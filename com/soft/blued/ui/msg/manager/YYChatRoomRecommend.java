package com.soft.blued.ui.msg.manager;

import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.msg.manager.YYChatRoomRecommend;
import com.soft.blued.ui.msg.model.ChatroomRecommendModel;
import com.soft.blued.ui.msg.model.ChatroomRecommendUserModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/YYChatRoomRecommend.class */
public final class YYChatRoomRecommend {
    private static OnFinishListener b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f18764c;
    private static long e;

    /* renamed from: a  reason: collision with root package name */
    public static final YYChatRoomRecommend f18763a = new YYChatRoomRecommend();
    private static AppConfigModel.AiRecommendImChatRoom d = new AppConfigModel.AiRecommendImChatRoom();
    private static List<String> f = new ArrayList();
    private static int g = 1;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/YYChatRoomRecommend$OnFinishListener.class */
    public interface OnFinishListener {
        void onFinish(SessionModel sessionModel);
    }

    private YYChatRoomRecommend() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionModel a(ChatroomRecommendModel chatroomRecommendModel) {
        try {
            SessionModel sessionModel = new SessionModel();
            sessionModel.sessionType = (short) 6668;
            sessionModel.sessionId = 3L;
            sessionModel.lastMsgTime = k();
            sessionModel.lastMsgFromId = chatroomRecommendModel.getUid();
            sessionModel.lastMsgFromAvatar = chatroomRecommendModel.getAvatar();
            sessionModel.lastMsgFromNickname = chatroomRecommendModel.getRoom_name();
            sessionModel.lastMsgContent = chatroomRecommendModel.getText_content();
            sessionModel.lastMsgExtra = Intrinsics.a("", Long.valueOf(chatroomRecommendModel.getRoom_id()));
            SessionSettingBaseModel sessionSettingModel = new SessionSettingModel();
            sessionSettingModel.setRemindAudio(0);
            sessionModel.sessionSettingModel = sessionSettingModel;
            return sessionModel;
        } catch (Exception e2) {
            return null;
        }
    }

