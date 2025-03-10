package com.dongdong.academic.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "course_registrations")
class CourseRegistration(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,  // 수강 신청 ID (자동 생성)

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    val student: Student,  // 수강 신청한 학생 (N:1 관계)

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    val course: Course,  // 신청한 과목 (N:1 관계)

    @Column(nullable = false)
    val registrationDate: LocalDate = LocalDate.now()  // 수강 신청 날짜 (기본값: 오늘)
)