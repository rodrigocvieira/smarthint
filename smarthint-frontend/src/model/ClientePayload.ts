import ClienteListagemDTO from "./ClienteListagemDTO";

export default class ClientePayload {

    #clientes : ClienteListagemDTO[]
    #proximaPagina : boolean

    constructor( clientes : ClienteListagemDTO[], proximaPagina: boolean) {
        this.#clientes = clientes
        this.#proximaPagina = proximaPagina
    }

    get clientes() {
        return this.#clientes
    }

    get proximaPagina() {
        return this.#proximaPagina
    }
}