import Button from "./Button";

export default function Header() {
    return (
        <div className="flex">
            <h1 className="text-bold-header w-full text-primary">
                Consulte os seus Clientes cadastrados na sua Loja
            </h1>
            <div className="w-52 content-center text-center">
                <Button>
                    Adicionar Cliente
                </Button>
            </div>

        </div>
    );
}
