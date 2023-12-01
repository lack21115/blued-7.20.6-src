package com.tencent.liteav.beauty;

import android.util.SparseBooleanArray;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.zego.zegoavkit2.entities.ZegoStreamRelayCDNInfo;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final C0926a[] f36347a = {new C0926a(l.a.FACE_SLIM, TXLiteAVCode.WARNING_SCREEN_CAPTURE_NOT_AUTHORIZED, "reportFaceSlimDua", (byte) 0), new C0926a(l.a.EYE_SCALE, 1205, "reportEyeScaleDua", (byte) 0), new C0926a(l.a.FACE_V_SHAPE, ZegoStreamRelayCDNInfo.Detail.MIXSTREAM_ALL_INPUT_STREAM_CLOSED, "reportFaceVDua", (byte) 0), new C0926a(l.a.FACE_SHORT, 1216, "reportFaceShortDua", (byte) 0), new C0926a(l.a.CHIN_SCALE, ZegoStreamRelayCDNInfo.Detail.MIXSTREAM_ALL_INPUT_STREAM_NODATA, "reportChinDua", (byte) 0), new C0926a(l.a.NOSE_SLIM, 1217, "reportNoseSlimDua", (byte) 0), new C0926a(l.a.FOREHEAD, 1221, "reportForeheadDua", (byte) 0), new C0926a(l.a.EYE_DISTANCE, 1222, "reportEyeDistanceDua", (byte) 0), new C0926a(l.a.EYE_ANGLE, 1223, "reportEyeAngleDua", (byte) 0), new C0926a(l.a.MOUTH_SHAPE, 1224, "reportMouthShapeDua", (byte) 0), new C0926a(l.a.NOSE_WING, 1225, "reportNoseWingDua", (byte) 0), new C0926a(l.a.NOSE_POSITION, 1226, "reportNosePositionDua", (byte) 0), new C0926a(l.a.LIPS_THICKNESS, 1227, "reportLipsThicknessDua", (byte) 0), new C0926a(l.a.BASIC3, 1213, "reportFaceBeautyDua", (byte) 0), new C0926a(l.a.EYE_LIGHTEN, 1229, "reportEyeLightenDua", (byte) 0), new C0926a(l.a.TOOTH_WHITEN, 1230, "reportToothWhitenDua", (byte) 0), new C0926a(l.a.REMOVE_WRINKLES, 1218, "reportWrinkleRemoveDua", (byte) 0), new C0926a(l.a.REMOVE_POUNCH, 1219, "reportPounchRemoveDua", (byte) 0), new C0926a(l.a.REMOVE_SMILE_LINES, 1220, "reportSmileLinesRemoveDua", (byte) 0)};
    private static final SparseBooleanArray b = new SparseBooleanArray();

    /* renamed from: com.tencent.liteav.beauty.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/a$a.class */
    static final class C0926a {

        /* renamed from: a  reason: collision with root package name */
        public final l.a f36348a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final String f36349c;

        private C0926a(l.a aVar, int i, String str) {
            this.f36348a = aVar;
            this.b = i;
            this.f36349c = str;
        }

        /* synthetic */ C0926a(l.a aVar, int i, String str, byte b) {
            this(aVar, i, str);
        }
    }

    public static void a(IVideoReporter iVideoReporter) {
        b.clear();
        a(iVideoReporter, 1201, "reportSDKInit!");
    }

    private static void a(IVideoReporter iVideoReporter, int i, String str) {
        synchronized (a.class) {
            try {
                if (b.get(i)) {
                    return;
                }
                b.put(i, true);
                LiteavLog.i("ReportDauManager", "report DAU eventId: %d", Integer.valueOf(i));
                if (iVideoReporter != null) {
                    h.b bVar = h.b.EVT_VIDEO_PREPROCESS_COSMETIC_FIRST_USE;
                    iVideoReporter.notifyEvent(bVar, "report DAU eventId:" + i + " errorInfo:" + str, new Object[0]);
                }
            } finally {
            }
        }
    }

    public static void a(IVideoReporter iVideoReporter, l.a aVar) {
        C0926a[] c0926aArr = f36347a;
        int length = c0926aArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            C0926a c0926a = c0926aArr[i2];
            if (c0926a.f36348a == aVar) {
                a(iVideoReporter, c0926a.b, c0926a.f36349c);
                return;
            }
            i = i2 + 1;
        }
    }

    public static void b(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1202, "reportBeautyDua");
    }

    public static void c(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1203, "reportWhiteDua");
    }

    public static void d(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1210, "reportSharpDua");
    }

    public static void e(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1204, "reportRuddyDua");
    }

    public static void f(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1208, "reportFilterImageDua");
    }

    public static void g(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1211, "reportTemplateDua");
    }

    public static void h(IVideoReporter iVideoReporter) {
        a(iVideoReporter, 1212, "reportWarterMarkDua");
    }
}
