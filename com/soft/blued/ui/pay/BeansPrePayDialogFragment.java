package com.soft.blued.ui.pay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.fragment.LiveHalfWebDialogFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LivePayChargeAdItemModel;
import com.blued.android.module.live_china.model.LivePayChargeAdModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveVIPModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.live.adapter.LivePrePayViewPagerAdapter;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.TypefaceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/BeansPrePayDialogFragment.class */
public class BeansPrePayDialogFragment extends BottomSheetDialogFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public View f19256a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f19257c;
    private String d;
    private String e;
    private LiveChargeCouponModel f;
    private RelativeLayout g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private ViewPager l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private RelativeLayout p;
    private PayOption q;
    private List<PayOption._pay_list> r;
    private LivePrePayViewPagerAdapter s;
    private final float t;
    private boolean u;
    private LiveHalfWebDialogFragment v;

    public BeansPrePayDialogFragment() {
        this.b = 0;
        this.f19257c = 0;
        this.d = "";
        this.e = "";
        this.t = 0.42f;
        this.u = false;
    }

    public BeansPrePayDialogFragment(Context context, int i, int i2, String str) {
        this.b = 0;
        this.f19257c = 0;
        this.d = "";
        this.e = "";
        this.t = 0.42f;
        this.u = false;
        this.b = i;
        this.f19257c = i2;
        this.d = str;
    }

    public BeansPrePayDialogFragment(Context context, int i, LiveChargeCouponModel liveChargeCouponModel) {
        this.b = 0;
        this.f19257c = 0;
        this.d = "";
        this.e = "";
        this.t = 0.42f;
        this.u = false;
        this.b = i;
        this.f = liveChargeCouponModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        String str;
        Tracker.onClick(view);
        LivePrePayViewPagerAdapter livePrePayViewPagerAdapter = this.s;
        if (livePrePayViewPagerAdapter == null || livePrePayViewPagerAdapter.f17411a == null || this.r == null) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_PAGE_NOW_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), (int) this.s.f17411a.money, (int) (this.s.f17411a.money * this.s.f17411a.ratio));
        this.s.f17411a.choosed = false;
        if (k()) {
            final int i = (int) this.s.f17411a.money;
            if (TextUtils.isEmpty(this.d)) {
                int i2 = this.b;
                str = i2 == 7 ? "yy_chat" : (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8 || i2 == 10 || i2 == 9 || i2 == 6) ? "experiment_p" : "";
            } else {
                str = this.d;
            }
            LiveChargeCouponModel liveChargeCouponModel = this.f;
            if (liveChargeCouponModel != null) {
                liveChargeCouponModel.realPayMoney = i;
                final String str2 = str;
                PayHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<CountModel>>(a()) { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                        Context context = BeansPrePayDialogFragment.this.getContext();
                        BluedURIRouterAdapter.startVIPPay(context, BeansPrePayDialogFragment.this.s.f17411a.id + "", "", "", "", BeansPrePayDialogFragment.this.p(), str2, i, BeansPrePayDialogFragment.this.f);
                    }
                }, this.f.id, i, (IRequestHost) a());
                return;
            }
            Context context = getContext();
            BluedURIRouterAdapter.startVIPPay(context, this.s.f17411a.id + "", "", "", "", p(), str, (int) this.s.f17411a.money);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, final View view2) {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || !this.u) {
            return;
        }
        this.u = false;
        view.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BeansPrePayDialogFragment.this.g.removeView(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, final View view2, View view3) {
        Tracker.onClick(view3);
        if (view.getAlpha() < 0.95d || !this.u) {
            return;
        }
        this.u = false;
        view.setClickable(false);
        view.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BeansPrePayDialogFragment.this.g.removeView(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b(final View view, final View view2, View view3, View view4) {
        this.u = true;
        LiveRoomPreferences.g();
        view2.animate().alpha(1.0f).setDuration(300L);
        view4.animate().translationX(0 - view3.getWidth()).setDuration(2000L).setInterpolator(new DecelerateInterpolator(2.0f));
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$kXxwtRSfqIV_RHil0Bx60TdKRwE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                BeansPrePayDialogFragment.this.a(view2, view, view5);
            }
        });
        a(new Runnable() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$lHUQS7W5K7zNiUWLF7SgykqIZVY
            @Override // java.lang.Runnable
            public final void run() {
                BeansPrePayDialogFragment.this.a(view2, view);
            }
        }, m.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PayOption._pay_list _pay_listVar) {
        this.n.setText(getContext().getString(R.string.live_pre_pay_btn, CommonStringUtils.a(_pay_listVar.money)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        EventTrackLive.s(LiveProtos.Event.LIVE_EXCHANGE_PAGE_BANNER_SHOW, LiveRoomManager.a().g(), LiveRoomManager.a().e(), str);
        final ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(a()).a(str).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.5
            public void onUIFinish(File file, Exception exc) {
                if (file == null || !file.exists() || imageSize.a() <= 0) {
                    return;
                }
                int a2 = (int) ((((AppInfo.l - DensityUtils.a(AppInfo.d(), 20.0f)) * imageSize.b()) * 1.0f) / imageSize.a());
                ViewGroup.LayoutParams layoutParams = BeansPrePayDialogFragment.this.h.getLayoutParams();
                layoutParams.width = AppInfo.l - DensityUtils.a(AppInfo.d(), 20.0f);
                layoutParams.height = a2;
                BeansPrePayDialogFragment.this.h.setLayoutParams(layoutParams);
                ImageLoader.a(BeansPrePayDialogFragment.this.a(), str).a(BeansPrePayDialogFragment.this.h);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        LivePrePayViewPagerAdapter livePrePayViewPagerAdapter = new LivePrePayViewPagerAdapter(getContext(), this.r, i, this.f, new LivePrePayViewPagerAdapter.SelectModelCallBack() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$_5JoC0ogO5iP4o4BwSNEAK2IOEI
            @Override // com.soft.blued.ui.live.adapter.LivePrePayViewPagerAdapter.SelectModelCallBack
            public final void selectModel(PayOption._pay_list _pay_listVar) {
                BeansPrePayDialogFragment.this.a(_pay_listVar);
            }
        });
        this.s = livePrePayViewPagerAdapter;
        this.l.setAdapter(livePrePayViewPagerAdapter);
        this.l.setCurrentItem(i / 6);
        n();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final View view) {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing()) {
            return;
        }
        final View findViewById = view.findViewById(2131369389);
        final View findViewById2 = view.findViewById(R.id.view_shadow);
        final View findViewById3 = view.findViewById(R.id.view_hand);
        findViewById.post(new Runnable() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$MirS0IwGGM2PvuUEK4o6ShnjN_A
            @Override // java.lang.Runnable
            public final void run() {
                BeansPrePayDialogFragment.this.b(view, findViewById, findViewById2, findViewById3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(getContext(), H5Url.a(13), 0);
    }

    private void m() {
        this.g = (RelativeLayout) this.f19256a.findViewById(2131369389);
        this.h = (ImageView) this.f19256a.findViewById(2131365719);
        this.i = (TextView) this.f19256a.findViewById(R.id.tv_balance_title);
        this.j = (TextView) this.f19256a.findViewById(R.id.tv_balance);
        this.l = (ViewPager) this.f19256a.findViewById(R.id.vp_pre_pay);
        this.m = (LinearLayout) this.f19256a.findViewById(R.id.view_indicator);
        this.n = (TextView) this.f19256a.findViewById(R.id.tv_pre_pay);
        this.o = (TextView) this.f19256a.findViewById(R.id.tv_agreement);
        this.p = (RelativeLayout) this.f19256a.findViewById(R.id.loading);
        this.k = (ImageView) this.f19256a.findViewById(R.id.iv_vip);
        a(false);
        h();
        i();
        this.n.getPaint().setFakeBoldText(true);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$0L2lyWm6dTT7wPOUJS_AceKYZg8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeansPrePayDialogFragment.this.a(view);
            }
        });
        o();
        VIPBuyResultObserver.a().a(this);
        LiveEventBus.get("live_activity_pos").post("pay_dlg_show");
    }

    private void n() {
        this.m.removeAllViews();
        int count = this.s.getCount();
        if (count == 0) {
            return;
        }
        int a2 = DensityUtils.a(getContext(), 5.0f);
        int i = a2 / 2;
        int i2 = 0;
        this.m.setPadding(i, 0, i, 0);
        while (i2 < count) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.bg_pre_pay_indicator_dot);
            view.setAlpha(i2 == this.l.getCurrentItem() ? 1.0f : 0.42f);
            this.m.addView(view);
            i2++;
        }
        this.l.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.6
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                if (i3 >= BeansPrePayDialogFragment.this.m.getChildCount()) {
                    return;
                }
                float f2 = ((1.0f - f) * 0.58000004f) + 0.42f;
                BeansPrePayDialogFragment.this.m.getChildAt(i3).setAlpha(f2);
                int i5 = i3 + 1;
                if (i5 < BeansPrePayDialogFragment.this.m.getChildCount()) {
                    BeansPrePayDialogFragment.this.m.getChildAt(i5).setAlpha(1.42f - f2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= BeansPrePayDialogFragment.this.m.getChildCount()) {
                        return;
                    }
                    if (i5 != i3) {
                        BeansPrePayDialogFragment.this.m.getChildAt(i5).setAlpha(0.42f);
                    } else {
                        BeansPrePayDialogFragment.this.m.getChildAt(i5).setAlpha(1.0f);
                    }
                    i4 = i5 + 1;
                }
            }
        });
    }

    private void o() {
        String string = getString(R.string.live_pre_pay_agreement_title);
        String string2 = getString(R.string.live_pre_pay_agreement_url_title);
        TextView textView = this.o;
        textView.setText(string + string2);
        int length = string.length();
        int length2 = string2.length() + length;
        TypefaceUtils.a(getContext(), this.o, new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$Qm1fln230EfBuLyfJQKxJHQk9RM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeansPrePayDialogFragment.this.c(view);
            }
        }, new TypefaceUtils.SpannIndex(length, length2), new TypefaceUtils.SpannIndex(length, length2), false, getContext().getResources().getColor(2131101852));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        switch (this.b) {
            case 0:
                return "";
            case 1:
            case 6:
            default:
                return "my";
            case 2:
                return "live";
            case 3:
            case 10:
                return "gift";
            case 4:
            case 9:
                return "live_btn";
            case 5:
                return "package";
            case 7:
                return "yy_chat";
            case 8:
                return "live_first_charge";
        }
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || i != 1 || !z) {
            return;
        }
        if (this.f != null) {
            LiveEventBusUtil.c();
        } else {
            AppMethods.a(getResources().getString(R.string.Live_setting_rechargeSuccess));
        }
        a(true);
    }

    public void a(final boolean z) {
        MineHttpUtils.d((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(a()) { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0 || bluedEntityA.data.get(0) == null) {
                    return;
                }
                PayRemaining payRemaining = (PayRemaining) bluedEntityA.data.get(0);
                UserInfo.getInstance().setUserPrice(payRemaining.beans);
                LiveDataManager.a().a(payRemaining);
                if (z) {
                    LiveEventBusUtil.a(true, 0, (String) null);
                    LiveEventBus.get("gold_remain_result").post(bluedEntityA.getSingleData());
                }
                if (BeansPrePayDialogFragment.this.getActivity() == null || BeansPrePayDialogFragment.this.getActivity().isFinishing() || BeansPrePayDialogFragment.this.getDialog() == null || !BeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    return;
                }
                BeansPrePayDialogFragment.this.j.setText(String.valueOf(payRemaining.beans + payRemaining.bonus));
                BeansPrePayDialogFragment.this.i.setVisibility(0);
                BeansPrePayDialogFragment.this.j.setVisibility(0);
                if (z) {
                    BeansPrePayDialogFragment.this.dismissAllowingStateLoss();
                }
            }

            public boolean onUIFailure(int i, String str) {
                if (z && BeansPrePayDialogFragment.this.getActivity() != null && !BeansPrePayDialogFragment.this.getActivity().isFinishing() && BeansPrePayDialogFragment.this.getDialog() != null && BeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    BeansPrePayDialogFragment.this.dismissAllowingStateLoss();
                }
                return super.onUIFailure(i, str);
            }

            public void onUIStart() {
            }
        }, (IRequestHost) a());
    }

    public void dismiss() {
        super.dismissAllowingStateLoss();
        VIPBuyResultObserver.a().b(this);
    }

    public boolean e() {
        return true;
    }

    public int g() {
        return R.style.main_menu_animstyle;
    }

    public void h() {
        int i = this.b;
        PayHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<PayOption>>(a()) { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayOption> bluedEntityA) {
                int i2;
                BeansPrePayDialogFragment beansPrePayDialogFragment;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0 || bluedEntityA.data.get(0) == null) {
                    return;
                }
                BeansPrePayDialogFragment.this.e = ((PayOption) bluedEntityA.data.get(0)).banner_url;
                if (!TextUtils.isEmpty(BeansPrePayDialogFragment.this.e)) {
                    if (BeansPrePayDialogFragment.this.b == 8) {
                        BeansPrePayDialogFragment.this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.2.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                BeansPrePayDialogFragment.this.dismissAllowingStateLoss();
                            }
                        });
                    } else {
                        BeansPrePayDialogFragment beansPrePayDialogFragment2 = BeansPrePayDialogFragment.this;
                        beansPrePayDialogFragment2.a(beansPrePayDialogFragment2.e);
                        BeansPrePayDialogFragment.this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.2.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                EventTrackLive.s(LiveProtos.Event.LIVE_EXCHANGE_PAGE_BANNER_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), BeansPrePayDialogFragment.this.e);
                                LiveRouteUtil.a(BeansPrePayDialogFragment.this, BeansPrePayDialogFragment.this.a(), 0, false, 10020);
                            }
                        });
                    }
                }
                if (((PayOption) bluedEntityA.data.get(0)).pay_list == null || ((PayOption) bluedEntityA.data.get(0)).pay_list.size() == 0) {
                    return;
                }
                if (BeansPrePayDialogFragment.this.r == null) {
                    BeansPrePayDialogFragment.this.r = new ArrayList();
                } else {
                    BeansPrePayDialogFragment.this.r.clear();
                }
                BeansPrePayDialogFragment.this.q = (PayOption) bluedEntityA.data.get(0);
                BeansPrePayDialogFragment.this.r.addAll(BeansPrePayDialogFragment.this.q.pay_list);
                int i3 = -1;
                if (BeansPrePayDialogFragment.this.r != null) {
                    i3 = -1;
                    if (BeansPrePayDialogFragment.this.r.size() > 0) {
                        int i4 = 0;
                        while (true) {
                            i2 = i4;
                            if (i2 >= BeansPrePayDialogFragment.this.r.size()) {
                                i2 = -1;
                                break;
                            } else if (BeansPrePayDialogFragment.this.f != null) {
                                if (((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i2)).money >= BeansPrePayDialogFragment.this.f.threshold) {
                                    break;
                                }
                                i4 = i2 + 1;
                            } else if (BeansPrePayDialogFragment.this.f19257c > 0) {
                                if (((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i2)).money * ((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i2)).ratio >= BeansPrePayDialogFragment.this.f19257c) {
                                    break;
                                }
                                i4 = i2 + 1;
                            } else if (((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i2)).is_selected == 1) {
                                break;
                            } else {
                                i4 = i2 + 1;
                            }
                        }
                        int i5 = i2;
                        if (i2 == -1) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                i5 = i2;
                                if (i7 >= BeansPrePayDialogFragment.this.r.size()) {
                                    break;
                                } else if (((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i7)).money == 10.0d) {
                                    i5 = i7;
                                    break;
                                } else {
                                    i6 = i7 + 1;
                                }
                            }
                        }
                        int i8 = i5 == -1 ? 0 : i5;
                        if (BeansPrePayDialogFragment.this.f != null) {
                            PayOption._pay_list _pay_listVar = (PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(BeansPrePayDialogFragment.this.r.size() - 1);
                            i3 = i8;
                            if (i8 == 0) {
                                i3 = i8;
                                if (BeansPrePayDialogFragment.this.f.threshold > _pay_listVar.money) {
                                    i3 = BeansPrePayDialogFragment.this.r.size() - 1;
                                }
                            }
                            BeansPrePayDialogFragment.this.f19257c = (int) (beansPrePayDialogFragment.f.threshold * ((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i3)).ratio);
                        } else {
                            i3 = i8;
                            if (BeansPrePayDialogFragment.this.f19257c > 0) {
                                PayOption._pay_list _pay_listVar2 = (PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(BeansPrePayDialogFragment.this.r.size() - 1);
                                i3 = i8;
                                if (i8 == 0) {
                                    i3 = i8;
                                    if (BeansPrePayDialogFragment.this.f19257c > _pay_listVar2.money * _pay_listVar2.ratio) {
                                        i3 = BeansPrePayDialogFragment.this.r.size() - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                if (BeansPrePayDialogFragment.this.r.size() > i3) {
                    BeansPrePayDialogFragment.this.n.setText(BeansPrePayDialogFragment.this.getContext().getString(R.string.live_pre_pay_btn, CommonStringUtils.a(((PayOption._pay_list) BeansPrePayDialogFragment.this.r.get(i3)).money)));
                }
                BeansPrePayDialogFragment.this.b(i3);
            }

            public boolean onUIFailure(int i2, String str) {
                return super.onUIFailure(i2, str);
            }

            public void onUIFinish() {
                if (BeansPrePayDialogFragment.this.getActivity() == null || BeansPrePayDialogFragment.this.getActivity().isFinishing() || BeansPrePayDialogFragment.this.getDialog() == null || !BeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    return;
                }
                super.onUIFinish();
                BeansPrePayDialogFragment.this.p.setVisibility(8);
                if (TextUtils.isEmpty(BeansPrePayDialogFragment.this.e)) {
                    BeansPrePayDialogFragment.this.j();
                }
            }

            public void onUIStart() {
                if (BeansPrePayDialogFragment.this.getActivity() == null || BeansPrePayDialogFragment.this.getActivity().isFinishing() || BeansPrePayDialogFragment.this.getDialog() == null || !BeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    return;
                }
                super.onUIStart();
                BeansPrePayDialogFragment.this.p.setVisibility(0);
            }
        }, (IRequestHost) a(), "beans", (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 10 || i == 9 || i == 6) ? "live" : "");
    }

    public void i() {
        PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveVIPModel>>(a()) { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveVIPModel> bluedEntityA) {
                if (bluedEntityA.getSingleData() != null) {
                    if (!((LiveVIPModel) bluedEntityA.data.get(0)).is_enable()) {
                        BeansPrePayDialogFragment.this.k.setVisibility(8);
                        return;
                    }
                    BeansPrePayDialogFragment.this.k.setVisibility(0);
                    ImageLoader.c(BeansPrePayDialogFragment.this.a(), "live_charge_vip.png").f().g(-1).a(BeansPrePayDialogFragment.this.k);
                    final String link = ((LiveVIPModel) bluedEntityA.data.get(0)).getLink();
                    final int link_type = ((LiveVIPModel) bluedEntityA.data.get(0)).getLink_type();
                    BeansPrePayDialogFragment.this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                            if (TextUtils.isEmpty(link) || ClickUtils.a(view.getId())) {
                                return;
                            }
                            LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
                            liveRoomFunctionItemModel.setLink_type(link_type);
                            liveRoomFunctionItemModel.setLink(link);
                            LiveEventBus.get(LiveEventBusUtil.C).postDelay(liveRoomFunctionItemModel, 200L);
                        }
                    });
                }
            }

            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        });
    }

    public void j() {
        LiveHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LivePayChargeAdModel>>(a()) { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LivePayChargeAdModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0) == null || ((LivePayChargeAdModel) bluedEntityA.data.get(0)).get_9002() == null || ((LivePayChargeAdModel) bluedEntityA.data.get(0)).get_9002().size() <= 0 || ((LivePayChargeAdModel) bluedEntityA.data.get(0)).get_9002().get(0) == null) {
                    BeansPrePayDialogFragment.this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.4.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            BeansPrePayDialogFragment.this.dismissAllowingStateLoss();
                        }
                    });
                    return;
                }
                final LivePayChargeAdItemModel livePayChargeAdItemModel = (LivePayChargeAdItemModel) ((LivePayChargeAdModel) bluedEntityA.data.get(0)).get_9002().get(0);
                if (livePayChargeAdItemModel != null) {
                    FindHttpUtils.b(livePayChargeAdItemModel.getShow_url());
                    BeansPrePayDialogFragment.this.a(livePayChargeAdItemModel.getBanner_pic());
                    BeansPrePayDialogFragment.this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayDialogFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            EventTrackLive.s(LiveProtos.Event.LIVE_EXCHANGE_PAGE_BANNER_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), livePayChargeAdItemModel.getId());
                            String target_url = livePayChargeAdItemModel.getTarget_url();
                            if (TextUtils.isEmpty(target_url)) {
                                return;
                            }
                            FindHttpUtils.b(livePayChargeAdItemModel.getClick_url());
                            LiveSetDataObserver.a().b(target_url, 25);
                        }
                    });
                }
            }

            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, a());
    }

    public boolean k() {
        return true;
    }

    public void l() {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || !LiveRoomPreferences.f() || this.u) {
            return;
        }
        final View inflate = getActivity().getLayoutInflater().inflate(R.layout.live_pre_pay_guide, (ViewGroup) null);
        this.g.addView(inflate);
        a(new Runnable() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayDialogFragment$C4buf-FXd6l_s_6ler7cpSQx26A
            @Override // java.lang.Runnable
            public final void run() {
                BeansPrePayDialogFragment.this.b(inflate);
            }
        }, 500L);
    }

    public void onDestroy() {
        Dialog dialog;
        super.onDestroy();
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = this.v;
        if (liveHalfWebDialogFragment != null && (dialog = liveHalfWebDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.v.dismissAllowingStateLoss();
        }
        LiveEventBus.get("live_activity_pos").post("pay_dlg_hide");
        LiveEventBus.get("live_tans_activity").post(true);
    }

    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        dialog.requestWindowFeature(1);
        dialog.getContext().setTheme(R.style.transparentFrameWindowStyleLive);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        this.f19256a = getActivity().getLayoutInflater().inflate(R.layout.dialog_pre_pay, (ViewGroup) null);
        dialog.setContentView(this.f19256a, new ViewGroup.LayoutParams(-1, DensityUtils.a(getContext(), 440.0f)));
        m();
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_PAGE_SHOW, LiveRoomManager.a().g(), LiveRoomManager.a().e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
