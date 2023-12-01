package com.soft.blued.ui.find.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/NearbyChatRoomView.class */
public class NearbyChatRoomView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30708a;
    public ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f30709c;
    public LinearLayout d;
    public View e;
    public Context f;

    public NearbyChatRoomView(Context context) {
        this(context, null);
    }

    public NearbyChatRoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyChatRoomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = context;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.width = intValue;
        this.e.setLayoutParams(layoutParams);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.nearby_chat_room_view, this);
        this.e = inflate;
        this.f30708a = (TextView) inflate.findViewById(R.id.nearby_chat_room_num);
        this.b = (ImageView) this.e.findViewById(R.id.iv_notice);
        this.f30709c = (LinearLayout) this.e.findViewById(R.id.nearby_chat_room_long_layout);
        this.d = (LinearLayout) this.e.findViewById(R.id.nearby_chat_room_short_layout);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.NearbyChatRoomView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYChatRoomsListFragment.f17120a.a(NearbyChatRoomView.this.getContext(), "home_chat_room");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.width = intValue;
        this.e.setLayoutParams(layoutParams);
    }

    public void a() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.width = DensityUtils.a(this.f, 164.0f);
        this.e.setLayoutParams(layoutParams);
        this.f30709c.setVisibility(0);
        this.d.setVisibility(8);
        Log.v("drb", " -- showLongChatRoom GONE");
    }

    public void b() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.width = DensityUtils.a(this.f, 47.0f);
        this.e.setLayoutParams(layoutParams);
        this.f30709c.setVisibility(8);
        this.d.setVisibility(0);
        Log.v("drb", " -- showShortChatRoom VISIBLE");
    }

    public void c() {
        this.f30709c.setVisibility(0);
        this.d.setVisibility(8);
        Log.v("drb", " -- openChatRoom GONE");
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f, 47.0f), DensityUtils.a(this.f, 164.0f));
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new CubicInterpolator(0.36f, 0.79f, 0.33f, 0.99f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$NearbyChatRoomView$xoe7K6T2uhhKFOQAOj81XH-R_Uo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NearbyChatRoomView.this.b(valueAnimator);
            }
        });
        ofInt.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        this.d.startAnimation(alphaAnimation);
    }

    public void d() {
        this.f30709c.setVisibility(8);
        this.d.setVisibility(0);
        Log.v("drb", " -- retractChatRoom VISIBLE");
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f, 164.0f), DensityUtils.a(this.f, 47.0f));
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new CubicInterpolator(0.36f, 0.79f, 0.33f, 0.99f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$NearbyChatRoomView$0AyEweOyoDKj1T0djvpA4CHy4n0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NearbyChatRoomView.this.a(valueAnimator);
            }
        });
        ofInt.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100L);
        this.d.startAnimation(alphaAnimation);
    }

    public void setText(String str) {
        this.f30708a.setText(str);
        this.f30708a.setSelected(true);
    }

    public void setTextNotice(String str) {
        this.b.setVisibility(0);
        ImageLoader.a((IRequestHost) null, str).a(this.b);
    }
}
