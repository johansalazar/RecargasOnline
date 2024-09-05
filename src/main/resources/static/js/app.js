document.addEventListener('DOMContentLoaded', function () {
    fetchVendedores();
    document.getElementById('vendedorForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const nombre = document.getElementById('nombre').value;
        fetch('/api/vendedores', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre })
        })
            .then(response => response.json())
            .then(() => fetchVendedores())
            .catch(error => console.error('Error:', error));
    });
});

function fetchVendedores() {
    fetch('/api/vendedores')
        .then(response => response.json())
        .then(data => {
            const vendedorList = document.getElementById('vendedorList');
            vendedorList.innerHTML = '';
            data.forEach(vendedor => {
                const li = document.createElement('li');
                li.className = 'collection-item';
                li.innerHTML = `${vendedor.nombre} 
                <button class="btn red waves-effect waves-light right" onclick="eliminarVendedor(${vendedor.id})">Eliminar</button>`;
                vendedorList.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}

function eliminarVendedor(id) {
    fetch(`/api/vendedores/${id}`, {
        method: 'DELETE'
    })
        .then(() => fetchVendedores())
        .catch(error => console.error('Error:', error));
}


function volverInicio() {
    window.location.href = '/';
}

