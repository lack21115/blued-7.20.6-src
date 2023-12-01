package com.soft.blued.ui.search.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.search.SearchLikeChatFragment;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/adapter/SearchAllAdapter.class */
public class SearchAllAdapter extends BaseQuickAdapter<SearchSessionModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f19462a;
    private String b;

    public SearchAllAdapter(BaseFragment baseFragment) {
        super(R.layout.item_search_all_layout, new ArrayList());
        this.b = "";
        this.f19462a = baseFragment;
    }

    private UserBasicModel a(SessionModel sessionModel) {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = sessionModel.vipGrade;
        userBasicModel.is_vip_annual = sessionModel.vipAnnual;
        userBasicModel.is_hide_vip_look = sessionModel.hideVipLook;
        userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
        return userBasicModel;
    }

    private String a(SessionModel sessionModel, SessionSettingModel sessionSettingModel) {
        String str = sessionModel.nickName;
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        return !TextUtils.isEmpty(sessinoNote) ? sessinoNote : !TextUtils.isEmpty(str) ? str : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SearchSessionModel searchSessionModel) {
        if (searchSessionModel.f19471a > 1) {
            SearchLikeChatFragment.a(this.f19462a.getContext(), this.b, a(searchSessionModel, (SessionSettingModel) searchSessionModel.sessionSettingModel), searchSessionModel.sessionId, searchSessionModel.sessionType, searchSessionModel.avatar, searchSessionModel.vBadge, searchSessionModel.vipGrade, searchSessionModel.vipAnnual, searchSessionModel.vipExpLvl, searchSessionModel.hideVipLook);
        } else if (searchSessionModel.sessionType == 2 && BluedPreferences.av()) {
            a(searchSessionModel, true);
        } else {
            a(searchSessionModel, false);
        }
    }

    private void a(SearchSessionModel searchSessionModel, boolean z) {
        LogData logData = new LogData();
        logData.from = "none";
        ChatHelperV4 a2 = ChatHelperV4.a();
        Context context = this.f19462a.getContext();
        long j = searchSessionModel.sessionId;
        String str = searchSessionModel.nickName;
        String str2 = searchSessionModel.avatar;
        int i = searchSessionModel.vBadge;
        int i2 = searchSessionModel.vipGrade;
        int i3 = searchSessionModel.vipAnnual;
        int i4 = searchSessionModel.vipExpLvl;
        String str3 = searchSessionModel.lastMsgFromDistance + "";
        int i5 = searchSessionModel.sessionType == 3 ? 1 : 0;
        MsgSourceEntity msgSourceEntity = new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "");
        long j2 = -1;
        long j3 = searchSessionModel.f19471a == 0 ? -1L : searchSessionModel.lastMsgId;
        if (searchSessionModel.f19471a != 0) {
            j2 = searchSessionModel.lastMsgLocalId;
        }
        a2.a(context, j, str, str2, i, i2, i3, i4, str3, z, i5, 0, logData, msgSourceEntity, j3, j2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final SearchSessionModel searchSessionModel) {
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.item_view);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.msg_friend_item_avatar_v);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.msg_friend_item_status);
        LinearLayout linearLayout2 = (LinearLayout) baseViewHolder.getView(R.id.msg_content_noread_root);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(2131364726);
        TextView textView = (TextView) baseViewHolder.getView(R.id.msg_friend_item_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_note_name);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.msg_friend_item_content);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.msg_friend_item_time);
        short s = searchSessionModel.lastMsgStateCode;
        if (s == 1) {
            imageView3.setImageResource(R.drawable.icon_msg_sending);
            imageView3.setVisibility(0);
        } else if (s == 6) {
            imageView3.setImageResource(R.drawable.icon_msg_fail);
            imageView3.setVisibility(0);
        } else if (s != 7) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setImageResource(R.drawable.chat_fail_resend);
            imageView3.setVisibility(0);
        }
        textView.setMaxWidth(DensityUtils.a(this.f19462a.getContext(), 120.0f));
        linearLayout2.setVisibility(0);
        if (searchSessionModel.f19471a <= 0) {
            if (TextUtils.isEmpty(searchSessionModel.b)) {
                linearLayout2.setVisibility(8);
            }
            textView3.setText("");
            imageView3.setVisibility(8);
        } else if (searchSessionModel.f19471a > 1) {
            Resources resources = this.mContext.getResources();
            textView3.setText(resources.getString(R.string.chat_count, searchSessionModel.f19471a + ""));
        } else {
            UserRelationshipUtils.a(this.mContext, StringUtils.a(StringUtils.a(searchSessionModel.lastMsgContent, false, true, true, ""), (int) textView3.getTextSize()).toString(), this.b, textView3);
        }
        if (searchSessionModel.lastMsgTime == 0 || searchSessionModel.f19471a > 1) {
            textView4.setText("");
        } else {
            textView4.setText(MsgCommonUtils.a(this.f19462a.getContext(), searchSessionModel.lastMsgTime));
        }
        ImageLoader.a(this.f19462a.getFragmentActive(), searchSessionModel.sessionType == 3 ? searchSessionModel.avatar : AvatarUtils.a(0, searchSessionModel.avatar)).b(2131237310).a(imageView);
        if (TextUtils.isEmpty(searchSessionModel.b)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            UserRelationshipUtils.a(this.mContext, this.mContext.getResources().getString(R.string.msg_note_name, searchSessionModel.nickName), this.b, textView2);
        }
        UserRelationshipUtils.a(this.mContext, a(searchSessionModel, (SessionSettingModel) searchSessionModel.sessionSettingModel), this.b, textView);
        UserInfoHelper.a(imageView2, searchSessionModel.vBadge, 3);
        UserRelationshipUtils.a(imageView4, a((SessionModel) searchSessionModel));
        UserRelationshipUtils.a(this.f19462a.getContext(), textView, a((SessionModel) searchSessionModel));
        baseViewHolder.setGone(R.id.tv_group_icon, searchSessionModel.sessionType == 3);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.SearchAllAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SearchAllAdapter.this.mContext instanceof Activity) {
                    KeyboardUtils.a((Activity) SearchAllAdapter.this.mContext);
                }
                SearchAllAdapter.this.a(searchSessionModel);
            }
        });
    }

    public void a(List<SearchSessionModel> list, String str) {
        this.b = str;
        setNewData(list);
    }

    public void b(List<SearchSessionModel> list, String str) {
        this.b = str;
        addData((Collection) list);
    }
}
