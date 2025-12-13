let activeCard = null;

const postList = document.querySelector("#postList");

postList.addEventListener("click", (e) => {
  const btn = e.target.closest(".edit-btn");
  if (!btn) return;

  const card = btn.closest(".card-body");

  if (card === activeCard) {
    card.querySelector(".edit-form").submit();
    activeCard = null;
    card.classList.remove("editing");
    resetButton(btn);
    return;
  }

  if (activeCard) {
    activeCard.classList.remove("editing");
    resetButton(activeCard.querySelector(".edit-btn"));
  }

  enterEditMode(card);
  activeCard = card;
});

function enterEditMode(card) {
  const title = card.querySelector(".card-title");
  const body  = card.querySelector(".card-text");

  card.querySelector(".edit-title").value = title.textContent;
  card.querySelector(".edit-body").value  = body.textContent;

  card.classList.add("editing");

  const btn = card.querySelector(".edit-btn");
  btn.innerHTML = "<i class='bi bi-check-lg'></i>";
  btn.classList.replace("btn-primary", "btn-success");
}

function resetButton(btn) {
  btn.innerHTML = "<i class='bi bi-pencil-fill'></i>";
  btn.classList.replace("btn-success", "btn-primary");
}
