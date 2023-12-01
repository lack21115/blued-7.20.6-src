package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/FileSystemException.class */
public class FileSystemException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private final File f42486a;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42487c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(ExceptionsKt.b(file, file2, str));
        Intrinsics.e(file, "file");
        this.f42486a = file;
        this.b = file2;
        this.f42487c = str;
    }

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }
}
