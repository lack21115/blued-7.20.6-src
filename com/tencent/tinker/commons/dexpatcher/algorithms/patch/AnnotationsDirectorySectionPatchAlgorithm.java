package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/algorithms/patch/AnnotationsDirectorySectionPatchAlgorithm.class */
public class AnnotationsDirectorySectionPatchAlgorithm extends DexSectionPatchAlgorithm<AnnotationsDirectory> {
    private Dex.Section patchedAnnotationsDirectorySec;
    private TableOfContents.Section patchedAnnotationsDirectoryTocSec;

    public AnnotationsDirectorySectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedAnnotationsDirectoryTocSec = null;
        this.patchedAnnotationsDirectorySec = null;
        if (dex2 != null) {
            TableOfContents.Section section = dex2.getTableOfContents().annotationsDirectories;
            this.patchedAnnotationsDirectoryTocSec = section;
            this.patchedAnnotationsDirectorySec = dex2.openSection(section);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public AnnotationsDirectory adjustItem(AbstractIndexMap abstractIndexMap, AnnotationsDirectory annotationsDirectory) {
        return abstractIndexMap.adjust(annotationsDirectory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(AnnotationsDirectory annotationsDirectory) {
        return annotationsDirectory.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotationsDirectories;
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationsDirectoryDeleted(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public AnnotationsDirectory nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotationsDirectory();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationsDirectoryOffset(i2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(AnnotationsDirectory annotationsDirectory) {
        this.patchedAnnotationsDirectoryTocSec.size++;
        return this.patchedAnnotationsDirectorySec.writeAnnotationsDirectory(annotationsDirectory);
    }
}
