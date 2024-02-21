window.onload = function(){
    const id = localStorage.getItem('id')

    fetch(`http://localhost:8080/users/${id}`)
        .then(response => response.json())
          .then(data => {
            document.getElementById('username').textContent = `${data.name}`;
            document.getElementById('category').textContent = `${data.category}`;
          })
        .catch((error) => {

          console.error('Error:', error);
        });
}