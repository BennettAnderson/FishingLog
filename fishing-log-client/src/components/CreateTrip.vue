<template>
  <div>
    <h1>Add a Trip</h1>
    <form >
      <label for="location">Location:</label>
      <input type="text" required v-model="trip.location" />
      <label for="date">Date:</label>
      <input type="date" v-model="trip.date" />
      <label for="weather">Weather/Conditions:</label>
      <input type="text" v-model="trip.weather" />
      <label for="notes">Notes:</label>
      <textarea cols="50" rows="10" v-model="trip.comments"></textarea>
      <label for="species">Fish Species:</label>
      <input type="text" v-model="fish.species" />
      <label for="length">Length:</label>
      <input type="number" v-model="fish.length" />
      <label for="lure">Lure Used:</label>
      <input type="text" v-model="fish.lure" />
      <button v-on:click.prevent="addFish">Add Fish</button>
      <div v-for="(fish, index) in fishArray" v-bind:key="index">
        - {{ fish.length }}" {{ fish.species }} caught with: {{ fish.lure }}
      </div>

      <button v-on:click="saveTrip">Save Trip</button>
    </form>
  </div>
</template>

<script>
import TripService from '@/services/TripService.js'
import FishService from '@/services/FishService.js'

export default {
  name: "create-trip",
  data() {
    return {
      trip: {
        location: "",
        date: "",
        weather: "",
        comments: "",
      },
      fishArray: [],
      fish: {
        species: "",
        length: null,
        lure: ""
      },
    };
  },
  methods: {
    addFish() {
      this.fishArray.push(this.fish);
      this.fish = {
        species: "",
        length: null,
        lure: ""
      };
    },
    saveTrip() {
      TripService.saveTrip(this.trip).then((response) => {
        let tripId = response.data;
        this.fishArray.forEach(fish => {
        fish.tripId = tripId;
        FishService.saveFish(fish).then(response => {
          if (response.status == 201) {
            this.fishArray = [];
            this.fish = {};
            this.$router.push('/');
          }
        })
      })
      });
      
    },
  },
};
</script>

<style>
</style>