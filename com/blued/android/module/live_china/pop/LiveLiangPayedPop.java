package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveLiangPayedPop.class */
public class LiveLiangPayedPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    public Context f13980c;
    public final String d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private String j;
    private long k;
    private int t;

    public LiveLiangPayedPop(Context context) {
        super(context);
        this.d = "LiveLiangPayedPop";
        this.k = 0L;
        this.f13980c = context;
    }

    public static void a(final BaseFragment baseFragment, String str, long j, int i) {
        LiveLiangPayedPop liveLiangPayedPop = new LiveLiangPayedPop(baseFragment.getContext());
        liveLiangPayedPop.j = str;
        liveLiangPayedPop.k = j;
        liveLiangPayedPop.t = i;
        new XPopup.Builder(baseFragment.getContext()).a(new XPopupCallback() { // from class: com.blued.android.module.live_china.pop.LiveLiangPayedPop.1
            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView, int i2) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void a(BasePopupView basePopupView, int i2, float f, boolean z) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void b(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void c(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void d(BasePopupView basePopupView) {
                LiveEventBus.get("LIVE_WEB_PAGE_REFRESH").post("");
                BaseFragment baseFragment2 = BaseFragment.this;
                if (baseFragment2 == null || baseFragment2.getActivity() == null) {
                    return;
                }
                BaseFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void e(BasePopupView basePopupView) {
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public boolean f(BasePopupView basePopupView) {
                return false;
            }
        }).a((BasePopupView) liveLiangPayedPop).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        p();
    }

    private void c() {
        Resources resources;
        int i;
        this.e = (ImageView) findViewById(R.id.iv_close);
        this.i = (TextView) findViewById(R.id.tv_tip);
        this.f = (TextView) findViewById(R.id.tv_id);
        this.g = (TextView) findViewById(R.id.tv_date);
        TextView textView = (TextView) findViewById(R.id.tv_ok);
        this.h = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveLiangPayedPop$2pY9n2VUqKxdb4pQLykkopo5nzY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLiangPayedPop.this.c(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveLiangPayedPop$Ui4bkLowbsW_eGrph503V4ENpzo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveLiangPayedPop.this.b(view);
            }
        });
        TextView textView2 = this.i;
        if (this.t == 0) {
            resources = getResources();
            i = R.string.live_id_liang_receive;
        } else {
            resources = getResources();
            i = R.string.live_id_re_new;
        }
        textView2.setText(resources.getString(i));
        this.f.setText(this.j);
        long j = this.k;
        int i2 = (int) (j / 86400);
        int i3 = (int) ((j % 86400) / b.P);
        int i4 = (int) ((j % b.P) / 60);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13980c.getString(R.string.live_id_valid_period));
        if (i2 >= 1) {
            sb.append(String.format(this.f13980c.getString(R.string.live_id_valid_period_day), Integer.valueOf(i2)));
        }
        if (i3 >= 1) {
            sb.append(String.format(this.f13980c.getString(R.string.live_id_valid_period_hour), Integer.valueOf(i3)));
        }
        if (i4 >= 1) {
            sb.append(String.format(this.f13980c.getString(R.string.live_id_valid_period_minute), Integer.valueOf(i4)));
        }
        this.g.setText(sb.toString());
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
        return R.layout.live_pop_receive_liang_id;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return XPopupUtils.a(getContext());
    }
}
