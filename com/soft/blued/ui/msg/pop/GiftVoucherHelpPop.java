package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GiftVoucherHelpPop.class */
public class GiftVoucherHelpPop extends BottomPopupView {
    public static GiftVoucherHelpPop b;

    /* renamed from: c  reason: collision with root package name */
    private CommonTopTitleNoTrans f18791c;

    public GiftVoucherHelpPop(Context context) {
        super(context);
    }

    public void b() {
        super.b();
        CommonTopTitleNoTrans findViewById = findViewById(R.id.top_title);
        this.f18791c = findViewById;
        findViewById.setLeftImg(2131233183);
        this.f18791c.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftVoucherHelpPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GiftVoucherHelpPop.this.p();
            }
        });
        this.f18791c.setCenterText(getContext().getString(R.string.voucher_description));
    }

    public int getImplLayoutId() {
        return R.layout.pop_gift_voucher_help;
    }

    public void u() {
        super.u();
        b = null;
    }

    public void w() {
        super.w();
        b = this;
    }
}
