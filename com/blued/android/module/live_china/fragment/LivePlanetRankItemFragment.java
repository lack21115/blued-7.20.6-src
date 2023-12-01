package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLivePlanetRankItemBinding;
import com.blued.android.module.live_china.fragment.LivePlanetRankItemFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LivePlanetGiftModel;
import com.blued.android.module.live_china.model.LivePlanetRankExtra;
import com.blued.android.module.live_china.model.LivePlanetRankModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRankItemFragment.class */
public final class LivePlanetRankItemFragment extends BaseFragment {
    private final Lazy a = LazyKt.a(new Function0<FragmentLivePlanetRankItemBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRankItemFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLivePlanetRankItemBinding invoke() {
            return FragmentLivePlanetRankItemBinding.a(LayoutInflater.from(LivePlanetRankItemFragment.this.getContext()));
        }
    });
    private List<LivePlanetRankModel> b = new ArrayList();
    private String c = "";
    private String d = "";
    private int e;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRankItemFragment$GiftAdapter.class */
    public static final class GiftAdapter extends CommonRecycleAdapter<LivePlanetGiftModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftAdapter(Context context) {
            super(context);
            Intrinsics.e(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(LivePlanetGiftModel livePlanetGiftModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (commonAdapterHolder != null) {
                commonAdapterHolder.a(R.id.name, livePlanetGiftModel == null ? null : livePlanetGiftModel.getName());
            }
            if (commonAdapterHolder != null) {
                commonAdapterHolder.b(R.id.iv_pic, livePlanetGiftModel == null ? null : livePlanetGiftModel.getImage());
            }
            if (livePlanetGiftModel == null || livePlanetGiftModel.getCount() <= 999) {
                if (commonAdapterHolder == null) {
                    return;
                }
                commonAdapterHolder.a(R.id.tv_num, Intrinsics.a("x", (Object) (livePlanetGiftModel == null ? null : Integer.valueOf(livePlanetGiftModel.getCount()))));
            } else if (commonAdapterHolder == null) {
            } else {
                commonAdapterHolder.a(R.id.tv_num, "x999+");
            }
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_planet_rank_gift_item;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRankItemFragment$MyAdapter.class */
    public static final class MyAdapter extends BaseMultiItemQuickAdapter<LivePlanetRankModel, BaseViewHolder> {
        private Context a;
        private List<LivePlanetRankModel> b;
        private int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(Context context, int i, List<LivePlanetRankModel> models) {
            super(models);
            Intrinsics.e(models, "models");
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.a = context;
            this.c = i;
            arrayList.clear();
            this.b.addAll(models);
            addItemType(0, R.layout.live_planet_rank_item);
            addItemType(1, R.layout.live_planet_rank_item_end);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LivePlanetRankModel livePlanetRankModel, MyAdapter this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            if (StringUtils.a(livePlanetRankModel.getLid(), 0L) <= 0) {
                if (TextUtils.equals(LiveRoomManager.a().g(), LiveRoomInfo.a().f())) {
                    LiveSetDataObserver.a().e(livePlanetRankModel.getUid());
                } else if (this$0.c == 0) {
                    LiveSetDataObserver.a().e(livePlanetRankModel.getUid());
                } else {
                    this$0.a(livePlanetRankModel);
                }
            } else if (TextUtils.equals(LiveRoomManager.a().g(), LiveRoomInfo.a().f())) {
                LiveSetDataObserver.a().e(livePlanetRankModel.getUid());
            } else if (TextUtils.equals(LiveRoomManager.a().g(), livePlanetRankModel.getUid())) {
                this$0.a(livePlanetRankModel);
            } else {
                LiveDataListManager.a().b(new LiveRoomData(StringUtils.a(livePlanetRankModel.getLid(), 0L), 0, LiveFloatManager.a().D(), livePlanetRankModel.getUid(), "", "", 0));
            }
        }

        public final void a(LivePlanetRankModel livePlanetRankModel) {
            LiveRoomInfo.a().a(this.a, livePlanetRankModel == null ? null : livePlanetRankModel.getUid(), livePlanetRankModel == null ? null : livePlanetRankModel.getName(), livePlanetRankModel == null ? null : livePlanetRankModel.getAvatar(), 0, 1);
            LiveRefreshUIObserver.a().b(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, LivePlanetRankModel livePlanetRankModel) {
            if (baseViewHolder != null) {
                int itemViewType = baseViewHolder.getItemViewType();
                if (itemViewType == 0) {
                    c(baseViewHolder, livePlanetRankModel);
                } else if (itemViewType != 1) {
                } else {
                    b(baseViewHolder, livePlanetRankModel);
                }
            }
        }

        public final void b(BaseViewHolder helper, LivePlanetRankModel livePlanetRankModel) {
            Intrinsics.e(helper, "helper");
            TextView textView = (TextView) helper.getView(R.id.tv_content);
            if (textView == null) {
                return;
            }
            Intrinsics.a(livePlanetRankModel);
            textView.setText(livePlanetRankModel.getName());
        }

        public final void c(BaseViewHolder baseViewHolder, final LivePlanetRankModel livePlanetRankModel) {
            TextView textView;
            TextView textView2;
            if (baseViewHolder != null && (textView2 = (TextView) baseViewHolder.getView(R.id.tv_num)) != null) {
                textView2.setText(String.valueOf(baseViewHolder.getLayoutPosition() + 1));
            }
            Intrinsics.a(livePlanetRankModel);
            ImageLoader.a((IRequestHost) null, livePlanetRankModel.getAvatar()).b(R.drawable.live_planet_rank_default).c().a(baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_pic));
            if (baseViewHolder != null && (textView = (TextView) baseViewHolder.getView(R.id.tv_name)) != null) {
                textView.setText(livePlanetRankModel.getName());
            }
            RecyclerView view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.rv_goods);
            TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_value);
            if (this.c == 0) {
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
                if (view != null) {
                    view.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
                }
                Context context = this.a;
                Intrinsics.a(context);
                GiftAdapter giftAdapter = new GiftAdapter(context);
                if (view != null) {
                    view.setAdapter(giftAdapter);
                }
                giftAdapter.setDataAndNotify(livePlanetRankModel.getGoods());
            } else {
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                if (view != null) {
                    view.setVisibility(8);
                }
                if (textView3 != null) {
                    textView3.setText(AppInfo.d().getString(R.string.live_planet_rank_value) + ' ' + livePlanetRankModel.getEnergy());
                }
            }
            Intrinsics.a(baseViewHolder);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_live_recommend);
            if (StringUtils.a(livePlanetRankModel.getLid(), 0L) > 0) {
                imageView.setVisibility(0);
                ImageLoader.c(null, "img_live_recommend.png").g(-1).e(imageView.hashCode()).a(imageView);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_pic);
            if (imageView2 == null) {
                return;
            }
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRankItemFragment$MyAdapter$Qh3b0dh3Emm5Sf9ogxS1RpLF-e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LivePlanetRankItemFragment.MyAdapter.a(LivePlanetRankModel.this, this, view2);
                }
            });
        }

        public final Context getContext() {
            return this.a;
        }
    }

    private final FragmentLivePlanetRankItemBinding d() {
        return (FragmentLivePlanetRankItemBinding) this.a.getValue();
    }

    public final void a() {
        List<LivePlanetRankModel> list = this.b;
        if (list == null || list.size() <= 0) {
            d().b.setVisibility(8);
            d().a.setVisibility(0);
            d().c.setText(this.c);
            return;
        }
        LivePlanetRankModel livePlanetRankModel = new LivePlanetRankModel();
        livePlanetRankModel.setType(1);
        livePlanetRankModel.setName(this.d);
        this.b.add(livePlanetRankModel);
        d().b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        d().b.setAdapter(new MyAdapter(getContext(), this.e, this.b));
        d().b.setVisibility(0);
        d().a.setVisibility(8);
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void a(List<LivePlanetRankModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.b = list;
    }

    public final void b() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.B(new BluedUIHttpResponse<BluedEntity<LivePlanetRankModel, LivePlanetRankExtra>>(fragmentActive) { // from class: com.blued.android.module.live_china.fragment.LivePlanetRankItemFragment$getUserRank$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LivePlanetRankModel, LivePlanetRankExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LivePlanetRankItemFragment livePlanetRankItemFragment = LivePlanetRankItemFragment.this;
                List<LivePlanetRankModel> list = bluedEntity.data;
                Intrinsics.c(list, "bluedEntity!!.data");
                livePlanetRankItemFragment.a(list);
                if (bluedEntity.extra != null) {
                    LivePlanetRankItemFragment.this.a(bluedEntity.extra.getText());
                    LivePlanetRankItemFragment.this.b(bluedEntity.extra.getPlay_text());
                }
                LivePlanetRankItemFragment.this.a();
            }
        }, getFragmentActive());
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.d = str;
    }

    public final void c() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.C(new BluedUIHttpResponse<BluedEntity<LivePlanetRankModel, LivePlanetRankExtra>>(fragmentActive) { // from class: com.blued.android.module.live_china.fragment.LivePlanetRankItemFragment$getRecordRank$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LivePlanetRankModel, LivePlanetRankExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LivePlanetRankItemFragment livePlanetRankItemFragment = LivePlanetRankItemFragment.this;
                List<LivePlanetRankModel> list = bluedEntity.data;
                Intrinsics.c(list, "bluedEntity!!.data");
                livePlanetRankItemFragment.a(list);
                if (bluedEntity.extra != null) {
                    LivePlanetRankItemFragment.this.a(bluedEntity.extra.getText());
                    LivePlanetRankItemFragment.this.b(bluedEntity.extra.getPlay_text());
                }
                LivePlanetRankItemFragment.this.a();
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout root;
        FrameLayout root2;
        Intrinsics.e(inflater, "inflater");
        FragmentLivePlanetRankItemBinding d = d();
        if (((d == null || (root = d.getRoot()) == null) ? null : root.getParent()) != null) {
            FragmentLivePlanetRankItemBinding d2 = d();
            ViewParent parent = (d2 == null || (root2 = d2.getRoot()) == null) ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            FragmentLivePlanetRankItemBinding d3 = d();
            viewGroup2.removeView(d3 == null ? null : d3.getRoot());
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            a(arguments.getInt("position"));
        }
        if (this.e == 0) {
            b();
        } else {
            c();
        }
        FragmentLivePlanetRankItemBinding d4 = d();
        return d4 == null ? null : d4.getRoot();
    }
}
