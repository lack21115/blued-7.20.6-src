package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/AnnotationSet.class */
public class AnnotationSet extends TableOfContents.Section.Item<AnnotationSet> {
    public int[] annotationOffsets;

    public AnnotationSet(int i, int[] iArr) {
        super(i);
        this.annotationOffsets = iArr;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (this.annotationOffsets.length + 1) * 4;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnnotationSet annotationSet) {
        int length = this.annotationOffsets.length;
        int length2 = annotationSet.annotationOffsets.length;
        if (length != length2) {
            return CompareUtils.uCompare(length, length2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int[] iArr = this.annotationOffsets;
            int i3 = iArr[i2];
            int[] iArr2 = annotationSet.annotationOffsets;
            if (i3 != iArr2[i2]) {
                return CompareUtils.uCompare(iArr[i2], iArr2[i2]);
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof AnnotationSet) {
            if (compareTo((AnnotationSet) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.annotationOffsets);
    }
}
