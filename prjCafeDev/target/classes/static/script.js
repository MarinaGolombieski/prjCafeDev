document.addEventListener("DOMContentLoaded",()=>{
	const cadastroForm = document.getElementById("cadastroForm");
	
	const pesquisaForm = document.getElementById("pesquisaForm");
	
	cadastroForm.addEventListener("submit",cadastrarPedido);
	
	pesquisaForm.addEventListener("submit",function(e){
		e.preventDefault();
		pesquisarPedido();
	});
});

function cadastrarPedido(event) {
	event.preventDefault();
	
 

	//formatação
	const name = document.getElementById("name").value;
	const email = document.getElementById("email").value;
	const description = document.getElementById("description").value;
	const price = document.getElementById("price").value;
	const category = document.getElementById("category").value;
	const date = document.getElementById("date").value;
	
	
	
	
	const pedido = {
		name:name,
		email:email,
		description:description,
		price:price,
		category:category,
		date:date,
		
	}
	
	const formData = new FormData();
	
	formData.append(
		"pedido",
		new Blob([JSON.stringify(pedido)],{type:"application/json"})
	);
	
	
	//envio das informações
	fetch("http://localhost:8080/pedidos",{
		method:"POST",
		body:formData
	})
	.then(data=>{
		alert("Pedido cadastrado com Sucesso");
	})
	.catch(error=>console.error(error))
}





function pesquisarPedido(){

const searchId = document.getElementById("searchId").value;

if(searchId === ""){
alert("Digite um ID");
return;
}

fetch(`http://localhost:8080/pedidos/${searchId}`)
.then(response => {

if(response.status === 404){
throw new Error("Pedido não encontrado");
}

return response.json();

})
.then(data => {

document.getElementById("name").value = data.name;
document.getElementById("email").value = data.email;
document.getElementById("description").value = data.description;
document.getElementById("price").value = data.price;
document.getElementById("category").value = data.category;
document.getElementById("date").value = data.date;


	

const resultadoPesquisa = document.getElementById("resultadoPesquisa");

})
.catch(error => {

console.error(error);

const resultadoPesquisa = document.getElementById("resultadoPesquisa");

resultadoPesquisa.innerHTML = "Pedido não encontrado. Inserir ID válido";

});

}


function excluirProduto() {
   const searchId = document.getElementById("searchId").value;
   if (searchId === "") {
       alert("Digite um ID para exluir");
       return;
   }
   fetch(`http://localhost:8080/produtos/${searchId}`,{
       method:"DELETE"
   })
   .then(response =>{
       if(!response.ok){
           throw new Error("Erro ao exluir");
       }
       alert("Produto Excluido com sucesso");
       document.getElementById("pesquisaForm").reset();
       document.getElementById("resultadoPesquisa").innerHTML="";
   }).catch(error => {
       console.error(error);
       alert("Erro ao excluir o Produto");
   });    
}