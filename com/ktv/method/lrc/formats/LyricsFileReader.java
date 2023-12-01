package com.ktv.method.lrc.formats;

import com.ktv.method.lrc.model.LyricsInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/formats/LyricsFileReader.class */
public abstract class LyricsFileReader {

    /* renamed from: a  reason: collision with root package name */
    private Charset f10084a = Charset.forName("utf-8");

    public LyricsInfo a(File file) throws Exception {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        return null;
    }

    public abstract LyricsInfo a(InputStream inputStream) throws Exception;

    public abstract boolean a(String str);
}
