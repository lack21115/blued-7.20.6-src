package com.blued.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.module.common.base.mvi.EmptyMviViewModel;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.settings.SettingsProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.databinding.FmAdultIdentifyBinding;
import com.blued.login.face.AVConfig;
import com.blued.login.pop.FaceIdentifySucceedPop;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/AdultIdentifyFragment.class */
public final class AdultIdentifyFragment extends MVIBaseFragment<EmptyMviViewModel> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(AdultIdentifyFragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmAdultIdentifyBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f6933c;

    public AdultIdentifyFragment() {
        super(R.layout.fm_adult_identify);
        this.f6933c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<AdultIdentifyFragment, FmAdultIdentifyBinding>() { // from class: com.blued.login.fragment.AdultIdentifyFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/blued/login/fragment/AdultIdentifyFragment;)Lcom/blued/login/databinding/FmAdultIdentifyBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmAdultIdentifyBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<AdultIdentifyFragment, FmAdultIdentifyBinding>() { // from class: com.blued.login.fragment.AdultIdentifyFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/blued/login/fragment/AdultIdentifyFragment;)Lcom/blued/login/databinding/FmAdultIdentifyBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmAdultIdentifyBinding.a(fragment.requireView());
            }
        });
    }

    private final FmAdultIdentifyBinding a() {
        return (FmAdultIdentifyBinding) this.f6933c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdultIdentifyFragment adultIdentifyFragment, View view) {
        Intrinsics.e(adultIdentifyFragment, "this$0");
        UserInfo.getInstance().setAccessToken("");
        FragmentActivity activity = adultIdentifyFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdultIdentifyFragment adultIdentifyFragment, Object obj) {
        Intrinsics.e(adultIdentifyFragment, "this$0");
        adultIdentifyFragment.b();
    }

    private final void b() {
        EventTrackSettings.a(SettingsProtos.Event.UNDER_AGE_AUTH_SUCCESS_SHOW);
        UserInfo.getInstance().getLoginUserInfo().setNeedAdultVerify(0);
        LoginServiceManager.a().c();
        Context context = getContext();
        if (context == null) {
            return;
        }
        new XPopup.Builder(context).c(false).a(false).b(false).a(new FaceIdentifySucceedPop(context, new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$AdultIdentifyFragment$nW1TbCa13zFw5Sjtukcg9KvqSN8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdultIdentifyFragment.c(AdultIdentifyFragment.this, view);
            }
        })).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdultIdentifyFragment adultIdentifyFragment, View view) {
        Intrinsics.e(adultIdentifyFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.UNDER_AGE_AUTH_BTN_CLICK);
        TerminalActivity.d(adultIdentifyFragment.getContext(), IdentifyFaceFragment.class, (Bundle) null);
    }

    private final void c() {
        if (!AVConfig.a().f6930a) {
            Bundle bundle = new Bundle();
            bundle.putString("from_tag_page", "from_tag_login");
            LoginServiceManager.a().a(getActivity(), (Bundle) null, bundle);
        } else if (UserInfo.getInstance().isBindPhone()) {
            FinishProfile1Fragment.f6934a.a(getContext());
        } else {
            LoginServiceManager.a().c(getContext());
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdultIdentifyFragment adultIdentifyFragment, View view) {
        Intrinsics.e(adultIdentifyFragment, "this$0");
        adultIdentifyFragment.c();
    }

    public void m() {
        FmAdultIdentifyBinding a2 = a();
        if (a2 != null) {
            a2.f6903a.setCenterText(getString(R.string.login_adult_title));
            a2.f6903a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$AdultIdentifyFragment$uSLtBMtk2JV9rQG_OxmR9Yv9N5Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdultIdentifyFragment.a(AdultIdentifyFragment.this, view);
                }
            });
            a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$AdultIdentifyFragment$r-GjBquX30df6Z2kGizA9lBjFCA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdultIdentifyFragment.b(AdultIdentifyFragment.this, view);
                }
            });
        }
        EventTrackSettings.a(SettingsProtos.Event.UNDER_AGE_UNABLE_LOGIN_PAGE_SHOW);
    }

    public void o() {
        LiveEventBus.get("LOGIN_ADULT_IDENTIFY_SUCCEED").observe(getViewLifecycleOwner(), new Observer() { // from class: com.blued.login.fragment.-$$Lambda$AdultIdentifyFragment$7RW54Zny5hleeKSiW9nJukVkfSs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdultIdentifyFragment.a(AdultIdentifyFragment.this, obj);
            }
        });
    }
}
