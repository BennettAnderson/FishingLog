import axios from 'axios';

export default {
    saveFish(tripId, fish) {
        return axios.post(`/add-fish/${tripId}`, fish)
    }
}