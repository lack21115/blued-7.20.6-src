package com.tencent.thumbplayer.core.downloadproxy.api;

import com.huawei.openalliance.ad.constant.t;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadParam.class */
public class TPDownloadParam {
    private static final String FILE_NAME = "TPDownloadParam";
    private int dlType;
    private ArrayList<String> urlList = new ArrayList<>();
    private Map<String, Object> extInfoMap = new HashMap();

    public TPDownloadParam(ArrayList<String> arrayList, int i, Map<String, Object> map) {
        this.dlType = i;
        setUrlList(arrayList);
        setExtInfoMap(map);
    }

    private String getExtraFormatNodesJsonInfo(ArrayList<Map<String, Object>> arrayList) {
        if (arrayList == null) {
            return "[]";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer("[");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    stringBuffer.append("]");
                    return stringBuffer.toString();
                }
                Map<String, Object> map = arrayList.get(i2);
                if (i2 == arrayList.size() - 1) {
                    stringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", map.get("dl_param_name"), map.get("dl_param_bitrate")));
                } else {
                    stringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", map.get("dl_param_name"), map.get("dl_param_bitrate")));
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getExtraJsonInfo failed, error:" + th.toString());
            return "[]";
        }
    }

    private String getUrlHostNodesJsonInfo(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return "[]";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer("[");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    stringBuffer.append("]");
                    return stringBuffer.toString();
                }
                String str = arrayList.get(i2);
                if (i2 == arrayList.size() - 1) {
                    stringBuffer.append(String.format("\"%s\"", str));
                } else {
                    stringBuffer.append(String.format("\"%s\", ", str));
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getArrayListStr failed, error:" + th.toString());
            return "[]";
        }
    }

    public String getCdnUrls() {
        if (this.urlList == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, Object> map = this.extInfoMap;
        boolean booleanValue = (map == null || !map.containsKey(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL)) ? false : ((Boolean) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL)).booleanValue();
        for (int i = 0; i < this.urlList.size(); i++) {
            stringBuffer.append(this.urlList.get(i));
            if (booleanValue) {
                if (this.urlList.get(i).indexOf("?") > 0) {
                    stringBuffer.append("&cost=low");
                } else {
                    stringBuffer.append("?cost=low");
                }
            }
            stringBuffer.append(t.aE);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public int getClipCount() {
        Map<String, Object> map = this.extInfoMap;
        int i = 1;
        if (map != null) {
            if (map.isEmpty()) {
                return 1;
            }
            i = 1;
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_COUNT)) {
                i = ((Integer) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_COUNT)).intValue();
            }
        }
        return i;
    }

    public int getClipNo() {
        Map<String, Object> map = this.extInfoMap;
        int i = 1;
        if (map != null) {
            if (map.isEmpty()) {
                return 1;
            }
            i = 1;
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_NO)) {
                i = ((Integer) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_NO)).intValue();
            }
        }
        return i;
    }

    public int getDlType() {
        return this.dlType;
    }

    public Object getExtInfo(String str) {
        Map<String, Object> map = this.extInfoMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, Object> getExtInfoMap() {
        return this.extInfoMap;
    }

    public String getExtraJsonInfo() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty()) {
            return "";
        }
        try {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : this.extInfoMap.entrySet()) {
                if (!entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE) && !entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_OFFLINE_PLAY_EXTRA_INFO) && !entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION) && !entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL)) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JSONObject(hashMap).toString();
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getExtraJsonInfo failed, error:" + th.toString());
            return "";
        }
    }

    public String getFormat() {
        Map<String, Object> map = this.extInfoMap;
        String str = "";
        if (map != null) {
            if (map.isEmpty()) {
                return "";
            }
            str = "";
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMAT)) {
                str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMAT);
            }
        }
        return str;
    }

    public String getKeyid() {
        Map<String, Object> map = this.extInfoMap;
        String str = "";
        if (map != null) {
            if (map.isEmpty()) {
                return "";
            }
            str = "";
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_KEYID)) {
                str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_KEYID);
            }
        }
        return str;
    }

    public Map<String, String> getOfflinePlayExtraInfo() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_OFFLINE_PLAY_EXTRA_INFO)) {
            return null;
        }
        return (Map) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_OFFLINE_PLAY_EXTRA_INFO);
    }

    public String getPlayDefinition() {
        Map<String, Object> map = this.extInfoMap;
        String str = "";
        if (map != null) {
            if (map.isEmpty()) {
                return "";
            }
            str = "";
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION)) {
                str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION);
            }
        }
        return str;
    }

    public String getSavaPath() {
        Map<String, Object> map = this.extInfoMap;
        String str = "";
        if (map != null) {
            if (map.isEmpty()) {
                return "";
            }
            str = "";
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_SAVE_PATH)) {
                str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_SAVE_PATH);
            }
        }
        return str;
    }

    public long getTotalDurationMS() {
        Map<String, Object> map = this.extInfoMap;
        long j = 0;
        if (map != null) {
            if (map.isEmpty()) {
                return 0L;
            }
            j = 0;
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_FILE_DURATION)) {
                j = ((Long) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_FILE_DURATION)).longValue();
            }
        }
        return j;
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public String getVid() {
        Map<String, Object> map = this.extInfoMap;
        String str = "";
        if (map != null) {
            if (map.isEmpty()) {
                return "";
            }
            str = "";
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_VID)) {
                str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_VID);
            }
        }
        return str;
    }

    public boolean isAdaptive() {
        Map<String, Object> map = this.extInfoMap;
        boolean z = false;
        if (map != null) {
            if (map.isEmpty()) {
                return false;
            }
            z = false;
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE)) {
                z = false;
                if (((Integer) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE)).intValue() > 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isOffline() {
        Map<String, Object> map = this.extInfoMap;
        boolean z = false;
        if (map != null) {
            if (map.isEmpty()) {
                return false;
            }
            z = false;
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE)) {
                z = ((Boolean) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE)).booleanValue();
            }
        }
        return z;
    }

    public void setDlType(int i) {
        this.dlType = i;
    }

    public void setExtInfoMap(Map<String, Object> map) {
        if (map != null) {
            this.extInfoMap = map;
        } else {
            this.extInfoMap.clear();
        }
    }

    public void setUrlList(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.urlList = arrayList;
        } else {
            this.urlList.clear();
        }
    }
}
