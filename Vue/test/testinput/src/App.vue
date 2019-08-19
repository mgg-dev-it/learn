<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <div class="w3-container w3-blue">
      <h2>Input Form</h2>
    </div>

    <form class="w3-container">
      <p>
        <label class="w3-text-blue">Test field 01:</label>
        <MagInput
          msg="MagInput test1"
          :fieldDef="fieldDef1"
          @valuechanged="onValueChanged"
          :debug="debug"
        ></MagInput>
      </p>
      <p>
        <label class="w3-text-blue">Test field 02:</label>
        <MagInput
          msg="MagInput test2"
          :fieldDef="fieldDef2"
          @valuechanged="onValueChanged"
          :debug="debug"
        ></MagInput>
      </p>
      <p>
        <label class="w3-text-blue">Test field 03:</label>
        <MagInput
          msg="MagInput test3"
          :fieldDef="fieldDef3"
          @valuechanged="onValueChanged"
          :debug="debug"
        ></MagInput>
      </p>
      <p>Value of test field 01: {{value1}}</p>
      <p>Value of test field 02: {{value2}}</p>
      <p>Value of test field 03: {{value3}}</p>
    </form>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import MagInput from "./components/MagInput.vue";
import "@/assets/w3.css";

export default {
  name: "app",
  components: {
    //HelloWorld,
    MagInput
  },
  data() {
    return {
      //debug: false,
      debug: true,
      value1: "",
      value2: "",
      value3: "",
      fieldDef1: {
        name: "field1",
        typ: "",
        value: "ab",
        upperCase: true,
        maxLength: 5,
        focused: true
      },
      fieldDef2: {
        name: "field2",
        typ: "",
        value: "f1",
        upperCase: true,
        maxLength: 5
        //focused: true
      },
      fieldDef3: {
        name: "field3",
        typ: "date",
        value: "",
        upperCase: false,
        maxLength: -1
      }
    };
  },
  methods: {
    onValueChanged(val, name) {
      if (this.debug) {
        console.log("onValueChanged " + name + " " + val);
      }
      switch (name) {
        case "field1":
          this.value1 = val;
          break;
        case "field2":
          this.value2 = val;
          break;
        case "field3":
          this.value3 = val;
          break;
      }
    },
    onValueChanged1(val, name) {
      if (this.debug) {
        console.log("onValueChanged1 " + name + " " + val);
      }
      this.value1 = val;
    },
    onValueChanged2(val, name) {
      if (this.debug) {
        console.log("onValueChanged2 " + name + " " + val);
      }
      this.value2 = val;
    },
    onValueChanged3(val, name) {
      if (this.debug) {
        console.log("onValueChanged3 " + name + " " + val);
      }
      this.value3 = val;
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
  /*margin-top: 60px;*/
}
</style>
