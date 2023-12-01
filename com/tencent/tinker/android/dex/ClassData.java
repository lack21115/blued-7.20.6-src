package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/ClassData.class */
public final class ClassData extends TableOfContents.Section.Item<ClassData> {
    public Method[] directMethods;
    public Field[] instanceFields;
    public Field[] staticFields;
    public Method[] virtualMethods;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/ClassData$Field.class */
    public static class Field implements Comparable<Field> {
        public int accessFlags;
        public int fieldIndex;

        public Field(int i, int i2) {
            this.fieldIndex = i;
            this.accessFlags = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Field field) {
            int uCompare = CompareUtils.uCompare(this.fieldIndex, field.fieldIndex);
            return uCompare != 0 ? uCompare : CompareUtils.sCompare(this.accessFlags, field.accessFlags);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Field) {
                if (compareTo((Field) obj) == 0) {
                    z = true;
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            return HashCodeHelper.hash(Integer.valueOf(this.fieldIndex), Integer.valueOf(this.accessFlags));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/ClassData$Method.class */
    public static class Method implements Comparable<Method> {
        public int accessFlags;
        public int codeOffset;
        public int methodIndex;

        public Method(int i, int i2, int i3) {
            this.methodIndex = i;
            this.accessFlags = i2;
            this.codeOffset = i3;
        }

        @Override // java.lang.Comparable
        public int compareTo(Method method) {
            int uCompare = CompareUtils.uCompare(this.methodIndex, method.methodIndex);
            if (uCompare != 0) {
                return uCompare;
            }
            int sCompare = CompareUtils.sCompare(this.accessFlags, method.accessFlags);
            return sCompare != 0 ? sCompare : CompareUtils.sCompare(this.codeOffset, method.codeOffset);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Method) {
                if (compareTo((Method) obj) == 0) {
                    z = true;
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            return HashCodeHelper.hash(Integer.valueOf(this.methodIndex), Integer.valueOf(this.accessFlags), Integer.valueOf(this.codeOffset));
        }
    }

    public ClassData(int i, Field[] fieldArr, Field[] fieldArr2, Method[] methodArr, Method[] methodArr2) {
        super(i);
        this.staticFields = fieldArr;
        this.instanceFields = fieldArr2;
        this.directMethods = methodArr;
        this.virtualMethods = methodArr2;
    }

    private int calcFieldsSize(Field[] fieldArr) {
        int length = fieldArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i >= length) {
                return i2;
            }
            Field field = fieldArr[i];
            int i5 = field.fieldIndex;
            i3 = field.fieldIndex;
            i2 += Leb128.unsignedLeb128Size(i5 - i4) + Leb128.unsignedLeb128Size(field.accessFlags);
            i++;
        }
    }

    private int calcMethodsSize(Method[] methodArr) {
        int length = methodArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i >= length) {
                return i2;
            }
            Method method = methodArr[i];
            int i5 = method.methodIndex;
            i3 = method.methodIndex;
            i2 += Leb128.unsignedLeb128Size(i5 - i4) + Leb128.unsignedLeb128Size(method.accessFlags) + Leb128.unsignedLeb128Size(method.codeOffset);
            i++;
        }
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return Leb128.unsignedLeb128Size(this.staticFields.length) + Leb128.unsignedLeb128Size(this.instanceFields.length) + Leb128.unsignedLeb128Size(this.directMethods.length) + Leb128.unsignedLeb128Size(this.virtualMethods.length) + calcFieldsSize(this.staticFields) + calcFieldsSize(this.instanceFields) + calcMethodsSize(this.directMethods) + calcMethodsSize(this.virtualMethods);
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassData classData) {
        int aArrCompare = CompareUtils.aArrCompare(this.staticFields, classData.staticFields);
        if (aArrCompare != 0) {
            return aArrCompare;
        }
        int aArrCompare2 = CompareUtils.aArrCompare(this.instanceFields, classData.instanceFields);
        if (aArrCompare2 != 0) {
            return aArrCompare2;
        }
        int aArrCompare3 = CompareUtils.aArrCompare(this.directMethods, classData.directMethods);
        return aArrCompare3 != 0 ? aArrCompare3 : CompareUtils.aArrCompare(this.virtualMethods, classData.virtualMethods);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof ClassData) {
            if (compareTo((ClassData) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(this.staticFields, this.instanceFields, this.directMethods, this.virtualMethods);
    }
}
