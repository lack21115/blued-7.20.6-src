package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/av.class */
public final class av {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f40074a = new ArrayList();
    public final List<a> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Object f40075c = new Object();
    private final int d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/av$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f40076a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public int f40077c;

        private a(int i) {
            this.b = new byte[i];
        }

        /* synthetic */ a(int i, byte b) {
            this(i);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return TextUtils.equals(((a) obj).f40076a, this.f40076a);
            }
            return false;
        }
    }

    public av(int i) {
        this.d = i;
    }

    public final a a() {
        a remove;
        synchronized (this.f40075c) {
            remove = this.f40074a.size() > 0 ? this.f40074a.remove(0) : new a(this.d, (byte) 0);
            remove.f40076a = String.valueOf(aj.c());
        }
        return remove;
    }

    public final a a(String str) {
        synchronized (this.f40075c) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    return null;
                }
                a aVar = this.b.get(i2);
                if (TextUtils.equals(aVar.f40076a, str)) {
                    int i3 = aVar.f40077c - 1;
                    aVar.f40077c = i3;
                    if (i3 <= 0) {
                        this.b.remove(i2);
                    }
                    return aVar;
                }
                i = i2 + 1;
            }
        }
    }

    public final void a(a aVar) {
        synchronized (this.f40075c) {
            if (!this.f40074a.contains(aVar)) {
                this.f40074a.add(aVar);
            }
        }
    }

    public final int b(a aVar) {
        synchronized (this.f40075c) {
            if (this.b.contains(aVar)) {
                return -1;
            }
            this.b.add(aVar);
            return 0;
        }
    }
}
