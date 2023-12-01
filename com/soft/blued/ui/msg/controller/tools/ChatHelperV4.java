package com.soft.blued.ui.msg.controller.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.listener.MsgPreProcesserListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.chat.utils.AtRegExpUtils;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.push.NotificationModel;
import com.blued.android.framework.push.NotificationSender;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.module.common.db.model.MsgExtra;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.share.Util;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.model.CircleAddPoints;
import com.blued.das.message.MessageProtos;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.fragment.PendingFragment;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.model.UrlPicResult;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.ExtraGroupInvitationModel;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.view.VideoChatHintToast;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.MsgFragment;
import com.soft.blued.ui.msg.ShareToFragment;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgAudioExtra;
import com.soft.blued.ui.msg.model.MsgChattingImageModel;
import com.soft.blued.ui.msg.model.MsgChattingVideoModel;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg.model.SysCommandModel;
import com.soft.blued.ui.msg_group.model.GroupNotificationExtra;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.notify.fragment.MsgAttentionNotifyFragment;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/ChatHelperV4.class */
public class ChatHelperV4 {
    private static ChatHelperV4 d;
    private String f;
    private volatile boolean i;

    /* renamed from: a  reason: collision with root package name */
    private static final String f32198a = ChatHelperV4.class.getSimpleName();
    private static LinkedBlockingQueue<Pair<ChattingModel, MsgPreProcesserListener>> g = new LinkedBlockingQueue<>();
    private static AtomicLong j = new AtomicLong(0);
    private Gson b = AppInfo.f();
    private boolean e = false;
    private int h = 0;

    /* renamed from: c  reason: collision with root package name */
    private NotificationSender f32199c = NotificationSender.a();

    /* renamed from: com.soft.blued.ui.msg.controller.tools.ChatHelperV4$20  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/ChatHelperV4$20.class */
    class AnonymousClass20 implements MsgPreProcesser {
        @Override // com.blued.android.chat.listener.MsgPreProcesser
        public void preProcess(ChattingModel chattingModel, MsgPreProcesserListener msgPreProcesserListener) {
            chattingModel.msgStateCode = (short) 2;
            msgPreProcesserListener.onProcessToSave(chattingModel);
        }
    }

    private ChatHelperV4() {
    }

