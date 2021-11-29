import axios from "axios";

class SimulatorService {
    constructor() {
        this.serviceUrl = "http://localhost:8080/";
        this.headers = {
            'Content-Type': 'application/json'
        }
    }


    async postData(data) {
        return await axios.post(this.serviceUrl + "post", data, { headers: this.headers });
    }
}

export default SimulatorService;