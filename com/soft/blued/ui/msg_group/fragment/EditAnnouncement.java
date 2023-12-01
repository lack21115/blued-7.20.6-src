package com.soft.blued.ui.msg_group.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.blued.android.core.AppMethods;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.fragment.CommonWriteTextFragment;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/EditAnnouncement.class */
public final class EditAnnouncement extends CommonWriteTextFragment {
    private String k = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EditAnnouncement editAnnouncement, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(editAnnouncement, "this$0");
        editAnnouncement.a(0);
    }

    private final void b() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_exit_title), getString(R.string.group_announcement_exit_hint), getString(R.string.group_announcement_quit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$EditAnnouncement$_Y6zEscnV1fSFLfY_5_hhIyO0rs
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditAnnouncement.a(EditAnnouncement.this, dialogInterface, i);
            }
        }, getString(R.string.group_announcement_go_on), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EditAnnouncement editAnnouncement, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(editAnnouncement, "this$0");
        editAnnouncement.a(-1);
    }

    private final void c() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_send_title), getString(R.string.group_announcement_send_hint), getString(R.string.group_announcement_submit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$EditAnnouncement$I8LBB8ZGAGrKh1A55vfhKGw3BCw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditAnnouncement.b(EditAnnouncement.this, dialogInterface, i);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EditAnnouncement editAnnouncement, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(editAnnouncement, "this$0");
        editAnnouncement.a(-1);
    }

    private final void d() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_clear_title), getString(R.string.group_announcement_clear_hint), getString(R.string.group_notify_clean), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$EditAnnouncement$s4OPSH0gDCdOoCoc66f-DghYUY0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditAnnouncement.c(EditAnnouncement.this, dialogInterface, i);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.k = this.d.getText().toString();
    }

    @Override // com.soft.blued.fragment.CommonWriteTextFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.e(view, "v");
        int id = view.getId();
        boolean z = false;
        if (id == 2131363120) {
            if (Intrinsics.a(this.k, this.d.getText().toString())) {
                a(0);
            } else {
                b();
            }
        } else if (id != 2131363126) {
        } else {
            if (!this.e.isOutOfBounds()) {
                if (this.d.getText().toString().length() == 0) {
                    z = true;
                }
                if (z) {
                    d();
                    return;
                } else {
                    c();
                    return;
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = this.f15952a.getResources().getString(R.string.max_input_limit);
            Intrinsics.c(string, "mContext.resources.getSt…R.string.max_input_limit)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.b + ""}, 1));
            Intrinsics.c(format, "format(format, *args)");
            AppMethods.a(format);
        }
    }
}
