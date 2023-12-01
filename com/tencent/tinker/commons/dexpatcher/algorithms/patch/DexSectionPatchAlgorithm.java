package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;
import java.lang.Comparable;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/algorithms/patch/DexSectionPatchAlgorithm.class */
public abstract class DexSectionPatchAlgorithm<T extends Comparable<T>> {
    protected final Dex oldDex;
    private final SparseIndexMap oldToPatchedIndexMap;
    protected final DexPatchFile patchFile;

    public DexSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, SparseIndexMap sparseIndexMap) {
        this.patchFile = dexPatchFile;
        this.oldDex = dex;
        this.oldToPatchedIndexMap = sparseIndexMap;
    }

    private void doFullPatch(Dex.Section section, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int length2 = iArr2.length;
        int length3 = iArr3.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= i && i5 >= (i + length2) - length) {
                break;
            }
            if (i4 < length2 && iArr2[i4] == i5) {
                writePatchedItem(nextItem(this.patchFile.getBuffer()));
                i4++;
            } else if (i3 < length3 && iArr3[i3] == i5) {
                writePatchedItem(nextItem(this.patchFile.getBuffer()));
                i3++;
            } else if (Arrays.binarySearch(iArr, i6) >= 0) {
                markDeletedIndexOrOffset(this.oldToPatchedIndexMap, i6, getItemOffsetOrIndex(i6, nextItem(section)));
                i6++;
                i2++;
            } else if (Arrays.binarySearch(iArr3, i6) >= 0) {
                markDeletedIndexOrOffset(this.oldToPatchedIndexMap, i6, getItemOffsetOrIndex(i6, nextItem(section)));
                i6++;
            } else if (i6 < i) {
                T adjustItem = adjustItem(this.oldToPatchedIndexMap, nextItem(section));
                updateIndexOrOffset(this.oldToPatchedIndexMap, i6, getItemOffsetOrIndex(i6, adjustItem), i5, writePatchedItem(adjustItem));
                i6++;
                i5++;
            }
            i5++;
        }
        if (i4 != length2 || i2 != length || i3 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", Integer.valueOf(i4), Integer.valueOf(length2), Integer.valueOf(i2), Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(length3)));
        }
    }

    private int getItemOffsetOrIndex(int i, T t) {
        if (t instanceof TableOfContents.Section.Item) {
            i = ((TableOfContents.Section.Item) t).off;
        }
        return i;
    }

    private int[] readDeltaIndiciesOrOffsets(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += this.patchFile.getBuffer().readSleb128();
            iArr[i3] = i2;
        }
        return iArr;
    }

    protected T adjustItem(AbstractIndexMap abstractIndexMap, T t) {
        return t;
    }

    public void execute() {
        Dex.Section section;
        int i;
        int[] readDeltaIndiciesOrOffsets = readDeltaIndiciesOrOffsets(this.patchFile.getBuffer().readUleb128());
        int[] readDeltaIndiciesOrOffsets2 = readDeltaIndiciesOrOffsets(this.patchFile.getBuffer().readUleb128());
        int[] readDeltaIndiciesOrOffsets3 = readDeltaIndiciesOrOffsets(this.patchFile.getBuffer().readUleb128());
        TableOfContents.Section tocSection = getTocSection(this.oldDex);
        if (tocSection.exists()) {
            section = this.oldDex.openSection(tocSection);
            i = tocSection.size;
        } else {
            section = null;
            i = 0;
        }
        doFullPatch(section, i, readDeltaIndiciesOrOffsets, readDeltaIndiciesOrOffsets2, readDeltaIndiciesOrOffsets3);
    }

    protected abstract int getItemSize(T t);

    protected abstract TableOfContents.Section getTocSection(Dex dex);

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
    }

    protected abstract T nextItem(DexDataBuffer dexDataBuffer);

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
    }

    protected abstract int writePatchedItem(T t);
}
