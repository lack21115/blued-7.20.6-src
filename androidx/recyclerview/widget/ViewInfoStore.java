package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewInfoStore.class */
public class ViewInfoStore {

    /* renamed from: a  reason: collision with root package name */
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> f3316a = new SimpleArrayMap<>();
    final LongSparseArray<RecyclerView.ViewHolder> b = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewInfoStore$InfoRecord.class */
    public static class InfoRecord {
        static Pools.Pool<InfoRecord> d = new Pools.SimplePool(20);

        /* renamed from: a  reason: collision with root package name */
        int f3317a;
        RecyclerView.ItemAnimator.ItemHolderInfo b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f3318c;

        private InfoRecord() {
        }

        static InfoRecord a() {
            InfoRecord acquire = d.acquire();
            InfoRecord infoRecord = acquire;
            if (acquire == null) {
                infoRecord = new InfoRecord();
            }
            return infoRecord;
        }

        static void a(InfoRecord infoRecord) {
            infoRecord.f3317a = 0;
            infoRecord.b = null;
            infoRecord.f3318c = null;
            d.release(infoRecord);
        }

        static void b() {
            do {
            } while (d.acquire() != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewInfoStore$ProcessCallback.class */
    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder viewHolder, int i) {
        InfoRecord valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.f3316a.indexOfKey(viewHolder);
        if (indexOfKey < 0 || (valueAt = this.f3316a.valueAt(indexOfKey)) == null || (valueAt.f3317a & i) == 0) {
            return null;
        }
        valueAt.f3317a &= i;
        if (i == 4) {
            itemHolderInfo = valueAt.b;
        } else if (i != 8) {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        } else {
            itemHolderInfo = valueAt.f3318c;
        }
        if ((valueAt.f3317a & 12) == 0) {
            this.f3316a.removeAt(indexOfKey);
            InfoRecord.a(valueAt);
        }
        return itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder a(long j) {
        return this.b.get(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f3316a.clear();
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.ViewHolder viewHolder) {
        this.b.put(j, viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        InfoRecord infoRecord2 = infoRecord;
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.a();
            this.f3316a.put(viewHolder, infoRecord2);
        }
        infoRecord2.b = itemHolderInfo;
        infoRecord2.f3317a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ProcessCallback processCallback) {
        int size = this.f3316a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            RecyclerView.ViewHolder keyAt = this.f3316a.keyAt(i);
            InfoRecord removeAt = this.f3316a.removeAt(i);
            if ((removeAt.f3317a & 3) == 3) {
                processCallback.unused(keyAt);
            } else if ((removeAt.f3317a & 1) != 0) {
                if (removeAt.b == null) {
                    processCallback.unused(keyAt);
                } else {
                    processCallback.processDisappeared(keyAt, removeAt.b, removeAt.f3318c);
                }
            } else if ((removeAt.f3317a & 14) == 14) {
                processCallback.processAppeared(keyAt, removeAt.b, removeAt.f3318c);
            } else if ((removeAt.f3317a & 12) == 12) {
                processCallback.processPersistent(keyAt, removeAt.b, removeAt.f3318c);
            } else if ((removeAt.f3317a & 4) != 0) {
                processCallback.processDisappeared(keyAt, removeAt.b, null);
            } else if ((removeAt.f3317a & 8) != 0) {
                processCallback.processAppeared(keyAt, removeAt.b, removeAt.f3318c);
            } else {
                int i2 = removeAt.f3317a;
            }
            InfoRecord.a(removeAt);
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f3317a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        InfoRecord.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        InfoRecord infoRecord2 = infoRecord;
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.a();
            this.f3316a.put(viewHolder, infoRecord2);
        }
        infoRecord2.f3317a |= 2;
        infoRecord2.b = itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo c(RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        InfoRecord infoRecord2 = infoRecord;
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.a();
            this.f3316a.put(viewHolder, infoRecord2);
        }
        infoRecord2.f3318c = itemHolderInfo;
        infoRecord2.f3317a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f3317a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        InfoRecord infoRecord2 = infoRecord;
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.a();
            this.f3316a.put(viewHolder, infoRecord2);
        }
        infoRecord2.f3317a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3316a.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.f3317a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.ViewHolder viewHolder) {
        int size = this.b.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            } else if (viewHolder == this.b.valueAt(i)) {
                this.b.removeAt(i);
                break;
            } else {
                size = i;
            }
        }
        InfoRecord remove = this.f3316a.remove(viewHolder);
        if (remove != null) {
            InfoRecord.a(remove);
        }
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        f(viewHolder);
    }
}
