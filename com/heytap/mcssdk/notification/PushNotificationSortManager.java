package com.heytap.mcssdk.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.McsEventConstant;
import com.heytap.mcssdk.constant.PushConstant;
import com.heytap.mcssdk.statis.McsStatisticUtils;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/notification/PushNotificationSortManager.class */
public class PushNotificationSortManager {
    private int canDelete;
    private int highSize;
    private int normalSize;
    private int notDelete;
    private int keepNumber = 3;
    private List<NotificationSortMessage> canDeleteList = new ArrayList();
    private List<String> deleteList = new ArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/notification/PushNotificationSortManager$SingletonHolder.class */
    static class SingletonHolder {
        private static final PushNotificationSortManager INSTANCE = new PushNotificationSortManager();

        private SingletonHolder() {
        }
    }

    private void callbackListener(ISortListener iSortListener, boolean z, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z, builder, this.deleteList);
        }
    }

    private DataMessage createDataMessage(Context context, NotificationSortMessage notificationSortMessage) {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PushConstant.NotificationSort.IS_MCS, "false");
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(PushConstant.NotificationSort.CLIENT_STATISTIC_DATA, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
            return dataMessage;
        } catch (JSONException e) {
            return dataMessage;
        }
    }

    private boolean dealCurrentMessage(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        boolean judgeShowCurrentMessage;
        if (this.canDelete + this.notDelete < this.keepNumber) {
            StringBuilder sb = notificationSortMessage.getAutoDelete() == -1 ? new StringBuilder(PushConstant.Notification.DEFAULT_NOTIFICATION_NOT_DELETE_GROUP_KEY) : new StringBuilder(PushConstant.Notification.DEFAULT_NOTIFICATION_CAN_DELETE_GROUP_KEY);
            sb.append(context.getPackageName());
            notificationSortMessage.setGroup(sb.toString());
            judgeShowCurrentMessage = true;
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(PushConstant.Notification.DEFAULT_NOTIFICATION_NOT_DELETE_GROUP_KEY + context.getPackageName());
            int i = this.keepNumber - this.notDelete;
            if (i > 0) {
                deleteLowestMessage(context, notificationManager, i - 1);
                judgeShowCurrentMessage = true;
            } else {
                Notification createDefaultGroupNotification = NotificationHelper.createDefaultGroupNotification(context, notificationSortMessage.getGroup(), builder);
                judgeShowCurrentMessage = true;
                if (createDefaultGroupNotification != null) {
                    notificationManager.notify(4096, createDefaultGroupNotification);
                    judgeShowCurrentMessage = true;
                }
            }
        } else {
            judgeShowCurrentMessage = judgeShowCurrentMessage(context, notificationManager, notificationSortMessage);
        }
        if (judgeShowCurrentMessage) {
            doMessageConfig(builder, notificationSortMessage);
            return judgeShowCurrentMessage;
        }
        McsStatisticUtils.statisticEvent(context, McsEventConstant.EventId.EVENT_ID_PUSH_NO_SHOW_BY_FOLD, createDataMessage(context, notificationSortMessage));
        return judgeShowCurrentMessage;
    }

    private void dealShowedNotificationList(NotificationManager notificationManager, Context context) {
        initParams(NotificationHelper.getActiveNotifications(notificationManager, context.getPackageName()));
    }

    private void deleteLowestMessage(Context context, NotificationManager notificationManager, int i) {
        keepMessage(this.canDeleteList, i);
        sendCommandOrStatic(context, notificationManager, this.canDeleteList);
    }

    private void deleteNotification(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) {
        for (NotificationSortMessage notificationSortMessage : list) {
            if (notificationSortMessage.isMcs()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, notificationSortMessage.getNotifyId());
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                }
            } else {
                list2.add(createDataMessage(context, notificationSortMessage));
                this.deleteList.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    private void doMessageConfig(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, notificationSortMessage.getAutoDelete());
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, notificationSortMessage.getImportantLevel());
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
        bundle.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        bundle.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, notificationSortMessage.getStatisticData());
        if (Build.VERSION.SDK_INT >= 20) {
            builder.addExtras(bundle);
            builder.setGroup(notificationSortMessage.getGroup());
        }
    }

    private boolean doTask(PushNotification.Builder builder, int i, int i2, String str, String str2) {
        Context context = PushService.getInstance().getContext();
        if (builder == null || context == null) {
            return false;
        }
        NotificationManager notificationManager = NotificationHelper.getNotificationManager(context);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i2, i, false, System.currentTimeMillis(), str2);
        if (judgeMessageNeedDoAntiDeleteAndAntiFolderLogic(context, notificationManager, notificationSortMessage, builder)) {
            dealShowedNotificationList(notificationManager, context);
            return dealCurrentMessage(notificationManager, context, builder, notificationSortMessage);
        }
        return true;
    }

    public static PushNotificationSortManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private void initCanDeleteAndNotDelete(int i) {
        if (i == -1) {
            this.notDelete++;
        } else if (i == 1) {
            this.canDelete++;
        }
    }

    private void initHighAndNormalSize(int i) {
        if (i == 7) {
            this.highSize++;
        } else if (i == 5) {
            this.normalSize++;
        }
    }

    private void initList(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.canDeleteList.size() != 0) {
            int size = this.canDeleteList.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                NotificationSortMessage notificationSortMessage2 = this.canDeleteList.get(i);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.canDeleteList.add(i + 1, notificationSortMessage2);
                    return;
                }
                size = i;
            }
        }
        this.canDeleteList.add(0, notificationSortMessage);
    }

    private void initParams(StatusBarNotification[] statusBarNotificationArr) {
        resetParams();
        if (statusBarNotificationArr == null || statusBarNotificationArr.length == 0) {
            return;
        }
        int length = statusBarNotificationArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            StatusBarNotification statusBarNotification = statusBarNotificationArr[i2];
            Bundle bundle = statusBarNotification.getNotification().extras;
            boolean z = bundle.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
            long j = bundle.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, statusBarNotification.getPostTime());
            String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
            int i3 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
            int i4 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 7);
            NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i4, i3, z, j, statusBarNotification.getId(), bundle.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA));
            initCanDeleteAndNotDelete(i3);
            initHighAndNormalSize(i4);
            initList(notificationSortMessage);
            i = i2 + 1;
        }
    }

    private boolean judgeShowCurrentMessage(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) {
        int i = this.notDelete;
        int i2 = this.keepNumber;
        boolean z = false;
        if (i >= i2) {
            return false;
        }
        int i3 = i2 - i;
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.highSize + this.normalSize < i3 : this.highSize < i3)) {
            z = true;
        }
        if (z) {
            deleteLowestMessage(context, notificationManager, i3 - 1);
        }
        return z;
    }

    private int keepMessage(List<NotificationSortMessage> list, int i) {
        int size = list == null ? 0 : list.size();
        if (i > 0 && size != 0) {
            if (size < i) {
                list.clear();
                return i - size;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return 0;
                }
                list.remove((size - 1) - i3);
                i2 = i3 + 1;
            }
        }
        return i;
    }

    private void resetParams() {
        this.canDelete = 0;
        this.notDelete = 0;
        this.highSize = 0;
        this.normalSize = 0;
        this.canDeleteList.clear();
        this.deleteList.clear();
    }

    private void sendCommandOrStatic(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        deleteNotification(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(PushConstant.NotificationSort.SORT_ARRAY, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException e) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(McsEventConstant.EventId.EVENT_ID_PUSH_DELETE_BY_FOLD, arrayList);
            StatisticUtils.statisticEvent(context, hashMap);
        }
    }

    public boolean judgeMessageNeedDoAntiDeleteAndAntiFolderLogic(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        if (notificationSortMessage.getAutoDelete() != 0 && Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT < 30) {
            if (NotificationHelper.isExistNotificationsByPkgAndId(notificationManager, context.getPackageName(), 4096)) {
                notificationSortMessage.setGroup(PushConstant.Notification.DEFAULT_NOTIFICATION_NOT_DELETE_GROUP_KEY + context.getPackageName());
                doMessageConfig(builder, notificationSortMessage);
                return false;
            }
            return true;
        }
        return false;
    }

    public void startBuild(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        callbackListener(iSortListener, doTask(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }
}
