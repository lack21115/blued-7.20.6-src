package android.view;

import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.view.InputEventReceiver;
import android.view.WindowManager;
import android.view.animation.Animation;
import java.io.PrintWriter;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy.class */
public interface WindowManagerPolicy {
    public static final String ACTION_HDMI_PLUGGED = "android.intent.action.HDMI_PLUGGED";
    public static final int ACTION_PASS_TO_USER = 1;
    public static final String EXTRA_HDMI_PLUGGED_STATE = "state";
    public static final int FINISH_LAYOUT_REDO_ANIM = 8;
    public static final int FINISH_LAYOUT_REDO_CONFIG = 2;
    public static final int FINISH_LAYOUT_REDO_LAYOUT = 1;
    public static final int FINISH_LAYOUT_REDO_WALLPAPER = 4;
    public static final int FLAG_DISABLE_KEY_REPEAT = 134217728;
    public static final int FLAG_FILTERED = 67108864;
    public static final int FLAG_INJECTED = 16777216;
    public static final int FLAG_INTERACTIVE = 536870912;
    public static final int FLAG_PASS_TO_USER = 1073741824;
    public static final int FLAG_TRUSTED = 33554432;
    public static final int FLAG_VIRTUAL = 2;
    public static final int FLAG_WAKE = 1;
    public static final int OFF_BECAUSE_OF_ADMIN = 1;
    public static final int OFF_BECAUSE_OF_TIMEOUT = 3;
    public static final int OFF_BECAUSE_OF_USER = 2;
    public static final int PRESENCE_EXTERNAL = 2;
    public static final int PRESENCE_INTERNAL = 1;
    public static final int TRANSIT_ENTER = 1;
    public static final int TRANSIT_EXIT = 2;
    public static final int TRANSIT_HIDE = 4;
    public static final int TRANSIT_PREVIEW_DONE = 5;
    public static final int TRANSIT_SHOW = 3;
    public static final int USER_ROTATION_FREE = 0;
    public static final int USER_ROTATION_LOCKED = 1;
    public static final boolean WATCH_POINTER = false;

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy$FakeWindow.class */
    public interface FakeWindow {
        void dismiss();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy$OnKeyguardExitResult.class */
    public interface OnKeyguardExitResult {
        void onKeyguardExitResult(boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy$PointerEventListener.class */
    public interface PointerEventListener {
        void onPointerEvent(MotionEvent motionEvent);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy$ScreenOnListener.class */
    public interface ScreenOnListener {
        void onScreenOn();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy$WindowManagerFuncs.class */
    public interface WindowManagerFuncs {
        public static final int CAMERA_LENS_COVERED = 1;
        public static final int CAMERA_LENS_COVER_ABSENT = -1;
        public static final int CAMERA_LENS_UNCOVERED = 0;
        public static final int LID_ABSENT = -1;
        public static final int LID_CLOSED = 0;
        public static final int LID_OPEN = 1;

        FakeWindow addFakeWindow(Looper looper, InputEventReceiver.Factory factory, String str, int i, int i2, int i3, boolean z, boolean z2, boolean z3);

        void addSystemUIVisibilityFlag(int i);

        int getCameraLensCoverState();

        int getLidState();

        Object getWindowManagerLock();

        void rebootSafeMode(boolean z);

        void reevaluateStatusBarVisibility();

        void registerPointerEventListener(PointerEventListener pointerEventListener);

        void shutdown(boolean z);

        void switchKeyboardLayout(int i, int i2);

        void unregisterPointerEventListener(PointerEventListener pointerEventListener);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicy$WindowState.class */
    public interface WindowState {
        void computeFrameLw(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, Rect rect6, Rect rect7);

        IApplicationToken getAppToken();

        WindowManager.LayoutParams getAttrs();

        Rect getContentFrameLw();

        Rect getDisplayFrameLw();

        Rect getFrameLw();

        Rect getGivenContentInsetsLw();

        boolean getGivenInsetsPendingLw();

        Rect getGivenVisibleInsetsLw();

        boolean getNeedsMenuLw(WindowState windowState);

        Rect getOverscanFrameLw();

        String getOwningPackage();

        int getOwningUid();

        RectF getShownFrameLw();

        int getSurfaceLayer();

        int getSystemUiVisibility();

        Rect getVisibleFrameLw();

        boolean hasAppShownWindows();

        boolean hasDrawnLw();

        boolean hideLw(boolean z);

        boolean isAlive();

        boolean isAnimatingLw();

        boolean isDefaultDisplay();

        boolean isDisplayedLw();

        boolean isGoneForLayoutLw();

        boolean isVisibleLw();

        boolean isVisibleOrBehindKeyguardLw();

        boolean isVoiceInteraction();

        boolean showLw(boolean z);
    }

    View addStartingWindow(IBinder iBinder, String str, int i, CompatibilityInfo compatibilityInfo, CharSequence charSequence, int i2, int i3, int i4, int i5);

    void adjustConfigurationLw(Configuration configuration, int i, int i2);

    int adjustSystemUiVisibilityLw(int i);

    void adjustWindowParamsLw(WindowManager.LayoutParams layoutParams);

    boolean allowAppAnimationsLw();

    void applyPostLayoutPolicyLw(WindowState windowState, WindowManager.LayoutParams layoutParams, WindowState windowState2);

    void beginLayoutLw(boolean z, int i, int i2, int i3);

    void beginPostLayoutPolicyLw(int i, int i2);

    boolean canBeForceHidden(WindowState windowState, WindowManager.LayoutParams layoutParams);

    boolean canMagnifyWindow(int i);

    int checkAddPermission(WindowManager.LayoutParams layoutParams, int[] iArr);

    boolean checkShowToOwnerOnly(WindowManager.LayoutParams layoutParams);

    Animation createForceHideEnterAnimation(boolean z, boolean z2);

    Animation createForceHideWallpaperExitAnimation(boolean z, boolean z2);

    void dismissKeyguardLw();

    KeyEvent dispatchUnhandledKey(WindowState windowState, KeyEvent keyEvent, int i);

    void dump(String str, PrintWriter printWriter, String[] strArr);

    void enableKeyguard(boolean z);

    void enableScreenAfterBoot();

    void exitKeyguardSecurely(OnKeyguardExitResult onKeyguardExitResult);

    void finishLayoutLw();

    int finishPostLayoutPolicyLw();

    int focusChangedLw(WindowState windowState, WindowState windowState2);

    int getAboveUniverseLayer();

    int getConfigDisplayHeight(int i, int i2, int i3);

    int getConfigDisplayWidth(int i, int i2, int i3);

    void getContentRectLw(Rect rect);

    int getInputMethodWindowVisibleHeightLw();

    void getInsetHintLw(WindowManager.LayoutParams layoutParams, Rect rect, Rect rect2);

    int getMaxWallpaperLayer();

    int getNonDecorDisplayHeight(int i, int i2, int i3);

    int getNonDecorDisplayWidth(int i, int i2, int i3);

    int getSystemDecorLayerLw();

    int getUserRotationMode();

    WindowState getWinShowWhenLockedLw();

    void goingToSleep(int i);

    boolean hasNavigationBar();

    boolean hasPermanentMenuKey();

    void hideBootMessages();

    boolean inKeyguardRestrictedKeyInputMode();

    void init(Context context, IWindowManager iWindowManager, WindowManagerFuncs windowManagerFuncs);

    long interceptKeyBeforeDispatching(WindowState windowState, KeyEvent keyEvent, int i);

    int interceptKeyBeforeQueueing(KeyEvent keyEvent, int i);

    int interceptMotionBeforeQueueingNonInteractive(long j, int i);

    boolean isDefaultOrientationForced();

    boolean isForceHiding(WindowManager.LayoutParams layoutParams);

    boolean isKeyguardDrawnLw();

    boolean isKeyguardHostWindow(WindowManager.LayoutParams layoutParams);

    boolean isKeyguardLocked();

    boolean isKeyguardSecure();

    boolean isScreenOn();

    boolean isTopLevelWindow(int i);

    void keepScreenOnStartedLw();

    void keepScreenOnStoppedLw();

    void layoutWindowLw(WindowState windowState, WindowState windowState2);

    void lockNow(Bundle bundle);

    boolean needsNavigationBar();

    void notifyActivityDrawnForKeyguardLw();

    void notifyCameraLensCoverSwitchChanged(long j, boolean z);

    void notifyLidSwitchChanged(long j, boolean z);

    boolean performHapticFeedbackLw(WindowState windowState, int i, boolean z);

    int prepareAddWindowLw(WindowState windowState, WindowManager.LayoutParams layoutParams);

    void removeStartingWindow(IBinder iBinder, View view);

    void removeWindowLw(WindowState windowState);

    int rotationForOrientationLw(int i, int i2);

    boolean rotationHasCompatibleMetricsLw(int i, int i2);

    void screenTurnedOff();

    void screenTurningOn(ScreenOnListener screenOnListener);

    int selectAnimationLw(WindowState windowState, int i);

    void selectRotationAnimationLw(int[] iArr);

    void setCurrentOrientationLw(int i);

    void setCurrentUserLw(int i);

    void setDisplayOverscan(Display display, int i, int i2, int i3, int i4);

    void setInitialDisplaySize(Display display, int i, int i2, int i3);

    void setLastInputMethodWindowLw(WindowState windowState, WindowState windowState2);

    void setRotationLw(int i);

    void setSafeMode(boolean z);

    void setUserRotationMode(int i, int i2);

    void showBootMessage(CharSequence charSequence, boolean z);

    void showGlobalActions();

    void showRecentApps();

    void startKeyguardExitAnimation(long j, long j2);

    int subWindowTypeToLayerLw(int i);

    void systemBooted();

    void systemReady();

    void userActivity();

    boolean validateRotationAnimationLw(int i, int i2, boolean z);

    void wakingUp();

    int windowTypeToLayerLw(int i);
}
