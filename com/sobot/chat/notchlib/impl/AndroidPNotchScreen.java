package com.sobot.chat.notchlib.impl;

import android.app.Activity;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.sobot.chat.notchlib.INotchScreen;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/notchlib/impl/AndroidPNotchScreen.class */
public class AndroidPNotchScreen implements INotchScreen {
    @Override // com.sobot.chat.notchlib.INotchScreen
    public void getNotchRect(Activity activity, final INotchScreen.NotchSizeCallback notchSizeCallback) {
        final View decorView = activity.getWindow().getDecorView();
        decorView.post(new Runnable() { // from class: com.sobot.chat.notchlib.impl.AndroidPNotchScreen.1
            @Override // java.lang.Runnable
            public void run() {
                DisplayCutout displayCutout;
                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                    notchSizeCallback.onResult(null);
                } else {
                    notchSizeCallback.onResult(displayCutout.getBoundingRects());
                }
            }
        });
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public boolean hasNotch(Activity activity) {
        return true;
    }

    @Override // com.sobot.chat.notchlib.INotchScreen
    public void setDisplayInNotch(Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(1280);
    }
}
