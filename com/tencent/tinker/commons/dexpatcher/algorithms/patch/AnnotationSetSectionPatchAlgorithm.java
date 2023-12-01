package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/algorithms/patch/AnnotationSetSectionPatchAlgorithm.class */
public class AnnotationSetSectionPatchAlgorithm extends DexSectionPatchAlgorithm<AnnotationSet> {
    private Dex.Section patchedAnnotationSetSec;
    private TableOfContents.Section patchedAnnotationSetTocSec;

    public AnnotationSetSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedAnnotationSetTocSec = null;
        this.patchedAnnotationSetSec = null;
        if (dex2 != null) {
            TableOfContents.Section section = dex2.getTableOfContents().annotationSets;
            this.patchedAnnotationSetTocSec = section;
            this.patchedAnnotationSetSec = dex2.openSection(section);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public AnnotationSet adjustItem(AbstractIndexMap abstractIndexMap, AnnotationSet annotationSet) {
        return abstractIndexMap.adjust(annotationSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(AnnotationSet annotationSet) {
        return annotationSet.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotationSets;
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationSetDeleted(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public AnnotationSet nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotationSet();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationSetOffset(i2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(AnnotationSet annotationSet) {
        this.patchedAnnotationSetTocSec.size++;
        return this.patchedAnnotationSetSec.writeAnnotationSet(annotationSet);
    }
}
