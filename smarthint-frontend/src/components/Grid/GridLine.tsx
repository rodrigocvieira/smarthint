import moment from "moment";
import ClienteListagemDTO from "../../model/ClienteListagemDTO";
import Checkbox from "../CheckBox";
import { formatarTelefone } from "../Utils";

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
            <td className="p-1 w-72 text-left">{prop.object.nomeRazaoSocial}</td>
            <td className="p-1 w-72 text-left">{prop.object.email}</td>
            <td className="p-1 w-15 text-center">
                {formatarTelefone(prop.object.telefone)}
            </td>
            <td className="p-1 w-13 text-center">{moment(prop.object.dataDeCadastro).format('DD/MM/yyyy HH:mm')}</td>
            <td className="p-1 w-12 text-center">{prop.object.bloqueado ? "Sim" : "-"}</td>
            <td className="p-1 w-12 text-center">
                {prop.children}
            </td>
        </tr>
    );
}
