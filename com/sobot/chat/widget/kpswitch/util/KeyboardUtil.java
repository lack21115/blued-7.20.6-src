package com.sobot.chat.widget.kpswitch.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.kpswitch.IPanelHeightTarget;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KeyboardUtil.class */
public class KeyboardUtil {
    private static int LAST_SAVE_KEYBOARD_HEIGHT;
    private static int MAX_PANEL_HEIGHT;
    private static int MIN_KEYBOARD_HEIGHT;
    private static int MIN_PANEL_HEIGHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KeyboardUtil$KeyboardStatusListener.class */
    public static class KeyboardStatusListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private static final String TAG = "KeyboardStatusListener";
        private final ViewGroup contentView;
        private final boolean isFitSystemWindows;
        private final boolean isFullScreen;
        private final boolean isTranslucentStatus;
        private final OnKeyboardShowingListener keyboardShowingListener;
        private boolean lastKeyboardShowing;
        private int maxOverlayLayoutHeight;
        private final IPanelHeightTarget panelHeightTarget;
        private final int screenHeight;
        private final int statusBarHeight;
        private int previousDisplayHeight = 0;
        private boolean isOverlayLayoutDisplayHContainStatusBar = false;

        KeyboardStatusListener(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, IPanelHeightTarget iPanelHeightTarget, OnKeyboardShowingListener onKeyboardShowingListener, int i) {
            this.contentView = viewGroup;
            this.panelHeightTarget = iPanelHeightTarget;
            this.isFullScreen = z;
            this.isTranslucentStatus = z2;
            this.isFitSystemWindows = z3;
            this.statusBarHeight = StatusBarHeightUtil.getStatusBarHeight(viewGroup.getContext());
            this.keyboardShowingListener = onKeyboardShowingListener;
            this.screenHeight = i;
        }

