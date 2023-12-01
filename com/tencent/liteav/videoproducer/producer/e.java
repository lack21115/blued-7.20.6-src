package com.tencent.liteav.videoproducer.producer;

import android.util.LongSparseArray;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    final LongSparseArray<a> f37149a = new LongSparseArray<>();
    long b = -1;

    /* renamed from: c  reason: collision with root package name */
    CaptureSourceInterface.SourceType f37150c = CaptureSourceInterface.SourceType.NONE;
    Rotation d = Rotation.NORMAL;
    VideoProducerDef.HomeOrientation e = VideoProducerDef.HomeOrientation.UNSET;
    VideoProducerDef.GSensorMode f = VideoProducerDef.GSensorMode.UI_FIX_LAYOUT;

    /* renamed from: com.tencent.liteav.videoproducer.producer.e$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/e$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37151a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[VideoProducerDef.HomeOrientation.values().length];
            f37151a = iArr;
            try {
                iArr[VideoProducerDef.HomeOrientation.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f37151a[VideoProducerDef.HomeOrientation.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f37151a[VideoProducerDef.HomeOrientation.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f37151a[VideoProducerDef.HomeOrientation.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f37151a[VideoProducerDef.HomeOrientation.UNSET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f37152a;
        public GLConstants.MirrorMode b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37153c;

        private a() {
            this.f37152a = false;
            this.b = GLConstants.MirrorMode.AUTO;
            this.f37153c = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/e$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f37154a = false;
        boolean b = false;
    }

    public final b a(long j) {
        b bVar = new b();
        a b2 = b(j);
        if (this.f37150c == CaptureSourceInterface.SourceType.CUSTOM) {
            bVar.f37154a = b2.f37153c;
            return bVar;
        }
        if (this.f37150c == CaptureSourceInterface.SourceType.CAMERA) {
            if (!b2.f37153c) {
                return bVar;
            }
            int i = AnonymousClass1.f37151a[this.e.ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 || i == 4) {
                    bVar.b = b2.f37153c;
                    return bVar;
                } else if (i != 5) {
                    return bVar;
                } else {
                    if (this.f == VideoProducerDef.GSensorMode.DISABLE || !(this.d == Rotation.ROTATION_90 || this.d == Rotation.ROTATION_270)) {
                        bVar.f37154a = b2.f37153c;
                        return bVar;
                    }
                    bVar.b = b2.f37153c;
                    return bVar;
                }
            }
            bVar.f37154a = b2.f37153c;
        }
        return bVar;
    }

    public final void a(long j, GLConstants.MirrorMode mirrorMode) {
        b(j).b = mirrorMode;
    }

    public final void a(long j, boolean z) {
        b(j).f37153c = z;
    }

    public final void a(CaptureSourceInterface.SourceType sourceType) {
        CaptureSourceInterface.SourceType sourceType2 = sourceType;
        if (sourceType == null) {
            sourceType2 = CaptureSourceInterface.SourceType.NONE;
        }
        this.f37150c = sourceType2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a b(long j) {
        a aVar = this.f37149a.get(j);
        a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = new a((byte) 0);
            this.f37149a.put(j, aVar2);
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(long j) {
        a b2 = b(j);
        return b2.f37152a ? b2.b != GLConstants.MirrorMode.DISABLE : b2.b == GLConstants.MirrorMode.ENABLE;
    }
}
