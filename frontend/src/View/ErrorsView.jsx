import React from 'react'

function ErrorsView(props) {
    const { errorMessage } = props

    return (
        <div className="errorsview-container">
            <span>
                {errorMessage}
            </span>
        </div>);
}

export default ErrorsView;