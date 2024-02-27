window.onload = function(){
    const params = new URLSearchParams(window.location.search);
    const accId = params.get('acc');
    const userId = localStorage.getItem('userId');

    fetch(`http://localhost:8080/accounts/${accId}u${userId}`)
        .then(response => response.json())
          .then(data => {
            document.getElementById('month').textContent = `${data.month}`;
            const listIncomming = document.getElementById('incomming');
            data.incomming.forEach(acc => {
              const li = document.createElement("li");
                const div = document.createElement("div");
                  const p0 = document.createElement("p");
                  const p1 = document.createElement("p");
                  const p2 = document.createElement("p");
                  p0.innerHTML = `${acc.name}`;
                  
                  const dataGMT = new Date(acc.date);
                  const dia = dataGMT.getUTCDate();
                  const mes = dataGMT.getUTCMonth() + 1;
                  const ano = dataGMT.getUTCFullYear();
                  const dataFormatada = `${dia}/${mes}/${ano}`;
                  p1.innerHTML = dataFormatada;

                  p2.innerHTML = `R$ ${acc.price}`;
                  div.appendChild(p0);
                  div.appendChild(p1);
                  div.appendChild(p2);
                li.appendChild(div);
              listIncomming.appendChild(li);
            });
            const listExpenses = document.getElementById('expenses');
            data.expenses.forEach(acc => {
              const li = document.createElement("li");
                const div = document.createElement("div");
                  const p0 = document.createElement("p");
                  const p1 = document.createElement("p");
                  const p2 = document.createElement("p");
                  p0.innerHTML = `${acc.name}`;

                  const dataGMT = new Date(acc.date);
                  const dia = dataGMT.getUTCDate();
                  const mes = dataGMT.getUTCMonth() + 1;
                  const ano = dataGMT.getUTCFullYear();
                  const dataFormatada = `${dia}/${mes}/${ano}`;
                  p1.innerHTML = dataFormatada;

                  p2.innerHTML = `R$ ${acc.price}`;
                  div.appendChild(p0);
                  div.appendChild(p1);
                  div.appendChild(p2);
                li.appendChild(div);
              listExpenses.appendChild(li);
            });
            listIncomming.style.display = 'flex';
            listExpenses.style.display = 'flex';
          })
        .catch((error) => {
          console.error('Error:', error);
        });
}