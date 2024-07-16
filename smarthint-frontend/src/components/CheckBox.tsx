interface CheckboxProp {
    value: boolean,
    onClick: (e: any) => void
}

export default function Checkbox(prop: CheckboxProp) {

    return (
        <input type="checkbox"
            className="cursor-pointer"
            checked={prop.value}
            onChange={prop.onClick} />
    )
}