package com.soft.blued.ui.search.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.search.SearchLikeChatFragment;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.utils.SearchGlobalUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/adapter/SearchGlobalAdapter.class */
public final class SearchGlobalAdapter extends BaseMultiItemQuickAdapter<SearchGlobalInfo, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19465a = new Companion(null);
    private final IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private String f19466c;
    private int d;
    private GuyProtos.SortType e;
    private HashMap<Integer, HashSet<String>> f;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/adapter/SearchGlobalAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalAdapter(IRequestHost iRequestHost) {
        super(null);
        Intrinsics.e(iRequestHost, "requestHost");
        this.b = iRequestHost;
        this.f19466c = "";
        this.e = GuyProtos.SortType.COMPLEX_SORT;
        this.f = new HashMap<>();
        addItemType(0, R.layout.item_search_more);
        addItemType(2, R.layout.item_search_global_user);
        addItemType(3, R.layout.item_my_group_data);
        addItemType(1, R.layout.item_search_all_layout);
        addItemType(4, R.layout.item_search_all_circle);
        addItemType(5, R.layout.item_search_all_circle);
    }

    private final UserBasicModel a(SessionModel sessionModel) {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = sessionModel.vipGrade;
        userBasicModel.is_vip_annual = sessionModel.vipAnnual;
        userBasicModel.is_hide_vip_look = sessionModel.hideVipLook;
        userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
        return userBasicModel;
    }

    private final String a(SessionModel sessionModel, SessionSettingModel sessionSettingModel) {
        String str = sessionModel.nickName;
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        return !TextUtils.isEmpty(sessinoNote) ? sessinoNote : !TextUtils.isEmpty(str) ? str : "";
    }

    private final void a(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.setImageResource(R.id.msg_friend_item_status, i);
        baseViewHolder.setVisible(R.id.msg_friend_item_status, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalAdapter searchGlobalAdapter, GroupInfoModel groupInfoModel, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalAdapter, "this$0");
        Intrinsics.e(groupInfoModel, "$group");
        if (searchGlobalAdapter.mContext instanceof Activity) {
            Context context = searchGlobalAdapter.mContext;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            KeyboardUtils.a((Activity) context);
        }
        GroupInfoFragment.a(searchGlobalAdapter.mContext, String.valueOf(groupInfoModel.group_id), groupInfoModel, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
        SearchGlobalUtil.f19484a.b(searchGlobalAdapter.f19466c);
        if (searchGlobalAdapter.d == 0) {
            EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_GROUP_CLICK, searchGlobalAdapter.f19466c, String.valueOf(groupInfoModel.group_id));
        } else {
            EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_GROUP_CLICK, searchGlobalAdapter.f19466c, String.valueOf(groupInfoModel.group_id));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalAdapter searchGlobalAdapter, MyCircleModel myCircleModel, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalAdapter, "this$0");
        Intrinsics.e(myCircleModel, "$item");
        CircleDetailsFragment.a(searchGlobalAdapter.mContext, myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.z);
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_CLICK, searchGlobalAdapter.f19466c, myCircleModel.circle_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalAdapter searchGlobalAdapter, BluedTopic bluedTopic, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalAdapter, "this$0");
        Intrinsics.e(bluedTopic, "$item");
        SuperTopicDetailFragment.a(searchGlobalAdapter.mContext, bluedTopic.super_did);
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_CLICK, searchGlobalAdapter.f19466c, bluedTopic.super_did);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalAdapter searchGlobalAdapter, SearchGlobalInfo.SearchUserModel searchUserModel, BaseViewHolder baseViewHolder, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalAdapter, "this$0");
        Intrinsics.e(searchUserModel, "$user");
        Intrinsics.e(baseViewHolder, "$helper");
        if (searchGlobalAdapter.mContext instanceof Activity) {
            Context context = searchGlobalAdapter.mContext;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            KeyboardUtils.a((Activity) context);
        }
        FilterDialogFragment.f16500c = true;
        UserInfoFragmentNew.a(searchGlobalAdapter.mContext, searchUserModel, "", baseViewHolder.getView(2131364232));
        SearchGlobalUtil.f19484a.b(searchGlobalAdapter.f19466c);
        if (searchGlobalAdapter.d == 0) {
            EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_USER_CLICK, searchGlobalAdapter.f19466c, searchUserModel.uid);
        } else {
            EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_USER_CLICK, searchGlobalAdapter.f19466c, searchUserModel.uid, searchGlobalAdapter.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalAdapter searchGlobalAdapter, SearchSessionModel searchSessionModel, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalAdapter, "this$0");
        Intrinsics.e(searchSessionModel, "$session");
        if (searchGlobalAdapter.mContext instanceof Activity) {
            Context context = searchGlobalAdapter.mContext;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            KeyboardUtils.a((Activity) context);
        }
        searchGlobalAdapter.a(searchSessionModel);
        SearchGlobalUtil.f19484a.b(searchGlobalAdapter.f19466c);
        if (searchGlobalAdapter.d == 0) {
            EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_MSG_CLICK, searchGlobalAdapter.f19466c, String.valueOf(searchSessionModel.sessionId));
        } else {
            EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_MSG_CLICK, searchGlobalAdapter.f19466c, String.valueOf(searchSessionModel.sessionId));
        }
    }

    private final void a(SearchSessionModel searchSessionModel) {
        if (searchSessionModel.f19471a <= 1) {
            if (searchSessionModel.sessionType == 2 && BluedPreferences.av()) {
                a(searchSessionModel, true);
                return;
            } else {
                a(searchSessionModel, false);
                return;
            }
        }
        Context context = this.mContext;
        String str = this.f19466c;
        SearchSessionModel searchSessionModel2 = searchSessionModel;
        SessionSettingBaseModel sessionSettingBaseModel = searchSessionModel.sessionSettingModel;
        if (sessionSettingBaseModel == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.db.model.SessionSettingModel");
        }
        SearchLikeChatFragment.a(context, str, a(searchSessionModel2, (SessionSettingModel) sessionSettingBaseModel), searchSessionModel.sessionId, searchSessionModel.sessionType, searchSessionModel.avatar, searchSessionModel.vBadge, searchSessionModel.vipGrade, searchSessionModel.vipAnnual, searchSessionModel.vipExpLvl, searchSessionModel.hideVipLook);
    }

    private final void a(SearchSessionModel searchSessionModel, boolean z) {
        LogData logData = new LogData();
        logData.from = "none";
        ChatHelperV4.a().a(this.mContext, searchSessionModel.sessionId, searchSessionModel.nickName, searchSessionModel.avatar, searchSessionModel.vBadge, searchSessionModel.vipGrade, searchSessionModel.vipAnnual, searchSessionModel.vipExpLvl, Intrinsics.a(searchSessionModel.lastMsgFromDistance, ""), z, searchSessionModel.sessionType == 3 ? 1 : 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), searchSessionModel.lastMsgId, searchSessionModel.lastMsgLocalId, false, false);
    }

    private final boolean a(int i, String str) {
        HashSet<String> hashSet = this.f.get(Integer.valueOf(i));
        HashSet<String> hashSet2 = hashSet;
        if ((hashSet2 == null || hashSet2.isEmpty()) || !hashSet.contains(str)) {
            HashSet<String> hashSet3 = hashSet;
            if (hashSet == null) {
                hashSet3 = new HashSet<>();
                this.f.put(Integer.valueOf(i), hashSet3);
            }
            hashSet3.add(str);
            return false;
        }
        return true;
    }

    private final String b(int i) {
        String string = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : this.mContext.getString(R.string.topic) : this.mContext.getString(R.string.base) : this.mContext.getString(R.string.friend_global_search_group) : this.mContext.getString(R.string.friend_global_search_user) : this.mContext.getString(R.string.friend_global_search_chat);
        Intrinsics.c(string, "when (title_type) {\n    …\n        else -> \"\"\n    }");
        return string;
    }

    private final void b(BaseViewHolder baseViewHolder, SearchGlobalInfo searchGlobalInfo) {
        final MyCircleModel f = searchGlobalInfo.f();
        if (f == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(0, f.cover)).a(12.0f).b(2131102177).a((ImageView) baseViewHolder.getView(R.id.iv_avatar));
        View view = baseViewHolder.getView(2131372046);
        Intrinsics.c(view, "viewHolder.getView(R.id.tv_name)");
        UserRelationshipUtils.a(this.mContext, f.title, b(), (TextView) view);
        View view2 = baseViewHolder.getView(2131371259);
        Intrinsics.c(view2, "viewHolder.getView(R.id.tv_des)");
        UserRelationshipUtils.a(this.mContext, f.description, b(), (TextView) view2);
        baseViewHolder.setText(R.id.tv_num, Intrinsics.a(CommonStringUtils.b(f.members_num), this.mContext.getString(R.string.members_count_part))).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchGlobalAdapter$S52jxMmyFcK7ZonHYd2KWS2eYBE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SearchGlobalAdapter.a(SearchGlobalAdapter.this, f, view3);
            }
        });
        if (f.isShowUrlVisited) {
            return;
        }
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_SHOW, b(), f.circle_id);
        f.isShowUrlVisited = true;
    }

    private final void c(BaseViewHolder baseViewHolder, SearchGlobalInfo searchGlobalInfo) {
        final BluedTopic g = searchGlobalInfo.g();
        if (g == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(0, g.avatar)).a(12.0f).b(2131102177).a((ImageView) baseViewHolder.getView(R.id.iv_avatar));
        UserRelationshipUtils.a(this.mContext, g.name, b(), (TextView) baseViewHolder.getView(2131372046));
        UserRelationshipUtils.a(this.mContext, g.description, b(), (TextView) baseViewHolder.getView(2131371259));
        baseViewHolder.setText(R.id.tv_num, CommonStringUtils.b(g.ticktocks_total) + this.mContext.getString(R.string.subject_feed_count) + ' ' + ((Object) CommonStringUtils.b(g.visited_total)) + this.mContext.getString(R.string.subject_visit_count)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchGlobalAdapter$qsrMCTnF55HsQiLcap_9C89EYP0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGlobalAdapter.a(SearchGlobalAdapter.this, g, view);
            }
        });
        if (g.isShowUrlVisited) {
            return;
        }
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_SHOW, b(), g.super_did);
        g.isShowUrlVisited = true;
    }

    private final void d(BaseViewHolder baseViewHolder, SearchGlobalInfo searchGlobalInfo) {
        final SearchSessionModel c2 = searchGlobalInfo.c();
        if (c2 == null) {
            return;
        }
        boolean z = true;
        if (!a(1, String.valueOf(c2.sessionId))) {
            if (c() == 0) {
                EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_MSG_SHOW, b(), String.valueOf(c2.sessionId));
            } else {
                EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_MSG_SHOW, b(), String.valueOf(c2.sessionId));
            }
        }
        short s = c2.lastMsgStateCode;
        if (s == 7) {
            a(baseViewHolder, R.drawable.chat_fail_resend);
        } else if (s == 1) {
            a(baseViewHolder, R.drawable.icon_msg_sending);
        } else if (s == 6) {
            a(baseViewHolder, R.drawable.icon_msg_fail);
        } else {
            baseViewHolder.setGone(R.id.msg_friend_item_status, false);
        }
        ((TextView) baseViewHolder.getView(R.id.msg_friend_item_name)).setMaxWidth(BluedViewExtKt.a(120));
        TextView textView = (TextView) baseViewHolder.getView(R.id.msg_friend_item_content);
        if (c2.f19471a <= 0) {
            if (TextUtils.isEmpty(c2.b)) {
                baseViewHolder.setGone(R.id.msg_content_noread_root, true);
            }
            baseViewHolder.setText(R.id.msg_friend_item_content, "");
            baseViewHolder.setGone(R.id.msg_friend_item_status, true);
        } else if (c2.f19471a > 1) {
            baseViewHolder.setText(R.id.msg_friend_item_content, this.mContext.getResources().getString(R.string.chat_count, String.valueOf(c2.f19471a)));
        } else {
            UserRelationshipUtils.a(this.mContext, StringUtils.a(StringUtils.a(c2.lastMsgContent, false, true, true, ""), (int) textView.getTextSize()).toString(), b(), textView);
        }
        if (c2.lastMsgTime == 0 || c2.f19471a > 1) {
            baseViewHolder.setText(R.id.msg_friend_item_time, "");
        } else {
            baseViewHolder.setText(R.id.msg_friend_item_time, MsgCommonUtils.a(this.mContext, c2.lastMsgTime));
        }
        ImageLoader.a(a(), c2.sessionType == 3 ? c2.avatar : AvatarUtils.a(0, c2.avatar)).b(2131237310).a((ImageView) baseViewHolder.getView(2131364232));
        if (TextUtils.isEmpty(c2.b)) {
            baseViewHolder.setGone(R.id.tv_note_name, false);
        } else {
            baseViewHolder.setGone(R.id.tv_note_name, true);
            baseViewHolder.setText(R.id.tv_note_name, this.mContext.getResources().getString(R.string.msg_note_name, c2.nickName));
        }
        SearchSessionModel searchSessionModel = c2;
        baseViewHolder.setText(R.id.msg_friend_item_name, a(searchSessionModel, (SessionSettingModel) c2.sessionSettingModel));
        UserInfoHelper.a((ImageView) baseViewHolder.getView(R.id.msg_friend_item_avatar_v), c2.vBadge, 3);
        UserRelationshipUtils.a((ImageView) baseViewHolder.getView(2131364726), a((SessionModel) searchSessionModel));
        UserRelationshipUtils.a(this.mContext, (TextView) baseViewHolder.getView(R.id.msg_friend_item_name), a((SessionModel) searchSessionModel));
        if (c2.sessionType != 3) {
            z = false;
        }
        baseViewHolder.setGone(R.id.tv_group_icon, z);
        baseViewHolder.getView(R.id.item_view).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchGlobalAdapter$OGv0FZvj7NvWAxsfx3FMsE2RcTk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGlobalAdapter.a(SearchGlobalAdapter.this, c2, view);
            }
        });
    }

    private final void e(BaseViewHolder baseViewHolder, SearchGlobalInfo searchGlobalInfo) {
        final GroupInfoModel e = searchGlobalInfo.e();
        if (e == null) {
            return;
        }
        if (!a(3, String.valueOf(e.group_id))) {
            if (c() == 0) {
                EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_GROUP_SHOW, b(), String.valueOf(e.group_id));
            } else {
                EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_GROUP_SHOW, b(), String.valueOf(e.group_id));
            }
        }
        SocialNetWorkProtos.Event event = SocialNetWorkProtos.Event.GROUP_DRAW;
        List list = e.label;
        SocialNetWorkProtos.SourceType sourceType = e.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN;
        EventTrackGroup.a(event, list, sourceType, e.group_id + "");
        GroupUtil.a(baseViewHolder.getView(R.id.tv_type), e, true);
        GroupUtil.b(a(), e.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_header));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_identity), e.group_role);
        BaseViewHolder text = baseViewHolder.setText(R.id.tv_desc, e.group_desc);
        StringBuilder sb = new StringBuilder();
        sb.append(e.group_now_population);
        sb.append('/');
        sb.append(e.group_max_population);
        text.setText(R.id.tv_member_cnt, sb.toString()).setTextColor(R.id.tv_member_cnt, BluedSkinUtils.a(this.mContext, e.group_now_population > e.group_max_population ? 2131102251 : 2131102263));
        GroupUtil.a(e, (TextView) baseViewHolder.getView(2131372046));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_frozen), e.group_role, e.group_status);
        if (!TextUtils.isEmpty(b())) {
            UserRelationshipUtils.a(this.mContext, e.group_title, b(), (TextView) baseViewHolder.getView(2131372046));
            UserRelationshipUtils.a(this.mContext, e.group_desc, b(), (TextView) baseViewHolder.getView(R.id.tv_desc));
        }
        baseViewHolder.getView(R.id.root_group).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchGlobalAdapter$APxifFgV-xAxbkyU6AprbWST5rA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGlobalAdapter.a(SearchGlobalAdapter.this, e, view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void f(final com.chad.library.adapter.base.BaseViewHolder r8, com.soft.blued.ui.search.model.SearchGlobalInfo r9) {
        /*
            Method dump skipped, instructions count: 1176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.search.adapter.SearchGlobalAdapter.f(com.chad.library.adapter.base.BaseViewHolder, com.soft.blued.ui.search.model.SearchGlobalInfo):void");
    }

    private final void g(BaseViewHolder baseViewHolder, SearchGlobalInfo searchGlobalInfo) {
        baseViewHolder.setGone(2131366859, baseViewHolder.getAdapterPosition() != 0);
        baseViewHolder.setVisible(R.id.tv_more, searchGlobalInfo.b());
        baseViewHolder.setText(2131372754, b(searchGlobalInfo.a()));
        baseViewHolder.addOnClickListener(R.id.tv_more);
    }

    public final IRequestHost a() {
        return this.b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(GuyProtos.SortType sortType) {
        Intrinsics.e(sortType, "<set-?>");
        this.e = sortType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, SearchGlobalInfo searchGlobalInfo) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(searchGlobalInfo, "item");
        int type = searchGlobalInfo.getType();
        if (type == 0) {
            g(baseViewHolder, searchGlobalInfo);
        } else if (type == 1) {
            d(baseViewHolder, searchGlobalInfo);
        } else if (type == 2) {
            f(baseViewHolder, searchGlobalInfo);
        } else if (type == 3) {
            e(baseViewHolder, searchGlobalInfo);
        } else if (type == 4) {
            b(baseViewHolder, searchGlobalInfo);
        } else if (type != 5) {
        } else {
            c(baseViewHolder, searchGlobalInfo);
        }
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f19466c = str;
    }

    public final String b() {
        return this.f19466c;
    }

    public final int c() {
        return this.d;
    }

    public final GuyProtos.SortType d() {
        return this.e;
    }

    public final HashMap<Integer, HashSet<String>> e() {
        return this.f;
    }
}
