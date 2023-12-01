package com.qiniu.android.http;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.custom.DnsCacheKey;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.persistent.DnsCacheFile;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/DnsPrefetcher.class */
public class DnsPrefetcher {
    private static Configuration config;
    public static DnsPrefetcher dnsPrefetcher;
    private static ConcurrentHashMap<String, List<InetAddress>> mConcurrentHashMap = new ConcurrentHashMap<>();
    private static AtomicReference mDnsCacheKey = new AtomicReference();
    public static String target_region_id = "";
    private static String token;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/DnsPrefetcher$ZoneIndex.class */
    public static class ZoneIndex {
        final String accessKey;
        final String bucket;

        ZoneIndex(String str, String str2) {
            this.accessKey = str;
            this.bucket = str2;
        }

        static ZoneIndex getFromToken(String str) {
            String[] split = str.split(":");
            try {
                return new ZoneIndex(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (obj == null || !(obj instanceof ZoneIndex)) {
                    return false;
                }
                ZoneIndex zoneIndex = (ZoneIndex) obj;
                return zoneIndex.accessKey.equals(this.accessKey) && zoneIndex.bucket.equals(this.bucket);
            }
            return true;
        }

        public int hashCode() {
            return (this.accessKey.hashCode() * 37) + this.bucket.hashCode();
        }
    }

    private DnsPrefetcher() {
    }

