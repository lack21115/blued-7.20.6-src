package com.opos.cmn.e.a.a;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/a/b.class */
public class b implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int[] f11065a;

    public b(int[] iArr) {
        this.f11065a = iArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f11065a;
        if (iArr == null || iArr.length < 4) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f11065a[0] = (int) motionEvent.getX();
            this.f11065a[1] = (int) motionEvent.getY();
            return false;
        } else if (1 == motionEvent.getAction()) {
            this.f11065a[2] = (int) motionEvent.getX();
            this.f11065a[3] = (int) motionEvent.getY();
            return false;
        } else {
            return false;
        }
    }
}
