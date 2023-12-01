package com.soft.blued.ui.user.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.a;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.databinding.ItemVipCancelBuyPopPrivilegeItemBinding;
import com.soft.blued.databinding.PopVipBuyCancelTipsBinding;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPBuyTipsModel;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment.class */
public final class PopVipCancelBuyTipsDialogFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20688c;
    private CountDownTimer d;
    private VIPBuyTipsModel e;
    private int f;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(PopVipCancelBuyTipsDialogFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/PopVipBuyCancelTipsBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20687a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment$Companion.class */
    public static final class Companion {

        @Metadata
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment$Companion$UserType.class */
        public static final class UserType {

            /* renamed from: a  reason: collision with root package name */
            public static final C0686Companion f20689a = new C0686Companion(null);

            @Metadata
            /* renamed from: com.soft.blued.ui.user.views.PopVipCancelBuyTipsDialogFragment$Companion$UserType$Companion  reason: collision with other inner class name */
            /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment$Companion$UserType$Companion.class */
            public static final class C0686Companion {
                private C0686Companion() {
                }

                public /* synthetic */ C0686Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PopVipCancelBuyTipsDialogFragment a(Context context, BaseFragmentActivity baseFragmentActivity, VIPBuyTipsModel vIPBuyTipsModel, int i) {
            Intrinsics.e(context, "context");
            Intrinsics.e(vIPBuyTipsModel, "popModel");
            Bundle bundle = new Bundle();
            bundle.putSerializable("pop_model", vIPBuyTipsModel);
            bundle.putInt("page_index_key", i);
            TransparentActivity.a(bundle);
            TransparentActivity.b(context, PopVipCancelBuyTipsDialogFragment.class, bundle);
            if (baseFragmentActivity instanceof Activity) {
                ActivityChangeAnimationUtils.i((Activity) baseFragmentActivity);
            }
            return new PopVipCancelBuyTipsDialogFragment();
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment$MyPagerAdapter.class */
    public static final class MyPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f20690a;
        private final List<View> b;

        /* JADX WARN: Multi-variable type inference failed */
        public MyPagerAdapter(Context context, List<? extends View> list) {
            Intrinsics.e(context, "context");
            Intrinsics.e(list, "privileges");
            this.f20690a = context;
            this.b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Intrinsics.e(viewGroup, "container");
            Intrinsics.e(obj, "object");
            viewGroup.removeView((View) obj);
        }

        public final Context getContext() {
            return this.f20690a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Intrinsics.e(viewGroup, "container");
            viewGroup.addView(this.b.get(i));
            return this.b.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            Intrinsics.e(view, a.B);
            Intrinsics.e(obj, "object");
            return Intrinsics.a(view, obj);
        }
    }

    public PopVipCancelBuyTipsDialogFragment() {
        super((int) R.layout.pop_vip_buy_cancel_tips);
        this.f20688c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<PopVipCancelBuyTipsDialogFragment, PopVipBuyCancelTipsBinding>() { // from class: com.soft.blued.ui.user.views.PopVipCancelBuyTipsDialogFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment;)Lcom/soft/blued/databinding/PopVipBuyCancelTipsBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return PopVipBuyCancelTipsBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<PopVipCancelBuyTipsDialogFragment, PopVipBuyCancelTipsBinding>() { // from class: com.soft.blued.ui.user.views.PopVipCancelBuyTipsDialogFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/views/PopVipCancelBuyTipsDialogFragment;)Lcom/soft/blued/databinding/PopVipBuyCancelTipsBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return PopVipBuyCancelTipsBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(long j) {
        if (j >= 10) {
            return j + "";
        }
        return Intrinsics.a("0", Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPBuyTipsModel vIPBuyTipsModel, Context context, PopVipCancelBuyTipsDialogFragment popVipCancelBuyTipsDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vIPBuyTipsModel, "$popModel");
        Intrinsics.e(context, "$mContext");
        Intrinsics.e(popVipCancelBuyTipsDialogFragment, "this$0");
        if (TextUtils.isEmpty(vIPBuyTipsModel.welfare_link)) {
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK, popVipCancelBuyTipsDialogFragment.r(), popVipCancelBuyTipsDialogFragment.getType());
        } else {
            WebViewShowInfoFragment.show(context, vIPBuyTipsModel.welfare_link);
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_NOW_CLICK, popVipCancelBuyTipsDialogFragment.r(), popVipCancelBuyTipsDialogFragment.getType());
        }
        popVipCancelBuyTipsDialogFragment.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopVipCancelBuyTipsDialogFragment popVipCancelBuyTipsDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popVipCancelBuyTipsDialogFragment, "this$0");
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK, popVipCancelBuyTipsDialogFragment.r(), popVipCancelBuyTipsDialogFragment.getType());
        popVipCancelBuyTipsDialogFragment.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopVipCancelBuyTipsDialogFragment popVipCancelBuyTipsDialogFragment, Void r4) {
        Intrinsics.e(popVipCancelBuyTipsDialogFragment, "this$0");
        popVipCancelBuyTipsDialogFragment.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopVipBuyCancelTipsBinding s() {
        return (PopVipBuyCancelTipsBinding) this.f20688c.b(this, b[0]);
    }

    private final void t() {
        VIPBuyTipsModel vIPBuyTipsModel = this.e;
        if (vIPBuyTipsModel != null && vIPBuyTipsModel.welfare_deadline > 0) {
            final long j = vIPBuyTipsModel.welfare_deadline * 1000;
            CountDownTimer countDownTimer = new CountDownTimer(j) { // from class: com.soft.blued.ui.user.views.PopVipCancelBuyTipsDialogFragment$startCountDown$1$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    PopVipCancelBuyTipsDialogFragment.this.b(false);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    PopVipBuyCancelTipsBinding s;
                    String a2;
                    String a3;
                    String a4;
                    long j3 = (long) BaseConstants.Time.DAY;
                    long j4 = j2 / j3;
                    long j5 = j2 - (j3 * j4);
                    long j6 = (long) BaseConstants.Time.HOUR;
                    long j7 = j5 / j6;
                    long j8 = j5 - (j6 * j7);
                    long j9 = 60000;
                    long j10 = j8 / j9;
                    long j11 = (j8 - (j9 * j10)) / 1000;
                    s = PopVipCancelBuyTipsDialogFragment.this.s();
                    TextView textView = s == null ? null : s.r;
                    if (textView == null) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    a2 = PopVipCancelBuyTipsDialogFragment.this.a(j7 + (j4 * 24));
                    sb.append((Object) a2);
                    sb.append(':');
                    a3 = PopVipCancelBuyTipsDialogFragment.this.a(j10);
                    sb.append((Object) a3);
                    sb.append(':');
                    a4 = PopVipCancelBuyTipsDialogFragment.this.a(j11);
                    sb.append((Object) a4);
                    textView.setText(sb.toString());
                }
            };
            this.d = countDownTimer;
            if (countDownTimer == null) {
                return;
            }
            countDownTimer.start();
        }
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(VIPBuyTipsModel vIPBuyTipsModel) {
        this.e = vIPBuyTipsModel;
    }

    public final void b(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        LiveEventBus.get(LiveEventBusConstant.b).post(Boolean.valueOf(z));
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        activity.finish();
        ActivityChangeAnimationUtils.j(activity);
    }

    public void f() {
        final Context context;
        final VIPBuyTipsModel p;
        String string;
        StatusBarHelper.a(getActivity(), false);
        PopVipBuyCancelTipsBinding s = s();
        if (s != null && (context = getContext()) != null && (p = p()) != null) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.icon_svip_cancel_buy_pop_top_bg);
            Intrinsics.c(drawable, "mContext.resources.getDr…ip_cancel_buy_pop_top_bg)");
            Drawable drawable2 = context.getResources().getDrawable(R.drawable.icon_svip_cancel_buy_pop_bottom_bg);
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable2;
            if (q() == 1) {
                drawable3 = drawable;
                drawable4 = drawable2;
                if (p.open_intercept != 6) {
                    drawable3 = context.getResources().getDrawable(R.drawable.icon_vip_cancel_buy_pop_top_bg);
                    Intrinsics.c(drawable3, "mContext.resources.getDr…ip_cancel_buy_pop_top_bg)");
                    drawable4 = context.getResources().getDrawable(R.drawable.icon_vip_cancel_buy_pop_bottom_bg);
                }
            }
            s.e.setImageDrawable(drawable3);
            s.d.setImageDrawable(drawable4);
            if (p.open_intercept == 2 || p.open_intercept == 3 || p.open_intercept == 4) {
                s.j.setVisibility(0);
                s.h.setVisibility(8);
                ArrayList arrayList = new ArrayList();
                List<VIPPrivilegeModel> list = p.privilege.svip;
                if (q() == 1) {
                    list = p.privilege.vip;
                }
                Intrinsics.c(list, "privileges");
                for (VIPPrivilegeModel vIPPrivilegeModel : list) {
                    if (vIPPrivilegeModel != null && !TextUtils.isEmpty(vIPPrivilegeModel.icon) && !TextUtils.isEmpty(vIPPrivilegeModel.name) && !TextUtils.isEmpty(vIPPrivilegeModel.content)) {
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_vip_cancel_buy_pop_privilege_item, (ViewGroup) null);
                        ItemVipCancelBuyPopPrivilegeItemBinding a2 = ItemVipCancelBuyPopPrivilegeItemBinding.a(inflate);
                        Intrinsics.c(a2, "bind(layout)");
                        ImageLoader.a((IRequestHost) null, vIPPrivilegeModel.icon).a(a2.f15659a);
                        a2.f15660c.setText(vIPPrivilegeModel.name);
                        a2.b.setText(vIPPrivilegeModel.content);
                        arrayList.add(inflate);
                    }
                }
                s.m.setAdapter(new MyPagerAdapter(context, arrayList));
                s.m.a(1500);
                s.m.setInterval((long) m.ag);
                s.f15875c.setDotCount(3);
                s.f15875c.a((ViewPager) s.m);
                s.q.setText(context.getString(R.string.vip_cancel_buy_pop_to_see_btn));
            } else {
                s.j.setVisibility(8);
                s.h.setVisibility(0);
                s.q.setText(context.getString(R.string.vip_cancel_buy_pop_go_buy_btn));
                t();
            }
            if (p.open_intercept == 2) {
                s.l.setVisibility(8);
                s.g.setVisibility(0);
            } else {
                s.l.setVisibility(0);
                s.g.setVisibility(8);
            }
            int i = p.open_intercept;
            if (i != 2) {
                if (i == 3) {
                    string = context.getString(R.string.vip_cancel_buy_pop_top_title_expiring_soon);
                    Intrinsics.c(string, "mContext.getString(R.str…_top_title_expiring_soon)");
                    s.y.setText(context.getString(R.string.vip_cancel_buy_pop_expiring_soon_privilege_tips));
                    s.A.setText(context.getText(q() != 0 ? 2131892634 : 2131892216));
                    s.z.setText(context.getText(R.string.vip_cancel_buy_pop_subtitle_expiring_soon));
                } else if (i == 4) {
                    string = context.getString(R.string.vip_cancel_buy_pop_top_title_expired);
                    Intrinsics.c(string, "mContext.getString(R.str…uy_pop_top_title_expired)");
                    s.y.setText(context.getString(R.string.vip_cancel_buy_pop_expired_privilege_tips));
                    s.A.setText(context.getText(q() != 0 ? 2131892634 : 2131892216));
                    s.z.setText(context.getText(R.string.vip_cancel_buy_pop_subtitle_expiring_soon));
                } else if (i == 5) {
                    s.A.setText(context.getText(R.string.vip_cancel_buy_pop_title_regression));
                    s.z.setText(context.getText(R.string.vip_cancel_buy_pop_top_subtitle_regression));
                    string = context.getString(R.string.vip_cancel_buy_pop_top_title_regression);
                    Intrinsics.c(string, "mContext.getString(R.str…pop_top_title_regression)");
                    s.f.setVisibility(0);
                    s.k.setVisibility(8);
                    if (q() == 0) {
                        s.o.setText(Intrinsics.a("258", context.getString(R.string.vip_cancel_buy_pop_rmb)));
                        s.u.setText(Intrinsics.a(BaseWrapper.ENTER_ID_OAPS_DEMO, context.getString(R.string.vip_cancel_buy_pop_rmb)));
                    } else {
                        s.o.setText(Intrinsics.a("188", context.getString(R.string.vip_cancel_buy_pop_rmb)));
                        s.u.setText(Intrinsics.a("21", context.getString(R.string.vip_cancel_buy_pop_rmb)));
                    }
                    s.n.setText(Intrinsics.a(context.getString(R.string.vip_cancel_buy_pop_discount), "40%"));
                    s.t.setText(Intrinsics.a(context.getString(R.string.vip_cancel_buy_pop_discount), "22%"));
                } else if (i != 6) {
                    string = "";
                } else {
                    s.A.setText(context.getText(R.string.svip_cancel_buy_pop_title_regression));
                    s.z.setText(context.getText(R.string.svip_cancel_buy_pop_top_subtitle_regression));
                    string = context.getString(R.string.vip_cancel_buy_pop_top_title_regression);
                    Intrinsics.c(string, "mContext.getString(R.str…pop_top_title_regression)");
                    s.f.setVisibility(8);
                    s.k.setVisibility(0);
                    s.w.setText(Intrinsics.a(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER, context.getString(R.string.vip_cancel_buy_pop_first_buy_month)));
                    s.w.setPaintFlags(s.w.getPaintFlags() | 16);
                    s.x.setText("9.9");
                }
            } else {
                string = context.getString(R.string.svip_cancel_buy_pop_top_title_new_user);
                Intrinsics.c(string, "mContext.getString(R.str…y_pop_top_title_new_user)");
                s.y.setText(context.getString(R.string.vip_cancel_buy_pop_first_buy_privilege_tips));
                if (q() == 0) {
                    s.s.setText("18.17");
                } else {
                    s.s.setText("14");
                }
            }
            s.B.setText(string);
            s.f15874a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$PopVipCancelBuyTipsDialogFragment$bYX0BPStmG3zcYhcKFYwmnNVpSU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopVipCancelBuyTipsDialogFragment.a(PopVipCancelBuyTipsDialogFragment.this, view);
                }
            });
            s.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.views.-$$Lambda$PopVipCancelBuyTipsDialogFragment$JFtvsjOfLhHk8qiEOHxhPapzXwQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopVipCancelBuyTipsDialogFragment.a(VIPBuyTipsModel.this, context, this, view);
                }
            });
        }
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_SHOW, r(), getType());
    }

    public final String getType() {
        VIPBuyTipsModel vIPBuyTipsModel = this.e;
        Integer valueOf = vIPBuyTipsModel == null ? null : Integer.valueOf(vIPBuyTipsModel.open_intercept);
        return (valueOf != null && valueOf.intValue() == 2) ? "new" : (valueOf != null && valueOf.intValue() == 3) ? "in" : (valueOf != null && valueOf.intValue() == 4) ? "out_60" : (valueOf != null && valueOf.intValue() == 5) ? "out_180" : (valueOf != null && valueOf.intValue() == 6) ? "out_181" : "";
    }

    public void l() {
        LiveEventBus.get(LiveEventBusConstant.b, Void.class).observe((LifecycleOwner) this, new Observer() { // from class: com.soft.blued.ui.user.views.-$$Lambda$PopVipCancelBuyTipsDialogFragment$5JSXL4arRhTvv_qaSeP1I92gaJk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PopVipCancelBuyTipsDialogFragment.a(PopVipCancelBuyTipsDialogFragment.this, (Void) obj);
            }
        });
    }

    public boolean onBackPressed() {
        b(false);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        a(arguments.getInt("page_index_key", 0));
        Serializable serializable = arguments.getSerializable("pop_model");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.model.VIPBuyTipsModel");
        }
        a((VIPBuyTipsModel) serializable);
    }

    public final VIPBuyTipsModel p() {
        return this.e;
    }

    public final int q() {
        return this.f;
    }

    public final VipProtos.PageLevel r() {
        VipProtos.PageLevel pageLevel = VipProtos.PageLevel.UNKNOWN_PAGE_LEVEL;
        VIPBuyTipsModel vIPBuyTipsModel = this.e;
        return vIPBuyTipsModel == null ? pageLevel : vIPBuyTipsModel.open_intercept > 4 ? VipProtos.PageLevel.VIP_BACK : q() == 1 ? VipProtos.PageLevel.VIP_PAGE : VipProtos.PageLevel.SVIP_PAGE;
    }
}
