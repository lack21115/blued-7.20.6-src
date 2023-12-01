package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyWishRankingBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishRankModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishRankingView.class */
public class YYWishRankingView extends LinearLayout {
    private ViewYyWishRankingBinding a;
    private RankingAdapter b;
    private BaseYYStudioFragment c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishRankingView$RankingAdapter.class */
    public class RankingAdapter extends BaseQuickAdapter<YYWishRankModel, BaseViewHolder> {
        public RankingAdapter() {
            super(R.layout.item_ranking_layout, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            if (YYWishRankingView.this.c == null) {
                return;
            }
            YYRoomInfoManager.e().c().a(YYWishRankingView.this.getContext(), str, str2, str3, 0, 2);
            YYWishRankingView.this.c.onBackPressed();
            YYWishRankingView.this.c.getActivity().finish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYWishRankModel yYWishRankModel) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_rank);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_beans);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.host_name);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_host_head);
            ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.iv_user_head);
            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.card_left);
            textView.setText(CommonStringUtils.g(yYWishRankModel.beans));
            if (yYWishRankModel.receiver_info != null) {
                textView2.setText(yYWishRankModel.receiver_info.getName());
                ImageLoader.a(YYWishRankingView.this.c.getFragmentActive(), yYWishRankModel.receiver_info.getAvatar()).a(imageView2);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYWishRankingView.RankingAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        RankingAdapter.this.a(yYWishRankModel.receiver_info.getUid(), yYWishRankModel.receiver_info.getName(), yYWishRankModel.receiver_info.getAvatar());
                    }
                });
            }
            if (yYWishRankModel.sender_info != null) {
                ImageLoader.a(YYWishRankingView.this.c.getFragmentActive(), yYWishRankModel.sender_info.getAvatar()).a(imageView3);
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYWishRankingView.RankingAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        RankingAdapter.this.a(yYWishRankModel.sender_info.getUid(), yYWishRankModel.sender_info.getName(), yYWishRankModel.sender_info.getAvatar());
                    }
                });
            }
            int adapterPosition = baseViewHolder.getAdapterPosition();
            if (adapterPosition == 0) {
                ShapeHelper.a(shapeFrameLayout, R.color.syc_dark_F7DDA0, R.color.syc_dark_E7AF4D);
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.icon_ranking_1);
            } else if (adapterPosition == 1) {
                ShapeHelper.a(shapeFrameLayout, R.color.syc_dark_E5E9F2, R.color.syc_dark_B9BDD0);
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.icon_ranking_2);
            } else if (adapterPosition != 2) {
                ShapeHelper.a(shapeFrameLayout, R.color.syc_dark_b, R.color.syc_dark_b);
                imageView.setVisibility(4);
            } else {
                ShapeHelper.a(shapeFrameLayout, R.color.syc_dark_AD7239, R.color.syc_dark_EAAF76);
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.icon_ranking_3);
            }
        }
    }

    public YYWishRankingView(Context context) {
        this(context, null);
    }

    public YYWishRankingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYWishRankingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.a = ViewYyWishRankingBinding.a(LayoutInflater.from(getContext()), this, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.a.a.setLayoutManager(linearLayoutManager);
        this.b = new RankingAdapter();
        this.a.a.setAdapter(this.b);
    }

    private void b() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.D(b.room_id, new BluedUIHttpResponse<BluedEntityA<YYWishRankModel>>(this.c.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYWishRankingView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYWishRankModel> bluedEntityA) {
                if (bluedEntityA == null) {
                    return;
                }
                YYWishRankingView.this.b.setNewData(bluedEntityA.data);
            }
        }, this.c.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.c = baseYYStudioFragment;
        b();
    }
}
