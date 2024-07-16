import { Modal } from "flowbite-react";
import { useState } from "react";
import Button from "./Button";
import Input from "./Input/Input";

interface FiltroProp {
    janela: boolean
    setFechar: (b: boolean) => void
    pesquisar: (valor: string) => void
}

export default function Filtro(prop: FiltroProp) {
    const [pesquisa, setPesquisa] = useState("")

    return (
        <Modal show={prop.janela} onClose={() => prop.setFechar(false)}>
            <Modal.Header className="bg-primary ">
                <p className="text-white">Filtro de comprador</p>
            </Modal.Header>
            <Modal.Body>
                <Input
                    titulo="Informe o nome ou razão social do cliente para pesquisa:*"
                    onChange={setPesquisa}
                    placeHolder=""
                    tamanhoMaximo={150}
                    value={pesquisa}
                />
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={() => {
                    prop.setFechar(false)
                    prop.pesquisar(pesquisa)
                }}>
                    Pesquisar
                </Button>
                <Button className="bg-slate-600" onClick={() => {
                    prop.setFechar(false)
                    prop.pesquisar("")
                    setPesquisa("")
                }}>
                    Limpar filtro
                </Button>
                <Button className="bg-red-400" onClick={() => prop.setFechar(false)}>
                    Cancelar
                </Button>
            </Modal.Footer>
        </Modal >
    )
}