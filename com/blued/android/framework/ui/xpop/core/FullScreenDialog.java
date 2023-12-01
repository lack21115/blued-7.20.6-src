package com.blued.android.framework.ui.xpop.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/FullScreenDialog.class */
public class FullScreenDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    BasePopupView f9986a;

    public FullScreenDialog(Context context) {
        super(context, R.style._XPopup_TransparentDialog);
    }

    private String a(int i) {
        try {
            return getContext().getResources().getResourceEntryName(i);
        } catch (Exception e) {
            return "";
        }
    }

    public FullScreenDialog a(BasePopupView basePopupView) {
        this.f9986a = basePopupView;
        return this;
    }

    public void a(int i, boolean z) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (z) {
            attributes.flags = i | attributes.flags;
        } else {
            attributes.flags = i & attributes.flags;
        }
        getWindow().setAttributes(attributes);
    }

    public void a(MotionEvent motionEvent) {
        BasePopupView basePopupView = this.f9986a;
        if (basePopupView == null || !(basePopupView.getContext() instanceof Activity)) {
            return;
        }
        ((Activity) this.f9986a.getContext()).dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (android.os.Build.VERSION.SDK_INT == 27) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() {
        /*
            r3 = this;
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "X"
            boolean r0 = r0.contains(r1)
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L22
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "x"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L1d
            goto L22
        L1d:
            r0 = 0
            r4 = r0
            goto L24
        L22:
            r0 = 1
            r4 = r0
        L24:
            r0 = r6
            r5 = r0
            boolean r0 = com.blued.android.framework.ui.xpop.util.FuckRomUtils.a()
            if (r0 == 0) goto L46
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 == r1) goto L3e
            r0 = r6
            r5 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 27
            if (r0 != r1) goto L46
        L3e:
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 != 0) goto L46
            r0 = 1
            r5 = r0
        L46:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.xpop.core.FullScreenDialog.a():boolean");
    }

    public boolean b() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 23) {
            z = false;
            if ((((Activity) this.f9986a.getContext()).getWindow().getDecorView().getSystemUiVisibility() & 8192) != 0) {
                z = true;
            }
        }
        return z;
    }

    public void c() {
        if (!this.f9986a.l.u.booleanValue()) {
            getWindow().setFlags(1024, 1024);
        } else if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(b() ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public void d() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(a(id))) {
                childAt.setVisibility(4);
            }
        }
        getWindow().setFlags(8, 8);
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 3846);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (a()) {
            motionEvent.setLocation(motionEvent.getX(), motionEvent.getY() + XPopupUtils.a());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getWindow() == null) {
            return;
        }
        BasePopupView basePopupView = this.f9986a;
        if (basePopupView != null && basePopupView.l.F) {
            if (Build.VERSION.SDK_INT >= 26) {
                getWindow().setType(2038);
            } else {
                getWindow().setType(2003);
            }
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setFlags(16777216, 16777216);
        getWindow().setSoftInputMode(16);
        if (a()) {
            getWindow().getDecorView().setTranslationY(-XPopupUtils.a());
            getWindow().setLayout(-1, Math.max(XPopupUtils.c(getWindow()), XPopupUtils.b(getContext())));
        } else {
            getWindow().setLayout(-1, Math.max(XPopupUtils.c(getWindow()), XPopupUtils.b(getContext())));
        }
        getWindow().getDecorView().setSystemUiVisibility(1280);
        if (!this.f9986a.l.B) {
            getWindow().setFlags(8, 8);
        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            a(201326592, true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a(201326592, false);
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(this.f9986a.l.w);
            getWindow().addFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT == 19) {
            getWindow().clearFlags(67108864);
        }
        if (!this.f9986a.l.v.booleanValue()) {
            d();
        }
        c();
        setContentView(this.f9986a);
    }
}
