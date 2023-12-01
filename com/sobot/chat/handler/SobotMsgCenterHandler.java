package com.sobot.chat.handler;

import android.content.Context;
import android.text.TextUtils;
import com.sobot.chat.SobotApi;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotCompareNewMsgTime;
import com.sobot.chat.utils.SobotExecutorService;
import com.sobot.chat.utils.ZhiChiConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/handler/SobotMsgCenterHandler.class */
public class SobotMsgCenterHandler {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/handler/SobotMsgCenterHandler$SobotMsgCenterCallBack.class */
    public interface SobotMsgCenterCallBack {
        void onAllDataSuccess(List<SobotMsgCenterModel> list);

        void onLocalDataSuccess(List<SobotMsgCenterModel> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<SobotMsgCenterModel> getDataFromServer(Object obj, Context context, String str) {
        String stringData = SharedPreferencesUtil.getStringData(context.getApplicationContext(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        if (TextUtils.isEmpty(stringData) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SobotMsgManager.getInstance(context.getApplicationContext()).getZhiChiApi().getPlatformList(obj, stringData, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getMsgCenterAllData(final Object obj, final Context context, final String str, final SobotMsgCenterCallBack sobotMsgCenterCallBack) {
        SobotExecutorService.executorService().execute(new Runnable() { // from class: com.sobot.chat.handler.SobotMsgCenterHandler.1
            @Override // java.lang.Runnable
            public void run() {
                List<SobotMsgCenterModel> msgCenterList = SobotApi.getMsgCenterList(Context.this.getApplicationContext(), str);
                ArrayList arrayList = msgCenterList;
                if (msgCenterList == null) {
                    arrayList = new ArrayList();
                }
                SobotCompareNewMsgTime sobotCompareNewMsgTime = new SobotCompareNewMsgTime();
                Collections.sort(arrayList, sobotCompareNewMsgTime);
                SobotMsgCenterCallBack sobotMsgCenterCallBack2 = sobotMsgCenterCallBack;
                if (sobotMsgCenterCallBack2 != null) {
                    sobotMsgCenterCallBack2.onLocalDataSuccess(arrayList);
                }
                List dataFromServer = SobotMsgCenterHandler.getDataFromServer(obj, Context.this, str);
                if (dataFromServer == null || dataFromServer.size() <= 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= dataFromServer.size()) {
                        break;
                    }
                    SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) dataFromServer.get(i2);
                    int indexOf = arrayList.indexOf(sobotMsgCenterModel);
                    if (indexOf == -1) {
                        arrayList.add(sobotMsgCenterModel);
                    } else {
                        try {
                            arrayList.get(indexOf).setId(sobotMsgCenterModel.getId());
                        } catch (Exception e) {
                        }
                    }
                    i = i2 + 1;
                }
                Collections.sort(arrayList, sobotCompareNewMsgTime);
                SobotMsgCenterCallBack sobotMsgCenterCallBack3 = sobotMsgCenterCallBack;
                if (sobotMsgCenterCallBack3 != null) {
                    sobotMsgCenterCallBack3.onAllDataSuccess(arrayList);
                }
            }
        });
    }
}
