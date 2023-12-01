package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogSetRelationshipBinding;
import com.blued.android.module.yy_china.databinding.ItemRelationshipTimeBinding;
import com.blued.android.module.yy_china.databinding.ItemRelationshipTypeBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.YYSetRelationTypeModel;
import com.blued.android.module.yy_china.model.YYSetTypesModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSetRelationshipView.class */
public class YYSetRelationshipView extends RelativeLayout implements View.OnClickListener {
    private DialogSetRelationshipBinding a;
    private BaseYYStudioFragment b;
    private TimeAdapter c;
    private TypeAdapter d;
    private YYSetRelationTypeModel e;
    private YYSetRelationTypeModel f;
    private SetRelationShipListener g;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSetRelationshipView$SetRelationShipListener.class */
    public interface SetRelationShipListener {
        void a(YYSetRelationTypeModel yYSetRelationTypeModel, YYSetRelationTypeModel yYSetRelationTypeModel2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSetRelationshipView$TimeAdapter.class */
    public class TimeAdapter extends BaseQuickAdapter<YYSetRelationTypeModel, BaseViewHolder> {
        public TimeAdapter() {
            super(R.layout.item_relationship_time, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYSetRelationTypeModel yYSetRelationTypeModel) {
            ItemRelationshipTimeBinding a = ItemRelationshipTimeBinding.a(baseViewHolder.itemView);
            if (yYSetRelationTypeModel.equals(YYSetRelationshipView.this.e)) {
                ShapeHelper.b(a.a, R.color.transparent);
                ShapeHelper.a(a.a, YYSetRelationshipView.this.getResources().getDrawable(R.drawable.shape_mb_272727));
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, R.color.syc_dark_b);
            } else {
                ShapeHelper.a(a.a, (Drawable) null);
                ShapeHelper.b(a.a, R.color.syc_272727);
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, R.color.syc_dark_j);
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, 100.0f);
            }
            a.a.setText(String.format(YYSetRelationshipView.this.getResources().getString(R.string.yy_day), yYSetRelationTypeModel.getContent()));
            a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYSetRelationshipView.TimeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYSetRelationshipView.this.e = yYSetRelationTypeModel;
                    TimeAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSetRelationshipView$TypeAdapter.class */
    public class TypeAdapter extends BaseQuickAdapter<YYSetRelationTypeModel, BaseViewHolder> {
        public TypeAdapter() {
            super(R.layout.item_relationship_type, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYSetRelationTypeModel yYSetRelationTypeModel) {
            ItemRelationshipTypeBinding a = ItemRelationshipTypeBinding.a(baseViewHolder.itemView);
            if (yYSetRelationTypeModel.equals(YYSetRelationshipView.this.f)) {
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, R.color.syc_dark_b);
                ShapeHelper.a(a.a, YYSetRelationshipView.this.getResources().getDrawable(R.drawable.shape_mb_272727));
            } else {
                ShapeHelper.a(a.a, (Drawable) null);
                ShapeHelper.b(a.a, R.color.syc_272727);
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, R.color.syc_dark_j);
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, 100.0f);
            }
            a.a.setText(yYSetRelationTypeModel.getContent());
            a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYSetRelationshipView.TypeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYSetRelationshipView.this.f = yYSetRelationTypeModel;
                    TypeAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    public YYSetRelationshipView(Context context) {
        this(context, null);
    }

    public YYSetRelationshipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYSetRelationshipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = DialogSetRelationshipBinding.a(LayoutInflater.from(context), this, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.a.b.setLayoutManager(linearLayoutManager);
        this.a.a.setLayoutManager(new LinearLayoutManager(getContext()));
        this.a.c.setOnClickListener(this);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, String str, SetRelationShipListener setRelationShipListener) {
        this.b = baseYYStudioFragment;
        this.g = setRelationShipListener;
        this.c = new TimeAdapter();
        this.a.b.setAdapter(this.c);
        this.d = new TypeAdapter();
        this.a.a.setAdapter(this.d);
        YYRoomHttpUtils.Q(str, new BluedUIHttpResponse<BluedEntityA<YYSetTypesModel>>(baseYYStudioFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYSetRelationshipView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYSetTypesModel> bluedEntityA) {
                YYSetTypesModel singleData;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                if (singleData.getRelation() != null && singleData.getRelation().size() > 0) {
                    YYSetRelationshipView.this.f = singleData.getRelation().get(0);
                    YYSetRelationshipView.this.d.setNewData(singleData.getRelation());
                }
                if (singleData.getDuration() == null || singleData.getDuration().size() <= 0) {
                    return;
                }
                YYSetRelationshipView.this.e = singleData.getDuration().get(0);
                YYSetRelationshipView.this.c.setNewData(singleData.getDuration());
            }
        }, baseYYStudioFragment.getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYSetRelationTypeModel yYSetRelationTypeModel;
        Tracker.onClick(view);
        YYSetRelationTypeModel yYSetRelationTypeModel2 = this.f;
        if (yYSetRelationTypeModel2 == null || (yYSetRelationTypeModel = this.e) == null) {
            return;
        }
        SetRelationShipListener setRelationShipListener = this.g;
        if (setRelationShipListener != null) {
            setRelationShipListener.a(yYSetRelationTypeModel, yYSetRelationTypeModel2);
        }
        this.b.y();
    }
}
