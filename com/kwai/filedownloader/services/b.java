package com.kwai.filedownloader.services;

import com.kwai.filedownloader.e.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/b.class */
public final class b implements c.d {
    @Override // com.kwai.filedownloader.e.c.d
    public final int j(String str, String str2, boolean z) {
        return k(str, str2, z);
    }

    @Override // com.kwai.filedownloader.e.c.d
    public final int k(String str, String str2, boolean z) {
        return com.kwai.filedownloader.e.f.eC(z ? com.kwai.filedownloader.e.f.j("%sp%s@dir", str, str2) : com.kwai.filedownloader.e.f.j("%sp%s", str, str2)).hashCode();
    }
}
