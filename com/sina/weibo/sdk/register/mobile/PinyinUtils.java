package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import com.anythink.expressad.d.a.b;
import com.anythink.expressad.video.dynview.a.a;
import com.kuaishou.weapon.p0.bh;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.umeng.analytics.pro.d;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/PinyinUtils.class */
public class PinyinUtils {
    private static final int DISTINGUISH_LEN = 10;
    private static final char FIRST_CHINA = 19968;
    private static final char LAST_CHINA = 40869;
    private static final String[] PINYIN = {"a", b.cZ, "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", com.igexin.push.core.b.Y, "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", Segment.JsonKey.CURRENT, "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", a.X, "deng", AppIconSetting.DEFAULT_LARGE_ICON, "dia", "dian", "diao", "die", "ding", "diu", "dong", "dou", d.W, "duan", "dui", "dun", "duo", "e", NotificationStyle.EXPANDABLE_IMAGE_URL, "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", AppIconSetting.LARGE_ICON_URL, "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "none", "nong", "nou", "nu", "nuan", "nuo", "nv", "nve", "o", "ou", "pa", "pai", TextToSpeech.Engine.KEY_PARAM_PAN, "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", a.ab, "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", bh.y, "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"};
    private static final char SPECIAL_HANZI = 12295;
    private static final String SPECIAL_HANZI_PINYIN = "LING";
    private static volatile boolean isLoad = false;
    private static PinyinUtils sInstance;
    private static short[] sPinyinIndex;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/PinyinUtils$MatchedResult.class */
    public static class MatchedResult {
        public int start = -1;
        public int end = -1;
    }

    private PinyinUtils() {
    }

    private boolean distinguish(char[] cArr, char[] cArr2, String[] strArr, int i) {
        String str = new String(cArr);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int indexOf = str.indexOf(strArr[i3].charAt(0), i2);
            int i4 = indexOf;
            if (indexOf == -1) {
                i4 = str.indexOf(cArr2[i3], indexOf);
            }
            if (i4 == -1) {
                return false;
            }
            i2 = i4 + 1;
        }
        return true;
    }

    public static PinyinUtils getInstance(Context context) {
        PinyinUtils pinyinUtils;
        synchronized (PinyinUtils.class) {
            try {
                if (sInstance == null) {
                    sInstance = new PinyinUtils();
                }
                loadData(context);
                pinyinUtils = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pinyinUtils;
    }

    public static PinyinUtils getObject() {
        return sInstance;
    }

    private String getPinyin(char c2) {
        if (isLoad) {
            if (c2 == 12295) {
                return SPECIAL_HANZI_PINYIN;
            }
            if (c2 < FIRST_CHINA || c2 > LAST_CHINA) {
                return String.valueOf(c2);
            }
            String str = PINYIN[sPinyinIndex[c2 - FIRST_CHINA]];
            return str == null ? "" : str;
        }
        return "";
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b8: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:46:0x00b8 */
    private static void loadData(Context context) {
        DataInputStream dataInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        try {
            try {
                try {
                } catch (IOException e) {
                    inputStream = null;
                    dataInputStream = null;
                } catch (Exception e2) {
                    inputStream = null;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = null;
                    inputStream = null;
                }
                if (isLoad) {
                    return;
                }
                inputStream = context.getAssets().open("pinyinindex");
                try {
                    dataInputStream = new DataInputStream(inputStream);
                    try {
                        sPinyinIndex = new short[dataInputStream.available() >> 1];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= sPinyinIndex.length) {
                                break;
                            }
                            sPinyinIndex[i2] = dataInputStream.readShort();
                            i = i2 + 1;
                        }
                        isLoad = true;
                        dataInputStream.close();
                        if (inputStream == null) {
                            return;
                        }
                    } catch (IOException e3) {
                        isLoad = false;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        if (inputStream == null) {
                            return;
                        }
                        inputStream.close();
                    } catch (Exception e4) {
                        isLoad = false;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        if (inputStream == null) {
                            return;
                        }
                        inputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e5) {
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    dataInputStream = null;
                } catch (Exception e7) {
                    dataInputStream = null;
                }
                inputStream.close();
            } catch (Throwable th3) {
                inputStream = inputStream2;
                dataInputStream = null;
                th = th3;
            }
        } catch (IOException e8) {
        }
    }

    private char[] subCharRangeArray(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[(i2 - i) + 1];
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 > i2) {
                return cArr2;
            }
            cArr2[i5] = cArr[i3];
            i3++;
            i4 = i5 + 1;
        }
    }

