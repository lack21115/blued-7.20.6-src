package com.blued.android.module.live.base.fragment;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.adapter.MultiItemTypeSupport;
import com.blued.android.module.common.fragment.BaseGiftRootFragment;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.base.fragment.LiveGiftBaseFragment;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.OverridingMethodsMustInvokeSuper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/fragment/LiveGiftBaseFragment.class */
public abstract class LiveGiftBaseFragment extends BaseGiftRootFragment<CommonGiftPackageModel> implements View.OnClickListener {
    private ViewGroup F;
    protected TextView g;
    protected TextView l;
    protected TextView m;
    protected View n;
    public TextView o;
    protected LinearLayout p;
    protected ImageView q;
    public View r;
    protected ListView s;
    protected CommonAdapter t;
    protected long u;
    protected CommonLiveGiftModel y;
    protected LiveGiftComboTimer z;
    protected String v = "";
    protected String w = "";
    protected boolean x = false;
    private int C = 0;
    private int D = 100;
    protected int A = 10;
    private String E = "live_gift";
    int[] B = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live.base.fragment.LiveGiftBaseFragment$4  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/fragment/LiveGiftBaseFragment$4.class */
    public class AnonymousClass4 extends CommonAdapter<LiveGiftNumberModel> {
        AnonymousClass4(List list, MultiItemTypeSupport multiItemTypeSupport) {
            super(list, multiItemTypeSupport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveGiftNumberModel liveGiftNumberModel, View view) {
            if (liveGiftNumberModel.isUserDefined) {
                LiveGiftBaseFragment.this.a(liveGiftNumberModel);
            } else {
                LiveGiftBaseFragment.this.b(liveGiftNumberModel);
            }
            LiveGiftBaseFragment.this.a(false);
        }

        @Override // com.blued.android.module.common.adapter.CommonAdapter
        public void a(CommonAdapter.ViewHolder viewHolder, final LiveGiftNumberModel liveGiftNumberModel, int i) {
            viewHolder.a(R.id.item_live_gift_select_name, liveGiftNumberModel.name).a(R.id.item_live_gift_select_num_tv, String.valueOf(liveGiftNumberModel.count));
            if (LiveGiftBaseFragment.this.x) {
                viewHolder.b(R.id.item_live_gift_select_name, 0);
            } else {
                viewHolder.b(R.id.item_live_gift_select_name, 8);
            }
            if (liveGiftNumberModel.selected) {
                viewHolder.a(R.id.item_live_gift_select_num_tv, -1);
                viewHolder.a(R.id.item_live_gift_select_name, -1);
            } else {
                viewHolder.a(R.id.item_live_gift_select_num_tv, Color.parseColor("#99FFFFFF"));
                viewHolder.a(R.id.item_live_gift_select_name, Color.parseColor("#99FFFFFF"));
            }
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveGiftBaseFragment$4$hxU5RUub9oQt9Or9K2ft5rK1g5U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBaseFragment.AnonymousClass4.this.a(liveGiftNumberModel, view);
                }
            });
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/fragment/LiveGiftBaseFragment$LiveGiftComboTimer.class */
    public class LiveGiftComboTimer extends Timer {

        /* renamed from: a  reason: collision with root package name */
        CommonLiveGiftModel f11410a;

        public LiveGiftComboTimer(CommonLiveGiftModel commonLiveGiftModel) {
            this.f11410a = commonLiveGiftModel;
        }
    }

    static /* synthetic */ int a(LiveGiftBaseFragment liveGiftBaseFragment) {
        int i = liveGiftBaseFragment.C;
        liveGiftBaseFragment.C = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        m();
    }

    private ViewGroup s() {
        if (this.F == null) {
            this.F = (ViewGroup) getActivity().getWindow().getDecorView();
        }
        return this.F;
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BasePayRemaining basePayRemaining) {
        if (basePayRemaining == null) {
            return;
        }
        LiveDataManager.a().a(basePayRemaining);
        c(basePayRemaining);
        LiveEventBus.get("live_beans_change").post(new LiveBeansChangeEvent(LiveDataManager.a().c(), basePayRemaining.beans_current, basePayRemaining.beans_count));
    }

