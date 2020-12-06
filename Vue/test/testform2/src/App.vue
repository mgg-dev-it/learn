<template>
  <div id="app">
    <div class="w3-container w3-blue">
      <h2>Input Form</h2>
    </div>
    <div class="w3-container" style="border:0px solid blue">
      <div>
        <MagForm :fieldDefinitions="this.tableDefA" title="Input 1" @valuechanged="onValueChanged" @lostfocus="onLostFocus" @buttonpressed="onButtonPressed" :debug="debug"></MagForm>
        <div class="w3-container" style="border:0px solid red">
          <p>Value of test field 1: {{this.tableDefA[0].value}}</p>
          <p>Value of test field 2: {{this.tableDefA[1].value}}</p>
          <p>Value of test field 3: {{this.tableDefA[2].value}}</p>
        </div>
      </div>
    </div>
    <div class="w3-container" style="border:0px solid green">
      <div>
        <MagForm :fieldDefinitions="this.tableDefB" title="Input 2" @valuechanged="onValueChanged" @lostfocus="onLostFocus" @buttonpressed="onButtonPressed" :debug="debug"></MagForm>
        <div class="w3-container" style="border:0px solid red">
          <p>Value of test field b1: {{this.tableDefB[0].value}}</p>
          <p>Value of test field b2: {{this.tableDefB[1].value}}</p>
          <p>Value of test field b3: {{this.tableDefB[2].value}}</p>
        </div>
      </div>
    </div>
    <div class="w3-container" style="border:0px solid orange">
      <div>
        <MagForm :refresh="refresh" :fieldDefinitions="this.tableTest.getFields()" :buttonDefinitions="this.buttonDefA" title="Teszt form" @valuechanged="onValueChanged" @lostfocus="onLostFocus" @buttonpressed="onButtonPressed" :debug="debug"></MagForm>
        <div class="w3-container" style="border:0px solid red">
          <p>Value of test field t1: {{this.tableTest.getFields()[0].value}}</p>
          <p>Value of test field t2: {{this.tableTest.getFields()[1].value}}</p>
          <p>Value of test field t3: {{this.tableTest.getFields()[2].value}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import MagInput from "./components/MagInput.vue";
import MagForm from "./components/MagForm.vue";
import "@/assets/w3.css";
import { dbmixin } from "@/mixins/dbmixin.js";
import { controlmixin } from "@/mixins/controlmixin.js";

export default {
  mixins: [dbmixin, controlmixin],
  name: "app",
  components: {
    //MagInput,
    MagForm
  },
  data: function() {
    return {
      debug: false,
      //debug: true,
      refresh: false
    };
  },
  computed: {
    
  },
  beforeCreate: function() {
  },
  created: function() {
  },
  mounted: function() {
    //this.t = this.tableTest.getFields();
    // console.log(this.tableTest.getFields()[0].value);
    // console.log(this.tableTest.getFields()[1].value);
    // console.log(this.tableTest.getFields()[2].value);
  },
  methods: {
    onValueChanged(val, name) {
      if (this.debug) {
        console.log("onValueChanged " + name + " " + val);
      }
    },
    onLostFocus(val, name) {
      if (this.debug) {
        console.log("onLostFocus " + name + " " + val);
      }
    },
    onButtonPressed(name) {
      if (this.debug) {
        console.log("onButtonPressed " + name);
      }
      switch(name){
        case "btnLoad":
          this.tableTest.getFields()[0].value="ABC";
          this.tableTest.getFields()[1].value=123;
          this.tableTest.getFields()[2].value="2020/12/03";
          this.refresh=!this.refresh;
          break;
        case "btnSave":
          //this.refresh=!this.refresh;
          break;
        case "btnRefresh":
          //this.refresh=!this.refresh;
          break;
      }
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  /* color: red; */
  color: #2c3e50;
  /* margin-top: 60px; */
}
/* body{font-family:Verdana,sans-serif;font-size:12px;line-height:1.0} */
body{font-size:14px;line-height:1.0}
</style>
