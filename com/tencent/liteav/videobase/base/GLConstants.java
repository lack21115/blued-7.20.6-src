package com.tencent.liteav.videobase.base;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/base/GLConstants.class */
public interface GLConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f22906a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] b = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f22907c = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] d = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] e = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] f = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static final float[] g = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/base/GLConstants$GLScaleType.class */
    public enum GLScaleType {
        CENTER_CROP(0),
        FIT_CENTER(1),
        FILL(2);
        
        private static final GLScaleType[] d = values();
        public int mValue;

        GLScaleType(int i) {
            this.mValue = i;
        }

        public static GLScaleType a(int i) {
            GLScaleType[] gLScaleTypeArr = d;
            int length = gLScaleTypeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return FIT_CENTER;
                }
                GLScaleType gLScaleType = gLScaleTypeArr[i3];
                if (gLScaleType.mValue == i) {
                    return gLScaleType;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/base/GLConstants$MirrorMode.class */
    public enum MirrorMode {
        AUTO(0),
        ENABLE(1),
        DISABLE(2);
        
        private static final MirrorMode[] d = values();
        int mValue;

        MirrorMode(int i) {
            this.mValue = i;
        }

        public static MirrorMode a(int i) {
            MirrorMode[] mirrorModeArr = d;
            int length = mirrorModeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return AUTO;
                }
                MirrorMode mirrorMode = mirrorModeArr[i3];
                if (mirrorMode.mValue == i) {
                    return mirrorMode;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/base/GLConstants$Orientation.class */
    public enum Orientation {
        LANDSCAPE(0),
        PORTRAIT(1);
        

        /* renamed from: c  reason: collision with root package name */
        private static final Orientation[] f22913c = values();
        int mValue;

        Orientation(int i) {
            this.mValue = i;
        }

        public static Orientation a(int i) {
            Orientation[] orientationArr = f22913c;
            int length = orientationArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return PORTRAIT;
                }
                Orientation orientation = orientationArr[i3];
                if (orientation.mValue == i) {
                    return orientation;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/base/GLConstants$PixelBufferType.class */
    public enum PixelBufferType {
        BYTE_BUFFER(0),
        TEXTURE_2D(1),
        TEXTURE_OES(2),
        BYTE_ARRAY(3);
        
        private static final PixelBufferType[] e = values();
        public int mValue;

        PixelBufferType(int i) {
            this.mValue = i;
        }

        public static PixelBufferType a(int i) {
            PixelBufferType[] pixelBufferTypeArr = e;
            int length = pixelBufferTypeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return TEXTURE_2D;
                }
                PixelBufferType pixelBufferType = pixelBufferTypeArr[i3];
                if (pixelBufferType.mValue == i) {
                    return pixelBufferType;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/base/GLConstants$PixelFormatType.class */
    public enum PixelFormatType {
        I420(0),
        NV12(1),
        NV21(2),
        RGB(3),
        YUY2(4),
        RGBA(5),
        BGR(6),
        YV12(7),
        BGRA(8),
        ARGB(9),
        YUV422P(10),
        UYVY(11),
        YUYV(12),
        JPG(13),
        H264(14);
        
        private static final PixelFormatType[] p = values();
        private final int mJniValue;

        PixelFormatType(int i) {
            this.mJniValue = i;
        }

        public static PixelFormatType a(int i) {
            PixelFormatType[] pixelFormatTypeArr = p;
            int length = pixelFormatTypeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                PixelFormatType pixelFormatType = pixelFormatTypeArr[i3];
                if (pixelFormatType.mJniValue == i) {
                    return pixelFormatType;
                }
                i2 = i3 + 1;
            }
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }
}
