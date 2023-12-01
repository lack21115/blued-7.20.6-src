package com.anythink.expressad.video.module.a.a;

import android.app.Activity;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/a.class */
public final class a extends f {
    private com.anythink.expressad.foundation.d.c V;

    /* renamed from: a  reason: collision with root package name */
    private Activity f8505a;

    private a(Activity activity, com.anythink.expressad.foundation.d.c cVar) {
        this.f8505a = activity;
        this.V = cVar;
    }

    @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, Object obj) {
        Activity activity;
        super.a(i, obj);
        if (i != 106 || (activity = this.f8505a) == null || this.V == null) {
            return;
        }
        activity.finish();
    }
}
