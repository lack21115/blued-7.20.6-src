package com.efs.sdk.base.core.c;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/f.class */
public final class f {
    static FileLock b;

    /* renamed from: a */
    volatile int f21742a;

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/f$a.class */
    public static final class a {

        /* renamed from: a */
        private static final f f21744a = new f((byte) 0);
    }

    private f() {
        this.f21742a = 0;
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    /* synthetic */ f(byte b2) {
        this();
    }

    private void a(final Context context) {
        synchronized (this) {
            Log.w("efs.send_log", "tryFileLock start! ");
            this.f21742a = 1;
            new Thread(new Runnable() { // from class: com.efs.sdk.base.core.c.f.1
                {
                    f.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    FileLock lock;
                    try {
                        File a2 = com.efs.sdk.base.core.util.a.a(context);
                        if (!a2.exists()) {
                            a2.mkdirs();
                        }
                        File file = new File(a2.getPath() + File.separator + "sendlock");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        do {
                            lock = new FileOutputStream(file).getChannel().lock();
                            f.b = lock;
                        } while (!lock.isValid());
                        Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + ProcessUtil.getCurrentProcessName());
                        f.this.f21742a = 2;
                    } catch (Exception e) {
                        Log.w("efs.send_log", "tryFileLock fail! " + e.getMessage());
                        f.this.f21742a = 0;
                    }
                }
            }).start();
        }
    }

    public final boolean a() {
        if (this.f21742a == 2) {
            return true;
        }
        if (this.f21742a == 0) {
            a(ControllerCenter.getGlobalEnvStruct().mAppContext);
            return false;
        }
        return false;
    }
}
