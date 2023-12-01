package com.sobot.chat.widget.emoji;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/emoji/DisplayEmojiRules.class */
public enum DisplayEmojiRules {
    QQBIAOQING0("��", "SMILING FACE WITH OPEN MOUTH"),
    QQBIAOQING1("��", "SPACE"),
    QQBIAOQING2("��", "SMILING FACE WITH OPEN MOUTH AND SMILING EYES"),
    QQBIAOQING3("��", "GRINNING FACE WITH SMILING EYES"),
    QQBIAOQING4("��", "SMILING FACE WITH OPEN MOUTH AND TIGHTLY-CLOSED EYES"),
    QQBIAOQING6("��", "ROLLING ON THE FLOOR LAUGHING"),
    QQBIAOQING8("��", "SLIGHTLY SMILING FACE"),
    QQBIAOQING9("��", "WINKING FACE"),
    QQBIAOQING10("��", "SMILING FACE WITH SMILING EYES"),
    QQBIAOQING11("��", "SMILING FACE WITH HALO"),
    QQBIAOQING13("��", "GRINNING FACE WITH STAR EYES"),
    QQBIAOQING14("��", "FACE THROWING A KISS"),
    QQBIAOQING15("��", "KISSING FACE WITH CLOSED EYES"),
    QQBIAOQING16("��", "KISSING FACE WITH SMILING EYES"),
    QQBIAOQING17("��", "FACE SAVOURING DELICIOUS FOOD"),
    QQBIAOQING18("��", "FACE WITH STUCK-OUT TONGUE AND WINKING EYE"),
    QQBIAOQING23("��", "ZIPPER-MOUTH FACE"),
    QQBIAOQING24("��", "EXPRESSIONLESS FACE"),
    QQBIAOQING25("��", "SMIRKING FACE"),
    QQBIAOQING26("��", "UNAMUSED FACE"),
    QQBIAOQING27("��", "RELIEVED FACE"),
    QQBIAOQING28("��", "PENSIVE FACE"),
    QQBIAOQING30("��", "FACE WITH THERMOMETER"),
    QQBIAOQING32("��", "FACE WITH COWBOY HAT"),
    QQBIAOQING34("��", "NERD FACE"),
    QQBIAOQING35("��", "FLUSHED FACE"),
    QQBIAOQING36("��", "FACE WITH OPEN MOUTH AND COLD SWEAT"),
    QQBIAOQING37("��", "DISAPPOINTED BUT RELIEVED FACE"),
    QQBIAOQING38("��", "CRYING FACE"),
    QQBIAOQING39("��", "LOUDLY CRYING FACE"),
    QQBIAOQING40("��", "FACE SCREAMING IN FEAR"),
    QQBIAOQING41("��", "CONFOUNDED FACE"),
    QQBIAOQING42("��", "PERSEVERING FACE"),
    QQBIAOQING43("��", "FACE WITH COLD SWEAT"),
    QQBIAOQING44("��", "ANGRY FACE"),
    QQBIAOQING45("��", "WAVING HAND SIGN"),
    QQBIAOQING46("��", "OK HAND SIGN"),
    QQBIAOQING47("✌", "VICTORY HAND"),
    QQBIAOQING49("��", "THUMBS UP SIGN"),
    QQBIAOQING50("��", "CLAPPING HANDS SIGN"),
    QQBIAOQING52("��", "PERSON WITH FOLDED HANDS"),
    QQBIAOQING53("��", "FLEXED BICEPS"),
    QQBIAOQING54("��", "PERSON BOWING DEEPLY"),
    QQBIAOQING55("��", "COW FACE"),
    QQBIAOQING56("��", "ROSE"),
    QQBIAOQING58("��", "KISS MARK"),
    QQBIAOQING59("❤️", "HEAVY BLACK HEART"),
    QQBIAOQING60("��", "BROKEN HEART"),
    QQBIAOQING61("⭐", "WHITE MEDIUM STAR"),
    QQBIAOQING62("��", "PARTY POPPER"),
    QQBIAOQING63("��", "BEER MUG"),
    QQBIAOQING64("��", "WRAPPED PRESENT");
    
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
