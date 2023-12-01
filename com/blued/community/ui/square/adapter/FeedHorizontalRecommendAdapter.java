package com.blued.community.ui.square.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/FeedHorizontalRecommendAdapter.class */
public class FeedHorizontalRecommendAdapter extends BaseQuickAdapter<FeedRecommendUser, BaseViewHolder> {
    private Context a;
    private IRequestHost b;
    private String c;
    private int d;
    private long e;

    /* renamed from: com.blued.community.ui.square.adapter.FeedHorizontalRecommendAdapter$2  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/FeedHorizontalRecommendAdapter$2.class */
    class AnonymousClass2 implements CommunityHttpUtils.IAddOrRemoveAttentionDone {
        final /* synthetic */ FeedRecommendUser a;
        final /* synthetic */ FeedHorizontalRecommendAdapter b;

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void a() {
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void a(String str) {
            this.a.relationship = str;
            this.b.notifyDataSetChanged();
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void b() {
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void b(String str) {
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void c() {
            this.a.relationship = "0";
            this.b.notifyDataSetChanged();
        }
    }

    /* renamed from: com.blued.community.ui.square.adapter.FeedHorizontalRecommendAdapter$3  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/FeedHorizontalRecommendAdapter$3.class */
    class AnonymousClass3 implements CommunityHttpUtils.IAddOrRemoveAttentionDone {
        final /* synthetic */ FeedRecommendUser a;
        final /* synthetic */ FeedHorizontalRecommendAdapter b;

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void a() {
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void a(String str) {
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void b() {
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void b(String str) {
            this.a.relationship = "0";
            this.b.notifyDataSetChanged();
        }

        @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
        public void c() {
        }
    }

    public FeedHorizontalRecommendAdapter(Context context, IRequestHost iRequestHost, String str, int i) {
        super(R.layout.item_recommend_live_user, (List) null);
        this.c = "recommend";
        this.a = context;
        this.b = iRequestHost;
        this.c = str;
        this.d = i;
    }

    public void a() {
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.e = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final FeedRecommendUser feedRecommendUser) {
        if (baseViewHolder == null || feedRecommendUser == null) {
            return;
        }
        final String a = EncryptTool.a(feedRecommendUser.uid);
        EncryptTool.a(feedRecommendUser.lid);
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_header);
        if (imageView != null) {
            ImageLoader.a(this.b, AvatarUtils.a(1, feedRecommendUser.avatar)).b(R.drawable.user_header_square).a(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.adapter.FeedHorizontalRecommendAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (FeedHorizontalRecommendAdapter.this.c.equals("recommend")) {
                        EventTrackFeed.a(FeedProtos.Event.PLAZA_RECOMMEND_FOLLOW_USER_CLICK, a, feedRecommendUser.show_type == 0, FeedHorizontalRecommendAdapter.this.d, FeedHorizontalRecommendAdapter.this.e);
                    } else if (FeedHorizontalRecommendAdapter.this.c.equals("followed")) {
                        EventTrackFeed.a(FeedProtos.Event.PLAZA_FOLLOW_LIVE_USER_CLICK, a, feedRecommendUser.show_type == 0, FeedHorizontalRecommendAdapter.this.d, FeedHorizontalRecommendAdapter.this.e);
                    }
                    UserBasicModel userBasicModel = new UserBasicModel();
                    userBasicModel.uid = a;
                    userBasicModel.name = feedRecommendUser.name;
                    userBasicModel.avatar = feedRecommendUser.avatar;
                    if (feedRecommendUser.show_type == 0) {
                        CommunityServiceManager.b().a(FeedHorizontalRecommendAdapter.this.a, feedRecommendUser, FeedHorizontalRecommendAdapter.this.mData);
                    } else {
                        CommunityServiceManager.b().a(FeedHorizontalRecommendAdapter.this.a, userBasicModel, "feed_horizontal_recommend", false, (View) imageView, (LogData) null, MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND_USER);
                    }
                }
            });
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
        if (textView != null) {
            textView.setText(feedRecommendUser.name);
        }
        if (feedRecommendUser.isShowed) {
            return;
        }
        if (this.c.equals("recommend")) {
            EventTrackFeed.a(FeedProtos.Event.PLAZA_RECOMMEND_FOLLOW_USER_SHOW, a, feedRecommendUser.show_type == 0, this.d, this.e);
        } else if (this.c.equals("followed")) {
            EventTrackFeed.a(FeedProtos.Event.PLAZA_FOLLOW_LIVE_USER_SHOW, a, feedRecommendUser.show_type == 0, this.d, this.e);
        }
        feedRecommendUser.isShowed = true;
    }
}
