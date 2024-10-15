const BASE_URL = 'https://jsonplaceholder.typicode.com';

fetch(`${BASE_URL}/comments?postId=10`, {
    method: 'GET'
})
.then(response => response.json())
.then(data => {
    console.log("\n\nGET todos os comentários do post 10");
    console.log(data);
})

fetch(`${BASE_URL}/posts/10/comments`, {
    method: 'GET'
})
.then(response => response.json())
.then(data => {
    console.log("\n\nGET todos os comentários do post 10");
    console.log(data);
})

const body = JSON.stringify({name: "Novo comentario", email: "luisfelipesdn12@gmail.com", body: "Meu novo comentario!"});
fetch(`${BASE_URL}/posts/10/comments`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: body
})
.then(response => response.json())
.then(data => {
    console.log("\n\nPOST novo comentario");
    console.log(data);
})

const putBody = JSON.stringify({title: "Meu novo título"});
fetch(`${BASE_URL}/posts/15`, {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: putBody
})
.then(response => response.json())
.then(data => {
    console.log("\n\nPUT novo título");
    console.log(data);
})

fetch(`${BASE_URL}/comments/71`, {
    method: 'DELETE'
})
.then(response => response.json())
.then(data => {
    console.log("\n\nDELETE comentario");
    console.log(data);
})

fetch(`${BASE_URL}/posts/13/comments`, {
    method: 'GET'
})
.then(response => response.json())
.then(data => {
    console.log("\n\nGET comentarios do post 13");
    console.log(data);
    data.forEach(comment => {
        fetch(`${BASE_URL}/comments/${comment.id}`, {
            method: 'DELETE'
        })
        .then(response => response.json())
        .then(data => {
            console.log("\n\nDELETE comentario " + comment.id);
            console.log(data);
        })
    })
})