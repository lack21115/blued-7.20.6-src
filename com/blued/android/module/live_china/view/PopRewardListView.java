package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.RewardListAdapter;
import com.blued.android.module.live_china.contrast.LiveRewardDetailsContract;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IFollowView;
import com.blued.android.module.live_china.live_interface.IGrabRewardView;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.RewardDetailsCommonModel;
import com.blued.android.module.live_china.model.RewardErrorModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveKeyboardObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveRewardStatusObserver;
import com.blued.android.module.live_china.presenter.LiveFollowPresenter;
import com.blued.android.module.live_china.presenter.LiveGrabRewardPresenter;
import com.blued.android.module.live_china.presenter.LiveRewardDetailsPresenter;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRewardListView.class */
public class PopRewardListView implements View.OnClickListener, RenrenPullToRefreshListView.OnPullDownListener, LiveRewardDetailsContract.IView, IFollowView, IGrabRewardView, LiveKeyboardObserver.ILiveKeyboardObserver {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private TextView D;
    private FrameLayout E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private TextView I;
    private TextView J;
    private LinearLayout K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView O;
    private View P;
    private View Q;
    private ImageView R;
    private ImageView S;
    private SmCaptchaWebView T;
    private SmCaptchaWebView.ResultListener U;
    private SmCaptchaWebView.SmOption V;
    private String W;
    private View X;
    private View Y;
    private TextView Z;
    public View a;
    private View aa;
    private RewardListAdapter ab;
    private LiveRewardModel ac;
    private RewardDetailsCommonModel ad;
    private LiveRewardDetailsPresenter ae;
    private String af;
    private LiveRewardExtraModel ag;
    private OnPopEventCallBack ah;
    public LayoutInflater b;
    private View c;
    private View d;
    private Context e;
    private BaseFragment f;
    private RecordingOnliveFragment g;
    private PlayingOnliveBaseModeFragment h;
    private ActivityFragmentActive i;
    private boolean j;
    private long k;
    private MyPopupWindow l;
    private ImageView m;
    private RenrenPullToRefreshListView n;
    private ListView o;
    private LayoutInflater p;
    private View q;
    private View r;
    private ViewGroup s;
    private View t;
    private FrameLayout u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private TextView y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRewardListView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            if (PopRewardListView.this.f == null || PopRewardListView.this.f.getActivity() == null || PopRewardListView.this.f.getActivity().isFinishing()) {
                return;
            }
            super.dismiss();
            if (PopRewardListView.this.ah != null) {
                if (TextUtils.isEmpty(PopRewardListView.this.ac.pwd) || PopRewardListView.this.ac.hasPwdTip) {
                    PopRewardListView.this.ah.a(false);
                } else if (!PopRewardListView.this.ac.hasAgreePwd) {
                    PopRewardListView.this.ah.a(false);
                } else {
                    PopRewardListView.this.ac.hasPwdTip = true;
                    PopRewardListView.this.ah.a(true);
                }
            }
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopRewardListView.this.m();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRewardListView$OnPopEventCallBack.class */
    public interface OnPopEventCallBack {
        void a(boolean z);
    }

