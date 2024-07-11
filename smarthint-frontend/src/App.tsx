import './App.css';
import Button from './components/Button';
import Header from './components/Header';
import { Grid } from './components/Grid/Grid';
import ClienteListagemDTO from './model/ClienteListagemDTO';
import { Edit, EditBlue } from './components/Icons';

const clientes: ClienteListagemDTO[] = [
	new ClienteListagemDTO("1", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("2", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("3", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("4", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("5", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("6", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("7", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("8", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("9", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("10", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("11", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("12", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("13", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("14", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("15", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("16", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("17", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("18", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("19", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false),
	new ClienteListagemDTO("20", "nome", "empresa@empresa.com.br", "44999999999", "11/07/2024", false)
]

function App() {


	return (
		<div className='m-auto'>
			<div className='p-5'>
				<Header />
				<Button>
					Filtrar
				</Button>
			</div>

			<Grid.Root>
				<Grid.Header />
				<Grid.Body>
					{clientes.map((cliente: ClienteListagemDTO, i) => {
						return (
							<Grid.Line object={cliente} color={i % 2 == 0} key={cliente.id}>
								<Grid.Button >
									{i % 2 == 0 ? Edit : EditBlue}
								</Grid.Button>
							</Grid.Line>
						)
					})}
				</Grid.Body>
				<Grid.Pagination />
			</Grid.Root>
		</div>
	);
}

export default App;
