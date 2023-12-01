package com.opos.cmn.e.a.b.a;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/a/b.class */
public class b extends a {
    private ObjectAnimator b;

    public b(View view) {
        super(view);
        c();
    }

    private void c() {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11069a, Key.ROTATION, 0.0f, 360.0f);
            this.b = ofFloat;
            ofFloat.setDuration(1000L);
            this.b.setRepeatMode(1);
            this.b.setRepeatCount(-1);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.e.a.b.a.a
    public void a() {
        try {
            this.b.start();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.e.a.b.a.a
    public void b() {
        try {
            this.b.cancel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LoadingAnimCreative", "", (Throwable) e);
        }
    }
}
