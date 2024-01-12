// JavaScript
document.getElementById('meuFormulario').addEventListener('submit', function(e) {
    e.preventDefault(); // impede o envio do formulário

    var nomeUsuario = document.getElementById('nomeUsuario').value;
    var senhaUsuario = document.getElementById('senhaUsuario').value;

    console.log('Nome de usuário: ' + nomeUsuario);
    console.log('Senha: ' + senhaUsuario);
});
