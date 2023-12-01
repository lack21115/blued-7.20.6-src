package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/y.class */
final class y implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
