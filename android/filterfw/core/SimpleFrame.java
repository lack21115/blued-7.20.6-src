package android.filterfw.core;

import android.filterfw.format.ObjectFormat;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/SimpleFrame.class */
public class SimpleFrame extends Frame {
    private Object mObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleFrame(FrameFormat frameFormat, FrameManager frameManager) {
        super(frameFormat, frameManager);
        initWithFormat(frameFormat);
        setReusable(false);
    }

    private void initWithFormat(FrameFormat frameFormat) {
        int length = frameFormat.getLength();
        switch (frameFormat.getBaseType()) {
            case 2:
                this.mObject = new byte[length];
                return;
            case 3:
                this.mObject = new short[length];
                return;
            case 4:
                this.mObject = new int[length];
                return;
            case 5:
                this.mObject = new float[length];
                return;
            case 6:
                this.mObject = new double[length];
                return;
            default:
                this.mObject = null;
                return;
        }
    }

    private void setFormatObjectClass(Class cls) {
        MutableFrameFormat mutableCopy = getFormat().mutableCopy();
        mutableCopy.setObjectClass(cls);
        setFormat(mutableCopy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleFrame wrapObject(Object obj, FrameManager frameManager) {
        SimpleFrame simpleFrame = new SimpleFrame(ObjectFormat.fromObject(obj, 1), frameManager);
        simpleFrame.setObjectValue(obj);
        return simpleFrame;
    }

    @Override // android.filterfw.core.Frame
    public Bitmap getBitmap() {
        if (this.mObject instanceof Bitmap) {
            return (Bitmap) this.mObject;
        }
        return null;
    }

    @Override // android.filterfw.core.Frame
    public ByteBuffer getData() {
        if (this.mObject instanceof ByteBuffer) {
            return (ByteBuffer) this.mObject;
        }
        return null;
    }

    @Override // android.filterfw.core.Frame
    public float[] getFloats() {
        if (this.mObject instanceof float[]) {
            return (float[]) this.mObject;
        }
        return null;
    }

    @Override // android.filterfw.core.Frame
    public int[] getInts() {
        if (this.mObject instanceof int[]) {
            return (int[]) this.mObject;
        }
        return null;
    }

    @Override // android.filterfw.core.Frame
    public Object getObjectValue() {
        return this.mObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.filterfw.core.Frame
    public boolean hasNativeAllocation() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.filterfw.core.Frame
    public void releaseNativeAllocation() {
    }

    @Override // android.filterfw.core.Frame
    public void setBitmap(Bitmap bitmap) {
        assertFrameMutable();
        setGenericObjectValue(bitmap);
    }

    @Override // android.filterfw.core.Frame
    public void setData(ByteBuffer byteBuffer, int i, int i2) {
        assertFrameMutable();
        setGenericObjectValue(ByteBuffer.wrap(byteBuffer.array(), i, i2));
    }

    @Override // android.filterfw.core.Frame
    public void setFloats(float[] fArr) {
        assertFrameMutable();
        setGenericObjectValue(fArr);
    }

    @Override // android.filterfw.core.Frame
    protected void setGenericObjectValue(Object obj) {
        FrameFormat format = getFormat();
        if (format.getObjectClass() == null) {
            setFormatObjectClass(obj.getClass());
        } else if (!format.getObjectClass().isAssignableFrom(obj.getClass())) {
            throw new RuntimeException("Attempting to set object value of type '" + obj.getClass() + "' on SimpleFrame of type '" + format.getObjectClass() + "'!");
        }
        this.mObject = obj;
    }

    @Override // android.filterfw.core.Frame
    public void setInts(int[] iArr) {
        assertFrameMutable();
        setGenericObjectValue(iArr);
    }

    public String toString() {
        return "SimpleFrame (" + getFormat() + ")";
    }
}
