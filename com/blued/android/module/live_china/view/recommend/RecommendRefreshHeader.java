package com.blued.android.module.live_china.view.recommend;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/recommend/RecommendRefreshHeader.class */
public class RecommendRefreshHeader extends InternalAbstract implements RefreshHeader {

    /* renamed from: a  reason: collision with root package name */
    public View f15432a;
    public RefreshHeaderSlopeProgress b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15433c;
    private AnimatorSet d;
    private float e;

    /* renamed from: com.blued.android.module.live_china.view.recommend.RecommendRefreshHeader$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/recommend/RecommendRefreshHeader$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15434a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f15434a = iArr;
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15434a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15434a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public RecommendRefreshHeader(Context context) {
        this(context, null);
    }

    public RecommendRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecommendRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_refresh_header_recommend, this);
        this.f15432a = inflate.findViewById(R.id.rl_root);
        this.b = (RefreshHeaderSlopeProgress) inflate.findViewById(R.id.sp_view);
        this.f15433c = (TextView) inflate.findViewById(R.id.tv_refresh);
        this.b.setRingColor(BluedSkinUtils.a(context, R.color.white));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.d = null;
            this.b.setAlpha(1.0f);
            this.b.setScaleX(1.0f);
            this.b.setScaleY(1.0f);
            this.b.setProgress(0);
            this.b.setRotation(0.0f);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        this.b.animate().alpha(0.0f).scaleX(0.4f).scaleY(0.4f).setDuration(300L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.recommend.-$$Lambda$RecommendRefreshHeader$SGTl_y9Zem8oQrMNfjaFhhTtFQk
            @Override // java.lang.Runnable
            public final void run() {
                RecommendRefreshHeader.this.a();
            }
        }).start();
        return super.a(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshLayout refreshLayout, int i, int i2) {
        if (this.d == null) {
            this.d = new AnimatorSet();
        }
        if (this.d.isRunning()) {
            return;
        }
        RefreshHeaderSlopeProgress refreshHeaderSlopeProgress = this.b;
        float f = this.e;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(refreshHeaderSlopeProgress, "rotation", f, f + 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration(780L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.b, "progress", 90, 1);
        ofInt.setRepeatCount(-1);
        ofInt.setRepeatMode(2);
        ofInt.setDuration(920L);
        this.d.playTogether(ofFloat, ofInt);
        this.d.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.f15434a[refreshState2.ordinal()];
        if (i == 1) {
            this.f15433c.setText(R.string.live_recommend_pull_label);
        } else if (i == 2) {
            this.f15433c.setText(R.string.live_recommend_release_label);
        } else if (i != 3) {
        } else {
            this.f15433c.setText(R.string.live_recommend_loading);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(boolean z, float f, int i, int i2, int i3) {
        super.a(z, f, i, i2, i3);
        AnimatorSet animatorSet = this.d;
        if (animatorSet == null || !animatorSet.isRunning()) {
            int i4 = (int) (f * 90.0f);
            int i5 = i4;
            if (i4 > 90) {
                i5 = 90;
            }
            this.b.setProgress(i5);
            if (f < 1.0f) {
                this.e = (f * 450.0f) + 90.0f;
            } else {
                this.e = ((f - 1.0f) * 180.0f) + 540.0f;
            }
            this.b.setRotation(this.e);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void b(RefreshLayout refreshLayout, int i, int i2) {
        super.b(refreshLayout, i, i2);
        a(refreshLayout, i, i2);
    }
}
