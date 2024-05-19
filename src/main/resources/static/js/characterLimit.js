const limitTextLength = () => {
  let maxLength = 140; // 文字数の上限
  let enteredCharacters = document.getElementById('entered-characters');
  let remainingCharacters = document.getElementById('remaining-characters');

  if (enteredCharacters.value.length > maxLength) {
    enteredCharacters.value = enteredCharacters.value.substr(0, maxLength);
    remainingCharacters.classList.add('max');
  } else {
    remainingCharacters.classList.remove('max');
  }

  remainingCharacters.textContent = maxLength - enteredCharacters.value.length;
};