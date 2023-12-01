package com.blued.community.ui.feed.fragment;

import android.content.Context;
import android.view.View;
import com.amap.api.fence.GeoFence;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.auto.ICommunityShowPageService;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.ui.event.model.EventMemberModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignInteractiveListFragment$initAdapter$1.class */
public final class SignInteractiveListFragment$initAdapter$1 extends CommonAdapter<EventMemberModel> {
    final /* synthetic */ SignInteractiveListFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInteractiveListFragment$initAdapter$1(SignInteractiveListFragment signInteractiveListFragment, int i) {
        super(i);
        this.d = signInteractiveListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final EventMemberModel item, SignInteractiveListFragment this$0, final Ref.ObjectRef followView, final SignInteractiveListFragment$initAdapter$1 this$1, View view) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(followView, "$followView");
        Intrinsics.e(this$1, "this$1");
        if (item.user_info.is_followed() == 0) {
            EventHttpUtils eventHttpUtils = EventHttpUtils.a;
            final ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
            BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>>(followView, this$1, fragmentActive) { // from class: com.blued.community.ui.feed.fragment.SignInteractiveListFragment$initAdapter$1$convert$1$1
                final /* synthetic */ Ref.ObjectRef<FollowStatusView> b;
                final /* synthetic */ SignInteractiveListFragment$initAdapter$1 c;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(fragmentActive);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<FeedUserInfoModel> parseData) {
                    Intrinsics.e(parseData, "parseData");
                    EventMemberModel.this.user_info.set_followed(1);
                    this.b.a.setRelationShip(String.valueOf(EventMemberModel.this.user_info.is_followed()));
                    this.c.notifyDataSetChanged();
                }
            };
            String str = UserInfo.getInstance().getLoginUserInfo().uid;
            Intrinsics.c(str, "getInstance().loginUserInfo.uid");
            String str2 = item.uid;
            Intrinsics.c(str2, "item.uid");
            ActivityFragmentActive fragmentActive2 = this$0.getFragmentActive();
            Intrinsics.c(fragmentActive2, "fragmentActive");
            eventHttpUtils.d(bluedUIHttpResponse, str, str2, GeoFence.BUNDLE_KEY_FENCESTATUS, fragmentActive2);
            return;
        }
        EventHttpUtils eventHttpUtils2 = EventHttpUtils.a;
        final ActivityFragmentActive fragmentActive3 = this$0.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>> bluedUIHttpResponse2 = new BluedUIHttpResponse<BluedEntityA<FeedUserInfoModel>>(followView, this$1, fragmentActive3) { // from class: com.blued.community.ui.feed.fragment.SignInteractiveListFragment$initAdapter$1$convert$1$2$1
            final /* synthetic */ Ref.ObjectRef<FollowStatusView> b;
            final /* synthetic */ SignInteractiveListFragment$initAdapter$1 c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedUserInfoModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                EventMemberModel.this.user_info.set_followed(0);
                this.b.a.setRelationShip(String.valueOf(EventMemberModel.this.user_info.is_followed()));
                this.c.notifyDataSetChanged();
            }
        };
        String str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        Intrinsics.c(str3, "getInstance().loginUserInfo.uid");
        String str4 = item.uid;
        Intrinsics.c(str4, "it.uid");
        ActivityFragmentActive fragmentActive4 = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive4, "fragmentActive");
        eventHttpUtils2.e(bluedUIHttpResponse2, str3, str4, GeoFence.BUNDLE_KEY_FENCESTATUS, fragmentActive4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SignInteractiveListFragment$initAdapter$1 this$0, SignInteractiveListFragment this$1, EventMemberModel item, View view) {
        BluedIngSelfFeed bluedIngSelfFeed;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this$1, "this$1");
        Intrinsics.e(item, "$item");
        ICommunityShowPageService b = CommunityServiceManager.b();
        Context context = this$0.a;
        bluedIngSelfFeed = this$1.i;
        b.a(context, bluedIngSelfFeed, item.uid, "feed_sign_state");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.blued.android.module.common.adapter.CommonAdapter
    public void a(CommonAdapter.ViewHolder viewHolder, final EventMemberModel item, int i) {
        View a;
        CommonAdapter.ViewHolder d;
        CommonAdapter.ViewHolder a2;
        Intrinsics.e(item, "item");
        if (viewHolder != null && (d = viewHolder.d(R.id.iv_member_avatar, item.user_info.avatar)) != null && (a2 = d.a(R.id.tv_member_name, item.user_info.name)) != null) {
            int i2 = R.id.tv_event_time;
            a2.a(i2, DistanceUtils.a(item.user_info.distance, BlueAppLocal.c(), false) + (char) 12539 + ((Object) item.user_info.age) + '/' + ((Object) item.user_info.height) + '/' + ((Object) item.user_info.weight));
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = viewHolder == null ? null : (FollowStatusView) viewHolder.a(R.id.follow_status_view);
        FollowStatusView followStatusView = (FollowStatusView) objectRef.a;
        if (followStatusView != null) {
            followStatusView.setRelationShip(String.valueOf(item.user_info.is_followed()));
        }
        FollowStatusView followStatusView2 = (FollowStatusView) objectRef.a;
        if (followStatusView2 != null) {
            final SignInteractiveListFragment signInteractiveListFragment = this.d;
            followStatusView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignInteractiveListFragment$initAdapter$1$aluqsh-7h0FceAhjtLx5LAouxGA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SignInteractiveListFragment$initAdapter$1.a(EventMemberModel.this, signInteractiveListFragment, objectRef, this, view);
                }
            });
        }
        if (viewHolder == null || (a = viewHolder.a(R.id.cl_user_info)) == null) {
            return;
        }
        final SignInteractiveListFragment signInteractiveListFragment2 = this.d;
        a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignInteractiveListFragment$initAdapter$1$7B-eP_rY7JLlMoFM7gWXUaqb-u4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignInteractiveListFragment$initAdapter$1.a(SignInteractiveListFragment$initAdapter$1.this, signInteractiveListFragment2, item, view);
            }
        });
    }
}
