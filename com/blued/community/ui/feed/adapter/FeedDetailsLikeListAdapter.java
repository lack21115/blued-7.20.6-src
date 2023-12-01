package com.blued.community.ui.feed.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedUserInfoModel;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.observer.LikeListDataObserver;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedDetailsLikeListAdapter.class */
public class FeedDetailsLikeListAdapter extends BaseQuickAdapter<FeedUserInfoModel, BaseViewHolder> implements LikeListDataObserver.ILikeListDataObserver {
    private Context a;
    private IRequestHost b;
    private Dialog c;
    private String d;
    private BluedIngSelfFeed e;

    public FeedDetailsLikeListAdapter(Context context, IRequestHost iRequestHost, String str) {
        super(R.layout.fragment_zan_list_item);
        this.b = iRequestHost;
        this.a = context;
        this.c = DialogUtils.a(context);
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final FeedUserInfoModel feedUserInfoModel) {
        CommunityHttpUtils.b(this.a, new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsLikeListAdapter.3
            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a() {
                DialogUtils.a(FeedDetailsLikeListAdapter.this.c);
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                UserInfoUtils.b().setAttentionCount(1);
                feedUserInfoModel.relationship = str;
                LiveEventBus.get("feed_relation_ship").post(feedUserInfoModel);
                FeedDetailsLikeListAdapter.this.notifyDataSetChanged();
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b() {
                DialogUtils.b(FeedDetailsLikeListAdapter.this.c);
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
            }

            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
            public void c() {
                DialogUtils.b(FeedDetailsLikeListAdapter.this.c);
            }
        }, feedUserInfoModel.uid, "", this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final FeedUserInfoModel feedUserInfoModel) {
        Context context = this.a;
        CommonAlertDialog.a(context, context.getResources().getString(R.string.community_string_notice), this.a.getResources().getString(R.string.cancel_follow_hint), this.a.getResources().getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsLikeListAdapter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CommunityHttpUtils.a(FeedDetailsLikeListAdapter.this.a, new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsLikeListAdapter.4.1
                    @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
                    public void a() {
                        DialogUtils.a(FeedDetailsLikeListAdapter.this.c);
                    }

                    @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
                    public void a(String str) {
                    }

                    @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
                    public void b() {
                        DialogUtils.b(FeedDetailsLikeListAdapter.this.c);
                    }

                    @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
                    public void b(String str) {
                        UserInfoUtils.b().setAttentionCount(-1);
                        feedUserInfoModel.relationship = str;
                        LiveEventBus.get("feed_relation_ship").post(feedUserInfoModel);
                        FeedDetailsLikeListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
                    public void c() {
                        DialogUtils.b(FeedDetailsLikeListAdapter.this.c);
                    }
                }, feedUserInfoModel.uid, "", FeedDetailsLikeListAdapter.this.b);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void a() {
        LikeListDataObserver.a().a(this);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        this.e = bluedIngSelfFeed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final FeedUserInfoModel feedUserInfoModel) {
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.header_view);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_anonymous);
        TextView textView = (TextView) baseViewHolder.getView(R.id.location_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.age_view);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.height_view);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.weight_view);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.role_view);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_verify);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.img_vip_icon);
        FollowStatusView followStatusView = (FollowStatusView) baseViewHolder.getView(R.id.follow_status_view);
        UserInfoHelper.a(imageView3, feedUserInfoModel.vbadge, 3);
        ImageWrapper b = ImageLoader.a(this.b, AvatarUtils.a(0, feedUserInfoModel.avatar)).c().b(R.drawable.user_bg_round);
        if (feedUserInfoModel.is_comment_anonym == 1) {
            b.d();
        }
        b.a(imageView);
        UserInfoHelper.a(this.a, textView6, feedUserInfoModel.role);
        if (!TextUtils.isEmpty(feedUserInfoModel.note)) {
            textView2.setText(feedUserInfoModel.note);
        } else if (TextUtils.isEmpty(feedUserInfoModel.name)) {
            textView2.setText("");
        } else {
            textView2.setText(feedUserInfoModel.name);
        }
        final boolean a = FeedMethods.a(textView2, feedUserInfoModel.uid, feedUserInfoModel.is_comment_anonym == 1);
        imageView2.setVisibility(feedUserInfoModel.is_comment_anonym == 1 ? 0 : 8);
        UserInfoHelper.a(this.a, textView2, feedUserInfoModel);
        UserInfoHelper.a(imageView4, feedUserInfoModel);
        if (TextUtils.isEmpty(feedUserInfoModel.age)) {
            textView3.setText("");
        } else {
            textView3.setText(feedUserInfoModel.age + this.a.getResources().getString(R.string.age_unit));
        }
        if (TextUtils.isEmpty(feedUserInfoModel.height)) {
            textView4.setText("");
        } else if (BlueAppLocal.d()) {
            textView4.setText(StringUtils.a(feedUserInfoModel.height, BlueAppLocal.c(), false));
        } else {
            textView4.setText(StringUtils.a(feedUserInfoModel.height, BlueAppLocal.c(), true));
        }
        if (TextUtils.isEmpty(feedUserInfoModel.weight)) {
            textView5.setText("");
        } else if (BlueAppLocal.d()) {
            textView5.setText(StringUtils.b(feedUserInfoModel.weight, BlueAppLocal.c(), false));
        } else {
            textView5.setText(StringUtils.b(feedUserInfoModel.weight, BlueAppLocal.c(), true));
        }
        if (TextUtils.isEmpty(feedUserInfoModel.location)) {
            textView.setText("");
        } else {
            textView.setText(feedUserInfoModel.location);
        }
        DistanceUtils.b(this.a, textView, feedUserInfoModel.is_hide_city_settled, 1);
        if (feedUserInfoModel.uid.equals(UserInfoUtils.c())) {
            followStatusView.setVisibility(8);
        } else {
            followStatusView.setVisibility(0);
        }
        followStatusView.setRelationShip(feedUserInfoModel.relationship);
        followStatusView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsLikeListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextUtils.isEmpty(feedUserInfoModel.relationship) || !(feedUserInfoModel.relationship.equals("1") || feedUserInfoModel.relationship.equals("3"))) {
                    FeedDetailsLikeListAdapter.this.a(feedUserInfoModel);
                } else {
                    FeedDetailsLikeListAdapter.this.b(feedUserInfoModel);
                }
            }
        });
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsLikeListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (a) {
                    return;
                }
                CommunityServiceManager.b().a(FeedDetailsLikeListAdapter.this.a, feedUserInfoModel, FeedDetailsLikeListAdapter.this.e, FeedDetailsLikeListAdapter.this.d, imageView);
            }
        });
    }

    @Override // com.blued.community.ui.feed.observer.LikeListDataObserver.ILikeListDataObserver
    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (1 == i) {
            FeedUserInfoModel feedUserInfoModel = new FeedUserInfoModel();
            feedUserInfoModel.avatar = UserInfoUtils.b().getAvatar();
            feedUserInfoModel.uid = UserInfoUtils.c();
            feedUserInfoModel.vbadge = UserInfoUtils.b().getVBadge();
            feedUserInfoModel.name = UserInfoUtils.b().getName();
            feedUserInfoModel.city_settled = UserInfoUtils.b().getCity_settled();
            feedUserInfoModel.age = UserInfoUtils.b().getAge();
            feedUserInfoModel.height = UserInfoUtils.b().getHeight();
            feedUserInfoModel.weight = UserInfoUtils.b().getWeight();
            feedUserInfoModel.role = UserInfoUtils.b().getRole();
            if (this.e.is_feed_anonym == 1 && TextUtils.equals(str, this.e.feed_uid)) {
                feedUserInfoModel.is_comment_anonym = 1;
            }
            addData(0, feedUserInfoModel);
        } else if (i == 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mData.size()) {
                    break;
                } else if (str.equals(((FeedUserInfoModel) this.mData.get(i3)).uid)) {
                    this.mData.remove(i3);
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        notifyDataSetChanged();
    }

    public void b() {
        LikeListDataObserver.a().b(this);
    }
}
