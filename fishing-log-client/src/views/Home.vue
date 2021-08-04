<template>
  <div class="home">
    <h1>Home</h1>
    <h1>Welcom back, {{$store.state.user.username}}</h1>
    <router-link v-bind:to="{ name: 'trips' }">View Trips</router-link> | 
    <router-link v-bind:to="{ name: 'add-trip' }">Add a Trip</router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
