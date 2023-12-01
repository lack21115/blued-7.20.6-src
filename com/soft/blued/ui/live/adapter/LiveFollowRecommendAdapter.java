package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.anythink.expressad.foundation.d.c;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.databinding.ItemLiveFollowRecommendUserBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LiveAutoPlayView;
import com.blued.android.module.live_china.view.LiveListAutoPlay;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveFollowRecommendAdapter.class */
public final class LiveFollowRecommendAdapter extends BaseQuickAdapter<LiveRecommendModel, BaseViewHolder> implements LiveListAutoPlay {

    /* renamed from: a  reason: collision with root package name */
    private Context f17381a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17382c;
    private String d;
    private LiveAutoPlayView e;
    private boolean f;
    private final HashSet<String> g;
    private final List<String> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFollowRecommendAdapter(Context context, IRequestHost iRequestHost) {
        super((int) R.layout.item_live_follow_recommend_user);
        Intrinsics.e(context, "context");
        this.f17381a = context;
        this.b = iRequestHost;
        this.f17382c = 2;
        this.d = "";
        this.g = new HashSet<>();
        this.h = new ArrayList();
    }

    private final void a(final View view, final LiveRecommendModel liveRecommendModel) {
        LiveRoomInfo.a().a(this.mContext, new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.live.adapter.LiveFollowRecommendAdapter$addUserFollow$1
            public void Q_() {
            }

            public void a(String str) {
                if (str == null) {
                    return;
                }
                LiveRecommendModel liveRecommendModel2 = liveRecommendModel;
                View view2 = view;
                liveRecommendModel2.followed = Integer.parseInt(str);
                if (view2 == null) {
                    return;
                }
                view2.setVisibility(8);
            }

            public void b(String str) {
            }

            public void c() {
            }

            public void d() {
            }
        }, liveRecommendModel.uid, "", this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ImageSize imageSize, LiveFollowRecommendAdapter liveFollowRecommendAdapter, Ref.ObjectRef objectRef, LiveRecommendModel liveRecommendModel, BaseViewHolder baseViewHolder, File file, Exception exc) {
        Intrinsics.e(imageSize, "$size");
        Intrinsics.e(liveFollowRecommendAdapter, "this$0");
        Intrinsics.e(objectRef, "$ivTopLeft");
        Intrinsics.e(liveRecommendModel, "$item");
        if (file == null || !file.exists()) {
            return;
        }
        int a2 = imageSize.a();
        int b = imageSize.b();
        int a3 = DensityUtils.a(liveFollowRecommendAdapter.mContext, 20.0f);
        int i = b > 0 ? (a2 * a3) / b : 0;
        ViewGroup.LayoutParams layoutParams = ((ImageView) objectRef.a).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = i;
        layoutParams2.height = a3;
        ((ImageView) objectRef.a).setLayoutParams(layoutParams2);
        String str = liveRecommendModel.anchor_tag;
        Intrinsics.c(str, "item.anchor_tag");
        if (StringsKt.b(str, ".gif", false, 2, (Object) null)) {
            ImageLoader.a(liveFollowRecommendAdapter.b, liveRecommendModel.anchor_tag).h().a((ImageView) objectRef.a);
        } else {
            String str2 = liveRecommendModel.anchor_tag;
            Intrinsics.c(str2, "item.anchor_tag");
            if (StringsKt.b(str2, ".png", false, 2, (Object) null)) {
                ImageLoader.a(liveFollowRecommendAdapter.b, liveRecommendModel.anchor_tag).e(baseViewHolder.hashCode()).g(-1).a((ImageView) objectRef.a);
            } else {
                ImageLoader.a(liveFollowRecommendAdapter.b, liveRecommendModel.anchor_tag).a((ImageView) objectRef.a);
            }
        }
        baseViewHolder.setGone(R.id.iv_top_left, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRecommendModel liveRecommendModel, LiveFollowRecommendAdapter liveFollowRecommendAdapter, View view) {
        Tracker.onClick(view);
        Intrinsics.e(liveRecommendModel, "$item");
        Intrinsics.e(liveFollowRecommendAdapter, "this$0");
        String str = liveRecommendModel.uid;
        String str2 = liveRecommendModel.lid;
        ArrayList arrayList = new ArrayList();
        int size = liveFollowRecommendAdapter.mData.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            arrayList.add(new LiveRoomData(StringUtils.a(((LiveRecommendModel) liveFollowRecommendAdapter.mData.get(i2)).lid, 0L), ((LiveRecommendModel) liveFollowRecommendAdapter.mData.get(i2)).liveType == 1 ? 1 : 0, "live_followed_grid_recommend", ((LiveRecommendModel) liveFollowRecommendAdapter.mData.get(i2)).uid, ((LiveRecommendModel) liveFollowRecommendAdapter.mData.get(i2)).name, ((LiveRecommendModel) liveFollowRecommendAdapter.mData.get(i2)).avatar, ((LiveRecommendModel) liveFollowRecommendAdapter.mData.get(i2)).vbadge));
            i = i2 + 1;
        }
        LiveRoomInfoChannel.a(liveFollowRecommendAdapter.mContext, new LiveRoomData(StringUtils.a(str2, 0L), liveRecommendModel.liveType == 1 ? 1 : 0, "live_followed_grid_recommend", str, liveRecommendModel.name, liveRecommendModel.avatar, liveRecommendModel.vbadge), -1, arrayList);
        EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "follow_default", liveRecommendModel.lid, liveRecommendModel.uid);
        EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOWED_GRID_RECOMMEND_CLICK, liveRecommendModel.lid, liveRecommendModel.uid);
        InstantLog.b("live_followed_grid_recommend_click", liveRecommendModel.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRecommendModel liveRecommendModel, LiveFollowRecommendAdapter liveFollowRecommendAdapter, ShapeTextView shapeTextView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(liveRecommendModel, "$item");
        Intrinsics.e(liveFollowRecommendAdapter, "this$0");
        Intrinsics.e(shapeTextView, "$tvFollowAnchor");
        EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_PAGE_MAYBE_LIKE_ROOM_FOLLOW, liveRecommendModel.lid, liveRecommendModel.uid);
        liveFollowRecommendAdapter.a((View) shapeTextView, liveRecommendModel);
    }

    private final void f() {
        if (this.e == null || !this.f) {
            return;
        }
        Log.i("xpp", "start");
        LiveAutoPlayView liveAutoPlayView = this.e;
        Intrinsics.a(liveAutoPlayView);
        liveAutoPlayView.b();
    }

    public final IRequestHost a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final LiveRecommendModel liveRecommendModel) {
        if (baseViewHolder == null) {
            return;
        }
        ItemLiveFollowRecommendUserBinding a2 = ItemLiveFollowRecommendUserBinding.a(baseViewHolder.itemView);
        Intrinsics.c(a2, "bind(it.itemView)");
        FrameLayout frameLayout = a2.g;
        Intrinsics.c(frameLayout, "binding.liveUserLayout");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        }
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
        layoutParams2.width = (AppInfo.l - DensityUtils.a(getContext(), 12.0f)) / this.f17382c;
        layoutParams2.height = layoutParams2.width;
        frameLayout.setLayoutParams(layoutParams2);
        CardView cardView = a2.b;
        Intrinsics.c(cardView, "binding.aarivCoverLayout");
        ImageView imageView = a2.a;
        Intrinsics.c(imageView, "binding.aarivCover");
        TextView textView = a2.i;
        Intrinsics.c(textView, "binding.tvUsername");
        LiveAutoPlayView liveAutoPlayView = a2.c;
        Intrinsics.c(liveAutoPlayView, "binding.flVideoView");
        final View view = a2.h;
        Intrinsics.c(view, "binding.tvFollowAnchor");
        BluedLiveListData bluedLiveListData = new BluedLiveListData();
        DensityUtils.a(getContext(), 4.5f);
        int a3 = DensityUtils.a(getContext(), 4.5f);
        int a4 = DensityUtils.a(getContext(), 6.0f);
        int a5 = DensityUtils.a(getContext(), 3.0f);
        int a6 = DensityUtils.a(getContext(), 5.0f);
        ViewGroup.LayoutParams layoutParams3 = cardView.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.leftMargin = a4;
        layoutParams4.topMargin = a6;
        layoutParams4.rightMargin = a5;
        layoutParams4.bottomMargin = a3;
        cardView.setLayoutParams(layoutParams4);
        if (liveRecommendModel == null) {
            return;
        }
        if (!this.h.contains(liveRecommendModel.lid)) {
            List<String> list = this.h;
            String str = liveRecommendModel.lid;
            Intrinsics.c(str, "item.lid");
            list.add(str);
            EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_maybe", liveRecommendModel.lid, liveRecommendModel.uid);
        }
        bluedLiveListData.positionReal = baseViewHolder.getLayoutPosition() - 1;
        bluedLiveListData.anchor_level = liveRecommendModel.level;
        bluedLiveListData.lid = liveRecommendModel.lid;
        bluedLiveListData.uid = liveRecommendModel.uid;
        bluedLiveListData.rtmp_live_urls = liveRecommendModel.livePlay;
        bluedLiveListData.liveType = liveRecommendModel.liveType;
        bluedLiveListData.source = liveRecommendModel.source;
        bluedLiveListData.realtime_count = String.valueOf(liveRecommendModel.realtime_count);
        bluedLiveListData.screen_pattern = liveRecommendModel.screen_pattern;
        bluedLiveListData.link_type = liveRecommendModel.link_type;
        bluedLiveListData.live_play = liveRecommendModel.livePlay;
        if (liveRecommendModel.followed == 1) {
            BluedViewExKt.a(view);
        } else {
            BluedViewExKt.b(view);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveFollowRecommendAdapter$edO1-uF8Rg_9Sh7xeAicURJjZFg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveFollowRecommendAdapter.a(liveRecommendModel, this, view, view2);
            }
        });
        liveAutoPlayView.a(this, bluedLiveListData, this.d, layoutParams2.width, layoutParams2.height);
        if (bluedLiveListData.positionReal == 0) {
            this.e = liveAutoPlayView;
        }
        textView.setText(liveRecommendModel.name);
        ImageLoader.a(a(), liveRecommendModel.pic_url).b(2131234804).a(imageView);
        int i = liveRecommendModel.link_type;
        if (i == 1 || i == 2 || i == 4 || i == 6) {
            this.e = null;
        }
        ImageLoader.a(a(), liveRecommendModel.pic_url).b(2131234804).a(imageView);
        ImageView imageView2 = a2.e;
        Intrinsics.c(imageView2, "binding.ivTopLeft");
        BluedViewExKt.a(imageView2);
        if (!TextUtils.isEmpty(liveRecommendModel.anchor_tag)) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ImageView imageView3 = a2.e;
            Intrinsics.c(imageView3, "binding.ivTopLeft");
            objectRef.a = imageView3;
            final ImageSize imageSize = new ImageSize();
            ImageFileLoader.a(a()).a(liveRecommendModel.anchor_tag).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveFollowRecommendAdapter$4d4JjfqnPfDa8NdBC8H0Z0enFg8
                public final void onUIFinish(File file, Exception exc) {
                    LiveFollowRecommendAdapter.a(imageSize, this, objectRef, liveRecommendModel, baseViewHolder, file, exc);
                }
            }).a();
        }
        if (TextUtils.isEmpty(liveRecommendModel.name)) {
            textView.setText("");
        } else {
            textView.setText(liveRecommendModel.name);
        }
        if (liveRecommendModel.level > 0) {
            LiveUtils.a(getContext(), a2.f, liveRecommendModel.level, false);
        } else {
            ImageView imageView4 = a2.f;
            Intrinsics.c(imageView4, "binding.liveRecordLevel");
            BluedViewExKt.a(imageView4);
        }
        int i2 = liveRecommendModel.screen_pattern;
        String str2 = liveRecommendModel.avatar;
        String str3 = liveRecommendModel.pic_url;
        String str4 = liveRecommendModel.lid;
        String str5 = liveRecommendModel.name;
        new LiveRoomData(StringUtils.a(str4, 0L), i2, this.d, liveRecommendModel.uid, str5, str2, liveRecommendModel.vbadge).live_url = liveRecommendModel.livePlay;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveFollowRecommendAdapter$CK0ZIchRniF5EIg1odIKvrzlLuU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveFollowRecommendAdapter.a(liveRecommendModel, this, view2);
            }
        });
    }

    public final void a(List<? extends LiveRecommendModel> list) {
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LiveRecommendModel liveRecommendModel = list.get(i);
            if (!this.g.contains(liveRecommendModel.uid)) {
                this.mData.add(liveRecommendModel);
                this.g.add(liveRecommendModel.uid);
            }
        }
        notifyDataSetChanged();
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void b() {
        this.g.clear();
        this.h.clear();
    }

    public final void b(boolean z) {
        LiveAutoPlayView liveAutoPlayView = this.e;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.a(z);
        }
    }

    public boolean c() {
        LiveAutoPlayView liveAutoPlayView = this.e;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            if (liveAutoPlayView.e()) {
                Log.i("xpp", "prepareToPlayIfHave");
                f();
                return true;
            }
            return false;
        }
        return false;
    }

    public void d() {
        if (this.e != null) {
            Log.i("xpp", c.cb);
            LiveAutoPlayView liveAutoPlayView = this.e;
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.c();
        }
    }

    public final void e() {
        if (c()) {
            return;
        }
        d();
    }

    public final Context getContext() {
        return this.f17381a;
    }
}
