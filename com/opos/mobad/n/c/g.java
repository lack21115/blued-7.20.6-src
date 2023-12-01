package com.opos.mobad.n.c;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/g.class */
public abstract class g implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int[] f12923a = new int[4];

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a(view, this.f12923a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f12923a;
        if (iArr == null || iArr.length < 4) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f12923a[0] = (int) motionEvent.getX();
            this.f12923a[1] = (int) motionEvent.getY();
            return false;
        } else if (1 == motionEvent.getAction()) {
            this.f12923a[2] = (int) motionEvent.getX();
            this.f12923a[3] = (int) motionEvent.getY();
            return false;
        } else {
            return false;
        }
    }
}
