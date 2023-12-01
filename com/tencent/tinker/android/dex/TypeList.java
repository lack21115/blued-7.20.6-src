package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/TypeList.class */
public final class TypeList extends TableOfContents.Section.Item<TypeList> {
    public static final TypeList EMPTY = new TypeList(0, Dex.EMPTY_SHORT_ARRAY);
    public short[] types;

    public TypeList(int i, short[] sArr) {
        super(i);
        this.types = sArr;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (this.types.length * 2) + 4;
    }

    @Override // java.lang.Comparable
    public int compareTo(TypeList typeList) {
        return CompareUtils.uArrCompare(this.types, typeList.types);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof TypeList) {
            if (compareTo((TypeList) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.types);
    }
}
