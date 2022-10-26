/** @format */

let cards = [];
let sum = 0;
let hasBlackjack = false;
let isAlive = false;
let message = "";
let messageEl = document.getElementById("message-el");
let sumEl = document.querySelector("#sum-el");
let cardsEl = document.querySelector("#cards-el");

let player = {
  name: "Gajanan",
  chips: 100,
};

let playerEl = document.querySelector("#player-el");

playerEl.textContent = player.name + ": $" + player.chips;

function getRandomCard() {
  let randomCard = Math.floor(Math.random() * 13) + 1;
  if (randomCard === 1) {
    return 11;
  } else if (randomCard > 10) {
    return 10;
  } else {
    return randomCard;
  }
}

function startGame() {
  isAlive = true;
  let firstCard = getRandomCard();
  let secondCard = getRandomCard();
  cards = [firstCard, secondCard];
  sum = firstCard + secondCard;
  renderGame();
}

function renderGame() {
  cardsEl.textContent = "Cards: ";
  for (let i = 0; i < cards.length; i++) {
    cardsEl.textContent += cards[i] + " ";
  }

  sumEl.textContent = "Sum: " + sum;

  if (sum <= 20) {
    message = "Do you want to draw another card.";
  } else if (sum === 21) {
    message = "You have got a balckjack.";
    hasBlackjack = true;
  } else {
    message = "You lost the game";
    isAlive = false;
  }
  messageEl.textContent = message;
}

function newCard() {
  if (hasBlackjack === false && isAlive === true) {
    let card = getRandomCard();
    sum += card;
    cards.push(card);
    renderGame();
  }
}
