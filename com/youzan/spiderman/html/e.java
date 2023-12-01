package com.youzan.spiderman.html;

import com.youzan.spiderman.html.h;
import com.youzan.spiderman.utils.FileUtil;
import com.youzan.spiderman.utils.Logger;
import java.io.ByteArrayInputStream;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private l f41833a;

    public e(l lVar) {
        this.f41833a = lVar;
    }

    public final void a() {
        String c2 = this.f41833a.c();
        File file = new File(com.youzan.spiderman.cache.g.i(), c2);
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(com.youzan.spiderman.cache.g.h(), c2);
        if (file2.exists()) {
            file2.delete();
        }
        h hVar = h.a.f41839a;
        if (hVar.b(c2) != null) {
            hVar.a();
        }
    }

    public final void a(HtmlHeader htmlHeader, g gVar, byte[] bArr) {
        String c2 = this.f41833a.c();
        File file = new File(com.youzan.spiderman.cache.g.i(), c2);
        if (!FileUtil.writeContentToFile(file, HtmlHeader.toJson(htmlHeader))) {
            Logger.e("HtmlCacheWriter", "write html header to local failed, headerFile:" + file, new Object[0]);
            return;
        }
        File file2 = new File(com.youzan.spiderman.cache.g.h(), c2);
        if (!FileUtil.writeStreamToFile(file2, new ByteArrayInputStream(bArr))) {
            Logger.e("HtmlCacheWriter", "write html content to local failed, htmlFile:" + file2, new Object[0]);
            return;
        }
        com.youzan.spiderman.b.f.a().a(gVar.b());
        h hVar = h.a.f41839a;
        hVar.a(gVar);
        hVar.a();
    }
}
