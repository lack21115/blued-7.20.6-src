package com.android.dex;

import com.android.dex.Dex;
import com.android.dex.util.Unsigned;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/ProtoId.class */
public final class ProtoId implements Comparable<ProtoId> {
    private final Dex dex;
    private final int parametersOffset;
    private final int returnTypeIndex;
    private final int shortyIndex;

    public ProtoId(Dex dex, int i, int i2, int i3) {
        this.dex = dex;
        this.shortyIndex = i;
        this.returnTypeIndex = i2;
        this.parametersOffset = i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(ProtoId protoId) {
        return this.returnTypeIndex != protoId.returnTypeIndex ? Unsigned.compare(this.returnTypeIndex, protoId.returnTypeIndex) : Unsigned.compare(this.parametersOffset, protoId.parametersOffset);
    }

    public int getParametersOffset() {
        return this.parametersOffset;
    }

    public int getReturnTypeIndex() {
        return this.returnTypeIndex;
    }

    public int getShortyIndex() {
        return this.shortyIndex;
    }

    public String toString() {
        return this.dex == null ? this.shortyIndex + " " + this.returnTypeIndex + " " + this.parametersOffset : this.dex.strings().get(this.shortyIndex) + ": " + this.dex.typeNames().get(this.returnTypeIndex) + " " + this.dex.readTypeList(this.parametersOffset);
    }

    public void writeTo(Dex.Section section) {
        section.writeInt(this.shortyIndex);
        section.writeInt(this.returnTypeIndex);
        section.writeInt(this.parametersOffset);
    }
}
