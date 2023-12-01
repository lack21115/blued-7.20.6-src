package com.blued.android.module.yy_china.test;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.ClientType;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.info.ChatAppInfo;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.info.ChatUserInfo;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.manager.YYIMManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.google.protobuf.Any;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/IMManager.class */
public class IMManager implements ConnectListener, ReceiveMsgListener {
    private static final String b = IMManager.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f17804a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17805c;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/IMManager$SingletonCreator.class */
    static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        public static final IMManager f17806a = new IMManager();

        private SingletonCreator() {
        }
    }

    private IMManager() {
        this.f17804a = "disconnected";
    }

    public static IMManager a() {
        return SingletonCreator.f17806a;
    }

    private void d() {
        this.f17805c = true;
        Logger.c(b, "initIM ======");
        ChatAppInfo chatAppInfo = new ChatAppInfo();
        chatAppInfo.platform = "android_china";
        chatAppInfo.appVersionName = AppInfo.g;
        chatAppInfo.appVersionCode = AppInfo.h;
        chatAppInfo.channel = AppInfo.f9487c;
        chatAppInfo.clientType = ClientType.CHINA;
        chatAppInfo.language = LocaleUtils.b();
        chatAppInfo.context = AppInfo.d();
        ChatConnectInfo chatConnectInfo = new ChatConnectInfo();
        chatConnectInfo.dnsManager = HappyDnsUtils.d();
        chatConnectInfo.host = Host.a("GRPC_CHAT");
        String str = b;
        Logger.c(str, "host ====== " + chatConnectInfo.host);
        PrivateChatManager.getInstance().init(chatAppInfo, chatConnectInfo, null, false);
    }

    String a(String str) {
        try {
            return !StringUtils.b(str) ? AesCrypto.c(str) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void b() {
        if (!this.f17805c) {
            d();
        }
        ChatUserInfo chatUserInfo = new ChatUserInfo();
        chatUserInfo.token = a(UserInfo.getInstance().getAccessToken());
        String str = b;
        Logger.c(str, "startIM ====token==" + chatUserInfo.token);
        chatUserInfo.uid = UserInfo.getInstance().getLoginUserInfo().uid;
        PrivateChatManager.getInstance().registerConnectListener(this);
        PrivateChatManager.getInstance().registerExternalMsgListener(this);
        PrivateChatManager.getInstance().start(chatUserInfo);
    }

    public void c() {
        this.f17805c = false;
        PrivateChatManager.getInstance().stop();
        PrivateChatManager.getInstance().unregisterConnectListener(this);
        PrivateChatManager.getInstance().unregisterExternalMsgListener(this);
    }

    @Override // com.blued.android.chat.grpc.listener.ConnectListener
    public void onConnected() {
        if (YYRoomInfoManager.e().b() != null) {
            YYIMManager.a().onConnected();
        }
        Logger.c(b, "grpc-链接成功，sync_msg");
        ChatManager.getInstance().syncMsg();
        this.f17804a = "connected";
    }

    @Override // com.blued.android.chat.grpc.listener.ConnectListener
    public void onConnecting() {
        this.f17804a = "connecting";
    }

    @Override // com.blued.android.chat.grpc.listener.ConnectListener
    public void onDisconnected(int i, String str) {
        this.f17804a = "Disconnected";
        if (YYRoomInfoManager.e().b() != null) {
            YYIMManager.a().onDisconnected();
        }
    }

    @Override // com.blued.android.chat.grpc.listener.ReceiveMsgListener
    public void onReceiveMsg(Any any) {
        if (any != null) {
            try {
                if (any.is(AudioChatroomOuterClass.Receive.class)) {
                    Logger.e("onMessage", "IMManager AudioChatroomOuterClass Receive ...");
                    YYIMManager.a().onReceive(any);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
