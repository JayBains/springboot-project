import './style.css'

// Selecting the HTML Elements
const form = document.getElementById("pokemonForm") as HTMLFormElement; 
const userNameInput = document.getElementById("userName") as HTMLInputElement;

// Throwing errors
if (!form || !userNameInput) {
  throw new Error("Some elements can't be found");
}

// Handle form submission
form.addEventListener("submit", async (event) => {
  event.preventDefault()

  const userName = userNameInput.value.trim();

  if (!userName) {
    alert("Please enter your name!");
    return;
  }

  // Send username to the backend and assigning it a random pokemon
  try {
    const response = await fetch("https://example.com", {
      method: "POST",
      headers: {"Content-Type": "application/json",
      }, body: JSON.stringify({userName})
      });

      if (!response.ok) {
        throw new Error("Failed to fetch Pokemon data");
      }

      // Extracting data from the response
      const { pokemonName, pokemonImage, pokemonType, date} = await response.json();
        
      // Update the pokemon card in the generated pokemon section
      // MAY NEED TO CHANGE BASED ON BACKEND TABLE
      pokemonName.textContent = pokemonName;
      pokemonImage.src = pokemonImage;
      pokemonType.textContent = `Type: ${pokemonType}`;
      
      // Calling addToTable function to populate the table below
      addToTable(userName, pokemonName, pokemonType, date);}
      catch (error) {
  }

});

// Function addToTable called above in the try catch block


// User submits name
// Name goes backend 
// Assigned random pokemon in backend table
// Front end fetches that entry
// Display pokemon card in section 1
// Updates section 2 table with username, pokemon name, date