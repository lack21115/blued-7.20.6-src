package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/FilesKt__UtilsKt$copyRecursively$1.class */
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements Function2 {

    /* renamed from: a  reason: collision with root package name */
    public static final FilesKt__UtilsKt$copyRecursively$1 f42501a = new FilesKt__UtilsKt$copyRecursively$1();

    FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Void invoke(File file, IOException exception) {
        Intrinsics.e(file, "<anonymous parameter 0>");
        Intrinsics.e(exception, "exception");
        throw exception;
    }
}
