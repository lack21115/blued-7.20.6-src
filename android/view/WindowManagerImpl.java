package android.view;

import android.os.IBinder;
import android.view.ViewGroup;
import android.view.WindowManager;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerImpl.class */
public final class WindowManagerImpl implements WindowManager {
    private IBinder mDefaultToken;
    private final Display mDisplay;
    private final WindowManagerGlobal mGlobal;
    private final Window mParentWindow;

    public WindowManagerImpl(Display display) {
        this(display, null);
    }

    private WindowManagerImpl(Display display, Window window) {
        this.mGlobal = WindowManagerGlobal.getInstance();
        this.mDisplay = display;
        this.mParentWindow = window;
    }

    private void applyDefaultToken(ViewGroup.LayoutParams layoutParams) {
        if (this.mDefaultToken == null || this.mParentWindow != null) {
            return;
        }
        if (!(layoutParams instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        if (layoutParams2.token == null) {
            layoutParams2.token = this.mDefaultToken;
        }
    }

    @Override // android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        applyDefaultToken(layoutParams);
        this.mGlobal.addView(view, layoutParams, this.mDisplay, this.mParentWindow);
    }

    public WindowManagerImpl createLocalWindowManager(Window window) {
        return new WindowManagerImpl(this.mDisplay, window);
    }

    public WindowManagerImpl createPresentationWindowManager(Display display) {
        return new WindowManagerImpl(display, this.mParentWindow);
    }

    @Override // android.view.WindowManager
    public Display getDefaultDisplay() {
        return this.mDisplay;
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        this.mGlobal.removeView(view, false);
    }

    @Override // android.view.WindowManager
    public void removeViewImmediate(View view) {
        this.mGlobal.removeView(view, true);
    }

    public void setDefaultToken(IBinder iBinder) {
        this.mDefaultToken = iBinder;
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        applyDefaultToken(layoutParams);
        this.mGlobal.updateViewLayout(view, layoutParams);
    }
}
