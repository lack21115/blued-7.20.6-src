package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/AnnotationSetRefList.class */
public class AnnotationSetRefList extends TableOfContents.Section.Item<AnnotationSetRefList> {
    public int[] annotationSetRefItems;

    public AnnotationSetRefList(int i, int[] iArr) {
        super(i);
        this.annotationSetRefItems = iArr;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (this.annotationSetRefItems.length + 1) * 4;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnnotationSetRefList annotationSetRefList) {
        int length = this.annotationSetRefItems.length;
        int length2 = annotationSetRefList.annotationSetRefItems.length;
        if (length != length2) {
            return CompareUtils.uCompare(length, length2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int[] iArr = this.annotationSetRefItems;
            int i3 = iArr[i2];
            int[] iArr2 = annotationSetRefList.annotationSetRefItems;
            if (i3 != iArr2[i2]) {
                return CompareUtils.uCompare(iArr[i2], iArr2[i2]);
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof AnnotationSetRefList) {
            if (compareTo((AnnotationSetRefList) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.annotationSetRefItems);
    }
}
