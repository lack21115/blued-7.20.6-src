package com.soft.blued.ui.msg.adapter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
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
    private final IRequestHost f32195a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceNumberListAdapter(IRequestHost requestHost) {
        super((int) R.layout.item_msg_friend_list);
        Intrinsics.e(requestHost, "requestHost");
        this.f32195a = requestHost;
    }

    public final void a(TextView tv_content, SessionModel item) {
        Intrinsics.e(tv_content, "tv_content");
        Intrinsics.e(item, "item");
        String str = item.lastDraft;
        if (!TextUtils.isEmpty(str)) {
            String string = this.mContext.getResources().getString(R.string.msg_draft);
            Intrinsics.c(string, "mContext.resources.getString(R.string.msg_draft)");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Intrinsics.a(string, (Object) str));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(2131101201)), 0, string.length(), 33);
            tv_content.setText(StringUtils.a(spannableStringBuilder, (int) tv_content.getTextSize(), 0));
        } else if (MsgType.getClassify(item.lastMsgType) == 1 || item.lastMsgType == 8) {
            if (TextUtils.isEmpty(item.lastMsgContent)) {
                tv_content.setText("");
            } else {
                tv_content.setText(item.lastMsgContent);
            }
        } else if (MsgType.getGroupOperationNotifyType(item.lastMsgType) == 2) {
            if (TextUtils.isEmpty(item.lastMsgContent)) {
                tv_content.setText("");
            } else {
                tv_content.setText(item.lastMsgContent);
            }
        } else if (item.sessionType == 1 && item.sessionId == 5) {
            if (TextUtils.isEmpty(item.lastMsgContent)) {
                tv_content.setText("");
            } else if (TextUtils.isEmpty(item.lastMsgFromNickname)) {
                tv_content.setText(item.lastMsgContent);
            } else {
                tv_content.setText(item.lastMsgFromNickname + ": " + ((Object) item.lastMsgContent));
            }
        } else {
            short s = item.lastMsgType;
            if (s == 1) {
                if (TextUtils.isEmpty(item.lastMsgContent)) {
                    tv_content.setText("");
                } else {
                    tv_content.setText(StringUtils.a(StringUtils.a(item.lastMsgContent, false, true, true, ""), (int) tv_content.getTextSize()));
                }
            } else if (s == 68) {
                if (TextUtils.isEmpty(item.lastMsgContent)) {
                    tv_content.setText("");
                } else {
                    tv_content.setText(StringUtils.a(item.lastMsgContent, false, true, true, ""));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, SessionModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ((TextView) helper.getView(R.id.msg_friend_item_name)).setMaxWidth(DensityUtils.a(this.mContext, 120.0f));
        helper.setText(R.id.msg_friend_item_name, item.nickName);
        TextView textView = (TextView) helper.getView(R.id.msg_friend_item_name);
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = item.vipGrade;
        userBasicModel.is_vip_annual = item.vipAnnual;
        userBasicModel.is_hide_vip_look = item.hideVipLook;
        userBasicModel.vip_exp_lvl = item.vipExpLvl;
        UserRelationshipUtils.a(this.mContext, textView, userBasicModel);
        View view = helper.getView(R.id.msg_friend_item_avatar);
        Intrinsics.c(view, "helper.getView(R.id.msg_friend_item_avatar)");
        ImageLoader.a(this.f32195a, item.avatar).b(2131237310).c().a((ImageView) view);
        View view2 = helper.getView(R.id.msg_friend_item_avatar_v);
        Intrinsics.c(view2, "helper.getView(R.id.msg_friend_item_avatar_v)");
        UserInfoHelper.a((ImageView) view2, item.vBadge, 3, 1, this.mContext.getResources().getColor(2131101191));
        View view3 = helper.getView(2131364726);
        Intrinsics.c(view3, "helper.getView(R.id.img_vip_icon)");
        ImageView imageView = (ImageView) view3;
        UserBasicModel userBasicModel2 = new UserBasicModel();
        userBasicModel2.vip_grade = item.vipGrade;
        userBasicModel2.is_vip_annual = item.vipAnnual;
        userBasicModel2.is_hide_vip_look = item.hideVipLook;
        userBasicModel2.vip_exp_lvl = item.vipExpLvl;
        UserRelationshipUtils.a(imageView, userBasicModel2);
        SessionSettingBaseModel sessionSettingBaseModel = item.sessionSettingModel;
        if (sessionSettingBaseModel == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.db.model.SessionSettingModel");
        }
        helper.setGone(R.id.msg_group_remind_soundoff, ((SessionSettingModel) sessionSettingBaseModel).getRemindAudio() == 1);
        helper.setText(R.id.msg_friend_item_time, MsgCommonUtils.a(this.mContext, item.lastMsgTime));
        helper.setTextColor(R.id.msg_friend_item_content, this.mContext.getResources().getColor(2131102263));
        TextView msgContent = (TextView) helper.getView(R.id.msg_friend_item_content);
        Intrinsics.c(msgContent, "msgContent");
        a(msgContent, item);
        helper.setGone(R.id.iv_secret, false);
        ImageView imageView2 = (ImageView) helper.getView(R.id.msg_friend_item_status);
        if (!TextUtils.isEmpty(item.lastDraft) || item.lastMsgType == 52 || item.lastMsgType == 68) {
            imageView2.setVisibility(8);
        } else {
            short s = item.lastMsgStateCode;
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
        helper.setGone(R.id.tv_at_me, false);
    }
}
