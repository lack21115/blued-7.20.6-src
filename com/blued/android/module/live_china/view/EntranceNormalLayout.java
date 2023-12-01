package com.blued.android.module.live_china.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveChattingModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/EntranceNormalLayout.class */
public class EntranceNormalLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f14270a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f14271c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private int h;
    private int i;
    private List<LiveChattingModel> j;
    private int k;
    private int l;
    private int m;

    public EntranceNormalLayout(Context context) {
        super(context);
        this.h = 300;
        this.i = 300;
        this.k = 1500;
        this.l = 500;
        this.m = 100;
        this.b = context;
        b();
    }

    public EntranceNormalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 300;
        this.i = 300;
        this.k = 1500;
        this.l = 500;
        this.m = 100;
        this.b = context;
        b();
    }

    public EntranceNormalLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 300;
        this.i = 300;
        this.k = 1500;
        this.l = 500;
        this.m = 100;
        this.b = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveChattingModel liveChattingModel) {
        if (liveChattingModel != null) {
            if (TextUtils.equals(LiveRoomInfo.a().f(), String.valueOf(liveChattingModel.fromId))) {
                liveChattingModel.fromRichLevel = LiveRoomInfo.a().r();
            }
            if (TextUtils.isEmpty(liveChattingModel.msgContent)) {
                liveChattingModel.msgContent = this.b.getResources().getString(R.string.live_coming);
            }
            this.g.setText(liveChattingModel.msgContent);
            this.f.setText(liveChattingModel.fromNickName);
            if (liveChattingModel.fromLiveManager == 1) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            BitmapUtils.a(this.b, this.d, liveChattingModel.fromRichLevel);
            this.f14271c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            View view = this.f14271c;
            view.layout(0, 0, view.getMeasuredWidth(), this.f14271c.getMeasuredHeight());
            a(this.f14271c.getMeasuredWidth(), liveChattingModel).start();
        }
    }

    private void b() {
        a();
        View findViewById = this.f14270a.findViewById(R.id.fl_main);
        this.f14271c = findViewById;
        findViewById.setVisibility(4);
        this.f = (TextView) this.f14271c.findViewById(R.id.tv_name);
        this.g = (TextView) this.f14271c.findViewById(R.id.tv_content);
        this.d = (ImageView) this.f14271c.findViewById(R.id.img_rich_rank);
        this.e = (ImageView) this.f14271c.findViewById(R.id.img_manager_icon);
        this.j = new ArrayList();
    }

    public AnimatorSet a(float f, final LiveChattingModel liveChattingModel) {
        ValueAnimator ofFloat;
        this.f14271c.setVisibility(0);
        new ObjectAnimator();
        float f2 = -f;
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(f2, 0.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceNormalLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) EntranceNormalLayout.this.f14271c.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                EntranceNormalLayout.this.f14271c.setAlpha(1.0f);
                EntranceNormalLayout.this.f14271c.setLayoutParams(layoutParams);
            }
        });
        ofFloat2.setDuration(this.h);
        new ObjectAnimator();
        ValueAnimator ofFloat3 = ObjectAnimator.ofFloat(0.0f, -0.1f);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceNormalLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) EntranceNormalLayout.this.f14271c.getLayoutParams();
                layoutParams.leftMargin = (int) floatValue;
                EntranceNormalLayout.this.f14271c.setAlpha(1.0f);
                EntranceNormalLayout.this.f14271c.setLayoutParams(layoutParams);
            }
        });
        List<LiveChattingModel> list = this.j;
        int i = (list == null || list.size() < 10) ? this.k : this.l;
        ofFloat3.setDuration(i);
        if (Build.VERSION.SDK_INT < 11) {
            new ObjectAnimator();
            ofFloat = ObjectAnimator.ofFloat(0.0f, f2);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceNormalLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) EntranceNormalLayout.this.f14271c.getLayoutParams();
                    layoutParams.leftMargin = (int) floatValue;
                    EntranceNormalLayout.this.f14271c.setLayoutParams(layoutParams);
                }
            });
        } else {
            new ObjectAnimator();
            ofFloat = ObjectAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.EntranceNormalLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EntranceNormalLayout.this.f14271c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        ofFloat.setDuration(this.i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        this.f14271c.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.EntranceNormalLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (EntranceNormalLayout.this.j.size() > 0) {
                    EntranceNormalLayout.this.j.remove(liveChattingModel);
                }
                if (EntranceNormalLayout.this.j.size() > 0) {
                    EntranceNormalLayout entranceNormalLayout = EntranceNormalLayout.this;
                    entranceNormalLayout.a((LiveChattingModel) entranceNormalLayout.j.get(0));
                }
            }
        }, this.h + i + this.i);
        return animatorSet;
    }

    public void a() {
        this.f14270a = LayoutInflater.from(this.b).inflate(R.layout.item_entrance_normal, this);
    }
}
