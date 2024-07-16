import { ToggleSwitch } from "flowbite-react";

interface CheckboxProp {
    titulo: string,
    valor: boolean,
    onClick: (valor: boolean) => void
}


export default function Checkbox(prop: CheckboxProp) {

    return (
        <ToggleSwitch
            className="mt-5 text-primary ring-primary"
            checked={prop.valor}
            label={prop.titulo}
            onChange={prop.onClick} />
    )
}