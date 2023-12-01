package com.sobot.chat.widget.kpswitch.view;

import android.content.Context;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/CustomeViewFactory.class */
public class CustomeViewFactory {
    public static BaseChattingPanelView getInstance(Context context, int i) {
        LogUtils.i("BaseChattingPanelView");
        if (i != 0) {
            if (i == ResourceUtils.getIdByName(context, "id", "sobot_btn_upload_view")) {
                return new ChattingPanelUploadView(context);
            }
            if (i == ResourceUtils.getIdByName(context, "id", "sobot_btn_emoticon_view")) {
                return new ChattingPanelEmoticonView(context);
            }
            return null;
        }
        return null;
    }

    public static String getInstanceTag(Context context, int i) {
        if (i != 0) {
            if (i == ResourceUtils.getIdByName(context, "id", "sobot_btn_upload_view")) {
                return "ChattingPanelUploadView";
            }
            if (i == ResourceUtils.getIdByName(context, "id", "sobot_btn_emoticon_view")) {
                return "ChattingPanelEmoticonView";
            }
            return null;
        }
        return null;
    }
}
