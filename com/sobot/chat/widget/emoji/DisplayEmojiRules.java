package com.sobot.chat.widget.emoji;

import android.content.Context;
import com.tencent.tinker.android.dex.DexFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/emoji/DisplayEmojiRules.class */
public enum DisplayEmojiRules {
    QQBIAOQING0(DexFormat.MAGIC_SUFFIX, "SMILING FACE WITH OPEN MOUTH"),
    QQBIAOQING1(DexFormat.MAGIC_SUFFIX, "SPACE"),
    QQBIAOQING2(DexFormat.MAGIC_SUFFIX, "SMILING FACE WITH OPEN MOUTH AND SMILING EYES"),
    QQBIAOQING3(DexFormat.MAGIC_SUFFIX, "GRINNING FACE WITH SMILING EYES"),
    QQBIAOQING4(DexFormat.MAGIC_SUFFIX, "SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES"),
    QQBIAOQING6(DexFormat.MAGIC_SUFFIX, "ROLLING ON THE FLOOR LAUGHING"),
    QQBIAOQING8(DexFormat.MAGIC_SUFFIX, "SLIGHTLY SMILING FACE"),
    QQBIAOQING9(DexFormat.MAGIC_SUFFIX, "WINKING FACE"),
    QQBIAOQING10(DexFormat.MAGIC_SUFFIX, "SMILING FACE WITH SMILING EYES"),
    QQBIAOQING11(DexFormat.MAGIC_SUFFIX, "SMILING FACE WITH HALO"),
    QQBIAOQING13(DexFormat.MAGIC_SUFFIX, "GRINNING FACE WITH STAR EYES"),
    QQBIAOQING14(DexFormat.MAGIC_SUFFIX, "FACE THROWING A KISS"),
    QQBIAOQING15(DexFormat.MAGIC_SUFFIX, "KISSING FACE WITH CLOSED EYES"),
    QQBIAOQING16(DexFormat.MAGIC_SUFFIX, "KISSING FACE WITH SMILING EYES"),
    QQBIAOQING17(DexFormat.MAGIC_SUFFIX, "FACE SAVOURING DELICIOUS FOOD"),
    QQBIAOQING18(DexFormat.MAGIC_SUFFIX, "FACE WITH STUCK-OUT TONGUE AND WINKING EYE"),
    QQBIAOQING23(DexFormat.MAGIC_SUFFIX, "ZIPPER-MOUTH FACE"),
    QQBIAOQING24(DexFormat.MAGIC_SUFFIX, "EXPRESSIONLESS FACE"),
    QQBIAOQING25(DexFormat.MAGIC_SUFFIX, "SMIRKING FACE"),
    QQBIAOQING26(DexFormat.MAGIC_SUFFIX, "UNAMUSED FACE"),
    QQBIAOQING27(DexFormat.MAGIC_SUFFIX, "RELIEVED FACE"),
    QQBIAOQING28(DexFormat.MAGIC_SUFFIX, "PENSIVE FACE"),
    QQBIAOQING30(DexFormat.MAGIC_SUFFIX, "FACE WITH THERMOMETER"),
    QQBIAOQING32(DexFormat.MAGIC_SUFFIX, "FACE WITH COWBOY HAT"),
    QQBIAOQING34(DexFormat.MAGIC_SUFFIX, "NERD FACE"),
    QQBIAOQING35(DexFormat.MAGIC_SUFFIX, "FLUSHED FACE"),
    QQBIAOQING36(DexFormat.MAGIC_SUFFIX, "FACE WITH OPEN MOUTH AND COLD SWEAT"),
    QQBIAOQING37(DexFormat.MAGIC_SUFFIX, "DISAPPOINTED BUT RELIEVED FACE"),
    QQBIAOQING38(DexFormat.MAGIC_SUFFIX, "CRYING FACE"),
    QQBIAOQING39(DexFormat.MAGIC_SUFFIX, "LOUDLY CRYING FACE"),
    QQBIAOQING40(DexFormat.MAGIC_SUFFIX, "FACE SCREAMING IN FEAR"),
    QQBIAOQING41(DexFormat.MAGIC_SUFFIX, "CONFOUNDED FACE"),
    QQBIAOQING42(DexFormat.MAGIC_SUFFIX, "PERSEVERING FACE"),
    QQBIAOQING43(DexFormat.MAGIC_SUFFIX, "FACE WITH COLD SWEAT"),
    QQBIAOQING44(DexFormat.MAGIC_SUFFIX, "ANGRY FACE"),
    QQBIAOQING45(DexFormat.MAGIC_SUFFIX, "WAVING HAND SIGN"),
    QQBIAOQING46(DexFormat.MAGIC_SUFFIX, "OK HAND SIGN"),
    QQBIAOQING47("✌", "VICTORY HAND"),
    QQBIAOQING49(DexFormat.MAGIC_SUFFIX, "THUMBS UP SIGN"),
    QQBIAOQING50(DexFormat.MAGIC_SUFFIX, "CLAPPING HANDS SIGN"),
    QQBIAOQING52(DexFormat.MAGIC_SUFFIX, "PERSON WITH FOLDED HANDS"),
    QQBIAOQING53(DexFormat.MAGIC_SUFFIX, "FLEXED BICEPS"),
    QQBIAOQING54(DexFormat.MAGIC_SUFFIX, "PERSON BOWING DEEPLY"),
    QQBIAOQING55(DexFormat.MAGIC_SUFFIX, "COW FACE"),
    QQBIAOQING56(DexFormat.MAGIC_SUFFIX, "ROSE"),
    QQBIAOQING58(DexFormat.MAGIC_SUFFIX, "KISS MARK"),
    QQBIAOQING59("❤️", "HEAVY BLACK HEART"),
    QQBIAOQING60(DexFormat.MAGIC_SUFFIX, "BROKEN HEART"),
    QQBIAOQING61("⭐", "WHITE MEDIUM STAR"),
    QQBIAOQING62(DexFormat.MAGIC_SUFFIX, "PARTY POPPER"),
    QQBIAOQING63(DexFormat.MAGIC_SUFFIX, "BEER MUG"),
    QQBIAOQING64(DexFormat.MAGIC_SUFFIX, "WRAPPED PRESENT");
    
    private static Map<String, String> sEmojiMap;
    private String emojiCode;
    private String emojiDes;

    DisplayEmojiRules(String str, String str2) {
        this.emojiDes = str2;
        this.emojiCode = str;
    }

    public static ArrayList<EmojiconNew> getListAll(Context context) {
        ArrayList<EmojiconNew> arrayList = new ArrayList<>();
        DisplayEmojiRules[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            DisplayEmojiRules displayEmojiRules = values[i2];
            arrayList.add(new EmojiconNew(displayEmojiRules.getEmojiCode(), displayEmojiRules.getEmojiDes()));
            i = i2 + 1;
        }
    }

    public static Map<String, String> getMapAll(Context context) {
        if (sEmojiMap == null) {
            sEmojiMap = new HashMap();
            DisplayEmojiRules[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                DisplayEmojiRules displayEmojiRules = values[i2];
                sEmojiMap.put(displayEmojiRules.getEmojiCode(), displayEmojiRules.getEmojiDes());
                i = i2 + 1;
            }
        }
        return sEmojiMap;
    }

    public String getEmojiCode() {
        return this.emojiCode;
    }

    public String getEmojiDes() {
        return this.emojiDes;
    }

    public void setEmojiCode(String str) {
        this.emojiCode = str;
    }

    public void setEmojiDes(String str) {
        this.emojiDes = str;
    }
}
