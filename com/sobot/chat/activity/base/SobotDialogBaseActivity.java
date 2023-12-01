package com.sobot.chat.activity.base;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.SobotApi;
import com.sobot.chat.notchlib.INotchScreen;
import com.sobot.chat.notchlib.NotchScreenManager;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/base/SobotDialogBaseActivity.class */
public abstract class SobotDialogBaseActivity extends SobotBaseActivity {
    public static void displayInNotch(Activity activity, final View view) {
        if (!SobotApi.getSwitchMarkStatus(1) || !SobotApi.getSwitchMarkStatus(4) || view == null || activity == null) {
            return;
        }
        NotchScreenManager.getInstance().getNotchInfo(activity, new INotchScreen.NotchScreenCallback() { // from class: com.sobot.chat.activity.base.SobotDialogBaseActivity.1
            @Override // com.sobot.chat.notchlib.INotchScreen.NotchScreenCallback
            public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                if (notchScreenInfo.hasNotch) {
                    for (Rect rect : notchScreenInfo.notchRects) {
                        View view2 = view;
                        int i = 110;
                        if (rect.right <= 110) {
                            i = rect.right;
                        }
                        view2.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                    }
                }
            }
        });
    }

    private void overridePending() {
        overridePendingTransition(ResourceUtils.getIdByName(getApplicationContext(), i.f, "sobot_popupwindow_in"), ResourceUtils.getIdByName(getApplicationContext(), i.f, "sobot_popupwindow_out"));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePending();
    }

    public Activity getContext() {
        return this;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            if (SobotApi.getSwitchMarkStatus(1)) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(7);
            }
        }
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || motionEvent.getY() > 0.0f) {
            return true;
        }
        finish();
        return true;
    }
}
