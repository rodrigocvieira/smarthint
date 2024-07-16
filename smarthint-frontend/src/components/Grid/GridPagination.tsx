import Button from "../Button";


interface GridPaginationProp {
    habilitaPaginaAnterior: boolean,
    onClickAnterior: () => void,
    habilitaPaginaPosterior: boolean,
    onClickPosterior: () => void 
}

export default function GridPagination(prop: GridPaginationProp) {

    return (
        <caption className="caption-bottom space-x-3 p-1 text-right">
            <Button 
                className={`${prop.habilitaPaginaAnterior ? "" : "bg-gray_my"} `}
                disabled={!prop.habilitaPaginaAnterior}
                onClick={prop.onClickAnterior}>
                Página anterior
            </Button>
            <Button 
                className={`${prop.habilitaPaginaPosterior ? "" : "bg-gray_my"} `}
                disabled={!prop.habilitaPaginaPosterior}
                onClick={prop.onClickPosterior}>
                Próxima página
            </Button>
        </caption>
    );
}
