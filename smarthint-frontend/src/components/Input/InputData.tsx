import { CSS } from './Color';
import { Datepicker } from "flowbite-react";

interface InputDataProp {
    titulo: string,
    value: Date,
    onChange: (value: Date) => void
}

export default function InputData(prop: InputDataProp) {

    return (

        <>
            <label className="text-primary text-semi-bold mt-5">{prop.titulo}</label>

            <Datepicker
                className={CSS} //TODO: arrumar borda
                language="pt-BR"
                labelTodayButton="Hoje"
                labelClearButton="Limpar"
                maxDate={new Date()}
                value={prop.value?.toLocaleString('pt-br', {
                    dateStyle: 'short'
                })}
                
                onSelectedDateChanged={prop.onChange}
            />
        </>
    )
}