package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyGoldListViewBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGoldListView.class */
public class YYGoldListView extends LinearLayout {
    private ViewYyGoldListViewBinding a;
    private MemberAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGoldListView$MemberAdapter.class */
    public class MemberAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
        public MemberAdapter() {
            super(R.layout.item_yy_gold_member_layout, new ArrayList());
        }

        private void a(YYAudienceModel yYAudienceModel, ImageView imageView) {
            if (!YYRoomInfoManager.e().J()) {
                ImageLoader.a((IRequestHost) null, yYAudienceModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
            } else if (YYRoomInfoManager.e().g(yYAudienceModel.getUid())) {
                ImageLoader.a((IRequestHost) null, yYAudienceModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
            } else {
                ImageLoader.a((IRequestHost) null, R.drawable.icon_user_mask_without_text).b(R.drawable.user_bg_round).a(imageView);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYAudienceModel yYAudienceModel) {
            a(yYAudienceModel, (ImageView) baseViewHolder.getView(R.id.iv_user));
        }
    }

    public YYGoldListView(Context context) {
        this(context, null);
    }

    public YYGoldListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYGoldListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.a = ViewYyGoldListViewBinding.a(LayoutInflater.from(getContext()), this, true);
        this.b = new MemberAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.a.a.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.yy_china.view.YYGoldListView.1
            int a;

            {
                this.a = DensityUtils.a(YYGoldListView.this.getContext(), 5.0f);
            }

            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.left = 0;
                } else {
                    rect.left = -this.a;
                }
            }
        });
        this.a.a.setLayoutManager(linearLayoutManager);
        this.a.a.setAdapter(this.b);
        setGoldDatas(null);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setGoldDatas(List<YYAudienceModel> list) {
        if (list == null || list.isEmpty()) {
            this.a.a.setVisibility(8);
            return;
        }
        this.a.a.setVisibility(0);
        List<YYAudienceModel> list2 = list;
        if (list != null) {
            list2 = list;
            if (list.size() > 3) {
                list2 = list.subList(0, 3);
            }
        }
        this.b.setNewData(list2);
    }
}
