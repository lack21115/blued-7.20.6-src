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
    private Context f27719a;

    /* renamed from: a  reason: collision with other field name */
    private fq f408a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f409a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f412a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f413a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f410a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f411a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    private fo f407a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(InputStream inputStream, fq fqVar, Context context) {
        this.f409a = new BufferedInputStream(inputStream);
        this.f408a = fqVar;
        this.f27719a = context;
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
            int read = this.f409a.read(byteBuffer.array(), position, i);
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
        this.f412a = false;
        fj m8717a = m8717a();
        if ("CONN".equals(m8717a.m8708a())) {
            dv.f a2 = dv.f.a(m8717a.m8712a());
            z = false;
            if (a2.m8632a()) {
                this.f408a.a(a2.m8631a());
                z = true;
            }
            if (a2.c()) {
                dv.b m8630a = a2.m8630a();
                fj fjVar = new fj();
                fjVar.a("SYNC", "CONF");
                fjVar.a(m8630a.a(), (String) null);
                this.f408a.a(fjVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("[Slim] CONN: host = " + a2.m8633b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f413a = this.f408a.m8726a();
        while (!this.f412a) {
            fj m8717a2 = m8717a();
            this.f408a.c();
            short m8710a = m8717a2.m8710a();
            if (m8710a != 1) {
                if (m8710a != 2) {
                    if (m8710a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m8717a2.m8710a());
                        com.xiaomi.channel.commonutils.logger.b.m8344a(str);
                    } else {
                        try {
                            this.f408a.b(this.f407a.a(m8717a2.m8712a(), this.f408a));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder("[Slim] Parse packet from Blob chid=");
                            sb.append(m8717a2.a());
                            sb.append("; Id=");
                            sb.append(m8717a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m8344a(str);
                        }
                    }
                } else if ("SECMSG".equals(m8717a2.m8708a()) && ((m8717a2.a() == 2 || m8717a2.a() == 3) && TextUtils.isEmpty(m8717a2.m8714b()))) {
                    try {
                        this.f408a.b(this.f407a.a(m8717a2.m8713a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m8717a2.a()).toString(), m8717a2.g()).h), this.f408a));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder("[Slim] Parse packet from Blob chid=");
                        sb.append(m8717a2.a());
                        sb.append("; Id=");
                        sb.append(m8717a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.m8344a(str);
                    }
                } else if (m8717a2.a() == 10) {
                    m8717a2.b(10);
                    m8717a2.f403a.f929a = s.a(this.f27719a);
                    m8717a2.f403a.f931b = bh.e(this.f27719a);
                    m8717a2.f403a.f928a = System.currentTimeMillis();
                    com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                }
            }
            this.f408a.a(m8717a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fj m8717a() {
        int i;
        try {
            ByteBuffer a2 = a();
            i = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fp fpVar = i == 8 ? new fp() : fj.a(a2.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m8708a() + ";chid=" + fpVar.a() + ";len=" + i + "}");
                return fpVar;
            } catch (IOException e) {
                e = e;
                int i2 = i;
                if (i == 0) {
                    i2 = this.f410a.position();
                }
                StringBuilder sb = new StringBuilder("[Slim] read Blob [");
                byte[] array = this.f410a.array();
                int i3 = i2;
                if (i2 > 128) {
                    i3 = 128;
                }
                sb.append(af.a(array, 0, i3));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m8344a(sb.toString());
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m8718a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f412a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f412a = true;
    }
}
