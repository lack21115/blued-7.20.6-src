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
    private fl f41415a;

    /* renamed from: a  reason: collision with other field name */
    private fm f471a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f472a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f473a;

    public fq(XMPushService xMPushService, fv fvVar) {
        super(xMPushService, fvVar);
    }

    private fj a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m11755a = fh.m11755a();
        if (m11755a != null) {
            dv.j jVar = new dv.j();
            jVar.a(a.a(m11755a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.f41415a = new fl(this.f503a.getInputStream(), this, this.f486a);
            this.f471a = new fm(this.f503a.getOutputStream(), this);
            fr frVar = new fr(this, "Blob Reader (" + this.b + ")");
            this.f472a = frVar;
            frVar.start();
        } catch (Exception e) {
            throw new gf("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.gb
    /* renamed from: a */
    public void mo11809a() {
        synchronized (this) {
            h();
            this.f471a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.gb
    public void a(int i, Exception exc) {
        synchronized (this) {
            if (this.f41415a != null) {
                this.f41415a.b();
                this.f41415a = null;
            }
            if (this.f471a != null) {
                try {
                    this.f471a.b();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                this.f471a = null;
            }
            this.f473a = null;
            super.a(i, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fj fjVar) {
        if (fjVar == null) {
            return;
        }
        if (fjVar.m11761a()) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("[Slim] RCV blob chid=" + fjVar.a() + "; id=" + fjVar.e() + "; errCode=" + fjVar.b() + "; err=" + fjVar.m11765c());
        }
        if (fjVar.a() == 0) {
            if ("PING".equals(fjVar.m11758a())) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("[Slim] RCV ping id=" + fjVar.e());
                g();
            } else if ("CLOSE".equals(fjVar.m11758a())) {
                c(13, null);
            }
        }
        for (fu.a aVar : this.f490a.values()) {
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
    protected void mo11774a(boolean z) {
        if (this.f471a == null) {
            throw new gf("The BlobWriter is null.");
        }
        fj a2 = a(z);
        com.xiaomi.channel.commonutils.logger.b.m11394a("[Slim] SND ping id=" + a2.e());
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
    public boolean mo11775a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public byte[] m11776a() {
        byte[] bArr;
        synchronized (this) {
            if (this.f473a == null && !TextUtils.isEmpty(this.f487a)) {
                String m12168a = com.xiaomi.push.service.bv.m12168a();
                this.f473a = com.xiaomi.push.service.bp.a(this.f487a.getBytes(), (this.f487a.substring(this.f487a.length() / 2) + m12168a.substring(m12168a.length() / 2)).getBytes());
            }
            bArr = this.f473a;
        }
        return bArr;
    }

    @Override // com.xiaomi.push.fu
    public void b(fj fjVar) {
        fm fmVar = this.f471a;
        if (fmVar == null) {
            throw new gf("the writer is null.");
        }
        try {
            int a2 = fmVar.a(fjVar);
            this.d = SystemClock.elapsedRealtime();
            String f = fjVar.f();
            if (!TextUtils.isEmpty(f)) {
                gz.a(this.f486a, f, a2, false, true, System.currentTimeMillis());
            }
            for (fu.a aVar : this.f493b.values()) {
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
        for (fu.a aVar : this.f490a.values()) {
            aVar.a(glVar);
        }
    }
}
