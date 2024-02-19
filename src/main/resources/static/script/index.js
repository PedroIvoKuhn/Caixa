window.onload = function(){
    document.getElementById("loginForm").addEventListener("submit", function(event){
        event.preventDefault()   // Prevent the form from submitting normally
      
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;

        fetch(`http://localhost:8080/users`, {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({email: email, password: password}),
        })
        .then(response => { 
            if (!response.ok) {
              throw new Error(`Usuario ou senha incorretos. Status: ${response.status}`)
            } 
            window.location.href = "http://localhost:8080/homepage";
          })
        .catch((error) => {
          alert(error);
          console.error('Error:', error);
        });
      });
}