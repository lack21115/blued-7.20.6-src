package com.blued.android.module.live_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/PhotoFolderAdapter.class */
public class PhotoFolderAdapter extends BaseAdapter {
    private List<String> a;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/PhotoFolderAdapter$PhotoHolder.class */
    static class PhotoHolder {
        public TextView a;

        private PhotoHolder() {
        }
    }

    public PhotoFolderAdapter(List<String> list) {
        this.a = list;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PhotoHolder photoHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_folder_layout, viewGroup, false);
            photoHolder = new PhotoHolder();
            view.setTag(photoHolder);
            photoHolder.a = (TextView) view.findViewById(R.id.tv_folder_name);
        } else {
            photoHolder = (PhotoHolder) view.getTag();
        }
        photoHolder.a.setText(this.a.get(i));
        return view;
    }
}
