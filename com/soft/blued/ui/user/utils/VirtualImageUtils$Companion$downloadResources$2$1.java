package com.soft.blued.ui.user.utils;

import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImageUtils$Companion$downloadResources$2$1.class */
public final class VirtualImageUtils$Companion$downloadResources$2$1 extends FileHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f34339a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ File f34340c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VirtualImageUtils$Companion$downloadResources$2$1(String str, String str2, File file) {
        this.f34339a = str;
        this.b = str2;
        this.f34340c = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(File file, File dir, File file2, Exception exc) {
        Intrinsics.e(dir, "$dir");
        file.delete();
        VirtualImageUtils.Companion.b(dir);
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onSuccess(final File file) {
        if (file == null || !file.exists()) {
            return;
        }
        ImageFileWrapper a2 = ImageFileLoader.a((IRequestHost) null).a(this.f34339a, this.b);
        final File file2 = this.f34340c;
        a2.a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImageUtils$Companion$downloadResources$2$1$1usd1KdOkGTZN85RrWAA_b7nMKk
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public final void onUIFinish(File file3, Exception exc) {
                VirtualImageUtils$Companion$downloadResources$2$1.a(File.this, file2, file3, exc);
            }
        }).a();
    }
}
