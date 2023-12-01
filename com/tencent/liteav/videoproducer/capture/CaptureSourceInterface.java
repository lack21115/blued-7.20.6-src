package com.tencent.liteav.videoproducer.capture;

import android.graphics.Rect;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CaptureSourceInterface.class */
public interface CaptureSourceInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CaptureSourceInterface$CaptureParams.class */
    public static class CaptureParams {
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f23155c;
        public int d;
        public Rect e;

        public CaptureParams() {
        }

        public CaptureParams(CaptureParams captureParams) {
            this.b = captureParams.b;
            this.f23155c = captureParams.f23155c;
            this.d = captureParams.d;
            this.e = captureParams.e;
        }

        public boolean equals(Object obj) {
            if (obj instanceof CaptureParams) {
                CaptureParams captureParams = (CaptureParams) obj;
                return this.b == captureParams.b && this.f23155c == captureParams.f23155c && this.d == captureParams.d;
            }
            return false;
        }

        public String toString() {
            return String.format(Locale.ENGLISH, "size: %dx%d, fps: %d", Integer.valueOf(this.f23155c), Integer.valueOf(this.d), Integer.valueOf(this.b));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CaptureSourceInterface$SourceType.class */
    public enum SourceType {
        NONE(0),
        CAMERA(1),
        SCREEN(2),
        VIRTUAL_CAMERA(3),
        CUSTOM(4);
        
        private static final SourceType[] f = values();
        private final int mValue;

        SourceType(int i) {
            this.mValue = i;
        }

        public static SourceType a(int i) {
            SourceType[] sourceTypeArr = f;
            int length = sourceTypeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return NONE;
                }
                SourceType sourceType = sourceTypeArr[i3];
                if (sourceType.mValue == i) {
                    return sourceType;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CaptureSourceInterface$a.class */
    public interface a {
        void a();

        void a(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame);

        void a(boolean z);

        void b(boolean z);

        void c(boolean z);

        void d(boolean z);
    }

    void pause();

    void resume();

    void start(Object obj, CaptureParams captureParams, a aVar);

    void stop();

    void updateParams(CaptureParams captureParams);
}
