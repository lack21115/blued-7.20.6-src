package com.blued.login.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.ILoginService;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.constant.LoginConstants;
import com.blued.login.databinding.FmFinishProfile3Binding;
import com.blued.login.log.EventTrackLogin;
import com.blued.login.model.ProfileInfoModel;
import com.blued.login.utils.LoginHelper;
import com.blued.login.vm.FinishProfileVM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/FinishProfile3Fragment.class */
public final class FinishProfile3Fragment extends MVVMBaseFragment<FinishProfileVM> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f20546a = {Reflection.a(new PropertyReference1Impl(FinishProfile3Fragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmFinishProfile3Binding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private ProfileInfoModel f20547c;

    public FinishProfile3Fragment() {
        super(R.layout.fm_finish_profile_3);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<FinishProfile3Fragment, FmFinishProfile3Binding>() { // from class: com.blued.login.fragment.FinishProfile3Fragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmFinishProfile3Binding invoke(FinishProfile3Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmFinishProfile3Binding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<FinishProfile3Fragment, FmFinishProfile3Binding>() { // from class: com.blued.login.fragment.FinishProfile3Fragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmFinishProfile3Binding invoke(FinishProfile3Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmFinishProfile3Binding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FinishProfile3Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void a(final List<? extends UserTag> list) {
        FlowLayout flowLayout;
        FlowLayout flowLayout2;
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        FmFinishProfile3Binding p = p();
        if (p != null && (flowLayout2 = p.d) != null) {
            flowLayout2.removeAllViews();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.login_role_text_view, (ViewGroup) null);
            Intrinsics.c(inflate, "from(context).inflate(R.…gin_role_text_view, null)");
            TextView textView = (TextView) inflate.findViewById(R.id.tv_tag_text);
            textView.setText(list.get(i).name);
            if (list.get(i).checked == 0) {
                textView.setBackground(BluedSkinUtils.b(getContext(), R.drawable.login_user_job_text_bg));
                textView.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            } else {
                textView.setBackground(BluedSkinUtils.b(getContext(), R.drawable.login_user_job_text_select_bg));
                textView.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_b));
            }
            FmFinishProfile3Binding p2 = p();
            if (p2 != null && (flowLayout = p2.d) != null) {
                flowLayout.addView(inflate);
            }
        }
        final FmFinishProfile3Binding p3 = p();
        if (p3 == null) {
            return;
        }
        p3.d.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile3Fragment$P6nDDT45Lbyl8HCHjAyxpjPpa8I
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                FinishProfile3Fragment.a(List.this, p3, this, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List list, FmFinishProfile3Binding it, FinishProfile3Fragment this$0, View view, int i) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        UserTag userTag = (UserTag) list.get(i);
        TextView textView = (TextView) view.findViewById(R.id.tv_tag_text);
        if (userTag.checked != 0) {
            userTag.checked = 0;
            textView.setBackgroundResource(R.drawable.login_user_job_text_bg);
            textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_h));
            ProfileInfoModel profileInfoModel = this$0.f20547c;
            ProfileInfoModel profileInfoModel2 = profileInfoModel;
            if (profileInfoModel == null) {
                Intrinsics.c("model");
                profileInfoModel2 = null;
            }
            profileInfoModel2.f("");
            it.h.setText("");
            FmFinishProfile3Binding p = this$0.p();
            ShapeTextView shapeTextView = p == null ? null : p.g;
            if (shapeTextView == null) {
                return;
            }
            shapeTextView.setEnabled(false);
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            ((UserTag) list.get(i3)).checked = 0;
            View childAt = it.d.getChildAt(i3);
            Intrinsics.c(childAt, "it.roleFlowLayout.getChildAt(i)");
            TextView textView2 = (TextView) childAt.findViewById(R.id.tv_tag_text);
            textView2.setBackgroundResource(R.drawable.login_user_job_text_bg);
            textView2.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_h));
            i2 = i3 + 1;
        }
        userTag.checked = 1;
        textView.setBackground(BluedSkinUtils.b(this$0.getContext(), R.drawable.login_user_job_text_select_bg));
        textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), R.color.syc_b));
        ProfileInfoModel profileInfoModel3 = this$0.f20547c;
        ProfileInfoModel profileInfoModel4 = profileInfoModel3;
        if (profileInfoModel3 == null) {
            Intrinsics.c("model");
            profileInfoModel4 = null;
        }
        String str = userTag.id;
        Intrinsics.c(str, "userTag.id");
        profileInfoModel4.f(str);
        it.h.setText(userTag.name);
        FmFinishProfile3Binding p2 = this$0.p();
        ShapeTextView shapeTextView2 = p2 == null ? null : p2.g;
        if (shapeTextView2 == null) {
            return;
        }
        shapeTextView2.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FinishProfile3Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK;
        LoginHelper loginHelper = LoginHelper.f20590a;
        ProfileInfoModel profileInfoModel = this$0.f20547c;
        ProfileInfoModel profileInfoModel2 = profileInfoModel;
        if (profileInfoModel == null) {
            Intrinsics.c("model");
            profileInfoModel2 = null;
        }
        EventTrackLogin.a(event, loginHelper.a(profileInfoModel2));
        FinishProfileVM a2 = this$0.a();
        ProfileInfoModel profileInfoModel3 = this$0.f20547c;
        if (profileInfoModel3 == null) {
            Intrinsics.c("model");
            profileInfoModel3 = null;
        }
        a2.b(profileInfoModel3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FinishProfile3Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ILoginService a2 = LoginServiceManager.a();
        FinishProfile3Fragment finishProfile3Fragment = this$0;
        ProfileInfoModel profileInfoModel = this$0.f20547c;
        ProfileInfoModel profileInfoModel2 = profileInfoModel;
        if (profileInfoModel == null) {
            Intrinsics.c("model");
            profileInfoModel2 = null;
        }
        String h = profileInfoModel2.h();
        ProfileInfoModel profileInfoModel3 = this$0.f20547c;
        ProfileInfoModel profileInfoModel4 = profileInfoModel3;
        if (profileInfoModel3 == null) {
            Intrinsics.c("model");
            profileInfoModel4 = null;
        }
        String i = profileInfoModel4.i();
        ProfileInfoModel profileInfoModel5 = this$0.f20547c;
        if (profileInfoModel5 == null) {
            Intrinsics.c("model");
            profileInfoModel5 = null;
        }
        a2.a(finishProfile3Fragment, h, i, profileInfoModel5.j(), LoginConstants.b);
    }

    private final FmFinishProfile3Binding p() {
        return (FmFinishProfile3Binding) this.b.b(this, f20546a[0]);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        RelativeLayout relativeLayout;
        ShapeTextView shapeTextView;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        ImageView leftImg;
        Context context = getContext();
        if (context != null) {
            a().a(context);
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("profile_model")) {
            Serializable serializable = arguments.getSerializable("profile_model");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.login.model.ProfileInfoModel");
            }
            this.f20547c = (ProfileInfoModel) serializable;
            FinishProfileVM a2 = a();
            ProfileInfoModel profileInfoModel = this.f20547c;
            ProfileInfoModel profileInfoModel2 = profileInfoModel;
            if (profileInfoModel == null) {
                Intrinsics.c("model");
                profileInfoModel2 = null;
            }
            a2.a(profileInfoModel2);
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.REGISTER_PROFILE_ROLE_SHOW;
            LoginHelper loginHelper = LoginHelper.f20590a;
            ProfileInfoModel profileInfoModel3 = this.f20547c;
            ProfileInfoModel profileInfoModel4 = profileInfoModel3;
            if (profileInfoModel3 == null) {
                Intrinsics.c("model");
                profileInfoModel4 = null;
            }
            EventTrackLogin.a(event, loginHelper.a(profileInfoModel4));
        }
        ArrayList arrayList = new ArrayList();
        Context context2 = getContext();
        arrayList.add(new UserTag("1", context2 == null ? null : context2.getString(R.string.role_1)));
        Context context3 = getContext();
        arrayList.add(new UserTag("0.5", context3 == null ? null : context3.getString(R.string.role_05)));
        Context context4 = getContext();
        arrayList.add(new UserTag("0", context4 == null ? null : context4.getString(R.string.role_0)));
        Context context5 = getContext();
        arrayList.add(new UserTag("-1", context5 == null ? null : context5.getString(R.string.register_info_role_other)));
        FmFinishProfile3Binding p = p();
        if (p != null && (commonTopTitleNoTrans = p.e) != null && (leftImg = commonTopTitleNoTrans.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile3Fragment$_GUH7jzdIKrl7Zj402nUMxDLgY8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FinishProfile3Fragment.a(FinishProfile3Fragment.this, view);
                }
            });
        }
        FmFinishProfile3Binding p2 = p();
        if (p2 != null && (shapeTextView = p2.g) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile3Fragment$QUtaew0MCImJ4sH6EQj1KhXGvr4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FinishProfile3Fragment.b(FinishProfile3Fragment.this, view);
                }
            });
        }
        FmFinishProfile3Binding p3 = p();
        if (p3 != null && (relativeLayout = p3.b) != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile3Fragment$MBeuAN2DG5OK4AhHwxI2G6ULb18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FinishProfile3Fragment.c(FinishProfile3Fragment.this, view);
                }
            });
        }
        a(arrayList);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        TextView textView;
        super.onActivityResult(i, i2, intent);
        if (i == LoginConstants.b) {
            ProfileInfoModel profileInfoModel = this.f20547c;
            ProfileInfoModel profileInfoModel2 = profileInfoModel;
            if (profileInfoModel == null) {
                Intrinsics.c("model");
                profileInfoModel2 = null;
            }
            profileInfoModel2.h(intent == null ? null : intent.getStringExtra("health_result"));
            ProfileInfoModel profileInfoModel3 = this.f20547c;
            ProfileInfoModel profileInfoModel4 = profileInfoModel3;
            if (profileInfoModel3 == null) {
                Intrinsics.c("model");
                profileInfoModel4 = null;
            }
            profileInfoModel4.i(intent == null ? null : intent.getStringExtra("health_time"));
            ProfileInfoModel profileInfoModel5 = this.f20547c;
            ProfileInfoModel profileInfoModel6 = profileInfoModel5;
            if (profileInfoModel5 == null) {
                Intrinsics.c("model");
                profileInfoModel6 = null;
            }
            profileInfoModel6.j(intent == null ? null : intent.getStringExtra("health_prep"));
            ProfileInfoModel profileInfoModel7 = this.f20547c;
            ProfileInfoModel profileInfoModel8 = profileInfoModel7;
            if (profileInfoModel7 == null) {
                Intrinsics.c("model");
                profileInfoModel8 = null;
            }
            if (TextUtils.equals(profileInfoModel8.h(), "-1")) {
                ProfileInfoModel profileInfoModel9 = this.f20547c;
                ProfileInfoModel profileInfoModel10 = profileInfoModel9;
                if (profileInfoModel9 == null) {
                    Intrinsics.c("model");
                    profileInfoModel10 = null;
                }
                if (TextUtils.equals(profileInfoModel10.i(), "-1")) {
                    ProfileInfoModel profileInfoModel11 = this.f20547c;
                    ProfileInfoModel profileInfoModel12 = profileInfoModel11;
                    if (profileInfoModel11 == null) {
                        Intrinsics.c("model");
                        profileInfoModel12 = null;
                    }
                    if (TextUtils.equals(profileInfoModel12.j(), "-1")) {
                        FmFinishProfile3Binding p = p();
                        TextView textView2 = p == null ? null : p.f;
                        if (textView2 == null) {
                            return;
                        }
                        textView2.setText("");
                        return;
                    }
                }
            }
            FmFinishProfile3Binding p2 = p();
            if (p2 == null || (textView = p2.f) == null) {
                return;
            }
            textView.setText(R.string.login_health_information_completed);
        }
    }
}
