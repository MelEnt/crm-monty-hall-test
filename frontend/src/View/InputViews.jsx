import React, { useState } from 'react'
import RadioButtons from '../Components/RadioButtons';
import { SIM_FIELDS } from '../Enums/SimulatorFields';

function InputViews(props) {
    const { onSubmit, isLoading } = props;

    const [numberOfSims, setNumberOfSims] = useState(0);
    const [option, setOption] = useState("0");



    function handleChangeNumber(e) {
        setNumberOfSims(e.currentTarget.value);
    }

    function handleSubmit(e) {
        console.log(e.currentTarget);
        console.log("e.currentTarget");

        const outputData = {
            [SIM_FIELDS.NUM_OF_SIMS]: Number(numberOfSims),
            [SIM_FIELDS.WILL_SWAP_DOOR]: option === "0" ? true : false
        }

        onSubmit(outputData)
        e.preventDefault();
    }

    function handleChangeOption(value) {
        setOption(value);
    }

    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <label className="content-form-label">{"Ange antal simulationer"}</label>
            <input className="content-form-numberofsims-input" type="number" value={numberOfSims} onChange={handleChangeNumber} />
            <RadioButtons value={option} onChange={handleChangeOption} />
            <input className="form-submit-btn" type="submit" value={isLoading ? "Loading..." : "Submit"} />
        </form>);
}

export default InputViews;