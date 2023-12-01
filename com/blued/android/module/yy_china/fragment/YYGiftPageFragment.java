package com.blued.android.module.yy_china.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.fragment.BaseGiftPageFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYGiftAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftPageFragment.class */
public class YYGiftPageFragment extends BaseGiftPageFragment {
    @Override // com.blued.android.module.common.fragment.BaseGiftPageFragment
    public void a() {
        this.f10803a.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.fragment.YYGiftPageFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.right = DensityUtils.a(YYGiftPageFragment.this.getContext(), 5.0f);
            }
        });
        this.b = new YYGiftAdapter(this, this.g);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LiveEventBus.get("gift_free_time", Integer.class).observe(this, new Observer<Integer>() { // from class: com.blued.android.module.yy_china.fragment.YYGiftPageFragment.2
            /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
                if (r7.intValue() >= 60) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
                r0.setFreeTime(r7 + "s");
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
                r0 = r0.getResources().getDrawable(com.blued.android.module.yy_china.R.drawable.yy_gift_item_beans_true);
                r0.setBounds(0, 0, r0.getMinimumWidth(), r0.getMinimumHeight());
                r0.setCompoundDrawables(r0, null, null, null);
                r0.setFreeTime("0豆");
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x00c0, code lost:
                r0.setText(r0.getFreeTime());
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x00c7, code lost:
                return;
             */
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onChanged(java.lang.Integer r7) {
                /*
                    Method dump skipped, instructions count: 218
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYGiftPageFragment.AnonymousClass2.onChanged(java.lang.Integer):void");
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftPageFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_yy_gift_page;
    }
}
