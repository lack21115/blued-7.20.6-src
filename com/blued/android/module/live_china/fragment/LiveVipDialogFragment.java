package com.blued.android.module.live_china.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveVipBinding;
import com.blued.android.module.live_china.fitem.FitemVipPrivilege;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.VipDataModel;
import com.blued.android.module.live_china.model.VipHttpDataModel;
import com.blued.android.module.live_china.model.VipModel;
import com.blued.android.module.live_china.model.VipPrivilegeModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveVipCardTransformer;
import com.blued.android.module.live_china.utils.VipDataUtil;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.VipCardView;
import com.blued.das.live.LiveProtos;
import java.io.File;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveVipDialogFragment.class */
public final class LiveVipDialogFragment extends BaseDialogFragment implements OnClickCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13281a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private int f13282c;
    private VipDataModel d;
    private VipCardAdapter e;
    private FreedomAdapter g;
    private TextView i;
    private FitemVipPrivilege j;
    private ValueAnimator l;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveVipBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveVipDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveVipBinding invoke() {
            return DialogLiveVipBinding.a(LayoutInflater.from(LiveVipDialogFragment.this.getContext()));
        }
    });
    private final ArrayList<FitemVipPrivilege> f = new ArrayList<>();
    private int h = -1;
    private int k = -1;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveVipDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveVipDialogFragment a(FragmentManager manager, int i) {
            Intrinsics.e(manager, "manager");
            LiveVipDialogFragment liveVipDialogFragment = new LiveVipDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("from", i);
            liveVipDialogFragment.setArguments(bundle);
            liveVipDialogFragment.show(manager, LiveVipDialogFragment.class.getSimpleName());
            return liveVipDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveVipDialogFragment$VipCardAdapter.class */
    public static final class VipCardAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f13283a;
        private final ArrayList<View> b;

        public VipCardAdapter(Context mContext, ArrayList<View> list) {
            Intrinsics.e(mContext, "mContext");
            Intrinsics.e(list, "list");
            this.f13283a = mContext;
            this.b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            if (object instanceof View) {
                container.removeView((View) object);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            container.addView(this.b.get(i));
            View view = this.b.get(i);
            Intrinsics.c(view, "list[position]");
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.e(view, "view");
            Intrinsics.e(object, "object");
            return view == object;
        }
    }

    private final void a(int i) {
        TextView textView = this.i;
        if (textView != null) {
            textView.animate().alpha(0.6f).setDuration(200L).start();
            ObjectAnimator.ofArgb(textView, "TextColor", ContextCompat.getColor(requireContext(), R.color.syc_dark_16161E), ContextCompat.getColor(requireContext(), R.color.syc_dark_FEDA96)).setDuration(200L).start();
            textView.getPaint().setFakeBoldText(false);
        }
        TextView textView2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? e().u : e().y : e().x : e().w : e().v : e().u;
        Intrinsics.c(textView2, "when (position) {\n      … -> vb.tvLevel1\n        }");
        this.i = textView2;
        final TextView textView3 = textView2;
        e().t.animate().alpha(0.0f).scaleX(0.35f).scaleY(0.6f).setDuration(160L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$iQhUqpmx-40FSWm22CfTVKlhxdU
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.a(LiveVipDialogFragment.this, textView3);
            }
        }).start();
    }

    private final void a(final int i, View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$j-YzZXcJj0P_LC_zspZwSuxWcG8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveVipDialogFragment.a(LiveVipDialogFragment.this, i, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, VipModel vipModel) {
        if (this.h == i) {
            return;
        }
        this.h = i;
        a(vipModel);
        a(i);
        b(vipModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ImageSize imageSize, int i, final LiveVipDialogFragment this$0, VipPrivilegeModel model, File file, Exception exc) {
        Intrinsics.e(imageSize, "$imageSize");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (file == null || !file.exists()) {
            this$0.e().q.c();
            ImageLoader.a(this$0.a(), R.drawable.live_icon_no_data_posted).a(this$0.e().p);
            this$0.e().p.animate().alpha(1.0f).setDuration(100L).start();
            return;
        }
        float a2 = imageSize.a();
        float b = imageSize.b();
        if (a2 > 0.0f && b > 0.0f) {
            int i2 = (int) ((b / a2) * i);
            ViewGroup.LayoutParams layoutParams = this$0.e().p.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            this$0.e().p.setLayoutParams(layoutParams);
        }
        this$0.e().p.animate().cancel();
        this$0.e().p.setAlpha(0.0f);
        ImageWrapper g = ImageLoader.a(this$0.a(), model.getInfo_img_url()).g().g(-1);
        final ActivityFragmentActive a3 = this$0.a();
        g.a(new ImageLoadResult(a3) { // from class: com.blued.android.module.live_china.fragment.LiveVipDialogFragment$loadPrivilegeImg$2$1
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
                DialogLiveVipBinding e;
                super.a();
                e = LiveVipDialogFragment.this.e();
                e.p.animate().alpha(1.0f).setDuration(200L).start();
            }

            @Override // com.blued.android.core.image.ImageLoadResult
            public void a(int i3, Exception exc2) {
                DialogLiveVipBinding e;
                DialogLiveVipBinding e2;
                super.a(i3, exc2);
                ImageWrapper a4 = ImageLoader.a(LiveVipDialogFragment.this.a(), R.drawable.live_icon_no_data_posted);
                e = LiveVipDialogFragment.this.e();
                a4.a(e.p);
                e2 = LiveVipDialogFragment.this.e();
                e2.p.animate().alpha(1.0f).setDuration(200L).start();
            }

            @Override // com.blued.android.core.image.ImageLoadResult
            public void b() {
                DialogLiveVipBinding e;
                e = LiveVipDialogFragment.this.e();
                e.q.c();
                super.b();
            }
        }).a(this$0.e().p);
        this$0.e().p.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$rf57Vowv9UwWsf53zcoWreETYgc
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.g(LiveVipDialogFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.e == null) {
            return;
        }
        this$0.e().L.setCurrentItem(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        this$0.e().d.getLayoutParams().height = intValue;
        this$0.e().d.setLayoutParams(this$0.e().d.getLayoutParams());
        this$0.k = intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, TextView currentLevelTv) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(currentLevelTv, "$currentLevelTv");
        ViewGroup.LayoutParams layoutParams = this$0.e().t.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.width = currentLevelTv.getWidth();
        layoutParams2.height = currentLevelTv.getHeight();
        this$0.e().t.setTranslationX(currentLevelTv.getLeft());
        this$0.e().t.setTranslationY(currentLevelTv.getTop());
        this$0.e().t.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
        currentLevelTv.animate().alpha(1.0f).setDuration(200L).start();
        ObjectAnimator.ofArgb(currentLevelTv, "TextColor", ContextCompat.getColor(this$0.requireContext(), R.color.syc_dark_FEDA96), ContextCompat.getColor(this$0.requireContext(), R.color.syc_dark_16161E)).setDuration(200L).start();
        currentLevelTv.getPaint().setFakeBoldText(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveVipDialogFragment this$0, VipModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        ImageWrapper a2 = ImageLoader.a(this$0.a(), model.getBg_url());
        final ActivityFragmentActive a3 = this$0.a();
        a2.a(new ImageLoadResult(a3) { // from class: com.blued.android.module.live_china.fragment.LiveVipDialogFragment$updateCurrentSelectDataToBackground$1$1
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
                DialogLiveVipBinding e;
                super.a();
                e = LiveVipDialogFragment.this.e();
                e.i.animate().alpha(1.0f).translationY(0.0f).setDuration(560L).start();
            }
        }).a(this$0.e().i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, VipModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.e().L.setCurrentItem(item.getLevel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, VipPrivilegeModel it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        this$0.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveVipDialogFragment this$0, Ref.IntRef intRef) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(intRef, "$default");
        this$0.onClick(null, intRef.f42543a, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VipHttpDataModel vipHttpDataModel) {
        this.d = new VipDataUtil().a(vipHttpDataModel);
        ImageLoader.a(a(), vipHttpDataModel.getAvatar()).b(R.drawable.icon_desire_funders_default).a(1.0f, getResources().getColor(R.color.white)).a(e().f);
        ImageLoader.a(a(), vipHttpDataModel.getAvatar_frame()).g().g(-1).a(e().g);
        e().z.setText(vipHttpDataModel.getName());
        VipDataModel vipDataModel = this.d;
        VipDataModel vipDataModel2 = vipDataModel;
        if (vipDataModel == null) {
            Intrinsics.c("mData");
            vipDataModel2 = null;
        }
        ArrayList<VipModel> levels = vipDataModel2.getLevels();
        if (levels != null) {
            for (VipModel vipModel : levels) {
                int level = vipModel.getLevel();
                if (level == 0) {
                    e().u.setText(vipModel.getName());
                } else if (level == 1) {
                    e().v.setText(vipModel.getName());
                } else if (level == 2) {
                    e().w.setText(vipModel.getName());
                } else if (level == 3) {
                    e().x.setText(vipModel.getName());
                } else if (level == 4) {
                    e().y.setText(vipModel.getName());
                }
            }
        }
        VipDataModel vipDataModel3 = this.d;
        VipDataModel vipDataModel4 = vipDataModel3;
        if (vipDataModel3 == null) {
            Intrinsics.c("mData");
            vipDataModel4 = null;
        }
        int current_level = vipDataModel4.getCurrent_level();
        if (current_level == 0) {
            e().k.setImageResource(R.drawable.live_vip_level_dot_select);
        } else if (current_level == 1) {
            e().l.setImageResource(R.drawable.live_vip_level_dot_select);
        } else if (current_level == 2) {
            e().m.setImageResource(R.drawable.live_vip_level_dot_select);
        } else if (current_level == 3) {
            e().n.setImageResource(R.drawable.live_vip_level_dot_select);
        } else if (current_level == 4) {
            e().o.setImageResource(R.drawable.live_vip_level_dot_select);
        }
        if (requireContext() != null) {
            if (this.d == null) {
                Intrinsics.c("mData");
            }
            VipDataModel vipDataModel5 = this.d;
            VipDataModel vipDataModel6 = vipDataModel5;
            if (vipDataModel5 == null) {
                Intrinsics.c("mData");
                vipDataModel6 = null;
            }
            ArrayList<VipModel> levels2 = vipDataModel6.getLevels();
            if (!(levels2 == null || levels2.isEmpty())) {
                ArrayList arrayList = new ArrayList();
                VipDataModel vipDataModel7 = this.d;
                VipDataModel vipDataModel8 = vipDataModel7;
                if (vipDataModel7 == null) {
                    Intrinsics.c("mData");
                    vipDataModel8 = null;
                }
                ArrayList<VipModel> levels3 = vipDataModel8.getLevels();
                if (levels3 != null) {
                    for (final VipModel vipModel2 : levels3) {
                        Context requireContext = requireContext();
                        Intrinsics.c(requireContext, "requireContext()");
                        VipDataModel vipDataModel9 = this.d;
                        VipDataModel vipDataModel10 = vipDataModel9;
                        if (vipDataModel9 == null) {
                            Intrinsics.c("mData");
                            vipDataModel10 = null;
                        }
                        int current_level2 = vipDataModel10.getCurrent_level();
                        VipDataModel vipDataModel11 = this.d;
                        VipDataModel vipDataModel12 = vipDataModel11;
                        if (vipDataModel11 == null) {
                            Intrinsics.c("mData");
                            vipDataModel12 = null;
                        }
                        VipCardView vipCardView = new VipCardView(requireContext, vipModel2, current_level2, vipDataModel12.getCurrent_score());
                        vipCardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$Caj7QN6PKB3-GyPhJR4kk3SVxZs
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                LiveVipDialogFragment.a(LiveVipDialogFragment.this, vipModel2, view);
                            }
                        });
                        arrayList.add(vipCardView);
                    }
                }
                Context requireContext2 = requireContext();
                Intrinsics.c(requireContext2, "requireContext()");
                this.e = new VipCardAdapter(requireContext2, arrayList);
            }
        }
        VipCardAdapter vipCardAdapter = this.e;
        if (vipCardAdapter == null) {
            return;
        }
        e().L.setAdapter(vipCardAdapter);
        e().L.setOffscreenPageLimit(2);
        e().L.setPageTransformer(true, new LiveVipCardTransformer(DisplayUtil.a(requireContext(), 40.0f)));
        e().L.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveVipDialogFragment$getDataSucceed$3$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                VipDataModel vipDataModel13;
                vipDataModel13 = LiveVipDialogFragment.this.d;
                VipDataModel vipDataModel14 = vipDataModel13;
                if (vipDataModel13 == null) {
                    Intrinsics.c("mData");
                    vipDataModel14 = null;
                }
                ArrayList<VipModel> levels4 = vipDataModel14.getLevels();
                if (levels4 == null) {
                    return;
                }
                LiveVipDialogFragment liveVipDialogFragment = LiveVipDialogFragment.this;
                VipModel vipModel3 = levels4.get(i);
                Intrinsics.c(vipModel3, "levels[position]");
                liveVipDialogFragment.a(i, vipModel3);
            }
        });
        ViewPager viewPager = e().L;
        VipDataModel vipDataModel13 = this.d;
        VipDataModel vipDataModel14 = vipDataModel13;
        if (vipDataModel13 == null) {
            Intrinsics.c("mData");
            vipDataModel14 = null;
        }
        viewPager.setCurrentItem(vipDataModel14.getCurrent_level());
        VipDataModel vipDataModel15 = this.d;
        if (vipDataModel15 == null) {
            Intrinsics.c("mData");
            vipDataModel15 = null;
        }
        ArrayList<VipModel> levels4 = vipDataModel15.getLevels();
        if (levels4 == null) {
            return;
        }
        int currentItem = e().L.getCurrentItem();
        VipModel vipModel3 = levels4.get(e().L.getCurrentItem());
        Intrinsics.c(vipModel3, "levels[vb.vpLevelCard.currentItem]");
        a(currentItem, vipModel3);
    }

    private final void a(final VipModel vipModel) {
        e().i.animate().alpha(0.0f).translationY((-e().i.getHeight()) * 0.3f).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$g3VzALcitbOqtXu9O-MHi0nxYvs
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.a(LiveVipDialogFragment.this, vipModel);
            }
        }).setDuration(80L).start();
    }

    private final void a(final VipPrivilegeModel vipPrivilegeModel) {
        e().p.animate().alpha(0.0f).setDuration(80L).start();
        String info_img_url = vipPrivilegeModel.getInfo_img_url();
        if (!(info_img_url == null || info_img_url.length() == 0)) {
            e().q.b();
            final int width = e().p.getWidth();
            final ImageSize imageSize = new ImageSize();
            e().p.setTag(vipPrivilegeModel.getInfo_img_url());
            ImageFileLoader.a(a()).a(vipPrivilegeModel.getInfo_img_url()).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$Zr6-P1KugxQyx9HKNE6sSZmVu_Y
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    LiveVipDialogFragment.a(ImageSize.this, width, this, vipPrivilegeModel, file, exc);
                }
            }).a();
            return;
        }
        e().p.setTag("");
        ViewGroup.LayoutParams layoutParams = e().p.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = e().p.getWidth();
        layoutParams.height = e().p.getWidth();
        e().p.setLayoutParams(layoutParams);
        ImageLoader.a(a(), R.drawable.live_icon_no_data_posted).a(e().p);
        e().p.animate().alpha(1.0f).setDuration(200L).start();
        e().p.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$852Wm0NebL2gvzoqV5Nbv-p_mVc
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.f(LiveVipDialogFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VipPrivilegeModel it, LiveVipDialogFragment this$0, View view) {
        Bundle arguments;
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        int info_btn_type = it.getInfo_btn_type();
        if (info_btn_type == 1) {
            this$0.a(it.getInfo_btn_url_online(), it.getInfo_btn_url_test(), it.getLive_suffix(), true);
        } else if (info_btn_type == 2) {
            this$0.a(it.getInfo_btn_url_online(), it.getInfo_btn_url_test(), it.getLive_suffix(), false);
        } else if (info_btn_type != 3) {
        } else {
            if (this$0.f13282c == 0 && (arguments = this$0.getArguments()) != null) {
                this$0.f13282c = arguments.getInt("from", -1);
            }
            int i = this$0.f13282c;
            if (i > 0) {
                if (i == 1) {
                    LiveRoomInfo.a().a(this$0.requireContext(), String.valueOf(it.getInfo_btn_uid()), it.getInfo_btn_nickname(), "", 0, 1);
                    return;
                }
                LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
                liveRoomUserModel.uid = String.valueOf(it.getInfo_btn_uid());
                liveRoomUserModel.name = it.getInfo_btn_nickname();
                LiveSetDataObserver.a().a(liveRoomUserModel);
            }
        }
    }

    private final void a(String str, String str2, String str3, boolean z) {
        Bundle arguments;
        if (this.f13282c == 0 && (arguments = getArguments()) != null) {
            this.f13282c = arguments.getInt("from", -1);
        }
        if (this.f13282c <= 0) {
            return;
        }
        if (!LiveRoomInfo.a().j()) {
            str = str2;
        }
        if (this.f13282c == 1) {
            LiveRoomInfo.a().a(requireContext(), str);
            return;
        }
        String str4 = str3;
        boolean z2 = true;
        if (str4 != null) {
            z2 = str4.length() == 0;
        }
        String str5 = str;
        if (!z2) {
            str5 = Intrinsics.a(str, (Object) str3);
        }
        if (z) {
            LiveSetDataObserver.a().g(str5);
        } else {
            LiveSetDataObserver.a().b(str5, 0);
        }
    }

    private final void b(int i) {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.l = ValueAnimator.ofInt(this.k, i);
        long j = 250;
        long b = DisplayUtil.b(AppInfo.d(), Math.abs(this.k - i) * 0.15f);
        ValueAnimator valueAnimator2 = this.l;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(Math.max(j + b, 300L));
        }
        ValueAnimator valueAnimator3 = this.l;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(new DecelerateInterpolator(1.0f));
        }
        ValueAnimator valueAnimator4 = this.l;
        if (valueAnimator4 != null) {
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$mrTeoIJvvxHO80ZjsXlfiCtAWoA
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                    LiveVipDialogFragment.a(LiveVipDialogFragment.this, valueAnimator5);
                }
            });
        }
        ValueAnimator valueAnimator5 = this.l;
        if (valueAnimator5 == null) {
            return;
        }
        valueAnimator5.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveVipDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a("https://app.blued.cn/home/home/vip-detail-page", "https://app-testenv.blued.cn/home/vip-detail-page", "?isLive=true", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveVipDialogFragment this$0, VipModel model) {
        String sb;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        TextView textView = this$0.e().D;
        if (model.getLevel() == 0) {
            sb = "成为VIP可享超多豪华特权";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(model.getName());
            sb2.append("VIP特权 ");
            ArrayList<VipPrivilegeModel> privileges = model.getPrivileges();
            sb2.append(privileges == null ? null : Integer.valueOf(privileges.size()));
            sb = sb2.toString();
        }
        textView.setText(sb);
        this$0.e().D.animate().alpha(1.0f).setDuration(160L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveVipDialogFragment this$0, Ref.IntRef intRef) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(intRef, "$default");
        this$0.onClick(null, intRef.f42543a, null);
    }

    private final void b(final VipModel vipModel) {
        Integer g;
        Integer g2;
        e().D.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$fOn4Djq7n-Hyn9oRPydNTxo03h4
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.b(LiveVipDialogFragment.this, vipModel);
            }
        }).setDuration(80L).start();
        ArrayList<VipPrivilegeModel> privileges = vipModel.getPrivileges();
        if (privileges == null) {
            return;
        }
        if (privileges.size() >= this.f.size()) {
            final Ref.IntRef intRef = new Ref.IntRef();
            FitemVipPrivilege d = d();
            if (d != null && (g = d.g()) != null) {
                intRef.f42543a = g.intValue();
            }
            this.f.clear();
            for (VipPrivilegeModel vipPrivilegeModel : privileges) {
                this.f.add(new FitemVipPrivilege(vipPrivilegeModel));
            }
            if (intRef.f42543a < 0 || intRef.f42543a > privileges.size() - 1) {
                ArrayList<FitemVipPrivilege> arrayList = this.f;
                a(arrayList.get(arrayList.size() - 1));
                privileges.size();
            } else {
                a(this.f.get(intRef.f42543a));
            }
            FreedomAdapter freedomAdapter = this.g;
            if (freedomAdapter != null) {
                freedomAdapter.b("lightItemPosition", Integer.valueOf(intRef.f42543a));
            }
            h();
            e().s.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$E2cmL0uNP0mZLQePxoy1CksDpH8
                @Override // java.lang.Runnable
                public final void run() {
                    LiveVipDialogFragment.b(LiveVipDialogFragment.this, intRef);
                }
            });
            return;
        }
        int size = this.f.size();
        int size2 = privileges.size();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.f42543a = -1;
        FitemVipPrivilege d2 = d();
        if (d2 != null && (g2 = d2.g()) != null) {
            int intValue = g2.intValue();
            int i = intValue;
            if (intValue > privileges.size() - 1) {
                i = privileges.size() - 1;
            }
            intRef2.f42543a = i;
        }
        int i2 = 0;
        while (i2 < size - size2) {
            i2++;
            this.f.remove(privileges.size());
            FreedomAdapter freedomAdapter2 = this.g;
            if (freedomAdapter2 != null) {
                freedomAdapter2.notifyItemRemoved(privileges.size());
            }
        }
        for (VipPrivilegeModel vipPrivilegeModel2 : privileges) {
            for (FitemVipPrivilege fitemVipPrivilege : this.f) {
                if (vipPrivilegeModel2.getId() == fitemVipPrivilege.e().getId()) {
                    fitemVipPrivilege.a(vipPrivilegeModel2);
                }
            }
        }
        if (intRef2.f42543a >= 0) {
            a((FitemVipPrivilege) null);
        }
        e().s.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$s87FKye7d7ppHbliyFugSYv_M8A
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.a(LiveVipDialogFragment.this, intRef2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveVipDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        StatusBarHelper.a((Activity) this$0.getActivity(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveVipDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.e().t.setPivotY(this$0.e().t.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveVipBinding e() {
        return (DialogLiveVipBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveVipDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.e().d.getLayoutParams().height = this$0.e().r.getHeight();
        this$0.k = this$0.e().r.getHeight();
    }

    private final void f() {
        e().K.getLayoutParams().height = DensityUtils.a(getActivity());
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("from", -1);
            this.f13282c = i;
            if (i > 0) {
                ImageView imageView = e().j;
                Intrinsics.c(imageView, "vb.ivInfo");
                BluedViewExKt.b(imageView);
                if (this.f13282c == 1) {
                    e().j.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$m6r2ltQflfqvuK-oYfwuAaMuuJI
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveVipDialogFragment.c(LiveVipDialogFragment.this);
                        }
                    });
                }
            }
        }
        e().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$b66ijYkNLYxMJFmXoVoVLxng0UI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveVipDialogFragment.a(LiveVipDialogFragment.this, view);
            }
        });
        e().j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$jP1IYkPmpM1Je8EFaF2Cigewa-I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveVipDialogFragment.b(LiveVipDialogFragment.this, view);
            }
        });
        e().i.animate().setInterpolator(new DecelerateInterpolator(2.0f));
        e().t.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$ypOf9NZNz_PSuSrCVLUCFvDZCNI
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.d(LiveVipDialogFragment.this);
            }
        });
        e().r.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveVipDialogFragment$MpZFXVBY5YerxkGZjzuc1dcedPY
            @Override // java.lang.Runnable
            public final void run() {
                LiveVipDialogFragment.e(LiveVipDialogFragment.this);
            }
        });
        TextView textView = e().u;
        Intrinsics.c(textView, "vb.tvLevel1");
        a(0, textView);
        ImageView imageView2 = e().k;
        Intrinsics.c(imageView2, "vb.ivLevel1Dot");
        a(0, imageView2);
        TextView textView2 = e().v;
        Intrinsics.c(textView2, "vb.tvLevel2");
        a(1, textView2);
        ImageView imageView3 = e().l;
        Intrinsics.c(imageView3, "vb.ivLevel2Dot");
        a(1, imageView3);
        TextView textView3 = e().w;
        Intrinsics.c(textView3, "vb.tvLevel3");
        a(2, textView3);
        ImageView imageView4 = e().m;
        Intrinsics.c(imageView4, "vb.ivLevel3Dot");
        a(2, imageView4);
        TextView textView4 = e().x;
        Intrinsics.c(textView4, "vb.tvLevel4");
        a(3, textView4);
        ImageView imageView5 = e().n;
        Intrinsics.c(imageView5, "vb.ivLevel4Dot");
        a(3, imageView5);
        TextView textView5 = e().y;
        Intrinsics.c(textView5, "vb.tvLevel5");
        a(4, textView5);
        ImageView imageView6 = e().o;
        Intrinsics.c(imageView6, "vb.ivLevel5Dot");
        a(4, imageView6);
        e().D.getPaint().setFakeBoldText(true);
        e().C.getPaint().setFakeBoldText(true);
        e().A.getPaint().setFakeBoldText(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveVipDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(RangesKt.c(this$0.e().r.getHeight(), this$0.e().f11828a.getHeight()));
    }

    private final void g() {
        e().q.b();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.I(new BluedUIHttpResponse<BluedEntity<VipHttpDataModel, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveVipDialogFragment$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogLiveVipBinding e;
                super.onUIFinish();
                e = LiveVipDialogFragment.this.e();
                e.q.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<VipHttpDataModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                VipHttpDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveVipDialogFragment.this.a(singleData);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveVipDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(RangesKt.c(this$0.e().r.getHeight(), this$0.e().f11828a.getHeight()));
    }

    private final void h() {
        FreedomAdapter freedomAdapter = this.g;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.g = new FreedomAdapter(getContext(), a(), this.f, this);
        DialogLiveVipBinding e = e();
        RecyclerView recyclerView = e == null ? null : e.s;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        DialogLiveVipBinding e2 = e();
        RecyclerView recyclerView2 = e2 == null ? null : e2.s;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        DialogLiveVipBinding e3 = e();
        RecyclerView recyclerView3 = e3 == null ? null : e3.s;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.g);
    }

    public final void a(FitemVipPrivilege fitemVipPrivilege) {
        this.j = fitemVipPrivilege;
    }

    public final FitemVipPrivilege d() {
        return this.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0128, code lost:
        if (r7.getCurrent_level() < 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ad, code lost:
        if (kotlin.jvm.internal.Intrinsics.a((java.lang.Object) r0, (java.lang.Object) ((java.lang.String) r0)) == false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026c  */
    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r7, int r8, com.blued.android.module.common.utils.freedom.BaseViewHolder r9) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveVipDialogFragment.onClick(android.view.View, int, com.blued.android.module.common.utils.freedom.BaseViewHolder):void");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getWidth());
        }
        Integer num2 = num;
        if (num == null) {
            num2 = -1;
        }
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(e().getRoot(), new ViewGroup.LayoutParams(num2.intValue(), -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = num2.intValue();
        attributes.height = -1;
        attributes.gravity = 80;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        EventTrackLive.a(LiveProtos.Event.LIVE_VIP_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        if (this.f13282c == 1) {
            StatusBarHelper.a((Activity) getActivity(), true);
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        f();
        g();
    }
}
