package com.tencent.turingface.sdk.mfa;

import com.anythink.expressad.foundation.d.d;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ORjG3.class */
public final class ORjG3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f26211a;
    public final Object b;

    /* renamed from: c  reason: collision with root package name */
    public Process f26212c;
    public DataOutputStream d;
    public spXPg e;
    public spXPg f;
    public ByteArrayOutputStream g;
    public ByteArrayOutputStream h;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ORjG3$ShGzN.class */
    public static final class ShGzN {

        /* renamed from: a  reason: collision with root package name */
        public final String f26213a;
        public final String b;

        public ShGzN(String str, String str2, long j) {
            this.f26213a = str;
            this.b = str2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ORjG3$SkEpO.class */
    public static final class SkEpO {

        /* renamed from: a  reason: collision with root package name */
        public final String f26214a;
        public final String b;

        public SkEpO(String str, String str2) {
            this.f26214a = str;
            this.b = str2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/ORjG3$spXPg.class */
    public final class spXPg extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public InputStream f26215a;
        public ByteArrayOutputStream b;

        public spXPg(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.f26215a = inputStream;
            this.b = byteArrayOutputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = this.f26215a.read(bArr);
                    if (read < 0) {
                        synchronized (ORjG3.this.b) {
                            this.b.write(":RET=EOF".getBytes());
                            this.b.flush();
                        }
                        synchronized (ORjG3.this.f26211a) {
                            ORjG3.this.f26211a.notifyAll();
                        }
                        return;
                    } else if (read > 0) {
                        synchronized (ORjG3.this.b) {
                            this.b.write(bArr, 0, read);
                            this.b.flush();
                        }
                        synchronized (ORjG3.this.f26211a) {
                            ORjG3.this.f26211a.notifyAll();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public ORjG3() throws IllegalArgumentException, FileNotFoundException, IOException, InterruptedException {
        boolean z;
        Object obj = new Object();
        this.f26211a = obj;
        this.b = new Object();
        this.g = new ByteArrayOutputStream();
        this.h = new ByteArrayOutputStream();
        this.f26212c = Runtime.getRuntime().exec(d.t);
        synchronized (obj) {
            obj.wait(10L);
        }
        try {
            this.f26212c.exitValue();
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (z) {
            throw new IOException();
        }
        this.d = new DataOutputStream(this.f26212c.getOutputStream());
        this.e = new spXPg("s", this.f26212c.getInputStream(), this.g);
        this.f = new spXPg("e", this.f26212c.getErrorStream(), this.h);
        synchronized (this.f26211a) {
            this.f26211a.wait(10L);
        }
        this.e.start();
        this.f.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x000d, B:8:0x0015, B:10:0x0020, B:15:0x002f, B:16:0x0037, B:20:0x0049, B:21:0x004c, B:22:0x0086, B:27:0x0095, B:29:0x00ab, B:32:0x00be, B:38:0x00d1, B:39:0x00da, B:50:0x00e7, B:51:0x00ea, B:52:0x00f0, B:18:0x0039, B:19:0x0048, B:24:0x0088, B:25:0x0093), top: B:60:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e7 A[Catch: all -> 0x00f1, all -> 0x00f1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:6:0x000d, B:8:0x0015, B:10:0x0020, B:15:0x002f, B:16:0x0037, B:20:0x0049, B:21:0x004c, B:22:0x0086, B:27:0x0095, B:29:0x00ab, B:32:0x00be, B:38:0x00d1, B:39:0x00da, B:50:0x00e7, B:51:0x00ea, B:52:0x00f0, B:18:0x0039, B:19:0x0048, B:24:0x0088, B:25:0x0093), top: B:60:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingface.sdk.mfa.ORjG3.SkEpO a(com.tencent.turingface.sdk.mfa.ORjG3.ShGzN r8) throws java.lang.IllegalArgumentException, java.io.IOException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.ORjG3.a(com.tencent.turingface.sdk.mfa.ORjG3$ShGzN):com.tencent.turingface.sdk.mfa.ORjG3$SkEpO");
    }

    public final SkEpO a(ShGzN shGzN, long j) throws InterruptedException {
        boolean z;
        synchronized (this.f26211a) {
            synchronized (this.b) {
                z = new String(this.g.toByteArray()).lastIndexOf(":RET=") == -1;
            }
            if (z) {
                this.f26211a.wait(j);
            }
        }
        synchronized (this.b) {
            byte[] byteArray = this.g.toByteArray();
            byte[] byteArray2 = this.h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") != -1) {
                this.g.reset();
                this.h.reset();
                if (str.lastIndexOf(":RET=0") != -1) {
                    return new SkEpO(str.substring(0, str.lastIndexOf(":RET=")), str2);
                }
                if (str.lastIndexOf(":RET=EOF") == -1) {
                    str2.lastIndexOf(":RET=EOF");
                }
                return new SkEpO(str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            return null;
        }
    }

    public final void a() {
        try {
            this.d.write("exit\n".getBytes());
            this.d.flush();
            this.f26212c.wait(100L);
        } catch (Exception e) {
        }
        spXPg spxpg = this.e;
        if (spxpg != null) {
            spxpg.interrupt();
            this.e = null;
        }
        spXPg spxpg2 = this.f;
        if (spxpg2 != null) {
            spxpg2.interrupt();
            this.f = null;
        }
        Process process = this.f26212c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable th) {
            }
            this.f26212c = null;
        }
    }

    public final void finalize() throws Throwable {
        try {
            a();
        } catch (Throwable th) {
        }
        super.finalize();
    }
}
