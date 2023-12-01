package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/g.class */
public final class g extends Handler implements e {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f21731a;
    private com.efs.sdk.base.core.e.a.d b;

    /* renamed from: c  reason: collision with root package name */
    private com.efs.sdk.base.core.e.a.c f21732c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/g$a.class */
    public static final class a extends FileOutputStream {

        /* renamed from: a  reason: collision with root package name */
        long f21733a;
        File b;

        a(File file) {
            super(file);
            this.b = file;
            this.f21733a = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        super(com.efs.sdk.base.core.util.concurrent.a.f21795a.getLooper());
        this.f21731a = new ConcurrentHashMap<>();
        this.b = new com.efs.sdk.base.core.e.a.d();
        this.f21732c = new com.efs.sdk.base.core.e.a.c();
    }

    private boolean a(com.efs.sdk.base.core.d.b bVar, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                try {
                    for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                        String b = com.efs.sdk.base.core.util.b.b.b(readLine.getBytes());
                        if (!TextUtils.isEmpty(b)) {
                            sb.append(b);
                            sb.append("\n");
                        }
                    }
                    bVar.a(sb.toString().getBytes());
                    bVar.c();
                    this.f21732c.a(bVar);
                    bVar.d = file;
                    com.efs.sdk.base.core.util.b.a(bufferedReader2);
                    com.efs.sdk.base.core.util.b.a(fileReader2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    fileReader = fileReader2;
                    try {
                        Log.e("efs.cache", "local decode error", th);
                        com.efs.sdk.base.core.util.b.a(bufferedReader);
                        com.efs.sdk.base.core.util.b.a(fileReader);
                        return false;
                    } catch (Throwable th2) {
                        com.efs.sdk.base.core.util.b.a(bufferedReader);
                        com.efs.sdk.base.core.util.b.a(fileReader);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    private static long b(String str) {
        Map<String, String> c2 = com.efs.sdk.base.core.config.a.c.a().c();
        String concat = "record_accumulation_time_".concat(String.valueOf(str));
        if (c2.containsKey(concat)) {
            String str2 = c2.get(concat);
            if (TextUtils.isEmpty(str2)) {
                return 60000L;
            }
            try {
                return Math.max(Long.parseLong(str2) * 1000, 1000L);
            } catch (Throwable th) {
                Log.e("efs.cache", "get cache interval error", th);
                return 60000L;
            }
        }
        return 60000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.efs.sdk.base.core.b.g.a b(com.efs.sdk.base.core.d.b r6) {
        /*
            r5 = this;
            r0 = r5
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.b.g$a> r0 = r0.f21731a
            r1 = r6
            com.efs.sdk.base.core.d.a r1 = r1.f21764a
            java.lang.String r1 = r1.f21762a
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L23
            r0 = r5
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.b.g$a> r0 = r0.f21731a
            r1 = r6
            com.efs.sdk.base.core.d.a r1 = r1.f21764a
            java.lang.String r1 = r1.f21762a
            java.lang.Object r0 = r0.get(r1)
            com.efs.sdk.base.core.b.g$a r0 = (com.efs.sdk.base.core.b.g.a) r0
            return r0
        L23:
            r0 = r6
            java.lang.String r0 = com.efs.sdk.base.core.util.b.a(r0)
            r7 = r0
            java.io.File r0 = new java.io.File
            r1 = r0
            com.efs.sdk.base.core.config.GlobalEnvStruct r2 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r2 = r2.mAppContext
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r3 = r3.getAppid()
            java.io.File r2 = com.efs.sdk.base.core.util.a.e(r2, r3)
            r3 = r7
            r1.<init>(r2, r3)
            r8 = r0
            com.efs.sdk.base.core.b.g$a r0 = new com.efs.sdk.base.core.b.g$a     // Catch: java.lang.Throwable -> L98
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L98
            r7 = r0
            r0 = r5
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.b.g$a> r0 = r0.f21731a     // Catch: java.lang.Throwable -> L94
            r1 = r6
            com.efs.sdk.base.core.d.a r1 = r1.f21764a     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = r1.f21762a     // Catch: java.lang.Throwable -> L94
            r2 = r7
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)     // Catch: java.lang.Throwable -> L94
            com.efs.sdk.base.core.b.g$a r0 = (com.efs.sdk.base.core.b.g.a) r0     // Catch: java.lang.Throwable -> L94
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L6d
            r0 = r7
            com.efs.sdk.base.core.util.b.a(r0)     // Catch: java.lang.Throwable -> L94
            r0 = r8
            com.efs.sdk.base.core.util.b.b(r0)     // Catch: java.lang.Throwable -> L94
            r0 = r9
            return r0
        L6d:
            android.os.Message r0 = android.os.Message.obtain()     // Catch: java.lang.Throwable -> L94
            r8 = r0
            r0 = r8
            r1 = r6
            com.efs.sdk.base.core.d.a r1 = r1.f21764a     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = r1.f21762a     // Catch: java.lang.Throwable -> L94
            r0.obj = r1     // Catch: java.lang.Throwable -> L94
            r0 = r8
            r1 = 1
            r0.what = r1     // Catch: java.lang.Throwable -> L94
            r0 = r5
            r1 = r8
            r2 = r6
            com.efs.sdk.base.core.d.a r2 = r2.f21764a     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = r2.f21762a     // Catch: java.lang.Throwable -> L94
            long r2 = b(r2)     // Catch: java.lang.Throwable -> L94
            boolean r0 = r0.sendMessageDelayed(r1, r2)     // Catch: java.lang.Throwable -> L94
            goto L9f
        L94:
            r8 = move-exception
            goto L9b
        L98:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L9b:
            r0 = r8
            r0.printStackTrace()
        L9f:
            java.lang.String r0 = "wa"
            r1 = r6
            com.efs.sdk.base.core.d.a r1 = r1.f21764a
            java.lang.String r1 = r1.f21762a
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto Lb7
            com.efs.sdk.base.core.f.f r0 = com.efs.sdk.base.core.f.f.a.a()
            com.efs.sdk.base.core.f.d r0 = r0.f21780c
            r0.b()
        Lb7:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.b.g.b(com.efs.sdk.base.core.d.b):com.efs.sdk.base.core.b.g$a");
    }

    private void c(String str) {
        a aVar;
        com.efs.sdk.base.core.f.f fVar;
        com.efs.sdk.base.core.f.f fVar2;
        if (this.f21731a.containsKey(str) && (aVar = this.f21731a.get(str)) != null) {
            try {
                aVar.flush();
                com.efs.sdk.base.core.util.b.a(aVar);
                a(aVar.b);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.f21731a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                        return;
                    }
                    fVar2 = f.a.f21781a;
                    fVar2.f21780c.c();
                } finally {
                    this.f21731a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        fVar = f.a.f21781a;
                        fVar.f21780c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        Message obtain = Message.obtain();
        obtain.obj = bVar;
        obtain.what = 0;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(File file) {
        com.efs.sdk.base.core.b.a unused;
        com.efs.sdk.base.core.b.a unused2;
        com.efs.sdk.base.core.d.b b = com.efs.sdk.base.core.util.b.b(file.getName());
        if (b == null) {
            unused = a.b.f21727a;
            com.efs.sdk.base.core.b.a.b(file);
        } else if (!a(b, file) || b.f21765c == null || b.f21765c.length <= 0) {
            unused2 = a.b.f21727a;
            com.efs.sdk.base.core.b.a.b(file);
        } else {
            com.efs.sdk.base.core.util.b.a(new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(b)), b.f21765c);
            com.efs.sdk.base.core.util.b.b(file);
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.what = 1;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.b.e
    public final boolean a(File file, com.efs.sdk.base.core.d.b bVar) {
        if (!bVar.b()) {
            a(file);
            return false;
        } else if (file.exists()) {
            bVar.d = file;
            bVar.c();
            bVar.b(1);
            return true;
        } else {
            return false;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1 && (message.obj instanceof String)) {
                c(message.obj.toString());
                return;
            }
            return;
        }
        com.efs.sdk.base.core.d.b bVar = (com.efs.sdk.base.core.d.b) message.obj;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 3) {
                return;
            }
            try {
                a b = b(bVar);
                if (b == null) {
                    Log.w("efs.cache", "writer is null for type " + bVar.f21764a.f21762a);
                    return;
                }
                a aVar = b;
                if (b.getChannel().position() + bVar.f21765c.length > 819200) {
                    c(bVar.f21764a.f21762a);
                    a b2 = b(bVar);
                    aVar = b2;
                    if (b2 == null) {
                        Log.w("efs.cache", "writer is null for type " + bVar.f21764a.f21762a);
                        return;
                    }
                }
                aVar.write(Base64.encode(bVar.f21765c, 11));
                aVar.write("\n".getBytes());
                return;
            } catch (Throwable th) {
                Log.e("efs.cache", "cache file error", th);
                i2 = i3 + 1;
            }
        }
    }
}
