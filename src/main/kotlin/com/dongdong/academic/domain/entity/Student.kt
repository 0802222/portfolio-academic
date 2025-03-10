package com.dongdong.academic.domain.entity

import jakarta.persistence.*

// Kotlin 01 : val (Immutable, 읽기전용, 수정 불가)

// Kotlin 02 : var (mutable, 수정 가능)

@Entity
@Table(name = "students") // 테이블 명 지정
class Student(
    @Id // 기본키(PK) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment 설정
    val id: Long? = null, // 기본값이 null임 (DB에서 자동생성됨)

    // Column 정의(어노테이션 생략 시 컬럼은 자동생성되지만, 제약조건 미적용)
    @Column(nullable = false, unique = true)
    val studentNumber: String,

    @Column(nullable = false) // NOT NULL 설정
    val name: String,

    @Column(unique = true, nullable = false) // 이메일 중복방지
    val email: String,


    @Column(nullable = false)
    val semester: Int, //현재 학기

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    val department: Department, //학과 (N : 1)

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], orphanRemoval = true)
    val courseRegistrations: MutableList<CourseRegistration> = mutableListOf() //수강과목 목록
) : BaseEntity() //BaseEntity 상속