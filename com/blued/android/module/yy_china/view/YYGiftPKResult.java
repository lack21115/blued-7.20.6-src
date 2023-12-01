package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPkDetailsModel;
import com.blued.android.module.yy_china.model.YYPkGoodItemModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftPKResult.class */
public class YYGiftPKResult extends LinearLayout {
    private TextView a;
    private ImageView b;
    private ImageView c;
    private RecyclerView d;
    private GiftPkAdapter e;
    private BaseYYStudioFragment f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftPKResult$GiftPkAdapter.class */
    public class GiftPkAdapter extends BaseQuickAdapter<YYPkGoodItemModel, BaseViewHolder> {
        public GiftPkAdapter() {
            super(R.layout.item_yy_gift_result, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYPkGoodItemModel yYPkGoodItemModel) {
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_index);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_gift_name);
            TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_gift_count);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_gift_img);
            int adapterPosition = baseViewHolder.getAdapterPosition() + 1;
            if (adapterPosition == 1) {
                textView.setTextColor(YYGiftPKResult.this.getResources().getColor(R.color.syc_00E0AB));
            } else {
                textView.setTextColor(YYGiftPKResult.this.getResources().getColor(R.color.syc_dark_j));
            }
            textView.setText(adapterPosition + "");
            textView2.setText(yYPkGoodItemModel.event_name);
            ImageLoader.a(YYGiftPKResult.this.f.getFragmentActive(), yYPkGoodItemModel.image).a(imageView);
            textView3.setText(yYPkGoodItemModel.vote_count + "票");
        }
    }

    public YYGiftPKResult(Context context) {
        super(context);
        a();
    }

    public YYGiftPKResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYGiftPKResult(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_gift_pk_result, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.tv_pk_user);
        this.b = (ImageView) findViewById(R.id.iv_pk_user);
        this.c = (ImageView) findViewById(R.id.iv_pk_close);
        this.d = findViewById(R.id.rv_result_list);
        this.e = new GiftPkAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.d.setLayoutManager(linearLayoutManager);
        this.d.setAdapter(this.e);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYGiftPKResult.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYGiftPKResult.this.f != null) {
                    YYGiftPKResult.this.f.y();
                }
            }
        });
    }

    private void getPKResultInfo() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.j(b.room_id, 1, new BluedUIHttpResponse<BluedEntityA<YYPkDetailsModel>>(this.f.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGiftPKResult.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPkDetailsModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYPkDetailsModel singleData = bluedEntityA.getSingleData();
                YYUserInfo yYUserInfo = singleData.user;
                if (yYUserInfo != null) {
                    YYGiftPKResult.this.a.setText(yYUserInfo.getName());
                    ImageLoader.a(YYGiftPKResult.this.f.getFragmentActive(), yYUserInfo.getAvatar()).a(YYGiftPKResult.this.b);
                }
                YYGiftPKResult.this.e.setNewData(singleData.event);
            }
        }, this.f.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.f = baseYYStudioFragment;
        getPKResultInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
