package android.filterfw.core;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/Frame.class */
public abstract class Frame {
    public static final int NO_BINDING = 0;
    public static final long TIMESTAMP_NOT_SET = -2;
    public static final long TIMESTAMP_UNKNOWN = -1;
    private long mBindingId;
    private int mBindingType;
    private FrameFormat mFormat;
    private FrameManager mFrameManager;
    private boolean mReadOnly;
    private int mRefCount;
    private boolean mReusable;
    private long mTimestamp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Frame(FrameFormat frameFormat, FrameManager frameManager) {
        this.mReadOnly = false;
        this.mReusable = false;
        this.mRefCount = 1;
        this.mBindingType = 0;
        this.mBindingId = 0L;
        this.mTimestamp = -2L;
        this.mFormat = frameFormat.mutableCopy();
        this.mFrameManager = frameManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Frame(FrameFormat frameFormat, FrameManager frameManager, int i, long j) {
        this.mReadOnly = false;
        this.mReusable = false;
        this.mRefCount = 1;
        this.mBindingType = 0;
        this.mBindingId = 0L;
        this.mTimestamp = -2L;
        this.mFormat = frameFormat.mutableCopy();
        this.mFrameManager = frameManager;
        this.mBindingType = i;
        this.mBindingId = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bitmap convertBitmapToRGBA(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        if (copy == null) {
            throw new RuntimeException("Error converting bitmap to RGBA!");
        }
        if (copy.getRowBytes() != copy.getWidth() * 4) {
            throw new RuntimeException("Unsupported row byte count in bitmap!");
        }
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void assertFrameMutable() {
        if (isReadOnly()) {
            throw new RuntimeException("Attempting to modify read-only frame!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int decRefCount() {
        this.mRefCount--;
        return this.mRefCount;
    }

    public long getBindingId() {
        return this.mBindingId;
    }

    public int getBindingType() {
        return this.mBindingType;
    }

    public abstract Bitmap getBitmap();

    public int getCapacity() {
        return getFormat().getSize();
    }

    public abstract ByteBuffer getData();

    public abstract float[] getFloats();

    public FrameFormat getFormat() {
        return this.mFormat;
    }

    public FrameManager getFrameManager() {
        return this.mFrameManager;
    }

    public abstract int[] getInts();

    public abstract Object getObjectValue();

    public int getRefCount() {
        return this.mRefCount;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean hasNativeAllocation();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int incRefCount() {
        this.mRefCount++;
        return this.mRefCount;
    }

    public boolean isReadOnly() {
        return this.mReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isReusable() {
        return this.mReusable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void markReadOnly() {
        this.mReadOnly = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFrameFetch() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFrameStore() {
    }

    public Frame release() {
        Frame frame = this;
        if (this.mFrameManager != null) {
            frame = this.mFrameManager.releaseFrame(this);
        }
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void releaseNativeAllocation();

    protected boolean requestResize(int[] iArr) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(FrameFormat frameFormat) {
        this.mFormat = frameFormat.mutableCopy();
        this.mReadOnly = false;
        this.mRefCount = 1;
    }

    public Frame retain() {
        Frame frame = this;
        if (this.mFrameManager != null) {
            frame = this.mFrameManager.retainFrame(this);
        }
        return frame;
    }

    public abstract void setBitmap(Bitmap bitmap);

    public void setData(ByteBuffer byteBuffer) {
        setData(byteBuffer, 0, byteBuffer.limit());
    }

    public abstract void setData(ByteBuffer byteBuffer, int i, int i2);

    public void setData(byte[] bArr, int i, int i2) {
        setData(ByteBuffer.wrap(bArr, i, i2));
    }

    public void setDataFromFrame(Frame frame) {
        setData(frame.getData());
    }

    public abstract void setFloats(float[] fArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFormat(FrameFormat frameFormat) {
        this.mFormat = frameFormat.mutableCopy();
    }

    protected void setGenericObjectValue(Object obj) {
        throw new RuntimeException("Cannot set object value of unsupported type: " + obj.getClass());
    }

    public abstract void setInts(int[] iArr);

    public void setObjectValue(Object obj) {
        assertFrameMutable();
        if (obj instanceof int[]) {
            setInts((int[]) obj);
        } else if (obj instanceof float[]) {
            setFloats((float[]) obj);
        } else if (obj instanceof ByteBuffer) {
            setData((ByteBuffer) obj);
        } else if (obj instanceof Bitmap) {
            setBitmap((Bitmap) obj);
        } else {
            setGenericObjectValue(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setReusable(boolean z) {
        this.mReusable = z;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
