interface GridButtonProp {
    children: any;
    onClick?: () => void;
}

export default function GridButton(prop: GridButtonProp) {

    return (
        <button
            className="text-semi-bold p-2 content-center text-center rounded-lg"
            onClick={prop.onClick}>
            {prop.children}
        </button>
    );
}
