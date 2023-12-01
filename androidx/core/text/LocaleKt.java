package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/text/LocaleKt.class */
public final class LocaleKt {
    public static final int getLayoutDirection(Locale locale) {
        Intrinsics.e(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
