import './style.css'

const form = document.getElementById("pokemonForm") as HTMLFormElement;

// fetchAllPokemonData();

// Handle form submission
form.addEventListener("submit", async (event) => {
  event.preventDefault()

  const userName = (document.getElementById("userName") as HTMLInputElement).value;

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

// Fetch a random pokemon from the backend
// const fetchRandomPokemon() = async () => {
//   const response = await fetch("https://example.com");
//   const data = await response.json();
// };


// Logic to update the table with specific entry
  // create user pokemon function
  // Add another empty row