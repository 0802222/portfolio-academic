package com.dongdong.academic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing  //  JPA Auditing 활성화(비활성화 시 @CreatedDate, @LastModifiedDate 비동작)
class AcademicManagementApplication

fun main(args: Array<String>) {
	runApplication<AcademicManagementApplication>(*args)
}

