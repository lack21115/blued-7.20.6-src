package com.opos.cmn.e.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/a.class */
public abstract class a implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int[] f24750a = new int[4];

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a(view, this.f24750a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f24750a;
        if (iArr == null || iArr.length < 4) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f24750a[0] = (int) motionEvent.getX();
            this.f24750a[1] = (int) motionEvent.getY();
            return false;
        } else if (1 == motionEvent.getAction()) {
            this.f24750a[2] = (int) motionEvent.getX();
            this.f24750a[3] = (int) motionEvent.getY();
            return false;
        } else {
            return false;
        }
    }
}
