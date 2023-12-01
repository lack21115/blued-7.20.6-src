package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STFaceAttribute.class */
public class STFaceAttribute {
    Attribute[] arrayAttribute;
    int attribute_count;

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STFaceAttribute$Attribute.class */
    public static class Attribute {
        String category;
        String label;
        float score;

        public String getCategory() {
            return this.category;
        }

        public String getLabel() {
            return this.label;
        }

        public float getScore() {
            return this.score;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public void setScore(float f) {
            this.score = f;
        }
    }

    public static String getFaceAttributeString(STFaceAttribute sTFaceAttribute) {
        String str = null;
        String str2 = "";
        int i = 0;
        String str3 = "男";
        while (true) {
            Attribute[] attributeArr = sTFaceAttribute.arrayAttribute;
            if (i >= attributeArr.length) {
                return "颜值:" + str + "  性别:" + str3 + "  年龄:" + str2;
            }
            if (attributeArr[i].category.equals("attractive")) {
                str = sTFaceAttribute.arrayAttribute[i].label;
            }
            if (sTFaceAttribute.arrayAttribute[i].category.equals("gender")) {
                str3 = sTFaceAttribute.arrayAttribute[i].label.equals("male") ? "男" : "女";
            }
            if (sTFaceAttribute.arrayAttribute[i].category.equals("age")) {
                str2 = sTFaceAttribute.arrayAttribute[i].label;
            }
            i++;
        }
    }

    public static boolean isMale(STFaceAttribute sTFaceAttribute) {
        int i = 0;
        boolean z = false;
        while (true) {
            Attribute[] attributeArr = sTFaceAttribute.arrayAttribute;
            if (i >= attributeArr.length) {
                return z;
            }
            if (attributeArr[i].category.equals("gender")) {
                z = sTFaceAttribute.arrayAttribute[i].label.equals("male");
            }
            i++;
        }
    }

    public Attribute[] getArrayAttribute() {
        return this.arrayAttribute;
    }

    public int getAttributeCount() {
        return this.attribute_count;
    }

    public void setArrayAttribute(Attribute[] attributeArr) {
        this.arrayAttribute = attributeArr;
    }

    public void setAttributeCount(int i) {
        this.attribute_count = i;
    }
}
