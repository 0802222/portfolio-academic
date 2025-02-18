package com.dongdong.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null //자료형 뒤에 ?물음표가 붙으면 null이 허용된다는 뜻이다.

    var cookies: String? = httpServletRequest.cookies?.map { "${it.name}: ${it.value}" }?.toString()
    //cookies뒤에 ? 물음표는 nullpointexception을 막아주는 기능을 함
    //map은 cookies(cookie라는 객체의 배열임) 안에 있는 것들을 하나씩 순차적으로 돌면서서 안에 들어갈 함수대로 변환을 해줌
    //it은 배열에 들어온 각각의 객체를 뜻함, cookies안에 name, value 필드를 가져옴, "$"는 포맷팅을 해주는것임
    //cookies가 null이면 map, toString 둘다 실행되지 않음

    var referer: String? = httpServletRequest.getHeader("referer")
    //getHeader에 referer를 지정해주면, referer를 가져옴 (요청이 어디에서 부터왔는지 알려줌)

    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI

    var userAgent: String? = httpServletRequest.getHeader("user-agent")
    //브라우저 정보를 알려줌(크롬인지, 사파리인지..등)
}