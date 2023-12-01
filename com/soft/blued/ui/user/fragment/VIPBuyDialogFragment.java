package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.CirclePageIndicator;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.ui.user.model.VIPBuyOptionForJsonParse;
import com.soft.blued.ui.user.model.VIPRightDescForSelling;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.views.VIPDiaglogBuyOptionView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPBuyDialogFragment.class */
public class VIPBuyDialogFragment extends BaseFragment implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f34099a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f34100c;
    private Dialog d;
    private String f;
    private int g;
    private AutoScrollViewPager h;
    private ImageView i;
    private TextView j;
    private ImageView k;
    private CirclePageIndicator l;
    private TextView m;
    private LinearLayout n;
    private ShapeTextView o;
    private TextView p;
    private VIPBuyOption s;
    private MyPagerAdapter t;
    private VipProtos.FromType u;
    private int e = 1;
    private List<VIPDiaglogBuyOptionView> q = new ArrayList();
    private List<VIPBuyOption> r = new ArrayList();
    private List<View> v = new ArrayList();
    private BluedUIHttpResponse w = new BluedUIHttpResponse<BluedEntityA<VIPBuyOptionForJsonParse>>("vip_dialog_goods", getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<VIPBuyOptionForJsonParse> bluedEntityA) {
            if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0 && bluedEntityA.data.get(0) != null) {
                if (VIPBuyDialogFragment.this.e == 1) {
                    if (bluedEntityA.data.get(0).vip_list != null) {
                        VIPBuyDialogFragment.this.r = bluedEntityA.data.get(0).vip_list.list;
                        VIPBuyDialogFragment.this.a(bluedEntityA.data.get(0).vip_list.privilege);
                    }
                } else if (bluedEntityA.data.get(0).svip_list != null) {
                    VIPBuyDialogFragment.this.r = bluedEntityA.data.get(0).svip_list.list;
                    VIPBuyDialogFragment.this.a(bluedEntityA.data.get(0).svip_list.privilege);
                }
                VIPBuyDialogFragment.this.h.a();
            }
            VIPBuyDialogFragment.this.a(0);
            for (int i = 0; i < VIPBuyDialogFragment.this.r.size(); i++) {
                if (((VIPBuyOption) VIPBuyDialogFragment.this.r.get(i)).is_hot == 1) {
                    VIPBuyDialogFragment.this.a(i);
                    return;
                }
            }
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPBuyDialogFragment$MyPagerAdapter.class */
    public class MyPagerAdapter extends PagerAdapter {
        public MyPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (VIPBuyDialogFragment.this.v != null) {
                return VIPBuyDialogFragment.this.v.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) VIPBuyDialogFragment.this.v.get(i));
            return VIPBuyDialogFragment.this.v.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public void a() {
        PayHttpUtils.a(this.w, getFragmentActive(), "new_vip", this.g);
    }

    public void a(int i) {
        List<VIPBuyOption> list;
        List<VIPDiaglogBuyOptionView> list2 = this.q;
        if (list2 == null || list2.size() <= 0 || (list = this.r) == null || list.size() <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.r.size()) {
                break;
            }
            if (i == i3) {
                this.r.get(i3).choosen = true;
                this.s = this.r.get(i3);
            } else {
                this.r.get(i3).choosen = false;
            }
            if (i3 < this.q.size()) {
                this.q.get(i3).setOptionView(this.r.get(i3));
            }
            i2 = i3 + 1;
        }
        if (StringUtils.d(this.s.item.button)) {
            this.o.setText(this.f34099a.getResources().getString(R.string.get_it_right_now));
        } else {
            this.o.setText(this.s.item.button);
        }
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (z) {
            getActivity().finish();
        }
    }

    public void a(List<VIPRightDescForSelling> list) {
        b(list);
        this.t.notifyDataSetChanged();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            if (list.get(i2).is_hot == 1) {
                this.h.setCurrentItem(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    public void b() {
        this.d = DialogUtils.a(this.f34099a);
        AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) this.b.findViewById(2131373209);
        this.h = autoScrollViewPager;
        autoScrollViewPager.setInterval(4000L);
        this.i = (ImageView) this.b.findViewById(R.id.img_shift);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_shift);
        this.j = textView;
        if (this.e == 1) {
            textView.setText(R.string.check_svip);
        } else {
            textView.setText(R.string.check_vip);
        }
        this.k = (ImageView) this.b.findViewById(2131364488);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) this.b.findViewById(2131364744);
        this.l = circlePageIndicator;
        circlePageIndicator.setInterval(DensityUtils.a(this.f34099a, 5.0f));
        this.m = (TextView) this.b.findViewById(R.id.tv_vip_desc);
        this.n = (LinearLayout) this.b.findViewById(R.id.ll_options);
        VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView = (VIPDiaglogBuyOptionView) this.b.findViewById(R.id.option1);
        VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView2 = (VIPDiaglogBuyOptionView) this.b.findViewById(R.id.option2);
        VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView3 = (VIPDiaglogBuyOptionView) this.b.findViewById(R.id.option3);
        VIPDiaglogBuyOptionView vIPDiaglogBuyOptionView4 = (VIPDiaglogBuyOptionView) this.b.findViewById(R.id.option4);
        this.q.add(vIPDiaglogBuyOptionView);
        this.q.add(vIPDiaglogBuyOptionView2);
        this.q.add(vIPDiaglogBuyOptionView3);
        this.q.add(vIPDiaglogBuyOptionView4);
        this.o = (ShapeTextView) this.b.findViewById(R.id.tv_buy_btn);
        this.p = (TextView) this.b.findViewById(2131372705);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter();
        this.t = myPagerAdapter;
        this.h.setAdapter(myPagerAdapter);
        this.l.setViewPager(this.h);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        vIPDiaglogBuyOptionView.setOnClickListener(this);
        vIPDiaglogBuyOptionView2.setOnClickListener(this);
        vIPDiaglogBuyOptionView3.setOnClickListener(this);
        vIPDiaglogBuyOptionView4.setOnClickListener(this);
        this.o.setOnClickListener(this);
        if (this.e == 2) {
            this.m.setText(this.f34099a.getResources().getString(R.string.svip_membership));
            this.p.setText(this.f34099a.getResources().getString(R.string.vip_will_count_after_svip_end) + this.f34099a.getResources().getString(R.string.vip_buy_agreement_dialog));
            TypefaceUtils.a(this.f34099a, this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(VIPBuyDialogFragment.this.f34099a, H5Url.a(35), 0);
                }
            }, new TypefaceUtils.SpannIndex(51, 64), new TypefaceUtils.SpannIndex(204, 235), true);
            TypefaceUtils.a(this.f34099a, this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(VIPBuyDialogFragment.this.f34099a, H5Url.a(22), 0);
                }
            }, new TypefaceUtils.SpannIndex(65, 69), new TypefaceUtils.SpannIndex(236, 250), true);
            TypefaceUtils.a(this.f34099a, this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(VIPBuyDialogFragment.this.f34099a, H5Url.a(34), 0);
                }
            }, new TypefaceUtils.SpannIndex(70, 83), new TypefaceUtils.SpannIndex(251, 297), true);
            this.h.setBackgroundResource(R.drawable.bg_buy_vip_dialog_yellow);
        } else {
            this.m.setText(this.f34099a.getResources().getString(R.string.vip_membership));
            this.p.setText(this.f34099a.getResources().getString(R.string.vip_buy_agreement_dialog));
            TypefaceUtils.a(this.f34099a, this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(VIPBuyDialogFragment.this.f34099a, H5Url.a(35), 0);
                }
            }, new TypefaceUtils.SpannIndex(27, 40), new TypefaceUtils.SpannIndex(122, 153), true);
            TypefaceUtils.a(this.f34099a, this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(VIPBuyDialogFragment.this.f34099a, H5Url.a(22), 0);
                }
            }, new TypefaceUtils.SpannIndex(41, 45), new TypefaceUtils.SpannIndex(154, 165), true);
            TypefaceUtils.a(this.f34099a, this.p, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPBuyDialogFragment.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(VIPBuyDialogFragment.this.f34099a, H5Url.a(34), 0);
                }
            }, new TypefaceUtils.SpannIndex(46, 59), new TypefaceUtils.SpannIndex(166, 215), true);
            this.h.setBackgroundResource(R.drawable.bg_buy_vip_dialog_blue);
        }
        this.w.refresh();
        a();
    }

    public void b(List<VIPRightDescForSelling> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.v.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            VIPRightDescForSelling vIPRightDescForSelling = list.get(i2);
            View inflate = this.f34100c.inflate(R.layout.item_vip_buy_head_vp, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(2131364552);
            TextView textView = (TextView) inflate.findViewById(2131372046);
            TextView textView2 = (TextView) inflate.findViewById(2131371262);
            ImageLoader.a(getFragmentActive(), vIPRightDescForSelling.icon).a(imageView);
            textView.setText(vIPRightDescForSelling.title);
            textView2.setText(vIPRightDescForSelling.description);
            this.v.add(inflate);
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131364488:
                EventTrackVIP.a(VipProtos.Event.VIP_BUY_BACK_BTN_CLICK);
                getActivity().finish();
                return;
            case R.id.img_shift /* 2131364681 */:
            case R.id.tv_shift /* 2131372588 */:
                EventTrackVIP.a(VipProtos.Event.VIP_BUY_SWITCH_BTN_CLICK, this.e == 1 ? VipProtos.Name.VIP : VipProtos.Name.SVIP, VipProtos.PageVersion.V_0813);
                if (this.e == 2) {
                    PayUtils.a(this.f34099a, 1, this.f, this.g, this.u);
                } else {
                    PayUtils.a(this.f34099a, 2, this.f, this.g, this.u);
                }
                ActivityChangeAnimationUtils.k(getActivity());
                getActivity().finish();
                return;
            case R.id.option1 /* 2131368785 */:
                a(0);
                return;
            case R.id.option2 /* 2131368786 */:
                a(1);
                return;
            case R.id.option3 /* 2131368787 */:
                a(2);
                return;
            case R.id.option4 /* 2131368788 */:
                a(3);
                return;
            case R.id.tv_buy_btn /* 2131371033 */:
                EventTrackVIP.a(VipProtos.Event.VIP_BUY_OPEN_BTN_CLICK, this.e == 1 ? VipProtos.Name.VIP : VipProtos.Name.SVIP, this.u, VipProtos.PageVersion.V_0813);
                PayPreOrderFragment.a(this.f34099a, this.s, "popup", "", "", "", this.f);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34099a = getActivity();
        this.f34100c = layoutInflater;
        if (this.b == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.e = arguments.getInt("KEY_VIP_GRADE");
                this.f = arguments.getString("KEY_DETAIL");
                this.g = arguments.getInt("KEY_RIGHT_ID");
                this.u = (VipProtos.FromType) arguments.getSerializable("KEY_RIGHT_ID");
            }
            this.b = this.f34100c.inflate(R.layout.fragment_vip_buy_new, viewGroup, false);
            b();
            StatusBarHelper.a((Activity) getActivity(), false);
            VIPBuyResultObserver.a().a(this, getLifecycle());
        }
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_SHOW, this.e == 1 ? VipProtos.Name.VIP : VipProtos.Name.SVIP, this.u, VipProtos.PageVersion.V_0813);
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.d;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.d.dismiss();
    }
}
