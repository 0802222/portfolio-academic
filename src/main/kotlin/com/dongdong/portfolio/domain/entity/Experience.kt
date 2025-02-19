package com.dongdong.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null //자료형 뒤에 ?물음표가 붙으면 null이 허용된다는 뜻이다.

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive = isActive

    @OneToMany(
        targetEntity = ExperienceDetail::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    ) //Experience 엔티티가 영속성컨텍스트에 관련해서
    // 발생하는 모든 변화를 자식 엔티티인 ExperienceDetail에도 적용해줌
    //One이 Exprience이고, Many가 ExperienceDetail로, '1:다' 의 관계를 나타냄
    @JoinColumn(name = "experience_id") //맵핑의 기준인 컬럼을 알려줌
    var details: MutableList<ExperienceDetail> = mutableListOf()
    //mutableListOf()로 빈 리스트를 만들어줌
    //mutable은 변할 수 있다는 의미로, 그래서 데이터를 넣고 빼는게 가능함


    //종료년월 메소드 만들기 (한번에 서비스에 가져올 수 있도록 엔티티안에 메소드를 생성함)
    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}" //2023.11 형식으로 문자열이 리턴됨
    }


    //생성자에 있는것들을 다 받음
    fun update(
        title: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean
    ) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDtails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details) //파라미터를 받은 details를 추가해줌
        }
    }
}