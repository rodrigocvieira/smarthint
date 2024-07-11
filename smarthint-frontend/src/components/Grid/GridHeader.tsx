import Checkbox from "../CheckBox";

export default function GridHeader() {
    return (
        <thead className="text-primary">
            <tr>
                <th className="p-1">
                    <Checkbox value="true" onClick={() => {}}/>
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
