package com.heytap.mcssdk.processor;

import android.app.NotificationManager;
import android.content.Context;
import com.anythink.expressad.foundation.g.b.b;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.ThreadUtil;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/processor/DataMessageProcessor.class */
public class DataMessageProcessor implements Processor {
    private static final int IS_REVOKE_COMMAND = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public void revokeMessage(Context context, DataMessage dataMessage) {
        if (context == null) {
            LogUtil.d(b.f7836a);
            return;
        }
        LogUtil.d("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
        ((NotificationManager) context.getSystemService("notification")).cancel(dataMessage.getNotifyID());
        staticRevokeMessage(context, dataMessage);
    }

    private void staticRevokeMessage(Context context, DataMessage dataMessage) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataMessage);
        hashMap.put(dataMessage.getEventId(), arrayList);
        StatisticUtils.statisticEvent(context, hashMap);
    }

    @Override // com.heytap.mcssdk.processor.Processor
    public void process(final Context context, BaseMode baseMode, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            final DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                ThreadUtil.executeOnUiThread(new Runnable() { // from class: com.heytap.mcssdk.processor.DataMessageProcessor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (dataMessage.getMsgCommand() == 1) {
                            DataMessageProcessor.this.revokeMessage(context, dataMessage);
                        } else {
                            iDataMessageCallBackService.processMessage(context, dataMessage);
                        }
                    }
                });
            }
        }
    }
}
