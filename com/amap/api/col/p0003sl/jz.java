package com.amap.api.col.p0003sl;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.p0003sl.hp;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.amap.api.col.3sl.jz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jz.class */
public final class jz extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f5252a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private SSLContext f5253c;

    public jz(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.b = context.getApplicationContext();
            } catch (Throwable th) {
                try {
                    iw.c(th, "myssl", "<init>");
                    try {
                        if (this.f5253c == null && Build.VERSION.SDK_INT >= 9) {
                            this.f5253c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        iw.c(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.f5252a == null) {
                            this.f5252a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        iw.c(th3, "myssl", "<init3>");
                        return;
                    }
                } catch (Throwable th4) {
                    try {
                        if (this.f5253c == null && Build.VERSION.SDK_INT >= 9) {
                            this.f5253c = SSLContext.getDefault();
                        }
                    } catch (Throwable th5) {
                        iw.c(th5, "myssl", "<init2>");
                    }
                    try {
                        if (this.f5252a == null) {
                            this.f5252a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th6) {
                        iw.c(th6, "myssl", "<init3>");
                    }
                    throw th4;
                }
            }
        }
        this.f5253c = sSLContext;
        if (sSLContext != null) {
            this.f5252a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f5253c == null && Build.VERSION.SDK_INT >= 9) {
                this.f5253c = SSLContext.getDefault();
            }
        } catch (Throwable th7) {
            iw.c(th7, "myssl", "<init2>");
        }
        try {
            if (this.f5252a == null) {
                this.f5252a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th8) {
            iw.c(th8, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
        } catch (Throwable th) {
            iw.c(th, "myssl", "stlv2");
        }
        if (Build.VERSION.SDK_INT < 21) {
            return socket;
        }
        if (hp.f.b && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            return socket;
        }
        return socket;
    }

    private void a(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f5253c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(ib.c("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String c2 = ib.c("Yc2V0UGVyc2lzdGVudENhY2hl");
            int length = methods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Method method = methods[i2];
                if (method.getName().equals(c2)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            iw.c(th, "myssl", "isc2");
        }
    }

    private static void b(Socket socket) {
        if (Build.VERSION.SDK_INT >= 17 && hp.f.f5094c && hp.f.e && (socket instanceof SSLSocket)) {
            int i = hp.f.f > hp.f.d ? hp.f.d : hp.f.f;
            if (i <= 17 || Build.VERSION.SDK_INT <= i) {
                try {
                    socket.getClass().getMethod(ib.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    iw.c(th, "myssl", "sust");
                }
            }
        }
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 17 && hp.f.f5094c && this.b != null && this.f5253c != null) {
            int i = hp.f.d;
            if (i <= 17 || Build.VERSION.SDK_INT <= i) {
                SSLSessionCache sSLSessionCache = new SSLSessionCache(this.b);
                if (Build.VERSION.SDK_INT <= 20 || Build.VERSION.SDK_INT >= 28) {
                    a(sSLSessionCache);
                    return;
                }
                try {
                    sSLSessionCache.getClass().getMethod(ib.c("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f5253c);
                } catch (Throwable th) {
                    iw.c(th, "myssl", "isc1");
                    a(sSLSessionCache);
                }
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z;
        IOException iOException;
        try {
            if (this.f5252a != null) {
                Socket a2 = a(this.f5252a.createSocket());
                b(a2);
                return a2;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        try {
            if (this.f5252a != null) {
                Socket a2 = a(this.f5252a.createSocket(str, i));
                b(a2);
                return a2;
            }
            return null;
        } catch (Throwable th) {
            iw.c(th, "myssl", "cs3");
            if (th instanceof UnknownHostException) {
                throw th;
            }
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        try {
            if (this.f5252a != null) {
                Socket a2 = a(this.f5252a.createSocket(str, i, inetAddress, i2));
                b(a2);
                return a2;
            }
            return null;
        } catch (Throwable th) {
            iw.c(th, "myssl", "cs4");
            if (th instanceof UnknownHostException) {
                throw th;
            }
            if (th instanceof IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        boolean z;
        IOException iOException;
        try {
            if (this.f5252a != null) {
                Socket a2 = a(this.f5252a.createSocket(inetAddress, i));
                b(a2);
                return a2;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        boolean z;
        IOException iOException;
        try {
            if (this.f5252a != null) {
                Socket a2 = a(this.f5252a.createSocket(inetAddress, i, inetAddress2, i2));
                b(a2);
                return a2;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        boolean z2;
        IOException iOException;
        try {
            if (this.f5252a != null) {
                Socket a2 = a(this.f5252a.createSocket(socket, str, i, z));
                b(a2);
                return a2;
            }
            return null;
        } finally {
            if (!z2) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            if (this.f5252a != null) {
                return this.f5252a.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            iw.c(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            if (this.f5252a != null) {
                return this.f5252a.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            iw.c(th, "myssl", "gscs");
        }
        return new String[0];
    }
}
