package com.ktv.method.lrc.formats.vtt;

import android.util.Log;
import com.ktv.method.lrc.formats.LyricsFileReader;
import com.ktv.method.lrc.model.LyricsInfo;
import com.ktv.method.lrc.model.LyricsLineInfo;
import com.ktv.method.lrc.model.LyricsTag;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/formats/vtt/VttLyricsFileReader.class */
public class VttLyricsFileReader extends LyricsFileReader {
    private LyricsLineInfo a(Map<String, Object> map, String str, LyricsInfo lyricsInfo) throws Exception {
        if (str.startsWith("[ti:")) {
            map.put(LyricsTag.f23697a, str.substring(4, str.lastIndexOf("]")));
            return null;
        }
        Matcher matcher = Pattern.compile("\\[\\d+,\\d+\\]").matcher(str);
        if (matcher.find()) {
            LyricsLineInfo lyricsLineInfo = new LyricsLineInfo();
            int start = matcher.start();
            int end = matcher.end();
            String[] split = str.substring(start + 1, end - 1).split(",");
            int i = 0;
            int parseInt = Integer.parseInt(split[0]);
            lyricsLineInfo.b(Integer.parseInt(split[1]));
            lyricsLineInfo.a(parseInt);
            String substring = str.substring(end, str.length());
            Matcher matcher2 = Pattern.compile("\\<\\d+,\\d+,\\d+\\>").matcher(substring);
            String[] a2 = a(substring.split("\\<\\d+,\\d+,\\d+\\>"));
            lyricsLineInfo.a(a2);
            int length = a2.length;
            int[] iArr = new int[length];
            while (matcher2.find()) {
                if (i >= length) {
                    throw new Exception("字标签个数与字时间标签个数不相符");
                }
                String group = matcher2.group();
                iArr[i] = Integer.parseInt(group.substring(group.indexOf(60) + 1, group.lastIndexOf(62)).split(",")[1]);
                i++;
            }
            lyricsLineInfo.a(iArr);
            lyricsLineInfo.a(matcher2.replaceAll(""));
            return lyricsLineInfo;
        }
        return null;
    }

    private String[] a(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            return new String[strArr.length];
        }
        String[] strArr2 = new String[strArr.length - 1];
        for (int i = 1; i < strArr.length; i++) {
            strArr2[i - 1] = strArr[i];
        }
        return strArr2;
    }

    private String b(String str) {
        long j;
        Matcher matcher = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})").matcher(str);
        if (matcher.matches()) {
            j = (Long.parseLong(matcher.group(1)) * 3600000) + (Long.parseLong(matcher.group(2)) * 60000) + (Long.parseLong(matcher.group(3)) * 1000) + Long.parseLong(matcher.group(4));
        } else {
            Log.e("VttLyricsFileReader", " date to milliseconds error, inputString: " + str);
            j = -1L;
        }
        return Long.toString(j);
    }

    @Override // com.ktv.method.lrc.formats.LyricsFileReader
    public LyricsInfo a(InputStream inputStream) throws Exception {
        LyricsInfo lyricsInfo = new LyricsInfo();
        lyricsInfo.a(a());
        if (inputStream != null) {
            TreeMap<Integer, LyricsLineInfo> treeMap = new TreeMap<>();
            HashMap hashMap = new HashMap();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2}).(\\d{3})").matcher(readLine).find()) {
                    String[] split = readLine.split(" --> ");
                    String str = "[";
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 2) {
                            break;
                        }
                        String str2 = str + b(split[i3]);
                        str = str2;
                        if (i3 == 0) {
                            str = str2 + ",";
                        }
                        i2 = i3 + 1;
                    }
                    LyricsLineInfo a2 = a(hashMap, str + "]" + bufferedReader.readLine(), lyricsInfo);
                    if (a2 != null) {
                        treeMap.put(Integer.valueOf(i), a2);
                        i++;
                    }
                }
            }
            inputStream.close();
            lyricsInfo.a(hashMap);
            lyricsInfo.a(treeMap);
        }
        return lyricsInfo;
    }

    public String a() {
        return "vtt";
    }

    @Override // com.ktv.method.lrc.formats.LyricsFileReader
    public boolean a(String str) {
        return str.equalsIgnoreCase("vtt");
    }
}
