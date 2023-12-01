package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveGiftSkinDlgFragment;
import com.blued.android.module.live_china.model.LiveGiftSkinItemModel;
import com.blued.android.module.live_china.model.LiveGiftSkinModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftSkinDlgFragment.class */
public class LiveGiftSkinDlgFragment extends LiveBaseDialogFragment {
    private ListView j;
    private ImageView k;
    private CommonAdapter<LiveGiftSkinModel> l;
    private ImageView m;
    private View n;
    private int o;
    private int p;
    private int q;
    private String r = null;
    private final int s = 2;
    private final int t = 1;
    private final int u = 0;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftSkinDlgFragment$GiftSkinAdapter.class */
    public class GiftSkinAdapter extends CommonRecycleAdapter<LiveGiftSkinItemModel> {
        private int b;

        public GiftSkinAdapter(Context context) {
            super(context);
            this.b = 0;
        }

        private int a() {
            if (this.b == 0) {
                this.b = (int) ((AppInfo.l - DisplayUtil.a(AppInfo.d(), 27.0f)) / 3.6f);
            }
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveGiftSkinItemModel liveGiftSkinItemModel, View view) {
            LiveGiftSkinDlgFragment.this.a((List<LiveGiftSkinItemModel>) this.dataList, liveGiftSkinItemModel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveGiftSkinItemModel liveGiftSkinItemModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            String str;
            String str2;
            View a2 = commonAdapterHolder.a(R.id.item_live_gift_skin_layout);
            ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
            if (layoutParams.width != a()) {
                layoutParams.width = a();
                a2.setLayoutParams(layoutParams);
            }
            int i2 = R.id.item_live_gift_skin_body_level;
            if (liveGiftSkinItemModel.is_original) {
                str = "初始";
            } else {
                str = "Lv." + liveGiftSkinItemModel.level;
            }
            CommonRecycleAdapter.CommonAdapterHolder b = commonAdapterHolder.a(i2, str).b(R.id.item_live_gift_skin_body_clock, liveGiftSkinItemModel.status == 0 ? 0 : 8);
            int i3 = R.id.item_live_gift_skin_body_task;
            if (liveGiftSkinItemModel.status == 2 || liveGiftSkinItemModel.status == 1) {
                str2 = "";
            } else {
                str2 = "(" + liveGiftSkinItemModel.process + BridgeUtil.SPLIT_MARK + liveGiftSkinItemModel.count + ")";
            }
            b.a(i3, str2).a(R.id.item_live_gift_skin_body_state, liveGiftSkinItemModel.status == 2 ? "使用中" : liveGiftSkinItemModel.status == 1 ? "已解锁" : "未解锁").a(R.id.item_live_gift_skin_body_state, liveGiftSkinItemModel.status == 2 ? LiveGiftSkinDlgFragment.this.q : liveGiftSkinItemModel.status == 1 ? LiveGiftSkinDlgFragment.this.p : LiveGiftSkinDlgFragment.this.o).c(R.id.item_live_gift_skin_body_btn, liveGiftSkinItemModel.status == 2 ? R.drawable.item_live_gift_skin_body_btn_used_bg : liveGiftSkinItemModel.status == 1 ? R.drawable.item_live_gift_skin_body_btn_unlock_bg : R.drawable.item_live_gift_skin_body_btn_bg).a(R.id.item_live_gift_skin_body_btn, new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftSkinDlgFragment$GiftSkinAdapter$kZPyCGrMS4s6VltrNTMj5nz5o1A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftSkinDlgFragment.GiftSkinAdapter.this.a(liveGiftSkinItemModel, view);
                }
            }).b(R.id.item_live_gift_skin_body_iv, liveGiftSkinItemModel.images_static);
            if (liveGiftSkinItemModel.isExposure) {
                return;
            }
            liveGiftSkinItemModel.isExposure = true;
            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_SKIN_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_live_gift_skin_body;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveGiftSkinItemModel> list, final LiveGiftSkinItemModel liveGiftSkinItemModel) {
        long j;
        if (liveGiftSkinItemModel == null || liveGiftSkinItemModel.status != 1) {
            return;
        }
        Iterator<LiveGiftSkinItemModel> it = list.iterator();
        while (true) {
            j = 0;
            if (!it.hasNext()) {
                break;
            }
            LiveGiftSkinItemModel next = it.next();
            if (next.status == 2) {
                j = next.goods_skin_id;
                break;
            }
        }
        h();
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CountModel>>(a()) { // from class: com.blued.android.module.live_china.mine.LiveGiftSkinDlgFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                Iterator it2 = LiveGiftSkinDlgFragment.this.l.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    LiveGiftSkinModel liveGiftSkinModel = (LiveGiftSkinModel) it2.next();
                    if (StringUtils.a(liveGiftSkinModel.goods_id, liveGiftSkinItemModel.goods_id) && liveGiftSkinModel.data != null) {
                        for (LiveGiftSkinItemModel liveGiftSkinItemModel2 : liveGiftSkinModel.data) {
                            if (liveGiftSkinItemModel2.goods_skin_id != liveGiftSkinItemModel.goods_skin_id && liveGiftSkinItemModel2.status == 2) {
                                liveGiftSkinItemModel2.status = 1;
                            }
                            if (liveGiftSkinItemModel2.goods_skin_id == liveGiftSkinItemModel.goods_skin_id) {
                                liveGiftSkinItemModel2.status = 2;
                            }
                        }
                    }
                }
                LiveGiftSkinDlgFragment.this.l.notifyDataSetChanged();
                LiveEventBusUtil.a(liveGiftSkinItemModel);
                ToastUtils.b("成功使用");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveGiftSkinDlgFragment.this.i();
            }
        }, liveGiftSkinItemModel.goods_id, j, liveGiftSkinItemModel.goods_skin_id, a());
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_SKIN_PAGE_USE_CLICK, liveGiftSkinItemModel.goods_id, liveGiftSkinItemModel.goods_skin_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        j();
    }

    private void k() {
        this.m.setImageResource(R.drawable.live_gift_skin_tips_img);
        this.n.setVisibility(0);
    }

    private void l() {
        this.n.setVisibility(8);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_gift_skin;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.j = (ListView) this.b.findViewById(R.id.live_gift_skin_lv);
        this.k = (ImageView) this.b.findViewById(R.id.live_gift_skin_bg_iv);
        CommonAdapter<LiveGiftSkinModel> commonAdapter = new CommonAdapter<LiveGiftSkinModel>(R.layout.item_live_gift_skin) { // from class: com.blued.android.module.live_china.mine.LiveGiftSkinDlgFragment.1
            @Override // com.blued.android.module.common.adapter.CommonAdapter
            public void a(CommonAdapter.ViewHolder viewHolder, LiveGiftSkinModel liveGiftSkinModel, int i) {
                viewHolder.a(R.id.item_live_gift_skin_name, liveGiftSkinModel.name);
                RecyclerView recyclerView = (RecyclerView) viewHolder.a(R.id.item_live_gift_skin_rv);
                if (recyclerView.getLayoutManager() == null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
                }
                GiftSkinAdapter giftSkinAdapter = (GiftSkinAdapter) recyclerView.getAdapter();
                GiftSkinAdapter giftSkinAdapter2 = giftSkinAdapter;
                if (giftSkinAdapter == null) {
                    giftSkinAdapter2 = new GiftSkinAdapter(AppInfo.d());
                    recyclerView.setAdapter(giftSkinAdapter2);
                }
                giftSkinAdapter2.setDataAndNotify(liveGiftSkinModel.data);
            }
        };
        this.l = commonAdapter;
        this.j.setAdapter((ListAdapter) commonAdapter);
        this.o = Color.parseColor("#989898");
        this.p = Color.parseColor("#C933CC");
        this.q = Color.parseColor("#EAEAEA");
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftSkinDlgFragment$t_N1rQyhSeb_yOh7N8zz77HnB1M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftSkinDlgFragment.this.c(view);
            }
        });
        this.b.findViewById(R.id.live_gift_skin_qa).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftSkinDlgFragment$16cNloyV_Ag7b8JDtrokE52lOwE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftSkinDlgFragment.this.b(view);
            }
        });
        this.m = (ImageView) this.b.findViewById(R.id.live_gift_skin_tips_iv);
        View findViewById = this.b.findViewById(R.id.live_gift_skin_tips_layout);
        this.n = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftSkinDlgFragment$cEe11nPlqkr8K3NStAbCnyaFV-M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftSkinDlgFragment.this.a(view);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        super.f();
        this.r = this.f10822c.getString("goods_id");
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void g() {
        super.g();
        h();
        LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<LiveGiftSkinModel>>(a()) { // from class: com.blued.android.module.live_china.mine.LiveGiftSkinDlgFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftSkinModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i >= bluedEntityA.data.size()) {
                        LiveGiftSkinDlgFragment.this.l.a(arrayList);
                        LiveGiftSkinDlgFragment.this.j.setSelection(i3);
                        return;
                    }
                    LiveGiftSkinModel liveGiftSkinModel = bluedEntityA.data.get(i);
                    int i4 = i3;
                    if (liveGiftSkinModel.data != null) {
                        int i5 = -1;
                        boolean z = false;
                        for (int i6 = 0; i6 < liveGiftSkinModel.data.size(); i6++) {
                            LiveGiftSkinItemModel liveGiftSkinItemModel = liveGiftSkinModel.data.get(i6);
                            if (liveGiftSkinItemModel.is_original) {
                                if (liveGiftSkinItemModel.status == 0) {
                                    liveGiftSkinItemModel.status = 1;
                                }
                                i5 = i6;
                            }
                            if (liveGiftSkinItemModel.wear == 1) {
                                liveGiftSkinItemModel.status = 2;
                                z = true;
                            }
                        }
                        if (!z && i5 >= 0) {
                            liveGiftSkinModel.data.get(i5).status = 2;
                        }
                        if (StringUtils.a(liveGiftSkinModel.goods_id, LiveGiftSkinDlgFragment.this.r)) {
                            i3 = i;
                        }
                        arrayList.add(liveGiftSkinModel);
                        i4 = i3;
                    }
                    i++;
                    i2 = i4;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveGiftSkinDlgFragment.this.i();
            }
        }, a());
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void j() {
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), -1, null);
        }
        super.j();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        j();
        return true;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.height = (int) (AppInfo.l * 0.42666668f);
        this.k.setLayoutParams(layoutParams);
        ImageLoader.a(a(), R.drawable.live_gift_skin_dlg_bg).a(15.0f, 15.0f, 0.0f, 0.0f).a(this.k);
    }
}
