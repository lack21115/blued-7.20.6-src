package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cz.class */
public class cz implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RelativeLayout f9408a;
    final /* synthetic */ cv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cv cvVar, RelativeLayout relativeLayout) {
        this.b = cvVar;
        this.f9408a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.b.h);
            hashMap.put("banner_container", this.f9408a);
            hashMap.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.b.D));
            hashMap.put("channelId", Integer.valueOf(this.b.E));
            hashMap.put("novel_id", this.b.F);
            hashMap.put("isnight", Boolean.valueOf(this.b.w()));
            this.b.a(cv.u, hashMap);
        }
    }
}
