package com.android.dex;

import com.android.dex.Dex;
import com.android.dex.util.Unsigned;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/MethodId.class */
public final class MethodId implements Comparable<MethodId> {
    private final int declaringClassIndex;
    private final Dex dex;
    private final int nameIndex;
    private final int protoIndex;

    public MethodId(Dex dex, int i, int i2, int i3) {
        this.dex = dex;
        this.declaringClassIndex = i;
        this.protoIndex = i2;
        this.nameIndex = i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(MethodId methodId) {
        return this.declaringClassIndex != methodId.declaringClassIndex ? Unsigned.compare(this.declaringClassIndex, methodId.declaringClassIndex) : this.nameIndex != methodId.nameIndex ? Unsigned.compare(this.nameIndex, methodId.nameIndex) : Unsigned.compare(this.protoIndex, methodId.protoIndex);
    }

    public int getDeclaringClassIndex() {
        return this.declaringClassIndex;
    }

    public int getNameIndex() {
        return this.nameIndex;
    }

    public int getProtoIndex() {
        return this.protoIndex;
    }

    public String toString() {
        return this.dex == null ? this.declaringClassIndex + " " + this.protoIndex + " " + this.nameIndex : this.dex.typeNames().get(this.declaringClassIndex) + "." + this.dex.strings().get(this.nameIndex) + this.dex.readTypeList(this.dex.protoIds().get(this.protoIndex).getParametersOffset());
    }

    public void writeTo(Dex.Section section) {
        section.writeUnsignedShort(this.declaringClassIndex);
        section.writeUnsignedShort(this.protoIndex);
        section.writeInt(this.nameIndex);
    }
}
