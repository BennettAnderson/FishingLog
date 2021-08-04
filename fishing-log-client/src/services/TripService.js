import axios from 'axios';

export default {

    getAllTrips() {
        return axios.get('/trips');
    }

}
