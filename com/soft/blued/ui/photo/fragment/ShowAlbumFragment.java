package com.soft.blued.ui.photo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.community.ui.feed.observer.LikeListDataObserver;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.ui.square.fragment.HotFeedFragment;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.StringUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.github.chrisbanes.photoview.PhotoView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.photo.observer.AlbumDownLoadObserver;
import com.soft.blued.ui.photo.observer.PhotoListPositionObserver;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.observer.AlbumDataObserver;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowAlbumFragment.class */
public class ShowAlbumFragment extends BasePhotoFragment implements View.OnClickListener, IFeedDataObserver, FeedRefreshObserver.IFeedRefreshObserver {

    /* renamed from: c  reason: collision with root package name */
    public static AlbumForDataTrans f19375c;
    private LinearLayout A;
    private ImageView B;
    private TextView C;
    private LinearLayout D;
    private TextView E;
    private LinearLayout F;
    private ImageView G;
    private TextView H;
    private ImageView I;
    private LinearLayout J;
    private ImageView K;
    private LinearLayout L;
    private ImageView M;
    private TextView N;
    private ShapeLinearLayout O;
    private TextView P;
    private ImageView Q;
    private View R;
    private FlowLayout S;
    private boolean W;
    private int X;
    private String Y;
    private String Z;
    private View aa;
    private TextView ab;
    private int ac;
    private View ad;
    private boolean ae;
    private AlbumFlow af;
    public LinearLayout d;
    public TextView e;
    private Context h;
    private View i;
    private LayoutInflater j;
    private ImagePagerAdapter k;
    private LoadOptions l;
    private int m;
    private int n;
    private int o;
    private AlbumFlow q;
    private Dialog r;
    private HackyViewPager s;
    private LinearLayout t;
    private TextViewFixTouchForDynamic u;
    private LinearLayout v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private List<AlbumFlow> p = new ArrayList();
    private boolean T = true;
    private boolean U = true;
    private boolean V = true;
    AlbumViewDataManager.IAlbumDataListener f = new AlbumViewDataManager.IAlbumDataListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.2
        @Override // com.soft.blued.ui.photo.manager.AlbumViewDataManager.IAlbumDataListener
        public void a() {
            AlbumDownLoadObserver.a().b();
        }

