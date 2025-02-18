package com.dongdong.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
//기본생성자 정의
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null //자료형 뒤에 ?물음표가 붙으면 null이 허용된다는 뜻이다.

    //필드 만들기
    var title: String = title //생성자에서 받은 값(title)을 초기값으로 받는다.

    var description: String = description

    var achievedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive = isActive


}