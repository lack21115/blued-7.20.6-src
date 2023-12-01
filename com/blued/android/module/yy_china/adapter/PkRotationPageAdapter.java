package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/PkRotationPageAdapter.class */
public class PkRotationPageAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f16141a;
    private IRequestHost b;

    public PkRotationPageAdapter(List<String> list, IRequestHost iRequestHost) {
        ArrayList arrayList = new ArrayList();
        this.f16141a = arrayList;
        arrayList.addAll(list);
        this.b = iRequestHost;
    }

    private int a() {
        List<String> list = this.f16141a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(ImageView imageView, int i) {
        ImageLoader.a(this.b, this.f16141a.get(i)).a(imageView.getResources().getDimensionPixelOffset(R.dimen.dp_2)).a(imageView);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return a() * 500;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a2 = a();
        ImageView imageView = new ImageView(viewGroup.getContext());
        a(imageView, i % a2);
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
