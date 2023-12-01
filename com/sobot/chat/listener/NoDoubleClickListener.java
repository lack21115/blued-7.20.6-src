package com.sobot.chat.listener;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import java.util.Calendar;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/NoDoubleClickListener.class */
public abstract class NoDoubleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.lastClickTime > 1000) {
            this.lastClickTime = timeInMillis;
            onNoDoubleClick(view);
        }
    }

    public abstract void onNoDoubleClick(View view);
}
