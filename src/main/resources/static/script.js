document.addEventListener("DOMContentLoaded", function () {
  const searchBox = document.getElementById("studentSearchBox");
  const studentRows = document.querySelectorAll(".student");
  const courseRows = document.querySelectorAll(".student-course");

  searchBox.addEventListener("input", function () {
    const keyword = this.value.toLowerCase();

// 受講生情報
    studentRows.forEach(row => {
      const id = row.children[0]?.innerText.toLowerCase() || "";
      const name = row.children[1]?.innerText.toLowerCase() || "";
      const furigana = row.children[2]?.innerText.toLowerCase() || "";
      const nickName = row.children[3]?.innerText.toLowerCase() || "";
      const email = row.children[4]?.innerText.toLowerCase() || "";
      const address = row.children[5]?.innerText.toLowerCase() || "";
      const sex = row.children[6]?.innerText.toLowerCase() || "";
      const note = row.children[7]?.innerText.toLowerCase() || "";
      const age = row.children[8]?.innerText.toLowerCase() || "";

      const match = name.includes(keyword) || furigana.includes(keyword) || email.includes(keyword) || id ===keyword || nickName.includes(keyword) || address.includes(keyword) || sex.includes(keyword) || note.includes(keyword) || age === keyword ;
      row.style.display = match ? "" : "none";
    });

// 受講生コース情報
    courseRows.forEach(row => {
      const courseId = row.children[0]?.innerText.toLowerCase() || "";
      const studentId = row.children[1]?.innerText.toLowerCase() || "";
      const courseName = row.children[2]?.innerText.toLowerCase() || "";


      const match =  courseId === keyword || studentId === keyword ||courseName.includes(keyword);
      row.style.display = match ? "" : "none";
    });
  });
});
