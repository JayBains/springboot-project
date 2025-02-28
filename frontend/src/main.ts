import './style.css';

// Selecting the HTML Elements
const form = document.getElementById("pokemonForm") as HTMLFormElement; 
const usernameInput = document.getElementById("userName") as HTMLInputElement;
const pokemonNameElement = document.getElementById("pokemonName") as HTMLHeadingElement;
const pokemonImageElement = document.getElementById("pokemonImage") as HTMLImageElement;
const pastPokemonTable = document.getElementById("pastPokemonTable") as HTMLTableElement;
const apiUrl = "http://localhost:8080/pokemon"; // Backend API

// Throwing errors if elements are missing
if (!form || !usernameInput || !pokemonNameElement || !pokemonImageElement || !pastPokemonTable) {
  throw new Error("Some elements can't be found");
}

// Handle form submission
form.addEventListener("submit", async (event) => {
  event.preventDefault();

  const username = usernameInput.value.trim();

  if (!username) {
    alert("Please enter your name!");
    return;
  }

  try {
    // Send request to backend to generate a Pokemon
    const response = await fetch(`${apiUrl}/generate?username=${username}`, { 
      method: "POST",
      headers: { "Content-Type": "application/json" } 
    });

    if (!response.ok) throw new Error("Failed to fetch Pokémon data");

    // Extract data from response
    const data = await response.json();
    const { name, spriteUrl } = data;

    // Update the Pokemon card
    pokemonNameElement.textContent = name;
    pokemonImageElement.src = spriteUrl;

    // Refresh the table with updated Pokemon data
    fetchPastPokemon();
  } catch (error) {
    console.error("Error fetching Pokémon: ", error);
    alert("Failed to generate Pokémon. Please try again.");
  }
});

// Fetch all stored Pokemon and update the table
async function fetchPastPokemon() {
  try {
    const response = await fetch(`${apiUrl}/all`);
    if (!response.ok) throw new Error("Failed to fetch Pokémon data");

    const data = await response.json();
    updateTable(data);
  } catch (error) {
    console.error("Error fetching past Pokémon: ", error);
  }
}

// Populate the table with users & Pokemon
function updateTable(pokemonList: { username: string; pokemon_name: string; pokemon_image_url: string }[]) {
  const tableBody = pastPokemonTable.getElementsByTagName("tbody")[0];
  tableBody.innerHTML = ""; // Clear previous data

  pokemonList.forEach((entry) => {
    const row = tableBody.insertRow();
    row.insertCell(0).textContent = entry.username;
    row.insertCell(1).textContent = entry.pokemon_name;
    
    // Create an image element for the Pokemon sprite
    const imgCell = row.insertCell(2);
    const img = document.createElement("img");
    img.src = entry.pokemon_image_url;
    img.width = 50;
    img.height = 50;
    imgCell.appendChild(img);
  });
}

// Fetch stored Pokemon when the page loads
fetchPastPokemon();
