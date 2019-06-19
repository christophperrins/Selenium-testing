function submitWord() {
        let word = document.getElementById("inputBox").value;
        sessionStorage.setItem("secretWord", word);
        document.location.href = "play.html";
        return false;
    }