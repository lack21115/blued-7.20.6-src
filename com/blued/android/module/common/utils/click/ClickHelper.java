package com.blued.android.module.common.utils.click;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/ClickHelper.class */
public class ClickHelper implements View.OnTouchListener {
    private static final String i = ClickHelper.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    int f10916a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f10917c;
    int d;
    boolean e;
    boolean f;
    Runnable g;
    Runnable h;
    private View j;

    /* renamed from: com.blued.android.module.common.utils.click.ClickHelper$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/ClickHelper$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ClickHelper f10918a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10918a.e) {
                this.f10918a.e = false;
            }
        }
    }

    /* renamed from: com.blued.android.module.common.utils.click.ClickHelper$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/ClickHelper$2.class */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ClickHelper f10919a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10919a.f) {
                this.f10919a.f = false;
            }
        }
    }

    public void a() {
        if (!this.f) {
            this.f = true;
            this.j.postDelayed(this.h, 500L);
            return;
        }
        b();
        this.f = false;
        this.j.removeCallbacks(this.h);
    }

    public void b() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.e || motionEvent.getAction() == 0) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f10916a = (int) motionEvent.getX();
                this.b = (int) motionEvent.getY();
                this.e = true;
                this.j.postDelayed(this.g, 250L);
                return false;
            } else if (action == 1) {
                this.f10917c = (int) motionEvent.getX();
                this.d = (int) motionEvent.getY();
                if (Math.abs(this.f10917c - this.f10916a) > 100 || Math.abs(this.d - this.b) > 100) {
                    this.e = false;
                    this.j.removeCallbacks(this.g);
                    return false;
                }
                this.e = false;
                this.j.removeCallbacks(this.g);
                a();
                return false;
            } else if (action != 2) {
                if (action != 3) {
                    return false;
                }
                this.e = false;
                this.j.removeCallbacks(this.g);
                return false;
            } else {
                this.f10917c = (int) motionEvent.getX();
                this.d = (int) motionEvent.getY();
                if (Math.abs(this.f10917c - this.f10916a) > 100 || Math.abs(this.d - this.b) > 100) {
                    this.e = false;
                    this.j.removeCallbacks(this.g);
                    return false;
                }
                return false;
            }
        }
        return false;
    }
}
