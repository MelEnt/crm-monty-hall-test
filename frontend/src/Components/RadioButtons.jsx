import React from 'react'

function RadioButtons(props) {
    const { onChange, value } = props

    function handleOnChange(e) {
        const value = e.currentTarget.value;
        console.log(value);
        console.log();
        onChange(value);
    }

    return (
        <div className="radio-container">
            <label className="radio-container-btn">
                <input type={"radio"} onChange={handleOnChange} value={"0"} checked={value === "0"} />
                Byta dörr
            </label>
            <label className="radio-container-btn">
                <input type={"radio"} onChange={handleOnChange} value={"1"} checked={value === "1"} />
                Stå kvar
            </label>
        </div>);
}

export default RadioButtons;