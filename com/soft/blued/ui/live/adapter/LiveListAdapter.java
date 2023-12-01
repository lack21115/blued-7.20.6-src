package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveHotListDiversion;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.view.LiveAutoPlayView;
import com.blued.android.module.live_china.view.LiveListAutoPlay;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.PKLiveHorizontalView;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.tencent.mapsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveListAdapter.class */
public class LiveListAdapter extends BaseMultiItemQuickAdapter<BluedLiveListData, BaseViewHolder> implements LiveListAutoPlay {

    /* renamed from: a  reason: collision with root package name */
    private Context f17398a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f17399c;
    private LoadOptions d;
    private List<BluedLiveListData> e;
    private List<String> f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;
    private String l;
    private String m;
    private LiveAutoPlayView n;
    private LiveAutoPlayView o;
    private boolean p;
    private List<String> q;

    public LiveListAdapter(IRequestHost iRequestHost, Context context, boolean z, int i, String str) {
        super(new ArrayList());
        this.p = true;
        this.q = new ArrayList();
        this.f17398a = context;
        this.b = iRequestHost;
        this.i = z;
        this.k = i;
        this.l = str;
        this.f17399c = LayoutInflater.from(context);
        this.e = new ArrayList();
        this.f = new ArrayList();
        LoadOptions loadOptions = new LoadOptions();
        this.d = loadOptions;
        loadOptions.d = 2131234804;
        this.d.b = 2131234804;
        int i2 = AppInfo.l;
        this.g = (int) ((i2 - DensityUtils.a(context, 36.0f)) / 3.0f);
        this.h = (i2 - DensityUtils.a(context, 23.0f)) / 2;
        f();
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0")) {
            this.m = "live_list_hot";
            return;
        }
        this.m = "tag_" + str;
    }

    private void a(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData, boolean z) {
        int a2;
        int a3;
        if (TextUtils.equals(this.l, "12")) {
            Log.i("==abc", "tabId:" + this.l);
        }
        if (!this.q.contains(bluedLiveListData.lid)) {
            this.q.add(bluedLiveListData.lid);
            EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_SHOW, this.l, bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.isPKStreamShow());
        }
        View view = baseViewHolder.getView(R.id.live_user_layout);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.width = AppInfo.l / 2;
        layoutParams.height = AppInfo.l / 2;
        view.setLayoutParams(layoutParams);
        int a4 = DensityUtils.a(this.f17398a, 4.5f);
        int a5 = DensityUtils.a(this.f17398a, 4.5f);
        if (bluedLiveListData.position == 0) {
            a2 = DensityUtils.a(this.f17398a, 12.0f);
            a3 = DensityUtils.a(this.f17398a, 3.0f);
        } else {
            a2 = DensityUtils.a(this.f17398a, 3.0f);
            a3 = DensityUtils.a(this.f17398a, 12.0f);
        }
        View findViewById = view.findViewById(R.id.aariv_cover_layout);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams2.leftMargin = a2;
        layoutParams2.topMargin = a4;
        layoutParams2.rightMargin = a3;
        layoutParams2.bottomMargin = a5;
        findViewById.setLayoutParams(layoutParams2);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.aariv_cover);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_mark_screen_horizontal);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audience_count);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_live_description);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_username);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.grab_reward_icon);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.iv_icon_live);
        ImageView imageView5 = (ImageView) baseViewHolder.getView(R.id.iv_pk_left);
        ImageView imageView6 = (ImageView) baseViewHolder.getView(R.id.iv_pk_right);
        LiveAutoPlayView view2 = baseViewHolder.getView(R.id.fl_video_view);
        view2.a(this, bluedLiveListData, this.m, layoutParams.width, layoutParams.height);
        if (bluedLiveListData.positionReal == 0 && z) {
            this.n = view2;
        }
        if (!TextUtils.equals(this.l, "13")) {
            imageView5.setVisibility(8);
            imageView6.setVisibility(8);
        } else if (bluedLiveListData.position == 0) {
            imageView5.setVisibility(0);
            imageView6.setVisibility(8);
        } else {
            imageView5.setVisibility(8);
            imageView6.setVisibility(0);
        }
        if ((TextUtils.equals(this.l, "13") || TextUtils.equals(this.l, "14")) && bluedLiveListData.positionReal == 0) {
            this.n = null;
        }
        final LiveHotListDiversion liveHotListDiversion = bluedLiveListData.hot_diversion;
        if (liveHotListDiversion != null) {
            EventTrackLive.c(LiveProtos.Event.LIVE_TASK_COLLECTION_PAGE_SHOW, liveHotListDiversion.link);
            ImageLoader.a(this.b, liveHotListDiversion.pic).b(2131234804).a(imageView);
            textView3.setText(liveHotListDiversion.title);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    FindHttpUtils.b(liveHotListDiversion.click_url);
                    LiveUtils.a("", "", 0);
                    WebViewShowInfoFragment.a(LiveListAdapter.this.f17398a, liveHotListDiversion.link, "", false, 9);
                    EventTrackLive.c(LiveProtos.Event.HOT_LIVE_H5_LINK_CLICK, liveHotListDiversion.link);
                    EventTrackLive.c(LiveProtos.Event.LIVE_TASK_COLLECTION_PAGE_CLICK, liveHotListDiversion.link);
                }
            });
            imageView4.setVisibility(8);
            textView.setVisibility(8);
            if (!bluedLiveListData.isShowUrlVisited) {
                FindHttpUtils.b(liveHotListDiversion.show_url);
                bluedLiveListData.isShowUrlVisited = true;
            }
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_record_level, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            View view3 = baseViewHolder.getView(R.id.live_is_emperor_recommend);
            if (view3 != null) {
                view3.setVisibility(8);
                return;
            }
            return;
        }
        textView.setVisibility(0);
        if (bluedLiveListData.hb > 0) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(R.drawable.live_list_grab_reward_icon);
        } else if (bluedLiveListData.link_type == 1) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235124);
            if (bluedLiveListData.positionReal == 0) {
                this.n = null;
            }
        } else if (bluedLiveListData.link_type == 2) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235118);
            if (bluedLiveListData.positionReal == 0) {
                this.n = null;
            }
        } else if (bluedLiveListData.link_type == 4) {
            if (TextUtils.equals(this.l, "11")) {
                imageView3.setVisibility(0);
                imageView3.setImageResource(2131235119);
            } else {
                imageView3.setVisibility(8);
            }
            if (bluedLiveListData.positionReal == 0) {
                this.n = null;
            }
        } else if (bluedLiveListData.link_type == 6) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235120);
            if (bluedLiveListData.positionReal == 0) {
                this.n = null;
            }
        } else if (bluedLiveListData.link_type == 7) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235121);
        } else if (bluedLiveListData.link_type == 8) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235126);
        } else if (bluedLiveListData.link_type == 9) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235125);
        } else {
            imageView3.setVisibility(8);
        }
        ImageLoader.a(this.b, bluedLiveListData.pic_url).b(2131234804).a(imageView);
        if (TextUtils.isEmpty(bluedLiveListData.realtime_count)) {
            textView.setText("");
        } else {
            textView.setText(StringUtils.a(Long.valueOf(bluedLiveListData.realtime_count).longValue()));
        }
        if (bluedLiveListData.anchor != null) {
            int i = bluedLiveListData.screen_pattern;
            String str = bluedLiveListData.anchor.avatar;
            String str2 = bluedLiveListData.pic_url;
            final String str3 = bluedLiveListData.lid;
            String str4 = bluedLiveListData.anchor.name;
            final String str5 = bluedLiveListData.uid;
            final LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str3, 0L), i, this.m, str5, str4, str, bluedLiveListData.anchor.vbadge);
            liveRoomData.live_url = bluedLiveListData.live_play;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    Tracker.onClick(view4);
                    int i2 = 2;
                    if (bluedLiveListData.positionReal == 0 && TextUtils.equals(LiveListAdapter.this.l, "0")) {
                        if (bluedLiveListData.link_type == 1) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, str3, str5, LiveProtos.EnterType.PK);
                        } else if (bluedLiveListData.link_type == 2) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, str3, str5, LiveProtos.EnterType.FRIEND);
                        } else {
                            EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, str3, str5, LiveProtos.EnterType.COMMON);
                        }
                    }
                    if (TextUtils.equals(LiveListAdapter.this.l, "12")) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_CLICK, bluedLiveListData.lid, bluedLiveListData.uid);
                    }
                    EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_CLICK, LiveListAdapter.this.l, bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.isPKStreamShow());
                    Bundle bundle = new Bundle();
                    if (bluedLiveListData.link_type == 8) {
                        i2 = 1;
                    } else if (bluedLiveListData.link_type != 9) {
                        i2 = 0;
                    }
                    bundle.putInt("live_prop", i2);
                    LiveRoomInfoChannel.a(LiveListAdapter.this.f17398a, liveRoomData, -1, LiveRoomInfoChannel.a(LiveListDataUtils.a(LiveListAdapter.this.e), LiveListAdapter.this.m), bundle);
                }
            });
            if (!TextUtils.isEmpty(bluedLiveListData.title)) {
                textView3.setText(bluedLiveListData.title);
            } else if (TextUtils.isEmpty(bluedLiveListData.anchor.name)) {
                textView3.setText("");
            } else {
                textView3.setText(bluedLiveListData.anchor.name);
            }
        }
        if (bluedLiveListData.is_distance == 1) {
            baseViewHolder.setGone(R.id.ll_distance, true);
            if (bluedLiveListData.anchor.is_hide_distance == 1) {
                baseViewHolder.setText(R.id.tv_distance, R.string.live_distance_privacy);
                baseViewHolder.setGone(R.id.iv_distance, true);
                UserRelationshipUtils.a((ImageView) baseViewHolder.getView(R.id.iv_distance), bluedLiveListData.anchor);
            } else {
                baseViewHolder.setText(R.id.tv_distance, DistanceUtils.a(bluedLiveListData.distance, BlueAppLocal.c(), false));
                baseViewHolder.setGone(R.id.iv_distance, false);
            }
        } else {
            baseViewHolder.setGone(R.id.ll_distance, false);
        }
        if (bluedLiveListData.anchor_level >= 80) {
            LiveUtils.a(this.f17398a, (ImageView) baseViewHolder.getView(R.id.live_record_level), bluedLiveListData.anchor_level, false);
        } else {
            baseViewHolder.setGone(R.id.live_record_level, false);
        }
        if (bluedLiveListData.is_emperor_recommend == 1) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, true);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, false);
        } else if (bluedLiveListData.is_recommend == 1) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, true);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, false);
        } else if (bluedLiveListData.is_top == 1) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, true);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, false);
        } else if (!TextUtils.isEmpty(bluedLiveListData.top_icon)) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, true);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, false);
        } else if (bluedLiveListData.isPKStreamShow()) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, true);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, false);
            if (bluedLiveListData.win_streak == 10) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235385);
            } else if (bluedLiveListData.win_streak == 20) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235386);
            } else if (bluedLiveListData.win_streak == 30) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235387);
            } else if (bluedLiveListData.win_streak == 40) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235388);
            } else if (bluedLiveListData.win_streak == 50) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235389);
            } else if (bluedLiveListData.win_streak == 60) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235390);
            } else if (bluedLiveListData.win_streak == 70) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235391);
            } else if (bluedLiveListData.win_streak == 80) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235392);
            } else if (bluedLiveListData.win_streak == 90) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235393);
            } else if (bluedLiveListData.win_streak == 99) {
                baseViewHolder.setImageResource(R.id.live_pk_streak, 2131235394);
            }
        } else if (bluedLiveListData.is_hot == 1) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, true);
            baseViewHolder.setGone(R.id.live_new_user, false);
        } else if (bluedLiveListData.is_exist_na_page == 1) {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, true);
        } else {
            baseViewHolder.setGone(R.id.live_is_emperor_recommend, false);
            baseViewHolder.setGone(R.id.live_recommend_top, false);
            baseViewHolder.setGone(R.id.live_level_top, false);
            baseViewHolder.setGone(R.id.live_offical_top, false);
            baseViewHolder.setGone(R.id.live_pk_streak, false);
            baseViewHolder.setGone(R.id.live_select, false);
            baseViewHolder.setGone(R.id.live_new_user, false);
        }
        if (bluedLiveListData.isShowUrlVisited) {
            return;
        }
        FindHttpUtils.b(bluedLiveListData.show_url);
        InstantLog.a(this.k, bluedLiveListData.uid, bluedLiveListData.lid, this.l, bluedLiveListData.link_type == 1 ? "1" : "0", bluedLiveListData.realtime_count);
        bluedLiveListData.isShowUrlVisited = true;
    }

    private void b(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
        if (!this.q.contains(bluedLiveListData.lid)) {
            this.q.add(bluedLiveListData.lid);
            EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, this.l, bluedLiveListData.lid, bluedLiveListData.uid);
        }
        ((PKLiveHorizontalView) baseViewHolder.getView(R.id.list_view)).a(this.b, this.e, bluedLiveListData, this.j);
    }

    private void c(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        if (!this.q.contains(bluedLiveListData.lid)) {
            this.q.add(bluedLiveListData.lid);
            EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, this.l, bluedLiveListData.lid, bluedLiveListData.uid);
        }
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.live_game_layout);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = this.h;
        layoutParams.bottomMargin = DensityUtils.a(this.f17398a, 3.0f);
        if (bluedLiveListData.position == 0) {
            layoutParams.leftMargin = DensityUtils.a(this.f17398a, 10.0f);
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = DensityUtils.a(this.f17398a, 3.0f);
            layoutParams.rightMargin = DensityUtils.a(this.f17398a, 10.0f);
        }
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.aariv_cover);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_mark_screen_horizontal);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audience_count);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_live_description);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_username);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.grab_reward_icon);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.iv_icon_live);
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R.id.aariv_cover_layout);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_game_name);
        LinearLayout linearLayout2 = (LinearLayout) baseViewHolder.getView(R.id.ll_live_item_info);
        LiveAutoPlayView view = baseViewHolder.getView(R.id.fl_video_view);
        view.a(this, bluedLiveListData, this.m, layoutParams.width, DensityUtils.a(this.f17398a, 100.0f));
        if (bluedLiveListData.positionReal == 0) {
            this.n = view;
        }
        textView4.setText(!TextUtils.isEmpty(bluedLiveListData.game_name) ? bluedLiveListData.game_name : "");
        if (TextUtils.isEmpty(bluedLiveListData.title)) {
            textView2.setText(bluedLiveListData.anchor.name + " " + this.f17398a.getString(R.string.liveVideo_followingHost_label_isLiving));
        } else {
            textView2.setText(bluedLiveListData.title);
        }
        if (bluedLiveListData.hb > 0) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(R.drawable.live_list_grab_reward_icon);
        } else if (bluedLiveListData.link_type == 1) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235124);
        } else if (bluedLiveListData.link_type == 2) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235118);
        } else if (bluedLiveListData.link_type == 6) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235120);
        } else {
            imageView3.setVisibility(8);
        }
        ImageLoader.a(this.b, bluedLiveListData.pic_url).b(2131234804).a(imageView);
        if (TextUtils.isEmpty(bluedLiveListData.realtime_count)) {
            textView.setText("");
        } else {
            textView.setText(StringUtils.a(Long.valueOf(bluedLiveListData.realtime_count).longValue()));
        }
        if (bluedLiveListData.anchor != null) {
            int i = bluedLiveListData.screen_pattern;
            String str = bluedLiveListData.anchor.avatar;
            String str2 = bluedLiveListData.pic_url;
            String str3 = bluedLiveListData.lid;
            String str4 = bluedLiveListData.anchor.name;
            final String str5 = bluedLiveListData.uid;
            final LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str3, 0L), i, this.m, str5, str4, str, bluedLiveListData.anchor.vbadge);
            liveRoomData.live_url = bluedLiveListData.live_play;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, LiveListAdapter.this.l, bluedLiveListData.lid, bluedLiveListData.uid);
                    LiveRoomInfoChannel.a(LiveListAdapter.this.f17398a, liveRoomData, -1, LiveRoomInfoChannel.a(LiveListAdapter.this.e, LiveListAdapter.this.m));
                }
            });
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    UserInfoFragmentNew.a(LiveListAdapter.this.f17398a, str5, "");
                }
            });
            if (TextUtils.isEmpty(bluedLiveListData.anchor.name)) {
                textView3.setText("");
            } else {
                textView3.setText(bluedLiveListData.anchor.name);
            }
        }
        if (bluedLiveListData.isShowUrlVisited) {
            return;
        }
        InstantLog.a(2, bluedLiveListData.uid, bluedLiveListData.lid, this.l, bluedLiveListData.link_type == 1 ? "1" : "0", bluedLiveListData.realtime_count);
        bluedLiveListData.isShowUrlVisited = true;
    }

    private void d(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
    }

    private void e(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
    }

    private void f() {
        addItemType(0, R.layout.layout_live_user_new);
        addItemType(1, R.layout.layout_live_offcial_new);
        addItemType(2, R.layout.layout_live_red_new);
        addItemType(3, R.layout.layout_live_offcial_new_title);
        addItemType(4, R.layout.layout_live_red_new_title);
        addItemType(5, R.layout.layout_live_user_new_title);
        addItemType(6, R.layout.layout_live_game_new);
        addItemType(7, R.layout.layout_live_pk);
        addItemType(8, R.layout.layout_live_interested_title);
        addItemType(9, R.layout.layout_live_not_live_tip);
        addItemType(10, R.layout.layout_live_user_new);
    }

    private void f(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        if (!this.q.contains(bluedLiveListData.lid)) {
            this.q.add(bluedLiveListData.lid);
            EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, BuildConfig.FLAVOR, bluedLiveListData.lid, bluedLiveListData.uid);
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.aariv_cover);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_mark_screen_horizontal);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audience_count);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_live_description);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_username);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.grab_reward_icon);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.iv_icon_live);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_live_item_info);
        if (bluedLiveListData.hb > 0) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(R.drawable.live_list_grab_reward_icon);
        } else if (bluedLiveListData.link_type == 1) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235124);
        } else if (bluedLiveListData.link_type == 2) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235118);
        } else if (bluedLiveListData.link_type == 6) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235120);
        } else {
            imageView3.setVisibility(8);
        }
        ImageLoader.a(this.b, bluedLiveListData.pic_url).b(2131234804).a(imageView);
        if (TextUtils.isEmpty(bluedLiveListData.realtime_count)) {
            textView.setText("");
        } else {
            textView.setText(StringUtils.a(Long.valueOf(bluedLiveListData.realtime_count).longValue()));
        }
        if (bluedLiveListData.screen_pattern == 1) {
            if (!BlueAppLocal.d()) {
                imageView2.setImageResource(R.drawable.icon_live_list_horizontal_screen_en);
            } else if (DeviceUtils.a()) {
                imageView2.setImageResource(R.drawable.icon_live_list_horizontal_screen);
            } else {
                imageView2.setImageResource(R.drawable.icon_live_list_horizontal_screen_zhr);
            }
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        if (bluedLiveListData.anchor_level >= 80) {
            LiveUtils.a(this.f17398a, (ImageView) baseViewHolder.getView(R.id.live_record_level), bluedLiveListData.anchor_level, false);
        } else {
            baseViewHolder.setGone(R.id.live_record_level, false);
        }
        if (bluedLiveListData.anchor != null) {
            int i = bluedLiveListData.screen_pattern;
            String str = bluedLiveListData.anchor.avatar;
            String str2 = bluedLiveListData.pic_url;
            String str3 = bluedLiveListData.lid;
            String str4 = bluedLiveListData.anchor.name;
            final String str5 = bluedLiveListData.uid;
            final LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str3, 0L), i, "official_live", str5, str4, str, bluedLiveListData.anchor.vbadge);
            liveRoomData.live_url = bluedLiveListData.live_play;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, BuildConfig.FLAVOR, bluedLiveListData.lid, bluedLiveListData.uid);
                    LiveRoomInfoChannel.a(LiveListAdapter.this.f17398a, liveRoomData, -1, LiveRoomInfoChannel.a(LiveListDataUtils.a(LiveListAdapter.this.e), "official_live"));
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    UserInfoFragmentNew.a(LiveListAdapter.this.f17398a, str5, "");
                }
            });
            if (!TextUtils.isEmpty(bluedLiveListData.title)) {
                textView2.setText(bluedLiveListData.title);
                return;
            }
            textView2.setText(bluedLiveListData.anchor.name + " " + this.f17398a.getString(R.string.liveVideo_followingHost_label_isLiving));
        }
    }

    private void g() {
        LiveAutoPlayView liveAutoPlayView;
        LiveAutoPlayView liveAutoPlayView2 = this.o;
        if (liveAutoPlayView2 != null && liveAutoPlayView2.e() && (liveAutoPlayView = this.o) != null) {
            liveAutoPlayView.d();
        }
        LiveAutoPlayView liveAutoPlayView3 = this.n;
        if (liveAutoPlayView3 == null || !this.p) {
            return;
        }
        liveAutoPlayView3.b();
    }

    private void g(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        if (!this.q.contains(bluedLiveListData.lid)) {
            this.q.add(bluedLiveListData.lid);
            EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_SHOW, "red", bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.isPKStreamShow());
        }
        ViewGroup viewGroup = (ViewGroup) baseViewHolder.getView(R.id.live_red_layout);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.width = this.g;
        layoutParams.height = this.g;
        layoutParams.topMargin = DensityUtils.a(this.f17398a, 4.5f);
        layoutParams.bottomMargin = DensityUtils.a(this.f17398a, 4.5f);
        if (bluedLiveListData.position == 0) {
            layoutParams.leftMargin = DensityUtils.a(this.f17398a, 12.0f);
            layoutParams.rightMargin = 0;
        } else if (bluedLiveListData.position == 1) {
            layoutParams.leftMargin = DensityUtils.a(this.f17398a, 6.0f);
            layoutParams.rightMargin = DensityUtils.a(this.f17398a, 6.0f);
        } else if (bluedLiveListData.position == 2) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = DensityUtils.a(this.f17398a, 12.0f);
        }
        viewGroup.setLayoutParams(layoutParams);
        View view = baseViewHolder.getView(R.id.fl_cover);
        int i = this.g;
        view.setLayoutParams(new RelativeLayout.LayoutParams(i, i));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.aariv_cover);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_mark_screen_horizontal);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audience_count);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_live_description);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_username);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.grab_reward_icon);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.iv_icon_live);
        LiveAutoPlayView view2 = baseViewHolder.getView(R.id.fl_video_view);
        String str = this.m;
        int i2 = this.g;
        view2.a(this, bluedLiveListData, str, i2, i2);
        if (bluedLiveListData.positionReal == 0) {
            this.o = view2;
        }
        if (bluedLiveListData.isPKStreamShow()) {
            baseViewHolder.setGone(R.id.live_type_right_icon, true);
            if (bluedLiveListData.win_streak == 10) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235385);
            } else if (bluedLiveListData.win_streak == 20) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235386);
            } else if (bluedLiveListData.win_streak == 30) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235387);
            } else if (bluedLiveListData.win_streak == 40) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235388);
            } else if (bluedLiveListData.win_streak == 50) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235389);
            } else if (bluedLiveListData.win_streak == 60) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235390);
            } else if (bluedLiveListData.win_streak == 70) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235391);
            } else if (bluedLiveListData.win_streak == 80) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235392);
            } else if (bluedLiveListData.win_streak == 90) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235393);
            } else if (bluedLiveListData.win_streak == 99) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235394);
            }
            imageView3.setVisibility(8);
        } else {
            baseViewHolder.setGone(R.id.live_type_right_icon, false);
            if (bluedLiveListData.hb > 0) {
                imageView3.setVisibility(0);
                imageView3.setImageResource(R.drawable.live_list_grab_reward_icon);
            } else if (bluedLiveListData.link_type == 1) {
                imageView3.setVisibility(0);
                imageView3.setImageResource(2131235124);
                if (bluedLiveListData.positionReal == 0) {
                    this.o = null;
                }
            } else if (bluedLiveListData.link_type == 2) {
                imageView3.setVisibility(0);
                imageView3.setImageResource(2131235118);
                if (bluedLiveListData.positionReal == 0) {
                    this.o = null;
                }
            } else if (bluedLiveListData.link_type == 6) {
                imageView3.setVisibility(0);
                imageView3.setImageResource(2131235120);
                if (bluedLiveListData.positionReal == 0) {
                    this.o = null;
                }
            } else {
                imageView3.setVisibility(8);
            }
        }
        ImageLoader.a(this.b, bluedLiveListData.pic_url).b(2131234804).a(imageView);
        if (TextUtils.isEmpty(bluedLiveListData.realtime_count)) {
            textView.setText("");
        } else {
            textView.setText(StringUtils.a(Long.valueOf(bluedLiveListData.realtime_count).longValue()));
        }
        if (bluedLiveListData.anchor_level >= 80) {
            LiveUtils.a(this.f17398a, (ImageView) baseViewHolder.getView(R.id.live_record_level), bluedLiveListData.anchor_level, false);
        } else {
            baseViewHolder.setGone(R.id.live_record_level, false);
        }
        if (bluedLiveListData.anchor != null) {
            final int i3 = bluedLiveListData.screen_pattern;
            final String str2 = bluedLiveListData.anchor.avatar;
            String str3 = bluedLiveListData.pic_url;
            final String str4 = bluedLiveListData.lid;
            final String str5 = bluedLiveListData.anchor.name;
            final String str6 = bluedLiveListData.uid;
            final int i4 = bluedLiveListData.anchor.vbadge;
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveListAdapter.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (bluedLiveListData.positionReal == 0 && TextUtils.equals(LiveListAdapter.this.l, "0")) {
                        if (bluedLiveListData.link_type == 1) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_FAVORITE_FIRST_ROOM_CLICK, str4, str6, LiveProtos.EnterType.PK);
                        } else if (bluedLiveListData.link_type == 2) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_FAVORITE_FIRST_ROOM_CLICK, str4, str6, LiveProtos.EnterType.FRIEND);
                        } else {
                            EventTrackLive.a(LiveProtos.Event.LIVE_FAVORITE_FIRST_ROOM_CLICK, str4, str6, LiveProtos.EnterType.COMMON);
                        }
                    }
                    EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_CLICK, "red", bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.isPKStreamShow());
                    ArrayList arrayList = new ArrayList();
                    for (BluedLiveListData bluedLiveListData2 : LiveListAdapter.this.mData) {
                        if (bluedLiveListData2.liveType == 0 || bluedLiveListData2.liveType == 1 || bluedLiveListData2.liveType == 2) {
                            arrayList.add(bluedLiveListData2);
                        }
                    }
                    LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str4, 0L), i3, "red_board", str6, str5, str2, i4);
                    liveRoomData.live_url = bluedLiveListData.live_play;
                    LiveRoomInfoChannel.a(LiveListAdapter.this.f17398a, liveRoomData, -1, LiveRoomInfoChannel.a(LiveListDataUtils.a(arrayList), "red_board"));
                    InstantLog.b("click_live_hot", str6);
                }
            });
            if (TextUtils.isEmpty(bluedLiveListData.anchor.name)) {
                textView3.setText("");
            } else {
                textView3.setText(bluedLiveListData.anchor.name);
            }
        }
        if (bluedLiveListData.isShowUrlVisited) {
            return;
        }
        InstantLog.a(3, bluedLiveListData.uid, bluedLiveListData.lid, this.l, bluedLiveListData.link_type == 1 ? "1" : "0", bluedLiveListData.realtime_count);
        bluedLiveListData.isShowUrlVisited = true;
    }

    private void h() {
        LiveAutoPlayView liveAutoPlayView;
        LiveAutoPlayView liveAutoPlayView2 = this.n;
        if (liveAutoPlayView2 != null && liveAutoPlayView2.e() && (liveAutoPlayView = this.n) != null) {
            liveAutoPlayView.d();
        }
        LiveAutoPlayView liveAutoPlayView3 = this.o;
        if (liveAutoPlayView3 == null || !this.p) {
            return;
        }
        liveAutoPlayView3.b();
    }

    public List<BluedLiveListData> a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
        if (baseViewHolder != null) {
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 0) {
                a(baseViewHolder, bluedLiveListData, true);
            } else if (itemViewType == 1) {
                f(baseViewHolder, bluedLiveListData);
            } else if (itemViewType == 2) {
                g(baseViewHolder, bluedLiveListData);
            } else if (itemViewType == 3) {
                d(baseViewHolder, bluedLiveListData);
            } else if (itemViewType == 5) {
                e(baseViewHolder, bluedLiveListData);
            } else if (itemViewType == 6) {
                c(baseViewHolder, bluedLiveListData);
            } else if (itemViewType == 7) {
                b(baseViewHolder, bluedLiveListData);
            } else if (itemViewType != 10) {
            } else {
                a(baseViewHolder, bluedLiveListData, false);
            }
        }
    }

    public void a(List<BluedLiveListData> list) {
        a(list, false);
    }

    public void a(List<BluedLiveListData> list, boolean z) {
        int size = this.mData.size();
        this.mData.clear();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (!TextUtils.isEmpty(list.get(i2).lid)) {
                    if (!this.f.contains(list.get(i2).lid)) {
                        this.f.add(list.get(i2).lid);
                        this.e.add(list.get(i2));
                    } else if (list.get(i2).is_emperor_recommend == 1) {
                        this.e.add(list.get(i2));
                    }
                }
                i = i2 + 1;
            }
        }
        this.mData.addAll(LiveListDataUtils.a(this.e, this.i));
        if (size == this.mData.size() && !z) {
            setEnableLoadMore(false);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.j = z;
    }

    public String b() {
        return this.m;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public void c(boolean z) {
        LiveAutoPlayView liveAutoPlayView = this.o;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.a(z);
        }
        LiveAutoPlayView liveAutoPlayView2 = this.n;
        if (liveAutoPlayView2 != null) {
            liveAutoPlayView2.a(z);
        }
    }

    public boolean c() {
        LiveAutoPlayView liveAutoPlayView;
        LiveAutoPlayView liveAutoPlayView2 = this.o;
        if (liveAutoPlayView2 != null && liveAutoPlayView2.e() && (liveAutoPlayView = this.n) != null && liveAutoPlayView.e() && this.o.getHeight() != 0 && this.n.getHeight() != 0) {
            int[] iArr = new int[2];
            this.o.getLocationOnScreen(iArr);
            int i = iArr[1];
            this.n.getLocationOnScreen(iArr);
            if (Math.abs((i + this.o.getHeight()) - (AppInfo.m / 2)) < Math.abs((iArr[1] + this.n.getHeight()) - (AppInfo.m / 2))) {
                Log.i("xpp", "prepareToPlayIfHave 1");
                h();
                return true;
            }
            Log.i("xpp", "prepareToPlayIfHave 2");
            g();
            return true;
        }
        LiveAutoPlayView liveAutoPlayView3 = this.o;
        if (liveAutoPlayView3 != null && liveAutoPlayView3.e()) {
            Log.i("xpp", "prepareToPlayIfHave 3");
            h();
            return true;
        }
        LiveAutoPlayView liveAutoPlayView4 = this.n;
        if (liveAutoPlayView4 == null || !liveAutoPlayView4.e()) {
            return false;
        }
        Log.i("xpp", "prepareToPlayIfHave 4");
        g();
        return true;
    }

    public void d() {
        LiveAutoPlayView liveAutoPlayView = this.o;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.c();
        }
        LiveAutoPlayView liveAutoPlayView2 = this.n;
        if (liveAutoPlayView2 != null) {
            liveAutoPlayView2.c();
        }
    }

    public void e() {
        if (c()) {
            return;
        }
        d();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<BluedLiveListData> list) {
        this.f.clear();
        this.e.clear();
        this.q.clear();
        a(list, true);
    }
}
