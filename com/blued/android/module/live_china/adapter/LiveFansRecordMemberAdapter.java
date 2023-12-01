package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFansRecordMemberAdapter.class */
public class LiveFansRecordMemberAdapter extends BaseQuickAdapter<LiveFansMemberModel, BaseViewHolder> {
    private Context a;

    public LiveFansRecordMemberAdapter(Context context) {
        super(R.layout.live_fans_record_member_item_view, new ArrayList());
        this.a = context;
    }

    public int a() {
        if (getData() != null) {
            return getData().size();
        }
        return 0;
    }

    public LiveFansMemberModel a(int i) {
        if (getData() != null && i < getData().size() && i >= 0) {
            return (LiveFansMemberModel) getData().get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveFansMemberModel liveFansMemberModel) {
        ImageLoader.a((IRequestHost) null, liveFansMemberModel.avatar).b(R.drawable.user_bg_round).c().a((ImageView) baseViewHolder.getView(R.id.avatar));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_fans_new);
        if (liveFansMemberModel.is_new == 1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ((TextView) baseViewHolder.getView(R.id.tv_name)).setText(liveFansMemberModel.fans_name);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_num);
        textView.setText(liveFansMemberModel.relation + "");
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_fans_name);
        textView2.setText(liveFansMemberModel.name);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_level_num);
        textView3.setText(liveFansMemberModel.level + "");
        View view = baseViewHolder.getView(R.id.ll_level);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_heart);
        if (liveFansMemberModel.brand_status == 1) {
            textView3.setTextColor(AppInfo.d().getResources().getColor(com.blued.android.module.common.R.color.syc_dark_E07F00));
            view.setBackgroundResource(R.drawable.live_fans_heart_level_badge_bg);
            imageView2.setImageResource(R.drawable.live_fans_heart_level_badge_heart);
        } else {
            textView3.setTextColor(AppInfo.d().getResources().getColor(com.blued.android.module.common.R.color.syc_dark_777777));
            view.setBackgroundResource(R.drawable.live_fans_heart_level_badge_bg_grey);
            imageView2.setImageResource(R.drawable.live_fans_heart_level_badge_heart_grey);
        }
        textView2.getPaint().setFakeBoldText(true);
        textView3.getPaint().setFakeBoldText(true);
        baseViewHolder.addOnClickListener(R.id.ll_items_view);
    }

    public void a(List<LiveFansMemberModel> list) {
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
