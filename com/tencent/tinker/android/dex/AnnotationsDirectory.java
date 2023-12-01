package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/AnnotationsDirectory.class */
public class AnnotationsDirectory extends TableOfContents.Section.Item<AnnotationsDirectory> {
    public int classAnnotationsOffset;
    public int[][] fieldAnnotations;
    public int[][] methodAnnotations;
    public int[][] parameterAnnotations;

    public AnnotationsDirectory(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.classAnnotationsOffset = i2;
        this.fieldAnnotations = iArr;
        this.methodAnnotations = iArr2;
        this.parameterAnnotations = iArr3;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (((this.fieldAnnotations.length + this.methodAnnotations.length + this.parameterAnnotations.length) * 2) + 4) * 4;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnnotationsDirectory annotationsDirectory) {
        int i = this.classAnnotationsOffset;
        int i2 = annotationsDirectory.classAnnotationsOffset;
        if (i != i2) {
            return CompareUtils.uCompare(i, i2);
        }
        int length = this.fieldAnnotations.length;
        int length2 = this.methodAnnotations.length;
        int length3 = this.parameterAnnotations.length;
        int length4 = annotationsDirectory.fieldAnnotations.length;
        int length5 = annotationsDirectory.methodAnnotations.length;
        int length6 = annotationsDirectory.parameterAnnotations.length;
        if (length != length4) {
            return CompareUtils.sCompare(length, length4);
        }
        if (length2 != length5) {
            return CompareUtils.sCompare(length2, length5);
        }
        if (length3 != length6) {
            return CompareUtils.sCompare(length3, length6);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < length) {
                int[][] iArr = this.fieldAnnotations;
                int i5 = iArr[i4][0];
                int i6 = iArr[i4][1];
                int[][] iArr2 = annotationsDirectory.fieldAnnotations;
                int i7 = iArr2[i4][0];
                int i8 = iArr2[i4][1];
                if (i5 != i7) {
                    return CompareUtils.uCompare(i5, i7);
                }
                if (i6 != i8) {
                    return CompareUtils.sCompare(i6, i8);
                }
                i3 = i4 + 1;
            } else {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < length2) {
                        int[][] iArr3 = this.methodAnnotations;
                        int i11 = iArr3[i10][0];
                        int i12 = iArr3[i10][1];
                        int[][] iArr4 = annotationsDirectory.methodAnnotations;
                        int i13 = iArr4[i10][0];
                        int i14 = iArr4[i10][1];
                        if (i11 != i13) {
                            return CompareUtils.uCompare(i11, i13);
                        }
                        if (i12 != i14) {
                            return CompareUtils.sCompare(i12, i14);
                        }
                        i9 = i10 + 1;
                    } else {
                        int i15 = 0;
                        while (true) {
                            int i16 = i15;
                            if (i16 >= length3) {
                                return 0;
                            }
                            int[][] iArr5 = this.parameterAnnotations;
                            int i17 = iArr5[i16][0];
                            int i18 = iArr5[i16][1];
                            int[][] iArr6 = annotationsDirectory.parameterAnnotations;
                            int i19 = iArr6[i16][0];
                            int i20 = iArr6[i16][1];
                            if (i17 != i19) {
                                return CompareUtils.uCompare(i17, i19);
                            }
                            if (i18 != i20) {
                                return CompareUtils.sCompare(i18, i20);
                            }
                            i15 = i16 + 1;
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof AnnotationsDirectory) {
            if (compareTo((AnnotationsDirectory) obj) == 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Integer.valueOf(this.classAnnotationsOffset), this.fieldAnnotations, this.methodAnnotations, this.parameterAnnotations);
    }
}
