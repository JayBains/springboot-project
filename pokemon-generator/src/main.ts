import './style.css'

// Selecting the HTML Elements
const form = document.getElementById("pokemonForm") as HTMLFormElement; 
const userNameInput = document.getElementById("userName") as HTMLInputElement;


// Handle form submission
form.addEventListener("submit", async (event) => {
  event.preventDefault()

  const userName = userNameInput.value.trim();

  if (!userName) {
    alert("Please enter your name!");
    return;
  }

  // Fetch a random pokemon from the backend
  const pokemon = fetchRandomPokemon(userName);

  // Logic to fill pokemon form && clear at the end
  if (pokemon) {
    pokemonName.textContent = pokemon.name;
    pokemonType.textContent = `Type: ${pokemon.type}`;
    pokemonImage.src = pokemon.image;
  }

  addToTable(userName, pokemon.name, pokemon.type, pokemon.image);

  // send pokemon and username to the db

});

// Fetch all the pokemon data
const fetchAllPokemonData = async () => {
  const response = await fetch("https://example.com");
  const data = await response.json();
};


// User submits name
// Name goes backend 
// Assigned random pokemon in backend table
// Front end fetches that entry
// Display pokemon card in section 1
// Updates section 2 table with username, pokemon name, date