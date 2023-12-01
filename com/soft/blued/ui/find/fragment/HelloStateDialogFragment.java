package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.PileLayout;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.user.BluedConfig;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/HelloStateDialogFragment.class */
public class HelloStateDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public View f30333a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30334c;
    private ImageView d;
    private View e;
    private View f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private TextView k;
    private PileLayout l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private ImageView p;
    private TextView q;
    private LoadOptions r;
    private CallMeStatusData s;
    private Timer t;
    private int u;

    public static void a(Context context, CallMeStatusData callMeStatusData) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", callMeStatusData);
        TransparentActivity.a(bundle);
        TransparentActivity.b(context, HelloStateDialogFragment.class, bundle);
    }

    static /* synthetic */ int b(HelloStateDialogFragment helloStateDialogFragment) {
        int i = helloStateDialogFragment.u;
        helloStateDialogFragment.u = i - 1;
        return i;
    }

    private void d() {
        this.f30334c = (TextView) this.f30333a.findViewById(2131372754);
        this.d = (ImageView) this.f30333a.findViewById(R.id.iv_center);
        this.e = this.f30333a.findViewById(R.id.fl_center);
        this.f = this.f30333a.findViewById(2131365051);
        this.g = (LinearLayout) this.f30333a.findViewById(R.id.ll_text);
        this.h = (LinearLayout) this.f30333a.findViewById(R.id.ll_call_info);
        this.i = (TextView) this.f30333a.findViewById(R.id.tv_recommend_people);
        this.j = (TextView) this.f30333a.findViewById(R.id.tv_popularize);
        this.k = (TextView) this.f30333a.findViewById(R.id.tv_visit_cnt);
        this.l = (PileLayout) this.f30333a.findViewById(R.id.pile_layout);
        this.m = (TextView) this.f30333a.findViewById(R.id.tv_contDown);
        this.n = (TextView) this.f30333a.findViewById(R.id.tv_promoting);
        this.o = (LinearLayout) this.f30333a.findViewById(R.id.ll_verify);
        this.p = (ImageView) this.f30333a.findViewById(2131365207);
        this.q = (TextView) this.f30333a.findViewById(2131371023);
        if (this.s.call_status == 5) {
            this.q.setText(getResources().getString(R.string.call_again));
        } else {
            this.q.setText(getResources().getString(R.string.call_know));
        }
        LoadOptions loadOptions = new LoadOptions();
        this.r = loadOptions;
        loadOptions.d = 2131237310;
        this.r.b = 2131237310;
        e();
        k();
    }

    private void e() {
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.HelloStateDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                HelloStateDialogFragment.this.getActivity().finish();
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.HelloStateDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (HelloStateDialogFragment.this.s.call_status == 5) {
                    if (BluedConfig.a().C()) {
                        HelloOpenDialogFragment.a(HelloStateDialogFragment.this.getContext(), 0);
                    } else {
                        CallHelloManager.a().a(HelloStateDialogFragment.this.getContext(), (IRequestHost) null, 0, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.find.fragment.HelloStateDialogFragment.2.1
                            @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                            public void done(boolean z) {
                                if (z) {
                                    CallHelloManager.a().a((Context) HomeActivity.f30985c, (IRequestHost) null, false, 4);
                                }
                            }
                        });
                    }
                }
                HelloStateDialogFragment.this.getActivity().finish();
            }
        });
    }

    private void f() {
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        this.h.setVisibility(8);
        if (CallHelloManager.a().b().is_quietly == 1) {
            this.f30334c.setText(R.string.call_secret_open_successful);
            this.n.setText(R.string.call_secret_running);
        } else {
            if (CallHelloManager.a().h()) {
                this.f30334c.setText(R.string.open_twice_call_success);
            } else {
                this.f30334c.setText(R.string.call_open_successful);
            }
            if (CallHelloManager.a().g()) {
                this.n.setText(R.string.super_hello_name_ing);
            } else {
                this.n.setText(R.string.hello_name_ing);
            }
        }
        this.n.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        this.m.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.anim_hello_state);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.f.startAnimation(loadAnimation);
        l();
    }

    private void g() {
        this.m.setVisibility(8);
        this.p.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(0);
        this.h.setVisibility(8);
        this.f30334c.setText(getResources().getString(R.string.call_under_review));
        this.d.setVisibility(0);
        this.d.setImageResource(R.drawable.icon_call_verify);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
    }

    private void h() {
        this.m.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        this.h.setVisibility(0);
        this.i.setText(R.string.call_recommend_people);
        if (CallHelloManager.a().b().is_quietly == 1) {
            this.f30334c.setText(getResources().getString(R.string.call_secret_running));
        } else if (CallHelloManager.a().g()) {
            this.f30334c.setText(R.string.super_hello_name_ing);
            this.i.setText(R.string.super_call_recommend_people);
        } else {
            this.f30334c.setText(R.string.hello_name_ing);
        }
        this.n.setText(R.string.call_spotlight_promoting);
        this.n.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        TextView textView = this.j;
        textView.setText("" + this.s.promote_person_num);
        TextView textView2 = this.k;
        textView2.setText("" + this.s.visits);
        j();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.anim_hello_state);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.f.startAnimation(loadAnimation);
        l();
    }

    private void i() {
        this.m.setVisibility(8);
        this.p.setVisibility(0);
        this.o.setVisibility(8);
        this.h.setVisibility(0);
        this.i.setText(R.string.call_recommend_people);
        if (CallHelloManager.a().b().is_quietly == 1) {
            this.f30334c.setText(getResources().getString(R.string.call_secret_complete));
        } else if (CallHelloManager.a().g()) {
            this.i.setText(R.string.super_call_recommend_people);
            this.f30334c.setText(getResources().getString(R.string.super_call_complete));
        } else {
            this.f30334c.setText(getResources().getString(R.string.call_complete));
        }
        this.n.setText(R.string.call_spotlight_promoted);
        this.n.setVisibility(0);
        this.d.setVisibility(0);
        this.d.setImageResource(R.drawable.icon_call_me_complete);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        TextView textView = this.j;
        textView.setText("" + this.s.promote_person_num);
        TextView textView2 = this.k;
        textView2.setText("" + this.s.visits);
        j();
    }

    private void j() {
        if (this.s.visitors == null || this.s.visitors.isEmpty()) {
            return;
        }
        this.l.removeAllViews();
        for (CallMeStatusData.Visitor visitor : this.s.visitors) {
            ImageView imageView = new ImageView(getContext());
            ImageLoader.a(a(), visitor.avatar).b(2131237310).a(2.0f, -1).a(imageView);
            this.l.addView(imageView, new ViewGroup.MarginLayoutParams(DensityUtils.a(getContext(), 32.0f), DensityUtils.a(getContext(), 32.0f)));
        }
    }

    private void k() {
        int i = this.s.call_status;
        if (i == 1) {
            h();
        } else if (i == 2) {
            g();
        } else if (i == 4) {
            f();
        } else if (i != 5) {
        } else {
            i();
        }
    }

    private void l() {
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
            this.t = null;
        }
        this.u = this.s.countdown;
        Timer timer2 = new Timer();
        this.t = timer2;
        timer2.schedule(new TimerTask() { // from class: com.soft.blued.ui.find.fragment.HelloStateDialogFragment.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                HelloStateDialogFragment.b(HelloStateDialogFragment.this);
                if (HelloStateDialogFragment.this.u > 0) {
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.find.fragment.HelloStateDialogFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HelloStateDialogFragment.this.m.setText(TimeAndDateUtils.a(HelloStateDialogFragment.this.u, false));
                        }
                    });
                } else if (HelloStateDialogFragment.this.t != null) {
                    HelloStateDialogFragment.this.t.cancel();
                    HelloStateDialogFragment.this.t = null;
                    HelloStateDialogFragment.this.getActivity().finish();
                }
            }
        }, 0L, 1000L);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.s = (CallMeStatusData) getArguments().getSerializable("data");
        }
        if (this.s == null) {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        if (this.f30333a == null) {
            this.f30333a = layoutInflater.inflate(R.layout.dialog_hello_state_new, viewGroup, false);
            d();
            StatusBarHelper.a((Activity) getActivity(), false);
        }
        return this.f30333a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
            this.t = null;
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = this.f;
        if (view != null) {
            view.clearAnimation();
        }
    }
}
