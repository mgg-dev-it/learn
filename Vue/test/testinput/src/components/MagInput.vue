<template>
  <div id="maginputdiv">
    <!-- <h1>{{ msg }}</h1> -->
    <input
      type="text"
      v-model="cv"
      @blur="onBlur"
      @keydown="onKeyDown"
      @keypress="onKeyPress"
      @keyup="onKeyUp"
      @input="onInput"
      placeholder="type here"
      class="w3-input w3-border w3-round-large"
      ref="refinput"
      :inputmode="inputMode"
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
      prevcvd: "",
      inputMode: ""
    };
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
        if (this.cvd != this.prevcvd) {
          this.raiseEventValueChanged();
        }
        this.prevcvd = this.cvd;
      }
    }
  },
  beforeCreate() {},
  created: function() {
    if (this.fieldDef.type == "date" || this.fieldDef.type == "int") {
      this.inputMode = "decimal";
    }
    this.cvd = this.fieldDef.value;
    if (this.fieldDef.upperCase) {
      this.cvd = this.cvd.toUpperCase();
    }
  },
  mounted: function() {
    //this.$emit("valuechanged", this.cvd, this.fieldDef.name);
    this.raiseEventValueChanged();
    if (this.fieldDef.focused) {
      //this.$refs[“ref-input”].setFocus();
      //console.log(this.$refs);
      //console.log(this.$refs.refinput);
      this.$refs.refinput.focus();
    }
  },
  methods: {
    raiseEventValueChanged() {
      this.$emit("valuechanged", this.cvd, this.fieldDef.name);
    },
    formatInt(val) {
      var s = this.cv.replace(/\D/g, "");
      var l = s.length;
      var t = 0;
      var r = "";
      //for (var i = l; i--; i > 0) {
      for (var i = l; i > 0; i--) {
        r = s.substring(i - 1, i) + r;
        ++t;
        if (t == 3) {
          r = " " + r;
          t = 0;
        }
      }
      return r;
    },
    onInput(event) {
      if (this.debug) {
        console.log("onInput data " + event.data);
        console.log("onInput inputType " + event.inputType);
        console.log("onInput isComposing " + event.isComposing);
      }
    },
    onBlur(event) {
      //because of IME composition mode ...
      if (
        this.fieldDef.maxLength > 0 &&
        this.cvd.length >= this.fieldDef.maxLength
      ) {
        this.cv = this.cv.substring(0, this.fieldDef.maxLength);
      }
      if (this.fieldDef.type == "date") {
        //this.cv = "123";
        var s = this.cv.replace(/\D/g, "");
        var d = new Date();
        var sYear = String(d.getFullYear());
        var sMonth = String(d.getMonth() + 1);
        if (sMonth.length == 1) {
          sMonth = "0" + sMonth;
        }
        var sDay = String(d.getDate());
        if (sDay.length == 1) {
          sDay = "0" + sDay;
        }
        var dd = sYear + sMonth + sDay;
        if (s.length == 1) {
          s = "0" + s;
        }
        if (s.length == 3) {
          s = "0" + s;
        }
        if (s.length > 0) {
          dd = dd.substring(0, 8 - s.length) + s;
        }
        //s = dd;
        //this.cv = s;
        var sDateSeparator = "/";
        this.cv =
          dd.substring(0, 4) +
          sDateSeparator +
          dd.substring(4, 6) +
          sDateSeparator +
          dd.substring(6, 8);
      }
      if (this.fieldDef.type == "int") {
        this.cv = this.formatInt(this.cv);
      }
    },
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
        console.log("onKeyPress " + event.key);
        console.log("selectionStart = " + this.$refs.refinput.selectionStart);
        console.log("selectionEnd = " + this.$refs.refinput.selectionEnd);
      }
      if (
        this.fieldDef.maxLength > 0 &&
        this.cvd.length >= this.fieldDef.maxLength &&
        this.$refs.refinput.selectionEnd - this.$refs.refinput.selectionStart <
          1
      ) {
        event.preventDefault();
      }
      if (this.fieldDef.type == "date") {
        if ("1234567890/.-".indexOf(event.key) < 0) {
          event.preventDefault();
        }
      }
      if (this.fieldDef.type == "int") {
        if ("1234567890".indexOf(event.key) < 0) {
          event.preventDefault();
        }
        //this.cv = this.formatInt(this.cv);
      }
    },
    onKeyUp(event) {
      if (this.debug) {
        console.log("onKeyUp " + event.key);
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