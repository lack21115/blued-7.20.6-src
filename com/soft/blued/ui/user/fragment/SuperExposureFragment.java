package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.utils.HashidEncryptTool;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.adapter.MultiItemTypeSupport;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.track.EventTrackSuperExpose;
import com.blued.community.view.PhotoGridView;
import com.blued.das.superexpose.SuperExposeProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.databinding.FragmentSuperExposureBinding;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.ui.mine.model.SuperExposureCouponModel;
import com.soft.blued.ui.mine.model.SuperExposureFeedModel;
import com.soft.blued.ui.mine.model.SuperExposureModel;
import com.soft.blued.ui.mine.model.SuperExposurePayItemModel;
import com.soft.blued.ui.mine.model.SuperExposureUserModel;
import com.soft.blued.ui.pay.CouponFragment;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.ui.pay.presenter.CouponPresenter;
import com.soft.blued.ui.user.viewmodel.SuperExposureViewModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SuperExposureFragment.class */
public final class SuperExposureFragment extends MVVMBaseFragment<SuperExposureViewModel> {

    /* renamed from: c  reason: collision with root package name */
    public CommonAdapter<SuperExposurePayItemModel> f33969c;
    private long d;
    private String e;
    private int f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private SuperExposureCouponModel o;
    private ArrayList<SuperExposurePayItemModel> p;
    private SparseArray<SuperExposureCouponModel> q;
    private int r;
    private final ViewBindingProperty s;
    private boolean t;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(SuperExposureFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentSuperExposureBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33968a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SuperExposureFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String strFeedId, String detail) {
            Intrinsics.e(context, "context");
            Intrinsics.e(strFeedId, "strFeedId");
            Intrinsics.e(detail, "detail");
            Bundle bundle = new Bundle();
            bundle.putLong("feed_id", CommonStringUtils.c(strFeedId));
            bundle.putString("detail", detail);
            TerminalActivity.d(context, SuperExposureFragment.class, bundle);
        }
    }

    public SuperExposureFragment() {
        super(R.layout.fragment_super_exposure);
        this.e = "";
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = true;
        this.j = true;
        this.k = true;
        this.n = -1;
        this.p = new ArrayList<>();
        this.q = new SparseArray<>();
        this.s = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<SuperExposureFragment, FragmentSuperExposureBinding>() { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentSuperExposureBinding invoke(SuperExposureFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentSuperExposureBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<SuperExposureFragment, FragmentSuperExposureBinding>() { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentSuperExposureBinding invoke(SuperExposureFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentSuperExposureBinding.a(fragment.requireView());
            }
        });
    }

    private final void A() {
        boolean a2 = Intrinsics.a((Object) BluedStatistics.g().a("VAS_超级曝光购买页优化实验_VAS_promote_payment-page_price", ""), (Object) "test");
        this.t = a2;
        if (a2) {
            FragmentSuperExposureBinding x = x();
            LinearLayout linearLayout = x == null ? null : x.m;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentSuperExposureBinding x2 = x();
            TextView textView = x2 == null ? null : x2.al;
            if (textView != null) {
                textView.setVisibility(8);
            }
            FragmentSuperExposureBinding x3 = x();
            LinearLayout linearLayout2 = x3 == null ? null : x3.p;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentSuperExposureBinding x4 = x();
            TextView textView2 = x4 == null ? null : x4.aq;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(0);
            return;
        }
        FragmentSuperExposureBinding x5 = x();
        LinearLayout linearLayout3 = x5 == null ? null : x5.m;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentSuperExposureBinding x6 = x();
        TextView textView3 = x6 == null ? null : x6.al;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        FragmentSuperExposureBinding x7 = x();
        LinearLayout linearLayout4 = x7 == null ? null : x7.p;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        FragmentSuperExposureBinding x8 = x();
        TextView textView4 = x8 == null ? null : x8.aq;
        if (textView4 == null) {
            return;
        }
        textView4.setVisibility(8);
    }

    private final void B() {
        this.f = 0;
        int size = this.p.size();
        int i = this.m;
        if (size > i) {
            a(this.p.get(i).id, true);
        }
        D();
    }

    private final void C() {
        this.f = 1;
        int size = this.p.size();
        int i = this.m;
        if (size > i) {
            a(this.p.get(i).id, true);
        }
        D();
    }

    private final void D() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        LinearLayout linearLayout = null;
        if (this.f == 1) {
            FragmentSuperExposureBinding x = x();
            if (x != null && (imageView4 = x.ae) != null) {
                imageView4.setImageResource(R.drawable.icon_unselect);
            }
            FragmentSuperExposureBinding x2 = x();
            if (x2 != null && (imageView3 = x2.ag) != null) {
                imageView3.setImageResource(R.drawable.icon_selected);
            }
            FragmentSuperExposureBinding x3 = x();
            if (x3 != null) {
                linearLayout = x3.W;
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            F();
        } else {
            FragmentSuperExposureBinding x4 = x();
            if (x4 != null && (imageView2 = x4.ae) != null) {
                imageView2.setImageResource(R.drawable.icon_selected);
            }
            FragmentSuperExposureBinding x5 = x();
            if (x5 != null && (imageView = x5.ag) != null) {
                imageView.setImageResource(R.drawable.icon_unselect);
            }
            FragmentSuperExposureBinding x6 = x();
            LinearLayout linearLayout2 = x6 == null ? null : x6.W;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        I();
    }

    private final void E() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextView textView21;
        TextView textView22;
        if (this.g.contains("9") && this.g.size() > 1) {
            this.g.clear();
        }
        if (this.g.size() == 0) {
            this.g.add("9");
        }
        if (this.g.contains("9")) {
            FragmentSuperExposureBinding x = x();
            if (x != null && (textView22 = x.T) != null) {
                textView22.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
            }
            FragmentSuperExposureBinding x2 = x();
            if (x2 != null && (textView21 = x2.T) != null) {
                textView21.setTextColor(i(2131101780));
            }
            FragmentSuperExposureBinding x3 = x();
            if (x3 != null && (textView20 = x3.U) != null) {
                textView20.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x4 = x();
            if (x4 != null && (textView19 = x4.U) != null) {
                textView19.setTextColor(i(2131102254));
            }
            FragmentSuperExposureBinding x5 = x();
            if (x5 != null && (textView18 = x5.V) != null) {
                textView18.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x6 = x();
            if (x6 != null && (textView17 = x6.V) != null) {
                textView17.setTextColor(i(2131102254));
            }
            FragmentSuperExposureBinding x7 = x();
            if (x7 != null && (textView16 = x7.S) != null) {
                textView16.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x8 = x();
            if (x8 != null && (textView15 = x8.S) != null) {
                textView15.setTextColor(i(2131102254));
            }
        } else {
            FragmentSuperExposureBinding x9 = x();
            if (x9 != null && (textView14 = x9.T) != null) {
                textView14.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x10 = x();
            if (x10 != null && (textView13 = x10.T) != null) {
                textView13.setTextColor(i(2131102254));
            }
            if (this.g.contains("1")) {
                FragmentSuperExposureBinding x11 = x();
                if (x11 != null && (textView12 = x11.U) != null) {
                    textView12.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
                }
                FragmentSuperExposureBinding x12 = x();
                if (x12 != null && (textView11 = x12.U) != null) {
                    textView11.setTextColor(i(2131101780));
                }
            } else {
                FragmentSuperExposureBinding x13 = x();
                if (x13 != null && (textView2 = x13.U) != null) {
                    textView2.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
                }
                FragmentSuperExposureBinding x14 = x();
                if (x14 != null && (textView = x14.U) != null) {
                    textView.setTextColor(i(2131102254));
                }
            }
            if (this.g.contains("2")) {
                FragmentSuperExposureBinding x15 = x();
                if (x15 != null && (textView10 = x15.V) != null) {
                    textView10.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
                }
                FragmentSuperExposureBinding x16 = x();
                if (x16 != null && (textView9 = x16.V) != null) {
                    textView9.setTextColor(i(2131101780));
                }
            } else {
                FragmentSuperExposureBinding x17 = x();
                if (x17 != null && (textView4 = x17.V) != null) {
                    textView4.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
                }
                FragmentSuperExposureBinding x18 = x();
                if (x18 != null && (textView3 = x18.V) != null) {
                    textView3.setTextColor(i(2131102254));
                }
            }
            if (this.g.contains("3")) {
                FragmentSuperExposureBinding x19 = x();
                if (x19 != null && (textView8 = x19.S) != null) {
                    textView8.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
                }
                FragmentSuperExposureBinding x20 = x();
                if (x20 != null && (textView7 = x20.S) != null) {
                    textView7.setTextColor(i(2131101780));
                }
            } else {
                FragmentSuperExposureBinding x21 = x();
                if (x21 != null && (textView6 = x21.S) != null) {
                    textView6.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
                }
                FragmentSuperExposureBinding x22 = x();
                if (x22 != null && (textView5 = x22.S) != null) {
                    textView5.setTextColor(i(2131102254));
                }
            }
        }
        J();
    }

    private final void F() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextView textView21;
        TextView textView22;
        if (this.h.contains("9") && this.h.size() > 1) {
            this.h.clear();
        }
        if (this.h.size() == 0) {
            this.h.add("9");
        }
        if (this.h.contains("9")) {
            FragmentSuperExposureBinding x = x();
            if (x != null && (textView22 = x.R) != null) {
                textView22.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
            }
            FragmentSuperExposureBinding x2 = x();
            if (x2 != null && (textView21 = x2.R) != null) {
                textView21.setTextColor(i(2131101780));
            }
            FragmentSuperExposureBinding x3 = x();
            if (x3 != null && (textView20 = x3.O) != null) {
                textView20.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x4 = x();
            if (x4 != null && (textView19 = x4.O) != null) {
                textView19.setTextColor(i(2131102254));
            }
            FragmentSuperExposureBinding x5 = x();
            if (x5 != null && (textView18 = x5.P) != null) {
                textView18.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x6 = x();
            if (x6 != null && (textView17 = x6.P) != null) {
                textView17.setTextColor(i(2131102254));
            }
            FragmentSuperExposureBinding x7 = x();
            if (x7 != null && (textView16 = x7.Q) != null) {
                textView16.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x8 = x();
            if (x8 != null && (textView15 = x8.Q) != null) {
                textView15.setTextColor(i(2131102254));
            }
        } else {
            FragmentSuperExposureBinding x9 = x();
            if (x9 != null && (textView14 = x9.R) != null) {
                textView14.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x10 = x();
            if (x10 != null && (textView13 = x10.R) != null) {
                textView13.setTextColor(i(2131102254));
            }
            if (this.h.contains("1")) {
                FragmentSuperExposureBinding x11 = x();
                if (x11 != null && (textView12 = x11.O) != null) {
                    textView12.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
                }
                FragmentSuperExposureBinding x12 = x();
                if (x12 != null && (textView11 = x12.O) != null) {
                    textView11.setTextColor(i(2131101780));
                }
            } else {
                FragmentSuperExposureBinding x13 = x();
                if (x13 != null && (textView2 = x13.O) != null) {
                    textView2.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
                }
                FragmentSuperExposureBinding x14 = x();
                if (x14 != null && (textView = x14.O) != null) {
                    textView.setTextColor(i(2131102254));
                }
            }
            if (this.h.contains("2")) {
                FragmentSuperExposureBinding x15 = x();
                if (x15 != null && (textView10 = x15.P) != null) {
                    textView10.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
                }
                FragmentSuperExposureBinding x16 = x();
                if (x16 != null && (textView9 = x16.P) != null) {
                    textView9.setTextColor(i(2131101780));
                }
            } else {
                FragmentSuperExposureBinding x17 = x();
                if (x17 != null && (textView4 = x17.P) != null) {
                    textView4.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
                }
                FragmentSuperExposureBinding x18 = x();
                if (x18 != null && (textView3 = x18.P) != null) {
                    textView3.setTextColor(i(2131102254));
                }
            }
            if (this.h.contains("3")) {
                FragmentSuperExposureBinding x19 = x();
                if (x19 != null && (textView8 = x19.Q) != null) {
                    textView8.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
                }
                FragmentSuperExposureBinding x20 = x();
                if (x20 != null && (textView7 = x20.Q) != null) {
                    textView7.setTextColor(i(2131101780));
                }
            } else {
                FragmentSuperExposureBinding x21 = x();
                if (x21 != null && (textView6 = x21.Q) != null) {
                    textView6.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
                }
                FragmentSuperExposureBinding x22 = x();
                if (x22 != null && (textView5 = x22.Q) != null) {
                    textView5.setTextColor(i(2131102254));
                }
            }
        }
        J();
    }

    private final void G() {
        if (this.f == 1) {
            this.j = true;
        } else {
            this.i = true;
        }
        I();
    }

    private final void H() {
        if (this.f == 1) {
            this.j = false;
        } else {
            this.i = false;
        }
        I();
    }

    private final void I() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        if (this.t) {
            c(P());
            b(!P());
        } else if (P()) {
            FragmentSuperExposureBinding x = x();
            if (x != null && (textView8 = x.q) != null) {
                textView8.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
            }
            FragmentSuperExposureBinding x2 = x();
            if (x2 != null && (textView7 = x2.q) != null) {
                textView7.setTextColor(i(2131101780));
            }
            FragmentSuperExposureBinding x3 = x();
            if (x3 != null && (textView6 = x3.r) != null) {
                textView6.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x4 = x();
            if (x4 != null && (textView5 = x4.r) != null) {
                textView5.setTextColor(i(2131102254));
            }
        } else {
            FragmentSuperExposureBinding x5 = x();
            if (x5 != null && (textView4 = x5.q) != null) {
                textView4.setBackgroundResource(R.drawable.super_exposure_rule_unselect_bg);
            }
            FragmentSuperExposureBinding x6 = x();
            if (x6 != null && (textView3 = x6.q) != null) {
                textView3.setTextColor(i(2131102254));
            }
            FragmentSuperExposureBinding x7 = x();
            if (x7 != null && (textView2 = x7.r) != null) {
                textView2.setBackgroundResource(R.drawable.super_exposure_rule_selected_bg);
            }
            FragmentSuperExposureBinding x8 = x();
            if (x8 != null && (textView = x8.r) != null) {
                textView.setTextColor(i(2131101780));
            }
        }
        J();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x015c, code lost:
        if (r7.j == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0168, code lost:
        if (r7.i == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x016b, code lost:
        r8 = (int) (r9 * 0.5f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f0, code lost:
        if (r7.i == false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void J() {
        /*
            Method dump skipped, instructions count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.SuperExposureFragment.J():void");
    }

    private final void K() {
        if (this.p.size() <= this.m) {
            return;
        }
        int i = 0;
        SuperExposureCouponModel superExposureCouponModel = this.o;
        if (superExposureCouponModel != null) {
            i = superExposureCouponModel.id;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(CouponPresenter.j, this.p.get(this.m).id);
        bundle.putInt(CouponPresenter.l, i);
        bundle.putInt(CouponPresenter.m, this.f);
        TerminalActivity.d(getContext(), CouponFragment.class, bundle);
    }

    private final void L() {
        this.k = !this.k;
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        TextView textView;
        CardView cardView;
        ImageView imageView;
        CardView cardView2;
        ImageView imageView2;
        TextView textView2;
        int size = this.p.size();
        int i = this.m;
        if (size <= i || this.p.get(i).storage_num <= 0) {
            FragmentSuperExposureBinding x = x();
            if (x != null && (textView = x.G) != null) {
                textView.setText(R.string.go_to_pay);
            }
        } else {
            FragmentSuperExposureBinding x2 = x();
            if (x2 != null && (textView2 = x2.G) != null) {
                textView2.setText(R.string.go_to_use);
            }
        }
        if (this.k) {
            FragmentSuperExposureBinding x3 = x();
            if (x3 != null && (imageView2 = x3.X) != null) {
                imageView2.setImageResource(R.drawable.icon_selected);
            }
            FragmentSuperExposureBinding x4 = x();
            if (x4 == null || (cardView2 = x4.H) == null) {
                return;
            }
            cardView2.setCardBackgroundColor(Color.parseColor("#2187FF"));
            return;
        }
        FragmentSuperExposureBinding x5 = x();
        if (x5 != null && (imageView = x5.X) != null) {
            imageView.setImageResource(R.drawable.icon_unselect);
        }
        FragmentSuperExposureBinding x6 = x();
        if (x6 == null || (cardView = x6.H) == null) {
            return;
        }
        cardView.setCardBackgroundColor(i(2131102260));
    }

    private final void N() {
        WebViewShowInfoFragment.show(getContext(), Intrinsics.a(Host.a("H5"), (Object) "/term/vipterm"), -1);
    }

    private final void O() {
        WebViewShowInfoFragment.show(getContext(), Intrinsics.a(Host.a("H5"), (Object) "/home/fans/launchinfo"), -1);
    }

    private final boolean P() {
        return this.f == 1 ? this.j : this.i;
    }

    private final void Q() {
        if (!this.k || this.p.size() <= this.m) {
            return;
        }
        String a2 = this.g.contains("9") ? "9" : a(this.g);
        String a3 = this.h.contains("9") ? "9" : a(this.h);
        String str = P() ? "1" : "2";
        int i = this.p.get(this.m).id;
        String valueOf = String.valueOf(this.f + 1);
        if (this.p.get(this.m).storage_num > 0) {
            final ActivityFragmentActive fragmentActive = getFragmentActive();
            PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BasePayRemaining>>(fragmentActive) { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$onClickPay$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BasePayRemaining> parseData) {
                    Intrinsics.e(parseData, "parseData");
                    if (parseData.code == 21001) {
                        AppMethods.d((int) R.string.super_exposure_fire_toast);
                        return;
                    }
                    SuperExposureViewModel a4 = SuperExposureFragment.this.a();
                    long p = SuperExposureFragment.this.p();
                    ActivityFragmentActive fragmentActive2 = SuperExposureFragment.this.getFragmentActive();
                    Intrinsics.c(fragmentActive2, "fragmentActive");
                    a4.a(p, fragmentActive2);
                    if (parseData.getSingleData() != null) {
                        WebViewShowInfoFragment.show(AppInfo.d(), Intrinsics.a("http://common.blued.com?action=exposure_inventory_buy_success&order_id=", (Object) parseData.getSingleData().order_id), -1);
                    }
                }
            }, i, this.d, this.e, valueOf, a2, a3, str, getFragmentActive());
            return;
        }
        String b2 = HashidEncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid);
        String str2 = this.p.get(this.m).name;
        String b3 = HashidEncryptTool.b(String.valueOf(this.d));
        SuperExposureCouponModel superExposureCouponModel = this.o;
        String valueOf2 = superExposureCouponModel == null ? "" : String.valueOf(superExposureCouponModel.id);
        int i2 = this.l;
        String str3 = Host.a("H5") + "/home/pay/payway?from=exposure&detail=" + this.e + "&uid=" + ((Object) b2) + (i2 > 0 ? Intrinsics.a("&money=", (Object) Integer.valueOf(i2)) : "&money=0.01") + "&productId=" + i + "&productName=" + ((Object) str2) + "&fid=" + ((Object) b3) + "&promotionType=" + valueOf + "&couponsid=" + valueOf2 + "&role=" + ((Object) a2) + "&age=" + ((Object) a3) + "&area=" + str;
        LogUtils.c(Intrinsics.a("wholeUrl: ", (Object) str3));
        WebViewShowInfoFragment.show(getContext(), str3, -1);
        int i3 = !P();
        EventTrackSuperExpose.a(String.valueOf(i), valueOf2, this.f, i3);
        GuyEventUtils.a(i, valueOf2, this.f, i3);
    }

    private final String a(List<String> list) {
        String str;
        String str2 = "";
        String str3 = str2;
        if (list != null) {
            str3 = str2;
            if (!list.isEmpty()) {
                int i = 0;
                int size = list.size();
                while (true) {
                    str3 = str2;
                    if (i >= size) {
                        break;
                    }
                    if (i == 0) {
                        str = list.get(i);
                    } else {
                        str = str2 + ',' + list.get(i);
                    }
                    str2 = str;
                    i++;
                }
            }
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, SuperExposureFragment this$0, SuperExposureModel.FireBag fireModel, Context context, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(fireModel, "$fireModel");
        Intrinsics.e(context, "$context");
        if (i == 1) {
            AppMethods.d((int) R.string.super_exposure_fire_can_not_buy);
            return;
        }
        String a2 = this$0.g.contains("9") ? "9" : this$0.a(this$0.g);
        String a3 = this$0.h.contains("9") ? "9" : this$0.a(this$0.h);
        String str = this$0.P() ? "1" : "2";
        int i2 = fireModel.id;
        int i3 = this$0.f;
        String b2 = HashidEncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid);
        String string = context.getString(R.string.super_exposure_fire_bag);
        Intrinsics.c(string, "context.getString(R.stri….super_exposure_fire_bag)");
        String b3 = HashidEncryptTool.b(String.valueOf(this$0.d));
        String str2 = Host.a("H5") + "/home/pay/payway?from=exposure&detail=cs_fire&uid=" + ((Object) b2) + Intrinsics.a("&money=", (Object) Integer.valueOf(fireModel.total_price)) + "&productId=" + i2 + "&productName=" + string + "&fid=" + ((Object) b3) + "&promotionType=" + String.valueOf(i3 + 1) + "&couponsid=&role=" + ((Object) a2) + "&age=" + ((Object) a3) + "&area=" + str;
        LogUtils.c(Intrinsics.a("wholeUrl: ", (Object) str2));
        WebViewShowInfoFragment.show(context, str2, -1);
        EventTrackSuperExpose.b(SuperExposeProtos.Event.SUPER_EXPOSE_BUY_PAGE_PAY_CLICK, String.valueOf(i2));
    }

    private final void a(final int i, boolean z) {
        if (z) {
            this.q.clear();
        }
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<SuperExposureCouponModel>>(fragmentActive) { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$getCouponData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<SuperExposureCouponModel> bluedEntityA) {
                if ((bluedEntityA == null ? null : bluedEntityA.getSingleData()) == null) {
                    SuperExposureFragment.this.a((SuperExposureCouponModel) null);
                    return;
                }
                if (bluedEntityA.getSingleData().is_available == 1) {
                    bluedEntityA.getSingleData().is_confirm = 1;
                }
                SuperExposureFragment.this.w().put(i, bluedEntityA.getSingleData());
                SuperExposureFragment.this.a(bluedEntityA.getSingleData());
            }
        }, i, this.f, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(SuperExposureCouponModel superExposureCouponModel) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        String string = getString(R.string.exposure_no_available_coupon);
        Intrinsics.c(string, "getString(R.string.exposure_no_available_coupon)");
        if (this.m >= this.p.size() || this.q.get(this.p.get(this.m).id) == null || this.q.get(this.p.get(this.m).id).is_available != 1) {
            this.o = null;
            FragmentSuperExposureBinding x = x();
            if (x != null && (textView = x.u) != null) {
                textView.setTextColor(i(2131102263));
            }
        } else if (superExposureCouponModel == null || superExposureCouponModel.is_confirm != 1) {
            string = getString(R.string.no_choose_coupon);
            Intrinsics.c(string, "getString(R.string.no_choose_coupon)");
            FragmentSuperExposureBinding x2 = x();
            if (x2 != null && (textView2 = x2.u) != null) {
                textView2.setTextColor(i(2131102263));
            }
            this.o = null;
        } else {
            string = Intrinsics.a("-￥", (Object) CommonStringUtils.d(superExposureCouponModel.money));
            FragmentSuperExposureBinding x3 = x();
            if (x3 != null && (textView3 = x3.u) != null) {
                textView3.setTextColor(i(2131102251));
            }
            this.o = superExposureCouponModel;
        }
        String str = string;
        if (superExposureCouponModel != null) {
            str = string;
            if (superExposureCouponModel.discount_type == 2) {
                str = string;
                if (superExposureCouponModel.is_confirm == 1) {
                    Context context = getContext();
                    if (context == null) {
                        str = string;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                        String string2 = context.getResources().getString(R.string.super_exposure_discount_tip);
                        Intrinsics.c(string2, "it.resources.getString(R…er_exposure_discount_tip)");
                        str = String.format(string2, Arrays.copyOf(new Object[]{superExposureCouponModel.money}, 1));
                        Intrinsics.c(str, "format(format, *args)");
                    }
                }
            }
        }
        FragmentSuperExposureBinding x4 = x();
        TextView textView4 = x4 == null ? null : x4.u;
        if (textView4 != null) {
            textView4.setText(str);
        }
        if (superExposureCouponModel != null && !TextUtils.isEmpty(superExposureCouponModel.discount)) {
            String str2 = superExposureCouponModel.discount;
            Intrinsics.c(str2, "model.discount");
            if (Integer.parseInt(str2) > 0 && superExposureCouponModel.discount_type == 2 && superExposureCouponModel.is_confirm == 1) {
                String str3 = superExposureCouponModel.discount;
                Intrinsics.c(str3, "model.discount");
                this.r = Integer.parseInt(str3);
                b(superExposureCouponModel);
            }
        }
        this.r = 0;
        b(superExposureCouponModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final SuperExposurePayItemModel superExposurePayItemModel) {
        CardView cardView;
        CardView cardView2;
        EditText editText;
        CardView cardView3;
        EditText editText2;
        FragmentSuperExposureBinding x;
        EditText editText3;
        if (superExposurePayItemModel.min == 0) {
            superExposurePayItemModel.min = 50;
        }
        if (superExposurePayItemModel.max == 0) {
            superExposurePayItemModel.max = 5000;
        }
        if (superExposurePayItemModel.multiple == 0) {
            superExposurePayItemModel.multiple = 10;
        }
        FragmentSuperExposureBinding x2 = x();
        FrameLayout frameLayout = x2 == null ? null : x2.C;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FragmentSuperExposureBinding x3 = x();
        TextView textView = x3 == null ? null : x3.A;
        if (textView != null) {
            textView.setText("金额在" + superExposurePayItemModel.min + (char) 65374 + superExposurePayItemModel.max + "之间，且为" + superExposurePayItemModel.multiple + "的倍数");
        }
        if (!TextUtils.isEmpty(superExposurePayItemModel.money) && (x = x()) != null && (editText3 = x.B) != null) {
            editText3.setText(superExposurePayItemModel.money);
        }
        FragmentSuperExposureBinding x4 = x();
        if (x4 != null && (editText2 = x4.B) != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$showInputDlg$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    FragmentSuperExposureBinding x5;
                    FragmentSuperExposureBinding x6;
                    CardView cardView4;
                    int i;
                    FragmentSuperExposureBinding x7;
                    FragmentSuperExposureBinding x8;
                    FragmentSuperExposureBinding x9;
                    TextView textView2;
                    int i2;
                    CardView cardView5;
                    int i3;
                    FragmentSuperExposureBinding x10;
                    FragmentSuperExposureBinding x11;
                    FragmentSuperExposureBinding x12;
                    FragmentSuperExposureBinding x13;
                    TextView textView3;
                    int i4;
                    CardView cardView6;
                    int i5;
                    if (editable != null) {
                        if (!(editable.toString().length() == 0)) {
                            int a2 = CommonStringUtils.a(editable.toString());
                            if (a2 < superExposurePayItemModel.min || a2 > superExposurePayItemModel.max || !(superExposurePayItemModel.multiple == 0 || a2 % superExposurePayItemModel.multiple == 0)) {
                                x7 = SuperExposureFragment.this.x();
                                if (x7 != null && (cardView5 = x7.z) != null) {
                                    i3 = SuperExposureFragment.this.i(2131102264);
                                    cardView5.setCardBackgroundColor(i3);
                                }
                                x8 = SuperExposureFragment.this.x();
                                CardView cardView7 = x8 == null ? null : x8.z;
                                if (cardView7 != null) {
                                    cardView7.setEnabled(false);
                                }
                                x9 = SuperExposureFragment.this.x();
                                if (x9 == null || (textView2 = x9.A) == null) {
                                    return;
                                }
                                i2 = SuperExposureFragment.this.i(2131102251);
                                textView2.setTextColor(i2);
                                return;
                            }
                            x10 = SuperExposureFragment.this.x();
                            if (x10 != null && (cardView6 = x10.z) != null) {
                                i5 = SuperExposureFragment.this.i(2131101766);
                                cardView6.setCardBackgroundColor(i5);
                            }
                            x11 = SuperExposureFragment.this.x();
                            CardView cardView8 = x11 == null ? null : x11.z;
                            if (cardView8 != null) {
                                cardView8.setEnabled(true);
                            }
                            int i6 = superExposurePayItemModel.multiple == 0 ? 10 : superExposurePayItemModel.multiple;
                            x12 = SuperExposureFragment.this.x();
                            TextView textView4 = x12 == null ? null : x12.D;
                            if (textView4 != null) {
                                textView4.setText(String.valueOf((a2 * 1000) / i6));
                            }
                            x13 = SuperExposureFragment.this.x();
                            if (x13 == null || (textView3 = x13.A) == null) {
                                return;
                            }
                            i4 = SuperExposureFragment.this.i(2131102263);
                            textView3.setTextColor(i4);
                            return;
                        }
                    }
                    x5 = SuperExposureFragment.this.x();
                    if (x5 != null && (cardView4 = x5.z) != null) {
                        i = SuperExposureFragment.this.i(2131102264);
                        cardView4.setCardBackgroundColor(i);
                    }
                    x6 = SuperExposureFragment.this.x();
                    CardView cardView9 = x6 == null ? null : x6.z;
                    if (cardView9 == null) {
                        return;
                    }
                    cardView9.setEnabled(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
        FragmentSuperExposureBinding x5 = x();
        if (x5 != null && (cardView3 = x5.z) != null) {
            cardView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$z-n0iRo-MeDt4n5FZs2BNxP7UcE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.a(SuperExposureFragment.this, superExposurePayItemModel, view);
                }
            });
        }
        FragmentSuperExposureBinding x6 = x();
        if (x6 != null && (editText = x6.B) != null) {
            editText.postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$krfPZvimh-cbSJkmMD7uVLG9bWU
                @Override // java.lang.Runnable
                public final void run() {
                    SuperExposureFragment.c(SuperExposureFragment.this);
                }
            }, 100L);
        }
        if (BluedPreferences.cK()) {
            FragmentSuperExposureBinding x7 = x();
            if (x7 == null || (cardView2 = x7.x) == null) {
                return;
            }
            cardView2.setCardBackgroundColor(Color.parseColor("#151515"));
            return;
        }
        FragmentSuperExposureBinding x8 = x();
        if (x8 == null || (cardView = x8.x) == null) {
            return;
        }
        cardView.setCardBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SuperExposureFragment this$0, SuperExposurePayItemModel model, View view) {
        EditText editText;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        FragmentSuperExposureBinding x = this$0.x();
        Editable editable = null;
        if (x != null && (editText = x.B) != null) {
            editable = editText.getText();
        }
        int a2 = CommonStringUtils.a(String.valueOf(editable));
        if (a2 < model.min || a2 > model.max || model.multiple == 0 || a2 % model.multiple != 0) {
            return;
        }
        this$0.e(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static final void a(SuperExposureFragment superExposureFragment, BluedCoupon bluedCoupon) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SuperExposureFragment this$0, Boolean bool) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d > 0) {
            SuperExposureViewModel a2 = this$0.a();
            long j = this$0.d;
            ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            a2.a(j, fragmentActive);
        }
    }

    private final void a(String str) {
        CommonAlertDialog.a(getActivity(), (String) null, str, getString(R.string.get_it), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
    }

    private final void a(List<? extends SuperExposureModel.FireBag> list, final int i) {
        final Context context;
        FragmentSuperExposureBinding x = x();
        if (x == null || (context = getContext()) == null) {
            return;
        }
        List<? extends SuperExposureModel.FireBag> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            x.f28984c.setVisibility(8);
            return;
        }
        EventTrackSuperExpose.b(SuperExposeProtos.Event.SUPER_EXPOSE_BUY_PAGE_SHOW, "");
        x.f28984c.setVisibility(0);
        final SuperExposureModel.FireBag fireBag = list.get(0);
        TextView textView = x.as;
        textView.setText("x " + fireBag.buy_num + context.getString(R.string.super_exposure_fire_bag_times));
        x.at.setText(String.valueOf(fireBag.average_price));
        x.aw.setText(Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) context.getString(R.string.super_exposure_fire_bag_times)));
        TextView textView2 = x.ay;
        textView2.setText((char) 65509 + fireBag.total_price + '/' + fireBag.buy_num + context.getString(R.string.super_exposure_fire_bag_times));
        x.av.setText(Intrinsics.a(context.getString(R.string.super_exposure_fire_bag_save_money), (Object) fireBag.discount));
        ImageLoader.a(getFragmentActive(), ImgURLMap.f10885a.a("icon_super_exposure_fire_bag")).a(x.b);
        x.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$RDvd3Yup0NfEKi_KM1-Pjgg0f5c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperExposureFragment.z(SuperExposureFragment.this, view);
            }
        });
        x.f28982a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$y4tx9NjZomECponNEmYbH09-TTI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperExposureFragment.a(i, this, fireBag, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(SuperExposureCouponModel superExposureCouponModel) {
        String str;
        if (this.m < this.p.size()) {
            if (this.p.get(this.m).storage_num > 0) {
                this.l = 0;
            } else {
                String str2 = this.p.get(this.m).money;
                Intrinsics.c(str2, "payList[selectedPayIndex].money");
                this.l = (int) Double.parseDouble(str2);
            }
            SuperExposureCouponModel superExposureCouponModel2 = this.o;
            if (superExposureCouponModel2 != null) {
                if (u().get(s()).storage_num > 0) {
                    a(0);
                } else if (superExposureCouponModel != null && superExposureCouponModel.discount_type == 2 && superExposureCouponModel.is_confirm == 1) {
                    String str3 = u().get(s()).money;
                    Intrinsics.c(str3, "payList[selectedPayIndex].money");
                    a((int) Double.parseDouble(str3));
                } else {
                    int r = r();
                    String str4 = superExposureCouponModel2.money;
                    Intrinsics.c(str4, "it.money");
                    a(r - ((int) Double.parseDouble(str4)));
                }
            }
        }
        int i = this.l;
        if (i >= 0) {
            str = CommonStringUtils.a(i);
            Intrinsics.c(str, "formatPrice(payNum.toLong())");
        } else {
            str = "0.01";
        }
        FragmentSuperExposureBinding x = x();
        TextView textView = x == null ? null : x.L;
        if (textView != null) {
            textView.setText(str);
        }
        z();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        String string = this$0.getString(R.string.exposure_recommend_user_tips);
        Intrinsics.c(string, "getString(R.string.exposure_recommend_user_tips)");
        this$0.a(string);
    }

    private final void b(boolean z) {
        Context context;
        FragmentSuperExposureBinding x = x();
        if (x == null || (context = getContext()) == null) {
            return;
        }
        if (z) {
            x.k.setVisibility(0);
            x.ap.setVisibility(8);
            x.i.setImageResource(R.drawable.icon_super_exposure_area_city_select);
            x.j.setVisibility(0);
            x.ao.setTextColor(context.getResources().getColor(R.color.syc_B3000000));
            return;
        }
        x.k.setVisibility(8);
        x.ap.setVisibility(0);
        x.i.setImageResource(R.drawable.icon_super_exposure_area_city_unselect);
        x.j.setVisibility(8);
        x.ao.setTextColor(context.getResources().getColor(2131102264));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SuperExposureFragment this$0) {
        EditText editText;
        Editable text;
        FragmentSuperExposureBinding x;
        EditText editText2;
        EditText editText3;
        Intrinsics.e(this$0, "this$0");
        FragmentSuperExposureBinding x2 = this$0.x();
        if (x2 != null && (editText3 = x2.B) != null) {
            editText3.requestFocus();
        }
        FragmentSuperExposureBinding x3 = this$0.x();
        KeyboardUtils.a(x3 == null ? null : x3.B);
        FragmentSuperExposureBinding x4 = this$0.x();
        if (x4 == null || (editText = x4.B) == null || (text = editText.getText()) == null || (x = this$0.x()) == null || (editText2 = x.B) == null) {
            return;
        }
        editText2.setSelection(text.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.B();
    }

    private final void c(boolean z) {
        Context context;
        FragmentSuperExposureBinding x = x();
        if (x == null || (context = getContext()) == null) {
            return;
        }
        if (z) {
            x.h.setVisibility(0);
            x.an.setVisibility(8);
            x.f.setImageResource(R.drawable.icon_super_exposure_area_all_select);
            x.g.setVisibility(0);
            x.am.setTextColor(context.getResources().getColor(R.color.syc_B3000000));
            return;
        }
        x.h.setVisibility(8);
        x.an.setVisibility(0);
        x.f.setImageResource(R.drawable.icon_super_exposure_area_all_unselect);
        x.g.setVisibility(8);
        x.am.setTextColor(context.getResources().getColor(2131102264));
    }

    private final int d(int i) {
        int i2 = this.m;
        int i3 = this.n;
        if (i2 == i3) {
            return (i * 1000) / (this.p.get(i3).multiple == 0 ? 10 : this.p.get(this.n).multiple);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.C();
    }

    private final void e(int i) {
        int i2;
        FragmentSuperExposureBinding x = x();
        FrameLayout frameLayout = x == null ? null : x.C;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        if (i <= 0 || (i2 = this.n) < 0) {
            f(this.p.get(this.m).id);
        } else {
            this.m = i2;
            this.p.get(i2).money = String.valueOf(i);
            this.l = i;
            v().a(this.p);
            this.o = null;
            b((SuperExposureCouponModel) null);
            a((SuperExposureCouponModel) null);
        }
        FragmentSuperExposureBinding x2 = x();
        KeyboardUtils.b(x2 == null ? null : x2.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.g(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i) {
        a(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.g(1);
    }

    private final void g(int i) {
        String valueOf = String.valueOf(i);
        if (this.g.contains(valueOf)) {
            this.g.remove(valueOf);
        } else if (i == 9) {
            this.g.clear();
        } else {
            if (this.g.contains("9")) {
                this.g.remove("9");
            }
            if (this.g.contains(valueOf)) {
                this.g.remove(valueOf);
            } else {
                this.g.add(valueOf);
            }
        }
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.g(2);
    }

    private final void h(int i) {
        String valueOf = String.valueOf(i);
        if (this.h.contains(valueOf)) {
            this.h.remove(valueOf);
        } else if (i == 9) {
            this.h.clear();
        } else {
            if (this.h.contains("9")) {
                this.h.remove("9");
            }
            if (this.h.contains(valueOf)) {
                this.h.remove(valueOf);
            } else {
                this.h.add(valueOf);
            }
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.g(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(int i) {
        return BluedSkinUtils.a(getContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.h(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.h(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.h(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.h(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        String string = this$0.getString(R.string.exposure_amount_tips);
        Intrinsics.c(string, "getString(R.string.exposure_amount_tips)");
        this$0.a(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        String string = this$0.getString(R.string.exposure_price_tips);
        Intrinsics.c(string, "getString(R.string.exposure_price_tips)");
        this$0.a(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSuperExposureBinding x() {
        return (FragmentSuperExposureBinding) this.s.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.e(0);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.soft.blued.ui.user.fragment.SuperExposureFragment$createAdapter$2] */
    private final void y() {
        a(new SuperExposureFragment$createAdapter$1(this, new MultiItemTypeSupport<SuperExposurePayItemModel>() { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$createAdapter$2
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a() {
                return 2;
            }

            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a(int i, SuperExposurePayItemModel model) {
                Intrinsics.e(model, "model");
                return !TextUtils.isEmpty(model.content) ? R.layout.item_super_exposure_pay_defined : R.layout.item_super_exposure_pay;
            }

            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int b(int i, SuperExposurePayItemModel model) {
                Intrinsics.e(model, "model");
                return !TextUtils.isEmpty(model.content) ? 1 : 0;
            }
        }));
        FragmentSuperExposureBinding x = x();
        PhotoGridView photoGridView = x == null ? null : x.I;
        if (photoGridView == null) {
            return;
        }
        photoGridView.setAdapter((ListAdapter) v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.e(0);
    }

    private final void z() {
        SuperExposureCouponModel superExposureCouponModel = this.o;
        LinearLayout linearLayout = null;
        if (superExposureCouponModel != null && !TextUtils.isEmpty(superExposureCouponModel.money)) {
            String str = superExposureCouponModel.money;
            Intrinsics.c(str, "it.money");
            if (((int) Double.parseDouble(str)) > 0 && superExposureCouponModel.is_confirm == 1 && superExposureCouponModel.discount_type != 2) {
                FragmentSuperExposureBinding x = x();
                LinearLayout linearLayout2 = x == null ? null : x.ah;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FragmentSuperExposureBinding x2 = x();
                TextView textView = x2 == null ? null : x2.ai;
                if (textView == null) {
                    return;
                }
                textView.setText(CommonStringUtils.d(superExposureCouponModel.money));
                return;
            }
        }
        FragmentSuperExposureBinding x3 = x();
        if (x3 != null) {
            linearLayout = x3.ah;
        }
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SuperExposureFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        String string = this$0.getString(R.string.super_exposure_fire_bag_dialog_content);
        Intrinsics.c(string, "getString(R.string.super…_fire_bag_dialog_content)");
        this$0.a(string);
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(CommonAdapter<SuperExposurePayItemModel> commonAdapter) {
        Intrinsics.e(commonAdapter, "<set-?>");
        this.f33969c = commonAdapter;
    }

    public final void a(SuperExposureModel data) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        String str;
        String str2;
        SuperExposureFeedModel superExposureFeedModel;
        Intrinsics.e(data, "data");
        FragmentSuperExposureBinding x = x();
        TextView textView = x == null ? null : x.aj;
        if (textView != null) {
            BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
            textView.setText(Intrinsics.a(loginUserInfo == null ? null : loginUserInfo.name, (Object) "的动态"));
        }
        SuperExposureFeedModel superExposureFeedModel2 = data.feed;
        if (TextUtils.isEmpty(superExposureFeedModel2 == null ? null : superExposureFeedModel2.url) && (superExposureFeedModel = data.feed) != null) {
            superExposureFeedModel.url = "https://web.bldimg.com/cblued/static/defaultpage.1df8d8us01jt5pv.png";
        }
        SuperExposureFeedModel superExposureFeedModel3 = data.feed;
        if (superExposureFeedModel3 != null && (str2 = superExposureFeedModel3.url) != null) {
            ImageWrapper d = ImageLoader.a(getFragmentActive(), str2).d();
            FragmentSuperExposureBinding x2 = x();
            d.a(x2 == null ? null : x2.E);
            ImageWrapper a2 = ImageLoader.a(getFragmentActive(), str2).a(6.0f);
            FragmentSuperExposureBinding x3 = x();
            a2.a(x3 == null ? null : x3.K);
        }
        FragmentSuperExposureBinding x4 = x();
        TextView textView2 = x4 == null ? null : x4.w;
        if (textView2 != null) {
            SuperExposureFeedModel superExposureFeedModel4 = data.feed;
            textView2.setText(superExposureFeedModel4 == null ? null : superExposureFeedModel4.content);
        }
        SuperExposureUserModel superExposureUserModel = data.user;
        if (superExposureUserModel != null && (str = superExposureUserModel.avatar) != null) {
            ImageWrapper a3 = ImageLoader.a(getFragmentActive(), str).a(16.0f);
            FragmentSuperExposureBinding x5 = x();
            a3.a(x5 == null ? null : x5.s);
        }
        if (BluedSkinUtils.c()) {
            FragmentSuperExposureBinding x6 = x();
            if (x6 != null && (linearLayout = x6.t) != null) {
                linearLayout.setBackgroundResource(R.drawable.super_exposure_content_bg);
            }
        } else {
            FragmentSuperExposureBinding x7 = x();
            if (x7 != null && (linearLayout2 = x7.t) != null) {
                linearLayout2.setBackgroundResource(R.drawable.super_exposure_content_bg_dark);
            }
        }
        D();
        F();
        I();
        M();
        E();
        b((SuperExposureCouponModel) null);
        a(data.pack_list, data.buy_limited);
        v().a(data.list);
        if (data.is_limit == 1) {
            FragmentSuperExposureBinding x8 = x();
            TextView textView3 = x8 == null ? null : x8.r;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            if (this.t) {
                FragmentSuperExposureBinding x9 = x();
                LinearLayout linearLayout3 = x9 == null ? null : x9.o;
                if (linearLayout3 == null) {
                    return;
                }
                linearLayout3.setVisibility(4);
                return;
            }
            return;
        }
        FragmentSuperExposureBinding x10 = x();
        TextView textView4 = x10 == null ? null : x10.r;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        if (this.t) {
            FragmentSuperExposureBinding x11 = x();
            LinearLayout linearLayout4 = x11 == null ? null : x11.o;
            if (linearLayout4 == null) {
                return;
            }
            linearLayout4.setVisibility(0);
        }
    }

    public final void b(int i) {
        this.m = i;
    }

    public final void c(int i) {
        this.n = i;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ImageView imageView;
        FrameLayout frameLayout;
        CardView cardView;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView3;
        TextView textView4;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        TextView textView15;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && arguments.containsKey("feed_id")) {
            z = true;
        }
        if (z) {
            Bundle arguments2 = getArguments();
            Long valueOf = arguments2 == null ? null : Long.valueOf(arguments2.getLong("feed_id"));
            Intrinsics.a(valueOf);
            this.d = valueOf.longValue();
        }
        Bundle arguments3 = getArguments();
        this.e = String.valueOf(arguments3 == null ? null : arguments3.getString("detail", "undefined"));
        A();
        FragmentSuperExposureBinding x = x();
        if (x != null && (commonTopTitleNoTrans = x.ak) != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$UenySncmEiM-HeNGfvQja1KW9RM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.a(SuperExposureFragment.this, view);
                }
            });
        }
        SuperExposureViewModel a2 = a();
        long j = this.d;
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.a(j, fragmentActive);
        FragmentSuperExposureBinding x2 = x();
        if (x2 != null && (textView15 = x2.N) != null) {
            textView15.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$a60eqQah-cDmscWmIRI1yXQTDzI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.b(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x3 = x();
        if (x3 != null && (linearLayout6 = x3.ad) != null) {
            linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$5tieYaAJKGTXITTJSlJT6zLOrLw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.c(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x4 = x();
        if (x4 != null && (linearLayout5 = x4.af) != null) {
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$emAr-nGPvu28osRAJNGnUh4D6vw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.d(SuperExposureFragment.this, view);
                }
            });
        }
        D();
        FragmentSuperExposureBinding x5 = x();
        if (x5 != null && (textView14 = x5.T) != null) {
            textView14.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$x9bLKCp3GMTRGnD_5crPSYldmzs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.e(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x6 = x();
        if (x6 != null && (textView13 = x6.U) != null) {
            textView13.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$rnchS213tTGhXv0-SXtDEgu_700
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.f(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x7 = x();
        if (x7 != null && (textView12 = x7.V) != null) {
            textView12.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$ykxkMnKWLRDB3a1gtMVgWRBH_QI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.g(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x8 = x();
        if (x8 != null && (textView11 = x8.S) != null) {
            textView11.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$A5N0ZqlA_gRSMtXvqy7nTyzQbqI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.h(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x9 = x();
        if (x9 != null && (textView10 = x9.R) != null) {
            textView10.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$0CN9obyGPn04O_8-CFZsNBF0G48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.i(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x10 = x();
        if (x10 != null && (textView9 = x10.O) != null) {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$3S_fW1q0r9hR5jmp9tUVVclYxG8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.j(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x11 = x();
        if (x11 != null && (textView8 = x11.P) != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$Gopu-4rlrXZkBY_NbBoLu3u16ko
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.k(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x12 = x();
        if (x12 != null && (textView7 = x12.Q) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$YrPV9CokzBI7bzgN2K-bMUoigL0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.l(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x13 = x();
        if (x13 != null && (textView6 = x13.q) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$UUbcyefMwMMCot0Pr3vcKPTxvPc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.m(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x14 = x();
        if (x14 != null && (textView5 = x14.r) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$Ad7hIik5MC3h16ZTI1_8SIrF3nI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.n(SuperExposureFragment.this, view);
                }
            });
        }
        if (this.t) {
            FragmentSuperExposureBinding x15 = x();
            if (x15 != null && (linearLayout4 = x15.n) != null) {
                linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$a4akcDiUes_loiz5z211xTMPZnQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SuperExposureFragment.o(SuperExposureFragment.this, view);
                    }
                });
            }
            FragmentSuperExposureBinding x16 = x();
            if (x16 != null && (linearLayout3 = x16.o) != null) {
                linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$o23PIMrOT6QMVraEKbkVTER9ohU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SuperExposureFragment.p(SuperExposureFragment.this, view);
                    }
                });
            }
        }
        I();
        FragmentSuperExposureBinding x17 = x();
        if (x17 != null && (textView4 = x17.ac) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$QcNmmIY2SVm8LB-yvd8t_MFrawE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.q(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x18 = x();
        if (x18 != null && (textView3 = x18.J) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$r4cJpBFZfRPlzjpGtIynUD2N-2E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.r(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x19 = x();
        if (x19 != null && (linearLayout2 = x19.v) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$lKf-5LB3M6oFbwF_0wmPwzFYfnw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.s(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x20 = x();
        if (x20 != null && (linearLayout = x20.Y) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$mVQXkFNa06L5Qk8r_sTNRKXqmEA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.t(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x21 = x();
        if (x21 != null && (textView2 = x21.aa) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$ZofPxIYvq6YLtfMCtZjJCOiZHNI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.u(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x22 = x();
        if (x22 != null && (textView = x22.Z) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$lw144qepx5Pk3nuLCWrOpuMKlQk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.v(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x23 = x();
        if (x23 != null && (cardView = x23.H) != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$Uh7H2Q_SWlUbLwuH-e5WQmZtZSg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.w(SuperExposureFragment.this, view);
                }
            });
        }
        y();
        FragmentSuperExposureBinding x24 = x();
        if (x24 != null && (frameLayout = x24.C) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$c86GIcOvW6WdNu3pQOqkvqgNh5g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.x(SuperExposureFragment.this, view);
                }
            });
        }
        FragmentSuperExposureBinding x25 = x();
        if (x25 != null && (imageView = x25.y) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$IVHdyC2oMpXVQ6IRFyqIK41obRc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuperExposureFragment.y(SuperExposureFragment.this, view);
                }
            });
        }
        EventTrackSuperExpose.a(SuperExposeProtos.Event.EXPOSE_BUY_PAGE_SHOW);
        GuyEventUtils.a(SuperExposeProtos.Event.EXPOSE_BUY_PAGE_SHOW.name());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        SuperExposureFragment superExposureFragment = this;
        LifecycleExtKt.a(superExposureFragment, a().d(), new Function1<SuperExposureModel, Unit>() { // from class: com.soft.blued.ui.user.fragment.SuperExposureFragment$liveDataObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(SuperExposureModel it) {
                if (it.list != null) {
                    Iterator<SuperExposurePayItemModel> it2 = it.list.iterator();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (!it2.hasNext()) {
                            break;
                        }
                        SuperExposurePayItemModel next = it2.next();
                        if (next.storage_num > 0 && SuperExposureFragment.this.s() == 0) {
                            SuperExposureFragment.this.b(i2);
                            SuperExposureFragment superExposureFragment2 = SuperExposureFragment.this;
                            String str = next.money;
                            Intrinsics.c(str, "value.money");
                            superExposureFragment2.a((int) Double.parseDouble(str));
                        } else if (next.isRecommend == 1) {
                            SuperExposureFragment.this.b(i2);
                            SuperExposureFragment superExposureFragment3 = SuperExposureFragment.this;
                            String str2 = next.money;
                            Intrinsics.c(str2, "value.money");
                            superExposureFragment3.a((int) Double.parseDouble(str2));
                        }
                        i = i2 + 1;
                    }
                    if (it.list.size() > SuperExposureFragment.this.s()) {
                        SuperExposureFragment.this.f(it.list.get(SuperExposureFragment.this.s()).id);
                    }
                    SuperExposureFragment.this.u().clear();
                    SuperExposureFragment.this.u().addAll(it.list);
                }
                SuperExposureFragment superExposureFragment4 = SuperExposureFragment.this;
                Intrinsics.c(it, "it");
                superExposureFragment4.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(SuperExposureModel superExposureModel) {
                a(superExposureModel);
                return Unit.f42314a;
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_SUPER_EXPOSURE, Boolean.TYPE).observe(superExposureFragment, new Observer() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$1OYddT-wz0NE7N2ZFfXu0Q0QUQg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuperExposureFragment.a(SuperExposureFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(19);
        }
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        LiveEventBus.get("select_coupon_model", BluedCoupon.class).observe(this, new Observer() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperExposureFragment$YNLTh2EUAqlxnD8GJQ8NSHsKIGg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuperExposureFragment.a(SuperExposureFragment.this, (BluedCoupon) obj);
            }
        });
    }

    public final long p() {
        return this.d;
    }

    public final boolean q() {
        return this.i;
    }

    public final int r() {
        return this.l;
    }

    public final int s() {
        return this.m;
    }

    public final int t() {
        return this.n;
    }

    public final ArrayList<SuperExposurePayItemModel> u() {
        return this.p;
    }

    public final CommonAdapter<SuperExposurePayItemModel> v() {
        CommonAdapter<SuperExposurePayItemModel> commonAdapter = this.f33969c;
        if (commonAdapter != null) {
            return commonAdapter;
        }
        Intrinsics.c("payAdapter");
        return null;
    }

    public final SparseArray<SuperExposureCouponModel> w() {
        return this.q;
    }
}
