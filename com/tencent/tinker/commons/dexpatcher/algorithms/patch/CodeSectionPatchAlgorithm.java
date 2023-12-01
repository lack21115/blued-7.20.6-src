package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/algorithms/patch/CodeSectionPatchAlgorithm.class */
public class CodeSectionPatchAlgorithm extends DexSectionPatchAlgorithm<Code> {
    private Dex.Section patchedCodeSec;
    private TableOfContents.Section patchedCodeTocSec;

    public CodeSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        this.patchedCodeTocSec = null;
        this.patchedCodeSec = null;
        if (dex2 != null) {
            TableOfContents.Section section = dex2.getTableOfContents().codes;
            this.patchedCodeTocSec = section;
            this.patchedCodeSec = dex2.openSection(section);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public Code adjustItem(AbstractIndexMap abstractIndexMap, Code code) {
        return abstractIndexMap.adjust(code);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int getItemSize(Code code) {
        return code.byteCountInDex();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().codes;
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markCodeDeleted(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public Code nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readCode();
    }

    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapCodeOffset(i2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm
    public int writePatchedItem(Code code) {
        this.patchedCodeTocSec.size++;
        return this.patchedCodeSec.writeCode(code);
    }
}
