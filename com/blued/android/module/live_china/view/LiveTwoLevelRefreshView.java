package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveTwoLevelRefreshView.class */
public class LiveTwoLevelRefreshView extends InternalAbstract implements RefreshHeader {
    public View a;
    public LottieAnimationView b;
    public TextView c;
    public boolean d;
    public boolean e;

    /* renamed from: com.blued.android.module.live_china.view.LiveTwoLevelRefreshView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveTwoLevelRefreshView$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.a.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[RefreshState.b.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[RefreshState.f.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[RefreshState.l.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public LiveTwoLevelRefreshView(Context context) {
        this(context, null);
    }

    public LiveTwoLevelRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveTwoLevelRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.live_second_flow_refresh, (ViewGroup) this);
        this.a = inflate.findViewById(R.id.fl_root_view);
        this.b = (LottieAnimationView) inflate.findViewById(R.id.lav_loading);
        this.c = (TextView) inflate.findViewById(R.id.tv_refresh);
        this.b.setImageAssetsFolder("images/");
        this.b.setAnimation("wave_super_man.json");
    }

    public int a(RefreshLayout refreshLayout, boolean z) {
        LottieAnimationView lottieAnimationView = this.b;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
        }
        return super.a(refreshLayout, z);
    }

    public void a(RefreshLayout refreshLayout, int i, int i2) {
        LottieAnimationView lottieAnimationView = this.b;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
        }
    }

    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.a[refreshState2.ordinal()];
        if (i == 1) {
            LottieAnimationView lottieAnimationView = this.b;
            if (lottieAnimationView != null) {
                lottieAnimationView.setFrame(0);
                this.b.setProgress(0.0f);
            }
        } else if (i == 2) {
            if (this.e) {
                this.c.setText(R.string.live_two_level_get);
            } else {
                this.c.setText(R.string.pull_to_refresh_pull_label);
            }
        } else if (i == 3) {
            if (this.e) {
                this.c.setText(R.string.live_two_level_get);
            } else {
                this.c.setText(R.string.pull_to_refresh_release_label);
            }
        } else if (i != 4) {
        } else {
            if (this.e) {
                this.c.setText(R.string.live_two_level_get);
            } else {
                this.c.setText(R.string.pull_to_refresh_refreshing_label);
            }
        }
    }

    public void a(boolean z, boolean z2) {
        this.d = z2;
        this.e = z;
        if (z2) {
            this.c.setTextSize(12.0f);
            this.c.setTextColor(getResources().getColor(R.color.syc_b));
            LottieAnimationView lottieAnimationView = this.b;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(4);
                return;
            }
            return;
        }
        this.c.setTextSize(10.0f);
        this.c.setTextColor(getResources().getColor(R.color.light_gray));
        LottieAnimationView lottieAnimationView2 = this.b;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
    }
}
