//IGNORE
const equalsArray = (expected, response) => {
  return (
    expected.length === response.length &&
    expected.every((element) => response.includes(element))
  );
};

const equalsDivisionArray = (expected, response) => {
  return expected.some((array) => equalsArray(array, response));
};

//Possíveis resultados para [1, 2, 3, 4]
const resultadosArray1 = [
  [1, 2, 3, 4],
  [0.5, 1, 1.5, 2],
  [0.3333333333333333, 0.6666666666666666, 1, 1.3333333333333333],
  [0.25, 0.5, 0.75, 1],
];

//Possíveis resultados para [22, 54, 43]
const resultadosArray2 = [
  [1, 2.4545454545454546, 1.9545454545454546],
  [0.4074074074074074, 1, 0.7962962962962963],
  [0.5116279069767442, 1.255813953488372, 1],
];

//Calculadora - Arrays
const calculadora = {
  /* Soma: Deve somar todos os valores do array, e retornar o resultado */
  soma: (array) => {},

  /* Subtração: Deve Subtrair o primeiro valor presente no array do restante dos valores, e retornar o resultado */
  subtracao: (array) => {},

  /* Divisão: Deve dividir os valores do array por um valor aleatório do mesmo, e retornar o resultado */
  /* Caso ocorra divisão por 0 retorne 0 */
  /* OBS: Utilizar Math.random */
  divisao: (array) => {},

  /* Multiplicação: Deve  multiplicar os valores do array, e retornar o resultado */
  multiplicacao: (array) => {},
};

//Testes - Arrays
const testes = [
  calculadora.soma([1, 2, 3, 45]) === 51,
  calculadora.soma([22, 30, 18]) === 70,
  equalsArray([2, 8, 21, 43], calculadora.subtracao([2, 10, 23, 45])),
  equalsArray([5, 1, 33, 52, -5], calculadora.subtracao([5, 6, 38, 57, 0])),
  equalsDivisionArray(resultadosArray1, calculadora.divisao([1, 2, 3, 4])),
  equalsDivisionArray(resultadosArray2, calculadora.divisao([22, 54, 43])),
  calculadora.multiplicacao([1, 2, 3, 4, 5]) === 120,
  calculadora.multiplicacao([1, 1, 1, 1]) === 1,
];

if (testes.includes(false)) {
  console.log("Testes com Erros: ");
  testes.forEach((element, index) =>
    console.log(`resultado teste ${index}: ${element}.`)
  );
} else {
  console.log("Testes Completos!!! :)");
}
