package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.oplus.quickgame.sdk.hall.Constant;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/i.class */
public enum i {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC(Constant.Param.TOPIC, 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);
    
    String j;
    int k;

    i(String str, int i) {
        this.j = str;
        this.k = i;
    }

    public static i b(String str) {
        i[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            i iVar = values[i2];
            if (iVar != null && TextUtils.isEmpty(iVar.j) && iVar.j.equals(str)) {
                return iVar;
            }
            i = i2 + 1;
        }
    }

    public String b() {
        return this.j;
    }

    public int c() {
        return this.k;
    }
}
