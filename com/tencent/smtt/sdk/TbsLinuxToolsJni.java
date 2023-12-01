package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsLinuxToolsJni.class */
public class TbsLinuxToolsJni {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f25078a = false;
    private static boolean b = false;

    public TbsLinuxToolsJni(Context context) {
        a(context);
    }

    private native int ChmodInner(String str, String str2);

    private void a(Context context) {
        File q;
        synchronized (TbsLinuxToolsJni.class) {
            try {
                TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
                if (b) {
                    return;
                }
                b = true;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    String a2 = TbsShareManager.a();
                    String str = a2;
                    if (a2 == null) {
                        str = TbsShareManager.c(context);
                    }
                    q = new File(str);
                } else {
                    q = o.a().q(context);
                }
                if (q != null) {
                    File file = q;
                    if (!new File(q.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists()) {
                        file = q;
                        if (!TbsShareManager.isThirdPartyApp(context)) {
                            file = o.a().p(context);
                        }
                    }
                    if (file != null) {
                        TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + file.getAbsolutePath());
                        System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        f25078a = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } finally {
            }
        }
    }

    public int a(String str, String str2) {
        if (f25078a) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
