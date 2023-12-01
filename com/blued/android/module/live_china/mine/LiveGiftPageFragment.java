package com.blued.android.module.live_china.mine;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.fragment.BaseGiftPageFragment;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftPageFragment.class */
public class LiveGiftPageFragment extends BaseGiftPageFragment {
    private int h = 0;

    @Override // com.blued.android.module.common.fragment.BaseGiftPageFragment
    public void a() {
        this.f10803a.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.live_china.mine.LiveGiftPageFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = LiveGiftPageFragment.this.h;
                rect.right = LiveGiftPageFragment.this.h;
            }
        });
        this.b = new LiveGiftAdapter(getActivity(), this, this.g);
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftPageFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.h = DensityUtils.a(getContext(), 2.0f);
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftPageFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_live_gift_page;
    }
}
