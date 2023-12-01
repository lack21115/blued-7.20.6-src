package com.anythink.expressad.widget;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import java.util.Calendar;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/widget/a.class */
public abstract class a implements View.OnClickListener {
    public static final int d = 2000;

    /* renamed from: a  reason: collision with root package name */
    private long f8784a = 0;

    protected abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f8784a > 2000) {
            this.f8784a = timeInMillis;
            a(view);
        }
    }
}
