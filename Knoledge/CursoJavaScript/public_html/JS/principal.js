/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var titulo = document.querySelector("h1");
titulo.textContent = "Cleciane";

var paciente = document.querySelector("#primeiro-paciente");

var tdPeso   = paciente.querySelector(".info-peso");
var tdAltura = paciente.querySelector(".info-altura");
var tdImc    = paciente.querySelector(".info-imc");

var peso   = tdPeso.textContent;
var altura = tdAltura.textContent;

var imc = peso /(altura * altura);

tdImc.textContent = imc;

console.log(paciente);
console.log(tdPeso);
console.log(peso);
console.log(altura);
console.log(imc);