package com.soft.blued.customview.floating_action;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/TouchDelegateGroup.class */
public class TouchDelegateGroup extends TouchDelegate {

    /* renamed from: a  reason: collision with root package name */
    private static final Rect f14899a = new Rect();
    private final ArrayList<TouchDelegate> b;

    /* renamed from: c  reason: collision with root package name */
    private TouchDelegate f14900c;
    private boolean d;

    public TouchDelegateGroup(View view) {
        super(f14899a, view);
        this.b = new ArrayList<>();
    }

    public void a() {
        this.b.clear();
        this.f14900c = null;
    }

    public void a(TouchDelegate touchDelegate) {
        this.b.add(touchDelegate);
    }

    public void a(boolean z) {
        this.d = z;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate;
        if (this.d) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    touchDelegate = null;
                    if (i2 >= this.b.size()) {
                        break;
                    }
                    TouchDelegate touchDelegate2 = this.b.get(i2);
                    if (touchDelegate2.onTouchEvent(motionEvent)) {
                        this.f14900c = touchDelegate2;
                        return true;
                    }
                    i = i2 + 1;
                }
            } else {
                if (action != 1) {
                    if (action == 2) {
                        touchDelegate = this.f14900c;
                    } else if (action != 3) {
                        touchDelegate = null;
                    }
                }
                touchDelegate = this.f14900c;
                this.f14900c = null;
            }
            boolean z = false;
            if (touchDelegate != null) {
                z = false;
                if (touchDelegate.onTouchEvent(motionEvent)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }
}
