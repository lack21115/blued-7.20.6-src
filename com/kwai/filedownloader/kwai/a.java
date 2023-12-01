package com.kwai.filedownloader.kwai;

import com.kwai.filedownloader.e.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/kwai/a.class */
public final class a implements c.a {
    @Override // com.kwai.filedownloader.e.c.a
    public final int ak(long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