    private LiveMsgShareEntity a(String str) {
        Logger.b(f32198a, "直播通知 notification：extraJson==", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (LiveMsgShareEntity) AppInfo.f().fromJson(str, (Class<Object>) LiveMsgShareEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ChatHelperV4 a() {
        if (d == null) {
            synchronized (ChatHelperV4.class) {
                try {
                    if (d == null) {
                        d = new ChatHelperV4();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChattingModel chattingModel, Pair<String, UploadModel> pair, MsgPreProcesserListener msgPreProcesserListener, boolean z) {
        int a2;
        if (pair == null) {
            a(chattingModel, msgPreProcesserListener);
            return;
        }
        String str = pair.first;
        UploadModel uploadModel = pair.second;
        String str2 = f32198a;
        Logger.e(str2, "uploadQiNiu===url:" + uploadModel.url + ",compressPath:" + uploadModel.compressPath);
        Log.v("drb", "uploadQiNiu===url:" + uploadModel.url + ",compressPath:" + uploadModel.compressPath);
        try {
            if (TextUtils.isEmpty(uploadModel.url)) {
                a(chattingModel, msgPreProcesserListener);
                i();
                return;
            }
            if (chattingModel.msgType == 2) {
                chattingModel.msgContent = uploadModel.url;
                if (z) {
                    LoadOptions loadOptions = new LoadOptions();
                    loadOptions.e = true;
                    loadOptions.j = true;
                    Drawable a3 = RecyclingImageLoader.a(RecyclingUtils.a(RecyclingUtils.Scheme.FILE.b(uploadModel.compressPath), loadOptions));
                    if (a3 == null || !(a3 instanceof IRecyclingDrawable)) {
                        Logger.e(f32198a, "RecyclingUtils.getMemoryCache fail");
                    } else {
                        RecyclingImageLoader.a(RecyclingUtils.a(uploadModel.url, loadOptions), (IRecyclingDrawable) a3);
                    }
                    RecyclingUtils.a(new File(uploadModel.compressPath), uploadModel.url);
                }
            } else if (chattingModel.msgType == 24) {
                chattingModel.msgContent = uploadModel.url;
                if (z) {
                    String str3 = "";
                    try {
                        String e = AesCrypto.e(uploadModel.url);
                        String str4 = f32198a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("解密服务器返回的地址===");
                        sb.append(e);
                        str3 = e;
                        Logger.e(str4, sb.toString());
                        str3 = e;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    RecyclingUtils.a(new File(uploadModel.compressPath), str3);
                }
            } else if (chattingModel.msgType == 3) {
                String[] split = chattingModel.msgContent.split(",,");
                if (split.length < 2 || (a2 = StringUtils.a(split[1], 0)) == 0) {
                    return;
                }
                chattingModel.msgContent = uploadModel.url + ",," + a2;
                MsgCommonUtils.a(chattingModel, uploadModel.url, uploadModel.compressPath);
            }
            b(chattingModel, msgPreProcesserListener);
        } catch (Exception e3) {
            e3.printStackTrace();
            a(chattingModel, msgPreProcesserListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ChattingModel chattingModel, final MsgPreProcesserListener msgPreProcesserListener, final String str) {
        if (str.startsWith("http")) {
            b(chattingModel, msgPreProcesserListener);
            return;
        }
        List<Pair<String, String>> a2 = QiniuUploadUtils.a(str, "");
        short s = chattingModel.msgType;
        if (s != 2) {
            if (s == 3) {
                MediaSender.a(ChatHttpUtils.a(chattingModel), a2, new SenderListener() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.10
                    @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                    public void a(String str2, int i) {
                    }

                    @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                    public void a(String str2, final Pair<String, UploadModel> pair) {
                        ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChatHelperV4.this.a(chattingModel, (Pair<String, UploadModel>) pair, msgPreProcesserListener, false);
                            }
                        });
                    }

                    @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                    public void a(String str2, boolean z, List<Pair<String, String>> list) {
                    }
                });
                return;
            }
            if (s != 5) {
                if (s != 24) {
                    if (s != 25) {
                        return;
                    }
                }
            }
            MediaSender.a(ChatHttpUtils.a(chattingModel), new Pair(str, ""), new SenderListener() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.9
                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str2, int i) {
                }

                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str2, final Pair<String, UploadModel> pair) {
                    ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.9.1
                        /* JADX WARN: Removed duplicated region for block: B:50:0x0189 A[Catch: Exception -> 0x030a, TryCatch #1 {Exception -> 0x030a, blocks: (B:13:0x0086, B:60:0x021f, B:48:0x016c, B:50:0x0189, B:52:0x01a1, B:46:0x0162, B:53:0x01c9, B:55:0x01e5, B:57:0x01eb, B:59:0x0218), top: B:70:0x0086 }] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void run() {
                            /*
                                Method dump skipped, instructions count: 844
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.AnonymousClass9.AnonymousClass1.run():void");
                        }
                    });
                }

                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str2, boolean z, List<Pair<String, String>> list) {
                }
            });
            return;
        }
        final boolean z = !a(new File(str));
        MediaSender.a(ChatHttpUtils.a(chattingModel), a2, z, new SenderListener() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.8
            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str2, int i) {
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str2, final Pair<String, UploadModel> pair) {
                ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatHelperV4.this.a(chattingModel, pair, msgPreProcesserListener, z);
                    }
                });
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str2, boolean z2, List<Pair<String, String>> list) {
            }
        });
    }

    public static void a(List<SessionModel> list, boolean z) {
        if (list == null) {
            return;
        }
        Iterator<SessionModel> it = list.iterator();
        while (it.hasNext()) {
            if (!a(it.next())) {
                it.remove();
            }
        }
        if (z) {
            d(list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r3.sessionType != 6668) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.blued.android.chat.model.SessionModel r3) {
        /*
            r0 = 1
            r5 = r0
            r0 = r3
            if (r0 == 0) goto L31
            r0 = r3
            short r0 = r0.sessionType
            r1 = 1
            if (r0 != r1) goto L11
            goto L31
        L11:
            r0 = r5
            r4 = r0
            r0 = r3
            short r0 = r0.sessionType
            r1 = 2
            if (r0 == r1) goto L33
            r0 = r5
            r4 = r0
            r0 = r3
            short r0 = r0.sessionType
            r1 = 3
            if (r0 == r1) goto L33
            r0 = r5
            r4 = r0
            r0 = r3
            short r0 = r0.sessionType
            r1 = 6668(0x1a0c, float:9.344E-42)
            if (r0 == r1) goto L33
        L31:
            r0 = 0
            r4 = r0
        L33:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.a(com.blued.android.chat.model.SessionModel):boolean");
    }

    public static boolean a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.skip(fileInputStream.available() - 1);
            int[] iArr = {fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read()};
            fileInputStream.close();
            boolean z = false;
            if (iArr[0] == 71) {
                z = false;
                if (iArr[1] == 73) {
                    z = false;
                    if (iArr[2] == 70) {
                        z = false;
                        if (iArr[3] == 56) {
                            z = false;
                            if (iArr[4] == 59) {
                                z = true;
                            }
                        }
                    }
                }
            }
            return z;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private void b(Context context, ChattingModel chattingModel) {
        SessionModel snapSessionModel;
        if (chattingModel == null || CommonTools.a(context) || !j()) {
            return;
        }
        NotificationModel notificationModel = new NotificationModel();
        if (!BluedPreferences.ag()) {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_new_havemsg_long));
        } else if (1 == chattingModel.msgType || 8 == chattingModel.msgType || 250 == chattingModel.msgType) {
            if (com.soft.blued.utils.StringUtils.d(chattingModel.msgContent)) {
                notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_new_havemsg_long));
            } else {
                notificationModel.setContentText(com.soft.blued.utils.StringUtils.a(chattingModel.msgContent, false, true, true, ""));
            }
        } else if (4 == chattingModel.msgType) {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_msg_location));
        } else if (2 == chattingModel.msgType || 24 == chattingModel.msgType || 251 == chattingModel.msgType) {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_msg_img));
        } else if (5 == chattingModel.msgType || 25 == chattingModel.msgType) {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_msg_video));
        } else if (3 == chattingModel.msgType) {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_msg_record));
        } else if (32 == chattingModel.msgType) {
            notificationModel.setContentText(context.getResources().getString(2131889187));
        } else if (6 == chattingModel.msgType || 205 == chattingModel.msgType) {
            notificationModel.setContentText(context.getString(R.string.msg_hello_expression_tips));
        } else if (220 == chattingModel.msgType) {
            notificationModel.setContentText(context.getString(R.string.group_announcement_updated) + context.getString(R.string.group_announcement));
        } else {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_new_havemsg_long));
        }
        if (chattingModel.sessionType == 1 && chattingModel.sessionId == 2) {
            if (ChatManager.getInstance().getSnapSessionModel((short) 3, chattingModel.fromId) != null) {
                notificationModel.setContentTitle(context.getString(R.string.group_notification_title) + snapSessionModel.nickName);
            } else {
                notificationModel.setContentTitle(context.getString(R.string.group_notification_title) + "");
            }
        } else {
            SessionModel snapSessionModel2 = ChatManager.getInstance().getSnapSessionModel(chattingModel.sessionType, chattingModel.sessionId);
            if (snapSessionModel2 == null || snapSessionModel2.sessionType != 3) {
                String str = chattingModel.fromNickName;
                if (chattingModel.isMatchMsg == 1) {
                    str = DateTodayManager.f32404a.c(chattingModel.fromNickName);
                }
                notificationModel.setContentTitle(str);
            } else {
                notificationModel.setContentTitle(snapSessionModel2.nickName);
                notificationModel.setContentText(chattingModel.fromNickName + ": " + notificationModel.getContentText().toString());
            }
        }
        notificationModel.setId(h());
        notificationModel.setTickerText(context.getResources().getString(R.string.biao_notify_new_havemsg));
        notificationModel.setIconResId(R.drawable.blued_icon_0);
        notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.blued_icon_0));
        notificationModel.setSoundFileUri(Uri.parse("android.resource://" + AppInfo.d().getPackageName() + BridgeUtil.SPLIT_MARK + R.raw.ringtone_get));
        notificationModel.setShakeEnable(BluedPreferences.af());
        notificationModel.setVoiceEnable(BluedPreferences.ae());
        notificationModel.setInnerVoiceEnable(BluedPreferences.ac());
        UserRelationshipUtils.a(Short.valueOf(chattingModel.sessionType), chattingModel.sessionId);
        Bundle bundle = null;
        if (chattingModel.sessionType == 1) {
            bundle = null;
            if (chattingModel.sessionId == 2) {
                bundle = new Bundle();
                bundle.putString("arg_open_homeactivity_ope", "ope_group_notification");
            }
        }
        notificationModel.setIntent(HomeArgumentHelper.b(context, "msg", bundle));
        this.f32199c.a(notificationModel);
    }

    public static void b(List<SessionModel> list) {
        if (list == null) {
            return;
        }
        Iterator<SessionModel> it = list.iterator();
        while (it.hasNext()) {
            SessionModel next = it.next();
            if (next.sessionType != 2 && next.sessionType != 3) {
                it.remove();
            }
            SubscribeNumberManager subscribeNumberManager = SubscribeNumberManager.f32449a;
            if (subscribeNumberManager.a(next.sessionId + "", Short.valueOf(next.sessionType))) {
                it.remove();
            }
        }
        d(list);
    }

    private void c(Context context, ChattingModel chattingModel) {
        LiveMsgShareEntity a2;
        Bundle b;
        if (chattingModel == null || CommonTools.a(context) || !j() || (a2 = a(chattingModel.getMsgExtra())) == null || (b = b(a2)) == null) {
            return;
        }
        Intent b2 = HomeArgumentHelper.b(context, "live", b);
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setId(h());
        notificationModel.setContentText(a2.name + " " + context.getResources().getString(2131889145));
        notificationModel.setContentTitle(context.getResources().getString(2131886479));
        notificationModel.setTickerText(context.getResources().getString(R.string.biao_notify_new_havemsg));
        if (Build.VERSION.SDK_INT < 21) {
            notificationModel.setIconResId(R.drawable.blued_icon_0);
        } else {
            notificationModel.setIconResId(R.drawable.icon_launcher_alpha);
        }
        notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.blued_icon_0));
        notificationModel.setSoundFileUri(Uri.parse("android.resource://" + AppInfo.d().getPackageName() + BridgeUtil.SPLIT_MARK + R.raw.ringtone_get));
        notificationModel.setShakeEnable(BluedPreferences.af());
        notificationModel.setVoiceEnable(BluedPreferences.ae());
        notificationModel.setInnerVoiceEnable(BluedPreferences.ac());
        notificationModel.setIntent(b2);
        this.f32199c.a(notificationModel);
    }

    public static void c(List<SessionModel> list) {
        if (list == null) {
            return;
        }
        Iterator<SessionModel> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().sessionType != 2) {
                it.remove();
            }
        }
        d(list);
    }

    public static List<SessionModel> d(List<SessionModel> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new SessionModelComparator());
        }
        return list;
    }

    private void d(Context context, ChattingModel chattingModel) {
        VideoChatMsgContentModel videoChatMsgContentModel;
        String str;
        try {
            videoChatMsgContentModel = (VideoChatMsgContentModel) AppInfo.f().fromJson(chattingModel.msgContent, new TypeToken<VideoChatMsgContentModel>() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.22
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            videoChatMsgContentModel = null;
        }
        if (videoChatMsgContentModel == null) {
            return;
        }
        NotificationModel notificationModel = new NotificationModel();
        String str2 = chattingModel.fromNickName;
        if (52 == chattingModel.msgType) {
            str = (videoChatMsgContentModel != null ? videoChatMsgContentModel.room_type : 0) == 1 ? context.getResources().getString(R.string.calling_audio_notification) : context.getResources().getString(R.string.calling_video_notification);
        } else {
            str = "";
        }
        String str3 = str2 + " " + str;
        notificationModel.setRemindEnable(!this.e);
        notificationModel.setContentTitle(str2);
        notificationModel.setContentText(str);
        notificationModel.setTickerText(str3);
        notificationModel.setId(100);
        if (Build.VERSION.SDK_INT < 21) {
            notificationModel.setIconResId(R.drawable.blued_icon_0);
        } else {
            notificationModel.setIconResId(R.drawable.icon_launcher_alpha);
        }
        notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.blued_icon_0));
        notificationModel.setSoundFileUri(Uri.parse("android.resource://" + AppInfo.d().getPackageName() + BridgeUtil.SPLIT_MARK + R.raw.ringtone_get));
        notificationModel.setShakeEnable(BluedPreferences.af());
        notificationModel.setVoiceEnable(BluedPreferences.ae());
        notificationModel.setInnerVoiceEnable(BluedPreferences.ac());
        Bundle bundle = new Bundle();
        final ChannelModel channelModel = new ChannelModel();
        channelModel.callType = videoChatMsgContentModel.room_type == 1 ? 3 : 2;
        channelModel.channelId = videoChatMsgContentModel.room_id;
        channelModel.remoteUid = (int) chattingModel.fromId;
        channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
        if (chattingModel.msgMapExtra != null) {
            channelModel.chat_sdk_type = MsgPackHelper.getIntValue(chattingModel.msgMapExtra, "chat_sdk_type");
        }
        bundle.putSerializable("CHANNEL", channelModel);
        bundle.putInt("action", 1);
        bundle.putBoolean("arg_bool_backtomain", true);
        notificationModel.setIntent(TransparentActivity.a(context, PendingFragment.class, bundle).a());
        this.f32199c.a(notificationModel);
        final Activity foreActivity = BluedApplicationLike.getForeActivity();
        if (foreActivity != null) {
            VideoChatHintToast.a(foreActivity, chattingModel.fromAvatar, chattingModel.fromVBadge, str3, new VideoChatHintToast.onHintClickLisnter() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.23
                @Override // com.soft.blued.ui.live.view.VideoChatHintToast.onHintClickLisnter
                public void a() {
                    DialogSkipFragment.a(foreActivity, channelModel);
                }
            });
        }
    }

    private void e(Context context, ChattingModel chattingModel) {
        if (chattingModel == null || chattingModel.msgMapExtra == null || CommonTools.a(context) || !j()) {
            return;
        }
        final NotificationModel notificationModel = new NotificationModel();
        MsgPackHelper.getIntValue(chattingModel.msgMapExtra, "version");
        String stringValue = MsgPackHelper.getStringValue(chattingModel.msgMapExtra, "title");
        String stringValue2 = MsgPackHelper.getStringValue(chattingModel.msgMapExtra, "link");
        String stringValue3 = MsgPackHelper.getStringValue(chattingModel.msgMapExtra, "content");
        String stringValue4 = MsgPackHelper.getStringValue(chattingModel.msgMapExtra, "image");
        notificationModel.setId(h());
        notificationModel.setRemindEnable(!this.e);
        notificationModel.setContentTitle(stringValue);
        notificationModel.setContentText(stringValue3);
        notificationModel.setTickerText(stringValue + " " + stringValue3);
        if (Build.VERSION.SDK_INT < 21) {
            notificationModel.setIconResId(R.drawable.blued_icon_0);
        } else {
            notificationModel.setIconResId(R.drawable.icon_launcher_alpha);
        }
        notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.blued_icon_0));
        notificationModel.setSoundFileUri(Uri.parse("android.resource://" + AppInfo.d().getPackageName() + BridgeUtil.SPLIT_MARK + R.raw.ringtone_get));
        notificationModel.setShakeEnable(BluedPreferences.af());
        notificationModel.setVoiceEnable(BluedPreferences.ae());
        notificationModel.setInnerVoiceEnable(BluedPreferences.ac());
        Intent intent = new Intent(context, FirstActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.putExtra("extra_bool_open_welcome_page", false);
        if (!TextUtils.isEmpty(stringValue2)) {
            intent.setData(Uri.parse(stringValue2));
        }
        notificationModel.setIntent(intent);
        this.f32199c.a(notificationModel);
        if (TextUtils.isEmpty(stringValue4)) {
            return;
        }
        ImageFileLoader.a((IRequestHost) null).a(stringValue4).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.24
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                if (file == null || !file.exists()) {
                    return;
                }
                try {
                    notificationModel.setBitmap(Util.imageZoomToSize(BitmapFactory.decodeFile(file.getPath()), 30));
                    notificationModel.setRemindEnable(false);
                    ChatHelperV4.this.f32199c.a(notificationModel);
                    Logger.b("xpf", "notifyMsg bitmap");
                } catch (Exception | OutOfMemoryError e) {
                }
            }
        }).a();
    }

    private void f(Context context, ChattingModel chattingModel) {
        Intent intent;
        if (chattingModel == null || CommonTools.a(context) || !j()) {
            return;
        }
        NotificationModel notificationModel = new NotificationModel();
        Bundle bundle = new Bundle();
        bundle.putString("from_tag_page", "from_notification_attention");
        Intent b = HomeArgumentHelper.b(context, "msg", bundle);
        if (TextUtils.isEmpty(chattingModel.msgContent)) {
            notificationModel.setContentText(context.getResources().getString(R.string.biao_notify_new_havemsg_long));
            intent = b;
        } else if (chattingModel.sessionId == 3 && chattingModel.msgType == 19) {
            notificationModel.setContentText(chattingModel.fromNickName + context.getResources().getString(2131891415));
            bundle.putString("from_tag_page", "from_notification_feed");
            bundle.putString("to_message_tab", "0");
            intent = HomeArgumentHelper.b(context, "msg", bundle);
        } else {
            intent = b;
            if (chattingModel.sessionId == 5) {
                intent = b;
                if (chattingModel.msgType == 1) {
                    notificationModel.setContentText(chattingModel.msgContent);
                    intent = b;
                }
            }
        }
        notificationModel.setId(h());
        if (Build.VERSION.SDK_INT < 21) {
            notificationModel.setIconResId(R.drawable.blued_icon_0);
        } else {
            notificationModel.setIconResId(R.drawable.icon_launcher_alpha);
        }
        notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.blued_icon_0));
        notificationModel.setSoundFileUri(Uri.parse("android.resource://" + AppInfo.d().getPackageName() + BridgeUtil.SPLIT_MARK + R.raw.ringtone_get));
        notificationModel.setShakeEnable(BluedPreferences.af());
        notificationModel.setVoiceEnable(BluedPreferences.ae());
        notificationModel.setInnerVoiceEnable(BluedPreferences.ac());
        String str = chattingModel.fromNickName;
        if (chattingModel.isMatchMsg == 1) {
            str = DateTodayManager.f32404a.c(chattingModel.fromNickName);
        }
        notificationModel.setContentTitle(str);
        notificationModel.setTickerText(context.getResources().getString(R.string.biao_notify_new_havemsg));
        notificationModel.setIntent(intent);
        this.f32199c.a(notificationModel);
    }

    private int h() {
        int i = this.h;
        this.h = i + 1;
        return i % 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (g.size() == 0) {
            this.i = false;
            this.f = null;
            return;
        }
        Pair<ChattingModel, MsgPreProcesserListener> poll = g.poll();
        if (poll == null) {
            i();
            return;
        }
        final ChattingModel chattingModel = poll.first;
        if (!AppUtils.c(chattingModel.fromId + "")) {
            com.blued.android.framework.utils.Logger.e(f32198a, "checkAndUpload===串号，列表还剩：" + g.size());
            if (!StringUtils.b(this.f)) {
                MediaSender.a(this.f);
            }
            g.clear();
            this.i = false;
            this.f = null;
            return;
        }
        this.i = true;
        final MsgPreProcesserListener msgPreProcesserListener = poll.second;
        String a2 = a(chattingModel);
        Log.v("drb", "checkAndUpload uploadFilePath:" + a2);
        if (a2.startsWith("http")) {
            b(chattingModel, msgPreProcesserListener);
            i();
            return;
        }
        final boolean z = !a(new File(a2));
        this.f = MediaSender.a(ChatHttpUtils.a(chattingModel), QiniuUploadUtils.a(a2, ""), z, new SenderListener() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.11
            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, int i) {
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, final Pair<String, UploadModel> pair) {
                if (AppUtils.c(chattingModel.fromId + "") && ChatHelperV4.this.i) {
                    ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChatHelperV4.this.a(chattingModel, pair, msgPreProcesserListener, z);
                        }
                    });
                }
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, boolean z2, List<Pair<String, String>> list) {
                ChatHelperV4.this.i();
            }
        });
    }

    private boolean j() {
        try {
            if (j.get() == 0 || (System.currentTimeMillis() - j.get()) / 1000 >= 3 || (System.currentTimeMillis() - j.get()) / 1000 < 0) {
                j.set(System.currentTimeMillis());
                return true;
            }
            j.set(System.currentTimeMillis());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public Bundle a(LiveMsgShareEntity liveMsgShareEntity) {
        Bundle bundle;
        if (liveMsgShareEntity == null) {
            return null;
        }
        int i = liveMsgShareEntity.redirect;
        Bundle bundle2 = new Bundle();
        if (i == 6) {
            bundle2.putString("arg_open_homeactivity_ope", "ope_liveplay");
            LiveRoomData liveRoomData = new LiveRoomData(com.soft.blued.utils.StringUtils.a(liveMsgShareEntity.lid, 0L), 0, "push", liveMsgShareEntity.uid, liveMsgShareEntity.name, liveMsgShareEntity.avatar, liveMsgShareEntity.vbadge);
            liveRoomData.note_type = liveMsgShareEntity.note_type;
            bundle2.putSerializable("live_anchor_model", liveRoomData);
        } else if (i == 1) {
            bundle2.putString("from_tag_page", "from_notification_attention");
            bundle2.putString("arg_open_homeactivity_ope", "ope_notifications");
            bundle2.putLong("passby_session_id", 5L);
            bundle2.putShort("passby_session_type", (short) 1);
            InstantLog.d("msg_push", "followed");
            EventTrackMessage.c(MessageProtos.Event.MSG_PUSH, "followed");
        } else if (i == 2) {
            bundle2.putString("arg_open_homeactivity_ope", "ope_visitors");
            InstantLog.d("msg_push", "visitors");
            EventTrackMessage.c(MessageProtos.Event.MSG_PUSH, "visitors");
        } else if (i != 3) {
            bundle = null;
            if (i != 4) {
                if (i == 5) {
                    return null;
                }
            }
            return bundle;
        } else {
            bundle2.putString("from_tag_page", "from_notification_feed");
        }
        bundle = bundle2;
        return bundle;
    }

    public ChattingModel a(String str, String str2, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse, MsgSourceEntity msgSourceEntity) {
        long a2 = com.soft.blued.utils.StringUtils.a(str, 0L);
        MsgExtraGift msgExtraGift = new MsgExtraGift();
        MsgExtraGift.GiftInfo giftInfo = new MsgExtraGift.GiftInfo();
        giftInfo.gift_name_cn = giftGivingOptionForJsonParse.gift_name_cn;
        giftInfo.gift_name_en = giftGivingOptionForJsonParse.gift_name_en;
        giftInfo.gift_name_tw = giftGivingOptionForJsonParse.gift_name_tw;
        giftInfo.gift_url = giftGivingOptionForJsonParse.effects;
        giftInfo.toNickName = str2;
        giftInfo.giftTye = giftGivingOptionForJsonParse.type;
        giftInfo.money = giftGivingOptionForJsonParse.money;
        giftInfo.topTime = giftGivingOptionForJsonParse.seconds;
        giftInfo.img_url = giftGivingOptionForJsonParse.icon;
        giftInfo.giftId = giftGivingOptionForJsonParse.gift_id;
        giftInfo.cardGift = giftGivingOptionForJsonParse.extra_info;
        msgExtraGift.gift_like = giftInfo;
        msgExtraGift.msgSource = msgSourceEntity;
        return ChatHelper.getChattingModelForSendmsg(a2, (short) 164, "gift", b(), this.b.toJson(msgExtraGift), (short) 2);
    }

    public SessionProfileModel a(String str, String str2, int i, int i2, int i3, int i4, int i5) {
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        sessionProfileModel.nickname = str;
        sessionProfileModel.avatar = str2;
        sessionProfileModel.vBadge = i;
        sessionProfileModel.vipGrade = i2;
        sessionProfileModel.vipAnnual = i3;
        sessionProfileModel.vipExpLvl = i4;
        sessionProfileModel.hideVipLook = i5;
        return sessionProfileModel;
    }

    public ShareToMsgEntity a(ChattingModel chattingModel, HashMap<String, ShareToMsgEntity> hashMap) {
        ShareToMsgEntity shareToMsgEntity;
        String str = chattingModel.sessionId + PhoneConstants.APN_TYPE_ALL + chattingModel.msgId + PhoneConstants.APN_TYPE_ALL + chattingModel.msgLocalId;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        ShareToMsgEntity shareToMsgEntity2 = new ShareToMsgEntity();
        try {
            String msgExtra = chattingModel.getMsgExtra();
            shareToMsgEntity = shareToMsgEntity2;
            if (!TextUtils.isEmpty(msgExtra)) {
                shareToMsgEntity = (ShareToMsgEntity) this.b.fromJson(msgExtra, (Class<Object>) ShareToMsgEntity.class);
                try {
                    hashMap.put(str, shareToMsgEntity);
                    return shareToMsgEntity;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return shareToMsgEntity;
                }
            }
        } catch (Exception e2) {
            e = e2;
            shareToMsgEntity = shareToMsgEntity2;
        }
        return shareToMsgEntity;
    }

    public String a(int i, int i2) {
        return a((MsgSourceEntity) null, i, i2);
    }

    public String a(ChattingModel chattingModel) {
        String str;
        String str2;
        short s = chattingModel.msgType;
        if (s == 2) {
            str = chattingModel.msgContent;
        } else if (s == 3) {
            str = IMV4Method.a(chattingModel);
        } else if (s != 24) {
            str = "";
        } else if (com.soft.blued.utils.StringUtils.d(chattingModel.msgContent) || chattingModel.msgContent.endsWith("destroy")) {
            return "";
        } else {
            try {
                str2 = AesCrypto.e(chattingModel.msgContent);
            } catch (Exception e) {
                e.printStackTrace();
                str2 = "";
            }
            if (com.soft.blued.utils.StringUtils.d(str2)) {
                return chattingModel.msgContent;
            }
            str = str2;
            if (!com.soft.blued.utils.StringUtils.d(str2)) {
                str = str2;
                if (!str2.contains("http")) {
                    return chattingModel.msgContent;
                }
            }
        }
        return com.soft.blued.utils.StringUtils.d(str) ? "" : str;
    }

    public String a(MsgSourceEntity msgSourceEntity) {
        if (msgSourceEntity != null) {
            MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = new MsgExtraForTextTypeEntity();
            msgExtraForTextTypeEntity.msgSource = msgSourceEntity;
            return this.b.toJson(msgExtraForTextTypeEntity);
        }
        return null;
    }

    public String a(MsgSourceEntity msgSourceEntity, int i, int i2) {
        MsgChattingImageModel msgChattingImageModel = new MsgChattingImageModel();
        msgChattingImageModel.setPicWidth(i);
        msgChattingImageModel.setPicHeight(i2);
        if (msgSourceEntity != null) {
            msgChattingImageModel.setMsgSource(msgSourceEntity);
        }
        return this.b.toJson(msgChattingImageModel);
    }

    public String a(List<GroupMemberModel> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuffer.toString();
            }
            stringBuffer.append(list.get(i2).uid);
            if (i2 != list.size() - 1) {
                stringBuffer.append(",");
            }
            i = i2 + 1;
        }
    }

    public void a(long j2) {
        ChatManager.getInstance().deleteSessionAndChatting((short) 1, j2);
    }

    public void a(Context context, long j2, long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("passby_session_id", j2);
        bundle.putShort("passby_session_type", (short) 1);
        bundle.putLong("passby_maxHasReadMsgID", j3);
        TerminalActivity.d(context, MsgAttentionNotifyFragment.class, bundle);
    }

    public void a(Context context, long j2, String str, String str2, int i, int i2, int i3, int i4, String str3, boolean z, int i5, int i6, LogData logData, MsgSourceEntity msgSourceEntity) {
        a(context, j2, str, str2, i, i2, i3, i4, str3, z, i5, i6, logData, msgSourceEntity, -1L, -1L, false, false);
    }

    public void a(Context context, long j2, String str, String str2, int i, int i2, int i3, int i4, String str3, boolean z, int i5, int i6, LogData logData, MsgSourceEntity msgSourceEntity, long j3, long j4, boolean z2, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putLong("passby_session_id", j2);
        bundle.putString("passby_nick_name", str);
        bundle.putString("passby_avatar", str2);
        bundle.putInt("passby_vbadge", i);
        bundle.putInt("passby_vip_grade", i2);
        bundle.putInt("passby_is_vip_annual", i3);
        bundle.putInt("passby_vip_exp_lvl", i4);
        bundle.putString("passby_last_msg_distance", str3);
        bundle.putBoolean("passby_session_secret", z);
        bundle.putSerializable("PASSBY_LOG_DATA", logData);
        bundle.putSerializable("msg_source_model", msgSourceEntity);
        bundle.putInt("passby_is_hide_vip_look", i6);
        bundle.putLong("PASSBY_MSG_ID", j3);
        bundle.putLong("PASSBY_MSG_LOCAL_ID", j4);
        bundle.putBoolean("show_guide", z2);
        bundle.putBoolean("PASSBY_DATE_TODAY", z3);
        Log.e("xxx", "toChattingPage dateToday=" + z3 + ", sessionId=" + j2);
        if (i5 == 0) {
            bundle.putShort("passby_session_type", (short) 2);
        } else if (i5 != 1) {
            return;
        } else {
            bundle.putShort("passby_session_type", (short) 3);
        }
        if (z3) {
            TerminalActivity.a(bundle);
        }
        TerminalActivity.d(context, MsgChattingFragment.class, bundle);
    }

    public void a(Context context, long j2, String str, String str2, int i, int i2, int i3, int i4, String str3, boolean z, int i5, int i6, LogData logData, MsgSourceEntity msgSourceEntity, ChatBundleExtra chatBundleExtra) {
        Bundle bundle = new Bundle();
        bundle.putLong("passby_session_id", j2);
        bundle.putString("passby_nick_name", str);
        bundle.putString("passby_avatar", str2);
        bundle.putInt("passby_vbadge", i);
        bundle.putInt("passby_vip_grade", i2);
        bundle.putInt("passby_is_vip_annual", i3);
        bundle.putInt("passby_vip_exp_lvl", i4);
        bundle.putString("passby_last_msg_distance", str3);
        bundle.putBoolean("passby_session_secret", z);
        bundle.putSerializable("PASSBY_LOG_DATA", logData);
        bundle.putSerializable("msg_source_model", msgSourceEntity);
        bundle.putInt("passby_is_hide_vip_look", i6);
        bundle.putSerializable("EXTRA", chatBundleExtra);
        if (i5 == 0) {
            bundle.putShort("passby_session_type", (short) 2);
        } else if (i5 != 1) {
            return;
        } else {
            bundle.putShort("passby_session_type", (short) 3);
        }
        TerminalActivity.d(context, MsgChattingFragment.class, bundle);
    }

    public void a(Context context, long j2, String str, String str2, int i, int i2, int i3, int i4, String str3, boolean z, int i5, int i6, LogData logData, MsgSourceEntity msgSourceEntity, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putLong("passby_session_id", j2);
        bundle.putString("passby_nick_name", str);
        bundle.putString("passby_avatar", str2);
        bundle.putInt("passby_vbadge", i);
        bundle.putInt("passby_vip_grade", i2);
        bundle.putInt("passby_is_vip_annual", i3);
        bundle.putInt("passby_vip_exp_lvl", i4);
        bundle.putString("passby_last_msg_distance", str3);
        bundle.putBoolean("passby_session_secret", z);
        bundle.putSerializable("PASSBY_LOG_DATA", logData);
        bundle.putSerializable("msg_source_model", msgSourceEntity);
        bundle.putInt("passby_is_hide_vip_look", i6);
        bundle.putBoolean("IS_FROM_MSG_BOX", z2);
        if (i5 == 0) {
            bundle.putShort("passby_session_type", (short) 2);
        } else if (i5 != 1) {
            return;
        } else {
            bundle.putShort("passby_session_type", (short) 3);
        }
        TerminalActivity.d(context, MsgChattingFragment.class, bundle);
    }

    public void a(Context context, long j2, String str, String str2, int i, int i2, int i3, int i4, String str3, boolean z, int i5, int i6, LogData logData, boolean z2, MsgSourceEntity msgSourceEntity) {
        a(context, j2, str, str2, i, i2, i3, i4, str3, z, i5, i6, logData, msgSourceEntity, -1L, -1L, z2, false);
    }

    public void a(Context context, ChattingModel chattingModel) {
        if (chattingModel != null && CommonTools.a(context) && j()) {
            i(chattingModel);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0242 -> B:101:0x01dc). Please submit an issue!!! */
    public void a(Context context, SessionModel sessionModel, ChattingModel chattingModel) {
        GroupNotificationExtra groupNotificationExtra;
        if (chattingModel == null) {
            return;
        }
        SessionSettingModel sessionSettingModel = sessionModel != null ? (SessionSettingModel) sessionModel.sessionSettingModel : null;
        if (chattingModel.msgType == 52) {
            d(context, chattingModel);
        } else if (chattingModel.sessionType == 2) {
            if (!(MsgBoxManager.a().c() && MsgBoxManager.a().a(chattingModel.sessionId)) && BluedPreferences.ak() && chattingModel.status == 0) {
                b(context, chattingModel);
                a(context, chattingModel);
            }
        } else if (chattingModel.sessionType == 3 && 1 != MsgType.getClassify(chattingModel.msgType)) {
            if (BluedConstant.f28239a || !BluedPreferences.am()) {
                return;
            }
            if (sessionSettingModel == null) {
                b(context, chattingModel);
                a(context, chattingModel);
            } else if (!GroupUtil.a(sessionSettingModel.getRemindAudio())) {
                b(context, chattingModel);
                a(context, chattingModel);
            } else if (GroupUtil.b(sessionSettingModel.getRemindAudio()) || !AtRegExpUtils.isAtSelf(chattingModel.msgAt)) {
            } else {
                b(context, chattingModel);
                a(context, chattingModel);
            }
        } else if (chattingModel.sessionType == 1) {
            if (chattingModel.sessionId == 6 || chattingModel.sessionId == 7) {
                c(context, chattingModel);
            } else if (chattingModel.sessionId == 2) {
                if (BluedConstant.f28239a) {
                    return;
                }
                try {
                    if (TextUtils.isEmpty(chattingModel.getMsgExtra()) || (groupNotificationExtra = (GroupNotificationExtra) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) GroupNotificationExtra.class)) == null) {
                        return;
                    }
                    SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel((short) 3, groupNotificationExtra.phone_session_id);
                    SessionSettingModel sessionSettingModel2 = null;
                    if (snapSessionModel != null) {
                        sessionSettingModel2 = (SessionSettingModel) snapSessionModel.sessionSettingModel;
                    }
                    if (sessionSettingModel2 == null || !GroupUtil.c(sessionSettingModel2.getRemindAudio())) {
                        b(context, chattingModel);
                        a(context, chattingModel);
                    }
                } catch (Throwable th) {
                }
            } else if (chattingModel.sessionId == 16 && BluedPreferences.ah()) {
                e(context, chattingModel);
            } else if (chattingModel.sessionId == 3 && chattingModel.msgType == 19 && BluedPreferences.an()) {
                f(context, chattingModel);
            } else if (chattingModel.sessionId == 5 && chattingModel.msgType == 1 && BluedPreferences.al()) {
                f(context, chattingModel);
            } else if (chattingModel.sessionId == 10) {
                if (!com.soft.blued.utils.StringUtils.d(chattingModel.msgContent)) {
                    try {
                        ReflectionUtils.a((Object) ((BluedLoginResult) AppInfo.f().fromJson(chattingModel.msgContent, (Class<Object>) BluedLoginResult.class)), (Object) UserInfo.getInstance().getLoginUserInfo(), true);
                    } catch (Exception e) {
                    }
                }
                BluedConfig.a().c();
            } else if (chattingModel.sessionId != 18) {
                if (chattingModel.sessionId == 19) {
                    MsgFragment.b = true;
                }
            } else if (TextUtils.isEmpty(chattingModel.getMsgExtra())) {
            } else {
                try {
                    SysCommandModel sysCommandModel = (SysCommandModel) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) SysCommandModel.class);
                    if (sysCommandModel.command_type == 1) {
                        ChatManager.getInstance().deleteSessionAndChatting((short) 2, sysCommandModel.command_info.session_id);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void a(Context context, UserBasicModel userBasicModel, int i, String str, String str2, int i2, int i3, String str3) {
        if (userBasicModel == null) {
            return;
        }
        ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(Long.parseLong(userBasicModel.uid), i == 0 ? (short) 98 : (short) 99, "vip", b(), "", (short) 2);
        chattingModelForSendmsg.msgMapExtra = new HashMap();
        chattingModelForSendmsg.msgMapExtra.put("title", str);
        chattingModelForSendmsg.msgMapExtra.put("content", str2);
        chattingModelForSendmsg.msgMapExtra.put("vip_type", Integer.valueOf(i2));
        chattingModelForSendmsg.msgMapExtra.put("link", str3);
        for (String str4 : chattingModelForSendmsg.msgMapExtra.keySet()) {
            Logger.b("xpf", str4, " :", chattingModelForSendmsg.msgMapExtra.get(str4));
        }
        c(chattingModelForSendmsg, userBasicModel.name, userBasicModel.avatar, userBasicModel.vbadge, userBasicModel.vip_grade, userBasicModel.is_vip_annual, userBasicModel.vip_exp_lvl, i3, false);
    }

    public void a(Context context, BluedCreatedGroupInfo bluedCreatedGroupInfo) {
        b(ChatHelper.getChattingModelForSendmsg(Long.valueOf(bluedCreatedGroupInfo.groups_gid).longValue(), (short) -1000, context.getResources().getString(R.string.biao_msg_soft_notice_create_group), a().b(), "", (short) 3), bluedCreatedGroupInfo.groups_name, bluedCreatedGroupInfo.groups_avatar, 0, 0, 0, 0, 0);
    }

    public void a(Context context, ShareToMsgEntity shareToMsgEntity) {
        ShareToFragment.a(context, shareToMsgEntity);
    }

    public void a(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().registerSessionListener((short) 1, 13L, singleSessionListener);
    }

    public void a(ChattingModel chattingModel, MsgPreProcesserListener msgPreProcesserListener) {
        if (AppUtils.c(chattingModel.fromId + "")) {
            chattingModel.msgStateCode = (short) 6;
            msgPreProcesserListener.onProcessToSave(chattingModel);
            MessageProtos.Event event = MessageProtos.Event.MSG_SEND_FAIL;
            EventTrackMessage.d(event, ((int) chattingModel.msgType) + "", "upload failed");
        }
    }

    public void a(ChattingModel chattingModel, String str, String str2, int i) {
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        sessionProfileModel.nickname = str;
        sessionProfileModel.avatar = str2;
        sessionProfileModel.vBadge = i;
        ChatManager.getInstance().sendMsg(chattingModel, sessionProfileModel, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.21
            @Override // com.blued.android.chat.listener.MsgPreProcesser
            public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                chattingModel2.msgStateCode = (short) 6;
                msgPreProcesserListener.onProcessToSave(chattingModel2);
            }
        });
    }

    public void a(final ChattingModel chattingModel, final String str, final String str2, final int i, final int i2, final int i3, final int i4, final int i5) {
        long j2 = chattingModel.sessionId;
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            a(chattingModel, str, str2, i);
            return;
        }
        Type type = new TypeToken<MsgExtra>() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.5
        }.getType();
        final Gson f = AppInfo.f();
        final MsgExtra msgExtra2 = (MsgExtra) f.fromJson(msgExtra, type);
        GroupHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<Object, ExtraGroupInvitationModel>>() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i6, String str3) {
                super.onFailure(th, i6, str3);
                ChatHelperV4.this.a(chattingModel, str, str2, i);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, ExtraGroupInvitationModel> bluedEntity) {
                if (bluedEntity != null) {
                    try {
                        if (bluedEntity.extra != null && bluedEntity.extra.iid != null && bluedEntity.extra.iid.size() > 0) {
                            String str3 = bluedEntity.extra.iid.get(0).iid;
                            if (TextUtils.isEmpty(str3)) {
                                ChatHelperV4.this.a(chattingModel, str, str2, i);
                                return;
                            }
                            msgExtra2.setGroups_iid(str3);
                            chattingModel.setMsgExtra(f.toJson(msgExtra2));
                            ChatHelperV4.this.c(chattingModel, str, str2, i, i2, i3, i4, i5, false);
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ChatHelperV4.this.a(chattingModel, str, str2, i);
                        return;
                    }
                }
                ChatHelperV4.this.a(chattingModel, str, str2, i);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<Object, ExtraGroupInvitationModel> parseData(String str3) {
                return super.parseData(str3);
            }
        }, msgExtra2.getGroups_gid(), new String[]{String.valueOf(j2)}, false);
    }

    public void a(ChattingModel chattingModel, String str, String str2, int i, int i2, int i3, int i4, int i5, boolean z) {
        SessionProfileModel a2 = a(str, str2, i, i2, i3, i4, i5);
        final String a3 = a(chattingModel);
        if (z) {
            ChatManager.getInstance().resendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.1
                @Override // com.blued.android.chat.listener.MsgPreProcesser
                public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                    ChatHelperV4.this.a(chattingModel2, msgPreProcesserListener, a3);
                }
            });
        } else {
            ChatManager.getInstance().sendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.2
                @Override // com.blued.android.chat.listener.MsgPreProcesser
                public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                    ChatHelperV4.this.a(chattingModel2, msgPreProcesserListener, a3);
                }
            });
        }
    }

    public void a(ChattingModel chattingModel, boolean z) {
        SessionProfileModel a2 = a("", "", 0, 0, 0, 0, 0);
        if ((chattingModel.msgType == 32 || chattingModel.msgType == 210) && IMManager.a().b(chattingModel)) {
            if (z) {
                ChatManager.getInstance().resendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.17
                    @Override // com.blued.android.chat.listener.MsgPreProcesser
                    public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                        IMManager.a().a(chattingModel2);
                    }
                });
            } else {
                ChatManager.getInstance().sendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.18
                    @Override // com.blued.android.chat.listener.MsgPreProcesser
                    public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                        IMManager.a().a(chattingModel2);
                    }
                });
            }
        } else if (z) {
            ChatManager.getInstance().resendMsg(chattingModel, a2);
        } else {
            ChatManager.getInstance().sendMsg(chattingModel, a2);
        }
    }

    public void a(SessionModel sessionModel, ChattingModel chattingModel) {
        ChattingModel chattingModel2 = new ChattingModel(chattingModel);
        chattingModel2.msgLocalId = ChatHelper.getLocalId();
        chattingModel2.msgType = (short) -1;
        h(chattingModel2);
    }

    public void a(ShareToMsgEntity shareToMsgEntity, long j2, short s, String str, String str2, int i, int i2, int i3, int i4, int i5) {
        if (shareToMsgEntity == null) {
            return;
        }
        MsgExtra msgExtra = new MsgExtra();
        msgExtra.setGroups_avatar(shareToMsgEntity.image);
        msgExtra.setGroups_name(shareToMsgEntity.name);
        msgExtra.setGroups_gid(shareToMsgEntity.gid);
        msgExtra.setGroups_description(shareToMsgEntity.description);
        ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(j2, (short) 10, shareToMsgEntity.title, b(), this.b.toJson(msgExtra), s);
        chattingModelForSendmsg.msgType = (short) 10;
        c(chattingModelForSendmsg, str, str2, i, i2, i3, i4, i5, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(final ShareToMsgEntity shareToMsgEntity, final long j2, final short s, final String str, final String str2, final int i, final int i2, final int i3, final int i4, final int i5, String str3) {
        short s2;
        int i6;
        if (shareToMsgEntity == null) {
            return;
        }
        switch (shareToMsgEntity.share_from) {
            case 1:
                s2 = 90;
                break;
            case 2:
                a(shareToMsgEntity, j2, s, str, str2, i, i2, i3, i4, i5);
                return;
            case 3:
            case 8:
            default:
                s2 = -1;
                break;
            case 4:
            case 10:
            case 13:
                s2 = 89;
                break;
            case 5:
                s2 = 87;
                break;
            case 6:
            case 7:
                s2 = 88;
                break;
            case 9:
                s2 = 2;
                break;
            case 11:
                CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<CircleAddPoints> bluedEntityA) {
                        if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData().circle_active_shared_posting <= 0) {
                            return;
                        }
                        AppMethods.a((CharSequence) ("分享成功，积分+" + bluedEntityA.getSingleData().circle_active_shared_posting));
                    }
                }, str3);
                s2 = 89;
                break;
            case 12:
                s2 = 210;
                break;
            case 14:
                s2 = 244;
                break;
            case 15:
                s2 = 242;
                break;
        }
        if (s2 == 2) {
            int i7 = 0;
            if (new File(shareToMsgEntity.image).exists()) {
                int[] b = ImageUtils.b(shareToMsgEntity.image);
                i7 = b[0];
                i6 = b[1];
            } else {
                i6 = 0;
            }
            a(ChatHelper.getChattingModelForSendmsg(j2, s2, shareToMsgEntity.image, b(), a(i7, i6), s), str, str2, i, i2, i3, i4, i5, false);
        } else if (s2 == 210) {
            LiveHttpUtils.b(shareToMsgEntity.sessionId + "", new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.13
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveMsgShareEntity> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        return;
                    }
                    LiveMsgShareEntity singleData = bluedEntityA.getSingleData();
                    Gson f = AppInfo.f();
                    singleData.name = shareToMsgEntity.name;
                    singleData.pic_url = shareToMsgEntity.image;
                    singleData.copywriting = shareToMsgEntity.title;
                    singleData.description = singleData.room_type_name;
                    String json = f.toJson(singleData);
                    Logger.e("invite", "invite friends extra: " + json);
                    ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(j2, (short) 210, AppInfo.d().getResources().getString(R.string.yy_share_to_chat), ChatHelperV4.this.b(), json, s);
                    String str4 = singleData.room_id;
                    String str5 = singleData.uid;
                    EventTrackYY.a(str4, str5, j2 + "");
                    ChatHelperV4.a().a(chattingModelForSendmsg, false);
                }
            }, (IRequestHost) null);
        } else {
            final ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(j2, s2, shareToMsgEntity.title, b(), AppInfo.f().toJson(shareToMsgEntity), s);
            if (TextUtils.isEmpty(shareToMsgEntity.image) || shareToMsgEntity.image.contains("http")) {
                c(chattingModelForSendmsg, str, str2, i, i2, i3, i4, i5, false);
            } else {
                ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UrlPicResult>>() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.14
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<UrlPicResult> bluedEntityA) {
                        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            ChatHelperV4.this.c(chattingModelForSendmsg, str, str2, i, i2, i3, i4, i5, false);
                            return;
                        }
                        UrlPicResult urlPicResult = bluedEntityA.data.get(0);
                        if (TextUtils.isEmpty(urlPicResult.url)) {
                            ChatHelperV4.this.c(chattingModelForSendmsg, str, str2, i, i2, i3, i4, i5, false);
                            return;
                        }
                        shareToMsgEntity.image = urlPicResult.url;
                        chattingModelForSendmsg.setMsgExtra(AppInfo.f().toJson(shareToMsgEntity));
                        ImageFileLoader.a((IRequestHost) null).a(shareToMsgEntity.image, urlPicResult.url).a();
                        ChatHelperV4.this.c(chattingModelForSendmsg, str, str2, i, i2, i3, i4, i5, false);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public boolean onUIFailure(int i8, String str4) {
                        ChatHelperV4.this.c(chattingModelForSendmsg, str, str2, i, i2, i3, i4, i5, false);
                        return super.onUIFailure(i8, str4);
                    }
                }, UserInfo.getInstance().getLoginUserInfo().getUid(), shareToMsgEntity.image, chattingModelForSendmsg);
            }
        }
    }

    public void a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
        c(ChatHelper.getChattingModelForSendmsg(com.soft.blued.utils.StringUtils.a(str, 0L), (short) 74, "unlock", b(), "", (short) 2), str2, str3, i, i2, i3, i4, i5, false);
    }

    public void a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse, MsgSourceEntity msgSourceEntity) {
        if (giftGivingOptionForJsonParse.type == -1) {
            return;
        }
        c(a(str, str2, giftGivingOptionForJsonParse, msgSourceEntity), str2, str3, i, i2, i3, i4, i5, false);
    }

    public void a(List<ChattingModel> list, String str, String str2, int i, int i2, int i3, int i4, int i5) {
        for (ChattingModel chattingModel : list) {
            ChatManager.getInstance().sendMsg(chattingModel, a(str, str2, i, i2, i3, i4, i5), new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.7
                @Override // com.blued.android.chat.listener.MsgPreProcesser
                public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                    ChatHelperV4.g.add(new Pair(chattingModel2, msgPreProcesserListener));
                    if (ChatHelperV4.this.i) {
                        return;
                    }
                    ChatHelperV4.this.i();
                }
            });
        }
    }

    public void a(short s, long j2, final ChattingModel chattingModel) {
        final String str = chattingModel.msgContent;
        ChatManager.getInstance().destroyMsg(s, j2, chattingModel);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.25
            @Override // java.lang.Runnable
            public void run() {
                if (str.endsWith("destroy")) {
                    return;
                }
                ChattingModel chattingModel2 = chattingModel;
                chattingModel2.msgContent = str + "|destroy";
                ChatManager.getInstance().updateMsgOneData(chattingModel);
            }
        }, 200L);
    }

    public Bundle b(LiveMsgShareEntity liveMsgShareEntity) {
        if (liveMsgShareEntity == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        LiveRoomData liveRoomData = new LiveRoomData(com.soft.blued.utils.StringUtils.a(liveMsgShareEntity.lid, 0L), 0, "push", liveMsgShareEntity.uid, liveMsgShareEntity.name, liveMsgShareEntity.avatar, liveMsgShareEntity.vbadge);
        liveRoomData.note_type = liveMsgShareEntity.note_type;
        bundle.putString("arg_open_homeactivity_ope", "ope_liveplay");
        bundle.putSerializable("live_anchor_model", liveRoomData);
        return bundle;
    }

    public SessionProfileModel b() {
        SessionProfileModel sessionProfileModel = new SessionProfileModel();
        if (UserInfo.getInstance().getLoginUserInfo() != null) {
            sessionProfileModel.nickname = UserInfo.getInstance().getLoginUserInfo().getName();
            sessionProfileModel.avatar = UserInfo.getInstance().getLoginUserInfo().getAvatar();
            sessionProfileModel.vBadge = UserInfo.getInstance().getLoginUserInfo().getVBadge();
        }
        return sessionProfileModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.blued.android.module.common.share.model.ShareEventToMsgEntity b(com.blued.android.chat.model.ChattingModel r5, java.util.HashMap<java.lang.String, com.soft.blued.ui.msg.model.ShareToMsgEntity> r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            r1 = r5
            long r1 = r1.sessionId
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = "*"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            long r1 = r1.msgId
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = "*"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            long r1 = r1.msgLocalId
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r0 = r0.toString()
            r9 = r0
            r0 = r6
            r1 = r9
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L4c
            r0 = r6
            r1 = r9
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.common.share.model.ShareEventToMsgEntity r0 = (com.blued.android.module.common.share.model.ShareEventToMsgEntity) r0
            return r0
        L4c:
            r0 = 0
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r5
            java.lang.String r0 = r0.getMsgExtra()     // Catch: java.lang.Exception -> L81
            r10 = r0
            r0 = r8
            r5 = r0
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L81
            if (r0 != 0) goto L88
            r0 = r4
            com.google.gson.Gson r0 = r0.b     // Catch: java.lang.Exception -> L81
            r1 = r10
            java.lang.Class<com.blued.android.module.common.share.model.ShareEventToMsgEntity> r2 = com.blued.android.module.common.share.model.ShareEventToMsgEntity.class
            java.lang.Object r0 = r0.fromJson(r1, r2)     // Catch: java.lang.Exception -> L81
            com.blued.android.module.common.share.model.ShareEventToMsgEntity r0 = (com.blued.android.module.common.share.model.ShareEventToMsgEntity) r0     // Catch: java.lang.Exception -> L81
            r5 = r0
            r0 = r6
            r1 = r9
            r2 = r5
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Exception -> L7d
            goto L88
        L7d:
            r6 = move-exception
            goto L84
        L81:
            r6 = move-exception
            r0 = r7
            r5 = r0
        L84:
            r0 = r6
            r0.printStackTrace()
        L88:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L96
            com.blued.android.module.common.share.model.ShareEventToMsgEntity r0 = new com.blued.android.module.common.share.model.ShareEventToMsgEntity
            r1 = r0
            r1.<init>()
            r6 = r0
        L96:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.b(com.blued.android.chat.model.ChattingModel, java.util.HashMap):com.blued.android.module.common.share.model.ShareEventToMsgEntity");
    }

    public String b(ChattingModel chattingModel) {
        String str;
        String str2;
        short s = chattingModel.msgType;
        if (s == 5) {
            str = chattingModel.msgContent;
        } else if (s != 25) {
            str = "";
        } else if (com.soft.blued.utils.StringUtils.d(chattingModel.msgContent) || chattingModel.msgContent.endsWith("destroy")) {
            return "";
        } else {
            try {
                str2 = AesCrypto.e(chattingModel.msgContent);
            } catch (Exception e) {
                e.printStackTrace();
                str2 = "";
            }
            if (com.soft.blued.utils.StringUtils.d(str2)) {
                return chattingModel.msgContent;
            }
            str = str2;
            if (!com.soft.blued.utils.StringUtils.d(str2)) {
                str = str2;
                if (!str2.contains("http")) {
                    return chattingModel.msgContent;
                }
            }
        }
        return com.soft.blued.utils.StringUtils.d(str) ? "" : str;
    }

    public String b(MsgSourceEntity msgSourceEntity) {
        if (msgSourceEntity == null) {
            return null;
        }
        MsgAudioExtra msgAudioExtra = new MsgAudioExtra();
        msgAudioExtra.msgSource = msgSourceEntity;
        return this.b.toJson(msgAudioExtra);
    }

    public void b(long j2) {
        ChatManager.getInstance().deleteSession((short) 2, j2);
    }

    public void b(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().unregisterSessionListener((short) 1, 13L, singleSessionListener);
    }

    public void b(ChattingModel chattingModel, MsgPreProcesserListener msgPreProcesserListener) {
        if (AppUtils.c(chattingModel.fromId + "")) {
            msgPreProcesserListener.onProcessToSave(chattingModel);
            if (IMManager.a().b(chattingModel)) {
                IMManager.a().a(chattingModel);
            } else {
                msgPreProcesserListener.onProcessToSend(chattingModel);
            }
        }
    }

    public void b(ChattingModel chattingModel, String str, String str2, int i, int i2, int i3, int i4, int i5) {
        ChatManager.getInstance().sendMsg(chattingModel, a(str, str2, i, i2, i3, i4, i5), new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.19
            @Override // com.blued.android.chat.listener.MsgPreProcesser
            public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                chattingModel2.msgStateCode = (short) 3;
                msgPreProcesserListener.onProcessToSave(chattingModel2);
            }
        });
    }

    public void b(ChattingModel chattingModel, String str, String str2, int i, int i2, int i3, int i4, int i5, boolean z) {
        SessionProfileModel a2 = a(str, str2, i, i2, i3, i4, i5);
        final String b = b(chattingModel);
        if (z) {
            ChatManager.getInstance().resendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.3
                @Override // com.blued.android.chat.listener.MsgPreProcesser
                public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                    ChatHelperV4.this.a(chattingModel2, msgPreProcesserListener, b);
                }
            });
        } else {
            ChatManager.getInstance().sendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.4
                @Override // com.blued.android.chat.listener.MsgPreProcesser
                public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                    ChatHelperV4.this.a(chattingModel2, msgPreProcesserListener, b);
                }
            });
        }
    }

    public void b(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
        c(ChatHelper.getChattingModelForSendmsg(com.soft.blued.utils.StringUtils.a(str, 0L), (short) 73, "apply", b(), "", (short) 2), str2, str3, i, i2, i3, i4, i5, false);
    }

    public void c() {
        this.f32199c.a(100);
    }

    public void c(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().registerSessionListener((short) 1, 4L, singleSessionListener);
    }

    public void c(ChattingModel chattingModel, String str, String str2, int i, int i2, int i3, int i4, int i5, boolean z) {
        SessionProfileModel a2 = a(str, str2, i, i2, i3, i4, i5);
        if (IMManager.a().b(chattingModel)) {
            if (z) {
                ChatManager.getInstance().resendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.15
                    @Override // com.blued.android.chat.listener.MsgPreProcesser
                    public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                        IMManager.a().a(chattingModel2);
                    }
                });
            } else {
                ChatManager.getInstance().sendMsg(chattingModel, a2, new MsgPreProcesser() { // from class: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.16
                    @Override // com.blued.android.chat.listener.MsgPreProcesser
                    public void preProcess(ChattingModel chattingModel2, MsgPreProcesserListener msgPreProcesserListener) {
                        IMManager.a().a(chattingModel2);
                    }
                });
            }
        } else if (z) {
            ChatManager.getInstance().resendMsg(chattingModel, a2);
        } else {
            ChatManager.getInstance().sendMsg(chattingModel, a2);
        }
    }

    public String[] c(ChattingModel chattingModel) {
        String[] strArr = new String[2];
        if (chattingModel == null) {
            return strArr;
        }
        String str = chattingModel.msgContent;
        if (com.soft.blued.utils.StringUtils.d(str)) {
            return strArr;
        }
        try {
            if (chattingModel.msgMapExtra == null || TextUtils.isEmpty((String) chattingModel.msgMapExtra.get("videoCoverUrl"))) {
                MsgChattingVideoModel msgChattingVideoModel = (MsgChattingVideoModel) this.b.fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgChattingVideoModel.class);
                if (msgChattingVideoModel != null && !TextUtils.isEmpty(msgChattingVideoModel.getVideoCoverUrl())) {
                    strArr[0] = msgChattingVideoModel.getVideoCoverUrl();
                } else if (str.contains("http")) {
                    strArr[0] = str;
                } else {
                    strArr[0] = chattingModel.msgVideoCoverUrlLocal;
                }
            } else {
                strArr[0] = (String) chattingModel.msgMapExtra.get("videoCoverUrl");
            }
        } catch (Exception e) {
        }
        strArr[1] = str;
        return strArr;
    }

    public MsgChattingImageModel d(ChattingModel chattingModel) {
        if (chattingModel == null) {
            return null;
        }
        try {
            return (MsgChattingImageModel) this.b.fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgChattingImageModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void d() {
        this.e = true;
    }

    public void d(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().unregisterSessionListener((short) 1, 4L, singleSessionListener);
    }

    public MsgChattingVideoModel e(ChattingModel chattingModel) {
        if (chattingModel == null) {
            return null;
        }
        try {
            return (MsgChattingVideoModel) this.b.fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgChattingVideoModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void e() {
        this.e = false;
    }

    public void e(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().registerSessionListener((short) 1, 7L, singleSessionListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
        if (android.text.TextUtils.isEmpty(r8.getLongitude()) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.soft.blued.ui.msg.model.MsgChattingImageModel f(com.blued.android.chat.model.ChattingModel r5) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.controller.tools.ChatHelperV4.f(com.blued.android.chat.model.ChattingModel):com.soft.blued.ui.msg.model.MsgChattingImageModel");
    }

    public void f(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().unregisterSessionListener((short) 1, 7L, singleSessionListener);
    }

    public void g(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().registerSessionListener((short) 1, 6L, singleSessionListener);
    }

    public int[] g(ChattingModel chattingModel) {
        MsgChattingVideoModel msgChattingVideoModel;
        MsgChattingVideoModel msgChattingVideoModel2;
        Gson f = AppInfo.f();
        String msgExtra = chattingModel.getMsgExtra();
        int[] iArr = new int[2];
        try {
            if (chattingModel.msgMapExtra != null) {
                iArr[0] = MsgPackHelper.getIntValue(chattingModel.msgMapExtra, TvContract.Programs.COLUMN_VIDEO_WIDTH);
                iArr[1] = MsgPackHelper.getIntValue(chattingModel.msgMapExtra, TvContract.Programs.COLUMN_VIDEO_HEIGHT);
                if ((iArr[0] == 0 || iArr[1] == 0) && !com.soft.blued.utils.StringUtils.d(msgExtra) && (msgChattingVideoModel2 = (MsgChattingVideoModel) f.fromJson(msgExtra, (Class<Object>) MsgChattingVideoModel.class)) != null) {
                    iArr[0] = msgChattingVideoModel2.getVideo_width();
                    iArr[1] = msgChattingVideoModel2.getVideo_height();
                    return iArr;
                }
            } else if (!com.soft.blued.utils.StringUtils.d(msgExtra) && (msgChattingVideoModel = (MsgChattingVideoModel) f.fromJson(msgExtra, (Class<Object>) MsgChattingVideoModel.class)) != null) {
                iArr[0] = msgChattingVideoModel.getVideo_width();
                iArr[1] = msgChattingVideoModel.getVideo_height();
                return iArr;
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public void h(SingleSessionListener singleSessionListener) {
        ChatManager.getInstance().unregisterSessionListener((short) 1, 6L, singleSessionListener);
    }

    public void h(ChattingModel chattingModel) {
        ChatManager.getInstance().sendMsg(chattingModel, null, null);
    }

    public void i(ChattingModel chattingModel) {
        try {
            if (this.e || IMV4Constant.f32240a) {
                return;
            }
            if (BluedPreferences.ae() || BluedPreferences.af()) {
                if (ChatConstants.f28313a == chattingModel.sessionId && IMV4Constant.b) {
                    return;
                }
                if (BluedPreferences.af() && BluedPreferences.ae()) {
                    if (ChatConstants.f28313a != chattingModel.sessionId) {
                        if (BluedPreferences.ac()) {
                            MediaUtils.a().a(1);
                        } else {
                            MediaUtils.a().b();
                        }
                    }
                    MediaUtils.a().a(1000L);
                } else if (BluedPreferences.af()) {
                    MediaUtils.a().a(1000L);
                } else if (!BluedPreferences.ae() || ChatConstants.f28313a == chattingModel.sessionId) {
                } else {
                    if (BluedPreferences.ac()) {
                        MediaUtils.a().a(1);
                    } else {
                        MediaUtils.a().b();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
