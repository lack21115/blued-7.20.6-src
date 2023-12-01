package androidx.core.net;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/net/UriKt.class */
public final class UriKt {
    public static final File toFile(Uri uri) {
        Intrinsics.e(uri, "<this>");
        if (Intrinsics.a(uri.getScheme(), ContentResolver.SCHEME_FILE)) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(Intrinsics.a("Uri path is null: ", uri).toString());
        }
        throw new IllegalArgumentException(Intrinsics.a("Uri lacks 'file' scheme: ", uri).toString());
    }

    public static final Uri toUri(File file) {
        Intrinsics.e(file, "<this>");
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.c(fromFile, "fromFile(this)");
        return fromFile;
    }

    public static final Uri toUri(String str) {
        Intrinsics.e(str, "<this>");
        Uri parse = Uri.parse(str);
        Intrinsics.c(parse, "parse(this)");
        return parse;
    }
}
