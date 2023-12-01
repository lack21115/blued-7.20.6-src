package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/MsgBoxGuidePop.class */
public class MsgBoxGuidePop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    public TextView f18803c;

    public MsgBoxGuidePop(Context context) {
        super(context);
    }

    public void b() {
        super.b();
        this.f18803c = (TextView) findViewById(R.id.tv_go);
        findViewById(2131371051).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.MsgBoxGuidePop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MsgBoxGuidePop.this.p();
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.dialog_msg_box_guide;
    }
}
