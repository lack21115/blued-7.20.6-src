package com.alipay.sdk.widget;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.alipay.sdk.widget.p;
import com.bytedance.applog.tracker.Tracker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/q.class */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f4697a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.f4697a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p.c cVar;
        Handler handler;
        ImageView imageView;
        ImageView imageView2;
        Tracker.onClick(view);
        cVar = this.f4697a.i;
        if (cVar != null) {
            view.setEnabled(false);
            handler = p.f;
            handler.postDelayed(new r(this, view), 256L);
            imageView = this.f4697a.f4695a;
            if (view == imageView) {
                cVar.a(this.f4697a);
                return;
            }
            imageView2 = this.f4697a.f4696c;
            if (view == imageView2) {
                cVar.b(this.f4697a);
            }
        }
    }
}
