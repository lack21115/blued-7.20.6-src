package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.community.model.AlbumFlow;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/WaterfallPicturesAdapter.class */
public class WaterfallPicturesAdapter extends BaseQuickAdapter<AlbumFlow, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f33817a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f33818c;
    private int d;
    private int e;
    private Set<String> f;
    private List<AlbumFlow> g;
    private List<AlbumFlow> h;
    private IRequestHost i;

    public WaterfallPicturesAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_picture_list, new ArrayList());
        this.f = new HashSet();
        this.h = new ArrayList();
        this.g = new ArrayList();
        this.i = iRequestHost;
        this.b = (AppInfo.l - DensityUtils.a(context, 30.0f)) / 2;
        this.d = DensityUtils.a(context, 400.0f);
        this.e = DensityUtils.a(context, 130.0f);
    }

    private boolean a(AlbumFlow albumFlow) {
        boolean z = false;
        int parseInt = Integer.parseInt(albumFlow.feed_pics_width[0]);
        int parseInt2 = Integer.parseInt(albumFlow.feed_pics_height[0]);
        float f = parseInt2 != 0 ? parseInt / parseInt2 : 0.0f;
        if (f != 0.0f) {
            this.f33818c = (int) (this.b / f);
        }
        if (this.f33818c > this.d) {
            z = true;
        }
        if (z) {
            this.f33818c = this.d;
            return z;
        }
        int i = this.f33818c;
        int i2 = this.e;
        int i3 = i;
        if (i < i2) {
            i3 = i2;
        }
        this.f33818c = i3;
        return z;
    }

    public List<AlbumFlow> a() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, AlbumFlow albumFlow) {
        if (baseViewHolder != null) {
            this.f33817a = (ImageView) baseViewHolder.getView(R.id.riv_picture);
            baseViewHolder.setText(2131371808, albumFlow.feed_dig + "");
            if (albumFlow.feed_dig == 0 || albumFlow.iliked == 0) {
                baseViewHolder.setImageResource(R.id.iv_icon_like, R.drawable.icon_unlike);
                baseViewHolder.setTextColor(2131371808, this.mContext.getResources().getColor(2131101191));
            }
            if (albumFlow.iliked != 0) {
                baseViewHolder.setImageResource(R.id.iv_icon_like, R.drawable.icon_liked);
                baseViewHolder.setTextColor(2131371808, this.mContext.getResources().getColor(2131101198));
            }
            if (a(albumFlow)) {
                baseViewHolder.setVisible(R.id.tv_long_picutre, true);
            } else {
                baseViewHolder.setVisible(R.id.tv_long_picutre, false);
            }
            if (TextUtils.isEmpty(albumFlow.score) || "0".equals(albumFlow.score)) {
                baseViewHolder.setVisible(2131372501, false);
            } else {
                baseViewHolder.setVisible(2131372501, true);
                baseViewHolder.setText(2131372501, albumFlow.score);
            }
        }
        baseViewHolder.addOnClickListener(R.id.iv_icon_like);
        this.f33817a.setLayoutParams(new ConstraintLayout.LayoutParams(this.b, this.f33818c));
        ImageLoader.a(this.i, albumFlow.feed_pics[0]).b(2131101212).a(3.0f).a(this.f33817a);
    }

    public void a(String str, int i) {
        try {
            List<AlbumFlow> data = getData();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= data.size()) {
                    break;
                }
                if (data.get(i3).feed_id.equals(str)) {
                    data.get(i3).iliked = i;
                    if (i == 1) {
                        data.get(i3).feed_dig++;
                    } else {
                        data.get(i3).feed_dig--;
                    }
                }
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends AlbumFlow> collection) {
        ArrayList arrayList = new ArrayList(collection);
        this.h.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                super.setNewData(this.g);
                return;
            }
            if (!TextUtils.isEmpty(((AlbumFlow) arrayList.get(i2)).hash_id) && !this.f.contains(((AlbumFlow) arrayList.get(i2)).hash_id)) {
                this.f.add(((AlbumFlow) arrayList.get(i2)).hash_id);
                this.h.add((AlbumFlow) arrayList.get(i2));
                this.g.add((AlbumFlow) arrayList.get(i2));
            }
            i = i2 + 1;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<AlbumFlow> list) {
        this.f.clear();
        this.g.clear();
        if (list == null) {
            super.setNewData(list);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                super.setNewData(this.g);
                return;
            }
            if (!TextUtils.isEmpty(list.get(i2).hash_id) && !this.f.contains(list.get(i2).hash_id)) {
                this.f.add(list.get(i2).hash_id);
                this.g.add(list.get(i2));
            }
            i = i2 + 1;
        }
    }
}
