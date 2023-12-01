package com.kwai.filedownloader.services;

import android.content.Intent;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/f.class */
public final class f {
    public static void f(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.Gq() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra("model", cVar);
        com.kwai.filedownloader.e.c.IZ().sendBroadcast(intent);
    }
}
