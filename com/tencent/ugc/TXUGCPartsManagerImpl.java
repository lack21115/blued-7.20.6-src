package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXUGCPartsManagerImpl.class */
public class TXUGCPartsManagerImpl implements TXUGCPartsManager {
    private long mNativePartsManager;

    public TXUGCPartsManagerImpl(long j) {
        this.mNativePartsManager = 0L;
        this.mNativePartsManager = j;
    }

    private static native void nativeAddPart(long j, String str, long j2);

    private static native void nativeDeleteAllParts(long j);

    private static native void nativeDeleteLastPart(long j);

    private static native void nativeDeletePart(long j, int i);

    private static native void nativeDestroy(long j);

    private static native int nativeGetDuration(long j);

    private static native String[] nativeGetPartsPathList(long j);

    private static native void nativeInsertPart(long j, String str, int i);

    @Override // com.tencent.ugc.TXUGCPartsManager
    public void addClipInfo(PartInfo partInfo) {
        long j = this.mNativePartsManager;
        if (j != 0) {
            nativeAddPart(j, partInfo.getPath(), partInfo.getDuration());
        }
    }

    @Override // com.tencent.ugc.TXUGCPartsManager
    public void deleteAllParts() {
        long j = this.mNativePartsManager;
        if (j != 0) {
            nativeDeleteAllParts(j);
        }
    }

    @Override // com.tencent.ugc.TXUGCPartsManager
    public void deleteLastPart() {
        long j = this.mNativePartsManager;
        if (j != 0) {
            nativeDeleteLastPart(j);
        }
    }

    @Override // com.tencent.ugc.TXUGCPartsManager
    public void deletePart(int i) {
        long j = this.mNativePartsManager;
        if (j != 0) {
            nativeDeletePart(j, i);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativePartsManager;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativePartsManager = 0L;
        }
    }

    @Override // com.tencent.ugc.TXUGCPartsManager
    public int getDuration() {
        long j = this.mNativePartsManager;
        if (j != 0) {
            return nativeGetDuration(j);
        }
        return 0;
    }

    @Override // com.tencent.ugc.TXUGCPartsManager
    public List<String> getPartsPathList() {
        ArrayList arrayList = new ArrayList();
        long j = this.mNativePartsManager;
        if (j == 0) {
            return arrayList;
        }
        String[] nativeGetPartsPathList = nativeGetPartsPathList(j);
        if (nativeGetPartsPathList != null && nativeGetPartsPathList.length != 0) {
            arrayList.addAll(Arrays.asList(nativeGetPartsPathList));
        }
        return arrayList;
    }

    @Override // com.tencent.ugc.TXUGCPartsManager
    public void insertPart(String str, int i) {
        long j = this.mNativePartsManager;
        if (j != 0) {
            nativeInsertPart(j, str, i);
        }
    }
}
