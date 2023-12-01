package com.tencent.turingcam;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import com.tencent.turingcam.z5VDt;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/TuringFaceDefender.class */
public class TuringFaceDefender {
    public static JSONObject getDeviceInfo(Context context) {
        return d5HOq.a().a(context);
    }

    public static String getSDKVersion() {
        return "2.0.3";
    }

    public static void init(TuringFaceBuilder turingFaceBuilder) {
        int i = z5VDt.j;
        z5VDt.Bi3eT.a().a(turingFaceBuilder);
    }

    public static void processFrame(byte[] bArr) {
        int i = z5VDt.j;
        z5VDt.Bi3eT.a().a(bArr);
    }

    public static void setCallback(TuringCallback turingCallback) {
        if (turingCallback == null) {
            int i = z5VDt.j;
            z5VDt.Bi3eT.a().a((z5VDt.B9LVG) null);
            return;
        }
        int i2 = z5VDt.j;
        z5VDt.Bi3eT.a().a(new F2BEC(turingCallback));
    }

    public static void setPreviewDisplay(Camera camera, TuringPreviewDisplay turingPreviewDisplay) {
        int i = z5VDt.j;
        z5VDt.Bi3eT.a().a(camera, turingPreviewDisplay);
    }

    public static void start(Camera camera, String str) {
        int i = z5VDt.j;
        z5VDt.Bi3eT.a().a(camera, str);
    }

    public static void startFrameCheck(String str) {
        int i = z5VDt.j;
        z5VDt.Bi3eT.a().a(str);
    }
}
