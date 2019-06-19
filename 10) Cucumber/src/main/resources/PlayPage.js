function addToProgress() {
    let text = "";
    let length = sessionStorage.getItem("secretWord").length;
    for (let i = 0; i < length; i++) {
        text += "_ ";
    }
    text = text.trim();
    document.getElementById("progress").innerText = text;
}
addToProgress();

let numOfErrors = 0;

function removeSpaces() {
    let text = document.getElementById("progress").innerHTML;
    let newText = "";
    for (let i = 0; i < text.length; i++) {
        let char = text.substring(i, i + 1);
        if (char !== " ") {
            newText += char;
        }
    }
    return newText;
}

function replaceText(text) {
    let guess = document.getElementById("guessBox").value;
    document.getElementById("guessBox").value = "";
    for (let i = 0; i < text.length; i++) {
        let char = text.substring(i, i + 1);
        if (char === "_") {
            let replacement = sessionStorage.getItem("secretWord").substring(i, i + 1);
            if (guess === replacement) {
                text = text.substring(0, i) + replacement + text.substring(i + 1);
            }
        }
    }
    return text;
}

function addSpaces(text) {
    let newText = "";
    for (let i = 0; i < text.length; i++) {
        newText += text.substring(i, i + 1) + " ";
    }
    newText = newText.trim()
    return newText;
}

function isWin(text) {

    for (let i = 0; i < text.length; i++) {
        if (text.substring(i, i + 1) === "_") {
            return false;
        }
    }
    return true;
}

function submitGuess() {
    let initial = document.getElementById("progress").innerHTML;
    let text = removeSpaces();
    text = replaceText(text);
    text = addSpaces(text);

    if (initial === text) {
        numOfErrors++;
        document.getElementById("message").innerHTML = "Wrong!";

        switch (numOfErrors) {
            case 1:
                document.getElementById("hangman").setAttribute("src", "image1.png");
                break;
            case 2:
                document.getElementById("hangman").setAttribute("src", "image2.png");
                break;
            case 3:
                document.getElementById("hangman").setAttribute("src", "image3.png");
                break;
            case 4:
                document.getElementById("hangman").setAttribute("src", "image4.png");
                break;
            case 5:
                document.getElementById("hangman").setAttribute("src", "image5.png");
                document.getElementById("guessBox").remove();
                document.getElementById("message").innerHTML = "Game Over!";

                break;
        }

    } else {
        document.getElementById("message").innerHTML = "";
    }

    document.getElementById("progress").innerHTML = text;

    if (isWin(text)) {
        document.getElementById("message").innerHTML = "Win!";
        document.getElementById("guessBox").remove();
    }


    return false;
}
