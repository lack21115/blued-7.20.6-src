package com.soft.blued.ui.msg_group.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.view.GroupJoinView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg_group.event.UpdateAnnouncementEvent;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.model.GroupConfigModel;
import com.soft.blued.ui.msg_group.model.ReportJsonModel;
import com.soft.blued.ui.msg_group.pop.CircleGroupListPop;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/utils/GroupUtil.class */
public class GroupUtil {

    /* renamed from: a  reason: collision with root package name */
    public static int f32828a = 168;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f32829c = false;

    /* renamed from: com.soft.blued.ui.msg_group.utils.GroupUtil$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/utils/GroupUtil$1.class */
    class AnonymousClass1 implements FetchDataListener<List<SessionModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IRequestHost f32830a;
        final /* synthetic */ ImageView b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SessionModel f32831c;

        AnonymousClass1(IRequestHost iRequestHost, ImageView imageView, SessionModel sessionModel) {
            this.f32830a = iRequestHost;
            this.b = imageView;
            this.f32831c = sessionModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(IRequestHost iRequestHost, ImageView imageView, List list, SessionModel sessionModel) {
            int i;
            if (iRequestHost == null || !iRequestHost.isActive()) {
                return;
            }
            int i2 = 0;
            if (imageView.isSelected()) {
                imageView.setSelected(false);
                sessionModel.lieTop = 0;
                ChatManager.getInstance().updateSessionLieTop(sessionModel.sessionType, sessionModel.sessionId, sessionModel.lieTop);
                return;
            }
            Iterator it = list.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i = i2;
                if (((SessionModel) it.next()).lieTop == 1) {
                    i = i2 + 1;
                }
                i2 = i;
                if (i == 3) {
                    EventTrackMessage.a(MessageProtos.Event.MSG_TO_UP_MAX_SHOW);
                    ToastUtils.a(imageView.getContext().getString(R.string.msg_lie_top_max));
                    break;
                }
            }
            if (i < 3) {
                imageView.setSelected(true);
                sessionModel.lieTop = 1;
                ChatManager.getInstance().updateSessionLieTop(sessionModel.sessionType, sessionModel.sessionId, sessionModel.lieTop);
            }
        }

