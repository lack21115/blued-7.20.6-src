package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/VisitorGitVipAvatarAdapter.class */
public class VisitorGitVipAvatarAdapter extends BaseQuickAdapter<BluedMyVisitorList.ProfilePicture, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f16464a;
    private IRequestHost b;

    public VisitorGitVipAvatarAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_visitor_git_vip_avatar, null);
        this.f16464a = context;
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedMyVisitorList.ProfilePicture profilePicture) {
        if (baseViewHolder == null || baseViewHolder.getAdapterPosition() == -1) {
            return;
        }
        int adapterPosition = baseViewHolder.getAdapterPosition();
        List<BluedMyVisitorList.ProfilePicture> data = getData();
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_avatar1);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_avatar2);
        ImageLoader.a(this.b, data.get(adapterPosition).url).b((int) R.drawable.user_bg_round_border_white).a(2.0f, this.f16464a.getResources().getColor(2131101191)).a(imageView);
        int size = data.size();
        int i = adapterPosition + 1;
        if (size > i) {
            ImageLoader.a(this.b, data.get(i).url).b((int) R.drawable.user_bg_round_border_white).a(2.0f, this.f16464a.getResources().getColor(2131101191)).a(imageView2);
        }
    }
}
