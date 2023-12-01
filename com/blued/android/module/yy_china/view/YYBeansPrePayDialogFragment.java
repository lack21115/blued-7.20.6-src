package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYPrePayViewPagerAdapter;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.android.module.yy_china.listener.YYIVIPBuyResultObserver;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPayRemaining;
import com.blued.android.module.yy_china.model.YYPerFirstGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYRoomPreferences;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBeansPrePayDialogFragment.class */
public class YYBeansPrePayDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener, YYIVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f18055a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f18056c;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private ViewPager h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private RelativeLayout l;
    private PayOption m;
    private List<PayOption._pay_list> n;
    private YYPrePayViewPagerAdapter o;
    private Object r;
    private ShapeTextView s;
    private List<YYPerFirstGiftModel> t;
    private YYPerFirstGiftModel u;
    private YYBeansListener v;
    private int d = 0;
    private final float p = 0.42f;
    private boolean q = false;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBeansPrePayDialogFragment$YYBeansListener.class */
    public interface YYBeansListener {
        void a(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener);

        void b(YYPerFirstGiftModel yYPerFirstGiftModel, View.OnClickListener onClickListener);

        void s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        if (getContext() != null) {
            this.j.setText(getContext().getResources().getString(R.string.yy_pre_pay_btn, CommonStringUtils.a(d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        YYPrePayViewPagerAdapter yYPrePayViewPagerAdapter = this.o;
        if (yYPrePayViewPagerAdapter == null || yYPrePayViewPagerAdapter.f16210a == null || this.n == null) {
            return;
        }
        this.o.f16210a.choosed = false;
        if (i()) {
            String a2 = !StringUtils.b(YYChatRoomsListFragment.f17120a.a()) ? YYChatRoomsListFragment.f17120a.a() : "yy_chat";
            if (!StringUtils.b(YYRoomInfoManager.e().f())) {
                a2 = YYRoomInfoManager.e().f();
            }
            YYRoomInfoManager e = YYRoomInfoManager.e();
            Context context = getContext();
            e.a(context, this.o.f16210a.id + "", "", "", "", "yy_chat", a2, (int) this.o.f16210a.money);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, final View view2) {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || !this.q) {
            return;
        }
        this.q = false;
        view.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                YYBeansPrePayDialogFragment.this.e.removeView(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, final View view2, View view3) {
        if (view.getAlpha() < 0.95d || !this.q) {
            return;
        }
        this.q = false;
        view.setClickable(false);
        view.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                YYBeansPrePayDialogFragment.this.e.removeView(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b(final View view, final View view2, View view3, View view4) {
        this.q = true;
        YYRoomPreferences.c();
        view2.animate().alpha(1.0f).setDuration(300L);
        view4.animate().translationX(0 - view3.getWidth()).setDuration(2000L).setInterpolator(new DecelerateInterpolator(2.0f));
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBeansPrePayDialogFragment$0zRurCuz43C8X-cUWcapwAJJJeU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                YYBeansPrePayDialogFragment.this.a(view2, view, view5);
            }
        });
        a(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBeansPrePayDialogFragment$mWu0JshHGO9flV3d2_wMEg40Y-g
            @Override // java.lang.Runnable
            public final void run() {
                YYBeansPrePayDialogFragment.this.a(view2, view);
            }
        }, m.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final View view) {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing()) {
            return;
        }
        final View findViewById = view.findViewById(R.id.rl_root);
        final View findViewById2 = view.findViewById(R.id.view_shadow);
        final View findViewById3 = view.findViewById(R.id.view_hand);
        findViewById.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBeansPrePayDialogFragment$NlI-I_ov3kocjXgTyApYX5LQlzA
            @Override // java.lang.Runnable
            public final void run() {
                YYBeansPrePayDialogFragment.this.b(view, findViewById, findViewById2, findViewById3);
            }
        });
    }

    private void k() {
        this.e = (RelativeLayout) this.b.findViewById(R.id.rl_root);
        this.f = (TextView) this.b.findViewById(R.id.tv_balance_title);
        this.g = (TextView) this.b.findViewById(R.id.tv_balance);
        this.h = (ViewPager) this.b.findViewById(R.id.vp_pre_pay);
        this.i = (LinearLayout) this.b.findViewById(R.id.view_indicator);
        this.j = (TextView) this.b.findViewById(R.id.tv_pre_pay);
        this.k = (TextView) this.b.findViewById(R.id.tv_agreement);
        this.l = (RelativeLayout) this.b.findViewById(R.id.loading);
        this.s = (ShapeTextView) this.b.findViewById(R.id.tv_go_first_charge);
        a(false);
        h();
        this.j.getPaint().setFakeBoldText(true);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBeansPrePayDialogFragment$2PfY01omvee3J6cQ1_hzWILlwW4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYBeansPrePayDialogFragment.this.a(view);
            }
        });
        this.s.setOnClickListener(this);
        n();
        Object a2 = YYRoomInfoManager.e().a((YYIVIPBuyResultObserver) this);
        this.r = a2;
        if (a2 == null) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int i;
        int i2 = 0;
        if (this.d > 0) {
            List<PayOption._pay_list> list = this.n;
            i2 = 0;
            if (list != null) {
                i2 = 0;
                if (list.size() > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        i = 0;
                        if (i4 >= this.n.size()) {
                            break;
                        }
                        PayOption._pay_list _pay_listVar = this.n.get(i4);
                        if (_pay_listVar.money * _pay_listVar.ratio > this.d) {
                            i = i4;
                            break;
                        }
                        i3 = i4 + 1;
                    }
                    List<PayOption._pay_list> list2 = this.n;
                    PayOption._pay_list _pay_listVar2 = list2.get(list2.size() - 1);
                    i2 = i;
                    if (i == 0) {
                        i2 = i;
                        if (this.d > _pay_listVar2.money * _pay_listVar2.ratio) {
                            i2 = this.n.size() - 1;
                        }
                    }
                }
            }
        }
        YYPrePayViewPagerAdapter yYPrePayViewPagerAdapter = new YYPrePayViewPagerAdapter(getContext(), this.n, this.d, i2, new YYPrePayViewPagerAdapter.SelectModelCallBack() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.3
            @Override // com.blued.android.module.yy_china.adapter.YYPrePayViewPagerAdapter.SelectModelCallBack
            public void a(PayOption._pay_list _pay_listVar3) {
                YYBeansPrePayDialogFragment.this.a(_pay_listVar3.money);
                if (YYBeansPrePayDialogFragment.this.t != null) {
                    for (YYPerFirstGiftModel yYPerFirstGiftModel : YYBeansPrePayDialogFragment.this.t) {
                        if (yYPerFirstGiftModel.getPay_id() == _pay_listVar3.id) {
                            YYBeansPrePayDialogFragment.this.u = yYPerFirstGiftModel;
                            YYBeansPrePayDialogFragment.this.p();
                            return;
                        }
                    }
                }
            }
        });
        this.o = yYPrePayViewPagerAdapter;
        this.h.setAdapter(yYPrePayViewPagerAdapter);
        this.h.setCurrentItem(i2 / 6);
        m();
        j();
    }

    private void m() {
        this.i.removeAllViews();
        int count = this.o.getCount();
        if (count == 0) {
            return;
        }
        int a2 = DensityUtils.a(requireContext(), 5.0f);
        int i = a2 / 2;
        int i2 = 0;
        this.i.setPadding(i, 0, i, 0);
        while (i2 < count) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.bg_pre_pay_indicator_dot_yy);
            view.setAlpha(i2 == this.h.getCurrentItem() ? 1.0f : 0.42f);
            this.i.addView(view);
            i2++;
        }
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.4
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                if (i3 >= YYBeansPrePayDialogFragment.this.i.getChildCount()) {
                    return;
                }
                float f2 = ((1.0f - f) * 0.58000004f) + 0.42f;
                YYBeansPrePayDialogFragment.this.i.getChildAt(i3).setAlpha(f2);
                int i5 = i3 + 1;
                if (i5 < YYBeansPrePayDialogFragment.this.i.getChildCount()) {
                    YYBeansPrePayDialogFragment.this.i.getChildAt(i5).setAlpha(1.42f - f2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= YYBeansPrePayDialogFragment.this.i.getChildCount()) {
                        return;
                    }
                    if (i5 != i3) {
                        YYBeansPrePayDialogFragment.this.i.getChildAt(i5).setAlpha(0.42f);
                    } else {
                        YYBeansPrePayDialogFragment.this.i.getChildAt(i5).setAlpha(1.0f);
                    }
                    i4 = i5 + 1;
                }
            }
        });
    }

    private void n() {
        this.k.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f18056c != null) {
            YYRoomHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<YYPerFirstGiftModel>>(a()) { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYPerFirstGiftModel> bluedEntityA) {
                    if (bluedEntityA.hasData()) {
                        YYBeansPrePayDialogFragment.this.t = bluedEntityA.data;
                        YYBeansPrePayDialogFragment.this.u = bluedEntityA.getSingleData();
                        YYBeansPrePayDialogFragment.this.p();
                    }
                }
            }, a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.o != null && this.t != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (YYPerFirstGiftModel yYPerFirstGiftModel : this.t) {
                arrayList.add(Long.valueOf(yYPerFirstGiftModel.getPay_id()));
            }
            this.o.a(arrayList);
        }
        Iterator<PayOption._pay_list> it = this.m.pay_list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PayOption._pay_list next = it.next();
            if (next.id == this.u.getPay_id()) {
                this.u.setSel(next);
                break;
            }
        }
        if (this.u.getSel() == null || this.s == null || YYRoomInfoManager.e().c() == null) {
            return;
        }
        boolean z = false;
        this.s.setVisibility(0);
        if (this.u.getType() == 1) {
            this.s.setText(String.format(YYRoomInfoManager.e().d().getString(R.string.yy_prepay_rechrgefirst), ((long) this.u.getSel().money) + ""));
        } else {
            this.s.setText(String.format(YYRoomInfoManager.e().d().getString(R.string.yy_prepay_rechrgeback), ((long) this.u.getSel().money) + ""));
            if (YYRoomInfoManager.e().b() != null) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                EventTrackYY.d(ChatRoomProtos.Event.YY_DOWN_EXCHANGE_CLICK, b.room_id, b.uid);
            }
            if (this.v != null) {
                long j = SharedPreferencesUtils.b().getLong("PREPAY_FIRST", 0L);
                String string = SharedPreferencesUtils.b().getString("PREPAY_FIRST_TIME", "");
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
                long j2 = j;
                if (j < 2) {
                    j2 = j + 1;
                    z = true;
                }
                if (!string.equals(format)) {
                    j2 = 1;
                    z = true;
                }
                if (z) {
                    SharedPreferencesUtils.b().edit().putLong("PREPAY_FIRST", j2).apply();
                    SharedPreferencesUtils.b().edit().putString("PREPAY_FIRST_TIME", format).apply();
                    this.v.b(this.u, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            YYBeansPrePayDialogFragment.this.q();
                            YYBeansPrePayDialogFragment.this.a(view);
                        }
                    });
                }
            }
        }
        q();
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 != null) {
            EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_PAY_SIX_POP_SHOW, b2.room_id, b2.uid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        PayOption payOption;
        if (this.o == null || (payOption = this.m) == null || payOption.pay_list == null || this.u == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.m.pay_list.size()) {
                break;
            }
            if (this.m.pay_list.get(i2).id == this.u.getPay_id()) {
                this.o.f16211c = i2;
                a(this.m.pay_list.get(i2).money);
                this.o.a();
            }
            i = i2 + 1;
        }
        int i3 = this.o.f16211c / 6;
        if (i3 < this.h.getCurrentItem()) {
            this.h.setCurrentItem(i3);
        }
    }

    public YYBeansPrePayDialogFragment a(Context context, BaseFragment baseFragment, int i) {
        this.f18055a = context;
        this.d = i;
        this.f18056c = baseFragment;
        return this;
    }

    public YYBeansPrePayDialogFragment a(YYBeansListener yYBeansListener) {
        this.v = yYBeansListener;
        return this;
    }

    @Override // com.blued.android.module.yy_china.listener.YYIVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || i != 1 || !z) {
            return;
        }
        AppMethods.a((CharSequence) getString(R.string.yy_setting_rechargesuccess));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && b.yyPerFirstGiftModel != null) {
            b.yyPerFirstGiftModel.setType(0L);
        }
        LiveEventBus.get("pre_pay_succes").post("");
        a(true);
    }

    public void a(final boolean z) {
        YYRoomHttpUtils.o(new BluedUIHttpResponse<BluedEntityA<YYPayRemaining>>(a()) { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPayRemaining> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0 || bluedEntityA.data.get(0) == null) {
                    return;
                }
                YYPayRemaining yYPayRemaining = bluedEntityA.data.get(0);
                UserInfo.getInstance().setUserPrice(yYPayRemaining.beans);
                LiveDataManager.a().a(yYPayRemaining);
                if (z) {
                    LiveDataManager.a().a(bluedEntityA.getSingleData());
                    if (bluedEntityA.getSingleData().text != null) {
                        bluedEntityA.getSingleData().text.sums = "充值";
                        bluedEntityA.getSingleData().text.goods = "充值";
                    }
                    bluedEntityA.getSingleData().bonus = 0L;
                    LiveEventBus.get("gold_remain_result").post(bluedEntityA.getSingleData());
                }
                if (YYBeansPrePayDialogFragment.this.getActivity() == null || YYBeansPrePayDialogFragment.this.getActivity().isFinishing() || YYBeansPrePayDialogFragment.this.getDialog() == null || !YYBeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    return;
                }
                YYBeansPrePayDialogFragment.this.g.setText(CommonStringUtils.d(String.valueOf(yYPayRemaining.beans)));
                YYBeansPrePayDialogFragment.this.f.setVisibility(0);
                YYBeansPrePayDialogFragment.this.g.setVisibility(0);
                if (z) {
                    YYBeansPrePayDialogFragment.this.dismissAllowingStateLoss();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (z && YYBeansPrePayDialogFragment.this.getActivity() != null && !YYBeansPrePayDialogFragment.this.getActivity().isFinishing() && YYBeansPrePayDialogFragment.this.getDialog() != null && YYBeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    YYBeansPrePayDialogFragment.this.dismissAllowingStateLoss();
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
            }
        }, a());
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean e() {
        return true;
    }

    public void h() {
        YYRoomInfoManager.e().c().a(new BluedUIHttpResponse<BluedEntityA<PayOption>>(a()) { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayOption> bluedEntityA) {
                int i;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0 || bluedEntityA.data.get(0) == null || bluedEntityA.data.get(0).pay_list == null || bluedEntityA.data.get(0).pay_list.size() == 0) {
                    return;
                }
                if (YYBeansPrePayDialogFragment.this.n == null) {
                    YYBeansPrePayDialogFragment.this.n = new ArrayList();
                } else {
                    YYBeansPrePayDialogFragment.this.n.clear();
                }
                YYBeansPrePayDialogFragment.this.m = bluedEntityA.data.get(0);
                YYBeansPrePayDialogFragment.this.n.addAll(YYBeansPrePayDialogFragment.this.m.pay_list);
                if (YYBeansPrePayDialogFragment.this.n != null && YYBeansPrePayDialogFragment.this.n.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = 0;
                        if (i3 >= YYBeansPrePayDialogFragment.this.n.size()) {
                            break;
                        } else if (((PayOption._pay_list) YYBeansPrePayDialogFragment.this.n.get(i3)).money == 5.0d) {
                            i = i3;
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                    YYBeansPrePayDialogFragment yYBeansPrePayDialogFragment = YYBeansPrePayDialogFragment.this;
                    yYBeansPrePayDialogFragment.a(((PayOption._pay_list) yYBeansPrePayDialogFragment.n.get(i)).money);
                }
                YYBeansPrePayDialogFragment.this.l();
                YYBeansPrePayDialogFragment.this.o();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                if (YYBeansPrePayDialogFragment.this.getActivity() == null || YYBeansPrePayDialogFragment.this.getActivity().isFinishing() || YYBeansPrePayDialogFragment.this.getDialog() == null || !YYBeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    return;
                }
                super.onUIFinish();
                YYBeansPrePayDialogFragment.this.l.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                if (YYBeansPrePayDialogFragment.this.getActivity() == null || YYBeansPrePayDialogFragment.this.getActivity().isFinishing() || YYBeansPrePayDialogFragment.this.getDialog() == null || !YYBeansPrePayDialogFragment.this.getDialog().isShowing()) {
                    return;
                }
                super.onUIStart();
                YYBeansPrePayDialogFragment.this.l.setVisibility(0);
            }
        }, a(), ReqAckPackage.REQ_RESPONSE_KEY.BEANS);
    }

    public boolean i() {
        return true;
    }

    public void j() {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || YYRoomPreferences.b() || this.q) {
            return;
        }
        final View inflate = getActivity().getLayoutInflater().inflate(R.layout.yy_pre_pay_guide, (ViewGroup) null);
        this.e.addView(inflate);
        a(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYBeansPrePayDialogFragment$0j9KL3m5lWKqwVqfrxsasEC9lCM
            @Override // java.lang.Runnable
            public final void run() {
                YYBeansPrePayDialogFragment.this.b(inflate);
            }
        }, 500L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.tv_agreement) {
            YYRoomInfoManager.e().c().a(getContext(), H5Url.a(13), 0);
        } else if (id != R.id.tv_go_first_charge || this.u == null || ClickUtils.a(id)) {
        } else {
            if (this.u.getType() == 1) {
                YYBeansListener yYBeansListener = this.v;
                if (yYBeansListener != null) {
                    yYBeansListener.a(this.u, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            YYBeansPrePayDialogFragment.this.q();
                            YYBeansPrePayDialogFragment.this.a(view2);
                            YYRoomModel b = YYRoomInfoManager.e().b();
                            if (b != null) {
                                EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_PAY_SIX_POP_NOW_RECHARGE_CLICK, b.room_id, b.uid);
                            }
                        }
                    });
                }
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.SINGLE_ROOM_PAY_SIX_POP_CLICK, b.room_id, b.uid);
                    return;
                }
                return;
            }
            YYBeansListener yYBeansListener2 = this.v;
            if (yYBeansListener2 != null) {
                yYBeansListener2.b(this.u, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYBeansPrePayDialogFragment.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        YYBeansPrePayDialogFragment.this.q();
                        YYBeansPrePayDialogFragment.this.a(view2);
                        if (YYRoomInfoManager.e().b() != null) {
                            YYRoomModel b2 = YYRoomInfoManager.e().b();
                            EventTrackYY.d(ChatRoomProtos.Event.YY_TWELVE_POP_NOW_CLICK, b2.room_id, b2.uid);
                        }
                    }
                });
                if (YYRoomInfoManager.e().b() != null) {
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    EventTrackYY.d(ChatRoomProtos.Event.YY_EXCHANGE_PAGE_TWELVE_CLICK, b2.room_id, b2.uid);
                }
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.r != null) {
            YYRoomInfoManager.e().a(this.r);
        }
        YYBeansListener yYBeansListener = this.v;
        if (yYBeansListener != null) {
            yYBeansListener.s();
        }
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        dialog.requestWindowFeature(1);
        dialog.getContext().setTheme(R.style.transparentFrameWindowStyleLive);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.yy_pop_bottom_in_anim);
        this.b = getActivity().getLayoutInflater().inflate(R.layout.dialog_yy_pre_pay, (ViewGroup) null);
        dialog.setContentView(this.b, new ViewGroup.LayoutParams(-1, DensityUtils.a(dialog.getContext(), 330.0f)));
        k();
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
