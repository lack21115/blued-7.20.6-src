package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveOfficalRecommendPop.class */
public class LiveOfficalRecommendPop extends CenterPopupView {
    public Context c;
    public final String d;
    public int e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private TextView i;

    public LiveOfficalRecommendPop(Context context) {
        super(context);
        this.d = "LiveRecommendPop";
        this.c = context;
    }

    public static LiveOfficalRecommendPop a(Context context, int i) {
        LiveOfficalRecommendPop liveOfficalRecommendPop = new LiveOfficalRecommendPop(context);
        liveOfficalRecommendPop.e = i;
        new XPopup.Builder(context).a((BasePopupView) liveOfficalRecommendPop).h();
        return liveOfficalRecommendPop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        p();
    }

    private void c() {
        this.f = (ImageView) findViewById(R.id.iv_close);
        this.g = (ImageView) findViewById(R.id.iv_recommend_bg);
        this.h = (TextView) findViewById(R.id.tv_recommed_tip);
        this.i = (TextView) findViewById(R.id.tv_confirm);
        this.g.setImageResource(this.e == 0 ? R.drawable.live_recommend_offical : R.drawable.live_recommend_time_tip);
        this.h.setText(this.e == 0 ? R.string.live_recommend_receive : R.string.live_recommend_time_tip);
        TextView textView = (TextView) findViewById(R.id.tv_confirm);
        this.i = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveOfficalRecommendPop$MMysCrOfqm_Yp85hWZAG0x2qbl4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOfficalRecommendPop.this.c(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveOfficalRecommendPop$AFzjBzC9ukp_HsrA--n1M0PT0Ds
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOfficalRecommendPop.this.b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        c();
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.live_pop_recommend;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return XPopupUtils.a(getContext());
    }
}
