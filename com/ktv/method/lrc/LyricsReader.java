package com.ktv.method.lrc;

import com.ktv.method.lrc.model.LyricsInfo;
import com.ktv.method.lrc.model.LyricsLineInfo;
import com.ktv.method.lrc.model.LyricsTag;
import com.ktv.method.lrc.utils.LyricsIOUtils;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/LyricsReader.class */
public class LyricsReader {

    /* renamed from: a  reason: collision with root package name */
    private long f10082a = 0;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f10083c = 1;
    private String d;
    private TreeMap<Integer, LyricsLineInfo> e;
    private LyricsInfo f;

    private void a(LyricsInfo lyricsInfo) {
        this.f = lyricsInfo;
        this.f10083c = lyricsInfo.c();
        Map<String, Object> a2 = lyricsInfo.a();
        if (a2.containsKey(LyricsTag.f10090c)) {
            this.f10082a = 0L;
            try {
                this.f10082a = Long.parseLong((String) a2.get(LyricsTag.f10090c));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.f10082a = 0L;
        }
        this.e = lyricsInfo.b();
    }

    public int a() {
        return this.f10083c;
    }

    public void a(File file) throws Exception {
        if (!file.exists() || file.length() == 0) {
            return;
        }
        this.d = file.getPath();
        a(LyricsIOUtils.a(file).a(file));
    }

    public TreeMap<Integer, LyricsLineInfo> b() {
        return this.e;
    }

    public long c() {
        return this.f10082a + this.b;
    }
}
