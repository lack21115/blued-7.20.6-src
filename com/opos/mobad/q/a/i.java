package com.opos.mobad.q.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/i.class */
public abstract class i implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int[] f13528a = new int[4];

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a(view, this.f13528a);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f13528a;
        if (iArr == null || iArr.length < 4) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f13528a[0] = (int) motionEvent.getX();
            this.f13528a[1] = (int) motionEvent.getY();
            return false;
        } else if (1 == motionEvent.getAction()) {
            this.f13528a[2] = (int) motionEvent.getX();
            this.f13528a[3] = (int) motionEvent.getY();
            return false;
        } else {
            return false;
        }
    }
}
