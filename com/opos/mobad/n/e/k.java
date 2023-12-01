package com.opos.mobad.n.e;

import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/k.class */
class k implements ZkViewSDK.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f26652a;

    /* renamed from: c  reason: collision with root package name */
    private final i f26653c;
    private final long b = System.currentTimeMillis();
    private final com.opos.mobad.n.e.b d = new a();
    private final e e = new b();
    private final f f = new c();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/k$a.class */
    class a implements com.opos.mobad.n.e.b {
        a() {
        }

        @Override // com.opos.mobad.n.e.b
        public void a(View view, int[] iArr) {
            if (k.this.f26653c.o != null) {
                k.this.f26653c.o.a(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void b(View view, int[] iArr) {
            if (k.this.f26653c.o != null) {
                k.this.f26653c.o.b(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void c(View view, int[] iArr) {
            if (k.this.f26653c.o != null) {
                k.this.f26653c.o.c(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void d(View view, int[] iArr) {
            if (k.this.f26653c.o != null) {
                k.this.f26653c.o.d(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void e(View view, int[] iArr) {
            if (k.this.f26653c.o != null) {
                k.this.f26653c.o.e(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void f(View view, int[] iArr) {
            if (k.this.f26653c.o != null) {
                k.this.f26653c.o.f(view, iArr);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/k$b.class */
    class b implements e {
        b() {
        }

        @Override // com.opos.mobad.n.e.e
        public void a() {
            if (k.this.f26653c.p != null) {
                k.this.f26653c.p.a();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/k$c.class */
    class c implements f {
        c() {
        }

        @Override // com.opos.mobad.n.e.f
        public void a() {
            if (k.this.f26653c.q != null) {
                k.this.f26653c.q.a();
            }
        }

        @Override // com.opos.mobad.n.e.f
        public void a(String str) {
            if (k.this.f26653c.q != null) {
                k.this.f26653c.q.a(str);
            }
        }
    }

    public k(i iVar, String str) {
        this.f26653c = iVar;
        this.f26652a = str;
    }

    private int[] a(ZkViewSDK.Event event) {
        return event == null ? new int[4] : new int[]{event.downX, event.downY, event.upX, event.upY};
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i, int i2, int i3, Map map2) {
        if (this.f26653c.r != null) {
            this.f26653c.r.a(i2, i3);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoProgress scene:" + str + ",sceneType:" + i + ", curTime:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i, int i2, Map map2) {
        if (this.f26653c.r != null) {
            this.f26653c.r.a(i2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoStart scene:" + str + ",sceneType:" + i + ", totalTime:" + i2 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i, String str2, Map map2) {
        if (this.f26653c.r != null) {
            this.f26653c.r.a(str2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i + ", errorMsg:" + str2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        this.f.a();
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadSuccess path:" + this.f26652a + ",scene:" + str + ", sceneType:" + i + ",loadTime:" + (currentTimeMillis - j));
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, ZkViewSDK.Event event, int i, String str2, int i2, Map map2) {
        int[] iArr = {event.downX, event.downY, event.upX, event.upY};
        if (i == 0) {
            this.d.e(this.f26653c.s, iArr);
        } else if (1 == i) {
            this.d.f(this.f26653c.s, iArr);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAdClick path:" + this.f26652a + ",action:" + str + ",type:" + i + ",scene:" + str2 + ", sceneType:" + i2 + ",coordinate:" + iArr + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, ZkViewSDK.Event event, int i, Map map2) {
        int[] a2 = a(event);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doOtherAction path:" + this.f26652a + ",action:" + str + ", sceneType:" + i + ",event:" + a2 + ",engineInfo:" + map2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, ZkViewSDK.Event event, String str2, int i, Map map2) {
        boolean z;
        int[] a2 = a(event);
        switch (str.hashCode()) {
            case -1037349779:
                if (str.equals("useraction_showprivacy")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -742120727:
                if (str.equals("useraction_showpermissions")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 897602042:
                if (str.equals("useraction_close")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 912245512:
                if (str.equals("useraction_shake")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1714813235:
                if (str.equals("useraction_countdown")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1830545725:
                if (str.equals("useraction_skip")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z || z || z) {
            this.d.a(this.f26653c.s, a2);
        } else if (z) {
            this.d.b(this.f26653c.s, a2);
        } else if (z) {
            this.d.c(this.f26653c.s, a2);
        } else if (z) {
            this.d.d(this.f26653c.s, a2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAction path:" + this.f26652a + ",action:" + str + ",scene:" + str2 + ", sceneType:" + i + ",coordinate:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, String str2, int i, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        this.e.a();
        com.opos.cmn.an.f.a.b("LoadCallBack", "onSceneExpose path:" + this.f26652a + ",lastScene:" + str + ",curScene:" + str2 + ", sceneType:" + i + ",loadTime:" + (currentTimeMillis - j) + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, Map map2) {
        this.f.a(str);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadFailed path:" + this.f26652a + ",msg:" + str);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, Map map2) {
        com.opos.cmn.an.f.a.b("LoadCallBack", "preLoadInfo path:" + this.f26652a + ",map1:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void b(Map map, String str, int i, int i2, int i3, Map map2) {
        if (this.f26653c.r != null) {
            this.f26653c.r.b(i2, i3);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPause scene:" + str + ",sceneType:" + i + ", curTime:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void c(Map map, String str, int i, int i2, int i3, Map map2) {
        if (this.f26653c.r != null) {
            this.f26653c.r.c(i2, i3);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i + ", curTime:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }
}
