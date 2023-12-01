package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ForwardingListener.class */
public abstract class ForwardingListener implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1775a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    final View f1776c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ForwardingListener$DisallowIntercept.class */
    public class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f1776c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ForwardingListener$TriggerLongPress.class */
    public class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.a();
        }
    }

    public ForwardingListener(View view) {
        this.f1776c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1775a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.b = tapTimeout;
        this.d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.f1776c;
        if (view.isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new DisallowIntercept();
                }
                view.postDelayed(this.e, this.b);
                if (this.f == null) {
                    this.f = new TriggerLongPress();
                }
                view.postDelayed(this.f, this.d);
                return false;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.h);
                    if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1775a)) {
                        return false;
                    }
                    b();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                } else if (actionMasked != 3) {
                    return false;
                }
            }
            b();
            return false;
        }
        return false;
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    private void b() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.f1776c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            this.f1776c.removeCallbacks(runnable2);
        }
    }

    private boolean b(MotionEvent motionEvent) {
        View view = this.f1776c;
        ShowableListMenu popup = getPopup();
        boolean z = false;
        if (popup != null) {
            if (!popup.isShowing()) {
                return false;
            }
            DropDownListView dropDownListView = (DropDownListView) popup.getListView();
            z = false;
            if (dropDownListView != null) {
                if (!dropDownListView.isShown()) {
                    return false;
                }
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                b(view, obtainNoHistory);
                a(dropDownListView, obtainNoHistory);
                boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.h);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z2 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                z = false;
                if (onForwardedEvent) {
                    z = false;
                    if (z2) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    void a() {
        b();
        View view = this.f1776c;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    public abstract ShowableListMenu getPopup();

    protected boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (popup == null || popup.isShowing()) {
            return true;
        }
        popup.show();
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = b(motionEvent) || !onForwardingStopped();
        } else {
            boolean z3 = a(motionEvent) && onForwardingStarted();
            z = z3;
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1776c.onTouchEvent(obtain);
                obtain.recycle();
                z = z3;
            }
        }
        this.g = z;
        boolean z4 = true;
        if (!z) {
            if (z2) {
                return true;
            }
            z4 = false;
        }
        return z4;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        Runnable runnable = this.e;
        if (runnable != null) {
            this.f1776c.removeCallbacks(runnable);
        }
    }
}
