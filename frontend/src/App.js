import React, { useState } from 'react';
import monty from './monty.jpg';
import './App.css';
import BackendHealth from './BackendHealth/BackendHealth';
import InputViews from './View/InputViews';
import SimulatorService from './Service/SimulatorService';
import ResultsView from './View/ResultsView';
import ErrorsView from './View/ErrorsView';
import Loader from './Components/Loader';

function App() {

    const simulatorService = new SimulatorService();
    const [results, setResults] = useState(null);
    const [errorMessage, setErrorMessage] = useState("");
    const [isLoading, setLoading] = useState(false);

    async function handleSubmit(data) {
        try {
            setErrorMessage("");
            setLoading(true);
            const results = await simulatorService.postData(data);
            console.log(results.data);
            setResults(results.data);
        } catch (e) {
            console.log(e.response);
            setErrorMessage(e.response.data.message);
            setResults(null);
        } finally {
            setLoading(false);
        }
    }

    return (
        <div className="App">
            <header className="App-header">
                <BackendHealth />
                <img src={monty} className="App-monty" alt="logo" />
                <h1 className="App-title">Welcome to the Monty Hall Simulator</h1>
            </header>
            <div className="content-container">
                {errorMessage && <ErrorsView errorMessage={errorMessage} />}
                <InputViews onSubmit={handleSubmit} />
                <Loader isLoading={isLoading}>
                    <ResultsView results={results} isLoading={isLoading} />
                </Loader>
            </div>
        </div>
    );
}

export default App;
