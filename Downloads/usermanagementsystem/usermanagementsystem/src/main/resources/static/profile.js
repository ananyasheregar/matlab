window.onload = function() {

    const email =
        localStorage.getItem("email");

    if(email == null){

        alert("Please Login First");

        window.location.href =
            "login.html";

        return;
    }

    fetch(
      "http://localhost:8080/api/user/profile/"
      + email
    )
    .then(response => response.json())
    .then(user => {

        document.getElementById(
            "profileCard"
        ).innerHTML =

            "<h3>User Details</h3>" +
            "<p><b>Name:</b> "
            + user.name + "</p>" +

            "<p><b>Email:</b> "
            + user.email + "</p>";
    })
    .catch(error => {
        console.log(error);
    });
};

function logout() {

    localStorage.removeItem("email");

    window.location.href =
        "login.html";
}
