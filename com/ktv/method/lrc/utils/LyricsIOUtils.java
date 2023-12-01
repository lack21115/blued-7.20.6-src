package com.ktv.method.lrc.utils;

import com.ktv.method.lrc.formats.LyricsFileReader;
import com.ktv.method.lrc.formats.vtt.VttLyricsFileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/utils/LyricsIOUtils.class */
public class LyricsIOUtils {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<LyricsFileReader> f10091a;

    static {
        ArrayList<LyricsFileReader> arrayList = new ArrayList<>();
        f10091a = arrayList;
        arrayList.add(new VttLyricsFileReader());
    }

    public static LyricsFileReader a(File file) {
        return a(file.getName());
    }

    public static LyricsFileReader a(String str) {
        String a2 = Utils.a(str);
        Iterator<LyricsFileReader> it = f10091a.iterator();
        while (it.hasNext()) {
            LyricsFileReader next = it.next();
            if (next.a(a2)) {
                return next;
            }
        }
        return null;
    }
}
