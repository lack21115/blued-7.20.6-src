package cn.shuzilm.core;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.PhoneConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/k.class */
public final class k implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        boolean z;
        DUHelper dUHelper2;
        DUHelper dUHelper3;
        DUHelper dUHelper4;
        try {
            System.loadLibrary("du");
            dUHelper = DUHelper.d;
            z = dUHelper.w;
            if (!z && Build.VERSION.SDK_INT >= 19) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                if (Looper.myLooper() != null) {
                    dUHelper3 = DUHelper.d;
                    ((TelephonyManager) DUHelper.mContext.getSystemService(PhoneConstants.PHONE_KEY)).listen(dUHelper3, 256);
                    dUHelper4 = DUHelper.d;
                    dUHelper4.h(this.a);
                }
                DUHelper.i(DUHelper.mContext);
            }
            dUHelper2 = DUHelper.d;
            dUHelper2.w = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
