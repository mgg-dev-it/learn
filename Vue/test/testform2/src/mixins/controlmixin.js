export const controlmixin = {
    data() {
        return {
            b1 : new this.ButtonDef("button1", "Button1"),
            b2 : new this.ButtonDef("button2", "Button2")
        }
    },
    computed: {
        buttonDefA: function () {
            return ([this.b1, this.b2])
        }
    },
    methods: {
        ButtonDef: function (name, displayText) {
            this.name = name;
            this.displayText = displayText;
        }
    }
}