package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/ProtoId.class */
public final class ProtoId extends TableOfContents.Section.Item<ProtoId> {
    public int parametersOffset;
    public int returnTypeIndex;
    public int shortyIndex;

    public ProtoId(int i, int i2, int i3, int i4) {
        super(i);
        this.shortyIndex = i2;
        this.returnTypeIndex = i3;
        this.parametersOffset = i4;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return 12;
    }

    @Override // java.lang.Comparable
    public int compareTo(ProtoId protoId) {
        int uCompare = CompareUtils.uCompare(this.shortyIndex, protoId.shortyIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        int uCompare2 = CompareUtils.uCompare(this.returnTypeIndex, protoId.returnTypeIndex);
        return uCompare2 != 0 ? uCompare2 : CompareUtils.sCompare(this.parametersOffset, protoId.parametersOffset);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof ProtoId) {
            if (compareTo((ProtoId) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.shortyIndex), Integer.valueOf(this.returnTypeIndex), Integer.valueOf(this.parametersOffset));
    }
}
