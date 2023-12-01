package com.blued.community.ui.video.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.video.fragment.VideoScanFragment;
import com.blued.community.ui.video.manager.ShineVideoDataManager;
import com.blued.community.utils.StringUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/ShineVideoListAdapter.class */
public class ShineVideoListAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20295a;
    public LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    public LoadOptions f20296c;
    public LoadOptions d;
    public IRequestHost e;
    public int f;
    public int g;

    /* renamed from: com.blued.community.ui.video.adapter.ShineVideoListAdapter$5  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/ShineVideoListAdapter$5.class */
    class AnonymousClass5 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20303a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f20303a.setScaleX(floatValue);
            this.f20303a.setScaleY(floatValue);
        }
    }

    /* renamed from: com.blued.community.ui.video.adapter.ShineVideoListAdapter$6  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/ShineVideoListAdapter$6.class */
    class AnonymousClass6 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20304a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f20304a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/ShineVideoListAdapter$ViewHolder.class */
    public class ViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f20306c;
        private ImageView d;
        private ImageView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private TextView i;
        private RelativeLayout j;
        private TextView k;

        public ViewHolder() {
        }
    }

    public ShineVideoListAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_video_list, new ArrayList());
        this.f20295a = context;
        this.b = LayoutInflater.from(context);
        int i = AppInfo.l;
        LoadOptions loadOptions = new LoadOptions();
        this.f20296c = loadOptions;
        loadOptions.l = false;
        this.f20296c.d = R.drawable.user_bg_round;
        this.f20296c.b = R.drawable.user_bg_round;
        int i2 = i >> 1;
        this.f20296c.a(i2, i2);
        LoadOptions loadOptions2 = new LoadOptions();
        this.d = loadOptions2;
        loadOptions2.d = R.drawable.defaultpicture;
        this.d.b = R.drawable.defaultpicture;
        this.e = iRequestHost;
        this.f = a(this.f20295a)[0];
        this.g = a(this.f20295a)[1];
    }

    private void a(TextView textView, String str) {
        textView.setText(StringUtils.a(StringUtils.a(str, (int) textView.getTextSize(), 0), false, true, false, ""));
    }

    public static int[] a(Context context) {
        int a2 = (AppInfo.l - DensityUtils.a(context, 23.0f)) / 2;
        return new int[]{a2, (a2 * 12) / 7};
    }

    public List<BluedIngSelfFeed> a(Collection<? extends BluedIngSelfFeed> collection) {
        List list = (List) collection;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                arrayList.add((BluedIngSelfFeed) list.get(i2));
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed) {
        if (baseViewHolder != null) {
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.b = (ImageView) baseViewHolder.getView(R.id.img_cover);
            viewHolder.d = (ImageView) baseViewHolder.getView(R.id.img_header);
            viewHolder.e = (ImageView) baseViewHolder.getView(R.id.img_follow_status);
            viewHolder.f = (TextView) baseViewHolder.getView(R.id.tv_like_count);
            viewHolder.g = (TextView) baseViewHolder.getView(R.id.tv_content);
            viewHolder.h = (TextView) baseViewHolder.getView(R.id.tv_recomment_text);
            viewHolder.i = (TextView) baseViewHolder.getView(R.id.tv_user_kol);
            viewHolder.j = (RelativeLayout) baseViewHolder.getView(R.id.rl_main);
            viewHolder.f20306c = (ImageView) baseViewHolder.getView(R.id.img_bg_btm);
            viewHolder.k = (TextView) baseViewHolder.getView(R.id.tv_long_video);
            if (bluedIngSelfFeed.feed_videos_duration * 1000.0d >= 60000.0d) {
                viewHolder.k.setVisibility(0);
            } else {
                viewHolder.k.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = viewHolder.j.getLayoutParams();
            layoutParams.width = this.f;
            layoutParams.height = this.g;
            viewHolder.j.setLayoutParams(layoutParams);
            if (bluedIngSelfFeed.feed_videos == null || bluedIngSelfFeed.feed_videos.length <= 0) {
                viewHolder.b.setImageResource(R.drawable.defaultpicture);
            } else {
                ImageLoader.a(this.e, bluedIngSelfFeed.feed_videos[0]).b(R.color.default_place_color).a(new ImageLoadResult(this.e) { // from class: com.blued.community.ui.video.adapter.ShineVideoListAdapter.1
                    @Override // com.blued.android.core.image.ImageLoadResult
                    public void a() {
                        Drawable drawable = viewHolder.b.getDrawable();
                        if (drawable == null) {
                            viewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        } else if (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight()) {
                            viewHolder.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        } else {
                            viewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    }
                }).a(viewHolder.b);
            }
            viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.ShineVideoListAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (CommunityServiceManager.a().k()) {
                        return;
                    }
                    EventTrackFeed.b(FeedProtos.Event.FLASH_PLAY_LIST_ONE_CLICK, bluedIngSelfFeed.feed_id);
                    CommunityHttpUtils.a(bluedIngSelfFeed.click_url);
                    CommunityServiceManager.d().a("shine_video_list_click", bluedIngSelfFeed.feed_id);
                    VideoScanFragment.a(ShineVideoListAdapter.this.f20295a, bluedIngSelfFeed);
                }
            });
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewHolder.g.getLayoutParams();
            if (TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
                layoutParams2.height = DensityUtils.a(this.f20295a, 5.0f);
                viewHolder.g.setText("");
            } else {
                layoutParams2.height = -2;
                a(viewHolder.g, bluedIngSelfFeed.feed_content);
            }
            viewHolder.g.setLayoutParams(layoutParams2);
            if (TextUtils.isEmpty(bluedIngSelfFeed.kol_name)) {
                viewHolder.i.setVisibility(8);
            } else {
                viewHolder.i.setVisibility(0);
                viewHolder.i.setText(bluedIngSelfFeed.kol_name);
            }
            if (bluedIngSelfFeed.is_recommend_ticktocks != 1 || TextUtils.isEmpty(bluedIngSelfFeed.recommend_text)) {
                viewHolder.h.setVisibility(8);
            } else {
                viewHolder.h.setVisibility(0);
                viewHolder.h.setText(bluedIngSelfFeed.recommend_text);
            }
            if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_content) || ((bluedIngSelfFeed.is_recommend_ticktocks == 1 && !TextUtils.isEmpty(bluedIngSelfFeed.recommend_text)) || !TextUtils.isEmpty(bluedIngSelfFeed.kol_name))) {
                viewHolder.f20306c.setVisibility(0);
            } else {
                viewHolder.f20306c.setVisibility(8);
            }
            ImageLoader.a(this.e, AvatarUtils.a(0, bluedIngSelfFeed.user_avatar)).b(R.drawable.user_bg_round).a(1.0f, this.f20295a.getResources().getColor(R.color.syc_shine_b)).a(viewHolder.d);
            viewHolder.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.ShineVideoListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    UserBasicModel userBasicModel = new UserBasicModel();
                    userBasicModel.uid = bluedIngSelfFeed.feed_uid;
                    userBasicModel.avatar = bluedIngSelfFeed.user_avatar;
                    userBasicModel.name = bluedIngSelfFeed.user_name;
                    LogData logData = new LogData();
                    logData.feed_id = bluedIngSelfFeed.feed_id;
                    CommunityServiceManager.b().a(ShineVideoListAdapter.this.f20295a, userBasicModel, "shine_video_list", false, (View) null, logData, MessageProtos.StrangerSource.FIND_PLAZA_FLASH);
                }
            });
            if (bluedIngSelfFeed.feed_dig == 0) {
                viewHolder.f.setText("");
            } else {
                viewHolder.f.setText(DistanceUtils.a(this.f20295a, Long.valueOf(bluedIngSelfFeed.feed_dig)));
            }
            if ("1".equalsIgnoreCase(bluedIngSelfFeed.relationship) || "3".equalsIgnoreCase(bluedIngSelfFeed.relationship)) {
                viewHolder.e.setVisibility(8);
            } else {
                viewHolder.e.setImageResource(R.drawable.icon_video_list_add_follow);
                viewHolder.e.setVisibility(0);
                viewHolder.e.setScaleX(1.0f);
                viewHolder.e.setScaleY(1.0f);
                viewHolder.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.ShineVideoListAdapter.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        CommunityServiceManager.d().a(0, bluedIngSelfFeed.feed_uid);
                        bluedIngSelfFeed.relationship = "1";
                        viewHolder.e.setImageResource(R.drawable.icon_video_list_followed);
                        CommunityHttpUtils.b(ShineVideoListAdapter.this.f20295a, new CommunityHttpUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.community.ui.video.adapter.ShineVideoListAdapter.4.1
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
                            }

                            @Override // com.blued.community.http.CommunityHttpUtils.IAddOrRemoveAttentionDone
                            public void c() {
                                bluedIngSelfFeed.relationship = "0";
                                ShineVideoListAdapter.this.notifyDataSetChanged();
                            }
                        }, bluedIngSelfFeed.feed_uid, "shine_video_list", ShineVideoListAdapter.this.e);
                        viewHolder.e.setImageResource(R.drawable.icon_video_list_followed);
                        ShineVideoDataManager.a().a(bluedIngSelfFeed.feed_id, bluedIngSelfFeed.relationship);
                        EventTrackFeed.a(bluedIngSelfFeed.feed_uid, "", "", FeedProtos.FollowLocation.FOLLOW_PLAZA_FLASH, true, bluedIngSelfFeed.live > 0, bluedIngSelfFeed.in_promotion == 1, bluedIngSelfFeed.strong_insert_data);
                    }
                });
            }
            if (bluedIngSelfFeed.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.FEED_DRAW, bluedIngSelfFeed, TextUtils.isEmpty(bluedIngSelfFeed.super_did) ? "" : bluedIngSelfFeed.super_did, FeedProtos.FeedClass.FEED_VIDEO, FeedProtos.FeedPage.PLAZA_FLASH_LIST);
            CommunityServiceManager.d().a(5, bluedIngSelfFeed.feed_id, bluedIngSelfFeed.recommend_text, bluedIngSelfFeed.feed_uid);
            CommunityHttpUtils.a(bluedIngSelfFeed.show_url);
            bluedIngSelfFeed.isShowUrlVisited = true;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends BluedIngSelfFeed> collection) {
        super.addData((Collection) a(collection));
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<BluedIngSelfFeed> list) {
        super.setNewData(a(list));
        notifyDataSetChanged();
    }
}
