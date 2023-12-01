package com.sobot.chat.utils;

import com.sobot.chat.api.model.SobotMsgCenterModel;
import java.util.Comparator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotCompareNewMsgTime.class */
public class SobotCompareNewMsgTime implements Comparator<SobotMsgCenterModel> {
    private int compareNewMsgTime(SobotMsgCenterModel sobotMsgCenterModel, SobotMsgCenterModel sobotMsgCenterModel2) {
        int i = ((getFormatTS(sobotMsgCenterModel2) - getFormatTS(sobotMsgCenterModel)) > 0L ? 1 : ((getFormatTS(sobotMsgCenterModel2) - getFormatTS(sobotMsgCenterModel)) == 0L ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }

    private long getFormatTS(SobotMsgCenterModel sobotMsgCenterModel) {
        long j = 0;
        if (sobotMsgCenterModel != null) {
            if (sobotMsgCenterModel.getLastDateTime() == null) {
                return 0L;
            }
            try {
                j = Long.parseLong(sobotMsgCenterModel.getLastDateTime());
            } catch (Exception e) {
                return 0L;
            }
        }
        return j;
    }

    @Override // java.util.Comparator
    public int compare(SobotMsgCenterModel sobotMsgCenterModel, SobotMsgCenterModel sobotMsgCenterModel2) {
        return compareNewMsgTime(sobotMsgCenterModel, sobotMsgCenterModel2);
    }
}
