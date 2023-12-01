package com.zego.ve;

import android.media.Image;
import android.media.ImageReader;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VImageReader.class */
public class VImageReader implements ImageReader.OnImageAvailableListener {
    private static final String TAG = "VImageReader";
    private long pthis = 0;
    private ImageReader mImgRdr = null;
    private Image mImg = null;
    private Object mLock = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VImageReader$ImageReaderBuffer.class */
    static class ImageReaderBuffer {
        private ByteBuffer uBuffer;
        private ByteBuffer vBuffer;
        private ByteBuffer yBuffer;

        public ImageReaderBuffer(Image.Plane[] planeArr) {
            this.yBuffer = planeArr[0].getBuffer();
            this.uBuffer = planeArr[1].getBuffer();
            this.vBuffer = planeArr[2].getBuffer();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VImageReader$ImageReaderFormat.class */
    static class ImageReaderFormat {
        int height;
        int uvPixelStride;
        int uvStride;
        int width;
        int yStride;

        public ImageReaderFormat(int i, int i2, Image.Plane[] planeArr) {
            this.width = i;
            this.height = i2;
            this.yStride = planeArr[0].getRowStride();
            this.uvStride = planeArr[1].getRowStride();
            this.uvPixelStride = planeArr[1].getPixelStride();
        }
    }

    private void closeImage() {
        Image image = this.mImg;
        if (image != null) {
            image.close();
        }
    }

    private ImageReaderBuffer getImageReaderBuffer() {
        try {
            Image acquireLatestImage = this.mImgRdr.acquireLatestImage();
            this.mImg = acquireLatestImage;
            if (acquireLatestImage == null) {
                android.util.Log.e(TAG, "acquired null image from image reader");
                return null;
            }
            Image.Plane[] planes = acquireLatestImage.getPlanes();
            if (planes.length > 1) {
                return new ImageReaderBuffer(planes);
            }
            android.util.Log.e(TAG, "image is not accessable");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ImageReaderFormat getImageReaderFormat() {
        try {
            Image acquireLatestImage = this.mImgRdr.acquireLatestImage();
            this.mImg = acquireLatestImage;
            if (acquireLatestImage == null) {
                android.util.Log.e(TAG, "acquired null image from image reader");
                return null;
            }
            Image.Plane[] planes = acquireLatestImage.getPlanes();
            if (planes.length > 1) {
                return new ImageReaderFormat(this.mImg.getWidth(), this.mImg.getHeight(), planes);
            }
            android.util.Log.e(TAG, "image is not accessable");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static native int on_image(long j, int i);

    public int create(long j, int i, int i2) {
        this.pthis = j;
        try {
            ImageReader newInstance = ImageReader.newInstance(i, i2, 35, 2);
            this.mImgRdr = newInstance;
            newInstance.setOnImageAvailableListener(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageReader imageReader = this.mImgRdr;
        if (imageReader == null) {
            return -1;
        }
        return imageReader.hashCode();
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.pthis = 0L;
        }
        Image image = this.mImg;
        if (image != null) {
            image.close();
            this.mImg = null;
        }
        this.mImgRdr.setOnImageAvailableListener(null, null);
        this.mImgRdr.close();
        this.mImgRdr = null;
    }

    public ImageReader get() {
        return this.mImgRdr;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        try {
            synchronized (this.mLock) {
                if (this.pthis != 0) {
                    on_image(this.pthis, imageReader.hashCode());
                } else {
                    android.util.Log.d(TAG, "ignore callback:");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
