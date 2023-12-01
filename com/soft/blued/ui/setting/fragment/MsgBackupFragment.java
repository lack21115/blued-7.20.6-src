package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.base.mvi.UiEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FmMsgBackupBinding;
import com.soft.blued.ui.setting.state.MsgBackupAction;
import com.soft.blued.ui.setting.state.MsgBackupState;
import com.soft.blued.ui.setting.vm.MsgBackupVM;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/MsgBackupFragment.class */
public final class MsgBackupFragment extends MVIBaseFragment<MsgBackupVM> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(MsgBackupFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmMsgBackupBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19823c;

    public MsgBackupFragment() {
        super((int) R.layout.fm_msg_backup);
        this.f19823c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<MsgBackupFragment, FmMsgBackupBinding>() { // from class: com.soft.blued.ui.setting.fragment.MsgBackupFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/MsgBackupFragment;)Lcom/soft/blued/databinding/FmMsgBackupBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmMsgBackupBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<MsgBackupFragment, FmMsgBackupBinding>() { // from class: com.soft.blued.ui.setting.fragment.MsgBackupFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/MsgBackupFragment;)Lcom/soft/blued/databinding/FmMsgBackupBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmMsgBackupBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FmMsgBackupBinding a() {
        return (FmMsgBackupBinding) this.f19823c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        EventTrackSettings.a(SettingsProtos.Event.MINE_DELETE_RECORD_CANCEL_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MsgBackupFragment msgBackupFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(msgBackupFragment, "this$0");
        BluedStructureExtKt.a(msgBackupFragment, MsgBackupAction.Delete.f19944a);
        EventTrackSettings.a(SettingsProtos.Event.MINE_DELETE_RECORD_TRUE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MsgBackupFragment msgBackupFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(msgBackupFragment, "this$0");
        FragmentActivity activity = msgBackupFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void b() {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(getContext());
        BluedAlertDialog.Builder c2 = builder.c(0);
        Context context = getContext();
        BluedAlertDialog.Builder a2 = c2.a(context == null ? null : context.getString(R.string.msg_delete_backup));
        Context context2 = getContext();
        BluedAlertDialog.Builder a3 = a2.b(context2 == null ? null : context2.getString(R.string.msg_delete_hint)).a((View) null);
        Context context3 = getContext();
        BluedAlertDialog.Builder a4 = a3.a(context3 == null ? null : context3.getString(R.string.msg_delete_backup), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$XlsVQqOTUt2TJydpN4gshb_c4WY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.a(MsgBackupFragment.this, dialogInterface, i);
            }
        });
        Context context4 = getContext();
        a4.b(context4 == null ? null : context4.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$30Q7NDT9SUA_weSvWzZnQ7kX4lg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.a(dialogInterface, i);
            }
        }).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a5 = builder.a();
        a5.setCanceledOnTouchOutside(false);
        a5.show();
        a5.f().setTextColor(BluedSkinUtils.a(getContext(), 2131102251));
        a5.e().setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        EventTrackSettings.a(SettingsProtos.Event.MINE_RECOVERY_RECORD_CANCEL_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MsgBackupFragment msgBackupFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(msgBackupFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_RECOVERY_RECORD_CONTINUE_CLICK);
        BluedStructureExtKt.a(msgBackupFragment, MsgBackupAction.DownloadAndRestore.f19945a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MsgBackupFragment msgBackupFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(msgBackupFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_BACKUP_RECORD_CLICK);
        if (BluedApiProxy.a || (NetworkUtils.b() && !NetworkUtils.a())) {
            msgBackupFragment.d();
        } else {
            msgBackupFragment.e();
        }
    }

    private final void c() {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(getContext());
        BluedAlertDialog.Builder c2 = builder.c(0);
        Context context = getContext();
        BluedAlertDialog.Builder a2 = c2.a(context == null ? null : context.getString(R.string.msg_restore_chat));
        Context context2 = getContext();
        BluedAlertDialog.Builder a3 = a2.b(context2 == null ? null : context2.getString(R.string.msg_restore_hint)).a((View) null);
        Context context3 = getContext();
        BluedAlertDialog.Builder a4 = a3.a(context3 == null ? null : context3.getString(R.string.msg_restore), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$BPYmZRuRsne2K2wzkLG3cZHaVJ8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.b(MsgBackupFragment.this, dialogInterface, i);
            }
        });
        Context context4 = getContext();
        a4.b(context4 == null ? null : context4.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$_gffcBLlclFqvvTqLooz9wdcrUQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.b(dialogInterface, i);
            }
        }).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a5 = builder.a();
        a5.setCanceledOnTouchOutside(false);
        a5.show();
        a5.f().setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        a5.e().setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        EventTrackSettings.a(SettingsProtos.Event.MINE_BACKUP_RECORD_CANCEL_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MsgBackupFragment msgBackupFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(msgBackupFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_BACKUP_RECORD_CONTINUE_CLICK);
        BluedStructureExtKt.a(msgBackupFragment, MsgBackupAction.Backup.f19943a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MsgBackupFragment msgBackupFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(msgBackupFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_RECOVERY_RECORD_CLICK);
        if (BluedApiProxy.a || (NetworkUtils.b() && !NetworkUtils.a())) {
            msgBackupFragment.c();
        } else {
            msgBackupFragment.e();
        }
    }

    private final void d() {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(getContext());
        BluedAlertDialog.Builder c2 = builder.c(0);
        Context context = getContext();
        BluedAlertDialog.Builder a2 = c2.a(context == null ? null : context.getString(R.string.msg_backup_chat));
        Context context2 = getContext();
        BluedAlertDialog.Builder a3 = a2.b(context2 == null ? null : context2.getString(R.string.msg_backup_hint)).a((View) null);
        Context context3 = getContext();
        BluedAlertDialog.Builder a4 = a3.a(context3 == null ? null : context3.getString(2131886739), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$T-00nXwcKxQC-9Hgwtu2b_VY7yg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.c(MsgBackupFragment.this, dialogInterface, i);
            }
        });
        Context context4 = getContext();
        a4.b(context4 == null ? null : context4.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$OPVKyLyBYulkGI2BQqvM5WaDfdU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.c(dialogInterface, i);
            }
        }).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a5 = builder.a();
        a5.setCanceledOnTouchOutside(false);
        a5.show();
        a5.f().setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        a5.e().setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        if (dialogInterface == null) {
            return;
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MsgBackupFragment msgBackupFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(msgBackupFragment, "this$0");
        BluedStructureExtKt.a(msgBackupFragment, MsgBackupAction.UploadFile.f19948a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MsgBackupFragment msgBackupFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(msgBackupFragment, "this$0");
        msgBackupFragment.b();
        EventTrackSettings.a(SettingsProtos.Event.MINE_DELETE_RECORD_CLICK);
    }

    private final void e() {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(getContext());
        BluedAlertDialog.Builder c2 = builder.c(0);
        Context context = getContext();
        BluedAlertDialog.Builder a2 = c2.a(context == null ? null : context.getString(2131891192));
        Context context2 = getContext();
        BluedAlertDialog.Builder a3 = a2.b(context2 == null ? null : context2.getString(R.string.msg_backup_failed_hint)).a((View) null);
        Context context3 = getContext();
        a3.a(context3 == null ? null : context3.getString(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$l38id7Jw3qZK4Dd8kguOGYVtMXk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.d(dialogInterface, i);
            }
        }).b((CharSequence) null, (DialogInterface.OnClickListener) null).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0).i(BluedSkinUtils.a(getContext(), 2131101766));
        BluedAlertDialog a4 = builder.a();
        a4.setCanceledOnTouchOutside(false);
        a4.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MsgBackupFragment msgBackupFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(msgBackupFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_RECOVERY_RECORD_CANCEL_CLICK);
        msgBackupFragment.a(false, false);
    }

    private final void f() {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(getContext());
        BluedAlertDialog.Builder c2 = builder.c(0);
        Context context = getContext();
        BluedAlertDialog.Builder a2 = c2.a(context == null ? null : context.getString(R.string.msg_backup_chat));
        Context context2 = getContext();
        BluedAlertDialog.Builder a3 = a2.b(context2 == null ? null : context2.getString(R.string.msg_restore_file_size_limit)).a((View) null);
        Context context3 = getContext();
        BluedAlertDialog.Builder a4 = a3.a(context3 == null ? null : context3.getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$d1fxv2MC7KLQe3Qq-qA5yjVoCPM
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.d(MsgBackupFragment.this, dialogInterface, i);
            }
        });
        Context context4 = getContext();
        a4.b(context4 == null ? null : context4.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$B5yLqpnx502_Dw51MggrVRAfSB4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MsgBackupFragment.e(MsgBackupFragment.this, dialogInterface, i);
            }
        }).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a5 = builder.a();
        a5.setCanceledOnTouchOutside(false);
        a5.show();
        a5.f().setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        a5.e().setTextColor(BluedSkinUtils.a(getContext(), 2131102263));
    }

    public void a(boolean z, boolean z2) {
        DialogUtils.b(t());
    }

    public void m() {
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        ImageView leftImg;
        FmMsgBackupBinding a2 = a();
        if (a2 != null && (commonTopTitleNoTrans2 = a2.f15062c) != null && (leftImg = commonTopTitleNoTrans2.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$76y-GV53j3gize5TgODqW6pxZ2o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgBackupFragment.a(MsgBackupFragment.this, view);
                }
            });
        }
        FmMsgBackupBinding a3 = a();
        TextView centerTextView = (a3 == null || (commonTopTitleNoTrans = a3.f15062c) == null) ? null : commonTopTitleNoTrans.getCenterTextView();
        if (centerTextView != null) {
            Context context = getContext();
            centerTextView.setText(context == null ? null : context.getString(R.string.msg_backup_restore));
        }
        FmMsgBackupBinding a4 = a();
        if (a4 != null && (linearLayout2 = a4.f15061a) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$ewf3NPG1yp-5qEB3hQ334_-hfhI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgBackupFragment.b(MsgBackupFragment.this, view);
                }
            });
        }
        FmMsgBackupBinding a5 = a();
        if (a5 != null && (linearLayout = a5.b) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$6AYqd3H6BQMgJ8DACV0v04ddeBI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgBackupFragment.c(MsgBackupFragment.this, view);
                }
            });
        }
        FmMsgBackupBinding a6 = a();
        if (a6 != null && (textView2 = a6.e) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$MsgBackupFragment$Oyni5g6bA8A6CvKASWI_puC57vg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgBackupFragment.d(MsgBackupFragment.this, view);
                }
            });
        }
        String string = getString(R.string.system_msg_backup_hint);
        Intrinsics.c(string, "getString(R.string.system_msg_backup_hint)");
        String string2 = getString(R.string.system_msg_backup_hint_link);
        Intrinsics.c(string2, "getString(R.string.system_msg_backup_hint_link)");
        ArrayList arrayList = new ArrayList();
        String string3 = getString(R.string.system_msg_backup_hint_link);
        Intrinsics.c(string3, "getString(R.string.system_msg_backup_hint_link)");
        arrayList.add(string3);
        FmMsgBackupBinding a7 = a();
        if (a7 != null && (textView = a7.f) != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.setting.fragment.MsgBackupFragment$initView$5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Intrinsics.e(view, "v");
                WebViewShowInfoFragment.show(MsgBackupFragment.this.getActivity(), H5Url.a(22), 0);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                Intrinsics.e(textPaint, "ds");
                textPaint.setColor(AppInfo.d().getResources().getColor(2131101766));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }, string.length() - string2.length(), string.length(), 33);
        FmMsgBackupBinding a8 = a();
        TextView textView3 = a8 == null ? null : a8.f;
        if (textView3 != null) {
            textView3.setText(spannableStringBuilder);
        }
        BluedStructureExtKt.a(this, MsgBackupAction.GetBackupInfo.f19946a);
    }

    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.setting.fragment.MsgBackupFragment$liveDataObserver$1
            public Object a(Object obj) {
                return ((MsgBackupState) obj).a();
            }
        }, new Function1<String, Unit>() { // from class: com.soft.blued.ui.setting.fragment.MsgBackupFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(String str) {
                FmMsgBackupBinding a2;
                Intrinsics.e(str, "it");
                a2 = MsgBackupFragment.this.a();
                TextView textView = a2 == null ? null : a2.d;
                if (textView == null) {
                    return;
                }
                textView.setText(str);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return Unit.a;
            }
        });
    }

    public void onEvent(UiEvent uiEvent) {
        Intrinsics.e(uiEvent, "event");
        if (uiEvent instanceof MsgBackupAction.MsgBackupEvent.FileLimitDialog) {
            f();
        }
    }

    public void r() {
        DialogUtils.a(t());
    }
}
