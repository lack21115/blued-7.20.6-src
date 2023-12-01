package com.blued.community.ui.send.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/AddPostImageAdapter.class */
public class AddPostImageAdapter extends BaseItemDraggableAdapter<ChildImageInfo, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19886a;
    public IRequestHost b;
    private int l;
    private boolean m;
    private boolean n;
    private ChildImageInfo o;
    private ChildImageInfo p;

    public AddPostImageAdapter(IRequestHost iRequestHost) {
        this(null, (AppInfo.l - FeedMethods.a(25.0f)) / 3);
    }

    public AddPostImageAdapter(IRequestHost iRequestHost, int i) {
        this(null, i, true);
    }

    public AddPostImageAdapter(IRequestHost iRequestHost, int i, boolean z) {
        super(R.layout.item_add_post_image, null);
        this.f19886a = true;
        this.n = false;
        this.o = new ChildImageInfo();
        ChildImageInfo childImageInfo = new ChildImageInfo();
        this.p = childImageInfo;
        this.b = iRequestHost;
        childImageInfo.itemType = 1;
        if (i > 0) {
            this.l = i;
        } else {
            this.l = (AppInfo.l - FeedMethods.a(25.0f)) / 3;
        }
        this.m = z;
    }

    public void a() {
        setNewData(new ArrayList());
        for (ChildImageInfo childImageInfo : SelectPhotoManager.a().c()) {
            addData((AddPostImageAdapter) childImageInfo);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, ChildImageInfo childImageInfo) {
        View view = baseViewHolder.getView(R.id.root_view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (childImageInfo.itemType == 1) {
            layoutParams.width = this.l * 2;
        } else {
            layoutParams.width = this.l;
        }
        layoutParams.height = this.l - FeedMethods.c(5);
        view.setLayoutParams(layoutParams);
        if (childImageInfo.itemType == 1) {
            baseViewHolder.setGone(R.id.add_post_audit_layout, true);
            baseViewHolder.setGone(R.id.add_post_img_layout, false);
            ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1687335848_57042.png").a(2.5f).a((ImageView) baseViewHolder.getView(R.id.add_post_audit_img_1));
            ImageLoader.a((IRequestHost) null, "https://web.bldimg.com/image-manager/1687335848_52864.png").a(2.5f).a((ImageView) baseViewHolder.getView(R.id.add_post_audit_img_2));
            baseViewHolder.addOnClickListener(R.id.add_post_audit_layout);
            return;
        }
        baseViewHolder.setGone(R.id.add_post_audit_layout, false);
        baseViewHolder.setGone(R.id.add_post_img_layout, true);
        a(baseViewHolder, childImageInfo, (ImageView) baseViewHolder.getView(R.id.img_image));
        baseViewHolder.setGone(R.id.iv_image_delete, this.f19886a);
        baseViewHolder.addOnClickListener(R.id.iv_image_delete);
        if (!TextUtils.isEmpty(childImageInfo.mImagePath)) {
            baseViewHolder.setGone(R.id.img_add, false);
            baseViewHolder.setGone(R.id.img_image, true);
            return;
        }
        baseViewHolder.setGone(R.id.img_add, true);
        baseViewHolder.setGone(R.id.img_image, false);
        baseViewHolder.addOnClickListener(R.id.img_add);
    }

    public void a(BaseViewHolder baseViewHolder, ChildImageInfo childImageInfo, ImageView imageView) {
        if (childImageInfo.height > childImageInfo.width * 3) {
            ImageLoader.d(this.b, childImageInfo.mImagePath).b(R.drawable.feed_photo_default).a(true, 0.0f).a(imageView);
            baseViewHolder.setGone(R.id.stv_long_pic_icon, true);
            return;
        }
        ImageLoader.d(this.b, childImageInfo.mImagePath).b(R.drawable.feed_photo_default).a(imageView);
        baseViewHolder.setGone(R.id.stv_long_pic_icon, false);
    }

    public void a(boolean z) {
        this.n = z;
        getData().remove(this.p);
        if (this.n && c() == 0) {
            getData().add(this.p);
        }
        notifyDataSetChanged();
    }

    public void b() {
        getData().remove(this.o);
        getData().remove(this.p);
        SelectPhotoManager.a().d();
        for (ChildImageInfo childImageInfo : getData()) {
            SelectPhotoManager.a().a(childImageInfo);
        }
        if (c() > 0) {
            this.n = false;
            LiveEventBus.get("never_show_audit_guide").post(true);
        }
        if (getItemCount() < 9 && this.m) {
            getData().add(this.o);
        }
        if (this.n) {
            getData().add(this.p);
            h();
        } else {
            g();
        }
        notifyDataSetChanged();
    }

    public int c() {
        int i = 0;
        for (ChildImageInfo childImageInfo : getData()) {
            if (childImageInfo != null && !TextUtils.isEmpty(childImageInfo.mImagePath)) {
                i++;
            }
        }
        return i;
    }

    public boolean d() {
        for (ChildImageInfo childImageInfo : getData()) {
            if (childImageInfo != null && !TextUtils.isEmpty(childImageInfo.mImagePath)) {
                return true;
            }
        }
        return false;
    }

    public int e() {
        int i = 0;
        for (ChildImageInfo childImageInfo : getData()) {
            if (childImageInfo == null || TextUtils.isEmpty(childImageInfo.mImagePath)) {
                i++;
            }
        }
        return i;
    }

    public int f() {
        if (this.mData != null) {
            return this.mData.size() >= 1 ? this.mData.size() - e() : this.mData.size();
        }
        return 0;
    }
}