    public static boolean checkRePrefetchDns(String str, Configuration configuration) {
        DnsCacheKey dnsCacheKey;
        if (mDnsCacheKey.get() == null) {
            return true;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String hostIP = AndroidNetwork.getHostIP();
        String akAndScope = StringUtils.getAkAndScope(str);
        if (valueOf == null || hostIP == null || akAndScope == null || (dnsCacheKey = (DnsCacheKey) mDnsCacheKey.get()) == null || dnsCacheKey.getCurrentTime() == null) {
            return true;
        }
        return (hostIP.equals(dnsCacheKey.getLocalIp()) && (Long.parseLong(valueOf) - Long.parseLong(dnsCacheKey.getCurrentTime())) / 1000 <= configuration.dnsCacheTimeMs && akAndScope.equals(dnsCacheKey.getAkScope())) ? false : true;
    }

    public static DnsPrefetcher getDnsPrefetcher() {
        if (dnsPrefetcher == null) {
            synchronized (DnsPrefetcher.class) {
                try {
                    if (dnsPrefetcher == null) {
                        dnsPrefetcher = new DnsPrefetcher();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return dnsPrefetcher;
    }

    private void preFetch(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                mConcurrentHashMap.put(str, okhttp3.Dns.SYSTEM.lookup(str));
            } catch (UnknownHostException e) {
                e.printStackTrace();
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            rePreFetch(arrayList, (Dns) null);
        }
    }

    private List<String> preHosts() {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ZoneInfo preQueryZone = getPreQueryZone();
        if (preQueryZone != null) {
            for (String str : preQueryZone.upDomainsList) {
                if (hashSet.add(str)) {
                    arrayList.add(str);
                }
            }
        }
        for (ZoneInfo zoneInfo : getLocalZone()) {
            for (String str2 : zoneInfo.upDomainsList) {
                if (hashSet.add(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (hashSet.add(Config.preQueryHost)) {
            arrayList.add(Config.preQueryHost);
        }
        return arrayList;
    }

    private void rePreFetch(List<String> list, Dns dns) {
        for (String str : list) {
            int i = 0;
            while (i < Config.rePreHost) {
                i++;
                if (rePreFetch(str, dns)) {
                    break;
                }
            }
        }
    }

    private boolean rePreFetch(String str, Dns dns) {
        try {
            mConcurrentHashMap.put(str, dns == null ? okhttp3.Dns.SYSTEM.lookup(str) : dns.lookup(str));
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean recoverCache(Configuration configuration) {
        byte[] bArr;
        DnsCacheKey cacheKey;
        try {
            DnsCacheFile dnsCacheFile = new DnsCacheFile(Config.dnscacheDir);
            String fileName = dnsCacheFile.getFileName();
            if (fileName == null || (bArr = dnsCacheFile.get(fileName)) == null || (cacheKey = DnsCacheKey.toCacheKey(fileName)) == null) {
                return true;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            String hostIP = AndroidNetwork.getHostIP();
            if (valueOf == null || hostIP == null) {
                return true;
            }
            long parseLong = (Long.parseLong(valueOf) - Long.parseLong(cacheKey.getCurrentTime())) / 1000;
            if (!cacheKey.getLocalIp().equals(hostIP) || parseLong > configuration.dnsCacheTimeMs) {
                return true;
            }
            mDnsCacheKey.set(cacheKey);
            return recoverDnsCache(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean recoverDnsCache(byte[] bArr) {
        try {
            ConcurrentHashMap<String, List<InetAddress>> concurrentHashMap = (ConcurrentHashMap) StringUtils.toObject(bArr);
            if (concurrentHashMap == null) {
                return true;
            }
            getDnsPrefetcher().setConcurrentHashMap(concurrentHashMap);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static void startPrefetchDns(String str, Configuration configuration) {
        byte[] byteArray;
        String valueOf = String.valueOf(System.currentTimeMillis());
        String hostIP = AndroidNetwork.getHostIP();
        String akAndScope = StringUtils.getAkAndScope(str);
        if (valueOf == null || hostIP == null || akAndScope == null) {
            return;
        }
        DnsCacheKey dnsCacheKey = new DnsCacheKey(valueOf, hostIP, akAndScope);
        String dnsCacheKey2 = dnsCacheKey.toString();
        try {
            DnsCacheFile dnsCacheFile = new DnsCacheFile(Config.dnscacheDir);
            DnsPrefetcher init = getDnsPrefetcher().init(str, configuration);
            mDnsCacheKey.set(dnsCacheKey);
            if (configuration.dns != null) {
                getDnsPrefetcher().dnsPreByCustom(configuration.dns);
            }
            if (init == null || (byteArray = StringUtils.toByteArray(init.getConcurrentHashMap())) == null) {
                return;
            }
            dnsCacheFile.set(dnsCacheKey2, byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dnsPreByCustom(Dns dns) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<InetAddress>> concurrentHashMap = mConcurrentHashMap;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (String str : mConcurrentHashMap.keySet()) {
                if (str != null && str.length() != 0) {
                    try {
                        mConcurrentHashMap.put(str, dns.lookup(str));
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                        arrayList.add(str);
                    }
                }
            }
        }
        rePreFetch(arrayList, dns);
    }

    public ConcurrentHashMap<String, List<InetAddress>> getConcurrentHashMap() {
        return mConcurrentHashMap;
    }

    public List<InetAddress> getInetAddressByHost(String str) {
        return mConcurrentHashMap.get(str);
    }

    public List<ZoneInfo> getLocalZone() {
        return FixedZone.getZoneInfos();
    }

    public ZoneInfo getPreQueryZone() {
        return preQueryIndex(ZoneIndex.getFromToken(token));
    }

    ResponseInfo getZoneJsonSync(ZoneIndex zoneIndex) {
        Client client = new Client();
        String str = (!config.useHttps ? "http://" : "https://") + Config.preQueryHost + "/v2/query?ak=" + zoneIndex.accessKey + "&bucket=" + zoneIndex.bucket;
        LogHandler uplogHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
        uplogHandler.send("up_type", "uc_query");
        return client.syncGet(uplogHandler, str, null);
    }

    public DnsPrefetcher init(String str, Configuration configuration) throws UnknownHostException {
        token = str;
        config = configuration;
        List<String> preHosts = preHosts();
        if (preHosts != null && preHosts.size() > 0) {
            preFetch(preHosts);
        }
        return this;
    }

    public void localFetch() {
        ArrayList arrayList = new ArrayList();
        for (ZoneInfo zoneInfo : getLocalZone()) {
            for (String str : zoneInfo.upDomainsList) {
                arrayList.add(str);
            }
        }
        arrayList.add(Config.preQueryHost);
        if (arrayList.size() > 0) {
            preFetch(arrayList);
        }
    }

    ZoneInfo preQueryIndex(ZoneIndex zoneIndex) {
        ZoneInfo buildFromJson;
        try {
            ResponseInfo zoneJsonSync = getZoneJsonSync(zoneIndex);
            if (zoneJsonSync.response == null || (buildFromJson = ZoneInfo.buildFromJson(zoneJsonSync.response)) == null) {
                return null;
            }
            if (buildFromJson.upDomainsList.size() > 0) {
                if (buildFromJson.upDomainsList.contains(FixedZone.arrayzone0[0])) {
                    target_region_id = "z0";
                    return buildFromJson;
                } else if (buildFromJson.upDomainsList.contains(FixedZone.arrayzone1[0])) {
                    target_region_id = "z1";
                    return buildFromJson;
                } else if (buildFromJson.upDomainsList.contains(FixedZone.arrayzone2[0])) {
                    target_region_id = "z2";
                    return buildFromJson;
                } else if (buildFromJson.upDomainsList.contains(FixedZone.arrayZoneAs0[0])) {
                    target_region_id = "as0";
                    return buildFromJson;
                } else if (buildFromJson.upDomainsList.contains(FixedZone.arrayzoneNa0[0])) {
                    target_region_id = "na";
                }
            }
            return buildFromJson;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setConcurrentHashMap(ConcurrentHashMap<String, List<InetAddress>> concurrentHashMap) {
        mConcurrentHashMap = concurrentHashMap;
    }

    public void setToken(String str) {
        token = str;
    }
}
