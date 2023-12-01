package androidx.recyclerview.widget;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/BatchingListUpdateCallback.class */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a  reason: collision with root package name */
    final ListUpdateCallback f3182a;
    int b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f3183c = -1;
    int d = -1;
    Object e = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f3182a = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.b;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.f3182a.onInserted(this.f3183c, this.d);
        } else if (i == 2) {
            this.f3182a.onRemoved(this.f3183c, this.d);
        } else if (i == 3) {
            this.f3182a.onChanged(this.f3183c, this.d, this.e);
        }
        this.e = null;
        this.b = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        int i3;
        if (this.b == 3) {
            int i4 = this.f3183c;
            int i5 = this.d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.e == obj) {
                this.f3183c = Math.min(i, i4);
                this.d = Math.max(i5 + i4, i3) - this.f3183c;
                return;
            }
        }
        dispatchLastEvent();
        this.f3183c = i;
        this.d = i2;
        this.e = obj;
        this.b = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        int i3;
        if (this.b == 1 && i >= (i3 = this.f3183c)) {
            int i4 = this.d;
            if (i <= i3 + i4) {
                this.d = i4 + i2;
                this.f3183c = Math.min(i, i3);
                return;
            }
        }
        dispatchLastEvent();
        this.f3183c = i;
        this.d = i2;
        this.b = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.f3182a.onMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        int i3;
        if (this.b == 2 && (i3 = this.f3183c) >= i && i3 <= i + i2) {
            this.d += i2;
            this.f3183c = i;
            return;
        }
        dispatchLastEvent();
        this.f3183c = i;
        this.d = i2;
        this.b = 2;
    }
}
