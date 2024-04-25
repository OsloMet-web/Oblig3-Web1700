
const sciFiMovies = [
    "Blade Runner",
    "The Matrix",
    "Inception",
    "Star Wars: A New Hope",
    "The Terminator",
    "2001: A Space Odyssey",
    "Alien",
    "Jurassic Park",
    "The Fifth Element",
    "Interstellar",
];


// Insert the film names when page is loaded using an event listener
$(document).ready(function() {
    let filmNames = $("#filmNames");
    sciFiMovies.forEach(function(film) {
        filmNames.append($(`<option value="${film}">${film}</option>`));
    });
});






// Function to add bilets first checks the inputs
// if all are valid adds ticket object to the global billettListe array
// Then also adds the new bilett to the ordered list "alleBilletter" as a list element
function addBillett() {
    if (checkInputs()) {
        let billett = {
            filmName: $("#filmNames").val(),
            count: $("#antall").val(),
            forNavn: $("#fornavn").val(),
            etterNavn: $("#etternavn").val(),
            telNummer: $("#telefonnr").val(),
            email: $("#epost").val(),
        };
        $.post("/addTicket", billett, function (){
            alert("Bilet eklendi.");
        })

        //Add the new billett to the list
        $("#alleBilletter").append(`
        <li class="list-group-item d-flex justify-content-between align-items-center">
            ${billett.filmName} - ${billett.count} tickets - ${billett.forNavn} ${billett.etterNavn}
        </li>
    `);
        //Reset the form fields after adding the film
        resetForm();
    }
}



//If any of the inputs fail this function will return false.
function checkInputs() {
    return (
        checkFilmSelectionInput() &
        checkMailInput() &
        checkPhoneInput() &
        checkNameInput() &
        checkSurNameInput()
    );
}

function validateInput(selector, regex, errorMessageSelector, errorMessage) {
    const input = $(selector);
    const value = input.val();
    const isValid = regex.test(value);
    input.toggleClass('is-invalid', !isValid);
    input.toggleClass('is-valid', isValid);
    if (!isValid) {
        $(errorMessageSelector).text(errorMessage).show();
    } else {
        $(errorMessageSelector).hide();
    }
    return isValid;
}

// Refactored specific validation functions
function checkMailInput() {
    return validateInput("#epost", /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/, "#epostErrMsg", "Invalid email format");
}

function checkPhoneInput() {
    return validateInput("#telefonnr", /^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$/, "#telErrMsg", "Invalid phone number");
}

function checkNameInput() {
    return validateInput("#fornavn", /^[a-zA-ZæøåÆØÅ\s]+$/, "#fornavnErrMsg", "Invalid first name");
}

function checkSurNameInput() {
    return validateInput("#etternavn", /^[a-zA-ZæøåÆØÅ\s]+$/, "#etternavnErrMsg", "Invalid surname");
}

// Checks the film selection element input
function checkFilmSelectionInput() {
    let isValid = true;
    // Get the selected value from the dropdown
    let film = $("#filmNames").val();

    if (film.length < 1) {
        $("#filmNames").addClass("is-invalid")
        $("#filmNames").removeClass("is-valid")
        isValid = false;
    } else {
        $("#filmNames").removeClass("is-invalid")
        $("#filmNames").addClass("is-valid")
    }
    return isValid;
}



// Reset the form
function resetForm() {
    // Reset the form
    $('#billettForm')[0].reset();

    // Hide all warning messages
    $('.error-message').css('visibility', 'hidden');
}

// Clear all bilets from the array and reset the list
function slettAlleBilletter() {
$.get("/deleteAllTickets",function (){
    alert("Biletler silindi")
});

$("#alleBilletter")[0].innerHTML = "";
}
