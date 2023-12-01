package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ao;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/d.class */
public final class d {
    private static final Pattern any = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern anz = Pattern.compile("GET /(.*) HTTP");
    public final long anA;
    public final boolean anB;
    public final String uri;

    private d(String str) {
        ao.eK(str);
        long cQ = cQ(str);
        this.anA = Math.max(0L, cQ);
        this.anB = cQ >= 0;
        this.uri = cR(str);
    }

    public static d b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private static long cQ(String str) {
        Matcher matcher = any.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String cR(String str) {
        Matcher matcher = anz.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.anA + ", partial=" + this.anB + ", uri='" + this.uri + "'}";
    }
}
