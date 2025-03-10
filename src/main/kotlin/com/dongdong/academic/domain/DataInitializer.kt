package com.dongdong.academic.domain

import com.dongdong.academic.domain.constant.CourseCategory
import com.dongdong.academic.domain.entity.*
import com.dongdong.academic.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component //빈 등록(의존성 주입 시 사용)
@Profile(value = ["default"])//프로필이 디폴트일때만 이 클래스를 생성해서 빈으로 등록하라는 뜻
class DataInitializer( //의존성 주입을 받기위해 생성자 코드 작성
    private val studentRepository: StudentRepository,
    private val courseRepository: CourseRepository,
    private val departmentRepository: DepartmentRepository,
    private val courseRegistrationRepository: CourseRegistrationRepository

) {

    //데이터를 만들어서 넣어줄 메소드 만들기
    @PostConstruct //메인메소드가 실행이되면 스프링을 구축할때, 스프링 DI가 컴포넌트 스캔을 해서 필요한것을 찾고,
    //인스턴스를 생성하고, 의존성주입하면서 @PostConstruct 어노테이션이 붙은 메소드들을 찾아서 한번더 실행해줌
    //메소드 실행시점에는 스프링 빈들이 생성, 등록되어 있기때문에 우리가 필요한 빈들을 찾아서 사용할 수 있기 때문에 데이터 초기화해줌
    fun initializeData() {

        println("스프링이 실행되었습니다. 학사관리 시스템 테스트 데이터를 초기화 합니다.")
        //실무에서는 println보다 log를 쓰는게 성능이 좋음

        // Department 학과 데이터 생성
        val csDepartment = Department(name = "컴퓨터공학과")
        val businessDepartment = Department(name = "경영학과")
        val departments = listOf(csDepartment, businessDepartment)
        departmentRepository.saveAll(departments)

        // Student 학생 데이터 생성
        val student1 = Student(
            studentNumber = "20230001",
            name = "김철수",
            email = "chulsoo@example.com",
            department = csDepartment,
            semester = 2
        )

        val student2 = Student(
            studentNumber = "20230002",
            name = "이영희",
            email = "younghee@example.com",
            department = businessDepartment,
            semester = 3
        )

        val students = listOf(student1, student2)
        studentRepository.saveAll(students)
        //saveAll은 영속성 컨텍스트에 들어가는 것, 현재 살아있는 트랜잭션이 종료가 될 때 디비로 전송됨

        // Course 과목 데이터 생성
        val course1 = Course(
            courseCode = "CS101",
            name = "자료구조",
            category = CourseCategory.GENERAL_ELECTIVE,
            professor = "홍길동",
            credits = 3,
            department = csDepartment
        )

        val course2 = Course(
            courseCode = "BUS201",
            name = "마케팅 전략",
            category = CourseCategory.MAJOR_REQUIRED,
            professor = "이순신",
            credits = 3,
            department = businessDepartment
        )

        val courses = listOf(course1, course2)
        courseRepository.saveAll(courses)

        // CourseRegistration 수강신청 데이터 생성
        val registration1 = CourseRegistration(
            student = student1,
            course = course1,
            registrationDate = LocalDate.of(2024, 3, 10)
        )

        val registration2 = CourseRegistration(
            student = student2,
            course = course2,
            registrationDate = LocalDate.of(2024, 3, 11)
        )

        val registrations = listOf(registration1, registration2)
        courseRegistrationRepository.saveAll(registrations)

        println("학사관리 시스템 더미 데이터 삽입 완료!")
    }
}
