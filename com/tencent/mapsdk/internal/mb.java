package com.tencent.mapsdk.internal;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mb.class */
public class mb extends qb {

    /* renamed from: c  reason: collision with root package name */
    private String f23953c;

    public String c() {
        return this.f23953c;
    }

    @Override // com.tencent.mapsdk.internal.qb, com.tencent.mapsdk.internal.ib
    public InputStream f(String str) {
        try {
            String file = new URL(str).getFile();
            if (!f7.b(file)) {
                this.f23953c = file.substring(file.lastIndexOf("/") + 1).replace("%20", " ");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return super.f(str);
    }
}
