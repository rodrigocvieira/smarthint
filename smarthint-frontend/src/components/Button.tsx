interface ButtonProp {
    children: any;
    className?: string,
    onClick?: () => void;
    disabled?: boolean
}

export default function Button(prop: ButtonProp) {

    const corBotao = prop.disabled ? prop.className : "bg-primary"

    return (
        <button disabled={prop.disabled}
            className={
                `${corBotao} text-white text-semi-bold p-2 content-center text-center rounded-lg 
                ${prop.className}`
            }
            onClick={prop.onClick}>
            {prop.children}
        </button>
    );
}
