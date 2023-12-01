package com.anythink.china.api;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.anythink.china.activity.TransparentActivity;
import com.anythink.china.common.d;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/api/ATChinaSDKHandler.class */
public class ATChinaSDKHandler {
    private static boolean allowUserOaidSDK = true;

    public static void handleInitOaidSDK(Context context, final OaidSDKCallbackListener oaidSDKCallbackListener) {
        try {
            if (allowUserOaidSDK) {
                MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.anythink.china.api.ATChinaSDKHandler.1
                    public void OnSupport(boolean z, IdSupplier idSupplier) {
                        OaidSDKCallbackListener oaidSDKCallbackListener2 = OaidSDKCallbackListener.this;
                        if (oaidSDKCallbackListener2 != null) {
                            oaidSDKCallbackListener2.OnSupport(z, idSupplier);
                        }
                    }

                    public void onSupport(IdSupplier idSupplier) {
                        OaidSDKCallbackListener oaidSDKCallbackListener2 = OaidSDKCallbackListener.this;
                        if (oaidSDKCallbackListener2 != null) {
                            oaidSDKCallbackListener2.onSupport(idSupplier);
                        }
                    }
                });
            } else if (oaidSDKCallbackListener != null) {
                oaidSDKCallbackListener.OnSupport(false, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void requestPermissionIfNecessary(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 23) {
            Log.i("PermissionManager", "Build.VERSION.SDK_INT below 23 does not require permission");
            return;
        }
        int nextInt = new Random().nextInt(1000000000);
        Intent intent = new Intent(context, TransparentActivity.class);
        intent.putExtra("type", 1000);
        intent.putExtra(TransparentActivity.b, nextInt);
        intent.putExtra(TransparentActivity.d, new String[]{d.a, d.b});
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void setAllowUseMdidSDK(boolean z) {
        allowUserOaidSDK = z;
    }
}
