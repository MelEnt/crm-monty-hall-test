import React from 'react'
import { SIM_FIELDS } from '../Enums/SimulatorFields';

function ResultsView(props) {
    const { results, isLoading } = props;

    if (!results) {
        return null;
    }

    const { numberOfSimulations, willSwapDoor, chanceToWin } = results;
    console.log(results);

    const roundedWinChance = (chanceToWin * 100).toString().substring(0, 5) + "%";

    /*

    {
    "numberOfSimulations": 5,
    "chanceToWin": 0.4,
    "willSwapDoor": false
}

    */

    return (
        <div className="resultsview-container">
            <div className="resultsview-results">
                <span>
                    {isLoading ? "Simulerar..." : "Resultat: " + roundedWinChance + " chans att vinna med " + numberOfSimulations + " antal simuleringar"}
                </span>
            </div>
        </div>);
}

export default ResultsView;