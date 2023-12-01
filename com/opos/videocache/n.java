package com.opos.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/n.class */
class n extends r {

    /* renamed from: a  reason: collision with root package name */
    private final d f13762a;
    private final com.opos.videocache.a.b b;

    /* renamed from: c  reason: collision with root package name */
    private b f13763c;

    public n(d dVar, com.opos.videocache.a.b bVar) {
        super(dVar, bVar);
        this.b = bVar;
        this.f13762a = dVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j, 8192);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j += a2;
            }
        }
    }

    private boolean a(m mVar) {
        long a2 = this.f13762a.a();
        boolean z = a2 > 0;
        long a3 = this.b.a();
        boolean z2 = true;
        if (z) {
            z2 = true;
            if (mVar.f13761c) {
                if (((float) mVar.b) <= ((float) a3) + (((float) a2) * 0.2f)) {
                    return true;
                }
                z2 = false;
            }
        }
        return z2;
    }

    private String b(m mVar) {
        String c2 = this.f13762a.c();
        boolean isEmpty = TextUtils.isEmpty(c2);
        long a2 = this.b.d() ? this.b.a() : this.f13762a.a();
        boolean z = a2 >= 0;
        long j = mVar.f13761c ? a2 - mVar.b : a2;
        boolean z2 = z && mVar.f13761c;
        StringBuilder sb = new StringBuilder();
        sb.append(mVar.f13761c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? a("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z2 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(mVar.b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
        sb.append(isEmpty ^ true ? a("Content-Type: %s\n", c2) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j) {
        d dVar = new d(this.f13762a);
        try {
            dVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = dVar.a(bArr);
                if (a2 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a2);
            }
        } finally {
            dVar.b();
        }
    }

    @Override // com.opos.videocache.r
    protected void a(int i) {
        b bVar = this.f13763c;
        if (bVar != null) {
            bVar.a(this.b.f13741a, this.f13762a.d(), i);
        }
    }

    public void a(b bVar) {
        this.f13763c = bVar;
    }

    public void a(m mVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(mVar).getBytes("UTF-8"));
        long j = mVar.b;
        if (a(mVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
