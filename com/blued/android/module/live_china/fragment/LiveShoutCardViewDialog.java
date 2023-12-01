package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LayoutSuperCallingCardBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShoutCardViewDialog.class */
public final class LiveShoutCardViewDialog extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final String b;
    private final String c;
    private final Lazy d;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShoutCardViewDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveShoutCardViewDialog a(String pop_up_title, String pop_up_description, FragmentManager manager) {
            Intrinsics.e(pop_up_title, "pop_up_title");
            Intrinsics.e(pop_up_description, "pop_up_description");
            Intrinsics.e(manager, "manager");
            LiveShoutCardViewDialog liveShoutCardViewDialog = new LiveShoutCardViewDialog(pop_up_title, pop_up_description);
            liveShoutCardViewDialog.show(manager, LiveShoutCardViewDialog.class.getSimpleName());
            return liveShoutCardViewDialog;
        }
    }

    public LiveShoutCardViewDialog(String popUpTitle, String popUpDescription) {
        Intrinsics.e(popUpTitle, "popUpTitle");
        Intrinsics.e(popUpDescription, "popUpDescription");
        this.b = popUpTitle;
        this.c = popUpDescription;
        this.d = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutSuperCallingCardBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveShoutCardViewDialog$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutSuperCallingCardBinding invoke() {
                LayoutSuperCallingCardBinding a2 = LayoutSuperCallingCardBinding.a(LayoutInflater.from(LiveShoutCardViewDialog.this.getContext()));
                Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
                return a2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LayoutSuperCallingCardBinding this_run, final LiveShoutCardViewDialog this$0, View view) {
        Intrinsics.e(this_run, "$this_run");
        Intrinsics.e(this$0, "this$0");
        Editable text = this_run.a.getText();
        Intrinsics.c(text, "edtInputCallingMsg.text");
        if (text.length() == 0) {
            ToastUtils.a("请输入喊话内容");
            return;
        }
        EventTrackLive.j(LiveProtos.Event.LIVE_SUPER_SPEAK_PAGE_GO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this_run.a.getText().toString());
        CommonAlertDialog.a(this$0.getActivity(), "", this$0.getResources().getString(R.string.live_confirm_to_calling), this$0.getResources().getString(R.string.biao_v4_ok), this$0.getResources().getColor(R.color.syc_2B72FF), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveShoutCardViewDialog$srfU8Ge2tfd-kStikcBf9YBxEys
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveShoutCardViewDialog.a(LiveShoutCardViewDialog.this, this_run, dialogInterface, i);
            }
        }, this$0.getResources().getString(R.string.cancel), R.color.syc_dark_A5A6B3, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveShoutCardViewDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        new LiveShapeBtnDialogFragment(this$0.requireContext(), this$0.b, this$0.c, "确定").show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveShoutCardViewDialog this$0, LayoutSuperCallingCardBinding this_run) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_run, "$this_run");
        KeyboardUtils.a(this$0.getActivity(), this_run.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveShoutCardViewDialog this$0, LayoutSuperCallingCardBinding this_run, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_run, "$this_run");
        this$0.a(this_run.a.getText().toString());
    }

    private final LayoutSuperCallingCardBinding d() {
        return (LayoutSuperCallingCardBinding) this.d.getValue();
    }

    private final void e() {
        EventTrackLive.i(LiveProtos.Event.LIVE_SUPER_SPEAK_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), "");
        final LayoutSuperCallingCardBinding d = d();
        d.a.requestFocus();
        d.a.setFocusableInTouchMode(true);
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveShoutCardViewDialog$eqwbarU6-17xIZf9GNONLQHizH0
            @Override // java.lang.Runnable
            public final void run() {
                LiveShoutCardViewDialog.a(LiveShoutCardViewDialog.this, d);
            }
        }, 200L);
        d.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveShoutCardViewDialog$TEBRE41am4kOhe7J-mlfioB2zL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveShoutCardViewDialog.a(LiveShoutCardViewDialog.this, view);
            }
        });
        final ShapeModel shapeModel = d.g.getShapeModel();
        Intrinsics.c(shapeModel, "stvToCalling.shapeModel");
        d.a.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.LiveShoutCardViewDialog$initSuperCallingCard$1$3
            /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void afterTextChanged(android.text.Editable r5) {
                /*
                    Method dump skipped, instructions count: 239
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveShoutCardViewDialog$initSuperCallingCard$1$3.afterTextChanged(android.text.Editable):void");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        d.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveShoutCardViewDialog$TDPMFMQ8m-CftFRbCQcXQpUpGXU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveShoutCardViewDialog.a(LayoutSuperCallingCardBinding.this, this, view);
            }
        });
    }

    public final void a(String contents) {
        Intrinsics.e(contents, "contents");
        String e = LiveRoomManager.a().e();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.g(e, contents, new BluedUIHttpResponse<BluedEntity<?, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveShoutCardViewDialog$toShout$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveShoutCardViewDialog.this.dismissAllowingStateLoss();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                LiveEventBus.get("live_shout_card_success").post(true);
            }
        }, a());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        DensityUtils.a(getContext(), 165.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -2));
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
            window2.setWindowAnimations(R.style.main_menu_animstyle);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            dialog.onWindowAttributesChanged(attributes);
        }
        d().getRoot().setBackgroundResource(R.drawable.shape_live_shout_card_bg_top_radius);
        return dialog;
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
    }
}
