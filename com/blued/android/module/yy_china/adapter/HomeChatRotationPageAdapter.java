package com.blued.android.module.yy_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/HomeChatRotationPageAdapter.class */
public class HomeChatRotationPageAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f16132a;
    private IRequestHost b;

    public HomeChatRotationPageAdapter(List<String> list, IRequestHost iRequestHost) {
        ArrayList arrayList = new ArrayList();
        this.f16132a = arrayList;
        arrayList.addAll(list);
        this.b = iRequestHost;
    }

    private int a() {
        List<String> list = this.f16132a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(ImageView imageView, int i) {
        ImageLoader.a(this.b, this.f16132a.get(i)).c().a(imageView);
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
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_chat_rotation_item, viewGroup, false);
        a((ShapeableImageView) inflate.findViewById(R.id.iv), i % a2);
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
