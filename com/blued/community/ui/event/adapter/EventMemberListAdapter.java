package com.blued.community.ui.event.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.amap.api.fence.GeoFence;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.ui.event.fragment.EventUserInfoDlgFragment;
import com.blued.community.ui.event.manager.EventMethods;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.event.model.EventMemberModel;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventMemberListAdapter.class */
public final class EventMemberListAdapter extends BaseQuickAdapter<EventMemberModel, BaseViewHolder> {
    private final FragmentManager a;
    private final IRequestHost b;
    private final String c;
    private final boolean d;
    private final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventMemberListAdapter(FragmentManager fragmentManager, IRequestHost fragmentActive, String eventId, boolean z, int i) {
        super(R.layout.item_event_member_guest);
        Intrinsics.e(fragmentManager, "fragmentManager");
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(eventId, "eventId");
        this.a = fragmentManager;
        this.b = fragmentActive;
        this.c = eventId;
        this.d = z;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    private final void a(EventMemberModel eventMemberModel) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(this.c);
        eventLogData.setUid(eventMemberModel.uid);
        eventLogData.setSourcePage(FeedProtos.SourcePage.ENROLL_USERS);
        EventUserInfoDlgFragment.a.a(this.a, eventMemberModel.uid, this.c, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final EventMemberModel item, final EventMemberListAdapter this$0, final FollowStatusView followStatusView, View view) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        if (item.user_info.is_followed() == 0) {
            EventHttpUtils eventHttpUtils = EventHttpUtils.a;
            final IRequestHost iRequestHost = this$0.b;
            BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>>(iRequestHost) { // from class: com.blued.community.ui.event.adapter.EventMemberListAdapter$convert$3$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<FeedUserInfoModel> parseData) {
                    Intrinsics.e(parseData, "parseData");
                    EventMemberModel.this.user_info.set_followed(1);
                    followStatusView.setRelationShip(Intrinsics.a("", (Object) Integer.valueOf(EventMemberModel.this.user_info.is_followed())));
                    this$0.notifyDataSetChanged();
                }
            };
            String str = UserInfo.getInstance().getLoginUserInfo().uid;
            Intrinsics.c(str, "getInstance().loginUserInfo.uid");
            String str2 = item.uid;
            Intrinsics.c(str2, "item.uid");
            eventHttpUtils.d(bluedUIHttpResponse, str, str2, GeoFence.BUNDLE_KEY_FENCESTATUS, this$0.b);
            return;
        }
        EventHttpUtils eventHttpUtils2 = EventHttpUtils.a;
        final IRequestHost iRequestHost2 = this$0.b;
        BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>> bluedUIHttpResponse2 = new BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>>(iRequestHost2) { // from class: com.blued.community.ui.event.adapter.EventMemberListAdapter$convert$3$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedUserInfoModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                EventMemberModel.this.user_info.set_followed(0);
                followStatusView.setRelationShip(Intrinsics.a("", (Object) Integer.valueOf(EventMemberModel.this.user_info.is_followed())));
                this$0.notifyDataSetChanged();
            }
        };
        String str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        Intrinsics.c(str3, "getInstance().loginUserInfo.uid");
        String str4 = item.uid;
        Intrinsics.c(str4, "item.uid");
        eventHttpUtils2.e(bluedUIHttpResponse2, str3, str4, GeoFence.BUNDLE_KEY_FENCESTATUS, this$0.b);
    }

    private final void a(List<? extends AlbumFlow> list, int i) {
        if (list == null) {
            return;
        }
        LogUtils.c("onClickPhoto: " + list.size() + ", " + i);
        CommunityServiceManager.b().a(this.mContext, (List<AlbumFlow>) list, i, 6, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventMemberListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventMemberListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item.feedPics, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventMemberListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item.feedPics, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EventMemberListAdapter this$0, EventMemberModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item.feedPics, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final EventMemberModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageView imageView = (ImageView) helper.getView(R.id.iv_member_avatar);
        ImageLoader.a(this.b, item.user_info.avatar).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(imageView);
        ImageView imageView2 = (ImageView) helper.getView(R.id.img_verify);
        int i = 8;
        if (item.user_info.vbadge > 0) {
            UserInfoHelper.b(imageView2, item.user_info.vbadge);
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        helper.setText(R.id.tv_member_name, item.user_info.name).setText(R.id.tv_event_num, this.mContext.getString(R.string.register_time) + FeedMethods.i().get(String.valueOf(item.user_info.getRegistration_time())) + " | " + this.mContext.getString(R.string.join_event) + item.join_activity_num);
        helper.setOnClickListener(R.id.cl_user_info, new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberListAdapter$gf4F5PS_kLTL098yNaYQiVHD_I8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberListAdapter.a(EventMemberListAdapter.this, item, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberListAdapter$qXxgQITSfMpB_4Xoqbwu98RHH5Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberListAdapter.b(EventMemberListAdapter.this, item, view);
            }
        });
        if (UserInfoHelper.b(item.user_info.vbadge)) {
            helper.setGone(R.id.tv_event_time, false);
        } else {
            helper.setGone(R.id.tv_event_time, true).setText(R.id.tv_event_time, item.user_info.age + '/' + ((Object) item.user_info.height) + '/' + ((Object) item.user_info.weight) + (char) 12539 + ((Object) UserInfoHelper.a(this.mContext, item.user_info.role)));
        }
        if (this.d && item.is_sign == 1) {
            helper.setGone(R.id.event_member_signed, true);
        } else {
            helper.setGone(R.id.event_member_signed, false);
        }
        final FollowStatusView followStatusView = (FollowStatusView) helper.getView(R.id.follow_status_view);
        followStatusView.setRelationShip(Intrinsics.a("", (Object) Integer.valueOf(item.user_info.is_followed())));
        if (!EventMethods.a(item.uid)) {
            i = 0;
        }
        followStatusView.setVisibility(i);
        followStatusView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberListAdapter$bvLVXudaSEAd_iCWjM-knjku1_I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberListAdapter.a(EventMemberModel.this, this, followStatusView, view);
            }
        });
        if (item.feedPics == null || item.feedPics.isEmpty()) {
            helper.setGone(R.id.event_member_iv_layout, false);
            return;
        }
        helper.setGone(R.id.event_member_iv_layout, true).setGone(R.id.event_member_iv_one, false).setGone(R.id.event_member_iv_two, false).setGone(R.id.event_member_iv_three, false);
        if (item.feedPics.size() > 2) {
            helper.setGone(R.id.event_member_iv_three, true);
            ImageLoader.a(this.b, item.feedPics.get(2).album_pic).b(R.drawable.defaultpicture).a(6.0f).a((ImageView) helper.getView(R.id.event_member_iv_three));
            helper.setOnClickListener(R.id.event_member_iv_three, new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberListAdapter$4Deb0lN6Y0ehKsFNCO4DIkrSGls
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventMemberListAdapter.c(EventMemberListAdapter.this, item, view);
                }
            });
        }
        if (item.feedPics.size() > 1) {
            helper.setGone(R.id.event_member_iv_two, true);
            ImageLoader.a(this.b, item.feedPics.get(1).album_pic).b(R.drawable.defaultpicture).a(6.0f).a((ImageView) helper.getView(R.id.event_member_iv_two));
            helper.setOnClickListener(R.id.event_member_iv_two, new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberListAdapter$ktu4WpdMRsRuKP5W64UOOD4ukNk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventMemberListAdapter.d(EventMemberListAdapter.this, item, view);
                }
            });
        }
        if (item.feedPics.size() > 0) {
            helper.setGone(R.id.event_member_iv_one, true);
            ImageLoader.a(this.b, item.feedPics.get(0).album_pic).b(R.drawable.defaultpicture).a(6.0f).a((ImageView) helper.getView(R.id.event_member_iv_one));
            helper.setOnClickListener(R.id.event_member_iv_one, new View.OnClickListener() { // from class: com.blued.community.ui.event.adapter.-$$Lambda$EventMemberListAdapter$9CR0k6f4ssDkiX46DuSQrdnVIpo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventMemberListAdapter.e(EventMemberListAdapter.this, item, view);
                }
            });
        }
    }
}
