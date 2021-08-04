<template>
  <div class="trip-list">
    <table>
      <thead>
        <tr>
          <th>Trip</th>
          <th>Edit</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="trip in this.$store.state.trips" v-bind:key="trip.tripId">
          <td width="80%">
            <router-link v-bind:to="{ name: 'Trip', params: { id: trip.id } }"
              >{{ trip.location }}: {{ trip.date }}</router-link
            >
          </td>
          <td>
            <router-link :to="{ name: 'EditTrip', params: { id: trip.id } }"
              >Edit</router-link
            >
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import tripService from "@/services/TripService.js";

export default {
  name: "trip-list",
  methods: {
    getTrips() {
      tripService.getAllTrips().then((response) => {
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