package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/c.class */
public final class c {
    public final File ant;
    public final com.kwad.sdk.core.videocache.kwai.c anu;
    public final com.kwad.sdk.core.videocache.kwai.a anv;
    public final com.kwad.sdk.core.videocache.c.b anw;
    public final com.kwad.sdk.core.videocache.a.b anx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.ant = file;
        this.anu = cVar;
        this.anv = aVar;
        this.anw = bVar;
        this.anx = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File cP(String str) {
        return new File(this.ant, this.anu.generate(str));
    }
}
