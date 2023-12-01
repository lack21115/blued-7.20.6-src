package com.soft.blued.ui.live.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.blued.android.module.live_china.activity.LiveFloatDialogActivity;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.soft.blued.R;
import com.soft.blued.ui.discover.fragment.SendFeedFloatManager;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/live/activity/SendFeedDialogActivity.class */
public class SendFeedDialogActivity extends LiveFloatDialogActivity {
    public int i;

    public void c() {
        TextView textView = (TextView) this.h.findViewById(2131371259);
        int i = this.i;
        if (i == 0) {
            textView.setText(getString(R.string.feed_float_dialog_des));
        } else if (i == 1) {
            textView.setText(getString(R.string.task_float_dialog_des));
        }
    }

    public void d() {
        int i = this.i;
        if (i != 0) {
            if (i == 1) {
                GlobalTaskFloatManager.a().c();
            }
        } else if (FeedSendManager.a().d() == null || FeedSendManager.a().d().size() <= 0) {
        } else {
            SendFeedFloatManager.a().c();
        }
    }

    public void e() {
        if (this.i == 0) {
            SendFeedFloatManager.a().a(false);
            SendFeedFloatManager.a().b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = getIntent().getIntExtra("type", 0);
    }
}
