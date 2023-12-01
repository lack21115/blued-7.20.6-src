package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FlashReportDialogFragment.class */
public class FlashReportDialogFragment extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f30311a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f30312c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private TextView r;
    private String s;
    private String t;
    private String u;
    private int v = -1;
    private DialogStateListener w;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FlashReportDialogFragment$DialogStateListener.class */
    public interface DialogStateListener {
        void a();

        void b();
    }

    private void a() {
        this.m = (ImageView) this.b.findViewById(R.id.layout_ad).findViewById(2131364411);
        this.n = (ImageView) this.b.findViewById(R.id.layout_poli).findViewById(2131364411);
        this.o = (ImageView) this.b.findViewById(R.id.layout_sex).findViewById(2131364411);
        this.p = (ImageView) this.b.findViewById(R.id.layout_drug).findViewById(2131364411);
        this.q = (ImageView) this.b.findViewById(R.id.layout_other).findViewById(2131364411);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.layout_ad).findViewById(2131367604);
        this.f30312c = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FlashReportDialogFragment.this.m.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.n.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.o.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.p.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.q.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment flashReportDialogFragment = FlashReportDialogFragment.this;
                flashReportDialogFragment.a(flashReportDialogFragment.m);
                FlashReportDialogFragment.this.v = 1;
                FlashReportDialogFragment.this.b();
            }
        });
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.layout_poli).findViewById(2131367604);
        this.d = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FlashReportDialogFragment.this.m.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.n.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.o.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.p.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.q.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment flashReportDialogFragment = FlashReportDialogFragment.this;
                flashReportDialogFragment.a(flashReportDialogFragment.n);
                FlashReportDialogFragment.this.v = 4;
                FlashReportDialogFragment.this.b();
            }
        });
        LinearLayout linearLayout3 = (LinearLayout) this.b.findViewById(R.id.layout_sex).findViewById(2131367604);
        this.e = linearLayout3;
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FlashReportDialogFragment.this.m.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.n.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.o.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.p.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.q.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment flashReportDialogFragment = FlashReportDialogFragment.this;
                flashReportDialogFragment.a(flashReportDialogFragment.o);
                FlashReportDialogFragment.this.v = 2;
                FlashReportDialogFragment.this.b();
            }
        });
        LinearLayout linearLayout4 = (LinearLayout) this.b.findViewById(R.id.layout_drug).findViewById(2131367604);
        this.f = linearLayout4;
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FlashReportDialogFragment.this.m.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.n.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.o.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.p.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.q.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment flashReportDialogFragment = FlashReportDialogFragment.this;
                flashReportDialogFragment.a(flashReportDialogFragment.p);
                FlashReportDialogFragment.this.v = 5;
                FlashReportDialogFragment.this.b();
            }
        });
        LinearLayout linearLayout5 = (LinearLayout) this.b.findViewById(R.id.layout_other).findViewById(2131367604);
        this.g = linearLayout5;
        linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FlashReportDialogFragment.this.m.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.n.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.o.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.p.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment.this.q.setImageResource(R.drawable.report_unchoosen);
                FlashReportDialogFragment flashReportDialogFragment = FlashReportDialogFragment.this;
                flashReportDialogFragment.a(flashReportDialogFragment.q);
                FlashReportDialogFragment.this.v = 0;
                FlashReportDialogFragment.this.b();
            }
        });
        TextView textView = (TextView) this.b.findViewById(R.id.layout_ad).findViewById(2131370786);
        this.h = textView;
        textView.setText(getResources().getString(2131886298));
        TextView textView2 = (TextView) this.b.findViewById(R.id.layout_poli).findViewById(2131370786);
        this.i = textView2;
        textView2.setText(getResources().getString(2131891288));
        TextView textView3 = (TextView) this.b.findViewById(R.id.layout_sex).findViewById(2131370786);
        this.j = textView3;
        textView3.setText(getResources().getString(2131891289));
        TextView textView4 = (TextView) this.b.findViewById(R.id.layout_drug).findViewById(2131370786);
        this.k = textView4;
        textView4.setText(getResources().getString(2131887538));
        TextView textView5 = (TextView) this.b.findViewById(R.id.layout_other).findViewById(2131370786);
        this.l = textView5;
        textView5.setText(getResources().getString(2131891208));
        TextView textView6 = (TextView) this.b.findViewById(R.id.tv_submit);
        this.r = textView6;
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (FlashReportDialogFragment.this.v != -1) {
                    FlashReportDialogFragment.this.c();
                    FlashReportDialogFragment.this.dismiss();
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FlashReportDialogFragment.this.dismiss();
            }
        });
        DialogStateListener dialogStateListener = this.w;
        if (dialogStateListener != null) {
            dialogStateListener.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        AppMethods.a((CharSequence) this.f30311a.getResources().getString(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.1f, 0.5f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100L);
        final ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(50L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.setImageResource(R.drawable.photo_selected);
                imageView.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(scaleAnimation3);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        imageView.startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.v != -1) {
            this.r.setBackground(getResources().getDrawable(R.drawable.shape_common_round_sara_a_solid));
        } else {
            this.r.setBackground(getResources().getDrawable(R.drawable.shape_common_round_hery_solid));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ChatHttpUtils.a(this.f30311a, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.find.fragment.FlashReportDialogFragment.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                FlashReportDialogFragment.this.a((int) R.string.biao_report_ok);
            }
        }, this.s, this.v, this.t, this.u, (IRequestHost) null);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f30311a = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.s = arguments.getString("uid");
            this.t = arguments.getString("roomId");
            this.u = arguments.getString("streamId");
        }
        setStyle(0, R.style.Theme_trans);
        if (AppInfo.p()) {
            StatusBarHelper.a((Activity) getActivity(), false);
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getArguments();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.flash_dialog_report, viewGroup, false);
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        DialogStateListener dialogStateListener = this.w;
        if (dialogStateListener != null) {
            dialogStateListener.b();
            this.w = null;
        }
        super.onDismiss(dialogInterface);
    }
}
