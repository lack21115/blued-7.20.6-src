package com.igexin.push.b;

import android.os.Build;
import com.igexin.push.b.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/e.class */
public final class e {
    private static final String e = "DT_DetectRunTask";
    private static final long f = 60;

    /* renamed from: a  reason: collision with root package name */
    Future<d> f9702a;
    d b;

    /* renamed from: c  reason: collision with root package name */
    i f9703c;
    boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.push.b.e$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/e$1.class */
    public final class AnonymousClass1 implements Callable<d> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public d call() {
            Socket socket;
            Thread.currentThread().hashCode();
            com.igexin.b.a.a().f9586a.getActiveCount();
            if (!Thread.currentThread().isInterrupted()) {
                Socket socket2 = null;
                try {
                    try {
                    } catch (Exception e) {
                        e = e;
                        socket = null;
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(Thread.currentThread().getName());
                        sb.append(" is interrupted ######");
                        com.igexin.c.a.c.a.a(e.e, sb.toString());
                        Thread.currentThread().hashCode();
                        com.igexin.b.a.a().f9586a.getActiveCount();
                        return null;
                    }
                    synchronized (i.class) {
                        try {
                        } finally {
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String[] a2 = com.igexin.c.a.b.g.a(e.this.b.a());
                    socket = new Socket();
                    try {
                        socket.connect(new InetSocketAddress(a2[1], e.this.b.b), 2500);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String a3 = e.a(socket.getInetAddress());
                        e.this.b.a("socket://" + a3 + ":" + e.this.b.b, currentTimeMillis2 - currentTimeMillis, currentTimeMillis2);
                        e.this.c();
                        com.igexin.c.a.c.a.a("DT_DetectRunTask|detect " + e.this.c() + "|time = " + e.this.b.c(), new Object[0]);
                        synchronized (i.class) {
                            if (e.this.f9703c != null && !Thread.currentThread().isInterrupted()) {
                                e.this.f9703c.a(b.a.f9694a, e.this.b);
                            }
                        }
                        if (!socket.isClosed()) {
                            try {
                                socket.close();
                            } catch (Exception e2) {
                                e = e2;
                                com.igexin.c.a.c.a.a(e);
                                Thread.currentThread().hashCode();
                                com.igexin.b.a.a().f9586a.getActiveCount();
                                return e.this.b;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        StringBuilder sb2 = new StringBuilder("|detect ");
                        Socket socket3 = socket;
                        sb2.append(e.this.c());
                        Socket socket4 = socket;
                        sb2.append("thread -->");
                        Socket socket5 = socket;
                        sb2.append(e.getMessage());
                        Socket socket6 = socket;
                        com.igexin.c.a.c.a.b(e.e, sb2.toString());
                        Socket socket7 = socket;
                        synchronized (i.class) {
                            if (e.this.f9703c != null) {
                                e.this.b.b();
                                e.this.f9703c.a(b.a.f9695c, e.this.b);
                            }
                        }
                        if (socket != null && !socket.isClosed()) {
                            try {
                                socket.close();
                            } catch (Exception e4) {
                                e = e4;
                                com.igexin.c.a.c.a.a(e);
                                Thread.currentThread().hashCode();
                                com.igexin.b.a.a().f9586a.getActiveCount();
                                return e.this.b;
                            }
                        }
                        Thread.currentThread().hashCode();
                        com.igexin.b.a.a().f9586a.getActiveCount();
                        return e.this.b;
                    } catch (Throwable th) {
                        socket2 = socket;
                        th = th;
                        if (socket2 != null && !socket2.isClosed()) {
                            try {
                                socket2.close();
                            } catch (Exception e5) {
                                com.igexin.c.a.c.a.a(e5);
                            }
                        }
                        Thread.currentThread().hashCode();
                        com.igexin.b.a.a().f9586a.getActiveCount();
                        throw th;
                    }
                    Thread.currentThread().hashCode();
                    com.igexin.b.a.a().f9586a.getActiveCount();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return e.this.b;
        }
    }

    public static String a(InetAddress inetAddress) throws NoSuchMethodException {
        Class<?> cls;
        try {
            cls = Class.forName("java.net.InetAddress");
        } catch (Throwable th) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Method declaredMethod = cls.getDeclaredMethod("holder", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(inetAddress, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("address");
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(invoke)).intValue();
            String str = ((intValue >>> 24) & 255) + "." + ((intValue >>> 16) & 255) + "." + ((intValue >>> 8) & 255) + "." + (intValue & 255);
            com.igexin.c.a.c.a.b(e, "i new Str: ".concat(String.valueOf(str)));
            return str;
        }
        Field declaredField2 = cls.getDeclaredField("ipaddress");
        declaredField2.setAccessible(true);
        byte[] bArr = (byte[]) declaredField2.get(inetAddress);
        if (bArr.length >= 4) {
            byte b = bArr[3];
            byte b2 = bArr[2];
            byte b3 = bArr[1];
            byte b4 = bArr[0];
            String str2 = (b & 255) + "." + (b2 & 255) + "." + (b3 & 255) + "." + (b4 & 255);
            com.igexin.c.a.c.a.b(e, "i old Str: ".concat(String.valueOf(str2)));
            return str2;
        }
        if (com.igexin.push.config.d.ag) {
            com.igexin.c.a.c.a.b(e, "get ad by original method");
            return inetAddress.getHostAddress();
        }
        throw new NoSuchMethodException("can't get ad by new method");
    }

    private void a(d dVar) {
        this.b = dVar;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private d d() {
        return this.b;
    }

    private void e() {
        synchronized (i.class) {
            try {
                if (this.f9703c != null) {
                    this.f9702a = com.igexin.b.a.a().f9586a.submit(new AnonymousClass1());
                }
            } finally {
            }
        }
    }

    private void f() {
        this.f9702a = com.igexin.b.a.a().f9586a.submit(new AnonymousClass1());
    }

    private void g() {
        try {
            if (this.f9702a == null || this.f9702a.isCancelled() || this.f9702a.isDone()) {
                return;
            }
            this.f9702a.cancel(true);
            this.f9702a = null;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final void a() {
        c();
        com.igexin.c.a.c.a.a("DT_DetectRunTask|stop " + c() + " task", new Object[0]);
        g();
    }

    public final void a(i iVar) {
        synchronized (i.class) {
            try {
                this.f9703c = iVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        a((i) null);
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.b.a() + "|" + this.b.f9700a;
    }
}
