package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.user.model.UserTag;
import com.soft.blued.R;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserFaceTagAdapter.class */
public class UserFaceTagAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f20066a;
    private List<UserTag> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20067c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserFaceTagAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ShapeLinearLayout f20068a;
        public ImageView b;

        private ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f20066a.inflate(R.layout.item_user_face_tag, viewGroup, false);
            viewHolder.f20068a = view2.findViewById(R.id.ll_bg);
            viewHolder.b = (ImageView) view2.findViewById(R.id.iv_user_face);
            ViewGroup.LayoutParams layoutParams = viewHolder.f20068a.getLayoutParams();
            layoutParams.width = (this.f20067c.getResources().getDisplayMetrics().widthPixels - DensityUtils.a(this.f20067c, 90.0f)) / 4;
            layoutParams.height = (int) (layoutParams.width * 1.3d);
            viewHolder.f20068a.setLayoutParams(layoutParams);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        UserTag userTag = this.b.get(i);
        ImageLoader.a((IRequestHost) null, userTag.icon).a(viewHolder.b);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.q = DensityUtils.a(this.f20067c, 2.0f);
        shapeModel.H = DensityUtils.a(this.f20067c, 12.0f);
        if (userTag.checked == 1) {
            shapeModel.n = BluedSkinUtils.a(this.f20067c, 2131101766);
            shapeModel.k = BluedSkinUtils.a(this.f20067c, 2131101780);
        } else {
            shapeModel.n = BluedSkinUtils.a(this.f20067c, 2131102360);
            shapeModel.k = BluedSkinUtils.a(this.f20067c, 2131102360);
        }
        viewHolder.f20068a.setShapeModel(shapeModel);
        return view2;
    }
}
