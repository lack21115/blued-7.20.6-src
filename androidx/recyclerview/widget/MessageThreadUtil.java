package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/MessageThreadUtil.class */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/MessageThreadUtil$1.class */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        final /* synthetic */ ThreadUtil.MainThreadCallback b;

        /* renamed from: a  reason: collision with root package name */
        final MessageQueue f3253a = new MessageQueue();
        private final Handler d = new Handler(Looper.getMainLooper());
        private Runnable e = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.1.1
            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem a2 = AnonymousClass1.this.f3253a.a();
                while (true) {
                    SyncQueueItem syncQueueItem = a2;
                    if (syncQueueItem == null) {
                        return;
                    }
                    int i = syncQueueItem.what;
                    if (i == 1) {
                        AnonymousClass1.this.b.updateItemCount(syncQueueItem.arg1, syncQueueItem.arg2);
                    } else if (i == 2) {
                        AnonymousClass1.this.b.addTile(syncQueueItem.arg1, (TileList.Tile) syncQueueItem.data);
                    } else if (i != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + syncQueueItem.what);
                    } else {
                        AnonymousClass1.this.b.removeTile(syncQueueItem.arg1, syncQueueItem.arg2);
                    }
                    a2 = AnonymousClass1.this.f3253a.a();
                }
            }
        };

        AnonymousClass1(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.b = mainThreadCallback;
        }

        private void a(SyncQueueItem syncQueueItem) {
            this.f3253a.b(syncQueueItem);
            this.d.post(this.e);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            a(SyncQueueItem.a(2, i, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            a(SyncQueueItem.a(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            a(SyncQueueItem.a(1, i, i2));
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/MessageThreadUtil$2.class */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ThreadUtil.BackgroundCallback f3257c;

        /* renamed from: a  reason: collision with root package name */
        final MessageQueue f3256a = new MessageQueue();
        private final Executor e = AsyncTask.THREAD_POOL_EXECUTOR;
        AtomicBoolean b = new AtomicBoolean(false);
        private Runnable f = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.2.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a2 = AnonymousClass2.this.f3256a.a();
                    if (a2 == null) {
                        AnonymousClass2.this.b.set(false);
                        return;
                    }
                    int i = a2.what;
                    if (i == 1) {
                        AnonymousClass2.this.f3256a.a(1);
                        AnonymousClass2.this.f3257c.refresh(a2.arg1);
                    } else if (i == 2) {
                        AnonymousClass2.this.f3256a.a(2);
                        AnonymousClass2.this.f3256a.a(3);
                        AnonymousClass2.this.f3257c.updateRange(a2.arg1, a2.arg2, a2.arg3, a2.arg4, a2.arg5);
                    } else if (i == 3) {
                        AnonymousClass2.this.f3257c.loadTile(a2.arg1, a2.arg2);
                    } else if (i != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass2.this.f3257c.recycleTile((TileList.Tile) a2.data);
                    }
                }
            }
        };

        AnonymousClass2(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.f3257c = backgroundCallback;
        }

        private void a() {
            if (this.b.compareAndSet(false, true)) {
                this.e.execute(this.f);
            }
        }

        private void a(SyncQueueItem syncQueueItem) {
            this.f3256a.b(syncQueueItem);
            a();
        }

        private void b(SyncQueueItem syncQueueItem) {
            this.f3256a.a(syncQueueItem);
            a();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            a(SyncQueueItem.a(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            a(SyncQueueItem.a(4, 0, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            b(SyncQueueItem.a(1, i, (Object) null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            b(SyncQueueItem.a(2, i, i2, i3, i4, i5, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/MessageThreadUtil$MessageQueue.class */
    public static class MessageQueue {

        /* renamed from: a  reason: collision with root package name */
        private SyncQueueItem f3259a;

        MessageQueue() {
        }

        SyncQueueItem a() {
            synchronized (this) {
                if (this.f3259a == null) {
                    return null;
                }
                SyncQueueItem syncQueueItem = this.f3259a;
                this.f3259a = this.f3259a.f3261a;
                return syncQueueItem;
            }
        }

        void a(int i) {
            synchronized (this) {
                while (this.f3259a != null && this.f3259a.what == i) {
                    SyncQueueItem syncQueueItem = this.f3259a;
                    this.f3259a = this.f3259a.f3261a;
                    syncQueueItem.a();
                }
                if (this.f3259a != null) {
                    SyncQueueItem syncQueueItem2 = this.f3259a;
                    SyncQueueItem syncQueueItem3 = syncQueueItem2.f3261a;
                    while (true) {
                        SyncQueueItem syncQueueItem4 = syncQueueItem3;
                        if (syncQueueItem4 == null) {
                            break;
                        }
                        SyncQueueItem syncQueueItem5 = syncQueueItem4.f3261a;
                        if (syncQueueItem4.what == i) {
                            syncQueueItem2.f3261a = syncQueueItem5;
                            syncQueueItem4.a();
                        } else {
                            syncQueueItem2 = syncQueueItem4;
                        }
                        syncQueueItem3 = syncQueueItem5;
                    }
                }
            }
        }

        void a(SyncQueueItem syncQueueItem) {
            synchronized (this) {
                syncQueueItem.f3261a = this.f3259a;
                this.f3259a = syncQueueItem;
            }
        }

        void b(SyncQueueItem syncQueueItem) {
            synchronized (this) {
                if (this.f3259a == null) {
                    this.f3259a = syncQueueItem;
                    return;
                }
                SyncQueueItem syncQueueItem2 = this.f3259a;
                while (syncQueueItem2.f3261a != null) {
                    syncQueueItem2 = syncQueueItem2.f3261a;
                }
                syncQueueItem2.f3261a = syncQueueItem;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem.class */
    public static class SyncQueueItem {
        private static SyncQueueItem b;

        /* renamed from: c  reason: collision with root package name */
        private static final Object f3260c = new Object();

        /* renamed from: a  reason: collision with root package name */
        SyncQueueItem f3261a;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        public int what;

        SyncQueueItem() {
        }

        static SyncQueueItem a(int i, int i2, int i3) {
            return a(i, i2, i3, 0, 0, 0, null);
        }

        static SyncQueueItem a(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (f3260c) {
                if (b == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = b;
                    b = b.f3261a;
                    syncQueueItem.f3261a = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        static SyncQueueItem a(int i, int i2, Object obj) {
            return a(i, i2, 0, 0, 0, 0, obj);
        }

        void a() {
            this.f3261a = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (f3260c) {
                if (b != null) {
                    this.f3261a = b;
                }
                b = this;
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new AnonymousClass2(backgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(mainThreadCallback);
    }
}
