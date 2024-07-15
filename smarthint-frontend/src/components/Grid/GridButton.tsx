import { Link } from "react-router-dom";

interface GridButtonProp {
    children: any;
    link? :string,
    onClick?: () => void;
}

export default function GridButton(prop: GridButtonProp) {

    const link = prop.link ? prop.link : ""

    return (
        <Link to={link}>
            <button
                className="text-semi-bold p-2 content-center text-center rounded-lg"
                onClick={prop.onClick}>
                {prop.children}
            </button>
        </Link>
    );
}
