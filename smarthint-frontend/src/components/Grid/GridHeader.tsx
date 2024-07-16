import { useState } from "react";
import Checkbox from "../CheckBox";

interface GridHeaderProp {
    onClickCheckBox: (v: boolean) => void,
    selecionado: boolean
}

export default function GridHeader(prop: GridHeaderProp) {

    const [ selecionado , setSelecionado ] = useState(prop.selecionado);

    return (
        <thead className="text-primary">
            <tr>
                <th className="p-1">
                    <Checkbox value={prop.selecionado} onClick={(e) => {
                        const checked = e.target.checked
                        prop.onClickCheckBox(checked)
                        setSelecionado(checked)
                    }}/>
                </th>
                <th className="p-1 text-left">Nome/Razão Social</th>
                <th className="p-1 text-left">E-mail</th>
                <th className="p-1 text-center">Telefone</th>
                <th className="p-1 text-center">Dada de cadastro</th>
                <th className="p-1 text-center">Bloqueado</th>
                <th className="p-1 text-center">Ações</th>
            </tr>
        </thead>
    );
}
