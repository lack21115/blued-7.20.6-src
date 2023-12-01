package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentGoodsWallBrandBinding;
import com.blued.android.module.live_china.fitem.FitemGoodsWallBrand;
import com.blued.android.module.live_china.fitem.FitemGoodsWallBrandTitle;
import com.blued.android.module.live_china.fragment.LiveGiftGalleryDialogFragment;
import com.blued.android.module.live_china.fragment.LiveGoodsWallBrandAwardDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GoodsWallBrandItemModel;
import com.blued.android.module.live_china.model.GoodsWallBrandModel;
import com.blued.android.module.live_china.model.GoodsWallDataBrandModel;
import com.blued.android.module.live_china.model.GoodsWallInfoModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGoodsWallBrandFragment.class */
public final class LiveGoodsWallBrandFragment extends BaseFragment {
    private FragmentGoodsWallBrandBinding a;
    private final ArrayList<FreedomItem> b = new ArrayList<>();
    private FreedomAdapter c;

    private final void a() {
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding = this.a;
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding2 = fragmentGoodsWallBrandBinding;
        if (fragmentGoodsWallBrandBinding == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding2 = null;
        }
        fragmentGoodsWallBrandBinding2.h.b();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.F(new BluedUIHttpResponse<BluedEntity<GoodsWallDataBrandModel, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.fragment.LiveGoodsWallBrandFragment$getData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding3;
                super.onUIFinish();
                fragmentGoodsWallBrandBinding3 = LiveGoodsWallBrandFragment.this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding4 = fragmentGoodsWallBrandBinding3;
                if (fragmentGoodsWallBrandBinding3 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding4 = null;
                }
                fragmentGoodsWallBrandBinding4.h.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GoodsWallDataBrandModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                GoodsWallDataBrandModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveGoodsWallBrandFragment.this.a(singleData);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGoodsWallBrandFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_CUSTOM_MADE_SEAL_PAGE_REWARD_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LiveGoodsWallBrandAwardDialogFragment.Companion companion = LiveGoodsWallBrandAwardDialogFragment.a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(GoodsWallDataBrandModel goodsWallDataBrandModel) {
        Resources resources;
        final GoodsWallInfoModel info = goodsWallDataBrandModel.getInfo();
        if (info != null) {
            if (info.getEnable_hall() != 1) {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding2 = fragmentGoodsWallBrandBinding;
                if (fragmentGoodsWallBrandBinding == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding2 = null;
                }
                View view = fragmentGoodsWallBrandBinding2.b;
                Intrinsics.c(view, "vb.clCustomGallery");
                BluedViewExKt.a(view);
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding3 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding4 = fragmentGoodsWallBrandBinding3;
                if (fragmentGoodsWallBrandBinding3 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding4 = null;
                }
                fragmentGoodsWallBrandBinding4.a.setBackgroundResource(R.drawable.live_bg_goods_wall_brand_award_btn_bg_big);
            } else {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding5 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding6 = fragmentGoodsWallBrandBinding5;
                if (fragmentGoodsWallBrandBinding5 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding6 = null;
                }
                View view2 = fragmentGoodsWallBrandBinding6.b;
                Intrinsics.c(view2, "vb.clCustomGallery");
                BluedViewExKt.b(view2);
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding7 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding8 = fragmentGoodsWallBrandBinding7;
                if (fragmentGoodsWallBrandBinding7 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding8 = null;
                }
                fragmentGoodsWallBrandBinding8.a.setBackgroundResource(R.drawable.live_bg_goods_wall_brand_award_btn_bg);
            }
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                ImageWrapper a = ImageLoader.a(getFragmentActive(), info.getAvatar()).b(R.drawable.icon_desire_funders_default).c().a(1.0f, resources.getColor(R.color.syc_dark_FFE1A6));
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding9 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding10 = fragmentGoodsWallBrandBinding9;
                if (fragmentGoodsWallBrandBinding9 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding10 = null;
                }
                a.a(fragmentGoodsWallBrandBinding10.c);
            }
            String avatar_frame = info.getAvatar_frame();
            if (avatar_frame == null || avatar_frame.length() == 0) {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding11 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding12 = fragmentGoodsWallBrandBinding11;
                if (fragmentGoodsWallBrandBinding11 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding12 = null;
                }
                ImageView imageView = fragmentGoodsWallBrandBinding12.d;
                Intrinsics.c(imageView, "vb.ivAvatarFrame");
                BluedViewExKt.c(imageView);
            } else {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding13 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding14 = fragmentGoodsWallBrandBinding13;
                if (fragmentGoodsWallBrandBinding13 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding14 = null;
                }
                ImageView imageView2 = fragmentGoodsWallBrandBinding14.d;
                Intrinsics.c(imageView2, "vb.ivAvatarFrame");
                BluedViewExKt.b(imageView2);
                ImageWrapper g = ImageLoader.a((IRequestHost) null, info.getAvatar_frame()).g().g(-1);
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding15 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding16 = fragmentGoodsWallBrandBinding15;
                if (fragmentGoodsWallBrandBinding15 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding16 = null;
                }
                g.a(fragmentGoodsWallBrandBinding16.d);
            }
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding17 = this.a;
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding18 = fragmentGoodsWallBrandBinding17;
            if (fragmentGoodsWallBrandBinding17 == null) {
                Intrinsics.c("vb");
                fragmentGoodsWallBrandBinding18 = null;
            }
            fragmentGoodsWallBrandBinding18.o.setText(info.getUsername());
            String link = info.getLink();
            if (link == null || link.length() == 0) {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding19 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding20 = fragmentGoodsWallBrandBinding19;
                if (fragmentGoodsWallBrandBinding19 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding20 = null;
                }
                ImageView imageView3 = fragmentGoodsWallBrandBinding20.g;
                Intrinsics.c(imageView3, "vb.ivInfo");
                BluedViewExKt.a(imageView3);
            } else {
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding21 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding22 = fragmentGoodsWallBrandBinding21;
                if (fragmentGoodsWallBrandBinding21 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding22 = null;
                }
                ImageView imageView4 = fragmentGoodsWallBrandBinding22.g;
                Intrinsics.c(imageView4, "vb.ivInfo");
                BluedViewExKt.b(imageView4);
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding23 = this.a;
                FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding24 = fragmentGoodsWallBrandBinding23;
                if (fragmentGoodsWallBrandBinding23 == null) {
                    Intrinsics.c("vb");
                    fragmentGoodsWallBrandBinding24 = null;
                }
                fragmentGoodsWallBrandBinding24.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallBrandFragment$ZGmsRX7n0Gnf0KpyIOjxAquzyaM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        LiveGoodsWallBrandFragment.a(GoodsWallInfoModel.this, view3);
                    }
                });
            }
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding25 = this.a;
            if (fragmentGoodsWallBrandBinding25 == null) {
                Intrinsics.c("vb");
                fragmentGoodsWallBrandBinding25 = null;
            }
            fragmentGoodsWallBrandBinding25.l.setText(AppInfo.d().getString(R.string.live_goods_wall_brand_subtitle, Integer.valueOf(info.getStamp_count())));
        }
        this.b.clear();
        ArrayList<GoodsWallBrandModel> records = goodsWallDataBrandModel.getRecords();
        if (records == null || records.isEmpty()) {
            this.b.add(new FitemGoodsWallBrandTitle("当前暂无记录"));
        } else {
            ArrayList<GoodsWallBrandModel> records2 = goodsWallDataBrandModel.getRecords();
            if (records2 != null) {
                for (GoodsWallBrandModel goodsWallBrandModel : records2) {
                    String date = goodsWallBrandModel.getDate();
                    if (!(date == null || date.length() == 0)) {
                        ArrayList<GoodsWallBrandItemModel> data = goodsWallBrandModel.getData();
                        if (!(data == null || data.isEmpty())) {
                            this.b.add(new FitemGoodsWallBrandTitle(goodsWallBrandModel.getDate()));
                            ArrayList<GoodsWallBrandItemModel> data2 = goodsWallBrandModel.getData();
                            if (data2 != null) {
                                for (GoodsWallBrandItemModel goodsWallBrandItemModel : data2) {
                                    this.b.add(new FitemGoodsWallBrand(goodsWallBrandItemModel));
                                }
                            }
                        }
                    }
                }
            }
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GoodsWallInfoModel it, View view) {
        Intrinsics.e(it, "$it");
        if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
            LiveSetDataObserver.a().b(it.getLink(), 25);
        } else {
            LiveRefreshUIObserver.a().b(it.getLink(), 25);
        }
    }

    private final void b() {
        FreedomAdapter freedomAdapter = this.c;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.c = new FreedomAdapter(getContext(), getFragmentActive(), this.b);
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding = this.a;
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding2 = fragmentGoodsWallBrandBinding;
        if (fragmentGoodsWallBrandBinding == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding2 = null;
        }
        RecyclerView recyclerView = fragmentGoodsWallBrandBinding2.i;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding3 = this.a;
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding4 = fragmentGoodsWallBrandBinding3;
        if (fragmentGoodsWallBrandBinding3 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding4 = null;
        }
        RecyclerView recyclerView2 = fragmentGoodsWallBrandBinding4.i;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding5 = this.a;
        if (fragmentGoodsWallBrandBinding5 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding5 = null;
        }
        RecyclerView recyclerView3 = fragmentGoodsWallBrandBinding5.i;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGoodsWallBrandFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_CUSTOM_MADE_SEAL_PAGE_HALL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        boolean equals = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        LiveGiftGalleryDialogFragment.Companion companion = LiveGiftGalleryDialogFragment.a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, equals, this$0);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        FragmentGoodsWallBrandBinding a = FragmentGoodsWallBrandBinding.a(getLayoutInflater(), viewGroup, false);
        Intrinsics.c(a, "inflate(layoutInflater, container, false)");
        this.a = a;
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding = a;
        if (a == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding = null;
        }
        RelativeLayout root = fragmentGoodsWallBrandBinding.getRoot();
        if ((root == null ? null : root.getParent()) != null) {
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding2 = this.a;
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding3 = fragmentGoodsWallBrandBinding2;
            if (fragmentGoodsWallBrandBinding2 == null) {
                Intrinsics.c("vb");
                fragmentGoodsWallBrandBinding3 = null;
            }
            RelativeLayout root2 = fragmentGoodsWallBrandBinding3.getRoot();
            ViewParent parent = root2 == null ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding4 = this.a;
            FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding5 = fragmentGoodsWallBrandBinding4;
            if (fragmentGoodsWallBrandBinding4 == null) {
                Intrinsics.c("vb");
                fragmentGoodsWallBrandBinding5 = null;
            }
            viewGroup2.removeView(fragmentGoodsWallBrandBinding5.getRoot());
        }
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding6 = this.a;
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding7 = fragmentGoodsWallBrandBinding6;
        if (fragmentGoodsWallBrandBinding6 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding7 = null;
        }
        fragmentGoodsWallBrandBinding7.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallBrandFragment$PO1-dH18l6rLqLe5d6D2RZBVDJs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGoodsWallBrandFragment.a(LiveGoodsWallBrandFragment.this, view);
            }
        });
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding8 = this.a;
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding9 = fragmentGoodsWallBrandBinding8;
        if (fragmentGoodsWallBrandBinding8 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding9 = null;
        }
        fragmentGoodsWallBrandBinding9.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGoodsWallBrandFragment$8jNcas4TVAVe9ZjLgbTFaAJLqwQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGoodsWallBrandFragment.b(LiveGoodsWallBrandFragment.this, view);
            }
        });
        a();
        FragmentGoodsWallBrandBinding fragmentGoodsWallBrandBinding10 = this.a;
        if (fragmentGoodsWallBrandBinding10 == null) {
            Intrinsics.c("vb");
            fragmentGoodsWallBrandBinding10 = null;
        }
        return fragmentGoodsWallBrandBinding10.getRoot();
    }
}
