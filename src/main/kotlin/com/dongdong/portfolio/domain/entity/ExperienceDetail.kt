package com.dongdong.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(content: String, isActive: Boolean) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id")
    var id: Long? = null //자료형 뒤에 ?물음표가 붙으면 null이 허용된다는 뜻이다.

    var content: String = content

    var isActive: Boolean = isActive

    fun update(content: String, isActive: Boolean) {
        this.content = content
        this.isActive = isActive
        //Experience에서는 ExperienceDetail을 1:다 관계로 참조할 수 있었으나, 반대로는 참조할 수 없으므로
        //둘간의 관계는 1:다 단방향 연관관계라고 할 수 있다.
    }
}