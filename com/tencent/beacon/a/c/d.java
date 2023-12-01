package com.tencent.beacon.a.c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/d.class */
public class d implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f34941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f34941a = eVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
