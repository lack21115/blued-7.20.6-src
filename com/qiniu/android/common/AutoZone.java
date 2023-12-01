package com.qiniu.android.common;

import android.os.Process;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.UrlSafeBase64;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/common/AutoZone.class */
public final class AutoZone extends Zone {
    private Client client;
    private String ucServer;
    private Map<ZoneIndex, ZoneInfo> zones;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/common/AutoZone$ZoneIndex.class */
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

    public AutoZone() {
        this(true);
    }

    public AutoZone(boolean z) {
        this.zones = new ConcurrentHashMap();
        this.client = new Client();
        if (z) {
            this.ucServer = "https://uc.qbox.me";
        } else {
            this.ucServer = "http://uc.qbox.me";
        }
    }

    private void getZoneJsonAsync(LogHandler logHandler, ZoneIndex zoneIndex, CompletionHandler completionHandler) {
        this.client.asyncGet(logHandler, this.ucServer + "/v2/query?ak=" + zoneIndex.accessKey + "&bucket=" + zoneIndex.bucket, null, UpToken.NULL, completionHandler);
    }

    private ResponseInfo getZoneJsonSync(LogHandler logHandler, ZoneIndex zoneIndex) {
        return this.client.syncGet(logHandler, this.ucServer + "/v2/query?ak=" + zoneIndex.accessKey + "&bucket=" + zoneIndex.bucket, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTarget_region_id(ZoneInfo zoneInfo) {
        if (zoneInfo != null && zoneInfo.upDomainsList.size() > 0) {
            if (zoneInfo.upDomainsList.contains(FixedZone.arrayzone0[0])) {
                DnsPrefetcher.target_region_id = "z0";
            } else if (zoneInfo.upDomainsList.contains(FixedZone.arrayzone1[0])) {
                DnsPrefetcher.target_region_id = "z1";
            } else if (zoneInfo.upDomainsList.contains(FixedZone.arrayzone2[0])) {
                DnsPrefetcher.target_region_id = "z2";
            } else if (zoneInfo.upDomainsList.contains(FixedZone.arrayZoneAs0[0])) {
                DnsPrefetcher.target_region_id = "as0";
            } else if (zoneInfo.upDomainsList.contains(FixedZone.arrayzoneNa0[0])) {
                DnsPrefetcher.target_region_id = "na";
            }
        }
    }

    @Override // com.qiniu.android.common.Zone
    public void frozenDomain(String str) {
        ZoneInfo zoneInfo;
        synchronized (this) {
            if (str != null) {
                String host = URI.create(str).getHost();
                Iterator<Map.Entry<ZoneIndex, ZoneInfo>> it = this.zones.entrySet().iterator();
                do {
                    zoneInfo = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    zoneInfo = it.next().getValue();
                } while (!zoneInfo.upDomainsList.contains(host));
                if (zoneInfo != null) {
                    zoneInfo.frozenDomain(host);
                }
            }
        }
    }

    public String getUcServer() {
        return this.ucServer;
    }

    @Override // com.qiniu.android.common.Zone
    public void preQuery(LogHandler logHandler, String str, Zone.QueryHandler queryHandler) {
        preQueryIndex(logHandler, ZoneIndex.getFromToken(str), queryHandler);
    }

    @Override // com.qiniu.android.common.Zone
    public boolean preQuery(LogHandler logHandler, String str) {
        return preQueryIndex(logHandler, ZoneIndex.getFromToken(str));
    }

    void preQueryIndex(LogHandler logHandler, final ZoneIndex zoneIndex, final Zone.QueryHandler queryHandler) {
        if (zoneIndex == null) {
            queryHandler.onFailure(-5);
            return;
        }
        ZoneInfo zoneInfo = this.zones.get(zoneIndex);
        if (zoneInfo != null) {
            setTarget_region_id(zoneInfo);
            queryHandler.onSuccess();
            return;
        }
        logHandler.send("tid", Long.valueOf(Process.myTid()));
        getZoneJsonAsync(logHandler, zoneIndex, new CompletionHandler() { // from class: com.qiniu.android.common.AutoZone.1
            @Override // com.qiniu.android.http.CompletionHandler
            public void complete(ResponseInfo responseInfo, JSONObject jSONObject) {
                if (!responseInfo.isOK() || jSONObject == null) {
                    queryHandler.onFailure(responseInfo.statusCode);
                    return;
                }
                try {
                    ZoneInfo buildFromJson = ZoneInfo.buildFromJson(jSONObject);
                    AutoZone.this.setTarget_region_id(buildFromJson);
                    AutoZone.this.zones.put(zoneIndex, buildFromJson);
                    queryHandler.onSuccess();
                } catch (JSONException e) {
                    e.printStackTrace();
                    queryHandler.onFailure(-1);
                }
            }
        });
    }

    boolean preQueryIndex(LogHandler logHandler, ZoneIndex zoneIndex) {
        logHandler.send("tid", Long.valueOf(Process.myTid()));
        if (zoneIndex != null) {
            if (this.zones.get(zoneIndex) != null) {
                return true;
            }
            try {
                ResponseInfo zoneJsonSync = getZoneJsonSync(logHandler, zoneIndex);
                if (zoneJsonSync.response == null) {
                    return false;
                }
                this.zones.put(zoneIndex, ZoneInfo.buildFromJson(zoneJsonSync.response));
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    ZoneInfo queryByToken(String str) {
        try {
            String[] split = str.split(":");
            return zoneInfo(split[0], new JSONObject(new String(UrlSafeBase64.decode(split[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setUcServer(String str) {
        this.ucServer = str;
    }

    @Override // com.qiniu.android.common.Zone
    public String upHost(String str, boolean z, String str2) {
        synchronized (this) {
            ZoneInfo queryByToken = queryByToken(str);
            if (queryByToken != null) {
                return super.upHost(queryByToken, z, str2);
            }
            return null;
        }
    }

    ZoneInfo zoneInfo(String str, String str2) {
        return this.zones.get(new ZoneIndex(str, str2));
    }
}
