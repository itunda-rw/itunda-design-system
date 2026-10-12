(()=> {
  const root = document.documentElement;
  const themeButton = document.getElementById("theme");
  const themeKey = "itunda-ids-theme";
  const allowedThemes = ["system", "dark", "light"];
  const savedTheme = localStorage.getItem(themeKey);
  root.dataset.theme = allowedThemes.includes(savedTheme) ? savedTheme : "system";
  const renderTheme = () => {
    const theme = root.dataset.theme || "system";
    themeButton.textContent = "Theme: " + theme;
    themeButton.setAttribute("aria-label", "Color theme is " + theme + ". Activate to change.");
    themeButton.setAttribute("aria-pressed", String(theme !== "system"));
  };
  themeButton.addEventListener("click", () => {
    const current = root.dataset.theme || "system";
    root.dataset.theme = allowedThemes[(allowedThemes.indexOf(current) + 1) % allowedThemes.length];
    localStorage.setItem(themeKey, root.dataset.theme);
    renderTheme();
  });
  renderTheme();

  const actionFeedback = document.getElementById("action-feedback");
  document.getElementById("continue-demo").addEventListener("click", () => {
    actionFeedback.textContent = "Ready to continue. In a product flow, confirm the details before committing.";
  });
  document.getElementById("cancel-demo").addEventListener("click", () => {
    actionFeedback.textContent = "Action cancelled. No changes were made.";
  });

  const email = document.getElementById("email-demo");
  const emailFeedback = document.getElementById("email-feedback");
  document.getElementById("validate-email").addEventListener("click", () => {
    if (!email.value.trim()) {
      emailFeedback.textContent = "Enter an email address to continue.";
      email.setAttribute("aria-invalid", "true");
      email.focus();
      return;
    }
    if (!email.validity.valid) {
      emailFeedback.textContent = "Check the email format and try again.";
      email.setAttribute("aria-invalid", "true");
      email.focus();
      return;
    }
    email.removeAttribute("aria-invalid");
    emailFeedback.textContent = "The email format looks valid.";
  });
  email.addEventListener("input", () => {
    email.removeAttribute("aria-invalid");
    emailFeedback.textContent = "";
  });

  document.querySelectorAll(".nav-item").forEach((item) => {
    item.addEventListener("click", () => {
      document.querySelectorAll(".nav-item").forEach((other) => {
        const active = other === item;
        other.classList.toggle("is-active", active);
        other.setAttribute("aria-pressed", String(active));
      });
      document.getElementById("nav-feedback").textContent = item.querySelector("b").textContent + " selected.";
    });
  });

  document.querySelectorAll(".choice-list .choice").forEach((item) => {
    item.addEventListener("click", () => {
      document.querySelectorAll(".choice-list .choice").forEach((other) => {
        const selected = other === item;
        other.classList.toggle("is-selected", selected);
        other.setAttribute("aria-pressed", String(selected));
        other.querySelector(".choice-check").textContent = selected ? "✓" : "";
      });
      document.getElementById("choice-feedback").textContent = item.querySelector("span").textContent + " selected.";
    });
  });

  const undoButton = document.getElementById("undo-demo");
  let isSaved = true;
  undoButton.addEventListener("click", () => {
    isSaved = !isSaved;
    document.getElementById("snackbar-message").textContent = isSaved ? "Demo item saved." : "Demo item restored.";
    undoButton.textContent = isSaved ? "Undo" : "Redo";
    document.getElementById("undo-feedback").textContent = isSaved ? "Saved state restored." : "Undo applied to the demo state.";
  });

  const sheetButton = document.getElementById("sheet-toggle");
  const extra = document.getElementById("sheet-extra");
  sheetButton.addEventListener("click", () => {
    const expanded = sheetButton.getAttribute("aria-expanded") !== "true";
    sheetButton.setAttribute("aria-expanded", String(expanded));
    extra.hidden = !expanded;
    sheetButton.innerHTML = expanded ? 'Hide options <span aria-hidden="true">↑</span>' : 'View options <span aria-hidden="true">↓</span>';
  });

  document.querySelectorAll("[data-copy]").forEach((button) => {
    button.addEventListener("click", async () => {
      const value = button.dataset.copy;
      try {
        await navigator.clipboard.writeText(value);
        button.textContent = "Copied";
      } catch {
        button.textContent = value;
      }
      window.setTimeout(() => { button.textContent = "Copy"; }, 1400);
    });
  });
})();