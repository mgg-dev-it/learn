import { fieldmixin } from "@/mixins/fieldmixin.js";
export const tablemixin = {
    mixins: [fieldmixin],
    data() {
        return {
            // f1: new this.FieldDef("field1", "text", "").setMaxLength(6).setUpperCase(true),
            // f2: new this.FieldDef("field2", "int", "").setMaxLength(10),
            // f3: new this.FieldDef("field3", "date", ""),
            // fb1: new this.FieldDef("fieldb1", "text", "").setMaxLength(4).setUpperCase(true),
            // fb2: new this.FieldDef("fieldb2", "int", "").setMaxLength(4),
            // fb3: new this.FieldDef("fieldb3", "date", "")
            //fff: new this.FieldDef("fff", "text", "")
        }
    },
    // computed: {
    //     tableDef: function () {
    //         return ([this.f1, this.f2, this.f3])
    //     },
    //     tableDefB: function () {
    //         return ([this.fb1, this.fb2, this.fb3])
    //     }
    // },
    methods: {
        TableDef: function (name, displayname) {
            this.name = name;
            this.displayname = displayname;
            this.fields = [];
            this.addField = function (field) {
                //if (field instanceof this.FieldDef) {
                //if (field instanceof this.fff) {
                //    console.log(typeof field);
                //if (typeof field == this.FieldDef) {
                    this.fields.push(field);
                //}
            };
            this.getFields = function (){
                return(this.fields);
            };
        }
        //     Person: function (first, last, age, eyecolor) {
        //         this.firstName = first;
        //         this.lastName = last;
        //         this.age = age;
        //         this.eyeColor = eyecolor;
        //         this.nationality = "English";
        //         this.name = function () { return this.firstName + " " + this.lastName; };
        //         this.changeName = function (name) {
        //             this.lastName = name;
        //         };
        //     },
        //     FieldDef22222: function (name, type, value) {
        //         this.name = name;
        //         this.type = type;
        //         this.value = value;
        //         this.upperCase = false;
        //         this.maxLength = -1;
        //         this.focused = false;
        //         this.setMaxLength = function (m) {
        //             this.maxLength = m;
        //             return (this);
        //         }
        //     }
    }
}