import ValorDropdown from "./ValorDropdown";

export const MASCULINO = new ValorDropdown("Masculino", "MASCULINO");
export const FEMININO = new ValorDropdown("Feminio", "FEMININO");
export const OUTROS = new ValorDropdown("Outros", "OUTROS");

export function convertGenero(valor: string) {
    if (valor === MASCULINO.valor)
        return MASCULINO
    else if (valor === FEMININO.valor)
        return FEMININO
    return OUTROS
}