package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/SearchNewAdapter.class */
public class SearchNewAdapter extends PeopleListQuickAdapter {
    public String x;

    public SearchNewAdapter(List<UserFindResult> list, Activity activity, IRequestHost iRequestHost, String str, RecyclerView recyclerView) {
        super(list, activity, iRequestHost, str, recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.ui.find.adapter.PeopleListQuickAdapter, com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        super.convert(baseViewHolder, userFindResult);
        TextView textView = (TextView) baseViewHolder.getView(2131368652);
        textView.setTypeface(Typeface.defaultFromStyle(0));
        String str = userFindResult.name;
        if (!TextUtils.isEmpty(userFindResult.note)) {
            str = userFindResult.note;
        }
        UserRelationshipUtils.a(this.f30084a, textView, userFindResult);
        UserRelationshipUtils.a(this.f30084a, str, this.x, textView);
        baseViewHolder.getView(R.id.layout_friend).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.SearchNewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SearchNewAdapter.this.f30084a instanceof Activity) {
                    KeyboardUtils.a((Activity) SearchNewAdapter.this.f30084a);
                }
                FilterDialogFragment.f30190c = true;
                UserInfoFragmentNew.a(SearchNewAdapter.this.f30084a, userFindResult, "", baseViewHolder.getView(2131364232));
            }
        });
        baseViewHolder.setGone(R.id.online_time_view, false);
        TextView textView2 = (TextView) baseViewHolder.getView(2131363246);
        if (TextUtils.isEmpty(userFindResult.distance)) {
            textView2.setText("");
        } else {
            textView2.setText(DistanceUtils.a(userFindResult.distance, BlueAppLocal.c(), false));
        }
        DistanceUtils.a(this.f30084a, textView2, userFindResult, 1);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364625);
        if (userFindResult.online_state == 1) {
            imageView.setImageResource(2131233953);
        } else {
            imageView.setImageResource(2131233951);
        }
    }

    public void a(List<UserFindResult> list, String str) {
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (BlueAppLocal.d()) {
                    list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), false);
                    list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), false);
                } else {
                    list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), true);
                    list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), true);
                }
                i = i2 + 1;
            }
            setNewData(list);
        }
        this.x = str;
    }

    public void b(List<UserFindResult> list, String str) {
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (BlueAppLocal.d()) {
                    list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), false);
                    list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), false);
                } else {
                    list.get(i2).height = StringUtils.a(list.get(i2).height, BlueAppLocal.c(), true);
                    list.get(i2).weight = StringUtils.b(list.get(i2).weight, BlueAppLocal.c(), true);
                }
                i = i2 + 1;
            }
            addData((Collection<? extends UserFindResult>) list);
        }
        this.x = str;
    }
}
