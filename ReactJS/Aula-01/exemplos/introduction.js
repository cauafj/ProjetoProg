//Variaveis

// 1.0 - Normais
// 1.1 - Mutavel
var variavel = 2;
console.log("var: ", variavel);

variavel = 5;
console.log("var: ", variavel);

// 1.2 - Imutavel
const constante = 2;
console.log("const: ", constante);

//ERRO
// constante = 3;
// console.log("const: ", constante);

// 2.0 - Arrays
// 2.1 - Arrays Homogeneos
const arrayHomogeneoNumeros = [1, 2, 3, 4, 5];
const arrayHomogeneoPalavras = ["Um", "Dois", "Três", "Quatro", "Cinco"];

console.log("Números: ", arrayHomogeneoNumeros);
console.log("Palavras: ", arrayHomogeneoPalavras);

// 2.2 - Arrays Heterogeneos
const arrayHeterogeneo = [1, "Dois", 27, 52, variavel, constante, true];

// 3.0 - Lacos de Repetição
let contador = 0;

// 3.1 - FOR
for (contador = 0; i < 5; i++) {
  console.log(contador);
}

console.log("for: ", contador);

// 3.2.0 - WHILE -> break;
while (true) {
  if (contador == 10) {
    console.log("while -> break: ", contador);
    break;
  }

  contador++;
}

// 3.2.1 - WHILE -> condição
while (contador < 15) {
  contador++;
}

console.log("while -> condição: ", contador);

// 3.3 - DO WHILE
do {
  console.log(contador);
  contador++;
} while (contador < 20);

console.log("do while: ", contador);

// 4.0 - Objetos
const objetoPessoa = {
  nome: "Luan Barcella",
  idade: 19,
  casado: true,
};

// 5.0.0 - Funcoes
// 5.0.1 - Funcoes sem parametro
function minhaFuncaoSemParametros() {
  console.log("Função Sem Parâmetros...");
}

minhaFuncaoSemParametros();

// 5.0.2 - Funcoes com parametro
function minhaFuncaoComParametros(parametro1, parametro2, parametro3) {
  console.log("Parametro 1: ", parametro1);
  console.log("Parametro 2: ", parametro2);
  console.log("Parametro 3: ", parametro3);
}

minhaFuncaoComParametros(1, "dois", objetoPessoa);

// 5.1.0 - Arrow Function
// 5.1.1 - Arrow Function sem parametros
const minhaArrowFunctionSemParametros = () => {
  console.log("Arrow Function Sem Parametros...");
};

minhaArrowFunctionSemParametros();

// 5.1.2 - Arrow Function com parametros
const minhaArrowFunctionComParametros = (
  parametro1,
  parametro2,
  parametro3
) => {
  console.log("Arrow - Parametro 1: ", parametro1);
  console.log("Arrow - Parametro 2: ", parametro2);
  console.log("Arrow - Parametro 3: ", parametro3);
};

minhaArrowFunctionComParametros(objetoPessoa, "Cinco", 8);

// 5.2 - Retorno de funcoes
const minhaFuncaoComRetorno = (um, dois) => {
  return um + dois;
};

const retorno1 = minhaFuncaoComRetorno(1, 2);
console.log(retorno1);

const retorno2 = minhaFuncaoComRetorno("bom ", "dia");
console.log(retorno2);

// 6.0 - Callback
const callBack1 = () => {
  console.log("callback 1");
};

const callBack2 = () => {
  console.log("callback 2");
};

const callBack3 = () => {
  console.log("callback 3");
};

const minhaFuncaoComCallback = (callback) => {
  callback();
};

minhaFuncaoComCallback(callBack1);
minhaFuncaoComCallback(callBack2);
minhaFuncaoComCallback(callBack3);
