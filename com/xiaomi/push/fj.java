package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dv;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fj.class */
public class fj {

    /* renamed from: a  reason: collision with other field name */
    int f401a;

    /* renamed from: a  reason: collision with other field name */
    private dv.a f402a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.an f403a;

    /* renamed from: a  reason: collision with other field name */
    String f404a;

    /* renamed from: a  reason: collision with other field name */
    private short f405a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f406b;
    private static String b = gw.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f27717a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f400a = new byte[0];

    public fj() {
        this.f405a = (short) 2;
        this.f406b = f400a;
        this.f404a = null;
        this.f403a = null;
        this.f402a = new dv.a();
        this.f401a = 1;
    }

    fj(dv.a aVar, short s, byte[] bArr) {
        this.f405a = (short) 2;
        this.f406b = f400a;
        this.f404a = null;
        this.f403a = null;
        this.f402a = aVar;
        this.f405a = s;
        this.f406b = bArr;
        this.f401a = 2;
    }

    @Deprecated
    public static fj a(gl glVar, String str) {
        int i;
        fj fjVar = new fj();
        try {
            i = Integer.parseInt(glVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fjVar.a(i);
        fjVar.a(glVar.j());
        fjVar.c(glVar.m());
        fjVar.b(glVar.n());
        fjVar.a("XMLMSG", (String) null);
        try {
            fjVar.a(glVar.mo8764a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fjVar.a((short) 3);
                return fjVar;
            }
            fjVar.a((short) 2);
            fjVar.a("SECMSG", (String) null);
            return fjVar;
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Blob setPayload err： " + e2.getMessage());
            return fjVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static fj a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            dv.a aVar = new dv.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fj(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static String d() {
        String sb;
        synchronized (fj.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b);
                long j = f27717a;
                f27717a = 1 + j;
                sb2.append(Long.toString(j));
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public int a() {
        return this.f402a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8708a() {
        return this.f402a.m8592c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo8709a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer == null) {
            byteBuffer2 = ByteBuffer.allocate(c());
        }
        byteBuffer2.putShort(this.f405a);
        byteBuffer2.putShort((short) this.f402a.a());
        byteBuffer2.putInt(this.f406b.length);
        int position = byteBuffer2.position();
        this.f402a.a(byteBuffer2.array(), byteBuffer2.arrayOffset() + position, this.f402a.a());
        byteBuffer2.position(position + this.f402a.a());
        byteBuffer2.put(this.f406b);
        return byteBuffer2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m8710a() {
        return this.f405a;
    }

    public void a(int i) {
        this.f402a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f402a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f402a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f402a.b(str2);
    }

    public void a(String str) {
        this.f402a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f402a.c(str);
        this.f402a.m8587a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f402a.d(str2);
    }

    public void a(short s) {
        this.f405a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f402a.c(0);
            this.f406b = bArr;
            return;
        }
        this.f402a.c(1);
        this.f406b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8711a() {
        return this.f402a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m8712a() {
        return fk.a(this, this.f406b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m8713a(String str) {
        if (this.f402a.e() == 1) {
            return fk.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f406b));
        }
        if (this.f402a.e() == 0) {
            return fk.a(this, this.f406b);
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("unknow cipher = " + this.f402a.e());
        return fk.a(this, this.f406b);
    }

    public int b() {
        return this.f402a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m8714b() {
        return this.f402a.m8594d();
    }

    public void b(int i) {
        com.xiaomi.push.service.an anVar = new com.xiaomi.push.service.an();
        this.f403a = anVar;
        anVar.f27916a = i;
    }

    public void b(String str) {
        this.f404a = str;
    }

    public int c() {
        return this.f402a.b() + 8 + this.f406b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m8715c() {
        return this.f402a.m8598f();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f402a.a(parseLong);
            this.f402a.a(substring);
            this.f402a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m8596e = this.f402a.m8596e();
        if ("ID_NOT_AVAILABLE".equals(m8596e)) {
            return null;
        }
        if (!this.f402a.g()) {
            m8596e = d();
            this.f402a.e(m8596e);
        }
        return m8596e;
    }

    public String f() {
        return this.f404a;
    }

    public String g() {
        if (this.f402a.m8591b()) {
            return Long.toString(this.f402a.m8586a()) + "@" + this.f402a.m8588a() + "/" + this.f402a.m8590b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m8708a() + "; type=" + ((int) m8710a()) + "; from=" + g() + " ]";
    }
}
