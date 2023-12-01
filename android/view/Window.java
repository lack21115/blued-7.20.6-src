package android.view;

import android.Manifest;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ActionMode;
import android.view.InputQueue;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/view/Window.class */
public abstract class Window {
    @Deprecated
    protected static final int DEFAULT_FEATURES = 65;
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_ACTIVITY_TRANSITIONS = 13;
    public static final int FEATURE_CONTENT_TRANSITIONS = 12;
    public static final int FEATURE_CONTEXT_MENU = 6;
    public static final int FEATURE_CUSTOM_TITLE = 7;
    public static final int FEATURE_INDETERMINATE_PROGRESS = 5;
    public static final int FEATURE_LEFT_ICON = 3;
    public static final int FEATURE_MAX = 13;
    public static final int FEATURE_NO_TITLE = 1;
    public static final int FEATURE_OPTIONS_PANEL = 0;
    public static final int FEATURE_PROGRESS = 2;
    public static final int FEATURE_RIGHT_ICON = 4;
    public static final int FEATURE_SWIPE_TO_DISMISS = 11;
    public static final int ID_ANDROID_CONTENT = 16908290;
    public static final String NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME = "android:navigation:background";
    public static final int PROGRESS_END = 10000;
    public static final int PROGRESS_INDETERMINATE_OFF = -4;
    public static final int PROGRESS_INDETERMINATE_ON = -3;
    public static final int PROGRESS_SECONDARY_END = 30000;
    public static final int PROGRESS_SECONDARY_START = 20000;
    public static final int PROGRESS_START = 0;
    public static final int PROGRESS_VISIBILITY_OFF = -2;
    public static final int PROGRESS_VISIBILITY_ON = -1;
    private static final String PROPERTY_HARDWARE_UI = "persist.sys.ui.hw";
    public static final String STATUS_BAR_BACKGROUND_TRANSITION_NAME = "android:status:background";
    private Window mActiveChild;
    private String mAppName;
    private IBinder mAppToken;
    private Callback mCallback;
    private Window mContainer;
    private final Context mContext;
    private boolean mDestroyed;
    private int mFeatures;
    private boolean mHardwareAccelerated;
    private int mLocalFeatures;
    private OnWindowDismissedCallback mOnWindowDismissedCallback;
    private WindowManager mWindowManager;
    private TypedArray mWindowStyle;
    private boolean mIsActive = false;
    private boolean mHasChildren = false;
    private boolean mCloseOnTouchOutside = false;
    private boolean mSetCloseOnTouchOutside = false;
    private int mForcedWindowFlags = 0;
    private boolean mHaveWindowFormat = false;
    private boolean mHaveDimAmount = false;
    private int mDefaultWindowFormat = -1;
    private boolean mHasSoftInputMode = false;
    private final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();

    /* loaded from: source-4181928-dex2jar.jar:android/view/Window$Callback.class */
    public interface Callback {
        boolean dispatchGenericMotionEvent(MotionEvent motionEvent);

        boolean dispatchKeyEvent(KeyEvent keyEvent);

        boolean dispatchKeyShortcutEvent(KeyEvent keyEvent);

        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        boolean dispatchTouchEvent(MotionEvent motionEvent);

        boolean dispatchTrackballEvent(MotionEvent motionEvent);

        void onActionModeFinished(ActionMode actionMode);

        void onActionModeStarted(ActionMode actionMode);

        void onAttachedToWindow();

        void onContentChanged();

        boolean onCreatePanelMenu(int i, Menu menu);

        View onCreatePanelView(int i);

        void onDetachedFromWindow();

        boolean onMenuItemSelected(int i, MenuItem menuItem);

        boolean onMenuOpened(int i, Menu menu);

        void onPanelClosed(int i, Menu menu);

        boolean onPreparePanel(int i, View view, Menu menu);

        boolean onSearchRequested();

        void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

        void onWindowFocusChanged(boolean z);

