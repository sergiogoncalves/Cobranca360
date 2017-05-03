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
        var imc = calculaImc(peso, altura);
        tdImc.textContent = imc;
    }

}

function calculaImc(peso, altura){
    var imc = peso / (altura * altura);
    
    return imc.toFixed(2);
}








