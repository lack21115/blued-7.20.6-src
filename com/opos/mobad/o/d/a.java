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
    ListView f13401a;
    c b;

    /* renamed from: com.opos.mobad.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$a.class */
    public static class C0552a {

        /* renamed from: a  reason: collision with root package name */
        public final String f13402a;
        public final String b;

        public C0552a(String str, String str2) {
            this.f13402a = str;
            this.b = str2;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$b.class */
    public static class b extends RelativeLayout {

        /* renamed from: a  reason: collision with root package name */
        private TextView f13403a;
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
            this.f13403a = textView;
            textView.setId(View.generateViewId());
            this.f13403a.setTextColor(Color.parseColor("#D9000000"));
            this.f13403a.setTextSize(1, 16.0f);
            this.f13403a.setGravity(17);
            this.f13403a.setGravity(51);
            this.f13403a.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            addView(this.f13403a, layoutParams);
            TextView textView2 = new TextView(getContext());
            this.b = textView2;
            textView2.setTextColor(Color.parseColor("#C4000000"));
            this.b.setTextSize(1, 12.0f);
            this.b.setGravity(17);
            this.b.setGravity(51);
            this.b.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f13403a.getId());
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 3.0f);
            addView(this.b, layoutParams2);
        }

        public void a(C0552a c0552a) {
            TextView textView;
            int i;
            if (c0552a == null) {
                return;
            }
            this.f13403a.setText(TextUtils.isEmpty(c0552a.f13402a) ? "" : c0552a.f13402a);
            if (TextUtils.isEmpty(c0552a.b)) {
                textView = this.b;
                i = 8;
            } else {
                this.b.setText(c0552a.b);
                textView = this.b;
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$c.class */
    static class c extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private List<C0552a> f13404a = new ArrayList();

        public void a(List<C0552a> list) {
            this.f13404a.clear();
            this.f13404a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f13404a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f13404a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0552a c0552a = (C0552a) getItem(i);
            d a2 = d.a(view, viewGroup);
            a2.f13405a.a(c0552a);
            return a2.f13405a;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/a$d.class */
    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final b f13405a;

        private d(b bVar) {
            this.f13405a = bVar;
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
        this.f13401a = listView;
        listView.setDividerHeight(0);
        c cVar = new c();
        this.b = cVar;
        this.f13401a.setAdapter((ListAdapter) cVar);
    }

    public static List<C0552a> b(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ComplianceListView", "transformMapToList = " + map);
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            if (map.size() <= 0) {
                return arrayList;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new C0552a(entry.getKey(), entry.getValue()));
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
        return this.f13401a;
    }

    @Override // com.opos.mobad.o.d.d
    public void c() {
    }
}
