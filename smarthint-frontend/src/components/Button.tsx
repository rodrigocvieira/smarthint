interface ButtonProp {
    children: any;
    className?: string,
    onClick?: () => void;
}

export default function Button(prop: ButtonProp) {

    return (
        <button
            className={
                `bg-primary text-white text-semi-bold p-2 content-center text-center rounded-lg
                ${prop.className}`
            }
            onClick={prop.onClick}>
            {prop.children}
        </button>
    );
}