    private String[] subStringRangeArray(String[] strArr, int i, int i2) {
        String[] strArr2 = new String[(i2 - i) + 1];
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 > i2) {
                return strArr2;
            }
            strArr2[i5] = strArr[i3];
            i3++;
            i4 = i5 + 1;
        }
    }

    public int distinguish(char[] cArr, int i, char[] cArr2, String[] strArr, int i2, int i3) {
        if (i == 0 && (cArr[0] == cArr2[0] || cArr[0] == strArr[0].charAt(0))) {
            if (cArr.length != 1) {
                return distinguish(cArr, 1, cArr2, strArr, 0, 1);
            }
            return 0;
        } else if (strArr[i2].length() > i3 && i < cArr.length && (cArr[i] == cArr2[i2] || cArr[i] == strArr[i2].charAt(i3))) {
            if (i == cArr.length - 1) {
                if (distinguish(cArr, cArr2, strArr, i2)) {
                    return i2;
                }
                return -1;
            }
            return distinguish(cArr, i + 1, cArr2, strArr, i2, i3 + 1);
        } else {
            int i4 = i2 + 1;
            if (strArr.length > i4 && i < cArr.length && (cArr[i] == cArr2[i4] || cArr[i] == strArr[i4].charAt(0))) {
                if (i == cArr.length - 1) {
                    if (distinguish(cArr, cArr2, strArr, i2)) {
                        return i4;
                    }
                    return -1;
                }
                return distinguish(cArr, 1 + i, cArr2, strArr, i4, 1);
            } else if (strArr.length <= i4) {
                return -1;
            } else {
                int i5 = 1;
                while (true) {
                    int i6 = i5;
                    if (i6 >= i) {
                        return -1;
                    }
                    if (distinguish(cArr, i - i6, cArr2, strArr, i4, 0) != -1) {
                        return i4;
                    }
                    i5 = i6 + 1;
                }
            }
        }
    }

    public MatchedResult getMatchedResult(String str, String str2) {
        int distinguish;
        MatchedResult matchedResult = new MatchedResult();
        matchedResult.start = -1;
        matchedResult.end = -1;
        if (isLoad && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String upperCase = str.toUpperCase();
            String upperCase2 = str2.toUpperCase();
            String str3 = upperCase;
            String str4 = upperCase2;
            if (Math.min(upperCase.length(), upperCase2.length()) > 10) {
                str3 = upperCase.substring(0, 10);
                str4 = upperCase2.substring(0, 10);
            }
            int indexOf = str3.indexOf(str4);
            if (indexOf >= 0) {
                matchedResult.start = indexOf;
                matchedResult.end = (indexOf + str4.length()) - 1;
            }
            char[] cArr = new char[str4.length()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str4.length()) {
                    break;
                }
                cArr[i2] = str4.charAt(i2);
                i = i2 + 1;
            }
            int length = str3.length();
            char[] cArr2 = new char[length];
            int length2 = str3.length();
            String[] strArr = new String[length2];
            int length3 = str3.length();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length3) {
                    break;
                }
                char charAt = str3.charAt(i4);
                cArr2[i4] = charAt;
                String pinyin = getPinyin(charAt);
                if (TextUtils.isEmpty(pinyin)) {
                    strArr[i4] = new StringBuilder(String.valueOf(charAt)).toString();
                } else {
                    strArr[i4] = pinyin.toUpperCase();
                }
                i3 = i4 + 1;
            }
            char c2 = cArr[0];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length2) {
                    return matchedResult;
                }
                char charAt2 = strArr[i6].charAt(0);
                char c3 = cArr2[i6];
                if ((charAt2 == c2 || c3 == c2) && (distinguish = distinguish(cArr, 0, subCharRangeArray(cArr2, i6, length - 1), subStringRangeArray(strArr, i6, length2 - 1), 0, 0)) != -1) {
                    matchedResult.start = i6;
                    matchedResult.end = i6 + distinguish;
                    return matchedResult;
                }
                i5 = i6 + 1;
            }
        }
        return matchedResult;
    }

    public String getPinyin(String str) {
        if (TextUtils.isEmpty(str) || !isLoad) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            sb.append(getPinyin(str.charAt(i2)));
            i = i2 + 1;
        }
    }
}
