package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.impl.FullScreenPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayGuidePop.class */
public final class DateTodayGuidePop extends FullScreenPopupView {
    private final int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTodayGuidePop(Context context, int i) {
        super(context);
        Intrinsics.e(context, "context");
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayGuidePop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    @Override // com.blued.android.framework.ui.xpop.impl.FullScreenPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_top);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = this.g;
        frameLayout.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.tv_dating_today_guide_ok)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayGuidePop$FXbdpQp-3DmjYw6oIBbtn71DRBk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTodayGuidePop.a(DateTodayGuidePop.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_date_today_guide;
    }
}