    public void a(CommonLiveGiftModel commonLiveGiftModel) {
        LiveEventBus.get("gift_item_update").post(commonLiveGiftModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CommonLiveGiftModel commonLiveGiftModel, int i) {
        int i2 = this.A;
        int i3 = i;
        if (i > i2) {
            i3 = i2;
        }
        if (commonLiveGiftModel == null) {
            return;
        }
        LogUtils.c(commonLiveGiftModel.index + " left double hit time: " + i3);
        if (commonLiveGiftModel.double_hit == 1) {
            commonLiveGiftModel.comboWaitTime = i3;
            if (i3 <= 0) {
                commonLiveGiftModel.hit_count = 0;
            }
            LiveEventBus.get("gift_item_update").post(commonLiveGiftModel);
        }
    }

    protected void a(LiveGiftNumberModel liveGiftNumberModel) {
    }

    public void a(boolean z) {
        if (n() != -1 && o() != -1) {
            this.q.setImageResource(z ? n() : o());
        }
        this.r.setVisibility(z ? 0 : 8);
    }

    protected void b(BasePayRemaining basePayRemaining) {
    }

    public void b(CommonLiveGiftModel commonLiveGiftModel) {
        int a2;
        int a3;
        int i;
        int a4;
        float f;
        int i2;
        int a5;
        if (isHidden()) {
            return;
        }
        final ImageView imageView = new ImageView(getContext());
        imageView.setTag("Gift_View");
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageLoader.a(((BaseFragment) getParentFragment()).getFragmentActive(), commonLiveGiftModel.images_static).a(imageView);
        int i3 = -1;
        int i4 = 0;
        int i5 = 2;
        int i6 = 4;
        while (i4 < this.b.size()) {
            CommonGiftPackageModel commonGiftPackageModel = (CommonGiftPackageModel) this.b.get(i4);
            int i7 = i3;
            if (commonGiftPackageModel.tabIndex == commonLiveGiftModel.packageTabIndex) {
                int line = commonGiftPackageModel.getLine();
                int column = commonGiftPackageModel.getColumn();
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    i7 = i3;
                    i5 = line;
                    i6 = column;
                    if (i9 >= commonGiftPackageModel.goods.size()) {
                        break;
                    } else if (StringUtils.a(commonLiveGiftModel.index, ((BaseGiftModel) commonGiftPackageModel.goods.get(i9)).index)) {
                        i7 = i9;
                        i5 = line;
                        i6 = column;
                        break;
                    } else {
                        i8 = i9 + 1;
                    }
                }
            }
            i4++;
            i3 = i7;
        }
        if (i3 < 0) {
            return;
        }
        int i10 = i3 - (((i3 / (i5 * i6)) * i5) * i6);
        int a6 = LiveDataManager.a().f() ? (AppInfo.m - DisplayUtil.a(getContext(), 200.0f)) / i6 : (AppInfo.l - DisplayUtil.a(getContext(), 30.0f)) / i6;
        if (LiveDataManager.a().f()) {
            a2 = DisplayUtil.a(getContext(), 30.0f) + ((i5 <= 1 ? i10 : i10 - (i6 * (i5 - 1))) * a6) + (a6 / 2);
            a3 = DisplayUtil.a(getContext(), 33.0f);
        } else {
            a2 = DisplayUtil.a(getContext(), 15.0f) + ((i10 % i6) * a6) + (a6 / 2);
            a3 = DisplayUtil.a(getContext(), 33.0f);
        }
        int i11 = a2 - a3;
        int[] iArr = this.B;
        if (iArr[0] == 0 || iArr[1] == 0) {
            this.f10811a.getLocationInWindow(this.B);
        }
        int i12 = this.B[1];
        int i13 = i12;
        if (i12 == 0) {
            if (LiveDataManager.a().f()) {
                i2 = AppInfo.l;
                a5 = DisplayUtil.a(getContext(), 175.0f);
            } else {
                i2 = AppInfo.m;
                a5 = DisplayUtil.a(getContext(), 245.0f);
            }
            i13 = i2 - a5;
        }
        int a7 = ((i13 + ((i10 / 4) * a6)) + DisplayUtil.a(getContext(), 33.0f)) - (a6 / 2);
        if (LiveDataManager.a().f()) {
            i = AppInfo.m / 2;
            a4 = DisplayUtil.a(getContext(), 120.0f);
        } else {
            i = AppInfo.l / 2;
            a4 = DisplayUtil.a(getContext(), 190.0f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UiUtils.a(getContext(), 66.0f), UiUtils.a(getContext(), 66.0f));
        layoutParams.leftMargin = i11;
        layoutParams.topMargin = a7;
        s().addView(imageView, layoutParams);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i - i11, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, a4 - a7);
        translateAnimation2.setInterpolator(new DecelerateInterpolator());
        translateAnimation2.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateAnimation2);
        animationSet.setDuration(Math.abs(f / 0.7f));
        imageView.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live.base.fragment.LiveGiftBaseFragment.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.clearAnimation();
                imageView.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    protected void b(CommonLiveGiftModel commonLiveGiftModel, int i) {
        CommonLiveGiftModel commonLiveGiftModel2 = (CommonLiveGiftModel) a(this.f10812c);
        if (commonLiveGiftModel2 == null || commonLiveGiftModel == null || !StringUtils.a(commonLiveGiftModel2.goods_id, commonLiveGiftModel.goods_id) || commonLiveGiftModel2.comboWaitTime <= 0) {
            r();
        } else {
            q();
        }
        LiveGiftComboTimer liveGiftComboTimer = new LiveGiftComboTimer(commonLiveGiftModel);
        this.z = liveGiftComboTimer;
        liveGiftComboTimer.schedule(new TimerTask() { // from class: com.blued.android.module.live.base.fragment.LiveGiftBaseFragment.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LiveGiftBaseFragment.this.getParentFragment() == null || !((BaseFragment) LiveGiftBaseFragment.this.getParentFragment()).getFragmentActive().isActive()) {
                    return;
                }
                LiveGiftBaseFragment.a(LiveGiftBaseFragment.this);
                LiveGiftBaseFragment liveGiftBaseFragment = LiveGiftBaseFragment.this;
                CommonLiveGiftModel commonLiveGiftModel3 = (CommonLiveGiftModel) liveGiftBaseFragment.a(liveGiftBaseFragment.f10812c);
                if (LiveGiftBaseFragment.this.z == null || LiveGiftBaseFragment.this.z.f11410a == null) {
                    LiveGiftBaseFragment.this.C = 0;
                    return;
                }
                if (commonLiveGiftModel3 != null) {
                    try {
                        if (LiveGiftBaseFragment.this.z != null && LiveGiftBaseFragment.this.z.f11410a != null && StringUtils.a(commonLiveGiftModel3.goods_id, LiveGiftBaseFragment.this.z.f11410a.goods_id)) {
                            LiveGiftBaseFragment.this.d(commonLiveGiftModel3, LiveGiftBaseFragment.this.C);
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        LiveGiftBaseFragment.this.q();
                        return;
                    }
                }
                LiveGiftBaseFragment.this.q();
            }
        }, 0L, this.D);
        c(commonLiveGiftModel, i);
    }

    protected void b(LiveGiftNumberModel liveGiftNumberModel) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(List<CommonGiftPackageModel> list) {
        CommonLiveGiftModel commonLiveGiftModel = (CommonLiveGiftModel) a(this.f10812c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.b.clear();
                this.b.addAll(list);
                d();
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < list.get(i2).goods.size()) {
                    CommonLiveGiftModel commonLiveGiftModel2 = (CommonLiveGiftModel) list.get(i2).goods.get(i4);
                    commonLiveGiftModel2.pic = commonLiveGiftModel2.images_static;
                    if (commonLiveGiftModel == null || !StringUtils.a(commonLiveGiftModel2.index, commonLiveGiftModel.index)) {
                        commonLiveGiftModel2.sendGiftStatus = 0;
                    } else {
                        commonLiveGiftModel2.sendGiftStatus = commonLiveGiftModel.sendGiftStatus;
                        commonLiveGiftModel2.hit_batch = commonLiveGiftModel.hit_batch;
                        commonLiveGiftModel2.hit_count = commonLiveGiftModel.hit_count;
                        commonLiveGiftModel2.hit_id = commonLiveGiftModel.hit_id;
                        commonLiveGiftModel2.isSelected = commonLiveGiftModel.isSelected;
                        commonLiveGiftModel2.comboWaitTime = commonLiveGiftModel.comboWaitTime;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void c(BasePayRemaining basePayRemaining) {
        this.g.setText(CommonStringUtils.d(String.valueOf(LiveDataManager.a().d() + (basePayRemaining != null ? basePayRemaining.bonus : 0L))));
    }

    public void c(CommonLiveGiftModel commonLiveGiftModel) {
        r();
    }

    protected void c(CommonLiveGiftModel commonLiveGiftModel, int i) {
    }

    public void c(List<LiveGiftNumberModel> list) {
        if (TypeUtils.a((List<?>) list)) {
            return;
        }
        a(true);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveGiftBaseFragment$ZDbaHl4iJ2qPWwWP04Y2yknW1yw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftBaseFragment.this.a(view);
            }
        });
        if (this.t == null) {
            p();
            this.s.setAdapter((ListAdapter) this.t);
        }
        this.t.a(list);
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void d() {
        super.d();
        l();
    }

    protected void d(CommonLiveGiftModel commonLiveGiftModel, int i) {
        int i2 = i / 5;
        if (i % 5 == 0) {
            a(commonLiveGiftModel, this.A - i2);
        }
        if (i2 >= this.A) {
            c(commonLiveGiftModel);
        }
    }

    protected void d(String str) {
    }

    @OverridingMethodsMustInvokeSuper
    public void e(CommonLiveGiftModel commonLiveGiftModel, int i) {
        CommonLiveGiftModel commonLiveGiftModel2 = this.y;
        if (commonLiveGiftModel2 == null || StringUtils.a(commonLiveGiftModel2.index, commonLiveGiftModel.index)) {
            return;
        }
        q();
        if (this.y.double_hit == 1) {
            a(this.y, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(CommonLiveGiftModel commonLiveGiftModel, int i) {
        if (commonLiveGiftModel == null) {
            return;
        }
        CommonGiftPackageModel b = b(commonLiveGiftModel.index);
        if (b != null && b.deleteItemIfZeroCount && commonLiveGiftModel.getDeleteItemCount() <= 0) {
            r();
        } else if (commonLiveGiftModel.double_hit == 1 && i == 1) {
            b(commonLiveGiftModel, i);
        }
    }

    protected abstract String g();

    /* JADX INFO: Access modifiers changed from: protected */
    public String h() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public abstract void t();

    public boolean j() {
        return getFragmentActive() != null && isAdded() && isActive();
    }

    protected abstract int k();

    protected void l() {
        if (this.f10812c == null) {
            this.f10812c = b();
        }
        BaseGiftModel a2 = a(this.f10812c);
        if (a2 != null) {
            LiveEventBus.get("gift_item_selected").post(this.f10812c);
            this.f10811a.setToolBtnSelect(a2.packageTabIndex);
            this.h.setCurrentItem(a2.packageTabIndex, false);
        }
    }

    protected abstract void m();

    public int n() {
        return -1;
    }

    public int o() {
        return -1;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        View view = this.r;
        if (view == null || view.getVisibility() != 0) {
            return super.onBackPressed();
        }
        a(false);
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            return;
        }
        r();
        int childCount = s().getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            try {
                View childAt = s().getChildAt(i2);
                if ("Gift_View".equals(childAt.getTag()) && childAt.getAnimation() == null) {
                    s().removeView(childAt);
                }
                i = i2 + 1;
            } catch (Exception e) {
                return;
            }
        }
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment, com.blued.android.framework.ui.SimpleFragment
    @OverridingMethodsMustInvokeSuper
    public void onInitListener() {
        super.onInitListener();
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveGiftBaseFragment$46IfMYB7p-iGZO51HhgD_nW9z3U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftBaseFragment.this.c(view);
            }
        });
        this.l.setOnClickListener(this);
        this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveGiftBaseFragment$ND5Rz9Xsp5i_MNP94AGKqSRpPx4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftBaseFragment.b(view);
            }
        });
        this.p.setOnClickListener(this);
        LiveEventBus.get("gold_remain_result", BasePayRemaining.class).observe(this, new Observer<BasePayRemaining>() { // from class: com.blued.android.module.live.base.fragment.LiveGiftBaseFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(BasePayRemaining basePayRemaining) {
                LiveGiftBaseFragment.this.c(basePayRemaining);
                if (basePayRemaining != null && basePayRemaining.text != null) {
                    boolean b = LiveBasePreferences.b();
                    if (!TextUtils.isEmpty(basePayRemaining.text.goods) && !b) {
                        LiveGiftBaseFragment.this.d(basePayRemaining.text.goods);
                    }
                    if (TextUtils.isEmpty(basePayRemaining.text.sums)) {
                        LiveGiftBaseFragment.this.l.setText(LiveGiftBaseFragment.this.w);
                    } else {
                        LiveGiftBaseFragment.this.l.setText(basePayRemaining.text.sums);
                    }
                }
                if (basePayRemaining != null) {
                    LiveGiftBaseFragment.this.b(basePayRemaining);
                }
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.E = g();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        List<CommonGiftPackageModel> b = LiveDataManager.a().b(h());
        if (TypeUtils.a((List<?>) b)) {
            return;
        }
        for (CommonGiftPackageModel commonGiftPackageModel : b) {
            for (BaseGiftModel baseGiftModel : commonGiftPackageModel.goods) {
                baseGiftModel.isSelected = false;
            }
        }
        this.b.clear();
        this.b.addAll(b);
        d();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        c(new BasePayRemaining());
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveGiftBaseFragment$rsXuMVMWLL7FPtD5cNre6QoH9W4
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftBaseFragment.this.t();
            }
        }, 300L);
    }

    protected void p() {
        this.t = new AnonymousClass4(new ArrayList(), new MultiItemTypeSupport<LiveGiftNumberModel>() { // from class: com.blued.android.module.live.base.fragment.LiveGiftBaseFragment.3
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a() {
                return 2;
            }

            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a(int i, LiveGiftNumberModel liveGiftNumberModel) {
                return liveGiftNumberModel.isUserDefined ? R.layout.item_live_gift_define_num_layout : R.layout.item_live_gift_select_num_layout;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int b(int i, LiveGiftNumberModel liveGiftNumberModel) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        });
    }

    protected void q() {
        LiveGiftComboTimer liveGiftComboTimer = this.z;
        if (liveGiftComboTimer != null) {
            liveGiftComboTimer.f11410a = null;
            this.z.cancel();
            this.z = null;
        }
        this.C = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        q();
        a((CommonLiveGiftModel) a(this.f10812c), 0);
    }
}