        ActionMode onWindowStartingActionMode(ActionMode.Callback callback);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/Window$OnWindowDismissedCallback.class */
    public interface OnWindowDismissedCallback {
        void onWindowDismissed();
    }

    public Window(Context context) {
        this.mContext = context;
        int defaultFeatures = getDefaultFeatures(context);
        this.mLocalFeatures = defaultFeatures;
        this.mFeatures = defaultFeatures;
    }

    public static int getDefaultFeatures(Context context) {
        int i = 0;
        Resources resources = context.getResources();
        if (resources.getBoolean(R.bool.config_defaultWindowFeatureOptionsPanel)) {
            i = 0 | 1;
        }
        int i2 = i;
        if (resources.getBoolean(R.bool.config_defaultWindowFeatureContextMenu)) {
            i2 = i | 64;
        }
        return i2;
    }

    private boolean isOutOfBounds(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getDecorView();
        return x < (-scaledWindowTouchSlop) || y < (-scaledWindowTouchSlop) || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }

    private void setPrivateFlags(int i, int i2) {
        if ((i & i2 & 536870912) != 0) {
            this.mContext.enforceCallingOrSelfPermission(Manifest.permission.PREVENT_POWER_KEY, "No permission to prevent power key");
        }
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.privateFlags = (attributes.privateFlags & (i2 ^ (-1))) | (i & i2);
        dispatchWindowAttributesChanged(attributes);
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public void addFlags(int i) {
        setFlags(i, i);
    }

    public void addPrivateFlags(int i) {
        setPrivateFlags(i, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustLayoutParamsForSubWindow(WindowManager.LayoutParams layoutParams) {
        View peekDecorView;
        CharSequence title = layoutParams.getTitle();
        if (layoutParams.type < 1000 || layoutParams.type > 1999) {
            if (layoutParams.token == null) {
                layoutParams.token = this.mContainer == null ? this.mAppToken : this.mContainer.mAppToken;
            }
            if ((title == null || title.length() == 0) && this.mAppName != null) {
                layoutParams.setTitle(this.mAppName);
            }
        } else {
            if (layoutParams.token == null && (peekDecorView = peekDecorView()) != null) {
                layoutParams.token = peekDecorView.getWindowToken();
            }
            if (title == null || title.length() == 0) {
                String num = layoutParams.type == 1001 ? "Media" : layoutParams.type == 1004 ? "MediaOvr" : layoutParams.type == 1000 ? "Panel" : layoutParams.type == 1002 ? "SubPanel" : layoutParams.type == 1003 ? "AtchDlg" : Integer.toString(layoutParams.type);
                String str = num;
                if (this.mAppName != null) {
                    str = num + ":" + this.mAppName;
                }
                layoutParams.setTitle(str);
            }
        }
        if (layoutParams.packageName == null) {
            layoutParams.packageName = this.mContext.getPackageName();
        }
        if (this.mHardwareAccelerated) {
            layoutParams.flags |= 16777216;
        }
    }

    public abstract void alwaysReadCloseOnTouchAttr();

    public void clearFlags(int i) {
        setFlags(0, i);
    }

    public void clearPrivateFlags(int i) {
        setPrivateFlags(0, i);
    }

    public abstract void closeAllPanels();

    public abstract void closePanel(int i);

    public final void destroy() {
        this.mDestroyed = true;
    }

    public final void dispatchOnWindowDismissed() {
        if (this.mOnWindowDismissedCallback != null) {
            this.mOnWindowDismissedCallback.onWindowDismissed();
        }
    }

    protected void dispatchWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (this.mCallback != null) {
            this.mCallback.onWindowAttributesChanged(layoutParams);
        }
    }

    public View findViewById(int i) {
        return getDecorView().findViewById(i);
    }

    public boolean getAllowEnterTransitionOverlap() {
        return true;
    }

    public boolean getAllowExitTransitionOverlap() {
        return getAllowReturnTransitionOverlap();
    }

    public boolean getAllowReturnTransitionOverlap() {
        return true;
    }

    public final WindowManager.LayoutParams getAttributes() {
        return this.mWindowAttributes;
    }

    public final Callback getCallback() {
        return this.mCallback;
    }

    public final Window getContainer() {
        return this.mContainer;
    }

    public Scene getContentScene() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public abstract View getCurrentFocus();

    public abstract View getDecorView();

    public Transition getEnterTransition() {
        return null;
    }

    public Transition getExitTransition() {
        return null;
    }

    protected final int getFeatures() {
        return this.mFeatures;
    }

    protected final int getForcedWindowFlags() {
        return this.mForcedWindowFlags;
    }

    public abstract LayoutInflater getLayoutInflater();

    protected final int getLocalFeatures() {
        return this.mLocalFeatures;
    }

    public MediaController getMediaController() {
        return null;
    }

    public abstract int getNavigationBarColor();

    public Transition getReenterTransition() {
        return null;
    }

    public Transition getReturnTransition() {
        return null;
    }

    public Transition getSharedElementEnterTransition() {
        return null;
    }

    public Transition getSharedElementExitTransition() {
        return null;
    }

    public Transition getSharedElementReenterTransition() {
        return null;
    }

    public Transition getSharedElementReturnTransition() {
        return null;
    }

    public boolean getSharedElementsUseOverlay() {
        return true;
    }

    public abstract int getStatusBarColor();

    public long getTransitionBackgroundFadeDuration() {
        return 0L;
    }

    public TransitionManager getTransitionManager() {
        return null;
    }

    public abstract int getVolumeControlStream();

    public WindowManager getWindowManager() {
        return this.mWindowManager;
    }

    public final TypedArray getWindowStyle() {
        TypedArray typedArray;
        synchronized (this) {
            if (this.mWindowStyle == null) {
                this.mWindowStyle = this.mContext.obtainStyledAttributes(R.styleable.Window);
            }
            typedArray = this.mWindowStyle;
        }
        return typedArray;
    }

    public final boolean hasChildren() {
        return this.mHasChildren;
    }

    public boolean hasFeature(int i) {
        return (getFeatures() & (1 << i)) != 0;
    }

    protected final boolean hasSoftInputMode() {
        return this.mHasSoftInputMode;
    }

    protected boolean haveDimAmount() {
        return this.mHaveDimAmount;
    }

    public void injectInputEvent(InputEvent inputEvent) {
    }

    public abstract void invalidatePanelMenu(int i);

    public final boolean isActive() {
        return this.mIsActive;
    }

    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    public abstract boolean isFloating();

    public abstract boolean isShortcutKey(int i, KeyEvent keyEvent);

    public final void makeActive() {
        if (this.mContainer != null) {
            if (this.mContainer.mActiveChild != null) {
                this.mContainer.mActiveChild.mIsActive = false;
            }
            this.mContainer.mActiveChild = this;
        }
        this.mIsActive = true;
        onActive();
    }

    protected abstract void onActive();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void openPanel(int i, KeyEvent keyEvent);

    public abstract View peekDecorView();

    public abstract boolean performContextMenuIdentifierAction(int i, int i2);

    public abstract boolean performPanelIdentifierAction(int i, int i2, int i3);

    public abstract boolean performPanelShortcut(int i, int i2, KeyEvent keyEvent, int i3);

    protected void removeFeature(int i) {
        int i2 = 1 << i;
        this.mFeatures &= i2 ^ (-1);
        int i3 = this.mLocalFeatures;
        int i4 = i2;
        if (this.mContainer != null) {
            i4 = i2 & (this.mContainer.mFeatures ^ (-1));
        }
        this.mLocalFeatures = i3 & (i4 ^ (-1));
    }

    public boolean requestFeature(int i) {
        int i2 = 1 << i;
        this.mFeatures |= i2;
        this.mLocalFeatures = (this.mContainer != null ? (this.mContainer.mFeatures ^ (-1)) & i2 : i2) | this.mLocalFeatures;
        return (this.mFeatures & i2) != 0;
    }

    public abstract void restoreHierarchyState(Bundle bundle);

    public abstract Bundle saveHierarchyState();

    public void setAllowEnterTransitionOverlap(boolean z) {
    }

    public void setAllowExitTransitionOverlap(boolean z) {
        setAllowReturnTransitionOverlap(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
    }

    public void setAttributes(WindowManager.LayoutParams layoutParams) {
        this.mWindowAttributes.copyFrom(layoutParams);
        dispatchWindowAttributesChanged(this.mWindowAttributes);
    }

    public abstract void setBackgroundDrawable(Drawable drawable);

    public void setBackgroundDrawableResource(int i) {
        setBackgroundDrawable(this.mContext.getDrawable(i));
    }

    public void setBlurMaskAlphaThreshold(float f) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.blurMaskAlphaThreshold = f;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public abstract void setChildDrawable(int i, Drawable drawable);

    public abstract void setChildInt(int i, int i2);

    public void setClipToOutline(boolean z) {
    }

    public void setCloseOnTouchOutside(boolean z) {
        this.mCloseOnTouchOutside = z;
        this.mSetCloseOnTouchOutside = true;
    }

    public void setCloseOnTouchOutsideIfNotSet(boolean z) {
        if (this.mSetCloseOnTouchOutside) {
            return;
        }
        this.mCloseOnTouchOutside = z;
        this.mSetCloseOnTouchOutside = true;
    }

    public void setContainer(Window window) {
        this.mContainer = window;
        if (window != null) {
            this.mFeatures |= 2;
            this.mLocalFeatures |= 2;
            window.mHasChildren = true;
        }
    }

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public void setDefaultIcon(int i) {
    }

    public void setDefaultLogo(int i) {
    }

    protected void setDefaultWindowFormat(int i) {
        this.mDefaultWindowFormat = i;
        if (this.mHaveWindowFormat) {
            return;
        }
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.format = i;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setDimAmount(float f) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.dimAmount = f;
        this.mHaveDimAmount = true;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setDisableWallpaperTouchEvents(boolean z) {
        setPrivateFlags(z ? 16384 : 0, 16384);
    }

    public void setElevation(float f) {
    }

    public void setEnterTransition(Transition transition) {
    }

    public void setExitTransition(Transition transition) {
    }

    public abstract void setFeatureDrawable(int i, Drawable drawable);

    public abstract void setFeatureDrawableAlpha(int i, int i2);

    public abstract void setFeatureDrawableResource(int i, int i2);

    public abstract void setFeatureDrawableUri(int i, Uri uri);

    public abstract void setFeatureInt(int i, int i2);

    public void setFlags(int i, int i2) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.flags = (attributes.flags & (i2 ^ (-1))) | (i & i2);
        this.mForcedWindowFlags |= i2;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setFormat(int i) {
        WindowManager.LayoutParams attributes = getAttributes();
        if (i != 0) {
            attributes.format = i;
            this.mHaveWindowFormat = true;
        } else {
            attributes.format = this.mDefaultWindowFormat;
            this.mHaveWindowFormat = false;
        }
        dispatchWindowAttributesChanged(attributes);
    }

    public void setGravity(int i) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.gravity = i;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setIcon(int i) {
    }

    public void setLayout(int i, int i2) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.width = i;
        attributes.height = i2;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setLocalFocus(boolean z, boolean z2) {
    }

    public void setLogo(int i) {
    }

    public void setMediaController(MediaController mediaController) {
    }

    public abstract void setNavigationBarColor(int i);

    protected void setNeedsMenuKey(int i) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.needsMenuKey = i;
        dispatchWindowAttributesChanged(attributes);
    }

    public final void setOnWindowDismissedCallback(OnWindowDismissedCallback onWindowDismissedCallback) {
        this.mOnWindowDismissedCallback = onWindowDismissedCallback;
    }

    public void setReenterTransition(Transition transition) {
    }

    public void setReturnTransition(Transition transition) {
    }

    public void setSharedElementEnterTransition(Transition transition) {
    }

    public void setSharedElementExitTransition(Transition transition) {
    }

    public void setSharedElementReenterTransition(Transition transition) {
    }

    public void setSharedElementReturnTransition(Transition transition) {
    }

    public void setSharedElementsUseOverlay(boolean z) {
    }

    public void setSoftInputMode(int i) {
        WindowManager.LayoutParams attributes = getAttributes();
        if (i != 0) {
            attributes.softInputMode = i;
            this.mHasSoftInputMode = true;
        } else {
            this.mHasSoftInputMode = false;
        }
        dispatchWindowAttributesChanged(attributes);
    }

    public abstract void setStatusBarColor(int i);

    public abstract void setTitle(CharSequence charSequence);

    @Deprecated
    public abstract void setTitleColor(int i);

    public void setTransitionBackgroundFadeDuration(long j) {
    }

    public void setTransitionManager(TransitionManager transitionManager) {
        throw new UnsupportedOperationException();
    }

    public void setType(int i) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.type = i;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setUiOptions(int i) {
    }

    public void setUiOptions(int i, int i2) {
    }

    public abstract void setVolumeControlStream(int i);

    public void setWindowAnimations(int i) {
        WindowManager.LayoutParams attributes = getAttributes();
        attributes.windowAnimations = i;
        dispatchWindowAttributesChanged(attributes);
    }

    public void setWindowManager(WindowManager windowManager, IBinder iBinder, String str) {
        setWindowManager(windowManager, iBinder, str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (android.os.SystemProperties.getBoolean(android.view.Window.PROPERTY_HARDWARE_UI, false) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setWindowManager(android.view.WindowManager r5, android.os.IBinder r6, java.lang.String r7, boolean r8) {
        /*
            r4 = this;
            r0 = 0
            r9 = r0
            r0 = r4
            r1 = r6
            r0.mAppToken = r1
            r0 = r4
            r1 = r7
            r0.mAppName = r1
            r0 = r8
            if (r0 != 0) goto L1f
            r0 = r9
            r8 = r0
            java.lang.String r0 = "persist.sys.ui.hw"
            r1 = 0
            boolean r0 = android.os.SystemProperties.getBoolean(r0, r1)
            if (r0 == 0) goto L22
        L1f:
            r0 = 1
            r8 = r0
        L22:
            r0 = r4
            r1 = r8
            r0.mHardwareAccelerated = r1
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L3c
            r0 = r4
            android.content.Context r0 = r0.mContext
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            r6 = r0
        L3c:
            r0 = r4
            r1 = r6
            android.view.WindowManagerImpl r1 = (android.view.WindowManagerImpl) r1
            r2 = r4
            android.view.WindowManagerImpl r1 = r1.createLocalWindowManager(r2)
            r0.mWindowManager = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.Window.setWindowManager(android.view.WindowManager, android.os.IBinder, java.lang.String, boolean):void");
    }

    public boolean shouldCloseOnTouch(Context context, MotionEvent motionEvent) {
        return this.mCloseOnTouchOutside && motionEvent.getAction() == 0 && isOutOfBounds(context, motionEvent) && peekDecorView() != null;
    }

    public abstract boolean superDispatchGenericMotionEvent(MotionEvent motionEvent);

    public abstract boolean superDispatchKeyEvent(KeyEvent keyEvent);

    public abstract boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent);

    public abstract boolean superDispatchTouchEvent(MotionEvent motionEvent);

    public abstract boolean superDispatchTrackballEvent(MotionEvent motionEvent);

    public abstract void takeInputQueue(InputQueue.Callback callback);

    public abstract void takeKeyEvents(boolean z);

    public abstract void takeSurface(SurfaceHolder.Callback2 callback2);

    public abstract void togglePanel(int i, KeyEvent keyEvent);
}
