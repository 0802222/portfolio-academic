package com.dongdong.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    abstract class BaseEntity {

        @CreatedDate //JPA 엔티티가 생성된 시간을 자동으로 셋팅해줌
        @Column(nullable = false, updatable = false)
        //nullable은 null 일 수 있냐, 없냐를 나타내줌, false면 값이 항상 있어야됨
        //updatable은 update를 할 수 있냐 없냐를 나타내줌, 필드에 셋팅된 값이 변경이되면 JPA에서 오류를 냄

        var createdDateTime: LocalDateTime = LocalDateTime.now()
        //현재 시간을 생성을 해서 필드에 넣어줌


        @LastModifiedDate //@CreatedDate랑 세트로 보면됨, 데이터 생성일시, 마지막 수정일시를 지정해주는 기능을 함
        @Column(nullable = false) //updateable = true은 기본값이기 때문에 코드에 별도의 파라미터로 지정하진 않음
        var updatedDateTime: LocalDateTime = LocalDateTime.now()

    }
}