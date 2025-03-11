# 학사관리 시스템 (Student Management System)

## 테이블 구조

**1. `students` (학생 테이블)**
| 컬럼명           | 타입           | 제약조건           | 설명 |
|---------------|--------------|----------------|------|
| `id`          | BIGINT       | PK, AUTO_INCREMENT | 학생 ID |
| `student_number` | VARCHAR(20)  | UNIQUE, NOT NULL  | 학번 |
| `name`        | VARCHAR(50)  | NOT NULL       | 학생 이름 |
| `email`       | VARCHAR(100) | UNIQUE, NOT NULL  | 이메일 |
| `department_id` | INT       | FK (departments) | 학과 ID |
| `semester`    | INT          | NOT NULL       | 현재 학기 |
| `created_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP | 생성일 |
| `updated_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 수정일 |

---

**2. `departments` (학과 테이블)**
| 컬럼명           | 타입           | 제약조건           | 설명 |
|---------------|--------------|----------------|------|
| `id`          | INT       | PK, AUTO_INCREMENT | 학과 ID |
| `name`        | VARCHAR(100) | UNIQUE, NOT NULL | 학과명 |
| `created_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP | 생성일 |
| `updated_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 수정일 |

---

**3. `courses` (과목 테이블)**
| 컬럼명           | 타입           | 제약조건           | 설명 |
|---------------|--------------|----------------|------|
| `id`          | INT       | PK, AUTO_INCREMENT | 과목 ID |
| `course_code` | VARCHAR(20)  | UNIQUE, NOT NULL | 과목 코드 |
| `name`        | VARCHAR(100) | NOT NULL | 과목명 |
| `category`    | ENUM (`MAJOR_REQUIRED`, `MAJOR_ELECTIVE`, `GENERAL_REQUIRED`, `GENERAL_ELECTIVE`) | NOT NULL | 과목 유형 |
| `professor`   | VARCHAR(100) | NOT NULL | 담당 교수 |
| `credits`     | INT          | NOT NULL | 학점 |
| `department_id` | INT       | FK (departments) | 개설 학과 ID |
| `created_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP | 생성일 |
| `updated_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 수정일 |

---

**4. `course_registrations` (수강 신청 테이블)**
| 컬럼명           | 타입           | 제약조건           | 설명 |
|---------------|--------------|----------------|------|
| `id`          | INT       | PK, AUTO_INCREMENT | 수강 신청 ID |
| `student_id`  | INT       | FK (students) | 수강한 학생 ID |
| `course_id`   | INT       | FK (courses) | 신청한 과목 ID |
| `registration_date` | DATE | NOT NULL | 수강 신청일 |
| `created_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP | 생성일 |
| `updated_date_time` | TIMESTAMP  | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 수정일 |

---
