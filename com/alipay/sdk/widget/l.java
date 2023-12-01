package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/l.class */
public class l extends j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f4690a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, p pVar) {
        super(jVar, null);
        this.b = jVar;
        this.f4690a = pVar;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f4690a.a();
        this.b.v = false;
    }
}
