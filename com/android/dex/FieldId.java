package com.android.dex;

import com.android.dex.Dex;
import com.android.dex.util.Unsigned;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/FieldId.class */
public final class FieldId implements Comparable<FieldId> {
    private final int declaringClassIndex;
    private final Dex dex;
    private final int nameIndex;
    private final int typeIndex;

    public FieldId(Dex dex, int i, int i2, int i3) {
        this.dex = dex;
        this.declaringClassIndex = i;
        this.typeIndex = i2;
        this.nameIndex = i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldId fieldId) {
        return this.declaringClassIndex != fieldId.declaringClassIndex ? Unsigned.compare(this.declaringClassIndex, fieldId.declaringClassIndex) : this.nameIndex != fieldId.nameIndex ? Unsigned.compare(this.nameIndex, fieldId.nameIndex) : Unsigned.compare(this.typeIndex, fieldId.typeIndex);
    }

    public int getDeclaringClassIndex() {
        return this.declaringClassIndex;
    }

    public int getNameIndex() {
        return this.nameIndex;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public String toString() {
        return this.dex == null ? this.declaringClassIndex + " " + this.typeIndex + " " + this.nameIndex : this.dex.typeNames().get(this.typeIndex) + "." + this.dex.strings().get(this.nameIndex);
    }

    public void writeTo(Dex.Section section) {
        section.writeUnsignedShort(this.declaringClassIndex);
        section.writeUnsignedShort(this.typeIndex);
        section.writeInt(this.nameIndex);
    }
}
