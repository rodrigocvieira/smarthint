export const formatarTelefone = (telefone: string) => {
    return telefone.replace(/^(\d{2})(\d{5})(\d{4})$/, '($1) $2-$3');
};