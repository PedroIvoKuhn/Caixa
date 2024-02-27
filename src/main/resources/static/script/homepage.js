window.onload = function(){
    const id = localStorage.getItem('userId');

    fetch(`http://localhost:8080/users/${id}`)
        .then(response => response.json())
          .then(data => {
            document.getElementById('username').textContent = `${data.name}`;
            document.getElementById('category').textContent = `${data.category}`;
            const list = document.getElementById('monthlyAcc');
            data.monthlyAccounts.forEach(acc => {
              const li = document.createElement("li");
                const a = document.createElement("a");
                a.textContent = acc.month
                a.href = `/pages/monthlyAccounts.html?acc=${acc.id}`;
                li.appendChild(a);
              list.appendChild(li);
            });
          })
        .catch((error) => {
          console.error('Error:', error);
        });
}