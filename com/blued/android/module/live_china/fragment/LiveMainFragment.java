package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.live.base.utils.LiveSettingConfig;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveMainBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveTabInfo;
import com.blued.android.module.live_china.model.LiveTabModel;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.observer.LiveTagsSetSelectedTab;
import com.blued.android.module.live_china.pop.LiveLiangExpirePop;
import com.blued.android.module.live_china.pop.LiveLiangIDReceivedPop;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view_model.LiveMainViewModel;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import skin.support.observe.SkinObservable;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMainFragment.class */
public final class LiveMainFragment extends MVVMBaseFragment<LiveMainViewModel> implements BluedSkinObserver, LiveTagsSetSelectedTab.iLiveTagsSetSelectedTab {
    static final /* synthetic */ KProperty<Object>[] a = {Reflection.a(new PropertyReference1Impl(LiveMainFragment.class, "viewBinding", "getViewBinding()Lcom/blued/android/module/live_china/databinding/FragmentLiveMainBinding;", 0))};
    private final ViewBindingProperty b;
    private LiveTabInfo c;
    private List<LiveTabModel> d;
    private LiveLiangIDReceivedPop e;
    private LiveLiangExpirePop f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private LiveTwoFloorModel k;
    private int l;
    private String m;
    private String n;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMainFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentStatePagerAdapter {
        private final LiveMainViewModel a;
        private List<? extends LiveTabModel> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fragmentManager, List<? extends LiveTabModel> tabs, LiveMainViewModel mViewModel) {
            super(fragmentManager, 1);
            Intrinsics.e(tabs, "tabs");
            Intrinsics.e(mViewModel, "mViewModel");
            Intrinsics.a(fragmentManager);
            this.a = mViewModel;
            this.b = tabs;
        }

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            super.destroyItem(container, i, object);
        }

        public int getCount() {
            List<? extends LiveTabModel> list = this.b;
            Intrinsics.a(list);
            return list.size();
        }

        public Fragment getItem(int i) {
            LiveTabModel liveTabModel;
            LiveTabModel liveTabModel2;
            LiveTabModel liveTabModel3;
            String str;
            LiveTabModel liveTabModel4;
            LiveTabModel liveTabModel5;
            String str2;
            List<? extends LiveTabModel> list = this.b;
            if (!TextUtils.equals((list == null || (liveTabModel = list.get(i)) == null) ? null : liveTabModel.id, "15")) {
                LiveTabFragmentNew liveTabFragmentNew = new LiveTabFragmentNew();
                Bundle bundle = new Bundle();
                List<? extends LiveTabModel> list2 = this.b;
                bundle.putString("tabId", (list2 == null || (liveTabModel2 = list2.get(i)) == null) ? null : liveTabModel2.id);
                List<? extends LiveTabModel> list3 = this.b;
                bundle.putString("tabName", (list3 == null || (liveTabModel3 = list3.get(i)) == null) ? null : liveTabModel3.name);
                List<? extends LiveTabModel> list4 = this.b;
                if (list4 == null) {
                    str = null;
                } else {
                    LiveTabModel liveTabModel6 = list4.get(i);
                    str = liveTabModel6 == null ? null : liveTabModel6.data_point;
                }
                bundle.putString("tabPoint", str);
                bundle.putString("live_pay_beans_details", this.a.h());
                this.a.a("");
                liveTabFragmentNew.setArguments(bundle);
                return liveTabFragmentNew;
            }
            Fragment liveFootPrintFragmentN = new LiveFootPrintFragmentN();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("from", 1);
            List<? extends LiveTabModel> list5 = this.b;
            bundle2.putString("tabId", (list5 == null || (liveTabModel4 = list5.get(i)) == null) ? null : liveTabModel4.id);
            List<? extends LiveTabModel> list6 = this.b;
            bundle2.putString("tabName", (list6 == null || (liveTabModel5 = list6.get(i)) == null) ? null : liveTabModel5.name);
            List<? extends LiveTabModel> list7 = this.b;
            if (list7 == null) {
                str2 = null;
            } else {
                LiveTabModel liveTabModel7 = list7.get(i);
                str2 = liveTabModel7 == null ? null : liveTabModel7.data_point;
            }
            bundle2.putString("tabPoint", str2);
            bundle2.putString("live_pay_beans_details", this.a.h());
            this.a.a("");
            liveFootPrintFragmentN.setArguments(bundle2);
            return liveFootPrintFragmentN;
        }

        public int getItemPosition(Object object) {
            Intrinsics.e(object, "object");
            return -2;
        }

        public CharSequence getPageTitle(int i) {
            LiveTabModel liveTabModel;
            List<? extends LiveTabModel> list = this.b;
            String str = null;
            if (list != null && (liveTabModel = list.get(i)) != null) {
                str = liveTabModel.name;
            }
            return str;
        }

        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            Object instantiateItem = super.instantiateItem(container, i);
            Intrinsics.c(instantiateItem, "super.instantiateItem(container, position)");
            return instantiateItem;
        }

        public void setPrimaryItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            super.setPrimaryItem(container, i, object);
        }
    }

    public LiveMainFragment() {
        super(R.layout.fragment_live_main);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveMainFragment, FragmentLiveMainBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveMainFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLiveMainBinding invoke(LiveMainFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveMainBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveMainFragment, FragmentLiveMainBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveMainFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLiveMainBinding invoke(LiveMainFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveMainBinding.a(fragment.requireView());
            }
        });
        this.d = new ArrayList();
        this.m = "";
        this.n = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMainFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.y();
    }

    private final void y() {
        FragmentLiveMainBinding p;
        PageTabLayout pageTabLayout;
        ArrayList<PageTabLayout.Tab> tabs;
        PageTabLayout pageTabLayout2;
        ArrayList<PageTabLayout.Tab> tabs2;
        PageTabLayout pageTabLayout3;
        FragmentLiveMainBinding p2 = p();
        Integer num = null;
        if (p2 != null && (pageTabLayout3 = p2.b) != null) {
            num = Integer.valueOf(pageTabLayout3.getWidth());
        }
        Intrinsics.a(num);
        int intValue = num.intValue();
        FragmentLiveMainBinding p3 = p();
        int i = 0;
        int i2 = 0;
        if (p3 != null && (pageTabLayout2 = p3.b) != null && (tabs2 = pageTabLayout2.getTabs()) != null) {
            Iterator<PageTabLayout.Tab> it = tabs2.iterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                View a2 = it.next().a();
                if (a2 != null) {
                    View findViewById = a2.findViewById(R.id.shape_layout);
                    View findViewById2 = a2.findViewById(R.id.rl_content);
                    if (i2 > 0 || findViewById.getWidth() + i3 <= intValue) {
                        i3 += a2.getWidth();
                        i4 += findViewById2.getWidth();
                        i5++;
                    } else {
                        i2 = ((intValue - i4) - (findViewById2.getWidth() / 2)) / ((i5 * 2) + 1);
                    }
                }
            }
        }
        if (i <= 0 || (p = p()) == null || (pageTabLayout = p.b) == null || (tabs = pageTabLayout.getTabs()) == null) {
            return;
        }
        for (PageTabLayout.Tab tab : tabs) {
            View a3 = tab.a();
            if (a3 != null) {
                a3.findViewById(R.id.shape_layout);
            }
        }
    }

    private final void z() {
        if (LiveRoomPreferences.v() <= 0) {
            Date date = new Date(System.currentTimeMillis());
            if ((date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate() > LiveRoomPreferences.w()) {
                LiveMainViewModel a2 = a();
                ActivityFragmentActive fragmentActive = getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                a2.d(fragmentActive);
            }
        }
    }

    public final void a(float f, int i) {
        FragmentLiveMainBinding p = p();
        if (p == null) {
            return;
        }
        View view = p.a;
        if (view != null) {
            view.setAlpha(1 - Math.min(f * 1.8f, 1.0f));
        }
        FrameLayout frameLayout = p.c;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setAlpha(1 - Math.min(f * 1.8f, 1.0f));
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(LiveTabInfo data) {
        PageTabLayout pageTabLayout;
        PageTabLayout pageTabLayout2;
        PageTabLayout.Tab a2;
        PageTabLayout pageTabLayout3;
        PageTabLayout.Tab a3;
        PageTabLayout pageTabLayout4;
        Intrinsics.e(data, "data");
        this.c = data;
        if (data == null) {
            return;
        }
        List<LiveTabModel> jj = data.liveTabs;
        q().clear();
        List<LiveTabModel> q = q();
        Intrinsics.c(jj, "jj");
        q.addAll(jj);
        FragmentLiveMainBinding p = p();
        ViewPager viewPager = p == null ? null : p.d;
        if (viewPager != null) {
            viewPager.setAdapter(new MyAdapter(getChildFragmentManager(), q(), a()));
        }
        FragmentLiveMainBinding p2 = p();
        ViewPager viewPager2 = p2 == null ? null : p2.d;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(1);
        }
        FragmentLiveMainBinding p3 = p();
        if (p3 != null && (pageTabLayout4 = p3.b) != null) {
            FragmentLiveMainBinding p4 = p();
            pageTabLayout4.setupWithViewPager(p4 == null ? null : p4.d);
        }
        Iterator<LiveTabModel> it = q().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            LiveTabModel next = it.next();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.live_item_tab, (ViewGroup) null);
            Intrinsics.c(inflate, "from(context).inflate(R.…yout.live_item_tab, null)");
            View findViewById = inflate.findViewById(R.id.shape_tv);
            Intrinsics.c(findViewById, "tabView.findViewById(R.id.shape_tv)");
            ShapeTextView shapeTextView = (ShapeTextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.tv_tab_dot);
            Intrinsics.c(findViewById2, "tabView.findViewById(R.id.tv_tab_dot)");
            ShapeTextView shapeTextView2 = (ShapeTextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.rectangular_icon);
            Intrinsics.c(findViewById3, "tabView.findViewById(R.id.rectangular_icon)");
            ImageView imageView = (ImageView) findViewById3;
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_h);
            String language = BlueAppLocal.c().getLanguage();
            if (TextUtils.isEmpty(next.rectangular_icon)) {
                BluedViewExKt.b((View) shapeTextView);
                BluedViewExKt.a(imageView);
                if (Intrinsics.a((Object) "zh", (Object) language)) {
                    shapeTextView.setText(next.name);
                } else {
                    shapeTextView.setText(next.en_name);
                }
            } else {
                BluedViewExKt.c((View) shapeTextView);
                BluedViewExKt.b(imageView);
                ImageLoader.a(getFragmentActive(), next.rectangular_icon).a(imageView);
            }
            FragmentLiveMainBinding p5 = p();
            if (p5 != null && (pageTabLayout3 = p5.b) != null && (a3 = pageTabLayout3.a(i2)) != null) {
                a3.a(inflate);
            }
            if (next.red_point == 1) {
                BluedViewExKt.b((View) shapeTextView2);
            } else {
                BluedViewExKt.a((View) shapeTextView2);
            }
            if (i2 == u()) {
                c(i2);
            } else {
                d(i2);
            }
            FragmentLiveMainBinding p6 = p();
            if (p6 != null && (pageTabLayout2 = p6.b) != null && (a2 = pageTabLayout2.a(i2)) != null) {
                a2.a(inflate);
            }
            if (!TextUtils.isEmpty(v()) && TextUtils.equals(next.id, v())) {
                a(i2);
            }
            i = i2 + 1;
        }
        FragmentLiveMainBinding p7 = p();
        PageTabLayout pageTabLayout5 = p7 == null ? null : p7.b;
        if (pageTabLayout5 != null) {
            pageTabLayout5.setVisibility(0);
        }
        FragmentLiveMainBinding p8 = p();
        ViewPager viewPager3 = p8 == null ? null : p8.d;
        if (viewPager3 != null) {
            viewPager3.setCurrentItem(u());
        }
        a("");
        FragmentLiveMainBinding p9 = p();
        if (p9 == null || (pageTabLayout = p9.b) == null) {
            return;
        }
        pageTabLayout.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMainFragment$eCUd637TIbqsVLv2ucAuWtG2r5k
            @Override // java.lang.Runnable
            public final void run() {
                LiveMainFragment.a(LiveMainFragment.this);
            }
        });
    }

    public final void a(LiveTwoFloorModel liveTwoFloorModel) {
        this.k = liveTwoFloorModel;
    }

    public final void a(MultiDialogModel model) {
        Intrinsics.e(model, "model");
        if (model.isInit) {
            if (model.from_type != 0) {
                LiveRouteUtil.a(this, (MultiDialogModel) null);
                return;
            }
            model.isInit = false;
            LiveRouteUtil.a(this, model);
        }
    }

    public final void a(String str) {
        this.m = str;
    }

    public final void a(List<LiveLiangModel> datas) {
        LiveLiangModel liveLiangModel;
        Intrinsics.e(datas, "datas");
        if (datas.size() > 0 && (liveLiangModel = datas.get(0)) != null) {
            if (liveLiangModel.is_first_default == 1) {
                liveLiangModel.is_first_default = 0;
                this.g = true;
                LiveLiangIDReceivedPop liveLiangIDReceivedPop = this.e;
                if (liveLiangIDReceivedPop != null) {
                    Intrinsics.a(liveLiangIDReceivedPop);
                    if (liveLiangIDReceivedPop.s()) {
                        return;
                    }
                }
                this.e = LiveLiangIDReceivedPop.a(getContext(), liveLiangModel.liang_id, getFragmentActive());
            } else if (StringUtils.a(liveLiangModel.expire, 0L) > 0 && StringUtils.a(liveLiangModel.expire, 0L) <= 86400) {
                this.g = true;
                LiveLiangExpirePop liveLiangExpirePop = this.f;
                if (liveLiangExpirePop != null) {
                    Intrinsics.a(liveLiangExpirePop);
                    if (liveLiangExpirePop.s()) {
                        return;
                    }
                }
                if (!LiveRoomPreferences.L()) {
                    LiveRoomPreferences.d(true);
                    this.f = LiveLiangExpirePop.a(getContext(), liveLiangModel.liang_id);
                }
            }
        }
        if (this.g) {
            return;
        }
        z();
    }

    @Override // skin.support.observe.SkinObserver
    public void a(SkinObservable skinObservable, Object obj) {
        Iterator<LiveTabModel> it = this.d.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            it.next();
            if (u() == i2) {
                c(i2);
            } else {
                d(i2);
            }
            i = i2 + 1;
        }
    }

    public final void b(int i) {
        if (i != 0 || this.g || this.h) {
            return;
        }
        Date date = new Date(System.currentTimeMillis());
        LiveRoomPreferences.f((date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate());
        LiveRouteUtil.a(this, getFragmentActive(), 0, false, 10020);
    }

    @Override // com.blued.android.module.live_china.observer.LiveTagsSetSelectedTab.iLiveTagsSetSelectedTab
    public void b(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            LiveRoomInfo.a().a(getParentFragment(), 1);
            return;
        }
        int i = 0;
        if (TextUtils.equals(str2, "11")) {
            LiveRoomInfo.a().a(getParentFragment(), 0);
            return;
        }
        LiveRoomInfo.a().a(getParentFragment(), 1);
        if (this.d.size() <= 0) {
            this.m = str;
            return;
        }
        for (LiveTabModel liveTabModel : this.d) {
            if (liveTabModel != null && TextUtils.equals(liveTabModel.id, str2)) {
                FragmentLiveMainBinding p = p();
                ViewPager viewPager = p == null ? null : p.d;
                if (viewPager == null) {
                    return;
                }
                viewPager.setCurrentItem(i);
                return;
            }
            i++;
        }
    }

    public final void b(boolean z) {
        this.j = z;
    }

    public final void c(int i) {
        PageTabLayout pageTabLayout;
        PageTabLayout.Tab a2;
        this.l = i;
        FragmentLiveMainBinding p = p();
        View a3 = (p == null || (pageTabLayout = p.b) == null || (a2 = pageTabLayout.a(i)) == null) ? null : a2.a();
        ShapeTextView shapeTextView = a3 == null ? null : (ShapeTextView) a3.findViewById(R.id.shape_tv);
        if (shapeTextView != null) {
            shapeTextView.setTextSize(15.0f);
        }
        if (shapeTextView != null) {
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_h);
        }
        ImageView imageView = a3 == null ? null : (ImageView) a3.findViewById(R.id.rectangular_icon);
        if (imageView == null) {
            return;
        }
        imageView.setAlpha(1.0f);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public boolean c() {
        return true;
    }

    public final void d(int i) {
        PageTabLayout pageTabLayout;
        PageTabLayout.Tab a2;
        FragmentLiveMainBinding p = p();
        View a3 = (p == null || (pageTabLayout = p.b) == null || (a2 = pageTabLayout.a(i)) == null) ? null : a2.a();
        ShapeTextView shapeTextView = a3 == null ? null : (ShapeTextView) a3.findViewById(R.id.shape_tv);
        if (shapeTextView != null) {
            shapeTextView.setTextSize(14.0f);
        }
        ImageView imageView = a3 == null ? null : (ImageView) a3.findViewById(R.id.rectangular_icon);
        if (imageView != null) {
            imageView.setAlpha(0.5f);
        }
        if (shapeTextView != null) {
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_k);
        }
    }

    public final void e(int i) {
        PageTabLayout pageTabLayout;
        PageTabLayout.Tab a2;
        FragmentLiveMainBinding p = p();
        View a3 = (p == null || (pageTabLayout = p.b) == null || (a2 = pageTabLayout.a(i)) == null) ? null : a2.a();
        ShapeTextView shapeTextView = a3 == null ? null : (ShapeTextView) a3.findViewById(R.id.tv_tab_dot);
        if (shapeTextView == null) {
            return;
        }
        BluedViewExKt.a((View) shapeTextView);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentLiveMainBinding p = p();
        if (p != null) {
            EventTrackLive.g(LiveProtos.Event.LIVE_FIRST_TAB_SHOW, "recommend");
            p.d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveMainFragment$initView$1$1
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    int size = LiveMainFragment.this.q().size();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= size) {
                            break;
                        }
                        if (i3 == i) {
                            LiveMainFragment.this.c(i);
                        } else {
                            LiveMainFragment.this.d(i3);
                        }
                        i2 = i3 + 1;
                    }
                    if (LiveMainFragment.this.q().get(i).red_point_cancel == 1 && LiveMainFragment.this.q().get(i).red_point == 1) {
                        LiveMainFragment.this.q().get(i).red_point = 0;
                        LiveRoomHttpUtils.b((BluedUIHttpResponse) null, LiveMainFragment.this.q().get(i).red_point_word);
                        LiveMainFragment.this.e(i);
                    }
                }
            });
        }
        LiveMainViewModel a2 = a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.c(fragmentActive);
        LiveSettingConfig.a().a(LiveRoomHttpUtils.i());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        LiveMainViewModel a2 = a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.a(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        LiveTagsSetSelectedTab.a().a(this);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LifecycleExtKt.a(lifecycleOwner, a().d(), new LiveMainFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(lifecycleOwner, a().e(), new LiveMainFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(lifecycleOwner, a().f(), new LiveMainFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(lifecycleOwner, a().g(), new LiveMainFragment$liveDataObserver$4(this));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BluedSkinUtils.a(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        BluedSkinUtils.b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        this.h = true;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        this.h = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        this.h = true;
    }

    public final FragmentLiveMainBinding p() {
        return (FragmentLiveMainBinding) this.b.b(this, a[0]);
    }

    public final List<LiveTabModel> q() {
        return this.d;
    }

    public final boolean r() {
        return this.i;
    }

    public final boolean s() {
        return this.j;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.i = z;
        if (!isAdded() || getChildFragmentManager() == null || getChildFragmentManager().getFragments() == null) {
            return;
        }
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.c(fragments, "childFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof LiveTabFragmentNew) {
                ((LiveTabFragmentNew) fragment).v();
            }
        }
    }

    public final LiveTwoFloorModel t() {
        return this.k;
    }

    public final int u() {
        return this.l;
    }

    public final String v() {
        return this.m;
    }

    public final void w() {
        LiveMainViewModel a2 = a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.a(fragmentActive);
    }

    public final int x() {
        if (p() != null) {
            FragmentLiveMainBinding p = p();
            if ((p == null ? null : p.b) != null) {
                FragmentLiveMainBinding p2 = p();
                Intrinsics.a(p2);
                PageTabLayout pageTabLayout = p2.b;
                Intrinsics.a(pageTabLayout);
                return pageTabLayout.getHeight();
            }
            return 0;
        }
        return 0;
    }
}
