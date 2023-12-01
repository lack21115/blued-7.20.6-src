package com.blued.android.chat.utils;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/AtRegExpUtils.class */
public class AtRegExpUtils {
    public static final String AT_USERNAME_PATTERN2 = "@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)";
    public static final String NOT_NAME_PUNCTUATION = "`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？";

    public static boolean isAtSelf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(ChatManager.userInfo.encryUid) || str.contains(MsgType.UID_GROUP_AT_ALL);
    }

    public static String parseMessageAt(String str) {
        StringBuffer stringBuffer;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile(AT_USERNAME_PATTERN2).matcher(str);
        StringBuffer stringBuffer2 = null;
        while (true) {
            stringBuffer = stringBuffer2;
            if (!matcher.find()) {
                break;
            }
            StringBuffer stringBuffer3 = stringBuffer;
            if (stringBuffer == null) {
                stringBuffer3 = new StringBuffer();
            }
            stringBuffer3.append(matcher.group(2));
            stringBuffer3.append(";");
            stringBuffer2 = stringBuffer3;
        }
        if (stringBuffer == null || stringBuffer.length() <= 1) {
            return null;
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }
}
