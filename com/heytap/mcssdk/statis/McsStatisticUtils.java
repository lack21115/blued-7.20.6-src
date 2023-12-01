package com.heytap.mcssdk.statis;

import android.content.Context;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/statis/McsStatisticUtils.class */
public class McsStatisticUtils {
    public static boolean statisticEvent(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessageStat(context.getPackageName(), str));
        return StatUtil.statisticMessage(context, arrayList);
    }

    public static boolean statisticEvent(Context context, String str, DataMessage dataMessage) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        arrayList.add(dataMessage == null ? new MessageStat(packageName, str) : new MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
        return StatUtil.statisticMessage(context, arrayList);
    }

    public static boolean statisticEvent(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (list != null && list.size() != 0) {
            for (String str : list) {
                arrayList.add(new MessageStat(packageName, str));
            }
        }
        return StatUtil.statisticMessage(context, arrayList);
    }
}
