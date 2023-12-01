package com.tencent.cloud.huiyansdkface.facelight.c.d;

import android.content.Context;
import android.hardware.Camera;
import android.view.View;
import com.tencent.cloud.huiyansdkface.a.g.a;
import com.tencent.cloud.huiyansdkface.facelight.c.a.e;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.turingcam.TuringFaceBuilder;
import com.tencent.turingcam.TuringFaceDefender;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/d/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f21889a;
    private static boolean b;

    static {
        try {
            Class.forName("com.tencent.turingcam.TuringFaceDefender");
            b = true;
        } catch (ClassNotFoundException e) {
            b = false;
        }
        f21889a = new c() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.d.d.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public View a(Context context) {
                return null;
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public e a() {
                WLogger.d("WbDeviceRiskProviders", "get null turing cameraPreview,use system");
                return null;
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public void a(Camera camera) {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public void a(Camera camera, String str) {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public void a(a.InterfaceC0735a interfaceC0735a) {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public void a(byte[] bArr) {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public boolean b() {
                return false;
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.c.d.c
            public void c() {
            }
        };
    }

    public static c a() {
        return b ? new a() : f21889a;
    }

    public static void a(Context context) {
        if (!b) {
            WLogger.d("WbDeviceRiskProviders", "get null turing sdk");
            return;
        }
        TuringFaceBuilder build = TuringFaceBuilder.build();
        build.setContext(context);
        TuringFaceDefender.init(build);
    }

    public static String b() {
        return b ? TuringFaceDefender.getSDKVersion() : "empty turing face";
    }

    public static String b(Context context) {
        if (!b) {
            WLogger.d("WbDeviceRiskProviders", "get null turing sdk");
            return "";
        }
        JSONObject deviceInfo = TuringFaceDefender.getDeviceInfo(context);
        WLogger.d("WbDeviceRiskProviders", "di:" + deviceInfo.toString());
        try {
            b bVar = (b) new WeJson().fromJsonObj(deviceInfo, b.class);
            return bVar != null ? bVar.toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
