package com.dongdong.portfolio.domain.repository

import com.dongdong.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>