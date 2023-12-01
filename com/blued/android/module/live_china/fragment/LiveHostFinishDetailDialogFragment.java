package com.blued.android.module.live_china.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveHostFinishDetailDialogLayoutBinding;
import com.blued.android.module.live_china.databinding.LiveHostFinishDetailTabItemBinding;
import com.blued.android.module.live_china.model.LiveCloseInfoModel;
import com.blued.android.module.live_china.model.LiveFinishTabData;
import com.blued.android.module.live_china.utils.LiveNumFormatUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel;
import com.blued.das.live.LiveProtos;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailDialogFragment.class */
public final class LiveHostFinishDetailDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private LiveCloseInfoModel e;
    private final Lazy b = LazyKt.a(new Function0<LiveHostFinishDetailViewModel>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailDialogFragment$mViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveHostFinishDetailViewModel invoke() {
            ViewModelStore viewModelStore = LiveHostFinishDetailDialogFragment.this.requireActivity().getViewModelStore();
            Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
            ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
            Context d = AppInfo.d();
            if (d != null) {
                return (LiveHostFinishDetailViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(LiveHostFinishDetailViewModel.class);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
    });
    private final Lazy c = LazyKt.a(new Function0<LiveHostFinishDetailDialogLayoutBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveHostFinishDetailDialogLayoutBinding invoke() {
            return LiveHostFinishDetailDialogLayoutBinding.a(LayoutInflater.from(LiveHostFinishDetailDialogFragment.this.getContext()));
        }
    });
    private List<LiveFinishTabData> d = new ArrayList();
    private List<LiveHostFinishDetailTabItemBinding> f = new ArrayList();
    private LiveHostFinishDetailViewModel.ApiState g = LiveHostFinishDetailViewModel.ApiState.ApiStateInfo.a;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveHostFinishDetailDialogFragment a(FragmentManager manager, LiveCloseInfoModel liveCloseInfoModel) {
            Intrinsics.e(manager, "manager");
            LiveHostFinishDetailDialogFragment liveHostFinishDetailDialogFragment = new LiveHostFinishDetailDialogFragment();
            Bundle bundle = new Bundle();
            if (liveCloseInfoModel != null) {
                bundle.putSerializable("model", liveCloseInfoModel);
            }
            liveHostFinishDetailDialogFragment.setArguments(bundle);
            liveHostFinishDetailDialogFragment.show(manager, LiveHostFinishDetailDialogFragment.class.getSimpleName());
            return liveHostFinishDetailDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDetailDialogFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentPagerAdapter {
        private FragmentManager a;
        private List<LiveFinishTabData> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm, List<LiveFinishTabData> tabs) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(tabs, "tabs");
            this.a = fm;
            this.b = tabs;
        }

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            super.destroyItem(container, i, object);
        }

        public int getCount() {
            return this.b.size();
        }

        public Fragment getItem(int i) {
            return LiveHostFinishDetailFragment.a.a(this.b.get(i).getState());
        }

        public CharSequence getPageTitle(int i) {
            return this.b.get(i).getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveHostFinishDetailDialogFragment this$0) {
        LinearLayout linearLayout;
        Intrinsics.e(this$0, "this$0");
        LiveHostFinishDetailDialogLayoutBinding e = this$0.e();
        Intrinsics.a(e);
        LinearLayout linearLayout2 = e.c;
        Intrinsics.a(linearLayout2);
        int width = (linearLayout2.getWidth() - (AppMethods.a(8) * 3)) / 4;
        LinearLayout linearLayout3 = new LinearLayout(this$0.getContext());
        this$0.f.clear();
        Iterator<LiveFinishTabData> it = this$0.d.iterator();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            final LiveFinishTabData next = it.next();
            LiveHostFinishDetailTabItemBinding a2 = LiveHostFinishDetailTabItemBinding.a(LayoutInflater.from(this$0.getContext()));
            Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
            this$0.f.add(a2);
            a2.b.setText(next.getName());
            a2.d.setText(next.getCount());
            if (i2 == 0) {
                ShapeFrameLayout shapeFrameLayout = a2.a;
                Intrinsics.c(shapeFrameLayout, "vbTab.slSelect");
                BluedViewExKt.b(shapeFrameLayout);
            } else {
                ShapeFrameLayout shapeFrameLayout2 = a2.a;
                Intrinsics.c(shapeFrameLayout2, "vbTab.slSelect");
                BluedViewExKt.a(shapeFrameLayout2);
            }
            if (Intrinsics.a(next.getState(), LiveHostFinishDetailViewModel.ApiState.ApiNewFans.a)) {
                TextView textView = a2.c;
                Intrinsics.c(textView, "vbTab.tvName1");
                BluedViewExKt.b(textView);
                a2.c.setText(this$0.getString(R.string.live_host_finish_people_add));
            } else {
                TextView textView2 = a2.c;
                Intrinsics.c(textView2, "vbTab.tvName1");
                BluedViewExKt.a(textView2);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, width);
            int i3 = i2 % 4;
            if (i3 == 3) {
                layoutParams.rightMargin = AppMethods.a(0);
            } else {
                layoutParams.rightMargin = AppMethods.a(8);
            }
            if (i3 == 0) {
                linearLayout3 = new LinearLayout(this$0.getContext());
                linearLayout3.setOrientation(0);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.setMargins(0, AppMethods.a(11), 0, 0);
                linearLayout3.addView(a2.getRoot(), layoutParams);
                LiveHostFinishDetailDialogLayoutBinding e2 = this$0.e();
                if (e2 != null && (linearLayout = e2.c) != null) {
                    linearLayout.addView(linearLayout3, layoutParams2);
                }
            } else {
                linearLayout3.addView(a2.getRoot(), layoutParams);
            }
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDetailDialogFragment$g9YluL0-sT6JGjlOzH8ALz4dzEE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveHostFinishDetailDialogFragment.a(LiveFinishTabData.this, this$0, i2, view);
                }
            });
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHostFinishDetailDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveFinishTabData tab, LiveHostFinishDetailDialogFragment this$0, int i, View view) {
        Intrinsics.e(tab, "$tab");
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.i(LiveProtos.Event.ANCHOR_END_PAGE_MORE_LIST_PAGE_SHOW, tab.getName());
        this$0.e().e.setCurrentItem(i);
    }

    public final void a(int i) {
        Iterator<LiveHostFinishDetailTabItemBinding> it = this.f.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            LiveHostFinishDetailTabItemBinding next = it.next();
            if (i3 == i) {
                ShapeFrameLayout shapeFrameLayout = next.a;
                Intrinsics.c(shapeFrameLayout, "viewBind.slSelect");
                BluedViewExKt.b(shapeFrameLayout);
            } else {
                ShapeFrameLayout shapeFrameLayout2 = next.a;
                Intrinsics.c(shapeFrameLayout2, "viewBind.slSelect");
                BluedViewExKt.a(shapeFrameLayout2);
            }
            i2 = i3 + 1;
        }
    }

    public final void a(LiveCloseInfoModel liveCloseInfoModel) {
        this.e = liveCloseInfoModel;
    }

    public final void b(LiveCloseInfoModel liveCloseInfoModel) {
        if (liveCloseInfoModel == null) {
            return;
        }
        a(liveCloseInfoModel);
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.f.get();
        String format = simpleDateFormat == null ? null : simpleDateFormat.format(new Date(liveCloseInfoModel.start_time * 1000));
        SimpleDateFormat simpleDateFormat2 = TimeAndDateUtils.f.get();
        String format2 = simpleDateFormat2 == null ? null : simpleDateFormat2.format(new Date(liveCloseInfoModel.end_time * 1000));
        TextView textView = e().d;
        textView.setText(((Object) format) + '-' + ((Object) format2) + getString(R.string.live_host_finish_this_time));
        List<LiveFinishTabData> j = j();
        Iterator<LiveHostFinishDetailTabItemBinding> it = f().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            LiveHostFinishDetailTabItemBinding next = it.next();
            if (i2 < j.size()) {
                next.d.setText(j.get(i2).getCount());
            }
            i = i2 + 1;
        }
    }

    public final LiveHostFinishDetailViewModel d() {
        return (LiveHostFinishDetailViewModel) this.b.getValue();
    }

    public final LiveHostFinishDetailDialogLayoutBinding e() {
        return (LiveHostFinishDetailDialogLayoutBinding) this.c.getValue();
    }

    public final List<LiveHostFinishDetailTabItemBinding> f() {
        return this.f;
    }

    public final void g() {
        Serializable serializable;
        Bundle arguments = getArguments();
        if (arguments == null || (serializable = arguments.getSerializable("model")) == null || !(serializable instanceof LiveCloseInfoModel)) {
            return;
        }
        a((LiveCloseInfoModel) serializable);
    }

    public final void h() {
        View view;
        LinearLayout linearLayout;
        ImageView imageView;
        this.d.clear();
        LiveHostFinishDetailDialogLayoutBinding e = e();
        ViewGroup.LayoutParams layoutParams = (e == null || (view = e.f) == null) ? null : view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = DensityUtils.a(getActivity());
        }
        this.d.addAll(j());
        ImageWrapper a2 = ImageLoader.a(a(), ImgURLMap.a.a("live_host_icon_back"));
        LiveHostFinishDetailDialogLayoutBinding e2 = e();
        a2.a(e2 == null ? null : e2.a);
        ImageLoader.a(a(), ImgURLMap.a.a("live_host_icon_header_bg")).a(e().b);
        LiveHostFinishDetailDialogLayoutBinding e3 = e();
        if (e3 != null && (imageView = e3.a) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDetailDialogFragment$5pBrllih0CeHVy9VBLS8RaoX7hE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveHostFinishDetailDialogFragment.a(LiveHostFinishDetailDialogFragment.this, view2);
                }
            });
        }
        LiveHostFinishDetailDialogLayoutBinding e4 = e();
        if (e4 != null && (linearLayout = e4.c) != null) {
            linearLayout.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDetailDialogFragment$UwmPNwd1MB7KeId43VWNfdsGbRA
                @Override // java.lang.Runnable
                public final void run() {
                    LiveHostFinishDetailDialogFragment.a(LiveHostFinishDetailDialogFragment.this);
                }
            });
        }
        ViewPager viewPager = e().e;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        viewPager.setAdapter(new MyAdapter(childFragmentManager, this.d));
        e().e.setCurrentItem(0);
        e().e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailDialogFragment$initView$3
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                LiveHostFinishDetailDialogFragment.this.a(i);
            }
        });
        a(0);
        d().a(this.g);
    }

    public final void i() {
        LifecycleExtKt.a((LifecycleOwner) this, d().d(), new Function1<LiveCloseInfoModel, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDetailDialogFragment$liveDataObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(LiveCloseInfoModel liveCloseInfoModel) {
                LiveHostFinishDetailDialogFragment.this.b(liveCloseInfoModel);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(LiveCloseInfoModel liveCloseInfoModel) {
                a(liveCloseInfoModel);
                return Unit.a;
            }
        });
    }

    public final List<LiveFinishTabData> j() {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            this.e = new LiveCloseInfoModel();
        }
        LiveCloseInfoModel liveCloseInfoModel = this.e;
        if (liveCloseInfoModel != null) {
            ArrayList arrayList2 = arrayList;
            String string = getString(R.string.live_host_finish_beans);
            Intrinsics.c(string, "getString(R.string.live_host_finish_beans)");
            arrayList2.add(new LiveFinishTabData(string, LiveNumFormatUtil.a.a(liveCloseInfoModel.received_beans), LiveHostFinishDetailViewModel.ApiState.ApiContributors.a));
            String string2 = getString(R.string.live_host_finish_att);
            Intrinsics.c(string2, "getString(R.string.live_host_finish_att)");
            arrayList2.add(new LiveFinishTabData(string2, LiveNumFormatUtil.a.a(liveCloseInfoModel.new_follower_count), LiveHostFinishDetailViewModel.ApiState.ApiNewFollowers.a));
            String string3 = getString(R.string.live_host_finish_au);
            Intrinsics.c(string3, "getString(R.string.live_host_finish_au)");
            arrayList2.add(new LiveFinishTabData(string3, LiveNumFormatUtil.a.a(liveCloseInfoModel.total_watch_count), LiveHostFinishDetailViewModel.ApiState.ApiAudiences.a));
            String string4 = getString(R.string.live_host_finish_gift);
            Intrinsics.c(string4, "getString(R.string.live_host_finish_gift)");
            arrayList2.add(new LiveFinishTabData(string4, LiveNumFormatUtil.a.a(liveCloseInfoModel.giver_count), LiveHostFinishDetailViewModel.ApiState.ApiGiverFrom.a));
            String string5 = getString(R.string.live_host_finish_fans);
            Intrinsics.c(string5, "getString(R.string.live_host_finish_fans)");
            arrayList2.add(new LiveFinishTabData(string5, LiveNumFormatUtil.a.a(liveCloseInfoModel.new_fan_count), LiveHostFinishDetailViewModel.ApiState.ApiNewFans.a));
            String string6 = getString(R.string.live_host_finish_com);
            Intrinsics.c(string6, "getString(R.string.live_host_finish_com)");
            arrayList2.add(new LiveFinishTabData(string6, LiveNumFormatUtil.a.a(liveCloseInfoModel.commenter_count), LiveHostFinishDetailViewModel.ApiState.ApiComments.a));
            String string7 = getString(R.string.live_host_finish_like);
            Intrinsics.c(string7, "getString(R.string.live_host_finish_like)");
            arrayList2.add(new LiveFinishTabData(string7, LiveNumFormatUtil.a.a(liveCloseInfoModel.liked), LiveHostFinishDetailViewModel.ApiState.ApiLikes.a));
        }
        return arrayList;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i = AppInfo.l;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(e().getRoot(), new ViewGroup.LayoutParams(i, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i;
        attributes.height = -1;
        attributes.gravity = 80;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        this.f.clear();
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        g();
        h();
        i();
    }
}
