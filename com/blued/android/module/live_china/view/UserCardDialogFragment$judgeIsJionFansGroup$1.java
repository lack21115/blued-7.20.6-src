package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$judgeIsJionFansGroup$1.class */
public final class UserCardDialogFragment$judgeIsJionFansGroup$1 extends BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>> {
    final /* synthetic */ UserCardDialogFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCardDialogFragment$judgeIsJionFansGroup$1(UserCardDialogFragment userCardDialogFragment, IRequestHost iRequestHost) {
        super(iRequestHost);
        this.a = userCardDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
            this.a.z();
            return;
        }
        boolean z = false;
        for (LiveFansGroupModel liveFansGroupModel : bluedEntityA.data) {
            if (liveFansGroupModel.apply_status == 3) {
                z = true;
            }
        }
        if (!z) {
            this.a.z();
            return;
        }
        context = this.a.d;
        Context context5 = context;
        if (context5 == null) {
            Intrinsics.c("mContext");
            context5 = null;
        }
        context2 = this.a.d;
        Context context6 = context2;
        if (context2 == null) {
            Intrinsics.c("mContext");
            context6 = null;
        }
        String string = context6.getString(R.string.live_fans_group_dialog_cancel_attention);
        context3 = this.a.d;
        Context context7 = context3;
        if (context3 == null) {
            Intrinsics.c("mContext");
            context7 = null;
        }
        String string2 = context7.getString(R.string.live_fans_group_dialog_confirm);
        final UserCardDialogFragment userCardDialogFragment = this.a;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$judgeIsJionFansGroup$1$NYi5n-eHTunSXEyBRZ4B711xvXQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UserCardDialogFragment$judgeIsJionFansGroup$1.a(UserCardDialogFragment.this, dialogInterface, i);
            }
        };
        context4 = this.a.d;
        Context context8 = context4;
        if (context8 == null) {
            Intrinsics.c("mContext");
            context8 = null;
        }
        CommonAlertDialog.a(context5, string, (String) null, string2, onClickListener, context8.getString(R.string.live_fans_group_dialog_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public boolean onUIFailure(int i, String errorMessage) {
        Intrinsics.e(errorMessage, "errorMessage");
        this.a.z();
        return false;
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish() {
        super.onUIFinish();
    }
}
