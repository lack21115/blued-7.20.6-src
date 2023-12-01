package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nb.class */
public class nb {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f23971a = new ArrayList();
    private List<String> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final int f23972c = 300;

    private void a(List<String> list) {
        if (list != null && list.size() > 300) {
            list.remove(0);
        }
    }

    public void a() {
        synchronized (this) {
            this.f23971a.clear();
            this.b.clear();
        }
    }

    public void a(String str) {
        synchronized (this) {
            if (str != null) {
                if (str.trim().length() != 0) {
                    if (this.b.contains(str)) {
                        this.b.remove(str);
                        this.b.add(str);
                        return;
                    }
                    if (this.f23971a.contains(str)) {
                        a(this.b);
                        this.b.add(str);
                        this.f23971a.remove(str);
                    } else {
                        a(this.f23971a);
                        this.f23971a.add(str);
                    }
                }
            }
        }
    }

    public boolean b(String str) {
        synchronized (this) {
            if (str != null) {
                if (str.trim().length() != 0) {
                    return !this.b.contains(str);
                }
            }
            return false;
        }
    }
}
