package com.dongdong.academic.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
// 이 클래스를 상속받는 엔티티 클래스가 여기안에 있는 필드들을 해당 엔티티에 있는 테이블의 컬럼과 맵핑할 수 있음
@EntityListeners(AuditingEntityListener::class)  // JPA Auditing 활성화
abstract class BaseEntity {

        @CreatedDate //JPA 엔티티가 생성된 시간을 자동으로 셋팅해줌
        @Column(nullable = false, updatable = false)
        //nullable은 null 일 수 있냐, 없냐를 나타내줌, false면 값이 항상 있어야됨
        //updatable은 update를 할 수 있냐 없냐를 나타내줌, 필드에 셋팅된 값이 변경이되면 JPA에서 오류를 냄

        lateinit var createdDateTime: LocalDateTime  // 생성일 (자동)

        @LastModifiedDate //@CreatedDate랑 세트로 보면됨, 데이터 생성일시, 마지막 수정일시를 지정해주는 기능을 함
        @Column(nullable = false) //updateable = true은 기본값이기 때문에 코드에 별도의 파라미터로 지정하진 않음
        lateinit var updatedDateTime: LocalDateTime  // 수정일 (자동)
}