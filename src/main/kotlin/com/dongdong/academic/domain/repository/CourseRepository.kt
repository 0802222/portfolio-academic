package com.dongdong.academic.domain.repository

import com.dongdong.academic.domain.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course, Long> {
    fun findByCourseCode(courseCode: String): Course?  // 과목 코드로 과목 찾기
}