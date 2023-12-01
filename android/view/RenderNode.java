package android.view;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/view/RenderNode.class */
public class RenderNode {
    public static final int FLAG_CLIP_CHILDREN = 1;
    public static final int STATUS_DONE = 0;
    public static final int STATUS_DRAW = 1;
    public static final int STATUS_DREW = 4;
    public static final int STATUS_INVOKE = 2;
    final long mNativeRenderNode;
    private final View mOwningView;
    private boolean mValid;

    private RenderNode(long j) {
        this.mNativeRenderNode = j;
        this.mOwningView = null;
    }

    private RenderNode(String str, View view) {
        this.mNativeRenderNode = nCreate(str);
        this.mOwningView = view;
    }

    public static RenderNode adopt(long j) {
        return new RenderNode(j);
    }

    public static RenderNode create(String str, View view) {
        return new RenderNode(str, view);
    }

    private static native void nAddAnimator(long j, long j2);

    private static native long nCreate(String str);

    private static native void nDestroyRenderNode(long j);

    private static native void nEndAllAnimators(long j);

    private static native float nGetAlpha(long j);

    private static native float nGetCameraDistance(long j);

    private static native boolean nGetClipToOutline(long j);

    private static native int nGetDebugSize(long j);

    private static native float nGetElevation(long j);

    private static native void nGetInverseTransformMatrix(long j, long j2);

    private static native float nGetPivotX(long j);

    private static native float nGetPivotY(long j);

    private static native float nGetRotation(long j);

    private static native float nGetRotationX(long j);

    private static native float nGetRotationY(long j);

    private static native float nGetScaleX(long j);

    private static native float nGetScaleY(long j);

    private static native void nGetTransformMatrix(long j, long j2);

    private static native float nGetTranslationX(long j);

    private static native float nGetTranslationY(long j);

    private static native float nGetTranslationZ(long j);

    private static native boolean nHasIdentityMatrix(long j);

    private static native boolean nHasOverlappingRendering(long j);

    private static native boolean nHasShadow(long j);

    private static native boolean nIsPivotExplicitlySet(long j);

    private static native boolean nOffsetLeftAndRight(long j, int i);

    private static native boolean nOffsetTopAndBottom(long j, int i);

    private static native void nOutput(long j);

    private static native boolean nSetAlpha(long j, float f);

    private static native boolean nSetAnimationMatrix(long j, long j2);

    private static native boolean nSetBottom(long j, int i);

    private static native boolean nSetCameraDistance(long j, float f);

    private static native boolean nSetClipBounds(long j, int i, int i2, int i3, int i4);

    private static native boolean nSetClipBoundsEmpty(long j);

    private static native boolean nSetClipToBounds(long j, boolean z);

    private static native boolean nSetClipToOutline(long j, boolean z);

    private static native void nSetDisplayListData(long j, long j2);

    private static native boolean nSetElevation(long j, float f);

    private static native boolean nSetHasOverlappingRendering(long j, boolean z);

    private static native boolean nSetLayerPaint(long j, long j2);

    private static native boolean nSetLayerType(long j, int i);

    private static native boolean nSetLeft(long j, int i);

    private static native boolean nSetLeftTopRightBottom(long j, int i, int i2, int i3, int i4);

    private static native boolean nSetOutlineConvexPath(long j, long j2, float f);

    private static native boolean nSetOutlineEmpty(long j);

    private static native boolean nSetOutlineNone(long j);

    private static native boolean nSetOutlineRoundRect(long j, int i, int i2, int i3, int i4, float f, float f2);

    private static native boolean nSetPivotX(long j, float f);

    private static native boolean nSetPivotY(long j, float f);

    private static native boolean nSetProjectBackwards(long j, boolean z);

    private static native boolean nSetProjectionReceiver(long j, boolean z);

    private static native boolean nSetRevealClip(long j, boolean z, float f, float f2, float f3);

    private static native boolean nSetRight(long j, int i);

    private static native boolean nSetRotation(long j, float f);

    private static native boolean nSetRotationX(long j, float f);

    private static native boolean nSetRotationY(long j, float f);

    private static native boolean nSetScaleX(long j, float f);

    private static native boolean nSetScaleY(long j, float f);

    private static native boolean nSetStaticMatrix(long j, long j2);

    private static native boolean nSetTop(long j, int i);

    private static native boolean nSetTranslationX(long j, float f);

    private static native boolean nSetTranslationY(long j, float f);

    private static native boolean nSetTranslationZ(long j, float f);

