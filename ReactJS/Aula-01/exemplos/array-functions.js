//Base
const objetoBase1 = {
  nome: "Nome Teste 1",
  idade: 17,
  cidade: "Osório",
  estado: "RS",
  pais: "Brasil",
};

const objetoBase2 = {
  nome: "Nome Teste 2",
  idade: 16,
  cidade: "São Paulo",
  estado: "SP",
  pais: "Brasil",
};

const objetoBase3 = {
  nome: "Nome Teste 3",
  idade: 14,
  cidade: "Tramandaí",
  estado: "RS",
  pais: "Brasil",
};

const arrayBase = [objetoBase1, objetoBase2, objetoBase3];
console.log("Array Base: ", arrayBase);

//MAP - Mapeia objeto A para Objeto B
const arrayObjetosMapeados = arrayBase.map((elemento) => {
  return {
    nomeAluno: elemento.nome,
    idadeAluno: elemento.idade,
    localidade: `${elemento.cidade}, ${elemento.estado}/${elemento.pais}`,
  };
});

console.log("Array Mapeado: ", arrayObjetosMapeados);

//FILTER - Filtra o Array deixando apenas os elementos que atendem a condição
const arrayObjetosFiltrados = arrayBase.filter((elemento) => {
  return elemento.estado === "RS";
});

console.log("Array Filtrado: ", arrayObjetosFiltrados);

//SOME - Retorna true se um elemento do array atende a condição
const temMaioresDezesseis = arrayBase.some((elemento) => {
  return elemento.idade > 16;
});

console.log(temMaioresDezesseis);

//EVERY - Retorna true caso todos os elementos passem na condição
const todosSaoMaioresDezesseis = arrayBase.every((elemento) => {
  return elemento.idade > 16;
});

console.log(todosSaoMaioresDezesseis);

//REDUCE - Reduz um array a uma unidade pré-determinada
const somaIdadesAlunos = arrayBase.reduce((acumulador, elemento) => {
  return acumulador + elemento.idade;
}, 0);

const concatenacaoNomesAlunos = arrayBase.reduce(
  (acumulador, elemento, index, array) => {
    if (index !== array.length - 1) {
      return `${acumulador}${elemento.nome}, `;
    }

    return `${acumulador}${elemento.nome}.`;
  },
  ""
);

console.log(somaIdadesAlunos);
console.log(concatenacaoNomesAlunos);
