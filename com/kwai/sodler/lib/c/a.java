package com.kwai.sodler.lib.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/c/a.class */
public final class a implements Comparable<a> {
    public String aKT;
    public boolean qy;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
