import InputComMask from './InputComMask';

interface InputCPFProp {
    titulo: string,
    value: string,
    onChange: (value: string) => void
}

export default function InputCPF(prop: InputCPFProp) {

    return (
        <InputComMask
            titulo={prop.titulo}
            mask="999.999.999-99"
            value={prop.value}
            onChange={prop.onChange}
            placeholder="999.999.999-99" />
    )
}