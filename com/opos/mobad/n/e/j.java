package com.opos.mobad.n.e;

import android.content.Context;
import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/j.class */
public class j implements d {

    /* renamed from: a  reason: collision with root package name */
    private View f12963a;
    private Context b;

    public j(Context context, View view) {
        this.f12963a = view;
        this.b = context;
    }

    private boolean e() {
        if (this.f12963a == null) {
            com.opos.cmn.an.f.a.d("MatView", "mView is null!");
            return false;
        }
        return true;
    }

    @Override // com.opos.mobad.n.e.d
    public View a() {
        return this.f12963a;
    }

    @Override // com.opos.mobad.n.e.d
    public void a(String str) {
        com.opos.cmn.an.f.a.b("MatView", "updateMatTitle!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_TITLE, str);
                ZkViewSDK.a().a(this.f12963a, hashMap);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "updateMatTitle error!title=" + str);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void a(boolean z) {
        com.opos.cmn.an.f.a.b("MatView", "setVideoMute!");
        if (e()) {
            try {
                ZkViewSDK.a().a(this.f12963a, z);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "setVideoMute error!mute=" + z);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void b() {
        com.opos.cmn.an.f.a.b("MatView", "pause!");
        if (e()) {
            try {
                ZkViewSDK.a().b(this.f12963a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "pause error!" + this.f12963a);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void b(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatDesc!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_DESC, str);
                ZkViewSDK.a().a(this.f12963a, hashMap);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "setMatDesc error!desc=" + str);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void c() {
        com.opos.cmn.an.f.a.b("MatView", "resume!");
        if (e()) {
            try {
                ZkViewSDK.a().a(this.f12963a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "resume error!" + this.f12963a);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void c(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatAction!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_ACTION, str);
                ZkViewSDK.a().a(this.f12963a, hashMap);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "setMatAction error!action=" + str);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void d() {
        com.opos.cmn.an.f.a.b("MatView", "release!");
        if (e()) {
            try {
                ZkViewSDK.a().c(this.f12963a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MatView", "release error!" + this.f12963a);
            }
        }
    }
}
