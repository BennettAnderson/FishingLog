<template>
  <div class="trip-list">
    <h1>Trips</h1>
    <ul v-for="trip in this.trips" v-bind:key="trip.tripId">
      <router-link
        v-bind:tripId="trip.tripId"
        :to="{ name: 'trip', params: { tripId: trip.tripId } }"
        >{{ trip.location }} on {{ trip.date }}</router-link
      >
    </ul>
  </div>
</template>

<script>
import tripService from "@/services/TripService.js";

export default {
  name: "trip-list",
  data() {
    return {
      trips: [],
    };
  },
  methods: {
    getTrips() {
      tripService.getAllTrips().then((response) => {
        this.trips = response.data;
        this.$store.commit("SET_TRIPS", response.data);
      });
    },
  },
  created() {
    this.getTrips();
  },
};
</script>

<style>
</style>