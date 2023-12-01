package com.android.dex;

import com.android.dex.util.Unsigned;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/TypeList.class */
public final class TypeList implements Comparable<TypeList> {
    public static final TypeList EMPTY = new TypeList(null, Dex.EMPTY_SHORT_ARRAY);
    private final Dex dex;
    private final short[] types;

    public TypeList(Dex dex, short[] sArr) {
        this.dex = dex;
        this.types = sArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(TypeList typeList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.types.length || i2 >= typeList.types.length) {
                break;
            } else if (this.types[i2] != typeList.types[i2]) {
                return Unsigned.compare(this.types[i2], typeList.types[i2]);
            } else {
                i = i2 + 1;
            }
        }
        return Unsigned.compare(this.types.length, typeList.types.length);
    }

    public short[] getTypes() {
        return this.types;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int length = this.types.length;
        for (int i = 0; i < length; i++) {
            sb.append(this.dex != null ? this.dex.typeNames().get(this.types[i]) : Short.valueOf(this.types[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}
