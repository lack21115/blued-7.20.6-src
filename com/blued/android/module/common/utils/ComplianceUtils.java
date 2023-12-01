package com.blued.android.module.common.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ComplianceUtils.class */
public final class ComplianceUtils {
    public static final ComplianceUtils a = new ComplianceUtils();

    private ComplianceUtils() {
    }

    public final boolean a(Context context) {
        if (context == null || !StringsKt.a(AppInfo.c, "a1000a", true)) {
            return false;
        }
        CommonAlertDialog.a(context, context.getString(R.string.common_notice), context.getString(R.string.common_notice_destroy_photo_content), context.getString(R.string.common_notice_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 1);
        return true;
    }
}
