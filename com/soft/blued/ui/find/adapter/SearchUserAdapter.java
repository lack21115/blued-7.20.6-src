package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/SearchUserAdapter.class */
public class SearchUserAdapter extends BaseQuickAdapter<UserBasicModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private String f30140a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f30141c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final UserBasicModel userBasicModel) {
        int indexOf;
        UserInfoHelper.a((ImageView) baseViewHolder.getView(2131364720), userBasicModel.vbadge, 3);
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        int i = 0;
        ImageLoader.a(this.f30141c, AvatarUtils.a(0, userBasicModel.avatar)).c().b(2131237310).a(imageView);
        UserInfoHelper.a(this.b, (TextView) baseViewHolder.getView(2131369448), userBasicModel.role);
        TextView textView = (TextView) baseViewHolder.getView(2131363246);
        if (TextUtils.isEmpty(userBasicModel.distance)) {
            textView.setText("");
        } else {
            textView.setText(DistanceUtils.a(userBasicModel.distance, BlueAppLocal.c(), false));
        }
        DistanceUtils.a(this.b, textView, userBasicModel, 1);
        TextView textView2 = (TextView) baseViewHolder.getView(2131368652);
        if (TextUtils.isEmpty(userBasicModel.name)) {
            textView2.setText("");
        } else {
            textView2.setText(userBasicModel.name);
        }
        UserRelationshipUtils.a(this.b, textView2, userBasicModel);
        UserRelationshipUtils.a((ImageView) baseViewHolder.getView(2131364459), userBasicModel);
        TextView textView3 = (TextView) baseViewHolder.getView(2131362003);
        if (TextUtils.isEmpty(userBasicModel.age)) {
            textView3.setText("");
        } else {
            textView3.setText(userBasicModel.age + this.b.getResources().getString(2131886374));
        }
        TextView textView4 = (TextView) baseViewHolder.getView(2131364242);
        if (TextUtils.isEmpty(userBasicModel.height)) {
            textView4.setText("");
        } else {
            textView4.setText(userBasicModel.height);
        }
        TextView textView5 = (TextView) baseViewHolder.getView(2131373390);
        if (TextUtils.isEmpty(userBasicModel.weight)) {
            textView5.setText("");
        } else {
            textView5.setText(userBasicModel.weight);
        }
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.sign_view);
        if (TextUtils.isEmpty(userBasicModel.description)) {
            textView6.setVisibility(4);
        } else {
            textView6.setVisibility(0);
            textView6.setText(userBasicModel.description);
        }
        String str = userBasicModel.name;
        if (TextUtils.isEmpty(str)) {
            textView2.setText("");
        } else if (str.toLowerCase().contains(this.f30140a.toLowerCase())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            String lowerCase = str.toLowerCase();
            this.f30140a = this.f30140a.toLowerCase();
            while (i < lowerCase.length() && (indexOf = lowerCase.indexOf(this.f30140a, i)) >= 0) {
                spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, this.f30140a.length() + indexOf, 33);
                i = Math.max(i + 1, indexOf);
            }
            textView2.setText(spannableStringBuilder);
        } else {
            textView2.setText(str);
        }
        baseViewHolder.getView(2131368209).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.SearchUserAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FilterDialogFragment.f30190c = true;
                UserInfoFragmentNew.a(SearchUserAdapter.this.b, userBasicModel, "", imageView);
            }
        });
    }
}
