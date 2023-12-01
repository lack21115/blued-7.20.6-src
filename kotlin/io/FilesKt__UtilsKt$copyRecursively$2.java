package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/FilesKt__UtilsKt$copyRecursively$2.class */
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements Function2<File, IOException, Unit> {
    final /* synthetic */ Function2<File, IOException, OnErrorAction> a;

    public final void a(File f, IOException e) {
        Intrinsics.e(f, "f");
        Intrinsics.e(e, "e");
        if (this.a.invoke(f, e) == OnErrorAction.TERMINATE) {
            throw new TerminateException(f);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(File file, IOException iOException) {
        a(file, iOException);
        return Unit.a;
    }
}
