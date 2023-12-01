package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/UserinfoNewAlbumAdapter.class */
public class UserinfoNewAlbumAdapter extends BaseQuickAdapter<BluedAlbum, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f20087a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private String f20088c;
    private boolean d;
    private int e;

    public UserinfoNewAlbumAdapter(IRequestHost iRequestHost, Context context, String str, boolean z, int i) {
        super(R.layout.item_userinfo_new_album, new ArrayList());
        this.f20087a = context;
        this.b = iRequestHost;
        this.f20088c = str;
        this.d = z;
        this.e = i;
    }

    public void a() {
        if (this.mData != null && this.mData.size() > 0) {
            ((BluedAlbum) this.mData.get(0)).applyStatus = 2;
        }
        notifyDataSetChanged();
    }

    public void a(int i) {
        this.e = i;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedAlbum bluedAlbum) {
        if (baseViewHolder != null) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_cover);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_lock);
            ShapeTextView view = baseViewHolder.getView(R.id.tv_under_review);
            view.setVisibility(0);
            ShapeHelper.b(view, 2131102388);
            int i = bluedAlbum.applyStatus;
            if (i == 1) {
                view.setText((int) R.string.user_profile_apply_album);
                ImageLoader.a(this.b, bluedAlbum.getUrl()).b((int) R.drawable.private_album_icon).a(6.0f).a(imageView);
            } else if (i != 2) {
                if (bluedAlbum.audit_status == 1) {
                    ShapeHelper.b(view, 2131101800);
                    view.setText((int) R.string.pic_in_review);
                } else {
                    view.setVisibility(8);
                }
                ImageLoader.a(this.b, bluedAlbum.getUrl()).b((int) R.drawable.feed_photo_default).a(6.0f).a(imageView);
            } else {
                view.setText((int) R.string.user_profile_waiting_for_apply);
                ImageLoader.a(this.b, bluedAlbum.getUrl()).b((int) R.drawable.private_album_icon).a(6.0f).a(imageView);
            }
            if (this.d) {
                if (this.e == 2) {
                    imageView2.setImageResource(R.drawable.icon_userinfo_new_album_unlock);
                } else {
                    imageView2.setImageResource(R.drawable.icon_userinfo_new_album_lock);
                }
            } else if (bluedAlbum.applyStatus == 0) {
                imageView2.setImageResource(R.drawable.icon_userinfo_new_album_unlock);
            } else {
                imageView2.setImageResource(R.drawable.icon_userinfo_new_album_lock);
            }
        }
    }

    public void a(boolean z, String str) {
        if (!StringUtils.d(str) && !z) {
            Iterator it = this.mData.iterator();
            while (it.hasNext()) {
                if (str.equals(((BluedAlbum) it.next()).getPid())) {
                    it.remove();
                }
            }
        }
        notifyDataSetChanged();
    }

    public void b() {
        if (this.mData != null && this.mData.size() > 0) {
            ((BluedAlbum) this.mData.get(0)).applyStatus = 1;
        }
        notifyDataSetChanged();
    }
}
