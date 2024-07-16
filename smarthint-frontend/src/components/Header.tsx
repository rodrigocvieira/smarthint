import { Link } from "react-router-dom";
import Button from "./Button";

export default function Header() {
    return (
        <div className="flex">
            <h1 className="text-bold-header w-full text-primary">
                Consulte os seus Clientes cadastrados na sua Loja
            </h1>
            <div className="w-52 content-center text-center">
                <Link to={"/cliente/"}>
                    <Button>
                        Adicionar Cliente
                    </Button>
                </Link>

            </div>

        </div>
    );
}
