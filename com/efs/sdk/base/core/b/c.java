package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/c.class */
public final class c extends Handler implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8123a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f8124a = new c((byte) 0);
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.f8189a.getLooper());
        this.f8123a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.f8124a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            WorkThreadUtil.submit(this);
            return;
        }
        Log.w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.core.b.a unused;
        unused = a.b.f8121a;
        File f = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (f.exists()) {
            for (File file : com.efs.sdk.base.core.util.b.d(f)) {
                if (com.efs.sdk.base.core.b.a.a(file.getName())) {
                    com.efs.sdk.base.core.b.a.c(file);
                }
            }
        }
        com.efs.sdk.base.core.config.a.c a2 = com.efs.sdk.base.core.config.a.c.a();
        String str = a2.d.f.containsKey("disk_bytes") ? a2.d.f.get("disk_bytes") : "4194304";
        if (TextUtils.isEmpty(str)) {
            str = "4194304";
        }
        long parseLong = Long.parseLong(str);
        long c2 = com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z = c2 < parseLong;
        this.f8123a = z;
        if (!z) {
            Log.w("efs.cache", "Cache Limited! curr " + c2 + "byte, max " + parseLong + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }
}
