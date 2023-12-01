package com.soft.blued.ui.msg.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgContentTranslatedEntity;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.utils.BluedPreferences;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/MessageChatMethod.class */
public class MessageChatMethod {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/MessageChatMethod$VoiceTurnText.class */
    public static class VoiceTurnText {
        public String text;

        private VoiceTurnText() {
        }
    }

    public static void a(Context context, ChattingModel chattingModel) {
        MessageProtos.Event event = MessageProtos.Event.MSG_CLICK_BUBBLE_CLICK;
        EventTrackMessage.a(event, (MessageProtos.StrangerSource) null, chattingModel.fromId + "");
        VipBubbleFragment.a(context, 0, chattingModel.isFromSelf() ? "chat_msg_bubble_owner" : "chat_msg_bubble_guest");
    }

    public static void a(final Context context, final ChattingModel chattingModel, IMsgChatAdapterCallback iMsgChatAdapterCallback) {
        a(chattingModel);
        if (!NetworkUtils.b()) {
            CommonAlertDialog.a(context, (View) null, (String) null, context.getResources().getString(R.string.retraction_failed), context.getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                }
            }, (DialogInterface.OnCancelListener) null, true);
        } else if (a(chattingModel, iMsgChatAdapterCallback)) {
            ChatManager.getInstance().retractOneMessage(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, (short) chattingModel.isMatchMsg, new RetractionListener() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.1
                public void onMsgRetractedTimeout() {
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (((Activity) context).isFinishing() || ((Activity) context).isDestroyed()) {
                                return;
                            }
                            CommonAlertDialog.a(context, (View) null, (String) null, context.getResources().getString(R.string.send_out_time), context.getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.1.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Tracker.onClick(dialogInterface, i);
                                }
                            }, (DialogInterface.OnCancelListener) null, true);
                        }
                    });
                }

                public void onRetractFailed() {
                }

                public void onRetractSuccess() {
                    if (chattingModel.sessionType != 3 || chattingModel.isFromSelf()) {
                        return;
                    }
                    ChatManager.getInstance().updateMsgState(chattingModel, (short) 10);
                }
            });
        } else {
            CommonAlertDialog.a(context, (View) null, (String) null, context.getResources().getString(R.string.send_out_time), context.getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                }
            }, (DialogInterface.OnCancelListener) null, true);
        }
    }

    public static void a(Context context, ChattingModel chattingModel, List<ChattingModel> list, IMsgChatAdapterCallback iMsgChatAdapterCallback, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        MsgCommonUtils.a(context, list, chattingModel, chattingModel.fromId + "", iMsgChatAdapterCallback.c() ? 7 : 6, 1, iMsgChatAdapterOperationCallback.getFragmentActive());
    }

    public static void a(final View view, final TextView textView, final View view2, final ChattingModel chattingModel, final Set<Long> set, final IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback, final IRequestHost iRequestHost) {
        EventTrackMessage.e(MessageProtos.Event.MSG_VOICE_TRANSFER_WORD_CLICK, String.valueOf(chattingModel.fromId));
        if (!BluedPreferences.ed()) {
            b(view, textView, view2, chattingModel, set, iMsgChatAdapterOperationCallback, iRequestHost);
            return;
        }
        BluedPreferences.ee();
        CommonAlertDialog.a(view.getContext(), AppUtils.a((int) R.string.turn_text_tip_title), AppUtils.a((int) R.string.turn_text_tip), AppUtils.a((int) R.string.map_ok), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MessageChatMethod.b(view, textView, view2, chattingModel, set, iMsgChatAdapterOperationCallback, iRequestHost);
            }
        }, 0);
    }

    public static void a(View view, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback, ChattingModel chattingModel) {
        view.setVisibility(8);
        g(chattingModel, iMsgChatAdapterOperationCallback);
    }

    private static void a(ChattingModel chattingModel) {
        if (chattingModel.sessionType != 2) {
            return;
        }
        short s = chattingModel.msgType;
    }

    public static void a(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        if (TextUtils.isEmpty(chattingModel.msgTextTranslateContent)) {
            a(chattingModel.msgContent, chattingModel, iMsgChatAdapterOperationCallback);
        } else if (chattingModel.msgTextTranslateIsShow == 1) {
            g(chattingModel, iMsgChatAdapterOperationCallback);
        } else {
            f(chattingModel, iMsgChatAdapterOperationCallback);
        }
    }

    private static void a(String str, final ChattingModel chattingModel, final IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        String str2;
        if (TextUtils.isEmpty(str) || chattingModel == null) {
            return;
        }
        try {
            str2 = URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        d(chattingModel, iMsgChatAdapterOperationCallback);
        ChatHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<MsgContentTranslatedEntity>>() { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.4

            /* renamed from: a  reason: collision with root package name */
            boolean f18735a;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MsgContentTranslatedEntity> bluedEntityA) {
                MsgContentTranslatedEntity msgContentTranslatedEntity;
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (msgContentTranslatedEntity = (MsgContentTranslatedEntity) bluedEntityA.data.get(0)) == null || msgContentTranslatedEntity.trans_result == null || msgContentTranslatedEntity.trans_result.size() <= 0) {
                    return;
                }
                String str3 = msgContentTranslatedEntity.trans_result.get(0).dst;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                MessageChatMethod.b(chattingModel, str3, iMsgChatAdapterOperationCallback);
            }

            public boolean onUIFailure(int i, String str3) {
                this.f18735a = true;
                return super.onUIFailure(i, str3);
            }

            public void onUIFinish() {
                super.onUIFinish();
                if (this.f18735a) {
                    this.f18735a = false;
                    MessageChatMethod.e(chattingModel, iMsgChatAdapterOperationCallback);
                }
            }
        }, str2, (IRequestHost) iMsgChatAdapterOperationCallback.getFragmentActive());
    }

    public static void a(boolean z, short s, long j, int i, TextView textView, String str) {
        if (s == 3 && i == 10) {
            textView.setText(String.format(textView.getContext().getString(R.string.group_admin_retracted), str));
        } else if (z) {
            textView.setText(textView.getContext().getResources().getString(R.string.msg_retraction_self));
        } else {
            String str2 = str;
            if (j < 0) {
                str2 = DateTodayManager.f18714a.c(str);
            }
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.msg_retraction_other), str2));
        }
    }

    public static boolean a(ChattingModel chattingModel, IMsgChatAdapterCallback iMsgChatAdapterCallback) {
        boolean z = false;
        if (chattingModel.isFromSelf()) {
            if (chattingModel.msgLocalId == 0) {
                if ((System.currentTimeMillis() - chattingModel.msgTimestamp) / 60000 < 2) {
                    z = true;
                }
                return z;
            }
            return false;
        } else if (iMsgChatAdapterCallback == null || !iMsgChatAdapterCallback.c() || chattingModel.fromId == iMsgChatAdapterCallback.a()) {
            return false;
        } else {
            return iMsgChatAdapterCallback.b() == 1 || iMsgChatAdapterCallback.b() == 2;
        }
    }

    public static void b(final View view, final TextView textView, final View view2, final ChattingModel chattingModel, final Set<Long> set, final IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback, IRequestHost iRequestHost) {
        if (!TextUtils.isEmpty(chattingModel.msgTextTranslateContent)) {
            view.setVisibility(0);
            textView.setText(chattingModel.msgTextTranslateContent);
            set.add(Long.valueOf(chattingModel.msgId));
            f(chattingModel, iMsgChatAdapterOperationCallback);
        } else if (chattingModel.msgStateCode == 6 || !NetworkUtils.b()) {
            AppMethods.d((int) R.string.turn_text_error);
        } else {
            d(chattingModel, null);
            ChatHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VoiceTurnText>>(iRequestHost) { // from class: com.soft.blued.ui.msg.manager.MessageChatMethod.6
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<VoiceTurnText> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        return;
                    }
                    String str = ((VoiceTurnText) bluedEntityA.getSingleData()).text;
                    if (TextUtils.isEmpty(str)) {
                        AppMethods.d((int) R.string.turn_text_no_find_content);
                        return;
                    }
                    view.setVisibility(0);
                    textView.setText(str);
                    set.add(Long.valueOf(chattingModel.msgId));
                    MessageChatMethod.b(chattingModel, str, iMsgChatAdapterOperationCallback);
                    if (IMV4Method.a(chattingModel.fromId) != 1 || chattingModel.msgStateCode == 5) {
                        return;
                    }
                    ChatManager.getInstance().updateMsgState(chattingModel, (short) 5);
                }

                public void onUIFinish(boolean z) {
                    super.onUIFinish(z);
                    view2.setVisibility(8);
                }

                public void onUIStart() {
                    super.onUIStart();
                    view2.setVisibility(0);
                }
            }, IMV4Method.a(chattingModel), iRequestHost);
        }
    }

    public static void b(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        iMsgChatAdapterOperationCallback.a(chattingModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ChattingModel chattingModel, String str, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        chattingModel.msgTextTranslateStatus = 2;
        chattingModel.msgTextTranslateIsShow = 1;
        chattingModel.msgTextTranslateContent = str;
        h(chattingModel, iMsgChatAdapterOperationCallback);
    }

    public static boolean b(ChattingModel chattingModel, IMsgChatAdapterCallback iMsgChatAdapterCallback) {
        return (chattingModel.msgType == 24 || chattingModel.msgType == 25) && !chattingModel.isFromSelf();
    }

    private static void d(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        chattingModel.msgTextTranslateStatus = 1;
        chattingModel.msgTextTranslateIsShow = 0;
        h(chattingModel, iMsgChatAdapterOperationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        chattingModel.msgTextTranslateStatus = 0;
        chattingModel.msgTextTranslateIsShow = 0;
        h(chattingModel, iMsgChatAdapterOperationCallback);
    }

    private static void f(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        chattingModel.msgTextTranslateIsShow = 1;
        h(chattingModel, iMsgChatAdapterOperationCallback);
    }

    private static void g(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        chattingModel.msgTextTranslateIsShow = 0;
        h(chattingModel, iMsgChatAdapterOperationCallback);
    }

    private static void h(ChattingModel chattingModel, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback) {
        ChatManager.getInstance().updateMsgOneData(chattingModel);
        if (iMsgChatAdapterOperationCallback != null) {
            iMsgChatAdapterOperationCallback.t();
        }
    }
}
