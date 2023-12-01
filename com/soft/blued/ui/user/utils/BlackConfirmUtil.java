package com.soft.blued.ui.user.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.presenter.PayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/BlackConfirmUtil.class */
public final class BlackConfirmUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final BlackConfirmUtil f20634a = new BlackConfirmUtil();

    private BlackConfirmUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(context, "$context");
        PayUtils.a(context, 7, "blacklist_expand");
    }

    public final void a(final Context context) {
        Intrinsics.e(context, "context");
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.c(0).a(context.getString(R.string.block_user_limit_title)).b(context.getString(R.string.block_user_limit_desc)).a((View) null).a(context.getString(R.string.begin_vip), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$BlackConfirmUtil$iU5x7dne33a7pOZKaj3jwCq7-R0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BlackConfirmUtil.a(Context.this, dialogInterface, i);
            }
        }).b(context.getString(2131886885), (DialogInterface.OnClickListener) null).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0).i(ContextCompat.getColor(context, 2131101766)).h(ContextCompat.getColor(context, 2131102263));
        BluedAlertDialog a2 = builder.a();
        a2.setCanceledOnTouchOutside(false);
        a2.show();
    }

    public final void a(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        Intrinsics.e(context, "context");
        Intrinsics.e(onClickListener, "okListener");
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        BluedAlertDialog.Builder a2 = builder.c(0).a(context.getString(R.string.block_user_title));
        String str2 = str;
        a2.b(context.getString((TextUtils.isEmpty(str2) || !TextUtils.equals(str2, "1")) ? 2131886798 : 2131890884)).a((View) null).a(context.getString(R.string.block_user_confirm), onClickListener).b(context.getString(2131886885), (DialogInterface.OnClickListener) null).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0).i(ContextCompat.getColor(context, 2131102251)).h(ContextCompat.getColor(context, 2131102263));
        BluedAlertDialog a3 = builder.a();
        a3.setCanceledOnTouchOutside(false);
        a3.show();
    }
}
