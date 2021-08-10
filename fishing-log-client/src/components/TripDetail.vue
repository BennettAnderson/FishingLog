<template>
  <div>
    <h1>Trip detail</h1>
    <h2>Location {{ this.trip.location }}</h2>
    <h3>Date: {{ this.trip.date }}</h3>
    <h3>Weather: {{ this.trip.weather }}</h3>
    <p>Comments:</p>
    <p>{{ this.trip.comments }}</p>
    <h3>Fish:</h3>
    <ul v-for="fish in this.trip.fishList" v-bind:key="fish.fishId">
      -
      {{
        fish.length
      }}"
      {{
        fish.species
      }} - {{fish.lure}}
    </ul>
  </div>
</template>

<script>
import TripService from "@/services/TripService.js";

export default {
  name: "trip-detail",
  props: ["tripId"],
  data() {
    return {
      trip: {},
    };
  },
  methods: {
    getTrip() {
      TripService.getTrip(this.tripId).then((response) => {
        this.trip = response.data;
      });
    },
  },
  created() {
    this.getTrip();
  },
};
</script>

<style>
</style>