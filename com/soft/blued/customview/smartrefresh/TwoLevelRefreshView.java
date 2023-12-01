package com.soft.blued.customview.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/smartrefresh/TwoLevelRefreshView.class */
public class TwoLevelRefreshView extends InternalAbstract implements RefreshHeader {

    /* renamed from: a  reason: collision with root package name */
    public View f14963a;
    public LottieAnimationView b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14964c;
    public boolean d;
    public boolean e;

    /* renamed from: com.soft.blued.customview.smartrefresh.TwoLevelRefreshView$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/smartrefresh/TwoLevelRefreshView$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14965a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f14965a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14965a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14965a[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14965a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public TwoLevelRefreshView(Context context) {
        this(context, null);
    }

    public TwoLevelRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoLevelRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_second_flow_refresh, this);
        this.f14963a = inflate.findViewById(2131363911);
        this.b = inflate.findViewById(2131366703);
        this.f14964c = (TextView) inflate.findViewById(2131372398);
        this.b.setImageAssetsFolder("images/");
        this.b.setAnimation("wave_super_man.json");
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        LottieAnimationView lottieAnimationView = this.b;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
        }
        return super.a(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshLayout refreshLayout, int i, int i2) {
        LottieAnimationView lottieAnimationView = this.b;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.f14965a[refreshState2.ordinal()];
        if (i == 1) {
            LottieAnimationView lottieAnimationView = this.b;
            if (lottieAnimationView != null) {
                lottieAnimationView.setFrame(0);
                this.b.setProgress(0.0f);
            }
        } else if (i == 2) {
            if (this.e) {
                this.f14964c.setText(R.string.live_two_level_get);
            } else {
                this.f14964c.setText(2131891361);
            }
        } else if (i == 3) {
            if (this.e) {
                this.f14964c.setText(R.string.live_two_level_get);
            } else {
                this.f14964c.setText(2131891364);
            }
        } else if (i != 4) {
        } else {
            if (this.e) {
                this.f14964c.setText(R.string.live_two_level_get);
            } else {
                this.f14964c.setText(2131891363);
            }
        }
    }

    public void a(boolean z, boolean z2) {
        this.d = z2;
        this.e = z;
        if (z2) {
            this.f14964c.setTextSize(12.0f);
            this.f14964c.setTextColor(getResources().getColor(2131101780));
            LottieAnimationView lottieAnimationView = this.b;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(4);
                return;
            }
            return;
        }
        this.f14964c.setTextSize(10.0f);
        this.f14964c.setTextColor(getResources().getColor(2131100624));
        LottieAnimationView lottieAnimationView2 = this.b;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
    }
}
