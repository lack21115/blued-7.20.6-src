package com.ss.android.socialbase.downloader.network.connectionpool;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/connectionpool/DownloadConnectionPool.class */
public class DownloadConnectionPool {
    public static final int MAX_HOLD_CONNECTION = 3;
    private static final String TAG = "DownloadConnectionPool";
    private final Map<String, FakeDownloadHttpConnection> mCachedDownloadConnections;
    private final Map<String, FakeDownloadHeadHttpConnection> mCachedHeadConnections;
    protected int maxCacheSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/connectionpool/DownloadConnectionPool$InstanceHolder.class */
    public static final class InstanceHolder {
        private static final DownloadConnectionPool INSTANCE = new DownloadConnectionPool();

        private InstanceHolder() {
        }
    }

    private DownloadConnectionPool() {
        this.mCachedHeadConnections = new HashMap();
        this.mCachedDownloadConnections = new LinkedHashMap(3);
        this.maxCacheSize = 3;
    }

    public static DownloadConnectionPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public FakeDownloadHttpConnection getCachedDownloadConnection(String str, List<HttpHeader> list) {
        FakeDownloadHttpConnection remove;
        synchronized (this.mCachedDownloadConnections) {
            remove = this.mCachedDownloadConnections.remove(str);
        }
        if (remove != null) {
            if (DownloadUtils.isHeaderEqual(remove.getRequestHeaders(), list)) {
                try {
                    remove.joinExecute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.isValid() && remove.isSuccessful()) {
                    return remove;
                }
            }
            try {
                remove.end();
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public FakeDownloadHeadHttpConnection getCachedHeadConnection(String str, List<HttpHeader> list) {
        FakeDownloadHeadHttpConnection remove;
        synchronized (this.mCachedHeadConnections) {
            remove = this.mCachedHeadConnections.remove(str);
        }
        if (remove != null) {
            if (DownloadUtils.isHeaderEqual(remove.getRequestHeaders(), list)) {
                try {
                    remove.joinExecute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.isValid() && remove.isSuccessful()) {
                    return remove;
                }
            }
            try {
                remove.cancel();
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public boolean isDownloadConnectionExist(String str) {
        FakeDownloadHttpConnection fakeDownloadHttpConnection = this.mCachedDownloadConnections.get(str);
        boolean z = false;
        if (fakeDownloadHttpConnection != null) {
            if (fakeDownloadHttpConnection.isRequesting()) {
                return true;
            }
            z = false;
            if (fakeDownloadHttpConnection.isValid()) {
                z = false;
                if (fakeDownloadHttpConnection.isSuccessful()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isHeadConnectionExist(String str) {
        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = this.mCachedHeadConnections.get(str);
        boolean z = false;
        if (fakeDownloadHeadHttpConnection != null) {
            if (fakeDownloadHeadHttpConnection.isRequesting()) {
                return true;
            }
            z = false;
            if (fakeDownloadHeadHttpConnection.isValid()) {
                z = false;
                if (fakeDownloadHeadHttpConnection.isSuccessful()) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a9 -> B:16:0x006c). Please submit an issue!!! */
    public void putCachedDownloadConnections(String str, FakeDownloadHttpConnection fakeDownloadHttpConnection) {
        FakeDownloadHttpConnection fakeDownloadHttpConnection2;
        Map.Entry<String, FakeDownloadHttpConnection> next;
        synchronized (this.mCachedDownloadConnections) {
            if (this.mCachedDownloadConnections.size() == this.maxCacheSize) {
                Iterator<Map.Entry<String, FakeDownloadHttpConnection>> it = this.mCachedDownloadConnections.entrySet().iterator();
                if (it.hasNext() && (next = it.next()) != null) {
                    fakeDownloadHttpConnection2 = this.mCachedDownloadConnections.remove(next.getKey());
                    this.mCachedDownloadConnections.put(str, fakeDownloadHttpConnection);
                }
            }
            fakeDownloadHttpConnection2 = null;
            this.mCachedDownloadConnections.put(str, fakeDownloadHttpConnection);
        }
        if (fakeDownloadHttpConnection2 != null) {
            try {
                fakeDownloadHttpConnection2.end();
            } catch (Throwable th) {
            }
        }
        Logger.i(TAG, "mCachedConnections size = " + this.mCachedDownloadConnections.size() + ", max size = " + this.maxCacheSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putCachedHeadConnections(String str, FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection) {
        synchronized (this.mCachedHeadConnections) {
            this.mCachedHeadConnections.put(str, fakeDownloadHeadHttpConnection);
        }
    }

    public void releaseDownloadConnection(String str) {
        FakeDownloadHttpConnection remove;
        synchronized (this.mCachedDownloadConnections) {
            remove = this.mCachedDownloadConnections.remove(str);
        }
        if (remove != null) {
            try {
                remove.end();
            } catch (Throwable th) {
            }
        }
    }

    public void releaseHeadConnection(String str) {
        FakeDownloadHeadHttpConnection remove;
        synchronized (this.mCachedHeadConnections) {
            remove = this.mCachedHeadConnections.remove(str);
        }
        if (remove != null) {
            remove.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCachedDownloadConnectionSize(int i) {
        this.maxCacheSize = i;
    }
}
