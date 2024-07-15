export default class ClienteListagemDTO {

    #id: string;
    #nomeRazaoSocial: string;
    #email: string;
    #telefone: string;
    #dataDeCadastro: string;
    #bloqueado: boolean;

    constructor(id: string, nome: string, email: string, telefone: string, dataCadastro: string, bloqueado: boolean) {
        this.#id = id
        this.#nomeRazaoSocial = nome
        this.#email = email
        this.#telefone = telefone
        this.#dataDeCadastro = dataCadastro
        this.#bloqueado = bloqueado
    }

    get id() {
        return this.#id
    }

    get nomeRazaoSocial() {
        return this.#nomeRazaoSocial
    }

    get email() {
        return this.#email
    }

    get telefone() {
        return this.#telefone
    }

    get dataDeCadastro() {
        return this.#dataDeCadastro
    }

    get bloqueado() {
        return this.#bloqueado
    }


}