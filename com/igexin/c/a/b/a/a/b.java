package com.igexin.c.a.b.a.a;

import android.text.TextUtils;
import com.igexin.c.a.b.a.a.a;
import com.igexin.push.config.SDKUrlConfig;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/b.class */
public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23222a = -2037;
    private static final String j = "GS-C";
    private static final int k = 10000;
    private Socket P;
    private com.igexin.c.a.b.a.a.a.d l;

    public b(com.igexin.c.a.b.a.a.a.d dVar) {
        super(-2037, null);
        this.l = dVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        Socket socket;
        super.a();
        com.igexin.c.a.c.a.a("GS-C|sc dispose", new Object[0]);
        if (this.l != null) {
            if (this.g == a.EnumC0446a.f23221c) {
                this.l.a();
            } else if (this.g == a.EnumC0446a.b) {
                if (!TextUtils.isEmpty(this.h)) {
                    this.l.a(new Exception(this.h));
                }
            } else if (this.g == a.EnumC0446a.f23220a && (socket = this.P) != null) {
                this.l.a(socket);
            }
        }
        this.l = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        com.igexin.push.b.c.a().d().a();
        String connectAddress = SDKUrlConfig.getConnectAddress();
        try {
            String[] a2 = com.igexin.c.a.b.g.a(connectAddress);
            String str = a2[1];
            int parseInt = Integer.parseInt(a2[2]);
            com.igexin.c.a.c.a.a("GS-C|start connect :  " + connectAddress + " *********", new Object[0]);
            com.igexin.c.a.b.a.a.a.d dVar = this.l;
            if (dVar != null) {
                dVar.b();
            }
            Socket socket = new Socket();
            this.P = socket;
            try {
                socket.connect(new InetSocketAddress(str, parseInt), 10000);
                com.igexin.c.a.c.a.a("GS-C|connected :  " + connectAddress + " #########", new Object[0]);
                this.P.getLocalAddress();
                this.P.getLocalPort();
                com.igexin.c.a.c.a.a("GS-C|local-" + this.P.getLocalAddress() + ":" + this.P.getLocalPort(), new Object[0]);
                if (this.g != a.EnumC0446a.f23221c) {
                    this.g = a.EnumC0446a.f23220a;
                }
            } catch (Exception e) {
                if (this.g != a.EnumC0446a.f23221c) {
                    this.g = a.EnumC0446a.b;
                    this.h = e.toString();
                }
            }
            this.f = true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("GS-C|ips invalid, " + e2.toString(), new Object[0]);
            throw e2;
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2037;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        boolean z = this.i;
        boolean z2 = this.f;
        this.g = a.EnumC0446a.f23221c;
    }
}