        @Override // com.blued.android.chat.listener.FetchDataListener
        /* renamed from: a */
        public void onFetchData(final List<SessionModel> list) {
            Handler n = AppInfo.n();
            final IRequestHost iRequestHost = this.f32830a;
            final ImageView imageView = this.b;
            final SessionModel sessionModel = this.f32831c;
            n.post(new Runnable() { // from class: com.soft.blued.ui.msg_group.utils.-$$Lambda$GroupUtil$1$u67Zv5dxAzjfw23vxf2ZTYN4Z5k
                @Override // java.lang.Runnable
                public final void run() {
                    GroupUtil.AnonymousClass1.a(IRequestHost.this, imageView, list, sessionModel);
                }
            });
        }
    }

    public static int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = i == 1 ? 1 : 0;
        int i6 = i2 == 1 ? 1 : 0;
        if (i3 == 1) {
            i4 = 1;
        }
        return b(i5, i6, i4);
    }

    public static ReportJsonModel a(List<ChattingModel> list, ChattingModel chattingModel) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int indexOf = list.indexOf(chattingModel);
        ReportJsonModel reportJsonModel = new ReportJsonModel();
        reportJsonModel.group_id = chattingModel.sessionId;
        reportJsonModel.report_uid = chattingModel.fromId;
        reportJsonModel.contexts = new ArrayList();
        a(reportJsonModel.contexts, chattingModel, chattingModel, false);
        if (indexOf >= 0) {
            int i = indexOf;
            while (true) {
                int i2 = i - 1;
                if (i2 < 0 || reportJsonModel.contexts.size() > 5) {
                    break;
                }
                ChattingModel chattingModel2 = list.get(i2);
                if (chattingModel2.msgType == 1 || chattingModel2.msgType == 2 || chattingModel2.msgType == 5 || chattingModel2.msgType == 3) {
                    a(reportJsonModel.contexts, chattingModel2, chattingModel, true);
                }
                i = i2;
            }
            int i3 = indexOf;
            while (true) {
                int i4 = i3 + 1;
                if (i4 >= list.size()) {
                    break;
                } else if (reportJsonModel.contexts.size() > 10) {
                    return reportJsonModel;
                } else {
                    ChattingModel chattingModel3 = list.get(i4);
                    if (chattingModel3.msgType == 1 || chattingModel3.msgType == 2 || chattingModel3.msgType == 5 || chattingModel3.msgType == 3) {
                        a(reportJsonModel.contexts, chattingModel3, chattingModel, false);
                    }
                    i3 = i4;
                }
            }
        }
        return reportJsonModel;
    }

    public static String a(ChattingModel chattingModel, boolean z, String str) {
        return z ? IMV4Method.a(chattingModel.fromId) == 1 ? chattingModel.fromAvatar : UserInfo.getInstance().getLoginUserInfo().getAvatar() : IMV4Method.a(chattingModel.fromId) == 1 ? str : UserInfo.getInstance().getLoginUserInfo().getAvatar();
    }

    public static String a(GroupInfoModel groupInfoModel) {
        String str = groupInfoModel.announcement;
        String str2 = str;
        if (groupInfoModel.type == 4) {
            str2 = str;
            if (groupInfoModel.event != null) {
                str2 = str;
                if (!TextUtils.isEmpty(groupInfoModel.event.announcement)) {
                    if (TextUtils.isEmpty(str)) {
                        str2 = a(groupInfoModel.event.announcement);
                    } else {
                        str2 = str + " | " + a(groupInfoModel.event.announcement);
                    }
                }
            }
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        }
        return str3;
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("$", "");
    }

    public static String a(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(d(num.intValue()));
            sb.append("、");
        }
        String sb2 = sb.toString();
        return sb2.length() > 1 ? sb2.substring(0, sb2.length() - 1) : "";
    }

    public static void a() {
        MsgGroupHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<GroupConfigModel>>(null) { // from class: com.soft.blued.ui.msg_group.utils.GroupUtil.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupConfigModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    final GroupConfigModel groupConfigModel = bluedEntityA.data.get(0);
                    if (groupConfigModel.tips_interval != 0) {
                        GroupUtil.f32828a = groupConfigModel.tips_interval;
                    }
                    GroupUtil.b = groupConfigModel.create == 1;
                    GroupUtil.f32829c = groupConfigModel.share == 1;
                    BluedConstant.f28239a = groupConfigModel.group_open == 0;
                    boolean z = false;
                    if (groupConfigModel.group_more == 0) {
                        z = true;
                    }
                    BluedConstant.b = z;
                    if (groupConfigModel.groups != null) {
                        UserInfo.getInstance().getLoginUserInfo().setGroupsCount(groupConfigModel.groups.size() + "");
                    }
                    if (groupConfigModel.groups == null || groupConfigModel.groups.size() <= 0) {
                        return;
                    }
                    ChatManager.getInstance().getSessionModelMap(new FetchDataListener<Map<String, SessionModel>>() { // from class: com.soft.blued.ui.msg_group.utils.GroupUtil.2.1
                        @Override // com.blued.android.chat.listener.FetchDataListener
                        /* renamed from: a */
                        public void onFetchData(Map<String, SessionModel> map) {
                            SessionModel sessionModel;
                            ArrayList<GroupInfoModel> arrayList = new ArrayList();
                            for (GroupInfoModel groupInfoModel : groupConfigModel.groups) {
                                long j = groupInfoModel.group_id;
                                if (map == null || (sessionModel = map.get(SessionHeader.getSessionKey(3, j))) == null || sessionModel.sessionSettingModel == null) {
                                    arrayList.add(groupInfoModel);
                                } else {
                                    SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
                                    sessionSettingModel.setRemindAudio(GroupUtil.a(groupInfoModel.message_is_mute, groupInfoModel.at_message_is_mute, groupInfoModel.notice_is_mute));
                                    sessionSettingModel.is_super = groupInfoModel.is_super;
                                    sessionSettingModel.group_status = groupInfoModel.group_status;
                                    sessionSettingModel.setGroupCreateId(groupInfoModel.group_uid);
                                    ChatManager.getInstance().setSessionSetting((short) 3, j, sessionSettingModel);
                                }
                            }
                            for (GroupInfoModel groupInfoModel2 : arrayList) {
                                long j2 = groupInfoModel2.group_id;
                                SessionSettingModel sessionSettingModel2 = new SessionSettingModel();
                                sessionSettingModel2.setRemindAudio(GroupUtil.a(groupInfoModel2.message_is_mute, groupInfoModel2.at_message_is_mute, groupInfoModel2.notice_is_mute));
                                sessionSettingModel2.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                                sessionSettingModel2.setSessionId(j2);
                                sessionSettingModel2.setSessionType((short) 3);
                                sessionSettingModel2.is_super = groupInfoModel2.is_super;
                                sessionSettingModel2.group_status = groupInfoModel2.group_status;
                                sessionSettingModel2.setGroupCreateId(groupInfoModel2.group_uid);
                                ChatManager.getInstance().setSessionSetting((short) 3, j2, sessionSettingModel2);
                            }
                        }
                    });
                }
            }
        });
    }

    public static void a(Context context) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.f(2131101766).a(context.getString(R.string.group_info_auditing)).b(context.getString(R.string.group_info_auditing_hint)).a((View) null).a(context.getString(R.string.group_ok), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.utils.GroupUtil.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                dialogInterface.dismiss();
            }
        }).b((CharSequence) null, (DialogInterface.OnClickListener) null).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a2 = builder.a();
        a2.setCanceledOnTouchOutside(true);
        a2.show();
    }

    public static void a(Context context, String str, String str2) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.i(ContextCompat.getColor(context, 2131101766)).a(str).b(str2).a((View) null).a(context.getString(R.string.group_ok), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.utils.GroupUtil.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                dialogInterface.dismiss();
            }
        }).b((CharSequence) null, (DialogInterface.OnClickListener) null).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a2 = builder.a();
        a2.setCanceledOnTouchOutside(true);
        a2.show();
    }

    public static void a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        CommonAlertDialog.a(context, str, str2, AppUtils.a((int) R.string.group_ok), onClickListener, (DialogInterface.OnDismissListener) null, 0);
    }

    public static void a(TextView textView, int i) {
        a(textView, i, true);
    }

    public static void a(TextView textView, int i, int i2) {
        if (i2 == 4 && i == 1) {
            textView.setText(textView.getContext().getString(R.string.group_to_be_frozen));
            textView.setVisibility(0);
        } else if (i2 != 5) {
            textView.setVisibility(8);
        } else {
            textView.setText(textView.getContext().getString(R.string.group_has_been_frozen));
            textView.setVisibility(0);
        }
    }

    public static void a(TextView textView, int i, boolean z) {
        textView.setVisibility(0);
        if (i == 1) {
            textView.setText(textView.getContext().getString(R.string.group_member_role));
            if (textView instanceof ShapeTextView) {
                ShapeTextView shapeTextView = (ShapeTextView) textView;
                ShapeHelper.b(shapeTextView, 2131101115);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131099863);
            }
        } else if (i != 2) {
            if (z) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(4);
            }
        } else {
            textView.setText(textView.getContext().getString(R.string.group_admin_list));
            if (textView instanceof ShapeTextView) {
                ShapeTextView shapeTextView2 = (ShapeTextView) textView;
                ShapeHelper.b(shapeTextView2, 2131101112);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView2, 2131101766);
            }
        }
    }

    public static void a(TextView textView, TextView textView2, int i) {
        if (i == 1) {
            textView.setVisibility(0);
            textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), 2131102251));
            return;
        }
        textView.setVisibility(8);
        textView2.setTextColor(BluedSkinUtils.a(textView2.getContext(), 2131102254));
    }

    public static void a(TextView textView, UserBasicModel userBasicModel) {
        if (!TextUtils.isEmpty(userBasicModel.note)) {
            textView.setText(userBasicModel.note);
        } else if (TextUtils.isEmpty(userBasicModel.name)) {
            textView.setText("");
        } else {
            textView.setText(userBasicModel.name);
        }
    }

    public static void a(SessionModel sessionModel, ImageView imageView, IRequestHost iRequestHost) {
        ChatManager.getInstance().getSessionModelList(new AnonymousClass1(iRequestHost, imageView, sessionModel));
    }

    public static void a(IRequestHost iRequestHost, String str, ImageView imageView) {
        ImageLoader.a(iRequestHost, AvatarUtils.a(0, str)).c().b(2131237310).a(imageView);
    }

    public static void a(ShapeTextView shapeTextView, GroupInfoModel groupInfoModel, boolean... zArr) {
        shapeTextView.setVisibility(0);
        int i = groupInfoModel.type;
        if (i == 1) {
            shapeTextView.setText(shapeTextView.getContext().getString(R.string.group_type_circle));
            ShapeHelper.b(shapeTextView, R.color.syc_19FF8021);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131099863);
            return;
        }
        if (i != 2) {
            if (i == 4) {
                shapeTextView.setText(shapeTextView.getContext().getString(R.string.group_event_group));
                ShapeHelper.b(shapeTextView, 2131101106);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131101766);
                return;
            } else if (i != 5) {
                if (i == 6) {
                    shapeTextView.setText(shapeTextView.getContext().getString(R.string.group_selected_group));
                    ShapeHelper.b(shapeTextView, R.color.syc_19FF0016);
                    ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, (int) R.color.syc_dark_FF0016);
                    return;
                } else if (groupInfoModel.is_super != 1 || zArr.length <= 0 || !zArr[0]) {
                    shapeTextView.setVisibility(8);
                    return;
                } else {
                    shapeTextView.setText(shapeTextView.getContext().getString(R.string.group_super));
                    ShapeHelper.b(shapeTextView, 2131101117);
                    ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131102170);
                    return;
                }
            }
        }
        shapeTextView.setText(shapeTextView.getContext().getString(R.string.group_type_fans));
        ShapeHelper.b(shapeTextView, R.color.syc_19583DFF);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131102357);
    }

    public static void a(GroupInfoModel groupInfoModel, TextView textView) {
        if (groupInfoModel == null || textView == null) {
            return;
        }
        textView.setText(groupInfoModel.group_title);
        textView.setTextColor(BluedSkinUtils.a(textView.getContext(), groupInfoModel.is_super == 1 ? 2131102251 : 2131102254));
    }

    public static void a(final GroupJoinView groupJoinView, int i, final int i2, final List<GroupInfoModel> list, final IRequestHost iRequestHost) {
        if (BluedConstant.f28239a || i == 0 || list == null || list.size() == 0) {
            groupJoinView.setVisibility(8);
            return;
        }
        groupJoinView.a();
        groupJoinView.setVisibility(0);
        groupJoinView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.utils.GroupUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                List list2 = List.this;
                if (list2 == null || list2.size() != 1) {
                    new CircleGroupListPop(groupJoinView.getContext(), List.this, i2, iRequestHost).a(groupJoinView.getContext());
                    return;
                }
                Context context = groupJoinView.getContext();
                GroupInfoFragment.a(context, ((GroupInfoModel) List.this.get(0)).group_id + "", (GroupInfoModel) List.this.get(0), SocialNetWorkProtos.SourceType.CIRCLE);
            }
        });
    }

    public static void a(Object obj, String str, Object obj2) throws Exception {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void a(final String str, final long j, IRequestHost iRequestHost) {
        HashMap hashMap = new HashMap();
        hashMap.put("announcement", str);
        MsgGroupHttpUtils.a(iRequestHost, j + "", hashMap, new BluedUIHttpResponse<BluedEntityA>(iRequestHost) { // from class: com.soft.blued.ui.msg_group.utils.GroupUtil.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    AppMethods.a((CharSequence) AppUtils.a((int) R.string.group_announcement_submitted));
                    LiveEventBus.get("update_announcement", UpdateAnnouncementEvent.class).post(new UpdateAnnouncementEvent(j, str));
                }
            }
        });
    }

    public static void a(List<ReportJsonModel.ReportMsgContent> list, ChattingModel chattingModel, ChattingModel chattingModel2, boolean z) {
        ReportJsonModel.ReportMsgContent reportMsgContent = new ReportJsonModel.ReportMsgContent();
        reportMsgContent.contents = chattingModel.msgContent;
        reportMsgContent.createdAt = chattingModel.msgTimestamp;
        reportMsgContent.uid = chattingModel.fromId;
        reportMsgContent.messageId = chattingModel.msgId;
        reportMsgContent.setMsgTypeString(chattingModel.msgType);
        try {
            if (chattingModel.msgType == 3) {
                reportMsgContent.url = chattingModel.msgContent.split(",,")[0];
            } else {
                if (chattingModel.msgType != 24 && chattingModel.msgType != 25) {
                    reportMsgContent.url = chattingModel.msgContent;
                }
                try {
                    reportMsgContent.url = AesCrypto.e(chattingModel.msgContent.endsWith("destroy") ? chattingModel.msgContent.substring(0, chattingModel.msgContent.lastIndexOf("|")) : chattingModel.msgContent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
        }
        if (chattingModel.msgId == chattingModel2.msgId) {
            reportMsgContent.report = 1;
        }
        if (z) {
            list.add(0, reportMsgContent);
        } else {
            list.add(reportMsgContent);
        }
    }

    public static boolean a(int i) {
        return (i & 1) != 0;
    }

    private static int b(int i, int i2, int i3) {
        return i | (i2 << 1) | (i3 << 2);
    }

    public static void b(IRequestHost iRequestHost, String str, ImageView imageView) {
        ImageLoader.a(iRequestHost, str).b(R.drawable.group_default_head).c().a(imageView);
    }

    public static void b(List<GroupInfoModel> list) {
        if (list == null) {
            return;
        }
        for (GroupInfoModel groupInfoModel : list) {
            if (groupInfoModel.group_role != 0 && groupInfoModel.group_role != 1) {
                groupInfoModel.group_role = 0;
                return;
            }
        }
    }

    public static boolean b(int i) {
        return (i & 2) != 0;
    }

    public static boolean c(int i) {
        return (i & 4) != 0;
    }

    public static String d(int i) {
        switch (i) {
            case 0:
                return AppInfo.d().getResources().getString(2131891208);
            case 1:
                return AppInfo.d().getResources().getString(2131886298);
            case 2:
                return AppInfo.d().getResources().getString(2131891289);
            case 3:
            default:
                return "";
            case 4:
                return AppInfo.d().getResources().getString(2131891288);
            case 5:
                return AppInfo.d().getResources().getString(2131887538);
            case 6:
                return AppInfo.d().getResources().getString(2131886996);
            case 7:
                return AppInfo.d().getResources().getString(2131887348);
            case 8:
                return AppInfo.d().getResources().getString(2131891260);
            case 9:
                return AppInfo.d().getResources().getString(2131890631);
        }
    }
}
