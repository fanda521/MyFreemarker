package com.wang.autocode;

public enum FieldTypeEnum {
    //INT java.long.Interger  VARCHAR java.lang.String  FLOAT java.lang.Float TIMESTAMP java.util.Date
    INT {
        public  String getValue(){
            return "java.lang.Integer";
        }
    },VARCHAR {
        public  String getValue(){
            return "java.lang.String";
        }
    },FLOAT {
        public  String getValue(){
            return "java.lang.Float";
        }
    },
    DOUBLE {
        public  String getValue(){
            return "java.lang.Double";
        }
    },TIMESTAMP {
        public  String getValue(){
            return "java.util.Date";
        }
    };
    public abstract String getValue();
}
