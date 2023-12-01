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
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveLiangExpirePop.class */
public class LiveLiangExpirePop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    public Context f13975c;
    public final String d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private String h;

    public LiveLiangExpirePop(Context context) {
        super(context);
        this.d = "LiveLiangExpirePop";
        this.f13975c = context;
    }

    public static LiveLiangExpirePop a(Context context, String str) {
        LiveLiangExpirePop liveLiangExpirePop = new LiveLiangExpirePop(context);
        liveLiangExpirePop.h = str;
        new XPopup.Builder(context).a((BasePopupView) liveLiangExpirePop).h();
        return liveLiangExpirePop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        p();
    }

    private void d() {
        this.e = (ImageView) findViewById(R.id.iv_close);
        TextView textView = (TextView) findViewById(R.id.tv_id);
        this.f = textView;
        textView.setText(this.h);
        this.g = (TextView) findViewById(R.id.tv_ok);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveLiangExpirePop$xHAeer-0OmXYsocmxD6o4ryi460
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLiangExpirePop.this.c(view);
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveLiangExpirePop$0N1thHsjvTOcc818Sxh6NCCRnuU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLiangExpirePop.this.b(view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        d();
    }

    public void c() {
        LiveRoomInfo.a().a(this.f13975c, LiveRoomInfo.a().E());
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
