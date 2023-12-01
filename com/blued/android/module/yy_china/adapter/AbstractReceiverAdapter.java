package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/AbstractReceiverAdapter.class */
public abstract class AbstractReceiverAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private int f16110a;
    private ActivityFragmentActive b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractReceiverAdapter(Context context, ActivityFragmentActive fragmentActive, int i) {
        super(i, new ArrayList());
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.b = fragmentActive;
        this.mContext = context;
        this.f16110a = DensityUtils.a(context, 1.0f);
    }

    public abstract CardView a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        b(baseViewHolder, yYSeatMemberModel);
        if (yYSeatMemberModel != null && yYSeatMemberModel.isSelected) {
            ImageView d = d();
            if (d != null) {
                d.setVisibility(0);
            }
            CardView a2 = a();
            if (a2 != null) {
                a2.setContentPadding(0, 0, 0, 0);
            }
        } else {
            ImageView d2 = d();
            if (d2 != null) {
                d2.setVisibility(4);
            }
            CardView a3 = a();
            if (a3 != null) {
                int i = this.f16110a;
                a3.setContentPadding(i, i, i, i);
            }
        }
        YYRoomInfoManager.e().a(this.b, b(), yYSeatMemberModel == null ? null : yYSeatMemberModel.getUid(), yYSeatMemberModel == null ? null : yYSeatMemberModel.getAvatar());
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        if ((baseViewHolder != null && baseViewHolder.getAdapterPosition() == 0) && TextUtils.equals(b.chat_type, "9")) {
            if (yYSeatMemberModel != null && yYSeatMemberModel.mic_position == 0) {
                TextView c2 = c();
                if (c2 != null) {
                    c2.setText("主持人");
                }
                TextView c3 = c();
                if (c3 == null) {
                    return;
                }
                c3.setVisibility(0);
                return;
            }
        }
        if (!TextUtils.equals(yYSeatMemberModel == null ? null : yYSeatMemberModel.getUid(), b.uid)) {
            TextView c4 = c();
            if (c4 == null) {
                return;
            }
            c4.setVisibility(4);
            return;
        }
        TextView c5 = c();
        if (c5 != null) {
            c5.setText("房主");
        }
        TextView c6 = c();
        if (c6 == null) {
            return;
        }
        c6.setVisibility(0);
    }

    public abstract ImageView b();

    public abstract void b(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel);

    public abstract TextView c();

    public abstract ImageView d();
}
