import './style.css'

const form = document.getElementById("pokemonForm") as HTMLFormElement;


fetchAllPokemonData();




// Handle form submission
form.addEventListener("submit", async (event) => {
  event.preventDefault

  const userName = (document.getElementById("userName") as HTMLInputElement).value;

  // Fetch a random pokemon from the backend
  const pokemon = fetchRandomPokemon(userName);

  // Logic to fill pokemon form && clear at the end
  if (pokemon) {
    pokemonName.textContent = pokemon.name;
    pokemonType.textContent = `Type: ${pokemon.type}`;
    
  }


});

// Fetch all the pokemon data


// Fetch a random pokemon from the backend


// logic to update table row
// Add another empty row