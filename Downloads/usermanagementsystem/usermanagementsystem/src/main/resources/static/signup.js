function registerUser() {

    const user = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    fetch("http://localhost:8080/api/auth/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
    .then(response => response.text())
    .then(data => {

        document.getElementById("message").innerHTML = data;

        if(data === "Registration Successful"){
            setTimeout(() => {
                window.location.href = "login.html";
            }, 1500);
        }
    })
    .catch(error => {
        console.log(error);
    });
}
