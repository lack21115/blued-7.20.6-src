package com.blued.community.ui.feed.adapter;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.RepostListDataObserver;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.UserInfoUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedDetailsRepostListAdapter.class */
public class FeedDetailsRepostListAdapter extends BaseQuickAdapter<FeedRepost, BaseViewHolder> implements RepostListDataObserver.IRepostListDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f19611a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private String f19612c;
    private BluedIngSelfFeed d;

    public FeedDetailsRepostListAdapter(Context context, IRequestHost iRequestHost, String str) {
        super(R.layout.item_feed_repost);
        this.f19611a = context;
        this.b = iRequestHost;
        this.f19612c = str;
    }

    private void a(View view, final FeedRepost feedRepost) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsRepostListAdapter.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                String str = feedRepost.repost_content;
                if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
                    ((ClipboardManager) FeedDetailsRepostListAdapter.this.f19611a.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(str));
                } else {
                    try {
                        ((android.content.ClipboardManager) FeedDetailsRepostListAdapter.this.f19611a.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
                    } catch (Exception e) {
                    }
                }
                AppMethods.a((CharSequence) FeedDetailsRepostListAdapter.this.f19611a.getResources().getString(R.string.copy));
                return true;
            }
        });
    }

    public void a() {
        RepostListDataObserver.b().a(this);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        this.d = bluedIngSelfFeed;
    }

    @Override // com.blued.community.ui.feed.observer.RepostListDataObserver.IRepostListDataObserver
    public void a(FeedRepost feedRepost) {
        BluedIngSelfFeed bluedIngSelfFeed;
        if (feedRepost == null || (bluedIngSelfFeed = this.d) == null || TextUtils.isEmpty(bluedIngSelfFeed.feed_id) || !this.d.feed_id.equals(feedRepost.feed_id)) {
            return;
        }
        if (TextUtils.isEmpty(feedRepost.repost_content)) {
            feedRepost.repost_content = this.f19611a.getResources().getString(R.string.feed_forward);
        }
        this.mData.add(0, feedRepost);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final FeedRepost feedRepost) {
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.header_view);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_anonymous);
        TextView textView = (TextView) baseViewHolder.getView(R.id.time_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.content_view);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_verify);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.img_vip_icon);
        UserInfoHelper.a(imageView3, feedRepost.vbadge, 3);
        ImageWrapper b = ImageLoader.a(this.b, AvatarUtils.a(1, feedRepost.user_avatar)).c().b(R.drawable.user_bg_round);
        if (feedRepost.is_comment_anonym == 1) {
            b.d();
        }
        b.a(imageView);
        if (TextUtils.isEmpty(feedRepost.repost_timestamp)) {
            textView.setText("");
        } else {
            textView.setText(TimeAndDateUtils.g(this.f19611a, TimeAndDateUtils.c(feedRepost.repost_timestamp)));
        }
        if (TextUtils.isEmpty(feedRepost.user_name)) {
            textView2.setText("");
        } else if (TextUtils.isEmpty(feedRepost.note)) {
            textView2.setText(feedRepost.user_name.replace(":", ""));
        } else {
            textView2.setText(StringUtils.a(feedRepost.note, feedRepost.user_name.replace(":", "")));
        }
        int i = 0;
        final boolean a2 = FeedMethods.a(textView2, feedRepost.feed_uid, feedRepost.is_comment_anonym == 1);
        if (feedRepost.is_comment_anonym != 1) {
            i = 8;
        }
        imageView2.setVisibility(i);
        if (TextUtils.equals(feedRepost.feed_uid, UserInfoUtils.c())) {
            imageView2.setImageResource(R.drawable.feed_author_icon);
        } else {
            imageView2.setImageResource(R.drawable.anonymous_icon);
        }
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = feedRepost.vip_grade;
        userBasicModel.is_vip_annual = feedRepost.is_vip_annual;
        userBasicModel.is_hide_vip_look = feedRepost.is_hide_vip_look;
        userBasicModel.vip_exp_lvl = feedRepost.vip_exp_lvl;
        UserInfoHelper.a(this.f19611a, textView2, userBasicModel);
        UserInfoHelper.a(imageView4, userBasicModel);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsRepostListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (a2 || feedRepost.repost_uid.equals(UserInfoUtils.c())) {
                    return;
                }
                UserBasicModel userBasicModel2 = new UserBasicModel();
                userBasicModel2.uid = feedRepost.repost_uid;
                userBasicModel2.avatar = feedRepost.user_avatar;
                userBasicModel2.name = feedRepost.user_name;
                CommunityServiceManager.b().a(FeedDetailsRepostListAdapter.this.f19611a, userBasicModel2, FeedDetailsRepostListAdapter.this.d, FeedDetailsRepostListAdapter.this.f19612c, imageView);
            }
        };
        textView2.setOnClickListener(onClickListener);
        imageView.setOnClickListener(onClickListener);
        StringUtils.a(textView3, (CharSequence) feedRepost.repost_content, true, this.f19612c);
        a(baseViewHolder.getConvertView(), feedRepost);
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.adapter.FeedDetailsRepostListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                bluedIngSelfFeed.feed_id = feedRepost.repost_id;
                FeedDetailsFragment.a(FeedDetailsRepostListAdapter.this.f19611a, bluedIngSelfFeed, -1, new FeedDetailParams(0));
            }
        });
    }

    public void b() {
        RepostListDataObserver.b().b(this);
    }
}
