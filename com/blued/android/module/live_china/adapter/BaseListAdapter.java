package com.blued.android.module.live_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/BaseListAdapter.class */
public abstract class BaseListAdapter<E> extends BaseAdapter {
    public List<E> a;
    public LayoutInflater b;
    public Map<Integer, onInternalClickListener> c;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/BaseListAdapter$onInternalClickListener.class */
    public interface onInternalClickListener {
        void a(View view, View view2, Integer num, Object obj);
    }

    private void a(final View view, final Integer num, final Object obj) {
        Map<Integer, onInternalClickListener> map = this.c;
        if (map == null || view == null) {
            return;
        }
        for (Integer num2 : map.keySet()) {
            View findViewById = view.findViewById(num2.intValue());
            final onInternalClickListener oninternalclicklistener = this.c.get(num2);
            if (findViewById != null && oninternalclicklistener != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.BaseListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        oninternalclicklistener.a(view, view2, num, obj);
                    }
                });
            }
        }
    }

    public abstract View a(int i, View view, ViewGroup viewGroup);

    public List<E> a() {
        return this.a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View a = a(i, view, viewGroup);
        a(a, Integer.valueOf(i), this.a.get(i));
        return a;
    }
}
