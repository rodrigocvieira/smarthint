import ValorDropdown from "./ValorDropdown";

export const FISICA = new ValorDropdown("Fisica", "FISICA");
export const JURIDICA = new ValorDropdown("Juridica", "JURIDICA");

export function convertTipoPessoa(valor: string) {
    if (valor === JURIDICA.valor)
        return JURIDICA
    return FISICA
}