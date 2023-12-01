package com.tencent.tencentmap.net;

import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/net/NetManager.class */
public class NetManager {
    private static NetManager sInstance;

    private NetManager() {
    }

    public static NetManager getInstance() {
        NetManager netManager;
        synchronized (NetManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new NetManager();
                }
                netManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return netManager;
    }

    public NetResponse doGet(String str) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, int i, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).retryNum(i).canceler(httpCanceler).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, String str2) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, String str2, int i) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, String str2, int i, int i2, HashMap<String, String> hashMap) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).timeOut(i2).header(hashMap).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, String str2, int i, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i2).retryNum(i).header(hashMap).canceler(httpCanceler).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, String str2, int i, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).canceler(httpCanceler).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doGet(String str, String str2, int i, HashMap<String, String> hashMap, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).header(hashMap).canceler(httpCanceler).doGet();
        if (doGet != null) {
            return new NetResponse(doGet);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i, int i2, HashMap<String, String> hashMap) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i2).retryNum(i).header(hashMap).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, int i2) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i2).retryNum(i).header(hashMap).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i).header(hashMap).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i, HashMap<String, String> hashMap, HttpCanceler httpCanceler, int i2) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i2).retryNum(i).header(hashMap).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, byte[] bArr) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPost(String str, byte[] bArr, int i, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).retryNum(i).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public NetResponse doPostNoBuffer(String str, String str2, byte[] bArr) throws Exception {
        com.tencent.map.tools.net.NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).postData(bArr).doPost();
        if (doPost != null) {
            return new NetResponse(doPost);
        }
        return null;
    }

    public void doRangePost(String str, byte[] bArr, String str2, String str3, String str4, String str5, HttpCanceler httpCanceler) throws Exception {
        com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).token(str2).postData(bArr).nonce(str3).timestamp(str4).startTag(str5).canceler(httpCanceler).doPost();
    }
}
