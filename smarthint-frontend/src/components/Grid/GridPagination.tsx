import Button from "../Button";

export default function GridPagination() {
    return (
        <caption className="caption-bottom space-x-3 p-1 text-right">
            <Button>
                Página anterior
            </Button>
            <Button>
                Próxima página
            </Button>
        </caption>
    );
}
