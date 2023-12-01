package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/TooltipCompatHandler.class */
public class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static TooltipCompatHandler j;
    private static TooltipCompatHandler k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1914a;
    private final CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1915c;
    private final Runnable d = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.1
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.a(false);
        }
    };
    private final Runnable e = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.2
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.a();
        }
    };
    private int f;
    private int g;
    private TooltipPopup h;
    private boolean i;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f1914a = view;
        this.b = charSequence;
        this.f1915c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        d();
        this.f1914a.setOnLongClickListener(this);
        this.f1914a.setOnHoverListener(this);
    }

    private static void a(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = j;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.c();
        }
        j = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.b();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) > this.f1915c || Math.abs(y - this.g) > this.f1915c) {
            this.f = x;
            this.g = y;
            return true;
        }
        return false;
    }

    private void b() {
        this.f1914a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f1914a.removeCallbacks(this.d);
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = j;
        if (tooltipCompatHandler != null && tooltipCompatHandler.f1914a == view) {
            a((TooltipCompatHandler) null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new TooltipCompatHandler(view, charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler2 = k;
        if (tooltipCompatHandler2 != null && tooltipCompatHandler2.f1914a == view) {
            tooltipCompatHandler2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    void a() {
        if (k == this) {
            k = null;
            TooltipPopup tooltipPopup = this.h;
            if (tooltipPopup != null) {
                tooltipPopup.a();
                this.h = null;
                d();
                this.f1914a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((TooltipCompatHandler) null);
        }
        this.f1914a.removeCallbacks(this.e);
    }

    void a(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (ViewCompat.isAttachedToWindow(this.f1914a)) {
            a((TooltipCompatHandler) null);
            TooltipCompatHandler tooltipCompatHandler = k;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.a();
            }
            k = this;
            this.i = z;
            TooltipPopup tooltipPopup = new TooltipPopup(this.f1914a.getContext());
            this.h = tooltipPopup;
            tooltipPopup.a(this.f1914a, this.f, this.g, this.i, this.b);
            this.f1914a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j3 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f1914a) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f1914a.removeCallbacks(this.e);
            this.f1914a.postDelayed(this.e, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h == null || !this.i) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1914a.getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action != 10) {
                    return false;
                }
                d();
                a();
                return false;
            } else if (this.f1914a.isEnabled() && this.h == null && a(motionEvent)) {
                a(this);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