        @Override // com.soft.blued.ui.photo.manager.AlbumViewDataManager.IAlbumDataListener
        public void a(boolean z, List<AlbumFlow> list) {
            Log.v("drb", "onDownloadSuccess");
            int currentItem = ShowAlbumFragment.this.s.getCurrentItem();
            ShowAlbumFragment.this.p.clear();
            if (list != null) {
                ShowAlbumFragment.this.p.addAll(list);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ShowAlbumFragment.this.p.size()) {
                    break;
                }
                AlbumFlow albumFlow = (AlbumFlow) ShowAlbumFragment.this.p.get(i2);
                if (albumFlow != null) {
                    Logger.a("drb", "id = ", Integer.valueOf(i2), "name = ", albumFlow.user_name, "-- ", Boolean.valueOf(albumFlow.isOccupyModel));
                }
                i = i2 + 1;
            }
            if (z) {
                ShowAlbumFragment.this.p.add(ShowAlbumFragment.this.k());
            }
            ShowAlbumFragment.this.s.setAdapter(ShowAlbumFragment.this.k);
            ShowAlbumFragment.this.s.setCurrentItem(currentItem);
        }
    };
    BluedUIHttpResponse g = new BluedUIHttpResponse<BluedEntityA<FeedComment>>() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.19
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    LiveEventBus.get("feed_add_comment").post((FeedComment) bluedEntityA.data.get(0));
                    AppMethods.a(ShowAlbumFragment.this.getString(R.string.commented));
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a(ShowAlbumFragment.this.h.getResources().getString(2131887272));
                }
            }
        }

        public void onUIFinish() {
            DialogUtils.b(ShowAlbumFragment.this.r);
        }

        public void onUIStart() {
            DialogUtils.a(ShowAlbumFragment.this.r);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowAlbumFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentPagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ShowAlbumFragment.this.p.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            String str;
            AlbumFlow albumFlow = (AlbumFlow) ShowAlbumFragment.this.p.get(i);
            if (ShowAlbumFragment.this.b(albumFlow)) {
                return GlassDetailFragment.a(albumFlow.album_pic, false, ShowAlbumFragment.this.X, i, albumFlow.album_pics_num);
            }
            if (!ShowAlbumFragment.this.a(albumFlow)) {
                if (albumFlow.isOccupyModel) {
                    return OccupyDetailFragment.a(ShowAlbumFragment.this.X, i);
                }
                String str2 = ShowAlbumFragment.this.X == 10 ? (albumFlow.feed_pics == null || albumFlow.feed_pics.length <= 0) ? "" : albumFlow.feed_pics[0] : albumFlow.album_pic;
                LogData logData = new LogData();
                logData.id = ShowAlbumFragment.this.af != null ? ShowAlbumFragment.this.af.feed_id : "";
                logData.url = str2;
                logData.type = "0";
                logData.logService = "feed_full_screen_show";
                InstantLog.a(logData);
                Log.v("drb", "getItem 个人主页-相册页面-【图片/视频】全屏页-曝光 ：0");
                return BizPhotoDetailFragment.a(str2, ShowAlbumFragment.this.X, ShowAlbumFragment.this.l, albumFlow.feed_id, albumFlow.uid);
            }
            String[] strArr = albumFlow.feed_videos;
            String str3 = null;
            if (strArr == null || strArr.length <= 1) {
                str = null;
            } else {
                str3 = strArr[0];
                str = strArr[1];
            }
            String[] strArr2 = albumFlow.feed_videos_width;
            if (strArr2 != null && strArr2.length > 0) {
                Integer.valueOf(strArr2[0]).intValue();
            }
            String[] strArr3 = albumFlow.feed_videos_height;
            if (strArr3 != null && strArr3.length > 0) {
                Integer.valueOf(strArr3[0]).intValue();
            }
            float f = 0.0f;
            if (!TextUtils.isEmpty(albumFlow.feed_video_size)) {
                try {
                    f = Float.parseFloat(albumFlow.feed_video_size);
                } catch (Exception e) {
                    e.printStackTrace();
                    f = 0.0f;
                }
            }
            long j = f;
            Logger.a("drb", "albumVideoPath = ", str);
            LogData logData2 = new LogData();
            logData2.id = ShowAlbumFragment.this.af != null ? ShowAlbumFragment.this.af.feed_id : "";
            logData2.url = str3;
            logData2.type = "1";
            logData2.logService = "feed_full_screen_show";
            InstantLog.a(logData2);
            VideoPlayConfig d = BizVideoDetailFragment.d();
            d.a = str3;
            d.b = str;
            d.c = j;
            Log.v("drb", "getItem 个人主页-相册页面-【图片/视频】全屏页-曝光 ：1");
            return BizVideoDetailFragment.a(d, ShowAlbumFragment.this.X, albumFlow.feed_id, albumFlow.uid);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return ((AlbumFlow) ShowAlbumFragment.this.p.get(i)).hashCode();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public static String a(int i, int i2) {
        String str;
        if (i == 0) {
            str = "feed_followed";
        } else if (i == 2) {
            str = "feed_detail";
        } else if (i == 14) {
            str = "PAGE_FEED_DETAIL_MORE";
        } else if (i == 19) {
            str = "feed_city_time";
        } else if (i == 4) {
            str = "feed_nearby";
        } else if (i == 5) {
            str = "topic_detail";
        } else if (i == 6) {
            str = "feed_square";
        } else if (i == 29) {
            str = "sunject_recommend";
        } else if (i != 30) {
            switch (i) {
                case 10:
                    str = "feed_image";
                    break;
                case 11:
                    str = "PAGE_FEED_MINE";
                    break;
                case 12:
                    str = "PAGE_FEED_LIKE";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "sunject_latest";
        }
        String str2 = str;
        if (i2 == 1) {
            str2 = str + "_vote";
        }
        return str2;
    }

    private void a(BluedIngSelfFeed bluedIngSelfFeed, int i) {
        Log.v("drb", "refreshZan liked:" + i);
        if (i == 0 || i == 1) {
            bluedIngSelfFeed.iliked = i;
            int i2 = bluedIngSelfFeed.feed_dig;
            int i3 = i == 1 ? i2 + 1 : i2 - 1;
            int i4 = i3;
            if (i3 < 0) {
                i4 = 0;
            }
            bluedIngSelfFeed.feed_dig = i4;
            Log.v("drb", "refreshZan likeCount:" + i4);
            e(bluedIngSelfFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedIngSelfFeed bluedIngSelfFeed, int i, String str) {
        FeedHttpUtils.a(this.h, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.20
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), bluedIngSelfFeed.feed_id, i, str, getFragmentActive());
    }

    private void a(TextViewFixTouchForDynamic textViewFixTouchForDynamic, String str) {
        CharSequence a2 = StringUtils.a(com.soft.blued.utils.StringUtils.a(MarkDownLinkHelper.a(AppInfo.d(), com.soft.blued.utils.StringUtils.a(str, (int) textViewFixTouchForDynamic.getTextSize(), 0), true, 2131102270, true, (MarkDownLinkHelper.MDLinkOnClickListener) null), true, true, true, ""), true, new boolean[0]);
        ViewGroup.LayoutParams layoutParams = textViewFixTouchForDynamic.getLayoutParams();
        layoutParams.width = AppInfo.l - DensityUtils.a(this.h, 20.0f);
        textViewFixTouchForDynamic.setMoeTextColor(this.h.getResources().getColor(2131102478), false);
        textViewFixTouchForDynamic.setLayoutParams(layoutParams);
        textViewFixTouchForDynamic.setMaxWidth(layoutParams.width);
        textViewFixTouchForDynamic.setMaxLines(2);
        textViewFixTouchForDynamic.setExpandText(a2);
        textViewFixTouchForDynamic.setMovementMethod(LinkMovementClickMethod.a());
    }

    private void a(boolean z, boolean z2) {
        if (this.W) {
            return;
        }
        if (z2) {
            this.ac = 2;
        }
        this.I.setVisibility(8);
        this.t.setVisibility(8);
        this.ab.setVisibility(8);
        if (!z) {
            this.W = false;
            this.T = false;
            this.U = false;
            this.V = false;
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_out);
        this.t.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.h, 2130772121);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.h, 2130772121);
        this.I.startAnimation(loadAnimation2);
        this.ab.startAnimation(loadAnimation3);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ShowAlbumFragment.this.W = false;
                ShowAlbumFragment.this.T = false;
                ShowAlbumFragment.this.U = false;
                ShowAlbumFragment.this.V = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ShowAlbumFragment.this.W = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlbumFlow albumFlow) {
        return albumFlow != null && "1".equals(albumFlow.is_videos);
    }

    private void b(boolean z, boolean z2) {
        if (this.W) {
            return;
        }
        if (z2) {
            this.ac = 1;
        }
        this.I.setVisibility(0);
        if (this.p.size() > 1) {
            this.ab.setVisibility(0);
        }
        this.t.setVisibility(0);
        AlbumFlow albumFlow = this.af;
        if (albumFlow == null || albumFlow.isFeed != 0) {
            this.L.setVisibility(0);
            this.J.setVisibility(8);
        } else {
            this.L.setVisibility(8);
            this.J.setVisibility(0);
        }
        if (!z) {
            this.W = false;
            this.T = true;
            this.U = true;
            this.V = true;
            return;
        }
        this.t.startAnimation(AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_in));
        Animation loadAnimation = AnimationUtils.loadAnimation(this.h, 2130772120);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.h, 2130772120);
        this.I.startAnimation(loadAnimation);
        this.ab.startAnimation(loadAnimation2);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ShowAlbumFragment.this.W = false;
                ShowAlbumFragment.this.T = true;
                ShowAlbumFragment.this.U = true;
                ShowAlbumFragment.this.V = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ShowAlbumFragment.this.W = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(AlbumFlow albumFlow) {
        boolean z = false;
        if (albumFlow != null) {
            z = false;
            if (albumFlow.album_status == 0) {
                z = false;
                if (!albumFlow.isSelf) {
                    z = true;
                }
            }
        }
        return z;
    }

    private void c(View view) {
        if (!(view instanceof PhotoView)) {
            Log.v("drb", "");
            return;
        }
        PhotoView photoView = (PhotoView) view;
        LogData logData = new LogData();
        AlbumFlow albumFlow = this.af;
        logData.id = albumFlow != null ? albumFlow.feed_id : "";
        logData.from = "6";
        logData.logService = "feed_pic_click";
        AlbumFlow albumFlow2 = this.af;
        logData.type = albumFlow2 != null ? albumFlow2.recommend_text : "";
        InstantLog.a(logData);
        Logger.a("drb", "setPhotoClick");
        if (photoView.getScale() <= ((int) photoView.getMinimumScale())) {
            m();
            return;
        }
        photoView.a(photoView.getMinimumScale(), true);
        if (this.T) {
            return;
        }
        b(true, true);
    }

    private void d(BluedIngSelfFeed bluedIngSelfFeed) {
        View a2 = ViewUtils.a(this.h, this.S, bluedIngSelfFeed.is_top_hot, new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.a(FeedProtos.Event.HOT_FEED_ICON_CLICK, ShowAlbumFragment.this.af.feed_id, FeedProtos.FeedPage.HOT_FEED_IMAGE);
                HotFeedFragment.a.a(ShowAlbumFragment.this.h);
            }
        });
        ShapeLinearLayout findViewById = a2.findViewById(R.id.sll_top_hot);
        ShapeHelper.b(findViewById, (int) R.color.color_1B1B1B);
        ShapeHelper.d(findViewById, (int) R.color.color_1B1B1B);
        ((TextView) a2.findViewById(R.id.tv_top_hot)).setTextColor(BluedSkinUtils.a(this.h, 2131102177));
        if (bluedIngSelfFeed.is_top_hot == 1) {
            this.R.setVisibility(0);
        } else {
            this.R.setVisibility(8);
        }
    }

    private void e(final BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.is_vote == 1) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                InstantLog.a(11, bluedIngSelfFeed, "", -1);
                if (!UserInfoHelper.a(bluedIngSelfFeed.relationship)) {
                    if (bluedIngSelfFeed.iliked == 0) {
                        bluedIngSelfFeed.iliked = 1;
                        LikeListDataObserver.a().a(UserInfo.getInstance().getLoginUserInfo().getUid(), bluedIngSelfFeed.iliked);
                        LiveEventBus.get("feed_like_change").post(bluedIngSelfFeed);
                        ShowAlbumFragment showAlbumFragment = ShowAlbumFragment.this;
                        BluedIngSelfFeed bluedIngSelfFeed2 = bluedIngSelfFeed;
                        showAlbumFragment.a(bluedIngSelfFeed2, bluedIngSelfFeed2.is_ads, bluedIngSelfFeed.liked_url);
                    } else {
                        bluedIngSelfFeed.iliked = 0;
                        LikeListDataObserver.a().a(UserInfo.getInstance().getLoginUserInfo().getUid(), bluedIngSelfFeed.iliked);
                        LiveEventBus.get("feed_like_change").post(bluedIngSelfFeed);
                        ShowAlbumFragment.this.g(bluedIngSelfFeed);
                    }
                    if (bluedIngSelfFeed.feed_dig == 0) {
                        ShowAlbumFragment.this.H.setText(R.string.zan);
                    } else {
                        ShowAlbumFragment.this.H.setText(DistanceUtils.a(ShowAlbumFragment.this.h, Long.valueOf(bluedIngSelfFeed.feed_dig)));
                    }
                }
                if (!ShowAlbumFragment.this.q()) {
                    EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_LIKE_CLICK, bluedIngSelfFeed.feed_uid, bluedIngSelfFeed.feed_id);
                    return;
                }
                AlbumFlow albumFlow = ShowAlbumFragment.this.af;
                ShowAlbumFragment showAlbumFragment2 = ShowAlbumFragment.this;
                EventTrackFeed.a(albumFlow, !showAlbumFragment2.a(showAlbumFragment2.af) ? FeedProtos.SourcePage.FEED_IMAGE_FULL_SCREEN_SOURCE : FeedProtos.SourcePage.PERSONAL_VIDEO_FULL_SCREEN_SOURCE, false);
            }
        });
        f(bluedIngSelfFeed);
    }

    private void f(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.iliked == 0) {
            this.G.setImageResource(R.drawable.album_like_icon);
            this.H.setTextColor(this.h.getResources().getColor(2131102478));
        } else {
            ImageLoader.a(getFragmentActive(), (int) R.drawable.album_ilike_icon).a(this.G);
            this.H.setTextColor(this.h.getResources().getColor(R.color.feed_like));
        }
        if (bluedIngSelfFeed.feed_dig == 0) {
            this.H.setText(R.string.zan);
        } else {
            this.H.setText(DistanceUtils.a(this.h, Long.valueOf(bluedIngSelfFeed.feed_dig)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(BluedIngSelfFeed bluedIngSelfFeed) {
        FeedHttpUtils.a(this.h, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.21
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), bluedIngSelfFeed.feed_id, bluedIngSelfFeed.is_ads, getFragmentActive());
    }

    private void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.X = getArguments().getInt("show_photo");
            this.Y = getArguments().getString("WATER_MASK_NAME");
            this.Z = getArguments().getString("TARGET_UID");
            this.m = arguments.getInt("photo_index", 0);
            this.o = arguments.getInt("REQUEST_CODE_KEY", 0);
            this.l = arguments.getSerializable("photo_options");
            List list = (List) arguments.getSerializable("photo_datas");
            this.n = this.m;
            Log.v("drb", "mComeCode:" + this.X + " mCurrentPosition:" + this.m);
            int i = this.X;
            if (i != 6 && i != 15) {
                this.p.addAll(list);
            } else if (f19375c != null) {
                boolean d = AlbumViewDataManager.a().d();
                this.p.addAll(f19375c.data);
                if (d && this.X != 15) {
                    this.p.add(k());
                }
                f19375c = null;
            }
        }
    }

    private void i() {
        this.r = DialogUtils.a(getActivity());
        this.j = LayoutInflater.from(this.h);
        this.s = (HackyViewPager) this.i.findViewById(2131368810);
        this.t = (LinearLayout) this.i.findViewById(R.id.bottom_layout);
        this.u = (TextViewFixTouchForDynamic) this.i.findViewById(R.id.feed_content);
        this.ad = this.i.findViewById(R.id.feed_content_layout);
        this.v = (LinearLayout) this.i.findViewById(R.id.ll_distance_and_time);
        this.w = (TextView) this.i.findViewById(R.id.tv_user_kol);
        this.x = (TextView) this.i.findViewById(R.id.distance_view);
        this.y = (TextView) this.i.findViewById(R.id.time_view);
        this.z = (TextView) this.i.findViewById(R.id.tv_feed_time);
        this.A = (LinearLayout) this.i.findViewById(R.id.ll_details_share);
        this.B = (ImageView) this.i.findViewById(R.id.icon_share);
        this.C = (TextView) this.i.findViewById(R.id.tv_share_count);
        this.D = (LinearLayout) this.i.findViewById(R.id.ll_details_comments);
        this.E = (TextView) this.i.findViewById(R.id.comment_num_view);
        this.F = (LinearLayout) this.i.findViewById(R.id.zan_view);
        this.G = (ImageView) this.i.findViewById(R.id.zan_num_icon);
        this.H = (TextView) this.i.findViewById(R.id.zan_num_text);
        this.J = (LinearLayout) this.i.findViewById(R.id.album_layout);
        this.K = (ImageView) this.i.findViewById(R.id.private_album_icon);
        this.L = (LinearLayout) this.i.findViewById(R.id.feed_layout);
        this.M = (ImageView) this.i.findViewById(2131364232);
        this.N = (TextView) this.i.findViewById(R.id.tv_age_height_weight);
        this.P = (TextView) this.i.findViewById(R.id.name_view);
        this.Q = (ImageView) this.i.findViewById(R.id.iv_anonymous);
        this.O = this.i.findViewById(R.id.follow_status_view);
        this.d = (LinearLayout) this.i.findViewById(R.id.location_layout);
        this.e = (TextView) this.i.findViewById(R.id.location_text);
        this.R = this.i.findViewById(R.id.layout_super_topic);
        this.S = this.i.findViewById(R.id.flow_layout_topics_and_hot);
        ImageView imageView = (ImageView) this.i.findViewById(R.id.close_album_btn);
        this.I = imageView;
        imageView.setOnClickListener(this);
        View findViewById = this.i.findViewById(R.id.tv_delete);
        this.aa = findViewById;
        findViewById.setOnClickListener(this);
        this.ab = (TextView) this.i.findViewById(R.id.tv_position);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.k = imagePagerAdapter;
        this.s.setAdapter(imagePagerAdapter);
        this.s.setCurrentItem(this.m);
        this.aa.setVisibility(8);
        this.s.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ShowAlbumFragment.this.m = i;
                ShowAlbumFragment.this.o();
                ShowAlbumFragment.this.j();
            }
        });
        o();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.p.size() <= 1) {
            this.ab.setVisibility(8);
            return;
        }
        TextView textView = this.ab;
        textView.setText((this.m + 1) + "/" + this.p.size());
        this.ab.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlbumFlow k() {
        if (this.q == null) {
            AlbumFlow albumFlow = new AlbumFlow();
            this.q = albumFlow;
            albumFlow.isOccupyModel = true;
            this.q.album_status = 1;
            this.q.isFeed = 1;
        }
        return this.q;
    }

    private void l() {
    }

    private void m() {
        if (this.W) {
            return;
        }
        if (this.T) {
            Logger.a("drb", "pushOutBottomLayout");
            a(true, true);
            return;
        }
        Logger.a("drb", "pushInBottomLayout");
        b(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        final AlbumFlow albumFlow = this.p.get(this.m);
        if (albumFlow == null || albumFlow.isFeed != 1) {
            Context context = this.h;
            CommonAlertDialog.a(context, (String) null, context.getResources().getString(R.string.album_del_photo), this.h.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    final String str = ((AlbumFlow) ShowAlbumFragment.this.p.get(ShowAlbumFragment.this.m)).pid;
                    ProfileHttpUtils.b(ShowAlbumFragment.this.h, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.7.1
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                            try {
                                List album = UserInfo.getInstance().getLoginUserInfo().getAlbum();
                                if (album != null && album.size() > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 >= album.size()) {
                                            break;
                                        }
                                        if (((BluedAlbum) album.get(i3)).getPid().equals(str)) {
                                            LiveEventBus.get("remove_album").post(str);
                                        } else {
                                            arrayList.add((BluedAlbum) album.get(i3));
                                        }
                                        i2 = i3 + 1;
                                    }
                                    UserInfo.getInstance().getLoginUserInfo().setAlbum(arrayList);
                                }
                                AlbumDataObserver.a().a(false, str);
                                if (bluedEntityA.code == 200) {
                                    AppMethods.d((int) R.string.done);
                                } else {
                                    AppMethods.d(2131887272);
                                }
                                ShowAlbumFragment.this.g();
                            } catch (Exception e) {
                                e.printStackTrace();
                                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                            }
                        }

                        public void onUIFinish() {
                            DialogUtils.b(ShowAlbumFragment.this.r);
                            if (ShowAlbumFragment.this.p.size() == 0) {
                                ShowAlbumFragment.this.f();
                            }
                        }
                    }, str, (IRequestHost) ShowAlbumFragment.this.getFragmentActive());
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            return;
        }
        Context context2 = this.h;
        CommonAlertDialog.a(context2, (String) null, context2.getResources().getString(R.string.album_del_feed), this.h.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ShowAlbumFragment.this.c((BluedIngSelfFeed) albumFlow);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z;
        Log.v("drb", "setPositionData mDataList.size():" + this.p.size() + " mCurrentPosition:" + this.m);
        if (this.p.size() != 0) {
            int size = this.p.size();
            int i = this.m;
            if (size <= i) {
                return;
            }
            this.af = this.p.get(i);
            PersonalProfileProtos.Source source = PersonalProfileProtos.Source.UNKNOWN_FOLLOW_SOURCE;
            if (getArguments() != null) {
                PersonalProfileProtos.Source e = EventTrackFeed.e(getArguments().getInt("from_feed_list_page", -1));
                source = e;
                if (e == PersonalProfileProtos.Source.PERSONAL_VIDEO_FULL_SCREEN) {
                    source = PersonalProfileProtos.Source.PERSONAL_FEED;
                }
            }
            if (!com.soft.blued.utils.StringUtils.d(this.af.feed_id)) {
                LogData logData = new LogData();
                logData.id = this.af.feed_id;
                if (a(this.af)) {
                    if (this.af.feed_videos != null && this.af.feed_videos.length > 1) {
                        logData.url = this.af.feed_videos[1];
                    }
                    logData.type = "1";
                    Log.v("drb", "个人主页-相册页面-【图片/视频】全屏页-曝光 true");
                    if (AudioChannelManager.j().n()) {
                        AppMethods.a(getActivity().getResources().getText(R.string.yy_in_use));
                        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ShowAlbumFragment.this.f();
                            }
                        }, 300L);
                    }
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.FEED_FULL_SCREEN_SHOW, this.af.feed_uid, logData.id, 1, logData.url);
                    z = true;
                } else {
                    logData.url = this.X == 10 ? (this.af.feed_pics == null || this.af.feed_pics.length <= 0) ? "" : this.af.feed_pics[0] : this.af.album_pic;
                    logData.type = "0";
                    Log.v("drb", "个人主页-相册页面-【图片/视频】全屏页-曝光 false");
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.FEED_FULL_SCREEN_SHOW, this.af.feed_uid, logData.id, 0, logData.url);
                    z = false;
                }
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PHOTO_PAGE_PHOTO_SHOW, this.af, z, source);
                logData.logService = "feed_full_screen_show";
                InstantLog.a(logData);
            }
            AlbumFlow albumFlow = this.af;
            if (albumFlow == null) {
                return;
            }
            if (b(albumFlow)) {
                if (this.T) {
                    a(false, false);
                }
                this.I.setVisibility(0);
            } else if (this.af.isFeed == 0) {
                if (this.af.album_status == 0) {
                    this.K.setImageResource(R.drawable.icon_userinfo_album_center_lock);
                } else {
                    this.K.setImageResource(R.drawable.icon_userinfo_album_unlock);
                }
            }
            if (!b(this.af)) {
                int i2 = this.ac;
                if (i2 == 0 || i2 == 1) {
                    b(false, false);
                    if (this.af.isFeed == 0) {
                        this.L.setVisibility(8);
                        this.J.setVisibility(0);
                    } else {
                        this.L.setVisibility(0);
                        this.J.setVisibility(8);
                    }
                } else if (i2 == 2) {
                    a(false, false);
                }
            }
            if (this.af.isOccupyModel) {
                this.v.setVisibility(8);
            }
            ImageWrapper c2 = ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, this.af.user_avatar)).b(2131237310).c();
            if (this.af.is_feed_anonym == 1) {
                c2.d();
            }
            c2.a(this.M);
            this.P.setText(!TextUtils.isEmpty(this.af.note) ? this.af.note : this.af.user_name);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = this.af.vip_grade;
            userBasicModel.is_vip_annual = this.af.is_vip_annual;
            userBasicModel.is_hide_vip_look = this.af.is_hide_vip_look;
            userBasicModel.vip_exp_lvl = this.af.vip_exp_lvl;
            UserInfoHelper.a(this.h, this.P, userBasicModel, 2131102478);
            if (this.af.is_feed_anonym == 1) {
                FeedMethods.a(this.P, this.af.feed_uid, true);
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.af.feed_content)) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                a(this.u, this.af.feed_content);
            }
            if (this.af.activity_data == null || com.soft.blued.utils.StringUtils.d(this.af.activity_data.id)) {
                this.z.setVisibility(8);
                if (TextUtils.isEmpty(this.af.kol_name)) {
                    this.w.setVisibility(8);
                } else {
                    this.w.setText(this.af.kol_name);
                    this.w.setVisibility(0);
                }
                if (com.soft.blued.utils.StringUtils.d(this.af.distance)) {
                    this.x.setVisibility(8);
                } else {
                    this.x.setText(DistanceUtils.a(this.af.distance, BlueAppLocal.c(), true));
                    this.x.setVisibility(0);
                }
                Log.v("drb", "setPositionData location:" + this.af.location + "  distance:" + this.af.distance + " -- " + this.af.is_hide_distance);
                DistanceUtils.a(this.h, this.x, this.af.is_hide_distance, 0);
                if (TextUtils.equals(this.af.feed_uid, UserInfo.getInstance().getLoginUserInfo().getUid())) {
                    this.x.setVisibility(8);
                }
                if (UserInfoHelper.c(this.af.vbadge)) {
                    this.N.setVisibility(8);
                } else if (this.af.age > 0 || this.af.height > 0 || this.af.weight > 0) {
                    this.N.setVisibility(0);
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(this.af.distance) || !TextUtils.isEmpty(this.af.location) || this.af.is_hide_distance == 1) {
                        sb.append(" · ");
                    }
                    if (this.af.age > 0) {
                        sb.append(this.af.age);
                    } else {
                        sb.append(Constants.WAVE_SEPARATOR);
                    }
                    sb.append(this.h.getString(R.string.cut_point));
                    if (this.af.height > 0) {
                        sb.append(this.af.height);
                    } else {
                        sb.append(Constants.WAVE_SEPARATOR);
                    }
                    sb.append(this.h.getString(R.string.cut_point));
                    if (this.af.weight > 0) {
                        sb.append(this.af.weight);
                    } else {
                        sb.append(Constants.WAVE_SEPARATOR);
                    }
                    this.N.setText(sb.toString());
                } else {
                    this.N.setVisibility(8);
                }
                if (TextUtils.equals(this.af.feed_uid, UserInfo.getInstance().getLoginUserInfo().getUid())) {
                    this.N.setVisibility(8);
                }
                if (TextUtils.equals(this.af.feed_uid, UserInfo.getInstance().getLoginUserInfo().getUid()) || a(this.af.relationship) || this.af.is_feed_anonym == 1) {
                    this.O.setVisibility(8);
                } else {
                    this.O.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.af.feed_timestamp)) {
                    this.y.setText("");
                } else {
                    this.y.setText(TimeAndDateUtils.c(this.h, TimeAndDateUtils.c(this.af.feed_timestamp)));
                }
            } else {
                this.w.setVisibility(8);
                this.x.setVisibility(8);
                this.N.setVisibility(8);
                this.O.setVisibility(8);
                this.y.setVisibility(8);
                this.z.setVisibility(0);
                String e2 = TimeAndDateUtils.e(this.h, TimeAndDateUtils.c(this.af.feed_timestamp));
                if (TextUtils.isEmpty(e2)) {
                    this.z.setText("");
                } else {
                    this.z.setText(e2);
                }
            }
            e((BluedIngSelfFeed) this.af);
            if (this.af.feed_comment == 0) {
                this.E.setText(R.string.comment);
            } else {
                this.E.setText(DistanceUtils.a(this.h, String.valueOf(this.af.feed_comment)) + "");
            }
            if (TextUtils.isEmpty(this.af.location)) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.e.setText(this.af.location);
            }
            d((BluedIngSelfFeed) this.af);
            if (this.af.feed_is_delete == 1 || this.af.disallow_share == 1) {
                this.B.setImageDrawable(BluedSkinUtils.b(this.h, (int) R.drawable.album_unshare_icon));
                this.C.setTextColor(BluedSkinUtils.a(this.h, 2131101543));
                this.A.setEnabled(false);
            } else {
                this.B.setImageDrawable(BluedSkinUtils.b(this.h, (int) R.drawable.album_share_icon));
                this.C.setTextColor(BluedSkinUtils.a(this.h, 2131102478));
                this.A.setEnabled(true);
            }
            this.O.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ShowAlbumFragment.this.p();
                }
            });
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    Tracker.onClick(view);
                    boolean z2 = true;
                    if (ShowAlbumFragment.this.af.is_feed_anonym == 1) {
                        return;
                    }
                    UserBasicModel userBasicModel2 = new UserBasicModel();
                    userBasicModel2.uid = ShowAlbumFragment.this.af.feed_uid;
                    userBasicModel2.name = ShowAlbumFragment.this.af.user_name;
                    userBasicModel2.avatar = ShowAlbumFragment.this.af.user_avatar;
                    userBasicModel2.is_show_vip_page = ShowAlbumFragment.this.af.is_show_vip_page;
                    if (ShowAlbumFragment.this.X == 6) {
                        ShowAlbumFragment showAlbumFragment = ShowAlbumFragment.this;
                        if (showAlbumFragment.a(showAlbumFragment.af)) {
                            new MsgSourceEntity(MessageProtos.StrangerSource.PERSONAL_VIDEO_FULL_SCREEN);
                            str = "album_show_video";
                        } else {
                            str = "album_show_photo";
                        }
                    } else if (ShowAlbumFragment.this.q()) {
                        new MsgSourceEntity(MessageProtos.StrangerSource.FEED_IMAGE_FULL_SCREEN);
                        str = "feed_show_photo";
                    } else {
                        str = "";
                    }
                    Log.v("drb", "from:" + str);
                    LogData logData2 = new LogData();
                    logData2.distance = ShowAlbumFragment.this.af.distance;
                    if (ShowAlbumFragment.this.af.in_promotion != 1) {
                        z2 = false;
                    }
                    logData2.is_feed_super_exposure = z2;
                    logData2.feed_id = ShowAlbumFragment.this.af.feed_id;
                    logData2.target_uid = ShowAlbumFragment.this.af.feed_uid;
                    logData2.is_hot_feed = ShowAlbumFragment.this.af.is_hot_feed;
                    logData2.strong_insert_data = ShowAlbumFragment.this.af.strong_insert_data;
                    logData2.is_new_face = ShowAlbumFragment.this.af.is_new_face;
                    logData2.recommend_time = ShowAlbumFragment.this.af.recommend_time;
                    int i3 = ShowAlbumFragment.this.getArguments().getInt("from_feed_list_page", -1);
                    String a2 = ShowAlbumFragment.a(i3, 0);
                    if (!com.soft.blued.utils.StringUtils.d(a2)) {
                        str = a2;
                    }
                    UserInfoFragmentNew.a(ShowAlbumFragment.this.h, userBasicModel2, str, false, ShowAlbumFragment.this.M, logData2, new MsgSourceEntity(FeedMethods.b(i3, ShowAlbumFragment.this.af.in_promotion)));
                }
            });
            this.P.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ShowAlbumFragment.this.M.performClick();
                }
            });
            this.N.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ShowAlbumFragment.this.M.performClick();
                }
            });
            this.ad.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Log.v("drb", "onClick:" + ShowAlbumFragment.this.af.isFeed);
                    if (UserInfoHelper.a(ShowAlbumFragment.this.af.relationship) || ShowAlbumFragment.this.af.isFeed == 0) {
                        return;
                    }
                    if (ShowAlbumFragment.this.X == 16 || ShowAlbumFragment.this.X == 17) {
                        ShowAlbumFragment.this.getActivity().finish();
                        return;
                    }
                    FeedDetailsFragment.a(ShowAlbumFragment.this.getActivity(), ShowAlbumFragment.this.af, ShowAlbumFragment.this.r(), new FeedDetailParams(0));
                    if (ShowAlbumFragment.this.X != 10) {
                        EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_TEXT_CLICK, ShowAlbumFragment.this.af.feed_uid, ShowAlbumFragment.this.af.feed_id);
                    }
                }
            });
            this.A.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (ShowAlbumFragment.this.X == 16 || ShowAlbumFragment.this.X == 17) {
                        ShowAlbumFragment.this.getActivity().setResult(-1, new Intent());
                        ShowAlbumFragment.this.getActivity().finish();
                        return;
                    }
                    FeedDetailsFragment.a(ShowAlbumFragment.this.h, ShowAlbumFragment.this.af, ShowAlbumFragment.this.r(), new FeedDetailParams(18));
                    if (!ShowAlbumFragment.this.q()) {
                        EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_SHARE_CLICK, ShowAlbumFragment.this.af.feed_uid, ShowAlbumFragment.this.af.feed_id);
                        return;
                    }
                    FeedProtos.Event event = FeedProtos.Event.SHARE_TO_CLICK;
                    FeedProtos.ShareChannel shareChannel = FeedProtos.ShareChannel.SHARE_FRIEND;
                    String str = ShowAlbumFragment.this.af.feed_uid;
                    String str2 = ShowAlbumFragment.this.af.feed_id;
                    String str3 = ShowAlbumFragment.this.af.super_did;
                    String str4 = ShowAlbumFragment.this.af.circle_id;
                    ShowAlbumFragment showAlbumFragment = ShowAlbumFragment.this;
                    EventTrackFeed.a(event, shareChannel, str, str2, str3, "", str4, !showAlbumFragment.a(showAlbumFragment.af) ? FeedProtos.SourcePage.FEED_IMAGE_FULL_SCREEN_SOURCE : FeedProtos.SourcePage.PERSONAL_VIDEO_FULL_SCREEN_SOURCE, ShowAlbumFragment.this.af.share_url, ShowAlbumFragment.this.af.in_promotion == 1, ShowAlbumFragment.this.af.recommend_text, ShowAlbumFragment.this.af.is_anonym == 1, ShowAlbumFragment.this.af.is_top == 1, "", ShowAlbumFragment.this.af.is_hot_feed == 1, ShowAlbumFragment.this.af);
                }
            });
            this.D.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    InstantLog.b(11, (BluedIngSelfFeed) ShowAlbumFragment.this.af, "", -1);
                    if (ShowAlbumFragment.this.X == 16 || ShowAlbumFragment.this.X == 17) {
                        ShowAlbumFragment.this.getActivity().finish();
                        return;
                    }
                    boolean z2 = true;
                    if (ShowAlbumFragment.this.X == 1) {
                        EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_COMMENT_CLICK, ShowAlbumFragment.this.af.feed_uid, ShowAlbumFragment.this.af.feed_id);
                    }
                    FeedDetailParams feedDetailParams = new FeedDetailParams(6);
                    feedDetailParams.isFromComment = true;
                    if (ShowAlbumFragment.this.af.feed_comment <= 0) {
                        z2 = false;
                    }
                    feedDetailParams.hasComment = z2;
                    FeedDetailsFragment.a(ShowAlbumFragment.this.h, ShowAlbumFragment.this.af, ShowAlbumFragment.this.r(), feedDetailParams);
                }
            });
            if (q()) {
                EventTrackFeed.b(FeedProtos.Event.FEED_IMAGE_FULL_SCREEN_SHOW, this.af.feed_id);
            }
            if (this.X == 6 && a(this.af)) {
                EventTrackFeed.b(FeedProtos.Event.PERSONAL_VIDEO_FULL_SCREEN_SHOW, this.af.feed_uid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        UserHttpUtils.b(this.h, new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.17
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                ShowAlbumFragment.this.af.relationship = str;
                ShowAlbumFragment.this.O.setVisibility(8);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
                ShowAlbumFragment.this.af.relationship = "0";
            }
        }, this.af.feed_uid, "", (IRequestHost) getFragmentActive());
        if (q()) {
            String str = this.af.feed_uid;
            String str2 = this.af.feed_id;
            String str3 = this.af.super_did;
            FeedProtos.FollowLocation followLocation = !a(this.af) ? FeedProtos.FollowLocation.FOLLOW_FEED_IMAGE_FULL_SCREEN : FeedProtos.FollowLocation.FOLLOW_PERSONAL_VIDEO_FULL_SCREEN;
            boolean z = true;
            boolean z2 = this.af.live > 0;
            if (this.af.in_promotion != 1) {
                z = false;
            }
            EventTrackFeed.a(str, str2, str3, followLocation, true, z2, z, this.af.strong_insert_data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        int i = this.X;
        boolean z = true;
        if (i != 0) {
            z = true;
            if (i != 1) {
                if (i == 6) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r() {
        int i = this.X;
        if (i == 10) {
            return 9;
        }
        if (i == 6 && a(this.af)) {
            return 21;
        }
        return q() ? 20 : -1;
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void a(int i) {
        super.a(i);
        this.s.getBackground().setAlpha(i);
        Log.v("drb", "mData:" + this.af + " -- isAlbumLock(mData):" + b(this.af));
        AlbumFlow albumFlow = this.af;
        if (albumFlow == null || b(albumFlow)) {
            return;
        }
        Log.v("drb", "isShowBottom:" + this.T + " -- isOnForceground:" + this.ae);
        if (this.T && this.ae) {
            a(true, false);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void a(View view) {
        super.a(view);
        Log.v("drb", "onSingleClick");
        c(view);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        f();
    }

    public void a(FeedComment feedComment) {
        if (this.af == null || !feedComment.feed_id.equals(this.af.feed_id)) {
            return;
        }
        int i = this.af.feed_comment + 1;
        this.af.feed_comment = i;
        TextView textView = this.E;
        textView.setText(DistanceUtils.a(this.h, String.valueOf(i)) + "");
    }

    public void a(BusFeedInteractModel busFeedInteractModel) {
    }

    public void a(FeedRepost feedRepost) {
    }

    public void a(Object obj, int i) {
    }

    public void a(String str, int i) {
    }

    public void a(String str, String str2) {
        if (this.af == null || TextUtils.isEmpty(str) || !this.af.feed_id.equals(str)) {
            return;
        }
        int i = this.af.feed_comment;
        if (i <= 0) {
            this.af.feed_comment = 0;
            this.E.setText(R.string.comment);
            return;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            this.af.feed_comment = i2;
            this.E.setText(R.string.comment);
            return;
        }
        this.af.feed_comment = i2;
        TextView textView = this.E;
        textView.setText(DistanceUtils.a(this.h, String.valueOf(i2)) + "");
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void a(Object... objArr) {
        super.a(objArr);
        if (objArr == null || objArr[1] == null || !(objArr[1] instanceof File)) {
            return;
        }
        try {
            final File file = (File) objArr[1];
            String[] strArr = {this.h.getResources().getString(R.string.common_save)};
            if (this.af != null && this.af.isSelf) {
                strArr = getResources().getStringArray(R.array.my_image_detail_items);
            } else if (this.X == 15) {
                strArr = getResources().getStringArray(2130903082);
            }
            CommonShowBottomWindow.a(getActivity(), strArr, "#3494f4", new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.5
                public void a(ActionSheet actionSheet, int i) {
                    if (ShowAlbumFragment.this.af != null && ShowAlbumFragment.this.af.isSelf) {
                        if (i == 0) {
                            ShowAlbumFragment.this.n();
                        } else if (i != 1) {
                        } else {
                            InstantLog.a("save_pic_click");
                            PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.5.1
                                public void U_() {
                                    ShowAlbumFragment.this.a(file, ShowAlbumFragment.this.Y);
                                }

                                public void a(String[] strArr2) {
                                }
                            });
                        }
                    } else if (i == 0) {
                        InstantLog.a("save_pic_click");
                        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.5.2
                            public void U_() {
                                ShowAlbumFragment.this.a(file, ShowAlbumFragment.this.Y);
                            }

                            public void a(String[] strArr2) {
                            }
                        });
                    } else if (i != 1) {
                    } else {
                        Context context = ShowAlbumFragment.this.h;
                        String str = ShowAlbumFragment.this.af.album_pic;
                        String str2 = ShowAlbumFragment.this.Y;
                        ReportFragmentNew.a(context, 11, str, str2, ShowAlbumFragment.this.af.pid + "," + ShowAlbumFragment.this.Z);
                    }
                }

                public void a(ActionSheet actionSheet, boolean z) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean a(String str) {
        return "1".equalsIgnoreCase(str) || "3".equalsIgnoreCase(str);
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void al_() {
        super.al_();
        AlbumFlow albumFlow = this.af;
        if (albumFlow == null || b(albumFlow) || this.T) {
            return;
        }
        int i = this.ac;
        if (i == 0) {
            b(true, false);
        } else if (i != 1) {
        } else {
            b(true, false);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void am_() {
        super.am_();
        PhotoListPositionObserver.a().a(this.m);
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void b(View view) {
        super.b(view);
        c(view);
    }

    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    public void b(String str, int i) {
    }

    public void b(String str, String str2) {
    }

    public void c(int i) {
    }

    public void c(final BluedIngSelfFeed bluedIngSelfFeed) {
        FeedHttpUtils.a(this.h, new BluedUIHttpResponse() { // from class: com.soft.blued.ui.photo.fragment.ShowAlbumFragment.22
            public void onUIFinish() {
                DialogUtils.b(ShowAlbumFragment.this.r);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ShowAlbumFragment.this.r);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.d((int) R.string.del_success);
                LiveEventBus.get("feed_delete").post(bluedIngSelfFeed);
                if (bluedIngSelfFeed.repost != null) {
                    LiveEventBus.get("feed_delete_repost").post(bluedIngSelfFeed.repost.feed_id);
                }
                AlbumDataObserver.a().a(true, bluedIngSelfFeed.feed_id);
                ShowAlbumFragment.this.g();
            }
        }, bluedIngSelfFeed.feed_id, getFragmentActive());
    }

    public void c(String str) {
    }

    public void c(String str, int i) {
        if (this.af == null || TextUtils.isEmpty(str) || !str.equals(this.af.feed_id)) {
            return;
        }
        Log.v("drb", "notifyLikeChanged refreshZan");
        a((BluedIngSelfFeed) this.af, i);
    }

    public void d(int i) {
    }

    public void d(String str, int i) {
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 3) {
                if (i == 4) {
                    f();
                }
            } else if (!com.soft.blued.utils.StringUtils.d(intent.getStringExtra("string_edit"))) {
                String stringExtra = intent.getStringExtra("string_edit");
                FeedHttpUtils.a(this.g, this.p.get(this.m), (FeedComment) null, stringExtra, getFragmentActive());
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131362969) {
            return;
        }
        PhotoListPositionObserver.a().a(this.m);
        e();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = getActivity();
        View view = this.i;
        if (view == null) {
            this.i = layoutInflater.inflate(R.layout.fragment_show_album, viewGroup, false);
            h();
            i();
            l();
            FeedRefreshObserver.a().a(this);
            FeedMethods.a(getActivity(), this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        if (bundle != null) {
            this.m = bundle.getInt("state_position");
        }
        return this.i;
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void onDestroy() {
        super.onDestroy();
        FeedRefreshObserver.a().b(this);
    }

    public void onPause() {
        super.onPause();
        this.ae = false;
    }

    public void onResume() {
        super.onResume();
        HackyViewPager hackyViewPager = this.s;
        if (hackyViewPager != null) {
            hackyViewPager.a();
        }
        AlbumViewDataManager.a().a(this.f);
        this.ae = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("state_position", this.s.getCurrentItem());
    }

    public void onStop() {
        super.onStop();
        AlbumViewDataManager.a().b();
    }
}
