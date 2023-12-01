package com.youzan.spiderman.a;

import com.youzan.spiderman.utils.FileUtil;
import com.youzan.spiderman.utils.IOUtils;
import com.youzan.spiderman.utils.Logger;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/a/b.class */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28024a = b.class.getSimpleName();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f28025c;

    private b(String str, String str2) {
        this.b = str;
        this.f28025c = str2;
    }

    public static b a(String str, String str2) {
        return new b(str, str2);
    }

    @Override // com.youzan.spiderman.a.a
    public final void a() throws Throwable {
        String str = this.b;
        String format = String.format("%s_tmp", str);
        FileUtil.createFile(format);
        IOUtils.writeStringToFile(format, this.f28025c);
        if (FileUtil.checkFileExists(str)) {
            FileUtil.deleteFile(str);
        }
        FileUtil.renameToFile(format, str);
    }

    @Override // com.youzan.spiderman.a.a
    public final void a(Throwable th) {
        Logger.e(f28024a, th);
    }
}
