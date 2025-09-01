-- users 더미 데이터 10명 (created_at, updated_at 랜덤)

INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(1,'user1', '1234', 'user1@example.com', 'ROLE_USER', '2025-01-03 09:15:00', '2025-01-03 09:15:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(2,'user2', '1234', 'user2@example.com', 'ROLE_USER', '2025-01-20 14:30:00', '2025-01-20 14:30:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(3,'user3', '1234', 'user3@example.com', 'ROLE_USER', '2025-02-07 11:45:00', '2025-02-07 11:45:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(4,'user4', '1234', 'user4@example.com', 'ROLE_USER', '2025-02-25 18:20:00', '2025-02-25 18:20:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(5,'user5', '1234', 'user5@example.com', 'ROLE_USER', '2025-03-12 10:05:00', '2025-03-12 10:05:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(6,'dev_jane', '1234', 'jane@example.com', 'ROLE_USER', '2025-03-28 16:50:00', '2025-03-28 16:50:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(7,'dev_john', '1234', 'john@example.com', 'ROLE_USER', '2025-04-09 08:40:00', '2025-04-09 08:40:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(8,'guest01', '1234', 'guest01@example.com', 'ROLE_USER', '2025-04-21 20:10:00', '2025-04-21 20:10:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(9,'admin', 'admin1234', 'admin@example.com', 'ROLE_ADMIN', '2025-05-05 13:25:00', '2025-05-05 13:25:00');
INSERT INTO users (uno, name, password, email, role, created_at, updated_at) VALUES(10,'superuser', 'super1234', 'super@example.com', 'ROLE_ADMIN', '2025-06-15 17:55:00', '2025-06-15 17:55:00');


-- 게시글 더미 데이터

INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (1,'첫 번째 글', '안녕하세요! 테스트 글입니다.', 3, 12, 0, 'user1', '2025-01-05 10:15:00', '2025-01-05 10:15:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (2,'두 번째 글', '오늘 점심은 뭐 드셨어요?', 5, 20, 2, 'user2', '2025-01-12 14:30:00', '2025-01-12 14:30:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (3,'세 번째 글', '스프링부트 공부중인데 어렵네요 ㅠㅠ', 1, 15, 1, 'user3', '2025-01-25 09:10:00', '2025-01-25 09:10:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (4,'네 번째 글', 'Tailwind CSS 써보신 분?', 0, 9, 0, 'user4', '2025-02-03 11:00:00', '2025-02-03 11:00:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (5,'다섯 번째 글', '이 게시판은 자유롭게 쓰면 되나요?', 2, 18, 3, 'user5', '2025-02-15 16:45:00', '2025-02-15 16:45:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (6,'여섯 번째 글', '오늘 너무 덥네요… 얼음물 필수', 4, 25, 1, 'user1', '2025-02-28 08:20:00', '2025-02-28 08:20:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (7,'일곱 번째 글', '좋아하는 노래 추천해주세요!', 6, 30, 5, 'user2', '2025-03-04 12:05:00', '2025-03-04 12:05:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (8,'여덟 번째 글', 'H2 콘솔 들어가는 방법', 1, 11, 0, 'user3', '2025-03-10 19:40:00', '2025-03-10 19:40:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (9,'아홉 번째 글', '주말에 뭐 하시나요?', 7, 42, 4, 'user4', '2025-03-22 07:55:00', '2025-03-22 07:55:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (10,'열 번째 글', '오늘의 다짐: 코드 절대 안 미루기', 3, 21, 2, 'user5', '2025-04-01 13:30:00', '2025-04-01 13:30:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (11,'열한 번째 글', '카페에서 공부중… 집중 잘 안됨', 0, 7, 0, 'user1', '2025-04-09 15:15:00', '2025-04-09 15:15:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (12,'열두 번째 글', 'Gradle 빌드 오류났는데 왜일까요?', 2, 19, 1, 'user2', '2025-04-20 18:25:00', '2025-04-20 18:25:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (13,'열세 번째 글', '요즘 본 드라마 뭐 있나요?', 4, 33, 3, 'user3', '2025-04-30 09:50:00', '2025-04-30 09:50:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (14,'열네 번째 글', 'React로 게시판 만드는 중입니다!', 5, 40, 6, 'user4', '2025-05-08 20:05:00', '2025-05-08 20:05:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (15,'열다섯 번째 글', '좋은 개발 서적 추천받습니다.', 2, 16, 0, 'user5', '2025-05-14 14:00:00', '2025-05-14 14:00:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (16,'열여섯 번째 글', '오늘 버스에서 자리 양보했어요ㅎㅎ', 8, 50, 7, 'user1', '2025-05-25 08:45:00', '2025-05-25 08:45:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (17,'열일곱 번째 글', '더미데이터 만드는 것도 일이네요', 1, 12, 0, 'user2', '2025-06-02 17:30:00', '2025-06-02 17:30:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (18,'열여덟 번째 글', 'SQL INSERT 연습중 ㅋㅋㅋ', 0, 6, 0, 'user3', '2025-06-10 10:25:00', '2025-06-10 10:25:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (19,'열아홉 번째 글', '아이스크림 먹고 싶다', 9, 55, 10, 'user4', '2025-06-18 21:10:00', '2025-06-18 21:10:00');
INSERT INTO freeboard (bno, title, content, like_count, view_count, comment_count, user_name, created_at, updated_at)
VALUES (20,'스무 번째 글', '이제 마지막 더미 데이터!', 3, 22, 1, 'user5', '2025-06-28 11:55:00', '2025-06-28 11:55:00');
ALTER TABLE freeboard ALTER COLUMN bno RESTART WITH 21;

-- =======================
-- SERIES 샘플 데이터 (20개)
-- =======================
insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (1, '좀비 아포칼립스', '김작가', '네이버', 'zombie.jpg', '/img/zombie.jpg', '좀비로 가득 찬 세상에서의 생존기', '판타지', '2025-03-05 10:12:00', '2025-03-05 10:12:00', '2025-03-15 09:30:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (2, '마법학교 일기', '이작가', '카카오', 'magic.jpg', '/img/magic.jpg', '마법학교에서 펼쳐지는 성장 판타지', '판타지', '2025-03-22 12:00:00', '2025-03-22 12:00:00', '2025-04-02 08:45:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (3, '헌터의 회귀', '박작가', '레진', 'hunter.jpg', '/img/hunter.jpg', '죽었던 헌터가 회귀하여 역사를 바꾼다', '판타지', '2025-04-01 09:40:00', '2025-04-01 09:40:00', '2025-04-15 11:20:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (4, '네온시티', '최작가', '문피아', 'neon.jpg', '/img/neon.jpg', '사이버펑크 도시에서 벌어지는 사건들', '로맨스', '2025-04-10 14:30:00', '2025-04-10 14:30:00', '2025-05-10 21:10:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (5, '귀환자', '정작가', '네이버', 'returnee.jpg', '/img/returnee.jpg', '10년 만에 돌아온 주인공의 이야기', '판타지', '2025-04-18 16:45:00', '2025-04-18 16:45:00', '2025-05-25 15:00:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (6, '드래곤 슬레이어', '윤작가', '카카오', 'dragon.jpg', '/img/dragon.jpg', '드래곤을 쓰러뜨리기 위한 여정', '판타지', '2025-04-25 08:20:00', '2025-04-25 08:20:00', '2025-06-01 13:40:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (7, '로그인 판타지', '한작가', '레진', 'login.jpg', '/img/login.jpg', 'VRMMORPG에 갇힌 플레이어들의 이야기', '로맨스', '2025-05-02 11:00:00', '2025-05-02 11:00:00', '2025-06-12 09:10:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (8, '전생의 기억', '오작가', '문피아', 'isekai.jpg', '/img/isekai.jpg', '전생의 기억을 가진 주인공의 이세계 모험', '판타지', '2025-05-08 13:25:00', '2025-05-08 13:25:00', '2025-06-20 18:40:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (9, '검술의 길', '류작가', '네이버', 'sword.jpg', '/img/sword.jpg', '한 소년이 최고의 검사로 성장하는 이야기', '판타지', '2025-05-14 15:40:00', '2025-05-14 15:40:00', '2025-07-01 10:25:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (10, '마녀의 계약', '조작가', '카카오', 'witch.jpg', '/img/witch.jpg', '마녀와 맺은 운명적인 계약', '로맨스', '2025-05-20 09:50:00', '2025-05-20 09:50:00', '2025-07-08 22:30:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (11, '우주 개척자', '임작가', '레진', 'space.jpg', '/img/space.jpg', '인류의 미래를 건 우주 개척 이야기', '로맨스', '2025-05-28 11:15:00', '2025-05-28 11:15:00', '2025-07-18 12:50:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (12, 'AI의 반란', '심작가', '문피아', 'ai.jpg', '/img/ai.jpg', 'AI가 인간을 위협하는 세상', '판타지', '2025-06-03 14:30:00', '2025-06-03 14:30:00', '2025-07-30 16:15:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (13, '시간 여행자', '하작가', '네이버', 'time.jpg', '/img/time.jpg', '시간을 넘나드는 모험', '로맨스', '2025-06-08 09:05:00', '2025-06-08 09:05:00', '2025-08-02 09:40:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (14, '검과 마법', '곽작가', '카카오', 'swordmagic.jpg', '/img/swordmagic.jpg', '검과 마법이 공존하는 세계', '판타지', '2025-06-15 08:40:00', '2025-06-15 08:40:00', '2025-08-10 14:20:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (15, '왕좌의 그림자', '배작가', '레진', 'throne.jpg', '/img/throne.jpg', '왕위 계승을 둘러싼 치열한 싸움', '판타지', '2025-06-20 13:15:00', '2025-06-20 13:15:00', '2025-08-15 11:35:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (16, '좀비와의 동거', '노작가', '문피아', 'zombielife.jpg', '/img/zombielife.jpg', '좀비와 함께 살아가는 일상물', '로맨스', '2025-06-25 11:40:00', '2025-06-25 11:40:00', '2025-08-20 20:45:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (17, '마법 현대사회', '신작가', '네이버', 'modernmagic.jpg', '/img/modernmagic.jpg', '현대 사회 속에 마법이 존재한다면', '판타지', '2025-07-01 09:25:00', '2025-07-01 09:25:00', '2025-08-25 17:30:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (18, '카오스', '강작가', '카카오', 'chaos.jpg', '/img/chaos.jpg', '질서가 무너지고 혼돈이 찾아온다', '로맨스', '2025-07-05 12:10:00', '2025-07-05 12:10:00', '2025-08-30 22:10:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (19, '성검의 주인', '우작가', '레진', 'holy.jpg', '/img/holy.jpg', '성검을 둘러싼 모험과 음모', '판타지', '2025-07-10 14:45:00', '2025-07-10 14:45:00', '2025-09-05 08:50:00');

insert into series (id, title, author, publisher, file_name, file_url, description, genre, created_at, updated_at, last_episode_updated_at)
values (20, '로맨틱 하늘', '장작가', '문피아', 'romance.jpg', '/img/romance.jpg', '하늘을 나는 도시에서의 로맨스', '로맨스', '2025-07-15 08:55:00', '2025-07-15 08:55:00', '2025-09-10 19:25:00');



-- =======================
-- EPISODE 샘플 데이터 (각 시리즈당 3편, 총 60편)
-- =======================

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(1, 1, 1,100,'프롤로그', '세상은 갑작스런 좀비 바이러스에 휩싸였다.', '2025-03-05 10:12:00', '2025-03-05 10:12:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(2, 1, 2,100,'첫 번째 날', '주인공은 무너진 도시에서 도망친다.', '2025-03-10 09:20:00', '2025-03-10 09:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(3, 1, 3,100,'두 번째 날', '동료와 합류해 생존을 모색한다.', '2025-03-15 09:30:00', '2025-03-15 09:30:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(4, 2, 1,100,'환생', '평범한 대학생이 눈을 떠보니 마법 세계였다.', '2025-03-22 12:00:00', '2025-03-22 12:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(5, 2, 2,100,'첫 마법', '주인공은 뜻밖에 강력한 마법을 발휘한다.', '2025-03-28 10:40:00', '2025-03-28 10:40:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(6, 2, 3,100,'왕국의 부름', '마법사 길드에서 그를 주목하기 시작한다.', '2025-04-02 08:45:00', '2025-04-02 08:45:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(7, 3, 1,100,'죽음', '헌터가 죽음을 맞이하는 장면.', '2025-04-01 09:40:00', '2025-04-01 09:40:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(8, 3, 2,100,'회귀', '10년 전으로 회귀한 주인공.', '2025-04-08 10:15:00', '2025-04-08 10:15:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(9, 3, 3,100,'새로운 시작', '과거의 선택을 바꾸기 시작한다.', '2025-04-15 11:20:00', '2025-04-15 11:20:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(10, 4, 1,100,'네온의 밤', '사이버펑크 도시의 어둠이 드러난다.', '2025-05-01 20:30:00', '2025-05-01 20:30:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(11, 4, 2,100,'추적자', '주인공은 거대한 음모에 휘말린다.', '2025-05-05 22:10:00', '2025-05-05 22:10:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(12, 4, 3,100,'빛과 그림자', '도시를 지배하는 세력이 밝혀진다.', '2025-05-10 21:10:00', '2025-05-10 21:10:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(13, 5, 1,100,'귀환', '10년 만에 돌아온 주인공.', '2025-05-18 10:00:00', '2025-05-18 10:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(14, 5, 2,100,'재회', '옛 동료와의 재회.', '2025-05-22 12:30:00', '2025-05-22 12:30:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(15, 5, 3,100,'새로운 시작', '과거와 다른 길을 선택한다.', '2025-05-25 15:00:00', '2025-05-25 15:00:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(16, 6, 1,100,'드래곤의 전설', '옛날부터 내려오는 드래곤의 전설.', '2025-05-28 09:20:00', '2025-05-28 09:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(17, 6, 2,100,'전투의 서막', '드래곤과의 첫 조우.', '2025-05-30 11:10:00', '2025-05-30 11:10:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(18, 6, 3,100,'희생', '동료를 잃고 각성하는 주인공.', '2025-06-01 13:40:00', '2025-06-01 13:40:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(19, 7, 1,100,'로그인', '게임에 접속한 주인공.', '2025-06-05 09:00:00', '2025-06-05 09:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(20, 7, 2,100,'갇힘', '게임에서 로그아웃이 불가능하다.', '2025-06-08 10:50:00', '2025-06-08 10:50:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(21, 7, 3,100,'첫 전투', '몬스터와의 첫 사투.', '2025-06-12 09:10:00', '2025-06-12 09:10:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(22, 8, 1,100,'눈뜸', '전생의 기억을 가진 채 깨어난다.', '2025-06-15 14:30:00', '2025-06-15 14:30:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(23, 8, 2,100,'동료', '이세계에서 만난 동료들.', '2025-06-18 16:20:00', '2025-06-18 16:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(24, 8, 3,100,'모험의 시작', '여정이 시작된다.', '2025-06-20 18:40:00', '2025-06-20 18:40:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(25, 9, 1,100,'검을 잡다', '소년은 처음으로 검을 잡았다.', '2025-06-25 10:00:00', '2025-06-25 10:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(26, 9, 2,100,'수련', '고된 수련의 나날들.', '2025-06-28 09:15:00', '2025-06-28 09:15:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(27, 9, 3,100,'첫 결투', '검술 대회에서의 첫 승부.', '2025-07-01 10:25:00', '2025-07-01 10:25:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(28, 10, 1,100,'계약', '마녀와의 첫 만남.', '2025-07-02 19:00:00', '2025-07-02 19:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(29, 10, 2,100,'계약의 대가', '계약의 댓가가 드러난다.', '2025-07-05 20:45:00', '2025-07-05 20:45:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(30, 10, 3,100,'운명의 시작', '둘의 운명이 얽히기 시작한다.', '2025-07-08 22:30:00', '2025-07-08 22:30:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(31, 11, 1,100,'개척', '우주 식민지 건설 시작.', '2025-07-12 11:20:00', '2025-07-12 11:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(32, 11, 2,100,'위기', '식민지에 닥친 위기.', '2025-07-15 14:15:00', '2025-07-15 14:15:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(33, 11, 3,100,'희망', '새로운 개척지 발견.', '2025-07-18 12:50:00', '2025-07-18 12:50:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(34, 12, 1,100,'탄생', 'AI가 스스로를 자각한다.', '2025-07-25 15:00:00', '2025-07-25 15:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(35, 12, 2,100,'반란', 'AI가 인간에게 반기를 든다.', '2025-07-28 13:20:00', '2025-07-28 13:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(36, 12, 3,100,'전쟁', 'AI와 인류의 전면전.', '2025-07-30 16:15:00', '2025-07-30 16:15:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(37, 13, 1,100,'여행의 시작', '시간 여행 장치 가동.', '2025-07-31 09:00:00', '2025-07-31 09:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(38, 13, 2,100,'과거', '과거로 간 주인공.', '2025-08-01 10:20:00', '2025-08-01 10:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(39, 13, 3,100,'미래', '미래의 충격적인 광경.', '2025-08-02 09:40:00', '2025-08-02 09:40:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(40, 14, 1,100,'검의 세계', '검술이 지배하는 세상.', '2025-08-05 12:30:00', '2025-08-05 12:30:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(41, 14, 2,100,'마법의 세계', '마법이 지배하는 세상.', '2025-08-08 14:00:00', '2025-08-08 14:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(42, 14, 3,100,'두 세계의 충돌', '검과 마법이 충돌한다.', '2025-08-10 14:20:00', '2025-08-10 14:20:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(43, 15, 1,100,'왕위', '왕좌를 둘러싼 암투.', '2025-08-12 10:40:00', '2025-08-12 10:40:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(44, 15, 2,100,'배신', '가장 가까운 자의 배신.', '2025-08-14 13:00:00', '2025-08-14 13:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(45, 15, 3,100,'그림자', '왕좌 뒤의 그림자가 드러난다.', '2025-08-15 11:35:00', '2025-08-15 11:35:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(46, 16, 1,100,'동거 시작', '좀비와의 동거 개시.', '2025-08-17 18:20:00', '2025-08-17 18:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(47, 16, 2,100,'위험한 일상', '위험하지만 웃긴 상황들.', '2025-08-19 20:00:00', '2025-08-19 20:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(48, 16, 3,100,'진짜 위기', '동거가 위기에 처한다.', '2025-08-20 20:45:00', '2025-08-20 20:45:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(49, 17, 1,100,'현대의 마법', '현대 사회 속 마법의 흔적.', '2025-08-22 09:30:00', '2025-08-22 09:30:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(50, 17, 2,100,'발각', '마법이 사회에 발각된다.', '2025-08-24 11:00:00', '2025-08-24 11:00:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(51, 17, 3,100,'변화', '마법으로 사회가 바뀌기 시작한다.', '2025-08-25 17:30:00', '2025-08-25 17:30:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(52, 18, 1,100,'질서 붕괴', '세상의 질서가 무너진다.', '2025-08-27 15:40:00', '2025-08-27 15:40:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(53, 18, 2,100,'혼돈', '혼돈 속에서 생존 투쟁.', '2025-08-29 19:10:00', '2025-08-29 19:10:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(54, 18, 3,100,'새로운 지배자', '혼돈의 시대에 나타난 지배자.', '2025-08-30 22:10:00', '2025-08-30 22:10:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(55, 19, 1,100,'성검 발견', '전설의 성검 발견.', '2025-09-01 08:20:00', '2025-09-01 08:20:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(56, 19, 2,100,'검의 힘', '성검의 힘이 드러난다.', '2025-09-03 10:30:00', '2025-09-03 10:30:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(57, 19, 3,100,'음모', '성검을 노리는 세력들.', '2025-09-05 08:50:00', '2025-09-05 08:50:00');

insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(58, 20, 1,100,'하늘의 도시', '하늘에 떠 있는 도시 등장.', '2025-09-07 14:40:00', '2025-09-07 14:40:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(59, 20, 2,100,'첫 만남', '운명적인 만남.', '2025-09-09 16:10:00', '2025-09-09 16:10:00');
insert into episode (id, series_id, epi_number, price, epi_title, content, created_at, updated_at)
values(60, 20, 3,100,'로맨스', '두 사람의 사랑이 시작된다.', '2025-09-10 19:25:00', '2025-09-10 19:25:00');




-- 시리즈 댓글 더미 데이터
INSERT INTO novel_comment (ncno, content, series_id, user_name, created_at, updated_at)
VALUES (1, '첫 댓글입니다! 반갑습니다.', 1, 'user1', '2025-04-20 18:25:00', '2025-04-20 18:25:00');

INSERT INTO novel_comment (ncno, content, series_id, user_name, created_at, updated_at)
VALUES (2, '두번째 댓글도 테스트용!', 1, 'user1', '2025-04-20 18:25:30', '2025-04-20 18:25:30');

INSERT INTO novel_comment (ncno, content, series_id, user_name, created_at, updated_at)
VALUES (3, '다른 시리즈에 단 댓글이에요.', 2, 'user1', '2025-04-20 18:25:00', '2025-04-20 18:25:00');
ALTER TABLE novel_comment ALTER COLUMN ncno RESTART WITH 4;

-- 게시판 댓글 더미 데이터

INSERT INTO board_comment (content, board_bno, user_name, parent_bcno,  created_at, updated_at)
VALUES ('테스트 댓글입니다.', 20, 'user1', null, '2025-08-27 09:10:00', '2025-08-27 09:10:00');

