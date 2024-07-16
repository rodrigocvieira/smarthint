import ClienteDTO from "../model/ClienteDTO"

export async function consultaClientes(pagina: number) {
    const response = await fetch(`${process.env.REACT_APP_API_URL}/clientes?paginacao=${pagina}`)
    const data = await response.json()

    if (process.env.REACT_APP_API_MOCK !== "false")
        return data[0]

    return data
}


export async function inserir(dto: ClienteDTO) {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dto)
    };

    var error = false;

    const response = await fetch(`${process.env.REACT_APP_API_URL}/clientes/inserir`, requestOptions)
    if (response.status !== 201)
        error = true

    const data = await response.json()
    return { mensagem: data.mensagem, error };
}

export async function obter(id: string) {
    const requestOptions = {
        method: 'GET',
    };

    var error = false;

    const response = await fetch(`${process.env.REACT_APP_API_URL}/clientes/${id}`, requestOptions)
    if (response.status !== 200)
        error = true

    const data = await response.json()
    return { data, error };
}

export async function editar(id: string, dto: ClienteDTO) {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dto)
    };

    var error = false;

    const response = await fetch(`${process.env.REACT_APP_API_URL}/clientes/${id}`, requestOptions)
    if (response.status !== 200)
        error = true

    const data = await response.json()
    return { mensagem: data.mensagem, error };
}