package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.FilterInfo;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MultiSelectFragment.class */
public class MultiSelectFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f30358a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private CommonTopTitleNoTrans f30359c;
    private ListView f;
    private String[] g;
    private String h;
    private int[] i;
    private RaceAdapter j;
    private String k;
    private int m;
    private List<FilterInfo> d = new ArrayList();
    private List<FilterInfo> e = new ArrayList();
    private String l = "";

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MultiSelectFragment$RaceAdapter.class */
    public class RaceAdapter extends BaseAdapter {
        private Context b;

        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MultiSelectFragment$RaceAdapter$ViewHolder.class */
        final class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            TextView f30365a;
            View b;

            /* renamed from: c  reason: collision with root package name */
            RelativeLayout f30366c;

            private ViewHolder() {
            }
        }

        public RaceAdapter(Context context) {
            this.b = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MultiSelectFragment.this.d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return MultiSelectFragment.this.d.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.b).inflate(R.layout.race_list_item, viewGroup, false);
                viewHolder = new ViewHolder();
                view.setTag(viewHolder);
                viewHolder.f30365a = (TextView) view.findViewById(R.id.textView);
                viewHolder.b = view.findViewById(R.id.switch_view);
                viewHolder.f30366c = (RelativeLayout) view.findViewById(R.id.rl_item);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final FilterInfo filterInfo = (FilterInfo) MultiSelectFragment.this.d.get(i);
            filterInfo.position = i;
            viewHolder.f30365a.setText(filterInfo.mName);
            if (filterInfo.mSelected) {
                viewHolder.b.setVisibility(0);
            } else {
                viewHolder.b.setVisibility(8);
            }
            final ViewHolder viewHolder2 = viewHolder;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MultiSelectFragment.RaceAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (filterInfo.mSelected) {
                        viewHolder2.b.setVisibility(8);
                        filterInfo.mSelected = false;
                    } else {
                        viewHolder2.b.setVisibility(0);
                        filterInfo.mSelected = true;
                        if (filterInfo.mName.equals(MultiSelectFragment.this.k)) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= MultiSelectFragment.this.d.size()) {
                                    break;
                                }
                                if (i3 != 0) {
                                    ((FilterInfo) MultiSelectFragment.this.d.get(i3)).mSelected = false;
                                }
                                i2 = i3 + 1;
                            }
                        } else if (((FilterInfo) MultiSelectFragment.this.d.get(0)).mSelected) {
                            ((FilterInfo) MultiSelectFragment.this.d.get(0)).mSelected = false;
                        }
                    }
                    RaceAdapter.this.notifyDataSetChanged();
                }
            });
            return view;
        }
    }

    private void a() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.g;
        if (strArr == null || strArr.length == 0) {
            this.g = this.f30358a.getResources().getStringArray(R.array.race_array_key);
        }
        if (StringUtils.d(this.h)) {
            this.h = "-1";
        }
        this.k = this.f30358a.getResources().getString(R.string.unlimited);
        if (!"-1".equals(this.h) && !this.h.contains("-")) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] split = this.h.split(",");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    break;
                }
                int parseInt = Integer.parseInt(split[i2]);
                String[] strArr2 = this.g;
                if (parseInt < strArr2.length && parseInt >= 0) {
                    stringBuffer.append(strArr2[parseInt]);
                }
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.g.length) {
                    break;
                }
                FilterInfo filterInfo = new FilterInfo();
                filterInfo.mName = this.g[i4];
                if (stringBuffer.toString().contains(filterInfo.mName)) {
                    filterInfo.mSelected = true;
                }
                arrayList.add(filterInfo);
                i3 = i4 + 1;
            }
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.g.length) {
                    break;
                }
                FilterInfo filterInfo2 = new FilterInfo();
                filterInfo2.mName = this.g[i6];
                if (filterInfo2.mName.equals(this.k)) {
                    filterInfo2.mSelected = true;
                }
                arrayList.add(filterInfo2);
                i5 = i6 + 1;
            }
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= arrayList.size()) {
                this.j.notifyDataSetChanged();
                return;
            }
            if (StringUtils.d(((FilterInfo) arrayList.get(i8)).id)) {
                FilterInfo filterInfo3 = (FilterInfo) arrayList.get(i8);
                filterInfo3.id = i8 + "";
            }
            int[] iArr = this.i;
            if (iArr != null && iArr.length > 0) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    int[] iArr2 = this.i;
                    if (i10 >= iArr2.length) {
                        break;
                    }
                    if (i8 == iArr2[i10]) {
                        ((FilterInfo) arrayList.get(i8)).visible = 8;
                    }
                    i9 = i10 + 1;
                }
            }
            if (((FilterInfo) arrayList.get(i8)).visible != 8) {
                this.d.add((FilterInfo) arrayList.get(i8));
            }
            i7 = i8 + 1;
        }
    }

    public static void a(Fragment fragment, int i, String str, String[] strArr, String str2, int[] iArr) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putStringArray("list", strArr);
        bundle.putString("selectedPostion", str2);
        bundle.putIntArray("gonePostions", iArr);
        bundle.putInt("requestcode", i);
        TerminalActivity.a(fragment, MultiSelectFragment.class, bundle, i);
    }

    private void b() {
        this.j = new RaceAdapter(this.f30358a);
        ListView listView = (ListView) this.b.findViewById(R.id.race_list);
        this.f = listView;
        listView.setAdapter((ListAdapter) this.j);
    }

    private void c() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        this.f30359c = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setRightText(getString(R.string.apply));
        if (StringUtils.d(this.l)) {
            this.f30359c.setCenterText(getString(R.string.filter_race));
        } else {
            this.f30359c.setCenterText(this.l);
        }
        this.f30359c.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MultiSelectFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MultiSelectFragment.this.getActivity().finish();
            }
        });
        this.f30359c.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MultiSelectFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= MultiSelectFragment.this.d.size()) {
                        break;
                    }
                    FilterInfo filterInfo = (FilterInfo) MultiSelectFragment.this.d.get(i2);
                    if (filterInfo.mSelected) {
                        if (filterInfo.mName.equals(MultiSelectFragment.this.k)) {
                            stringBuffer.append(-1);
                            stringBuffer2.append(-1);
                            stringBuffer3.append(-1);
                            break;
                        }
                        stringBuffer.append(filterInfo.position + ",");
                        stringBuffer2.append(filterInfo.mName + ",");
                        stringBuffer3.append(filterInfo.id + ",");
                    }
                    i = i2 + 1;
                }
                if (stringBuffer.length() == 0) {
                    stringBuffer.append(-1);
                    stringBuffer2.append(-1);
                    stringBuffer3.append(-1);
                }
                Intent intent = new Intent();
                intent.putExtra("SELETEDPOSITION", stringBuffer.toString());
                intent.putExtra("SELECTEDTEXT", stringBuffer2.toString());
                intent.putExtra("SELECTEDID", stringBuffer3.toString());
                MultiSelectFragment.this.getActivity().setResult(-1, intent);
                MultiSelectFragment.this.getActivity().finish();
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30358a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.filter_menu_race, viewGroup, false);
            if (getArguments() != null) {
                this.g = getArguments().getStringArray("list");
                this.l = getArguments().getString("title");
                this.m = getArguments().getInt("requestcode");
                this.h = getArguments().getString("selectedPostion");
                this.i = getArguments().getIntArray("gonePostions");
            }
            b();
            a();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
