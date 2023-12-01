package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareResPatchInfo.class */
public class ShareResPatchInfo {
    public String arscBaseCrc = null;
    public String resArscMd5 = null;
    public ArrayList<String> addRes = new ArrayList<>();
    public ArrayList<String> deleteRes = new ArrayList<>();
    public ArrayList<String> modRes = new ArrayList<>();
    public HashMap<String, File> storeRes = new HashMap<>();
    public ArrayList<String> largeModRes = new ArrayList<>();
    public HashMap<String, LargeModeInfo> largeModMap = new HashMap<>();
    public HashSet<Pattern> patterns = new HashSet<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo.class */
    public static class LargeModeInfo {
        public long crc;
        public String md5 = null;
        public File file = null;
    }

    public static boolean checkFileInPattern(HashSet<Pattern> hashSet, String str) {
        if (hashSet.isEmpty()) {
            return false;
        }
        Iterator<Pattern> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkResPatchInfo(ShareResPatchInfo shareResPatchInfo) {
        String str;
        return (shareResPatchInfo == null || (str = shareResPatchInfo.resArscMd5) == null || str.length() != 32) ? false : true;
    }

    private static Pattern convertToPatternString(String str) {
        String str2 = str;
        if (str.contains(".")) {
            str2 = str.replaceAll("\\.", "\\\\.");
        }
        String str3 = str2;
        if (str2.contains("?")) {
            str3 = str2.replaceAll("\\?", "\\.");
        }
        String str4 = str3;
        if (str3.contains("*")) {
            str4 = str3.replace("*", ".*");
        }
        return Pattern.compile(str4);
    }

    public static void parseAllResPatchInfo(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str == null || str.length() == 0) {
            return;
        }
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            String str2 = split[i2];
            int i3 = i2;
            if (str2 != null) {
                if (str2.length() <= 0) {
                    i3 = i2;
                } else if (str2.startsWith(ShareConstants.RES_TITLE)) {
                    String[] split2 = str2.split(",", 3);
                    shareResPatchInfo.arscBaseCrc = split2[1];
                    shareResPatchInfo.resArscMd5 = split2[2];
                    i3 = i2;
                } else if (str2.startsWith(ShareConstants.RES_PATTERN_TITLE)) {
                    int parseInt = Integer.parseInt(str2.split(":", 2)[1]);
                    while (true) {
                        int i4 = parseInt;
                        i3 = i2;
                        if (i4 > 0) {
                            i2++;
                            shareResPatchInfo.patterns.add(convertToPatternString(split[i2]));
                            parseInt = i4 - 1;
                        }
                    }
                } else if (str2.startsWith(ShareConstants.RES_ADD_TITLE)) {
                    int parseInt2 = Integer.parseInt(str2.split(":", 2)[1]);
                    while (true) {
                        int i5 = parseInt2;
                        i3 = i2;
                        if (i5 > 0) {
                            i2++;
                            shareResPatchInfo.addRes.add(split[i2]);
                            parseInt2 = i5 - 1;
                        }
                    }
                } else if (str2.startsWith(ShareConstants.RES_MOD_TITLE)) {
                    int parseInt3 = Integer.parseInt(str2.split(":", 2)[1]);
                    while (true) {
                        int i6 = parseInt3;
                        i3 = i2;
                        if (i6 > 0) {
                            i2++;
                            shareResPatchInfo.modRes.add(split[i2]);
                            parseInt3 = i6 - 1;
                        }
                    }
                } else if (str2.startsWith(ShareConstants.RES_LARGE_MOD_TITLE)) {
                    int parseInt4 = Integer.parseInt(str2.split(":", 2)[1]);
                    while (true) {
                        int i7 = parseInt4;
                        i3 = i2;
                        if (i7 > 0) {
                            i2++;
                            String[] split3 = split[i2].split(",", 3);
                            String str3 = split3[0];
                            LargeModeInfo largeModeInfo = new LargeModeInfo();
                            largeModeInfo.md5 = split3[1];
                            largeModeInfo.crc = Long.parseLong(split3[2]);
                            shareResPatchInfo.largeModRes.add(str3);
                            shareResPatchInfo.largeModMap.put(str3, largeModeInfo);
                            parseInt4 = i7 - 1;
                        }
                    }
                } else if (str2.startsWith(ShareConstants.RES_DEL_TITLE)) {
                    int parseInt5 = Integer.parseInt(str2.split(":", 2)[1]);
                    while (true) {
                        int i8 = parseInt5;
                        i3 = i2;
                        if (i8 > 0) {
                            i2++;
                            shareResPatchInfo.deleteRes.add(split[i2]);
                            parseInt5 = i8 - 1;
                        }
                    }
                } else {
                    i3 = i2;
                    if (str2.startsWith(ShareConstants.RES_STORE_TITLE)) {
                        int parseInt6 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (true) {
                            int i9 = parseInt6;
                            i3 = i2;
                            if (i9 > 0) {
                                i2++;
                                shareResPatchInfo.storeRes.put(split[i2], null);
                                parseInt6 = i9 - 1;
                            }
                        }
                    }
                }
            }
            i = i3 + 1;
        }
    }

    public static void parseResPatchInfoFirstLine(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = str.split("\n")[0];
        if (str2 == null || str2.length() <= 0) {
            throw new TinkerRuntimeException("res meta Corrupted:" + str);
        }
        String[] split = str2.split(",", 3);
        shareResPatchInfo.arscBaseCrc = split[1];
        shareResPatchInfo.resArscMd5 = split[2];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resArscMd5:" + this.resArscMd5 + "\n");
        stringBuffer.append("arscBaseCrc:" + this.arscBaseCrc + "\n");
        Iterator<Pattern> it = this.patterns.iterator();
        while (it.hasNext()) {
            Pattern next = it.next();
            stringBuffer.append(ShareConstants.RES_PATTERN_TITLE + next + "\n");
        }
        Iterator<String> it2 = this.addRes.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            stringBuffer.append("addedSet:" + next2 + "\n");
        }
        Iterator<String> it3 = this.modRes.iterator();
        while (it3.hasNext()) {
            String next3 = it3.next();
            stringBuffer.append("modifiedSet:" + next3 + "\n");
        }
        Iterator<String> it4 = this.largeModRes.iterator();
        while (it4.hasNext()) {
            String next4 = it4.next();
            stringBuffer.append("largeModifiedSet:" + next4 + "\n");
        }
        Iterator<String> it5 = this.deleteRes.iterator();
        while (it5.hasNext()) {
            String next5 = it5.next();
            stringBuffer.append("deletedSet:" + next5 + "\n");
        }
        for (String str : this.storeRes.keySet()) {
            stringBuffer.append("storeSet:" + str + "\n");
        }
        return stringBuffer.toString();
    }
}
