package com.blued.android.module.shortvideo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ITrimBottomCallback;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.TrimViewUtils;
import com.blued.android.module.shortvideo.view.RangeSeekBar;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/TrimNewBottomView.class */
public class TrimNewBottomView extends RelativeLayout implements View.OnClickListener {
    private static final String b = TrimNewBottomView.class.getSimpleName() + " ";

    /* renamed from: a  reason: collision with root package name */
    SeekBar.OnSeekBarChangeListener f15920a;

    /* renamed from: c  reason: collision with root package name */
    private TrimSeekBar f15921c;
    private TextView d;
    private TextView e;
    private LinearLayout f;
    private RangeSeekBar g;
    private VideoFrameView h;
    private ValueAnimator i;
    private TrimDataModel j;
    private ITrimBottomCallback k;

    public TrimNewBottomView(Context context) {
        this(context, null);
    }

    public TrimNewBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrimNewBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15920a = new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.shortvideo.view.TrimNewBottomView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    int rightProgress = (int) (((int) ((((float) (TrimNewBottomView.this.j.getRightProgress() - TrimNewBottomView.this.j.getLeftProgress())) * i2) / 1000.0f)) + TrimNewBottomView.this.j.getLeftProgress());
                    double d = rightProgress;
                    if (d < TrimNewBottomView.this.j.getLeftProgress()) {
                        TrimNewBottomView.this.k.b((int) TrimNewBottomView.this.j.getLeftProgress());
                    } else if (d > TrimNewBottomView.this.j.getRightProgress()) {
                        TrimNewBottomView.this.k.b((int) TrimNewBottomView.this.j.getRightProgress());
                    } else {
                        TrimNewBottomView.this.k.b(rightProgress);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
                int rightProgress = (int) (((int) ((((float) (TrimNewBottomView.this.j.getRightProgress() - TrimNewBottomView.this.j.getLeftProgress())) * seekBar.getProgress()) / 1000.0f)) + TrimNewBottomView.this.j.getLeftProgress());
                int i2 = rightProgress;
                if (rightProgress > TrimNewBottomView.this.j.getRightProgress()) {
                    i2 = (int) TrimNewBottomView.this.j.getLeftProgress();
                }
                TrimNewBottomView.this.k.i_(i2);
            }
        };
        f();
    }

    private void b(int i) {
        this.f15921c.clearAnimation();
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.i.cancel();
        }
        if (this.f15921c.getVisibility() == 8) {
            this.f15921c.setVisibility(0);
        }
        final int leftProgress = (int) this.j.getLeftProgress();
        final int rightProgress = (int) this.j.getRightProgress();
        int i2 = i;
        if (i == 0) {
            i2 = leftProgress;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15921c.getLayoutParams();
        layoutParams.leftMargin = TrimViewUtils.a(this.j);
        layoutParams.width = TrimViewUtils.b(this.j);
        this.f15921c.setLayoutParams(layoutParams);
        if (leftProgress != rightProgress) {
            StvLogUtils.a(b + "IconStart:" + leftProgress + " | IconEnd:" + rightProgress, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append("PlayDuration:");
            sb.append(TrimViewUtils.c(this.j));
            StvLogUtils.a(sb.toString(), new Object[0]);
            ValueAnimator duration = ValueAnimator.ofFloat((float) (i2 - leftProgress), (float) (rightProgress - leftProgress)).setDuration((long) (rightProgress - i2));
            this.i = duration;
            duration.setInterpolator(new LinearInterpolator());
            this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.shortvideo.view.TrimNewBottomView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TrimNewBottomView.this.f15921c.setProgress((int) ((floatValue / (rightProgress - leftProgress)) * 1000.0f));
                    if (floatValue >= rightProgress - leftProgress) {
                        TrimNewBottomView.this.k.i_((int) TrimNewBottomView.this.j.getLeftProgress());
                    }
                }
            });
            this.i.start();
        }
    }

    private void f() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.trim_new_bottom_v, (ViewGroup) null);
        this.h = (VideoFrameView) inflate.findViewById(R.id.stv_video_frame_view);
        this.d = (TextView) inflate.findViewById(R.id.stv_editor_bottom_title);
        this.e = (TextView) inflate.findViewById(R.id.stv_bottom_save);
        this.f = (LinearLayout) inflate.findViewById(R.id.stv_video_trim_seek_layout);
        this.e.setOnClickListener(this);
        addView(inflate);
    }

    public void a() {
    }

    public void a(double d) {
        long round = d != 0.0d ? Math.round(d / 1000.0d) : 0L;
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(String.format(getResources().getString(R.string.stv_trim_video_time_title), Long.valueOf(round)));
        }
    }

    public void a(int i) {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            StvLogUtils.a(b + "animator.cancel():", new Object[0]);
            this.i.cancel();
        }
        b(i);
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        VideoFrameView videoFrameView = this.h;
        if (videoFrameView != null) {
            videoFrameView.a(onScrollListener);
        }
    }

    public void a(ITrimBottomCallback iTrimBottomCallback, TrimDataModel trimDataModel) {
        this.k = iTrimBottomCallback;
        this.j = trimDataModel;
        long min = Math.min(trimDataModel.getDurationMs(), this.j.getMaxVideoDuration());
        RangeSeekBar rangeSeekBar = new RangeSeekBar(getContext(), 0L, min);
        this.g = rangeSeekBar;
        this.f.addView(rangeSeekBar);
        this.g.setSelectedMinValue(0L);
        this.g.setSelectedMaxValue(min);
        this.g.setMin_cut_time(this.j.getMinVideoDuration());
        this.g.setNotifyWhileDragging(true);
        a(this.j.getRightProgress() - this.j.getLeftProgress());
        TrimSeekBar trimSeekBar = (TrimSeekBar) findViewById(R.id.seekbar_position_icon);
        this.f15921c = trimSeekBar;
        trimSeekBar.setMax(1000);
        this.f15921c.setOnSeekBarChangeListener(this.f15920a);
        this.h.a(this.j.getVideoPath(), this.j.getDurationMs(), this.j.getSingleRangeWidth(), DensityUtils.a(getContext(), 54.0f), this.j.getMarginSize(), this.j.getThumbnailsCount());
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        VideoFrameView videoFrameView = this.h;
        if (videoFrameView != null) {
            videoFrameView.a();
        }
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.i.cancel();
    }

    public void e() {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        StvLogUtils.a(b + "animator.cancel():", new Object[0]);
        this.i.cancel();
    }

    public long getSelectedMaxValue() {
        RangeSeekBar rangeSeekBar = this.g;
        if (rangeSeekBar != null) {
            return rangeSeekBar.getSelectedMaxValue();
        }
        return 0L;
    }

    public long getSelectedMinValue() {
        RangeSeekBar rangeSeekBar = this.g;
        if (rangeSeekBar != null) {
            return rangeSeekBar.getSelectedMinValue();
        }
        return 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ITrimBottomCallback iTrimBottomCallback;
        Tracker.onClick(view);
        if (view.getId() != R.id.stv_bottom_save || (iTrimBottomCallback = this.k) == null) {
            return;
        }
        iTrimBottomCallback.a(view);
    }

    public void setOnRangeSeekBarChangeListener(RangeSeekBar.OnRangeSeekBarChangeListener onRangeSeekBarChangeListener) {
        RangeSeekBar rangeSeekBar = this.g;
        if (rangeSeekBar != null) {
            rangeSeekBar.setOnRangeSeekBarChangeListener(onRangeSeekBarChangeListener);
        }
    }
}
