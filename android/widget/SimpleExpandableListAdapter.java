package android.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:android/widget/SimpleExpandableListAdapter.class */
public class SimpleExpandableListAdapter extends BaseExpandableListAdapter {
    private List<? extends List<? extends Map<String, ?>>> mChildData;
    private String[] mChildFrom;
    private int mChildLayout;
    private int[] mChildTo;
    private int mCollapsedGroupLayout;
    private int mExpandedGroupLayout;
    private List<? extends Map<String, ?>> mGroupData;
    private String[] mGroupFrom;
    private int[] mGroupTo;
    private LayoutInflater mInflater;
    private int mLastChildLayout;

    public SimpleExpandableListAdapter(Context context, List<? extends Map<String, ?>> list, int i, int i2, String[] strArr, int[] iArr, List<? extends List<? extends Map<String, ?>>> list2, int i3, int i4, String[] strArr2, int[] iArr2) {
        this.mGroupData = list;
        this.mExpandedGroupLayout = i;
        this.mCollapsedGroupLayout = i2;
        this.mGroupFrom = strArr;
        this.mGroupTo = iArr;
        this.mChildData = list2;
        this.mChildLayout = i3;
        this.mLastChildLayout = i4;
        this.mChildFrom = strArr2;
        this.mChildTo = iArr2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public SimpleExpandableListAdapter(Context context, List<? extends Map<String, ?>> list, int i, int i2, String[] strArr, int[] iArr, List<? extends List<? extends Map<String, ?>>> list2, int i3, String[] strArr2, int[] iArr2) {
        this(context, list, i, i2, strArr, iArr, list2, i3, i3, strArr2, iArr2);
    }

    public SimpleExpandableListAdapter(Context context, List<? extends Map<String, ?>> list, int i, String[] strArr, int[] iArr, List<? extends List<? extends Map<String, ?>>> list2, int i2, String[] strArr2, int[] iArr2) {
        this(context, list, i, i, strArr, iArr, list2, i2, i2, strArr2, iArr2);
    }

    private void bindView(View view, Map<String, ?> map, String[] strArr, int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            TextView textView = (TextView) view.findViewById(iArr[i2]);
            if (textView != null) {
                textView.setText((String) map.get(strArr[i2]));
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.mChildData.get(i).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newChildView(z, viewGroup);
        }
        bindView(view, this.mChildData.get(i).get(i2), this.mChildFrom, this.mChildTo);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.mChildData.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.mGroupData.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.mGroupData.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newGroupView(z, viewGroup);
        }
        bindView(view, this.mGroupData.get(i), this.mGroupFrom, this.mGroupTo);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public View newChildView(boolean z, ViewGroup viewGroup) {
        return this.mInflater.inflate(z ? this.mLastChildLayout : this.mChildLayout, viewGroup, false);
    }

    public View newGroupView(boolean z, ViewGroup viewGroup) {
        return this.mInflater.inflate(z ? this.mExpandedGroupLayout : this.mCollapsedGroupLayout, viewGroup, false);
    }
}
