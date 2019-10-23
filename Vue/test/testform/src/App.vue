<template>
  <div id="app">
    <div class="w3-container w3-blue">
      <h2>Input Form</h2>
    </div>
    <div class="w3-container w3-half">
      <form class="w3-container">
        <p>
          <label class="w3-text-blue">Test field 001: {{this.f1.type}}</label>
          <MagInput2 :fDef="f1" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
        </p>
        <p>
          <label class="w3-text-blue">Test field 002: {{this.f2.type}}</label>
          <MagInput2 :fDef="f2" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
        </p>
        <p>
          <label class="w3-text-blue">Test field 003: {{this.f3.type}}</label>
          <MagInput2 :fDef="f3" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
        </p>
      </form>

      <div class="w3-container w3-light-blue">
        <p>Value of test field 001: {{f1.value}}</p>
        <p>Value of test field 002: {{f2.value}}</p>
        <p>Value of test field 003: {{f3.value}}</p>
      </div>
    </div>

    <div class="w3-container w3-half">
      <div>
        <MagForm :fieldDefinitions="fa" :debug="debug"></MagForm>
      </div>
    </div>
  </div>
</template>

<script>
import MagInput2 from "./components/MagInput2.vue";
import MagForm from "./components/MagForm.vue";
import "@/assets/w3.css";
import { dbmixin } from "@/mixins/dbmixin.js";

var mapFields = new Map();

export default {
  mixins: [dbmixin],
  name: "app",
  components: {
    MagInput2,
    MagForm
  },
  data() {
    return {
      debug: false,
      //debug: true,
      // value1: "",
      // value2: "",
      // value3: "",
      //person: this.Person,
      f1: this.FieldDef,
      f2: this.FieldDef,
      f3: this.FieldDef,
      f11: this.FieldDef,
      f12: this.FieldDef,
      f13: this.FieldDef,
      fa: [this.f11, this.f12, this.f13]
      // fieldDef1: {
      //   name: "field1",
      //   type: "text",
      //   value: "",
      //   upperCase: true,
      //   maxLength: 5,
      //   focused: true
      // },
      // fieldDef2: {
      //   name: "field2",
      //   type: "int",
      //   value: "",
      //   //upperCase: true,
      //   maxLength: 10
      //   //focused: true
      // },
      // fieldDef3: {
      //   name: "field3",
      //   type: "date",
      //   value: "",
      //   upperCase: false,
      //   maxLength: -1
      // }
    };
  },
  beforeCreate: function() {
    //console.log("App beforeCreate");
  },
  created: function() {
    //console.log("App created");
    //mapFields.set(this.fieldDef1.name, this.fieldDef1);
    //mapFields.set(this.fieldDef2.name, this.fieldDef2);
    //mapFields.set(this.fieldDef3.name, this.fieldDef3);
    //this.person = new this.Person("first", "last", 99, "blue");
    this.f1 = new this.FieldDef("field01", "text", "");
    this.f1.upperCase = true;
    this.f1.maxLength = 5;
    this.f1.focused = true;
    this.f2 = new this.FieldDef("field02", "int", "");
    this.f2.maxLength = 10;
    this.f3 = new this.FieldDef("field03", "date", "");
    mapFields.set(this.f1.name, this.f1);
    mapFields.set(this.f2.name, this.f2);
    mapFields.set(this.f3.name, this.f3);

    this.f11 = new this.FieldDef("field11", "text", "");
    this.f11.upperCase = true;
    this.f11.maxLength = 5;
    this.f11.focused = true;
    this.f12 = new this.FieldDef("field12", "int", "");
    this.f12.maxLength = 10;
    this.f13 = new this.FieldDef("field13", "date", "");
    mapFields.set(this.f11.name, this.f11);
    mapFields.set(this.f12.name, this.f12);
    mapFields.set(this.f13.name, this.f13);
    this.fa = [this.f11, this.f12, this.f13];
    //console.log(this.f11);
    //console.log("App created end");
  },
  mounted: function() {
    //console.log("App mounted");
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
    }
    // onValueChanged1(val, name) {
    //   if (this.debug) {
    //     console.log("onValueChanged1 " + name + " " + val);
    //   }
    //   this.value1 = val;
    // },
    // onValueChanged2(val, name) {
    //   if (this.debug) {
    //     console.log("onValueChanged2 " + name + " " + val);
    //   }
    //   this.value2 = val;
    // },
    // onValueChanged3(val, name) {
    //   if (this.debug) {
    //     console.log("onValueChanged3 " + name + " " + val);
    //   }
    //   this.value3 = val;
    // }
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
</style>
