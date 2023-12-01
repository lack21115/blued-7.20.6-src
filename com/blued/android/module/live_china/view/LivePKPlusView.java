package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LivePKPlusModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKPlusView.class */
public class LivePKPlusView extends FrameLayout implements View.OnClickListener {
    private BaseFragment A;

    /* renamed from: a  reason: collision with root package name */
    Runnable f14772a;
    Runnable b;

    /* renamed from: c  reason: collision with root package name */
    Runnable f14773c;
    Runnable d;
    private View e;
    private View f;
    private View g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;
    private View r;
    private ProgressBar s;
    private boolean t;
    private boolean u;
    private long v;
    private long w;
    private int x;
    private int y;
    private LivePKPlusModel z;

    public LivePKPlusView(Context context) {
        this(context, null);
    }

    public LivePKPlusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = false;
        this.x = 0;
        this.y = 0;
        this.f14772a = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.12
            @Override // java.lang.Runnable
            public void run() {
                LivePKPlusView.this.f();
            }
        };
        this.b = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.13
            @Override // java.lang.Runnable
            public void run() {
                LivePKPlusView.this.g();
            }
        };
        this.f14773c = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.14
            @Override // java.lang.Runnable
            public void run() {
                LivePKPlusView.this.h();
            }
        };
        this.d = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.15
            @Override // java.lang.Runnable
            public void run() {
                LivePKPlusView.this.i();
            }
        };
        e();
    }

    private String a(int i) {
        return i >= 100 ? "99+" : String.valueOf(i);
    }

    private void a(int i, int i2, int i3, long j) {
        if (this.u) {
            return;
        }
        Log.i("==xpm", "leftWinNum:" + i + "  rightWinNum:" + i2);
        StringBuilder sb = new StringBuilder();
        sb.append("result:");
        sb.append(i3);
        Log.i("==xpm", sb.toString());
        this.x = i;
        this.y = i2;
        this.w = j;
        boolean z = true;
        if (i3 != 1) {
            z = false;
        }
        this.t = z;
        if (this.f.getVisibility() == 0) {
            if (i3 == 0 || i3 == -1) {
                if (i == 0) {
                    this.f.setVisibility(8);
                }
                this.m.setText(a(i));
            } else {
                this.n.setText(a(i));
                removeCallbacks(this.f14773c);
                postDelayed(this.f14773c, 5000L);
            }
            d();
        } else if (i > 0) {
            this.m.setText(a(i));
            removeCallbacks(this.f14772a);
            postDelayed(this.f14772a, i3 == -1 ? 500L : 5000L);
        } else {
            d();
        }
        if (this.g.getVisibility() != 0) {
            if (i2 > 0) {
                this.o.setText(a(i2));
                removeCallbacks(this.b);
                postDelayed(this.b, i3 == -1 ? 500L : 5000L);
            }
        } else if (i3 == 0 || i3 == -1) {
            if (i2 == 0) {
                this.g.setVisibility(8);
            }
            this.o.setText(a(i2));
        } else {
            this.p.setText(a(i2));
            removeCallbacks(this.d);
            postDelayed(this.d, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        this.f.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int measuredWidth = this.q.getMeasuredWidth();
        int measuredWidth2 = this.f.getMeasuredWidth();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKPlusView.this.q.setVisibility(8);
                LivePKPlusView.this.r.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z) {
                    LivePKPlusView.this.q.setVisibility(0);
                } else {
                    LivePKPlusView.this.r.setVisibility(0);
                }
            }
        });
        ofFloat.setDuration(600L);
        ofFloat.setRepeatCount(1);
        final int i = measuredWidth2 + measuredWidth;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * i) - measuredWidth);
                LivePKPlusView.this.q.setX(floatValue);
                LivePKPlusView.this.r.setX(floatValue);
                LivePKPlusView.this.getParent().requestLayout();
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Log.i("==xpm", "animForGone:" + z);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(300L);
        if (z) {
            this.f.clearAnimation();
            this.f.startAnimation(alphaAnimation);
            this.f.setVisibility(8);
            return;
        }
        this.g.clearAnimation();
        this.g.startAnimation(alphaAnimation);
        this.g.setVisibility(8);
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_winning_plus, this);
        this.e = findViewById(R.id.fl_plus_task);
        this.f = findViewById(R.id.pk_plus_left);
        this.n = (TextView) findViewById(R.id.tv_plus_left_copy);
        this.g = findViewById(R.id.pk_plus_right);
        this.p = (TextView) findViewById(R.id.tv_plus_right_copy);
        this.m = (TextView) findViewById(R.id.tv_plus_left);
        this.o = (TextView) findViewById(R.id.tv_plus_right);
        this.q = findViewById(R.id.pk_light_left);
        this.r = findViewById(R.id.pk_light_right);
        this.h = (ImageView) findViewById(R.id.iv_plus_task_icon);
        this.i = (ImageView) findViewById(R.id.iv_task_plus_num_check);
        this.j = (ImageView) findViewById(R.id.iv_task_plus_value_check);
        this.k = (TextView) findViewById(R.id.tv_task_plus);
        this.l = (TextView) findViewById(R.id.tv_task_plus_value);
        this.s = (ProgressBar) findViewById(R.id.live_plus_task_progres);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                if (LivePKPlusView.this.A instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) LivePKPlusView.this.A).d(LiveRoomInfo.a().G(), 25);
                }
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, String.valueOf(LivePKPlusView.this.v), String.valueOf(LivePKPlusView.this.w));
                if (LivePKPlusView.this.A instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) LivePKPlusView.this.A).d(LiveRoomInfo.a().G(), 0);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                if (LivePKPlusView.this.A instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) LivePKPlusView.this.A).d(LiveRoomInfo.a().G(), 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.u = true;
        this.f.setVisibility(8);
        this.f.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int a2 = DensityUtils.a(getContext(), 0.0f);
        int measuredWidth = this.f.getMeasuredWidth();
        final int i = (AppInfo.l / 2) - measuredWidth;
        this.f.setX(i);
        this.f.setAlpha(0.0f);
        Log.i("==xpm", "leftWidth:" + measuredWidth);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKPlusView.this.u = false;
                LivePKPlusView.this.d();
                if (LivePKPlusView.this.t) {
                    LivePKPlusView.this.a(true);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LivePKPlusView.this.f.setVisibility(0);
            }
        });
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view = LivePKPlusView.this.f;
                int i2 = i;
                view.setX(i2 + ((a2 - i2) * floatValue));
                LivePKPlusView.this.f.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.u = true;
        this.g.setVisibility(8);
        this.g.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int a2 = DensityUtils.a(getContext(), 10.0f);
        int measuredWidth = this.g.getMeasuredWidth();
        int i = AppInfo.l;
        final int i2 = i / 2;
        this.g.setX(i2);
        this.g.setAlpha(0.0f);
        Log.i("==xpm", "rightWidth:" + measuredWidth);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKPlusView.this.u = false;
                if (LivePKPlusView.this.t) {
                    return;
                }
                LivePKPlusView.this.a(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LivePKPlusView.this.g.setVisibility(0);
            }
        });
        ofFloat.setDuration(600L);
        final int i3 = (i - measuredWidth) - a2;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view = LivePKPlusView.this.g;
                int i4 = i2;
                view.setX(i4 + ((i3 - i4) * floatValue));
                LivePKPlusView.this.g.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.u = true;
        Log.i("==xpm", "animForUpdateNumsLeft");
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, this.t ? -1.0f : 1.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivePKPlusView.this.u = false;
                Log.i("==xpm", "onAnimationEnd");
                LivePKPlusView.this.m.setText(LivePKPlusView.this.n.getText());
                LivePKPlusView.this.m.clearAnimation();
                LivePKPlusView.this.n.setVisibility(8);
                LivePKPlusView.this.n.clearAnimation();
                if (LivePKPlusView.this.t) {
                    LivePKPlusView.this.a(true);
                } else if (TextUtils.equals("0", LivePKPlusView.this.m.getText()) || TextUtils.isEmpty(LivePKPlusView.this.m.getText())) {
                    LivePKPlusView.this.b(true);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.m.clearAnimation();
        this.m.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this.t ? 1.0f : -1.0f, 1, 0.0f);
        translateAnimation2.setDuration(400L);
        translateAnimation2.setFillAfter(true);
        this.n.clearAnimation();
        this.n.startAnimation(translateAnimation2);
        this.n.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.u = true;
        Log.i("==xpm", "animForUpdateNumsRight");
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, this.t ? 1.0f : -1.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKPlusView.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivePKPlusView.this.u = false;
                LivePKPlusView.this.o.setText(LivePKPlusView.this.p.getText());
                LivePKPlusView.this.o.clearAnimation();
                LivePKPlusView.this.p.setVisibility(8);
                LivePKPlusView.this.p.clearAnimation();
                if (!LivePKPlusView.this.t) {
                    LivePKPlusView.this.a(false);
                } else if (TextUtils.equals("0", LivePKPlusView.this.o.getText()) || TextUtils.isEmpty(LivePKPlusView.this.o.getText())) {
                    LivePKPlusView.this.b(false);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.o.clearAnimation();
        this.o.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this.t ? -1.0f : 1.0f, 1, 0.0f);
        translateAnimation2.setDuration(400L);
        translateAnimation2.setFillAfter(true);
        this.p.clearAnimation();
        this.p.startAnimation(translateAnimation2);
        this.p.setVisibility(0);
    }

    private boolean j() {
        if (TextUtils.equals(LiveRoomManager.a().g(), LiveRoomInfo.a().f())) {
            LivePKPlusModel livePKPlusModel = this.z;
            if (livePKPlusModel != null) {
                return (livePKPlusModel.target_streak == 0 || this.z.target_beans == 0) ? false : true;
            }
            return true;
        }
        return false;
    }

    private void setPkPlusTask(LivePKPlusModel livePKPlusModel) {
        this.k.setText(String.format(AppInfo.d().getString(R.string.live_pk_plus_num), String.valueOf(livePKPlusModel.target_streak)));
        TextView textView = this.l;
        textView.setText(livePKPlusModel.total_beans + BridgeUtil.SPLIT_MARK + livePKPlusModel.target_beans);
        boolean z = livePKPlusModel.leftWinNum >= livePKPlusModel.target_streak;
        this.i.setImageResource(z ? R.drawable.live_pk_plus_task_complete : R.drawable.live_pk_plus_task_un_complete);
        boolean z2 = livePKPlusModel.total_beans >= livePKPlusModel.target_beans;
        this.j.setImageResource(z2 ? R.drawable.live_pk_plus_task_complete : R.drawable.live_pk_plus_task_un_complete);
        this.h.setImageResource((z && z2) ? R.drawable.live_pk_plus_task_icon_complete : R.drawable.live_pk_plus_task_icon);
        if (livePKPlusModel.target_beans > 0) {
            this.s.setProgress((livePKPlusModel.total_beans * 100) / livePKPlusModel.target_beans);
        }
    }

    public void a() {
        this.u = false;
        this.x = 0;
        this.y = 0;
        removeCallbacks(this.f14772a);
        removeCallbacks(this.b);
        removeCallbacks(this.f14773c);
        removeCallbacks(this.d);
        this.f.clearAnimation();
        this.f.setVisibility(8);
        this.g.clearAnimation();
        this.g.setVisibility(8);
        this.e.setVisibility(8);
    }

    public boolean b() {
        return this.f.getVisibility() == 0;
    }

    public boolean c() {
        return this.g.getVisibility() == 0;
    }

    public void d() {
        this.e.setVisibility(j() ? 0 : 8);
    }

    public long getLid() {
        return this.v;
    }

    public long getUid() {
        return this.w;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r3.y > 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getViewHeight() {
        /*
            r3 = this;
            r0 = r3
            android.content.Context r0 = r0.getContext()
            r1 = 1092616192(0x41200000, float:10.0)
            int r0 = com.blued.android.framework.utils.DensityUtils.a(r0, r1)
            r4 = r0
            r0 = r3
            boolean r0 = r0.j()
            if (r0 == 0) goto L24
            r0 = r3
            android.content.Context r0 = r0.getContext()
            r1 = 1110179840(0x422c0000, float:43.0)
            int r0 = com.blued.android.framework.utils.DensityUtils.a(r0, r1)
            r5 = r0
            r0 = r4
            r1 = r5
            int r0 = r0 + r1
            r4 = r0
            goto L26
        L24:
            r0 = 0
            r5 = r0
        L26:
            r0 = r5
            if (r0 <= 0) goto L41
            r0 = r4
            r5 = r0
            r0 = r3
            int r0 = r0.x
            if (r0 <= 0) goto L60
            r0 = r3
            android.content.Context r0 = r0.getContext()
            r1 = 1102053376(0x41b00000, float:22.0)
            int r0 = com.blued.android.framework.utils.DensityUtils.a(r0, r1)
            r5 = r0
            goto L5c
        L41:
            r0 = r3
            int r0 = r0.x
            if (r0 > 0) goto L51
            r0 = r4
            r5 = r0
            r0 = r3
            int r0 = r0.y
            if (r0 <= 0) goto L60
        L51:
            r0 = r3
            android.content.Context r0 = r0.getContext()
            r1 = 1102053376(0x41b00000, float:22.0)
            int r0 = com.blued.android.framework.utils.DensityUtils.a(r0, r1)
            r5 = r0
        L5c:
            r0 = r4
            r1 = r5
            int r0 = r0 + r1
            r5 = r0
        L60:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LivePKPlusView.getViewHeight():int");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setFragment(BaseFragment baseFragment) {
        this.A = baseFragment;
    }

    public void setOtherLid(long j) {
        this.v = j;
    }

    public void setResult(LivePKPlusModel livePKPlusModel) {
        if (livePKPlusModel == null) {
            return;
        }
        this.z = livePKPlusModel;
        setPkPlusTask(livePKPlusModel);
        a(livePKPlusModel.leftWinNum, livePKPlusModel.rightWinNum, livePKPlusModel.result, livePKPlusModel.otherUid);
    }
}
