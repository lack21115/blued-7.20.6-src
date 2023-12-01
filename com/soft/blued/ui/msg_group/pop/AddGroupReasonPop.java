package com.soft.blued.ui.msg_group.pop;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.utils.ToastUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/AddGroupReasonPop.class */
public class AddGroupReasonPop extends BottomPopupView {
    private EditText b;

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        this.b = (EditText) findViewById(R.id.et_reason);
        findViewById(R.id.tv_apply).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.AddGroupReasonPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextUtils.isEmpty(AddGroupReasonPop.this.b.getText().toString())) {
                    ToastUtils.a(AddGroupReasonPop.this.getResources().getString(2131891609));
                    return;
                }
                LiveEventBus.get("add_group").post(AddGroupReasonPop.this.b.getText().toString());
                AddGroupReasonPop.this.p();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_add_group;
    }
}
