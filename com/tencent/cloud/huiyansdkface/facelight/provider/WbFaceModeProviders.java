package com.tencent.cloud.huiyansdkface.facelight.provider;

import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/WbFaceModeProviders.class */
public class WbFaceModeProviders {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21964a;
    private static WbFaceModeInterface b;

    /* renamed from: c  reason: collision with root package name */
    private static WbFaceModeInterface f21965c = new WbFaceLiveImpl();

    static {
        try {
            Class.forName("com.tencent.cloud.huiyansdkface.wbwillexpressionsdk.WbFaceWillImpl");
            f21964a = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            f21964a = false;
        }
    }

    public static WbFaceModeInterface faceMode() {
        if (d.z().x().T() && f21964a) {
            try {
                if (b != null) {
                    return b;
                }
                WbFaceModeInterface wbFaceModeInterface = (WbFaceModeInterface) Class.forName("com.tencent.cloud.huiyansdkface.wbwillexpressionsdk.WbFaceWillImpl").getConstructor(WbFaceModeInterface.class).newInstance(f21965c);
                b = wbFaceModeInterface;
                return wbFaceModeInterface;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("can't load WbWillExpressionHelper!");
            }
        }
        return f21965c;
    }

    public static boolean isUseWillSdk() {
        boolean z = d.z().x().T() && f21964a;
        WLogger.d("WbFaceModeProviders", "hasWbIntentionSdk:" + f21964a + ";isUseWillSdk =" + z);
        return z;
    }
}
