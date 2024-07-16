import InputComMask from './InputComMask';

interface InputTelefoneProp {
    titulo: string,
    placeHolder: string,
    value: string,
    onChange: (value: string) => void
}

export default function InputTelefone(prop: InputTelefoneProp) {

    return (
        <InputComMask
            titulo={prop.titulo}
            mask="(99) 99999-9999"
            value={prop.value}
            onChange={prop.onChange}
            placeholder={prop.placeHolder} />
    )
}