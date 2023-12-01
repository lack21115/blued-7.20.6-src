package com.heytap.mcssdk.parser;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/parser/MessageParser.class */
public abstract class MessageParser implements Parser {
    public static List<BaseMode> getMessageList(Context context, Intent intent) {
        BaseMode parse;
        if (intent == null) {
            return null;
        }
        int i = 4096;
        try {
            i = Integer.parseInt(CryptoUtil.sdkDecrypt(intent.getStringExtra("type")));
        } catch (Exception e) {
            LogUtil.e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
        }
        LogUtil.d("MessageParser--getMessageByIntent--type:".concat(String.valueOf(i)));
        ArrayList arrayList = new ArrayList();
        for (Parser parser : PushService.getInstance().getParsers()) {
            if (parser != null && (parse = parser.parse(context, i, intent)) != null) {
                arrayList.add(parse);
            }
        }
        return arrayList;
    }

    protected abstract BaseMode parseMessageByIntent(Intent intent, int i);
}
