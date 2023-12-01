package com.kwad.sdk.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/oaid/OADIDSDKHelper.class */
public class OADIDSDKHelper {
    private static final String SUB_TAG = "OADIDSDKHelper:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/oaid/OADIDSDKHelper$IIdentifierListenerImpl.class */
    public static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                } else {
                    Log.d(OADIDSDKHelper.TAG, "OADIDSDKHelper:oaid time=" + (currentTimeMillis - j) + "--OAID:" + oaid);
                    this.mOaidListener.cw(oaid);
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/oaid/OADIDSDKHelper$a.class */
    public interface a {
        void cw(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
        } else if (mIsRequestIng) {
        } else {
            mIsRequestIng = true;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, (IIdentifierListener) new IIdentifierListenerImpl(currentTimeMillis, aVar));
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d(TAG, "OADIDSDKHelper:sdk init time=" + (currentTimeMillis2 - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable th) {
                Log.d(TAG, "OADIDSDKHelper:oaid sdk not find ");
                mIsRequestIng = false;
                sGetOaidFail = true;
            }
        }
    }

    public static boolean isSupport() {
        String str;
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper.1
                public final void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport((IdSupplier) null);
            try {
                int a2 = e.a();
                Log.d(TAG, "OADIDSDKHelper:oaidVersion" + a2);
            } catch (Throwable th) {
                str = "OADIDSDKHelper:oaidVersion fail";
            }
        } catch (Throwable th2) {
            str = "OADIDSDKHelper:isSupport oaid sdk not find ";
        }
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
            return true;
        } catch (Throwable th3) {
            str = "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ";
            Log.d(TAG, str);
            return false;
        }
    }
}
