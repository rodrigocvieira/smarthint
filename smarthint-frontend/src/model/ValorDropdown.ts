export default class ValorDropdown {

    #label : string
    #valor : string

    constructor( label : string, valor: string) {
        this.#label = label
        this.#valor = valor
    }

    get label() {
        return this.#label
    }

    get valor() {
        return this.#valor
    }
}