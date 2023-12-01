package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVipLevelPrivilegeBinding;
import com.soft.blued.ui.user.adapter.NoVIPPrivilegeAdapter;
import com.soft.blued.ui.user.model.VIPCenterNewModel;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.state.VIPCenterAction;
import com.soft.blued.ui.user.state.VIPCenterState;
import com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel;
import com.soft.blued.ui.user.views.VipGradeProgress;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPLvlPrivilegeFragment.class */
public final class VIPLvlPrivilegeFragment extends MVIBaseFragment<VIPCenterTabPageViewModel> {
    private final ViewBindingProperty d;
    private final int e;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f34149c = {Reflection.a(new PropertyReference1Impl(VIPLvlPrivilegeFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentVipLevelPrivilegeBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPLvlPrivilegeFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, VIPLvlPrivilegeFragment.class, bundle);
        }
    }

    public VIPLvlPrivilegeFragment() {
        super(R.layout.fragment_vip_level_privilege);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<VIPLvlPrivilegeFragment, FragmentVipLevelPrivilegeBinding>() { // from class: com.soft.blued.ui.user.fragment.VIPLvlPrivilegeFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVipLevelPrivilegeBinding invoke(VIPLvlPrivilegeFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipLevelPrivilegeBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VIPLvlPrivilegeFragment, FragmentVipLevelPrivilegeBinding>() { // from class: com.soft.blued.ui.user.fragment.VIPLvlPrivilegeFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVipLevelPrivilegeBinding invoke(VIPLvlPrivilegeFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipLevelPrivilegeBinding.a(fragment.requireView());
            }
        });
        this.e = 9;
    }

    private final FragmentVipLevelPrivilegeBinding a() {
        return (FragmentVipLevelPrivilegeBinding) this.d.b(this, f34149c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2, int i3, TextView textView) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (i2 == 1) {
            textView.setText("VIP" + i + context.getString(R.string.vip_grade_page_privilege_title));
        } else if (i2 == 2) {
            textView.setText("Blued X" + i + context.getString(R.string.vip_grade_page_privilege_title));
        } else if (i3 == 1) {
            textView.setText("VIP" + i + context.getString(R.string.vip_grade_page_privilege_title));
        } else if (i3 != 2) {
        } else {
            textView.setText("Blued X" + i + context.getString(R.string.vip_grade_page_privilege_title));
        }
    }

    private final void a(ImageView imageView, int i, int i2, int i3) {
        if (imageView == null || i <= 0) {
            return;
        }
        String a2 = i2 > 0 ? Intrinsics.a("_center_", (Object) "expire_") : "_center_";
        if (i3 == 1) {
            imageView.setVisibility(0);
            a2 = "vip" + a2 + i;
        } else if (i3 == 2) {
            imageView.setVisibility(0);
            a2 = "bluedx" + a2 + i;
        } else if (i2 == 1) {
            imageView.setVisibility(0);
            a2 = "vip" + a2 + i;
        } else if (i2 == 2) {
            imageView.setVisibility(0);
            a2 = "bluedx" + a2 + i;
        }
        imageView.setImageResource(AppInfo.d().getResources().getIdentifier(a2, i.f7952c, AppInfo.d().getPackageName()));
        imageView.setAdjustViewBounds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPLvlPrivilegeFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final VIPCenterNewModel vIPCenterNewModel) {
        if (vIPCenterNewModel == null) {
            return;
        }
        final FragmentVipLevelPrivilegeBinding a2 = a();
        if (a2 != null) {
            Context context = getContext();
            if (context != null) {
                a2.n.setCenterTextColor(2131102203);
                a2.n.setBackgroundColor(context.getResources().getColor(2131102170));
                StatusBarHelper.a((Activity) getActivity(), true);
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.f42543a = 2;
                if (vIPCenterNewModel.user_info.grade == 1) {
                    ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_vip_center_bg")).a(a2.f29026c);
                    a2.f.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_center_header_bg));
                    a2.j.a();
                    a2.g.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_center_question));
                    a2.p.setTextColor(context.getResources().getColor(R.color.syc_A3623C));
                    a2.s.setTextColor(context.getResources().getColor(R.color.syc_A3623C));
                    a2.r.setTextColor(context.getResources().getColor(R.color.syc_A3623C));
                    a2.o.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
                    intRef.f42543a = 1;
                } else {
                    ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_bg")).a(a2.f29026c);
                    ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_header_bg")).a(a2.f);
                    a2.j.b();
                    a2.g.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_svip_center_question));
                    a2.p.setTextColor(context.getResources().getColor(R.color.syc_2A7BDF));
                    a2.s.setTextColor(context.getResources().getColor(R.color.syc_2A7BDF));
                    a2.r.setTextColor(context.getResources().getColor(R.color.syc_2A7BDF));
                    a2.o.setTextColor(context.getResources().getColor(2131102170));
                    intRef.f42543a = 2;
                }
                if (vIPCenterNewModel.user_info.expire_type > 0) {
                    a2.f29025a.setVisibility(0);
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.f42545a = "expire_svip";
                    if (vIPCenterNewModel.user_info.expire_type == 2) {
                        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_bg")).a(a2.f29026c);
                        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_header_out_time_bg")).a(a2.f);
                        a2.j.d();
                        a2.g.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_svip_center_question));
                        a2.p.setTextColor(context.getResources().getColor(R.color.syc_445771));
                        a2.s.setTextColor(context.getResources().getColor(R.color.syc_445771));
                        a2.r.setTextColor(context.getResources().getColor(R.color.syc_445771));
                        a2.d.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_svip_new_page_buy_btn_bg));
                        a2.o.setTextColor(context.getResources().getColor(2131102170));
                        intRef.f42543a = 2;
                        objectRef.f42545a = "expire_svip";
                    } else {
                        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_vip_center_bg")).a(a2.f29026c);
                        a2.f.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_center_header_out_time_bg));
                        a2.j.c();
                        a2.g.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_center_question));
                        a2.p.setTextColor(context.getResources().getColor(R.color.syc_7D7D7D));
                        a2.s.setTextColor(context.getResources().getColor(R.color.syc_7D7D7D));
                        a2.r.setTextColor(context.getResources().getColor(R.color.syc_7D7D7D));
                        a2.d.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_new_page_buy_btn_bg));
                        a2.o.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
                        intRef.f42543a = 1;
                        objectRef.f42545a = "expire_vip";
                    }
                    a2.f29025a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPLvlPrivilegeFragment$MhyvPInslGiPO0JShl0C7e9Vw4k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            VIPLvlPrivilegeFragment.a(Ref.IntRef.this, objectRef, view);
                        }
                    });
                } else {
                    a2.f29025a.setVisibility(8);
                }
                ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).c().a(2.0f, context.getResources().getColor(2131102170)).b(2131237310).d(2131237310).a(a2.h);
                a2.t.setText(UserInfo.getInstance().getLoginUserInfo().name);
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.vip_grade = vIPCenterNewModel.user_info.grade;
                userBasicModel.is_vip_annual = vIPCenterNewModel.user_info.is_vip_annual;
                userBasicModel.vip_exp_lvl = vIPCenterNewModel.user_info.vip_exp_lvl;
                userBasicModel.expire_type = vIPCenterNewModel.user_info.expire_type;
                UserInfoHelper.a(a2.e, userBasicModel, getFragmentActive());
                ImageView ivVipGradle = a2.i;
                Intrinsics.c(ivVipGradle, "ivVipGradle");
                a(ivVipGradle, vIPCenterNewModel.user_info.vip_exp_lvl, vIPCenterNewModel.user_info.expire_type, vIPCenterNewModel.user_info.grade);
                a2.p.setText(context.getString(R.string.vip_grade_current_exp) + ' ' + (vIPCenterNewModel.user_info.vip_exp > 0 ? String.valueOf(vIPCenterNewModel.user_info.vip_exp) : "0"));
                ArrayList arrayList = new ArrayList();
                if (vIPCenterNewModel.user_info.expire_type <= 0) {
                    TextView textView = a2.s;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string = context.getString(R.string.vip_grade_page_next_level_exp);
                    Intrinsics.c(string, "context.getString(R.stri…rade_page_next_level_exp)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(vIPCenterNewModel.user_info.exp_lvl_next)}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    textView.setText(format);
                    int[] iArr = vIPCenterNewModel.grade_list;
                    Intrinsics.c(iArr, "model.grade_list");
                    int length = iArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        int i4 = iArr[i3];
                        i++;
                        if (vIPCenterNewModel.user_info.vip_exp_lvl == i) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Lv.");
                            sb.append(vIPCenterNewModel.user_info.vip_exp_lvl);
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                            String string2 = context.getString(R.string.vip_new_grade_current_num);
                            Intrinsics.c(string2, "context.getString(R.stri…ip_new_grade_current_num)");
                            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Long.valueOf(vIPCenterNewModel.user_info.vip_exp))}, 1));
                            Intrinsics.c(format2, "format(format, *args)");
                            sb.append(format2);
                            arrayList.add(sb.toString());
                        } else if (vIPCenterNewModel.user_info.vip_exp_lvl < i) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Lv.");
                            sb2.append(i);
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
                            String string3 = context.getString(R.string.vip_new_grade_lack_num);
                            Intrinsics.c(string3, "context.getString(\n     …                        )");
                            String format3 = String.format(string3, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Long.valueOf(i4 - vIPCenterNewModel.user_info.vip_exp))}, 1));
                            Intrinsics.c(format3, "format(format, *args)");
                            sb2.append(format3);
                            arrayList.add(sb2.toString());
                        } else {
                            arrayList.add("Lv." + i + context.getString(R.string.vip_new_grade_complete));
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    if (vIPCenterNewModel.user_info.expire_type == 1 || vIPCenterNewModel.user_info.grade == 1) {
                        TextView textView2 = a2.s;
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.f42549a;
                        String string4 = context.getString(R.string.vip_grade_page_out_date);
                        Intrinsics.c(string4, "context.getString(R.stri….vip_grade_page_out_date)");
                        String format4 = String.format(string4, Arrays.copyOf(new Object[]{context.getString(R.string.vip), String.valueOf(vIPCenterNewModel.user_info.vip_exp_lvl)}, 2));
                        Intrinsics.c(format4, "format(format, *args)");
                        textView2.setText(format4);
                    } else {
                        TextView textView3 = a2.s;
                        StringCompanionObject stringCompanionObject5 = StringCompanionObject.f42549a;
                        String string5 = context.getString(R.string.vip_grade_page_out_date);
                        Intrinsics.c(string5, "context.getString(R.stri….vip_grade_page_out_date)");
                        String format5 = String.format(string5, Arrays.copyOf(new Object[]{context.getString(R.string.svip), String.valueOf(vIPCenterNewModel.user_info.vip_exp_lvl)}, 2));
                        Intrinsics.c(format5, "format(format, *args)");
                        textView3.setText(format5);
                    }
                    int[] iArr2 = vIPCenterNewModel.grade_list;
                    Intrinsics.c(iArr2, "model.grade_list");
                    int i5 = 0;
                    for (int i6 : iArr2) {
                        i5++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Lv.");
                        sb3.append(i5);
                        sb3.append((char) 65288);
                        StringCompanionObject stringCompanionObject6 = StringCompanionObject.f42549a;
                        String string6 = context.getString(R.string.vip_new_grade_reduce_num);
                        Intrinsics.c(string6, "context.getString(R.stri…vip_new_grade_reduce_num)");
                        String format6 = String.format(string6, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Integer.valueOf(Math.abs(vIPCenterNewModel.user_info.day_growth_value)))}, 1));
                        Intrinsics.c(format6, "format(format, *args)");
                        sb3.append(format6);
                        sb3.append((char) 65289);
                        arrayList.add(sb3.toString());
                    }
                }
                a2.j.setData(arrayList);
                a2.j.setSelectIndex(vIPCenterNewModel.user_info.vip_exp_lvl - 1);
                ActivityFragmentActive fragmentActive = getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                final NoVIPPrivilegeAdapter noVIPPrivilegeAdapter = new NoVIPPrivilegeAdapter(fragmentActive, intRef.f42543a, a2.l.getWidth(), 2);
                noVIPPrivilegeAdapter.a(vIPCenterNewModel.user_info.vip_exp_lvl);
                if (vIPCenterNewModel.user_info.expire_type > 0) {
                    noVIPPrivilegeAdapter.a(-1);
                }
                noVIPPrivilegeAdapter.b(noVIPPrivilegeAdapter.a());
                a2.l.setLayoutManager(new GridLayoutManager(context, 4));
                a2.l.setAdapter(noVIPPrivilegeAdapter);
                if (vIPCenterNewModel.user_info.vip_exp_lvl - 1 < vIPCenterNewModel.level_privilege.size()) {
                    noVIPPrivilegeAdapter.setNewData(vIPCenterNewModel.level_privilege.get(vIPCenterNewModel.user_info.vip_exp_lvl - 1));
                }
                int i7 = vIPCenterNewModel.user_info.vip_exp_lvl;
                int i8 = vIPCenterNewModel.user_info.grade;
                int i9 = vIPCenterNewModel.user_info.expire_type;
                TextView tvPrivilegeTitle = a2.q;
                Intrinsics.c(tvPrivilegeTitle, "tvPrivilegeTitle");
                a(i7, i8, i9, tvPrivilegeTitle);
                noVIPPrivilegeAdapter.notifyDataSetChanged();
                a2.j.setOnDropLickListener(new VipGradeProgress.OnDropLickListener() { // from class: com.soft.blued.ui.user.fragment.VIPLvlPrivilegeFragment$setData$1$1$1$4
                    @Override // com.soft.blued.ui.user.views.VipGradeProgress.OnDropLickListener
                    public void a(int i10, float f) {
                        int width = (int) (f - (FragmentVipLevelPrivilegeBinding.this.b.getWidth() / 2));
                        int i11 = width;
                        if (width < 0) {
                            i11 = 0;
                        }
                        FragmentVipLevelPrivilegeBinding.this.m.smoothScrollTo(i11, 0);
                        if (i10 < vIPCenterNewModel.level_privilege.size()) {
                            noVIPPrivilegeAdapter.setNewData(vIPCenterNewModel.level_privilege.get(i10));
                            int i12 = i10 + 1;
                            noVIPPrivilegeAdapter.b(i12);
                            VIPLvlPrivilegeFragment vIPLvlPrivilegeFragment = this;
                            int i13 = vIPCenterNewModel.user_info.grade;
                            int i14 = vIPCenterNewModel.user_info.expire_type;
                            TextView tvPrivilegeTitle2 = FragmentVipLevelPrivilegeBinding.this.q;
                            Intrinsics.c(tvPrivilegeTitle2, "tvPrivilegeTitle");
                            vIPLvlPrivilegeFragment.a(i12, i13, i14, tvPrivilegeTitle2);
                            noVIPPrivilegeAdapter.notifyDataSetChanged();
                        }
                    }
                });
                String a3 = vIPCenterNewModel.user_info.day_growth_value > 0 ? Intrinsics.a("+", (Object) Integer.valueOf(vIPCenterNewModel.user_info.day_growth_value)) : String.valueOf(vIPCenterNewModel.user_info.day_growth_value);
                TextView textView4 = a2.r;
                StringCompanionObject stringCompanionObject7 = StringCompanionObject.f42549a;
                String string7 = context.getResources().getString(R.string.vip_grade_page_today_exp);
                Intrinsics.c(string7, "context.resources.getStr…vip_grade_page_today_exp)");
                String format7 = String.format(string7, Arrays.copyOf(new Object[]{a3}, 1));
                Intrinsics.c(format7, "format(format, *args)");
                textView4.setText(format7);
                a2.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPLvlPrivilegeFragment$St_fxQpATeVZD-bwvsGh8e-FC9U
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VIPLvlPrivilegeFragment.b(VIPLvlPrivilegeFragment.this, view);
                    }
                });
                Unit unit = Unit.f42314a;
                Unit unit2 = Unit.f42314a;
            }
            Unit unit3 = Unit.f42314a;
        }
        Unit unit4 = Unit.f42314a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.IntRef pageGrade, Ref.ObjectRef vipDetail, View view) {
        Tracker.onClick(view);
        Intrinsics.e(pageGrade, "$pageGrade");
        Intrinsics.e(vipDetail, "$vipDetail");
        PayUtils.a(AppInfo.d(), pageGrade.f42543a, (String) vipDetail.f42545a, -1, VipProtos.FromType.UNKNOWN_FROM);
    }

    private final void b() {
        WebViewShowInfoFragment.show(AppInfo.d(), Intrinsics.a(HostConfig.a("H5"), (Object) "/home/vip/level"), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VIPLvlPrivilegeFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        y().a(1);
        BluedStructureExtKt.a(this, VIPCenterAction.GetVIPData.f34310a);
        FragmentVipLevelPrivilegeBinding a2 = a();
        if (a2 != null && (commonTopTitleNoTrans2 = a2.n) != null) {
            commonTopTitleNoTrans2.setCenterText(R.string.vip_exp_lvl);
        }
        FragmentVipLevelPrivilegeBinding a3 = a();
        if (a3 == null || (commonTopTitleNoTrans = a3.n) == null) {
            return;
        }
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPLvlPrivilegeFragment$SjzlBqznJ-LeYMy9bHwMHuTcFCY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPLvlPrivilegeFragment.a(VIPLvlPrivilegeFragment.this, view);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VIPLvlPrivilegeFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((VIPCenterState) obj).a();
            }
        }, new Function1<VIPCenterNewModel, Unit>() { // from class: com.soft.blued.ui.user.fragment.VIPLvlPrivilegeFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(VIPCenterNewModel it) {
                Dialog t;
                Intrinsics.e(it, "it");
                t = VIPLvlPrivilegeFragment.this.t();
                DialogUtils.b(t);
                VIPLvlPrivilegeFragment.this.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(VIPCenterNewModel vIPCenterNewModel) {
                a(vIPCenterNewModel);
                return Unit.f42314a;
            }
        });
    }
}
