package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/CenterGuidePop.class */
public class CenterGuidePop extends AttachPopupView {
    private String t;
    private int u;

    public CenterGuidePop(Context context, String str) {
        super(context);
        this.u = 5000;
        this.t = str;
    }

    public void a(View view, XPopupCallback xPopupCallback) {
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.a).d(false).a(PopupPosition.c).b(true).a(view).a(this).h();
    }

    public void b() {
        super.b();
        if (!StringUtils.d(this.t)) {
            ((TextView) findViewById(2131371675)).setText(this.t);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.pop.CenterGuidePop.1
            @Override // java.lang.Runnable
            public void run() {
                if (CenterGuidePop.this.t()) {
                    return;
                }
                CenterGuidePop.this.p();
            }
        }, this.u);
    }

    public int getImplLayoutId() {
        return R.layout.pop_gift_guide;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }

    public void u() {
        super.u();
    }
}
