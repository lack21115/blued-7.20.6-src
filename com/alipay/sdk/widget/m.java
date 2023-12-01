package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/m.class */
public class m extends j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f4691a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j f4692c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, p pVar, String str) {
        super(jVar, null);
        this.f4692c = jVar;
        this.f4691a = pVar;
        this.b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        p pVar;
        this.f4692c.removeView(this.f4691a);
        pVar = this.f4692c.x;
        pVar.a(this.b);
        this.f4692c.v = false;
    }
}
