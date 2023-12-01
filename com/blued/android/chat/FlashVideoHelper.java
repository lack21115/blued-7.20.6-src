package com.blued.android.chat;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.core.worker.chat.FlashVideo;
import com.blued.android.chat.data.RelationProfileData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.FlashVideoGiftModel;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper.class */
public class FlashVideoHelper implements FlashVideo.IFlashVideoCallback {
    private static final String TAG = "Chat_FlashVideoHelper";
    private Handler callbackHandler;
    private MatchListener matchListener;
    private String matchedRoomId;
    private long matchedUid;
    private MatchState state = MatchState.IDLE;
    private BothAgreeState matchAgreeState = BothAgreeState.IDLE;
    private BothAgreeState addExtraTimeAgreeState = BothAgreeState.IDLE;
    private int extraTime = 0;
    private FlashVideo flashVideoImpl = ChatManager.getInstance().registerFlashVideoHelper(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.chat.FlashVideoHelper$19  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper$19.class */
    public static /* synthetic */ class AnonymousClass19 {
        static final /* synthetic */ int[] $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[BothAgreeState.values().length];
            $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState = iArr;
            try {
                iArr[BothAgreeState.AGREE_BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[BothAgreeState.REJECT_SELF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[BothAgreeState.AGREE_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[BothAgreeState.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[BothAgreeState.AGREE_SELF.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[BothAgreeState.AGREE_BOTH_BUT_TIME_OUT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper$BothAgreeState.class */
    public enum BothAgreeState {
        IDLE,
        AGREE_SELF,
        AGREE_OPPOSITE,
        AGREE_BOTH,
        AGREE_BOTH_BUT_TIME_OUT,
        REJECT_SELF;

        BothAgreeState setAgreeStateOpposite() {
            synchronized (this) {
                if (this == IDLE) {
                    return AGREE_OPPOSITE;
                } else if (this == AGREE_SELF) {
                    return AGREE_BOTH;
                } else {
                    return this;
                }
            }
        }

        BothAgreeState setAgreeStateReject() {
            synchronized (this) {
                if (this == AGREE_SELF) {
                    return this;
                }
                if (this == AGREE_BOTH) {
                    return AGREE_BOTH_BUT_TIME_OUT;
                }
                return REJECT_SELF;
            }
        }

        BothAgreeState setAgreeStateSelf() {
            synchronized (this) {
                if (this == IDLE) {
                    return AGREE_SELF;
                } else if (this == AGREE_OPPOSITE) {
                    return AGREE_BOTH;
                } else {
                    return this;
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper$CloseReason.class */
    public interface CloseReason {
        public static final int CLOSE_BY_PEER = 0;
        public static final int CLOSE_BY_VIOLATION_PEER = 1;
        public static final int CLOSE_BY_VIOLATION_SELF = 2;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper$MatchFailed.class */
    public enum MatchFailed {
        NETWORK,
        FUNCTION_LOCK,
        USER_BLOCK,
        UNKNOWN
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper$MatchListener.class */
    public interface MatchListener {
        void onApplyFriends();

        void onApplyFriendsAgree();

        void onApplyFriendsReq(Map map);

        void onApplydExtraTimeAgree(int i);

        void onChatClose(int i, String str);

        void onMatchAgreed();

        void onMatchFailed(MatchFailed matchFailed, String str, int i);

        void onMatchSuccess(String str, RelationProfileData relationProfileData, int i, int i2, String str2, String str3, String str4, int i3);

        void onMatchWaiting(String str, List<String> list);

        void onReceiveAddExtraTimeApply();

        void onReceiveEmoji(String str);

        void onReceiveGift(FlashVideoGiftModel flashVideoGiftModel);

        void onReceiveText(ChattingModel chattingModel);

        void onSayHi();

        void onSendTextMsgFail(String str);

        void onSendTextMsgSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/FlashVideoHelper$MatchState.class */
    public enum MatchState {
        IDLE,
        MATCHING,
        CHATING,
        DESTROY
    }

    public FlashVideoHelper(MatchListener matchListener) {
        this.matchListener = matchListener;
    }

    private void notifyCallback(Runnable runnable) {
        if (this.matchListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void SayHi() {
        if (ChatManager.debug) {
            Log.v(TAG, "SayHi(), state:" + this.state);
        }
        if (this.state != MatchState.DESTROY) {
            this.flashVideoImpl.sayHi(this.matchedUid, this.matchedRoomId);
        } else if (ChatManager.debug) {
            Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行SayHi操作");
        }
    }

    public void applyExtraTime() {
        if (ChatManager.debug) {
            Log.v(TAG, "applyExtraTime(), state:" + this.state + ", addExtraTimeAgreeState:" + this.addExtraTimeAgreeState);
        }
        if (this.state == MatchState.DESTROY) {
            if (ChatManager.debug) {
                Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行applyExtraTime操作");
                return;
            }
            return;
        }
        BothAgreeState agreeStateSelf = this.addExtraTimeAgreeState.setAgreeStateSelf();
        this.addExtraTimeAgreeState = agreeStateSelf;
        if (agreeStateSelf == BothAgreeState.AGREE_BOTH) {
            this.addExtraTimeAgreeState = BothAgreeState.IDLE;
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onApplydExtraTimeAgree(FlashVideoHelper.this.extraTime);
                    }
                }
            });
        }
        this.flashVideoImpl.applyExtraTime(this.matchedUid, this.matchedRoomId);
    }

    public void applyFriend() {
        if (ChatManager.debug) {
            Log.v(TAG, "applyFriend(), state:" + this.state);
        }
        if (this.state != MatchState.DESTROY) {
            this.flashVideoImpl.applyFriend(this.matchedUid, this.matchedRoomId);
        } else if (ChatManager.debug) {
            Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行applyFriend操作");
        }
    }

    public void close() {
        if (ChatManager.debug) {
            Log.v(TAG, "close(), state:" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.MATCHING) {
            this.flashVideoImpl.cancelMatch();
        } else if (this.state == MatchState.CHATING) {
            int i = 1;
            switch (AnonymousClass19.$SwitchMap$com$blued$android$chat$FlashVideoHelper$BothAgreeState[this.matchAgreeState.ordinal()]) {
                case 1:
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                case 4:
                    i = 3;
                    break;
                case 5:
                    i = 4;
                    break;
                case 6:
                    i = 5;
                    break;
                default:
                    i = 1;
                    break;
            }
            this.flashVideoImpl.closeFlashVideo(this.matchedUid, this.matchedRoomId, i);
        }
        this.state = MatchState.IDLE;
        this.matchAgreeState = BothAgreeState.IDLE;
        this.addExtraTimeAgreeState = BothAgreeState.IDLE;
    }

    public void destroy() {
        if (ChatManager.debug) {
            Log.v(TAG, "destroy(), state:" + this.state);
        }
        this.state = MatchState.DESTROY;
        this.matchListener = null;
        ChatManager.getInstance().unregisterFlashVideoHelper(this);
    }

    public void match() {
        if (ChatManager.debug) {
            Log.v(TAG, "match(), state:" + this.state);
        }
        if (this.state == MatchState.DESTROY) {
            if (ChatManager.debug) {
                Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行match操作");
                return;
            }
            return;
        }
        this.state = MatchState.MATCHING;
        this.matchAgreeState = BothAgreeState.IDLE;
        this.addExtraTimeAgreeState = BothAgreeState.IDLE;
        this.flashVideoImpl.startMatch();
    }

    public void matchAgree() {
        if (ChatManager.debug) {
            Log.v(TAG, "matchAgree(), state:" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.DESTROY) {
            if (ChatManager.debug) {
                Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行matchAgree操作");
                return;
            }
            return;
        }
        BothAgreeState agreeStateSelf = this.matchAgreeState.setAgreeStateSelf();
        this.matchAgreeState = agreeStateSelf;
        if (agreeStateSelf == BothAgreeState.AGREE_BOTH) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onMatchAgreed();
                    }
                }
            });
        }
        this.flashVideoImpl.matchAgree(this.matchedUid, this.matchedRoomId);
    }

    public void matchCancel() {
        if (ChatManager.debug) {
            Log.e(TAG, "matchCancel(), state:" + this.state + ", matchAgreeState:" + this.matchAgreeState + ", cancel");
        }
        if (this.state == MatchState.DESTROY) {
            if (ChatManager.debug) {
                Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行matchCancel操作");
            }
        } else if (this.state == MatchState.CHATING) {
            this.flashVideoImpl.cancelMatch();
            matchReject();
        } else {
            this.flashVideoImpl.cancelMatch();
            this.state = MatchState.IDLE;
            this.matchAgreeState = BothAgreeState.IDLE;
            this.addExtraTimeAgreeState = BothAgreeState.IDLE;
        }
    }

    public void matchReject() {
        if (ChatManager.debug) {
            Log.v(TAG, "matchReject(), state:" + this.state + "   matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state != MatchState.DESTROY) {
            this.matchAgreeState = this.matchAgreeState.setAgreeStateReject();
            close();
        } else if (ChatManager.debug) {
            Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行matchReject操作");
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onApplyFriends(String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onApplyFriends(), roomId:" + str + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, str)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.11
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onApplyFriends();
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onApplyFriends(final Map map) {
        notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.13
            @Override // java.lang.Runnable
            public void run() {
                if (FlashVideoHelper.this.matchListener != null) {
                    FlashVideoHelper.this.matchListener.onApplyFriendsReq(map);
                }
            }
        });
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onApplyFriendsAgree(String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onApplyFriendsAgree(), roomId:" + str + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, str)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.12
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onApplyFriendsAgree();
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onChatClose(String str, final int i, final String str2) {
        if (ChatManager.debug) {
            Log.v(TAG, "onChatClose(), state:" + this.state + ", roomId:" + str + ", reason:" + i + ", message:" + str2);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(str, this.matchedRoomId)) {
            this.state = MatchState.IDLE;
            this.matchAgreeState = BothAgreeState.IDLE;
            this.addExtraTimeAgreeState = BothAgreeState.IDLE;
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onChatClose(i, str2);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onMatchAck(final String str, final List<String> list) {
        if (this.state == MatchState.MATCHING) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onMatchWaiting(str, list);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onMatchFailed(final MatchFailed matchFailed, final String str, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "onMatchFailed(), state:" + this.state + ", failedReason:" + matchFailed + ", failedMessage:" + str + ", remainNum:" + i);
        }
        if (this.state == MatchState.MATCHING) {
            this.state = MatchState.IDLE;
            this.matchAgreeState = BothAgreeState.IDLE;
            this.addExtraTimeAgreeState = BothAgreeState.IDLE;
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onMatchFailed(matchFailed, str, i);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onMatched(final String str, final RelationProfileData relationProfileData, final int i, final int i2, final String str2, final String str3, final String str4, final int i3) {
        if (ChatManager.debug) {
            Log.v(TAG, "onMatched(), state:" + this.state + ", roomId:" + str + ", maxTimeSec:" + i2 + ", chatTips:" + str2 + ", streamId:" + str3 + ", remainNum:" + i3);
        }
        long j = 0;
        if (this.state != MatchState.MATCHING) {
            FlashVideo flashVideo = this.flashVideoImpl;
            if (relationProfileData != null) {
                j = relationProfileData.uid;
            }
            flashVideo.closeFlashVideo(j, str, 2);
            return;
        }
        this.state = MatchState.CHATING;
        this.matchedRoomId = str;
        if (relationProfileData != null) {
            j = relationProfileData.uid;
        }
        this.matchedUid = j;
        notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (FlashVideoHelper.this.matchListener != null) {
                    FlashVideoHelper.this.matchListener.onMatchSuccess(str, relationProfileData, i, i2, str2, str3, str4, i3);
                }
            }
        });
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onReceiveApplyExtraTime(String str, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveApplyExtraTime(), roomId:" + str + ", extraTime:" + i + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, str)) {
            this.extraTime = i;
            BothAgreeState agreeStateOpposite = this.addExtraTimeAgreeState.setAgreeStateOpposite();
            this.addExtraTimeAgreeState = agreeStateOpposite;
            if (agreeStateOpposite != BothAgreeState.AGREE_BOTH) {
                notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FlashVideoHelper.this.matchListener != null) {
                            FlashVideoHelper.this.matchListener.onReceiveAddExtraTimeApply();
                        }
                    }
                });
                return;
            }
            this.addExtraTimeAgreeState = BothAgreeState.IDLE;
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.9
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onApplydExtraTimeAgree(i);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onReceiveEmoji(String str, final String str2) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveEmoji(), roomId:" + str + ", emojiTag" + str2 + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, str)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.15
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onReceiveEmoji(str2);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onReceiveGift(final FlashVideoGiftModel flashVideoGiftModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveGift(), model:" + flashVideoGiftModel);
        }
        if (flashVideoGiftModel != null && this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, flashVideoGiftModel.roomId)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.7
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onReceiveGift(flashVideoGiftModel);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onReceiveMatchAgree(String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveMatchAgree(), roomId:" + str + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, str)) {
            BothAgreeState agreeStateOpposite = this.matchAgreeState.setAgreeStateOpposite();
            this.matchAgreeState = agreeStateOpposite;
            if (agreeStateOpposite == BothAgreeState.AGREE_BOTH) {
                notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FlashVideoHelper.this.matchListener != null) {
                            FlashVideoHelper.this.matchListener.onMatchAgreed();
                        }
                    }
                });
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onReceiveText(long j, final ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveText(), sessionId:" + j + ", matchedUid" + this.matchedUid + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.16
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onReceiveText(chattingModel);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onSayHi(String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onSayHi(), roomId:" + str + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING && TextUtils.equals(this.matchedRoomId, str)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.14
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onSayHi();
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onSendTextMsgFail(long j, final String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onSendTextMsgFail(), sessionId:" + j + ", matchedUid" + this.matchedUid + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState + " , sendFailMsg:" + str);
        }
        if (this.state == MatchState.CHATING) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.18
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onSendTextMsgFail(str);
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.FlashVideo.IFlashVideoCallback
    public void onSendTextMsgSuccess(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "onSendTextMsgSuccess(), sessionId:" + j + ", matchedUid" + this.matchedUid + ", state" + this.state + ", matchAgreeState:" + this.matchAgreeState);
        }
        if (this.state == MatchState.CHATING) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.FlashVideoHelper.17
                @Override // java.lang.Runnable
                public void run() {
                    if (FlashVideoHelper.this.matchListener != null) {
                        FlashVideoHelper.this.matchListener.onSendTextMsgSuccess();
                    }
                }
            });
        }
    }

    public void sendEmoji(String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendEmoji(), state:" + this.state);
        }
        if (this.state != MatchState.DESTROY) {
            this.flashVideoImpl.sendEmoji(this.matchedUid, this.matchedRoomId, str);
        } else if (ChatManager.debug) {
            Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行sendEmoji操作");
        }
    }

    public void sendTextMsg(long j, ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "SendTextMsg, state:" + this.state);
        }
        if (this.state != MatchState.DESTROY) {
            this.flashVideoImpl.sendMsg(j, chattingModel);
        } else if (ChatManager.debug) {
            Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行send操作");
        }
    }

    public void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }
}
