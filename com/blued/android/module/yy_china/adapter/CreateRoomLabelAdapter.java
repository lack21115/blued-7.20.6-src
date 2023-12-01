package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.OnClickRoomLabelListener;
import com.blued.android.module.yy_china.model.HomeTopicModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/CreateRoomLabelAdapter.class */
public final class CreateRoomLabelAdapter extends BaseQuickAdapter<HomeTopicModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final OnClickRoomLabelListener f16117a;
    private HomeTopicModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRoomLabelAdapter(OnClickRoomLabelListener clickRoomTypeListener) {
        super(R.layout.item_yy_create_room_laber);
        Intrinsics.e(clickRoomTypeListener, "clickRoomTypeListener");
        this.f16117a = clickRoomTypeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HomeTopicModel homeTopicModel, CreateRoomLabelAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (homeTopicModel == null) {
            return;
        }
        this$0.a(homeTopicModel);
        this$0.f16117a.a(homeTopicModel, "");
    }

    public final void a(HomeTopicModel homeTopicModel) {
        this.b = homeTopicModel;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final HomeTopicModel homeTopicModel) {
        View view;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.tv_type);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.view_border);
        if (findViewById2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
        ImageView imageView = (ImageView) findViewById2;
        Integer valueOf = homeTopicModel == null ? null : Integer.valueOf(homeTopicModel.getLabel_id());
        HomeTopicModel homeTopicModel2 = this.b;
        if (Intrinsics.a(valueOf, homeTopicModel2 == null ? null : Integer.valueOf(homeTopicModel2.getLabel_id()))) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(homeTopicModel == null ? null : homeTopicModel.getLabel_name());
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$CreateRoomLabelAdapter$Dk-7WN-hxAicu2Zv6JT4uvz3mzc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateRoomLabelAdapter.a(HomeTopicModel.this, this, view2);
            }
        });
    }
}
