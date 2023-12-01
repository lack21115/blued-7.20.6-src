package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLQosManager.class */
public class PLQosManager {
    public static void disableReport(Context context) {
        QosManager.a(context).c();
    }

    public static void enableReport(Context context) {
        QosManager.a(context).b();
    }
}
