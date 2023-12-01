package com.blued.android.module.live_china.view.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/recommend/RecommendRefreshFooter.class */
public class RecommendRefreshFooter extends InternalClassics implements RefreshFooter {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f15430a;
    private TextView b;

    /* renamed from: com.blued.android.module.live_china.view.recommend.RecommendRefreshFooter$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/recommend/RecommendRefreshFooter$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15431a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f15431a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15431a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15431a[RefreshState.ReleaseToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15431a[RefreshState.Loading.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public RecommendRefreshFooter(Context context) {
        this(context, null);
        a(context);
    }

    public RecommendRefreshFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context);
    }

    public RecommendRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15430a = false;
        a(context);
    }

    private void a(Context context) {
        this.b = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_refresh_footer_recommend, this).findViewById(R.id.tv_refresh);
        this.K = 0;
        this.L = 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        if (this.f15430a) {
            return 0;
        }
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        return super.a(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        if (this.f15430a) {
            return;
        }
        int i = AnonymousClass1.f15431a[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.b.setText(R.string.live_recommend_load_more);
        } else if (i == 3) {
            this.b.setText(R.string.live_recommend_more_loading);
        } else if (i != 4) {
        } else {
            this.b.setText(R.string.live_recommend_loading);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean a(boolean z) {
        if (this.f15430a != z) {
            this.f15430a = z;
            this.b.setText(R.string.live_recommend_more_no);
            return true;
        }
        return true;
    }
}
