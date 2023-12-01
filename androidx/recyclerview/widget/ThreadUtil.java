package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ThreadUtil.class */
interface ThreadUtil<T> {

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ThreadUtil$BackgroundCallback.class */
    public interface BackgroundCallback<T> {
        void loadTile(int i, int i2);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i);

        void updateRange(int i, int i2, int i3, int i4, int i5);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ThreadUtil$MainThreadCallback.class */
    public interface MainThreadCallback<T> {
        void addTile(int i, TileList.Tile<T> tile);

        void removeTile(int i, int i2);

        void updateItemCount(int i, int i2);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
