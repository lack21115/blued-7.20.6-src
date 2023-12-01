package com.tencent.turingface.sdk.mfa;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.turingface.sdk.mfa.gELYz;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/tZ3Yi.class */
public abstract class tZ3Yi implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Window.Callback f39994a;

    public tZ3Yi(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f39994a = callback;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f39994a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f39994a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f39994a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f39994a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        QmgHg qmgHg;
        FxCVY fxCVY = (FxCVY) this;
        hxUS9 hxus9 = fxCVY.b;
        String str = fxCVY.f39875c;
        ((gELYz.SkEpO) hxus9).getClass();
        synchronized (QmgHg.f39913c) {
            int i = QmgHg.b;
            if (i > 0) {
                qmgHg = QmgHg.f39912a;
                QmgHg.f39912a = qmgHg.d;
                qmgHg.d = null;
                qmgHg.e = false;
                QmgHg.b = i - 1;
            } else {
                qmgHg = new QmgHg();
            }
        }
        qmgHg.m = str;
        qmgHg.f = motionEvent.getAction();
        qmgHg.g = motionEvent.getDeviceId();
        qmgHg.h = motionEvent.getToolType(0);
        qmgHg.i = motionEvent.getRawX();
        qmgHg.j = motionEvent.getRawY();
        qmgHg.k = motionEvent.getPressure();
        qmgHg.l = motionEvent.getSize();
        gELYz.b.obtainMessage(1, qmgHg).sendToTarget();
        try {
            return this.f39994a.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            return true;
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f39994a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f39994a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f39994a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f39994a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f39994a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f39994a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.f39994a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f39994a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f39994a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        return this.f39994a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        this.f39994a.onPanelClosed(i, menu);
    }

    public final void onPointerCaptureChanged(boolean z) {
        this.f39994a.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f39994a.onPreparePanel(i, view, menu);
    }

    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.f39994a.onProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f39994a.onSearchRequested();
    }

    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f39994a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        try {
            this.f39994a.onWindowAttributesChanged(layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.f39994a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f39994a.onWindowStartingActionMode(callback);
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f39994a.onWindowStartingActionMode(callback, i);
    }
}
