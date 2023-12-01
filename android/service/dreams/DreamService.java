package android.service.dreams;

import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.service.dreams.IDreamManager;
import android.service.dreams.IDreamService;
import android.util.MathUtils;
import android.util.Slog;
import android.view.ActionMode;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;
import com.android.internal.policy.PolicyManager;
import com.android.internal.util.DumpUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/service/dreams/DreamService.class */
public class DreamService extends Service implements Window.Callback {
    public static final String DREAM_META_DATA = "android.service.dream";
    public static final String DREAM_SERVICE = "dreams";
    public static final String SERVICE_INTERFACE = "android.service.dreams.DreamService";
    private boolean mCanDoze;
    private boolean mDozing;
    private boolean mFinished;
    private boolean mFullscreen;
    private boolean mInteractive;
    private boolean mStarted;
    private boolean mWaking;
    private Window mWindow;
    private IBinder mWindowToken;
    private boolean mWindowless;
    private final String TAG = DreamService.class.getSimpleName() + "[" + getClass().getSimpleName() + "]";
    private final Handler mHandler = new Handler();
    private boolean mLowProfile = true;
    private boolean mScreenBright = true;
    private int mDozeScreenState = 0;
    private int mDozeScreenBrightness = -1;
    private boolean mDebug = false;
    private final IDreamManager mSandman = IDreamManager.Stub.asInterface(ServiceManager.getService(DREAM_SERVICE));

    /* loaded from: source-9557208-dex2jar.jar:android/service/dreams/DreamService$DreamServiceWrapper.class */
    private final class DreamServiceWrapper extends IDreamService.Stub {
        private DreamServiceWrapper() {
        }

        @Override // android.service.dreams.IDreamService
        public void attach(final IBinder iBinder, final boolean z) {
            DreamService.this.mHandler.post(new Runnable() { // from class: android.service.dreams.DreamService.DreamServiceWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    DreamService.this.attach(iBinder, z);
                }
            });
        }

