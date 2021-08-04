<template>
  <div>
      <h1>Add a Trip</h1>
      <form>
          <label for="location">Location:</label>
          <input type="text" required>
          <label for="date">Date:</label>
          <input type="date">
          <label for="weather">Weather/Conditions:</label>
          <input type="text">
          <label for="notes">Notes:</label>
          <textarea cols="50" rows="10"></textarea>
      </form>
  </div>
</template>

<script>

export default {
    name: "create-trip",


}
</script>

<style>

</style>