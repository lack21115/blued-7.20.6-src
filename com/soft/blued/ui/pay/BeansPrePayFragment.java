package com.soft.blued.ui.pay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.BluedLoginResultVerBinding;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.ListViewForScroll;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.model.LiveCouponCountExtra;
import com.blued.android.module.live_china.model.LiveCouponNoticeExtra;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/BeansPrePayFragment.class */
public class BeansPrePayFragment extends SimpleFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f32966a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f32967c;
    private View d;
    private TextView e;
    private ImageView f;
    private View g;
    private ListViewForScroll i;
    private CommonAdapter j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private LinearLayout p;
    private TextView q;
    private int r;
    private List<PayOption._pay_list> h = new ArrayList();
    private String s = "my";
    private String t = "";

    public static void a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, BeansPrePayFragment.class, bundle);
    }

    public static void a(Context context, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        bundle.putString("details", str);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, BeansPrePayFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(getActivity(), H5Url.a(2), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    private void d() {
        this.j = new CommonAdapter<PayOption._pay_list>(R.layout.item_pay_options) { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.2
            @Override // com.blued.android.module.common.adapter.CommonAdapter
            public void a(CommonAdapter.ViewHolder viewHolder, final PayOption._pay_list _pay_listVar, final int i) {
                String a2;
                if (DeviceUtils.f()) {
                    a2 = StringUtils.a(_pay_listVar.pretax + "");
                } else {
                    a2 = StringUtils.a(((int) _pay_listVar.money) + "");
                }
                CommonAdapter.ViewHolder a3 = viewHolder.a(R.id.tv_rmb, a2 + BeansPrePayFragment.this.getString(2131886086));
                a3.a(2131372944, StringUtils.a(((int) (_pay_listVar.money * _pay_listVar.ratio)) + ""));
                if (_pay_listVar.bonus > 0.0f) {
                    CommonAdapter.ViewHolder b = viewHolder.b(2131371388, 0);
                    String string = BeansPrePayFragment.this.getString(R.string.present_free_beans);
                    b.a(2131371388, String.format(string, StringUtils.a(((int) _pay_listVar.bonus) + "")));
                } else {
                    viewHolder.b(2131371388, 8);
                }
                viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= BeansPrePayFragment.this.h.size()) {
                                break;
                            }
                            if (i3 != i) {
                                ((PayOption._pay_list) BeansPrePayFragment.this.h.get(i3)).choosed = false;
                            } else {
                                ((PayOption._pay_list) BeansPrePayFragment.this.h.get(i3)).choosed = true;
                            }
                            i2 = i3 + 1;
                        }
                        BeansPrePayFragment.this.j.a(BeansPrePayFragment.this.h);
                        if (BeansPrePayFragment.this.c()) {
                            Context d = AppInfo.d();
                            BluedURIRouterAdapter.startVIPPay(d, _pay_listVar.id + "", "", "", "", BeansPrePayFragment.this.s, BeansPrePayFragment.this.t, (int) _pay_listVar.money);
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        a(view);
    }

    private void e() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(2131370749);
        commonTopTitleNoTrans.setTitleBackgroundDrawable(2131102388);
        commonTopTitleNoTrans.setRightText(2131886222);
        commonTopTitleNoTrans.setRightTextColor(2131102254);
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayFragment$K35ApsyLMfNiA9ixb0lFa-GU3d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeansPrePayFragment.this.c(view);
            }
        });
        commonTopTitleNoTrans.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayFragment$uLo9s73U9N3JtFULTCdp3RmFajQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeansPrePayFragment.this.b(view);
            }
        });
    }

    private void f() {
        LiveRoomHttpUtils.i(new BluedUIHttpResponse<BluedEntity<CountModel, LiveCouponCountExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<CountModel, LiveCouponCountExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                TextView textView = BeansPrePayFragment.this.e;
                textView.setText("x" + bluedEntity.extra.existence);
                if (bluedEntity.extra.existence <= 0) {
                    BeansPrePayFragment.this.d.setVisibility(8);
                    return;
                }
                BeansPrePayFragment.this.d.setVisibility(0);
                EventTrackLive.b(LiveProtos.Event.WANDOU_RECHARGE_COUPON_ENTER_SHOW);
            }
        });
    }

    public void a() {
        PayHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<PayOption>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayOption> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null || bluedEntityA.getSingleData().pay_list == null || bluedEntityA.getSingleData().pay_list.size() <= 0) {
                    BeansPrePayFragment.this.a(false);
                    return;
                }
                BeansPrePayFragment.this.h.clear();
                BeansPrePayFragment.this.h.addAll(bluedEntityA.data.get(0).pay_list);
                BeansPrePayFragment.this.a(true);
                bluedEntityA.data.get(0);
                BeansPrePayFragment.this.j.a(BeansPrePayFragment.this.h);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    BeansPrePayFragment.this.a(false);
                }
                DialogUtils.b(BeansPrePayFragment.this.mLoadingDialog);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                if (BeansPrePayFragment.this.mLoadingDialog.isShowing()) {
                    return;
                }
                DialogUtils.a(BeansPrePayFragment.this.mLoadingDialog);
            }
        }, (IRequestHost) getFragmentActive(), ReqAckPackage.REQ_RESPONSE_KEY.BEANS);
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (this.r == 6 && i == 1 && z && getActivity() != null) {
            getActivity().finish();
        }
    }

    public void a(View view) {
        LiveChargeCouponFragment.a(this.h);
        Bundle bundle = new Bundle();
        bundle.putString("fromStr", this.s);
        bundle.putString("detail", this.t);
        TerminalActivity.d(getActivity(), LiveChargeCouponFragment.class, bundle);
        EventTrackLive.b(LiveProtos.Event.WANDOU_RECHARGE_COUPON_ENTER_CLICK);
        if (this.g.getVisibility() == 0) {
            LiveRoomHttpUtils.c();
            this.g.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.f32966a.setVisibility(0);
        } else {
            this.f32966a.setVisibility(8);
        }
    }

    public void b() {
        MineHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                final PayRemaining payRemaining;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (payRemaining = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                if (payRemaining.text == null || StringUtils.d(payRemaining.text.exchange)) {
                    BeansPrePayFragment.this.p.setVisibility(4);
                } else {
                    BeansPrePayFragment.this.p.setVisibility(0);
                    BeansPrePayFragment.this.n.setText(payRemaining.text.exchange);
                }
                UserInfo.getInstance().setUserPrice(payRemaining.beans);
                BeansPrePayFragment.this.k.setText(StringUtils.a(String.valueOf(payRemaining.beans + payRemaining.bonus)));
                if (payRemaining.bonus > 0) {
                    BeansPrePayFragment.this.m.setVisibility(0);
                    BeansPrePayFragment.this.m.setText(String.format(BeansPrePayFragment.this.getResources().getString(R.string.contain_free_beans), StringUtils.a(String.valueOf(payRemaining.bonus))));
                } else {
                    BeansPrePayFragment.this.m.setVisibility(8);
                }
                if (StringUtils.d(payRemaining.text.jump_url)) {
                    BeansPrePayFragment.this.o.setVisibility(8);
                    return;
                }
                BeansPrePayFragment.this.o.setVisibility(0);
                BeansPrePayFragment.this.p.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        WebViewShowInfoFragment.show(BeansPrePayFragment.this.getActivity(), payRemaining.text.jump_url, 7);
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(BeansPrePayFragment.this.mLoadingDialog);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                if (BeansPrePayFragment.this.mLoadingDialog.isShowing()) {
                    return;
                }
                DialogUtils.a(BeansPrePayFragment.this.mLoadingDialog);
            }
        }, getFragmentActive());
    }

    public boolean c() {
        return true;
    }

    @Override // com.blued.android.framework.ui.SimpleFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VIPBuyResultObserver.a().b(this);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        e();
        this.b = this.rootView.findViewById(R.id.beans_pre_pay_bean_content_layout);
        int a2 = StatusBarHelper.a(AppInfo.d());
        int i = a2;
        if (a2 <= 0) {
            i = DisplayUtil.a(AppInfo.d(), 25.0f);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.topMargin = i;
        this.b.setLayoutParams(layoutParams);
        this.f32967c = this.rootView.findViewById(R.id.beans_pre_pay_bean_bg_iv);
        this.f = (ImageView) this.rootView.findViewById(R.id.beans_pre_pay_coupon_arrow_iv);
        if (BluedPreferences.cK()) {
            this.f32967c.setBackgroundResource(R.drawable.beans_pre_pay_bean_bg_dark);
            this.f.setImageResource(R.drawable.beans_pre_pay_right_arrow_dark);
        } else {
            this.f32967c.setBackgroundResource(R.drawable.beans_pre_pay_bean_bg);
            this.f.setImageResource(R.drawable.beans_pre_pay_right_arrow);
        }
        this.g = this.rootView.findViewById(R.id.beans_pre_pay_coupon_notice);
        this.i = (ListViewForScroll) this.rootView.findViewById(R.id.pre_pay_lv);
        this.l = (TextView) this.rootView.findViewById(R.id.tv_account);
        this.k = (TextView) this.rootView.findViewById(R.id.tv_remaining);
        this.m = (TextView) this.rootView.findViewById(R.id.tv_extra_contained);
        this.n = (TextView) this.rootView.findViewById(R.id.tv_event_hint);
        this.o = (ImageView) this.rootView.findViewById(R.id.img_hint_arrow);
        this.p = (LinearLayout) this.rootView.findViewById(R.id.ll_event_hint);
        this.q = (TextView) this.rootView.findViewById(R.id.tv_charge_terms);
        View findViewById = this.rootView.findViewById(R.id.beans_pre_pay_coupon_layout);
        this.d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$BeansPrePayFragment$3KJrjOj7NeDliZqx6P1eXujlIxs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeansPrePayFragment.this.d(view);
            }
        });
        this.e = (TextView) this.rootView.findViewById(R.id.beans_pre_pay_coupon_count_tv);
        TypefaceUtils.a(getContext(), this.q, new View.OnClickListener() { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(BeansPrePayFragment.this.getActivity(), H5Url.a(13), 0);
            }
        }, new TypefaceUtils.SpannIndex(6, 21), new TypefaceUtils.SpannIndex(14, 53));
        BluedLoginResultVerBinding verified_bindings = UserInfo.getInstance().getLoginUserInfo().getVerified_bindings();
        if (!TextUtils.isEmpty(UserInfo.getInstance().getBindPhoneNum())) {
            this.l.setText(UserInfo.getInstance().getBindPhoneNum());
        } else if (verified_bindings != null) {
            if (verified_bindings.mobile != null) {
                this.l.setText(verified_bindings.mobile);
            } else if (verified_bindings.email != null) {
                this.l.setText(verified_bindings.email);
            } else if (!TextUtils.isEmpty(UserInfo.getInstance().getLoginUserInfo().getName())) {
                this.l.setText(UserInfo.getInstance().getLoginUserInfo().getName());
            }
        } else if (!TextUtils.isEmpty(UserInfo.getInstance().getLoginUserInfo().getName())) {
            this.l.setText(UserInfo.getInstance().getLoginUserInfo().getName());
        }
        this.f32966a = (LinearLayout) this.rootView.findViewById(R.id.ll_pay_main);
        d();
        this.i.setAdapter((ListAdapter) this.j);
        VIPBuyResultObserver.a().a(this);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        a();
        LiveRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntity<CountModel, LiveCouponNoticeExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.BeansPrePayFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<CountModel, LiveCouponNoticeExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                BeansPrePayFragment.this.g.setVisibility(bluedEntity.extra.has_new == 1 ? 0 : 8);
            }
        });
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        this.r = this.args.getInt("from");
        String string = this.args.getString("details");
        if (!TextUtils.isEmpty(string)) {
            this.t = string;
        }
        int i = this.r;
        if (i == 11) {
            this.t = "virtual";
            this.s = "virtual";
            return;
        }
        switch (i) {
            case 2:
                this.s = "live";
                return;
            case 3:
                this.s = "gift";
                return;
            case 4:
                this.s = "live_btn";
                return;
            case 5:
                this.s = "package";
                return;
            case 6:
                this.t = "private-chat";
                this.s = "private-chat";
                return;
            case 7:
                this.t = "yy_chat";
                this.s = "yy_chat";
                return;
            case 8:
                this.s = "live_first_charge";
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b();
        f();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        StatusBarHelper.a((Activity) getActivity(), false);
        return R.layout.fragment_pre_pay;
    }
}
