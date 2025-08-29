<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{common/layout}">

<!-- 페이지 전용 head 추가 -->
<th:block layout:fragment="pageHead">
    <title>시리즈 | Papaya Novel</title>
    <!-- 부트스트랩 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</th:block>


<div layout:fragment="content">
    <div class="mt-2 mx-auto w-full sm:w-11/12">
        <form th:action="" method="get">
            <h1 th:text="${series.title}">시리즈 제목</h1>
            <p th:text="${series.description}">시리즈 설명</p>
        </form>

        <!-- 댓글 영역 -->
        <h3>댓글</h3>

        <select id="sortSelect">
            <option value="desc">최신순</option>
            <option value="asc">오래된순</option>
        </select>

        <ul id="commentList"></ul>

        <input type="text" id="commentInput" placeholder="댓글 쓰기"/>
        <button id="commentBtn">등록</button>



    </div>
</div>

<!-- boardDetail.html -->
<th:block layout:fragment="extraScript">
    <!-- 부트스트랩 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

</th:block>


</html>