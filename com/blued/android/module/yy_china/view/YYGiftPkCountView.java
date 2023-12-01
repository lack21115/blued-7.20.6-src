package com.blued.android.module.yy_china.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftPkCountView.class */
public class YYGiftPkCountView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ShapeFrameLayout f18188a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f18189c;
    private TextView d;
    private TextView e;
    private ValueAnimator f;
    private int g;
    private int h;
    private String i;
    private SendGiftClickListener j;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftPkCountView$SendGiftClickListener.class */
    public interface SendGiftClickListener {
        void a(String str);
    }

    public YYGiftPkCountView(Context context) {
        super(context);
        a();
    }

    public YYGiftPkCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYGiftPkCountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_gift_pk_count, (ViewGroup) this, true);
        this.f18188a = (ShapeFrameLayout) findViewById(R.id.fl_reward_chart);
        this.b = (TextView) findViewById(R.id.tv_reward_name);
        this.f18189c = (ImageView) findViewById(R.id.iv_reward_gift);
        this.d = (TextView) findViewById(R.id.tv_pk_gift_count);
        this.e = (TextView) findViewById(R.id.tv_give);
        this.g = DensityUtils.a(getContext(), 24.0f);
        this.h = DensityUtils.a(getContext(), 100.0f);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYGiftPkCountView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Logger.e("YYGiftPkCountView", "点击投票 ... ");
                if (YYGiftPkCountView.this.j != null) {
                    YYGiftPkCountView.this.j.a(YYGiftPkCountView.this.i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f = null;
        }
    }

    public void setChartColor(int i) {
        ShapeHelper.b(this.f18188a, i);
    }

    public void setChartRange(float f) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(0, (int) (f * this.h));
        this.f = ofInt;
        ofInt.setDuration(500L);
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f18189c.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f18188a.getLayoutParams();
        this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.yy_china.view.YYGiftPkCountView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                layoutParams2.height = intValue;
                layoutParams.bottomMargin = Math.max(0, intValue - YYGiftPkCountView.this.g);
                YYGiftPkCountView.this.f18188a.requestLayout();
                YYGiftPkCountView.this.f18189c.requestLayout();
            }
        });
        this.f.start();
    }

    public void setGiftId(String str) {
        this.i = str;
    }

    public void setPkGiftImage(String str) {
        ImageLoader.a((IRequestHost) null, str).b(R.drawable.gift_default_icon).a(this.f18189c);
    }

    public void setReceivedGiftCount(String str) {
        this.d.setText(str);
    }

    public void setRewardName(String str) {
        this.b.setText(str);
    }

    public void setSendGiftClickListener(SendGiftClickListener sendGiftClickListener) {
        this.j = sendGiftClickListener;
    }
}
