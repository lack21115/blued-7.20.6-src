package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackMessage;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RiskyMsgDeletedHint.class */
public class RiskyMsgDeletedHint extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14810a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14811c;
    private ValueAnimator d;
    private RelativeLayout.LayoutParams e;
    private TextView f;
    private RelativeLayout g;
    private int h;
    private boolean i;
    private ImageView j;
    private Theme k;
    private View.OnClickListener l;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/RiskyMsgDeletedHint$Theme.class */
    public enum Theme {
        RED,
        BLUED
    }

    public RiskyMsgDeletedHint(Context context) {
        super(context);
        this.h = 0;
        this.i = true;
        this.k = Theme.BLUED;
        a(context);
    }

    public RiskyMsgDeletedHint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0;
        this.i = true;
        this.k = Theme.BLUED;
        a(context);
    }

    public RiskyMsgDeletedHint(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = true;
        this.k = Theme.BLUED;
        a(context);
    }

    private void a(Context context) {
        this.f14810a = context;
        this.b = LayoutInflater.from(context).inflate(R.layout.layout_msg_deleted_hint, this);
        this.g = (RelativeLayout) findViewById(2131369389);
        this.f = (TextView) this.b.findViewById(2131371675);
        setVisibility(8);
        this.e = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        ImageView imageView = (ImageView) this.b.findViewById(2131365207);
        this.j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.RiskyMsgDeletedHint.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                RiskyMsgDeletedHint.this.d();
                if (RiskyMsgDeletedHint.this.l != null) {
                    RiskyMsgDeletedHint.this.l.onClick(view);
                }
            }
        });
    }

    public boolean a() {
        return this.f14811c;
    }

    public void b() {
        this.j.setVisibility(0);
    }

    public void c() {
        if (isEnabled() && !this.f14811c) {
            this.f14811c = true;
            EventTrackMessage.a(MessageProtos.Event.MSG_DELETE_POINT_SHOW);
            setVisibility(0);
            if (this.i) {
                postDelayed(new Runnable() { // from class: com.soft.blued.customview.RiskyMsgDeletedHint.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RiskyMsgDeletedHint.this.d();
                    }
                }, 5000L);
            }
        }
    }

    public void d() {
        if (this.f14811c) {
            this.f14811c = false;
            animate().translationY(-getHeight()).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.customview.RiskyMsgDeletedHint.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    RiskyMsgDeletedHint.this.setVisibility(8);
                }
            }).start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setAutoDismiss(boolean z) {
        this.i = z;
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setHint(String str) {
        this.f.setText(str);
    }

    public void setHintTipsHeight(int i) {
        if (this.f == null) {
            return;
        }
        if (this.e == null) {
            this.e = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        }
        this.e.height = DensityUtils.a(this.f14810a, i);
        if (this.d == null) {
            new ValueAnimator();
            this.d = ValueAnimator.ofInt(-DensityUtils.a(this.f14810a, i + 1), 0);
        }
        this.d.setIntValues(-DensityUtils.a(this.f14810a, i + 1), 0);
    }

    public void setTheme(Theme theme) {
        this.k = theme;
        if (theme == Theme.RED) {
            this.g.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101121));
            this.f.setTextColor(BluedSkinUtils.a(getContext(), 2131101122));
            this.j.setImageResource(R.drawable.icon_msg_close_red);
            return;
        }
        this.g.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101119));
        this.f.setTextColor(BluedSkinUtils.a(getContext(), 2131101120));
        this.j.setImageResource(R.drawable.icon_msg_close_red);
    }
}
