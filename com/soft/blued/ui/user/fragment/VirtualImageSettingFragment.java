package com.soft.blued.ui.user.fragment;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.DialogFragment;
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
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(VirtualImageSettingFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FragmentVirtualImageSettingBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f34217c;
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
        super(R.layout.fragment_virtual_image_setting);
        this.f34217c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<VirtualImageSettingFragment, FragmentVirtualImageSettingBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVirtualImageSettingBinding invoke(VirtualImageSettingFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImageSettingBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImageSettingFragment, FragmentVirtualImageSettingBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVirtualImageSettingBinding invoke(VirtualImageSettingFragment fragment) {
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
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                VirtualImageSettingFragment.this.f = false;
                ToastUtils.a((int) R.string.user_virtual_image_switch_toast, 0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
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
    public static final void a(final VirtualImageSettingFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        this$0.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_DELETE_YES_CLICK);
        UserHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSettingFragment$showDeleteConfirmDialog$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                VirtualImageSettingFragment.OnVirtualImageDeletedListener a2 = VirtualImageSettingFragment.this.a();
                if (a2 == null) {
                    return;
                }
                a2.a();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str, String str2) {
                ToastUtils.a(2131887272, 0);
                return true;
            }
        }, this$0.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSettingFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.f || this$0.e != 2) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_FIRST_VIRTUAL_CLICK);
        b(this$0, false, 1, null);
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
        b2.f29032c.setTextColor(getResources().getColor(2131100152));
        b2.d.setTextColor(getResources().getColor(2131102478));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.f29031a, "translationX", 0.0f, BluedViewExtKt.a(88.0f));
        ofFloat.setDuration(this.d);
        ofFloat.start();
        if (z) {
            a(2);
        }
    }

    private final FragmentVirtualImageSettingBinding b() {
        return (FragmentVirtualImageSettingBinding) this.f34217c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSettingFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        this$0.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_DELETE_NO_CLICK);
        Dialog dialog = this$0.g;
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSettingFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.f || this$0.e != 1) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_FIRST_BG_CLICK);
        a(this$0, false, 1, null);
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
        b2.d.setTextColor(getResources().getColor(2131100152));
        b2.f29032c.setTextColor(getResources().getColor(2131102478));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.f29031a, "translationX", BluedViewExtKt.a(88.0f), 0.0f);
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
        BluedAlertDialog a2 = new BluedAlertDialog.Builder(getContext()).d(R.string.user_virtual_image_alert).e(R.string.user_virtual_image_alert_message).a(R.string.user_virtual_image_alert_delete, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$XQYBgCW4chp8OQFLPibI0HvcEtY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VirtualImageSettingFragment.a(VirtualImageSettingFragment.this, dialogInterface, i);
            }
        }).f(2131101730).b(R.string.user_virtual_image_alert_cancel, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$sX47xNKPTaj48r5VhXHnx7DHtHE
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
    public static final void c(VirtualImageSettingFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_DELETE_CLICK);
        this$0.c();
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

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
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
        b2.f29032c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$jbGMhBXIu6P0K9uHaq0iujimRy4
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
        b2.b.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSettingFragment$_A03STSO5MPLnLpwfGVT7HrKvz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageSettingFragment.c(VirtualImageSettingFragment.this, view);
            }
        }));
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        OnBackPressedListener onBackPressedListener = this.h;
        if (onBackPressedListener == null) {
            return true;
        }
        onBackPressedListener.a();
        return true;
    }
}
