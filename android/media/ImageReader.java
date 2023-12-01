package android.media;

import android.graphics.ImageFormat;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.NioUtils;

/* loaded from: source-9557208-dex2jar.jar:android/media/ImageReader.class */
public class ImageReader implements AutoCloseable {
    private static final int ACQUIRE_MAX_IMAGES = 2;
    private static final int ACQUIRE_NO_BUFS = 1;
    private static final int ACQUIRE_SUCCESS = 0;
    private final int mFormat;
    private final int mHeight;
    private OnImageAvailableListener mListener;
    private ListenerHandler mListenerHandler;
    private final Object mListenerLock = new Object();
    private final int mMaxImages;
    private long mNativeContext;
    private final int mNumPlanes;
    private final Surface mSurface;
    private final int mWidth;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/ImageReader$ListenerHandler.class */
    public final class ListenerHandler extends Handler {
        public ListenerHandler(Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnImageAvailableListener onImageAvailableListener;
            synchronized (ImageReader.this.mListenerLock) {
                onImageAvailableListener = ImageReader.this.mListener;
            }
            if (onImageAvailableListener != null) {
                onImageAvailableListener.onImageAvailable(ImageReader.this);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/ImageReader$OnImageAvailableListener.class */
    public interface OnImageAvailableListener {
        void onImageAvailable(ImageReader imageReader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/ImageReader$SurfaceImage.class */
    public class SurfaceImage extends Image {
        private long mLockedBuffer;
        private SurfacePlane[] mPlanes;
        private long mTimestamp;
        private int mHeight = -1;
        private int mWidth = -1;
        private boolean mIsImageValid = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/ImageReader$SurfaceImage$SurfacePlane.class */
        public class SurfacePlane extends Image.Plane {
            private ByteBuffer mBuffer;
            private final int mIndex;
            private final int mPixelStride;
            private final int mRowStride;

            private SurfacePlane(int i, int i2, int i3) {
                this.mIndex = i;
                this.mRowStride = i2;
                this.mPixelStride = i3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBuffer() {
                if (this.mBuffer == null) {
                    return;
                }
                if (this.mBuffer.isDirect()) {
                    NioUtils.freeDirectBuffer(this.mBuffer);
                }
                this.mBuffer = null;
            }

            @Override // android.media.Image.Plane
            public ByteBuffer getBuffer() {
                if (SurfaceImage.this.isImageValid()) {
                    if (this.mBuffer != null) {
                        return this.mBuffer;
                    }
                    this.mBuffer = SurfaceImage.this.nativeImageGetBuffer(this.mIndex, ImageReader.this.mFormat);
                    return this.mBuffer.order(ByteOrder.nativeOrder());
                }
                throw new IllegalStateException("Image is already released");
            }

            @Override // android.media.Image.Plane
            public int getPixelStride() {
                if (SurfaceImage.this.isImageValid()) {
                    return this.mPixelStride;
                }
                throw new IllegalStateException("Image is already released");
            }

            @Override // android.media.Image.Plane
            public int getRowStride() {
                if (SurfaceImage.this.isImageValid()) {
                    return this.mRowStride;
                }
                throw new IllegalStateException("Image is already released");
            }
        }

        public SurfaceImage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSurfacePlanes() {
            if (!this.mIsImageValid) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mPlanes.length) {
                    return;
                }
                if (this.mPlanes[i2] != null) {
                    this.mPlanes[i2].clearBuffer();
                    this.mPlanes[i2] = null;
                }
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createSurfacePlanes() {
            this.mPlanes = new SurfacePlane[ImageReader.this.mNumPlanes];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ImageReader.this.mNumPlanes) {
                    return;
                }
                this.mPlanes[i2] = nativeCreatePlane(i2, ImageReader.this.mFormat);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isImageValid() {
            return this.mIsImageValid;
        }

        private native synchronized SurfacePlane nativeCreatePlane(int i, int i2);

        private native synchronized int nativeGetHeight();

        private native synchronized int nativeGetWidth();

        /* JADX INFO: Access modifiers changed from: private */
        public native synchronized ByteBuffer nativeImageGetBuffer(int i, int i2);

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageValid(boolean z) {
            this.mIsImageValid = z;
        }

        @Override // android.media.Image, java.lang.AutoCloseable
        public void close() {
            if (this.mIsImageValid) {
                ImageReader.this.releaseImage(this);
            }
        }

        protected final void finalize() throws Throwable {
            try {
                close();
            } finally {
                super.finalize();
            }
        }

        @Override // android.media.Image
        public int getFormat() {
            if (this.mIsImageValid) {
                return ImageReader.this.mFormat;
            }
            throw new IllegalStateException("Image is already released");
        }

        @Override // android.media.Image
        public int getHeight() {
            if (this.mIsImageValid) {
                if (this.mHeight == -1) {
                    this.mHeight = getFormat() == 256 ? ImageReader.this.getHeight() : nativeGetHeight();
                }
                return this.mHeight;
            }
            throw new IllegalStateException("Image is already released");
        }

        @Override // android.media.Image
        public Image.Plane[] getPlanes() {
            if (this.mIsImageValid) {
                return (Image.Plane[]) this.mPlanes.clone();
            }
            throw new IllegalStateException("Image is already released");
        }

        public ImageReader getReader() {
            return ImageReader.this;
        }

        @Override // android.media.Image
        public long getTimestamp() {
            if (this.mIsImageValid) {
                return this.mTimestamp;
            }
            throw new IllegalStateException("Image is already released");
        }

        @Override // android.media.Image
        public int getWidth() {
            if (this.mIsImageValid) {
                if (this.mWidth == -1) {
                    this.mWidth = getFormat() == 256 ? ImageReader.this.getWidth() : nativeGetWidth();
                }
                return this.mWidth;
            }
            throw new IllegalStateException("Image is already released");
        }
    }

    static {
        System.loadLibrary("media_jni");
        nativeClassInit();
    }

    protected ImageReader(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mFormat = i3;
        this.mMaxImages = i4;
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("The image dimensions must be positive");
        }
        if (this.mMaxImages < 1) {
            throw new IllegalArgumentException("Maximum outstanding image count must be at least 1");
        }
        if (i3 == 17) {
            throw new IllegalArgumentException("NV21 format is not supported");
        }
        this.mNumPlanes = getNumPlanesFromFormat();
        nativeInit(new WeakReference(this), i, i2, i3, i4);
        this.mSurface = nativeGetSurface();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int acquireNextSurfaceImage(SurfaceImage surfaceImage) {
        int nativeImageSetup = nativeImageSetup(surfaceImage);
        switch (nativeImageSetup) {
            case 0:
                surfaceImage.createSurfacePlanes();
                surfaceImage.setImageValid(true);
                break;
            case 1:
            case 2:
                break;
            default:
                throw new AssertionError("Unknown nativeImageSetup return code " + nativeImageSetup);
        }
        return nativeImageSetup;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getNumPlanesFromFormat() {
        int i = 1;
        switch (this.mFormat) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 20:
            case 32:
            case 37:
            case 256:
            case ImageFormat.Y8 /* 538982489 */:
            case ImageFormat.Y16 /* 540422489 */:
                break;
            case 16:
                return 2;
            case 17:
            case 35:
            case ImageFormat.YV12 /* 842094169 */:
                i = 3;
                break;
            default:
                throw new UnsupportedOperationException(String.format("Invalid format specified %d", Integer.valueOf(this.mFormat)));
        }
        return i;
    }

    private static native void nativeClassInit();

    private native synchronized void nativeClose();

    private native synchronized Surface nativeGetSurface();

    private native synchronized int nativeImageSetup(Image image);

    private native synchronized void nativeInit(Object obj, int i, int i2, int i3, int i4);

    private native synchronized void nativeReleaseImage(Image image);

    public static ImageReader newInstance(int i, int i2, int i3, int i4) {
        return new ImageReader(i, i2, i3, i4);
    }

    private static void postEventFromNative(Object obj) {
        ListenerHandler listenerHandler;
        ImageReader imageReader = (ImageReader) ((WeakReference) obj).get();
        if (imageReader == null) {
            return;
        }
        synchronized (imageReader.mListenerLock) {
            listenerHandler = imageReader.mListenerHandler;
        }
        if (listenerHandler != null) {
            listenerHandler.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseImage(Image image) {
        if (!(image instanceof SurfaceImage)) {
            throw new IllegalArgumentException("This image was not produced by an ImageReader");
        }
        SurfaceImage surfaceImage = (SurfaceImage) image;
        if (surfaceImage.getReader() != this) {
            throw new IllegalArgumentException("This image was not produced by this ImageReader");
        }
        surfaceImage.clearSurfacePlanes();
        nativeReleaseImage(image);
        surfaceImage.setImageValid(false);
    }

    public Image acquireLatestImage() {
        Image acquireNextImage = acquireNextImage();
        Image image = acquireNextImage;
        if (acquireNextImage == null) {
            image = null;
        } else {
            while (true) {
                try {
                    Image acquireNextImageNoThrowISE = acquireNextImageNoThrowISE();
                    if (acquireNextImageNoThrowISE == null) {
                        break;
                    }
                    image.close();
                    image = acquireNextImageNoThrowISE;
                } catch (Throwable th) {
                    if (image != null) {
                        image.close();
                    }
                    throw th;
                }
            }
            if (0 != 0) {
                throw new NullPointerException();
            }
        }
        return image;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Image acquireNextImage() {
        SurfaceImage surfaceImage = new SurfaceImage();
        int acquireNextSurfaceImage = acquireNextSurfaceImage(surfaceImage);
        switch (acquireNextSurfaceImage) {
            case 0:
                break;
            case 1:
                surfaceImage = null;
                break;
            case 2:
                throw new IllegalStateException(String.format("maxImages (%d) has already been acquired, call #close before acquiring more.", Integer.valueOf(this.mMaxImages)));
            default:
                throw new AssertionError("Unknown nativeImageSetup return code " + acquireNextSurfaceImage);
        }
        return surfaceImage;
    }

    public Image acquireNextImageNoThrowISE() {
        SurfaceImage surfaceImage = new SurfaceImage();
        if (acquireNextSurfaceImage(surfaceImage) == 0) {
            return surfaceImage;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        setOnImageAvailableListener(null, null);
        nativeClose();
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getImageFormat() {
        return this.mFormat;
    }

    public int getMaxImages() {
        return this.mMaxImages;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setOnImageAvailableListener(OnImageAvailableListener onImageAvailableListener, Handler handler) {
        synchronized (this.mListenerLock) {
            if (onImageAvailableListener != null) {
                Looper looper = handler != null ? handler.getLooper() : Looper.myLooper();
                if (looper == null) {
                    throw new IllegalArgumentException("handler is null but the current thread is not a looper");
                }
                if (this.mListenerHandler == null || this.mListenerHandler.getLooper() != looper) {
                    this.mListenerHandler = new ListenerHandler(looper);
                }
                this.mListener = onImageAvailableListener;
            } else {
                this.mListener = null;
                this.mListenerHandler = null;
            }
        }
    }
}
