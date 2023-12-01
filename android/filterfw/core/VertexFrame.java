package android.filterfw.core;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/VertexFrame.class */
public class VertexFrame extends Frame {
    private int vertexFrameId;

    static {
        System.loadLibrary("filterfw");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VertexFrame(FrameFormat frameFormat, FrameManager frameManager) {
        super(frameFormat, frameManager);
        this.vertexFrameId = -1;
        if (getFormat().getSize() <= 0) {
            throw new IllegalArgumentException("Initializing vertex frame with zero size!");
        }
        if (!nativeAllocate(getFormat().getSize())) {
            throw new RuntimeException("Could not allocate vertex frame!");
        }
    }

    private native int getNativeVboId();

    private native boolean nativeAllocate(int i);

    private native boolean nativeDeallocate();

    private native boolean setNativeData(byte[] bArr, int i, int i2);

    private native boolean setNativeFloats(float[] fArr);

    private native boolean setNativeInts(int[] iArr);

    @Override // android.filterfw.core.Frame
    public Bitmap getBitmap() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @Override // android.filterfw.core.Frame
    public ByteBuffer getData() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @Override // android.filterfw.core.Frame
    public float[] getFloats() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @Override // android.filterfw.core.Frame
    public int[] getInts() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    @Override // android.filterfw.core.Frame
    public Object getObjectValue() {
        throw new RuntimeException("Vertex frames do not support reading data!");
    }

    public int getVboId() {
        return getNativeVboId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.filterfw.core.Frame
    public boolean hasNativeAllocation() {
        boolean z;
        synchronized (this) {
            z = this.vertexFrameId != -1;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.filterfw.core.Frame
    public void releaseNativeAllocation() {
        synchronized (this) {
            nativeDeallocate();
            this.vertexFrameId = -1;
        }
    }

    @Override // android.filterfw.core.Frame
    public void setBitmap(Bitmap bitmap) {
        throw new RuntimeException("Unsupported: Cannot set vertex frame bitmap value!");
    }

    @Override // android.filterfw.core.Frame
    public void setData(ByteBuffer byteBuffer, int i, int i2) {
        assertFrameMutable();
        byte[] array = byteBuffer.array();
        if (getFormat().getSize() != array.length) {
            throw new RuntimeException("Data size in setData does not match vertex frame size!");
        }
        if (!setNativeData(array, i, i2)) {
            throw new RuntimeException("Could not set vertex frame data!");
        }
    }

    @Override // android.filterfw.core.Frame
    public void setDataFromFrame(Frame frame) {
        super.setDataFromFrame(frame);
    }

    @Override // android.filterfw.core.Frame
    public void setFloats(float[] fArr) {
        assertFrameMutable();
        if (!setNativeFloats(fArr)) {
            throw new RuntimeException("Could not set int values for vertex frame!");
        }
    }

    @Override // android.filterfw.core.Frame
    public void setInts(int[] iArr) {
        assertFrameMutable();
        if (!setNativeInts(iArr)) {
            throw new RuntimeException("Could not set int values for vertex frame!");
        }
    }

    public String toString() {
        return "VertexFrame (" + getFormat() + ") with VBO ID " + getVboId();
    }
}
