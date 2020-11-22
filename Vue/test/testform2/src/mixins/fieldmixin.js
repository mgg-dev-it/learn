export const fieldmixin = {
    data() {
        return {
            // f101 : new this.FieldDef("field101", "text", "").setMaxLength(6).setUpperCase(true),
            // f102 : new this.FieldDef("field102", "int", "").setMaxLength(10),
            // f103 : new this.FieldDef("field103", "date", ""),
        }
    },
    // computed: {
    //     tableDef: function () {
    //         return ([this.f101, this.f102, this.f103])
    //     }
    // },
    methods: {
        FieldDef: function (name, type, value) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.displayName = name;
            this.upperCase = false;
            this.maxLength = -1;
            this.focused = false;
            this.setMaxLength = function (m) {
                this.maxLength = m;
                return (this);
            }
            this.setUpperCase = function (u){
                this.upperCase = u;
                return (this);
            }
        }
    }
}