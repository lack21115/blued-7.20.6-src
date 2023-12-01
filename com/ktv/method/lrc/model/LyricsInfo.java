package com.ktv.method.lrc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/model/LyricsInfo.class */
public class LyricsInfo {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private TreeMap<Integer, LyricsLineInfo> f23694c;

    /* renamed from: a  reason: collision with root package name */
    private int f23693a = 1;
    private Map<String, Object> d = new HashMap();

    public Map<String, Object> a() {
        return this.d;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map<String, Object> map) {
        this.d = map;
    }

    public void a(TreeMap<Integer, LyricsLineInfo> treeMap) {
        this.f23694c = treeMap;
    }

    public TreeMap<Integer, LyricsLineInfo> b() {
        return this.f23694c;
    }

    public int c() {
        return this.f23693a;
    }
}
