package com.sobot.chat.widget.kpswitch.util;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KPSwitchConflictUtil.class */
public class KPSwitchConflictUtil {
    private static boolean mIsInMultiWindowMode = false;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KPSwitchConflictUtil$SubPanelAndTrigger.class */
    public static class SubPanelAndTrigger {
        final View subPanelView;
        final View triggerView;

        public SubPanelAndTrigger(View view, View view2) {
            this.subPanelView = view;
            this.triggerView = view2;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/KPSwitchConflictUtil$SwitchClickListener.class */
    public interface SwitchClickListener {
        void onClickSwitch(View view, boolean z);
    }

    public static void attach(View view, View view2, View view3) {
        attach(view, view2, view3, (SwitchClickListener) null);
    }

    public static void attach(final View view, View view2, final View view3, final SwitchClickListener switchClickListener) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.kpswitch.util.KPSwitchConflictUtil.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    Tracker.onClick(view4);
                    boolean switchPanelAndKeyboard = KPSwitchConflictUtil.switchPanelAndKeyboard(view, view3);
                    SwitchClickListener switchClickListener2 = switchClickListener;
                    if (switchClickListener2 != null) {
                        switchClickListener2.onClickSwitch(view4, switchPanelAndKeyboard);
                    }
                }
            });
        }
        if (isHandleByPlaceholder(activity)) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.sobot.chat.widget.kpswitch.util.KPSwitchConflictUtil.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view4, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        if (SobotApi.getSwitchMarkStatus(1)) {
                            view.setVisibility(8);
                            return false;
                        }
                        view.setVisibility(4);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    public static void attach(final View view, View view2, SwitchClickListener switchClickListener, SubPanelAndTrigger... subPanelAndTriggerArr) {
        Activity activity = (Activity) view.getContext();
        int length = subPanelAndTriggerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            bindSubPanel(subPanelAndTriggerArr[i2], subPanelAndTriggerArr, view2, view, switchClickListener);
            i = i2 + 1;
        }
        if (isHandleByPlaceholder(activity)) {
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.sobot.chat.widget.kpswitch.util.KPSwitchConflictUtil.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        if (SobotApi.getSwitchMarkStatus(1)) {
                            view.setVisibility(8);
                            return false;
                        }
                        view.setVisibility(4);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    public static void attach(View view, View view2, SubPanelAndTrigger... subPanelAndTriggerArr) {
        attach(view, view2, (SwitchClickListener) null, subPanelAndTriggerArr);
    }

    private static void bindSubPanel(SubPanelAndTrigger subPanelAndTrigger, final SubPanelAndTrigger[] subPanelAndTriggerArr, final View view, final View view2, final SwitchClickListener switchClickListener) {
        View view3 = subPanelAndTrigger.triggerView;
        final View view4 = subPanelAndTrigger.subPanelView;
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.kpswitch.util.KPSwitchConflictUtil.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view5) {
                Boolean bool;
                Tracker.onClick(view5);
                if (view2.getVisibility() != 0) {
                    KPSwitchConflictUtil.showPanel(view2);
                    bool = true;
                    KPSwitchConflictUtil.showBoundTriggerSubPanel(view4, subPanelAndTriggerArr);
                } else if (view4.getVisibility() == 0) {
                    KPSwitchConflictUtil.showKeyboard(view2, view);
                    bool = false;
                } else {
                    KPSwitchConflictUtil.showBoundTriggerSubPanel(view4, subPanelAndTriggerArr);
                    bool = null;
                }
                SwitchClickListener switchClickListener2 = switchClickListener;
                if (switchClickListener2 == null || bool == null) {
                    return;
                }
                switchClickListener2.onClickSwitch(view5, bool.booleanValue());
            }
        });
    }

    public static void hidePanelAndKeyboard(View view) {
        Activity activity = (Activity) view.getContext();
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
            currentFocus.clearFocus();
        }
        view.setVisibility(8);
    }

    static boolean isHandleByPlaceholder(Activity activity) {
        return isHandleByPlaceholder(ViewUtil.isFullScreen(activity), ViewUtil.isTranslucentStatus(activity), ViewUtil.isFitsSystemWindows(activity));
    }

    public static boolean isHandleByPlaceholder(boolean z, boolean z2, boolean z3) {
        if (z) {
            return true;
        }
        return z2 && !z3;
    }

    public static void onMultiWindowModeChanged(boolean z) {
        mIsInMultiWindowMode = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showBoundTriggerSubPanel(View view, SubPanelAndTrigger[] subPanelAndTriggerArr) {
        int length = subPanelAndTriggerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                view.setVisibility(0);
                return;
            }
            SubPanelAndTrigger subPanelAndTrigger = subPanelAndTriggerArr[i2];
            if (subPanelAndTrigger.subPanelView != view) {
                subPanelAndTrigger.subPanelView.setVisibility(8);
            }
            i = i2 + 1;
        }
    }

    public static void showKeyboard(View view, View view2) {
        KeyboardUtil.showKeyboard(view2);
        if (!isHandleByPlaceholder((Activity) view.getContext())) {
            if (mIsInMultiWindowMode) {
                view.setVisibility(8);
            }
        } else if (SobotApi.getSwitchMarkStatus(1)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(4);
        }
    }

    public static void showPanel(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (!SobotApi.getSwitchMarkStatus(1)) {
            if (activity.getCurrentFocus() != null) {
                KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
                return;
            }
            return;
        }
        LogUtils.e(view.getMeasuredHeight() + "");
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (int) (((double) ScreenUtils.getScreenHeight(activity)) * 0.37d);
        view.setLayoutParams(layoutParams);
        if (activity.getCurrentFocus() != null) {
            KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
        }
    }

    public static boolean switchPanelAndKeyboard(View view, View view2) {
        boolean z = view.getVisibility() != 0;
        if (z) {
            showPanel(view);
            return z;
        }
        showKeyboard(view, view2);
        return z;
    }
}
