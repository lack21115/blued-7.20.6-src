package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/gloverlay/GLCrossVector.class */
public class GLCrossVector extends GLOverlay {
    private long mDiceNativeInstance;

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/gloverlay/GLCrossVector$2.class */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int[] val$crossAttrArray;
        final /* synthetic */ byte[] val$link;

        AnonymousClass2(int[] iArr, byte[] bArr) {
            this.val$crossAttrArray = iArr;
            this.val$link = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLCrossVector.nativeAddVectorData(GLCrossVector.this.mNativeInstance, this.val$crossAttrArray, this.val$link);
        }
    }

    public GLCrossVector(final int i, final IAMapDelegate iAMapDelegate, int i2) {
        super(i, iAMapDelegate, i2);
        this.mDiceNativeInstance = 0L;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.1
            @Override // java.lang.Runnable
            public void run() {
                GLCrossVector.this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
            }
        });
    }

    private static native void nativeAddVectorCar(long j, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAddVectorData(long j, int[] iArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j, Object obj, boolean z);

    private static native void nativeSetArrowResId(long j, boolean z, int i);

    private static native void nativeSetBackgroundResId(long j, int i);

    private static native void nativeSetCarResId(long j, int i);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, byte[] bArr, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void initTextureCallback(final CrossVectorOverlay crossVectorOverlay, final boolean z) {
        if (this.mGLMapView != null) {
            this.mGLMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.3
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeInitTextureCallback(GLCrossVector.this.mNativeInstance, crossVectorOverlay, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    public void releaseInstance() {
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, this.mNativeInstance);
        super.releaseInstance();
    }

    public void setArrowResId(boolean z, int i) {
        nativeSetArrowResId(this.mNativeInstance, z, i);
    }

    public void setBackgroundResId(int i) {
        nativeSetBackgroundResId(this.mNativeInstance, i);
    }

    public void setCarResId(int i) {
        nativeSetCarResId(this.mNativeInstance, i);
    }
}
