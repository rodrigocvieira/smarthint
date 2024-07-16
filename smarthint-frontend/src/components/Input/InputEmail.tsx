import { CSS } from "./Color"

interface InputEmailProp {
    titulo: string,
    placeHolder: string,
    value: string,
    onChange: (value: string) => void
    tamanhoMaximo: number
}


export default function InputEmail(prop: InputEmailProp) {


    return (
        <>
            <label className="text-primary text-semi-bold mt-5">{prop.titulo}</label>

            <input
                className={CSS}
                value={prop.value}
                onChange={(e) => prop.onChange(e.target.value)}
                maxLength={prop.tamanhoMaximo}
                placeholder={prop.placeHolder}
                type="email"
            />
        </>
    )
}