package com.opos.mobad.e.a.a;

import android.content.Context;
import com.opos.mobad.e.a.a.b.a;
import com.opos.mobad.e.a.l;
import com.wrapper_oaction.ZkViewSDK;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/a.class */
public final class a implements ZkViewSDK.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f25986a;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.mobad.e.a.a.b f25987c;
    private final Context d;
    private final a.C0691a e;
    private final long b = System.currentTimeMillis();
    private final C0690a f = new C0690a();
    private final b g = new b();
    private final c h = new c();

    /* renamed from: com.opos.mobad.e.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/a$a.class */
    final class C0690a implements com.opos.mobad.e.a.b {
        C0690a() {
        }

        @Override // com.opos.mobad.e.a.b
        public final void a(Map map, String str, l lVar, int i, String str2, int i2, Map map2) {
            if (a.this.f25987c.k != null) {
                a.this.f25987c.k.a(map, str, lVar, i, str2, i2);
            }
            if (a.this.f25987c.n != null) {
                a.this.f25987c.n.a(map, str, lVar, i, str2, i2, map2);
            }
        }

        @Override // com.opos.mobad.e.a.b
        public final void a(Map map, String str, l lVar, String str2, int i, Map map2) {
            if (a.this.f25987c.k != null) {
                a.this.f25987c.k.a(map, str, lVar, str2, i);
            }
            if (a.this.f25987c.n != null) {
                a.this.f25987c.n.a(map, str, lVar, str2, i, map2);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/a$b.class */
    final class b implements com.opos.mobad.e.a.c {
        b() {
        }

        @Override // com.opos.mobad.e.a.c
        public final void a(Map map, String str, String str2, int i, Map map2) {
            if (a.this.f25987c.l != null) {
                a.this.f25987c.l.a(map, str, str2, i);
            }
            if (a.this.f25987c.o != null) {
                a.this.f25987c.o.a(map, str, str2, i, map2);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/a$c.class */
    final class c implements com.opos.mobad.e.a.d {
        c() {
        }

        @Override // com.opos.mobad.e.a.d
        public final void a(Map map, String str, Map map2) {
            if (a.this.f25987c.m != null) {
                a.this.f25987c.m.a(map, str);
            }
            if (a.this.f25987c.p != null) {
                a.this.f25987c.p.a(map, str, map2);
            }
        }

        @Override // com.opos.mobad.e.a.d
        public final void a(Map map, Map map2) {
            if (a.this.f25987c.p != null) {
                a.this.f25987c.p.a(map, map2);
            }
        }

        @Override // com.opos.mobad.e.a.d
        public final void b(Map map, Map map2) {
            if (a.this.f25987c.m != null) {
                a.this.f25987c.m.a(map);
            }
            if (a.this.f25987c.p != null) {
                a.this.f25987c.p.b(map, map2);
            }
        }
    }

    public a(Context context, com.opos.mobad.e.a.a.b bVar, a.C0691a c0691a, String str) {
        this.f25987c = bVar;
        this.d = context;
        this.e = c0691a;
        this.f25986a = str;
    }

    private static l a(ZkViewSDK.Event event) {
        l lVar = new l();
        if (event == null) {
            return lVar;
        }
        lVar.b = event.upEvent;
        lVar.f25998a = event.downEvent;
        lVar.f25999c = event.downX;
        lVar.d = event.downY;
        lVar.f = event.upX;
        lVar.g = event.upY;
        lVar.h = event.upTime;
        return lVar;
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i, int i2, int i3, Map map2) {
        if (this.f25987c.q != null) {
            this.f25987c.q.a(map, str, i, i2, i3, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoProgress scene:" + str + ",sceneType:" + i + ", curTime:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i, int i2, Map map2) {
        if (this.f25987c.q != null) {
            this.f25987c.q.a(map, str, i, i2, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoStart scene:" + str + ",sceneType:" + i + ", totalTime:" + i2 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i, String str2, Map map2) {
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i + ", errorMsg:" + str2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i, Map map2) {
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        this.h.b(map, map2);
        this.g.a(map, "", str, i, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.b().a(this.e).d("").e(str).a(currentTimeMillis).a(i).a(this.d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadSuccess path:" + this.f25986a + ",scene:" + str + ", sceneType:" + i + ",loadTime:" + currentTimeMillis);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, ZkViewSDK.Event event, int i, String str2, int i2, Map map2) {
        l a2 = a(event);
        this.f.a(map, str, a2, i, str2, i2, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.c().a(this.e).e(String.valueOf(i)).f(str2).a(i2).d("1").a(a2).a(this.d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAdClick path:" + this.f25986a + ",action:" + str + ",type:" + i + ",scene:" + str2 + ", sceneType:" + i2 + ",event:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, ZkViewSDK.Event event, int i, Map map2) {
        l a2 = a(event);
        com.opos.mobad.e.a.a.b.a.a();
        a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.e).d("5");
        d.e(str + " scene action name error!").a(this.d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doOtherAction path:" + this.f25986a + ",action:" + str + ", sceneType:" + i + ",event:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, ZkViewSDK.Event event, String str2, int i, Map map2) {
        l a2 = a(event);
        this.f.a(map, str, a2, str2, i, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.c().a(this.e).f(str2).a(i).d("0").a(a2).a(this.d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAction path:" + this.f25986a + ",action:" + str + ",scene:" + str2 + ", sceneType:" + i + ",event:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, String str2, int i, Map map2) {
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        this.g.a(map, str, str2, i, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.b().a(this.e).d(str).e(str2).a(i).a(currentTimeMillis).a(this.d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onSceneExpose path:" + this.f25986a + ",lastScene:" + str + ",curScene:" + str2 + ", sceneType:" + i + ",loadTime:" + currentTimeMillis + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, Map map2) {
        this.h.a(map, str, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.d().a(this.e).d("0").e(str).a(this.d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadFailed path:" + this.f25986a + ",msg:" + str);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        this.h.a(map, map2);
        com.opos.cmn.an.f.a.b("LoadCallBack", "preLoadInfo path:" + this.f25986a + ",map1:" + map2 + ", cost time:" + (currentTimeMillis - j));
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void b(Map map, String str, int i, int i2, int i3, Map map2) {
        if (this.f25987c.q != null) {
            this.f25987c.q.b(map, str, i, i2, i3, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPause scene:" + str + ",sceneType:" + i + ", curTime:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void c(Map map, String str, int i, int i2, int i3, Map map2) {
        if (this.f25987c.q != null) {
            this.f25987c.q.c(map, str, i, i2, i3, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i + ", curTime:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }
}
