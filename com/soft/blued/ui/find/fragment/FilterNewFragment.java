package com.soft.blued.ui.find.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.ConstellationModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.view.PhotoGridView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.FilterScrollView;
import com.soft.blued.databinding.FragmentFilterNewBinding;
import com.soft.blued.databinding.LayoutBasicsFilterBinding;
import com.soft.blued.databinding.LayoutVipFilterBinding;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.adapter.FilterCommonAdapterForGridView;
import com.soft.blued.ui.find.adapter.FilterConstellationAdapter;
import com.soft.blued.ui.find.manager.FilterNewHelper;
import com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.state.FilterAction;
import com.soft.blued.ui.find.state.FilterState;
import com.soft.blued.ui.find.view.FilterCommonPhotoGridView;
import com.soft.blued.ui.find.view.FilterCommonScrollSelectorView;
import com.soft.blued.ui.find.viewmodel.FilterViewModel;
import com.soft.blued.ui.user.adapter.UserTagAdapterNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.video.uitls.ViewUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FilterNewFragment.class */
public final class FilterNewFragment extends MVIBaseFragment<FilterViewModel> {
    private boolean A;
    private boolean B;
    private boolean C;
    private List<UserTag> D;
    private List<UserTag> E;
    private List<UserTag> F;
    private List<UserTag> G;
    private List<UserTag> H;
    private List<UserTag> I;
    private List<UserTag> J;
    private final Set<String> K;
    private final ViewBindingProperty d;
    private LayoutBasicsFilterBinding e;
    private LayoutVipFilterBinding f;
    private FilterDialogFragment g;
    private FilterCommonAdapterForGridView h;
    private FilterCommonAdapterForGridView i;
    private boolean j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private boolean z;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f30229c = {Reflection.a(new PropertyReference1Impl(FilterNewFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentFilterNewBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FilterNewFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FilterNewFragment() {
        super(R.layout.fragment_filter_new);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<FilterNewFragment, FragmentFilterNewBinding>() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentFilterNewBinding invoke(FilterNewFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentFilterNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<FilterNewFragment, FragmentFilterNewBinding>() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentFilterNewBinding invoke(FilterNewFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentFilterNewBinding.a(fragment.requireView());
            }
        });
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = "";
        this.x = "";
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new LinkedHashSet();
    }

    private final void C() {
        BluedPreferences.k(this.l);
        BluedPreferences.d(this.j);
        BluedPreferences.e(this.y);
        BluedPreferences.g(this.z);
        BluedPreferences.h(this.A);
        BluedPreferences.l(this.m);
        BluedPreferences.o(this.q);
        BluedPreferences.m(this.p);
        BluedPreferences.q(this.o);
        BluedPreferences.s(this.t);
        BluedPreferences.t(this.u);
        BluedPreferences.u(this.v);
        BluedPreferences.i(this.B);
        BluedPreferences.v(this.r);
        BluedPreferences.w(this.s);
        BluedPreferences.f(this.C);
        BluedPreferences.aB(this.w);
    }

    private final boolean D() {
        return E() || F() || H() || G() || J() || I() || K() || L() || M() || N() || O() || P() || R() || Q() || S() || T();
    }

    private final boolean E() {
        HashSet hashSet = new HashSet();
        for (UserTag userTag : this.F) {
            if (userTag.checked == 1) {
                hashSet.add(userTag.id);
                Logger.e("isModified", Intrinsics.a("isMakeFriendModify=id==", (Object) Integer.valueOf(userTag.id.hashCode())));
            }
        }
        if (this.K.size() != hashSet.size()) {
            return true;
        }
        Logger.e("isModified", "isMakeFriendModify=default==" + this.K + "===curret=:" + hashSet);
        for (String str : this.K) {
            if (!hashSet.contains(str)) {
                Logger.e("isModified", Intrinsics.a("isMakeFriendModify=tag==", (Object) Integer.valueOf(str.hashCode())));
                return true;
            }
        }
        Logger.e("isModified", "isMakeFriendModify=tag=fffff=false");
        return false;
    }

    private final boolean F() {
        return this.j != BluedPreferences.H();
    }

    private final boolean G() {
        return this.B != BluedPreferences.Y();
    }

    private final boolean H() {
        return this.A != BluedPreferences.S();
    }

    private final boolean I() {
        return !TextUtils.equals(this.s, BluedPreferences.aa());
    }

    private final boolean J() {
        return !TextUtils.equals(this.r, BluedPreferences.Z());
    }

    private final boolean K() {
        String b2 = b();
        if (TextUtils.isEmpty(b2) || !TextUtils.isEmpty(BluedPreferences.I())) {
            return (TextUtils.isEmpty(b2) && !TextUtils.isEmpty(BluedPreferences.I())) || !TextUtils.equals(b2, BluedPreferences.I());
        }
        return true;
    }

    private final boolean L() {
        return this.y != BluedPreferences.P();
    }

    private final boolean M() {
        return this.z != BluedPreferences.R();
    }

    private final boolean N() {
        if (TextUtils.equals(this.m, BluedPreferences.K())) {
            return false;
        }
        String str = this.m;
        Context context = getContext();
        return (TextUtils.equals(str, Intrinsics.a("0-", (Object) (context == null ? null : Integer.valueOf(FilterNewHelper.f30593a.a(context).length - 1)))) && TextUtils.equals(BluedPreferences.K(), "0-300")) ? false : true;
    }

    private final boolean O() {
        String M = FilterNewHelper.f30593a.a() ? BluedPreferences.M() : BluedPreferences.L();
        if (TextUtils.equals(this.p, M)) {
            return false;
        }
        String str = this.p;
        Context context = getContext();
        return (TextUtils.equals(str, Intrinsics.a("0-", (Object) (context == null ? null : Integer.valueOf(FilterNewHelper.f30593a.b(context).length - 1)))) && TextUtils.equals(M, "0-500")) ? false : true;
    }

    private final boolean P() {
        String O = FilterNewHelper.f30593a.a() ? BluedPreferences.O() : BluedPreferences.N();
        if (TextUtils.equals(this.q, O)) {
            return false;
        }
        String str = this.q;
        Context context = getContext();
        return (TextUtils.equals(str, Intrinsics.a("0-", (Object) (context == null ? null : Integer.valueOf(FilterNewHelper.f30593a.c(context).length - 1)))) && TextUtils.equals(O, "0-1000")) ? false : true;
    }

    private final boolean Q() {
        return !TextUtils.equals(this.o, BluedPreferences.T());
    }

    private final boolean R() {
        boolean z = true;
        String[] a2 = a(true);
        if (a2.length > 2) {
            Logger.e("isModified", "lookModify===:" + a2[2] + "===本地:" + ((Object) BluedPreferences.X()));
            if (!d(a2[1])) {
                if (e(a2[2])) {
                    return true;
                }
                z = false;
            }
            return z;
        }
        return false;
    }

    private final boolean S() {
        return this.C != BluedPreferences.Q();
    }

    private final boolean T() {
        return !TextUtils.equals(this.w, BluedPreferences.fJ());
    }

    private final int a(String str, int i) {
        String str2 = str;
        if (TextUtils.equals(str2, "max") || TextUtils.equals(str2, "300") || TextUtils.equals(str2, "500") || TextUtils.equals(str2, Constants.DEFAULT_UIN) || FilterNewHelper.f30593a.a(str)) {
            return i - 1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    private final String a(String str, String[] strArr, String str2) {
        return TextUtils.isEmpty(str) ? Intrinsics.a(strArr[0], (Object) str2) : (FilterNewHelper.f30593a.a(str) || FilterNewHelper.f30593a.a(strArr[Integer.parseInt(str)])) ? FilterNewHelper.f30593a.b() : Intrinsics.a(strArr[Integer.parseInt(str)], (Object) str2);
    }

    private final void a(Context context, LayoutBasicsFilterBinding layoutBasicsFilterBinding, final UserTagAll userTagAll) {
        List<UserTag> list = userTagAll.love_type;
        if (list == null || list.isEmpty()) {
            return;
        }
        FilterCommonPhotoGridView filterCommonPhotoGridView = layoutBasicsFilterBinding.f29384c;
        String string = context.getString(R.string.my_shape);
        Intrinsics.c(string, "context.getString(R.string.my_shape)");
        filterCommonPhotoGridView.setGridViewTitle(string);
        layoutBasicsFilterBinding.f29384c.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$setPart1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FilterNewFragment.this.g("HIS_FAVORITE_FILTER");
            }
        });
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, userTagAll.love_type);
        final PhotoGridView photoGridView = layoutBasicsFilterBinding.f29384c.getPhotoGridView();
        if (photoGridView == null) {
            return;
        }
        photoGridView.setVisibility(0);
        photoGridView.setAdapter((ListAdapter) userTagAdapterNew);
        photoGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$fV2sgFdGaDGKb4m61gkkI88K7rc
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.a(FilterNewFragment.this, photoGridView, userTagAll, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, ValueAnimator valueAnimator) {
        Intrinsics.e(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.c(layoutParams, "view.layoutParams");
        layoutParams.height = intValue;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, boolean z, FilterNewFragment this$0, ValueAnimator valueAnimator) {
        FragmentFilterNewBinding d;
        FilterScrollView filterScrollView;
        Intrinsics.e(view, "$view");
        Intrinsics.e(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        layoutParams2.height = ((Integer) animatedValue).intValue();
        view.setLayoutParams(layoutParams2);
        if (BluedConfig.a().S() == 1 || !z || (d = this$0.d()) == null || (filterScrollView = d.h) == null) {
            return;
        }
        filterScrollView.scrollTo((int) view.getX(), view.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(UserTagAll userTagAll) {
        if (userTagAll == null) {
            return;
        }
        List<UserTag> list = userTagAll.type;
        Intrinsics.c(list, "data.type");
        this.D = list;
        List<UserTag> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            int size = this.D.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                this.D.get(i2).checked = 0;
                i = i2 + 1;
            }
        }
        List<UserTag> list3 = userTagAll.character;
        Intrinsics.c(list3, "data.character");
        this.E = list3;
        if (list3 != null) {
            int size2 = list3.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                this.E.get(i4).checked = 0;
                i3 = i4 + 1;
            }
        }
        List<UserTag> list4 = userTagAll.love_type;
        Intrinsics.c(list4, "data.love_type");
        this.G = list4;
        if (list4 != null) {
            int size3 = list4.size();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size3) {
                    break;
                }
                this.G.get(i6).checked = 0;
                i5 = i6 + 1;
            }
        }
        List<UserTag> list5 = userTagAll.love_character;
        Intrinsics.c(list5, "data.love_character");
        this.H = list5;
        if (list5 != null) {
            int size4 = list5.size();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size4) {
                    break;
                }
                this.H.get(i8).checked = 0;
                i7 = i8 + 1;
            }
        }
        List<UserTag> list6 = userTagAll.i_want;
        Intrinsics.c(list6, "data.i_want");
        this.F = list6;
        if (list6 != null) {
            int size5 = list6.size();
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= size5) {
                    break;
                }
                this.F.get(i10).checked = 0;
                i9 = i10 + 1;
            }
        }
        a(this.t);
        BluedPreferences.t(a()[1]);
        BluedPreferences.u(a(true)[2]);
        b(userTagAll);
        c(userTagAll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserTagAll data, FilterNewFragment this$0, UserTagAdapterNew adapterMakeFriends, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(data, "$data");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(adapterMakeFriends, "$adapterMakeFriends");
        List<UserTag> list = data.i_want;
        if (list.get(i).checked == 1) {
            list.get(i).checked = 0;
        } else {
            list.get(i).checked = 1;
        }
        Intrinsics.c(list, "list");
        this$0.a(list);
        adapterMakeFriends.notifyDataSetChanged();
        this$0.k = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentFilterNewBinding vb, FilterNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vb, "$vb");
        Intrinsics.e(this$0, "this$0");
        BluedPreferences.d(!BluedPreferences.H());
        if (BluedPreferences.H()) {
            vb.g.setImageResource(2131237259);
            vb.b.setVisibility(8);
        } else {
            vb.g.setImageResource(2131237258);
            vb.b.setVisibility(0);
        }
        this$0.k = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LayoutVipFilterBinding vb, Context context, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vb, "$vb");
        Intrinsics.e(context, "$context");
        if (vb.f29438a.b()) {
            vb.f.setImageDrawable(context.getDrawable(R.drawable.icon_arrow_up_filter));
        } else {
            vb.f.setImageDrawable(context.getDrawable(R.drawable.icon_arrow_down_filter));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterNewFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        this$0.C();
        FilterDialogFragment filterDialogFragment = this$0.g;
        if (filterDialogFragment != null) {
            Intrinsics.a(filterDialogFragment);
            filterDialogFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final FilterNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.D()) {
            CommonAlertDialog.a(this$0.getContext(), this$0.getString(R.string.common_string_notice), this$0.getResources().getString(R.string.filter_give_up), this$0.getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$3PPY3x9MKZe1lWX_9kR9VGrmVro
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FilterNewFragment.a(FilterNewFragment.this, dialogInterface, i);
                }
            }, this$0.getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            return;
        }
        FilterDialogFragment filterDialogFragment = this$0.g;
        if (filterDialogFragment == null) {
            return;
        }
        filterDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterNewFragment this$0, UserTagAll data, FilterConstellationAdapter adapterConstellation, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        Intrinsics.e(adapterConstellation, "$adapterConstellation");
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            PayUtils.a(this$0.getActivity(), 24, "nearby_filter_constellation", VipProtos.FromType.CONSTELLATION_FILTER);
            EventTrackGuy.a(GuyProtos.Event.SCREEN_CONSTELLATION_BTN_CLICK, false, data.zodiac.get(i).id);
            return;
        }
        ConstellationModel constellationModel = data.zodiac.get(i);
        if (constellationModel.checked == 1) {
            constellationModel.checked = 0;
        } else {
            constellationModel.checked = 1;
            EventTrackGuy.a(GuyProtos.Event.SCREEN_CONSTELLATION_BTN_CLICK, true, constellationModel.id);
        }
        List<ConstellationModel> list = data.zodiac;
        Intrinsics.c(list, "data.zodiac");
        this$0.a(list, true, adapterConstellation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterNewFragment this$0, PhotoGridView photoGridView, UserTagAll data, UserTagAdapterNew adapterHisFavoriteType, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        Intrinsics.e(adapterHisFavoriteType, "$adapterHisFavoriteType");
        List<UserTag> list = data.love_type;
        Intrinsics.c(list, "data.love_type");
        this$0.a(photoGridView, list, adapterHisFavoriteType, i, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterNewFragment this$0, LayoutBasicsFilterBinding vb, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vb, "$vb");
        this$0.e();
        LinearLayout linearLayout = vb.m;
        Intrinsics.c(linearLayout, "vb.llMoreFilterView");
        boolean z = true;
        if (!(linearLayout.getVisibility() == 8)) {
            this$0.g("");
        }
        LinearLayout linearLayout2 = vb.m;
        Intrinsics.c(linearLayout2, "vb.llMoreFilterView");
        if (linearLayout2.getVisibility() != 8) {
            z = false;
        }
        LinearLayout linearLayout3 = vb.m;
        Intrinsics.c(linearLayout3, "vb.llMoreFilterView");
        LinearLayout linearLayout4 = linearLayout3;
        ImageView imageView = vb.l;
        Intrinsics.c(imageView, "vb.ivMoreFilterHeaderArrow");
        this$0.a(z, linearLayout4, imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterNewFragment this$0, LayoutBasicsFilterBinding vb, UserTagAdapterNew adapterShapes, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vb, "$vb");
        Intrinsics.e(adapterShapes, "$adapterShapes");
        PhotoGridView photoGridView = vb.k;
        Intrinsics.c(photoGridView, "vb.gvShape");
        this$0.a(photoGridView, this$0.D, adapterShapes, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterNewFragment this$0, UserTagAdapterNew adapterRelations, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(adapterRelations, "$adapterRelations");
        if (this$0.J.get(i).checked == 1) {
            this$0.J.get(i).checked = 0;
        } else {
            this$0.J.get(i).checked = 1;
        }
        for (UserTag userTag : this$0.J) {
            if (!Intrinsics.a((Object) userTag.id, (Object) this$0.J.get(i).id)) {
                userTag.checked = 0;
            }
        }
        this$0.b(this$0.J);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<UserTag> it = this$0.J.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserTag next = it.next();
            if (next.checked == 1) {
                FilterNewHelper filterNewHelper = FilterNewHelper.f30593a;
                String str = next.name;
                Intrinsics.c(str, "tag.name");
                if (filterNewHelper.a(str)) {
                    stringBuffer.append("-1");
                    break;
                }
                stringBuffer.append(Intrinsics.a(next.id, (Object) ","));
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.c(stringBuffer2, "sbID.toString()");
        this$0.c(stringBuffer2);
        adapterRelations.notifyDataSetChanged();
    }

    private final void a(List<? extends UserTag> list) {
        FilterCommonPhotoGridView filterCommonPhotoGridView;
        FilterCommonPhotoGridView filterCommonPhotoGridView2;
        FilterCommonPhotoGridView filterCommonPhotoGridView3;
        FilterCommonPhotoGridView filterCommonPhotoGridView4;
        Context context = getContext();
        if (context == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (UserTag userTag : list) {
            if (userTag.checked == 1 && !arrayList.contains(userTag.name)) {
                String str = userTag.name;
                Intrinsics.c(str, "it.name");
                arrayList.add(str);
            }
            if (userTag.checked == 0 && arrayList.contains(userTag.name)) {
                arrayList.remove(userTag.name);
            }
        }
        this.x = "";
        if (arrayList.size() > 0) {
            int i = 0;
            for (Object obj : arrayList) {
                if (i < 0) {
                    CollectionsKt.c();
                }
                String str2 = (String) obj;
                if (i != arrayList.size() - 1) {
                    this.x += str2 + ',';
                } else {
                    this.x = Intrinsics.a(this.x, (Object) str2);
                }
                i++;
            }
        }
        if (TextUtils.isEmpty(this.x) || TextUtils.equals(context.getString(R.string.filter_new_choose), this.x)) {
            LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
            if (layoutBasicsFilterBinding != null && (filterCommonPhotoGridView2 = layoutBasicsFilterBinding.e) != null && !filterCommonPhotoGridView2.b()) {
                String string = context.getString(R.string.filter_new_choose);
                Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
                this.x = string;
            }
            LayoutBasicsFilterBinding layoutBasicsFilterBinding2 = this.e;
            if (layoutBasicsFilterBinding2 != null && (filterCommonPhotoGridView = layoutBasicsFilterBinding2.e) != null) {
                filterCommonPhotoGridView.setRightTextColor(BluedSkinUtils.a(context, 2131102254));
            }
        } else {
            LayoutBasicsFilterBinding layoutBasicsFilterBinding3 = this.e;
            if (layoutBasicsFilterBinding3 != null && (filterCommonPhotoGridView4 = layoutBasicsFilterBinding3.e) != null) {
                filterCommonPhotoGridView4.setRightTextColor(BluedSkinUtils.a(context, 2131101766));
            }
        }
        LayoutBasicsFilterBinding layoutBasicsFilterBinding4 = this.e;
        if (layoutBasicsFilterBinding4 == null || (filterCommonPhotoGridView3 = layoutBasicsFilterBinding4.e) == null) {
            return;
        }
        filterCommonPhotoGridView3.setRightText(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List portraitList, FilterNewFragment this$0, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(portraitList, "$portraitList");
        Intrinsics.e(this$0, "this$0");
        if (((UserTag) portraitList.get(i)).checked == 1) {
            ((UserTag) portraitList.get(i)).checked = 0;
        } else {
            ((UserTag) portraitList.get(i)).checked = 1;
        }
        if (i == 0) {
            BluedPreferences.g(!BluedPreferences.R());
        } else {
            BluedPreferences.e(!BluedPreferences.P());
        }
        FilterCommonAdapterForGridView filterCommonAdapterForGridView = this$0.i;
        if (filterCommonAdapterForGridView != null) {
            filterCommonAdapterForGridView.notifyDataSetChanged();
        }
        this$0.k = true;
    }

    private final void a(List<ConstellationModel> list, boolean z, FilterConstellationAdapter filterConstellationAdapter) {
        Context context;
        LayoutVipFilterBinding layoutVipFilterBinding = this.f;
        if (layoutVipFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ConstellationModel constellationModel : list) {
            if (constellationModel.checked == 1) {
                if (!arrayList.contains(constellationModel.name)) {
                    String str = constellationModel.name;
                    Intrinsics.c(str, "model.name");
                    arrayList.add(str);
                }
                if (!arrayList.contains(constellationModel.id)) {
                    String str2 = constellationModel.id;
                    Intrinsics.c(str2, "model.id");
                    arrayList2.add(str2);
                }
            }
        }
        Iterator<E> it = arrayList.iterator();
        String str3 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (i2 < 0) {
                CollectionsKt.c();
            }
            String str4 = (String) next;
            str3 = i2 != arrayList.size() - 1 ? str3 + str4 + ',' : Intrinsics.a(str3, (Object) str4);
            i = i2 + 1;
        }
        String str5 = str3;
        if (str3.length() > 18) {
            String substring = str3.substring(0, 18);
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            str5 = Intrinsics.a(substring, (Object) "...");
        }
        if (z) {
            int i3 = 0;
            String str6 = "";
            for (Object obj : arrayList2) {
                if (i3 < 0) {
                    CollectionsKt.c();
                }
                String str7 = (String) obj;
                str6 = i3 != arrayList.size() - 1 ? str6 + str7 + ',' : Intrinsics.a(str6, (Object) str7);
                i3++;
            }
            BluedPreferences.aB(str6);
        }
        layoutVipFilterBinding.i.setText(str5);
        layoutVipFilterBinding.i.setTextColor(context.getResources().getColor(2131101766));
        filterConstellationAdapter.notifyDataSetChanged();
    }

    private final void a(final boolean z, final View view, final ImageView imageView) {
        ValueAnimator ofInt;
        int a2 = ViewUtils.a(view);
        int[] iArr = new int[2];
        if (z) {
            iArr[0] = 0;
            iArr[1] = a2;
            ofInt = ValueAnimator.ofInt(iArr);
        } else {
            iArr[0] = a2;
            iArr[1] = 0;
            ofInt = ValueAnimator.ofInt(iArr);
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$sv6QAuIFR3GaMR5y2DVNj8p_Ypo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FilterNewFragment.a(View.this, z, this, valueAnimator);
            }
        });
        ofInt.setDuration(150L);
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$showAnimation$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                LayoutBasicsFilterBinding layoutBasicsFilterBinding;
                Intrinsics.e(animation, "animation");
                View.this.setVisibility(z ? 0 : 8);
                ViewGroup.LayoutParams layoutParams = View.this.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.height = -2;
                View.this.setLayoutParams(layoutParams2);
                Drawable drawable = null;
                if (!z) {
                    this.f();
                    ImageView imageView2 = imageView;
                    Context context = this.getContext();
                    if (context != null) {
                        drawable = context.getDrawable(R.drawable.icon_arrow_down_filter);
                    }
                    imageView2.setImageDrawable(drawable);
                    return;
                }
                ImageView imageView3 = imageView;
                Context context2 = this.getContext();
                imageView3.setImageDrawable(context2 == null ? null : context2.getDrawable(R.drawable.icon_arrow_up_filter));
                layoutBasicsFilterBinding = this.e;
                RelativeLayout relativeLayout = layoutBasicsFilterBinding == null ? null : layoutBasicsFilterBinding.f;
                if (relativeLayout == null) {
                    return;
                }
                relativeLayout.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.e(animation, "animation");
                View.this.setVisibility(0);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$VB_uiiUVF_YjV2AgLO-0S3gmJfA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FilterNewFragment.a(View.this, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void b(Context context, LayoutBasicsFilterBinding layoutBasicsFilterBinding, final UserTagAll userTagAll) {
        List<UserTag> list = userTagAll.love_character;
        if (list == null || list.isEmpty()) {
            return;
        }
        FilterCommonPhotoGridView filterCommonPhotoGridView = layoutBasicsFilterBinding.f29384c;
        String string = context.getString(R.string.my_personality);
        Intrinsics.c(string, "context.getString(R.string.my_personality)");
        filterCommonPhotoGridView.setGridViewTitle2(string);
        layoutBasicsFilterBinding.f29384c.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$setPart2$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FilterNewFragment.this.g("HIS_FAVORITE_FILTER");
            }
        });
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, userTagAll.love_character);
        final PhotoGridView photoGridView2 = layoutBasicsFilterBinding.f29384c.getPhotoGridView2();
        if (photoGridView2 == null) {
            return;
        }
        photoGridView2.setVisibility(0);
        photoGridView2.setAdapter((ListAdapter) userTagAdapterNew);
        photoGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$jP74qXwT1zU7EtgUJRwo72_iVIg
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.b(FilterNewFragment.this, photoGridView2, userTagAll, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    private final void b(UserTagAll userTagAll) {
        g(userTagAll);
        f(userTagAll);
        d(userTagAll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FilterNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.s();
        String[] a2 = this$0.a();
        BluedPreferences.s(a2[0]);
        BluedPreferences.t(a2[1]);
        BluedPreferences.u(this$0.a(true)[2]);
        PeopleDataObserver.a().b();
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_COMPLETE_BTN_CLICK, NearbyHttpUtils.a(NearbyHttpUtils.a(this$0.getContext(), new FilterEntity())), BluedPreferences.H());
        FilterDialogFragment filterDialogFragment = this$0.g;
        if (filterDialogFragment != null) {
            Intrinsics.a(filterDialogFragment);
            filterDialogFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FilterNewFragment this$0, PhotoGridView photoGridView, UserTagAll data, UserTagAdapterNew adapterHisFavoriteType, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        Intrinsics.e(adapterHisFavoriteType, "$adapterHisFavoriteType");
        List<UserTag> list = data.love_character;
        Intrinsics.c(list, "data.love_character");
        this$0.a(photoGridView, list, adapterHisFavoriteType, i, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FilterNewFragment this$0, LayoutBasicsFilterBinding vb, UserTagAdapterNew adapterRoles, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vb, "$vb");
        Intrinsics.e(adapterRoles, "$adapterRoles");
        PhotoGridView photoGridView = vb.i;
        Intrinsics.c(photoGridView, "vb.gvHeIs");
        this$0.a(photoGridView, this$0.I, adapterRoles, i, 0);
    }

    private final void b(List<? extends UserTag> list) {
        Context context;
        FilterCommonPhotoGridView filterCommonPhotoGridView;
        FilterCommonPhotoGridView filterCommonPhotoGridView2;
        FilterCommonPhotoGridView filterCommonPhotoGridView3;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        Iterator<? extends UserTag> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserTag next = it.next();
            if (next.checked == 1) {
                String str = next.name;
                Intrinsics.c(str, "tag.name");
                this.n = str;
                break;
            }
            this.n = "";
        }
        if (!layoutBasicsFilterBinding.g.b() && TextUtils.isEmpty(this.n)) {
            String string = context.getString(R.string.filter_new_choose);
            Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
            this.n = string;
        }
        if (TextUtils.equals(this.n, context.getString(R.string.filter_new_choose))) {
            LayoutBasicsFilterBinding layoutBasicsFilterBinding2 = this.e;
            if (layoutBasicsFilterBinding2 != null && (filterCommonPhotoGridView3 = layoutBasicsFilterBinding2.g) != null) {
                filterCommonPhotoGridView3.setRightTextColor(BluedSkinUtils.a(context, 2131102254));
            }
        } else {
            LayoutBasicsFilterBinding layoutBasicsFilterBinding3 = this.e;
            if (layoutBasicsFilterBinding3 != null && (filterCommonPhotoGridView = layoutBasicsFilterBinding3.g) != null) {
                filterCommonPhotoGridView.setRightTextColor(BluedSkinUtils.a(context, 2131101766));
            }
        }
        LayoutBasicsFilterBinding layoutBasicsFilterBinding4 = this.e;
        if (layoutBasicsFilterBinding4 == null || (filterCommonPhotoGridView2 = layoutBasicsFilterBinding4.g) == null) {
            return;
        }
        filterCommonPhotoGridView2.setRightText(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List priorityList, FilterNewFragment this$0, AdapterView adapterView, View view, int i, long j) {
        VipProtos.FromType fromType;
        String str;
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(priorityList, "$priorityList");
        Intrinsics.e(this$0, "this$0");
        if (((UserTag) priorityList.get(i)).checked == 0) {
            if (i == 0) {
                EventTrackGuy.a(GuyProtos.Event.SCREEN_AUTH_USER_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
            } else if (i != 1) {
                EventTrackGuy.a(GuyProtos.Event.SCREEN_PHOTO_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
            } else {
                EventTrackGuy.a(GuyProtos.Event.SCREEN_VIP_USER_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
            }
        }
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            if (i == 0) {
                fromType = VipProtos.FromType.AUTHENTICATED_FILTER;
                str = "nearby_filter_auth_user";
            } else if (i != 1) {
                fromType = VipProtos.FromType.PHOTO_FILTER;
                str = "nearby_filter_album";
            } else {
                fromType = VipProtos.FromType.VIP_FILTER;
                str = "nearby_filter_vip_user";
            }
            PayUtils.a(this$0.getActivity(), 24, str, fromType);
            return;
        }
        if (((UserTag) priorityList.get(i)).checked == 1) {
            ((UserTag) priorityList.get(i)).checked = 0;
        } else {
            ((UserTag) priorityList.get(i)).checked = 1;
        }
        if (i == 0) {
            BluedPreferences.h(!BluedPreferences.S());
        } else if (i != 1) {
            BluedPreferences.f(!BluedPreferences.Q());
        } else {
            BluedPreferences.i(!BluedPreferences.Y());
        }
        FilterCommonAdapterForGridView filterCommonAdapterForGridView = this$0.h;
        if (filterCommonAdapterForGridView != null) {
            filterCommonAdapterForGridView.notifyDataSetChanged();
        }
        this$0.k = true;
    }

    private final void c(UserTagAll userTagAll) {
        j();
        e(userTagAll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FilterNewFragment this$0, PhotoGridView photoGridView, UserTagAll data, UserTagAdapterNew adapterHisTag, AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        Intrinsics.e(adapterHisTag, "$adapterHisTag");
        List<UserTag> list = data.character;
        Intrinsics.c(list, "data.character");
        this$0.a(photoGridView, list, adapterHisTag, i, 1);
    }

    private final void c(String str) {
        String str2;
        if (StringUtils.d(str)) {
            BluedPreferences.q("");
        } else {
            this.k = true;
            if (Intrinsics.a((Object) str, (Object) "-1")) {
                BluedPreferences.q(str);
            } else {
                int i = 0;
                Object[] array = StringsKt.b((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                String[] strArr = (String[]) array;
                String[] strArr2 = new String[strArr.length];
                int length = strArr.length;
                String str3 = "";
                while (true) {
                    str2 = str3;
                    if (i >= length) {
                        break;
                    }
                    String str4 = str2;
                    if (!TextUtils.isEmpty(strArr[i])) {
                        str4 = (Integer.parseInt(strArr[i]) + 1) + ',' + str2;
                        strArr2[i] = (Integer.parseInt(strArr[i]) + 1) + "";
                    }
                    i++;
                    str3 = str4;
                }
                BluedPreferences.q(str2);
            }
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentFilterNewBinding d() {
        return (FragmentFilterNewBinding) this.d.b(this, f30229c[0]);
    }

    private final void d(UserTagAll userTagAll) {
        Context context;
        final LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, userTagAll.type);
        layoutBasicsFilterBinding.k.setAdapter((ListAdapter) userTagAdapterNew);
        layoutBasicsFilterBinding.k.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$2yYhk7wMTojED3qboa6M6H68JXg
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.a(FilterNewFragment.this, layoutBasicsFilterBinding, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    private final boolean d(String str) {
        return !TextUtils.equals(str, BluedPreferences.W());
    }

    private final void e() {
        Context context;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        String string = context.getString(R.string.filter_new_choose);
        Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
        boolean z = true;
        String[] a2 = a(true);
        if (BluedPreferences.P() || BluedPreferences.R()) {
            return;
        }
        if (TextUtils.isEmpty(this.n) || TextUtils.equals(this.n, string)) {
            if ((TextUtils.isEmpty(this.x) || TextUtils.equals(this.x, string)) && TextUtils.isEmpty(a2[1]) && TextUtils.isEmpty(a2[2])) {
                layoutBasicsFilterBinding.f.setVisibility(8);
                LinearLayout linearLayout = layoutBasicsFilterBinding.m;
                Intrinsics.c(linearLayout, "vb.llMoreFilterView");
                if (linearLayout.getVisibility() != 8) {
                    z = false;
                }
                if (z) {
                    layoutBasicsFilterBinding.y.setVisibility(8);
                    return;
                }
                layoutBasicsFilterBinding.y.setText(context.getString(R.string.filter_more_default_content));
                layoutBasicsFilterBinding.y.setVisibility(0);
            }
        }
    }

    private final void e(final UserTagAll userTagAll) {
        final Context context;
        final LayoutVipFilterBinding layoutVipFilterBinding = this.f;
        if (layoutVipFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutVipFilterBinding.f29438a.setShowItemHeight(250);
        layoutVipFilterBinding.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$gbFHaBjNGp6Jo-flYGulKEhDEyM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterNewFragment.a(LayoutVipFilterBinding.this, context, view);
            }
        });
        String chosenId = BluedPreferences.fJ();
        String str = chosenId;
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.c(chosenId, "chosenId");
            List<String> b2 = StringsKt.b((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            List<ConstellationModel> list = userTagAll.zodiac;
            Intrinsics.c(list, "data.zodiac");
            Iterator<ConstellationModel> it = list.iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                ConstellationModel next = it.next();
                if (i2 < 0) {
                    CollectionsKt.c();
                }
                ConstellationModel constellationModel = next;
                for (String str2 : b2) {
                    if (TextUtils.equals(str2, constellationModel.id)) {
                        constellationModel.checked = 1;
                    }
                }
                i = i2 + 1;
            }
        }
        List<ConstellationModel> list2 = userTagAll.zodiac;
        Intrinsics.c(list2, "data.zodiac");
        final FilterConstellationAdapter filterConstellationAdapter = new FilterConstellationAdapter(context, list2);
        List<ConstellationModel> list3 = userTagAll.zodiac;
        Intrinsics.c(list3, "data.zodiac");
        a(list3, false, filterConstellationAdapter);
        layoutVipFilterBinding.d.setAdapter((ListAdapter) filterConstellationAdapter);
        layoutVipFilterBinding.d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$vYkw77saqUDSgrvu1OGw2eG6-Wo
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j) {
                FilterNewFragment.a(FilterNewFragment.this, userTagAll, filterConstellationAdapter, adapterView, view, i3, j);
            }
        });
    }

    private final boolean e(String str) {
        return !TextUtils.equals(str, BluedPreferences.X());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        Context context;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        String string = context.getString(R.string.filter_new_choose);
        Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
        String[] a2 = a(true);
        if (!BluedPreferences.P() && !BluedPreferences.R() && ((TextUtils.isEmpty(this.n) || TextUtils.equals(this.n, string)) && ((TextUtils.isEmpty(this.x) || TextUtils.equals(this.x, string)) && TextUtils.isEmpty(a2[1]) && TextUtils.isEmpty(a2[2])))) {
            layoutBasicsFilterBinding.f.setVisibility(8);
            return;
        }
        layoutBasicsFilterBinding.y.setVisibility(8);
        layoutBasicsFilterBinding.f.setVisibility(0);
        if (BluedPreferences.R() && BluedPreferences.P()) {
            layoutBasicsFilterBinding.u.setVisibility(0);
            layoutBasicsFilterBinding.v.setVisibility(0);
            TextView textView = layoutBasicsFilterBinding.v;
            textView.setText(context.getString(R.string.filter_ai_photo) + ',' + context.getString(R.string.filter_header));
        } else if (BluedPreferences.R()) {
            layoutBasicsFilterBinding.u.setVisibility(0);
            layoutBasicsFilterBinding.v.setVisibility(0);
            layoutBasicsFilterBinding.v.setText(context.getString(R.string.filter_ai_photo));
        } else if (BluedPreferences.P()) {
            layoutBasicsFilterBinding.u.setVisibility(0);
            layoutBasicsFilterBinding.v.setVisibility(0);
            layoutBasicsFilterBinding.v.setText(context.getString(R.string.filter_header));
        } else {
            layoutBasicsFilterBinding.u.setVisibility(8);
            layoutBasicsFilterBinding.v.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.n) || TextUtils.equals(this.n, string)) {
            layoutBasicsFilterBinding.w.setVisibility(8);
            layoutBasicsFilterBinding.x.setVisibility(8);
        } else {
            layoutBasicsFilterBinding.w.setVisibility(0);
            layoutBasicsFilterBinding.x.setVisibility(0);
            layoutBasicsFilterBinding.x.setText(this.n);
        }
        if (TextUtils.isEmpty(this.x) || TextUtils.equals(this.x, string)) {
            layoutBasicsFilterBinding.s.setVisibility(8);
            layoutBasicsFilterBinding.t.setVisibility(8);
        } else {
            layoutBasicsFilterBinding.s.setVisibility(0);
            layoutBasicsFilterBinding.t.setVisibility(0);
            layoutBasicsFilterBinding.t.setText(this.x);
        }
        if (TextUtils.isEmpty(a2[1]) || TextUtils.equals(a2[1], string)) {
            layoutBasicsFilterBinding.o.setVisibility(8);
            layoutBasicsFilterBinding.p.setVisibility(8);
        } else {
            layoutBasicsFilterBinding.o.setVisibility(0);
            layoutBasicsFilterBinding.p.setVisibility(0);
            layoutBasicsFilterBinding.p.setText(a2[1]);
        }
        if (TextUtils.isEmpty(a2[2]) || TextUtils.equals(a2[2], string)) {
            layoutBasicsFilterBinding.q.setVisibility(8);
            layoutBasicsFilterBinding.r.setVisibility(8);
            return;
        }
        layoutBasicsFilterBinding.q.setVisibility(0);
        layoutBasicsFilterBinding.r.setVisibility(0);
        layoutBasicsFilterBinding.r.setText(a2[2]);
    }

    private final void f(UserTagAll userTagAll) {
        Context context;
        final LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        String I = BluedPreferences.I();
        Intrinsics.c(I, "getTYPECHOICE()");
        this.l = I;
        b(I);
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, this.I);
        layoutBasicsFilterBinding.i.setAdapter((ListAdapter) userTagAdapterNew);
        layoutBasicsFilterBinding.i.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$FVHnD1WEhBlJZs0ZlIifseCJWxQ
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.b(FilterNewFragment.this, layoutBasicsFilterBinding, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String str) {
        LayoutBasicsFilterBinding layoutBasicsFilterBinding;
        FilterCommonScrollSelectorView filterCommonScrollSelectorView;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding2;
        FilterCommonScrollSelectorView filterCommonScrollSelectorView2;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding3;
        FilterCommonScrollSelectorView filterCommonScrollSelectorView3;
        LayoutVipFilterBinding layoutVipFilterBinding;
        FilterCommonScrollSelectorView filterCommonScrollSelectorView4;
        LayoutVipFilterBinding layoutVipFilterBinding2;
        FilterCommonScrollSelectorView filterCommonScrollSelectorView5;
        String str2 = str;
        if (!TextUtils.equals(str2, "ONLINE_TIME_FILTER") && (layoutVipFilterBinding2 = this.f) != null && (filterCommonScrollSelectorView5 = layoutVipFilterBinding2.f29439c) != null) {
            filterCommonScrollSelectorView5.a();
        }
        if (!TextUtils.equals(str2, "DISTANCE_FILTER") && (layoutVipFilterBinding = this.f) != null && (filterCommonScrollSelectorView4 = layoutVipFilterBinding.b) != null) {
            filterCommonScrollSelectorView4.a();
        }
        if (!TextUtils.equals(str2, "AGE_FILTER") && (layoutBasicsFilterBinding3 = this.e) != null && (filterCommonScrollSelectorView3 = layoutBasicsFilterBinding3.f29383a) != null) {
            filterCommonScrollSelectorView3.a();
        }
        if (!TextUtils.equals(str2, "HEIGHT_FILTER") && (layoutBasicsFilterBinding2 = this.e) != null && (filterCommonScrollSelectorView2 = layoutBasicsFilterBinding2.b) != null) {
            filterCommonScrollSelectorView2.a();
        }
        if (TextUtils.equals(str2, "WEIGHT_FILTER") || (layoutBasicsFilterBinding = this.e) == null || (filterCommonScrollSelectorView = layoutBasicsFilterBinding.h) == null) {
            return;
        }
        filterCommonScrollSelectorView.a();
    }

    private final void g() {
        String[] strArr;
        String str;
        if (getContext() == null) {
            return;
        }
        String[] stringArray = getResources().getStringArray(R.array.relation_status_array);
        Intrinsics.c(stringArray, "resources.getStringArray…ay.relation_status_array)");
        stringArray[0] = getResources().getString(R.string.unlimited);
        String selectedPosition = BluedPreferences.T();
        String str2 = selectedPosition;
        if (TextUtils.isEmpty(str2)) {
            strArr = null;
        } else {
            Intrinsics.c(selectedPosition, "selectedPosition");
            Object[] array = StringsKt.b((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            strArr = (String[]) array;
        }
        int[] iArr = BlueAppLocal.d() ? UserRelationshipUtils.l : null;
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            this.J.add(new UserTag(i2 + "", stringArray[i2], 0));
            i = i2 + 1;
        }
        if (iArr != null && iArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            int length2 = iArr.length;
            int i3 = 0;
            while (i3 < length2) {
                int i4 = iArr[i3];
                i3++;
                arrayList.add(Integer.valueOf(i4));
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.J.size()) {
                    break;
                }
                int i7 = i6;
                if (arrayList.contains(Integer.valueOf(i6))) {
                    this.J.remove(i6);
                    i7 = i6 - 1;
                }
                i5 = i7 + 1;
            }
        }
        if (Intrinsics.a((Object) selectedPosition, (Object) "-1") && this.J.size() > 0) {
            this.J.get(0).checked = 1;
        } else if (strArr != null && strArr.length > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator a2 = ArrayIteratorKt.a(strArr);
            while (a2.hasNext()) {
                if (!TextUtils.isEmpty((String) a2.next())) {
                    arrayList2.add((Integer.valueOf(str).intValue() - 1) + "");
                }
            }
            for (UserTag userTag : this.J) {
                if (arrayList2.contains(userTag.id)) {
                    userTag.checked = 1;
                }
            }
        }
        b(this.J);
    }

    private final void g(UserTagAll userTagAll) {
        k(userTagAll);
        l(userTagAll);
        j(userTagAll);
        i(userTagAll);
        h(userTagAll);
        f();
        e();
        final LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null) {
            return;
        }
        layoutBasicsFilterBinding.m.setVisibility(8);
        layoutBasicsFilterBinding.n.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$9UqqwAklQaNiciwjOdjrwf4cb6A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterNewFragment.a(FilterNewFragment.this, layoutBasicsFilterBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str) {
        LayoutBasicsFilterBinding layoutBasicsFilterBinding;
        FilterCommonPhotoGridView filterCommonPhotoGridView;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding2;
        FilterCommonPhotoGridView filterCommonPhotoGridView2;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding3;
        FilterCommonPhotoGridView filterCommonPhotoGridView3;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding4;
        FilterCommonPhotoGridView filterCommonPhotoGridView4;
        String str2 = str;
        if (!TextUtils.equals(str2, "RELATION_FILTER") && (layoutBasicsFilterBinding4 = this.e) != null && (filterCommonPhotoGridView4 = layoutBasicsFilterBinding4.g) != null) {
            filterCommonPhotoGridView4.a();
        }
        if (!TextUtils.equals(str2, "MAKE_FRIENDS_FILTER") && (layoutBasicsFilterBinding3 = this.e) != null && (filterCommonPhotoGridView3 = layoutBasicsFilterBinding3.e) != null) {
            filterCommonPhotoGridView3.a();
        }
        if (!TextUtils.equals(str2, "HIS_TAG_FILTER") && (layoutBasicsFilterBinding2 = this.e) != null && (filterCommonPhotoGridView2 = layoutBasicsFilterBinding2.d) != null) {
            filterCommonPhotoGridView2.a();
        }
        if (TextUtils.equals(str2, "HIS_FAVORITE_FILTER") || (layoutBasicsFilterBinding = this.e) == null || (filterCommonPhotoGridView = layoutBasicsFilterBinding.f29384c) == null) {
            return;
        }
        filterCommonPhotoGridView.a();
    }

    private final void h() {
        final LayoutVipFilterBinding layoutVipFilterBinding;
        String format;
        String format2;
        Context context = getContext();
        if (context == null || (layoutVipFilterBinding = this.f) == null) {
            return;
        }
        layoutVipFilterBinding.f29439c.setNeedVipPrivilege(true);
        layoutVipFilterBinding.f29439c.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initOnlineTimeData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FragmentFilterNewBinding d;
                FilterScrollView filterScrollView;
                FilterNewFragment.this.f("ONLINE_TIME_FILTER");
                d = FilterNewFragment.this.d();
                if (d == null || (filterScrollView = d.h) == null) {
                    return;
                }
                filterScrollView.setOnTouchView(layoutVipFilterBinding.f29439c.getTwoLevelView());
            }
        });
        String[] d = FilterNewHelper.f30593a.d(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = d.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                break;
            }
            String str = d[i];
            if (i3 != d.length - 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = context.getString(2131890633);
                Intrinsics.c(string, "context.getString(R.string.minutes)");
                String format3 = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.c(format3, "format(format, *args)");
                linkedHashMap.put(format3, Integer.valueOf(i3));
            }
            if (FilterNewHelper.f30593a.a(str)) {
                linkedHashMap2.put(str, Integer.valueOf(i3));
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                String string2 = context.getString(2131890633);
                Intrinsics.c(string2, "context.getString(R.string.minutes)");
                String format4 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.c(format4, "format(format, *args)");
                linkedHashMap2.put(format4, Integer.valueOf(i3));
            }
            i++;
            i2 = i3 + 1;
        }
        String aa = BluedPreferences.aa();
        Intrinsics.c(aa, "getTIME_RANGE()");
        this.s = aa;
        if (TextUtils.isEmpty(aa)) {
            this.s = "0-max";
            BluedPreferences.w("0-max");
            layoutVipFilterBinding.f29439c.setRightTextColor(Integer.valueOf(BluedSkinUtils.a(context, 2131102254)));
        } else {
            layoutVipFilterBinding.f29439c.setRightTextColor(Integer.valueOf(context.getResources().getColor(2131102182)));
        }
        layoutVipFilterBinding.f29439c.a(linkedHashMap, linkedHashMap2);
        layoutVipFilterBinding.f29439c.setTag("ONLINE_TIME");
        List b2 = StringsKt.b((CharSequence) this.s, new String[]{"-"}, false, 0, 6, (Object) null);
        if (FilterNewHelper.f30593a.a(a((String) b2.get(0), d, ""))) {
            format = FilterNewHelper.f30593a.b();
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
            String string3 = context.getString(2131890633);
            Intrinsics.c(string3, "context.getString(R.string.minutes)");
            format = String.format(string3, Arrays.copyOf(new Object[]{a((String) b2.get(0), d, "")}, 1));
            Intrinsics.c(format, "format(format, *args)");
        }
        if (FilterNewHelper.f30593a.a(d[a((String) b2.get(1), d.length)])) {
            format2 = FilterNewHelper.f30593a.b();
        } else {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.f42549a;
            String string4 = context.getString(2131890633);
            Intrinsics.c(string4, "context.getString(R.string.minutes)");
            format2 = String.format(string4, Arrays.copyOf(new Object[]{d[a((String) b2.get(1), d.length)]}, 1));
            Intrinsics.c(format2, "format(format, *args)");
        }
        FilterCommonScrollSelectorView filterCommonScrollSelectorView = layoutVipFilterBinding.f29439c;
        Integer num = (Integer) linkedHashMap.get(format);
        String str2 = format2;
        if (FilterNewHelper.f30593a.a(format2)) {
            str2 = d[d.length - 1];
        }
        filterCommonScrollSelectorView.a(num, (Integer) linkedHashMap2.get(str2));
        layoutVipFilterBinding.f29439c.setRightText(false);
    }

    private final void h(UserTagAll userTagAll) {
        Context context;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        String X = BluedPreferences.X();
        Intrinsics.c(X, "getTAGCHOICETEXT_LOOKFOR()");
        this.v = X;
        if (TextUtils.isEmpty(X)) {
            String string = context.getString(R.string.filter_new_choose);
            Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
            this.v = string;
            layoutBasicsFilterBinding.f29384c.setRightTextColor(BluedSkinUtils.a(context, 2131102254));
        } else {
            layoutBasicsFilterBinding.f29384c.setRightTextColor(BluedSkinUtils.a(context, 2131101766));
        }
        layoutBasicsFilterBinding.f29384c.setRightText(this.v);
        a(context, layoutBasicsFilterBinding, userTagAll);
        b(context, layoutBasicsFilterBinding, userTagAll);
    }

    private final void i() {
        Context context;
        final LayoutVipFilterBinding layoutVipFilterBinding = this.f;
        if (layoutVipFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutVipFilterBinding.b.setNeedVipPrivilege(true);
        layoutVipFilterBinding.b.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initDistanceData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FragmentFilterNewBinding d;
                FilterScrollView filterScrollView;
                FilterNewFragment.this.f("DISTANCE_FILTER");
                d = FilterNewFragment.this.d();
                if (d == null || (filterScrollView = d.h) == null) {
                    return;
                }
                filterScrollView.setOnTouchView(layoutVipFilterBinding.b.getTwoLevelView());
            }
        });
        String[] e = FilterNewHelper.f30593a.e(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = e.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                break;
            }
            String str = e[i];
            if (i3 != e.length - 1) {
                linkedHashMap.put(Intrinsics.a(str, (Object) context.getString(R.string.distance_unit)), Integer.valueOf(i3));
            }
            if (FilterNewHelper.f30593a.a(str)) {
                linkedHashMap2.put(str, Integer.valueOf(i3));
            } else {
                linkedHashMap2.put(Intrinsics.a(str, (Object) context.getString(R.string.distance_unit)), Integer.valueOf(i3));
            }
            i++;
            i2 = i3 + 1;
        }
        String Z = BluedPreferences.Z();
        Intrinsics.c(Z, "getDISTANCE_RANGE()");
        this.r = Z;
        if (TextUtils.isEmpty(Z)) {
            this.r = "0-max";
            BluedPreferences.v("0-max");
            layoutVipFilterBinding.b.setRightTextColor(Integer.valueOf(BluedSkinUtils.a(context, 2131102254)));
        } else {
            layoutVipFilterBinding.b.setRightTextColor(Integer.valueOf(context.getResources().getColor(2131102182)));
        }
        layoutVipFilterBinding.b.a(linkedHashMap, linkedHashMap2);
        layoutVipFilterBinding.b.setTag("DISTANCE");
        List b2 = StringsKt.b((CharSequence) this.r, new String[]{"-"}, false, 0, 6, (Object) null);
        String str2 = (String) b2.get(0);
        String string = context.getString(R.string.distance_unit);
        Intrinsics.c(string, "context.getString(R.string.distance_unit)");
        String a2 = a(str2, e, string);
        String b3 = FilterNewHelper.f30593a.a(e[a((String) b2.get(1), e.length)]) ? FilterNewHelper.f30593a.b() : Intrinsics.a(e[a((String) b2.get(1), e.length)], (Object) context.getString(R.string.distance_unit));
        FilterCommonScrollSelectorView filterCommonScrollSelectorView = layoutVipFilterBinding.b;
        Integer num = (Integer) linkedHashMap.get(a2);
        String str3 = b3;
        if (FilterNewHelper.f30593a.a(b3)) {
            str3 = e[e.length - 1];
        }
        filterCommonScrollSelectorView.a(num, (Integer) linkedHashMap2.get(str3));
        layoutVipFilterBinding.b.setRightText(false);
    }

    private final void i(final UserTagAll userTagAll) {
        Context context;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        String W = BluedPreferences.W();
        Intrinsics.c(W, "getTAGCHOICETEXT_HEIS()");
        this.u = W;
        if (TextUtils.isEmpty(W)) {
            String string = context.getString(R.string.filter_new_choose);
            Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
            this.u = string;
            layoutBasicsFilterBinding.d.setRightTextColor(BluedSkinUtils.a(context, 2131102254));
        } else {
            layoutBasicsFilterBinding.d.setRightTextColor(BluedSkinUtils.a(context, 2131101766));
        }
        layoutBasicsFilterBinding.d.setRightText(this.u);
        List<UserTag> list = userTagAll.character;
        if (list == null || list.isEmpty()) {
            return;
        }
        FilterCommonPhotoGridView filterCommonPhotoGridView = layoutBasicsFilterBinding.d;
        String string2 = context.getString(R.string.my_personality);
        Intrinsics.c(string2, "context.getString(R.string.my_personality)");
        filterCommonPhotoGridView.setGridViewTitle(string2);
        layoutBasicsFilterBinding.d.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initHisTagData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FilterNewFragment.this.g("HIS_TAG_FILTER");
            }
        });
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, userTagAll.character);
        final PhotoGridView photoGridView = layoutBasicsFilterBinding.d.getPhotoGridView();
        if (photoGridView != null) {
            photoGridView.setAdapter((ListAdapter) userTagAdapterNew);
        }
        if (photoGridView == null) {
            return;
        }
        photoGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$rpV68L5GOd9BvUrn9qdUvSICr-s
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.c(FilterNewFragment.this, photoGridView, userTagAll, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final void j() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void j(final UserTagAll userTagAll) {
        Context context;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutBasicsFilterBinding.e.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initMakeFriendsData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FilterNewFragment.this.g("MAKE_FRIENDS_FILTER");
            }
        });
        if (TextUtils.isEmpty(this.x)) {
            String string = context.getString(R.string.filter_new_choose);
            Intrinsics.c(string, "context.getString(R.string.filter_new_choose)");
            this.x = string;
        }
        List<UserTag> list = userTagAll.i_want;
        Intrinsics.c(list, "data.i_want");
        a(list);
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, userTagAll.i_want);
        PhotoGridView photoGridView = layoutBasicsFilterBinding.e.getPhotoGridView();
        if (photoGridView != null) {
            photoGridView.setAdapter((ListAdapter) userTagAdapterNew);
        }
        if (photoGridView == null) {
            return;
        }
        photoGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$WqcSJpSY8fXAXqNDH20BU_mGmMs
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.a(UserTagAll.this, this, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final void k(UserTagAll userTagAll) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void l() {
        Context context;
        String N;
        String str;
        final LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutBasicsFilterBinding.h.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initWeightData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FragmentFilterNewBinding d;
                FilterScrollView filterScrollView;
                FilterNewFragment.this.f("WEIGHT_FILTER");
                d = FilterNewFragment.this.d();
                if (d == null || (filterScrollView = d.h) == null) {
                    return;
                }
                filterScrollView.setOnTouchView(layoutBasicsFilterBinding.h.getTwoLevelView());
            }
        });
        String[] c2 = FilterNewHelper.f30593a.c(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = c2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                break;
            }
            String str2 = c2[i];
            if (i3 != c2.length - 1) {
                if (FilterNewHelper.f30593a.a(str2)) {
                    linkedHashMap.put(FilterNewHelper.f30593a.b(), Integer.valueOf(i3));
                } else {
                    linkedHashMap.put(Intrinsics.a(str2, (Object) FilterNewHelper.f30593a.c()), Integer.valueOf(i3));
                }
            }
            if (i3 != 0) {
                if (FilterNewHelper.f30593a.a(str2)) {
                    linkedHashMap2.put(FilterNewHelper.f30593a.b(), Integer.valueOf(i3));
                } else {
                    linkedHashMap2.put(Intrinsics.a(str2, (Object) FilterNewHelper.f30593a.c()), Integer.valueOf(i3));
                }
            }
            i++;
            i2 = i3 + 1;
        }
        if (FilterNewHelper.f30593a.a()) {
            N = BluedPreferences.O();
            str = "getWEIGHTCHOICE_LBS()";
        } else {
            N = BluedPreferences.N();
            str = "getWEIGHTCHOICE()";
        }
        Intrinsics.c(N, str);
        this.q = N;
        if (TextUtils.isEmpty(N)) {
            layoutBasicsFilterBinding.h.setRightTextColor(Integer.valueOf(BluedSkinUtils.a(context, 2131102254)));
            this.q = Intrinsics.a("1-", (Object) Integer.valueOf(c2.length - 2));
            if (FilterNewHelper.f30593a.a()) {
                BluedPreferences.p(this.q);
            } else {
                BluedPreferences.o(this.q);
            }
        } else {
            FilterCommonScrollSelectorView filterCommonScrollSelectorView = layoutBasicsFilterBinding.h;
            Resources resources = context.getResources();
            filterCommonScrollSelectorView.setRightTextColor(resources == null ? null : Integer.valueOf(resources.getColor(2131101766)));
        }
        List b2 = StringsKt.b((CharSequence) this.q, new String[]{"-"}, false, 0, 6, (Object) null);
        String a2 = a((String) b2.get(0), c2, FilterNewHelper.f30593a.c());
        String b3 = FilterNewHelper.f30593a.a(c2[a((String) b2.get(1), c2.length)]) ? FilterNewHelper.f30593a.b() : Intrinsics.a(c2[a((String) b2.get(1), c2.length)], (Object) FilterNewHelper.f30593a.c());
        layoutBasicsFilterBinding.h.setTag("WEIGHT");
        layoutBasicsFilterBinding.h.a(linkedHashMap, linkedHashMap2);
        FilterCommonScrollSelectorView filterCommonScrollSelectorView2 = layoutBasicsFilterBinding.h;
        Integer num = (Integer) linkedHashMap.get(a2);
        V v = linkedHashMap2.get(b3);
        Intrinsics.a(v);
        filterCommonScrollSelectorView2.a(num, Integer.valueOf(((Number) v).intValue() - 1));
        layoutBasicsFilterBinding.h.setRightText(false);
    }

    private final void l(UserTagAll userTagAll) {
        Context context;
        LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutBasicsFilterBinding.g.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initRelationData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FilterNewFragment.this.g("RELATION_FILTER");
            }
        });
        g();
        String T = BluedPreferences.T();
        Intrinsics.c(T, "getRELATIONCHOICE()");
        this.o = T;
        PhotoGridView photoGridView = layoutBasicsFilterBinding.g.getPhotoGridView();
        final UserTagAdapterNew userTagAdapterNew = new UserTagAdapterNew(context, this.J);
        if (photoGridView != null) {
            photoGridView.setAdapter((ListAdapter) userTagAdapterNew);
        }
        if (photoGridView == null) {
            return;
        }
        photoGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$ouuvxgWl-FkuFU4ZWpDIfN_OWtI
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FilterNewFragment.a(FilterNewFragment.this, userTagAdapterNew, adapterView, view, i, j);
            }
        });
    }

    private final void n() {
        Context context;
        String L;
        String str;
        final LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutBasicsFilterBinding.b.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initHeightData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FragmentFilterNewBinding d;
                FilterScrollView filterScrollView;
                FilterNewFragment.this.f("HEIGHT_FILTER");
                d = FilterNewFragment.this.d();
                if (d == null || (filterScrollView = d.h) == null) {
                    return;
                }
                filterScrollView.setOnTouchView(layoutBasicsFilterBinding.b.getTwoLevelView());
            }
        });
        String[] b2 = FilterNewHelper.f30593a.b(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = b2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                break;
            }
            String str2 = b2[i];
            if (i3 != b2.length - 1) {
                if (FilterNewHelper.f30593a.a(str2)) {
                    linkedHashMap.put(FilterNewHelper.f30593a.b(), Integer.valueOf(i3));
                } else {
                    linkedHashMap.put(Intrinsics.a(str2, (Object) FilterNewHelper.f30593a.d()), Integer.valueOf(i3));
                }
            }
            if (i3 != 0) {
                if (FilterNewHelper.f30593a.a(str2)) {
                    linkedHashMap2.put(FilterNewHelper.f30593a.b(), Integer.valueOf(i3));
                } else {
                    linkedHashMap2.put(Intrinsics.a(str2, (Object) FilterNewHelper.f30593a.d()), Integer.valueOf(i3));
                }
            }
            i++;
            i2 = i3 + 1;
        }
        if (FilterNewHelper.f30593a.a()) {
            L = BluedPreferences.M();
            str = "getHEIGHTCHOICE_IN()";
        } else {
            L = BluedPreferences.L();
            str = "getHEIGHTCHOICE()";
        }
        Intrinsics.c(L, str);
        this.p = L;
        if (TextUtils.isEmpty(L)) {
            layoutBasicsFilterBinding.b.setRightTextColor(Integer.valueOf(BluedSkinUtils.a(context, 2131102254)));
            this.p = Intrinsics.a("1-", (Object) Integer.valueOf(b2.length - 2));
            if (FilterNewHelper.f30593a.a()) {
                BluedPreferences.n(this.p);
            } else {
                BluedPreferences.m(this.p);
            }
        } else {
            layoutBasicsFilterBinding.b.setRightTextColor(Integer.valueOf(context.getResources().getColor(2131101766)));
        }
        List b3 = StringsKt.b((CharSequence) this.p, new String[]{"-"}, false, 0, 6, (Object) null);
        String a2 = a((String) b3.get(0), b2, FilterNewHelper.f30593a.d());
        String b4 = FilterNewHelper.f30593a.a(b2[a((String) b3.get(1), b2.length)]) ? FilterNewHelper.f30593a.b() : Intrinsics.a(b2[a((String) b3.get(1), b2.length)], (Object) FilterNewHelper.f30593a.d());
        layoutBasicsFilterBinding.b.setTag("HEIGHT");
        layoutBasicsFilterBinding.b.a(linkedHashMap, linkedHashMap2);
        FilterCommonScrollSelectorView filterCommonScrollSelectorView = layoutBasicsFilterBinding.b;
        Integer num = (Integer) linkedHashMap.get(a2);
        V v = linkedHashMap2.get(b4);
        Intrinsics.a(v);
        filterCommonScrollSelectorView.a(num, Integer.valueOf(((Number) v).intValue() - 1));
        layoutBasicsFilterBinding.b.setRightText(false);
    }

    private final void p() {
        Context context;
        final LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
        if (layoutBasicsFilterBinding == null || (context = getContext()) == null) {
            return;
        }
        layoutBasicsFilterBinding.f29383a.setOpenTwoLevelListener(new FilterSelectorOpenTwoLevelListener() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$initAgeData$1$1$1
            @Override // com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener
            public void a() {
                FragmentFilterNewBinding d;
                FilterScrollView filterScrollView;
                FilterNewFragment.this.f("AGE_FILTER");
                d = FilterNewFragment.this.d();
                if (d == null || (filterScrollView = d.h) == null) {
                    return;
                }
                filterScrollView.setOnTouchView(layoutBasicsFilterBinding.f29383a.getTwoLevelView());
            }
        });
        String[] a2 = FilterNewHelper.f30593a.a(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = a2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                break;
            }
            String str = a2[i];
            if (i3 != a2.length - 1 && !FilterNewHelper.f30593a.a(str)) {
                linkedHashMap.put(Intrinsics.a(str, (Object) context.getString(R.string.old)), Integer.valueOf(i3));
            }
            if (FilterNewHelper.f30593a.a(str)) {
                linkedHashMap2.put(FilterNewHelper.f30593a.b(), Integer.valueOf(i3));
            } else {
                linkedHashMap2.put(Intrinsics.a(str, (Object) context.getString(R.string.old)), Integer.valueOf(i3));
            }
            i++;
            i2 = i3 + 1;
        }
        String K = BluedPreferences.K();
        Intrinsics.c(K, "getAGECHOICE()");
        this.m = K;
        if (TextUtils.isEmpty(K)) {
            layoutBasicsFilterBinding.f29383a.setRightTextColor(Integer.valueOf(BluedSkinUtils.a(context, 2131102254)));
            String a3 = Intrinsics.a("0-", (Object) Integer.valueOf(FilterNewHelper.f30593a.a(context).length - 2));
            this.m = a3;
            BluedPreferences.l(a3);
        } else {
            layoutBasicsFilterBinding.f29383a.setRightTextColor(Integer.valueOf(context.getResources().getColor(2131101766)));
        }
        List b2 = StringsKt.b((CharSequence) this.m, new String[]{"-"}, false, 0, 6, (Object) null);
        String str2 = (String) b2.get(0);
        String string = context.getString(R.string.old);
        Intrinsics.c(string, "context.getString(R.string.old)");
        String a4 = a(str2, a2, string);
        String b3 = FilterNewHelper.f30593a.a(a2[a((String) b2.get(1), a2.length)]) ? FilterNewHelper.f30593a.b() : Intrinsics.a(a2[a((String) b2.get(1), a2.length)], (Object) context.getString(R.string.old));
        layoutBasicsFilterBinding.f29383a.setTag("AGE");
        layoutBasicsFilterBinding.f29383a.a(linkedHashMap, linkedHashMap2);
        layoutBasicsFilterBinding.f29383a.a((Integer) linkedHashMap.get(a4), (Integer) linkedHashMap2.get(b3));
        layoutBasicsFilterBinding.f29383a.setRightText(false);
    }

    private final void q() {
        if (BluedPreferences.bN()) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(BluedPreferences.T())) {
            i = 1;
        }
        String[] a2 = a();
        int i2 = i;
        if (!TextUtils.isEmpty(a2[1])) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (!TextUtils.isEmpty(a2[2])) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (FilterNewHelper.f30593a.j()) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (FilterNewHelper.f30593a.i()) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (FilterNewHelper.f30593a.h()) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (!TextUtils.isEmpty(b())) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (BluedPreferences.R()) {
            i8 = i7 + 1;
        }
        int i9 = i8;
        if (BluedPreferences.P()) {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (FilterNewHelper.f30593a.f()) {
            i10 = i9 + 1;
        }
        int i11 = i10;
        if (FilterNewHelper.f30593a.g()) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (FilterNewHelper.f30593a.e()) {
            i12 = i11 + 1;
        }
        if (i12 >= 6) {
            BluedPreferences.bM();
            ToastUtils.a(getResources().getString(R.string.filter_condition_more));
        }
    }

    private final void s() {
        String b2 = b();
        Logger.e(Intrinsics.a("rolses==", (Object) b2), new Object[0]);
        BluedPreferences.k(b2);
    }

    public final void a(View view, List<? extends UserTag> list, UserTagAdapterNew adapter, int i, int i2) {
        FilterCommonPhotoGridView filterCommonPhotoGridView;
        FilterCommonPhotoGridView filterCommonPhotoGridView2;
        FilterCommonPhotoGridView filterCommonPhotoGridView3;
        FilterCommonPhotoGridView filterCommonPhotoGridView4;
        FilterCommonPhotoGridView filterCommonPhotoGridView5;
        FilterCommonPhotoGridView filterCommonPhotoGridView6;
        FilterCommonPhotoGridView filterCommonPhotoGridView7;
        FilterCommonPhotoGridView filterCommonPhotoGridView8;
        Intrinsics.e(view, "view");
        Intrinsics.e(list, "list");
        Intrinsics.e(adapter, "adapter");
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (list.get(i).checked == 1) {
            list.get(i).checked = 0;
        } else {
            list.get(i).checked = 1;
        }
        adapter.notifyDataSetChanged();
        String[] a2 = a(true);
        if (a2.length > 2) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(a2[1])) {
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding = this.e;
                    if (layoutBasicsFilterBinding != null && (filterCommonPhotoGridView8 = layoutBasicsFilterBinding.d) != null) {
                        filterCommonPhotoGridView8.setRightText("");
                    }
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding2 = this.e;
                    if (layoutBasicsFilterBinding2 != null && (filterCommonPhotoGridView7 = layoutBasicsFilterBinding2.d) != null) {
                        filterCommonPhotoGridView7.setRightTextColor(context.getResources().getColor(2131102254));
                    }
                } else {
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding3 = this.e;
                    if (layoutBasicsFilterBinding3 != null && (filterCommonPhotoGridView6 = layoutBasicsFilterBinding3.d) != null) {
                        filterCommonPhotoGridView6.setRightText(a2[1]);
                    }
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding4 = this.e;
                    if (layoutBasicsFilterBinding4 != null && (filterCommonPhotoGridView5 = layoutBasicsFilterBinding4.d) != null) {
                        filterCommonPhotoGridView5.setRightTextColor(context.getResources().getColor(2131101766));
                    }
                }
            }
            if (i2 == 2) {
                if (TextUtils.isEmpty(a2[2])) {
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding5 = this.e;
                    if (layoutBasicsFilterBinding5 != null && (filterCommonPhotoGridView4 = layoutBasicsFilterBinding5.f29384c) != null) {
                        filterCommonPhotoGridView4.setRightText("");
                    }
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding6 = this.e;
                    if (layoutBasicsFilterBinding6 != null && (filterCommonPhotoGridView3 = layoutBasicsFilterBinding6.f29384c) != null) {
                        filterCommonPhotoGridView3.setRightTextColor(context.getResources().getColor(2131102254));
                    }
                } else {
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding7 = this.e;
                    if (layoutBasicsFilterBinding7 != null && (filterCommonPhotoGridView2 = layoutBasicsFilterBinding7.f29384c) != null) {
                        filterCommonPhotoGridView2.setRightText(a2[2]);
                    }
                    LayoutBasicsFilterBinding layoutBasicsFilterBinding8 = this.e;
                    if (layoutBasicsFilterBinding8 != null && (filterCommonPhotoGridView = layoutBasicsFilterBinding8.f29384c) != null) {
                        filterCommonPhotoGridView.setRightTextColor(context.getResources().getColor(2131101766));
                    }
                }
            }
        }
        this.k = true;
    }

    public final void a(FilterDialogFragment filterDialogFragment) {
        this.g = filterDialogFragment;
    }

    public final void a(String ids) {
        Intrinsics.e(ids, "ids");
        if (StringUtils.d(ids)) {
            List<UserTag> list = this.D;
            if (list == null) {
                return;
            }
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.D.get(i2).checked = 0;
                i = i2 + 1;
            }
        } else {
            Object[] array = StringsKt.b((CharSequence) ids, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return;
                }
                List<UserTag> list2 = this.D;
                if (list2 != null) {
                    int size2 = list2.size();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= size2) {
                            break;
                        } else if (Intrinsics.a((Object) strArr[i4], (Object) this.D.get(i6).id)) {
                            this.D.get(i6).checked = 1;
                            break;
                        } else {
                            i5 = i6 + 1;
                        }
                    }
                }
                List<UserTag> list3 = this.E;
                if (list3 != null) {
                    int size3 = list3.size();
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= size3) {
                            break;
                        } else if (Intrinsics.a((Object) strArr[i4], (Object) this.E.get(i8).id)) {
                            this.E.get(i8).checked = 1;
                            break;
                        } else {
                            i7 = i8 + 1;
                        }
                    }
                }
                List<UserTag> list4 = this.G;
                if (list4 != null) {
                    int size4 = list4.size();
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 >= size4) {
                            break;
                        } else if (Intrinsics.a((Object) strArr[i4], (Object) this.G.get(i10).id)) {
                            this.G.get(i10).checked = 1;
                            break;
                        } else {
                            i9 = i10 + 1;
                        }
                    }
                }
                List<UserTag> list5 = this.H;
                if (list5 != null) {
                    int size5 = list5.size();
                    int i11 = 0;
                    while (true) {
                        int i12 = i11;
                        if (i12 >= size5) {
                            break;
                        } else if (Intrinsics.a((Object) strArr[i4], (Object) this.H.get(i12).id)) {
                            this.H.get(i12).checked = 1;
                            break;
                        } else {
                            i11 = i12 + 1;
                        }
                    }
                }
                List<UserTag> list6 = this.F;
                if (list6 != null) {
                    int size6 = list6.size();
                    int i13 = 0;
                    while (true) {
                        int i14 = i13;
                        if (i14 >= size6) {
                            break;
                        } else if (Intrinsics.a((Object) strArr[i4], (Object) this.F.get(i14).id)) {
                            this.F.get(i14).checked = 1;
                            Set<String> set = this.K;
                            String str = this.F.get(i14).id;
                            Intrinsics.c(str, "allLookforWantList[j].id");
                            set.add(str);
                            break;
                        } else {
                            i13 = i14 + 1;
                        }
                    }
                }
                i3 = i4 + 1;
            }
        }
    }

    public final String[] a() {
        return a(false);
    }

    public final String[] a(boolean z) {
        List<UserTag> list;
        String[] strArr = {"", "", ""};
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        List<UserTag> list2 = this.D;
        if (list2 != null) {
            int size = list2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                if (this.D.get(i2).checked == 1) {
                    stringBuffer.append(Intrinsics.a(StringUtils.d(stringBuffer.toString()) ? "" : ",", (Object) this.D.get(i2).id));
                }
                i = i2 + 1;
            }
        }
        List<UserTag> list3 = this.E;
        if (list3 != null) {
            int size2 = list3.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                if (this.E.get(i4).checked == 1) {
                    stringBuffer.append(Intrinsics.a(StringUtils.d(stringBuffer.toString()) ? "" : ",", (Object) this.E.get(i4).id));
                    stringBuffer2.append(Intrinsics.a(StringUtils.d(stringBuffer2.toString()) ? "" : ",", (Object) this.E.get(i4).name));
                }
                i3 = i4 + 1;
            }
        }
        List<UserTag> list4 = this.G;
        if (list4 != null) {
            int size3 = list4.size();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size3) {
                    break;
                }
                if (this.G.get(i6).checked == 1) {
                    stringBuffer.append(Intrinsics.a(StringUtils.d(stringBuffer.toString()) ? "" : ",", (Object) this.G.get(i6).id));
                    stringBuffer3.append(Intrinsics.a(StringUtils.d(stringBuffer3.toString()) ? "" : ",", (Object) this.G.get(i6).name));
                }
                i5 = i6 + 1;
            }
        }
        List<UserTag> list5 = this.H;
        if (list5 != null) {
            int size4 = list5.size();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size4) {
                    break;
                }
                if (this.H.get(i8).checked == 1) {
                    stringBuffer.append(Intrinsics.a(StringUtils.d(stringBuffer.toString()) ? "" : ",", (Object) this.H.get(i8).id));
                    stringBuffer3.append(Intrinsics.a(StringUtils.d(stringBuffer3.toString()) ? "" : ",", (Object) this.H.get(i8).name));
                }
                i7 = i8 + 1;
            }
        }
        if (!z && (list = this.F) != null) {
            int size5 = list.size();
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= size5) {
                    break;
                }
                if (this.F.get(i10).checked == 1) {
                    stringBuffer.append(Intrinsics.a(StringUtils.d(stringBuffer.toString()) ? "" : ",", (Object) this.F.get(i10).id));
                    stringBuffer3.append(Intrinsics.a(StringUtils.d(stringBuffer3.toString()) ? "" : ",", (Object) this.F.get(i10).name));
                }
                i9 = i10 + 1;
            }
        }
        String stringBuffer4 = stringBuffer.toString();
        Intrinsics.c(stringBuffer4, "sbResult.toString()");
        String stringBuffer5 = stringBuffer2.toString();
        Intrinsics.c(stringBuffer5, "sbHeIs.toString()");
        String stringBuffer6 = stringBuffer3.toString();
        Intrinsics.c(stringBuffer6, "sbLookFor.toString()");
        strArr[0] = stringBuffer4;
        strArr[1] = stringBuffer5;
        strArr[2] = stringBuffer6;
        return strArr;
    }

    public final String b() {
        List<UserTag> list = this.I;
        String str = "";
        if (list != null) {
            int i = 0;
            int size = list.size();
            String str2 = "";
            while (true) {
                str = str2;
                if (i >= size) {
                    break;
                }
                String str3 = str;
                if (this.I.get(i).checked == 1) {
                    if (TextUtils.equals(this.I.get(i).id, "0.5")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(StringUtils.d(str) ? "" : ",");
                        sb.append((Object) this.I.get(i).id);
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append(StringUtils.d(sb2) ? "" : ",");
                        sb3.append("0.75");
                        String sb4 = sb3.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(sb4);
                        sb5.append(StringUtils.d(sb4) ? "" : ",");
                        sb5.append("0.25");
                        str3 = sb5.toString();
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str);
                        sb6.append(StringUtils.d(str) ? "" : ",");
                        sb6.append((Object) this.I.get(i).id);
                        str3 = sb6.toString();
                    }
                }
                i++;
                str2 = str3;
            }
        }
        Log.v("drb", Intrinsics.a("result:", (Object) str));
        return str;
    }

    public final void b(String roles) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        String string;
        Intrinsics.e(roles, "roles");
        Context context = getContext();
        UserTag userTag = new UserTag("1", (context == null || (resources = context.getResources()) == null) ? null : resources.getString(2131891552), 0);
        Context context2 = getContext();
        UserTag userTag2 = new UserTag("0.5", (context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getString(2131891551), 0);
        Context context3 = getContext();
        UserTag userTag3 = new UserTag("0", (context3 == null || (resources3 = context3.getResources()) == null) ? null : resources3.getString(2131891550), 0);
        Context context4 = getContext();
        if (context4 == null) {
            string = null;
        } else {
            Resources resources4 = context4.getResources();
            string = resources4 == null ? null : resources4.getString(2131891554);
        }
        UserTag userTag4 = new UserTag("-1", string, 0);
        this.I.add(userTag);
        this.I.add(userTag2);
        this.I.add(userTag3);
        this.I.add(userTag4);
        if (StringUtils.d(roles)) {
            return;
        }
        Object[] array = StringsKt.b((CharSequence) roles, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            int size = this.I.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < size) {
                    UserTag userTag5 = this.I.get(i4);
                    if (StringsKt.a(userTag5.id, str, true)) {
                        userTag5.checked = 1;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public final void c() {
        ImageView imageView;
        FragmentFilterNewBinding d = d();
        if (d == null || (imageView = d.d) == null) {
            return;
        }
        imageView.performClick();
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        BluedStructureExtKt.a(this, FilterAction.GetFilterData.f30674a);
        final FragmentFilterNewBinding d = d();
        if (d == null) {
            return;
        }
        d.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$b4VpCcJNz898ku-PL6SRz5veQlc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterNewFragment.a(FilterNewFragment.this, view);
            }
        });
        View inflate = getLayoutInflater().inflate(R.layout.layout_basics_filter, (ViewGroup) null);
        View inflate2 = getLayoutInflater().inflate(R.layout.layout_vip_filter, (ViewGroup) null);
        this.e = LayoutBasicsFilterBinding.a(inflate);
        this.f = LayoutVipFilterBinding.a(inflate2);
        d.f.removeAllViews();
        if (BluedConfig.a().S() == 1) {
            d.f.addView(inflate);
            d.f.addView(inflate2);
        } else {
            d.f.addView(inflate2);
            d.f.addView(inflate);
        }
        if (BluedPreferences.H()) {
            this.j = true;
            d.g.setImageResource(2131237259);
            d.b.setVisibility(8);
        } else {
            this.j = false;
            d.g.setImageResource(2131237258);
            d.b.setVisibility(0);
        }
        d.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$qE4ZLynEu56dg8RZi5h-_gFb_-A
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = FilterNewFragment.a(view, motionEvent);
                return a2;
            }
        });
        d.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$rX6L1BbLiaJg6DT5tk8wBoJsHEE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterNewFragment.a(FragmentFilterNewBinding.this, this, view);
            }
        });
        String V = BluedPreferences.V();
        Intrinsics.c(V, "getTAGCHOICE()");
        this.t = V;
        d.f28822a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$FilterNewFragment$9UzqVhv8DZt9OfMDk6_f7GhssFU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterNewFragment.b(FilterNewFragment.this, view);
            }
        });
        p();
        n();
        l();
        h();
        i();
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((FilterState) obj).getFilterData();
            }
        }, new Function1<UserTagAll, Unit>() { // from class: com.soft.blued.ui.find.fragment.FilterNewFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(UserTagAll data) {
                Intrinsics.e(data, "data");
                FilterNewFragment.this.a(data);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(UserTagAll userTagAll) {
                a(userTagAll);
                return Unit.f42314a;
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        C();
        return super.onBackPressed();
    }
}
