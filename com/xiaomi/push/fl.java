package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.dv;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fl.class */
public class fl {

    /* renamed from: a  reason: collision with root package name */
    private Context f41410a;

    /* renamed from: a  reason: collision with other field name */
    private fq f455a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f456a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f459a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f460a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f457a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f458a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private fo f454a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(InputStream inputStream, fq fqVar, Context context) {
        this.f456a = new BufferedInputStream(inputStream);
        this.f455a = fqVar;
        this.f41410a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.nio.ByteBuffer a() {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fl.a():java.nio.ByteBuffer");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int i2;
        int i3;
        int position = byteBuffer.position();
        do {
            int read = this.f456a.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i2 = i - read;
            i3 = position + read;
            position = i3;
            i = i2;
        } while (i2 > 0);
        byteBuffer.position(i3);
    }

    private void c() {
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f459a = false;
        fj m11767a = m11767a();
        if ("CONN".equals(m11767a.m11758a())) {
            dv.f a2 = dv.f.a(m11767a.m11762a());
            z = false;
            if (a2.m11682a()) {
                this.f455a.a(a2.m11681a());
                z = true;
            }
            if (a2.c()) {
                dv.b m11680a = a2.m11680a();
                fj fjVar = new fj();
                fjVar.a("SYNC", "CONF");
                fjVar.a(m11680a.a(), (String) null);
                this.f455a.a(fjVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("[Slim] CONN: host = " + a2.m11683b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f460a = this.f455a.m11776a();
        while (!this.f459a) {
            fj m11767a2 = m11767a();
            this.f455a.c();
            short m11760a = m11767a2.m11760a();
            if (m11760a != 1) {
                if (m11760a != 2) {
                    if (m11760a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m11767a2.m11760a());
                        com.xiaomi.channel.commonutils.logger.b.m11394a(str);
                    } else {
                        try {
                            this.f455a.b(this.f454a.a(m11767a2.m11762a(), this.f455a));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder("[Slim] Parse packet from Blob chid=");
                            sb.append(m11767a2.a());
                            sb.append("; Id=");
                            sb.append(m11767a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m11394a(str);
                        }
                    }
                } else if ("SECMSG".equals(m11767a2.m11758a()) && ((m11767a2.a() == 2 || m11767a2.a() == 3) && TextUtils.isEmpty(m11767a2.m11764b()))) {
                    try {
                        this.f455a.b(this.f454a.a(m11767a2.m11763a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m11767a2.a()).toString(), m11767a2.g()).h), this.f455a));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder("[Slim] Parse packet from Blob chid=");
                        sb.append(m11767a2.a());
                        sb.append("; Id=");
                        sb.append(m11767a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.m11394a(str);
                    }
                } else if (m11767a2.a() == 10) {
                    m11767a2.b(10);
                    m11767a2.f450a.f976a = s.a(this.f41410a);
                    m11767a2.f450a.f978b = bh.e(this.f41410a);
                    m11767a2.f450a.f975a = System.currentTimeMillis();
                    com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                }
            }
            this.f455a.a(m11767a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fj m11767a() {
        int i;
        try {
            ByteBuffer a2 = a();
            i = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fp fpVar = i == 8 ? new fp() : fj.a(a2.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m11758a() + ";chid=" + fpVar.a() + ";len=" + i + com.alipay.sdk.util.i.d);
                return fpVar;
            } catch (IOException e) {
                e = e;
                int i2 = i;
                if (i == 0) {
                    i2 = this.f457a.position();
                }
                StringBuilder sb = new StringBuilder("[Slim] read Blob [");
                byte[] array = this.f457a.array();
                int i3 = i2;
                if (i2 > 128) {
                    i3 = 128;
                }
                sb.append(af.a(array, 0, i3));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m11394a(sb.toString());
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m11768a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f459a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f459a = true;
    }
}
