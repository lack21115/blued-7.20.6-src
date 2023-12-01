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
    private List<String> a;
    private IRequestHost b;

    public PkRotationPageAdapter(List<String> list, IRequestHost iRequestHost) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(list);
        this.b = iRequestHost;
    }

    private int a() {
        List<String> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(ImageView imageView, int i) {
        ImageLoader.a(this.b, this.a.get(i)).a(imageView.getResources().getDimensionPixelOffset(R.dimen.dp_2)).a(imageView);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return a() * 500;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a = a();
        ImageView imageView = new ImageView(viewGroup.getContext());
        a(imageView, i % a);
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        return imageView;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
