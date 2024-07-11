export default class ClienteListagemDTO {

    #id: string;
    #nome: string;
    #email: string;
    #telefone: string;
    #dataCadastro: string;
    #bloqueado: boolean;

    constructor(id: string, nome: string, email: string, telefone: string, dataCadastro: string, bloqueado: boolean) {
        this.#id = id
        this.#nome = nome
        this.#email = email
        this.#telefone = telefone
        this.#dataCadastro = dataCadastro
        this.#bloqueado = bloqueado
    }

    get id() {
        return this.#id
    }

    get nome() {
        return this.#nome
    }

    get email() {
        return this.#email
    }

    get telefone() {
        return this.#telefone
    }

    get dataCadastro() {
        return this.#dataCadastro
    }

    get bloqueado() {
        return this.#bloqueado
    }


}