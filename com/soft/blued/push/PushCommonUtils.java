package com.soft.blued.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.log.track.EventTrackSystemAuthority;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.net.URLDecoder;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushCommonUtils.class */
public class PushCommonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29737a = PushCommonUtils.class.getSimpleName();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushCommonUtils$RedirectType.class */
    public interface RedirectType {
    }

    public static void a(Context context, PushMsgModel pushMsgModel) {
        if (pushMsgModel == null || pushMsgModel.extra == null) {
            HomeArgumentHelper.a(context, "find", (Bundle) null);
            return;
        }
        LiveMsgShareEntity liveMsgShareEntity = pushMsgModel.extra;
        if (!TextUtils.isEmpty(liveMsgShareEntity.link)) {
            HomeArgumentHelper.a(context, "find", ChatHelperV4.a().a(liveMsgShareEntity));
            WebViewShowInfoFragment.show(context, liveMsgShareEntity.link, -1);
        } else if (liveMsgShareEntity.redirect == 1 || liveMsgShareEntity.redirect == 4) {
            HomeArgumentHelper.a(context, "msg", ChatHelperV4.a().a(liveMsgShareEntity));
            String str = f29737a;
            Log.e(str, "doRedirectPush" + pushMsgModel);
        } else if (liveMsgShareEntity.redirect == 2) {
            HomeArgumentHelper.a(context, "mine", ChatHelperV4.a().a(liveMsgShareEntity));
        } else if (liveMsgShareEntity.redirect == 3) {
            HomeArgumentHelper.a(context, IAdInterListener.AdProdType.PRODUCT_FEEDS, ChatHelperV4.a().a(liveMsgShareEntity));
            InstantLog.d("msg_push", "feed_followed");
            EventTrackMessage.c(MessageProtos.Event.MSG_PUSH, "feed_followed");
        } else if (liveMsgShareEntity.redirect == 5) {
            HomeArgumentHelper.a(context, "find", ChatHelperV4.a().a(liveMsgShareEntity));
        } else if (liveMsgShareEntity.redirect == 6) {
            HomeArgumentHelper.a(context, "live", ChatHelperV4.a().a(liveMsgShareEntity));
        } else if (liveMsgShareEntity.redirect == 7) {
            ChannelModel channelModel = new ChannelModel();
            if (liveMsgShareEntity.room_type == 2) {
                channelModel.callType = 2;
            } else if (liveMsgShareEntity.room_type == 1) {
                channelModel.callType = 3;
            } else {
                HomeArgumentHelper.a(context, "msg", (Bundle) null);
            }
            channelModel.channelId = liveMsgShareEntity.room_id;
            channelModel.remoteUid = Integer.parseInt(liveMsgShareEntity.uid);
            channelModel.remoteUserHead = liveMsgShareEntity.avatar;
            channelModel.remoteUserName = liveMsgShareEntity.name;
            DialogSkipFragment.a(context, channelModel);
        } else if (liveMsgShareEntity.redirect == 9) {
            HomeArgumentHelper.a(context, IAdInterListener.AdProdType.PRODUCT_FEEDS, ChatHelperV4.a().a(liveMsgShareEntity));
        } else {
            HomeArgumentHelper.a(context, "find", (Bundle) null);
        }
        a(pushMsgModel);
    }

    private static void a(PushMsgModel pushMsgModel) {
        String str;
        if (pushMsgModel == null || pushMsgModel.extra == null) {
            return;
        }
        if (StringUtils.d(pushMsgModel.extra.link)) {
            str = ((int) pushMsgModel.session_type) + "&" + pushMsgModel.session_id + "&" + pushMsgModel.extra.push_type;
        } else {
            String str2 = pushMsgModel.extra.link;
            try {
                str = URLDecoder.decode(pushMsgModel.extra.link, "UTF-8");
            } catch (Exception e) {
                str = str2;
            }
        }
        InstantLog.i("push_msg_navigate", str);
        EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.PUSH_CLICK, str);
    }
}
