import { useEffect, useState } from "react";
import Input from "../components/Input/Input";
import InputEmail from "../components/Input/InputEmail";
import InputTelefone from "../components/Input/InputTelefone";
import InputCPF from "../components/Input/InputCPF";
import InputInscricaoEstadual from "../components/Input/InputInscricaoEstadual";
import InputData from "../components/Input/InputData";
import Dropdown from "../components/Input/Dropdown";
import { convertGenero, FEMININO, MASCULINO, OUTROS } from "../model/GeneroDTO";
import { convertTipoPessoa, FISICA, JURIDICA } from "../model/TipoPessoaDTO";
import Checkbox from "../components/Input/Checkbox";
import Button from "../components/Button";
import InputSenha from "../components/Input/InputSenha";
import { Link, useNavigate, useParams } from "react-router-dom";
import { editar, inserir, obter } from "../services/api";
import ClienteDTO from "../model/ClienteDTO";
import { Toast } from "flowbite-react";
import { Alerta } from "../components/Icons";
import InputCNPJ from "../components/Input/InputCNPJ";

export default function Cadastro() {

    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [telefone, setTelefone] = useState("");
    const [tipoPessoa, setTipoPessoa] = useState(FISICA)
    const [cpfCnpj, setCpfCnpj] = useState("");
    const [inscricaoIsento, setInscricaoIsento] = useState(true);
    const [inscricaoEstadual, setInscricaoEstadual] = useState("");
    const [genero, setGenero] = useState(MASCULINO)
    const [dataNascimento, setDataNascimento] = useState(new Date());
    const [senha, setSenha] = useState("");
    const [senhaConfirmacao, setSenhaConfirmacao] = useState("");
    const [bloqueado, setBloqueado] = useState(false);

    const [error, setError] = useState("")

    const navegacao = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id)
            obter(id).then(data => {
                setNome(data.data.nomeRazaoSocial)
                setEmail(data.data.email)
                setTelefone(data.data.telefone)
                setTipoPessoa(convertTipoPessoa(data.data.tipo))
                setCpfCnpj(data.data.cpfCnpj)
                setInscricaoIsento(data.data.inscricaoEstadual ? false : true)
                setInscricaoEstadual(data.data.inscricaoEstadual)
                setGenero(convertGenero(data.data.genero))
                setDataNascimento(data.data.dataNascimento)
                setBloqueado(data.data.bloqueado)
                setSenha(data.data.senha)
            })

    }, [id])

    function submmit() {
        function removerMascara(valor: string) {
            return valor.replace(/[^a-zA-Z0-9]/g, '');
        }

        const dto = new ClienteDTO(
            nome,
            email,
            removerMascara(telefone),
            tipoPessoa.valor,
            removerMascara(cpfCnpj),
            inscricaoIsento ? null : removerMascara(inscricaoEstadual),
            genero.valor,
            dataNascimento,
            bloqueado,
            senha,
            senhaConfirmacao
        );

        function finalizarRequest(data: any) {
            if (data.error) {
                setError(data.mensagem)
                window.scrollTo(0, 0)
            } else {
                navegacao("/")
            }
        }

        if (id)
            editar(id, dto).then(data => {
                finalizarRequest(data)
            });
        else
            inserir(dto).then(data => {
                finalizarRequest(data)
            });
    }

    return (
        <div className="m-auto w-96 flex flex-col mb-11">
            {
                error && (
                    <Toast>
                        <div className="inline-flex h-8 w-8 shrink-0 items-center justify-center rounded-lg bg-red-500">
                            {Alerta}
                        </div>
                        <div className="ml-3 text-sm font-normal">{error}</div>
                    </Toast>
                )
            }


            <label className="text-bold-header text-primary text-center">Cadastro</label>

            <Input
                titulo="Nome do cliente/Razão Social:*"
                onChange={setNome}
                placeHolder="Informe o nome ou a razão social"
                tamanhoMaximo={150}
                value={nome}
            />

            <InputEmail
                titulo="E-mail:*"
                onChange={setEmail}
                placeHolder="Informe um e-mail"
                tamanhoMaximo={150}
                value={email}
            />

            <InputTelefone
                titulo="Telefone:*"
                onChange={setTelefone}
                placeHolder="(99) 99999-9999"
                value={telefone}
            />

            <label className="text-bold-header text-primary">Informações pessoais</label>

            <Dropdown
                titulo="Tipo pessoa:*"
                value={tipoPessoa}
                onSelect={(e) => {
                    setTipoPessoa(e)
                    setCpfCnpj("")
                    setInscricaoIsento(false)
                }}
                opcoes={[
                    FISICA, JURIDICA
                ]}
            />

            {
                tipoPessoa === FISICA ? (
                    <InputCPF
                        titulo="CPF:*"
                        onChange={setCpfCnpj}
                        value={cpfCnpj}
                    />
                ) : (
                    <InputCNPJ
                        titulo="CNPJ:*"
                        onChange={setCpfCnpj}
                        value={cpfCnpj}
                    />
                )
            }



            <Checkbox
                titulo="Inscrição estadual para Pessoa Física"
                valor={inscricaoIsento}
                onClick={(e) => {
                    if (e)
                        setInscricaoEstadual("")
                    setInscricaoIsento(!inscricaoIsento)
                }}
            />

            <InputInscricaoEstadual
                desabilitar={inscricaoIsento}
                titulo="Inscrição Estadual:*"
                onChange={setInscricaoEstadual}
                placeHolder="Isento"
                value={inscricaoEstadual}
            />

            {
                tipoPessoa === FISICA ? (
                    <>
                        <Dropdown
                            titulo="Genero:*"
                            value={genero}
                            onSelect={setGenero}
                            opcoes={[
                                MASCULINO, FEMININO, OUTROS
                            ]}
                        />

                        <InputData
                            titulo="Data de nascimento:*"
                            onChange={setDataNascimento}
                            value={dataNascimento}
                        />
                    </>
                ) : false
            }

            <label className="text-bold-header text-primary">Situação do cliente</label>

            <Checkbox
                titulo="Bloqueado"
                valor={bloqueado}
                onClick={setBloqueado}
            />

            <label className="text-bold-header text-primary">Senha de acesso</label>

            <InputSenha
                titulo="Senha:*"
                onChange={setSenha}
                placeHolder="Informe uma senha"
                tamanhoMaximo={15}
                value={senha}
            />

            <InputSenha
                titulo="Confirmação de senha:*"
                onChange={setSenhaConfirmacao}
                placeHolder="Confirme a senha informada"
                tamanhoMaximo={15}
                value={senhaConfirmacao}
            />

            <div className="m-5 w-fit self-center space-x-8">
                <Link to="/">
                    <Button className=" bg-red-600">
                        Cancelar
                    </Button>
                </Link>

                <Button onClick={() => submmit()}>
                    Adicionar Cliente
                </Button>
            </div>
        </div>
    )
}