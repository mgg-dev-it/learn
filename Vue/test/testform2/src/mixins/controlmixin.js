export const controlmixin = {
    data() {
        return {
            bLoad : new this.ButtonDef("btnLoad", "Load"),
            bSave : new this.ButtonDef("btnSave", "Save"),
            bRefresh : new this.ButtonDef("btnRefresh", "Refresh"),
            bClear : new this.ButtonDef("btnClear", "Clear")
        }
    },
    computed: {
        buttonDefA: function () {
            return ([this.bLoad, this.bSave, this.bRefresh, this.bClear]);
        }
    },
    methods: {
        ButtonDef: function (name, displayText) {
            this.name = name;
            this.displayText = displayText;
        }
    }
}