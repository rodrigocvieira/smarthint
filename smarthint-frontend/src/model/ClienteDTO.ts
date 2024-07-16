export default class ClienteDTO {

    #nomeRazaoSocial: string;
    #email: string;
    #telefone: string;
    #tipo: string;
    #cpfCnpj: string;
    #inscricaoEstadual: string | null;
    #genero: string;
    #dataNascimento: Date;
    #bloqueado: boolean;
    #senha: string;
    #senhaConfirmacao: string;

    constructor(
        nomeRazaoSocial: string,
        email: string,
        telefone: string,
        tipo: string,
        cpfCnpj: string,
        inscricaoEstadual: string | null,
        genero: string ,
        dataNascimento: Date,
        bloqueado: boolean,
        senha: string,
        senhaConfirmacao: string
    ) {
        this.#nomeRazaoSocial = nomeRazaoSocial
        this.#email = email
        this.#telefone = telefone
        this.#tipo = tipo
        this.#cpfCnpj = cpfCnpj
        this.#inscricaoEstadual = inscricaoEstadual
        this.#genero = genero
        this.#dataNascimento = dataNascimento
        this.#bloqueado = bloqueado
        this.#senha = senha
        this.#senhaConfirmacao = senhaConfirmacao
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

    get tipo() {
        return this.#tipo
    }

    get cpfCnpj() {
        return this.#cpfCnpj
    }

    get inscricaoEstadual() {
        return this.#inscricaoEstadual
    }

    get genero() {
        return this.#genero
    }

    get dataNascimento() {
        return this.#dataNascimento
    }

    get bloqueado() {
        return this.#bloqueado
    }

    get senha() {
        return this.#senha
    }

    get senhaConfirmacao() {
        return this.#senhaConfirmacao
    }

    toJSON() {
        return {
            nomeRazaoSocial : this.#nomeRazaoSocial,
            email : this.#email,
            telefone : this.#telefone,
            tipo : this.#tipo,
            cpfCnpj : this.#cpfCnpj,
            inscricaoEstadual : this.#inscricaoEstadual,
            genero : this.#genero,
            dataNascimento : this.#dataNascimento,
            bloqueado : this.#bloqueado,
            senha : this.#senha,
            senhaConfirmacao : this.#senhaConfirmacao,
        }
    }

}