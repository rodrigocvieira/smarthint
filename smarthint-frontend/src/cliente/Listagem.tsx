import React from 'react';
import Button from '../components/Button';
import Header from '../components/Header';
import { Grid } from '../components/Grid/Grid';
import ClienteListagemDTO from '../model/ClienteListagemDTO';
import { Edit, EditBlue } from '../components/Icons';
import { useEffect, useState } from 'react';
import ClientePayload from '../model/ClientePayload';
import consultaClientes from '../services/api';

export default function Listagem() {

	const [payload, setPayload] = useState(new ClientePayload([], false))
	const [temPaginaAnterior, setTemPaginaAnterior] = useState(false)
	const [temPaginaPosterior, setTemPaginaPosterior] = useState(false)
	const [paginaAtual, setPaginaAtual] = useState(0)

	useEffect(() => {
		consultar(paginaAtual).then(data => {
			setPayload(data)
			setTemPaginaAnterior(false)
			setTemPaginaPosterior(data?.proximaPagina)
		})
	}, [])

	async function consultar(pagina: number) {
		return await consultaClientes(pagina)
	}

	function filtrar() {

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


	return (
		<div className='m-auto'>
			<div className='p-5'>
				<Header />
				<Button onClick={filtrar}>
					Filtrar
				</Button>
			</div>

			<Grid.Root>
				<Grid.Header />
				<Grid.Body>
					{payload?.clientes?.map((cliente: ClienteListagemDTO, i) => {

						const controleCorLinha = i % 2 === 0

						return (
							<Grid.Line object={cliente} color={controleCorLinha} key={cliente.id}>
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

						consultar(controlePagina).then(data => {
							setPayload(data)
							setTemPaginaAnterior(controlePagina > 0)
							setTemPaginaPosterior(data.proximaPagina)
						})
					}}
					habilitaPaginaPosterior={temPaginaPosterior}
					onClickPosterior={() => {
						const controlePagina = controlePaginaPosterior()

						consultar(controlePagina).then(data => {
							setPayload(data)
							setTemPaginaAnterior(true)
							setTemPaginaPosterior(data.proximaPagina)
						})
					}} />
			</Grid.Root>
			<div className='text-center'>
				<label>{process.env.REACT_APP_API_MOCK === "true" ? "API MOCK" : "API SPRING"}</label>
			</div>

		</div>
	);
}
