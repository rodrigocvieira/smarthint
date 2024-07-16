import InputMask from 'react-input-mask';
import { CSS } from './Color';

interface InputComMaskProp {
    desabilitar?:boolean,
    mask: string
    titulo: string,
    placeholder: string,
    value: string,
    onChange: (value: string) => void
}

export default function InputComMask(prop: InputComMaskProp) {

    return (
        <>
            <label className="text-primary text-semi-bold mt-5">{prop.titulo}</label>

            <InputMask 
                disabled={prop.desabilitar}
                mask={prop.mask}
                className={CSS}
                value={prop.value}
                onChange={(e) => prop.onChange(e.target.value)}
                placeholder={prop.placeholder} />
        </>
    )
}