package com.blued.android.module.live_china.mine.backpack;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.mine.backpack.observer.LiveGiftBackpackItemObserver;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackPageFragment.class */
public class LiveGiftBackpackPageFragment extends BaseGiftBagPageFragment implements LiveGiftBackpackItemObserver.ILiveBackpackObserver {
    private int h = 0;

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment
    public void a() {
        this.f13883a.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackPageFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = LiveGiftBackpackPageFragment.this.h;
                rect.right = LiveGiftBackpackPageFragment.this.h;
            }
        });
        this.b = new LiveGiftBackpackAdapter(getActivity(), this, this.g);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.observer.LiveGiftBackpackItemObserver.ILiveBackpackObserver
    public void a(Object obj) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.getDataList().size()) {
                ((LiveGiftModel) obj).isSelected = true;
                this.b.notifyDataSetChanged();
                return;
            }
            ((LiveGiftModel) this.b.getDataList().get(i2)).isSelected = false;
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.live_china.mine.backpack.observer.LiveGiftBackpackItemObserver.ILiveBackpackObserver
    public void a(Object obj, int i) {
        LiveGiftModel liveGiftModel = (LiveGiftModel) obj;
        LogUtils.d("pLog", "礼物数据刷新" + liveGiftModel.user_store_count + " ----- " + liveGiftModel.count);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.getDataList().size()) {
                return;
            }
            LiveGiftModel liveGiftModel2 = (LiveGiftModel) this.b.getDataList().get(i3);
            if (liveGiftModel2.ops == i && liveGiftModel2.goods_id.equals(liveGiftModel.goods_id)) {
                if (liveGiftModel.user_store_count <= 0) {
                    this.b.getDataList().remove(i3);
                    this.b.notifyItemRemoved(i3);
                    return;
                }
                liveGiftModel2.user_store_count = liveGiftModel.user_store_count;
                liveGiftModel2.expire_time = liveGiftModel.expire_time;
                liveGiftModel2.expire_info = liveGiftModel.expire_info;
                this.b.notifyItemChanged(i3);
                return;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.blued.android.module.live_china.mine.backpack.observer.LiveGiftBackpackItemObserver.ILiveBackpackObserver
    public void a(Object obj, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.b.getDataList().size()) {
                return;
            }
            LiveGiftModel liveGiftModel = (LiveGiftModel) this.b.getDataList().get(i4);
            if (liveGiftModel.ops == i) {
                if (liveGiftModel.is_use == 1) {
                    liveGiftModel.is_use = 0;
                    this.b.notifyItemChanged(i4);
                }
                if (liveGiftModel.goods_id.equals(((LiveGiftModel) obj).goods_id)) {
                    liveGiftModel.is_use = i2;
                    this.b.notifyItemChanged(i4);
                }
            }
            i3 = i4 + 1;
        }
    }

    public void b(Object obj) {
        if (obj != null) {
            LiveEventBus.get("gift_backpack_item_clicked").post((LiveGiftModel) obj);
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveGiftBackpackItemObserver.a().b(this);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.h = DensityUtils.a(getContext(), 2.0f);
        LiveGiftBackpackItemObserver.a().a((LiveGiftBackpackItemObserver.ILiveBackpackObserver) this);
    }

    @Override // com.blued.android.module.live_china.mine.backpack.BaseGiftBagPageFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_live_gift_page;
    }
}
