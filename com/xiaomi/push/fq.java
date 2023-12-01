package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.dv;
import com.xiaomi.push.fu;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fq.class */
public class fq extends gb {

    /* renamed from: a  reason: collision with root package name */
    private fl f27724a;

    /* renamed from: a  reason: collision with other field name */
    private fm f424a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f425a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f426a;

    public fq(XMPushService xMPushService, fv fvVar) {
        super(xMPushService, fvVar);
    }

    private fj a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m8705a = fh.m8705a();
        if (m8705a != null) {
            dv.j jVar = new dv.j();
            jVar.a(a.a(m8705a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.f27724a = new fl(this.f456a.getInputStream(), this, this.f439a);
            this.f424a = new fm(this.f456a.getOutputStream(), this);
            fr frVar = new fr(this, "Blob Reader (" + this.b + ")");
            this.f425a = frVar;
            frVar.start();
        } catch (Exception e) {
            throw new gf("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.gb
    /* renamed from: a */
    public void mo8759a() {
        synchronized (this) {
            h();
            this.f424a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.gb
    public void a(int i, Exception exc) {
        synchronized (this) {
            if (this.f27724a != null) {
                this.f27724a.b();
                this.f27724a = null;
            }
            if (this.f424a != null) {
                try {
                    this.f424a.b();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                this.f424a = null;
            }
            this.f426a = null;
            super.a(i, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fj fjVar) {
        if (fjVar == null) {
            return;
        }
        if (fjVar.m8711a()) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("[Slim] RCV blob chid=" + fjVar.a() + "; id=" + fjVar.e() + "; errCode=" + fjVar.b() + "; err=" + fjVar.m8715c());
        }
        if (fjVar.a() == 0) {
            if ("PING".equals(fjVar.m8708a())) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("[Slim] RCV ping id=" + fjVar.e());
                g();
            } else if ("CLOSE".equals(fjVar.m8708a())) {
                c(13, null);
            }
        }
        for (fu.a aVar : this.f443a.values()) {
            aVar.a(fjVar);
        }
    }

    @Override // com.xiaomi.push.fu
    @Deprecated
    public void a(gl glVar) {
        b(fj.a(glVar, (String) null));
    }

    @Override // com.xiaomi.push.fu
    public void a(bg.b bVar) {
        synchronized (this) {
            fi.a(bVar, c(), this);
        }
    }

    @Override // com.xiaomi.push.fu
    public void a(String str, String str2) {
        synchronized (this) {
            fi.a(str, str2, this);
        }
    }

    @Override // com.xiaomi.push.gb
    /* renamed from: a  reason: collision with other method in class */
    protected void mo8724a(boolean z) {
        if (this.f424a == null) {
            throw new gf("The BlobWriter is null.");
        }
        fj a2 = a(z);
        com.xiaomi.channel.commonutils.logger.b.m8344a("[Slim] SND ping id=" + a2.e());
        b(a2);
        f();
    }

    @Override // com.xiaomi.push.gb, com.xiaomi.push.fu
    public void a(fj[] fjVarArr) {
        int length = fjVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            b(fjVarArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // com.xiaomi.push.fu
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo8725a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public byte[] m8726a() {
        byte[] bArr;
        synchronized (this) {
            if (this.f426a == null && !TextUtils.isEmpty(this.f440a)) {
                String m9118a = com.xiaomi.push.service.bv.m9118a();
                this.f426a = com.xiaomi.push.service.bp.a(this.f440a.getBytes(), (this.f440a.substring(this.f440a.length() / 2) + m9118a.substring(m9118a.length() / 2)).getBytes());
            }
            bArr = this.f426a;
        }
        return bArr;
    }

    @Override // com.xiaomi.push.fu
    public void b(fj fjVar) {
        fm fmVar = this.f424a;
        if (fmVar == null) {
            throw new gf("the writer is null.");
        }
        try {
            int a2 = fmVar.a(fjVar);
            this.d = SystemClock.elapsedRealtime();
            String f = fjVar.f();
            if (!TextUtils.isEmpty(f)) {
                gz.a(this.f439a, f, a2, false, true, System.currentTimeMillis());
            }
            for (fu.a aVar : this.f446b.values()) {
                aVar.a(fjVar);
            }
        } catch (Exception e) {
            throw new gf(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(gl glVar) {
        if (glVar == null) {
            return;
        }
        for (fu.a aVar : this.f443a.values()) {
            aVar.a(glVar);
        }
    }
}
