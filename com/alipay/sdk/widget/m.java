package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/m.class */
public class m extends j.a {
    final /* synthetic */ p a;
    final /* synthetic */ String b;
    final /* synthetic */ j c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, p pVar, String str) {
        super(jVar, null);
        this.c = jVar;
        this.a = pVar;
        this.b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        p pVar;
        this.c.removeView(this.a);
        pVar = this.c.x;
        pVar.a(this.b);
        this.c.v = false;
    }
}
