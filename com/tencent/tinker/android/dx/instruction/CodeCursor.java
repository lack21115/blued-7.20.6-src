package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.utils.SparseIntArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/CodeCursor.class */
public abstract class CodeCursor {
    private final SparseIntArray baseAddressMap = new SparseIntArray();
    private int cursor = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void advance(int i) {
        this.cursor += i;
    }

    public final int baseAddressForCursor() {
        int indexOfKey = this.baseAddressMap.indexOfKey(this.cursor);
        return indexOfKey < 0 ? this.cursor : this.baseAddressMap.valueAt(indexOfKey);
    }

    public final int cursor() {
        return this.cursor;
    }

    public void reset() {
        this.baseAddressMap.clear();
        this.cursor = 0;
    }

    public final void setBaseAddress(int i, int i2) {
        this.baseAddressMap.put(i, i2);
    }
}