    public void addAnimator(RenderNodeAnimator renderNodeAnimator) {
        if (this.mOwningView == null || this.mOwningView.mAttachInfo == null) {
            throw new IllegalStateException("Cannot start this animator on a detached view!");
        }
        nAddAnimator(this.mNativeRenderNode, renderNodeAnimator.getNativeAnimator());
        this.mOwningView.mAttachInfo.mViewRootImpl.registerAnimatingRenderNode(this);
    }

    public void destroyDisplayListData() {
        if (this.mValid) {
            nSetDisplayListData(this.mNativeRenderNode, 0L);
            this.mValid = false;
        }
    }

    public void end(HardwareCanvas hardwareCanvas) {
        if (!(hardwareCanvas instanceof GLES20RecordingCanvas)) {
            throw new IllegalArgumentException("Passed an invalid canvas to end!");
        }
        GLES20RecordingCanvas gLES20RecordingCanvas = (GLES20RecordingCanvas) hardwareCanvas;
        gLES20RecordingCanvas.onPostDraw();
        nSetDisplayListData(this.mNativeRenderNode, gLES20RecordingCanvas.finishRecording());
        gLES20RecordingCanvas.recycle();
        this.mValid = true;
    }

    public void endAllAnimators() {
        nEndAllAnimators(this.mNativeRenderNode);
    }

    protected void finalize() throws Throwable {
        try {
            nDestroyRenderNode(this.mNativeRenderNode);
        } finally {
            super.finalize();
        }
    }

    public float getAlpha() {
        return nGetAlpha(this.mNativeRenderNode);
    }

    public float getCameraDistance() {
        return nGetCameraDistance(this.mNativeRenderNode);
    }

    public boolean getClipToOutline() {
        return nGetClipToOutline(this.mNativeRenderNode);
    }

    public int getDebugSize() {
        return nGetDebugSize(this.mNativeRenderNode);
    }

    public float getElevation() {
        return nGetElevation(this.mNativeRenderNode);
    }

    public void getInverseMatrix(Matrix matrix) {
        nGetInverseTransformMatrix(this.mNativeRenderNode, matrix.native_instance);
    }

