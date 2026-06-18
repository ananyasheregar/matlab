function loginUser() {

    const user = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify(user)
    })
    .then(response => response.text())
    .then(data => {

        document.getElementById("message").innerHTML = data;

        if(data === "Login Successful"){

            localStorage.setItem(
                "email",
                user.email
            );

            setTimeout(() => {
                window.location.href =
                    "profile.html";
            }, 1000);
        }
    })
    .catch(error => {
        console.log(error);
    });
}
