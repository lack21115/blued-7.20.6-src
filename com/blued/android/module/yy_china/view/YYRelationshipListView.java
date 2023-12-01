package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRelationListBinding;
import com.blued.android.module.yy_china.databinding.ItemRelationListBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.UserAuctionModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationshipListView.class */
public class YYRelationshipListView extends RelativeLayout implements View.OnClickListener {
    private DialogRelationListBinding a;
    private BaseYYStudioFragment b;
    private RelationShipAdapter c;
    private String d;
    private String e;
    private String f;
    private String g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationshipListView$RelationShipAdapter.class */
    public class RelationShipAdapter extends BaseQuickAdapter<UserAuctionModel, BaseViewHolder> {
        public RelationShipAdapter() {
            super(R.layout.item_relation_list, new ArrayList());
        }

        private void a(BaseViewHolder baseViewHolder, final UserAuctionModel userAuctionModel, int i) {
            ItemRelationListBinding a = ItemRelationListBinding.a(baseViewHolder.itemView);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYRelationshipListView.RelationShipAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYRoomInfoManager.e().c().a(YYRelationshipListView.this.getContext(), userAuctionModel.getAuction_uid(), userAuctionModel.getAuction_name(), userAuctionModel.getAuction_avatar(), userAuctionModel.getAuction_vbadge(), 2);
                    YYRelationshipListView.this.b.onBackPressed();
                    YYRelationshipListView.this.b.getActivity().finish();
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYRelationshipListView.RelationShipAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYRoomInfoManager.e().c().a(YYRelationshipListView.this.getContext(), userAuctionModel.getTarget_uid(), userAuctionModel.getTarget_name(), userAuctionModel.getTarget_avatar(), userAuctionModel.getTarget_vbadge(), 2);
                    YYRelationshipListView.this.b.onBackPressed();
                    YYRelationshipListView.this.b.getActivity().finish();
                }
            };
            if (YYRelationshipListView.this.d.equals(userAuctionModel.getAuction_uid())) {
                ImageLoader.a(YYRelationshipListView.this.b.getFragmentActive(), userAuctionModel.getAuction_avatar()).c().a(a.c);
                a.c.setOnClickListener(onClickListener);
                ImageLoader.a(YYRelationshipListView.this.b.getFragmentActive(), userAuctionModel.getTarget_avatar()).c().a(a.d);
                a.d.setOnClickListener(onClickListener2);
            } else {
                a.d.setOnClickListener(onClickListener);
                a.c.setOnClickListener(onClickListener2);
                ImageLoader.a(YYRelationshipListView.this.b.getFragmentActive(), userAuctionModel.getAuction_avatar()).c().a(a.d);
                ImageLoader.a(YYRelationshipListView.this.b.getFragmentActive(), userAuctionModel.getTarget_avatar()).c().a(a.c);
            }
            ImageLoader.a(YYRelationshipListView.this.b.getFragmentActive(), userAuctionModel.getRelation_image()).a(a.b);
            a.g.setText(userAuctionModel.getIntimacy_name());
            TextView textView = a.f;
            textView.setText("亲密值: " + CommonStringUtils.g(userAuctionModel.getIntimacy_val()));
            TextView textView2 = a.e;
            textView2.setText("竞拍值: " + CommonStringUtils.g(userAuctionModel.getAuction_val()));
            a.a.setVisibility(4);
            if (i == 0) {
                a.a.setVisibility(0);
                a.a.setImageResource(R.drawable.icn_relation_ship_num_1);
            } else if (i == 1) {
                a.a.setVisibility(0);
                a.a.setImageResource(R.drawable.icn_relation_ship_num_2);
            } else if (i == 2) {
                a.a.setVisibility(0);
                a.a.setImageResource(R.drawable.icn_relation_ship_num_3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, UserAuctionModel userAuctionModel) {
        }

        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            super.onBindViewHolder(baseViewHolder, i);
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 0) {
                a(baseViewHolder, (UserAuctionModel) getItem(i - getHeaderLayoutCount()), i);
            } else if (itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365) {
            } else {
                a(baseViewHolder, (UserAuctionModel) getItem(i - getHeaderLayoutCount()), i);
            }
        }
    }

    public YYRelationshipListView(Context context) {
        this(context, null);
    }

    public YYRelationshipListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYRelationshipListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DialogRelationListBinding a = DialogRelationListBinding.a(LayoutInflater.from(context), this, true);
        this.a = a;
        a.a.setOnClickListener(this);
        this.a.b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.c = new RelationShipAdapter();
        this.a.b.setAdapter(this.c);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.b = baseYYStudioFragment;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = z;
        YYRoomHttpUtils.e(str, str2, str6, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserAuctionModel>>(baseYYStudioFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYRelationshipListView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserAuctionModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                YYRelationshipListView.this.c.setNewData(bluedEntityA.data);
            }
        }, (IRequestHost) baseYYStudioFragment.getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        BaseYYStudioFragment baseYYStudioFragment = this.b;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.a(this.d, this.e, this.f, this.g, this.h);
        }
    }
}
