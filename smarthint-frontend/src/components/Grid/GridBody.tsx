interface GridCorpoProp {
    children: any
}

export default function GridBody(prop : GridCorpoProp) {
    return (
        <tbody>
            {prop.children}
        </tbody>
    );
}
