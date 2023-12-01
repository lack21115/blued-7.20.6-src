package com.blued.android.chat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.chat.AudioRoomChat;
import com.blued.android.chat.core.worker.chat.Chat;
import com.blued.android.chat.core.worker.chat.FlashVideo;
import com.blued.android.chat.core.worker.chat.LiveChat;
import com.blued.android.chat.core.worker.chat.RoomChat;
import com.blued.android.chat.core.worker.chat.VideoChat;
import com.blued.android.chat.core.worker.chat.WawajiChat;
import com.blued.android.chat.core.worker.chat.WawajiControllerChat;
import com.blued.android.chat.core.worker.heart.Heart;
import com.blued.android.chat.data.UserInfoForChat;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.listener.AudioRoomChatInfoListener;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.DebugTipsListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.ILogCallback;
import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.chat.listener.LiveChatCreateListener;
import com.blued.android.chat.listener.LiveChatEnterListener;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.listener.LoadListener;
import com.blued.android.chat.listener.LoadMsgListener;
import com.blued.android.chat.listener.MsgContentListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.listener.MsgReceiveListener;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.DeviceInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.qiniu.android.dns.DnsManager;
import io.grpc.internal.GrpcUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/ChatManager.class */
public class ChatManager {
    private static final String TAG = "Chat_ChatManager";
    public static ClientType clientType;
    public static DBOper dbOperImpl;
    private AudioRoomChat audioRoomChat;
    private Chat chat;
    protected Connector connector;
    public DebugTipsListener debugTipsListener;
    private FlashVideo flashVideo;
    protected Heart heart;
    private LiveChat liveChat;
    private MsgReceiveListener msgReceiveListener;
    private RoomChat roomChat;
    private ChatTipsListener tipsListener;
    private VideoChat videoChat;
    private WawajiChat wawajiChat;
    private WawajiControllerChat wawajiControllerChat;
    public static final UserInfoForChat userInfo = new UserInfoForChat();
    private static ChatManager instance = null;
    public static Context context = null;
    public static boolean debug = false;
    public static boolean debugByteData = false;
    public static String chatHostAddr = "h3.blued.cn";
    public static int chatHostPort = 8080;
    public static int chatBackupPort = GrpcUtil.DEFAULT_PORT_SSL;
    public static DnsManager dnsManager = null;
    public static boolean isDnsManagerPrior = false;
    public static boolean isSSL = false;
    public static String language = null;
    public static String languageDetail = null;
    private boolean appActived = false;
    protected boolean stopped = true;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/ChatManager$ClientType.class */
    public enum ClientType {
        CHINA,
        INTERNATIONAL
    }

    private ChatManager() {
        Connector connector = new Connector();
        this.connector = connector;
        this.heart = new Heart(connector);
        Chat chat = new Chat(this.connector);
        this.chat = chat;
        this.videoChat = new VideoChat(this.connector, chat);
        this.flashVideo = new FlashVideo(this.connector, this.chat);
        this.wawajiControllerChat = new WawajiControllerChat(this.connector, this.chat);
        this.wawajiChat = new WawajiChat(this.connector, this.chat);
        this.roomChat = new RoomChat(this.chat);
        this.audioRoomChat = new AudioRoomChat(this.connector, this.chat);
    }

