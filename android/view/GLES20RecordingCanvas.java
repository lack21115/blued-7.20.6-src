package android.view;

import android.util.Pools;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/view/GLES20RecordingCanvas.class */
public class GLES20RecordingCanvas extends GLES20Canvas {
    private static final int POOL_LIMIT = 25;
    private static final Pools.SynchronizedPool<GLES20RecordingCanvas> sPool = new Pools.SynchronizedPool<>(25);
    RenderNode mNode;

    private GLES20RecordingCanvas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GLES20RecordingCanvas obtain(RenderNode renderNode) {
        if (renderNode == null) {
            throw new IllegalArgumentException("node cannot be null");
        }
        GLES20RecordingCanvas acquire = sPool.acquire();
        GLES20RecordingCanvas gLES20RecordingCanvas = acquire;
        if (acquire == null) {
            gLES20RecordingCanvas = new GLES20RecordingCanvas();
        }
        gLES20RecordingCanvas.mNode = renderNode;
        return gLES20RecordingCanvas;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long finishRecording() {
        return nFinishRecording(this.mRenderer);
    }

    @Override // android.graphics.Canvas
    public boolean isRecordingFor(Object obj) {
        return obj == this.mNode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle() {
        this.mNode = null;
        sPool.release(this);
    }
}
