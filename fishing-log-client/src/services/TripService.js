import axios from 'axios';

export default {

    getAllTrips() {
        return axios.get('/trips');
    },

    saveTrip(trip) {
        return axios.post('/trip', trip)
    },

    getTrip(tripId) {
        return axios.get(`/trip/${tripId}`)
    }

}
