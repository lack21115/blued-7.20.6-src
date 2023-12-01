package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.provider.Downloads;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GuideCenterDownBluedPop.class */
public final class GuideCenterDownBluedPop extends AttachPopupView {
    private final String t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideCenterDownBluedPop(Context context, String str) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(str, Downloads.Impl.COLUMN_FILE_NAME_HINT);
        this.t = str;
    }

    public void b() {
        super.b();
        ((TextView) findViewById(2131371675)).setText(this.t);
    }

    public final String getHint() {
        return this.t;
    }

    public int getImplLayoutId() {
        return R.layout.pop_guide_group_base;
    }
}
