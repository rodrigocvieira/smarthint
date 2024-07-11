interface CheckboxProp {
    value: string,
    onClick: () => void
}

export default function Checkbox(prop: CheckboxProp) {

    return (
        <>
            <input type="checkbox"
                className="cursor-pointer"
                value={prop.value}
                onClick={prop.onClick} />
        </>
    )
}