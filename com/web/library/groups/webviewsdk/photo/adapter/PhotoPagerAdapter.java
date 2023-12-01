package com.web.library.groups.webviewsdk.photo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.PagerAdapter;
import com.web.library.groups.webviewsdk.photoview.PhotoView;
import com.web.library.groups.webviewsdk.photoview.PhotoViewAttacher;
import com.weimob.library.groups.imageloader.assist.ImageLoaderInfo;
import com.weimob.library.groups.imageloader.core.ImageLoader;
import com.weimob.library.groups.imageloader.listener.ImageLoadingListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photo/adapter/PhotoPagerAdapter.class */
public class PhotoPagerAdapter extends PagerAdapter {
    private ViewGroup container;
    private Context context;
    private String currImgUrl;
    private List<String> dataList = new ArrayList();
    private Map<Integer, View> viewMap = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photo/adapter/PhotoPagerAdapter$a.class */
    public interface a {
        void a();
    }

    public PhotoPagerAdapter(Context context) {
        this.context = context;
    }

    private void saveImageToAlbum() {
    }

    private void show(Context context, String str, String[] strArr, boolean z, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog);
        builder.setCancelable(z);
        builder.setTitle(str);
        builder.setItems(strArr, onClickListener);
        builder.show().setCanceledOnTouchOutside(z);
    }

    public void clear() {
        this.dataList.clear();
        this.viewMap.clear();
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.viewMap.get(Integer.valueOf(i)));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.dataList.size();
    }

    public List<String> getDataList() {
        return this.dataList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.viewMap.get(Integer.valueOf(i));
        PhotoView photoView = view;
        if (view == null) {
            photoView = new PhotoView(this.context);
            final PhotoView photoView2 = photoView;
            ImageLoader.getInstance().loadImage(this.dataList.get(i), null, new ImageLoadingListener() { // from class: com.web.library.groups.webviewsdk.photo.adapter.PhotoPagerAdapter.1
                @Override // com.weimob.library.groups.imageloader.listener.ImageLoadingListener
                public void onLoadingComplete(String str, View view2, Drawable drawable) {
                    photoView2.setImageDrawable(drawable);
                }

                @Override // com.weimob.library.groups.imageloader.listener.ImageLoadingListener
                public void onLoadingComplete(String str, View view2, ImageLoaderInfo imageLoaderInfo) {
                }

                @Override // com.weimob.library.groups.imageloader.listener.ImageLoadingListener
                public void onLoadingFailed(String str, View view2) {
                }

                @Override // com.weimob.library.groups.imageloader.listener.ImageLoadingListener
                public void onLoadingProgressUpdate(String str, View view2, float f, float f2) {
                }

                @Override // com.weimob.library.groups.imageloader.listener.ImageLoadingListener
                public void onLoadingStarted(String str, View view2) {
                    photoView2.setImageDrawable(null);
                }
            });
            this.viewMap.put(Integer.valueOf(i), photoView2);
            photoView2.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() { // from class: com.web.library.groups.webviewsdk.photo.adapter.PhotoPagerAdapter.2
                @Override // com.web.library.groups.webviewsdk.photoview.PhotoViewAttacher.OnViewTapListener
                public void onViewTap(View view2, float f, float f2) {
                    if (PhotoPagerAdapter.this.context == null || !(PhotoPagerAdapter.this.context instanceof a)) {
                        return;
                    }
                    ((a) PhotoPagerAdapter.this.context).a();
                }
            });
        }
        viewGroup.addView(photoView);
        return photoView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        super.startUpdate(viewGroup);
        this.container = viewGroup;
    }
}
