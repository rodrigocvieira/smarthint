interface GridRootProp {
    children: any;
}

export default function GridRoot(prop: GridRootProp) {
    return (
       <table className="m-auto mb-5">
            {prop.children}
       </table>
    );
}
