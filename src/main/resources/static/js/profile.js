const postTitle = document.querySelector(".card-title")
const postText = document.querySelector(".card-text")

const editBtn = document.querySelector("#edit-btn")

const editForm = document.querySelector("#edit-form")
const editTitle = document.querySelector("#edit-title")
const editBody = document.querySelector("#edit-body")

editBtn.addEventListener("click", () => {
  const editMode = editForm.classList.contains("d-none") 

  if (editMode) {
    editTitle.value = postTitle.textContent
    editBody.textContent = postText.textContent

    postTitle.classList.add("d-none")
    postText.classList.add("d-none")
    editForm.classList.remove("d-none")

    editBtn.innerHTML = "<i class='bi bi-check-lg'></i>"
    editBtn.classList.remove("btn-primary")
    editBtn.classList.add("btn-success")
  } else {
    editForm.submit()
  }
})