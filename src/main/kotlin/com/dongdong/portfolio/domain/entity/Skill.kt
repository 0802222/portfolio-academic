package com.dongdong.portfolio.domain.entity

import com.dongdong.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null //자료형 뒤에 ?물음표가 붙으면 null이 허용된다는 뜻이다.

    var name: String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING) //자료형이 enum class일때 쓰는 어노테이션으로, 기본값은 ORDINAL이다.
    //ORDINAL은 enum이 선언된 순서대로 값을 DB에 넣어준다. 숫자로 컬럼에 값을 넣어줄 경우 직관적으로 어떤 데이터인지 파악하기 어렵다.
    //ORDINAL일 경우 SkillType.kt의 순서가 변경되었을 때 데이터의 정합성이 깨지게 된다.
    //STRING은 enum의 이름을 넣어준다. String으로 선택할 경우, 이 프로젝트에서는 LANGUAGE, FRAMEWORK, DATABASE, TOOL이 해당된다.

    var type: SkillType = SkillType.valueOf(type)
    // type 변수는 SkillType enum 타입이며, 초기값으로 문자열 type을 SkillType.valueOf(type)을 통해 변환하여 저장한다.
    // valueOf(type)은 전달된 문자열과 정확히 일치하는 SkillType enum 값을 반환한다.
    // 예를 들어, "LANGUAGE"가 들어오면 SkillType.LANGUAGE를 반환한다.

    var isActive = isActive
}