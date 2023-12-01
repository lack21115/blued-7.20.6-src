package com.anythink.expressad.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.anythink.expressad.foundation.f.b;
import com.anythink.expressad.foundation.h.o;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/activity/ATBaseActivity.class */
public abstract class ATBaseActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4144a = "ATBaseActivity";
    private OrientationEventListener b;

    /* renamed from: c  reason: collision with root package name */
    private Display f4145c;
    private int d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.activity.ATBaseActivity$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/activity/ATBaseActivity$2.class */
    public final class AnonymousClass2 extends OrientationEventListener {
        AnonymousClass2(Context context) {
            super(context, 1);
        }

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int i) {
            int c2 = ATBaseActivity.this.c();
            int i2 = c2;
            if (c2 < 0) {
                i2 = 0;
            }
            if (i2 == 1 && ATBaseActivity.this.d != 1) {
                ATBaseActivity.this.d = 1;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.f4144a, "Orientation Left");
            } else if (i2 == 3 && ATBaseActivity.this.d != 2) {
                ATBaseActivity.this.d = 2;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.f4144a, "Orientation Right");
            } else if (i2 == 0 && ATBaseActivity.this.d != 3) {
                ATBaseActivity.this.d = 3;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.f4144a, "Orientation Top");
            } else if (i2 != 2 || ATBaseActivity.this.d == 4) {
            } else {
                ATBaseActivity.this.d = 4;
                ATBaseActivity.this.a();
                o.d(ATBaseActivity.f4144a, "Orientation Bottom");
            }
        }
    }

    private void b() {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this);
        this.b = anonymousClass2;
        if (anonymousClass2.canDetectOrientation()) {
            this.b.enable();
            return;
        }
        this.b.disable();
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        if (this.f4145c == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f4145c = getDisplay();
            } else {
                this.f4145c = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            }
        }
        Display display = this.f4145c;
        if (display != null) {
            try {
                return display.getRotation();
            } catch (Throwable th) {
                return -1;
            }
        }
        return -1;
    }

    private void d() {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                getWindow().getDecorView().setSystemUiVisibility(2);
                return;
            }
            getWindow().addFlags(67108864);
            getWindow().getDecorView().setSystemUiVisibility(4098);
        } catch (Throwable th) {
            o.d(f4144a, th.getMessage());
        }
    }

    static /* synthetic */ void d(ATBaseActivity aTBaseActivity) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(aTBaseActivity);
        aTBaseActivity.b = anonymousClass2;
        if (anonymousClass2.canDetectOrientation()) {
            aTBaseActivity.b.enable();
            return;
        }
        aTBaseActivity.b.disable();
        aTBaseActivity.b = null;
    }

    public final void a() {
        getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.anythink.expressad.activity.ATBaseActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                DisplayCutout displayCutout;
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WindowInsets rootWindowInsets = ATBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        if (rootWindowInsets == null || Build.VERSION.SDK_INT < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                            i = -1;
                            i2 = 0;
                            i3 = 0;
                            i4 = 0;
                            i5 = 0;
                        } else {
                            i2 = displayCutout.getSafeInsetLeft();
                            i3 = displayCutout.getSafeInsetRight();
                            i4 = displayCutout.getSafeInsetTop();
                            int safeInsetBottom = displayCutout.getSafeInsetBottom();
                            o.d(ATBaseActivity.f4144a, "NOTCH Left:" + i2 + " Right:" + i3 + " Top:" + i4 + " Bottom:" + safeInsetBottom);
                            int c2 = ATBaseActivity.this.c();
                            if (ATBaseActivity.this.d == -1) {
                                ATBaseActivity.this.d = c2 == 0 ? 3 : c2 == 1 ? 1 : c2 == 2 ? 4 : c2 == 3 ? 2 : -1;
                                StringBuilder sb = new StringBuilder();
                                sb.append(ATBaseActivity.this.d);
                                o.d(ATBaseActivity.f4144a, sb.toString());
                            }
                            if (c2 == 0) {
                                i5 = safeInsetBottom;
                                i = 0;
                            } else if (c2 == 1) {
                                i5 = safeInsetBottom;
                                i = 90;
                            } else if (c2 == 2) {
                                i5 = safeInsetBottom;
                                i = 180;
                            } else if (c2 != 3) {
                                i5 = safeInsetBottom;
                                i = -1;
                            } else {
                                i5 = safeInsetBottom;
                                i = 270;
                            }
                        }
                        ATBaseActivity.this.a(i, i2, i3, i4, i5);
                        if (ATBaseActivity.this.b == null) {
                            ATBaseActivity.d(ATBaseActivity.this);
                        }
                    }
                } catch (Throwable th) {
                    o.d(ATBaseActivity.f4144a, th.getMessage());
                }
            }
        }, 500L);
    }

    public abstract void a(int i, int i2, int i3, int i4, int i5);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            d();
            c();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e) {
            o.d(f4144a, e.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.b = null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (b.f4978c) {
            return;
        }
        a();
        d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        d();
    }
}
