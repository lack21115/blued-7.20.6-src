package com.opos.videocache;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final File f13758a;
    public final com.opos.videocache.a.c b;

    /* renamed from: c  reason: collision with root package name */
    public final com.opos.videocache.a.a f13759c;
    public final com.opos.videocache.c.b d;
    public final com.opos.videocache.b.b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(File file, com.opos.videocache.a.c cVar, com.opos.videocache.a.a aVar, com.opos.videocache.c.b bVar, com.opos.videocache.b.b bVar2) {
        this.f13758a = file;
        this.b = cVar;
        this.f13759c = aVar;
        this.d = bVar;
        this.e = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f13758a, this.b.a(str));
    }
}
