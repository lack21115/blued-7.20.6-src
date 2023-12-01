package com.ss.android.socialbase.downloader.network.connectionpool;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/connectionpool/FakeDownloadHeadHttpConnection.class */
public class FakeDownloadHeadHttpConnection implements IDownloadHeadHttpConnection, IFakeDownloadHttpConnection {
    private static final String TAG = "FakeDownloadHeadHttpCon";
    private static final ArrayList<String> usedHeaders;
    private boolean isRequesting;
    private boolean isSuccessful;
    private long mCreateTime;
    protected List<HttpHeader> mRequestHeaders;
    private int mResponseCode;
    protected final long mStartOffset;
    protected final String mUrl;
    private IDownloadHeadHttpConnection realConnection;
    private Map<String, String> mResponseHeaders = null;
    protected final Object mJoinLock = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        usedHeaders = arrayList;
        arrayList.add("Content-Length");
        usedHeaders.add("Content-Range");
        usedHeaders.add("Transfer-Encoding");
        usedHeaders.add("Accept-Ranges");
        usedHeaders.add(DownloadUtils.ETAG);
        usedHeaders.add("Content-Disposition");
    }

    public FakeDownloadHeadHttpConnection(String str, List<HttpHeader> list, long j) {
        this.mUrl = str;
        this.mRequestHeaders = list;
        this.mStartOffset = j;
    }

    private void parseHeaders(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, Map<String, String> map) {
        if (iDownloadHeadHttpConnection == null || map == null) {
            return;
        }
        Iterator<String> it = usedHeaders.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, iDownloadHeadHttpConnection.getResponseHeaderField(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public void cancel() {
        IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.realConnection;
        if (iDownloadHeadHttpConnection != null) {
            iDownloadHeadHttpConnection.cancel();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public void execute() throws Exception {
        if (this.mResponseHeaders != null) {
            return;
        }
        try {
            this.isRequesting = true;
            this.realConnection = DownloadComponentManager.downloadWithHeadConnection(this.mUrl, this.mRequestHeaders);
            synchronized (this.mJoinLock) {
                if (this.realConnection != null) {
                    HashMap hashMap = new HashMap();
                    this.mResponseHeaders = hashMap;
                    parseHeaders(this.realConnection, hashMap);
                    this.mResponseCode = this.realConnection.getResponseCode();
                    this.mCreateTime = System.currentTimeMillis();
                    this.isSuccessful = isSuccessful(this.mResponseCode);
                }
                this.isRequesting = false;
                this.mJoinLock.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.mJoinLock) {
                if (this.realConnection != null) {
                    HashMap hashMap2 = new HashMap();
                    this.mResponseHeaders = hashMap2;
                    parseHeaders(this.realConnection, hashMap2);
                    this.mResponseCode = this.realConnection.getResponseCode();
                    this.mCreateTime = System.currentTimeMillis();
                    this.isSuccessful = isSuccessful(this.mResponseCode);
                }
                this.isRequesting = false;
                this.mJoinLock.notifyAll();
                throw th;
            }
        }
    }

    public List<HttpHeader> getRequestHeaders() {
        return this.mRequestHeaders;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public int getResponseCode() throws IOException {
        return this.mResponseCode;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
    public String getResponseHeaderField(String str) {
        Map<String, String> map = this.mResponseHeaders;
        if (map != null) {
            return map.get(str);
        }
        IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.realConnection;
        if (iDownloadHeadHttpConnection != null) {
            return iDownloadHeadHttpConnection.getResponseHeaderField(str);
        }
        return null;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isRequesting() {
        return this.isRequesting;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public boolean isSuccessful(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public boolean isValid() {
        return System.currentTimeMillis() - this.mCreateTime < DownloadPreconnecter.sHeadInfoOutdatedTime;
    }

    @Override // com.ss.android.socialbase.downloader.network.connectionpool.IFakeDownloadHttpConnection
    public void joinExecute() throws InterruptedException {
        synchronized (this.mJoinLock) {
            if (this.isRequesting && this.mResponseHeaders == null) {
                this.mJoinLock.wait();
            }
        }
    }
}
