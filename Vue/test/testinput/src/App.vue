<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <div class="w3-container w3-blue">
      <h3>Input Form</h3>
    </div>

    <form class="w3-container">
      <!-- <div class="w3-row">
        <div class="w3-col m1 w3-center w3-grey">1</div>
        <div class="w3-col m1 w3-center">2</div>
        <div class="w3-col m1 w3-center w3-grey">3</div>
        <div class="w3-col m1 w3-center">4</div>
        <div class="w3-col m1 w3-center w3-grey">5</div>
        <div class="w3-col m1 w3-center">6</div>
        <div class="w3-col m1 w3-center w3-grey">7</div>
        <div class="w3-col m1 w3-center">8</div>
        <div class="w3-col m1 w3-center w3-grey">9</div>
        <div class="w3-col m1 w3-center">10</div>
        <div class="w3-col m1 w3-center w3-grey">11</div>
        <div class="w3-col m1 w3-center">12</div>
      </div>-->
      <div class="w3-row">
        <!-- <div class="w3-col w3-container m4 l3 w3-yellow">
          <p>This part will occupy 12 columns on a small screen, 4 on a medium screen, and 3 on a large screen.</p>
        </div>
        <div class="w3-col w3-container m8 l9">
          <p>This part will occupy 12 columns on a small screen, 8 on a medium screen, and 9 on a large screen.</p>
          <p>This part will occupy 12 columns on a small screen, 8 on a medium screen, and 9 on a large screen.</p>
        </div>-->
        <!-- </div>
        <div class="w3-row">-->
        <div class="w3-col w3-container m4 l3 w3-aqua">
          <!-- <p> -->
          <label class="w3-text-blue">Test field 01: {{this.fieldDef1.typ}}</label>
          <MagInput
            msg="MagInput test1"
            :fieldDef="fieldDef1"
            @valuechanged="onValueChanged"
            :debug="debug"
          ></MagInput>
          <!-- </p> -->
        </div>
        <!-- </div>
        <div class="w3-row">-->
        <div class="w3-col w3-container m4 l3 w3-aqua">
          <!-- <p> -->
          <label class="w3-text-blue">Test field 02: {{this.fieldDef2.typ}}</label>
          <MagInput
            msg="MagInput test2"
            :fieldDef="fieldDef2"
            @valuechanged="onValueChanged"
            :debug="debug"
          ></MagInput>
          <!-- </p> -->
        </div>
        <!-- </div>
        <div class="w3-row">-->
        <div class="w3-col w3-container m4 l3 w3-aqua">
          <!-- <p> -->
          <label class="w3-text-blue">Test field 03: {{this.fieldDef3.typ}}</label>
          <MagInput
            msg="MagInput test3"
            :fieldDef="fieldDef3"
            @valuechanged="onValueChanged"
            :debug="debug"
          ></MagInput>
          <!-- </p> -->
        </div>
      </div>
      <div class="w3-row">
        <div class="w3-col w3-container m4 l3 w3-aqua">
          <p>Value of test field 01: {{fieldDef1.value}}</p>
        </div>
        <div class="w3-col w3-container m4 l3 w3-aqua">
          <p>Value of test field 02: {{fieldDef2.value}}</p>
        </div>
        <div class="w3-col w3-container m4 l3 w3-aqua">
          <p>Value of test field 03: {{fieldDef3.value}}</p>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
//import HelloWorld from "./components/HelloWorld.vue";
import MagInput from "./components/MagInput.vue";
import "@/assets/w3.css";
var mapFields = new Map();

export default {
  name: "app",
  components: {
    //HelloWorld,
    MagInput
  },
  data() {
    return {
      debug: false,
      //debug: true,
      // value1: "",
      // value2: "",
      // value3: "",
      fieldDef1: {
        name: "field1",
        type: "text",
        value: "",
        upperCase: true,
        maxLength: 5,
        focused: true
      },
      fieldDef2: {
        name: "field2",
        type: "int",
        value: "",
        //upperCase: true,
        maxLength: 10
        //focused: true
      },
      fieldDef3: {
        name: "field3",
        type: "date",
        value: "",
        upperCase: false,
        maxLength: -1
      }
    };
  },
  beforeCreate() {},
  created() {
    mapFields.set(this.fieldDef1.name, this.fieldDef1);
    mapFields.set(this.fieldDef2.name, this.fieldDef2);
    mapFields.set(this.fieldDef3.name, this.fieldDef3);
  },
  methods: {
    onValueChanged(val, name) {
      if (this.debug) {
        console.log("onValueChanged " + name + " " + val);
      }
      var f = mapFields.get(name);
      f.value = val;
      // switch (name) {
      //   case "field1":
      //     this.value1 = val;
      //     break;
      //   case "field2":
      //     this.value2 = val;
      //     break;
      //   case "field3":
      //     this.value3 = val;
      //     break;
      // }
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
