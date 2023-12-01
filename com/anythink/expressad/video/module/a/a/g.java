package com.anythink.expressad.video.module.a.a;

import com.anythink.expressad.video.module.AnythinkClickMiniCardView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/g.class */
public final class g extends i {

    /* renamed from: a  reason: collision with root package name */
    private AnythinkClickMiniCardView f5668a;

    public g(AnythinkClickMiniCardView anythinkClickMiniCardView, com.anythink.expressad.video.module.a.a aVar) {
        super(aVar);
        this.f5668a = anythinkClickMiniCardView;
    }

    @Override // com.anythink.expressad.video.module.a.a.i, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, Object obj) {
        boolean z;
        int i2;
        switch (i) {
            case 100:
                AnythinkClickMiniCardView anythinkClickMiniCardView = this.f5668a;
                z = false;
                i2 = i;
                if (anythinkClickMiniCardView != null) {
                    anythinkClickMiniCardView.webviewshow();
                    AnythinkClickMiniCardView anythinkClickMiniCardView2 = this.f5668a;
                    anythinkClickMiniCardView2.onSelfConfigurationChanged(anythinkClickMiniCardView2.getResources().getConfiguration());
                    i2 = i;
                    z = false;
                    break;
                }
                break;
            case 101:
            case 102:
                z = true;
                i2 = i;
                break;
            case 103:
                i2 = 107;
                z = false;
                break;
            default:
                z = false;
                i2 = i;
                break;
        }
        if (z) {
            return;
        }
        super.a(i2, obj);
    }
}
