package com.blued.android.chat.core.worker.chat;

import androidx.collection.ArrayMap;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.util.cm.QSConstants;
import com.android.internal.util.cm.SpamFilter;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqApplyJoinLivePackage;
import com.blued.android.chat.core.pack.ReqBasePackage;
import com.blued.android.chat.core.pack.ReqCloseLiveChatPackage;
import com.blued.android.chat.core.pack.ReqCreateLiveChatPackage;
import com.blued.android.chat.core.pack.ReqEnterLiveChatPackage;
import com.blued.android.chat.core.pack.ReqGetLiveChatInfoPackage;
import com.blued.android.chat.core.pack.ReqLeaveLiveChatPackage;
import com.blued.android.chat.core.pack.ReqLiveChatStatusChangePackage;
import com.blued.android.chat.core.pack.ReqLiveChatStopTalkPackage;
import com.blued.android.chat.core.pack.ReqNotifyLiveJoinEndPackage;
import com.blued.android.chat.core.pack.ReqNotifyLiveJoinStartPackage;
import com.blued.android.chat.core.pack.ReqRecoverLiveChatPackage;
import com.blued.android.chat.core.pack.ReqStartJoinLive;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.LiveCreateFailedReason;
import com.blued.android.chat.data.LiveEnterFailedReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.listener.LiveChatCreateListener;
import com.blued.android.chat.listener.LiveChatEnterListener;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/LiveChat.class */
public class LiveChat extends BaseWorker implements ConnectListener {
    public static final int LIVE_GAME = 1;
    public static final int LIVE_GUY_MIRROR = 1;
    public static final int LIVE_NORMAL = 0;
    public static final int LIVE_NO_MIRROR = 0;
    public static final int LIVE_PRIVATE = 2;
    public static final int LIVE_VOICE = 3;
    public static final int MAX_VIEWER_LIST_SIZE = 50;
    public static final int MIN_VIEWER_LIST_SIZE = 20;
    private static final String TAG = "Chat_LiveChat";
    Chat chat;
    Connector connector;
    PackSendHelper packSendHelper;
    private long liveChatStartLocalId = 0;
    private BasePackage liveChatStartPackage = null;
    private Object sessionLock = new Object();
    private LiveChatInfo liveChatInfo = null;
    private final Map<String, Set<LiveChatInfoListener>> liveChatInfoListenerMap = new ArrayMap();
    private boolean useHttp = false;

