package com.blued.android.chat.grpc.backup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.grpc.backup.model.AndroidMsgDbModel;
import com.blued.android.chat.grpc.backup.model.AndroidSessionDbModel;
import com.blued.android.chat.grpc.backup.model.IOSMsgDbModel;
import com.blued.android.chat.grpc.backup.model.IOSSessionDbModel;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.youzan.androidsdk.tool.WebParameter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/MsgBackupManager.class */
public class MsgBackupManager {
    public static final int BATCH_COUNT = 1000;
    public static final String PLATFORM_ANDROID = "android";
    public static final String PLATFORM_IOS = "ios";
    public static final String TAG = MsgBackupManager.class.getSimpleName();
    private static volatile MsgBackupManager instance;
    private static volatile boolean isRunning;
    private SQLiteDatabase localDatabase;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private ChattingModel restoreLastMsg = null;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/MsgBackupManager$ReserveListener.class */
    public interface ReserveListener {
        void onError(String str);

        void onReserveSucceed(String str);

        void onRestoreSucceed();

        void onStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/MsgBackupManager$TempSessionInfo.class */
    public class TempSessionInfo {
        public int msgCnt;
        public long sessionId;
        public short sessionType;

        private TempSessionInfo() {
        }
    }

    private MsgBackupManager() {
        if (ChatManager.dbOperImpl != null) {
            this.localDatabase = ChatManager.dbOperImpl.getReadDatabase();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean copyFile(File file, String str) {
        if (file == null || !file.exists() || str == null) {
            return false;
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel.transferTo(0L, channel.size(), channel2);
            try {
                channel.close();
                channel2.close();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static MsgBackupManager getInstance() {
        if (instance == null) {
            synchronized (MsgBackupManager.class) {
                try {
                    if (instance == null) {
                        instance = new MsgBackupManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private void insertRemoteSessionList(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SessionModel sessionModel = null;
            if (obj instanceof AndroidSessionDbModel) {
                sessionModel = ((AndroidSessionDbModel) obj).convertToSessionModel();
            } else if (obj instanceof IOSSessionDbModel) {
                sessionModel = ((IOSSessionDbModel) obj).convertToAndroidModel();
            }
            if (sessionModel != null && !ChatManager.getInstance().sessionExist(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId))) {
                arrayList.add(sessionModel);
            }
        }
        ChatManager.getInstance().insertSessionList(arrayList);
    }

    private Object parseCursorToObj(Object obj, Cursor cursor) throws IllegalAccessException, IllegalArgumentException {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return obj;
            }
            Field field = declaredFields[i2];
            boolean z = true;
            field.setAccessible(true);
            String name = field.getName();
            boolean z2 = true;
            if (cursor.getColumnIndex(name) != -1) {
                String simpleName = field.getType().getSimpleName();
                switch (simpleName.hashCode()) {
                    case -1808118735:
                        if (simpleName.equals("String")) {
                            z2 = true;
                            break;
                        }
                        break;
                    case 104431:
                        if (simpleName.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                            z2 = true;
                            break;
                        }
                        break;
                    case 3327612:
                        if (simpleName.equals("long")) {
                            z2 = true;
                            break;
                        }
                        break;
                    case 64711720:
                        if (simpleName.equals(TypedValues.Custom.S_BOOLEAN)) {
                            z2 = false;
                            break;
                        }
                        break;
                    case 109413500:
                        if (simpleName.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                            z2 = true;
                            break;
                        }
                        break;
                }
                if (!z2) {
                    if (cursor.getInt(cursor.getColumnIndex(name)) <= 0) {
                        z = false;
                    }
                    field.setBoolean(obj, z);
                } else if (z2) {
                    field.setInt(obj, cursor.getInt(cursor.getColumnIndex(name)));
                } else if (z2) {
                    field.setLong(obj, cursor.getLong(cursor.getColumnIndex(name)));
                } else if (z2) {
                    field.setShort(obj, cursor.getShort(cursor.getColumnIndex(name)));
                } else if (z2) {
                    field.set(obj, cursor.getString(cursor.getColumnIndex(name)));
                }
            }
            i = i2 + 1;
        }
    }

    private void queryAndInsertMsg(SQLiteDatabase sQLiteDatabase, short s, long j, Class cls, String str, long j2) throws IllegalAccessException, InstantiationException {
        String str2;
        String str3;
        Cursor cursor;
        ChattingModel chattingModel;
        Cursor cursor2;
        Cursor rawQuery;
        String name = cls.isAnnotationPresent(DbTableName.class) ? ((DbTableName) cls.getAnnotation(DbTableName.class)).name() : cls.getSimpleName();
        if (cls == AndroidMsgDbModel.class) {
            str2 = "msgTimestamp";
            str3 = "loadName=" + str + " and sessionId = " + j + " and msgTimestamp > " + j2;
        } else {
            str2 = RemoteMessageConst.SEND_TIME;
            str3 = "sessionId = " + j + " and " + RemoteMessageConst.SEND_TIME + " > " + j2;
        }
        String str4 = "select * from " + name + " where " + str3 + " order by " + str2 + " ASC limit 1000";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery2 = sQLiteDatabase.rawQuery(str4, null);
            while (rawQuery2.moveToNext()) {
                try {
                    arrayList.add(parseCursorToObj(cls.newInstance(), rawQuery2));
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
            ArrayList arrayList2 = new ArrayList();
            ChattingModel chattingModel2 = null;
            for (int i = 0; i < arrayList.size(); i++) {
                chattingModel2 = cls == AndroidMsgDbModel.class ? ((AndroidMsgDbModel) arrayList.get(i)).convertChattingModel() : ((IOSMsgDbModel) arrayList.get(i)).covertToAndroidModel();
                if (this.localDatabase != null) {
                    try {
                        rawQuery = this.localDatabase.rawQuery("select msgId from " + ChattingModel.class.getSimpleName() + " where msgId = " + chattingModel2.msgId + " and msgLocalId = " + chattingModel2.msgLocalId + " and msgTimestamp = " + chattingModel2.msgTimestamp, null);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = null;
                    }
                    try {
                        if (rawQuery.moveToNext()) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        } else if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = rawQuery;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                arrayList2.add(chattingModel2);
            }
            ChatLog.d(TAG, "需要插入数据库中-sessionId: " + j + " 消息数：" + arrayList2.size());
            if (arrayList2.size() > 0) {
                ChatManager.getInstance().insertMsgListFromBackup(arrayList2);
                this.restoreLastMsg = (ChattingModel) arrayList2.get(arrayList2.size() - 1);
            }
            if (arrayList.size() > 1000 && chattingModel2 != null) {
                queryAndInsertMsg(sQLiteDatabase, s, j, cls, str, chattingModel2.msgTimestamp);
                return;
            }
            SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel(s, j);
            if (snapSessionModel != null) {
                ChattingModel findSessionLastMsg = ChatManager.dbOperImpl.findSessionLastMsg(snapSessionModel.sessionType, snapSessionModel.sessionId);
                ChattingModel chattingModel3 = this.restoreLastMsg;
                if (chattingModel3 == null || findSessionLastMsg == null) {
                    chattingModel = this.restoreLastMsg;
                    if (chattingModel == null) {
                        chattingModel = null;
                        if (findSessionLastMsg != null) {
                            chattingModel = findSessionLastMsg;
                        }
                    }
                } else {
                    chattingModel = findSessionLastMsg;
                    if (chattingModel3.msgId > findSessionLastMsg.msgId) {
                        chattingModel = this.restoreLastMsg;
                    }
                }
                if (chattingModel == null || chattingModel.msgId <= snapSessionModel.lastMsgId) {
                    return;
                }
                SessionModel.setSessionForLastMsg(snapSessionModel, chattingModel);
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    private List<Object> queryRemoteSession(SQLiteDatabase sQLiteDatabase, Class cls, String str) throws IllegalAccessException, InstantiationException {
        ArrayList arrayList = new ArrayList();
        String str2 = "select * from " + (cls.isAnnotationPresent(DbTableName.class) ? ((DbTableName) cls.getAnnotation(DbTableName.class)).name() : cls.getSimpleName()) + " where sessionType > 0 ";
        String str3 = str2;
        if (cls == SessionModel.class) {
            str3 = str2 + " and loadName= " + str;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(str3, null);
            while (true) {
                cursor = rawQuery;
                if (!rawQuery.moveToNext()) {
                    break;
                }
                arrayList.add(parseCursorToObj(cls.newInstance(), rawQuery));
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreFromDb(File file, ReserveListener reserveListener, Class cls, Class cls2, String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file.getAbsolutePath(), (SQLiteDatabase.CursorFactory) null);
            restoreSession(sQLiteDatabase, cls, str);
            restoreMsg(sQLiteDatabase, cls2, str);
            sQLiteDatabase2 = sQLiteDatabase;
            reserveListener.onRestoreSucceed();
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (reserveListener != null) {
                try {
                    reserveListener.onError(th.toString());
                } catch (Throwable th2) {
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase2 == null) {
                return;
            }
            sQLiteDatabase = sQLiteDatabase2;
        }
        sQLiteDatabase.close();
    }

    private void restoreMsg(SQLiteDatabase sQLiteDatabase, Class cls, String str) throws IllegalAccessException, InstantiationException {
        Cursor cursor;
        String str2 = "select sessionType, sessionId, count(*) as msgCnt from " + (cls.isAnnotationPresent(DbTableName.class) ? ((DbTableName) cls.getAnnotation(DbTableName.class)).name() : cls.getSimpleName()) + " where " + (cls == AndroidMsgDbModel.class ? "sessionType > 0  and loadName = " + str : "sessionType > 0 ") + " group by(sessionId)";
        HashMap hashMap = new HashMap();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(str2, null);
            while (rawQuery.moveToNext()) {
                try {
                    TempSessionInfo tempSessionInfo = new TempSessionInfo();
                    tempSessionInfo.sessionType = rawQuery.getShort(rawQuery.getColumnIndex("sessionType"));
                    tempSessionInfo.sessionId = rawQuery.getLong(rawQuery.getColumnIndex(TextToSpeech.Engine.KEY_PARAM_SESSION_ID));
                    tempSessionInfo.msgCnt = rawQuery.getInt(rawQuery.getColumnIndex("msgCnt"));
                    hashMap.put(Long.valueOf(tempSessionInfo.sessionId), tempSessionInfo);
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (hashMap.size() > 0) {
                for (TempSessionInfo tempSessionInfo2 : hashMap.values()) {
                    ChatLog.d(TAG, "sessionId : " + tempSessionInfo2.sessionId + " 消息数：" + tempSessionInfo2.msgCnt);
                    this.restoreLastMsg = null;
                    queryAndInsertMsg(sQLiteDatabase, tempSessionInfo2.sessionType, tempSessionInfo2.sessionId, cls, str, 0L);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private void restoreSession(SQLiteDatabase sQLiteDatabase, Class cls, String str) throws IllegalAccessException, InstantiationException {
        List<Object> queryRemoteSession = queryRemoteSession(sQLiteDatabase, cls, str);
        String str2 = TAG;
        ChatLog.d(str2, "远端session个数===" + queryRemoteSession.size());
        insertRemoteSessionList(queryRemoteSession);
    }

    public void reserveMsgDb(final String str, List<Long> list, final ReserveListener reserveListener) {
        if (isRunning) {
            if (reserveListener != null) {
                reserveListener.onError("Task already running !!");
                return;
            }
            return;
        }
        isRunning = true;
        if (reserveListener != null) {
            reserveListener.onStart();
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.backup.MsgBackupManager.1
            @Override // java.lang.Runnable
            public void run() {
                SQLiteDatabase openOrCreateDatabase;
                int uid = PrivateChatManager.getInstance().getUid();
                if (uid < 0) {
                    return;
                }
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    String str2 = PrivateChatManager.getInstance().getChatAppInfo().context.getCacheDir() + File.separator + "blued" + File.separator + WebParameter.PATH_DATABASE;
                    String str3 = "android_" + uid;
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str4 = str2 + File.separator + str3;
                    if (MsgBackupManager.this.copyFile(new File(str), str4)) {
                        SQLiteDatabase sQLiteDatabase = null;
                        try {
                            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str4, (SQLiteDatabase.CursorFactory) null);
                            ChattingModel.class.getSimpleName();
                            SessionModel.class.getSimpleName();
                            String simpleName = ChattingModel.class.getSimpleName();
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            sb.append(uid);
                            int delete = openOrCreateDatabase.delete(simpleName, "loadName != ? or msgIsDelete = ? or msgType < ? or (msgType >= ? and msgType <= ?) or isMatchMsg = ?", new String[]{sb.toString(), "1", "0", "281", "288", "1"});
                            String simpleName2 = SessionModel.class.getSimpleName();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("");
                            sb2.append(uid);
                            int delete2 = openOrCreateDatabase.delete(simpleName2, "loadName != ? or sessionId < ?", new String[]{sb2.toString(), "0"});
                            String str5 = MsgBackupManager.TAG;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("删除消息数====");
                            sb3.append(delete);
                            ChatLog.d(str5, sb3.toString());
                            String str6 = MsgBackupManager.TAG;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("删除session数====");
                            sb4.append(delete2);
                            ChatLog.d(str6, sb4.toString());
                            if (reserveListener != null) {
                                sQLiteDatabase = openOrCreateDatabase;
                                reserveListener.onReserveSucceed(str4);
                            }
                        } catch (Throwable th) {
                            try {
                                if (reserveListener != null) {
                                    reserveListener.onError(th.getMessage());
                                }
                            } finally {
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                            }
                        }
                        if (openOrCreateDatabase != null) {
                            sQLiteDatabase = openOrCreateDatabase;
                        }
                    } else {
                        ReserveListener reserveListener2 = reserveListener;
                        if (reserveListener2 != null) {
                            reserveListener2.onError("Copied file failed !!");
                        }
                    }
                } else {
                    ReserveListener reserveListener3 = reserveListener;
                    if (reserveListener3 != null) {
                        reserveListener3.onError("External storage disable !!");
                    }
                }
                boolean unused = MsgBackupManager.isRunning = false;
            }
        });
    }

    public void restoreMsgDb(final String str, final ReserveListener reserveListener) {
        if (isRunning) {
            if (reserveListener != null) {
                reserveListener.onError("Task already running !!");
                return;
            }
            return;
        }
        isRunning = true;
        if (reserveListener != null) {
            reserveListener.onStart();
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.backup.MsgBackupManager.2
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(str);
                if (!file.exists()) {
                    ReserveListener reserveListener2 = reserveListener;
                    if (reserveListener2 != null) {
                        reserveListener2.onError("File is not exists !!");
                    }
                    boolean unused = MsgBackupManager.isRunning = false;
                    return;
                }
                String[] split = file.getName().split(BridgeUtil.UNDERLINE_STR);
                if (split.length != 2) {
                    ReserveListener reserveListener3 = reserveListener;
                    if (reserveListener3 != null) {
                        reserveListener3.onError("File's name is illegal !!  The file's name must be similar to: android_123456_0");
                    }
                    boolean unused2 = MsgBackupManager.isRunning = false;
                    return;
                }
                String str2 = split[0];
                String str3 = split[1];
                if (TextUtils.isEmpty(str3) || !str3.equals(PrivateChatManager.getInstance().getUserInfo().uid)) {
                    ReserveListener reserveListener4 = reserveListener;
                    if (reserveListener4 != null) {
                        reserveListener4.onError("Uid is wrong !! The file's name must be similar to: android_123456_0");
                    }
                    boolean unused3 = MsgBackupManager.isRunning = false;
                    return;
                }
                if ("android".equals(str2)) {
                    MsgBackupManager.this.restoreFromDb(file, reserveListener, AndroidSessionDbModel.class, AndroidMsgDbModel.class, str3);
                } else if (MsgBackupManager.PLATFORM_IOS.equals(str2)) {
                    MsgBackupManager.this.restoreFromDb(file, reserveListener, IOSSessionDbModel.class, IOSMsgDbModel.class, str3);
                } else {
                    ReserveListener reserveListener5 = reserveListener;
                    if (reserveListener5 != null) {
                        reserveListener5.onError("File's name is wrong !! The file's name must be similar to : android_123456_0");
                    }
                }
                boolean unused4 = MsgBackupManager.isRunning = false;
            }
        });
    }
}
