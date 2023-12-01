package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/g.class */
public class g {
    private static g a = new g();

    /* renamed from: a  reason: collision with other field name */
    private b f35a = new b();

    /* renamed from: a  reason: collision with other field name */
    private a f34a = new a();

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/g$a.class */
    class a implements Comparator<String> {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/g$b.class */
    class b implements Comparator<String> {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private g() {
    }

    public static g a() {
        return a;
    }

    public String[] a(String[] strArr, boolean z) {
        Comparator comparator = z ? this.f34a : this.f35a;
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
