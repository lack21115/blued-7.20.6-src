package com.opos.mobad.o.d;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a.class */
public class a implements com.opos.mobad.o.d.d {

    /* renamed from: a  reason: collision with root package name */
    ListView f27089a;
    c b;

    /* renamed from: com.opos.mobad.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$a.class */
    public static class C0722a {

        /* renamed from: a  reason: collision with root package name */
        public final String f27090a;
        public final String b;

        public C0722a(String str, String str2) {
            this.f27090a = str;
            this.b = str2;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$b.class */
    public static class b extends RelativeLayout {

        /* renamed from: a  reason: collision with root package name */
        private TextView f27091a;
        private TextView b;

        public b(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            int a2 = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            int a3 = com.opos.cmn.an.h.f.a.a(context, 24.0f);
            setPadding(a3, a2, a3, a2);
            TextView textView = new TextView(getContext());
            this.f27091a = textView;
            textView.setId(View.generateViewId());
            this.f27091a.setTextColor(Color.parseColor("#D9000000"));
            this.f27091a.setTextSize(1, 16.0f);
            this.f27091a.setGravity(17);
            this.f27091a.setGravity(51);
            this.f27091a.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            addView(this.f27091a, layoutParams);
            TextView textView2 = new TextView(getContext());
            this.b = textView2;
            textView2.setTextColor(Color.parseColor("#C4000000"));
            this.b.setTextSize(1, 12.0f);
            this.b.setGravity(17);
            this.b.setGravity(51);
            this.b.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f27091a.getId());
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 3.0f);
            addView(this.b, layoutParams2);
        }

        public void a(C0722a c0722a) {
            TextView textView;
            int i;
            if (c0722a == null) {
                return;
            }
            this.f27091a.setText(TextUtils.isEmpty(c0722a.f27090a) ? "" : c0722a.f27090a);
            if (TextUtils.isEmpty(c0722a.b)) {
                textView = this.b;
                i = 8;
            } else {
                this.b.setText(c0722a.b);
                textView = this.b;
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$c.class */
    static class c extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private List<C0722a> f27092a = new ArrayList();

        public void a(List<C0722a> list) {
            this.f27092a.clear();
            this.f27092a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f27092a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f27092a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0722a c0722a = (C0722a) getItem(i);
            d a2 = d.a(view, viewGroup);
            a2.f27093a.a(c0722a);
            return a2.f27093a;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$d.class */
    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final b f27093a;

        private d(b bVar) {
            this.f27093a = bVar;
        }

        public static final d a(View view, View view2) {
            if (view == null) {
                b bVar = new b(view2.getContext());
                d dVar = new d(bVar);
                bVar.setTag(dVar);
                return dVar;
            }
            return (d) view.getTag();
        }
    }

    public a(Context context) {
        ListView listView = new ListView(context);
        this.f27089a = listView;
        listView.setDividerHeight(0);
        c cVar = new c();
        this.b = cVar;
        this.f27089a.setAdapter((ListAdapter) cVar);
    }

    public static List<C0722a> b(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ComplianceListView", "transformMapToList = " + map);
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            if (map.size() <= 0) {
                return arrayList;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new C0722a(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.o.d.d
    public int a() {
        return 1;
    }

    @Override // com.opos.mobad.o.d.d
    public void a(String str) {
    }

    @Override // com.opos.mobad.o.d.d
    public void a(Map<String, String> map) {
        this.b.a(b(map));
    }

    @Override // com.opos.mobad.o.d.d
    public View b() {
        return this.f27089a;
    }

    @Override // com.opos.mobad.o.d.d
    public void c() {
    }
}
