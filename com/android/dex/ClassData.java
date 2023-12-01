package com.android.dex;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/ClassData.class */
public final class ClassData {
    private final Method[] directMethods;
    private final Field[] instanceFields;
    private final Field[] staticFields;
    private final Method[] virtualMethods;

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/ClassData$Field.class */
    public static class Field {
        private final int accessFlags;
        private final int fieldIndex;

        public Field(int i, int i2) {
            this.fieldIndex = i;
            this.accessFlags = i2;
        }

        public int getAccessFlags() {
            return this.accessFlags;
        }

        public int getFieldIndex() {
            return this.fieldIndex;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:com/android/dex/ClassData$Method.class */
    public static class Method {
        private final int accessFlags;
        private final int codeOffset;
        private final int methodIndex;

        public Method(int i, int i2, int i3) {
            this.methodIndex = i;
            this.accessFlags = i2;
            this.codeOffset = i3;
        }

        public int getAccessFlags() {
            return this.accessFlags;
        }

        public int getCodeOffset() {
            return this.codeOffset;
        }

        public int getMethodIndex() {
            return this.methodIndex;
        }
    }

    public ClassData(Field[] fieldArr, Field[] fieldArr2, Method[] methodArr, Method[] methodArr2) {
        this.staticFields = fieldArr;
        this.instanceFields = fieldArr2;
        this.directMethods = methodArr;
        this.virtualMethods = methodArr2;
    }

    public Field[] allFields() {
        Field[] fieldArr = new Field[this.staticFields.length + this.instanceFields.length];
        System.arraycopy(this.staticFields, 0, fieldArr, 0, this.staticFields.length);
        System.arraycopy(this.instanceFields, 0, fieldArr, this.staticFields.length, this.instanceFields.length);
        return fieldArr;
    }

    public Method[] allMethods() {
        Method[] methodArr = new Method[this.directMethods.length + this.virtualMethods.length];
        System.arraycopy(this.directMethods, 0, methodArr, 0, this.directMethods.length);
        System.arraycopy(this.virtualMethods, 0, methodArr, this.directMethods.length, this.virtualMethods.length);
        return methodArr;
    }

    public Method[] getDirectMethods() {
        return this.directMethods;
    }

    public Field[] getInstanceFields() {
        return this.instanceFields;
    }

    public Field[] getStaticFields() {
        return this.staticFields;
    }

    public Method[] getVirtualMethods() {
        return this.virtualMethods;
    }
}
