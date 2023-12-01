package com.opos.mobad.d.b;

import com.opos.mobad.d.e;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f25972a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25973c;
    public final String d;
    public int f = 0;
    public int g = 0;
    public final Set<e> e = new HashSet();

    public a(String str, String str2, String str3, String str4) {
        this.f25972a = str2;
        this.b = str3;
        this.f25973c = str4;
        this.d = str;
    }

    public void a(e eVar) {
        if (eVar != null) {
            if (this.e.size() > 0) {
                for (e eVar2 : this.e) {
                    if (eVar2 != null && (eVar2 == eVar || eVar2.hashCode() == eVar.hashCode())) {
                        return;
                    }
                }
            }
            this.e.add(eVar);
        }
    }

    public void b(e eVar) {
        if (eVar == null || this.e.size() <= 0) {
            return;
        }
        this.e.remove(eVar);
    }

    public String toString() {
        return "DownloadData{url='" + this.d + "', md5='" + this.f25973c + "', appName='" + this.f25972a + "', pkgName='" + this.b + "'}";
    }
}
