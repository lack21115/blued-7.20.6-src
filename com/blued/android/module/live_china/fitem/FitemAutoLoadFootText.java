package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemAutoLoadFootText.class */
public final class FitemAutoLoadFootText extends FreedomItem {
    public static final Companion b = new Companion(null);
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;

    /* renamed from: c  reason: collision with root package name */
    private Context f12523c;
    private TextView d;
    private int e = h;
    private String f = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemAutoLoadFootText$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_auto_load_foot_text;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i2) {
        Intrinsics.e(vh, "vh");
        this.f12523c = context;
        this.d = (TextView) vh.a(R.id.tv_text);
    }

    public final int getType() {
        return this.e;
    }
}
