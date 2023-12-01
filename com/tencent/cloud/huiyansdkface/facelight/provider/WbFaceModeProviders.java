package com.tencent.cloud.huiyansdkface.facelight.provider;

import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/WbFaceModeProviders.class */
public class WbFaceModeProviders {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f35655a;
    private static WbFaceModeInterface b;

    /* renamed from: c  reason: collision with root package name */
    private static WbFaceModeInterface f35656c = new WbFaceLiveImpl();

    static {
        try {
            Class.forName("com.tencent.cloud.huiyansdkface.wbwillexpressionsdk.WbFaceWillImpl");
            f35655a = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            f35655a = false;
        }
    }

    public static WbFaceModeInterface faceMode() {
        if (d.z().x().T() && f35655a) {
            try {
                if (b != null) {
                    return b;
                }
                WbFaceModeInterface wbFaceModeInterface = (WbFaceModeInterface) Class.forName("com.tencent.cloud.huiyansdkface.wbwillexpressionsdk.WbFaceWillImpl").getConstructor(WbFaceModeInterface.class).newInstance(f35656c);
                b = wbFaceModeInterface;
                return wbFaceModeInterface;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("can't load WbWillExpressionHelper!");
            }
        }
        return f35656c;
    }

    public static boolean isUseWillSdk() {
        boolean z = d.z().x().T() && f35655a;
        WLogger.d("WbFaceModeProviders", "hasWbIntentionSdk:" + f35655a + ";isUseWillSdk =" + z);
        return z;
    }
}
