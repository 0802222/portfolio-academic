package com.dongdong.academic.domain.entity

import com.dongdong.academic.domain.constant.CourseCategory
import jakarta.persistence.*

@Entity
@Table(name = "courses")
class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,  // 과목 ID (자동 생성)

    @Column(nullable = false, unique = true)
    val courseCode: String,  // 과목 코드 (EX: CS101)

    @Column(nullable = false)
    val name: String,  // 과목명 (예: 데이터베이스)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val category: CourseCategory, // 과목 유형(전필,전선..등)

    @Column(nullable = false)
    val professor: String,  // 담당 교수

    @Column(nullable = false)
    val credits: Int,  // 학점

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    val department: Department,  // 과목이 개설된 학과 (N:1 관계)

    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], orphanRemoval = true)
    val courseRegistrations: MutableList<CourseRegistration> = mutableListOf()  // 해당 과목을 수강한 학생들
)
