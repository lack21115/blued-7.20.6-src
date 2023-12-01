package com.tencent.tmsbeacon.a.d;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f39484a;

    static {
        ArrayList arrayList = new ArrayList();
        f39484a = arrayList;
        arrayList.add("CREATE TABLE t_r_e ( _id INTEGER PRIMARY KEY AUTOINCREMENT, _appKey text ,_time int ,_length int ,_data  blob)");
        arrayList.add("CREATE TABLE t_n_e ( _id INTEGER PRIMARY KEY AUTOINCREMENT, _appKey text ,_time int ,_length int ,_data  blob)");
    }
}
