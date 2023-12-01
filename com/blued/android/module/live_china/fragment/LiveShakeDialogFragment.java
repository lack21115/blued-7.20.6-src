package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveShakeModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.LiveShakeScrollView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShakeDialogFragment.class */
public class LiveShakeDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f13247a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f13248c;
    public LinearLayout d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public TextView l;
    public TextView m;
    public TextView n;
    private boolean o;
    private LiveShakeModel p = new LiveShakeModel();
    private CountDownTimer q;
    private CountDownTimer r;

    private void k() {
        this.e.setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(40L);
        alphaAnimation.setFillAfter(false);
        this.e.clearAnimation();
        this.e.startAnimation(alphaAnimation);
        this.e.setVisibility(0);
    }

    private void l() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.2f, 0.5f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(240L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(160L);
                scaleAnimation2.setFillAfter(true);
                LiveShakeDialogFragment.this.f.clearAnimation();
                LiveShakeDialogFragment.this.f.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f.clearAnimation();
        this.f.startAnimation(scaleAnimation);
    }

    private void m() {
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.l.setVisibility(8);
        this.g.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.6
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(280L);
                alphaAnimation.setFillAfter(true);
                LiveShakeDialogFragment.this.g.clearAnimation();
                LiveShakeDialogFragment.this.h.clearAnimation();
                LiveShakeDialogFragment.this.l.clearAnimation();
                LiveShakeDialogFragment.this.g.startAnimation(alphaAnimation);
                LiveShakeDialogFragment.this.g.setVisibility(0);
                if (LiveShakeDialogFragment.this.p.pageFrom == 1) {
                    LiveShakeDialogFragment.this.h.setVisibility(8);
                } else {
                    LiveShakeDialogFragment.this.h.startAnimation(alphaAnimation);
                    LiveShakeDialogFragment.this.h.setVisibility(0);
                }
                if (!TextUtils.equals(LiveShakeDialogFragment.this.p.mvp, LiveRoomInfo.a().f()) && LiveShakeDialogFragment.this.p.pageFrom != 1) {
                    LiveShakeDialogFragment.this.l.setVisibility(8);
                    return;
                }
                LiveShakeDialogFragment.this.l.startAnimation(alphaAnimation);
                LiveShakeDialogFragment.this.l.setVisibility(0);
            }
        }, 160L);
    }

    private void n() {
        this.i.setVisibility(8);
        this.i.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.7
            @Override // java.lang.Runnable
            public void run() {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(280L);
                scaleAnimation.setFillAfter(true);
                LiveShakeDialogFragment.this.i.setVisibility(0);
                LiveShakeDialogFragment.this.i.clearAnimation();
                LiveShakeDialogFragment.this.i.startAnimation(scaleAnimation);
            }
        }, 160L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        CountDownTimer countDownTimer = this.q;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        CountDownTimer countDownTimer = this.r;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void a(LiveShakeModel liveShakeModel) {
        o();
        this.p = liveShakeModel;
        if (liveShakeModel == null) {
            return;
        }
        if (liveShakeModel.status != 0) {
            if (this.p.status == 1) {
                this.e.setVisibility(0);
                this.k.setVisibility(8);
                this.m.setText(this.p.desc);
                this.l.setText(this.f13247a.getString(R.string.live_shake_state_2));
                this.l.setBackgroundResource(R.drawable.live_shake_state_2);
                if (this.p.pageFrom == 1) {
                    this.h.setVisibility(8);
                    this.l.setVisibility(0);
                } else {
                    this.h.setVisibility(0);
                    if (TextUtils.equals(this.p.mvp, LiveRoomInfo.a().f())) {
                        this.l.setVisibility(0);
                    } else {
                        this.l.setVisibility(8);
                    }
                }
                g();
            }
        } else if (this.p.beans > 0) {
            this.e.setVisibility(8);
            this.k.setVisibility(0);
            this.n.setText(String.valueOf(this.p.beans));
            i();
        } else {
            this.e.setVisibility(0);
            this.k.setVisibility(8);
            this.m.setText(this.p.desc);
            this.l.setBackgroundResource(R.drawable.live_shake_state_1);
            this.l.setText(String.format(this.f13247a.getString(R.string.live_shake_state_1), "5"));
            if (this.p.pageFrom == 1) {
                this.h.setVisibility(8);
                this.l.setVisibility(0);
                h();
            } else {
                this.h.setVisibility(0);
                if (TextUtils.equals(this.p.mvp, LiveRoomInfo.a().f())) {
                    this.l.setVisibility(0);
                    h();
                } else {
                    this.l.setVisibility(8);
                }
            }
            g();
            f();
        }
    }

    public void d() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            dismissAllowingStateLoss();
        }
        o();
        p();
    }

    public boolean e() {
        Dialog dialog = getDialog();
        return dialog != null && dialog.isShowing();
    }

    public void f() {
        k();
        l();
        m();
        n();
    }

    public void g() {
        LiveShakeModel liveShakeModel = this.p;
        if (liveShakeModel == null || liveShakeModel.machines == null) {
            d();
            return;
        }
        this.d.removeAllViews();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.p.machines);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                arrayList.add(jSONArray.getString(i2));
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.p.index == -1) {
            this.p.index = arrayList.size() - 1;
        }
        Iterator<E> it = arrayList.iterator();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return;
            }
            String str = (String) it.next();
            View inflate = LayoutInflater.from(this.f13247a).inflate(R.layout.live_shake_item_line_view, (ViewGroup) null);
            this.d.addView(inflate, -2, -1);
            View findViewById = inflate.findViewById(R.id.line_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            if (arrayList.size() == 5) {
                marginLayoutParams.leftMargin = DensityUtils.a(this.f13247a, 2.58f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f13247a, 2.58f);
            } else if (arrayList.size() == 6) {
                marginLayoutParams.leftMargin = DensityUtils.a(this.f13247a, 0.0f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f13247a, 0.0f);
            } else {
                marginLayoutParams.leftMargin = DensityUtils.a(this.f13247a, 7.4f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f13247a, 7.4f);
            }
            if (i4 == arrayList.size() - 1) {
                findViewById.setVisibility(8);
            }
            findViewById.setLayoutParams(marginLayoutParams);
            Log.i("==xpm", "result:" + str + "  index:" + i4 + " shakeModel.index:" + this.p.index);
            LiveShakeScrollView liveShakeScrollView = (LiveShakeScrollView) inflate.findViewById(R.id.scroll_view);
            if (TextUtils.equals("-", str)) {
                liveShakeScrollView.a(-1, false);
            } else if (this.p.index == i4 && this.p.status == 1) {
                liveShakeScrollView.setEventCallback(new LiveShakeScrollView.EventCallback() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.8
                    @Override // com.blued.android.module.live_china.view.LiveShakeScrollView.EventCallback
                    public void a() {
                        if (LiveShakeDialogFragment.this.p.beans <= 0) {
                            LiveShakeDialogFragment.this.i();
                            return;
                        }
                        LiveShakeDialogFragment.this.p();
                        LiveShakeDialogFragment.this.o();
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                alphaAnimation.setDuration(100L);
                                alphaAnimation.setFillAfter(true);
                                LiveShakeDialogFragment.this.e.clearAnimation();
                                LiveShakeDialogFragment.this.e.setVisibility(8);
                                LiveShakeDialogFragment.this.e.startAnimation(alphaAnimation);
                                LiveShakeDialogFragment.this.k.setVisibility(0);
                                LiveShakeDialogFragment.this.n.setText(String.valueOf(LiveShakeDialogFragment.this.p.beans));
                                LiveShakeDialogFragment.this.i();
                            }
                        }, 1000L);
                    }
                });
                liveShakeScrollView.a(StringUtils.a(str, 0), true);
            } else {
                liveShakeScrollView.a(StringUtils.a(str, 0), false);
            }
            i3 = i4 + 1;
        }
    }

    public void h() {
        o();
        this.q = new CountDownTimer(6000L, 1000L) { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.9
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                LiveShakeDialogFragment.this.l.setText(String.format(LiveShakeDialogFragment.this.f13247a.getString(R.string.live_shake_state_1), String.valueOf(j / 1000)));
            }
        }.start();
    }

    public void i() {
        p();
        this.r = new CountDownTimer(6000L, 1000L) { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.10
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveShakeDialogFragment.this.d();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void j() {
        if (this.p == null) {
            return;
        }
        this.l.setBackgroundResource(R.drawable.live_shake_state_2);
        this.l.setText(this.f13247a.getString(R.string.live_shake_state_2));
        LiveRoomHttpUtils.e(new BluedUIHttpResponse(a()) { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.11
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, this.p.mvp, this.p.anchor);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13247a = getActivity();
        setStyle(0, R.style.Dialog_FullScreen);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getArguments() != null) {
            this.p = (LiveShakeModel) getArguments().getSerializable("shakeModel");
        }
        View inflate = layoutInflater.inflate(R.layout.dialog_live_shake, viewGroup);
        this.b = inflate;
        if (this.p == null) {
            d();
            return this.b;
        }
        this.f13248c = inflate.findViewById(R.id.empty_view);
        this.d = (LinearLayout) this.b.findViewById(R.id.ll_shake);
        this.e = this.b.findViewById(R.id.live_shake_layout);
        this.g = this.b.findViewById(R.id.iv_reward);
        this.f = this.b.findViewById(R.id.fl_anim);
        this.h = this.b.findViewById(R.id.iv_close);
        this.i = this.b.findViewById(R.id.iv_fly);
        this.l = (TextView) this.b.findViewById(R.id.tv_shake);
        this.m = (TextView) this.b.findViewById(R.id.tv_tip);
        this.k = this.b.findViewById(R.id.fl_shake_beans);
        this.n = (TextView) this.b.findViewById(R.id.tv_beans);
        this.j = this.b.findViewById(R.id.iv_beans_close);
        a(this.p);
        this.f13248c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveShakeDialogFragment.this.d();
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveShakeDialogFragment.this.d();
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveShakeDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveShakeDialogFragment.this.o();
                LiveShakeDialogFragment.this.j();
            }
        });
        this.o = true;
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.o) {
            o();
            p();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