    public void getMatrix(Matrix matrix) {
        nGetTransformMatrix(this.mNativeRenderNode, matrix.native_instance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeDisplayList() {
        if (this.mValid) {
            return this.mNativeRenderNode;
        }
        throw new IllegalStateException("The display list is not valid.");
    }

    public float getPivotX() {
        return nGetPivotX(this.mNativeRenderNode);
    }

    public float getPivotY() {
        return nGetPivotY(this.mNativeRenderNode);
    }

    public float getRotation() {
        return nGetRotation(this.mNativeRenderNode);
    }

    public float getRotationX() {
        return nGetRotationX(this.mNativeRenderNode);
    }

    public float getRotationY() {
        return nGetRotationY(this.mNativeRenderNode);
    }

    public float getScaleX() {
        return nGetScaleX(this.mNativeRenderNode);
    }

    public float getScaleY() {
        return nGetScaleY(this.mNativeRenderNode);
    }

    public float getTranslationX() {
        return nGetTranslationX(this.mNativeRenderNode);
    }

    public float getTranslationY() {
        return nGetTranslationY(this.mNativeRenderNode);
    }

    public float getTranslationZ() {
        return nGetTranslationZ(this.mNativeRenderNode);
    }

    public boolean hasIdentityMatrix() {
        return nHasIdentityMatrix(this.mNativeRenderNode);
    }

    public boolean hasOverlappingRendering() {
        return nHasOverlappingRendering(this.mNativeRenderNode);
    }

    public boolean hasShadow() {
        return nHasShadow(this.mNativeRenderNode);
    }

    public boolean isPivotExplicitlySet() {
        return nIsPivotExplicitlySet(this.mNativeRenderNode);
    }

    public boolean isValid() {
        return this.mValid;
    }

    public boolean offsetLeftAndRight(int i) {
        return nOffsetLeftAndRight(this.mNativeRenderNode, i);
    }

    public boolean offsetTopAndBottom(int i) {
        return nOffsetTopAndBottom(this.mNativeRenderNode, i);
    }

    public void output() {
        nOutput(this.mNativeRenderNode);
    }

    public boolean setAlpha(float f) {
        return nSetAlpha(this.mNativeRenderNode, f);
    }

    public boolean setAnimationMatrix(Matrix matrix) {
        return nSetAnimationMatrix(this.mNativeRenderNode, matrix != null ? matrix.native_instance : 0L);
    }

    public boolean setBottom(int i) {
        return nSetBottom(this.mNativeRenderNode, i);
    }

    public boolean setCameraDistance(float f) {
        return nSetCameraDistance(this.mNativeRenderNode, f);
    }

    public boolean setClipBounds(Rect rect) {
        return rect == null ? nSetClipBoundsEmpty(this.mNativeRenderNode) : nSetClipBounds(this.mNativeRenderNode, rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean setClipToBounds(boolean z) {
        return nSetClipToBounds(this.mNativeRenderNode, z);
    }

    public boolean setClipToOutline(boolean z) {
        return nSetClipToOutline(this.mNativeRenderNode, z);
    }

    public boolean setElevation(float f) {
        return nSetElevation(this.mNativeRenderNode, f);
    }

    public boolean setHasOverlappingRendering(boolean z) {
        return nSetHasOverlappingRendering(this.mNativeRenderNode, z);
    }

    public boolean setLayerPaint(Paint paint) {
        return nSetLayerPaint(this.mNativeRenderNode, paint != null ? paint.mNativePaint : 0L);
    }

    public boolean setLayerType(int i) {
        return nSetLayerType(this.mNativeRenderNode, i);
    }

    public boolean setLeft(int i) {
        return nSetLeft(this.mNativeRenderNode, i);
    }

    public boolean setLeftTopRightBottom(int i, int i2, int i3, int i4) {
        return nSetLeftTopRightBottom(this.mNativeRenderNode, i, i2, i3, i4);
    }

    public boolean setOutline(Outline outline) {
        if (outline == null) {
            return nSetOutlineNone(this.mNativeRenderNode);
        }
        if (outline.isEmpty()) {
            return nSetOutlineEmpty(this.mNativeRenderNode);
        }
        if (outline.mRect != null) {
            return nSetOutlineRoundRect(this.mNativeRenderNode, outline.mRect.left, outline.mRect.top, outline.mRect.right, outline.mRect.bottom, outline.mRadius, outline.mAlpha);
        }
        if (outline.mPath != null) {
            return nSetOutlineConvexPath(this.mNativeRenderNode, outline.mPath.mNativePath, outline.mAlpha);
        }
        throw new IllegalArgumentException("Unrecognized outline?");
    }

    public boolean setPivotX(float f) {
        return nSetPivotX(this.mNativeRenderNode, f);
    }

    public boolean setPivotY(float f) {
        return nSetPivotY(this.mNativeRenderNode, f);
    }

    public boolean setProjectBackwards(boolean z) {
        return nSetProjectBackwards(this.mNativeRenderNode, z);
    }

    public boolean setProjectionReceiver(boolean z) {
        return nSetProjectionReceiver(this.mNativeRenderNode, z);
    }

    public boolean setRevealClip(boolean z, float f, float f2, float f3) {
        return nSetRevealClip(this.mNativeRenderNode, z, f, f2, f3);
    }

    public boolean setRight(int i) {
        return nSetRight(this.mNativeRenderNode, i);
    }

    public boolean setRotation(float f) {
        return nSetRotation(this.mNativeRenderNode, f);
    }

    public boolean setRotationX(float f) {
        return nSetRotationX(this.mNativeRenderNode, f);
    }

    public boolean setRotationY(float f) {
        return nSetRotationY(this.mNativeRenderNode, f);
    }

    public boolean setScaleX(float f) {
        return nSetScaleX(this.mNativeRenderNode, f);
    }

    public boolean setScaleY(float f) {
        return nSetScaleY(this.mNativeRenderNode, f);
    }

    public boolean setStaticMatrix(Matrix matrix) {
        return nSetStaticMatrix(this.mNativeRenderNode, matrix.native_instance);
    }

    public boolean setTop(int i) {
        return nSetTop(this.mNativeRenderNode, i);
    }

    public boolean setTranslationX(float f) {
        return nSetTranslationX(this.mNativeRenderNode, f);
    }

    public boolean setTranslationY(float f) {
        return nSetTranslationY(this.mNativeRenderNode, f);
    }

    public boolean setTranslationZ(float f) {
        return nSetTranslationZ(this.mNativeRenderNode, f);
    }

    public HardwareCanvas start(int i, int i2) {
        GLES20RecordingCanvas obtain = GLES20RecordingCanvas.obtain(this);
        obtain.setViewport(i, i2);
        obtain.onPreDraw(null);
        return obtain;
    }
}
