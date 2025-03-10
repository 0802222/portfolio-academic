package com.dongdong.academic.domain.repository

import com.dongdong.academic.domain.entity.CourseRegistration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRegistrationRepository : JpaRepository<CourseRegistration, Long> {
    fun findByStudentId(studentId: Long): List<CourseRegistration>  // 특정 학생의 수강 신청 목록 조회
}