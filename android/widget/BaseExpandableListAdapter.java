package android.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* loaded from: source-4181928-dex2jar.jar:android/widget/BaseExpandableListAdapter.class */
public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
    private final DataSetObservable mDataSetObservable = new DataSetObservable();

    @Override // android.widget.ExpandableListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        return 0;
    }

    @Override // android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getCombinedChildId(long j, long j2) {
        return Long.MIN_VALUE | ((2147483647L & j) << 32) | ((-1) & j2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getCombinedGroupId(long j) {
        return (2147483647L & j) << 32;
    }

    @Override // android.widget.HeterogeneousExpandableList
    public int getGroupType(int i) {
        return 0;
    }

    @Override // android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isEmpty() {
        return getGroupCount() == 0;
    }

    public void notifyDataSetChanged() {
        this.mDataSetObservable.notifyChanged();
    }

    public void notifyDataSetInvalidated() {
        this.mDataSetObservable.notifyInvalidated();
    }

    @Override // android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
    }

    @Override // android.widget.ExpandableListAdapter
    public void onGroupExpanded(int i) {
    }

    @Override // android.widget.ExpandableListAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    @Override // android.widget.ExpandableListAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }
}
