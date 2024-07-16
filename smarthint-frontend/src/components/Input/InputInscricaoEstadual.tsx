import InputComMask from './InputComMask';

interface InputInscricaoEstadualProp {
    desabilitar?: boolean,
    titulo: string,
    placeHolder: string,
    value: string,
    onChange: (value: string) => void
}

export default function InputInscricaoEstadual(prop: InputInscricaoEstadualProp) {

    return (
        <InputComMask
            desabilitar={prop.desabilitar}
            titulo={prop.titulo}
            mask="999.999.999-999"
            value={prop.value}
            onChange={prop.onChange}
            placeholder={prop.placeHolder} />
    )
}