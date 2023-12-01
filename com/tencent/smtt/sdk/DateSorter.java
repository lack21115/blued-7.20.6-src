package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/DateSorter.class */
public class DateSorter {
    public static int DAY_COUNT;

    /* renamed from: a  reason: collision with root package name */
    private android.webkit.DateSorter f38700a;
    private IX5DateSorter b;

    static {
        a();
        DAY_COUNT = 5;
    }

    public DateSorter(Context context) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            this.f38700a = new android.webkit.DateSorter(context);
        } else {
            this.b = a2.c().h(context);
        }
    }

    private static boolean a() {
        w a2 = w.a();
        return a2 != null && a2.b();
    }

    public long getBoundary(int i) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? this.f38700a.getBoundary(i) : this.b.getBoundary(i);
    }

    public int getIndex(long j) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? this.f38700a.getIndex(j) : this.b.getIndex(j);
    }

    public String getLabel(int i) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? this.f38700a.getLabel(i) : this.b.getLabel(i);
    }
}
