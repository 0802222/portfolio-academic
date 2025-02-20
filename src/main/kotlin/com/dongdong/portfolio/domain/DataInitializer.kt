package com.dongdong.portfolio.domain

import com.dongdong.portfolio.domain.constant.SkillType
import com.dongdong.portfolio.domain.entity.*
import com.dongdong.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component //빈 등록(의존성 주입 시 사용)
@Profile(value = ["default"])//프로필이 디폴트일때만 이 클래스를 생성해서 빈으로 등록하라는 뜻
class DataInitializer( //의존성 주입을 받기위해 생성자 코드 작성
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {

    //데이터를 만들어서 넣어줄 메소드 만들기
    @PostConstruct //메인메소드가 실행이되면 스프링을 구축할때, 스프링 DI가 컴포넌트 스캔을 해서 필요한것을 찾고,
    // 인스턴스를 생성하고, 의존성주입하면서 @PostConstruct 어노테이션이 붙은 메소드들을 찾아서 한번더 실행해줌
    //메소드 실행시점에는 스프링 빈들이 생성, 등록되어 있기때문에 우리가 필요한 빈들을 찾아서 사용할 수 있기 때문에 데이터 초기화해줌
    fun initializeData() {

        println("스프링이 실행되었습니다. 테스트 데이터를 초기화 합니다.")
        //실무에서는 println보다 log를 쓰는게 성능이 좋음

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2022 Catcko 해커톤 최우수상",
                description = "고양이 쇼핑몰 검색 서비스의 아키텍쳐",
                host = "캣카오",
                achievedDate = LocalDate.of(2021, 1, 1),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2021, 1, 1),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)


        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결합니다.", isActive = true),
            Introduction(content = "비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다", isActive = true)
        )
        introductionRepository.saveAll(introductions)


        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/0802222", isActive = true),
            Link(name = "Linkedin", content = "https://www.linkedin.com", isActive = true),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "캣홀릭대학교(CatHolic Univ.)",
            description = "냥퓨터공학 전공",
            startYear = 2021,
            startMonth = 1,
            endYear = 2021,
            endMonth = 2,
            isActive = true
        )
        experience1.addDtails(
            mutableListOf(
                ExperienceDetail(content = "GPA 4.3/4.5", isActive = true),
                ExperienceDetail(content = "소프트웨어 연구 학회 활동", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "냥냥전자",
            description = "소셜서비스팀 백엔드 개발자",
            startYear = 2021,
            startMonth = 1,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience2.addDtails(
            mutableListOf(
                ExperienceDetail(content = "유기묘 위치 공유 서비스 개발", isActive = true),
                ExperienceDetail(content = "신입 교육 프로그램 우수상 수상", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))
        //saveAll은 영속성 컨텍스트에 들어가는 것, 현재 살아있는 트랜잭션이 종료가 될 때 디비로 전송됨

        val java = Skill(name = "java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "spring", type = SkillType.LANGUAGE.name, isActive = true)
        val django = Skill(name = "django", type = SkillType.LANGUAGE.name, isActive = true)
        val mysql = Skill(name = "mysql", type = SkillType.LANGUAGE.name, isActive = true)
        val redis = Skill(name = "redis", type = SkillType.LANGUAGE.name, isActive = true)
        val kafka = Skill(name = "kafka", type = SkillType.LANGUAGE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, redis, kafka))

        val project1 = Project(
            name = "유기묘 발견 정보 공유 서비스",
            description = "유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스",
            startYear = 2021,
            startMonth = 1,
            endYear = 2022,
            endMonth = 12,
            isActive = true
        )
        project1.addDtails(
            mutableListOf(
                ProjectDetail(content = "구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발", url = null, isActive = true),
                ProjectDetail(content = "redis 적용하여 인기 게시글의 조회 속도 1.5초 -> 0.5초로 개선", url = null, isActive = true),
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis)
            )
        )

        val project2 = Project(
            name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
            description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작업",
            startYear = 2021,
            startMonth = 1,
            endYear = null,
            endMonth = null,
            isActive = true
        )

        project2.addDtails(
            mutableListOf(
                ProjectDetail(content = "PIL(Pillow)활용하여 이미지 분석 기능 개발", url = null, isActive = true),
                ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소", url = null, isActive = true),
                ProjectDetail(content = "Github Repository", url = "https://github.com/0802222", isActive = true),
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = kafka)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))
    }
}