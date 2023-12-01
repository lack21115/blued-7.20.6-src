package com.soft.blued.ui.user.fragment;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.EmptyMviViewModel;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.click.SingleClickProxy;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVirtualImageSettingBinding;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.user.fragment.VirtualImageSettingFragment;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageSettingFragment.class */
public final class VirtualImageSettingFragment extends MVIBaseFragment<EmptyMviViewModel> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(VirtualImageSettingFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FragmentVirtualImageSettingBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20526c;
    private final long d;
    private int e;
    private boolean f;
    private Dialog g;
    private OnBackPressedListener h;
    private OnVirtualImageDeletedListener i;
    private VirtualImageUtils j;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageSettingFragment$OnBackPressedListener.class */
    public interface OnBackPressedListener {
        void a();
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageSettingFragment$OnVirtualImageDeletedListener.class */
    public interface OnVirtualImageDeletedListener {
        void a();
    }

    public VirtualImageSettingFragment() {
        super((int) R.layout.fragment_virtual_image_setting);
        this.f20526c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<VirtualImageSettingFragment, FragmentVirtualImageSettingBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageSettingFragment;)Lcom/soft/blued/databinding/FragmentVirtualImageSettingBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImageSettingBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImageSettingFragment, FragmentVirtualImageSettingBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageSettingFragment;)Lcom/soft/blued/databinding/FragmentVirtualImageSettingBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImageSettingBinding.a(fragment.requireView());
            }
        });
        this.d = 200L;
        this.e = 1;
    }

    private final void a(final int i) {
        this.f = true;
        UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$setUserDisplay$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                VirtualImageSettingFragment.this.f = false;
                ToastUtils.a((int) R.string.user_virtual_image_switch_toast, 0);
            }

            public boolean onUIFailure(int i2, String str, String str2) {
                VirtualImageSettingFragment.this.f = false;
                ToastUtils.a(2131887272, 0);
                if (i == 1) {
                    VirtualImageSettingFragment.a(VirtualImageSettingFragment.this, false, 1, null);
                    return true;
                }
                VirtualImageSettingFragment.b(VirtualImageSettingFragment.this, false, 1, null);
                return true;
            }
        }, getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getUid(), i);
    }

    private final void a(PersonalProfileProtos.Event event) {
        VirtualImageUtils virtualImageUtils = this.j;
        if (virtualImageUtils == null) {
            return;
        }
        EventTrackPersonalProfile.a(event, virtualImageUtils.getAllGoodIdsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final VirtualImageSettingFragment virtualImageSettingFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(virtualImageSettingFragment, "this$0");
        virtualImageSettingFragment.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_DELETE_YES_CLICK);
        UserHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$showDeleteConfirmDialog$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                VirtualImageSettingFragment.OnVirtualImageDeletedListener a2 = VirtualImageSettingFragment.this.a();
                if (a2 == null) {
                    return;
                }
                a2.a();
            }

            public boolean onUIFailure(int i2, String str, String str2) {
                ToastUtils.a(2131887272, 0);
                return true;
            }
        }, virtualImageSettingFragment.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSettingFragment virtualImageSettingFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSettingFragment, "this$0");
        if (virtualImageSettingFragment.f || virtualImageSettingFragment.e != 2) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_FIRST_VIRTUAL_CLICK);
        b(virtualImageSettingFragment, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(VirtualImageSettingFragment virtualImageSettingFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        virtualImageSettingFragment.a(z);
    }

    private final void a(boolean z) {
        FragmentVirtualImageSettingBinding b2 = b();
        if (b2 == null) {
            return;
        }
        this.e = 2;
        b2.f15342c.setTextColor(getResources().getColor(R.color.color_BBBBBB));
        b2.d.setTextColor(getResources().getColor(2131102478));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.f15341a, "translationX", 0.0f, BluedViewExtKt.a(88.0f));
        ofFloat.setDuration(this.d);
        ofFloat.start();
        if (z) {
            a(2);
        }
    }

    private final FragmentVirtualImageSettingBinding b() {
        return (FragmentVirtualImageSettingBinding) this.f20526c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSettingFragment virtualImageSettingFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(virtualImageSettingFragment, "this$0");
        virtualImageSettingFragment.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_DELETE_NO_CLICK);
        Dialog dialog = virtualImageSettingFragment.g;
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSettingFragment virtualImageSettingFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSettingFragment, "this$0");
        if (virtualImageSettingFragment.f || virtualImageSettingFragment.e != 1) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_FIRST_BG_CLICK);
        a(virtualImageSettingFragment, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(VirtualImageSettingFragment virtualImageSettingFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        virtualImageSettingFragment.b(z);
    }

    private final void b(boolean z) {
        FragmentVirtualImageSettingBinding b2 = b();
        if (b2 == null) {
            return;
        }
        this.e = 1;
        b2.d.setTextColor(getResources().getColor(R.color.color_BBBBBB));
        b2.f15342c.setTextColor(getResources().getColor(2131102478));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.f15341a, "translationX", BluedViewExtKt.a(88.0f), 0.0f);
        ofFloat.setDuration(this.d);
        ofFloat.start();
        if (z) {
            a(1);
        }
    }

    private final void c() {
        Dialog dialog = this.g;
        boolean z = false;
        if (dialog != null && dialog.isShowing()) {
            z = true;
        }
        if (z) {
            return;
        }
        Dialog a2 = new BluedAlertDialog.Builder(getContext()).d((int) R.string.user_virtual_image_alert).e((int) R.string.user_virtual_image_alert_message).a((int) R.string.user_virtual_image_alert_delete, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$XQYBgCW4chp8OQFLPibI0HvcEtY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VirtualImageSettingFragment.a(VirtualImageSettingFragment.this, dialogInterface, i);
            }
        }).f(2131101730).b((int) R.string.user_virtual_image_alert_cancel, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$sX47xNKPTaj48r5VhXHnx7DHtHE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VirtualImageSettingFragment.b(VirtualImageSettingFragment.this, dialogInterface, i);
            }
        }).b().a();
        this.g = a2;
        if (a2 == null) {
            return;
        }
        a2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VirtualImageSettingFragment virtualImageSettingFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSettingFragment, "this$0");
        virtualImageSettingFragment.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_DELETE_CLICK);
        virtualImageSettingFragment.c();
    }

    public final OnVirtualImageDeletedListener a() {
        return this.i;
    }

    public final void a(OnBackPressedListener onBackPressedListener) {
        this.h = onBackPressedListener;
    }

    public final void a(OnVirtualImageDeletedListener onVirtualImageDeletedListener) {
        this.i = onVirtualImageDeletedListener;
    }

    public final void a(VirtualImageUtils virtualImageUtils) {
        this.j = virtualImageUtils;
    }

    public void m() {
        FragmentVirtualImageSettingBinding b2 = b();
        if (b2 == null) {
            return;
        }
        if (UserInfo.getInstance().getLoginUserInfo().personal_display == 1) {
            b(false);
        } else {
            a(false);
        }
        b2.f15342c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$jbGMhBXIu6P0K9uHaq0iujimRy4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageSettingFragment.a(VirtualImageSettingFragment.this, view);
            }
        });
        b2.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$MTs_PnBq5mi7O9-E7wfE8ocDiZo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageSettingFragment.b(VirtualImageSettingFragment.this, view);
            }
        });
        b2.b.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$_A03STSO5MPLnLpwfGVT7HrKvz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageSettingFragment.c(VirtualImageSettingFragment.this, view);
            }
        }));
    }

    public void o() {
    }

    public boolean onBackPressed() {
        OnBackPressedListener onBackPressedListener = this.h;
        if (onBackPressedListener == null) {
            return true;
        }
        onBackPressedListener.a();
        return true;
    }
}
