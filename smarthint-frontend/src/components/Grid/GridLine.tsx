import ClienteListagemDTO from "../../model/ClienteListagemDTO";
import Checkbox from "../CheckBox";

interface GridLineProp {
    object: ClienteListagemDTO,
    color?: boolean,
    children?: any
}

export default function GridLine(prop: GridLineProp) {

    const cor = prop.color ? "bg-primary text-white" : ""

    return (
        <tr className={cor}>
            <th className="p-1">
                <Checkbox value="true" onClick={() => { }} />
            </th>
            <td className="p-1 w-72 text-left">{prop.object.nome}</td>
            <td className="p-1 w-72 text-left">{prop.object.email}</td>
            <td className="p-1 w-12 text-center">{prop.object.telefone}</td>
            <td className="p-1 w-13 text-center">{prop.object.dataCadastro}</td>
            <td className="p-1 w-12 text-center">{prop.object.bloqueado ? "Bloqueado" : "-"}</td>
            <td className="p-1 w-12 text-center">
                {prop.children}
            </td>
        </tr>
    );
}
