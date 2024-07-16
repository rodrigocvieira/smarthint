import { Dropdown as DP } from "flowbite-react";
import ValorDropdown from "../../model/ValorDropdown";

interface DropdownProp {
    titulo: string,
    value: ValorDropdown,
    opcoes: ValorDropdown[],
    onSelect: (value: ValorDropdown) => void
}


export default function Dropdown(prop: DropdownProp) {

    return (
        <>
            <label className="text-primary text-semi-bold mt-5">{prop.titulo}</label>

            <DP label={prop.value.valor} className="text-primary">
                {prop.opcoes.map((opcao) => {
                    return (
                        <DP.Item key={opcao.valor}
                            onClick={() => prop.onSelect(opcao)}>
                                {opcao.label}
                        </DP.Item>
                    )
                })}
            </DP>
        </>
    )
}