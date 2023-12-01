package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.collection.ArrayMap;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/BaseListAdapter.class */
public abstract class BaseListAdapter<E> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<E> f31961a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f31962c;
    public Map<Integer, onInternalClickListener> d;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/BaseListAdapter$onInternalClickListener.class */
    public interface onInternalClickListener {
        void a(View view, View view2, Integer num, Object obj);
    }

    public BaseListAdapter(Context context, List<E> list) {
        this.b = context;
        this.f31961a = list;
        this.f31962c = LayoutInflater.from(context);
    }

    private void a(final View view, final Integer num, final Object obj) {
        Map<Integer, onInternalClickListener> map = this.d;
        if (map == null || view == null) {
            return;
        }
        for (Integer num2 : map.keySet()) {
            View findViewById = view.findViewById(num2.intValue());
            final onInternalClickListener oninternalclicklistener = this.d.get(num2);
            if (findViewById != null && oninternalclicklistener != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.BaseListAdapter.1
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
        return this.f31961a;
    }

    public void a(Integer num, onInternalClickListener oninternalclicklistener) {
        if (this.d == null) {
            this.d = new ArrayMap();
        }
        this.d.put(num, oninternalclicklistener);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f31961a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f31961a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View a2 = a(i, view, viewGroup);
        a(a2, Integer.valueOf(i), this.f31961a.get(i));
        return a2;
    }
}
