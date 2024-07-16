import Button from '../components/Button';
import Header from '../components/Header';
import { Grid } from '../components/Grid/Grid';
import ClienteListagemDTO from '../model/ClienteListagemDTO';
import { Edit, EditBlue } from '../components/Icons';
import { useEffect, useState } from 'react';
import ClientePayload from '../model/ClientePayload';
import { consultaClientes } from '../services/api';
import Filtro from '../components/Filtro';

export default function Listagem() {

	const [payload, setPayload] = useState(new ClientePayload([], false))
	const [temPaginaAnterior, setTemPaginaAnterior] = useState(false)
	const [temPaginaPosterior, setTemPaginaPosterior] = useState(false)
	const [paginaAtual, setPaginaAtual] = useState(0)

	const [selecionadoHeader, setSelecionadoHeader] = useState(false)
	const [janelaFiltrar, setJanelaFiltrar] = useState(false)
	const [filtroValor, setFiltroValor] = useState("")

	useEffect(() => {
		consultar(paginaAtual, filtroValor).then(data => {
			setPayload(data)
			setTemPaginaAnterior(paginaAtual > 0)
			setTemPaginaPosterior(data?.proximaPagina)
		})
	}, [paginaAtual, filtroValor])

	async function consultar(pagina: number, filtro: string) {
		return await consultaClientes(pagina, filtro)
	}

	function consultarPorFiltro(valor: string) {
		setFiltroValor(valor)
		setPaginaAtual(0)
	}

	function controlePaginaAnterior() {
		var controlePagina = paginaAtual
		controlePagina -= 1
		setTemPaginaAnterior(controlePagina > 0)
		setPaginaAtual(controlePagina)

		return controlePagina
	}

	function controlePaginaPosterior() {
		var controlePagina = paginaAtual
		controlePagina += 1
		setPaginaAtual(controlePagina)

		return controlePagina
	}

	function marcarDesmarcarTodos(v: boolean) {
		return payload.clientes.map(cliente => {
			cliente.selecionado = v;
			return cliente
		})
	}

	function atualizarListagem(clientes: ClienteListagemDTO[]) {
		setPayload(new ClientePayload(clientes, payload.proximaPagina))
	}

	return (
		<div className='m-auto'>
			<div className='p-5'>
				<Header />
				<Button onClick={() => setJanelaFiltrar(true)}>
					Filtrar
				</Button>
			</div>

			<Filtro janela={janelaFiltrar}
				setFechar={setJanelaFiltrar}
				pesquisar={(valor) => consultarPorFiltro(valor)} />

			<Grid.Root>
				<Grid.Header onClickCheckBox={(e) => {
					const clientes = marcarDesmarcarTodos(e)
					setSelecionadoHeader(e)
					atualizarListagem(clientes)
				}} selecionado={selecionadoHeader} />
				<Grid.Body>
					{payload?.clientes?.map((cliente: ClienteListagemDTO, i) => {

						const controleCorLinha = i % 2 === 0

						return (
							<Grid.Line
								object={cliente}
								color={controleCorLinha}
								key={cliente.id}
								selecionado={cliente.selecionado}
								onSelecionado={(valor) => {
									if (selecionadoHeader)
										valor = true

									var clientes = marcarDesmarcarTodos(false)
									setSelecionadoHeader(false)

									clientes = clientes.map(c => {
										if (c.id === cliente.id)
											c.selecionado = valor
										return c
									})

									atualizarListagem(clientes)
								}}
							>
								<Grid.Button link={`/clientes/${cliente.id}`} >
									{controleCorLinha ? Edit : EditBlue}
								</Grid.Button>
							</Grid.Line>
						)
					})}
				</Grid.Body>
				<Grid.Pagination
					habilitaPaginaAnterior={temPaginaAnterior}
					onClickAnterior={() => {
						const controlePagina = controlePaginaAnterior()

						consultar(controlePagina, filtroValor).then(data => {
							setPayload(data)
							setTemPaginaAnterior(controlePagina > 0)
							setTemPaginaPosterior(data.proximaPagina)
						})
					}}
					habilitaPaginaPosterior={temPaginaPosterior}
					onClickPosterior={() => {
						const controlePagina = controlePaginaPosterior()

						consultar(controlePagina, filtroValor).then(data => {
							setPayload(data)
							setTemPaginaAnterior(true)
							setTemPaginaPosterior(data.proximaPagina)
						})
					}} />
			</Grid.Root>
			<div className='text-center flex flex-col'>
				<label>Controle de Endpoint</label>
				<label>{process.env.REACT_APP_API_MOCK === "true" ? "API MOCK" : "API SPRING"}</label>
			</div>

		</div>
	);
}
