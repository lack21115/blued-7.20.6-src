package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.view.FlowLayout;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/UserLabelAdapterNew.class */
public class UserLabelAdapterNew extends BaseMultiItemQuickAdapter<UserTag, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f33312a;
    private OnItemClickListener b;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/UserLabelAdapterNew$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(UserTag userTag, int i);
    }

    public UserLabelAdapterNew(Context context) {
        super(new ArrayList());
        this.f33312a = context;
        a();
    }

    private void a() {
        addItemType(0, R.layout.item_user_label_new);
        addItemType(1, R.layout.item_user_title);
    }

    private void b(BaseViewHolder baseViewHolder, UserTag userTag) {
        baseViewHolder.setText(R.id.user_label_title, userTag.name);
    }

    private void c(BaseViewHolder baseViewHolder, final UserTag userTag) {
        FlowLayout flowLayout = (FlowLayout) baseViewHolder.getView(R.id.user_label_flow_layout);
        if (userTag.tagList == null || userTag.tagList.size() <= 0) {
            return;
        }
        flowLayout.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= userTag.tagList.size()) {
                flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.1
                    @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
                    public void onItemClick(View view, int i3) {
                        if (UserLabelAdapterNew.this.b != null) {
                            UserLabelAdapterNew.this.b.a(userTag, i3);
                        }
                    }
                });
                return;
            }
            View inflate = LayoutInflater.from(this.f33312a).inflate(R.layout.user_label_text_view, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(2131372684);
            textView.setText(userTag.tagList.get(i2).name);
            if (userTag.tagList.get(i2).checked == 0) {
                textView.setBackgroundResource(R.drawable.user_job_text_bg);
                textView.setTextColor(BluedSkinUtils.a(this.f33312a, 2131102254));
            } else {
                textView.setBackgroundResource(R.drawable.user_job_text_select_bg);
                textView.setTextColor(BluedSkinUtils.a(this.f33312a, 2131101780));
            }
            if (userTag.tagList.get(i2).chooseable) {
                textView.setBackground(textView.getBackground());
                textView.setTextColor(textView.getTextColors());
            } else {
                textView.setBackgroundResource(R.drawable.user_job_text_bg);
                textView.setTextColor(BluedSkinUtils.a(this.f33312a, 2131102260));
            }
            flowLayout.addView(inflate);
            i = i2 + 1;
        }
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

    public void a(OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }
}
