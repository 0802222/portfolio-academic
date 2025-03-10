package com.dongdong.academic.domain.repository

import com.dongdong.academic.domain.entity.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : JpaRepository<Department, Long> {
    fun findByName(name: String): Department?  // 학과명으로 학과 찾기
}