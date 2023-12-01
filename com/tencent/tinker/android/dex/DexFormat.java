package com.tencent.tinker.android.dex;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/DexFormat.class */
public final class DexFormat {
    public static final int API_CURRENT = 14;
    public static final int API_NO_EXTENDED_OPCODES = 13;
    public static final String DEX_IN_JAR_NAME = "classes.dex";
    public static final int ENDIAN_TAG = 305419896;
    public static final String MAGIC_PREFIX = "dex\n";
    public static final String MAGIC_SUFFIX = "��";
    public static final int MAX_MEMBER_IDX = 65535;
    public static final int MAX_TYPE_IDX = 65535;
    public static final String VERSION_CURRENT = "036";
    public static final String VERSION_FOR_API_13 = "035";

    private DexFormat() {
    }

    public static String apiToMagic(int i) {
        String str = i >= 14 ? "036" : "035";
        return "dex\n" + str + "��";
    }

    public static int magicToApi(byte[] bArr) {
        if (bArr.length == 8 && bArr[0] == 100 && bArr[1] == 101 && bArr[2] == 120 && bArr[3] == 10 && bArr[7] == 0) {
            String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
            if (str.equals("036")) {
                return 14;
            }
            return str.equals("035") ? 13 : -1;
        }
        return -1;
    }
}
