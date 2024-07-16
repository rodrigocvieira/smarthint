import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Cadastro from './cliente/Cadastro';
import Listagem from './cliente/Listagem';

function App() {

	return (
		<BrowserRouter>
			<Routes>
				<Route path="/" Component={Listagem} />
				<Route path="/clientes/:id" Component={Cadastro} />
				<Route path="/cliente" Component={Cadastro} />
			</Routes>
		</BrowserRouter>
	);
}

export default App;
