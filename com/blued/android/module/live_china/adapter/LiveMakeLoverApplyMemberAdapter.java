package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverApplyMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMakeLoverApplyMemberAdapter.class */
public class LiveMakeLoverApplyMemberAdapter extends BaseQuickAdapter<LiveMakeLoverApplyMemberModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f11650a;
    private boolean b;

    public LiveMakeLoverApplyMemberAdapter(Context context, boolean z) {
        super(R.layout.live_make_lover_apply_member_item_view, new ArrayList());
        this.f11650a = context;
        this.b = z;
    }

    public int a() {
        if (getData() != null) {
            return getData().size();
        }
        return 0;
    }

    public LiveMakeLoverApplyMemberModel a(int i) {
        if (getData() != null && i < getData().size() && i >= 0) {
            return getData().get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveMakeLoverApplyMemberModel liveMakeLoverApplyMemberModel) {
        View view = baseViewHolder.getView(R.id.ll_items_view);
        if (TextUtils.equals(liveMakeLoverApplyMemberModel.uid, LiveRoomInfo.a().f())) {
            view.setBackgroundColor(this.f11650a.getResources().getColor(R.color.syc_dark_ded9ff));
        } else {
            view.setBackground(null);
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_level);
        textView.setText("" + (liveMakeLoverApplyMemberModel.position + 1));
        ImageLoader.a((IRequestHost) null, liveMakeLoverApplyMemberModel.avatar).b(R.drawable.user_bg_round).c().a((ImageView) baseViewHolder.getView(R.id.avatar));
        ((TextView) baseViewHolder.getView(R.id.tv_name)).setText(liveMakeLoverApplyMemberModel.name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_done);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_ignore);
        if (this.b) {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView3.setVisibility(0);
        }
        baseViewHolder.addOnClickListener(R.id.ll_items_view);
        baseViewHolder.addOnClickListener(R.id.tv_done);
        baseViewHolder.addOnClickListener(R.id.tv_ignore);
    }

    public void a(List<LiveMakeLoverApplyMemberModel> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                setNewData(list);
                return;
            } else {
                list.get(i2).position = i2;
                i = i2 + 1;
            }
        }
    }
}
