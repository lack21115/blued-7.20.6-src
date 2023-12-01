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
    private long f23690a = 0;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f23691c = 1;
    private String d;
    private TreeMap<Integer, LyricsLineInfo> e;
    private LyricsInfo f;

    private void a(LyricsInfo lyricsInfo) {
        this.f = lyricsInfo;
        this.f23691c = lyricsInfo.c();
        Map<String, Object> a2 = lyricsInfo.a();
        if (a2.containsKey(LyricsTag.f23698c)) {
            this.f23690a = 0L;
            try {
                this.f23690a = Long.parseLong((String) a2.get(LyricsTag.f23698c));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.f23690a = 0L;
        }
        this.e = lyricsInfo.b();
    }

    public int a() {
        return this.f23691c;
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
        return this.f23690a + this.b;
    }
}
