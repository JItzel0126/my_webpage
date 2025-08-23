/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html",  // 타임리프 템플릿
    "./src/main/resources/static/**/*.js",       // JS 안에 클래스 쓸 경우
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}

