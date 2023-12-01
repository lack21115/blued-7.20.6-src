package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveDesireDeletePop.class */
public class LiveDesireDeletePop extends CenterPopupView {
    public Context c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private String g;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        p();
    }

    private void d() {
        this.d = (ImageView) findViewById(R.id.iv_close);
        TextView textView = (TextView) findViewById(R.id.tv_id);
        this.e = textView;
        textView.setText(this.g);
        this.f = (TextView) findViewById(R.id.tv_ok);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveDesireDeletePop$B1g4SFqAntLZICzkT0-oAmMF3qQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireDeletePop.this.c(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveDesireDeletePop$4S5tN90xHdmBY582PoTaAbuD8Fc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireDeletePop.this.b(view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        d();
    }

    public void c() {
        LiveRoomInfo.a().a(this.c, LiveRoomInfo.a().E());
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.live_pop_expire_liang_id;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return XPopupUtils.a(getContext());
    }
}
