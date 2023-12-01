package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgBase.class */
public abstract class FitemMsgBase extends FreedomItem {
    private final LiveChattingModel b;
    private final String c;
    private Pattern d;

    public FitemMsgBase(LiveChattingModel msg) {
        Intrinsics.e(msg, "msg");
        this.b = msg;
        this.c = "@\\(word:([\\s\\S]*?)\\)";
        this.d = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(long j) {
        BaseFragment baseFragment;
        if (e().fromId > 0 && (baseFragment = (BaseFragment) this.a.a.a("BaseFragment", (String) null)) != null) {
            LiveMsgReportModel liveMsgReportModel = new LiveMsgReportModel();
            if (LiveRoomManager.a().p() != null) {
                liveMsgReportModel.lid = LiveRoomManager.a().e();
            }
            liveMsgReportModel.uid = String.valueOf(j);
            liveMsgReportModel.reportMsg = e().msgContent;
            liveMsgReportModel.time = String.valueOf(e().msgTimestamp / 1000);
            UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
            userCardDialogFragment.a(liveMsgReportModel.uid, liveMsgReportModel);
            FragmentManager fragmentManager = baseFragment.getFragmentManager();
            if (fragmentManager == null) {
                return;
            }
            userCardDialogFragment.show(fragmentManager, "userCardDialog");
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        i();
    }

    public LiveChattingModel e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        TextView textView = (TextView) this.a.a(R.id.live_msg_content_text);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgBase$rLbTpiuiRb8K-f7xvojpPL3oc6k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemMsgBase.a(view);
                }
            });
            textView.getPaint().setFakeBoldText(true);
            textView.setTag(R.id.live_msg_span, null);
        }
        this.a.a(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgBase$MJD3WZg3rAs6iRnDmTQAhOsZWtI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgBase.b(view);
            }
        });
        FrameLayout frameLayout = (FrameLayout) this.a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
    }

    public final boolean j() {
        if (e().msgType == 51) {
            return true;
        }
        boolean z = false;
        if (e().msgType == 27) {
            z = false;
            if (this instanceof FitemMsgText) {
                FitemMsgText fitemMsgText = (FitemMsgText) this;
                String q = fitemMsgText.q();
                boolean z2 = true;
                if (q != null) {
                    z2 = q.length() == 0;
                }
                if (!z2) {
                    return false;
                }
                if (fitemMsgText.r() && o() != null) {
                    return false;
                }
                z = TextUtils.isEmpty(fitemMsgText.s());
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String k() {
        String str = e().fromNickName;
        String a = LiveCloakingUtil.a(str == null || str.length() == 0 ? "" : e().fromNickName, e().fromPrivilege);
        Intrinsics.c(a, "nicknameCloaking(\n      …g.fromPrivilege\n        )");
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        if (LiveRoomManager.a().p().profile.getUid() == LiveRoomInfo.a().g() || e().fromPrivilege != 1) {
            a(e().fromId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LiveFansLevelModel m() {
        LiveFansLevelModel liveFansLevelModel = new LiveFansLevelModel();
        if (e().msgMapExtra != null) {
            liveFansLevelModel.fan_club_name = MsgPackHelper.getStringValue(e().msgMapExtra, "fan_club_name");
            liveFansLevelModel.fan_club_level = MsgPackHelper.getIntValue(e().msgMapExtra, "fan_club_level");
            liveFansLevelModel.in_fan_club = MsgPackHelper.getIntValue(e().msgMapExtra, "in_fan_club");
            liveFansLevelModel.fans_status = MsgPackHelper.getIntValue(e().msgMapExtra, "fans_status");
        }
        return liveFansLevelModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LiveChatBadgeModel n() {
        String stringValue;
        Integer chat_badge_length;
        if (e().msgMapExtra == null || (stringValue = MsgPackHelper.getStringValue(e().msgMapExtra, "chat_badge_url")) == null) {
            return null;
        }
        stringValue.length();
        LiveChatBadgeModel liveChatBadgeModel = new LiveChatBadgeModel();
        liveChatBadgeModel.setChat_badge_url(stringValue);
        liveChatBadgeModel.setChat_badge_height(Integer.valueOf(MsgPackHelper.getIntValue(e().msgMapExtra, "chat_badge_height")));
        liveChatBadgeModel.setChat_badge_length(Integer.valueOf(MsgPackHelper.getIntValue(e().msgMapExtra, "chat_badge_length")));
        Integer chat_badge_height = liveChatBadgeModel.getChat_badge_height();
        if ((chat_badge_height != null && chat_badge_height.intValue() == 0) || ((chat_badge_length = liveChatBadgeModel.getChat_badge_length()) != null && chat_badge_length.intValue() == 0)) {
            return null;
        }
        return liveChatBadgeModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LiveNobleModel o() {
        if (e().nobleModel == null) {
            return null;
        }
        String nameplate_img = e().nobleModel.getNameplate_img();
        if (nameplate_img == null || nameplate_img.length() == 0) {
            return null;
        }
        Integer nameplate_img_width = e().nobleModel.getNameplate_img_width();
        if (nameplate_img_width != null && nameplate_img_width.intValue() == 0) {
            return null;
        }
        Integer nameplate_img_height = e().nobleModel.getNameplate_img_height();
        if (nameplate_img_height != null && nameplate_img_height.intValue() == 0) {
            return null;
        }
        return e().nobleModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String p() {
        return e().vip_frame;
    }
}
