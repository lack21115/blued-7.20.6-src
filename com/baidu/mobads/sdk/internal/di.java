package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/di.class */
class di extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dg f9420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(dg dgVar, long j, long j2) {
        super(j, j2);
        this.f9420a = dgVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9420a.b.a("CountDownTimer finished");
        this.f9420a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        int i = (int) (j / 1000);
        int i2 = i;
        if (i > 5) {
            i2 = 5;
        }
        textView = this.f9420a.d;
        textView.setText(String.valueOf(i2));
    }
}
