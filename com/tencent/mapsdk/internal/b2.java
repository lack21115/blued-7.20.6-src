package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.sdk.comps.offlinemap.OfflineItemController;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatus;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatusChangedListener;
import com.tencent.mapsdk.internal.ca;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b2.class */
public class b2 implements OfflineItemController {

    /* renamed from: a  reason: collision with root package name */
    private final ic f23613a;
    private final c2 b;

    /* renamed from: c  reason: collision with root package name */
    private final OfflineItem f23614c;
    private final String d;
    private final File e;
    private final File f;
    private final File g;
    private String h;
    private final kb i;
    private final e j;
    private OfflineStatusChangedListener k;
    private d l;
    private boolean m;
    private final q1 n;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b2$a.class */
    public class a extends ca.c<Boolean> {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Boolean bool) {
            if (!bool.booleanValue()) {
                b2.this.startDownload();
            } else if (b2.this.k != null) {
                b2.this.k.onStatusChanged(b2.this.f23614c, OfflineStatus.COMPLETED);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b2$b.class */
    public class b extends ca.i<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b2 b2Var = b2.this;
            return Boolean.valueOf(b2Var.b(b2Var.n));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b2$c.class */
    public class c implements FilenameFilter {
        public c() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return b2.this.f.getName().equals(str);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b2$d.class */
    public interface d {
        void a(OfflineItem offlineItem, int i);

        void a(OfflineItem offlineItem, boolean z);

        void b(OfflineItem offlineItem, boolean z);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b2$e.class */
    public class e extends mb implements jb {
        private lb d;
        private File e;

        private e() {
        }

        public /* synthetic */ e(b2 b2Var, a aVar) {
            this();
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void a(String str) {
            File file = this.e;
            if (file == null || !file.exists()) {
                return;
            }
            na.c(ma.u, "完成下载:[" + this.e + "]");
            na.c(ma.u, "创建城市缓存文件:[" + b2.this.f + "]");
            ga.d(b2.this.f);
            ga.b(this.e, b2.this.e);
            b2.this.b();
            if (!b2.this.f.exists()) {
                na.g(ma.u, "缓存文件创建失败！");
                return;
            }
            na.c(ma.u, "解压成功:[" + b2.this.f + "]");
            c2 c2Var = b2.this.b;
            c2Var.b(b2.this.f23613a);
            na.c(ma.u, "保持城市缓存信息:[" + c2Var + "]");
            b2.this.i.b(b2.this.j);
            if (b2.this.l != null) {
                b2.this.l.a(b2.this.f23614c, 100);
                b2.this.l.b(b2.this.f23614c, false);
            }
            if (b2.this.k != null) {
                b2.this.k.onStatusChanged(b2.this.f23614c, OfflineStatus.COMPLETED);
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void a(String str, lb lbVar) {
            na.c(ma.u, "下载状态：" + lbVar);
            this.d = lbVar;
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void a(String str, byte[] bArr) {
            File file;
            if (TextUtils.isEmpty(str) || !str.equals(b2.this.h) || bArr == null) {
                return;
            }
            if (this.d == lb.RUNNING && (file = this.e) != null) {
                int length = (int) ((file.length() * 100) / b2.this.b.d);
                if (b2.this.l != null) {
                    b2.this.l.a(b2.this.f23614c, length);
                }
                na.c(ma.u, "缓存文件下载中:：length: " + this.e.length() + "：" + length + "%");
                ga.a(this.e, bArr);
            }
            if (b2.this.k != null) {
                b2.this.k.onStatusChanged(b2.this.f23614c, OfflineStatus.DOWNLOADING);
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void b(String str) {
            if (this.e != null) {
                na.g(ma.u, "缓存文件下载失败！");
                ga.d(this.e);
            }
            if (b2.this.k != null) {
                b2.this.k.onStatusChanged(b2.this.f23614c, OfflineStatus.ERROR);
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void c(String str) {
            if (this.e != null) {
                na.g(ma.u, "取消下载:[" + this.e + "]");
                ga.d(this.e);
            }
            if (b2.this.k != null) {
                b2.this.k.onStatusChanged(b2.this.f23614c, OfflineStatus.CANCEL);
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void d(String str) {
            String str2 = b2.this.d;
            this.e = new File(str2, c() + ".tmp");
            na.c(ma.u, "开始下载:[" + this.e + "]");
            if (b2.this.k != null) {
                b2.this.k.onStatusChanged(b2.this.f23614c, OfflineStatus.START);
            }
        }
    }

    public b2(q1 q1Var, String str, OfflineItem offlineItem, c2 c2Var, ic icVar, OfflineStatusChangedListener offlineStatusChangedListener) {
        this.n = q1Var;
        this.f23613a = icVar;
        this.f23614c = offlineItem;
        this.b = c2Var;
        this.k = offlineStatusChangedListener;
        kb kbVar = new kb();
        this.i = kbVar;
        this.j = new e(this, null);
        kbVar.a(h7.f());
        this.d = str;
        this.e = new File(str, c2Var.c());
        this.f = new File(str, c2Var.a());
        this.g = new File(mc.b(q1Var.getContext()).d(), c2Var.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.e.exists()) {
            try {
                na.c(ma.u, "开始缓存文件校验...");
                String a2 = wa.a(this.e);
                na.c(ma.u, "结束缓存文件校验...");
                if (this.b.b.equals(a2)) {
                    ga.d(this.f);
                    ja.a(this.e, this.f.getParent(), new c());
                    return;
                }
                na.g(ma.u, "缓存文件MD5不一致！");
                ga.d(this.e);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a() {
        this.l = null;
        this.k = null;
    }

    public void a(OfflineStatusChangedListener offlineStatusChangedListener) {
        this.k = offlineStatusChangedListener;
    }

    public void a(d dVar) {
        this.l = dVar;
    }

    public boolean a(q1 q1Var) {
        synchronized (this) {
            if (!this.g.exists() || q1Var == null) {
                return false;
            }
            v1 o = q1Var.o();
            o.a();
            ga.b(this.g, this.f);
            o.e();
            o.c();
            d dVar = this.l;
            if (dVar != null) {
                dVar.a(this.f23614c, false);
            }
            OfflineStatusChangedListener offlineStatusChangedListener = this.k;
            if (offlineStatusChangedListener != null) {
                offlineStatusChangedListener.onStatusChanged(this.f23614c, OfflineStatus.CLOSE);
            }
            this.m = false;
            na.c(ma.u, "关闭[" + this.b.f23647c + "]离线");
            return true;
        }
    }

    public boolean b(q1 q1Var) {
        synchronized (this) {
            if (q1Var == null) {
                return false;
            }
            b();
            if (this.f.exists()) {
                v1 o = q1Var.o();
                o.a();
                ga.b(this.f, this.g);
                o.e();
                o.c();
                this.m = true;
                d dVar = this.l;
                if (dVar != null) {
                    dVar.a(this.f23614c, true);
                }
                OfflineStatusChangedListener offlineStatusChangedListener = this.k;
                if (offlineStatusChangedListener != null) {
                    offlineStatusChangedListener.onStatusChanged(this.f23614c, OfflineStatus.OPEN);
                }
                na.c(ma.u, "开启[" + this.b.f23647c + "]离线");
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public boolean checkInvalidate() {
        boolean z;
        synchronized (this) {
            c2 c2Var = this.b;
            z = false;
            if (c2Var != null) {
                this.h = c2Var.b();
                z = c2Var.a(this.f23613a);
                na.c(ma.u, "检查是否需要更新:[" + z + "]");
                if (!z && !this.m && !this.f.exists()) {
                    if (this.e.exists()) {
                        b();
                        z = false;
                        if (!this.f.exists()) {
                        }
                    }
                    z = true;
                }
            }
            d dVar = this.l;
            if (dVar != null) {
                dVar.b(this.f23614c, z);
            }
        }
        return z;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public boolean close() {
        return a(this.n);
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public boolean open() {
        return b(this.n);
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public boolean removeCache() {
        boolean d2 = ga.d(this.e);
        na.c(ma.u, "删除[" + this.b.f23647c + "]离线缓存");
        return d2;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public void startDownload() {
        if (this.n == null) {
            OfflineStatusChangedListener offlineStatusChangedListener = this.k;
            if (offlineStatusChangedListener != null) {
                offlineStatusChangedListener.onStatusChanged(this.f23614c, OfflineStatus.ERROR);
            }
        } else if (this.e.exists()) {
            ca.a((ca.i) new b()).b(null, new a());
        } else if (!checkInvalidate() || TextUtils.isEmpty(this.h)) {
            OfflineStatusChangedListener offlineStatusChangedListener2 = this.k;
            if (offlineStatusChangedListener2 != null) {
                offlineStatusChangedListener2.onStatusChanged(this.f23614c, OfflineStatus.ERROR);
            }
        } else {
            if (this.k != null) {
                this.i.a(this.j);
            }
            na.c(ma.u, "请求下载:[" + this.h + "]");
            this.i.a(this.h, this.j);
            OfflineStatusChangedListener offlineStatusChangedListener3 = this.k;
            if (offlineStatusChangedListener3 != null) {
                offlineStatusChangedListener3.onStatusChanged(this.f23614c, OfflineStatus.READY);
            }
        }
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public void stopDownload() {
        if (TextUtils.isEmpty(this.h)) {
            return;
        }
        na.c(ma.u, "停止下载:[" + this.h + "]");
        this.i.b(this.h);
    }
}
