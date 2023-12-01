package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/i.class */
public final class i extends b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f5678a;
    private AnythinkBTContainer d;

    public i(Activity activity, AnythinkBTContainer anythinkBTContainer) {
        this.f5678a = activity;
        this.d = anythinkBTContainer;
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.d
    public final void click(int i, String str) {
        super.click(i, str);
        AnythinkBTContainer anythinkBTContainer = this.d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.click(i, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.d
    public final void handlerH5Exception(int i, String str) {
        super.handlerH5Exception(i, str);
        AnythinkBTContainer anythinkBTContainer = this.d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.handlerH5Exception(i, str);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.b, com.anythink.expressad.video.signal.b
    public final void reactDeveloper(Object obj, String str) {
        super.reactDeveloper(obj, str);
        AnythinkBTContainer anythinkBTContainer = this.d;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.reactDeveloper(obj, str);
        }
    }
}
