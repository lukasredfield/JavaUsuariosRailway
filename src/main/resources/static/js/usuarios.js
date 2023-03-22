// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
    actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    let email = document.getElementById('txtEmail');
    if (email != null) {
        email.outerHTML = localStorage.email;
    }
}

async function cargarUsuarios() {
    const headers = getHeaders();
    if (!headers.Authorization) {
        alert("Debe iniciar sesión para acceder a esta página.");
        window.location.href = 'login.html';
        return;
    }

    const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: headers
    });

    if (request.status === 401) {
        alert("El token de sesión ha expirado. Debe iniciar sesión nuevamente.");
        window.location.href = 'login.html';
        return;
    }

    const usuarios = await request.json();

    let listadoHtml = '';
    for (let usuario of usuarios) {
        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;
        let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
                    + usuario.email+'</td><td>'+telefonoTexto
                    + '</td><td>' + botonEliminar + '</td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

function getHeaders() {
    const token = localStorage.token;
    if (!token) {
        return {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        };
    }

    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': token
    };
}

async function eliminarUsuario(id) {
    if (!confirm('¿Desea eliminar este usuario?')) {
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload();
}
