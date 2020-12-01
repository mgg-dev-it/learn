import { fieldmixin } from "@/mixins/fieldmixin.js";
import { tablemixin } from "@/mixins/tablemixin.js";
export const dbmixin = {
    mixins: [tablemixin, fieldmixin],
    data() {
        return {
            f1 : new this.FieldDef("field1", "Field1", "text", "").setMaxLength(6).setUpperCase(true),
            f2 : new this.FieldDef("field2", "Field2", "int", "").setMaxLength(10),
            f3 : new this.FieldDef("field3", "Field3", "date", ""),
            fb1 : new this.FieldDef("fieldb1", "Fieldb1", "text", "").setMaxLength(4).setUpperCase(true),
            fb2 : new this.FieldDef("fieldb2", "Fieldb2", "int", "").setMaxLength(4),
            fb3 : new this.FieldDef("fieldb3", "Fieldb3", "date", ""),
            ft1 : new this.FieldDef("fieldt1", "Kód", "text", "").setMaxLength(3).setUpperCase(true),
            ft2 : new this.FieldDef("fieldt2", "Mennyiség", "int", "").setMaxLength(3),
            ft3 : new this.FieldDef("fieldt3", "Dátum", "date", "")
        }
    },
    computed: {
        tableDefA: function () {
            return ([this.f1, this.f2, this.f3])
        },
        tableDefB: function () {
            return ([this.fb1, this.fb2, this.fb3])
        },
        tableTest: function(){
            var t = new this.TableDef("test", "Test");
            // t.addField(new this.FieldDef("fieldt1", "text", "").setMaxLength(3).setUpperCase(true));
            // t.addField(new this.FieldDef("fieldt2", "int", "").setMaxLength(3));
            // t.addField(new this.FieldDef("fieldt3", "date", ""));
            t.addField(this.ft1);
            t.addField(this.ft2);
            t.addField(this.ft3);
            return(t);
        }
    }
    // methods: {
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
    // }
}