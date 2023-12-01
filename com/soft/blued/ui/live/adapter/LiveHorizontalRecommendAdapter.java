package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveHorizontalRecommendAdapter.class */
public class LiveHorizontalRecommendAdapter extends BaseQuickAdapter<LiveRecommendModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public int f31075a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f31076c;
    private List<String> d;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveHorizontalRecommendAdapter$LIVE_RECOMMEND_FROM.class */
    public interface LIVE_RECOMMEND_FROM {
    }

    public LiveHorizontalRecommendAdapter(IRequestHost iRequestHost, Context context, int i) {
        super(R.layout.item_live_horizontal_recommend, null);
        this.f31075a = 0;
        this.d = new ArrayList();
        this.b = context;
        this.f31076c = iRequestHost;
        this.f31075a = i;
    }

    public void a() {
        if (this.mData != null) {
            this.d.clear();
            this.mData.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final LiveRecommendModel liveRecommendModel) {
        if (baseViewHolder != null) {
            if (!this.d.contains(liveRecommendModel.lid)) {
                this.d.add(liveRecommendModel.lid);
                EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_maybe", liveRecommendModel.lid, liveRecommendModel.uid);
            }
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_head);
            if (!TextUtils.isEmpty(liveRecommendModel.avatar)) {
                ImageLoader.a(this.f31076c, liveRecommendModel.avatar).a(imageView);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveHorizontalRecommendAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    int i = LiveHorizontalRecommendAdapter.this.f31075a;
                    if (i == 0) {
                        InstantLog.b("live_followed_hori_recommend_click", liveRecommendModel.uid);
                    } else if (i == 1) {
                        InstantLog.b("square_live_click", liveRecommendModel.uid);
                    }
                    EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "follow_maybe", liveRecommendModel.lid, liveRecommendModel.uid);
                    String str = LiveHorizontalRecommendAdapter.this.f31075a == 1 ? liveRecommendModel.source : "live_followed_hori_recommend";
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= LiveHorizontalRecommendAdapter.this.mData.size()) {
                            break;
                        }
                        arrayList.add(new LiveRoomData(StringUtils.a(((LiveRecommendModel) LiveHorizontalRecommendAdapter.this.mData.get(i3)).lid, 0L), ((LiveRecommendModel) LiveHorizontalRecommendAdapter.this.mData.get(i3)).liveType == 1 ? 1 : 0, str, ((LiveRecommendModel) LiveHorizontalRecommendAdapter.this.mData.get(i3)).uid, ((LiveRecommendModel) LiveHorizontalRecommendAdapter.this.mData.get(i3)).name, ((LiveRecommendModel) LiveHorizontalRecommendAdapter.this.mData.get(i3)).avatar, ((LiveRecommendModel) LiveHorizontalRecommendAdapter.this.mData.get(i3)).vbadge));
                        i2 = i3 + 1;
                    }
                    LiveRoomInfoChannel.a(LiveHorizontalRecommendAdapter.this.b, new LiveRoomData(StringUtils.a(liveRecommendModel.lid, 0L), liveRecommendModel.liveType == 1 ? 1 : 0, str, liveRecommendModel.uid, liveRecommendModel.name, liveRecommendModel.avatar, liveRecommendModel.vbadge), -1, arrayList);
                }
            });
            baseViewHolder.setText(2131372046, liveRecommendModel.name);
            if (liveRecommendModel.liveType == 1) {
                baseViewHolder.setText(R.id.tv_live, 2131890339);
            } else if (liveRecommendModel.link_type == 1) {
                baseViewHolder.setText(R.id.tv_live, 2131890342);
            } else if (liveRecommendModel.link_type == 2) {
                baseViewHolder.setText(R.id.tv_live, 2131890341);
            } else {
                baseViewHolder.setText(R.id.tv_live, 2131890340);
            }
            if (!liveRecommendModel.isShowed) {
                int i = this.f31075a;
                if (i == 0) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOWED_HORI_RECOMMEND_SHOW, liveRecommendModel.uid);
                } else if (i == 1) {
                    InstantLog.b("square_live_show", liveRecommendModel.uid);
                }
                liveRecommendModel.isShowed = true;
            }
            baseViewHolder.setOnClickListener(2131364488, new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveHorizontalRecommendAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveHttpUtils.a(liveRecommendModel.uid);
                    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = LiveHorizontalRecommendAdapter.this;
                    liveHorizontalRecommendAdapter.notifyItemRemoved(liveHorizontalRecommendAdapter.mData.indexOf(liveRecommendModel));
                    LiveHorizontalRecommendAdapter.this.mData.remove(liveRecommendModel);
                    if (LiveHorizontalRecommendAdapter.this.mData.size() == 0) {
                        LiveHorizontalRecommendAdapter.this.notifyDataSetChanged();
                        LiveEventBus.get(EventBusConstant.KEY_EVENT_DELETE_ALL_RECOMMEND_USER).post("");
                    } else {
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.live.adapter.LiveHorizontalRecommendAdapter.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LiveHorizontalRecommendAdapter.this.notifyDataSetChanged();
                            }
                        }, 420L);
                    }
                    if (LiveRoomPreferences.A()) {
                        LiveRoomPreferences.B();
                        AppMethods.a((CharSequence) LiveHorizontalRecommendAdapter.this.b.getString(2131890165));
                    }
                }
            });
        }
    }
}