        private void calculateKeyboardHeight(int i) {
            int abs;
            int validPanelHeight;
            if (this.previousDisplayHeight == 0) {
                this.previousDisplayHeight = i;
                this.panelHeightTarget.refreshHeight(KeyboardUtil.getValidPanelHeight(getContext()));
                return;
            }
            if (KPSwitchConflictUtil.isHandleByPlaceholder(this.isFullScreen, this.isTranslucentStatus, this.isFitSystemWindows)) {
                abs = ((View) this.contentView.getParent()).getHeight() - i;
                Log.d(TAG, String.format("action bar over layout %d display height: %d", Integer.valueOf(((View) this.contentView.getParent()).getHeight()), Integer.valueOf(i)));
            } else {
                abs = Math.abs(i - this.previousDisplayHeight);
            }
            if (abs <= KeyboardUtil.getMinKeyboardHeight(getContext())) {
                return;
            }
            Log.d(TAG, String.format("pre display height: %d display height: %d keyboard: %d ", Integer.valueOf(this.previousDisplayHeight), Integer.valueOf(i), Integer.valueOf(abs)));
            if (abs == this.statusBarHeight) {
                Log.w(TAG, String.format("On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (!KeyboardUtil.saveKeyboardHeight(getContext(), abs) || this.panelHeightTarget.getHeight() == (validPanelHeight = KeyboardUtil.getValidPanelHeight(getContext()))) {
            } else {
                this.panelHeightTarget.refreshHeight(validPanelHeight);
            }
        }

        private void calculateKeyboardShowing(int i) {
            boolean z;
            View view = (View) this.contentView.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (KPSwitchConflictUtil.isHandleByPlaceholder(this.isFullScreen, this.isTranslucentStatus, this.isFitSystemWindows)) {
                z = (this.isTranslucentStatus || height - i != this.statusBarHeight) ? height > i : this.lastKeyboardShowing;
            } else {
                z = (this.maxOverlayLayoutHeight == 0 || SobotApi.getSwitchMarkStatus(1)) ? this.lastKeyboardShowing : i < this.maxOverlayLayoutHeight - KeyboardUtil.getMinKeyboardHeight(getContext());
                this.maxOverlayLayoutHeight = Math.max(this.maxOverlayLayoutHeight, height);
            }
            if (this.lastKeyboardShowing != z) {
                Log.d(TAG, String.format("displayHeight %d actionBarOverlayLayoutHeight %d keyboard status change: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                this.panelHeightTarget.onKeyboardShowing(z);
                OnKeyboardShowingListener onKeyboardShowingListener = this.keyboardShowingListener;
                if (onKeyboardShowingListener != null) {
                    onKeyboardShowingListener.onKeyboardShowing(z);
                }
            }
            this.lastKeyboardShowing = z;
        }

        private Context getContext() {
            return this.contentView.getContext();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            boolean z = false;
            View childAt = this.contentView.getChildAt(0);
            View view = (View) this.contentView.getParent();
            Rect rect = new Rect();
            if (this.isTranslucentStatus) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.isOverlayLayoutDisplayHContainStatusBar) {
                    if (i2 == this.screenHeight) {
                        z = true;
                    }
                    this.isOverlayLayoutDisplayHContainStatusBar = z;
                }
                i = i2;
                if (!this.isOverlayLayoutDisplayHContainStatusBar) {
                    i = i2 + this.statusBarHeight;
                }
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i == -1) {
                return;
            }
            calculateKeyboardHeight(i);
            calculateKeyboardShowing(i);
            this.previousDisplayHeight = i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KeyboardUtil$OnKeyboardShowingListener.class */
    public interface OnKeyboardShowingListener {
        void onKeyboardShowing(boolean z);
    }

    public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity activity, IPanelHeightTarget iPanelHeightTarget) {
        return attach(activity, iPanelHeightTarget, null);
    }

    public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity activity, IPanelHeightTarget iPanelHeightTarget, OnKeyboardShowingListener onKeyboardShowingListener) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        boolean isFullScreen = ViewUtil.isFullScreen(activity);
        boolean isTranslucentStatus = ViewUtil.isTranslucentStatus(activity);
        boolean isFitsSystemWindows = ViewUtil.isFitsSystemWindows(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        KeyboardStatusListener keyboardStatusListener = new KeyboardStatusListener(isFullScreen, isTranslucentStatus, isFitsSystemWindows, viewGroup, iPanelHeightTarget, onKeyboardShowingListener, height);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(keyboardStatusListener);
        return keyboardStatusListener;
    }

    public static void detach(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (Build.VERSION.SDK_INT >= 16) {
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static int getKeyboardHeight(Context context) {
        if (LAST_SAVE_KEYBOARD_HEIGHT == 0) {
            LAST_SAVE_KEYBOARD_HEIGHT = KeyBoardSharedPreferences.get(context, getMinPanelHeight(context));
        }
        return LAST_SAVE_KEYBOARD_HEIGHT;
    }

    public static int getMaxPanelHeight(Context context) {
        Resources resources = context.getResources();
        if (MAX_PANEL_HEIGHT == 0) {
            MAX_PANEL_HEIGHT = resources.getDimensionPixelSize(ResourceUtils.getIdByName(context, "dimen", "sobot_max_panel_height"));
        }
        return MAX_PANEL_HEIGHT;
    }

    public static int getMinKeyboardHeight(Context context) {
        if (MIN_KEYBOARD_HEIGHT == 0) {
            MIN_KEYBOARD_HEIGHT = context.getResources().getDimensionPixelSize(ResourceUtils.getIdByName(context, "dimen", "sobot_min_keyboard_height"));
        }
        return MIN_KEYBOARD_HEIGHT;
    }

    public static int getMinPanelHeight(Context context) {
        Resources resources = context.getResources();
        if (MIN_PANEL_HEIGHT == 0) {
            MIN_PANEL_HEIGHT = resources.getDimensionPixelSize(ResourceUtils.getIdByName(context, "dimen", "sobot_min_panel_height"));
        }
        return MIN_PANEL_HEIGHT;
    }

    public static int getValidPanelHeight(Context context) {
        return Math.min(getMaxPanelHeight(context), Math.max(getMinPanelHeight(context), getKeyboardHeight(context)));
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean saveKeyboardHeight(Context context, int i) {
        if (LAST_SAVE_KEYBOARD_HEIGHT != i && i >= 0) {
            LAST_SAVE_KEYBOARD_HEIGHT = i;
            Log.d("KeyBordUtil", String.format("save keyboard: %d", Integer.valueOf(i)));
            return KeyBoardSharedPreferences.save(context, i);
        }
        return false;
    }

    public static void showKeyboard(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view, 0);
    }
}
