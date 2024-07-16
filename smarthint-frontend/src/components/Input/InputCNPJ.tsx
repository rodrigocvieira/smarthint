import InputComMask from './InputComMask';

interface InputCNPJProp {
    titulo: string,
    value: string,
    onChange: (value: string) => void
}

export default function InputCNPJ(prop: InputCNPJProp) {

    return (
        <InputComMask
            titulo={prop.titulo}
            mask="99.999.999/9999-99"
            value={prop.value}
            onChange={prop.onChange}
            placeholder="99.999.999/9999-99" />
    )
}