        @Override // android.service.dreams.IDreamService
        public void detach() {
            DreamService.this.mHandler.post(new Runnable() { // from class: android.service.dreams.DreamService.DreamServiceWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    DreamService.this.detach();
                }
            });
        }

        @Override // android.service.dreams.IDreamService
        public void wakeUp() {
            DreamService.this.mHandler.post(new Runnable() { // from class: android.service.dreams.DreamService.DreamServiceWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    DreamService.this.wakeUp(true);
                }
            });
        }
    }

    private int applyFlags(int i, int i2, int i3) {
        return ((i3 ^ (-1)) & i) | (i2 & i3);
    }

    private void applySystemUiVisibilityFlags(int i, int i2) {
        View decorView = this.mWindow == null ? null : this.mWindow.getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(applyFlags(decorView.getSystemUiVisibility(), i, i2));
        }
    }

    private void applyWindowFlags(int i, int i2) {
        if (this.mWindow != null) {
            WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
            attributes.flags = applyFlags(attributes.flags, i, i2);
            this.mWindow.setAttributes(attributes);
            this.mWindow.getWindowManager().updateViewLayout(this.mWindow.getDecorView(), attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attach(IBinder iBinder, boolean z) {
        if (this.mWindowToken != null) {
            Slog.e(this.TAG, "attach() called when already attached with token=" + this.mWindowToken);
        } else if (this.mFinished || this.mWaking) {
            Slog.w(this.TAG, "attach() called after dream already finished");
            try {
                this.mSandman.finishSelf(iBinder, true);
            } catch (RemoteException e) {
            }
        } else {
            this.mWindowToken = iBinder;
            this.mCanDoze = z;
            if (this.mWindowless && !this.mCanDoze) {
                throw new IllegalStateException("Only doze dreams can be windowless");
            }
            if (!this.mWindowless) {
                this.mWindow = PolicyManager.makeNewWindow(this);
                this.mWindow.setCallback(this);
                this.mWindow.requestFeature(1);
                this.mWindow.setBackgroundDrawable(new ColorDrawable(-16777216));
                this.mWindow.setFormat(-1);
                if (this.mDebug) {
                    Slog.v(this.TAG, String.format("Attaching window token: %s to window of type %s", iBinder, Integer.valueOf((int) WindowManager.LayoutParams.TYPE_DREAM)));
                }
                WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
                attributes.type = WindowManager.LayoutParams.TYPE_DREAM;
                attributes.token = iBinder;
                attributes.windowAnimations = R.style.Animation_Dream;
                attributes.flags = (this.mScreenBright ? 128 : 0) | 4784385 | (this.mFullscreen ? 1024 : 0) | attributes.flags;
                this.mWindow.setAttributes(attributes);
                this.mWindow.clearFlags(Integer.MIN_VALUE);
                this.mWindow.setWindowManager(null, iBinder, "dream", true);
                int i = 0;
                if (this.mLowProfile) {
                    i = 1;
                }
                applySystemUiVisibilityFlags(i, 1);
                try {
                    getWindowManager().addView(this.mWindow.getDecorView(), this.mWindow.getAttributes());
                } catch (WindowManager.BadTokenException e2) {
                    Slog.i(this.TAG, "attach() called after window token already removed, dream will finish soon");
                    this.mWindow = null;
                    return;
                }
            }
            this.mHandler.post(new Runnable() { // from class: android.service.dreams.DreamService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DreamService.this.mWindow != null || DreamService.this.mWindowless) {
                        if (DreamService.this.mDebug) {
                            Slog.v(DreamService.this.TAG, "Calling onDreamingStarted()");
                        }
                        DreamService.this.mStarted = true;
                        DreamService.this.onDreamingStarted();
                    }
                }
            });
        }
    }

    private static int clampAbsoluteBrightness(int i) {
        return MathUtils.constrain(i, 0, 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detach() {
        if (this.mStarted) {
            if (this.mDebug) {
                Slog.v(this.TAG, "detach(): Calling onDreamingStopped()");
            }
            this.mStarted = false;
            onDreamingStopped();
        }
        if (this.mWindow != null) {
            if (this.mDebug) {
                Slog.v(this.TAG, "detach(): Removing window from window manager");
            }
            this.mWindow.getWindowManager().removeViewImmediate(this.mWindow.getDecorView());
            this.mWindow = null;
        }
        if (this.mWindowToken != null) {
            WindowManagerGlobal.getInstance().closeAll(this.mWindowToken, getClass().getName(), "Dream");
            this.mWindowToken = null;
            this.mCanDoze = false;
        }
    }

    private boolean getSystemUiVisibilityFlagValue(int i, boolean z) {
        View decorView = this.mWindow == null ? null : this.mWindow.getDecorView();
        return decorView == null ? z : (decorView.getSystemUiVisibility() & i) != 0;
    }

    private boolean getWindowFlagValue(int i, boolean z) {
        return this.mWindow == null ? z : (this.mWindow.getAttributes().flags & i) != 0;
    }

    private void updateDoze() {
        if (this.mDozing) {
            try {
                this.mSandman.startDozing(this.mWindowToken, this.mDozeScreenState, this.mDozeScreenBrightness);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeUp(boolean z) {
        if (this.mDebug) {
            Slog.v(this.TAG, "wakeUp(): fromSystem=" + z + ", mWaking=" + this.mWaking + ", mFinished=" + this.mFinished);
        }
        if (this.mWaking || this.mFinished) {
            return;
        }
        this.mWaking = true;
        onWakeUp();
        if (z || this.mFinished) {
            return;
        }
        if (this.mWindowToken == null) {
            Slog.w(this.TAG, "WakeUp was called before the dream was attached.");
            return;
        }
        try {
            this.mSandman.finishSelf(this.mWindowToken, false);
        } catch (RemoteException e) {
        }
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getWindow().addContentView(view, layoutParams);
    }

    public boolean canDoze() {
        return this.mCanDoze;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mInteractive) {
            return this.mWindow.superDispatchGenericMotionEvent(motionEvent);
        }
        if (this.mDebug) {
            Slog.v(this.TAG, "Waking up on genericMotionEvent");
        }
        wakeUp();
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.mInteractive) {
            if (this.mDebug) {
                Slog.v(this.TAG, "Waking up on keyEvent");
            }
            wakeUp();
            return true;
        } else if (keyEvent.getKeyCode() == 4) {
            if (this.mDebug) {
                Slog.v(this.TAG, "Waking up on back key");
            }
            wakeUp();
            return true;
        } else {
            return this.mWindow.superDispatchKeyEvent(keyEvent);
        }
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.mInteractive) {
            return this.mWindow.superDispatchKeyShortcutEvent(keyEvent);
        }
        if (this.mDebug) {
            Slog.v(this.TAG, "Waking up on keyShortcutEvent");
        }
        wakeUp();
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mInteractive) {
            return this.mWindow.superDispatchTouchEvent(motionEvent);
        }
        if (this.mDebug) {
            Slog.v(this.TAG, "Waking up on touchEvent");
        }
        wakeUp();
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.mInteractive) {
            return this.mWindow.superDispatchTrackballEvent(motionEvent);
        }
        if (this.mDebug) {
            Slog.v(this.TAG, "Waking up on trackballEvent");
        }
        wakeUp();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Service
    public void dump(final FileDescriptor fileDescriptor, PrintWriter printWriter, final String[] strArr) {
        DumpUtils.dumpAsync(this.mHandler, new DumpUtils.Dump() { // from class: android.service.dreams.DreamService.2
            @Override // com.android.internal.util.DumpUtils.Dump
            public void dump(PrintWriter printWriter2) {
                DreamService.this.dumpOnHandler(fileDescriptor, printWriter2, strArr);
            }
        }, printWriter, 1000L);
    }

    protected void dumpOnHandler(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(this.TAG + ": ");
        if (this.mWindowToken == null) {
            printWriter.println("stopped");
        } else {
            printWriter.println("running (token=" + this.mWindowToken + ")");
        }
        printWriter.println("  window: " + this.mWindow);
        printWriter.print("  flags:");
        if (isInteractive()) {
            printWriter.print(" interactive");
        }
        if (isLowProfile()) {
            printWriter.print(" lowprofile");
        }
        if (isFullscreen()) {
            printWriter.print(" fullscreen");
        }
        if (isScreenBright()) {
            printWriter.print(" bright");
        }
        if (isWindowless()) {
            printWriter.print(" windowless");
        }
        if (isDozing()) {
            printWriter.print(" dozing");
        } else if (canDoze()) {
            printWriter.print(" candoze");
        }
        printWriter.println();
        if (canDoze()) {
            printWriter.println("  doze screen state: " + Display.stateToString(this.mDozeScreenState));
            printWriter.println("  doze screen brightness: " + this.mDozeScreenBrightness);
        }
    }

    public View findViewById(int i) {
        return getWindow().findViewById(i);
    }

    public final void finish() {
        if (this.mDebug) {
            Slog.v(this.TAG, "finish(): mFinished=" + this.mFinished);
        }
        if (this.mFinished) {
            return;
        }
        this.mFinished = true;
        if (this.mWindowToken == null) {
            Slog.w(this.TAG, "Finish was called before the dream was attached.");
        } else {
            try {
                this.mSandman.finishSelf(this.mWindowToken, true);
            } catch (RemoteException e) {
            }
        }
        stopSelf();
    }

    public int getDozeScreenBrightness() {
        return this.mDozeScreenBrightness;
    }

    public int getDozeScreenState() {
        return this.mDozeScreenState;
    }

    public Window getWindow() {
        return this.mWindow;
    }

    public WindowManager getWindowManager() {
        if (this.mWindow != null) {
            return this.mWindow.getWindowManager();
        }
        return null;
    }

    public boolean isDozing() {
        return this.mDozing;
    }

    public boolean isFullscreen() {
        return this.mFullscreen;
    }

    public boolean isInteractive() {
        return this.mInteractive;
    }

    public boolean isLowProfile() {
        return getSystemUiVisibilityFlagValue(1, this.mLowProfile);
    }

    public boolean isScreenBright() {
        return getWindowFlagValue(128, this.mScreenBright);
    }

    public boolean isWindowless() {
        return this.mWindowless;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (this.mDebug) {
            Slog.v(this.TAG, "onBind() intent = " + intent);
        }
        return new DreamServiceWrapper();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // android.app.Service
    public void onCreate() {
        if (this.mDebug) {
            Slog.v(this.TAG, "onCreate()");
        }
        super.onCreate();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return false;
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mDebug) {
            Slog.v(this.TAG, "onDestroy()");
        }
        detach();
        super.onDestroy();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
    }

    public void onDreamingStarted() {
        if (this.mDebug) {
            Slog.v(this.TAG, "onDreamingStarted()");
        }
    }

    public void onDreamingStopped() {
        if (this.mDebug) {
            Slog.v(this.TAG, "onDreamingStopped()");
        }
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return false;
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    public void onWakeUp() {
        finish();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setContentView(int i) {
        getWindow().setContentView(i);
    }

    public void setContentView(View view) {
        getWindow().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getWindow().setContentView(view, layoutParams);
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public void setDozeScreenBrightness(int i) {
        int i2 = i;
        if (i != -1) {
            i2 = clampAbsoluteBrightness(i);
        }
        if (this.mDozeScreenBrightness != i2) {
            this.mDozeScreenBrightness = i2;
            updateDoze();
        }
    }

    public void setDozeScreenState(int i) {
        if (this.mDozeScreenState != i) {
            this.mDozeScreenState = i;
            updateDoze();
        }
    }

    public void setFullscreen(boolean z) {
        if (this.mFullscreen != z) {
            this.mFullscreen = z;
            applyWindowFlags(this.mFullscreen ? 1024 : 0, 1024);
        }
    }

    public void setInteractive(boolean z) {
        this.mInteractive = z;
    }

    public void setLowProfile(boolean z) {
        if (this.mLowProfile != z) {
            this.mLowProfile = z;
            applySystemUiVisibilityFlags(this.mLowProfile ? 1 : 0, 1);
        }
    }

    public void setScreenBright(boolean z) {
        if (this.mScreenBright != z) {
            this.mScreenBright = z;
            applyWindowFlags(this.mScreenBright ? 128 : 0, 128);
        }
    }

    public void setWindowless(boolean z) {
        this.mWindowless = z;
    }

    public void startDozing() {
        if (!this.mCanDoze || this.mDozing) {
            return;
        }
        this.mDozing = true;
        updateDoze();
    }

    public void stopDozing() {
        if (this.mDozing) {
            this.mDozing = false;
            try {
                this.mSandman.stopDozing(this.mWindowToken);
            } catch (RemoteException e) {
            }
        }
    }

    public final void wakeUp() {
        wakeUp(false);
    }
}
