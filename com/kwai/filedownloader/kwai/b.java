package com.kwai.filedownloader.kwai;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/kwai/b.class */
public interface b {
    Map<String, List<String>> V();

    Map<String, List<String>> W();

    void X();

    void addHeader(String str, String str2);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    String o(String str);
}
