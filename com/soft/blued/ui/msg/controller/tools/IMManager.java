package com.soft.blued.ui.msg.controller.tools;

import com.blued.android.chat.ChatDBImpl;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.ClientType;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.info.ChatAppInfo;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.info.ChatUserInfo;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.im.IM;
import com.blued.android.module.yy_china.manager.YYIMManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.protobuf.Any;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/IMManager.class */
public class IMManager implements ConnectListener, ReceiveMsgListener {
    private static final String b = IMManager.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f18547a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18548c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/IMManager$SingletonCreator.class */
    public static class SingletonCreator {

        /* renamed from: a  reason: collision with root package name */
        public static final IMManager f18549a = new IMManager();

        private SingletonCreator() {
        }
    }

    private IMManager() {
        this.f18547a = NetworkUtil.NETWORK_CLASS_DISCONNECTED;
    }

    public static IMManager a() {
        return SingletonCreator.f18549a;
    }

    private void h() {
        this.f18548c = true;
        Logger.c(b, "initIM ======");
        ChatAppInfo chatAppInfo = new ChatAppInfo();
        chatAppInfo.platform = "android_china";
        chatAppInfo.appVersionName = AppInfo.g;
        chatAppInfo.appVersionCode = AppInfo.h;
        chatAppInfo.channel = AppInfo.c;
        chatAppInfo.clientType = ClientType.CHINA;
        chatAppInfo.language = LocaleUtils.b();
        chatAppInfo.context = AppInfo.d();
        ChatConnectInfo chatConnectInfo = new ChatConnectInfo();
        chatConnectInfo.dnsManager = HappyDnsUtils.d();
        chatConnectInfo.host = Host.a("GRPC_CHAT");
        String str = b;
        Logger.c(str, "host ====== " + chatConnectInfo.host);
        PrivateChatManager.getInstance().init(chatAppInfo, chatConnectInfo, new ChatDBImpl(), false);
    }

    public void a(ChattingModel chattingModel) {
        PrivateChatManager.getInstance().sendMsg(chattingModel);
    }

    public void b() {
        IM.c().d(LocaleUtils.b());
    }

    public boolean b(ChattingModel chattingModel) {
        short s = chattingModel.msgType;
        if (s == 32 || s == 210 || s == 256 || chattingModel.sessionType == 3) {
            return true;
        }
        return FlexDebugSevConfig.a().d();
    }

    public void c() {
        IM.c().a(AppInfo.c);
    }

    public void d() {
        if (!this.f18548c) {
            h();
        }
        ChatUserInfo chatUserInfo = new ChatUserInfo();
        chatUserInfo.token = LoginRegisterTools.f(UserInfo.getInstance().getAccessToken());
        String str = b;
        Logger.c(str, "startIM ====token==" + chatUserInfo.token);
        chatUserInfo.uid = UserInfo.getInstance().getLoginUserInfo().uid;
        PrivateChatManager.getInstance().registerConnectListener(this);
        PrivateChatManager.getInstance().registerExternalMsgListener(this);
        PrivateChatManager.getInstance().start(chatUserInfo);
    }

    public void e() {
        this.f18548c = false;
        PrivateChatManager.getInstance().stop();
        PrivateChatManager.getInstance().unregisterConnectListener(this);
        PrivateChatManager.getInstance().unregisterExternalMsgListener(this);
    }

    public void f() {
        PrivateChatManager.getInstance().resume();
    }

    public void g() {
        PrivateChatManager.getInstance().pause();
    }

    public void onConnected() {
        if (YYRoomInfoManager.e().b() != null) {
            YYIMManager.a().onConnected();
        }
        Logger.c(b, "grpc-链接成功，sync_msg");
        ChatManager.getInstance().syncMsg();
        this.f18547a = "connected";
    }

    public void onConnecting() {
        this.f18547a = "connecting";
    }

    public void onDisconnected(int i, String str) {
        this.f18547a = "Disconnected";
        if (YYRoomInfoManager.e().b() != null) {
            YYIMManager.a().onDisconnected();
        }
    }

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
