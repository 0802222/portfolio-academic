package com.dongdong.academic.domain.repository

import com.dongdong.academic.domain.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun findByStudentNumber(studentNumber: String): Student?  // 학번으로 학생 찾기
}