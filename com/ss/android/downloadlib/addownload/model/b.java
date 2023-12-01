package com.ss.android.downloadlib.addownload.model;

import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/b.class */
public class b {
    public static int b = 2;
    public static int mb = 0;
    public static int ox = 1;
    private int hj = mb;
    private long h = 0;
    private JSONObject u = null;
    private int ko = 0;
    private String ww = "";
    private String lz = "";

    public b mb(int i) {
        this.hj = i;
        return this;
    }

    public boolean mb() {
        return this.hj == ox;
    }

    public int ox() {
        return this.ko;
    }

    public b ox(int i) {
        this.ko = i;
        return this;
    }
}
