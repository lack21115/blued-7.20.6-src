package com.soft.blued.ui.msg.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.soft.blued.R;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceNumberListAdapter.class */
public final class ServiceNumberListAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f18505a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceNumberListAdapter(IRequestHost iRequestHost) {
        super((int) R.layout.item_msg_friend_list);
        Intrinsics.e(iRequestHost, "requestHost");
        this.f18505a = iRequestHost;
    }

    public final void a(TextView textView, SessionModel sessionModel) {
        Intrinsics.e(textView, "tv_content");
        Intrinsics.e(sessionModel, "item");
        String str = sessionModel.lastDraft;
        if (!TextUtils.isEmpty(str)) {
            String string = this.mContext.getResources().getString(R.string.msg_draft);
            Intrinsics.c(string, "mContext.resources.getString(R.string.msg_draft)");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Intrinsics.a(string, str));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131101201)), 0, string.length(), 33);
            textView.setText(StringUtils.a(spannableStringBuilder, (int) textView.getTextSize(), 0));
        } else if (MsgType.getClassify(sessionModel.lastMsgType) == 1 || sessionModel.lastMsgType == 8) {
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
            } else {
                textView.setText(sessionModel.lastMsgContent);
            }
        } else if (MsgType.getGroupOperationNotifyType(sessionModel.lastMsgType) == 2) {
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
            } else {
                textView.setText(sessionModel.lastMsgContent);
            }
        } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 5) {
            if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                textView.setText("");
            } else if (TextUtils.isEmpty(sessionModel.lastMsgFromNickname)) {
                textView.setText(sessionModel.lastMsgContent);
            } else {
                textView.setText(sessionModel.lastMsgFromNickname + ": " + ((Object) sessionModel.lastMsgContent));
            }
        } else {
            short s = sessionModel.lastMsgType;
            if (s == 1) {
                if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                    textView.setText("");
                } else {
                    textView.setText(StringUtils.a(StringUtils.a(sessionModel.lastMsgContent, false, true, true, ""), (int) textView.getTextSize()));
                }
            } else if (s == 68) {
                if (TextUtils.isEmpty(sessionModel.lastMsgContent)) {
                    textView.setText("");
                } else {
                    textView.setText(StringUtils.a(sessionModel.lastMsgContent, false, true, true, ""));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, SessionModel sessionModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(sessionModel, "item");
        ((TextView) baseViewHolder.getView(R.id.msg_friend_item_name)).setMaxWidth(DensityUtils.a(this.mContext, 120.0f));
        baseViewHolder.setText(R.id.msg_friend_item_name, sessionModel.nickName);
        TextView textView = (TextView) baseViewHolder.getView(R.id.msg_friend_item_name);
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = sessionModel.vipGrade;
        userBasicModel.is_vip_annual = sessionModel.vipAnnual;
        userBasicModel.is_hide_vip_look = sessionModel.hideVipLook;
        userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
        UserRelationshipUtils.a(this.mContext, textView, userBasicModel);
        View view = baseViewHolder.getView(R.id.msg_friend_item_avatar);
        Intrinsics.c(view, "helper.getView(R.id.msg_friend_item_avatar)");
        ImageLoader.a(this.f18505a, sessionModel.avatar).b(2131237310).c().a((ImageView) view);
        View view2 = baseViewHolder.getView(R.id.msg_friend_item_avatar_v);
        Intrinsics.c(view2, "helper.getView(R.id.msg_friend_item_avatar_v)");
        UserInfoHelper.a((ImageView) view2, sessionModel.vBadge, 3, 1, this.mContext.getResources().getColor(2131101191));
        View view3 = baseViewHolder.getView(2131364726);
        Intrinsics.c(view3, "helper.getView(R.id.img_vip_icon)");
        ImageView imageView = (ImageView) view3;
        UserBasicModel userBasicModel2 = new UserBasicModel();
        userBasicModel2.vip_grade = sessionModel.vipGrade;
        userBasicModel2.is_vip_annual = sessionModel.vipAnnual;
        userBasicModel2.is_hide_vip_look = sessionModel.hideVipLook;
        userBasicModel2.vip_exp_lvl = sessionModel.vipExpLvl;
        UserRelationshipUtils.a(imageView, userBasicModel2);
        SessionSettingModel sessionSettingModel = sessionModel.sessionSettingModel;
        if (sessionSettingModel == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.db.model.SessionSettingModel");
        }
        baseViewHolder.setGone(R.id.msg_group_remind_soundoff, sessionSettingModel.getRemindAudio() == 1);
        baseViewHolder.setText(R.id.msg_friend_item_time, MsgCommonUtils.a(this.mContext, sessionModel.lastMsgTime));
        baseViewHolder.setTextColor(R.id.msg_friend_item_content, this.mContext.getResources().getColor(2131102263));
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.msg_friend_item_content);
        Intrinsics.c(textView2, RemoteMessageConst.MessageBody.MSG_CONTENT);
        a(textView2, sessionModel);
        baseViewHolder.setGone(R.id.iv_secret, false);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.msg_friend_item_status);
        if (!TextUtils.isEmpty(sessionModel.lastDraft) || sessionModel.lastMsgType == 52 || sessionModel.lastMsgType == 68) {
            imageView2.setVisibility(8);
        } else {
            short s = sessionModel.lastMsgStateCode;
            if (s == 7) {
                imageView2.setImageResource(R.drawable.chat_fail_resend);
                imageView2.setVisibility(0);
            } else if (s == 1) {
                imageView2.setImageResource(R.drawable.icon_msg_sending);
                imageView2.setVisibility(0);
            } else if (s == 6) {
                imageView2.setImageResource(R.drawable.chat_fail_resend);
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
        }
        baseViewHolder.setGone(R.id.tv_at_me, false);
    }
}
