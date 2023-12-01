package com.soft.blued.ui.setting.adapter;

import android.util.Log;
import android.widget.TextView;
import com.blued.android.module.common.user.model.UserTag;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/UserLabelAdapter.class */
public class UserLabelAdapter extends BaseMultiItemQuickAdapter<UserTag, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private TextView f19620a;

    public UserLabelAdapter() {
        super(new ArrayList());
        a();
    }

    private void a() {
        addItemType(0, R.layout.item_user_label);
        addItemType(1, R.layout.item_user_title);
    }

    private void b(BaseViewHolder baseViewHolder, UserTag userTag) {
        baseViewHolder.setText(R.id.user_label_title, userTag.name);
    }

    private void c(BaseViewHolder baseViewHolder, UserTag userTag) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.user_label_text);
        this.f19620a = textView;
        textView.setText(userTag.name);
        Log.v("drb", "bindLabelView:" + userTag.name + " -- " + userTag.checked);
        if (userTag.checked == 1) {
            this.f19620a.setBackgroundResource(R.drawable.user_job_text_select_bg);
            this.f19620a.setTextColor(this.mContext.getResources().getColor(2131101780));
        } else {
            this.f19620a.setBackgroundResource(R.drawable.user_job_text_bg);
            this.f19620a.setTextColor(this.mContext.getResources().getColor(2131102254));
        }
        if (!userTag.chooseable) {
            this.f19620a.setBackgroundResource(R.drawable.user_job_text_bg);
            this.f19620a.setTextColor(this.mContext.getResources().getColor(2131102260));
            return;
        }
        TextView textView2 = this.f19620a;
        textView2.setBackground(textView2.getBackground());
        TextView textView3 = this.f19620a;
        textView3.setTextColor(textView3.getTextColors());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserTag userTag) {
        if (baseViewHolder != null) {
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 0) {
                c(baseViewHolder, userTag);
            } else if (itemViewType != 1) {
            } else {
                b(baseViewHolder, userTag);
            }
        }
    }
}
