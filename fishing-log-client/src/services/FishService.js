import axios from 'axios';

export default {
    saveFish(fish) {
        return axios.post('/add-fish', fish)
    }
}