package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveDesireResetPop.class */
public class LiveDesireResetPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    public Context f13974c;
    public final String d;
    private ImageView e;
    private TextView f;
    private IRequestHost g;

    public LiveDesireResetPop(Context context, IRequestHost iRequestHost) {
        super(context);
        this.d = "LiveDesireResetPop";
        this.f13974c = context;
        this.g = iRequestHost;
    }

    public static void a(Context context, IRequestHost iRequestHost) {
        new XPopup.Builder(context).a(new XPopupCallback() { // from class: com.blued.android.module.live_china.pop.LiveDesireResetPop.1
            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView, int i) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView, int i, float f, boolean z) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void b(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void c(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void d(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void e(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public boolean f(BasePopupView basePopupView) {
                return false;
            }
        }).a((BasePopupView) new LiveDesireResetPop(context, iRequestHost)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        c();
    }

    private void d() {
        this.e = (ImageView) findViewById(R.id.iv_close);
        TextView textView = (TextView) findViewById(R.id.tv_confirm);
        this.f = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveDesireResetPop$omBA5aqhBjgZlFwLkdDgSbScSBc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireResetPop.this.c(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveDesireResetPop$jjca9lP2svU_S1dz9cCr220s8lQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireResetPop.this.b(view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        d();
    }

    public void c() {
        p();
        LiveEventBus.get("desire_reset").post(true);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.live_pop_desire_reset;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return XPopupUtils.a(getContext());
    }
}
