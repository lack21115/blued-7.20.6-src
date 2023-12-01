package com.alipay.security.mobile.module.b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/b/c.class */
final class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4706a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4706a = bVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
