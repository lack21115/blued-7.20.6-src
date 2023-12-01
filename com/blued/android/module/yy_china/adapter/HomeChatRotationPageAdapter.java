package com.blued.android.module.yy_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/HomeChatRotationPageAdapter.class */
public class HomeChatRotationPageAdapter extends PagerAdapter {
    private List<String> a;
    private IRequestHost b;

    public HomeChatRotationPageAdapter(List<String> list, IRequestHost iRequestHost) {
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
        ImageLoader.a(this.b, this.a.get(i)).c().a(imageView);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return a() * 500;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a = a();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_chat_rotation_item, viewGroup, false);
        a(inflate.findViewById(R.id.iv), i % a);
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