    private final void a(final IRequestHost iRequestHost) {
        ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ChatroomRecommendModel>>(iRequestHost) { // from class: com.soft.blued.ui.msg.manager.YYChatRoomRecommend$updateFromNetwork$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ IRequestHost f18765a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(iRequestHost);
                this.f18765a = iRequestHost;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0129 -> B:22:0x007a). Please submit an issue!!! */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ChatroomRecommendModel> bluedEntityA) {
                YYChatRoomRecommend.OnFinishListener onFinishListener;
                ChatroomRecommendModel chatroomRecommendModel;
                YYChatRoomRecommend.OnFinishListener onFinishListener2;
                SessionModel a2;
                if (bluedEntityA != null) {
                    List list = bluedEntityA.data;
                    Intrinsics.c(list, "data");
                    if ((!list.isEmpty()) && (chatroomRecommendModel = (ChatroomRecommendModel) bluedEntityA.data.get(0)) != null && chatroomRecommendModel.getRoom_id() != 0) {
                        String text_content = chatroomRecommendModel.getText_content();
                        if (!(text_content == null || text_content.length() == 0)) {
                            try {
                                String json = AppInfo.f().toJson(chatroomRecommendModel);
                                YYChatRoomRecommend yYChatRoomRecommend = YYChatRoomRecommend.f18763a;
                                Intrinsics.c(json, "content");
                                yYChatRoomRecommend.a(json);
                            } catch (Exception e2) {
                            }
                            YYChatRoomRecommend yYChatRoomRecommend2 = YYChatRoomRecommend.f18763a;
                            YYChatRoomRecommend.f18764c = true;
                            YYChatRoomRecommend.f18763a.b(true);
                            YYChatRoomRecommend yYChatRoomRecommend3 = YYChatRoomRecommend.f18763a;
                            YYChatRoomRecommend.g = chatroomRecommendModel.getExperiment();
                            YYChatRoomRecommend yYChatRoomRecommend4 = YYChatRoomRecommend.f18763a;
                            YYChatRoomRecommend.e = chatroomRecommendModel.getRoom_id();
                            for (ChatroomRecommendUserModel chatroomRecommendUserModel : chatroomRecommendModel.getCurrent_users()) {
                                String avatar = chatroomRecommendUserModel.getAvatar();
                                if (!(avatar == null || avatar.length() == 0)) {
                                    YYChatRoomRecommend.f18763a.a().add(0, chatroomRecommendUserModel.getAvatar());
                                }
                            }
                            onFinishListener2 = YYChatRoomRecommend.b;
                            if (onFinishListener2 == null) {
                                return;
                            }
                            a2 = YYChatRoomRecommend.f18763a.a(chatroomRecommendModel);
                            onFinishListener2.onFinish(a2);
                            return;
                        }
                    }
                }
                YYChatRoomRecommend.f18763a.c();
                onFinishListener = YYChatRoomRecommend.b;
                if (onFinishListener == null) {
                    return;
                }
                onFinishListener.onFinish(null);
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }
        }, iRequestHost, e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        BluedPreferences.a().c().a(o(), str).b();
    }

    private final void b(long j) {
        BluedPreferences.a().c().a(n(), j).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        BluedPreferences.a().c().a(m(), z).b();
    }

    private final SessionModel g() {
        ChatroomRecommendModel h = h();
        if (h == null) {
            return null;
        }
        return f18763a.a(h);
    }

    private final ChatroomRecommendModel h() {
        Object obj;
        String j;
        try {
            j = j();
        } catch (Exception e2) {
        }
        if (j != null) {
            obj = AppInfo.f().fromJson(j, (Class<Object>) ChatroomRecommendModel.class);
            return (ChatroomRecommendModel) obj;
        }
        obj = null;
        return (ChatroomRecommendModel) obj;
    }

    private final AppConfigModel.AiRecommendImChatRoom i() {
        AppConfigModel b2 = BluedConfig.a().b();
        AppConfigModel.AiRecommendImChatRoom aiRecommendImChatRoom = b2 == null ? null : b2.ai_recommend_im_chat_room;
        if (aiRecommendImChatRoom != null) {
            d = aiRecommendImChatRoom;
        }
        if (d.update_time <= 0) {
            d.update_time = 1800;
        }
        return d;
    }

    private final String j() {
        return BluedPreferences.a().a(o(), "");
    }

    private final long k() {
        return BluedPreferences.a().a(n(), 0L);
    }

    private final boolean l() {
        return BluedPreferences.a().a(m(), false);
    }

    private final String m() {
        return Intrinsics.a("yy_chatroom_recommend_red_dot_click_", p());
    }

    private final String n() {
        return Intrinsics.a("yy_chatroom_recommend_last_update_ms_", p());
    }

    private final String o() {
        return Intrinsics.a("yy_chatroom_recommend_content_", p());
    }

    private final String p() {
        return UserInfo.getInstance().getLoginUserInfo().uid;
    }

    public final SessionModel a(OnFinishListener onFinishListener, IRequestHost iRequestHost) {
        b = onFinishListener;
        try {
            f18764c = l();
            int i = i().update_time;
            long k = k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > k + (i * 1000)) {
                b(currentTimeMillis);
                a(iRequestHost);
                return null;
            }
            return g();
        } catch (Exception e2) {
            return null;
        }
    }

    public final List<String> a() {
        return f;
    }

    public final boolean a(SessionModel sessionModel) {
        Intrinsics.e(sessionModel, d.aw);
        return sessionModel.sessionType == 6668 && sessionModel.sessionId == 3;
    }

    public final int b() {
        return g;
    }

    public final void c() {
        a("");
        e();
    }

    public final boolean d() {
        return f18764c;
    }

    public final void e() {
        if (f18764c) {
            f18764c = false;
            b(false);
        }
    }
}
