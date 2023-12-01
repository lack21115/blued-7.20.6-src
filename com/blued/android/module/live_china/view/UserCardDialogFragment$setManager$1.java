package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$setManager$1.class */
public final class UserCardDialogFragment$setManager$1 extends BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>> {
    final /* synthetic */ UserCardDialogFragment a;
    private boolean b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCardDialogFragment$setManager$1(UserCardDialogFragment userCardDialogFragment, IRequestHost iRequestHost) {
        super(iRequestHost);
        this.a = userCardDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, DialogInterface dialogInterface, int i) {
        UserCardDialogFragment.UserCardOnclickListner userCardOnclickListner;
        Intrinsics.e(this$0, "this$0");
        userCardOnclickListner = this$0.j;
        if (userCardOnclickListner == null) {
            return;
        }
        userCardOnclickListner.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
        Context context;
        if (bluedEntityA == null || !bluedEntityA.hasData()) {
            return;
        }
        context = this.a.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        AppMethods.a((CharSequence) context2.getResources().getString(R.string.live_manager_settled));
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public boolean onUIFailure(int i, String errInfo) {
        Intrinsics.e(errInfo, "errInfo");
        if (i == 403903) {
            this.c = errInfo;
            this.b = true;
            return true;
        }
        return super.onUIFailure(i, errInfo);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish() {
        Context context;
        Context context2;
        Context context3;
        super.onUIFinish();
        if (this.b) {
            context = this.a.d;
            Context context4 = context;
            if (context4 == null) {
                Intrinsics.c("mContext");
                context4 = null;
            }
            String str = this.c;
            context2 = this.a.d;
            Context context5 = context2;
            if (context2 == null) {
                Intrinsics.c("mContext");
                context5 = null;
            }
            String string = context5.getString(R.string.live_manager_manage);
            context3 = this.a.d;
            Context context6 = context3;
            if (context6 == null) {
                Intrinsics.c("mContext");
                context6 = null;
            }
            String string2 = context6.getString(R.string.live_ok);
            final UserCardDialogFragment userCardDialogFragment = this.a;
            CommonAlertDialog.a(context4, (View) null, "", str, string, string2, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$setManager$1$Db5NBG_i3g5Fb5y1oyYbRbyMS1I
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UserCardDialogFragment$setManager$1.a(UserCardDialogFragment.this, dialogInterface, i);
                }
            }, (DialogInterface.OnCancelListener) null, true);
            this.b = false;
        }
    }
}
