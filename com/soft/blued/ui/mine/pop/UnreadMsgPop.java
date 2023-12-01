package com.soft.blued.ui.mine.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/pop/UnreadMsgPop.class */
public class UnreadMsgPop extends AttachPopupView {
    public String t;

    public UnreadMsgPop(Context context) {
        super(context);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (!StringUtils.d(this.t)) {
            ((TextView) findViewById(2131371675)).setText(this.t);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.mine.pop.UnreadMsgPop.1
            @Override // java.lang.Runnable
            public void run() {
                if (UnreadMsgPop.this.t()) {
                    return;
                }
                UnreadMsgPop.this.p();
            }
        }, 5000L);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_unread_msg_guide;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }
}
