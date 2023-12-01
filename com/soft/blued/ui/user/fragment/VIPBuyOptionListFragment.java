package com.soft.blued.ui.user.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.das.vip.VipProtos;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.customview.ShowAllListView;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.pay.CouponFragment;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.ui.user.adapter.VIPAgreementAdapter;
import com.soft.blued.ui.user.adapter.VIPBuyAdapter;
import com.soft.blued.ui.user.adapter.VIPItemRoundAdapter;
import com.soft.blued.ui.user.adapter.VIPItemRoundNewAdapter;
import com.soft.blued.ui.user.adapter.VIPPrivilegeNewAdapter;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.ui.user.model.VIPBuyOptionForJsonParse;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.observer.VIPBuyOnBackPressedObserver;
import com.soft.blued.ui.user.views.IViewStateListener;
import com.soft.blued.ui.user.views.VIPPrivilegePageView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPBuyOptionListFragment.class */
public class VIPBuyOptionListFragment extends BaseFragment {
    private VIPPrivilegePageView A;
    private LinePageIndicator B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private View G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private int L;
    private int M;
    private View N;
    private RecyclerView O;
    private VIPItemRoundAdapter P;
    private LinearLayout Q;
    private LinearLayout R;
    private ShapeConstraintLayout S;
    private AutoScrollViewPager T;
    private LinePageIndicator U;
    private TextView V;
    private RecyclerView W;
    private TextView X;
    private TextView Y;
    private RecyclerView Z;