    public LiveChat(Connector connector, Chat chat) {
        if (ChatManager.debug) {
            Log.v(TAG, "LiveChat() create");
        }
        this.chat = chat;
        this.connector = connector;
        this.packSendHelper = connector.getPackageSendHelper();
        chat.liveChat = this;
        this.connector.registerConnectListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLiveChatFailed(long j, int i, String str, LiveChatCreateListener liveChatCreateListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "createLiveChatFailed(), localId:" + j + ", liveChatStartLocalId:" + this.liveChatStartLocalId + ", liveChatCreateListener:" + liveChatCreateListener);
        }
        if (this.liveChatStartLocalId == j && liveChatCreateListener != null) {
            if (i == 2) {
                liveChatCreateListener.onCreateFailed(LiveCreateFailedReason.FORBIDDEN_LIVE, str);
            } else if (i == 1) {
                liveChatCreateListener.onCreateFailed(LiveCreateFailedReason.NO_AUTHORITY_LIVE, str);
            } else if (i == 7) {
                liveChatCreateListener.onCreateFailed(LiveCreateFailedReason.DESCRIPTION_INVALID, str);
            } else {
                liveChatCreateListener.onCreateFailed(LiveCreateFailedReason.UNKNOWN, str);
            }
        }
    }

    private void createLiveChatSuccess(long j, Map<String, Object> map, LiveChatCreateListener liveChatCreateListener) {
        short shortValue = MsgPackHelper.getShortValue(map, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE);
        long longValue = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID);
        if (this.liveChatStartLocalId != j) {
            closeLiveChat(shortValue, longValue);
            return;
        }
        LiveChatInitData liveChatInitData = new LiveChatInitData();
        liveChatInitData.sessionType = shortValue;
        liveChatInitData.sessionId = longValue;
        liveChatInitData.streamUrl = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.LIVE_INFO);
        liveChatInitData.publish_url = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.PUBLISH_URL);
        liveChatInitData.liveUrl = MsgPackHelper.getStringValue(map, "live_url");
        liveChatInitData.topCardCount = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.TOP_CARD_COUNT);
        liveChatInitData.topCardUrl = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.TOP_CARD_URL);
        liveChatInitData.rank = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.RANK);
        liveChatInitData.beansCount = MsgPackHelper.getDoubleValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BEANS_COUNT);
        liveChatInitData.beansCurrentCount = MsgPackHelper.getDoubleValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BEANS_CURRENT_COUNT);
        liveChatInitData.badges = LiveChatInitData.parseBadgeMap(MsgPackHelper.getListValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BADGES));
        liveChatInitData.icon = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.ICON);
        liveChatInitData.liveType = MsgPackHelper.getIntValue(map, "live_type");
        liveChatInitData.liveDescription = MsgPackHelper.getStringValue(map, "description");
        liveChatInitData.joinLiveConferenceId = MsgPackHelper.getStringValue(map, "conference_id");
        liveChatInitData.joinLiveToken = MsgPackHelper.getStringValue(map, "token");
        liveChatInitData.live_quic = MsgPackHelper.getIntValue(map, "live_quic");
        Map<String, Object> mapValue = MsgPackHelper.getMapValue(map, "extra");
        liveChatInitData.liverProfile = new ProfileData();
        liveChatInitData.liverProfile.uid = ChatManager.getInstance().getUid();
        BasePackage basePackage = this.liveChatStartPackage;
        if (basePackage != null && (basePackage instanceof ReqCreateLiveChatPackage)) {
            liveChatInitData.screenPattern = ((ReqCreateLiveChatPackage) basePackage).screenPattern;
        }
        this.liveChatInfo = new LiveChatInfo(shortValue, longValue);
        if (liveChatCreateListener != null) {
            liveChatCreateListener.onCreateSuccess(shortValue, longValue, liveChatInitData, mapValue);
        } else {
            closeLiveChat(shortValue, longValue);
        }
    }

    private void destroy() {
        Connector connector = this.connector;
        if (connector != null) {
            connector.unregisterConnectListener(this);
        }
        Chat chat = this.chat;
        if (chat != null) {
            chat.liveChat = null;
            this.chat.videoChat = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterLiveChatFailed(long j, int i, Map<String, Object> map, LiveChatEnterListener liveChatEnterListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "createLiveChatFailed(), localId:" + j + ", liveChatStartLocalId:" + this.liveChatStartLocalId + ", liveChatEnterListener:" + liveChatEnterListener);
        }
        if (this.liveChatStartLocalId == j && liveChatEnterListener != null) {
            if (i == 3) {
                liveChatEnterListener.onEnterFailed(LiveEnterFailedReason.BLOCKED_BY_PEER, null);
            } else if (i == 4) {
                liveChatEnterListener.onEnterFailed(LiveEnterFailedReason.BLOCK_PEER, null);
            } else if (i == 5) {
                liveChatEnterListener.onEnterFailed(LiveEnterFailedReason.LIVEROOM_FULL, null);
            } else if (i == 6) {
                liveChatEnterListener.onEnterFailed(LiveEnterFailedReason.LIVEROOM_CLOSE, LiveChatStatistics.parseData(map));
            } else if (i == 18) {
                liveChatEnterListener.onEnterFailed(LiveEnterFailedReason.LIVEROOM_KICKED_OUT, LiveChatStatistics.parseData(map));
            } else {
                liveChatEnterListener.onEnterFailed(LiveEnterFailedReason.UNKNOWN, null);
            }
        }
    }

    private void enterLiveChatSuccess(long j, Map<String, Object> map, LiveChatEnterListener liveChatEnterListener) {
        short shortValue = MsgPackHelper.getShortValue(map, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE);
        long longValue = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID);
        if (this.liveChatStartLocalId != j) {
            Log.v(TAG, "enterLivechat localId not match, " + this.liveChatStartLocalId + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + j + ", so leave live");
            leaveLiveChat(shortValue, longValue, "");
            return;
        }
        LiveChatInitData liveChatInitData = new LiveChatInitData();
        liveChatInitData.sessionType = shortValue;
        liveChatInitData.sessionId = longValue;
        liveChatInitData.streamUrl = MsgPackHelper.getStringValue(map, "live_url");
        liveChatInitData.liveUrl = MsgPackHelper.getStringValue(map, "live_url");
        liveChatInitData.elapseTimeSec = MsgPackHelper.getLongValue(map, "elapse_time");
        liveChatInitData.topCardCount = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.TOP_CARD_COUNT);
        liveChatInitData.topCardUrl = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.TOP_CARD_URL);
        liveChatInitData.rank = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.RANK);
        liveChatInitData.beansCount = MsgPackHelper.getDoubleValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BEANS_COUNT);
        liveChatInitData.beansCurrentCount = MsgPackHelper.getDoubleValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BEANS_CURRENT_COUNT);
        liveChatInitData.badges = LiveChatInitData.parseBadgeMap(MsgPackHelper.getListValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BADGES));
        liveChatInitData.entranceData = EntranceData.parseEntranceData(MsgPackHelper.getMapValue(map, ReqAckPackage.REQ_RESPONSE_KEY.ENTRANCE_EFFECTS));
        liveChatInitData.bluedBadgePic = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BLUED_BADGE_PIC);
        liveChatInitData.privateFlag = MsgPackHelper.getIntValue(map, "is_private");
        liveChatInitData.icon = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.ICON);
        liveChatInitData.liveType = MsgPackHelper.getIntValue(map, "live_type");
        liveChatInitData.liveDescription = MsgPackHelper.getStringValue(map, "description");
        liveChatInitData.admin_type = MsgPackHelper.getIntValue(map, "admin_type");
        Map<String, Object> mapValue = MsgPackHelper.getMapValue(map, "extra");
        Map<String, Object> mapValue2 = MsgPackHelper.getMapValue(map, "profile");
        if (mapValue2 != null) {
            liveChatInitData.liverProfile = new ProfileData();
            liveChatInitData.liverProfile.parseMsgPackData(mapValue2);
        }
        liveChatInitData.screenPattern = MsgPackHelper.getIntValue(map, "screen_pattern");
        this.liveChatInfo = new LiveChatInfo(shortValue, longValue);
        if (liveChatEnterListener != null) {
            liveChatEnterListener.onEnterSuccess(shortValue, longValue, liveChatInitData, mapValue);
            return;
        }
        Log.v(TAG, "liveChatEnterListener is null, so leave live");
        leaveLiveChat(shortValue, longValue, "");
    }

    private void notifyJoinLive(short s, long j, int i, String str, String str2, String str3) {
        Log.v(TAG, "notifyJoinLive(), result:" + i);
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.liveChatInfoListenerMap) {
            Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
            if (set != null) {
                JoinLiveResult joinLiveResult = i == 0 ? JoinLiveResult.SUCCESS : i == 8 ? JoinLiveResult.FAILED_JOINLIVE_CLOSE : i == 9 ? JoinLiveResult.FAILED_JOINLIVE_FULL : i == 10 ? JoinLiveResult.FAILED_JOINLIVE_INVITE_OVERDUE : JoinLiveResult.FAILED_UNKNOWN;
                for (LiveChatInfoListener liveChatInfoListener : set) {
                    liveChatInfoListener.onJoinLive(joinLiveResult, str, str2, str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLiveChatClose(short s, long j, LiveCloseReason liveCloseReason, LiveChatStatistics liveChatStatistics) {
        Log.v(TAG, "notifyLiveChatClose(), reason:" + liveCloseReason);
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.liveChatInfoListenerMap) {
            Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
            if (set != null) {
                for (LiveChatInfoListener liveChatInfoListener : set) {
                    liveChatInfoListener.onClose(liveCloseReason, liveChatStatistics);
                }
            }
        }
        synchronized (this.sessionLock) {
            if (this.liveChatInfo != null && this.liveChatInfo.equalSession(s, j)) {
                this.liveChatInfo = null;
            }
        }
    }

    private void notifyRevNewMsg(ChattingModel chattingModel) {
        String sessionKey = SessionHeader.getSessionKey(chattingModel.sessionType, chattingModel.sessionId);
        synchronized (this.liveChatInfoListenerMap) {
            Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
            if (set != null) {
                for (LiveChatInfoListener liveChatInfoListener : set) {
                    liveChatInfoListener.onRecvNewMsg(chattingModel);
                }
            }
        }
    }

    private void notifyViewerEntrance(EntranceData entranceData) {
        if (entranceData != null) {
            String sessionKey = SessionHeader.getSessionKey(this.liveChatInfo.sessionType, this.liveChatInfo.sessionId);
            synchronized (this.liveChatInfoListenerMap) {
                Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
                if (set != null && this.liveChatInfo != null) {
                    for (LiveChatInfoListener liveChatInfoListener : set) {
                        liveChatInfoListener.onViewerEntrance(entranceData, this.liveChatInfo.viewerOnLineCount);
                    }
                }
            }
        }
    }

    private void notifyViewerListChanged(LiveChatInfo liveChatInfo) {
        if (liveChatInfo != null) {
            List<ProfileData> viewerList = liveChatInfo.getViewerList();
            String sessionKey = SessionHeader.getSessionKey(liveChatInfo.sessionType, liveChatInfo.sessionId);
            synchronized (this.liveChatInfoListenerMap) {
                Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
                if (set != null) {
                    for (LiveChatInfoListener liveChatInfoListener : set) {
                        liveChatInfoListener.onViewerDataChanged(liveChatInfo.viewerOnLineCount, viewerList);
                    }
                }
            }
        }
    }

    public void applyJoinLive(short s, long j, long j2) {
        this.packSendHelper.sendPackage(new ReqApplyJoinLivePackage(s, j, ChatHelper.getLocalId(), j2), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.LiveChat.5
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    LiveChat.this.recvReqJoinLivePackage((ReqAckPackage) basePackage2);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
            }
        });
    }

    public void closeLiveChat(short s, long j) {
        closeLiveChat(s, j, 0);
    }

    public void closeLiveChat(short s, long j, int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "closeLiveChat(), sessionType:" + ((int) s) + ", sessionId");
        }
        ReqCloseLiveChatPackage reqCloseLiveChatPackage = new ReqCloseLiveChatPackage(s, j, ChatHelper.getLocalId());
        reqCloseLiveChatPackage.setReason(i);
        this.packSendHelper.sendPackage(reqCloseLiveChatPackage, new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.LiveChat.2
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                ReqCloseLiveChatPackage reqCloseLiveChatPackage2 = (ReqCloseLiveChatPackage) basePackage;
                LiveChat.this.notifyLiveChatClose(reqCloseLiveChatPackage2.sessionType, reqCloseLiveChatPackage2.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    LiveChat.this.recvReqCloseLiveChatPackage((ReqAckPackage) basePackage2);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                ReqCloseLiveChatPackage reqCloseLiveChatPackage2 = (ReqCloseLiveChatPackage) basePackage;
                LiveChat.this.notifyLiveChatClose(reqCloseLiveChatPackage2.sessionType, reqCloseLiveChatPackage2.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                ReqCloseLiveChatPackage reqCloseLiveChatPackage2 = (ReqCloseLiveChatPackage) basePackage;
                LiveChat.this.notifyLiveChatClose(reqCloseLiveChatPackage2.sessionType, reqCloseLiveChatPackage2.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
            }
        });
        synchronized (this.sessionLock) {
            if (this.liveChatInfo != null && this.liveChatInfo.equalSession(s, j)) {
                this.liveChatInfo = null;
            }
        }
    }

    public void createLiveChat(int i, int i2, String str, String str2, int i3, int i4, int i5, final LiveChatCreateListener liveChatCreateListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "createLiveChat(), liveType:" + i2 + ", shareMirror:" + i + ", liveDescription:" + str + ", liveCover:" + str2 + ", screenPattern:" + i3 + ", showNearby:" + i4 + ", privateFlag:" + i5);
        }
        long localId = ChatHelper.getLocalId();
        this.liveChatStartLocalId = localId;
        ReqCreateLiveChatPackage reqCreateLiveChatPackage = new ReqCreateLiveChatPackage(i, i2, str, str2, localId, i3, i4, i5);
        this.liveChatStartPackage = reqCreateLiveChatPackage;
        this.packSendHelper.sendPackage(reqCreateLiveChatPackage, new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.LiveChat.1
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                LiveChat.this.createLiveChatFailed(((ReqCreateLiveChatPackage) basePackage).localId, -2, null, liveChatCreateListener);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    LiveChat.this.recvReqCreateLiveChatPackage((ReqAckPackage) basePackage2, liveChatCreateListener);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                LiveChat.this.createLiveChatFailed(((ReqCreateLiveChatPackage) basePackage).localId, -1, null, liveChatCreateListener);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                LiveChat.this.createLiveChatFailed(((ReqCreateLiveChatPackage) basePackage).localId, -2, null, liveChatCreateListener);
            }
        });
    }

    public void enterLiveChat(short s, long j, String str, final LiveChatEnterListener liveChatEnterListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "enterLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        long localId = ChatHelper.getLocalId();
        this.liveChatStartLocalId = localId;
        ReqEnterLiveChatPackage reqEnterLiveChatPackage = new ReqEnterLiveChatPackage(s, j, str, localId);
        this.liveChatStartPackage = reqEnterLiveChatPackage;
        this.packSendHelper.sendPackage(reqEnterLiveChatPackage, new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.LiveChat.3
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                LiveChat.this.enterLiveChatFailed(((ReqEnterLiveChatPackage) basePackage).localId, -2, null, liveChatEnterListener);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    LiveChat.this.recvReqEnterLiveChatPackage((ReqAckPackage) basePackage2, liveChatEnterListener);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                LiveChat.this.enterLiveChatFailed(((ReqEnterLiveChatPackage) basePackage).localId, -1, null, liveChatEnterListener);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                LiveChat.this.enterLiveChatFailed(((ReqEnterLiveChatPackage) basePackage).localId, -2, null, liveChatEnterListener);
            }
        });
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public String getWorkerName() {
        return "LiveChat";
    }

    public void initLiveChatInfo(short s, long j, boolean z) {
        this.liveChatInfo = new LiveChatInfo(s, j);
        this.useHttp = z;
    }

    public void leaveLiveChat(short s, long j, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "leaveLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        if (j <= 0) {
            return;
        }
        this.packSendHelper.sendPackage(new ReqLeaveLiveChatPackage(s, j, ChatHelper.getLocalId(), str), null);
        synchronized (this.sessionLock) {
            if (this.liveChatInfo != null && this.liveChatInfo.equalSession(s, j)) {
                this.liveChatInfo = null;
            }
        }
    }

    public void notifyJoinLiveEnd(short s, long j, long j2, long j3) {
        this.packSendHelper.sendPackage(new ReqNotifyLiveJoinEndPackage(s, j, j2, j3, ChatHelper.getLocalId()), null);
    }

    public void notifyJoinLiveStart(short s, long j, long j2, String str, long j3) {
        this.packSendHelper.sendPackage(new ReqNotifyLiveJoinStartPackage(s, j, j2, str, j3, ChatHelper.getLocalId()), null);
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnected() {
        synchronized (this.sessionLock) {
            if (this.liveChatInfo != null) {
                this.connector.sendPackage(new ReqRecoverLiveChatPackage(this.liveChatInfo.sessionType, this.liveChatInfo.sessionId, ChatHelper.getLocalId()));
            }
        }
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnecting() {
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onDisconnected() {
    }

    public void pauseLive(short s, long j) {
        this.packSendHelper.sendPackage(new ReqLiveChatStatusChangePackage(s, j, 1, ChatHelper.getLocalId()), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvPushMsgPackage(PushMsgPackage pushMsgPackage) {
        String str;
        synchronized (this.sessionLock) {
            if (this.liveChatInfo != null && this.liveChatInfo.equalSession(pushMsgPackage.sessionType, pushMsgPackage.sessionId)) {
                ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
                if (msgData.msgType == 29) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到消息－被主播关闭");
                    }
                    notifyLiveChatClose(pushMsgPackage.sessionType, pushMsgPackage.sessionId, LiveCloseReason.CLOSED_BY_LIVER, LiveChatStatistics.parseData(msgData.msgMapExtra));
                } else if (msgData.msgType == 30) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到消息－被场控关闭");
                    }
                    notifyLiveChatClose(pushMsgPackage.sessionType, pushMsgPackage.sessionId, LiveCloseReason.CLOSED_BY_MANAGER, LiveChatStatistics.parseData(msgData.msgMapExtra));
                } else if (msgData.msgType == 27) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到消息－进入直播间");
                    }
                    notifyRevNewMsg(msgData);
                } else if (msgData.msgType == 28) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "收到消息－离开直播间");
                    }
                    notifyRevNewMsg(msgData);
                } else {
                    if (ChatManager.debug) {
                        Log.v(TAG, "receive an new message, notify to business");
                    }
                    notifyRevNewMsg(msgData);
                }
                return;
            }
            if (ChatManager.debug) {
                String str2 = "can't match current liveChat, drop it, msgId:" + pushMsgPackage.msgId;
                if (this.liveChatInfo == null) {
                    str = str2 + ", liveChatInfo is null";
                } else {
                    str = str2;
                    if (!this.liveChatInfo.equalSession(pushMsgPackage.sessionType, pushMsgPackage.sessionId)) {
                        str = str2 + ", sessionType or sessionId not equal, current:" + ((int) this.liveChatInfo.sessionType) + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + this.liveChatInfo.sessionId + ", message:" + ((int) pushMsgPackage.sessionType) + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + pushMsgPackage.sessionId;
                    }
                }
                Log.v(TAG, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvReqCloseLiveChatPackage(ReqAckPackage reqAckPackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "recvReqCloseLiveChatPackage()");
        }
        if (reqAckPackage.result == 0) {
            notifyLiveChatClose(MsgPackHelper.getShortValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE), MsgPackHelper.getLongValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID), LiveCloseReason.CLOSED_BY_SELF, LiveChatStatistics.parseData(reqAckPackage.reqResponse));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvReqCreateLiveChatPackage(ReqAckPackage reqAckPackage, LiveChatCreateListener liveChatCreateListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "recvReqCreateLiveChatPackage()");
        }
        if (reqAckPackage.result != 0) {
            createLiveChatFailed(reqAckPackage.localId, -1, null, liveChatCreateListener);
        } else if (reqAckPackage.error == 0) {
            createLiveChatSuccess(reqAckPackage.localId, reqAckPackage.reqResponse, liveChatCreateListener);
        } else {
            createLiveChatFailed(reqAckPackage.localId, reqAckPackage.error, reqAckPackage.errorContent, liveChatCreateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvReqEnterLiveChatPackage(ReqAckPackage reqAckPackage, LiveChatEnterListener liveChatEnterListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "recvReqEnterLiveChatPackage(), LiveChatEnterListener:" + liveChatEnterListener);
        }
        if (reqAckPackage.result != 0) {
            enterLiveChatFailed(reqAckPackage.localId, -1, reqAckPackage.reqResponse, liveChatEnterListener);
        } else if (reqAckPackage.error != 0) {
            enterLiveChatFailed(reqAckPackage.localId, reqAckPackage.error, reqAckPackage.reqResponse, liveChatEnterListener);
        } else {
            enterLiveChatSuccess(reqAckPackage.localId, reqAckPackage.reqResponse, liveChatEnterListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvReqGetLiveChatInfoPackage(ReqAckPackage reqAckPackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "recvReqGetLiveChatInfoPackage()");
        }
        if (reqAckPackage.result == 0 && reqAckPackage.error == 0) {
            short shortValue = MsgPackHelper.getShortValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE);
            long longValue = MsgPackHelper.getLongValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID);
            synchronized (this.sessionLock) {
                if (this.liveChatInfo != null && this.liveChatInfo.equalSession(shortValue, longValue)) {
                    this.liveChatInfo.viewerTotalCount = MsgPackHelper.getLongValue(reqAckPackage.reqResponse, SpamFilter.SpamContract.NotificationTable.COUNT);
                    this.liveChatInfo.viewerOnLineCount = MsgPackHelper.getLongValue(reqAckPackage.reqResponse, "realtime_count");
                    this.liveChatInfo.viewerProfileList = ProfileData.parseProfileList(MsgPackHelper.getListValue(reqAckPackage.reqResponse, QSConstants.TILE_PROFILES));
                    notifyViewerListChanged(this.liveChatInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvReqJoinLivePackage(ReqAckPackage reqAckPackage) {
        String str = reqAckPackage.errorContent;
        notifyJoinLive(MsgPackHelper.getShortValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE), MsgPackHelper.getLongValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID), reqAckPackage.error, str, MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "conference_id"), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "token"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvReqRecoverLiveChatPackage(ReqAckPackage reqAckPackage) {
        if (reqAckPackage.error == 6) {
            notifyLiveChatClose(MsgPackHelper.getShortValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE), MsgPackHelper.getLongValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID), LiveCloseReason.CLOSED_BY_SELF, LiveChatStatistics.parseData(reqAckPackage.reqResponse));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvSendAckPackage(SendAckPackage sendAckPackage) {
        ChatTipsListener tipsListener;
        LiveChatInfo liveChatInfo;
        if (sendAckPackage.result == 0 || (tipsListener = ChatManager.getInstance().getTipsListener()) == null || (liveChatInfo = this.liveChatInfo) == null) {
            return;
        }
        tipsListener.onSendMsgFailed(liveChatInfo.sessionType, this.liveChatInfo.sessionId, 1, sendAckPackage.msgId, sendAckPackage.localId, sendAckPackage.result);
    }

    public void registerLiveChatListener(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "registerLiveChatListener(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.liveChatInfoListenerMap) {
            Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.liveChatInfoListenerMap.put(sessionKey, hashSet);
            }
            hashSet.add(liveChatInfoListener);
        }
    }

    public void resumeLive(short s, long j) {
        this.packSendHelper.sendPackage(new ReqLiveChatStatusChangePackage(s, j, 0, ChatHelper.getLocalId()), null);
    }

    protected void sendMsg(ChattingModel chattingModel, SessionProfileModel sessionProfileModel) {
        sendMsg(chattingModel, sessionProfileModel, false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMsg(ChattingModel chattingModel, SessionProfileModel sessionProfileModel, boolean z, MsgPreProcesser msgPreProcesser) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendMsg()");
        }
        chattingModel.msgStateCode = (short) 1;
        if (!z) {
            chattingModel.msgId = 0L;
            chattingModel.msgPreviousId = 0L;
            chattingModel.msgLocalId = ChatHelper.getLocalId();
            chattingModel.msgTimestamp = System.currentTimeMillis();
        }
        synchronized (this.sessionLock) {
            if (this.liveChatInfo != null && this.liveChatInfo.equalSession(chattingModel.sessionType, chattingModel.sessionId)) {
                if (!z && chattingModel.msgType != 31) {
                    notifyRevNewMsg(chattingModel);
                }
                if (chattingModel.msgType == 33) {
                    return;
                }
                this.packSendHelper.sendPackage(ChatHelper.getSendMsgPackageFromChattingModel(chattingModel), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.LiveChat.6
                    @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
                    public void onAckTimeout(BasePackage basePackage) {
                    }

                    @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
                    public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                        if (basePackage2 instanceof SendAckPackage) {
                            LiveChat.this.recvSendAckPackage((SendAckPackage) basePackage2);
                        }
                    }

                    @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
                    public void onSendFailed(BasePackage basePackage) {
                    }

                    @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
                    public void onSendFinish(BasePackage basePackage) {
                    }

                    @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
                    public void onSendTimeout(BasePackage basePackage) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMsgPackageFailed(SendMsgPackage sendMsgPackage, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendReqPackageFailed(ReqBasePackage reqBasePackage) {
        if (reqBasePackage instanceof ReqCreateLiveChatPackage) {
            createLiveChatFailed(((ReqCreateLiveChatPackage) reqBasePackage).localId, -1, null, null);
        } else if (reqBasePackage instanceof ReqEnterLiveChatPackage) {
            enterLiveChatFailed(((ReqEnterLiveChatPackage) reqBasePackage).localId, -1, null, null);
        } else if (reqBasePackage instanceof ReqCloseLiveChatPackage) {
            ReqCloseLiveChatPackage reqCloseLiveChatPackage = (ReqCloseLiveChatPackage) reqBasePackage;
            notifyLiveChatClose(reqCloseLiveChatPackage.sessionType, reqCloseLiveChatPackage.sessionId, LiveCloseReason.CLOSED_BY_SELF, null);
        }
    }

    public void startJoinLive(short s, long j, long j2) {
        this.packSendHelper.sendPackage(new ReqStartJoinLive(s, j, j2, ChatHelper.getLocalId()), null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void stopTalkSomebody(short s, long j, long j2, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void stopTalkSomebodyForever(short s, long j, long j2) {
        if (ChatManager.debug) {
            Log.v(TAG, "stopTalkSomebody(), sessionType:" + ((int) s) + ", sessionId:" + j + ", stopTalkUid:" + j2);
        }
        this.packSendHelper.sendPackage(new ReqLiveChatStopTalkPackage(s, j, j2, 2, ChatHelper.getLocalId()), null);
    }

    public void unregisterLiveChatListener(short s, long j, LiveChatInfoListener liveChatInfoListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterLiveChatListener(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        String sessionKey = SessionHeader.getSessionKey(s, j);
        synchronized (this.liveChatInfoListenerMap) {
            Set<LiveChatInfoListener> set = this.liveChatInfoListenerMap.get(sessionKey);
            if (set != null) {
                set.remove(liveChatInfoListener);
            }
        }
    }

    public void updateLiveChatInfo(short s, long j) {
        updateLiveChatInfo(s, j, 0);
    }

    public void updateLiveChatInfo(short s, long j, int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "updateLiveChatInfo(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        if (this.useHttp) {
            return;
        }
        this.packSendHelper.sendPackage(new ReqGetLiveChatInfoPackage(s, j, i, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.LiveChat.4
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    LiveChat.this.recvReqGetLiveChatInfoPackage((ReqAckPackage) basePackage2);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
            }
        });
    }
}