    public PopRewardListView(BaseFragment baseFragment, LiveRewardModel liveRewardModel) {
        this.f = baseFragment;
        this.e = baseFragment.getContext();
        this.ac = liveRewardModel;
        p();
        j();
        if (liveRewardModel.status == 2) {
            this.d.setVisibility(0);
            this.u.setVisibility(0);
            r();
        } else if (!this.j && liveRewardModel.status != 1) {
            if (TextUtils.isEmpty(this.ac.pwd) || this.ac.hasPwdTip) {
                n();
                return;
            }
            this.d.setVisibility(8);
            this.X.setVisibility(0);
            if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null) {
                return;
            }
            EventTrackLive.h(LiveProtos.Event.RED_BAG_GET_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.ac.pwd);
        } else {
            Logger.a("drb", "PopRewardListView 红包详情");
            this.d.setVisibility(0);
            this.s.setVisibility(0);
            this.u.setVisibility(8);
            this.t.setVisibility(0);
            this.E.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (LiveFloatManager.a().C()) {
                DensityUtils.a(this.e, 305.0f);
            } else {
                layoutParams.height = DensityUtils.a(this.e, 433.0f);
            }
            this.d.setLayoutParams(layoutParams);
            this.ae.b();
            if (this.j) {
                return;
            }
            if (liveRewardModel.is_prize == 1) {
                this.L.setText("1");
                this.H.setImageResource(R.drawable.live_reward_list_header_gift_icon);
            } else if (liveRewardModel.beans > 0.0d) {
                this.L.setText(CommonStringUtils.d(Double.toString(liveRewardModel.beans)));
                this.H.setImageResource(R.drawable.live_reward_list_header_bean_icon);
            }
        }
    }

    public PopRewardListView(BaseFragment baseFragment, LiveRewardModel liveRewardModel, LiveRewardListModel liveRewardListModel, RewardErrorModel rewardErrorModel) {
        this.f = baseFragment;
        this.e = baseFragment.getContext();
        this.ac = liveRewardModel;
        p();
        j();
        if (rewardErrorModel != null) {
            a(rewardErrorModel.throwable, rewardErrorModel.statusCode, rewardErrorModel.content);
        } else if (liveRewardListModel != null) {
            a(liveRewardListModel);
        } else {
            n();
        }
    }

    public static PopRewardListView a(BaseFragment baseFragment, LiveRewardModel liveRewardModel) {
        PopRewardListView popRewardListView = new PopRewardListView(baseFragment, liveRewardModel);
        popRewardListView.k();
        return popRewardListView;
    }

    public static PopRewardListView a(BaseFragment baseFragment, LiveRewardModel liveRewardModel, LiveRewardListModel liveRewardListModel, RewardErrorModel rewardErrorModel) {
        PopRewardListView popRewardListView = new PopRewardListView(baseFragment, liveRewardModel, liveRewardListModel, rewardErrorModel);
        popRewardListView.k();
        return popRewardListView;
    }

    private void p() {
        Context context = this.e;
        if (context == null) {
            return;
        }
        this.b = LayoutInflater.from(context);
        i();
        View findViewById = this.a.findViewById(R.id.tv_bg);
        this.c = findViewById;
        findViewById.setBackgroundColor(this.e.getResources().getColor(R.color.transparent));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRewardListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById2 = this.a.findViewById(R.id.ll_content);
        this.d = findViewById2;
        findViewById2.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRewardListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById3 = this.a.findViewById(R.id.ll_identify);
        this.Q = findViewById3;
        findViewById3.setVisibility(8);
        this.R = (ImageView) this.a.findViewById(R.id.iv_close);
        this.S = (ImageView) this.a.findViewById(R.id.sm_refresh);
        this.T = this.a.findViewById(R.id.sm_captch);
        this.Q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRewardListView.3
            @Override // java.lang.Runnable
            public void run() {
                PopRewardListView.this.s();
            }
        });
        this.X = this.a.findViewById(R.id.ll_word_tip);
        this.Y = this.a.findViewById(R.id.iv_word_tip_close);
        TextView textView = (TextView) this.a.findViewById(R.id.tv_word_tip_content);
        this.Z = textView;
        textView.setText(String.format(this.e.getString(R.string.live_reward_receive_content), this.ac.pwd));
        this.aa = this.a.findViewById(R.id.tv_word_tip_ok);
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.a, -1, -1, true);
        this.l = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.e.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.l.setTouchable(true);
        this.l.setOutsideTouchable(true);
        this.l.setFocusable(true);
        this.l.update();
        this.ab = new RewardListAdapter(this.f, this);
        this.p = (LayoutInflater) this.e.getSystemService("layout_inflater");
        this.m = (ImageView) this.a.findViewById(R.id.live_reward_close);
        this.n = (RenrenPullToRefreshListView) this.a.findViewById(R.id.live_reward_list);
        this.t = this.a.findViewById(R.id.live_reward_list_seat);
        this.s = (ViewGroup) this.a.findViewById(R.id.live_reward_title);
        this.n.setRefreshEnabled(false);
        this.n.setOnPullDownListener(this);
        ListView listView = (ListView) this.n.getRefreshableView();
        this.o = listView;
        listView.setDivider(null);
        this.o.setAdapter((ListAdapter) this.ab);
        this.q = (FrameLayout) this.p.inflate(R.layout.pop_reward_list_header, (ViewGroup) this.o, false);
        this.r = this.a.findViewById(R.id.pop_reward_list_footer);
        this.u = (FrameLayout) this.q.findViewById(R.id.reward_get_layout);
        this.v = (ImageView) this.q.findViewById(R.id.reward_get_bg);
        this.w = (ImageView) this.q.findViewById(R.id.reward_get_header);
        this.x = (ImageView) this.q.findViewById(R.id.reward_get_verify);
        this.y = (TextView) this.q.findViewById(R.id.reward_get_name);
        this.z = (TextView) this.q.findViewById(R.id.reward_get_follow_text);
        this.A = (LinearLayout) this.q.findViewById(R.id.reward_get_btn);
        this.B = (LinearLayout) this.q.findViewById(R.id.live_reward_get_loading);
        this.C = (LinearLayout) this.q.findViewById(R.id.live_reward_get_details_layout);
        this.D = (TextView) this.q.findViewById(R.id.reward_get_miss_text);
        this.E = (FrameLayout) this.q.findViewById(R.id.reward_detail_layout);
        this.F = (ImageView) this.q.findViewById(R.id.reward_detail_header);
        this.G = (ImageView) this.q.findViewById(R.id.reward_detail_verify);
        this.I = (TextView) this.q.findViewById(R.id.reward_detail_name);
        this.J = (TextView) this.q.findViewById(R.id.reward_detail_miss);
        this.K = (LinearLayout) this.q.findViewById(R.id.reward_detail_got);
        this.L = (TextView) this.q.findViewById(R.id.reward_detail_beans);
        this.H = (ImageView) this.q.findViewById(R.id.iv_gift_bens_icon);
        this.M = (TextView) this.q.findViewById(R.id.reward_detail_num);
        this.N = (TextView) this.q.findViewById(R.id.reward_detail_sum);
        this.O = (TextView) this.q.findViewById(R.id.reward_detail_time);
        this.P = this.q.findViewById(R.id.reward_detail__line);
        this.o.addHeaderView(this.q);
        this.m.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.aa.setOnClickListener(this);
        this.Y.setOnClickListener(this);
    }

    private void q() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(100L);
        ofFloat.start();
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.PopRewardListView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PopRewardListView.this.u.setVisibility(8);
            }
        });
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.e, 340.0f), DensityUtils.a(this.e, 433.0f));
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.PopRewardListView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = PopRewardListView.this.d.getLayoutParams();
                layoutParams.height = intValue;
                PopRewardListView.this.d.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
        this.s.setVisibility(0);
        this.t.setVisibility(0);
        this.E.setVisibility(0);
    }

    private void r() {
        this.D.setVisibility(0);
        this.C.setVisibility(0);
        this.J.setVisibility(0);
        this.K.setVisibility(8);
        this.A.setVisibility(8);
        this.z.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        String string = this.e.getString(R.string.biao_v1_lr_ver_sm_captcha);
        int a = DensityUtils.a(this.e, 300.0f);
        int i = (int) ((a / 300.0d) * 234.0d);
        ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
        layoutParams.width = a;
        layoutParams.height = i;
        this.T.setLayoutParams(layoutParams);
        SmCaptchaWebView.SmOption smOption = new SmCaptchaWebView.SmOption();
        this.V = smOption;
        smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
        this.V.setMode("slide");
        this.V.setAppId("1");
        this.V.setChannel(AppInfo.c);
        if (!BlueAppLocal.d()) {
            HashMap hashMap = new HashMap();
            hashMap.put("lang", "en");
            this.V.setExtOption(hashMap);
        }
        if (!TextUtils.isEmpty(string)) {
            this.V.setTipMessage(string);
        }
        this.T.setBackgroundColor(0);
        this.U = new SmCaptchaWebView.ResultListener() { // from class: com.blued.android.module.live_china.view.PopRewardListView.9
            public void onError(int i2) {
            }

            public void onReady() {
            }

            public void onSuccess(CharSequence charSequence, boolean z) {
                EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_CONFIRM, String.valueOf(PopRewardListView.this.k), PopRewardListView.this.af, z);
                PopRewardListView.this.W = charSequence.toString();
                Log.i("xpm", "onSuccess:" + PopRewardListView.this.W + "pass:" + z);
                if (!z) {
                    AppMethods.a((CharSequence) PopRewardListView.this.e.getString(R.string.live_reward_identify_fail), true);
                    return;
                }
                PopRewardListView popRewardListView = PopRewardListView.this;
                new LiveGrabRewardPresenter(popRewardListView, popRewardListView.i).a(PopRewardListView.this.ac.hongbao_id, PopRewardListView.this.k, PopRewardListView.this.W, PopRewardListView.this.ac.pwd);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.T.initWithOption(this.V, this.U);
        int i = SmCaptchaWebView.SMCAPTCHA_SUCCESS;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
    public void a() {
    }

    @Override // com.blued.android.module.live_china.contrast.LiveRewardDetailsContract.IView
    public void a(LiveRewardExtraModel liveRewardExtraModel) {
        this.ag = liveRewardExtraModel;
        if (this.j) {
            this.L.setText(CommonStringUtils.d(Double.toString(liveRewardExtraModel.total_beans)));
            this.N.setText(String.format(this.e.getString(R.string.live_reward_got_num), CommonStringUtils.d(Double.toString(liveRewardExtraModel.grab_beans)), CommonStringUtils.d(Double.toString(liveRewardExtraModel.total_beans))));
            this.M.setText(String.format(this.e.getString(R.string.live_reward_got_num), liveRewardExtraModel.grab_count + "", liveRewardExtraModel.total_count + ""));
        } else {
            this.M.setText(String.format(this.e.getString(R.string.live_reward_get_num), liveRewardExtraModel.grab_count + "", liveRewardExtraModel.total_count + ""));
        }
        if (liveRewardExtraModel.has_grabbed == 1) {
            this.O.setText(String.format(this.e.getString(R.string.live_reward_got_secound), liveRewardExtraModel.total_time + ""));
        }
        this.ab.a(liveRewardExtraModel.lucky_uid);
    }

    @Override // com.blued.android.module.live_china.live_interface.IGrabRewardView
    public void a(LiveRewardListModel liveRewardListModel) {
        Logger.a("rrrb", "抢红包完成 onGrabRewardComplete model = ", liveRewardListModel);
        this.B.setVisibility(8);
        if (liveRewardListModel != null) {
            if (liveRewardListModel.beans > 0.0d || liveRewardListModel.is_prize == 1) {
                if (liveRewardListModel.is_prize == 1) {
                    this.L.setText("1");
                    this.H.setImageResource(R.drawable.live_reward_list_header_gift_icon);
                } else if (liveRewardListModel.beans > 0.0d) {
                    this.L.setText(CommonStringUtils.d(Double.toString(liveRewardListModel.beans)));
                    this.H.setImageResource(R.drawable.live_reward_list_header_bean_icon);
                }
                this.ac.beans = liveRewardListModel.beans;
                this.ac.is_prize = liveRewardListModel.is_prize;
                if (LiveFloatManager.a().C()) {
                    this.u.setVisibility(8);
                    this.s.setVisibility(0);
                    this.t.setVisibility(0);
                    this.E.setVisibility(0);
                } else {
                    q();
                }
                this.ae.b();
                LiveRewardStatusObserver.a().a(1);
            } else {
                Logger.a("rrrb", "抢红包完成 showAlreadyGoneView");
                r();
                LiveRewardStatusObserver.a().a(2);
            }
        }
        if (this.Q.getVisibility() == 0) {
            EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_CONFIRM_RED_RESULT, String.valueOf(this.k), this.af, true);
        }
        this.d.setVisibility(0);
        this.Q.setVisibility(8);
    }

    public void a(OnPopEventCallBack onPopEventCallBack) {
        this.ah = onPopEventCallBack;
    }

    @Override // com.blued.android.module.live_china.live_interface.IFollowView
    public void a(String str, String str2) {
        Logger.a("rrrb", "关注结束 onFollowComplete");
        if (CommonStringUtils.c(str) != LiveRoomManager.a().f()) {
            Logger.a("rrrb", "关注结束 uid不同");
        } else if (!"1".equals(str2) && !"3".equals(str2)) {
            Logger.a("rrrb", "关注结束 状态不对");
        } else {
            LiveMsgSendManager.a().k();
            LiveRelationshipObserver.a().a(str2, str);
            new LiveGrabRewardPresenter(this, this.i).a(this.ac.hongbao_id, this.k, "", this.ac.pwd);
            Logger.a("rrrb", "关注结束 开始抢红包");
        }
    }

    @Override // com.blued.android.module.live_china.live_interface.IGrabRewardView
    public void a(Throwable th, int i, String str) {
        if (this.Q.getVisibility() == 0) {
            EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_CONFIRM_RED_RESULT, String.valueOf(this.k), this.af, false);
        }
        this.B.setVisibility(8);
        Pair<Integer, String> a = BluedHttpUtils.a(th, i, str);
        if (((Integer) a.first).intValue() == 4032014) {
            this.u.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.d.setVisibility(0);
            this.Q.setVisibility(8);
        } else if (((Integer) a.first).intValue() == 4032015) {
            m();
            AppMethods.a((CharSequence) this.e.getString(R.string.live_live_receive_conditions_toast), true);
        } else if (((Integer) a.first).intValue() == 4032021) {
            EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_SHOW, String.valueOf(this.k), this.af);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRewardListView.8
                @Override // java.lang.Runnable
                public void run() {
                    PopRewardListView.this.d.setVisibility(8);
                    PopRewardListView.this.Q.setVisibility(0);
                    PopRewardListView.this.t();
                }
            }, 300L);
        } else if (((Integer) a.first).intValue() == 4032022) {
            this.d.setVisibility(8);
            this.Q.setVisibility(0);
            this.T.reloadCaptcha();
            AppMethods.a((CharSequence) this.e.getString(R.string.live_reward_identify_fail), true);
        } else {
            Logger.a("rrrb", "抢红包失败 onGrabRewardFailed");
            if (this.Q.getVisibility() == 0) {
                n();
            } else {
                m();
            }
            BluedHttpUtils.b(th, i, str);
        }
    }

    @Override // com.blued.android.module.live_china.contrast.LiveRewardDetailsContract.IView
    public void a(List<LiveRewardListModel> list, boolean z) {
        Logger.a("rrrb", "红包详情 notifyListUpdate");
        this.d.setVisibility(0);
        if (list == null) {
            Logger.a("rrrb", "红包详情 notifyListUpdate = null");
            this.ab.notifyDataSetChanged();
            return;
        }
        Logger.a("rrrb", "红包详情 notifyListUpdate = ", Integer.valueOf(list.size()));
        if (z) {
            this.ab.b(list);
            return;
        }
        if (this.j) {
            InstantLog.a("view_history_from_red_envelope", 1);
        } else {
            InstantLog.a("view_history_from_red_envelope", 0);
        }
        this.ab.a(list);
    }

    @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
    public void b() {
        this.ad.page++;
        LiveRewardExtraModel liveRewardExtraModel = this.ag;
        if (liveRewardExtraModel != null) {
            this.ad.last_record_id = liveRewardExtraModel.last_record_id;
        }
        this.ae.b();
    }

    @Override // com.blued.android.module.live_china.contrast.LiveRewardDetailsContract.IView
    public void c() {
        this.n.p();
    }

    @Override // com.blued.android.module.live_china.contrast.LiveRewardDetailsContract.IView
    public void d() {
        this.n.q();
    }

    @Override // com.blued.android.module.live_china.contrast.LiveRewardDetailsContract.IView
    public void e() {
        this.n.o();
    }

    @Override // com.blued.android.module.live_china.live_interface.IGrabRewardView
    public void f() {
        this.B.setVisibility(0);
    }

    @Override // com.blued.android.module.live_china.observer.LiveKeyboardObserver.ILiveKeyboardObserver
    public void g() {
        m();
    }

    @Override // com.blued.android.module.live_china.observer.LiveKeyboardObserver.ILiveKeyboardObserver
    public void h() {
    }

    public void i() {
        if (this.e == null) {
            return;
        }
        if (LiveFloatManager.a().C()) {
            this.a = this.b.inflate(R.layout.pop_reward_list_center, (ViewGroup) null);
        } else {
            this.a = this.b.inflate(R.layout.pop_reward_list, (ViewGroup) null);
        }
    }

    public void j() {
        if (LiveRoomManager.a().p() != null && LiveRoomManager.a().p().profile != null) {
            this.af = LiveRoomManager.a().g();
        }
        BaseFragment baseFragment = this.f;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.j = true;
            RecordingOnliveFragment recordingOnliveFragment = (RecordingOnliveFragment) baseFragment;
            this.g = recordingOnliveFragment;
            this.i = recordingOnliveFragment.getFragmentActive();
            this.k = this.g.t;
            this.r.setVisibility(0);
            this.I.setText(String.format(this.e.getString(R.string.live_reward_master_name), LiveRoomInfo.a().c()));
            ImageLoader.a((IRequestHost) null, LiveRoomInfo.a().d()).b(R.drawable.user_bg_round).c().a(this.F);
            LiveRoomInfo.a().a(this.G, LiveRoomInfo.a().u());
        } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            this.j = false;
            PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = (PlayingOnliveBaseModeFragment) baseFragment;
            this.h = playingOnliveBaseModeFragment;
            this.i = playingOnliveBaseModeFragment.getFragmentActive();
            this.k = this.h.s;
            if (!LiveRoomManager.a().t()) {
                this.y.setText(String.format(this.e.getString(R.string.live_reward_master_name), LiveRoomManager.a().p().profile.name));
                this.I.setText(String.format(this.e.getString(R.string.live_reward_master_name), LiveRoomManager.a().p().profile.name));
                ImageLoader.a((IRequestHost) null, LiveRoomManager.a().p().profile.avatar).b(R.drawable.user_bg_round).c().a(this.w);
                ImageLoader.a((IRequestHost) null, LiveRoomManager.a().p().profile.avatar).b(R.drawable.user_bg_round).c().a(this.F);
                LiveRoomInfo.a().a(this.x, LiveRoomManager.a().p().profile.vbadge);
                LiveRoomInfo.a().a(this.G, LiveRoomManager.a().p().profile.vbadge);
            }
        }
        RewardDetailsCommonModel rewardDetailsCommonModel = new RewardDetailsCommonModel();
        this.ad = rewardDetailsCommonModel;
        this.ae = new LiveRewardDetailsPresenter(this.e, this, this.i, rewardDetailsCommonModel, String.valueOf(this.ac.hongbao_id), this.k);
        LiveKeyboardObserver.a().a(this);
    }

    public void k() {
        this.c.clearAnimation();
        this.d.clearAnimation();
        if (this.l.isShowing()) {
            this.l.a();
        }
        this.l.showAtLocation(this.d, 81, 0, 0);
        l();
    }

    public void l() {
        this.d.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.push_center_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopRewardListView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.c.startAnimation(alphaAnimation);
    }

    public void m() {
        LiveKeyboardObserver.a().b(this);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRewardListView.5
            @Override // java.lang.Runnable
            public void run() {
                PopRewardListView.this.l.a();
            }
        }, 320L);
        o();
        this.d.setVisibility(8);
    }

    public void n() {
        LiveKeyboardObserver.a().b(this);
        this.l.a();
    }

    public void o() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.c.startAnimation(alphaAnimation);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.push_center_out));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_reward_close) {
            m();
        } else if (view.getId() == R.id.reward_get_btn) {
            if (LiveRoomManager.a().t()) {
                return;
            }
            f();
            new LiveFollowPresenter(this, this.i, this.k).a(LiveRoomManager.a().g());
        } else if (view.getId() == R.id.live_reward_get_details_layout) {
            if (LiveFloatManager.a().C()) {
                this.u.setVisibility(8);
                this.s.setVisibility(0);
                this.t.setVisibility(0);
                this.E.setVisibility(0);
            } else {
                q();
            }
            this.ae.b();
        } else if (view.getId() == R.id.iv_close) {
            AppMethods.a((CharSequence) this.e.getString(R.string.live_reward_identify_fail), true);
            n();
        } else if (view.getId() == R.id.sm_refresh) {
            t();
        } else if (view.getId() == R.id.iv_word_tip_close) {
            EventTrackLive.h(LiveProtos.Event.RED_BAG_GET_POP_CANCEL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.ac.pwd);
            this.ac.hasAgreePwd = false;
            m();
        } else if (view.getId() == R.id.tv_word_tip_ok) {
            EventTrackLive.h(LiveProtos.Event.RED_BAG_GET_POP_CONFIRM_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.ac.pwd);
            this.ac.hasAgreePwd = true;
            m();
        }
    }
}
