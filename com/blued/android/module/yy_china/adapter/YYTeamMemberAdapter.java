package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.IMemberClickListener;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYTeamMemberAdapter.class */
public class YYTeamMemberAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IMemberClickListener f16278a;

    public YYTeamMemberAdapter() {
        super(R.layout.item_team_member_layout, new ArrayList());
    }

    public void a(IMemberClickListener iMemberClickListener) {
        this.f16278a = iMemberClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_member_img);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_member_name);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_choice);
        ImageLoader.a((IRequestHost) null, yYSeatMemberModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
        textView.setText(yYSeatMemberModel.getName());
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYTeamMemberAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYTeamMemberAdapter.this.f16278a != null) {
                    YYTeamMemberAdapter.this.f16278a.a(baseViewHolder.getAdapterPosition());
                }
            }
        });
    }
}
