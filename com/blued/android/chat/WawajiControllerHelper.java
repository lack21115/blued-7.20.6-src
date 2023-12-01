package com.blued.android.chat;

import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.chat.WawajiControllerChat;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper.class */
public class WawajiControllerHelper implements WawajiControllerChat.IWawajiControllerCallback {
    private static final String TAG = "Chat_WawajiController";
    private final Handler callBackHandler;
    private final long controllerVersionCode;
    private final GameDataOper gameDataOper;
    private WawajiGamePlaying playingData;
    private long sessionId;
    private final WawajiCallback wawajiCallback;
    private DeviceState deviceState = DeviceState.IDLE;
    private boolean playingCheck = false;
    private WawajiControllerChat wawajiControllerChat = ChatManager.getInstance().registerWawajiControllerHelper(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper$DeviceState.class */
    public enum DeviceState {
        IDLE,
        INIT,
        STREAM,
        WAIT,
        PLAY,
        DEAD
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper$GameDataOper.class */
    public interface GameDataOper {
        int deleteGameDataRecord(int i);

        List<WawajiGameResult> getGameDataRecords();

        int saveGameDataRecord(WawajiGameResult wawajiGameResult);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper$WawajiCallback.class */
    public interface WawajiCallback {
        void onInit(String str, String str2, String str3);

        void onPlayGame(WawajiControllerConfig wawajiControllerConfig);

        void onUpdate(long j, String str);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper$WawajiControllerConfig.class */
    public static class WawajiControllerConfig {
        public int at_talon;
        public int b_talon;
        public int heigh;
        public int m_talon;
        public int play_maxtime;
        public int success;
        public int u_talon;

        public static WawajiControllerConfig parseData(Map<String, Object> map) {
            WawajiControllerConfig wawajiControllerConfig = new WawajiControllerConfig();
            wawajiControllerConfig.play_maxtime = MsgPackHelper.getIntValue(map, "play_maxtime");
            wawajiControllerConfig.success = MsgPackHelper.getIntValue(map, "success");
            wawajiControllerConfig.u_talon = MsgPackHelper.getIntValue(map, "u_talon");
            wawajiControllerConfig.at_talon = MsgPackHelper.getIntValue(map, "at_talon");
            wawajiControllerConfig.m_talon = MsgPackHelper.getIntValue(map, "m_talon");
            wawajiControllerConfig.b_talon = MsgPackHelper.getIntValue(map, "b_talon");
            wawajiControllerConfig.heigh = MsgPackHelper.getIntValue(map, "heigh");
            return wawajiControllerConfig;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper$WawajiGamePlaying.class */
    static class WawajiGamePlaying {
        public int maxTimeSec;
        public String orderId;
        public long playerUid;
        public long sessionId;
        public long startTimeSec;

        private WawajiGamePlaying() {
        }

        public WawajiGameResult createGameResult(int i) {
            WawajiGameResult wawajiGameResult = new WawajiGameResult();
            wawajiGameResult.sessionId = this.sessionId;
            wawajiGameResult.playerUid = this.playerUid;
            wawajiGameResult.orderId = this.orderId;
            wawajiGameResult.result = i;
            return wawajiGameResult;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiControllerHelper$WawajiGameResult.class */
    public static class WawajiGameResult {
        public int id;
        public String orderId;
        public long playerUid;
        public int result = -1;
        public long sessionId;

        public String toString() {
            return "[id:" + this.id + ", sessionId:" + this.sessionId + ", playerUid:" + this.playerUid + ", orderId:" + this.orderId + ", result:" + this.result + "]";
        }
    }

    public WawajiControllerHelper(GameDataOper gameDataOper, long j, WawajiCallback wawajiCallback, Handler handler) {
        this.gameDataOper = gameDataOper;
        this.wawajiCallback = wawajiCallback;
        this.callBackHandler = handler;
        this.controllerVersionCode = j;
        int uploadGameRecord = uploadGameRecord();
        notifyDebugTips(uploadGameRecord + "条记录需要上报");
        initController();
        notifyDebugTips("初始化设备，当前控制器版本号: " + j);
        setState(DeviceState.INIT);
    }

    private void checkGamePlaying() {
        if (this.deviceState != DeviceState.WAIT || this.playingCheck) {
            return;
        }
        notifyDebugTips("当前状态为 " + this.deviceState + ", 进行服务器查询操作");
        this.playingCheck = true;
        this.wawajiControllerChat.checkPlayingState(this.sessionId);
    }

    private void initController() {
        this.wawajiControllerChat.initController();
    }

    private void notifyCallback(Runnable runnable) {
        Handler handler = this.callBackHandler;
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void notifyDebugTips(String str) {
        Log.v(TAG, str);
        if (!ChatManager.debug || ChatManager.getInstance().debugTipsListener == null) {
            return;
        }
        ChatManager.getInstance().debugTipsListener.onTips(str);
    }

    private void setState(DeviceState deviceState) {
        notifyDebugTips("控制器初状态由 " + this.deviceState + " 切换到 " + deviceState);
        this.deviceState = deviceState;
    }

    private int uploadGameRecord() {
        List<WawajiGameResult> gameDataRecords;
        GameDataOper gameDataOper = this.gameDataOper;
        if (gameDataOper == null || (gameDataRecords = gameDataOper.getGameDataRecords()) == null || gameDataRecords.size() <= 0) {
            return 0;
        }
        for (WawajiGameResult wawajiGameResult : gameDataRecords) {
            this.wawajiControllerChat.uploadGameResult(wawajiGameResult);
        }
        return gameDataRecords.size();
    }

    public boolean checkPlayerOperation(long j) {
        synchronized (this) {
            if (ChatManager.debug) {
                Log.v(TAG, "checkPlayerOperation(), operationUid:" + j);
            }
            if (this.deviceState == DeviceState.PLAY && this.playingData != null && this.playingData.playerUid == j) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("用户操作检查失败, 当前状态:");
            sb.append(this.deviceState);
            sb.append(", operationUid:");
            sb.append(j);
            sb.append(", need_playingUid:");
            sb.append(this.playingData == null ? "null" : Long.valueOf(this.playingData.playerUid));
            notifyDebugTips(sb.toString());
            checkGamePlaying();
            return false;
        }
    }

    public void destroy() {
        synchronized (this) {
            if (ChatManager.debug) {
                Log.v(TAG, "destroy()");
            }
            setState(DeviceState.DEAD);
            this.wawajiControllerChat = null;
            ChatManager.getInstance().unregisterWawajiControllerHelper(this);
        }
    }

    public void deviceReady() {
        synchronized (this) {
            setState(DeviceState.WAIT);
            notifyDebugTips("当前设备初始化完成, 等待玩家...");
            this.wawajiControllerChat.readyController(this.sessionId);
        }
    }

    public void gameOver(int i) {
        synchronized (this) {
            notifyDebugTips("游戏完成, result:" + i + ", playingData:" + this.playingData);
            if (this.deviceState == DeviceState.PLAY) {
                setState(DeviceState.WAIT);
            } else {
                notifyDebugTips("控制器状态异常, 当前状态:" + this.deviceState + ", 期望:" + DeviceState.PLAY);
            }
            if (this.playingData != null) {
                WawajiGameResult createGameResult = this.playingData.createGameResult(i);
                if (this.gameDataOper != null) {
                    int saveGameDataRecord = this.gameDataOper.saveGameDataRecord(createGameResult);
                    if (saveGameDataRecord <= 0) {
                        notifyDebugTips("游戏结果保存失败, saveId:" + saveGameDataRecord);
                    } else {
                        notifyDebugTips("游戏结果已保存, saveId:" + saveGameDataRecord);
                    }
                    createGameResult.id = saveGameDataRecord;
                }
                this.wawajiControllerChat.uploadGameResult(createGameResult);
                this.playingData = null;
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onControllerUpdate(final long j, final String str) {
        synchronized (this) {
            notifyDebugTips("接收到升级通知, 控制器版本:" + this.controllerVersionCode + ", 升级版本:" + j);
            if (j > this.controllerVersionCode) {
                notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiControllerHelper.3
                    @Override // java.lang.Runnable
                    public void run() {
                        WawajiControllerHelper.this.wawajiCallback.onUpdate(j, str);
                    }
                });
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onInitControllerFailed(String str) {
        synchronized (this) {
            notifyDebugTips("控制器初始化失败, errorMsg:" + str);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onInitControllerSuccess(long j, final String str, final String str2, final String str3) {
        synchronized (this) {
            notifyDebugTips("控制器初始化成功, sessionId:" + j + ", roomId:" + str + ", streamId1:" + str2 + ", streamId2:" + str3);
            this.sessionId = j;
            if (this.deviceState == DeviceState.INIT) {
                setState(DeviceState.STREAM);
                notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiControllerHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WawajiControllerHelper.this.wawajiCallback.onInit(str, str2, str3);
                    }
                });
                return;
            }
            notifyDebugTips("控制器状态异常, 当前状态:" + this.deviceState + ", 需要:" + DeviceState.INIT);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onPlayCheckFailed(String str) {
        synchronized (this) {
            this.playingCheck = false;
            notifyDebugTips("控制器play确认失败, errorMsg:" + str);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onPlayCheckSuccess() {
        this.playingCheck = false;
        notifyDebugTips("控制器play确认成功");
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onPlayConfig(long j, String str, final WawajiControllerConfig wawajiControllerConfig) {
        synchronized (this) {
            if (this.deviceState == DeviceState.WAIT) {
                notifyDebugTips("收到游戏配置，开始进入游戏状态");
                WawajiGamePlaying wawajiGamePlaying = new WawajiGamePlaying();
                this.playingData = wawajiGamePlaying;
                wawajiGamePlaying.playerUid = j;
                this.playingData.orderId = str;
                this.playingData.sessionId = this.sessionId;
                this.playingData.maxTimeSec = wawajiControllerConfig.play_maxtime;
                this.playingData.startTimeSec = System.currentTimeMillis() / 1000;
                setState(DeviceState.PLAY);
                notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiControllerHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WawajiControllerHelper.this.wawajiCallback.onPlayGame(wawajiControllerConfig);
                    }
                });
            } else {
                notifyDebugTips("当前控制器状态异常，当前状态:" + this.deviceState + ", 期望:" + DeviceState.WAIT);
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onReadyControllerFailed(String str) {
        synchronized (this) {
            notifyDebugTips("控制器ready通知失败, errorMsg:" + str);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onReadyControllerSuccess() {
        synchronized (this) {
            notifyDebugTips("控制器ready通知成功");
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onUploadGameResultFailed(WawajiGameResult wawajiGameResult, String str) {
        synchronized (this) {
            notifyDebugTips("游戏记录 " + wawajiGameResult.id + " 上传失败, errorMsg:" + str);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiControllerChat.IWawajiControllerCallback
    public void onUploadGameResultSuccess(WawajiGameResult wawajiGameResult) {
        synchronized (this) {
            notifyDebugTips("游戏记录 " + wawajiGameResult.id + " 上传成功");
            if (this.gameDataOper != null) {
                this.gameDataOper.deleteGameDataRecord(wawajiGameResult.id);
            }
        }
    }
}
