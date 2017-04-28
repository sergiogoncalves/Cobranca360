/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var titulo = document.querySelector("h1");
titulo.textContent = "Consultório Médico";

console.log("Vai passar 02");
titulo.addEventListener("click", function () {
    console.log("Houve um click");
});

var botaoAdicionar = document.querySelector("#adicionar-paciente");

console.log(botaoAdicionar);
botaoAdicionar.addEventListener("click", function (event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");
    
    var pacienteTr = document.createElement("tr");
    
    var nomeTd = document.createElement("td");
    var pesoTd = document.createElement("td");
    var alturaTd = document.createElement("td");
    var gorduraTd = document.createElement("td");
    var imcTd = document.createElement("td");
    
    var nome = form.nome.value;
    var peso = form.peso.value;
    var altura = form.altura.value;
    var gordura = form.gordura.value;
    
    console.log(form.altura.value);
    
    nomeTd.textContent = nome;
    pesoTd.textContent = peso;
    alturaTd.textContent = altura; 
    gorduraTd.textContent = gordura;
    
    pacienteTr.appendChild(nomeTd);
    pacienteTr.appendChild(pesoTd);
    pacienteTr.appendChild(alturaTd);
    pacienteTr.appendChild(gorduraTd);
    
   var tabela = document.querySelector("#tabela-pacientes");
   
   tabela.appendChild(pacienteTr);
});

//var paciente = document.querySelector(".paciente"); //Query selector só traz um registro]





console.log("Vai passar 01");
var pacientes = document.querySelectorAll(".paciente");



for (var i = 0; i <= pacientes.length; i++) {
    var paciente = pacientes[i];

    var tdPeso = paciente.querySelector(".info-peso");
    var tdAltura = paciente.querySelector(".info-altura");
    var tdImc = paciente.querySelector(".info-imc");

    var peso = tdPeso.textContent;
    var altura = tdAltura.textContent;

    if (peso < 0 || peso > 1000) {
        console.log("Peso inválido");

        tdImc.textContent = "Peso inválido";
        paciente.classList.add("paciente-invalido");
    } else {
        var imc = peso / (altura * altura);
        tdImc.textContent = imc.toFixed(2);
    }

}








