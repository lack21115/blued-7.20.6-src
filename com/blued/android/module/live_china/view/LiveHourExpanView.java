package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RankingHourExtra;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveHourExpanView.class */
public class LiveHourExpanView extends LinearLayout {
    boolean a;
    private Context b;
    private LayoutInflater c;
    private ShapeLinearLayout d;
    private TextView e;
    private TextView f;
    private int g;

    public LiveHourExpanView(Context context) {
        this(context, null);
    }

    public LiveHourExpanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.a = false;
        this.b = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        from.inflate(R.layout.pop_live_hour, (ViewGroup) this, true);
        this.d = (ShapeLinearLayout) findViewById(R.id.rl_root);
        this.e = (TextView) findViewById(R.id.tv_top);
        this.f = (TextView) findViewById(R.id.tv_down);
        this.g = ContextCompat.getColor(this.b, R.color.syc_dark_afb218ff);
    }

    private void a(ShapeFrameLayout shapeFrameLayout, final boolean z) {
        if (shapeFrameLayout.getVisibility() == 8) {
            setVisibility(8);
            return;
        }
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.k = this.g;
        if (z) {
            shapeModel.I = DensityUtils.a(this.b, 10.0f);
            shapeModel.J = DensityUtils.a(this.b, 10.0f);
        } else {
            shapeModel.H = DensityUtils.a(this.b, 10.0f);
        }
        shapeFrameLayout.setShapeModel(shapeModel);
        View findViewById = shapeFrameLayout.findViewById(R.id.iv_hour_down);
        RotateAnimation rotateAnimation = new RotateAnimation(z ? 0.0f : 180.0f, z ? 180.0f : 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        findViewById.clearAnimation();
        findViewById.startAnimation(rotateAnimation);
        setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, z ? -1.0f : 0.0f, 1, z ? 0.0f : -1.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        clearAnimation();
        setAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveHourExpanView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveHourExpanView.this.clearAnimation();
                LiveHourExpanView.this.a = false;
                if (z) {
                    return;
                }
                LiveHourExpanView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        translateAnimation.start();
    }

    public void a(ShapeFrameLayout shapeFrameLayout, boolean z, boolean z2) {
        if (shapeFrameLayout == null || this.a) {
            return;
        }
        this.a = true;
        a(shapeFrameLayout, z);
    }

    public void a(RankingHourExtra rankingHourExtra) {
        if (rankingHourExtra != null) {
            if (rankingHourExtra.rank >= 50) {
                this.e.setText(AppInfo.d().getString(R.string.live_hour_count_no_rank));
                this.f.setText(String.format(AppInfo.d().getString(R.string.live_hour_count_shanyao), String.valueOf(rankingHourExtra.score)));
            } else {
                this.e.setText(String.format(AppInfo.d().getString(R.string.live_hour_count_rank), String.valueOf(rankingHourExtra.rank)));
                if (rankingHourExtra.rank == 1) {
                    this.f.setText(String.format(AppInfo.d().getString(R.string.live_hour_count_second_tip), String.valueOf(rankingHourExtra.need_score)));
                } else {
                    this.f.setText(String.format(AppInfo.d().getString(R.string.live_hour_count_tip), String.valueOf(rankingHourExtra.need_score)));
                }
            }
            this.g = ContextCompat.getColor(this.b, rankingHourExtra.rank_type == 1 ? R.color.syc_dark_afb218ff : R.color.syc_dark_B39F77FF);
            ShapeModel shapeModel = this.d.getShapeModel();
            shapeModel.k = this.g;
            this.d.setShapeModel(shapeModel);
        }
    }
}