    private String getAppVersion(Context context2) {
        try {
            PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0);
            return packageInfo.versionName + BridgeUtil.UNDERLINE_STR + packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private File getDebugLogFile(Context context2) {
        File file = new File(context2.getFilesDir(), "blued_debug_log");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "blued_chat.txt");
        if (file2.exists() && file2.length() > 1024000 && !file2.delete()) {
            Log.e(TAG, "文件大小超过限制, 但删除失败");
            return null;
        }
        try {
            file2.createNewFile();
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ChatManager getInstance() {
        if (instance == null) {
            synchronized (ChatManager.class) {
                try {
                    if (instance == null) {
                        instance = new ChatManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static boolean isInited() {
        return context != null;
    }

    public void appActiveChanged(final boolean z) {
        if (debug) {
            Log.v(TAG, "appActiveChanged(), actived:" + z);
        }
        this.appActived = z;
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.78
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "appActiveChanged() running, actived:" + z);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.heart != null) {
                    ChatManager.this.heart.appActiveChanged(z);
                }
                if (ChatManager.this.connector != null) {
                    ChatManager.this.connector.appActiveChanged(z);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "appActiveChanged() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void applyJoinLive(final short s, final long j, final long j2) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.72
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.applyJoinLive(s, j, j2);
                }
            }
        });
    }

    public void clearAllSecretLook() {
        if (debug) {
            Log.v(TAG, "clearAllSecretLook()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.93
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.clearAllSecretLook();
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "clearAllSecretLook() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: ");
                }
            }
        });
    }

    public void closeLiveChat(short s, long j) {
        closeLiveChat(s, j, 0);
    }

    public void closeLiveChat(final short s, final long j, final int i) {
        if (debug) {
            Log.v(TAG, "closeLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.65
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "closeLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.closeLiveChat(s, j, i);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "closeLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void createGameLiveChat(final String str, final String str2, final int i, final int i2, final int i3, final LiveChatCreateListener liveChatCreateListener) {
        if (debug) {
            Log.v(TAG, "createLiveChat(), liveDescription:" + str + ", liveCover:" + str2 + ", screenPattern:" + i + ", showNearby:" + i2 + ", privateFlag:" + i3);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.60
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.createLiveChat(0, 1, str, str2, i, i2, i3, liveChatCreateListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void createLiveChat(final int i, final String str, final String str2, final int i2, final int i3, final int i4, final LiveChatCreateListener liveChatCreateListener) {
        if (debug) {
            Log.v(TAG, "createLiveChat(), liveDescription:" + str + ", liveCover:" + str2 + ", screenPattern:" + i2 + ", showNearby:" + i3 + ", privateFlag:" + i4);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.58
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.createLiveChat(0, i, str, str2, i2, i3, i4, liveChatCreateListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void createLiveChat(final String str, final String str2, final int i, final int i2, final int i3, final LiveChatCreateListener liveChatCreateListener) {
        if (debug) {
            Log.v(TAG, "createLiveChat(), liveDescription:" + str + ", liveCover:" + str2 + ", screenPattern:" + i + ", showNearby:" + i2 + ", privateFlag:" + i3);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.57
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.createLiveChat(0, 0, str, str2, i, i2, i3, liveChatCreateListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void createMirrorLiveChat(final String str, final String str2, final int i, final int i2, final int i3, final LiveChatCreateListener liveChatCreateListener) {
        if (debug) {
            Log.v(TAG, "createLiveChat(), liveDescription:" + str + ", liveCover:" + str2 + ", screenPattern:" + i + ", showNearby:" + i2 + ", privateFlag:" + i3);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.59
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.createLiveChat(1, 0, str, str2, i, i2, i3, liveChatCreateListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "createLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteAllChattings() {
        if (debug) {
            Log.v(TAG, "deleteAllChattings()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.39
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllChattings() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteAllChattings();
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllChattings() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteAllSessionAndChatting() {
        if (debug) {
            Log.v(TAG, "deleteAllSessionAndChatting()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.36
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllSessionAndChatting() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteAllSessions(true);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllSessionAndChatting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteAllSessions() {
        if (debug) {
            Log.v(TAG, "deleteAllSessions()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.31
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllSessions() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteAllSessions(false);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllSessions() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteAllTempChatting(final int i, final long j) {
        if (debug) {
            Log.v(TAG, "deleteAllTempChatting(), sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.41
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllTempChatting() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(Short.valueOf((short) i), Long.valueOf(j)));
                    ChatManager.this.chat.deleteSessionsWithSetting(arrayList, true);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteChatting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteChatting(final int i, final long j) {
        if (debug) {
            Log.v(TAG, "deleteChatting(), sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.37
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteChatting() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteChatting(i, j);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteChatting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteLocalChatting(final int i, final long j) {
        if (debug) {
            Log.v(TAG, "deleteLocalChatting(), sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.38
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteLocalChatting() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteLocalChatting(i, j);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteLocalChatting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteOneMessage(final short s, final long j, final long j2, final long j3) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.40
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteOneMessage(s, j, j2, j3);
                }
            }
        });
    }

    public void deleteSession(final short s, final long j) {
        if (debug) {
            Log.v(TAG, "deleteSession(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.29
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSession() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(Short.valueOf(s), Long.valueOf(j)));
                    ChatManager.this.chat.deleteSessions(arrayList, false);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSession() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteSessionAndChatting(final Short sh, final long j) {
        if (debug) {
            Log.v(TAG, "deleteSessionAndChattingForOne(), sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.32
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChattingForOne() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(sh, Long.valueOf(j)));
                    ChatManager.this.chat.deleteSessions(arrayList, true);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChattingForOne() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteSessionAndChatting(final List<Pair<Short, Long>> list) {
        if (debug) {
            Log.v(TAG, "deleteSessionAndChatting()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.33
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChatting() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteSessions(list, true);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChatting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteSessionAndChattingWithSetting(final Short sh, final long j) {
        if (debug) {
            Log.v(TAG, "deleteSessionAndChattingWithSetting(), sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.34
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChattingWithSetting() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(sh, Long.valueOf(j)));
                    ChatManager.this.chat.deleteSessionsWithSetting(arrayList, true);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChattingWithSetting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteSessionAndChattingWithSetting(final List<Pair<Short, Long>> list) {
        if (debug) {
            Log.v(TAG, "deleteSessionAndChattingWithSetting()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.35
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChattingWithSetting() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteSessionsWithSetting(list, true);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessionAndChattingWithSetting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void deleteSessions(final List<Pair<Short, Long>> list) {
        if (debug) {
            Log.v(TAG, "deleteSessions()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.30
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessions() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.deleteSessions(list, false);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteSessions() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void destroyMsg(final short s, final long j, final ChattingModel chattingModel) {
        if (debug) {
            Log.v(TAG, "destroyMsg(), sessionType:" + ((int) s) + ", sessionId:" + j + ", msgData:" + chattingModel);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.24
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "destroyMsg() running, msgData:" + chattingModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.destroyMsg(s, j, chattingModel);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "destroyMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void enterLiveChat(final short s, final long j, final String str, final LiveChatEnterListener liveChatEnterListener) {
        if (debug) {
            Log.v(TAG, "enterLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.66
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "enterLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.enterLiveChat(s, j, str, liveChatEnterListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "enterLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void findMessage(final short s, final long j, final long j2, final long j3, final LoadMsgListener loadMsgListener) {
        if (debug) {
            Log.v(TAG, "findMessage()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.94
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.findMessage(s, j, j2, j3, loadMsgListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "findMessage() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: ");
                }
            }
        });
    }

    public MsgReceiveListener getMsgReceiveListener() {
        return this.msgReceiveListener;
    }

    public void getSessionModel(final short s, final long j, final FetchDataListener<SessionModel> fetchDataListener) {
        if (debug) {
            Log.v(TAG, "getSessionModel(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.17
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionModel() running, sessionType:" + ((int) s) + ", sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.getSessionModel(s, j, fetchDataListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionModel() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void getSessionModelList(final FetchDataListener<List<SessionModel>> fetchDataListener) {
        if (debug) {
            Log.v(TAG, "getSessionModelList(), listener:" + fetchDataListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.18
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionModelList() running, listener:" + fetchDataListener);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.getSessionModelList(fetchDataListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionModelList() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void getSessionModelMap(final FetchDataListener<Map<String, SessionModel>> fetchDataListener) {
        if (debug) {
            Log.v(TAG, "getSessionModelMap(), listener:" + fetchDataListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.19
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionModelMap() running, listener:" + fetchDataListener);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.getSessionModelMap(fetchDataListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionModelMap() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void getSessionSettingModel(final short s, final long j, final FetchDataListener<SessionSettingBaseModel> fetchDataListener) {
        if (debug) {
            Log.v(TAG, "getSessionSettingModel(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.16
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionSettingModel() running, sessionType:" + ((int) s) + ", sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.getSessionSettingModel(s, j, fetchDataListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "getSessionSettingModel() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public SessionModel getSnapSessionModel(short s, long j) {
        if (debug) {
            Log.v(TAG, "getSnapSessionModel(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        Chat chat = this.chat;
        if (chat != null) {
            return chat.getSnapSessionModel(s, j);
        }
        return null;
    }

    public ChatTipsListener getTipsListener() {
        return this.tipsListener;
    }

    public long getUid() {
        UserInfoForChat userInfoForChat = userInfo;
        if (userInfoForChat != null) {
            return userInfoForChat.uid;
        }
        return 0L;
    }

    public void ignoredNoReadNum(final List<Pair<Short, Long>> list) {
        if (debug) {
            Log.v(TAG, "ignoredNoReadNum()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.46
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "ignoredNoReadNum() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.ignoredNoReadNumForSessions(list);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "appActiveChanged() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void ignoredNoReadNum(final short s, final long j) {
        if (debug) {
            Log.v(TAG, "ignoredNoReadNum()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.45
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "ignoredNoReadNum() running, sessionType:" + ((int) s) + ", sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(Short.valueOf(s), Long.valueOf(j)));
                    ChatManager.this.chat.ignoredNoReadNumForSessions(arrayList);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "appActiveChanged() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void ignoredNoReadNumAll() {
        if (debug) {
            Log.v(TAG, "ignoredNoReadNumAll()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.44
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "ignoredNoReadNumAll() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.ignoredNoReadNumAll();
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "appActiveChanged() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void init(Context context2, ClientType clientType2, DBOper dBOper, boolean z) {
        init(context2, clientType2, dBOper, z, null);
    }

    public void init(Context context2, ClientType clientType2, DBOper dBOper, boolean z, ILogCallback iLogCallback) {
        if (context != null) {
            return;
        }
        clientType = clientType2;
        context = context2;
        debug = z;
        if (dBOper != null) {
            dbOperImpl = dBOper;
        } else {
            dbOperImpl = DBOper.EmptyDBOper;
        }
        initLanguage();
        try {
            if (iLogCallback != null) {
                Log.init(context2, iLogCallback);
            } else if (z) {
                File debugLogFile = getDebugLogFile(context2);
                if (debugLogFile != null) {
                    Log.init(context2, true, debugLogFile);
                } else {
                    Log.init(context2, false, null);
                }
            } else {
                Log.init(context2, false, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (debug) {
            Log.v(TAG, "\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++");
            Log.v(TAG, "device info:" + DeviceInfo.getDeviceInfo());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:
        if ("hk".equalsIgnoreCase(r0) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initLanguage() {
        /*
            r3 = this;
            java.util.Locale r0 = com.blued.android.chat.utils.BlueAppChatLocal.getDefault()
            java.lang.String r0 = r0.getLanguage()
            r4 = r0
            r0 = r4
            com.blued.android.chat.ChatManager.language = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1b
            java.lang.String r0 = ""
            com.blued.android.chat.ChatManager.language = r0
            goto L7a
        L1b:
            java.lang.String r0 = com.blued.android.chat.ChatManager.language
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r0 = r0.trim()
            com.blued.android.chat.ChatManager.language = r0
            java.util.Locale r0 = com.blued.android.chat.utils.BlueAppChatLocal.getDefault()
            java.lang.String r0 = r0.getCountry()
            r5 = r0
            java.lang.String r0 = "tw"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L44
            r0 = r5
            r4 = r0
            java.lang.String r0 = "hk"
            r1 = r5
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L48
        L44:
            java.lang.String r0 = "tw"
            r4 = r0
        L48:
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L7a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = com.blued.android.chat.ChatManager.language
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = "_"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r1 = r1.trim()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            com.blued.android.chat.ChatManager.languageDetail = r0
        L7a:
            java.lang.String r0 = com.blued.android.chat.ChatManager.languageDetail
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L89
            java.lang.String r0 = com.blued.android.chat.ChatManager.language
            com.blued.android.chat.ChatManager.languageDetail = r0
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.ChatManager.initLanguage():void");
    }

    public void initLiveChatInfo(final short s, final long j, final boolean z) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.85
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.initLiveChatInfo(s, j, z);
            }
        });
    }

    public void insertMsgListFromBackup(final List<ChattingModel> list) {
        if (debug) {
            Log.v(TAG, "insertMsgListFromBackup(), chattingModelList:" + list.size());
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.89
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                int insertMsgListFromBackup = ChatManager.this.chat != null ? ChatManager.this.chat.insertMsgListFromBackup(list) : -1;
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "insertMsgListFromBackup() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: " + insertMsgListFromBackup);
                }
            }
        });
    }

    public void insertSessionList(final List<SessionModel> list) {
        if (debug) {
            Log.v(TAG, "insertSessionList(), sessionModels:" + list.size());
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.88
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                int insertSessionList = ChatManager.this.chat != null ? ChatManager.this.chat.insertSessionList(list) : -1;
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "insertSessionList() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: " + insertSessionList);
                }
            }
        });
    }

    public boolean isAppActived() {
        return this.appActived;
    }

    public void leaveLiveChat(final short s, final long j, final String str) {
        if (debug) {
            Log.v(TAG, "leaveLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.67
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "leaveLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.leaveLiveChat(s, j, str);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "leaveLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void loadNewMsg(final short s, final long j, final int i, final LoadMsgListener loadMsgListener) {
        if (debug) {
            Log.v(TAG, "loadNewMsg(), sessionId:" + j + ", count:" + i + ", listener:" + loadMsgListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.28
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadNewMsg() running, sessionId:" + j + ", count:" + i + ", listener:" + loadMsgListener);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.loadNewMsg(s, j, i, loadMsgListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadNewMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void loadServiceSessionMsgList(final short s, final String str, final ChattingModel chattingModel, final int i, final FetchDataListener<List<ChattingModel>> fetchDataListener) {
        if (debug) {
            Log.v(TAG, "loadSessionMsgList(), sessionId:" + str + ", count:" + i + ", listener:" + fetchDataListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.26
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadSessionMsgList() running, sessionId:" + str + ", count:" + i + ", listener:" + fetchDataListener);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.loadServiceSessionMsgList(s, str, chattingModel, i, fetchDataListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadSessionMsgList() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void loadSessionDownMsgList(final short s, final long j, final int i, final long j2, final long j3, final LoadListener loadListener) {
        if (debug) {
            Log.v(TAG, "loadSessionMsgList(), sessionId:" + j + ", count:" + i + ", listener:" + loadListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.27
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadSessionMsgList() running, sessionId:" + j + ", count:" + i + ", listener:" + loadListener);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.loadDownSessionMsgList(s, j, j2, j3, i, loadListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadSessionMsgList() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void loadSessionMsgList(final short s, final long j, final int i, final LoadListener loadListener) {
        if (debug) {
            Log.v(TAG, "loadSessionMsgList(), sessionId:" + j + ", count:" + i + ", listener:" + loadListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.25
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadSessionMsgList() running, sessionId:" + j + ", count:" + i + ", listener:" + loadListener);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.loadSessionMsgList(s, j, i, loadListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "loadSessionMsgList() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void mergeAllTempChatting(final short s, final long j, final MsgContentListener msgContentListener) {
        if (debug) {
            Log.v(TAG, "deleteAllTempChatting(), sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.42
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteAllTempChatting() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.mergeAllTempChatting(s, j, msgContentListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "deleteChatting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void networkChanged() {
        if (debug) {
            Log.v(TAG, "networkChanged(), stopped:" + this.stopped);
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.79
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "networkChanged() running, stopped:" + ChatManager.this.stopped);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.connector != null) {
                    ChatManager.this.connector.checkNet();
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "networkChanged() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void notifyJoinLiveEnd(final short s, final long j, final long j2, final long j3) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.74
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.notifyJoinLiveEnd(s, j, j2, j3);
                }
            }
        });
    }

    public void notifyJoinLiveStart(final short s, final long j, final long j2, final String str, final long j3) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.73
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.notifyJoinLiveStart(s, j, j2, str, j3);
                }
            }
        });
    }

    public void notifySendStateForGRPC(final int i, final ChattingModel chattingModel, final short s, final long j, final short s2, final long j2, final long j3, final long j4, final String str) {
        if (debug) {
            Log.v(TAG, "notifySendStateForGRPC()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.90
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.notifySendStateForGRPC(i, chattingModel, s, j, s2, j2, j3, j4, str);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "notifySendStateForGRPC() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: ");
                }
            }
        });
    }

    public void onReceiveMsgFromGRPC(final ChattingModel chattingModel, final boolean z, final boolean z2) {
        if (debug) {
            Log.v(TAG, "onReceiveMsgFromGRPC()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.91
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.onReceiveMsgFromGRPC(chattingModel, z, z2);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "onReceiveMsgFromGRPC() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: ");
                }
            }
        });
    }

    public void pause() {
        if (debug) {
            Log.v(TAG, "pause()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "pause() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.connector != null) {
                    ChatManager.this.connector.pause();
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "pause() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void pauseLive(final short s, final long j) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.75
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.pauseLive(s, j);
                }
            }
        });
    }

    public void registerAudioRoomChatListener(final AudioRoomChatInfoListener audioRoomChatInfoListener) {
        if (debug) {
            Log.v(TAG, "registerAudioRoomChatListener(), audioChatInfoListener:" + audioRoomChatInfoListener.hashCode());
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.61
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "registerAudioRoomChatListener() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.audioRoomChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.audioRoomChat = new AudioRoomChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.audioRoomChat.registerAudioRoomChatListener(audioRoomChatInfoListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "registerLiveChatListener() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void registerDebugTipsListener(DebugTipsListener debugTipsListener) {
        this.debugTipsListener = debugTipsListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FlashVideo registerFlashVideoHelper(FlashVideoHelper flashVideoHelper) {
        FlashVideo flashVideo = this.flashVideo;
        if (flashVideo != null) {
            flashVideo.attach(flashVideoHelper);
        }
        return this.flashVideo;
    }

    public void registerIMStatusListener(final IMStatusListener iMStatusListener) {
        if (debug) {
            Log.v(TAG, "registerIMStatusListener(), listener:" + iMStatusListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.13
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.registerIMStatusListener(iMStatusListener);
            }
        });
    }

    public void registerLiveChatListener(final short s, final long j, final LiveChatInfoListener liveChatInfoListener) {
        if (debug) {
            Log.v(TAG, "registerLiveChatListener(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.63
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "registerLiveChatListener() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat == null) {
                    ChatManager chatManager = ChatManager.this;
                    chatManager.liveChat = new LiveChat(chatManager.connector, ChatManager.this.chat);
                }
                ChatManager.this.liveChat.registerLiveChatListener(s, j, liveChatInfoListener);
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "registerLiveChatListener() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void registerMsgContentListener(final short s, final long j, final MsgContentListener msgContentListener) {
        if (debug) {
            Log.v(TAG, "registerMsgContentListener(), sessionId:" + j + ", listener:" + msgContentListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.9
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.registerMsgContentListener(s, j, msgContentListener, false);
            }
        });
    }

    public void registerMsgContentListenerSecret(final short s, final long j, final MsgContentListener msgContentListener) {
        if (debug) {
            Log.v(TAG, "registerMsgContentListenerSecret(), sessionId:" + j + ", listener:" + msgContentListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.11
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.registerMsgContentListener(s, j, msgContentListener, true);
            }
        });
    }

    public void registerMsgReceiveListener(MsgReceiveListener msgReceiveListener) {
        if (debug) {
            Log.v(TAG, "registerMsgReceiveListener(), listener:" + msgReceiveListener);
        }
        this.msgReceiveListener = msgReceiveListener;
    }

    public void registerServiceMsgContentListener(final short s, final String str) {
        if (debug) {
            Log.v(TAG, "registerServiceMsgContentListener(), sessionId:" + str);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.10
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.registerServiceMsgContentListener(s, str);
            }
        });
    }

    public void registerSessionListener(final SessionListener sessionListener) {
        if (debug) {
            Log.v(TAG, "registerSessionListener(), listener:" + sessionListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.7
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.registerSessionListener(sessionListener);
            }
        });
    }

    public void registerSessionListener(final short s, final long j, final SingleSessionListener singleSessionListener) {
        if (debug) {
            Log.v(TAG, "registerSessionListener, sessionType:" + ((int) s) + ", sessionId:" + j + ", listener:" + singleSessionListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.5
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.registerSessionListener(s, j, singleSessionListener);
            }
        });
    }

    public void registerTipsListener(ChatTipsListener chatTipsListener) {
        if (debug) {
            Log.v(TAG, "registerTipsListener(), listener:" + chatTipsListener);
        }
        this.tipsListener = chatTipsListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoChat registerVideoChatHelper(VideoChatHelper videoChatHelper) {
        VideoChat videoChat = this.videoChat;
        if (videoChat != null) {
            videoChat.attach(videoChatHelper);
        }
        return this.videoChat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WawajiControllerChat registerWawajiControllerHelper(WawajiControllerHelper wawajiControllerHelper) {
        WawajiControllerChat wawajiControllerChat = this.wawajiControllerChat;
        if (wawajiControllerChat != null) {
            wawajiControllerChat.attach(wawajiControllerHelper);
        }
        return this.wawajiControllerChat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WawajiChat registerWawajiHelper(WawajiChatHelper wawajiChatHelper) {
        WawajiChat wawajiChat = this.wawajiChat;
        if (wawajiChat != null) {
            wawajiChat.attach(wawajiChatHelper);
        }
        return this.wawajiChat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WawajiChat registerWawajiResultReceiveHelper(WawajiResultReceiveHelper wawajiResultReceiveHelper) {
        WawajiChat wawajiChat = this.wawajiChat;
        if (wawajiChat != null) {
            wawajiChat.attachResultCallback(wawajiResultReceiveHelper);
        }
        return this.wawajiChat;
    }

    public void resendMsg(final ChattingModel chattingModel, final SessionProfileModel sessionProfileModel) {
        if (debug) {
            Log.v(TAG, "resendMsg(), msgData:" + chattingModel);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.21
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendMsg() running, msgData:" + chattingModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.sendMsg(chattingModel, sessionProfileModel, true, null);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "resendMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void resendMsg(final ChattingModel chattingModel, final SessionProfileModel sessionProfileModel, final MsgPreProcesser msgPreProcesser) {
        if (debug) {
            Log.v(TAG, "resendMsg(), msgData:" + chattingModel + ", msgPreProcess:" + msgPreProcesser);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.23
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendMsg() running, msgData:" + chattingModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.sendMsg(chattingModel, sessionProfileModel, true, msgPreProcesser);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "resendMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void resume() {
        if (debug) {
            Log.v(TAG, "resume()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "resume() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.connector != null) {
                    ChatManager.this.connector.resume();
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "resume() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void resumeLive(final short s, final long j) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.76
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.resumeLive(s, j);
                }
            }
        });
    }

    public void retractOneMessage(final short s, final long j, final long j2, final short s2, final RetractionListener retractionListener) {
        if (debug) {
            Log.v(TAG, "retractOneMessage(), sessionType:" + ((int) s) + ", sessionId:" + j + ", messageId:" + j2);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.43
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "retractOneMessage() running, sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.retractOneMessage(s, j, j2, s2, retractionListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "retractOneMessage() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void runChatSyncTask(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public void sendMsg(final ChattingModel chattingModel, final SessionProfileModel sessionProfileModel) {
        if (debug) {
            Log.v(TAG, "sendMsg(), msgData:" + chattingModel);
        }
        chattingModel.msgLocalId = 0L;
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.20
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendMsg() running, msgData:" + chattingModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.sendMsg(chattingModel, sessionProfileModel, false, null);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void sendMsg(final ChattingModel chattingModel, final SessionProfileModel sessionProfileModel, final MsgPreProcesser msgPreProcesser) {
        if (debug) {
            Log.v(TAG, "sendMsg(), msgData:" + chattingModel + ", msgPreProcess:" + msgPreProcesser);
        }
        chattingModel.msgLocalId = 0L;
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.22
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendMsg() running, msgData:" + chattingModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.sendMsg(chattingModel, sessionProfileModel, false, msgPreProcesser);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void sendReadReceipt(final short s, final long j, final long j2) {
        if (debug) {
            Log.v(TAG, "sendReadReceipt()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.95
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.sendReadReceipt(s, j, j2);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "sendReadReceipt() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public boolean sessionExist(String str) {
        Chat chat = this.chat;
        if (chat != null) {
            return chat.sessionList.containsKey(str);
        }
        return false;
    }

    public void setServerInfo(String str, int i, int i2, DnsManager dnsManager2, boolean z, boolean z2) {
        chatHostAddr = str;
        chatHostPort = i;
        chatBackupPort = i2;
        dnsManager = dnsManager2;
        isDnsManagerPrior = z;
        isSSL = z2;
        if (debug) {
            Log.v(TAG, "setServerInfo(), chatHostAddr:" + str + ", chatHostPort:" + i + ", chatBackupPort:" + i2 + ", isSSL:" + z2);
        }
    }

    public void setSessionSetting(final short s, final long j, final SessionSettingBaseModel sessionSettingBaseModel) {
        if (debug) {
            Log.v(TAG, "setSessionSetting(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.80
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "setSessionSetting() running sessionType:" + ((int) s) + ", sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.setSessionSetting(s, j, sessionSettingBaseModel);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "setSessionSetting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    @Deprecated
    public void shutdownNow() {
        this.executor.shutdownNow();
        instance = null;
    }

    public void start(final long j, final String str, final String str2) {
        if (debug) {
            Log.v(TAG, "start(), uid:" + j + ", encryUid:" + str + ", encryToken:" + str2 + ", chatHostAddr:" + chatHostAddr + ", chatHostPort:" + chatHostPort + ", chatBackupPort:" + chatBackupPort + ", isSSL:" + isSSL);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "start() running, uid:" + j + ", encryToken:" + str2);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.stopped) {
                    ChatManager.userInfo.uid = j;
                    ChatManager.userInfo.encryUid = str;
                    ChatManager.userInfo.encryToken = str2;
                    ChatManager.this.heart.start();
                    ChatManager.this.chat.start();
                    ChatManager.this.connector.start();
                    ChatManager.this.stopped = false;
                    if (Build.VERSION.SDK_INT >= 21) {
                        PingCheckerJobServer.startServer(ChatManager.context);
                    }
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "start() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void startJoinLive(final short s, final long j, final long j2) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.71
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.startJoinLive(s, j, j2);
                }
            }
        });
    }

    public void stop() {
        if (debug) {
            Log.v(TAG, "stop()");
        }
        this.stopped = true;
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "stop() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.connector != null) {
                    ChatManager.this.heart.stop();
                    ChatManager.this.chat.stop();
                    if (ChatManager.this.liveChat != null) {
                        ChatManager.this.liveChat.stop();
                    }
                    ChatManager.this.connector.stop();
                }
                ChatManager.this.stopped = true;
                if (Build.VERSION.SDK_INT >= 21) {
                    PingCheckerJobServer.stopServer(ChatManager.context);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "stop() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void stopTalkForeverInLiveChat(final short s, final long j, final long j2) {
        if (debug) {
            Log.v(TAG, "stopTalkForeverInLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j + ", uid:" + j2);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.70
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "stopTalkForeverInLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.stopTalkSomebodyForever(s, j, j2);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "stopTalkForeverInLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void stopTalkInLiveChat(final short s, final long j, final long j2, final boolean z) {
        if (debug) {
            Log.v(TAG, "stopTalkInLiveChat(), sessionType:" + ((int) s) + ", sessionId:" + j + ", uid:" + j2 + ", enable:" + z);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.69
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "stopTalkInLiveChat() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.stopTalkSomebody(s, j, j2, z);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "stopTalkInLiveChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void switchRoomChat(final long j) {
        if (debug) {
            Log.v(TAG, "switchRoomChat(), roomId:" + j);
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.86
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "switchRoomChat() start, roomId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.roomChat != null) {
                    ChatManager.this.roomChat.switchRoomId(j);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "switchRoomChat() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void syncMsg() {
        if (debug) {
            Log.v(TAG, "syncMsg()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.92
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.retrySyncMsg(false);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "syncMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " result: ");
                }
            }
        });
    }

    public void triggleSessionListNotify() {
        if (debug) {
            Log.v(TAG, "triggleSessionListNotify()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.15
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.triggleSessionListNotify();
            }
        });
    }

    public void unregisterAudioRoomChatListener(final AudioRoomChatInfoListener audioRoomChatInfoListener) {
        if (debug) {
            Log.v(TAG, "unregisterAudioRoomChatListener(), audioChatInfoListener:" + audioRoomChatInfoListener.hashCode());
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.62
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "unregisterAudioRoomChatListener() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.audioRoomChat != null) {
                    ChatManager.this.audioRoomChat.unregisterAudioRoomChatListener(audioRoomChatInfoListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "unregisterAudioRoomChatListener() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterFlashVideoHelper(FlashVideoHelper flashVideoHelper) {
        FlashVideo flashVideo = this.flashVideo;
        if (flashVideo != null) {
            flashVideo.detach(flashVideoHelper);
        }
    }

    public void unregisterIMStatusListener(final IMStatusListener iMStatusListener) {
        if (debug) {
            Log.v(TAG, "unregisterIMStatusListener(), listener:" + iMStatusListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.14
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.unregisterIMStatusListener(iMStatusListener);
            }
        });
    }

    public void unregisterLiveChatListener(final short s, final long j, final LiveChatInfoListener liveChatInfoListener) {
        if (debug) {
            Log.v(TAG, "unregisterLiveChatListener(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.64
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "unregisterLiveChatListener() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.unregisterLiveChatListener(s, j, liveChatInfoListener);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "unregisterLiveChatListener() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void unregisterMsgContentListener(final short s, final long j, final MsgContentListener msgContentListener) {
        if (debug) {
            Log.v(TAG, "unregisterMsgContentListener(), sessionId:" + j + ", listener:" + msgContentListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.12
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.unregisterMsgContentListener(s, j, msgContentListener);
            }
        });
    }

    public void unregisterMsgReceiveListener(MsgReceiveListener msgReceiveListener) {
        if (debug) {
            Log.v(TAG, "unregisterMsgReceiveListener(), listener:" + msgReceiveListener);
        }
        if (this.msgReceiveListener == msgReceiveListener) {
            this.msgReceiveListener = null;
        }
    }

    public void unregisterSessionListener(final SessionListener sessionListener) {
        if (debug) {
            Log.v(TAG, "unregisterSessionListener(), listener:" + sessionListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.8
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.unregisterSessionListener(sessionListener);
            }
        });
    }

    public void unregisterSessionListener(final short s, final long j, final SingleSessionListener singleSessionListener) {
        if (debug) {
            Log.v(TAG, "unregisterSessionListener, sessionType:" + ((int) s) + ", sessionId:" + j + ", listener:" + singleSessionListener);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.6
            @Override // java.lang.Runnable
            public void run() {
                ChatManager.this.chat.unregisterSessionListener(s, j, singleSessionListener);
            }
        });
    }

    public void unregisterTipsListener(ChatTipsListener chatTipsListener) {
        if (debug) {
            Log.v(TAG, "unregisterTipsListener(), ChatTipsListener:" + chatTipsListener);
        }
        if (this.tipsListener == chatTipsListener) {
            this.tipsListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterVideoChatHelper(VideoChatHelper videoChatHelper) {
        VideoChat videoChat = this.videoChat;
        if (videoChat != null) {
            videoChat.detach(videoChatHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterWawajiControllerHelper(WawajiControllerHelper wawajiControllerHelper) {
        WawajiControllerChat wawajiControllerChat = this.wawajiControllerChat;
        if (wawajiControllerChat != null) {
            wawajiControllerChat.detach(wawajiControllerHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterWawajiHelper(WawajiChatHelper wawajiChatHelper) {
        WawajiChat wawajiChat = this.wawajiChat;
        if (wawajiChat != null) {
            wawajiChat.detach(wawajiChatHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterWawajiResultReceiveHelper(WawajiResultReceiveHelper wawajiResultReceiveHelper) {
        WawajiChat wawajiChat = this.wawajiChat;
        if (wawajiChat != null) {
            wawajiChat.detachResultCallback(wawajiResultReceiveHelper);
        }
    }

    public void updateAllSessionSetting(final Map<String, Object> map) {
        if (debug) {
            Log.v(TAG, "updateAllSessionSetting()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.84
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateAllSessionSetting()==running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = -1;
                if (ChatManager.this.chat != null) {
                    i = ChatManager.this.chat.updateAllSessionSetting(map);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateAllSessionSetting() result:" + i);
                    Log.v(ChatManager.TAG, "updateAllSessionSetting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateLiveChatInfo(final short s, final long j) {
        if (debug) {
            Log.v(TAG, "updateLiveChatInfo(), sessionType:" + ((int) s) + ", sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.68
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateLiveChatInfo() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.liveChat != null) {
                    ChatManager.this.liveChat.updateLiveChatInfo(s, j);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateLiveChatInfo() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateMsgForTextTranslateInit(final int i, final long j) {
        if (debug) {
            Log.v(TAG, "updateMsgForTextTranslateInit(), sessionType:" + i + ",sessionId:" + j);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.56
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateMsgForTextTranslateInit() running sessionType:" + i + ",sessionId:" + j);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateMsgForTextTranslateInit(i, j);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateMsgForTextTranslateInit() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateMsgOneData(final ChattingModel chattingModel) {
        if (debug) {
            Log.v(TAG, "updateMsgState(), msgData:" + chattingModel);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.55
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateMsgState() running, msgData:" + chattingModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateMsgOneData(chattingModel);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateMsgState() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateMsgState(final ChattingModel chattingModel, final short s) {
        if (debug) {
            Log.v(TAG, "updateMsgState(), msgData:" + chattingModel + ", newState:" + ((int) s));
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.54
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateMsgState() running, msgData:" + chattingModel + ", newState:" + ((int) s));
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateMsgState(chattingModel, s);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateMsgState() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateRelationSessionSetting(final short s, final long j, final Map<String, Object> map) {
        if (debug) {
            Log.v(TAG, "updateRelationSessionSetting()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.82
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateRelationSessionSetting()===running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateRelationSessionSetting(s, j, map);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateRelationSessionSetting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateRelationSessionSettingListDb(final List<SessionSettingBaseModel> list) {
        if (debug) {
            Log.v(TAG, "updateRelationSessionSettingListDb()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.83
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateRelationSessionSettingListDb()===running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = -1;
                if (ChatManager.this.chat != null) {
                    i = ChatManager.this.chat.updateRelationSessionSettingListDb(list);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateRelationSessionSettingListDb() result:" + i);
                    Log.v(ChatManager.TAG, "updateRelationSessionSettingListDb() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionDraft(final short s, final long j, final String str) {
        if (debug) {
            Log.v(TAG, "updateSessionDraft(), sessionType:" + ((int) s) + ", sessionId:" + j + ", draft:" + str);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.48
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionDraft() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", draft:" + str);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionDraft(s, j, str);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionDraft() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionFriend(final short s, final long j, final int i) {
        if (debug) {
            Log.v(TAG, "updateSessionFriend(), sessionType:" + ((int) s) + ", sessionId:" + j + ", friend:" + i);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.53
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionFriend() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", friend:" + i);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionFriend(s, j, i);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionFriend() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionInfoData(final short s, final long j, final SessionProfileModel sessionProfileModel) {
        if (debug) {
            Log.v(TAG, "updateSessionInfoData(), sessionType:" + ((int) s) + ", sessionId:" + j + ", profileM:" + sessionProfileModel);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.47
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionInfoData() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", profileM:" + sessionProfileModel);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionInfoData(s, j, sessionProfileModel);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionInfoData() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionLieTop(final short s, final long j, final int i) {
        if (debug) {
            Log.v(TAG, "updateSessionLieTop(), sessionType:" + ((int) s) + ", sessionId:" + j + ", lieTop:" + i);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.49
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionLieTop() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", lieTop:" + i);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionLieTop(s, j, i);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionLieTop() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionNoReadNum(final short s, final long j, final int i) {
        if (debug) {
            Log.v(TAG, "updateSessionNoReadNum(), sessionType:" + ((int) s) + ", sessionId:" + j + ", noReadCount:" + i);
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.87
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionNoReadNum() start, sessionType:" + ((int) s) + ", sessionId:" + j + ", noReadCount:" + i);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionNoReadCount(s, j, i);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionNoReadNum() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionOnLineState(final List<Pair<Long, Integer>> list) {
        if (debug) {
            Log.v(TAG, "updataSessionPLine()");
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.77
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updataSessionPLine() running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionOnLineState(list);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updataSessionPLine() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionSetting(final short s, final long j, final Map<String, Object> map) {
        if (debug) {
            Log.v(TAG, "updateSessionSetting()");
        }
        if (this.stopped) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.81
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionSetting()==running");
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = -1;
                if (ChatManager.this.chat != null) {
                    i = ChatManager.this.chat.updateSessionSetting(s, j, map);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionSetting() result:" + i);
                    Log.v(ChatManager.TAG, "updateSessionSetting() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionTopGift(final short s, final long j, final long j2, final float f) {
        if (debug) {
            Log.v(TAG, "updateSessionTopGift(), sessionType:" + ((int) s) + ", sessionId:" + j + ", expireTime:" + j2);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.51
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionTopGift() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", expireTime:" + j2);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionTopGift(s, j, j2, f);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionTopGift() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSessionUnreadGiftCnt(final short s, final long j, final int i, final long j2) {
        if (debug) {
            Log.v(TAG, "updateSessionUnreadGiftCnt(), sessionType:" + ((int) s) + ", sessionId:" + j + ", unreadCnt:" + i);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.50
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionUnreadGiftCnt() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", unreadCnt:" + i);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionUnreadGiftCnt(s, j, i, j2);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSessionUnreadGiftCnt() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateSesssionStatus(final short s, final long j, final int i) {
        if (debug) {
            Log.v(TAG, "updateSesssionStatus(), sessionType:" + ((int) s) + ", sessionId:" + j + ", sessionStatus:" + i);
        }
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.ChatManager.52
            @Override // java.lang.Runnable
            public void run() {
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSesssionStatus() running, sessionType:" + ((int) s) + ", sessionId:" + j + ", sessionStatus:" + i);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (ChatManager.this.chat != null) {
                    ChatManager.this.chat.updateSessionStatus(s, j, i);
                }
                if (ChatManager.debug) {
                    Log.v(ChatManager.TAG, "updateSesssionStatus() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
                }
            }
        });
    }

    public void updateUserToken(String str) {
        if (debug) {
            Log.v(TAG, "updateUserToken(), encryToken:" + str);
        }
        userInfo.encryToken = str;
    }
}
