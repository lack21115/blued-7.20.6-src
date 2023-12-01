package android.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListConnector.class */
class ExpandableListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter mExpandableListAdapter;
    private int mTotalExpChildrenCount;
    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();
    private ArrayList<GroupMetadata> mExpGroupMetadataList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListConnector$GroupMetadata.class */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: android.widget.ExpandableListConnector.GroupMetadata.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        private GroupMetadata() {
        }

        static GroupMetadata obtain(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.flPos = i;
            groupMetadata.lastChildFlPos = i2;
            groupMetadata.gPos = i3;
            groupMetadata.gId = j;
            return groupMetadata;
        }

        @Override // java.lang.Comparable
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.gPos - groupMetadata.gPos;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.flPos);
            parcel.writeInt(this.lastChildFlPos);
            parcel.writeInt(this.gPos);
            parcel.writeLong(this.gId);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListConnector$MyDataSetObserver.class */
    protected class MyDataSetObserver extends DataSetObserver {
        protected MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableListConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableListConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListConnector$PositionMetadata.class */
    public static class PositionMetadata {
        private static final int MAX_POOL_SIZE = 5;
        private static ArrayList<PositionMetadata> sPool = new ArrayList<>(5);
        public int groupInsertIndex;
        public GroupMetadata groupMetadata;
        public ExpandableListPosition position;

        private PositionMetadata() {
        }

        private static PositionMetadata getRecycledOrCreate() {
            synchronized (sPool) {
                if (sPool.size() <= 0) {
                    return new PositionMetadata();
                }
                PositionMetadata remove = sPool.remove(0);
                remove.resetState();
                return remove;
            }
        }

        static PositionMetadata obtain(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            PositionMetadata recycledOrCreate = getRecycledOrCreate();
            recycledOrCreate.position = ExpandableListPosition.obtain(i2, i3, i4, i);
            recycledOrCreate.groupMetadata = groupMetadata;
            recycledOrCreate.groupInsertIndex = i5;
            return recycledOrCreate;
        }

        private void resetState() {
            if (this.position != null) {
                this.position.recycle();
                this.position = null;
            }
            this.groupMetadata = null;
            this.groupInsertIndex = 0;
        }

        public boolean isExpanded() {
            return this.groupMetadata != null;
        }

        public void recycle() {
            resetState();
            synchronized (sPool) {
                if (sPool.size() < 5) {
                    sPool.add(this);
                }
            }
        }
    }

    public ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        setExpandableListAdapter(expandableListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshExpGroupMetadataList(boolean z, boolean z2) {
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        this.mTotalExpChildrenCount = 0;
        int i = size;
        if (z2) {
            boolean z3 = false;
            int i2 = size - 1;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int findGroupPosition = findGroupPosition(groupMetadata.gId, groupMetadata.gPos);
                int i3 = size;
                boolean z4 = z3;
                if (findGroupPosition != groupMetadata.gPos) {
                    int i4 = size;
                    if (findGroupPosition == -1) {
                        arrayList.remove(i2);
                        i4 = size - 1;
                    }
                    groupMetadata.gPos = findGroupPosition;
                    i3 = i4;
                    z4 = z3;
                    if (!z3) {
                        z4 = true;
                        i3 = i4;
                    }
                }
                i2--;
                size = i3;
                z3 = z4;
            }
            i = size;
            if (z3) {
                Collections.sort(arrayList);
                i = size;
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            GroupMetadata groupMetadata2 = arrayList.get(i7);
            int childrenCount = (groupMetadata2.lastChildFlPos == -1 || z) ? this.mExpandableListAdapter.getChildrenCount(groupMetadata2.gPos) : groupMetadata2.lastChildFlPos - groupMetadata2.flPos;
            this.mTotalExpChildrenCount += childrenCount;
            int i8 = i6 + (groupMetadata2.gPos - i5);
            i5 = groupMetadata2.gPos;
            groupMetadata2.flPos = i8;
            i6 = i8 + childrenCount;
            groupMetadata2.lastChildFlPos = i6;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mExpandableListAdapter.areAllItemsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean collapseGroup(int i) {
        ExpandableListPosition obtain = ExpandableListPosition.obtain(2, i, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos == null) {
            return false;
        }
        boolean collapseGroup = collapseGroup(flattenedPos);
        flattenedPos.recycle();
        return collapseGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean collapseGroup(PositionMetadata positionMetadata) {
        if (positionMetadata.groupMetadata == null) {
            return false;
        }
        this.mExpGroupMetadataList.remove(positionMetadata.groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        this.mExpandableListAdapter.onGroupCollapsed(positionMetadata.groupMetadata.gPos);
        return true;
    }

    boolean expandGroup(int i) {
        ExpandableListPosition obtain = ExpandableListPosition.obtain(2, i, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        boolean expandGroup = expandGroup(flattenedPos);
        flattenedPos.recycle();
        return expandGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean expandGroup(PositionMetadata positionMetadata) {
        if (positionMetadata.position.groupPos < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.mMaxExpGroupCount != 0 && positionMetadata.groupMetadata == null) {
            if (this.mExpGroupMetadataList.size() >= this.mMaxExpGroupCount) {
                GroupMetadata groupMetadata = this.mExpGroupMetadataList.get(0);
                int indexOf = this.mExpGroupMetadataList.indexOf(groupMetadata);
                collapseGroup(groupMetadata.gPos);
                if (positionMetadata.groupInsertIndex > indexOf) {
                    positionMetadata.groupInsertIndex--;
                }
            }
            GroupMetadata obtain = GroupMetadata.obtain(-1, -1, positionMetadata.position.groupPos, this.mExpandableListAdapter.getGroupId(positionMetadata.position.groupPos));
            this.mExpGroupMetadataList.add(positionMetadata.groupInsertIndex, obtain);
            refreshExpGroupMetadataList(false, false);
            notifyDataSetChanged();
            this.mExpandableListAdapter.onGroupExpanded(obtain.gPos);
            return true;
        }
        return false;
    }

    int findGroupPosition(long j, int i) {
        int groupCount = this.mExpandableListAdapter.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = min;
        int i3 = min;
        boolean z = false;
        ExpandableListAdapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        while (SystemClock.uptimeMillis() <= uptimeMillis + 100) {
            if (adapter.getGroupId(min) == j) {
                return min;
            }
            boolean z2 = i3 == groupCount - 1;
            boolean z3 = i2 == 0;
            if (z2 && z3) {
                return -1;
            }
            if (z3 || (z && !z2)) {
                i3++;
                min = i3;
                z = false;
            } else if (z2 || (!z && !z3)) {
                i2--;
                min = i2;
                z = true;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandableListAdapter getAdapter() {
        return this.mExpandableListAdapter;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mExpandableListAdapter.getGroupCount() + this.mTotalExpChildrenCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        return this.mExpGroupMetadataList;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter adapter = getAdapter();
        if (adapter instanceof Filterable) {
            return ((Filterable) adapter).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PositionMetadata getFlattenedPos(ExpandableListPosition expandableListPosition) {
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i = 0;
        int i2 = size - 1;
        if (size == 0) {
            return PositionMetadata.obtain(expandableListPosition.groupPos, expandableListPosition.type, expandableListPosition.groupPos, expandableListPosition.childPos, null, 0);
        }
        int i3 = 0;
        while (i <= i2) {
            int i4 = ((i2 - i) / 2) + i;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (expandableListPosition.groupPos > groupMetadata.gPos) {
                i = i4 + 1;
                i3 = i4;
            } else if (expandableListPosition.groupPos < groupMetadata.gPos) {
                i2 = i4 - 1;
                i3 = i4;
            } else {
                i3 = i4;
                if (expandableListPosition.groupPos == groupMetadata.gPos) {
                    if (expandableListPosition.type == 2) {
                        return PositionMetadata.obtain(groupMetadata.flPos, expandableListPosition.type, expandableListPosition.groupPos, expandableListPosition.childPos, groupMetadata, i4);
                    }
                    if (expandableListPosition.type == 1) {
                        return PositionMetadata.obtain(groupMetadata.flPos + expandableListPosition.childPos + 1, expandableListPosition.type, expandableListPosition.groupPos, expandableListPosition.childPos, groupMetadata, i4);
                    }
                    return null;
                }
            }
        }
        if (expandableListPosition.type != 2) {
            return null;
        }
        if (i > i3) {
            GroupMetadata groupMetadata2 = arrayList.get(i - 1);
            return PositionMetadata.obtain(groupMetadata2.lastChildFlPos + (expandableListPosition.groupPos - groupMetadata2.gPos), expandableListPosition.type, expandableListPosition.groupPos, expandableListPosition.childPos, null, i);
        } else if (i2 < i3) {
            int i5 = i2 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i5);
            return PositionMetadata.obtain(groupMetadata3.flPos - (groupMetadata3.gPos - expandableListPosition.groupPos), expandableListPosition.type, expandableListPosition.groupPos, expandableListPosition.childPos, null, i5);
        } else {
            return null;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        if (unflattenedPos.position.type == 2) {
            child = this.mExpandableListAdapter.getGroup(unflattenedPos.position.groupPos);
        } else if (unflattenedPos.position.type != 1) {
            throw new RuntimeException("Flat list position is of unknown type");
        } else {
            child = this.mExpandableListAdapter.getChild(unflattenedPos.position.groupPos, unflattenedPos.position.childPos);
        }
        unflattenedPos.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        long groupId = this.mExpandableListAdapter.getGroupId(unflattenedPos.position.groupPos);
        if (unflattenedPos.position.type == 2) {
            combinedChildId = this.mExpandableListAdapter.getCombinedGroupId(groupId);
        } else if (unflattenedPos.position.type != 1) {
            throw new RuntimeException("Flat list position is of unknown type");
        } else {
            combinedChildId = this.mExpandableListAdapter.getCombinedChildId(groupId, this.mExpandableListAdapter.getChildId(unflattenedPos.position.groupPos, unflattenedPos.position.childPos));
        }
        unflattenedPos.recycle();
        return combinedChildId;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        if (this.mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.mExpandableListAdapter;
            i2 = expandableListPosition.type == 2 ? heterogeneousExpandableList.getGroupType(expandableListPosition.groupPos) : heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(expandableListPosition.groupPos, expandableListPosition.childPos);
        } else {
            i2 = expandableListPosition.type == 2 ? 0 : 1;
        }
        unflattenedPos.recycle();
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PositionMetadata getUnflattenedPos(int i) {
        int i2;
        int i3;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i4 = 0;
        int i5 = size - 1;
        if (size == 0) {
            return PositionMetadata.obtain(i, 2, i, -1, null, 0);
        }
        int i6 = 0;
        while (i4 <= i5) {
            int i7 = ((i5 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i7);
            if (i > groupMetadata.lastChildFlPos) {
                i4 = i7 + 1;
                i6 = i7;
            } else if (i < groupMetadata.flPos) {
                i5 = i7 - 1;
                i6 = i7;
            } else if (i == groupMetadata.flPos) {
                return PositionMetadata.obtain(i, 2, groupMetadata.gPos, -1, groupMetadata, i7);
            } else {
                i6 = i7;
                if (i <= groupMetadata.lastChildFlPos) {
                    return PositionMetadata.obtain(i, 1, groupMetadata.gPos, i - (groupMetadata.flPos + 1), groupMetadata, i7);
                }
            }
        }
        if (i4 > i6) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            i2 = i4;
            i3 = (i - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
        } else if (i5 >= i6) {
            throw new RuntimeException("Unknown state");
        } else {
            i2 = i5 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.gPos - (groupMetadata3.flPos - i);
        }
        return PositionMetadata.obtain(i, 2, i3, -1, null, i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        boolean z = true;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        if (unflattenedPos.position.type == 2) {
            childView = this.mExpandableListAdapter.getGroupView(unflattenedPos.position.groupPos, unflattenedPos.isExpanded(), view, viewGroup);
        } else if (unflattenedPos.position.type != 1) {
            throw new RuntimeException("Flat list position is of unknown type");
        } else {
            if (unflattenedPos.groupMetadata.lastChildFlPos != i) {
                z = false;
            }
            childView = this.mExpandableListAdapter.getChildView(unflattenedPos.position.groupPos, unflattenedPos.position.childPos, z, view, viewGroup);
        }
        unflattenedPos.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.mExpandableListAdapter;
            return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mExpandableListAdapter.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isEmpty();
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        boolean isChildSelectable = expandableListPosition.type == 1 ? this.mExpandableListAdapter.isChildSelectable(expandableListPosition.groupPos, expandableListPosition.childPos) : true;
        unflattenedPos.recycle();
        return isChildSelectable;
    }

    public boolean isGroupExpanded(int i) {
        int size = this.mExpGroupMetadataList.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return false;
            }
            if (this.mExpGroupMetadataList.get(i2).gPos == i) {
                return true;
            }
            size = i2;
        }
    }

    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        if (this.mExpandableListAdapter != null) {
            this.mExpandableListAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mExpandableListAdapter = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExpandedGroupMetadataList(ArrayList<GroupMetadata> arrayList) {
        if (arrayList == null || this.mExpandableListAdapter == null) {
            return;
        }
        int groupCount = this.mExpandableListAdapter.getGroupCount();
        int size = arrayList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                this.mExpGroupMetadataList = arrayList;
                refreshExpGroupMetadataList(true, false);
                return;
            } else if (arrayList.get(i).gPos >= groupCount) {
                return;
            } else {
                size = i;
            }
        }
    }

    public void setMaxExpGroupCount(int i) {
        this.mMaxExpGroupCount = i;
    }
}
