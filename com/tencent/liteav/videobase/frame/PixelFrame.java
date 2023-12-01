package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.Rotation;
import java.nio.ByteBuffer;
import java.util.Collection;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/PixelFrame.class */
public class PixelFrame extends k {
    protected ByteBuffer mBuffer;
    protected byte[] mData;
    protected Object mGLContext;
    protected int mHeight;
    private boolean mIsMirrorHorizontal;
    private boolean mIsMirrorVertical;
    private float[] mMatrix;
    protected GLConstants.PixelBufferType mPixelBufferType;
    protected GLConstants.PixelFormatType mPixelFormatType;
    private Rotation mRotation;
    protected int mTextureId;
    private long mTimestamp;
    protected int mWidth;

    public PixelFrame() {
        super(null);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
    }

    public PixelFrame(int i, int i2, int i3, int i4, int i5) {
        this(null, i, i2, i3, GLConstants.PixelBufferType.a(i4), GLConstants.PixelFormatType.a(i5));
    }

    public PixelFrame(PixelFrame pixelFrame) {
        super(null);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        copy(pixelFrame);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PixelFrame(g<? extends PixelFrame> gVar) {
        super(gVar);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
    }

    public PixelFrame(g<PixelFrame> gVar, int i, int i2, int i3, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        super(gVar);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRotation = Rotation.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mWidth = i;
        this.mHeight = i2;
        this.mPixelFormatType = pixelFormatType;
        this.mPixelBufferType = pixelBufferType;
        if (pixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY) {
            this.mData = new byte[i3];
        } else {
            this.mBuffer = ByteBuffer.allocateDirect(i3);
        }
    }

    public PixelFrame(g<PixelFrame> gVar, int i, int i2, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        this(gVar, i, i2, pixelFormatType == GLConstants.PixelFormatType.RGBA ? i * i2 * 4 : ((i * i2) * 3) / 2, pixelBufferType, pixelFormatType);
    }

    private int getPixelBufferTypeValue() {
        return this.mPixelBufferType.mValue;
    }

    private int getPixelFormatTypeValue() {
        return this.mPixelFormatType.getValue();
    }

    public static void releasePixelFrames(Collection<PixelFrame> collection) {
        if (collection == null) {
            return;
        }
        for (PixelFrame pixelFrame : collection) {
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        }
        collection.clear();
    }

    public void copy(PixelFrame pixelFrame) {
        this.mTimestamp = pixelFrame.mTimestamp;
        this.mWidth = pixelFrame.mWidth;
        this.mHeight = pixelFrame.mHeight;
        this.mPixelBufferType = pixelFrame.mPixelBufferType;
        this.mPixelFormatType = pixelFrame.mPixelFormatType;
        this.mRotation = pixelFrame.mRotation;
        this.mIsMirrorHorizontal = pixelFrame.mIsMirrorHorizontal;
        this.mIsMirrorVertical = pixelFrame.mIsMirrorVertical;
        if (pixelFrame.mMatrix != null) {
            this.mMatrix = new float[16];
            float[] matrix = pixelFrame.getMatrix();
            float[] fArr = this.mMatrix;
            System.arraycopy(matrix, 0, fArr, 0, fArr.length);
        }
        this.mMatrix = pixelFrame.mMatrix;
        this.mData = pixelFrame.mData;
        this.mBuffer = pixelFrame.mBuffer;
        this.mTextureId = pixelFrame.mTextureId;
        this.mGLContext = pixelFrame.mGLContext;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public byte[] getData() {
        return this.mData;
    }

    public Object getGLContext() {
        return this.mGLContext;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public float[] getMatrix() {
        return this.mMatrix;
    }

    public GLConstants.PixelBufferType getPixelBufferType() {
        return this.mPixelBufferType;
    }

    public GLConstants.PixelFormatType getPixelFormatType() {
        return this.mPixelFormatType;
    }

    public Rotation getRotation() {
        return this.mRotation;
    }

    public int getTextureId() {
        return this.mTextureId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasTransformParams() {
        return this.mRotation != Rotation.NORMAL || this.mIsMirrorHorizontal || this.mIsMirrorVertical || this.mMatrix != null;
    }

    public boolean isFrameDataValid() {
        if (this.mPixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D && this.mTextureId == -1) {
            return false;
        }
        if (this.mPixelBufferType == GLConstants.PixelBufferType.BYTE_BUFFER && this.mBuffer == null) {
            return false;
        }
        return (this.mPixelBufferType == GLConstants.PixelBufferType.BYTE_ARRAY && this.mData == null) ? false : true;
    }

    public boolean isMirrorHorizontal() {
        return this.mIsMirrorHorizontal;
    }

    public boolean isMirrorVertical() {
        return this.mIsMirrorVertical;
    }

    public void postRotate(Rotation rotation) {
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            swapWidthHeight();
        }
        setRotation(Rotation.a((this.mRotation.mValue + rotation.mValue) % 360));
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setGLContext(Object obj) {
        this.mGLContext = obj;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setMatrix(float[] fArr) {
        this.mMatrix = fArr;
    }

    public void setMirrorHorizontal(boolean z) {
        this.mIsMirrorHorizontal = z;
    }

    public void setMirrorVertical(boolean z) {
        this.mIsMirrorVertical = z;
    }

    public void setPixelBufferType(GLConstants.PixelBufferType pixelBufferType) {
        this.mPixelBufferType = pixelBufferType;
    }

    public void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
        this.mPixelFormatType = pixelFormatType;
    }

    public void setRotation(Rotation rotation) {
        this.mRotation = rotation;
    }

    public void setTextureId(int i) {
        this.mTextureId = i;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void swapWidthHeight() {
        int i = this.mWidth;
        this.mWidth = this.mHeight;
        this.mHeight = i;
    }
}