    /* renamed from: a  reason: collision with root package name */
    public Context f20426a;
    private TextView aa;
    private TextView ab;
    private ShowAllListView ac;
    private VIPItemRoundNewAdapter ad;
    private BannerPagerAdapter ae;
    private VIPPrivilegeNewAdapter ag;
    private ImageView ah;
    private TextView ai;
    private LinearLayout aj;
    private View ak;
    private View al;
    private VipUpgradeDialogFragment an;
    private boolean ao;
    private boolean ap;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f20427c;
    public VIPBuyAdapter d;
    private TextView g;
    private String i;
    private String j;
    private TextView k;
    private LoadOptions l;
    private ShowAllListView m;
    private VIPAgreementAdapter n;
    private String o;
    private BluedCoupon q;
    private View s;
    private View t;
    private View x;
    private View y;
    private View z;
    private int h = 2;
    private VipProtos.FromType p = VipProtos.FromType.UNKNOWN_FROM;
    private int r = 1;
    private boolean u = false;
    private boolean v = true;
    private boolean w = false;
    public int e = 0;
    private boolean af = false;
    private boolean am = false;
    public BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntityA<VIPBuyOptionForJsonParse>>(VIPBuyOptionListFragment.class.getName() + this.h, getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.6
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUICache(BluedEntityA<VIPBuyOptionForJsonParse> bluedEntityA) {
            super.onUICache(bluedEntityA);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public void onUIUpdate(BluedEntityA<VIPBuyOptionForJsonParse> bluedEntityA) {
            VIPBuyOptionListFragment.this.a(bluedEntityA);
        }

        public void onUIFinish() {
            super.onUIFinish();
        }

        public void onUIStart() {
            super.onUIStart();
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPBuyOptionListFragment$BannerPagerAdapter.class */
    public class BannerPagerAdapter extends PagerAdapter {
        private List<VIPBuyOptionForJsonParse._banner_model> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private List<View> f20441c = new ArrayList();

        public BannerPagerAdapter() {
        }

        public void a(List<VIPBuyOptionForJsonParse._banner_model> list) {
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
            }
            while (this.f20441c.size() < this.b.size()) {
                this.f20441c.add(LayoutInflater.from(VIPBuyOptionListFragment.this.getActivity()).inflate(R.layout.item_vip_operate_banner, (ViewGroup) null));
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            final VIPBuyOptionForJsonParse._banner_model _banner_modelVar = this.b.get(i);
            View view = this.f20441c.get(i);
            viewGroup.addView(view);
            ImageView imageView = (ImageView) this.f20441c.get(i).findViewById(R.id.item_vip_operate_banner_iv);
            Glide.b(VIPBuyOptionListFragment.this.f20426a).b(_banner_modelVar.img).b(RequestOptions.c((Transformation<Bitmap>) new RoundedCorners(DensityUtils.a(VIPBuyOptionListFragment.this.f20426a, 6.0f)))).a(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.BannerPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    WebViewShowInfoFragment.show(VIPBuyOptionListFragment.this.f20426a, _banner_modelVar.link, -1);
                }
            });
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private void a(int i) {
        PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedCoupon>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedCoupon> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0 || bluedEntityA.data.get(0) == null) {
                    VIPBuyOptionListFragment.this.q = null;
                } else {
                    VIPBuyOptionListFragment.this.q = (BluedCoupon) bluedEntityA.data.get(0);
                }
                VIPBuyOptionListFragment.this.b();
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                VIPBuyOptionListFragment.this.q = null;
                VIPBuyOptionListFragment.this.b();
            }
        }, 1, 20, i, 0, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        layoutParams.height = intValue;
        this.x.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f20426a, 196.0f), DensityUtils.a(this.f20426a, 51.0f));
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$nnaxFoYHEnT3fcT_a9FTQAFSgKA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VIPBuyOptionListFragment.this.a(valueAnimator);
            }
        });
        ofInt.start();
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.A.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VIPBuyOption vIPBuyOption) {
        a(vIPBuyOption.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(VIPBuyOption vIPBuyOption, View view) {
        Tracker.onClick(view);
        this.t.setVisibility(8);
        BluedPreferences.cz();
        int i = vIPBuyOption.id;
        BluedCoupon bluedCoupon = this.q;
        CouponFragment.a(this, 101, i, bluedCoupon == null ? 0 : bluedCoupon.id);
    }

    private void a(List<VIPBuyOptionForJsonParse._banner_model> list) {
    }

    private void a(List<VIPPrivilegeModel> list, boolean z) {
        VIPPrivilegeModel vIPPrivilegeModel = new VIPPrivilegeModel(this.f20426a.getString(R.string.to_more_privilege), "");
        if (z) {
            vIPPrivilegeModel.url = BluedHttpUrl.a(-1, "", 2, UserInfo.getInstance().getLoginUserInfo().vip_grade);
        } else {
            vIPPrivilegeModel.url = BluedHttpUrl.a(-1, "", 1, UserInfo.getInstance().getLoginUserInfo().vip_grade);
        }
        if (!list.contains(vIPPrivilegeModel)) {
            list.add(vIPPrivilegeModel);
        }
        this.ag.setNewData(list);
        this.ag.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        layoutParams.height = intValue;
        this.x.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f20426a, 51.0f), DensityUtils.a(this.f20426a, 196.0f));
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$5tr5L9XIm9I0NQlsbG-F1hRk3h4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VIPBuyOptionListFragment.this.b(valueAnimator);
            }
        });
        ofInt.start();
        this.y.setVisibility(8);
        this.z.setVisibility(0);
        this.A.a();
        if (this.h == 1) {
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_MORE_BTN_CLICK, 1);
        } else {
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_MORE_BTN_CLICK, 2);
        }
    }

    private void b(BluedEntityA<VIPBuyOptionForJsonParse> bluedEntityA) {
        this.R.setVisibility(0);
        this.Q.setVisibility(8);
        if (this.h == 1) {
            this.k.setBackground(this.f20426a.getResources().getDrawable(R.drawable.icon_vip_new_page_buy_btn_bg));
            if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list != null && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.size() > 0 && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.get(0) != null) {
                this.V.setText(this.f20426a.getResources().getString(R.string.vip_pay_list_title));
                this.Y.setText(this.f20426a.getResources().getString(R.string.vip_pay_privilege_list_title));
                this.aa.setText(this.f20426a.getResources().getString(R.string.vip_pay_service_title));
                this.ab.setText(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).explain_list.vip);
                a(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.vip);
                this.ad.a(1);
                this.ad.setNewData(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list);
                int i = 0;
                for (int i2 = 0; i2 < ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.size(); i2++) {
                    if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(i2).default_checked == 1) {
                        i = i2;
                    }
                }
                this.ad.a(i, true);
                if (StringUtils.d(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.get(i).item.remark)) {
                    this.X.setVisibility(8);
                } else {
                    this.X.setText(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.get(i).item.remark);
                    this.X.setVisibility(0);
                }
                this.k.setText(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.get(i).item.button);
                this.ad.notifyDataSetChanged();
                final int i3 = i;
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        VIPBuyOptionListFragment.this.W.scrollBy(i3 * DensityUtil.a(128.0f), 0);
                    }
                }, 200L);
            }
            if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner == null || ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.svip == null || ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.svip.size() <= 0) {
                this.S.setVisibility(8);
            } else {
                this.S.setVisibility(0);
                this.ae.a(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.vip);
            }
            if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).vip_list.privilege_list != null && ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).vip_list.privilege_list.size() > 0) {
                a(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).vip_list.privilege_list, false);
            }
        } else {
            this.k.setBackground(this.f20426a.getResources().getDrawable(R.drawable.icon_svip_new_page_buy_btn_bg));
            if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list != null && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.size() > 0 && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(0) != null) {
                this.V.setText(this.f20426a.getResources().getString(R.string.svip_pay_list_title));
                this.Y.setText(this.f20426a.getResources().getString(R.string.svip_pay_privilege_list_title));
                this.aa.setText(this.f20426a.getResources().getString(R.string.vip_pay_service_title));
                this.ab.setText(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).explain_list.svip);
                this.ad.a(2);
                this.ad.setNewData(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list);
                int i4 = 0;
                for (int i5 = 0; i5 < ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.size(); i5++) {
                    if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(i5).default_checked == 1) {
                        i4 = i5;
                    }
                }
                this.ad.a(i4, true);
                if (StringUtils.d(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(i4).item.remark)) {
                    this.X.setVisibility(8);
                } else {
                    this.X.setText(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(i4).item.remark);
                    this.X.setVisibility(0);
                }
                this.k.setText(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(i4).item.button);
                this.ad.notifyDataSetChanged();
                final int i6 = i4;
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        VIPBuyOptionListFragment.this.W.scrollBy(i6 * DensityUtil.a(128.0f), 0);
                    }
                }, 200L);
            }
            if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner == null || ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.vip == null || ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.vip.size() <= 0) {
                this.S.setVisibility(8);
            } else {
                this.S.setVisibility(0);
                this.ae.a(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).banner.svip);
            }
            if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).svip_list.privilege_list != null && ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).svip_list.privilege_list.size() > 0) {
                a(((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).svip_list.privilege_list, true);
            }
        }
        if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).new_member_experiment == 1) {
            this.o = "new_msg";
        }
        if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).rule_list == null || ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).rule_list.size() <= 0) {
            this.ac.setVisibility(8);
            return;
        }
        this.ac.setVisibility(0);
        VIPAgreementAdapter vIPAgreementAdapter = new VIPAgreementAdapter(this.f20426a, ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).rule_list);
        this.n = vIPAgreementAdapter;
        this.ac.setAdapter((ListAdapter) vIPAgreementAdapter);
        this.n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(VIPBuyOption vIPBuyOption) {
        View view = this.s;
        if (view != null && view.getVisibility() == 0) {
            this.r = 1;
            a(vIPBuyOption, false);
        } else if (vIPBuyOption == null || vIPBuyOption.item == null || StringUtils.d(vIPBuyOption.item.button)) {
            this.k.setText(this.f20426a.getResources().getString(R.string.get_it_right_now));
            this.X.setVisibility(8);
        } else {
            this.k.setText(vIPBuyOption.item.button);
            this.e = vIPBuyOption.is_entrust_giver;
            this.X.setVisibility(0);
            if (StringUtils.d(vIPBuyOption.item.remark)) {
                this.X.setVisibility(8);
                return;
            }
            this.X.setText(vIPBuyOption.item.remark);
            this.X.setVisibility(0);
        }
    }

    private void c() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.h = arguments.getInt("KEY_VIP_GRADE");
            Log.v("drb", "fromType:" + this.p + " -- mVIPGrade:" + this.h);
            this.L = arguments.getInt("KEY_RIGHT_ID");
            this.M = arguments.getInt("KEY_PARAMS_LEVEL");
            this.i = getArguments().getString("KEY_TARGET_UID");
            this.j = getArguments().getString("KEY_ACTIVITY_ID");
            this.o = getArguments().getString("KEY_VIP_DETAIL", "");
            this.u = getArguments().getBoolean("KEY_IF_SHOW_COUPON");
            this.v = getArguments().getBoolean("KEY_IF_SHOW_UPGRADE_BUTTON");
            this.w = getArguments().getBoolean("KEY_IF_OPEN_UPGRADE_DIALOG");
            if (this.p == VipProtos.FromType.UNKNOWN_FROM) {
                this.p = (VipProtos.FromType) getArguments().getSerializable("KEY_VIP_FROM_TYPE");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        if (!this.am) {
            AppMethods.d((int) R.string.hello_bug_tips);
            return;
        }
        VIPBuyOption a2 = this.O.getVisibility() == 0 ? this.P.a() : this.d.a();
        if (this.af) {
            VIPBuyOption a3 = this.ad.a();
            a2 = a3;
            if (TextUtils.equals(this.o, "vip_center_top_renew_now_vip")) {
                this.o = "vip_buy_optimize";
                a2 = a3;
            }
        }
        if (a2 != null) {
            Context context = this.f20426a;
            String str = this.i;
            String str2 = this.j;
            String str3 = this.o;
            BluedCoupon bluedCoupon = this.q;
            PayPreOrderFragment.a(context, a2, "list", str, str2, "", str3, 0, bluedCoupon == null ? 0 : bluedCoupon.id, null, this.e, getFragmentActive());
        }
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_OPEN_BTN_CLICK, this.h == 2 ? VipProtos.Name.SVIP : VipProtos.Name.VIP, this.p, VipProtos.PageVersion.V_0730);
    }

    private void c(BluedEntityA<VIPBuyOptionForJsonParse> bluedEntityA) {
        this.R.setVisibility(8);
        this.Q.setVisibility(0);
        if (this.h == 1) {
            if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list != null && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.size() > 0 && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.get(0) != null) {
                ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list.get(0);
                if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).is_show_hori_items == 1) {
                    this.N.setVisibility(8);
                    this.P.a(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list);
                    this.O.setVisibility(0);
                    this.f20427c.setVisibility(8);
                    this.J.setVisibility(0);
                    this.K.setVisibility(8);
                    this.P.a(0);
                } else {
                    this.N.setVisibility(0);
                    this.d.a(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.list);
                    this.d.a(0);
                    this.O.setVisibility(8);
                    this.f20427c.setVisibility(0);
                    this.J.setVisibility(8);
                }
            }
        } else if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list != null && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.size() > 0 && ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(0) != null) {
            ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(0);
            if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).is_show_hori_items == 1) {
                this.P.a(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list);
                this.O.setVisibility(0);
                this.f20427c.setVisibility(8);
                this.J.setVisibility(0);
                this.K.setVisibility(8);
                this.P.a(0);
            } else {
                this.d.a(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list);
                int i = 0;
                for (int i2 = 0; i2 < ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.size(); i2++) {
                    if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.list.get(i2).default_checked == 1) {
                        i = i2;
                    }
                }
                if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).new_member_experiment == 1) {
                    this.o = "new_msg";
                }
                this.d.a(i);
                this.O.setVisibility(8);
                this.f20427c.setVisibility(0);
                this.J.setVisibility(8);
            }
            this.q = ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.default_coupon;
        }
        a(this.O.getVisibility() == 0 ? this.P.a() : this.d.a(), true);
        if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).rule_list == null || ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).rule_list.size() <= 0) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            VIPAgreementAdapter vIPAgreementAdapter = new VIPAgreementAdapter(this.f20426a, ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).rule_list);
            this.n = vIPAgreementAdapter;
            this.m.setAdapter((ListAdapter) vIPAgreementAdapter);
            this.n.notifyDataSetChanged();
        }
        if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).explain_list != null) {
            if (this.h == 2) {
                this.g.setText(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).explain_list.svip);
            } else {
                this.g.setText(((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).explain_list.vip);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(VIPBuyOption vIPBuyOption) {
        View view = this.s;
        if (view != null && view.getVisibility() == 0) {
            this.r = 1;
            a(vIPBuyOption, false);
        } else if (vIPBuyOption == null || vIPBuyOption.item == null || StringUtils.d(vIPBuyOption.item.button)) {
            this.k.setText(this.f20426a.getResources().getString(R.string.get_it_right_now));
            this.K.setVisibility(8);
        } else {
            this.k.setText(vIPBuyOption.item.button);
            this.e = vIPBuyOption.is_entrust_giver;
            this.K.setVisibility(0);
            if (StringUtils.d(vIPBuyOption.item.remark)) {
                this.K.setVisibility(8);
                return;
            }
            this.K.setText(vIPBuyOption.item.remark);
            this.K.setVisibility(0);
        }
    }

    private void d() {
        this.x = this.b.findViewById(R.id.privilege_layout);
        this.y = this.b.findViewById(R.id.privilege_close_layout);
        this.C = (ImageView) this.b.findViewById(R.id.privilege_close_icon);
        this.z = this.b.findViewById(R.id.privilege_open_layout);
        this.D = (ImageView) this.b.findViewById(R.id.privilege_open_icon);
        this.A = (VIPPrivilegePageView) this.b.findViewById(R.id.privilege_page_view);
        this.B = this.b.findViewById(R.id.privilege_page_indicator);
        this.E = (ImageView) this.b.findViewById(R.id.icon_close_right_arrow);
        this.F = (ImageView) this.b.findViewById(R.id.icon_open_right_arrow);
        this.G = this.b.findViewById(R.id.privilege_line);
        this.H = (TextView) this.b.findViewById(R.id.privilege_close_text);
        this.I = (TextView) this.b.findViewById(R.id.privilege_open_text);
        if (this.h == 2) {
            this.C.setImageResource(2131233869);
            this.D.setImageResource(2131233869);
            this.H.setText(R.string.svip_privilege);
            this.I.setText(R.string.svip_privilege);
        } else {
            this.C.setImageResource(2131233998);
            this.D.setImageResource(2131233998);
            this.H.setText(R.string.vip_privilege);
            this.I.setText(R.string.vip_privilege);
        }
        if (BluedPreferences.cK()) {
            this.E.setImageResource(R.drawable.icon_arrow_down_white_36);
            this.F.setImageResource(R.drawable.icon_arrow_up_white_36);
            this.B.setSelectedColor(Color.parseColor("#FFFFFF"));
            this.B.setUnselectedColor(Color.parseColor("#4CFFFFFF"));
        } else {
            this.B.setSelectedColor(Color.parseColor("#222222"));
            this.B.setUnselectedColor(Color.parseColor("#4C1E1F23"));
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 20) {
                this.A.setInterval(4000L);
                this.A.setIViewListener(new IViewStateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$iCWq4xUjn9xsx2VWNdfeb5Wznbg
                    @Override // com.soft.blued.ui.user.views.IViewStateListener
                    public final void onSetAdapter() {
                        VIPBuyOptionListFragment.this.j();
                    }
                });
                this.y.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$wSkPn9fHLKaqOIylmQt55Um3pN0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VIPBuyOptionListFragment.this.b(view);
                    }
                });
                this.z.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$I1SVdgU_MYuxR4iK6O93hXlb0R4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VIPBuyOptionListFragment.this.a(view);
                    }
                });
                return;
            }
            arrayList.add(new VIPPrivilegeModel("测试" + i2, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587463364879&di=0537824a516a799c84013d41576a9020&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201701%2F30%2F20170130181206_x8ScK.thumb.700_0.jpeg"));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(VIPBuyOption vIPBuyOption) {
        View view = this.s;
        if (view != null && view.getVisibility() == 0) {
            this.r = 1;
            a(vIPBuyOption, false);
        } else if (vIPBuyOption == null || vIPBuyOption.item == null || StringUtils.d(vIPBuyOption.item.button)) {
            this.k.setText(this.f20426a.getResources().getString(R.string.get_it_right_now));
            this.J.setVisibility(8);
        } else {
            this.k.setText(vIPBuyOption.item.button);
            this.J.setVisibility(0);
            if (StringUtils.d(vIPBuyOption.item.remark)) {
                this.J.setVisibility(8);
                return;
            }
            this.J.setText(vIPBuyOption.item.remark);
            this.J.setVisibility(0);
        }
    }

    private void e() {
        this.R = (LinearLayout) this.b.findViewById(R.id.layout_new_list);
        this.S = this.b.findViewById(R.id.ll_operate);
        this.T = this.b.findViewById(R.id.pager_operate);
        this.U = this.b.findViewById(R.id.indicator_operate);
        this.V = (TextView) this.b.findViewById(R.id.tv_list_title);
        this.W = (RecyclerView) this.b.findViewById(R.id.recycler_new_list);
        this.X = (TextView) this.b.findViewById(R.id.tv_item_choosed_desc);
        this.Y = (TextView) this.b.findViewById(R.id.tv_privilege_title);
        this.Z = (RecyclerView) this.b.findViewById(R.id.recycler_privilege_list);
        this.aa = (TextView) this.b.findViewById(R.id.tv_service_title);
        this.ab = (TextView) this.b.findViewById(R.id.tv_service_content);
        ShowAllListView showAllListView = (ShowAllListView) this.b.findViewById(R.id.list_view_new_agreement);
        this.ac = showAllListView;
        showAllListView.setBackgroundColor(BluedSkinUtils.a(this.f20426a, 2131102360));
        this.ah = (ImageView) this.b.findViewById(R.id.agreement_btn);
        this.ai = (TextView) this.b.findViewById(R.id.agreement_text);
        this.aj = (LinearLayout) this.b.findViewById(R.id.layout_upgrade_blued_x);
        this.al = this.b.findViewById(R.id.tv_pay_bluedx_btn);
        this.ak = this.b.findViewById(R.id.tv_upgrade_btn);
        this.ah.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                VIPBuyOptionListFragment vIPBuyOptionListFragment = VIPBuyOptionListFragment.this;
                vIPBuyOptionListFragment.am = !vIPBuyOptionListFragment.am;
                VIPBuyOptionListFragment.this.f();
            }
        });
        this.ad = new VIPItemRoundNewAdapter(this.f20426a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f20426a);
        linearLayoutManager.setOrientation(0);
        this.W.setLayoutManager(linearLayoutManager);
        this.W.setAdapter(this.ad);
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter();
        this.ae = bannerPagerAdapter;
        this.T.setAdapter(bannerPagerAdapter);
        this.T.setInterval((long) m.ag);
        this.U.setViewPager(this.T);
        this.ag = new VIPPrivilegeNewAdapter(this.f20426a, getFragmentActive());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f20426a, 2);
        gridLayoutManager.setOrientation(0);
        this.Z.setLayoutManager(gridLayoutManager);
        this.Z.setAdapter(this.ag);
        this.ad.a(new VIPItemRoundNewAdapter.onGoodClick() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$ZdHccenHGB2MDr85PZCD32kzcck
            @Override // com.soft.blued.ui.user.adapter.VIPItemRoundNewAdapter.onGoodClick
            public final void onclick(VIPBuyOption vIPBuyOption) {
                VIPBuyOptionListFragment.this.b(vIPBuyOption);
            }
        });
        g();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.am) {
            this.ah.setImageResource(R.drawable.icon_selected);
        } else {
            this.ah.setImageResource(R.drawable.icon_unselect);
        }
    }

    private void g() {
        String string = this.f20426a.getString(R.string.hello_agree_new);
        String string2 = this.f20426a.getString(R.string.hello_service_agreement_new);
        String string3 = this.f20426a.getString(R.string.hello_stop_interval);
        String string4 = this.f20426a.getString(R.string.hello_subscribe);
        String string5 = this.f20426a.getString(2131890425);
        String str = string + string2 + string3 + string4 + string3 + string5;
        SpannableString spannableString = new SpannableString(str);
        this.ai.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(VIPBuyOptionListFragment.this.getActivity(), H5Url.a(35), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(VIPBuyOptionListFragment.this.f20426a, 2131101766));
                textPaint.setUnderlineText(true);
            }
        }, str.indexOf(string2), (string + string2).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(VIPBuyOptionListFragment.this.getActivity(), H5Url.a(34), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(VIPBuyOptionListFragment.this.f20426a, 2131101766));
                textPaint.setUnderlineText(true);
            }
        }, str.indexOf(string4), (string + string2 + string3 + string4).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(VIPBuyOptionListFragment.this.f20426a, H5Url.a(22), 0);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(VIPBuyOptionListFragment.this.f20426a, 2131101766));
                textPaint.setUnderlineText(true);
            }
        }, str.indexOf(string5), str.length(), 33);
        this.ai.setText(spannableString);
    }

    private void h() {
        this.aj.setVisibility(0);
        this.k.setVisibility(8);
        this.ak.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                VIPBuyOptionListFragment.this.i();
            }
        });
        this.al.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                VIPBuyOptionListFragment.this.k.callOnClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.an != null) {
            return;
        }
        PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipUpgradeModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.9
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipUpgradeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    VIPBuyOptionListFragment.this.k.callOnClick();
                    return;
                }
                VIPBuyOptionListFragment.this.an = VipUpgradeDialogFragment.f20487a.a(VIPBuyOptionListFragment.this.getContext(), VIPBuyOptionListFragment.this.getParentFragmentManager(), bluedEntityA.data, VIPBuyOptionListFragment.this.w);
                VIPBuyOptionListFragment.this.an.a(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.9.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        VIPBuyOptionListFragment.this.an = null;
                    }
                });
            }

            public boolean onUIFailure(int i, String str, String str2) {
                return true;
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.B.setViewPager(this.A);
    }

    public void a() {
        this.Q = (LinearLayout) this.b.findViewById(R.id.layout_list);
        this.N = this.b.findViewById(R.id.tv_bottom_space);
        this.t = this.b.findViewById(R.id.view_coupon_red_dot);
        if (BluedPreferences.cy()) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
        }
        this.O = (RecyclerView) this.b.findViewById(R.id.list_round_items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f20426a);
        linearLayoutManager.setOrientation(0);
        this.O.setLayoutManager(linearLayoutManager);
        this.J = (TextView) this.b.findViewById(R.id.tv_round_item_choosed_desc);
        this.K = (TextView) this.b.findViewById(R.id.tv_list_item_choosed_desc);
        VIPItemRoundAdapter vIPItemRoundAdapter = new VIPItemRoundAdapter(this.f20426a, this.h);
        this.P = vIPItemRoundAdapter;
        vIPItemRoundAdapter.a(new VIPItemRoundAdapter.onGoodClick() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$mjgkd-IGL6Miuq8s1Pjbk86Bxgc
            @Override // com.soft.blued.ui.user.adapter.VIPItemRoundAdapter.onGoodClick
            public final void onclick(VIPBuyOption vIPBuyOption) {
                VIPBuyOptionListFragment.this.d(vIPBuyOption);
            }
        });
        this.O.setAdapter(this.P);
        ShowAllListView showAllListView = (ShowAllListView) this.b.findViewById(R.id.list_view_agreement);
        this.m = showAllListView;
        showAllListView.setBackgroundColor(BluedSkinUtils.a(this.f20426a, 2131102360));
        this.g = (TextView) this.b.findViewById(R.id.tv_desc);
        this.f20427c = (ListView) this.b.findViewById(R.id.list_view);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_buy_btn);
        this.k = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$7gfpTb30PQqj_7HnWGrcHv_O0d4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPBuyOptionListFragment.this.c(view);
            }
        });
        VIPBuyAdapter vIPBuyAdapter = new VIPBuyAdapter(this.f20426a, this.h);
        this.d = vIPBuyAdapter;
        vIPBuyAdapter.a(new VIPBuyAdapter.onGoodClick() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$lDiqVJ3Z9hK0rowGYdc0xeegMsQ
            @Override // com.soft.blued.ui.user.adapter.VIPBuyAdapter.onGoodClick
            public final void onclick(VIPBuyOption vIPBuyOption) {
                VIPBuyOptionListFragment.this.c(vIPBuyOption);
            }
        });
        this.f20427c.setAdapter((ListAdapter) this.d);
        String string = this.f20426a.getResources().getString(R.string.vip_buy_agreement);
        if (this.h == 2) {
            String string2 = this.f20426a.getResources().getString(R.string.vip_will_count_after_svip_end);
            TextView textView2 = this.g;
            textView2.setText(string2 + string);
            if (this.af) {
                this.k.setBackground(this.f20426a.getResources().getDrawable(R.drawable.icon_svip_new_page_buy_btn_bg));
            } else {
                this.k.setBackground(this.f20426a.getResources().getDrawable(R.drawable.icon_svip_new_page_buy_btn_bg));
            }
            this.k.setTextColor(this.f20426a.getResources().getColor(2131102170));
        } else {
            this.g.setText(string);
            if (this.af) {
                this.k.setBackground(this.f20426a.getResources().getDrawable(R.drawable.icon_vip_new_page_buy_btn_bg));
            } else {
                this.k.setBackground(this.f20426a.getResources().getDrawable(R.drawable.icon_vip_new_page_buy_btn_bg));
            }
            this.k.setTextColor(this.f20426a.getResources().getColor(2131102203));
        }
        this.f.refresh();
        PayHttpUtils.a(this.f, (IRequestHost) getFragmentActive(), this.M, "vip");
    }

    public void a(BluedEntityA<VIPBuyOptionForJsonParse> bluedEntityA) {
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0) == null) {
            return;
        }
        this.af = ((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).is_new_face == 1;
        if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).upgrade_button == 1 && this.h == 2 && this.v) {
            h();
            if (this.w) {
                if (this.aj.getVisibility() == 8) {
                    h();
                }
                i();
            }
        } else {
            this.aj.setVisibility(8);
            this.k.setVisibility(0);
        }
        if (((VIPBuyOptionForJsonParse) bluedEntityA.getSingleData()).is_new_face == 1) {
            b(bluedEntityA);
            return;
        }
        c(bluedEntityA);
        if (this.h == 1) {
            if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list != null) {
                List<VIPPrivilegeModel> list = ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).vip_list.privilege_list;
                if (list == null || list.size() <= 0) {
                    this.x.setVisibility(8);
                    return;
                }
                this.x.setVisibility(0);
                this.A.a(getFragmentActive(), list);
            }
        } else if (((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list != null) {
            List<VIPPrivilegeModel> list2 = ((VIPBuyOptionForJsonParse) bluedEntityA.data.get(0)).svip_list.privilege_list;
            if (list2 == null || list2.size() <= 0) {
                this.x.setVisibility(8);
                return;
            }
            this.x.setVisibility(0);
            this.A.a(getFragmentActive(), list2);
        }
    }

    public void a(final VIPBuyOption vIPBuyOption, boolean z) {
        if (vIPBuyOption == null || !this.u) {
            return;
        }
        if (z) {
            a(vIPBuyOption.id);
        } else {
            DelayRepeatTaskUtils.a("getCouponData", new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$Vau4rdO2X7E9BnNV5TyBSibsfQ0
                @Override // java.lang.Runnable
                public final void run() {
                    VIPBuyOptionListFragment.this.a(vIPBuyOption);
                }
            }, 500);
        }
    }

    public void b() {
        VIPBuyOption a2 = this.O.getVisibility() == 0 ? this.P.a() : this.d.a();
        if (this.af) {
            a2 = this.ad.a();
        }
        View findViewById = this.b.findViewById(R.id.view_coupon);
        this.s = findViewById;
        if (!this.u) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_discount);
        final VIPBuyOption vIPBuyOption = a2;
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPBuyOptionListFragment$ALFNMzA3pLCvMReJFZXJ2bEbv1Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPBuyOptionListFragment.this.a(vIPBuyOption, view);
            }
        });
        this.s.setVisibility(0);
        if (a2 == null) {
            return;
        }
        BluedCoupon bluedCoupon = this.q;
        if (bluedCoupon == null || bluedCoupon.is_available != 1) {
            this.q = null;
            int i = this.r;
            if (i == -1 || i == 0) {
                textView.setText("");
            } else {
                textView.setText(this.f20426a.getResources().getString(R.string.no_available_coupon));
            }
            if (a2 == null || a2.item == null || StringUtils.d(a2.item.button)) {
                return;
            }
            this.k.setText(a2.item.button);
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String str = "-￥" + decimalFormat.format(this.q.money);
        textView.setText(str);
        this.k.setText(String.format(this.f20426a.getResources().getString(R.string.money_after_discount), decimalFormat.format(a2.money - Double.parseDouble(this.q.money)) + ""));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 101 || intent == null) {
            return;
        }
        BluedCoupon bluedCoupon = (BluedCoupon) intent.getSerializableExtra(CouponFragment.b);
        if (i2 == -1) {
            this.r = -1;
            this.q = bluedCoupon;
            b();
        } else if (i2 != 0) {
        } else {
            this.r = 0;
            if (bluedCoupon == null || !(this.q == null || bluedCoupon.id == this.q.id)) {
                this.q = null;
                b();
            }
        }
    }

    public boolean onBackPressed() {
        Log.v("drb", "child onBackPressed");
        VIPBuyOnBackPressedObserver.a().b();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20426a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_vip_buy_option_list, viewGroup, false);
            LoadOptions loadOptions = new LoadOptions();
            this.l = loadOptions;
            loadOptions.d = 2131237310;
            this.l.b = 2131237310;
            a();
            d();
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        this.an = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0178, code lost:
        if (r0.equals("dynamic_skin") != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setUserVisibleHint(boolean r6) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.VIPBuyOptionListFragment.setUserVisibleHint(boolean):void");
    }
}
