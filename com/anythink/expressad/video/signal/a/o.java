package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import com.anythink.expressad.video.module.AnythinkContainerView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/o.class */
public final class o extends e {
    private Activity n;
    private AnythinkContainerView o;

    private o(Activity activity, AnythinkContainerView anythinkContainerView) {
        this.n = activity;
        this.o = anythinkContainerView;
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i, String str) {
        int i2;
        Activity activity;
        super.a(i, str);
        if (i != 1) {
            if (i == 2 && (activity = this.n) != null) {
                activity.finish();
            }
        } else if (this.o != null) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
                i2 = 1;
            }
            this.o.showVideoClickView(i2);
        }
    }
}
