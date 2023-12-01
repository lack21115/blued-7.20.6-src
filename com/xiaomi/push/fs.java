package com.xiaomi.push;

import android.os.Process;
import com.xiaomi.push.dv;
import com.xiaomi.push.fu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fs.class */
public class fs implements gg {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f27726a = false;

    /* renamed from: a  reason: collision with other field name */
    private fu f428a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f431a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f427a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fx f429a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f430a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fs$a.class */
    public class a implements fz, gh {

        /* renamed from: a  reason: collision with other field name */
        String f432a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f433a;

        a(boolean z) {
            this.f433a = true;
            this.f433a = z;
            this.f432a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fz
        public void a(fj fjVar) {
            StringBuilder sb;
            String str;
            if (fs.f27726a) {
                sb = new StringBuilder("[Slim] ");
                sb.append(fs.this.f431a.format(new Date()));
                sb.append(this.f432a);
                str = fjVar.toString();
            } else {
                sb = new StringBuilder("[Slim] ");
                sb.append(fs.this.f431a.format(new Date()));
                sb.append(this.f432a);
                sb.append(" Blob [");
                sb.append(fjVar.m8708a());
                sb.append(",");
                sb.append(fjVar.a());
                sb.append(",");
                sb.append(com.xiaomi.push.service.bd.a(fjVar.e()));
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            if (fjVar == null || fjVar.a() != 99999) {
                return;
            }
            String m8708a = fjVar.m8708a();
            fj fjVar2 = null;
            if (!this.f433a) {
                if ("BIND".equals(m8708a)) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("build binded result for loopback.");
                    dv.d dVar = new dv.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b(com.baidu.mobads.sdk.internal.bw.o);
                    dVar.a(com.baidu.mobads.sdk.internal.bw.o);
                    fjVar2 = new fj();
                    fjVar2.a(dVar.a(), (String) null);
                    fjVar2.a((short) 2);
                    fjVar2.a(Process.LAST_ISOLATED_UID);
                    fjVar2.a("BIND", (String) null);
                    fjVar2.a(fjVar.e());
                    fjVar2.b((String) null);
                    fjVar2.c(fjVar.g());
                } else {
                    fjVar2 = null;
                    if (!"UBND".equals(m8708a)) {
                        fjVar2 = null;
                        if ("SECMSG".equals(m8708a)) {
                            fjVar2 = new fj();
                            fjVar2.a(Process.LAST_ISOLATED_UID);
                            fjVar2.a("SECMSG", (String) null);
                            fjVar2.c(fjVar.g());
                            fjVar2.a(fjVar.e());
                            fjVar2.a(fjVar.m8710a());
                            fjVar2.b(fjVar.f());
                            fjVar2.a(fjVar.m8713a(com.xiaomi.push.service.bg.a().a("99999", fjVar.g()).h), (String) null);
                        }
                    }
                }
            }
            if (fjVar2 != null) {
                for (Map.Entry<fz, fu.a> entry : fs.this.f428a.m8736a().entrySet()) {
                    if (fs.this.f427a != entry.getKey()) {
                        entry.getValue().a(fjVar2);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.fz
        public void a(gl glVar) {
            StringBuilder sb;
            String str;
            if (fs.f27726a) {
                StringBuilder sb2 = new StringBuilder("[Slim] ");
                sb2.append(fs.this.f431a.format(new Date()));
                sb2.append(this.f432a);
                sb2.append(" PKT ");
                str = glVar.mo8764a();
                sb = sb2;
            } else {
                StringBuilder sb3 = new StringBuilder("[Slim] ");
                sb3.append(fs.this.f431a.format(new Date()));
                sb3.append(this.f432a);
                sb3.append(" PKT [");
                sb3.append(glVar.k());
                sb3.append(",");
                sb3.append(glVar.j());
                sb = sb3;
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        }

        @Override // com.xiaomi.push.gh
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo8730a(gl glVar) {
            return true;
        }
    }

    public fs(fu fuVar) {
        this.f428a = null;
        this.f428a = fuVar;
        a();
    }

    private void a() {
        this.f427a = new a(true);
        this.b = new a(false);
        fu fuVar = this.f428a;
        a aVar = this.f427a;
        fuVar.a(aVar, aVar);
        fu fuVar2 = this.f428a;
        a aVar2 = this.b;
        fuVar2.b(aVar2, aVar2);
        this.f429a = new ft(this);
    }
}
