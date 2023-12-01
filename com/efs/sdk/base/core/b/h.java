package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.b.a;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/h.class */
public final class h implements f {
    @Override // com.efs.sdk.base.core.b.f
    public final boolean a(File file) {
        a unused;
        com.efs.sdk.base.core.d.b b = com.efs.sdk.base.core.util.b.b(file.getName());
        if (b != null) {
            return ("wa".equals(b.f8158a.f8156a) || com.efs.sdk.base.core.c.b.a().a(b.f8158a.f8156a, file.length())) ? false : true;
        }
        unused = a.b.f8121a;
        a.b(file);
        return true;
    }
}
