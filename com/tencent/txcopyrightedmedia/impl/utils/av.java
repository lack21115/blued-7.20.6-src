package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/av.class */
public final class av {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f26383a = new ArrayList();
    public final List<a> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Object f26384c = new Object();
    private final int d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/av$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26385a;
        public final byte[] b;

        /* renamed from: c  reason: collision with root package name */
        public int f26386c;

        private a(int i) {
            this.b = new byte[i];
        }

        /* synthetic */ a(int i, byte b) {
            this(i);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return TextUtils.equals(((a) obj).f26385a, this.f26385a);
            }
            return false;
        }
    }

    public av(int i) {
        this.d = i;
    }

    public final a a() {
        a remove;
        synchronized (this.f26384c) {
            remove = this.f26383a.size() > 0 ? this.f26383a.remove(0) : new a(this.d, (byte) 0);
            remove.f26385a = String.valueOf(aj.c());
        }
        return remove;
    }

    public final a a(String str) {
        synchronized (this.f26384c) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    return null;
                }
                a aVar = this.b.get(i2);
                if (TextUtils.equals(aVar.f26385a, str)) {
                    int i3 = aVar.f26386c - 1;
                    aVar.f26386c = i3;
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
        synchronized (this.f26384c) {
            if (!this.f26383a.contains(aVar)) {
                this.f26383a.add(aVar);
            }
        }
    }

    public final int b(a aVar) {
        synchronized (this.f26384c) {
            if (this.b.contains(aVar)) {
                return -1;
            }
            this.b.add(aVar);
            return 0;
        }
    }
}
