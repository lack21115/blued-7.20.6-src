package com.opos.mobad.e.a.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.e.a.a.b.a;
import com.opos.mobad.e.a.g;
import com.wrapper_oaction.ZkViewSDK;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/c.class */
final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private View f25996a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private a.C0691a f25997c;

    public c(Context context, View view, a.C0691a c0691a) {
        this.f25996a = view;
        this.b = context;
        this.f25997c = c0691a;
    }

    private boolean e() {
        if (this.f25996a == null) {
            com.opos.cmn.an.f.a.d("MatView", "mView is null!");
            return false;
        }
        return true;
    }

    @Override // com.opos.mobad.e.a.g
    public final View a() {
        return this.f25996a;
    }

    @Override // com.opos.mobad.e.a.g
    public final void a(Object obj) {
        com.opos.cmn.an.f.a.b("MatView", "setMatImage!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_IMAGE, obj);
                ZkViewSDK.a().a(this.f25996a, hashMap);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("7");
                d.e("zk setMatImage error!Object=" + obj + ",msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "setMatImage error!Object=".concat(String.valueOf(obj)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void a(String str) {
        com.opos.cmn.an.f.a.b("MatView", "updateMatTitle!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_TITLE, str);
                ZkViewSDK.a().a(this.f25996a, hashMap);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("7");
                d.e("zk updateMatTitle error!title=" + str + ",msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "updateMatTitle error!title=".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void b() {
        com.opos.cmn.an.f.a.b("MatView", "pause!");
        if (e()) {
            try {
                ZkViewSDK.a().b(this.f25996a);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("2");
                d.e("zk pause error! + msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "pause error!" + this.f25996a);
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void b(Object obj) {
        com.opos.cmn.an.f.a.b("MatView", "setMatLogo!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_LOGO, obj);
                ZkViewSDK.a().a(this.f25996a, hashMap);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("7");
                d.e("zk setMatLogo error!Object=" + obj + ",msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "setMatLogo error!Object=".concat(String.valueOf(obj)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void b(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatDesc!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_DESC, str);
                ZkViewSDK.a().a(this.f25996a, hashMap);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("7");
                d.e("zk setMatDesc error!desc=" + str + ",msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "setMatDesc error!desc=".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void c() {
        com.opos.cmn.an.f.a.b("MatView", "resume!");
        if (e()) {
            try {
                ZkViewSDK.a().a(this.f25996a);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("1");
                d.e("zk resume error! + msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "resume error!" + this.f25996a);
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void c(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatAction!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_ACTION, str);
                ZkViewSDK.a().a(this.f25996a, hashMap);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("7");
                d.e("zk setMatAction error!action=" + str + ",msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "setMatAction error!action=".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void d() {
        com.opos.cmn.an.f.a.b("MatView", "release!");
        if (e()) {
            try {
                ZkViewSDK.a().c(this.f25996a);
            } catch (Exception e) {
                com.opos.mobad.e.a.a.b.a.a();
                a.c d = com.opos.mobad.e.a.a.b.a.d().a(this.f25997c).d("3");
                d.e("zk release error! + msg:" + e.getMessage()).a(this.b);
                com.opos.cmn.an.f.a.d("MatView", "release error!" + this.f25996a);
            }
        }
    }
}
