package com.xiaomi.push;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.xiaomi.push.dv;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fj.class */
public class fj {

    /* renamed from: a  reason: collision with other field name */
    int f448a;

    /* renamed from: a  reason: collision with other field name */
    private dv.a f449a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.an f450a;

    /* renamed from: a  reason: collision with other field name */
    String f451a;

    /* renamed from: a  reason: collision with other field name */
    private short f452a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f453b;
    private static String b = gw.a(5) + "-";

    /* renamed from: a  reason: collision with root package name */
    private static long f41408a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f447a = new byte[0];

    public fj() {
        this.f452a = (short) 2;
        this.f453b = f447a;
        this.f451a = null;
        this.f450a = null;
        this.f449a = new dv.a();
        this.f448a = 1;
    }

    fj(dv.a aVar, short s, byte[] bArr) {
        this.f452a = (short) 2;
        this.f453b = f447a;
        this.f451a = null;
        this.f450a = null;
        this.f449a = aVar;
        this.f452a = s;
        this.f453b = bArr;
        this.f448a = 2;
    }

    @Deprecated
    public static fj a(gl glVar, String str) {
        int i;
        fj fjVar = new fj();
        try {
            i = Integer.parseInt(glVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fjVar.a(i);
        fjVar.a(glVar.j());
        fjVar.c(glVar.m());
        fjVar.b(glVar.n());
        fjVar.a("XMLMSG", (String) null);
        try {
            fjVar.a(glVar.mo11814a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fjVar.a((short) 3);
                return fjVar;
            }
            fjVar.a((short) 2);
            fjVar.a("SECMSG", (String) null);
            return fjVar;
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m11394a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static String d() {
        String sb;
        synchronized (fj.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b);
                long j = f41408a;
                f41408a = 1 + j;
                sb2.append(Long.toString(j));
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public int a() {
        return this.f449a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11758a() {
        return this.f449a.m11642c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo11759a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer == null) {
            byteBuffer2 = ByteBuffer.allocate(c());
        }
        byteBuffer2.putShort(this.f452a);
        byteBuffer2.putShort((short) this.f449a.a());
        byteBuffer2.putInt(this.f453b.length);
        int position = byteBuffer2.position();
        this.f449a.a(byteBuffer2.array(), byteBuffer2.arrayOffset() + position, this.f449a.a());
        byteBuffer2.position(position + this.f449a.a());
        byteBuffer2.put(this.f453b);
        return byteBuffer2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m11760a() {
        return this.f452a;
    }

    public void a(int i) {
        this.f449a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f449a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f449a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f449a.b(str2);
    }

    public void a(String str) {
        this.f449a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f449a.c(str);
        this.f449a.m11637a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f449a.d(str2);
    }

    public void a(short s) {
        this.f452a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f449a.c(0);
            this.f453b = bArr;
            return;
        }
        this.f449a.c(1);
        this.f453b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11761a() {
        return this.f449a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m11762a() {
        return fk.a(this, this.f453b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m11763a(String str) {
        if (this.f449a.e() == 1) {
            return fk.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f453b));
        }
        if (this.f449a.e() == 0) {
            return fk.a(this, this.f453b);
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("unknow cipher = " + this.f449a.e());
        return fk.a(this, this.f453b);
    }

    public int b() {
        return this.f449a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m11764b() {
        return this.f449a.m11644d();
    }

    public void b(int i) {
        com.xiaomi.push.service.an anVar = new com.xiaomi.push.service.an();
        this.f450a = anVar;
        anVar.f41607a = i;
    }

    public void b(String str) {
        this.f451a = str;
    }

    public int c() {
        return this.f449a.b() + 8 + this.f453b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m11765c() {
        return this.f449a.m11648f();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf(BridgeUtil.SPLIT_MARK, indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f449a.a(parseLong);
            this.f449a.a(substring);
            this.f449a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m11646e = this.f449a.m11646e();
        if ("ID_NOT_AVAILABLE".equals(m11646e)) {
            return null;
        }
        if (!this.f449a.g()) {
            m11646e = d();
            this.f449a.e(m11646e);
        }
        return m11646e;
    }

    public String f() {
        return this.f451a;
    }

    public String g() {
        if (this.f449a.m11641b()) {
            return Long.toString(this.f449a.m11636a()) + "@" + this.f449a.m11638a() + BridgeUtil.SPLIT_MARK + this.f449a.m11640b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m11758a() + "; type=" + ((int) m11760a()) + "; from=" + g() + " ]";
    }
}
