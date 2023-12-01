package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareBsDiffPatchInfo.class */
public class ShareBsDiffPatchInfo {
    public String md5;
    public String name;
    public String patchMd5;
    public String path;
    public String rawCrc;

    public ShareBsDiffPatchInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.md5 = str2;
        this.rawCrc = str4;
        this.patchMd5 = str5;
        this.path = str3;
    }

    public static boolean checkDiffPatchInfo(ShareBsDiffPatchInfo shareBsDiffPatchInfo) {
        if (shareBsDiffPatchInfo == null) {
            return false;
        }
        String str = shareBsDiffPatchInfo.name;
        String str2 = shareBsDiffPatchInfo.md5;
        return str != null && str.length() > 0 && str2 != null && str2.length() == 32;
    }

    public static void parseDiffPatchInfo(String str, ArrayList<ShareBsDiffPatchInfo> arrayList) {
        String[] split;
        if (str == null || str.length() == 0) {
            return;
        }
        String[] split2 = str.split("\n");
        int length = split2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = split2[i2];
            if (str2 != null && str2.length() > 0 && (split = str2.split(",", 5)) != null && split.length >= 5) {
                arrayList.add(new ShareBsDiffPatchInfo(split[0].trim(), split[2].trim(), split[1].trim(), split[3].trim(), split[4].trim()));
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.md5);
        stringBuffer.append(",");
        stringBuffer.append(this.rawCrc);
        stringBuffer.append(",");
        stringBuffer.append(this.patchMd5);
        return stringBuffer.toString();
    }
}
