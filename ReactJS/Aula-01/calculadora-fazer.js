//Calculadora
const calculadora = {
  /* Soma: Deve somar "parametro1" e "parametro2", e retornar o resultado */
  soma: (parametro1, parametro2) => {},

  /* Subtração: Deve Subtrair "parametro2" de "parametro1", e retornar o resultado */
  subtracao: (parametro1, parametro2) => {},

  /* Divisão: Deve dividir "parametro1" pelo "parametro2", e retornar o resultado */
  /* Caso ocorra divisão por 0 retorne 0 */
  divisao: (parametro1, parametro2) => {},

  /* Multiplicação: Deve  multiplicar o "parametro1" com o "parametro2", e retornar o resultado */
  multiplicacao: (parametro1, parametro2) => {},
};

//Testes Básicos
const testes = [
  calculadora.soma(1, 2) === 3,
  calculadora.soma(97, 18) === 115,
  calculadora.subtracao(0, 15) === -15,
  calculadora.subtracao(10, 3) === 7,
  calculadora.divisao(10, 2) === 5,
  calculadora.divisao(2000, 0) === 0,
  calculadora.multiplicacao(2, 20) === 40,
  calculadora.multiplicacao(3, 32) === 96,
];

if (testes.includes(false)) {
  console.log("Testes com Erros: ");
  testes.forEach((element, index) =>
    console.log(`resultado teste ${index}: ${element}.`)
  );
} else {
  console.log("Testes Básicos Completos!!! :)");
}
