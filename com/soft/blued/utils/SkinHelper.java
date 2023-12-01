package com.soft.blued.utils;

import android.content.Context;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/SkinHelper.class */
public final class SkinHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SkinHelper f34771a = new SkinHelper();

    private SkinHelper() {
    }

    @JvmStatic
    public static final int a(Context context) {
        Intrinsics.e(context, "context");
        return BluedSkinUtils.c() ? context.getResources().getColor(2131102254) : context.getResources().getColor(2131102257);
    }

    @JvmStatic
    public static final int b(Context context) {
        Intrinsics.e(context, "context");
        return BluedSkinUtils.c() ? context.getResources().getColor(2131101780) : context.getResources().getColor(R.color.syc_b_in_dark_mode);
    }

    @JvmStatic
    public static final int c(Context context) {
        Intrinsics.e(context, "context");
        return BluedSkinUtils.c() ? context.getResources().getColor(2131102264) : context.getResources().getColor(R.color.syc_k_in_dark_mode);
    }

    @JvmStatic
    public static final int d(Context context) {
        Intrinsics.e(context, "context");
        return BluedSkinUtils.c() ? context.getResources().getColor(2131101796) : context.getResources().getColor(R.color.syc_c_in_dark_mode);
    }

    @JvmStatic
    public static final int e(Context context) {
        Intrinsics.e(context, "context");
        return BluedSkinUtils.c() ? context.getResources().getColor(2131102278) : context.getResources().getColor(2131102279);
    }
}
