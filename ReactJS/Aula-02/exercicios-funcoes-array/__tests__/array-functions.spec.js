import pokemons from '../src/pokedex.json'
import * as arrayFunctions from '../src/index'

describe('exercicio01', () => {
  //
  // Deve retornar o nome de todos os pokémons cujas defesas sejam maiores do que um limite informado
  //

  it('Recebendo valor intermediário, deve retornar alguns', () => {
    const expected = ['geodude', 'onix', 'cubone', 'mewtwo', 'mew']
    const defenseLimit = 80

    const result = arrayFunctions.exercicio01(pokemons, defenseLimit)

    expect(result).toEqual(expected)
  })

  it('Recebendo valor absurdo, não deve retornar ninguém', () => {
    const expected = []
    const defenseLimit = 9999

    const result = arrayFunctions.exercicio01(pokemons, defenseLimit)

    expect(result).toEqual(expected)
  })
})

describe('exercicio02', () => {
  //
  // Recebe a lista de pokémons, um id e um novo type.
  // Deve retornar uma lista com os pokémons que tenham o id informado.
  // O objeto de retorno deve ter as mesmas infos do pokémon original, porém sem stats e moves.
  // E a lista de types do objeto de retorno deve conter todos os types originais do pokémon e mais o novo recebido.
  //

  it('Recebendo id 25, deve retornar pikachu com dois types', () => {
    const expected = [
      {
        id: 25,
        height: 4,
        weight: 60,
        name: 'pikachu',
        types: ['electric', 'crescer'],
      },
    ]
    const id = 25
    const newType = 'crescer'

    const result = arrayFunctions.exercicio02(pokemons, id, newType)

    expect(result).toEqual(expected)
  })
})

describe('exercicio03', () => {
  //
  // Deve trazer um objeto simples, de chave-valor, no formato: { 'pikachu': 12345, 'onix': 33423, ... }.
  // Os nomes dos pokémons devem ser as chaves desse objeto e os valores devem ser a soma de todos stats deles.
  // Só devem ser considerados para esse objeto pokémons que possam aprender pelo menos 6 moves depois do nascimento.
  //

  it('Recebendo a lista completa, deve retornar 7 pokémons', () => {
    const expected = {
      bulbasaur: 188,
      butterfree: 225,
      charmander: 199,
      geodude: 240,
      ponyta: 280,
      squirtle: 200,
      tentacool: 185,
    }

    const result = arrayFunctions.exercicio03(pokemons)

    expect(result).toEqual(expected)
  })
})

describe('exercicio04', () => {
  //
  // Deve retornar uma lista com todos os moves iniciais dos pokémons.
  // Devemos considerar apenas pokémons que sejam, pelo menos, de um dos tipos informados.
  // A lista não deve conter moves repetidos e deve estar ordenada alfabeticamente.
  //

  it('Recebendo lista vazia de tipos, deve retornar uma lista vazia', () => {
    const expected = []
    const pokemonTypes = []

    const result = arrayFunctions.exercicio04(pokemons, pokemonTypes)

    expect(result).toEqual(expected)
  })

  it('Recebendo apenas fire, deve retornar uma lista com 4 nomes', () => {
    const expected = ['ember', 'growl', 'scratch', 'tail-whip']
    const pokemonTypes = ['fire']

    const result = arrayFunctions.exercicio04(pokemons, pokemonTypes)

    expect(result).toEqual(expected)
  })

  it('Recebendo [flying, water, normal], deve retornar uma lista com 13 nomes', () => {
    const expected = [
      'acid',
      'amnesia',
      'bite',
      'confusion',
      'dragon-rage',
      'gust',
      'headbutt',
      'hydro-pump',
      'leech-life',
      'leer',
      'rest',
      'sand-attack',
      'tackle',
      'tail-whip',
    ]
    const pokemonTypes = ['flying', 'water', 'normal']

    const result = arrayFunctions.exercicio04(pokemons, pokemonTypes)

    expect(result).toEqual(expected)
  })
})

describe('exercicio05', () => {
  //
  // Deve retornar uma lista de objetos no seguinte padrão:
  //    [{
  //      id: 25
  //      name: 'pikachu',
  //      valorSecreto: 123,
  //    },
  //    {...}]
  //
  // O valor secreto é a soma dos dígitos do weight dos pokémons.
  // Devem ser considerados para esta lista apenas pokémons verdadeiros com height abaixo de um limite informado.
  //

  it('Com limite 6, deve retornar 6 pokémons', () => {
    const expected = [
      { id: 7, name: 'squirtle', valorSecreto: 9 },
      { id: 25, name: 'pikachu', valorSecreto: 6 },
      { id: 50, name: 'diglett', valorSecreto: 8 },
      { id: 74, name: 'geodude', valorSecreto: 2 },
      { id: 104, name: 'cubone', valorSecreto: 11 },
      { id: 151, name: 'mew', valorSecreto: 4 },
    ]
    const heightLimit = 6

    const result = arrayFunctions.exercicio05(pokemons, heightLimit)

    expect(result).toEqual(expected)
  })

  it('Com limite 0, não deve retornar nada', () => {
    const expected = []
    const heightLimit = 0

    const result = arrayFunctions.exercicio05(pokemons, heightLimit)

    expect(result).toEqual(expected)
  })
})
