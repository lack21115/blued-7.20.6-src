package com.tencent.tinker.commons.dexpatcher.util;

import com.tencent.tinker.android.utils.SparseBoolArray;
import com.tencent.tinker.android.utils.SparseIntArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/util/SparseIndexMap.class */
public class SparseIndexMap extends AbstractIndexMap {
    private final SparseIntArray stringIdsMap = new SparseIntArray();
    private final SparseIntArray typeIdsMap = new SparseIntArray();
    private final SparseIntArray protoIdsMap = new SparseIntArray();
    private final SparseIntArray fieldIdsMap = new SparseIntArray();
    private final SparseIntArray methodIdsMap = new SparseIntArray();
    private final SparseIntArray typeListOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationSetOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationSetRefListOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationsDirectoryOffsetsMap = new SparseIntArray();
    private final SparseIntArray staticValuesOffsetsMap = new SparseIntArray();
    private final SparseIntArray classDataOffsetsMap = new SparseIntArray();
    private final SparseIntArray debugInfoItemOffsetsMap = new SparseIntArray();
    private final SparseIntArray codeOffsetsMap = new SparseIntArray();
    private final SparseBoolArray deletedStringIds = new SparseBoolArray();
    private final SparseBoolArray deletedTypeIds = new SparseBoolArray();
    private final SparseBoolArray deletedProtoIds = new SparseBoolArray();
    private final SparseBoolArray deletedFieldIds = new SparseBoolArray();
    private final SparseBoolArray deletedMethodIds = new SparseBoolArray();
    private final SparseBoolArray deletedTypeListOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationSetOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationSetRefListOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationsDirectoryOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedStaticValuesOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedClassDataOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedDebugInfoItemOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedCodeOffsets = new SparseBoolArray();

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustAnnotationOffset(int i) {
        int indexOfKey = this.annotationOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedAnnotationOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.annotationOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustAnnotationSetOffset(int i) {
        int indexOfKey = this.annotationSetOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedAnnotationSetOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.annotationSetOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustAnnotationSetRefListOffset(int i) {
        int indexOfKey = this.annotationSetRefListOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedAnnotationSetRefListOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.annotationSetRefListOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustAnnotationsDirectoryOffset(int i) {
        int indexOfKey = this.annotationsDirectoryOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedAnnotationsDirectoryOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.annotationsDirectoryOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustClassDataOffset(int i) {
        int indexOfKey = this.classDataOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedClassDataOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.classDataOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustCodeOffset(int i) {
        int indexOfKey = this.codeOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedCodeOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.codeOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustDebugInfoItemOffset(int i) {
        int indexOfKey = this.debugInfoItemOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedDebugInfoItemOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.debugInfoItemOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustFieldIdIndex(int i) {
        int indexOfKey = this.fieldIdsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedFieldIds.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.fieldIdsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustMethodIdIndex(int i) {
        int indexOfKey = this.methodIdsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedMethodIds.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.methodIdsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustProtoIdIndex(int i) {
        int indexOfKey = this.protoIdsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedProtoIds.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.protoIdsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustStaticValuesOffset(int i) {
        int indexOfKey = this.staticValuesOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedStaticValuesOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.staticValuesOffsetsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustStringIndex(int i) {
        int indexOfKey = this.stringIdsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedStringIds.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.stringIdsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustTypeIdIndex(int i) {
        int indexOfKey = this.typeIdsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedTypeIds.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.typeIdsMap.valueAt(indexOfKey);
    }

    @Override // com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap
    public int adjustTypeListOffset(int i) {
        int indexOfKey = this.typeListOffsetsMap.indexOfKey(i);
        if (indexOfKey < 0) {
            int i2 = i;
            if (i >= 0) {
                i2 = i;
                if (this.deletedTypeListOffsets.containsKey(i)) {
                    i2 = -1;
                }
            }
            return i2;
        }
        return this.typeListOffsetsMap.valueAt(indexOfKey);
    }

    public void mapAnnotationOffset(int i, int i2) {
        this.annotationOffsetsMap.put(i, i2);
    }

    public void mapAnnotationSetOffset(int i, int i2) {
        this.annotationSetOffsetsMap.put(i, i2);
    }

    public void mapAnnotationSetRefListOffset(int i, int i2) {
        this.annotationSetRefListOffsetsMap.put(i, i2);
    }

    public void mapAnnotationsDirectoryOffset(int i, int i2) {
        this.annotationsDirectoryOffsetsMap.put(i, i2);
    }

    public void mapClassDataOffset(int i, int i2) {
        this.classDataOffsetsMap.put(i, i2);
    }

    public void mapCodeOffset(int i, int i2) {
        this.codeOffsetsMap.put(i, i2);
    }

    public void mapDebugInfoItemOffset(int i, int i2) {
        this.debugInfoItemOffsetsMap.put(i, i2);
    }

    public void mapFieldIds(int i, int i2) {
        this.fieldIdsMap.put(i, i2);
    }

    public void mapMethodIds(int i, int i2) {
        this.methodIdsMap.put(i, i2);
    }

    public void mapProtoIds(int i, int i2) {
        this.protoIdsMap.put(i, i2);
    }

    public void mapStaticValuesOffset(int i, int i2) {
        this.staticValuesOffsetsMap.put(i, i2);
    }

    public void mapStringIds(int i, int i2) {
        this.stringIdsMap.put(i, i2);
    }

    public void mapTypeIds(int i, int i2) {
        this.typeIdsMap.put(i, i2);
    }

    public void mapTypeListOffset(int i, int i2) {
        this.typeListOffsetsMap.put(i, i2);
    }

    public void markAnnotationDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedAnnotationOffsets.put(i, true);
    }

    public void markAnnotationSetDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedAnnotationSetOffsets.put(i, true);
    }

    public void markAnnotationSetRefListDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedAnnotationSetRefListOffsets.put(i, true);
    }

    public void markAnnotationsDirectoryDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedAnnotationsDirectoryOffsets.put(i, true);
    }

    public void markClassDataDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedClassDataOffsets.put(i, true);
    }

    public void markCodeDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedCodeOffsets.put(i, true);
    }

    public void markDebugInfoItemDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedDebugInfoItemOffsets.put(i, true);
    }

    public void markFieldIdDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedFieldIds.put(i, true);
    }

    public void markMethodIdDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedMethodIds.put(i, true);
    }

    public void markProtoIdDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedProtoIds.put(i, true);
    }

    public void markStaticValuesDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedStaticValuesOffsets.put(i, true);
    }

    public void markStringIdDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedStringIds.put(i, true);
    }

    public void markTypeIdDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedTypeIds.put(i, true);
    }

    public void markTypeListDeleted(int i) {
        if (i < 0) {
            return;
        }
        this.deletedTypeListOffsets.put(i, true);
    }
}
