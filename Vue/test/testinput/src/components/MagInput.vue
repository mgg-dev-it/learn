<template>
  <div id="maginputdiv">
    <!-- <h1>{{ msg }}</h1> -->
    <input
      type="text"
      v-model="cv"
      @keydown="onKeyDown"
      @keypress="onKeyPress"
      @keyup="onKeyUp"
      placeholder="type here"
      class="w3-input w3-border w3-round-large"
      ref="refinput"
    />
    <!-- <p>Input value is: {{ cv }}</p> -->
  </div>
</template>

<script>
export default {
  name: "MagInput",
  props: {
    //msg: String,
    fieldDef: Object,
    debug: Boolean
  },
  data() {
    return {
      inputvalue: "",
      cvd: "",
      prevcvd: ""
    };
  },
  created: function() {
    this.cvd = this.fieldDef.value;
    if (this.fieldDef.upperCase) {
      this.cvd = this.cvd.toUpperCase();
    }
  },
  computed: {
    cv: {
      get() {
        return this.cvd;
      },
      set(val) {
        this.cvd = val;
        if (this.fieldDef.upperCase) {
          this.cvd = val.toUpperCase();
        }
      }
    }
  },
  mounted: function() {
    this.$emit("valuechanged", this.cvd, this.fieldDef.name);
    if (this.fieldDef.focused){
      //this.$refs[“ref-input”].setFocus();
      console.log(this.$refs);
      console.log(this.$refs.refinput);
      this.$refs.refinput.focus();
    }
  },
  methods: {
    onKeyDown(event) {
      if (this.debug) {
        // console.log("onKeyDown "+event.target.value);
        console.log("onKeyDown key " + event.key);
        console.log("onKeyDown keyCode " + event.keyCode);
        //console.log("onKeyDown altKey " + event.altKey);
        //console.log("onKeyDown ctrlKey " + event.ctrlKey);
        //console.log("onKeyDown metaKey " + event.metaKey);
        //console.log("onKeyDown shiftKey " + event.shiftKey);
      }
    },
    onKeyPress(event) {
      if (this.debug) {
        //console.log("onKeyPress "+event.target.value);
        console.log("onKeyPress " + event.key);
      }
      if (
        this.fieldDef.maxLength > 0 &&
        this.cvd.length >= this.fieldDef.maxLength
      ) {
        //if (event.keyCode > 31) {
          event.preventDefault();
        //}
      }
      if (this.fieldDef.typ == "date") {
        // if (
        //   event.keyCode < 48 ||
        //   event.keyCode > 57 ||
        //   event.altKey ||
        //   event.ctrlKey ||
        //   event.metaKey ||
        //   event.shiftKey
        // ) {
        //   event.preventDefault();
        // }
        if ("1234567890/.-".indexOf(event.key) < 0) {
          event.preventDefault();
        }
      }
    },
    onKeyUp(event) {
      if (this.debug) {
        //console.log("onKeyUp "+event.target.value);
        console.log("onKeyUp " + event.key);
      }
      //this.inputvalue = this.inputvalue.toUpperCase();
      //this.$emit("valuechanged", event.target.value);
      if (this.cvd != this.prevcvd) {
        if (this.debug) {
          console.log(
            "this.cvd - this.prevcvd : " + this.cvd + " " + this.prevcvd
          );
        }
        this.$emit("valuechanged", this.cvd, this.fieldDef.name);
      }
      this.prevcvd = this.cvd;
    }
  },
  directives: {
    uppercase: {
      update: function(el) {
        el.value = el.value.toUpperCase();
      }
    }
  }
};
</script>

<style scoped>
/* #maginputdiv {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  background-color: lightskyblue;
  padding: 5px;
} */
input:focus {
  background-color: yellow;
}
</style>