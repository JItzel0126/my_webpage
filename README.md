# 📚 Papaya Novel (my_webpage)

프로젝트 **#Page**의 클론 프로젝트.  
사용자는 웹소설 시리즈(작품)와 에피소드를 열람하고, 자유게시판에서 소통하며,
댓글을 Ajax 기반으로 등록/삭제/정렬할 수 있다.  
로그인/회원가입, 장바구니 기능을 통해 실제 서비스와 유사한 경험을 제공한다.  

## 🚀 Tech Stack

![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-59666C?logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2%20Database-003545?logo=h2&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-7952B3?logo=bootstrap&logoColor=white)
![TailwindCSS](https://img.shields.io/badge/TailwindCSS-3-06B6D4?logo=tailwindcss&logoColor=white)

---

| 영역 | 기술 |
|------|----------------|
| Backend | Spring Boot, JPA, Hibernate |
| Frontend | Thymeleaf, Tailwind CSS, Bootstrap |
| DB | H2 Database |
| Build | Gradle |

---

## 🚀 주요 기능

### 1. 소설 시리즈 & 에피소드
- [x] 시리즈 / 에피소드 CRUD
- [x] 시리즈 상세 → 에피소드 목록 (최신순/1화부터 정렬 가능)
- [x] 에피소드 목록 → 에피소드 상세 (에피소드 내용확인, 에피소드 목록)
- [x] 작품 소개, 표지 이미지 출력

### 2. 게시판 (Freeboard)
- [x] 자유게시판 CRUD
- [x] 게시글 상세, 수정, 삭제
- [x] 게시글 댓글 (대댓글 지원)

### 3. 댓글 (Ajax 기반)
- [x] 소설 댓글, 게시판 댓글 모두 **fetch()** 기반 Ajax 통신
- [x] 댓글 등록/삭제 실시간 반영
- [x] 정렬(최신순 / 오래된순)

### 4. 회원 관리
- [ ] 회원가입, 로그인 (User Entity)
- [x] DTO/Entity 변환은 MapStruct 사용

### 5. 장바구니 (Cart - 예정)
- [ ] 소설 에피소드 유료 구매용 장바구니 기능 (기본 뼈대)

---

## 🔮 향후 계획
- [ ] Spring Security 적용 → 로그인/회원가입 기능 강화 (세션/인증 처리)
- [ ] 댓글 / 게시판 권한 관리

---

## 🛠 기술 스택

- **Backend**: Spring Boot 3.x, Spring Data JPA, Hibernate  
- **Database**: H2 (개발용) 
- **Frontend**: Thymeleaf, Tailwind CSS, Bootstrap  
- **Ajax 통신**: fetch API  
- **Mapping**: MapStruct  
- **Build**: Gradle
- **Etc**: Lombok, Validation, Error Handling (messages.properties)

---

## 📂 프로젝트 구조
```
src/main/java/com/mywebpage/mywebpage
├─ comment
│ ├─ boardcomment (게시판 댓글)
│ └─ novelcomment (소설 댓글)
├─ common (공통 유틸/예외/MapStruct)
├─ config (JPA 설정)
├─ freeboard (자유게시판)
├─ novel
│ ├─ episode (에피소드 CRUD)
│ └─ series (시리즈 CRUD)
└─ user (회원 관리)
```

## 템플릿/정적 리소스:
```
src/main/resources
├─ static (css, js, images)
└─ templates
├─ common (layout, header, footer)
├─ freeboard (게시판 관련 뷰)
└─ novel (시리즈/에피소드 뷰)
```
---

## ⚙️ 실행 방법

```bash
# 프로젝트 클론
git clone https://github.com/JItzel0126/my_webpage.git
cd my_webpage

# 실행 (Gradle)
./gradlew bootRun
```

- 기본 접속 URL: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console

## 📸 화면 예시

- (캡처 이미지 추가 예정)

- 시리즈 상세 페이지 (에피소드 + 댓글 Ajax)
- 게시판 CRUD
- 로그인/회원가입



