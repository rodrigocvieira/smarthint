export default async function consultaClientes(pagina: number) {
    return await fetch(`http://localhost:5000/clientes?pagina=${pagina}`)
} 