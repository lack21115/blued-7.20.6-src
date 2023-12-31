package com.blued.android.module.common.widget.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/refresh/BluedRefreshView.class */
public class BluedRefreshView extends InternalAbstract implements RefreshHeader {
    private LottieAnimationView a;
    private View b;
    private TextView c;
    private boolean d;
    private String e;
    private Context f;

    /* renamed from: com.blued.android.module.common.widget.refresh.BluedRefreshView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/refresh/BluedRefreshView$1.class */
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

    public BluedRefreshView(Context context) {
        this(context, null);
    }

    public BluedRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BluedRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.e = "wave_super_man.json";
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_refresh, (ViewGroup) this);
        this.a = (LottieAnimationView) inflate.findViewById(R.id.lav_loading);
        this.c = (TextView) inflate.findViewById(R.id.tv_refresh);
        this.a.setImageAssetsFolder("images/");
        this.a.setAnimation(this.e);
        this.b = inflate.findViewById(R.id.fl_root_view);
    }

    public int a(RefreshLayout refreshLayout, boolean z) {
        LottieAnimationView lottieAnimationView = this.a;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
        }
        return super.a(refreshLayout, z);
    }

    public void a(RefreshLayout refreshLayout, int i, int i2) {
        LottieAnimationView lottieAnimationView = this.a;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
        }
    }

    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.a[refreshState2.ordinal()];
        if (i == 1) {
            LottieAnimationView lottieAnimationView = this.a;
            if (lottieAnimationView != null) {
                lottieAnimationView.setFrame(0);
                this.a.setProgress(0.0f);
            }
            if (this.d) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        } else if (i == 2) {
            if (!this.d) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            this.c.setText(R.string.pull_to_refresh_pull_label);
        } else if (i == 3) {
            if (!this.d) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            this.c.setText(R.string.pull_to_refresh_release_label);
        } else if (i != 4) {
        } else {
            if (!this.d) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            this.c.setText(R.string.pull_to_refresh_refreshing_label);
        }
    }

    public String getAnimationJson() {
        return this.e;
    }

    public void setBackgroundColorRes(int i) {
        this.b.setBackgroundColor(BluedSkinUtils.a(this.f, i));
    }

    public void setShowText(boolean z) {
        this.d = z;
    }
}
