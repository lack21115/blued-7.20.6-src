package com.ss.android.downloadlib.addownload.model;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/ox.class */
public class ox {
    public String b;
    public String h;
    public String hj;
    public String ko;
    public String lz;
    public long mb;
    public long ox;
    public String u;
    public final List<Pair<String, String>> ww = new ArrayList();

    public static long mb(long j, long j2) {
        return j > 0 ? j : j2;
    }

    public long mb() {
        return mb(this.mb, this.ox);
    }
}
