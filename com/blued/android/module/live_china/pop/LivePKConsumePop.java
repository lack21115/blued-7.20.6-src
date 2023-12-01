package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LivePKConsumePop.class */
public class LivePKConsumePop extends CenterPopupView {
    public Context c;
    public final String d;
    private String e;
    private String f;
    private CardView g;
    private View h;
    private View i;
    private TextView j;
    private TextView k;

    public LivePKConsumePop(Context context, String str, String str2) {
        super(context);
        this.d = "LivePKConsumePop";
        this.e = str;
        this.f = str2;
        this.c = context;
    }

    public static void a(BaseFragment baseFragment, String str, String str2) {
        new XPopup.Builder(baseFragment.getContext()).a(new XPopupCallback() { // from class: com.blued.android.module.live_china.pop.LivePKConsumePop.1
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
        }).a((BasePopupView) new LivePKConsumePop(baseFragment.getContext(), str, str2)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        p();
    }

    private void c() {
        View findViewById = findViewById(R.id.fl_root);
        TextView textView = (TextView) findViewById(R.id.tv_content);
        this.j = textView;
        textView.setText(this.e);
        TextView textView2 = (TextView) findViewById(R.id.tv_title);
        this.k = textView2;
        textView2.setText(this.f);
        this.h = findViewById(R.id.iv_close);
        this.i = findViewById(R.id.tv_ok);
        CardView findViewById2 = findViewById(R.id.card_view);
        this.g = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LivePKConsumePop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LivePKConsumePop.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LivePKConsumePop.this.p();
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePKConsumePop$Q58qg-IMH2VjvUIS73J-iUYAzJg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKConsumePop.this.c(view);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LivePKConsumePop$fH9coEDn4YC-NieWPpUBkm3-z3M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKConsumePop.this.b(view);
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
        return R.layout.live_pop_pk_consume;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return XPopupUtils.a(getContext());
    }
}
