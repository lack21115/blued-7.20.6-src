package com.blued.android.chat.core.worker.chat;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.alipay.sdk.util.e;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.DeleteAckPackage;
import com.blued.android.chat.core.pack.DeleteRetractMessagePackage;
import com.blued.android.chat.core.pack.PackageHandler;
import com.blued.android.chat.core.pack.PushBasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqBasePackage;
import com.blued.android.chat.core.pack.ReqCloseLiveChatPackage;
import com.blued.android.chat.core.pack.ReqCreateLiveChatPackage;
import com.blued.android.chat.core.pack.ReqEnterLiveChatPackage;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.core.worker.chat.MsgComparator;
import com.blued.android.chat.core.worker.chat.ReadFlagSender;
import com.blued.android.chat.data.ConnectState;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.listener.DebugTipsListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.chat.listener.LoadListener;
import com.blued.android.chat.listener.LoadMsgListener;
import com.blued.android.chat.listener.MsgContentListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.listener.MsgPreProcesserListener;
import com.blued.android.chat.listener.MsgReceiveListener;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.model.SyncChattingModel;
import com.blued.android.chat.utils.AtRegExpUtils;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.DataUtils;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.im.private_chat.ReceiptOuterClass;
import com.blued.im.req.ReqCode;
import com.blued.im.req.ReqOuterClass;
import com.blued.im.sync.SyncErrorCode;
import com.blued.im.sync.SyncMessageOuterClass;
import com.blued.im.sync.SyncOuterClass;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.GeneratedMessageV3;
import com.igexin.push.core.b;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/Chat.class */
public class Chat extends BaseWorker implements PackageHandler, TimeoutUtils.TimeoutListener, ConnectListener, MsgPreProcesserListener {
    private static final int MAX_UNREAD_MSG_COUNT = 100;
    private static final String TAG = "Chat_Chat";
    protected AudioRoomChat audioRoomChat;
    private Connector connector;
    protected FlashVideo flashVideo;
    protected LiveChat liveChat;
    private PackSendHelper packSendHelper;
    protected RoomChat roomChat;
    protected VideoChat videoChat;
    protected WawajiChat wawajiChat;
    protected WawajiControllerChat wawajiControllerChat;
    private boolean sessionListInited = false;
    private volatile boolean dataSyncing = false;
    private long initMaxMsgId = 0;
    private int syncRetryCount = 0;
    public final Map<String, SessionModel> snapSessionList = new ArrayMap();
    public final Map<String, SessionModel> sessionList = new ArrayMap();
    private volatile long lastSessionListChangedTime = 0;
    private final Map<String, Set<SingleSessionListener>> singleSessionListenerMap = new ArrayMap();
    private final Set<SessionListener> sessionListenerList = new HashSet();
    private final Map<String, Set<MsgContentListener>> msgListenerList = new ArrayMap();
    private final LongSparseArray<SendMsgPackage> sendingPackageList = new LongSparseArray<>();
    private final Set<IMStatusListener> imStatusListenerList = new HashSet();
    private ReadFlagSender readFlagSender = new ReadFlagSender();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.chat.core.worker.chat.Chat$7  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/Chat$7.class */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$blued$android$chat$data$ConnectState;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ConnectState.values().length];
            $SwitchMap$com$blued$android$chat$data$ConnectState = iArr;
            try {
                iArr[ConnectState.DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$blued$android$chat$data$ConnectState[ConnectState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$blued$android$chat$data$ConnectState[ConnectState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public Chat(Connector connector) {
        this.connector = connector;
        this.packSendHelper = connector.getPackageSendHelper();
        init();
    }

    private Pair<Long, Long> checkSyncRange(short s, long j, long j2) {
        long j3;
        long j4;
        synchronized (this.sessionList) {
            if (ChatManager.debug) {
                Log.v(TAG, "checkSyncRange(), sessionType:" + ((int) s) + ", sessionId:" + j + ", maxMsgId:" + j2);
            }
            long j5 = -j;
            String sessionKey = SessionHeader.getSessionKey(s, j5);
            synchronized (this.sessionList) {
                if (this.sessionList.get(sessionKey) == null) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "checkSyncRange(), sessionType:" + ((int) s) + ", sessionId:" + j5 + " not exist!");
                    }
                    return null;
                }
                List<Long> findAllMsgId = ChatManager.dbOperImpl.findAllMsgId(s, j, j2);
                long j6 = -1;
                if (findAllMsgId == null || findAllMsgId.size() <= 0) {
                    j3 = -1;
                } else {
                    j6 = findAllMsgId.get(0).longValue();
                    int i = 1;
                    while (true) {
                        if (i >= findAllMsgId.size()) {
                            j3 = -1;
                            j4 = -1;
                            break;
                        }
                        long longValue = findAllMsgId.get(i).longValue();
                        if (j6 != longValue + 1) {
                            int i2 = i + 1;
                            if (i2 < findAllMsgId.size()) {
                                long longValue2 = findAllMsgId.get(i2).longValue() + 1;
                                j3 = longValue2;
                                j4 = longValue;
                                if (longValue - longValue2 > 20) {
                                    j3 = longValue - 20;
                                    j4 = longValue;
                                }
                            } else {
                                j3 = -1;
                                j4 = longValue;
                            }
                        } else {
                            i++;
                            j6 = longValue;
                        }
                    }
                    if (j3 == -1 && j4 == -1) {
                        j3 = j6 - 20;
                        if (j3 < 1) {
                            j3 = 1;
                        }
                    } else {
                        j6 = j4;
                    }
                }
                if (ChatManager.debug) {
                    Log.v(TAG, "checkSyncRange(), endId=" + j6 + ", startId=" + j3);
                }
                if (j6 <= 0 || j3 <= 0) {
                    return null;
                }
                return new Pair<>(Long.valueOf(j3), Long.valueOf(j6));
            }
        }
    }

    private void deleteSessions(List<Pair<Short, Long>> list, boolean z, boolean z2, boolean z3) {
        boolean z4;
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this.sessionList) {
            z4 = false;
            for (Pair<Short, Long> pair : list) {
                String sessionKey = SessionHeader.getSessionKey(pair.first.shortValue(), pair.second.longValue());
                SessionModel remove = this.sessionList.remove(sessionKey);
                synchronized (this.snapSessionList) {
                    this.snapSessionList.remove(sessionKey);
                }
                if (remove != null) {
                    z4 = true;
                }
                if (z) {
                    ChatManager.dbOperImpl.deleteSessionAndChattingForOne(pair.first.shortValue(), pair.second.longValue());
                } else {
                    ChatManager.dbOperImpl.deleteSessionForOne(pair.first.shortValue(), pair.second.longValue());
                }
                if (z3) {
                    ChatManager.dbOperImpl.deleteSessionSetting(pair.first.shortValue(), pair.second.longValue());
                } else {
                    ChatManager.dbOperImpl.deleteNoGroupSessionSetting(pair.first.shortValue(), pair.second.longValue());
                }
            }
        }
        if (z4) {
            if (list.size() == 1) {
                if (z) {
                    notifyMsgListChanged(list.get(0).first.shortValue(), list.get(0).second.longValue());
                }
                notifySessionRemoved(list.get(0).first.shortValue(), list.get(0).second.longValue());
            } else {
                notifySessionListChanged();
            }
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            for (Pair<Short, Long> pair2 : list) {
                if (pair2.second.longValue() > 0) {
                    arrayList.add(pair2);
                }
            }
            if (arrayList.size() > 0) {
                if (arrayList.size() == 1) {
                    sendDeleteOneSessionsRequest(((Short) ((Pair) arrayList.get(0)).first).shortValue(), ((Long) ((Pair) arrayList.get(0)).second).longValue(), z);
                } else {
                    sendDeleteAllSessionsRequest(z);
                }
            }
        }
    }

    private boolean existAnotherSession(short s, long j) {
        boolean containsKey;
        synchronized (this.sessionList) {
            containsKey = this.sessionList.containsKey(SessionHeader.getSessionKey(s, -j));
        }
        return containsKey;
    }

    private List<ChattingModel> getOldMsgListFromDB(short s, long j, ChattingModel chattingModel, int i, boolean z) {
        long j2 = 0;
        long j3 = chattingModel == null ? 0L : chattingModel.msgId;
        long j4 = chattingModel == null ? 0L : chattingModel.msgLocalId;
        if (chattingModel != null) {
            j2 = chattingModel.msgTimestamp;
        }
        List<ChattingModel> msgList = ChatManager.dbOperImpl.getMsgList(ChatManager.userInfo.uid, s, j, j3, j4, j2, i, z);
        if (msgList != null && msgList.size() > 0) {
            MsgComparator.sortAndDistinct(msgList);
            if (isAllDeleted(msgList)) {
                ChattingModel chattingModel2 = msgList.get(0);
                List<ChattingModel> list = null;
                if (chattingModel2.msgId != j3 || chattingModel2.msgLocalId != j4 || chattingModel2.msgTimestamp != j2) {
                    list = getOldMsgListFromDB(s, j, chattingModel2, i, z);
                }
                if (list != null) {
                    msgList.addAll(list);
                    return msgList;
                }
            }
        }
        return msgList;
    }

    private List<ChattingModel> getServiceMsgFromDB(short s, String str, ChattingModel chattingModel, int i) {
        long j = 0;
        long j2 = chattingModel == null ? 0L : chattingModel.msgId;
        long j3 = chattingModel == null ? 0L : chattingModel.msgLocalId;
        long j4 = chattingModel == null ? 0L : chattingModel.msgTimestamp;
        long j5 = chattingModel == null ? 0L : chattingModel.sessionId;
        if (chattingModel != null) {
            j = chattingModel.sessionType;
        }
        List<ChattingModel> serviceMsgList = ChatManager.dbOperImpl.getServiceMsgList(ChatManager.userInfo.uid, s, str, j2, j3, j4, i);
        if (serviceMsgList != null && serviceMsgList.size() > 0 && isAllDeleted(serviceMsgList)) {
            ChattingModel chattingModel2 = serviceMsgList.get(serviceMsgList.size() - 1);
            List<ChattingModel> serviceMsgFromDB = (chattingModel2.msgId == j2 && chattingModel2.msgLocalId == j3 && chattingModel2.msgTimestamp == j4 && chattingModel2.sessionId == j5 && ((long) chattingModel2.sessionType) == j) ? null : getServiceMsgFromDB(s, str, chattingModel2, i);
            if (serviceMsgFromDB != null) {
                serviceMsgList.addAll(serviceMsgFromDB);
            }
        }
        return serviceMsgList;
    }

    private long getSessionId(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = -j;
        }
        return j2;
    }

    private void init() {
        this.connector.registerPackageHandler(3, this);
        this.connector.registerPackageHandler(4, this);
        this.connector.registerPackageHandler(5, this);
        this.connector.registerPackageHandler(6, this);
        this.connector.registerPackageHandler(7, this);
    }

    private void initSessionList() {
        long j;
        long j2;
        if (ChatManager.debug) {
            Log.v(TAG, "initSessionList()");
        }
        synchronized (this.sessionList) {
            this.sessionList.clear();
            synchronized (this.snapSessionList) {
                this.snapSessionList.clear();
            }
            ChatManager.dbOperImpl.failedAllSendingMsg(ChatManager.userInfo.uid);
            ChatManager.dbOperImpl.changeAllMsgType((short) 52, (short) 53);
            List<SessionModel> sessionList = ChatManager.dbOperImpl.getSessionList();
            Map<String, SessionSettingBaseModel> sessionSettingList = ChatManager.dbOperImpl.getSessionSettingList();
            HashMap hashMap = sessionSettingList;
            if (sessionSettingList == null) {
                hashMap = new HashMap();
            }
            if (sessionList != null) {
                Iterator<SessionModel> it = sessionList.iterator();
                long j3 = 0;
                while (true) {
                    j = j3;
                    if (!it.hasNext()) {
                        break;
                    }
                    SessionModel next = it.next();
                    String sessionKey = SessionHeader.getSessionKey(next.sessionType, next.sessionId);
                    SessionSettingBaseModel sessionSettingBaseModel = hashMap.get(sessionKey);
                    SessionSettingBaseModel sessionSettingBaseModel2 = sessionSettingBaseModel;
                    if (sessionSettingBaseModel == null) {
                        sessionSettingBaseModel2 = ChatManager.dbOperImpl.createSessionSetting(next.sessionType, next.sessionId, null);
                    }
                    next.sessionSettingModel = sessionSettingBaseModel2;
                    this.sessionList.put(sessionKey, next);
                    if (next.sessionType == 7) {
                        j3 = next.sessionId;
                    }
                }
            } else {
                j = 0;
            }
            synchronized (this.snapSessionList) {
                this.snapSessionList.putAll(this.sessionList);
            }
            j2 = 0;
            for (SessionModel sessionModel : this.sessionList.values()) {
                j2 = Math.max(j2, sessionModel.maxMsgId);
            }
        }
        notifySessionListInit();
        this.sessionListInited = true;
        RoomChat roomChat = this.roomChat;
        if (roomChat != null) {
            roomChat.setupRoomId(j);
        }
        this.initMaxMsgId = j2;
        if (ChatManager.debug) {
            Log.v(TAG, "get the maxMsgId:" + this.initMaxMsgId);
        }
    }

    private void insertMemoryAndNotifyUI(SessionModel sessionModel, ChattingModel chattingModel) {
        boolean insertMemoryMsgList;
        synchronized (this.sessionList) {
            insertMemoryMsgList = insertMemoryMsgList(sessionModel, chattingModel);
        }
        if (insertMemoryMsgList) {
            notifyMsgListChanged(chattingModel.sessionType, chattingModel.sessionId);
        }
    }

    private boolean insertMemoryMsgList(SessionModel sessionModel, ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.e(TAG, "insertMemoryMsgList====msgId: " + chattingModel.msgId + "  localId: " + chattingModel.msgLocalId);
        }
        if (sessionModel._msgList != null) {
            if (!sessionModel.isFromSearch || isShowLastMsg(sessionModel)) {
                MsgComparator.mergeSortedList(sessionModel._msgList, chattingModel);
                return true;
            }
            return false;
        }
        return false;
    }

    private void insertMsgDataForLocal(ChattingModel chattingModel) {
        String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                if (chattingModel.msgLocalId == 0) {
                    chattingModel.msgLocalId = ChatHelper.getLocalId();
                }
                ChatManager.dbOperImpl.insertChattingData(chattingModel);
                if (insertMemoryMsgList(sessionModel, chattingModel)) {
                    notifyMsgListChanged(chattingModel.sessionType, chattingModel.sessionId);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x01a1 A[Catch: all -> 0x027f, TRY_LEAVE, TryCatch #2 {, blocks: (B:19:0x0089, B:21:0x009f, B:24:0x00c9, B:26:0x00d2, B:28:0x00eb, B:29:0x0106, B:33:0x0117, B:35:0x011d, B:39:0x0135, B:72:0x0201, B:74:0x0208, B:76:0x020f, B:77:0x0210, B:47:0x0156, B:49:0x015c, B:54:0x0181, B:59:0x0191, B:61:0x01a1, B:71:0x01f4, B:63:0x01c8, B:65:0x01d5, B:67:0x01e2, B:31:0x0108, B:32:0x0116), top: B:107:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c8 A[Catch: all -> 0x027f, TRY_ENTER, TryCatch #2 {, blocks: (B:19:0x0089, B:21:0x009f, B:24:0x00c9, B:26:0x00d2, B:28:0x00eb, B:29:0x0106, B:33:0x0117, B:35:0x011d, B:39:0x0135, B:72:0x0201, B:74:0x0208, B:76:0x020f, B:77:0x0210, B:47:0x0156, B:49:0x015c, B:54:0x0181, B:59:0x0191, B:61:0x01a1, B:71:0x01f4, B:63:0x01c8, B:65:0x01d5, B:67:0x01e2, B:31:0x0108, B:32:0x0116), top: B:107:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f4 A[Catch: all -> 0x027f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:19:0x0089, B:21:0x009f, B:24:0x00c9, B:26:0x00d2, B:28:0x00eb, B:29:0x0106, B:33:0x0117, B:35:0x011d, B:39:0x0135, B:72:0x0201, B:74:0x0208, B:76:0x020f, B:77:0x0210, B:47:0x0156, B:49:0x015c, B:54:0x0181, B:59:0x0191, B:61:0x01a1, B:71:0x01f4, B:63:0x01c8, B:65:0x01d5, B:67:0x01e2, B:31:0x0108, B:32:0x0116), top: B:107:0x0089 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void insertMsgDataForSending(com.blued.android.chat.model.ChattingModel r6, com.blued.android.chat.model.SessionProfileModel r7) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.core.worker.chat.Chat.insertMsgDataForSending(com.blued.android.chat.model.ChattingModel, com.blued.android.chat.model.SessionProfileModel):void");
    }

    private void insertMsgListToMemory(List<ChattingModel> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String sessionKey = SessionHeader.getSessionKey(list.get(0).sessionType, list.get(0).sessionId);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && sessionModel._msgList != null) {
                MsgComparator.mergeSortedList(sessionModel._msgList, list);
                notifyMsgListChanged(list.get(0).sessionType, list.get(0).sessionId);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:253:0x07c8 A[Catch: all -> 0x0a1b, TRY_LEAVE, TryCatch #5 {all -> 0x0a1b, blocks: (B:258:0x07e4, B:128:0x0405, B:130:0x040e, B:132:0x041b, B:134:0x0428, B:136:0x0435, B:138:0x0442, B:140:0x044f, B:142:0x045c, B:144:0x0469, B:146:0x0476, B:148:0x0483, B:150:0x0490, B:152:0x049b, B:155:0x04ae, B:156:0x051f, B:158:0x053b, B:160:0x0544, B:162:0x054c, B:164:0x055d, B:166:0x0565, B:170:0x0575, B:172:0x057d, B:174:0x05a5, B:176:0x05b4, B:178:0x05ba, B:181:0x05c5, B:183:0x05d3, B:251:0x07ba, B:253:0x07c8, B:257:0x07d7, B:185:0x05e5, B:187:0x05ef, B:189:0x05f7, B:192:0x0610, B:194:0x061c, B:196:0x0631, B:198:0x063a, B:200:0x0645, B:202:0x065b, B:204:0x0669, B:206:0x0672, B:208:0x067a, B:210:0x068b, B:212:0x0691, B:214:0x069c, B:215:0x06a7, B:217:0x06bc, B:219:0x06c4, B:221:0x06ca, B:223:0x06f4, B:225:0x06fa, B:226:0x0718, B:228:0x0720, B:230:0x072b, B:232:0x0736, B:235:0x0744, B:238:0x075b, B:236:0x0753, B:240:0x0777, B:243:0x0787, B:247:0x0792, B:249:0x07a0), top: B:394:0x0405 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x07d7 A[Catch: all -> 0x0a1b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0a1b, blocks: (B:258:0x07e4, B:128:0x0405, B:130:0x040e, B:132:0x041b, B:134:0x0428, B:136:0x0435, B:138:0x0442, B:140:0x044f, B:142:0x045c, B:144:0x0469, B:146:0x0476, B:148:0x0483, B:150:0x0490, B:152:0x049b, B:155:0x04ae, B:156:0x051f, B:158:0x053b, B:160:0x0544, B:162:0x054c, B:164:0x055d, B:166:0x0565, B:170:0x0575, B:172:0x057d, B:174:0x05a5, B:176:0x05b4, B:178:0x05ba, B:181:0x05c5, B:183:0x05d3, B:251:0x07ba, B:253:0x07c8, B:257:0x07d7, B:185:0x05e5, B:187:0x05ef, B:189:0x05f7, B:192:0x0610, B:194:0x061c, B:196:0x0631, B:198:0x063a, B:200:0x0645, B:202:0x065b, B:204:0x0669, B:206:0x0672, B:208:0x067a, B:210:0x068b, B:212:0x0691, B:214:0x069c, B:215:0x06a7, B:217:0x06bc, B:219:0x06c4, B:221:0x06ca, B:223:0x06f4, B:225:0x06fa, B:226:0x0718, B:228:0x0720, B:230:0x072b, B:232:0x0736, B:235:0x0744, B:238:0x075b, B:236:0x0753, B:240:0x0777, B:243:0x0787, B:247:0x0792, B:249:0x07a0), top: B:394:0x0405 }] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void insertRecvMsgList(java.util.List<com.blued.android.chat.model.ChattingModel> r12) {
        /*
            Method dump skipped, instructions count: 2753
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.core.worker.chat.Chat.insertRecvMsgList(java.util.List):void");
    }

    private boolean isAllDeleted(List<ChattingModel> list) {
        if (list == null) {
            return false;
        }
        for (ChattingModel chattingModel : list) {
            if (!chattingModel.msgIsDelete) {
                return false;
            }
        }
        return true;
    }

    private boolean isGroupManagerRetract(short s, long j, long j2) {
        return ChatManager.clientType == ChatManager.ClientType.CHINA && s == 3 && j != j2;
    }

    private boolean isShowLastMsg(SessionModel sessionModel) {
        if (sessionModel._msgList == null || sessionModel._msgList.isEmpty() || sessionModel.maxMsgId != sessionModel._msgList.get(sessionModel._msgList.size() - 1).msgId) {
            return false;
        }
        Log.v(TAG, "session.maxMsgId = " + sessionModel.maxMsgId + " ; session.msgId = " + sessionModel._msgList.get(sessionModel._msgList.size() - 1).msgId);
        return true;
    }

    private boolean isTempSessionMessage(short s, long j, long j2) {
        long j3 = j;
        if (j > 0) {
            j3 = -j;
        }
        return ChatManager.dbOperImpl.existChattingModel(s, j3, j2);
    }

    private void loadUpOrDownSessionMsgList(SessionModel sessionModel, ChattingModel chattingModel, String str, short s, long j, int i, boolean z, final LoadListener loadListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        MsgComparator.FillInterval fillTaskIntervalBySortedMsg;
        long j2 = chattingModel == null ? 0L : chattingModel.msgId;
        long j3 = chattingModel == null ? 0L : chattingModel.msgPreviousId;
        if (ChatManager.debug) {
            Log.v(TAG, "fetch msg from db from msgId:" + j3);
        }
        List<ChattingModel> oldMsgListFromDB = getOldMsgListFromDB(s, j, chattingModel, i, z);
        if (ChatManager.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("get msg list from db size:");
            sb.append(oldMsgListFromDB == null ? b.l : Integer.valueOf(oldMsgListFromDB.size()));
            Log.v(TAG, sb.toString());
        }
        if (oldMsgListFromDB == null || oldMsgListFromDB.size() <= 0) {
            if (j3 > 0) {
                if (ChatManager.debug) {
                    Log.v(TAG, "db get empty list, so lost some message, fore load it, endId:" + j2 + ", count:" + i);
                }
                sendSyncMsgPackage(s, j, 0L, j2, loadListener, null);
                return;
            }
            if (ChatManager.debug) {
                Log.v(TAG, "db get empty list, but really have no msg");
            }
            loadListener.onLoadSuccess();
            if (chattingModel == null) {
                if (ChatManager.debug) {
                    Log.v(TAG, "current session hasn't msg, so send sync_last to fetch one.");
                }
                try {
                    IM.a(SyncOuterClass.SyncRequest.newBuilder().setSyncType(SyncOuterClass.SyncType.SyncLatest).setSessionType(s).setSessionId((int) j).setLocalId((int) ChatHelper.getLocalId()).build(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.Chat.1
                        @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
                        public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                            if (generatedMessageV3 == null) {
                                Chat.this.sendSyncPackageFailed(loadListener, null);
                                return;
                            }
                            Chat.this.recvSyncPackage((SyncOuterClass.SyncResponse) generatedMessageV3, loadListener, null);
                        }
                    });
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    sendSyncPackageFailed(loadListener, null);
                    return;
                }
            }
            return;
        }
        MsgComparator.sortAndDistinct(oldMsgListFromDB);
        if (!existAnotherSession(s, j) && (fillTaskIntervalBySortedMsg = MsgComparator.getFillTaskIntervalBySortedMsg(chattingModel, oldMsgListFromDB)) != null) {
            if (ChatManager.debug) {
                Log.v(TAG, "db get some msg list, but have black block, interval load it, startId:" + fillTaskIntervalBySortedMsg.startId + ", endId:" + fillTaskIntervalBySortedMsg.endId);
            }
            sendSyncMsgPackage(s, j, fillTaskIntervalBySortedMsg.startId, fillTaskIntervalBySortedMsg.endId, loadListener, oldMsgListFromDB);
            return;
        }
        synchronized (this.msgListenerList) {
            Set<MsgContentListener> set = this.msgListenerList.get(str);
            z2 = set != null && set.size() > 0;
        }
        synchronized (this.sessionList) {
            if (sessionModel == null) {
                sessionModel = ChatHelper.createSessionModel(oldMsgListFromDB.get(oldMsgListFromDB.size() - 1), null, false);
                this.sessionList.put(str, sessionModel);
                synchronized (this.snapSessionList) {
                    this.snapSessionList.put(str, sessionModel);
                }
                sessionModel.noReadMsgCount = 0;
                ChatHelper.clearSessionLikeNum(sessionModel);
                ChatManager.dbOperImpl.updateSession(sessionModel);
                if (z2) {
                    sessionModel._msgList = new ArrayList();
                }
                if (SessionModel.needRequestSessionInfo(sessionModel)) {
                    requestSessionData(sessionModel);
                }
                z3 = true;
            } else {
                z3 = false;
            }
            if (sessionModel == null || sessionModel._msgList == null) {
                z4 = false;
            } else {
                if (ChatManager.debug) {
                    Log.v(TAG, "before merge, msg size:" + sessionModel._msgList.size());
                }
                MsgComparator.mergeSortedList(sessionModel._msgList, oldMsgListFromDB);
                z4 = true;
                if (ChatManager.debug) {
                    Log.v(TAG, "after merge, msg size:" + sessionModel._msgList.size());
                    z4 = true;
                }
            }
        }
        if (z4) {
            notifyMsgListChanged(s, j);
        }
        if (z3) {
            notifySessionChanged(sessionModel);
        }
        if (loadListener != null) {
            loadListener.onLoadSuccess();
        }
    }

    private void logMsgList(List<ChattingModel> list, String str) {
        for (ChattingModel chattingModel : list) {
            Log.e("updateSend=" + str, "msgId: " + chattingModel.msgId + "==localId: " + chattingModel.msgLocalId + "===content: " + chattingModel.msgContent);
        }
    }

    private void mergeLocalMsgListForSync(List<ChattingModel> list, List<ChattingModel> list2) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list2 == null || list2.size() == 0) {
            insertMsgListToMemory(list);
            return;
        }
        ChattingModel chattingModel = list2.get(0);
        ChattingModel chattingModel2 = list2.get(list2.size() - 1);
        ArrayList arrayList = new ArrayList();
        long j = chattingModel2.msgId;
        long j2 = chattingModel.msgPreviousId;
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            ChattingModel chattingModel3 = list.get(i);
            if (chattingModel3.msgId <= j) {
                if (chattingModel3.msgId != j2) {
                    break;
                }
                arrayList.add(0, chattingModel3);
                j2 = chattingModel3.msgPreviousId;
            } else {
                arrayList.add(0, chattingModel3);
            }
            size = i;
        }
        insertMsgListToMemory(arrayList);
    }

    private void notifyAllMsgListClear() {
        synchronized (this.msgListenerList) {
            Collection<Set<MsgContentListener>> values = this.msgListenerList.values();
            if (values != null) {
                for (Set<MsgContentListener> set : values) {
                    for (MsgContentListener msgContentListener : set) {
                        msgContentListener.onMsgDataChanged(null);
                    }
                }
            }
        }
    }

    private void notifyAllSessionRemoved() {
        synchronized (this.singleSessionListenerMap) {
            if (this.singleSessionListenerMap.size() > 0) {
                for (Map.Entry<String, Set<SingleSessionListener>> entry : this.singleSessionListenerMap.entrySet()) {
                    String key = entry.getKey();
                    Set<SingleSessionListener> value = entry.getValue();
                    Pair<Short, Long> sessionTypeAndId = ChatHelper.getSessionTypeAndId(key);
                    if (sessionTypeAndId != null) {
                        for (SingleSessionListener singleSessionListener : value) {
                            singleSessionListener.onSessionRemoved(sessionTypeAndId.first.shortValue(), sessionTypeAndId.second.longValue());
                        }
                    }
                }
            }
        }
        notifySessionListChanged();
    }

    private void notifyIMStatusListener() {
        synchronized (this.imStatusListenerList) {
            ConnectState connectStatus = this.connector.getConnectStatus();
            for (IMStatusListener iMStatusListener : this.imStatusListenerList) {
                int i = AnonymousClass7.$SwitchMap$com$blued$android$chat$data$ConnectState[connectStatus.ordinal()];
                if (i == 1) {
                    iMStatusListener.onDisconnected();
                } else if (i == 2) {
                    iMStatusListener.onConnecting();
                } else if (i == 3) {
                    if (this.dataSyncing) {
                        iMStatusListener.onReceiving();
                    } else {
                        iMStatusListener.onConnected();
                    }
                }
            }
        }
    }

    private void notifyMsgListChanged(int i, long j) {
        ArrayList arrayList = new ArrayList();
        String sessionKey = SessionHeader.getSessionKey(i, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && sessionModel._msgList != null) {
                arrayList.addAll(sessionModel._msgList);
            }
        }
        Iterator<E> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((ChattingModel) it.next()).msgIsDelete) {
                it.remove();
            }
        }
        if (ChatManager.debug) {
            Log.v(TAG, "notifyMsgListChanged(), sessionType:" + i + ", sessionId:" + j + ", msg size:" + arrayList.size());
        }
        synchronized (this.msgListenerList) {
            Set<MsgContentListener> set = this.msgListenerList.get(sessionKey);
            if (set == null) {
                return;
            }
            for (MsgContentListener msgContentListener : set) {
                msgContentListener.onMsgDataChanged(arrayList);
            }
        }
    }

    private void notifySendPackageStateChanged(SendMsgPackage sendMsgPackage, int i) {
        notifySendPackageStateChanged(sendMsgPackage, null, i, null);
    }

    private void notifySendPackageStateChanged(SendMsgPackage sendMsgPackage, int i, SendAckPackage sendAckPackage) {
        notifySendPackageStateChanged(sendMsgPackage, null, i, sendAckPackage);
    }

    private void notifySendPackageStateChanged(SendMsgPackage sendMsgPackage, ChattingModel chattingModel, int i, SendAckPackage sendAckPackage) {
        SessionModel sessionModel;
        long j;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        ChattingModel sendingMsgData;
        ChattingModel next;
        if (ChatManager.debug) {
            Log.v(TAG, "notifySendStateForGRPC(), chattingModel=[" + chattingModel + "], sendPackage.sessionId=" + sendMsgPackage.sessionId);
        }
        String sessionKey = SessionHeader.getSessionKey(sendMsgPackage.sessionType, sendMsgPackage.sessionId);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                j2 = sessionModel.maxMsgId;
                if (i != 0 || sendAckPackage.msgId <= sessionModel.maxMsgId) {
                    z = false;
                } else {
                    sessionModel.maxMsgId = sendAckPackage.msgId;
                    if (ChatManager.debug) {
                        Log.e(TAG, "notifySend===" + sendAckPackage.msgId);
                    }
                    z = true;
                }
                if (sessionModel.lastMsgLocalId == sendMsgPackage.localId) {
                    if (i == 0) {
                        sessionModel.lastMsgId = sendAckPackage.msgId;
                        sessionModel.lastMsgTime = sendAckPackage.msgTime * 1000;
                        sessionModel.lastMsgStateCode = (short) 2;
                        sessionModel.lastMsgLocalId = 0L;
                    } else {
                        sessionModel.lastMsgStateCode = (short) 6;
                    }
                    z = true;
                }
                if (z) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                }
                if (sessionModel._msgList != null) {
                    if (i == 0) {
                        updateSendingMsgId(sessionModel, sendAckPackage.msgId, sendMsgPackage.localId);
                    }
                    Iterator<ChattingModel> it = sessionModel._msgList.iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                        } else {
                            j = 0;
                        }
                    } while (next.msgLocalId != sendMsgPackage.localId);
                    if (i == 0) {
                        next.msgStateCode = (short) 2;
                        next.msgTimestamp = sendAckPackage.msgTime * 1000;
                        next.msgId = sendAckPackage.msgId;
                        next.msgPreviousId = sendAckPackage.msgPreviousId;
                        next.msgLocalId = 0L;
                        next.promptType = sendAckPackage.promptType;
                        sessionModel._msgList.remove(next);
                        MsgComparator.mergeSortedList(sessionModel._msgList, next);
                        ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
                        if (tipsListener != null) {
                            tipsListener.onSendMsgSucceed(next);
                        }
                        j = 0;
                    } else {
                        next.msgStateCode = (short) 6;
                        j = next.msgId;
                    }
                    ChatManager.dbOperImpl.updateChattingModel(next);
                    z2 = true;
                    z3 = true;
                } else {
                    j = 0;
                }
            } else {
                j = 0;
                j2 = 0;
                z = false;
            }
            z2 = false;
            z3 = false;
        }
        if (!z2 && (sendingMsgData = ChatManager.dbOperImpl.getSendingMsgData(sendMsgPackage.sessionType, sendMsgPackage.sessionId, sendMsgPackage.localId)) != null) {
            if (i == 0) {
                sendingMsgData.msgStateCode = (short) 2;
                sendingMsgData.msgTimestamp = sendAckPackage.msgTime * 1000;
                sendingMsgData.msgId = sendAckPackage.msgId;
                sendingMsgData.msgPreviousId = sendAckPackage.msgPreviousId;
                sendingMsgData.msgLocalId = 0L;
                ChatManager.dbOperImpl.updateSendingMsgId(sendAckPackage.msgId, sendMsgPackage.sessionType, sendMsgPackage.sessionId, sendMsgPackage.localId);
                ChatTipsListener tipsListener2 = ChatManager.getInstance().getTipsListener();
                if (tipsListener2 != null) {
                    tipsListener2.onSendMsgSucceed(sendingMsgData);
                }
            } else {
                sendingMsgData.msgStateCode = (short) 6;
                j = sendingMsgData.msgId;
            }
            ChatManager.dbOperImpl.updateChattingModel(sendingMsgData);
        }
        if (z) {
            notifySessionChanged(sessionModel);
        }
        if (z3) {
            notifyMsgListChanged(sendMsgPackage.sessionType, sendMsgPackage.sessionId);
        }
        if (i == 0) {
            if (sendAckPackage.msgPreviousId > j2) {
                sendSyncMsgPackage(sendMsgPackage.sessionType, sendMsgPackage.sessionId, j2, sendAckPackage.msgId, null, null);
                return;
            }
            return;
        }
        ChatTipsListener tipsListener3 = ChatManager.getInstance().getTipsListener();
        if (tipsListener3 != null) {
            tipsListener3.onSendMsgFailed(sendMsgPackage.sessionType, sendMsgPackage.sessionId, sendMsgPackage.msgType, j, sendMsgPackage.localId, i);
        }
    }

    private void notifySessionChanged(SessionModel sessionModel) {
        if (sessionModel == null) {
            return;
        }
        String sessionKey = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
        synchronized (this.singleSessionListenerMap) {
            Set<SingleSessionListener> set = this.singleSessionListenerMap.get(sessionKey);
            if (set != null && set.size() > 0) {
                for (SingleSessionListener singleSessionListener : set) {
                    singleSessionListener.onSessionDataChanged(sessionModel);
                }
            }
        }
        notifySessionListChanged();
    }

    private void notifySessionChanged(Set<SessionModel> set) {
        if (set == null) {
            return;
        }
        synchronized (this.singleSessionListenerMap) {
            for (SessionModel sessionModel : set) {
                Set<SingleSessionListener> set2 = this.singleSessionListenerMap.get(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId));
                if (set2 != null && set2.size() > 0) {
                    for (SingleSessionListener singleSessionListener : set2) {
                        singleSessionListener.onSessionDataChanged(sessionModel);
                    }
                }
            }
        }
        notifySessionListChanged();
    }

    private void notifySessionChanged(short s, long j, SingleSessionListener singleSessionListener) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
        }
        if (sessionModel == null) {
            singleSessionListener.onSessionRemoved(s, j);
        } else {
            singleSessionListener.onSessionDataChanged(sessionModel);
        }
    }

    private void notifySessionListChanged() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.sessionList) {
            arrayList.addAll(this.sessionList.values());
            this.lastSessionListChangedTime = System.currentTimeMillis();
        }
        synchronized (this.sessionListenerList) {
            if (ChatManager.debug) {
                Log.v(TAG, "notifySessionListChanged(), session size:" + arrayList.size() + ", listener size:" + this.sessionListenerList.size());
            }
            for (SessionListener sessionListener : this.sessionListenerList) {
                sessionListener.onSessionDataChanged(arrayList, this.lastSessionListChangedTime);
            }
        }
    }

    private void notifySessionListChanged(SessionListener sessionListener) {
        if (sessionListener == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.sessionList) {
            arrayList.addAll(this.sessionList.values());
        }
        if (ChatManager.debug) {
            Log.v(TAG, "notifySessionListChanged(), session size:" + arrayList.size());
        }
        sessionListener.onSessionDataChanged(arrayList, this.lastSessionListChangedTime);
    }

    private void notifySessionListInit() {
        ArrayList<SessionModel> arrayList = new ArrayList();
        synchronized (this.sessionList) {
            arrayList.addAll(this.sessionList.values());
            this.lastSessionListChangedTime = System.currentTimeMillis();
        }
        if (ChatManager.debug) {
            Log.v(TAG, "notifySessionListInited(), session size:" + arrayList.size());
        }
        synchronized (this.singleSessionListenerMap) {
            for (SessionModel sessionModel : arrayList) {
                Set<SingleSessionListener> set = this.singleSessionListenerMap.get(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId));
                if (set != null && set.size() > 0) {
                    for (SingleSessionListener singleSessionListener : set) {
                        singleSessionListener.onSessionDataChanged(sessionModel);
                    }
                }
            }
        }
        synchronized (this.sessionListenerList) {
            for (SessionListener sessionListener : this.sessionListenerList) {
                sessionListener.onSessionDataChanged(arrayList, this.lastSessionListChangedTime);
            }
        }
    }

    private void notifySessionRemoved(short s, long j) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.singleSessionListenerMap) {
            Set<SingleSessionListener> set = this.singleSessionListenerMap.get(sessionKey);
            if (set != null && set.size() > 0) {
                for (SingleSessionListener singleSessionListener : set) {
                    singleSessionListener.onSessionRemoved(s, j);
                }
            }
        }
        notifySessionListChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSessionInfo(short s, int i, ReqOuterClass.SessionInfoResponse sessionInfoResponse) {
        SessionModel sessionModel;
        boolean z;
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(SessionHeader.getSessionKey(s, i));
            boolean z2 = false;
            z = false;
            if (sessionModel != null) {
                sessionModel._isRequestingInfo = false;
                if (sessionInfoResponse.getCode() == ReqCode.Code.REQ_SUCCESS) {
                    String name = sessionInfoResponse.getName();
                    String avatar = sessionInfoResponse.getAvatar();
                    String note = sessionInfoResponse.getNote();
                    sessionModel.vBadge = (int) sessionInfoResponse.getVbadge();
                    sessionModel.vipGrade = (int) sessionInfoResponse.getVipGrade();
                    sessionModel.ovipGrade = (int) sessionInfoResponse.getOVipGrade();
                    sessionModel.ovipExpLvl = (int) sessionInfoResponse.getVipExpLvl();
                    sessionModel.ohideVipLook = sessionInfoResponse.getOIsHideVipLook() ? 1 : 0;
                    int i2 = 0;
                    if (sessionInfoResponse.getIsHideVipLook()) {
                        i2 = 1;
                    }
                    sessionModel.hideVipLook = i2;
                    sessionModel.oFaceStatus = (int) sessionInfoResponse.getOFaceStatus();
                    sessionModel.vipAnnual = (int) sessionInfoResponse.getVipAnnual();
                    sessionModel.vipExpLvl = (int) sessionInfoResponse.getVipExpLvl();
                    String str = name;
                    if (!TextUtils.isEmpty(note)) {
                        str = note;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        sessionModel.nickName = str;
                    }
                    if (!TextUtils.isEmpty(avatar)) {
                        sessionModel.avatar = avatar;
                    }
                    z2 = true;
                }
                z = z2;
                if (z2) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                    z = z2;
                }
            }
        }
        if (z) {
            notifySessionChanged(sessionModel);
        }
    }

    private void receiveOrderMessage(PushMsgPackage pushMsgPackage) {
        SessionModel sessionModel;
        boolean z;
        boolean z2;
        boolean z3;
        ChattingModel next;
        if (ChatManager.debug) {
            Log.v(TAG, "receiveOrderMessage(), orderMessage:" + pushMsgPackage);
        }
        short s = pushMsgPackage.msgType;
        if (s == 55) {
            if (ChatManager.debug) {
                Log.v(TAG, "收到消息撤回消息");
            }
            if (isTempSessionMessage(pushMsgPackage.sessionType, pushMsgPackage.sessionId, pushMsgPackage.msgId) && pushMsgPackage.sessionId > 0) {
                pushMsgPackage.sessionId = -pushMsgPackage.sessionId;
            }
            String sessionKey = SessionHeader.getSessionKey(pushMsgPackage.sessionType, pushMsgPackage.sessionId);
            synchronized (this.sessionList) {
                sessionModel = this.sessionList.get(sessionKey);
                if (sessionModel != null) {
                    if (sessionModel.maxMsgId == pushMsgPackage.msgId) {
                        sessionModel.lastMsgType = (short) 55;
                        if (isGroupManagerRetract(sessionModel.sessionType, pushMsgPackage.fromId, sessionModel.lastMsgFromId)) {
                            sessionModel.lastMsgStateCode = (short) 10;
                        }
                        ChatManager.dbOperImpl.updateSession(sessionModel);
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (sessionModel._msgList != null) {
                        Iterator<ChattingModel> it = sessionModel._msgList.iterator();
                        do {
                            z2 = false;
                            z = z3;
                            if (!it.hasNext()) {
                                break;
                            }
                            next = it.next();
                        } while (next.msgId != pushMsgPackage.msgId);
                        next.msgType = (short) 55;
                        if (isGroupManagerRetract(next.sessionType, pushMsgPackage.fromId, next.fromId)) {
                            next.msgStateCode = (short) 10;
                        }
                        ChatManager.dbOperImpl.updateChattingModel(next);
                        z2 = true;
                        z = z3;
                    } else {
                        ChattingModel findMsgData = ChatManager.dbOperImpl.findMsgData(pushMsgPackage.sessionType, pushMsgPackage.sessionId, pushMsgPackage.msgId, 0L);
                        z2 = false;
                        z = z3;
                        if (findMsgData != null) {
                            findMsgData.msgType = (short) 55;
                            if (isGroupManagerRetract(findMsgData.sessionType, pushMsgPackage.fromId, findMsgData.fromId)) {
                                findMsgData.msgStateCode = (short) 10;
                            }
                            ChatManager.dbOperImpl.updateChattingModel(findMsgData);
                            z2 = true;
                            z = z3;
                        }
                    }
                }
                z = false;
                z2 = false;
            }
            this.readFlagSender.sendReceiptImmediateForOrder(pushMsgPackage.sessionType, getSessionId(pushMsgPackage.sessionId), pushMsgPackage.msgId, ReadFlagSender.ReceiptType.RECEIVED, true);
            if (z2) {
                notifyMsgListChanged(pushMsgPackage.sessionType, pushMsgPackage.sessionId);
            }
            if (z) {
                notifySessionChanged(sessionModel);
            }
        } else if (s == 59) {
            if (ChatManager.debug) {
                Log.v(TAG, "收到用户信息更新消息");
            }
            if (isTempSessionMessage(pushMsgPackage.sessionType, pushMsgPackage.sessionId, pushMsgPackage.msgId) && pushMsgPackage.sessionId > 0) {
                pushMsgPackage.sessionId = -pushMsgPackage.sessionId;
            }
            SessionModel sessionModel2 = this.sessionList.get(SessionHeader.getSessionKey(pushMsgPackage.sessionType, pushMsgPackage.sessionId));
            ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
            ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
            if (tipsListener != null) {
                tipsListener.onRecvNewMsg(sessionModel2, msgData);
            }
            this.readFlagSender.sendReceiptImmediateForOrder(pushMsgPackage.sessionType, getSessionId(pushMsgPackage.sessionId), pushMsgPackage.msgId, ReadFlagSender.ReceiptType.RECEIVED, true);
        } else if (s == 91) {
            if (ChatManager.debug) {
                Log.v(TAG, "收到闪聊礼物消息");
            }
            FlashVideo flashVideo = this.flashVideo;
            if (flashVideo != null) {
                flashVideo.receiveFlashVideoGift(pushMsgPackage);
            }
        } else if (s == 176) {
            if (ChatManager.debug) {
                Log.v(TAG, "收到国际闪聊发送的表情消息");
            }
            FlashVideo flashVideo2 = this.flashVideo;
            if (flashVideo2 != null) {
                flashVideo2.receiveFlashVideoEmoji(pushMsgPackage);
            }
        } else if (s == 71) {
            if (ChatManager.debug) {
                Log.v(TAG, "闪聊匹配成功");
            }
            FlashVideo flashVideo3 = this.flashVideo;
            if (flashVideo3 != null) {
                flashVideo3.receiveMatchedPush(pushMsgPackage);
            }
        } else if (s == 72) {
            if (ChatManager.debug) {
                Log.v(TAG, "对方结束闪聊");
            }
            FlashVideo flashVideo4 = this.flashVideo;
            if (flashVideo4 != null) {
                flashVideo4.receiveFlashVideoClosePush(pushMsgPackage);
            }
        } else if (s == 136) {
            if (ChatManager.debug) {
                Log.v(TAG, "收到闪聊好友申请消息");
            }
            FlashVideo flashVideo5 = this.flashVideo;
            if (flashVideo5 != null) {
                flashVideo5.receiveFlashVideoFriendApply(pushMsgPackage);
            }
        } else if (s == 137) {
            if (ChatManager.debug) {
                Log.v(TAG, "收到SayHi消息");
            }
            FlashVideo flashVideo6 = this.flashVideo;
            if (flashVideo6 != null) {
                flashVideo6.receiveFlashVideoSayHi(pushMsgPackage);
            }
        } else {
            switch (s) {
                case 95:
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到闪聊好友申请成功消息");
                    }
                    FlashVideo flashVideo7 = this.flashVideo;
                    if (flashVideo7 != null) {
                        flashVideo7.receiveFlashVideoFriendApplyAgree(pushMsgPackage);
                        return;
                    }
                    return;
                case 96:
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到闪聊申请加时消息");
                    }
                    FlashVideo flashVideo8 = this.flashVideo;
                    if (flashVideo8 != null) {
                        flashVideo8.receiveFlashVideoApplyExtraTime(pushMsgPackage);
                        return;
                    }
                    return;
                case 97:
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到闪聊对方匹配确认消息");
                    }
                    FlashVideo flashVideo9 = this.flashVideo;
                    if (flashVideo9 != null) {
                        flashVideo9.receiveFlashVideoMatchAgree(pushMsgPackage);
                        return;
                    }
                    return;
                default:
                    if (ChatManager.debug) {
                        Log.e(TAG, "无法识别的order消息:" + pushMsgPackage);
                        return;
                    }
                    return;
            }
        }
    }

    private void recvDeletePackage(DeleteAckPackage deleteAckPackage) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recvDeleteRetractAckPackage(DeleteRetractMessagePackage deleteRetractMessagePackage) {
        SessionModel sessionModel;
        boolean z;
        boolean z2;
        boolean z3;
        long j = deleteRetractMessagePackage.sessionId;
        long j2 = j;
        if (isTempSessionMessage(deleteRetractMessagePackage.sessionType, deleteRetractMessagePackage.sessionId, deleteRetractMessagePackage.messageId)) {
            j2 = j;
            if (deleteRetractMessagePackage.sessionId > 0) {
                j2 = -deleteRetractMessagePackage.sessionId;
            }
        }
        String sessionKey = SessionHeader.getSessionKey(deleteRetractMessagePackage.sessionType, j2);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                if (sessionModel.maxMsgId == deleteRetractMessagePackage.messageId) {
                    sessionModel.lastMsgType = (short) 55;
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (sessionModel._msgList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= sessionModel._msgList.size()) {
                            break;
                        }
                        ChattingModel chattingModel = sessionModel._msgList.get(i2);
                        if (chattingModel.msgId == deleteRetractMessagePackage.messageId) {
                            ChattingModel chattingModel2 = new ChattingModel(chattingModel);
                            sessionModel._msgList.set(i2, chattingModel2);
                            chattingModel2.msgType = (short) 55;
                            ChatManager.dbOperImpl.updateChattingModel(chattingModel2);
                            z2 = z3;
                            z = true;
                            break;
                        }
                        i = i2 + 1;
                    }
                }
                z2 = z3;
                z = false;
            } else {
                z = false;
                z2 = false;
            }
        }
        if (z) {
            notifyMsgListChanged(deleteRetractMessagePackage.sessionType, j2);
        }
        if (z2) {
            notifySessionChanged(sessionModel);
        }
    }

    private void recvDeleteRetractAckPackage(DeleteRetractMessagePackage deleteRetractMessagePackage, DeleteAckPackage deleteAckPackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "recvDeleteRetractAckPackage(), sessionType:" + ((int) deleteRetractMessagePackage.sessionType) + ", sessionId:" + deleteRetractMessagePackage.sessionId + ", messageId:" + deleteRetractMessagePackage.messageId + "localId:" + deleteAckPackage.localId);
        }
        recvDeleteRetractAckPackage(deleteRetractMessagePackage);
    }

    private void recvOnlineBothInterest(List<ChattingModel> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        ChattingModel chattingModel = list.get(0);
        if (chattingModel.msgType != 288) {
            return;
        }
        long j = chattingModel.sessionId;
        long j2 = j;
        if (j > 0) {
            j2 = -j;
        }
        String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, j2);
        synchronized (this.msgListenerList) {
            Set<MsgContentListener> set = this.msgListenerList.get(sessionKey);
            z = false;
            if (set != null) {
                z = false;
                if (set.size() > 0) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        recvSycBothInterest(list);
    }

    private void recvPushMsgPackage(PushMsgPackage pushMsgPackage) {
        RoomChat roomChat;
        ChatHelper.checkMsgType(pushMsgPackage);
        if (pushMsgPackage.fromId == ChatManager.userInfo.uid && pushMsgPackage.msgType == 17) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair<>(Short.valueOf(pushMsgPackage.sessionType), Long.valueOf(pushMsgPackage.sessionId)));
            deleteSessions(arrayList, true, false, true);
        } else if (pushMsgPackage.pushBasePackage.msgHeader.isOrder) {
            if (ChatManager.debug) {
                Log.e(TAG, "msgHeader.isOrder");
            }
            receiveOrderMessage(pushMsgPackage);
        } else if (pushMsgPackage.sessionType == 1 && (pushMsgPackage.sessionId == 16 || pushMsgPackage.sessionId == 25)) {
            ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
            ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
            if (tipsListener != null) {
                tipsListener.onRecvNewMsg(null, msgData);
            }
        } else if (pushMsgPackage.sessionType == 7 && ((roomChat = this.roomChat) == null || roomChat.handleRoomMessage(pushMsgPackage))) {
        } else {
            ChattingModel msgData2 = PushMsgPackage.toMsgData(pushMsgPackage);
            if (ChatManager.debug) {
                Log.e(TAG, "msgType: " + ((int) msgData2.msgType) + "--fromId: " + msgData2.isFromSelf());
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(msgData2);
            insertRecvMsgList(arrayList2);
            setMsgAndSessionReadFlag(msgData2);
        }
    }

    private void recvReqAckPackage(ReqAckPackage reqAckPackage) {
        switch (reqAckPackage.reqType) {
            case 3:
                LiveChat liveChat = this.liveChat;
                if (liveChat != null) {
                    liveChat.recvReqCreateLiveChatPackage(reqAckPackage, null);
                    return;
                }
                return;
            case 4:
                LiveChat liveChat2 = this.liveChat;
                if (liveChat2 != null) {
                    liveChat2.recvReqCloseLiveChatPackage(reqAckPackage);
                    return;
                }
                return;
            case 5:
            case 7:
            default:
                if (ChatManager.debug) {
                    Log.e(TAG, "unknown package recvReqAckPackage, pack:" + reqAckPackage);
                    return;
                }
                return;
            case 6:
                LiveChat liveChat3 = this.liveChat;
                if (liveChat3 != null) {
                    liveChat3.recvReqEnterLiveChatPackage(reqAckPackage, null);
                    return;
                }
                return;
            case 8:
                LiveChat liveChat4 = this.liveChat;
                if (liveChat4 != null) {
                    liveChat4.recvReqGetLiveChatInfoPackage(reqAckPackage);
                    return;
                }
                return;
            case 9:
                LiveChat liveChat5 = this.liveChat;
                if (liveChat5 != null) {
                    liveChat5.recvReqRecoverLiveChatPackage(reqAckPackage);
                    return;
                }
                return;
            case 10:
                return;
            case 11:
                LiveChat liveChat6 = this.liveChat;
                if (liveChat6 != null) {
                    liveChat6.recvReqJoinLivePackage(reqAckPackage);
                    return;
                }
                return;
        }
    }

    private boolean recvSendAckPackage(SendAckPackage sendAckPackage) {
        SendMsgPackage sendMsgPackage;
        synchronized (this.sendingPackageList) {
            sendMsgPackage = this.sendingPackageList.get(sendAckPackage.localId);
            if (sendMsgPackage != null) {
                this.sendingPackageList.remove(sendAckPackage.localId);
            }
        }
        if (sendMsgPackage == null) {
            if (ChatManager.debug) {
                Log.e(TAG, "the send ack can't find sending package");
                return false;
            }
            return false;
        }
        if (ChatManager.debug) {
            Log.v(TAG, "recv send ack for pack:" + sendAckPackage);
        }
        DataUtils.imMessageSuccess(BasePackage.typeToString(sendMsgPackage), SystemClock.uptimeMillis() - sendMsgPackage.sendTime);
        notifySendPackageStateChanged(sendMsgPackage, sendAckPackage.result, sendAckPackage);
        return true;
    }

    private void recvSycBothInterest(List<ChattingModel> list) {
        ChattingModel chattingModel;
        ChattingModel chattingModel2;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size() - 1;
        ChattingModel chattingModel3 = null;
        while (true) {
            chattingModel = chattingModel3;
            if (size < 0) {
                break;
            }
            ChattingModel chattingModel4 = list.get(size);
            if (chattingModel4.msgType != 281 && chattingModel4.msgType != 287 && chattingModel4.msgType != 282 && chattingModel4.msgType != 283) {
                chattingModel2 = chattingModel;
                if (chattingModel4.msgType != 288) {
                    size--;
                    chattingModel3 = chattingModel2;
                }
            }
            if (chattingModel != null || chattingModel4.isFromSelf()) {
                if (chattingModel4.msgType != 282) {
                    chattingModel2 = chattingModel;
                    if (chattingModel4.msgType != 288) {
                    }
                }
                try {
                    String msgExtra = chattingModel4.getMsgExtra();
                    String str = msgExtra;
                    if (TextUtils.isEmpty(msgExtra)) {
                        str = "{}";
                    }
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    asJsonObject.remove("played");
                    asJsonObject.addProperty("played", (Number) 1);
                    chattingModel4.setMsgExtra(asJsonObject.toString());
                    chattingModel2 = chattingModel;
                } catch (Exception e) {
                    e.printStackTrace();
                    chattingModel2 = chattingModel;
                }
            } else {
                chattingModel2 = chattingModel4;
            }
            size--;
            chattingModel3 = chattingModel2;
        }
        if (chattingModel == null || chattingModel.msgType != 288) {
            return;
        }
        long j = chattingModel.sessionId;
        long j2 = j;
        if (j > 0) {
            j2 = -j;
        }
        mergeAllTempChatting(chattingModel.sessionType, j2, null);
    }

    private void recvSyncMsgList(List<ChattingModel> list) {
        if (ChatManager.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("recvSyncMsgList(), syncMsgList size:");
            sb.append(list == null ? 0 : list.size());
            Log.v(TAG, sb.toString());
        }
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        for (ChattingModel chattingModel : list) {
            String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
            List list2 = (List) arrayMap.get(sessionKey);
            ArrayList arrayList = list2;
            if (list2 == null) {
                arrayList = new ArrayList();
                arrayMap.put(sessionKey, arrayList);
            }
            arrayList.add(chattingModel);
        }
        for (List<ChattingModel> list3 : arrayMap.values()) {
            recvSycBothInterest(list3);
            MsgComparator.sortPair(list3);
            insertRecvMsgList(list3);
            setMsgAndSessionReadFlag(list3.get(list3.size() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recvSyncPackage(SyncOuterClass.SyncResponse syncResponse, LoadListener loadListener, List<ChattingModel> list) {
        if (ChatManager.debug) {
            Log.v(TAG, "recv sync response :" + syncResponse);
        }
        if (syncResponse.getError() != SyncErrorCode.ErrorCode.ErrorCodeOK) {
            if (list == null) {
                if (loadListener != null) {
                    loadListener.onLoadFailed(e.f4661a);
                    return;
                }
                return;
            }
            insertMsgListToMemory(list);
            if (loadListener != null) {
                loadListener.onLoadSuccess();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SyncMessageOuterClass.SyncMessage syncMessage : syncResponse.getMessagesList()) {
            SyncChattingModel syncChattingModel = TextUtils.isEmpty(syncMessage.getBody()) ? null : (SyncChattingModel) ChatHelper.getGson().fromJson(syncMessage.getBody(), (Class<Object>) SyncChattingModel.class);
            if (syncChattingModel != null) {
                syncChattingModel.sessionId = syncMessage.getSessionId();
                syncChattingModel.sessionType = (short) syncMessage.getSessionType();
                syncChattingModel.msgId = syncMessage.getMsgId();
                syncChattingModel.timestamp = syncMessage.getTimestamp();
                syncChattingModel.distance = syncMessage.getDistance();
                syncChattingModel.isRead = syncMessage.getIsRead() == 1;
                syncChattingModel.isDeleted = syncMessage.getIsDeleted() == 1;
                ChattingModel chattingModel = syncChattingModel.toChattingModel();
                ChatHelper.checkMsgType(chattingModel);
                arrayList.add(chattingModel);
            }
        }
        mergeLocalMsgListForSync(list, arrayList);
        recvSyncMsgList(arrayList);
        if (loadListener != null) {
            loadListener.onLoadSuccess();
        }
    }

    private boolean removeSessionAtMsgId(SessionModel sessionModel) {
        if (sessionModel.atMessageId > 0 || sessionModel.evaluationMsgId > 0) {
            sessionModel.atMessageId = 0L;
            sessionModel.evaluationMsgId = 0L;
            return true;
        }
        return false;
    }

    private boolean removeSessionUnreadMsg(SessionModel sessionModel) {
        boolean z;
        if (sessionModel._unreadedMsgIds != null) {
            sessionModel._unreadedMsgIds.clear();
        }
        if (sessionModel.noReadMsgCount != 0) {
            sessionModel.noReadMsgCount = 0;
            ChatHelper.clearSessionLikeNum(sessionModel);
            z = true;
        } else {
            z = false;
        }
        if (sessionModel.noReadRedDot == 1) {
            sessionModel.noReadRedDot = 0;
            z = true;
        }
        if (sessionModel.maxHasReadMsgID < sessionModel.maxMsgId) {
            sessionModel.maxHasReadMsgID = sessionModel.maxMsgId;
            z = true;
        }
        if (sessionModel.secretLookStatus == 1) {
            sessionModel.secretLookStatus = 0;
            return true;
        }
        return z;
    }

    private void requestSessionData(final SessionModel sessionModel) {
        if (sessionModel._isRequestingInfo) {
            return;
        }
        sessionModel._isRequestingInfo = true;
        IM.a(sessionModel.sessionType, (int) getSessionId(sessionModel.sessionId), (int) ChatHelper.getLocalId(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.Chat.6
            @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
            public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                if (generatedMessageV3 != null) {
                    Chat.this.processSessionInfo(sessionModel.sessionType, (int) sessionModel.sessionId, (ReqOuterClass.SessionInfoResponse) generatedMessageV3);
                }
            }
        });
    }

    private void resetSessionNoReadMsgCnt(short s, long j, long j2) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            boolean z = false;
            if (sessionModel != null) {
                z = false;
                if (j2 >= sessionModel.maxMsgId) {
                    z = false;
                    if (sessionModel.noReadMsgCount > 0) {
                        sessionModel.noReadMsgCount = 0;
                        ChatHelper.clearSessionLikeNum(sessionModel);
                        z = true;
                    }
                }
            }
            if (z) {
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
    }

    private void sendDeleteAllSessionsRequest(boolean z) {
        try {
            IM.a(ReceiptOuterClass.ReceiptRequest.newBuilder().setCommon(Common.a().b()).setFrom((int) ChatManager.userInfo.uid).setIsDeleteMsg(z).build(), (GrpcUnaryCall.OnFinishListener) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendDeleteOneSessionsRequest(short s, long j, boolean z) {
        try {
            IM.e(s == 3, ReceiptOuterClass.ReceiptRequest.newBuilder().setCommon(Common.a().b()).setSessionType(s).setFrom((int) ChatManager.userInfo.uid).setTo((int) getSessionId(j)).setIsDeleteMsg(z).build(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendDestroyMsgReqToServer(short s, long j, long j2) {
        IM.a(s, (int) getSessionId(j), (int) ChatHelper.getLocalId(), j2, null);
    }

    private void sendMsgPackageFailed(SendMsgPackage sendMsgPackage, int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendMsgPackageFailed(), msgPackage:" + sendMsgPackage + ", failedReason:" + i);
        }
        synchronized (this.sendingPackageList) {
            this.sendingPackageList.remove(sendMsgPackage.localId);
        }
        notifySendPackageStateChanged(sendMsgPackage, i);
    }

    private void sendMsgToServer(ChattingModel chattingModel) {
        SendMsgPackage sendMsgPackageFromChattingModel = ChatHelper.getSendMsgPackageFromChattingModel(chattingModel);
        synchronized (this.sendingPackageList) {
            this.sendingPackageList.put(sendMsgPackageFromChattingModel.localId, sendMsgPackageFromChattingModel);
        }
        TimeoutUtils.addTimeoutPackage(sendMsgPackageFromChattingModel.localId, sendMsgPackageFromChattingModel, 30000L, this);
        this.connector.sendPackage(sendMsgPackageFromChattingModel);
    }

    private boolean sendReadReceiptLater(ChattingModel chattingModel, boolean z) {
        if (chattingModel.msgType == 3 || chattingModel.msgType == 24 || chattingModel.msgType == 25 || chattingModel.identifyYellow == 1) {
            return true;
        }
        if (z) {
            String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
            synchronized (this.sessionList) {
                SessionModel sessionModel = this.sessionList.get(sessionKey);
                if (sessionModel != null && sessionModel._msgList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= sessionModel._msgList.size()) {
                            break;
                        }
                        ChattingModel chattingModel2 = sessionModel._msgList.get(i2);
                        if (chattingModel2.msgId == chattingModel.msgId) {
                            return chattingModel2.identifyYellow == 1;
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        ChattingModel findMsgData = ChatManager.dbOperImpl.findMsgData(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, 0L);
        return findMsgData != null && findMsgData.identifyYellow == 1;
    }

    private boolean sendReadedFlagForSession(SessionModel sessionModel) {
        if (sessionModel == null || sessionModel.lastMsgFromId == ChatManager.getInstance().getUid() || sessionModel.maxHasReadMsgID >= sessionModel.lastMsgId) {
            return false;
        }
        long j = sessionModel.lastMsgId;
        if (ChatManager.dbOperImpl != null) {
            long findReadReceiptMaxMessageId = ChatManager.dbOperImpl.findReadReceiptMaxMessageId(sessionModel.sessionType, sessionModel.sessionId);
            if (findReadReceiptMaxMessageId > -1) {
                j = findReadReceiptMaxMessageId;
            }
        }
        this.readFlagSender.sendReceiptImmediate(sessionModel.sessionType, sessionModel.sessionId, j, ReadFlagSender.ReceiptType.READ);
        sessionModel.maxHasReadMsgID = sessionModel.lastMsgId;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSyncAllPackage(long j, long j2) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            if (ChatManager.debug) {
                Log.v(TAG, "syncType: SYNC_NEW");
            }
        } else if (ChatManager.debug) {
            Log.v(TAG, "syncType: SYNC_ALL");
        }
        syncStart();
        try {
            IM.a(SyncOuterClass.SyncRequest.newBuilder().setSyncType(i > 0 ? SyncOuterClass.SyncType.SyncNew : SyncOuterClass.SyncType.SyncAll).setLocalId((int) ChatHelper.getLocalId()).setSyncLocalId((int) j2).build(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.Chat.4
                @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
                public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                    if (generatedMessageV3 == null) {
                        if (Chat.this.retrySyncMsg(true)) {
                            return;
                        }
                        Chat.this.syncFinish();
                        return;
                    }
                    SyncOuterClass.SyncResponse syncResponse = (SyncOuterClass.SyncResponse) generatedMessageV3;
                    if (Chat.this.initMaxMsgId == 0) {
                        if (syncResponse.getMessagesList().size() > 0) {
                            Chat.this.initMaxMsgId = syncResponse.getMessagesList().get(0).getMsgId();
                        } else {
                            Chat.this.initMaxMsgId = 1L;
                        }
                    }
                    Chat.this.recvSyncPackage(syncResponse, null, null);
                    if (syncResponse.getContinue() != 1) {
                        Chat.this.syncFinish();
                        return;
                    }
                    Chat chat = Chat.this;
                    chat.sendSyncAllPackage(chat.initMaxMsgId, syncResponse.getSyncLocalId());
                }
            });
        } catch (Exception e) {
            if (!retrySyncMsg(true)) {
                syncFinish();
            }
            e.printStackTrace();
        }
    }

    private void sendSyncMsgPackage(short s, long j, long j2, long j3, final LoadListener loadListener, final List<ChattingModel> list) {
        long j4;
        if (ChatManager.debug) {
            Log.v(TAG, "sendSyncMsgPackage(), sessionType:" + ((int) s) + ", sessionId:" + j + ", startId:" + j2 + ", endId:" + j3 + ", loadListener:" + loadListener);
        }
        Pair<Long, Long> checkSyncRange = checkSyncRange(s, j, j3);
        if (checkSyncRange != null) {
            j2 = checkSyncRange.first.longValue();
            j4 = checkSyncRange.second.longValue();
        } else {
            j4 = j3;
        }
        long j5 = j;
        if (j < 0) {
            j5 = -j;
        }
        long localId = ChatHelper.getLocalId();
        long j6 = j2;
        if (j2 > 0) {
            j6 = j2 + 1;
        }
        long j7 = j4;
        if (j4 > 0) {
            j7 = j4 - 1;
        }
        if (j6 > j7) {
            if (loadListener != null) {
                loadListener.onLoadSuccess();
                return;
            }
            return;
        }
        if (ChatManager.debug) {
            Log.v(TAG, "sendedSyncMsgPackage(), sessionType:" + ((int) s) + ", sessionId:" + j5 + ", startId:" + j6 + ", endId:" + j7 + ", loadListener:" + loadListener);
        }
        try {
            try {
                IM.a(SyncOuterClass.SyncRequest.newBuilder().setSyncType(SyncOuterClass.SyncType.SyncRange).setSessionType(s).setSessionId((int) j5).setLocalId((int) localId).setStartId(j6).setStopId(j7).build(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.Chat.5
                    @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
                    public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                        if (generatedMessageV3 == null) {
                            Chat.this.sendSyncPackageFailed(loadListener, list);
                            return;
                        }
                        Chat.this.recvSyncPackage((SyncOuterClass.SyncResponse) generatedMessageV3, loadListener, list);
                    }
                });
            } catch (Exception e) {
                e = e;
                sendSyncPackageFailed(loadListener, list);
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSyncPackageFailed(LoadListener loadListener, List<ChattingModel> list) {
        if (list == null) {
            if (loadListener != null) {
                loadListener.onLoadFailed(e.f4661a);
                return;
            }
            return;
        }
        insertMsgListToMemory(list);
        if (loadListener != null) {
            loadListener.onLoadSuccess();
        }
    }

    private void setMsgAndSessionReadFlag(ChattingModel chattingModel) {
        if (!chattingModel.isFromSelf()) {
            setMsgReadedFlag(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
            if (chattingModel._pushMsgPackage.isReaded()) {
                resetSessionNoReadMsgCnt(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
            }
        } else if (chattingModel.sessionType != 3 || chattingModel.msgStateCode == 2) {
            resetSessionNoReadMsgCnt(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
            if (chattingModel._pushMsgPackage.isReaded()) {
                setMsgReadedFlag(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
            }
        }
    }

    private void setMsgReadedFlag(short s, long j, long j2) {
        SessionModel sessionModel;
        boolean z;
        boolean z2;
        boolean z3;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            boolean z4 = false;
            if (sessionModel != null) {
                if (sessionModel.lastMsgId == j2 && sessionModel.lastMsgStateCode == 2) {
                    sessionModel.lastMsgStateCode = (short) 3;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (sessionModel._msgList != null) {
                    z4 = false;
                    for (ChattingModel chattingModel : sessionModel._msgList) {
                        if (chattingModel.msgId <= j2 && chattingModel.msgStateCode == 2 && !sendReadReceiptLater(chattingModel, false)) {
                            chattingModel.msgStateCode = (short) 3;
                            z4 = true;
                        }
                    }
                }
                if (z3) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                }
                z2 = z3;
                z = z4;
            } else {
                if (ChatManager.debug) {
                    Log.v(TAG, "session is null, it may be deleted");
                }
                z = false;
                z2 = false;
            }
            ChatManager.dbOperImpl.readedAllMsg(s, j, j2);
        }
        if (z) {
            notifyMsgListChanged(s, j);
        }
        if (z2) {
            notifySessionChanged(sessionModel);
        }
    }

    private void setOneMsgReadedFlag(short s, long j, long j2) {
        SessionModel sessionModel;
        boolean z;
        boolean z2;
        boolean z3;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                if (sessionModel.lastMsgId == j2 && sessionModel.lastMsgStateCode == 2) {
                    sessionModel.lastMsgStateCode = (short) 3;
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z4 = false;
                if (sessionModel._msgList != null) {
                    Iterator<ChattingModel> it = sessionModel._msgList.iterator();
                    while (true) {
                        z4 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        ChattingModel next = it.next();
                        if (next.msgId == j2 && next.msgStateCode == 2) {
                            next.msgStateCode = (short) 3;
                            z4 = true;
                            break;
                        }
                    }
                }
                if (z3) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                }
                z2 = z3;
                z = z4;
            } else {
                if (ChatManager.debug) {
                    Log.v(TAG, "session is null, it may be deleted");
                }
                z = false;
                z2 = false;
            }
            ChatManager.dbOperImpl.readedOneMsg(s, j, j2);
        }
        if (z) {
            notifyMsgListChanged(s, j);
        }
        if (z2) {
            notifySessionChanged(sessionModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncFinish() {
        this.dataSyncing = false;
        notifyIMStatusListener();
    }

    private void syncStart() {
        this.dataSyncing = true;
        notifyIMStatusListener();
    }

    private void updateSendingMsgId(SessionModel sessionModel, long j, long j2) {
        if (sessionModel._msgList != null && sessionModel._msgList.size() > 0) {
            int i = 0;
            int size = sessionModel._msgList.size() - 1;
            while (size >= 0) {
                int i2 = i;
                if (sessionModel._msgList.get(size).msgLocalId != 0) {
                    i2 = i;
                    if (sessionModel._msgList.get(size).msgLocalId > j2) {
                        i2 = i;
                        if (sessionModel._msgList.get(size).msgStateCode == 1) {
                            sessionModel._msgList.get(size).msgId = j;
                            i2 = i + 1;
                        }
                    }
                }
                size--;
                i = i2;
            }
            if (i > 1) {
                Collections.sort(sessionModel._msgList, new MsgComparator());
            }
        }
        ChatManager.dbOperImpl.updateSendingMsgId(j, sessionModel.sessionType, sessionModel.sessionId, j2);
    }

    public void clearAllSecretLook() {
        boolean z;
        synchronized (this.sessionList) {
            z = false;
            for (SessionModel sessionModel : this.sessionList.values()) {
                if (sessionModel.secretLookStatus == 1) {
                    sessionModel.secretLookStatus = 0;
                    sessionModel._secretMsgListing = false;
                    if (ChatManager.dbOperImpl != null) {
                        ChatManager.dbOperImpl.updateSession(sessionModel);
                    }
                    z = true;
                }
            }
        }
        if (z) {
            notifySessionListChanged();
        }
    }

    public void deleteAllChattings() {
        if (ChatManager.debug) {
            Log.v(TAG, "deleteAllChattings()");
        }
        synchronized (this.sessionList) {
            ChatManager.dbOperImpl.deleteChattingForAll();
            for (SessionModel sessionModel : this.sessionList.values()) {
                if (sessionModel._msgList != null) {
                    sessionModel._msgList.clear();
                }
                SessionModel.removeSessionLastMsg(sessionModel);
            }
            ChatManager.dbOperImpl.updateAllLastMsgContentNull();
        }
        sendDeleteAllSessionsRequest(true);
        notifyAllSessionRemoved();
    }

    public void deleteAllSessions(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "deleteAllSessions()");
        }
        synchronized (this.sessionList) {
            if (z) {
                ChatManager.dbOperImpl.deleteSessionAndChattingForAll();
            } else {
                ChatManager.dbOperImpl.deleteSessionForAll();
            }
            ChatManager.dbOperImpl.deleteAllSessionSetting();
            this.sessionList.clear();
            synchronized (this.snapSessionList) {
                this.snapSessionList.clear();
            }
        }
        if (z) {
            notifyAllMsgListClear();
        }
        notifyAllSessionRemoved();
        sendDeleteAllSessionsRequest(z);
    }

    public void deleteChatting(int i, long j) {
        SessionModel sessionModel;
        if (ChatManager.debug) {
            Log.v(TAG, "deleteChatting(), sessionType:" + i + ", sessionId:" + j);
        }
        String sessionKey = SessionHeader.getSessionKey(i, j);
        boolean z = false;
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                if (sessionModel._msgList != null) {
                    sessionModel._msgList.clear();
                }
                removeSessionUnreadMsg(sessionModel);
                removeSessionAtMsgId(sessionModel);
                ChatManager.dbOperImpl.deleteChattingForOne(i, j);
                z = true;
            }
        }
        notifyMsgListChanged(i, j);
        if (z) {
            notifySessionChanged(sessionModel);
        }
        sendDeleteOneSessionsRequest(sessionModel.sessionType, sessionModel.sessionId, true);
    }

    public void deleteLocalChatting(int i, long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "deleteLocalChatting(), sessionType:" + i + ", sessionId:" + j);
        }
        String sessionKey = SessionHeader.getSessionKey(i, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel == null) {
                return;
            }
            if (sessionModel._msgList != null) {
                sessionModel._msgList.clear();
            }
            removeSessionUnreadMsg(sessionModel);
            removeSessionAtMsgId(sessionModel);
            ChatManager.dbOperImpl.deleteChattingForOne(i, j);
            notifyMsgListChanged(i, j);
            notifySessionChanged(sessionModel);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteOneMessage(short r6, long r7, long r9, long r11) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.core.worker.chat.Chat.deleteOneMessage(short, long, long, long):void");
    }

    public void deleteSessions(List<Pair<Short, Long>> list, boolean z) {
        deleteSessions(list, z, true, false);
    }

    public void deleteSessionsWithSetting(List<Pair<Short, Long>> list, boolean z) {
        deleteSessions(list, z, true, true);
    }

    public void destroyMsg(short s, long j, ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "destroyMsg(), msgData:" + chattingModel);
        }
        chattingModel.msgContent = "";
        updateMsgData(chattingModel);
        if (chattingModel.fromId != ChatManager.userInfo.uid) {
            sendDestroyMsgReqToServer(s, j, chattingModel.msgId);
        }
    }

    public ChattingModel findMessage(short s, long j, long j2, long j3, LoadMsgListener loadMsgListener) {
        ChattingModel chattingModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && sessionModel._msgList != null) {
                Iterator<ChattingModel> it = sessionModel._msgList.iterator();
                while (it.hasNext()) {
                    chattingModel = it.next();
                    if (chattingModel.msgId == j2 && chattingModel.msgLocalId == j3) {
                        break;
                    }
                }
            }
            chattingModel = null;
        }
        ChattingModel chattingModel2 = chattingModel;
        if (chattingModel == null) {
            chattingModel2 = ChatManager.dbOperImpl.findMsgData(s, j, j2, j3);
        }
        if (loadMsgListener != null && chattingModel2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(chattingModel2);
            loadMsgListener.onLoadFinish(arrayList);
        }
        return chattingModel2;
    }

    public void getSessionModel(short s, long j, FetchDataListener<SessionModel> fetchDataListener) {
        SessionModel sessionModel;
        if (ChatManager.debug) {
            Log.v(TAG, "getSessionModel()");
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
        }
        if (fetchDataListener != null) {
            fetchDataListener.onFetchData(sessionModel);
        }
    }

    public void getSessionModelList(FetchDataListener<List<SessionModel>> fetchDataListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "getSessionModelList()");
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.sessionList) {
            arrayList.addAll(this.sessionList.values());
        }
        if (fetchDataListener != null) {
            fetchDataListener.onFetchData(arrayList);
        }
    }

    public void getSessionModelMap(FetchDataListener<Map<String, SessionModel>> fetchDataListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "getSessionModelMap()");
        }
        ArrayMap arrayMap = new ArrayMap();
        synchronized (this.sessionList) {
            arrayMap.putAll(this.sessionList);
        }
        if (fetchDataListener != null) {
            fetchDataListener.onFetchData(arrayMap);
        }
    }

    public void getSessionSettingModel(short s, long j, FetchDataListener<SessionSettingBaseModel> fetchDataListener) {
        SessionSettingBaseModel sessionSetting;
        if (ChatManager.debug) {
            Log.v(TAG, "getSessionSettingModel()");
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            sessionSetting = sessionModel != null ? sessionModel.sessionSettingModel : ChatManager.dbOperImpl.getSessionSetting(s, j);
        }
        if (fetchDataListener != null) {
            fetchDataListener.onFetchData(sessionSetting);
        }
    }

    public SessionModel getSnapSessionModel(short s, long j) {
        SessionModel sessionModel;
        if (ChatManager.debug) {
            Log.v(TAG, "getSnapSessionModel()");
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.snapSessionList) {
            sessionModel = this.snapSessionList.get(sessionKey);
        }
        return sessionModel;
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public String getWorkerName() {
        return TXCopyrightedMedia.PLAY_SCENE_CHAT;
    }

    public void ignoredNoReadNumAll() {
        if (ChatManager.debug) {
            Log.v(TAG, "ignoredNoReadNumAll()");
        }
        HashSet hashSet = new HashSet();
        synchronized (this.sessionList) {
            for (SessionModel sessionModel : this.sessionList.values()) {
                if (removeSessionUnreadMsg(sessionModel)) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                    hashSet.add(sessionModel);
                }
            }
        }
        if (hashSet.size() > 0) {
            notifySessionChanged(hashSet);
        }
    }

    public void ignoredNoReadNumForSessions(List<Pair<Short, Long>> list) {
        if (ChatManager.debug) {
            Log.v(TAG, "ignoredNoReadNumAll()");
        }
        if (list == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        synchronized (this.sessionList) {
            for (Pair<Short, Long> pair : list) {
                SessionModel sessionModel = this.sessionList.get(SessionHeader.getSessionKey(pair.first.shortValue(), pair.second.longValue()));
                if (sessionModel != null && removeSessionUnreadMsg(sessionModel)) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                    hashSet.add(sessionModel);
                }
            }
        }
        if (hashSet.size() > 0) {
            notifySessionChanged(hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SessionModel insertEmptySession(short s, long j) {
        SessionModel sessionModel;
        if (ChatManager.debug) {
            Log.d(TAG, "insertEmptySession(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        boolean z = false;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel2 = this.sessionList.get(sessionKey);
            sessionModel = sessionModel2;
            if (sessionModel2 == null) {
                SessionModel createEmptySessionModel = ChatHelper.createEmptySessionModel(s, j);
                this.sessionList.put(sessionKey, createEmptySessionModel);
                synchronized (this.snapSessionList) {
                    this.snapSessionList.put(sessionKey, createEmptySessionModel);
                }
                z = true;
                sessionModel = createEmptySessionModel;
                if (ChatManager.debug) {
                    Log.v(TAG, "session don't exit, create it");
                    z = true;
                    sessionModel = createEmptySessionModel;
                }
            }
        }
        if (z) {
            notifySessionChanged(sessionModel);
        }
        return sessionModel;
    }

    public int insertMsgListFromBackup(List<ChattingModel> list) {
        int i = -1;
        if (list == null || list.size() == 0) {
            return -1;
        }
        synchronized (this.sessionList) {
            if (ChatManager.dbOperImpl != null) {
                i = ChatManager.dbOperImpl.insertMsgListFromBackup(list);
            }
        }
        return i;
    }

    public int insertSessionList(List<SessionModel> list) {
        int insertSessionList;
        if (list == null || list.size() == 0) {
            return -1;
        }
        synchronized (this.sessionList) {
            insertSessionList = ChatManager.dbOperImpl != null ? ChatManager.dbOperImpl.insertSessionList(list) : -1;
            for (SessionModel sessionModel : list) {
                this.sessionList.put(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId), sessionModel);
                synchronized (this.snapSessionList) {
                    this.snapSessionList.put(SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId), sessionModel);
                }
            }
            notifySessionListChanged();
        }
        return insertSessionList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadDownSessionMsgList(short s, long j, long j2, long j3, int i, LoadListener loadListener) {
        Map<String, SessionModel> map;
        SessionModel sessionModel;
        StringBuilder sb;
        if (ChatManager.debug) {
            sb = new StringBuilder();
            sb.append("loadSessionMsgList(), sessionType:");
            sb.append((int) s);
            sb.append(", sessionId:");
            sb.append(j);
            sb.append(", count:");
            sb.append(i);
            sb.append(", listener:");
            sb.append(loadListener);
            Log.v(TAG, sb.toString());
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        ChattingModel chattingModel = null;
        Map<String, SessionModel> map2 = this.sessionList;
        synchronized (map2) {
            try {
            } catch (Throwable th) {
                th = th;
                map = sb;
            }
            try {
                sessionModel = this.sessionList.get(sessionKey);
                if (sessionModel != null && (j2 != -1 || j3 != -1)) {
                    sessionModel.isFromSearch = true;
                    chattingModel = ChatManager.dbOperImpl.findMsgData(s, j, j2, j3);
                }
            } catch (Throwable th2) {
                map = map2;
                th = th2;
                throw th;
            }
        }
        loadUpOrDownSessionMsgList(sessionModel, chattingModel, sessionKey, s, j, i, false, loadListener);
    }

    public void loadNewMsg(short s, long j, int i, LoadMsgListener loadMsgListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "loadNewMsg(), sessionType:" + ((int) s) + ", sessionId:" + j + ", count:" + i + ", listener:" + loadMsgListener);
        }
        List<ChattingModel> msgList = ChatManager.dbOperImpl.getMsgList(ChatManager.userInfo.uid, s, j, 0L, 0L, 0L, i, true);
        if (ChatManager.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("get msg list from db size:");
            sb.append(msgList == null ? b.l : Integer.valueOf(msgList.size()));
            Log.v(TAG, sb.toString());
        }
        if (msgList != null && msgList.size() > 0) {
            MsgComparator.sortAndDistinct(msgList);
        }
        if (loadMsgListener != null) {
            loadMsgListener.onLoadFinish(msgList);
        }
    }

    public void loadServiceSessionMsgList(short s, String str, ChattingModel chattingModel, int i, FetchDataListener<List<ChattingModel>> fetchDataListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "loadSessionMsgList(), sessionType:" + ((int) s) + ", sessionId:" + str + ", count:" + i + ", listener:" + fetchDataListener);
        }
        List<ChattingModel> serviceMsgFromDB = getServiceMsgFromDB(s, str, chattingModel, i);
        fetchDataListener.onFetchData(serviceMsgFromDB);
        if (ChatManager.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("get msg list from db size:");
            sb.append(serviceMsgFromDB == null ? b.l : Integer.valueOf(serviceMsgFromDB.size()));
            Log.v(TAG, sb.toString());
        }
    }

    public void loadSessionMsgList(short s, long j, int i, LoadListener loadListener) {
        SessionModel sessionModel;
        ChattingModel chattingModel;
        if (ChatManager.debug) {
            Log.v(TAG, "loadSessionMsgList(), sessionType:" + ((int) s) + ", sessionId:" + j + ", count:" + i + ", listener:" + loadListener);
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            chattingModel = null;
            if (sessionModel != null) {
                chattingModel = null;
                if (sessionModel._msgList != null) {
                    chattingModel = null;
                    if (sessionModel._msgList.size() > 0) {
                        chattingModel = sessionModel._msgList.get(0);
                    }
                }
            }
        }
        loadUpOrDownSessionMsgList(sessionModel, chattingModel, sessionKey, s, j, i, true, loadListener);
    }

    public void mergeAllTempChatting(short s, long j, MsgContentListener msgContentListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "mergeAllTempChatting(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        long j2 = j;
        if (j > 0) {
            j2 = -j;
        }
        String sessionKey = SessionHeader.getSessionKey(s, j2);
        String sessionKey2 = SessionHeader.getSessionKey(s, -j2);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                if (ChatManager.debug) {
                    Log.v(TAG, "mergeAllTempChatting(), change db all temp message to normal");
                }
                ChatManager.dbOperImpl.changeAllTempMsgToNormal(s, j2);
                if (ChatManager.debug) {
                    Log.v(TAG, "mergeAllTempChatting(), delete db session=" + sessionKey);
                }
                ChatManager.dbOperImpl.deleteSessionForOne(s, j2);
                if (msgContentListener != null) {
                    unregisterMsgContentListener(sessionModel.sessionType, sessionModel.sessionId, msgContentListener);
                }
                if (ChatManager.debug) {
                    Log.v(TAG, "mergeAllTempChatting(), remove memory session=" + sessionKey);
                }
                this.sessionList.remove(sessionKey);
                synchronized (this.snapSessionList) {
                    this.snapSessionList.remove(sessionKey);
                }
                SessionModel sessionModel2 = this.sessionList.get(sessionKey2);
                if (sessionModel2 == null) {
                    sessionModel.sessionId = -sessionModel.sessionId;
                    this.sessionList.put(sessionKey2, sessionModel);
                    synchronized (this.snapSessionList) {
                        this.snapSessionList.put(sessionKey2, sessionModel);
                    }
                } else {
                    sessionModel = sessionModel2;
                }
                notifySessionListChanged();
                if (msgContentListener != null) {
                    registerMsgContentListener(sessionModel.sessionType, sessionModel.sessionId, msgContentListener, false);
                    if (ChatManager.debug) {
                        Log.v(TAG, "mergeAllTempChatting(), loadSessionMsgList()");
                    }
                    loadSessionMsgList(sessionModel.sessionType, sessionModel.sessionId, 20, new LoadListener() { // from class: com.blued.android.chat.core.worker.chat.Chat.2
                        @Override // com.blued.android.chat.listener.LoadListener
                        public void onLoadFailed(String str) {
                        }

                        @Override // com.blued.android.chat.listener.LoadListener
                        public void onLoadSuccess() {
                        }
                    });
                }
            }
        }
    }

    public void notifySendStateForGRPC(int i, ChattingModel chattingModel, short s, long j, short s2, long j2, long j3, long j4, String str) {
        long j5 = j;
        if (chattingModel != null) {
            j5 = j;
            if (chattingModel.isMatchMsg == 1) {
                long j6 = j;
                if (j > 0) {
                    j6 = -j;
                }
                j5 = j6;
                if (chattingModel.sessionId > 0) {
                    chattingModel.sessionId = -chattingModel.sessionId;
                    j5 = j6;
                }
            }
        }
        if (ChatManager.debug) {
            Log.v(TAG, "notifySendStateForGRPC(), chattingModel=[" + chattingModel + "], sessionId:" + j5);
        }
        SendMsgPackage sendMsgPackage = new SendMsgPackage(s, j5, j3, 0L, s2, null, null, null, 0L, null);
        if (i != 0) {
            notifySendPackageStateChanged(sendMsgPackage, chattingModel, i, null);
            return;
        }
        SendAckPackage sendAckPackage = new SendAckPackage();
        sendAckPackage.msgId = j2;
        sendAckPackage.msgTime = j4;
        sendAckPackage.msgPreviousId = j2 - 1;
        sendAckPackage.result = (short) 0;
        sendAckPackage.promptType = str;
        notifySendPackageStateChanged(sendMsgPackage, chattingModel, i, sendAckPackage);
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnected() {
        if (ChatManager.debug) {
            Log.v(TAG, "onConnected------->");
        }
        if (this.sessionListInited) {
            retrySyncMsg(false);
        }
        notifyIMStatusListener();
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnecting() {
        notifyIMStatusListener();
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onDisconnected() {
        notifyIMStatusListener();
    }

    @Override // com.blued.android.chat.core.utils.TimeoutUtils.TimeoutListener
    public void onPackageTimeout(long j, Object obj) {
        if (ChatManager.debug) {
            Log.v(TAG, "onPackageTimeout(), keyId:" + j + ", package:" + obj);
        }
        BasePackage basePackage = (BasePackage) obj;
        this.connector.cancelPackage(basePackage);
        if (ChatManager.debug && ChatManager.getInstance().debugTipsListener != null) {
            DebugTipsListener debugTipsListener = ChatManager.getInstance().debugTipsListener;
            debugTipsListener.onTips("超时未收到ack, pack:" + obj);
        }
        if (obj instanceof BasePackage) {
            String typeToString = BasePackage.typeToString(basePackage);
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = basePackage.sendTime;
            DataUtils.imMessageFailed(typeToString, uptimeMillis - j2, "package timeout, connect state:" + this.connector.getConnectStatus());
        }
        if (obj instanceof SendMsgPackage) {
            sendMsgPackageFailed((SendMsgPackage) obj, -2);
        }
    }

    @Override // com.blued.android.chat.listener.MsgPreProcesserListener
    public void onProcessToSave(ChattingModel chattingModel) {
        ChattingModel sendingMsgData;
        if (chattingModel.msgLocalId != 0 && (sendingMsgData = ChatManager.dbOperImpl.getSendingMsgData(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgLocalId)) != null && chattingModel.msgId != sendingMsgData.msgId) {
            chattingModel.msgId = sendingMsgData.msgId;
        }
        updateMsgData(chattingModel);
    }

    @Override // com.blued.android.chat.listener.MsgPreProcesserListener
    public void onProcessToSend(ChattingModel chattingModel) {
        sendMsgToServer(chattingModel);
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onReceive(BasePackage basePackage) {
        LiveChat liveChat;
        if (ChatManager.debug) {
            Log.v(TAG, "onReceive(), packType:" + ((int) basePackage.type));
        }
        if (ChatManager.debug && ChatManager.getInstance().debugTipsListener != null) {
            DebugTipsListener debugTipsListener = ChatManager.getInstance().debugTipsListener;
            debugTipsListener.onTips("收到服务器包, pack:" + basePackage);
        }
        if (!isWorking()) {
            if (ChatManager.debug) {
                Log.v(TAG, "stopped, don't deal any pack");
                return;
            }
            return;
        }
        short s = basePackage.type;
        if (s == 3) {
            if (!basePackage.ack || !(basePackage instanceof SendAckPackage)) {
                if (ChatManager.debug) {
                    Log.e(TAG, "can't handle this send pack");
                    return;
                }
                return;
            }
            SendAckPackage sendAckPackage = (SendAckPackage) basePackage;
            TimeoutUtils.cancelTimeoutPackage(sendAckPackage.localId);
            if (recvSendAckPackage(sendAckPackage) || (liveChat = this.liveChat) == null) {
                return;
            }
            liveChat.recvSendAckPackage(sendAckPackage);
        } else if (s != 4) {
            if (s != 6) {
                if (s != 7) {
                    if (ChatManager.debug) {
                        Log.e(TAG, "receive unknown package, pack:" + basePackage);
                    }
                } else if (!(basePackage instanceof ReqAckPackage)) {
                    if (ChatManager.debug) {
                        Log.e(TAG, "can't handle this req pack");
                    }
                } else {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage;
                    Object cancelTimeoutPackage = TimeoutUtils.cancelTimeoutPackage(reqAckPackage.localId);
                    if (cancelTimeoutPackage != null && (cancelTimeoutPackage instanceof ReqBasePackage) && reqAckPackage.reqType == -1) {
                        reqAckPackage.reqType = ((ReqBasePackage) cancelTimeoutPackage).reqType;
                    }
                    recvReqAckPackage(reqAckPackage);
                }
            }
        } else if (!(basePackage instanceof PushBasePackage)) {
            if (ChatManager.debug) {
                Log.e(TAG, "can't handle this push pack");
            }
        } else {
            PushBasePackage pushBasePackage = (PushBasePackage) basePackage;
            if (pushBasePackage.pushReadedPackage == null && pushBasePackage.pushMsgPackage != null) {
                if (ChatManager.debug) {
                    Log.e(TAG, "pushMsgPackage != null，sessionType：" + ((int) pushBasePackage.pushMsgPackage.sessionType));
                }
                MsgReceiveListener msgReceiveListener = ChatManager.getInstance().getMsgReceiveListener();
                if (msgReceiveListener != null) {
                    msgReceiveListener.onReceivePushMessage(PushMsgPackage.toMsgData(pushBasePackage.pushMsgPackage));
                }
                if (pushBasePackage.pushMsgPackage.sessionType == 4 || pushBasePackage.pushMsgPackage.sessionType == 5) {
                    LiveChat liveChat2 = this.liveChat;
                    if (liveChat2 != null) {
                        liveChat2.recvPushMsgPackage(pushBasePackage.pushMsgPackage);
                    }
                } else if (pushBasePackage.pushMsgPackage.sessionType == 6) {
                    if (this.wawajiControllerChat.handlePushMessage(pushBasePackage.pushMsgPackage)) {
                        return;
                    }
                    this.wawajiChat.handlePushMessage(pushBasePackage.pushMsgPackage);
                } else if (pushBasePackage.pushMsgPackage.sessionType == 8) {
                    if (this.wawajiControllerChat.handlePushMessage(pushBasePackage.pushMsgPackage)) {
                        return;
                    }
                    this.audioRoomChat.recvPushMsgPackage(pushBasePackage.pushMsgPackage);
                } else if (pushBasePackage.pushMsgPackage.sessionType == 9) {
                    if (this.wawajiControllerChat.handlePushMessage(pushBasePackage.pushMsgPackage)) {
                        return;
                    }
                    this.flashVideo.recvPushMsgPackage(pushBasePackage.pushMsgPackage);
                } else if (pushBasePackage.pushMsgPackage.sessionType == 10) {
                    if (this.wawajiControllerChat.handlePushMessage(pushBasePackage.pushMsgPackage)) {
                        return;
                    }
                    this.videoChat.recvPushMsgPackage(pushBasePackage.pushMsgPackage);
                } else {
                    if (ChatManager.debug) {
                        Log.e(TAG, "recvPushMsgPackage ==== " + pushBasePackage.pushMsgPackage.toString());
                    }
                    recvPushMsgPackage(pushBasePackage.pushMsgPackage);
                }
            }
        }
    }

    public void onReceiveMsgFromGRPC(ChattingModel chattingModel, boolean z, boolean z2) {
        PushBasePackage defaultInstance = PushBasePackage.getDefaultInstance();
        defaultInstance.msgHeader.isReaded = z;
        defaultInstance.msgHeader.isDeleted = z2;
        defaultInstance.pushMsgPackage.msgType = chattingModel.msgType;
        if (chattingModel.isMatchMsg == 1 && chattingModel.sessionId > 0) {
            chattingModel.sessionId = -chattingModel.sessionId;
        }
        if (defaultInstance.pushMsgPackage.msgType == 55) {
            defaultInstance.pushMsgPackage.fromId = chattingModel.fromId;
            defaultInstance.pushMsgPackage.msgId = chattingModel.msgId;
            defaultInstance.pushMsgPackage.sessionType = chattingModel.sessionType;
            defaultInstance.pushMsgPackage.sessionId = chattingModel.sessionId;
            receiveOrderMessage(defaultInstance.pushMsgPackage);
            return;
        }
        ChatHelper.checkMsgType(chattingModel);
        if (chattingModel.sessionType == 2 && chattingModel.msgStateCode == 3) {
            if (sendReadReceiptLater(chattingModel, true)) {
                setOneMsgReadedFlag(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
                return;
            } else {
                setMsgReadedFlag(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
                return;
            }
        }
        chattingModel._pushMsgPackage = defaultInstance.pushMsgPackage;
        ArrayList arrayList = new ArrayList();
        arrayList.add(chattingModel);
        insertRecvMsgList(arrayList);
        recvOnlineBothInterest(arrayList);
        setMsgAndSessionReadFlag(chattingModel);
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onSendFailed(BasePackage basePackage, String str) {
        LiveChat liveChat;
        if (ChatManager.debug) {
            Log.v(TAG, "onSendFailed(), pack:" + basePackage + ", failedMessage:" + str);
        }
        if (ChatManager.debug && ChatManager.getInstance().debugTipsListener != null) {
            DebugTipsListener debugTipsListener = ChatManager.getInstance().debugTipsListener;
            debugTipsListener.onTips("发送失败, pack:" + basePackage);
        }
        DataUtils.imMessageFailed(BasePackage.typeToString(basePackage), SystemClock.uptimeMillis() - basePackage.sendTime, str);
        short s = basePackage.type;
        if (s == 3) {
            if (!(basePackage instanceof SendMsgPackage)) {
                if (ChatManager.debug) {
                    Log.e(TAG, "unknown send package, drop it");
                    return;
                }
                return;
            }
            SendMsgPackage sendMsgPackage = (SendMsgPackage) basePackage;
            TimeoutUtils.cancelTimeoutPackage(sendMsgPackage.localId);
            if (sendMsgPackage.sessionType != 4 && sendMsgPackage.sessionType != 5) {
                sendMsgPackageFailed(sendMsgPackage, -1);
                return;
            }
            LiveChat liveChat2 = this.liveChat;
            if (liveChat2 != null) {
                liveChat2.sendMsgPackageFailed(sendMsgPackage, -1);
            }
        } else if (s != 7) {
            if (ChatManager.debug) {
                Log.e(TAG, "unknown package onSendFailed, pack:" + basePackage);
            }
        } else if (basePackage instanceof ReqBasePackage) {
            ReqBasePackage reqBasePackage = (ReqBasePackage) basePackage;
            TimeoutUtils.cancelTimeoutPackage(reqBasePackage.localId);
            if (basePackage instanceof ReqCreateLiveChatPackage) {
                LiveChat liveChat3 = this.liveChat;
                if (liveChat3 != null) {
                    liveChat3.sendReqPackageFailed(reqBasePackage);
                }
            } else if (basePackage instanceof ReqEnterLiveChatPackage) {
                LiveChat liveChat4 = this.liveChat;
                if (liveChat4 != null) {
                    liveChat4.sendReqPackageFailed(reqBasePackage);
                }
            } else if (!(basePackage instanceof ReqCloseLiveChatPackage) || (liveChat = this.liveChat) == null) {
            } else {
                liveChat.sendReqPackageFailed(reqBasePackage);
            }
        }
    }

    @Override // com.blued.android.chat.core.pack.PackageHandler
    public void onSendSuccess(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "onSendSuccess(), pack:" + basePackage);
        }
        if (!ChatManager.debug || ChatManager.getInstance().debugTipsListener == null) {
            return;
        }
        DebugTipsListener debugTipsListener = ChatManager.getInstance().debugTipsListener;
        debugTipsListener.onTips("发送成功, pack:" + basePackage);
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onStart() {
        if (ChatManager.debug) {
            Log.v(TAG, "onStart()");
        }
        reset();
        this.connector.registerConnectListener(this);
        initSessionList();
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public void onStop() {
        if (ChatManager.debug) {
            Log.v(TAG, "onStop()");
        }
        reset();
    }

    public void registerIMStatusListener(IMStatusListener iMStatusListener) {
        if (iMStatusListener == null) {
            return;
        }
        synchronized (this.imStatusListenerList) {
            this.imStatusListenerList.add(iMStatusListener);
            int i = AnonymousClass7.$SwitchMap$com$blued$android$chat$data$ConnectState[this.connector.getConnectStatus().ordinal()];
            if (i == 1) {
                iMStatusListener.onDisconnected();
            } else if (i == 2) {
                iMStatusListener.onConnecting();
            } else if (i == 3) {
                if (this.dataSyncing) {
                    iMStatusListener.onReceiving();
                } else {
                    iMStatusListener.onConnected();
                }
            }
        }
    }

    public void registerMsgContentListener(short s, long j, MsgContentListener msgContentListener, boolean z) {
        SessionModel sessionModel;
        boolean z2;
        boolean z3;
        boolean z4;
        if (ChatManager.debug) {
            Log.v(TAG, "registerMsgContentListener(), sessionType:" + ((int) s) + ", sessionId:" + j + ", listener:" + msgContentListener + ", secret:" + z);
        }
        if (s == 4 || s == 5) {
            if (ChatManager.debug) {
                Log.e(TAG, "can't register livechat msglist");
                return;
            }
            return;
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && sessionModel._msgList == null) {
                if (ChatManager.debug) {
                    Log.v(TAG, "init session._msgList");
                }
                sessionModel._msgList = new ArrayList();
                sessionModel._secretMsgListing = z;
            }
            boolean z5 = false;
            if (sessionModel == null || sessionModel._secretMsgListing) {
                z2 = false;
                if (sessionModel != null) {
                    z2 = false;
                    if (sessionModel._secretMsgListing) {
                        if (sessionModel._unreadedMsgIds != null) {
                            sessionModel._unreadedMsgIds.clear();
                        }
                        if (sessionModel.noReadMsgCount != 0) {
                            sessionModel.noReadMsgCount = 0;
                            ChatHelper.clearSessionLikeNum(sessionModel);
                            sessionModel.secretLookStatus = 1;
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (sessionModel.noReadRedDot == 1) {
                            sessionModel.noReadRedDot = 0;
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        z2 = z4;
                        if (z4) {
                            ChatManager.dbOperImpl.updateSession(sessionModel);
                            z2 = z4;
                        }
                    }
                }
            } else {
                boolean z6 = removeSessionUnreadMsg(sessionModel) || sendReadedFlagForSession(sessionModel);
                if (removeSessionAtMsgId(sessionModel) || z6) {
                    z5 = true;
                }
                z2 = z5;
                if (z5) {
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                    z2 = z5;
                }
            }
        }
        synchronized (this.msgListenerList) {
            Set<MsgContentListener> set = this.msgListenerList.get(sessionKey);
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.msgListenerList.put(sessionKey, hashSet);
            }
            if (!hashSet.contains(msgContentListener)) {
                hashSet.add(msgContentListener);
                if (sessionModel != null && sessionModel._msgList != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(sessionModel._msgList);
                    msgContentListener.onMsgDataChanged(arrayList);
                }
            }
        }
        if (z2) {
            notifySessionChanged(sessionModel);
        }
    }

    public void registerServiceMsgContentListener(short s, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "registerServiceMsgContentListener(), sessionType:" + ((int) s) + ", sessionId:" + str);
        }
        if (s == 4 || s == 5) {
            if (ChatManager.debug) {
                Log.e(TAG, "can't register livechat msglist");
            }
        } else if (str.trim().isEmpty()) {
        } else {
            String[] split = str.trim().split(",");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    notifySessionListChanged();
                    return;
                }
                String sessionKey = SessionHeader.getSessionKey(s, Long.valueOf(split[i2]).longValue());
                synchronized (this.sessionList) {
                    SessionModel sessionModel = this.sessionList.get(sessionKey);
                    if (sessionModel != null && !sessionModel._secretMsgListing) {
                        boolean z = removeSessionUnreadMsg(sessionModel) || sendReadedFlagForSession(sessionModel);
                        boolean z2 = true;
                        if (!removeSessionAtMsgId(sessionModel)) {
                            z2 = z;
                        }
                        if (z2) {
                            ChatManager.dbOperImpl.updateSession(sessionModel);
                        }
                    }
                }
                i = i2 + 1;
            }
        }
    }

    public void registerSessionListener(SessionListener sessionListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "registerSessionListener(), listener:" + sessionListener);
        }
        synchronized (this.sessionListenerList) {
            this.sessionListenerList.add(sessionListener);
        }
        notifySessionListChanged(sessionListener);
    }

    public void registerSessionListener(short s, long j, SingleSessionListener singleSessionListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "registerSessionListener(), sessionType: " + ((int) s) + ", sessionId: " + j + ", listener:" + singleSessionListener);
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.singleSessionListenerMap) {
            Set<SingleSessionListener> set = this.singleSessionListenerMap.get(sessionKey);
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.singleSessionListenerMap.put(sessionKey, hashSet);
            }
            hashSet.add(singleSessionListener);
        }
        notifySessionChanged(s, j, singleSessionListener);
    }

    public void reset() {
        if (ChatManager.debug) {
            Log.v(TAG, "reset()");
        }
        this.sessionListInited = false;
        RoomChat roomChat = this.roomChat;
        if (roomChat != null) {
            roomChat.setupRoomId(0L);
        }
        this.dataSyncing = false;
        this.initMaxMsgId = 0L;
        this.syncRetryCount = 0;
        synchronized (this.sessionList) {
            this.sessionList.clear();
            synchronized (this.snapSessionList) {
                this.snapSessionList.clear();
            }
        }
        synchronized (this.sendingPackageList) {
            this.sendingPackageList.clear();
        }
    }

    public void retractOneMessage(final short s, final long j, final long j2, final short s2, final RetractionListener retractionListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "retractOneMessage(), sessionType:" + ((int) s) + ", sessionId:" + j + ", messageId:" + j2);
        }
        try {
            try {
                IM.c(s == 3, ReceiptOuterClass.ReceiptRequest.newBuilder().setCommon(Common.a().b()).setSessionType(s).setFrom((int) ChatManager.userInfo.uid).setTo((int) getSessionId(j)).setSeqnum(j2).setIsMatchMsg(s2).build(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.Chat.3
                    @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
                    public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                        if (generatedMessageV3 != null) {
                            int number = ((ReceiptOuterClass.ReceiptResponse) generatedMessageV3).getCode().getNumber();
                            if (number == 0) {
                                RetractionListener retractionListener2 = retractionListener;
                                if (retractionListener2 != null) {
                                    retractionListener2.onRetractSuccess();
                                }
                                Chat.this.recvDeleteRetractAckPackage(new DeleteRetractMessagePackage(s, j, j2, 0L, s2));
                                return;
                            } else if (number == 13) {
                                RetractionListener retractionListener3 = retractionListener;
                                if (retractionListener3 != null) {
                                    retractionListener3.onMsgRetractedTimeout();
                                    return;
                                }
                                return;
                            }
                        }
                        RetractionListener retractionListener4 = retractionListener;
                        if (retractionListener4 != null) {
                            retractionListener4.onRetractFailed();
                        }
                    }
                });
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public boolean retrySyncMsg(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "checkSyncState(), syncRetryCount:" + this.syncRetryCount);
        }
        if (!z) {
            this.syncRetryCount = 0;
            sendSyncAllPackage(this.initMaxMsgId, 0L);
            return true;
        }
        int i = this.syncRetryCount;
        if (i < 3) {
            this.syncRetryCount = i + 1;
            sendSyncAllPackage(this.initMaxMsgId, 0L);
            return true;
        }
        return false;
    }

    public void sendMsg(ChattingModel chattingModel, SessionProfileModel sessionProfileModel, boolean z, MsgPreProcesser msgPreProcesser) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendMsg(), msgData:" + chattingModel);
        }
        if (chattingModel == null) {
            return;
        }
        if (chattingModel.isMatchMsg == 1) {
            if (chattingModel.sessionId > 0) {
                chattingModel.sessionId = -chattingModel.sessionId;
            }
            if (chattingModel.toId < 0) {
                chattingModel.toId = -chattingModel.toId;
            }
            if (chattingModel.fromId < 0) {
                chattingModel.fromId = -chattingModel.fromId;
            }
        }
        if (!z) {
            chattingModel.msgAt = AtRegExpUtils.parseMessageAt(chattingModel.msgContent);
        }
        if (chattingModel.sessionType == 4 || chattingModel.sessionType == 5) {
            LiveChat liveChat = this.liveChat;
            if (liveChat != null) {
                liveChat.sendMsg(chattingModel, sessionProfileModel, z, msgPreProcesser);
            }
        } else if (chattingModel.sessionType == 8) {
            AudioRoomChat audioRoomChat = this.audioRoomChat;
            if (audioRoomChat != null) {
                audioRoomChat.sendMsg(chattingModel, msgPreProcesser);
            }
        } else if (ChatHelper.isLocalViewMsg(chattingModel.msgType)) {
            insertMsgDataForLocal(chattingModel);
        } else {
            chattingModel.msgStateCode = (short) 1;
            if (z) {
                updateMsgData(chattingModel);
            } else {
                insertMsgDataForSending(chattingModel, sessionProfileModel);
            }
            if (msgPreProcesser != null) {
                msgPreProcesser.preProcess(chattingModel, this);
            } else {
                sendMsgToServer(chattingModel);
            }
        }
    }

    public void sendReadReceipt(short s, long j, long j2) {
        if (s != 2) {
            return;
        }
        this.readFlagSender.sendReadReceiptImmediate(s, getSessionId(j), j2);
        String sessionKey = SessionHeader.getSessionKey(s, getSessionId(j));
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && sessionModel.maxHasReadMsgID < j2) {
                sessionModel.maxHasReadMsgID = j2;
            }
        }
    }

    public void setSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel == null) {
                SessionSettingBaseModel sessionSetting = ChatManager.dbOperImpl.getSessionSetting(s, j);
                if (sessionSetting != null) {
                    sessionSetting.copyValue(sessionSettingBaseModel);
                    ChatManager.dbOperImpl.updateSessionSetting(s, j, sessionSetting);
                } else {
                    ChatManager.dbOperImpl.createSessionSetting(s, j, sessionSettingBaseModel);
                }
            } else if (sessionSettingBaseModel == null) {
                ChatManager.dbOperImpl.deleteSessionSetting(s, j);
                sessionModel.sessionSettingModel = null;
            } else if (sessionModel.sessionSettingModel == null) {
                ChatManager.dbOperImpl.createSessionSetting(s, j, sessionSettingBaseModel);
                sessionModel.sessionSettingModel = sessionSettingBaseModel;
            } else {
                sessionModel.sessionSettingModel.copyValue(sessionSettingBaseModel);
                ChatManager.dbOperImpl.updateSessionSetting(s, j, sessionModel.sessionSettingModel);
            }
        }
    }

    public void triggleSessionListNotify() {
        notifySessionListChanged();
    }

    public void unregisterIMStatusListener(IMStatusListener iMStatusListener) {
        synchronized (this.imStatusListenerList) {
            this.imStatusListenerList.remove(iMStatusListener);
        }
    }

    public void unregisterMsgContentListener(short s, long j, MsgContentListener msgContentListener) {
        Set<MsgContentListener> set;
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterMsgContentListener(), sessionType:" + ((int) s) + ", sessionId:" + j + ", listener:" + msgContentListener);
        }
        if (s == 4 || s == 5) {
            if (ChatManager.debug) {
                Log.e(TAG, "can't unregister livechat msglist");
                return;
            }
            return;
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.msgListenerList) {
            set = this.msgListenerList.get(sessionKey);
            if (set != null) {
                set.remove(msgContentListener);
            }
        }
        if (set == null || set.size() <= 0) {
            if (ChatManager.debug) {
                Log.v(TAG, "don't have the session msg listener, so clear session._msgList");
            }
            synchronized (this.sessionList) {
                SessionModel sessionModel = this.sessionList.get(sessionKey);
                if (sessionModel != null) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "dispose _msgList");
                    }
                    sessionModel._msgList = null;
                    sessionModel._secretMsgListing = false;
                    sessionModel.isFromSearch = false;
                }
            }
        }
    }

    public void unregisterSessionListener(SessionListener sessionListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterSessionListener(), listener:" + sessionListener);
        }
        synchronized (this.sessionListenerList) {
            this.sessionListenerList.remove(sessionListener);
        }
    }

    public void unregisterSessionListener(short s, long j, SingleSessionListener singleSessionListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterSessionListener(), sessionType: " + ((int) s) + ", sessionId: " + j + ", listener:" + singleSessionListener);
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.singleSessionListenerMap) {
            Set<SingleSessionListener> set = this.singleSessionListenerMap.get(sessionKey);
            if (set != null) {
                set.remove(singleSessionListener);
            }
        }
    }

    public int updateAllSessionSetting(Map<String, Object> map) {
        SessionSettingBaseModel sessionSettingBaseModel;
        int updateAllSessionSetting = ChatManager.dbOperImpl.updateAllSessionSetting(map);
        synchronized (this.sessionList) {
            for (Map.Entry<String, SessionModel> entry : this.sessionList.entrySet()) {
                SessionModel value = entry.getValue();
                if (value != null && (sessionSettingBaseModel = value.sessionSettingModel) != null) {
                    sessionSettingBaseModel.updateValues(map);
                }
            }
        }
        return updateAllSessionSetting;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateMsgData(ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "updateMsgData(), msgData:" + chattingModel);
        }
        ChatManager.dbOperImpl.updateChattingModel(chattingModel);
        String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel == null) {
                return;
            }
            long j = sessionModel.lastMsgId;
            long j2 = sessionModel.lastMsgLocalId;
            boolean z = false;
            if (j == chattingModel.msgId) {
                z = false;
                if (j2 == chattingModel.msgLocalId) {
                    SessionModel.setSessionForLastMsg(sessionModel, chattingModel);
                    z = true;
                }
            }
            if (z) {
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
            if (z) {
                notifySessionChanged(sessionModel);
            }
            insertMemoryAndNotifyUI(sessionModel, chattingModel);
        }
    }

    public void updateMsgForTextTranslateInit(int i, long j) {
        ChatManager.dbOperImpl.updateMsgForTextTranslateInit(i, j);
    }

    public void updateMsgOneData(ChattingModel chattingModel) {
        if (chattingModel == null) {
            return;
        }
        String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
        boolean z = false;
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                z = false;
                if (sessionModel._msgList != null) {
                    MsgComparator msgComparator = new MsgComparator();
                    Iterator<ChattingModel> it = sessionModel._msgList.iterator();
                    while (true) {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        } else if (msgComparator.compare(it.next(), chattingModel) == 0) {
                            z = true;
                            break;
                        }
                    }
                }
                ChatManager.dbOperImpl.updateChattingModel(chattingModel);
            }
        }
        if (z) {
            notifyMsgListChanged(chattingModel.sessionType, chattingModel.sessionId);
        }
    }

    public void updateMsgState(ChattingModel chattingModel, short s) {
        SessionModel sessionModel;
        boolean z;
        boolean z2;
        ChattingModel next;
        if (chattingModel == null) {
            return;
        }
        String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            z = true;
            z2 = false;
            if (sessionModel != null) {
                if (sessionModel.lastMsgId == chattingModel.msgId && sessionModel.lastMsgLocalId == chattingModel.msgLocalId) {
                    sessionModel.lastMsgStateCode = s;
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (sessionModel._msgList != null) {
                    MsgComparator msgComparator = new MsgComparator();
                    Iterator<ChattingModel> it = sessionModel._msgList.iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                        }
                    } while (msgComparator.compare(next, chattingModel) != 0);
                    next.msgStateCode = s;
                    ChatManager.dbOperImpl.updateChattingModel(next);
                }
            }
            z = false;
        }
        if (z) {
            notifyMsgListChanged(chattingModel.sessionType, chattingModel.sessionId);
        }
        if (z2) {
            notifySessionChanged(sessionModel);
        }
    }

    public void updateRelationSessionSetting(short s, long j, Map<String, Object> map) {
        SessionSettingBaseModel sessionSettingBaseModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && (sessionSettingBaseModel = sessionModel.sessionSettingModel) != null) {
                sessionSettingBaseModel.updateValues(map);
            }
        }
    }

    public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list) {
        int updateRelationSessionSettingListDb;
        if (ChatManager.dbOperImpl != null) {
            synchronized (this.sessionList) {
                updateRelationSessionSettingListDb = ChatManager.dbOperImpl.updateRelationSessionSettingListDb(list);
            }
            return updateRelationSessionSettingListDb;
        }
        return -1;
    }

    public void updateSessionDraft(short s, long j, String str) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                sessionModel.lastDraft = str;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }

    public void updateSessionFriend(short s, long j, int i) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                sessionModel.friend = i;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }

    public void updateSessionInfoData(short s, long j, SessionProfileModel sessionProfileModel) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                String str = sessionProfileModel.nickname;
                if (!TextUtils.isEmpty(str)) {
                    sessionModel.nickName = str;
                }
                sessionModel.avatar = sessionProfileModel.avatar;
                sessionModel.vBadge = sessionProfileModel.vBadge;
                sessionModel.online = sessionProfileModel.online;
                sessionModel.vipGrade = sessionProfileModel.vipGrade;
                sessionModel.vipAnnual = sessionProfileModel.vipAnnual;
                sessionModel.vipExpLvl = sessionProfileModel.vipExpLvl;
                sessionModel.hideVipLook = sessionProfileModel.hideVipLook;
                sessionModel.ovipGrade = sessionProfileModel.ovipGrade;
                sessionModel.ovipExpLvl = sessionProfileModel.ovipExpLvl;
                sessionModel.beansMerchantIdentity = sessionProfileModel.beansMerchantIdentity;
                sessionModel.avatar_badge = sessionProfileModel.avatar_badge;
                sessionModel.ohideVipLook = sessionProfileModel.ohideVipLook;
                sessionModel.oFaceStatus = sessionProfileModel.oFaceStatus;
                sessionModel.status_img = sessionProfileModel.status_img;
                sessionModel.oVipGroupType = sessionProfileModel.oVipGroupType;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }

    public void updateSessionLieTop(short s, long j, int i) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                sessionModel.lieTop = i;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }

    public void updateSessionNoReadCount(short s, long j, int i) {
        SessionModel sessionModel;
        boolean z;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel == null || sessionModel.noReadMsgCount == i) {
                z = false;
            } else {
                sessionModel.noReadMsgCount = i;
                ChatManager.dbOperImpl.updateSession(sessionModel);
                z = true;
            }
        }
        if (z) {
            notifySessionChanged(sessionModel);
        }
    }

    public void updateSessionOnLineState(List<Pair<Long, Integer>> list) {
        if (ChatManager.debug) {
            Log.v(TAG, "updataSessionPLine()");
        }
        if (list == null) {
            return;
        }
        synchronized (this.sessionList) {
            for (Pair<Long, Integer> pair : list) {
                SessionModel sessionModel = this.sessionList.get(SessionHeader.getSessionKey(2, pair.first.longValue()));
                if (sessionModel != null) {
                    sessionModel.onLineState = pair.second.intValue();
                    ChatManager.dbOperImpl.updateSession(sessionModel);
                }
            }
        }
        notifySessionListChanged();
    }

    public int updateSessionSetting(short s, long j, Map<String, Object> map) {
        SessionSettingBaseModel sessionSettingBaseModel;
        int updateSessionSetting = ChatManager.dbOperImpl.updateSessionSetting(s, j, map);
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            SessionModel sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null && (sessionSettingBaseModel = sessionModel.sessionSettingModel) != null) {
                sessionSettingBaseModel.updateValues(map);
            }
        }
        return updateSessionSetting;
    }

    public void updateSessionStatus(short s, long j, int i) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                sessionModel.sessionStatus = i;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }

    public void updateSessionTopGift(short s, long j, long j2, float f) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                sessionModel.expireTime = j2;
                sessionModel.totalMoney = f;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }

    public void updateSessionUnreadGiftCnt(short s, long j, int i, long j2) {
        SessionModel sessionModel;
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.sessionList) {
            sessionModel = this.sessionList.get(sessionKey);
            if (sessionModel != null) {
                sessionModel.unreadGiftCnt = i;
                sessionModel.lastGiftMsgId = j2;
                ChatManager.dbOperImpl.updateSession(sessionModel);
            }
        }
        notifySessionChanged(sessionModel);
    }
}
