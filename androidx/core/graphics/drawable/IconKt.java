package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/drawable/IconKt.class */
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        Intrinsics.e(bitmap, "<this>");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        Intrinsics.c(createWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    public static final Icon toIcon(Bitmap bitmap) {
        Intrinsics.e(bitmap, "<this>");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        Intrinsics.c(createWithBitmap, "createWithBitmap(this)");
        return createWithBitmap;
    }

    public static final Icon toIcon(Uri uri) {
        Intrinsics.e(uri, "<this>");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        Intrinsics.c(createWithContentUri, "createWithContentUri(this)");
        return createWithContentUri;
    }

    public static final Icon toIcon(byte[] bArr) {
        Intrinsics.e(bArr, "<this>");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        Intrinsics.c(createWithData, "createWithData(this, 0, size)");
        return createWithData;
    }
}
