<template>
  <div>
    <h1>Add a Trip</h1>
    <form>
      <label for="location">Location:</label>
      <input type="text" required v-model="trip.location" />
      <label for="date">Date:</label>
      <input type="date" v-model="trip.date" />
      <label for="weather">Weather/Conditions:</label>
      <input type="text" v-model="trip.weather" />
      <label for="notes">Notes:</label>
      <textarea cols="50" rows="10" v-model="trip.notes" ></textarea>
      <label for="fish">Log a fish:</label>
      <input type="text" v-model="fish" />
      <button v-on:click.prevent="addFish" >Add Fish</button>
      <input type="submit" value="Save Trip" >
    </form>
    <div v-for="fish in fishArray" v-bind:key="fish" >{{fish}}</div>
  </div>
</template>

<script>
export default {
  name: "create-trip",
  data() {
    return {
      trip: {
        location: "",
        date: "",
        weather: "",
        notes: ""
      },
      fishArray: [],
      fish: "",
    };
  },
  methods: {
    addFish() {
      this.fishArray.push(this.fish);
      this.fish = "";
    },
    saveTrip() {
      
    }
  }
};
</script>

<style>
</style>