window.onload = function(){
    document.getElementById("loginForm").addEventListener("submit", function(event){
        event.preventDefault()
      
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
              throw new Error(`Usuario ou senha incorretos. Status: ${response.status}`);
            } 
            return response.json();
          })
          .then(data => {
            localStorage.setItem('id', `${data.id}`);
            console.log("salvou");
            window.location.href = `http://localhost:8080/pages/homepage.html`;
          })
        .catch((error) => {
          alert(error);
          console.error('Error:', error);
        });
      });
}