import React from 'react'

function Loader(props) {
    const { isLoading, children } = props

    if (!isLoading) {
        return (children);
    }
    return (<div className="resultsview-container">
        <div className="resultsview-results">
            <span>
                {"Simulerar..."}
            </span>
        </div>
    </div>);
}

export default Loader;