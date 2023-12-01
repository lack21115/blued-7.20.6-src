package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/algorithms/patch/AnnotationSetRefListSectionPatchAlgorithm.class */
public class AnnotationSetRefListSectionPatchAlgorithm extends DexSectionPatchAlgorithm<AnnotationSetRefList> {
    private Dex.Section patchedAnnotationSetRefListSec;
    private TableOfContents.Section patchedAnnotationSetRefListTocSec;

    public AnnotationSetRefListSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedAnnotationSetRefListTocSec = null;
        this.patchedAnnotationSetRefListSec = null;
        if (dex2 != null) {
            TableOfContents.Section section = dex2.getTableOfContents().annotationSetRefLists;
            this.patchedAnnotationSetRefListTocSec = section;
            this.patchedAnnotationSetRefListSec = dex2.openSection(section);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public AnnotationSetRefList adjustItem(AbstractIndexMap abstractIndexMap, AnnotationSetRefList annotationSetRefList) {
        return abstractIndexMap.adjust(annotationSetRefList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(AnnotationSetRefList annotationSetRefList) {
        return annotationSetRefList.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotationSetRefLists;
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationSetRefListDeleted(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public AnnotationSetRefList nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotationSetRefList();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationSetRefListOffset(i2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(AnnotationSetRefList annotationSetRefList) {
        this.patchedAnnotationSetRefListTocSec.size++;
        return this.patchedAnnotationSetRefListSec.writeAnnotationSetRefList(annotationSetRefList);
    }
}
