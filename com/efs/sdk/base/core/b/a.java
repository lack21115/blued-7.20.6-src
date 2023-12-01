package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/a.class */
public final class a {

    /* renamed from: a */
    public boolean f8119a;
    public boolean b;

    /* renamed from: c */
    public com.efs.sdk.base.core.b.b f8120c;
    public C0163a d;

    /* renamed from: com.efs.sdk.base.core.b.a$a */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/a$a.class */
    public static final class C0163a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i == 0 ? 0 : -1;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/a$b.class */
    public static final class b {

        /* renamed from: a */
        private static final a f8121a = new a((byte) 0);

        public static /* synthetic */ a a() {
            return f8121a;
        }
    }

    private a() {
        this.f8119a = false;
        this.b = true;
        this.f8120c = new com.efs.sdk.base.core.b.b();
        this.d = new C0163a();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static boolean a(String str) {
        try {
            long parseLong = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            com.efs.sdk.base.core.a.a.a();
            return Math.abs(com.efs.sdk.base.core.a.a.b() - parseLong) >= 604800000;
        } catch (Throwable th) {
            return true;
        }
    }

    public static void b(File file) {
        com.efs.sdk.base.core.f.f fVar;
        if (!file.getName().startsWith("wa_")) {
            fVar = f.a.f8175a;
            fVar.f8174c.e();
        }
        com.efs.sdk.base.core.util.b.b(file);
    }

    public static void c(File file) {
        com.efs.sdk.base.core.f.f fVar;
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        Log.i("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            fVar = f.a.f8175a;
            fVar.f8174c.d();
        }
        com.efs.sdk.base.core.util.b.b(file);
    }

    public final com.efs.sdk.base.core.d.b a(File file) {
        try {
            if (file.exists()) {
                if (a(file.getName())) {
                    c(file);
                    return null;
                }
                com.efs.sdk.base.core.d.b b2 = com.efs.sdk.base.core.util.b.b(file.getName());
                if (b2 == null) {
                    b(file);
                    return null;
                }
                e a2 = this.f8120c.a(b2.f8158a.b);
                if (a2 == null) {
                    b(file);
                    return null;
                } else if (a2.a(file, b2)) {
                    return b2;
                } else {
                    b(file);
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            Log.w("efs.cache", th);
            b(file);
            return null;
        }
    }

    public final void a() {
        String[] list;
        File d = com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!d.exists() || !d.isDirectory() || (list = d.list()) == null || list.length <= 0) {
            return;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = list[i2];
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(d, str);
                List<File> d2 = com.efs.sdk.base.core.util.b.d(file);
                if (!d2.isEmpty()) {
                    for (File file2 : d2) {
                        if (a(file2.getName())) {
                            c(file2);
                        } else {
                            com.efs.sdk.base.core.d.b b2 = com.efs.sdk.base.core.util.b.b(file2.getName());
                            if (b2 == null) {
                                b(file2);
                            } else {
                                e a2 = this.f8120c.a(b2.f8158a.b);
                                if (a2 == null) {
                                    b(file2);
                                } else {
                                    a2.a(file2);
                                }
                            }
                        }
                    }
                }
                com.efs.sdk.base.core.util.b.b(file);
            }
            i = i2 + 1;
        }
    }
}
