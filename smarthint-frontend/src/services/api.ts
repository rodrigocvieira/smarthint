export default async function consultaClientes(pagina: number) {
    const response = await fetch(`${process.env.REACT_APP_API_URL}/clientes?paginacao=${pagina}`)
    const data = await response.json()
    console.log(data)

    if (process.env.REACT_APP_API_MOCK !== "false")
        return data[0]
    
    return data
} 