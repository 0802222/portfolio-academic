package com.dongdong.academic.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "departments")
class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,  // 학과 ID (자동 생성)

    @Column(nullable = false, unique = true)
    val name: String,  // 학과명 (예: 컴퓨터공학과, 경영학과)

    @OneToMany(mappedBy = "department", cascade = [CascadeType.ALL], orphanRemoval = true)
    val students: MutableList<Student> = mutableListOf(),  // 해당 학과의 학생들
)