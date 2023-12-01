package com.tencent.thumbplayer.c;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/k.class */
public class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static TPDownloadParam a(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map) {
        ArrayList<Map<String, String>> arrayList;
        ArrayList<String> arrayList2;
        if (tPDownloadParamData == null) {
            ArrayList arrayList3 = new ArrayList(1);
            arrayList3.add(str);
            return new TPDownloadParam(arrayList3, 0, null);
        }
        ArrayList<String> arrayList4 = new ArrayList<>();
        if (tPDownloadParamData.getUrlCdnidList() == null || tPDownloadParamData.getUrlCdnidList().isEmpty()) {
            if (TextUtils.isEmpty(str)) {
                str = tPDownloadParamData.url;
            }
            arrayList4.add(str);
            String[] bakUrl = tPDownloadParamData.getBakUrl();
            if (bakUrl != null && bakUrl.length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bakUrl.length) {
                        break;
                    }
                    if (!TextUtils.isEmpty(bakUrl[i2])) {
                        arrayList4.add(bakUrl[i2]);
                    }
                    i = i2 + 1;
                }
            }
            ArrayList<Map<String, String>> arrayList5 = null;
            if (map != null) {
                arrayList5 = new ArrayList<>();
                arrayList5.add(map);
            }
            arrayList = arrayList5;
            arrayList2 = arrayList4;
        } else {
            arrayList2 = tPDownloadParamData.getUrlCdnidList();
            arrayList = tPDownloadParamData.getUrlCdnidHttpHeaderList();
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(tPDownloadParamData.getFlowId())) {
            TPLogUtil.i("TPProxyUtils", tPDownloadParamData.getFlowId());
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_FLOWID, tPDownloadParamData.getFlowId());
        }
        if (tPDownloadParamData.getUrlExpireTime() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_EXPIRE_TIME, Integer.valueOf(tPDownloadParamData.getUrlExpireTime()));
        }
        if (tPDownloadParamData.getFileSize() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_FILE_SIZE, Long.valueOf(tPDownloadParamData.getFileSize()));
        }
        if (tPDownloadParamData.getFileDuration() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_FILE_DURATION, Long.valueOf(tPDownloadParamData.getFileDuration()));
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getDownloadFileID())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_KEYID, tPDownloadParamData.getDownloadFileID());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getVid())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VID, tPDownloadParamData.getVid());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getPlayDefinition())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION, tPDownloadParamData.getPlayDefinition());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getCurrentFormat())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMAT, tPDownloadParamData.getCurrentFormat());
        }
        if (tPDownloadParamData.getCurrentFormatID() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMATID, Integer.valueOf(tPDownloadParamData.getCurrentFormatID()));
        }
        if (!com.tencent.thumbplayer.utils.b.a(tPDownloadParamData.getFormatInfo())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_FORMAT_INFO, tPDownloadParamData.getFormatInfo());
        }
        if (tPDownloadParamData.getBandwidthLevel() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_BAND_WIDTH_LEVEL, Integer.valueOf(tPDownloadParamData.getBandwidthLevel()));
        }
        hashMap.put(TPDownloadProxyEnum.DLPARAM_SOURCE_IS_CHARGE, Boolean.valueOf(tPDownloadParamData.isCharge()));
        hashMap.put(TPDownloadProxyEnum.DLPARAM_CACHE_NEED_ENCRYPT, Boolean.valueOf(tPDownloadParamData.isNeedEncryptCache()));
        hashMap.put(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE, Boolean.valueOf(tPDownloadParamData.isOffline()));
        hashMap.put(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL, Boolean.valueOf(tPDownloadParamData.isExtraParam()));
        if (arrayList != null && !arrayList.isEmpty()) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_HEADER, arrayList);
        }
        if (tPDownloadParamData.getPreloadSize() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PRELOAD_SIZE, Long.valueOf(tPDownloadParamData.getPreloadSize()));
        }
        if (tPDownloadParamData.getPreloadDuration() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PRELOAD_DURATION, Long.valueOf(tPDownloadParamData.getPreloadDuration()));
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getSavePath())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_SAVE_PATH, tPDownloadParamData.getSavePath());
        }
        if (tPDownloadParamData.getStarTimeMS() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_START_TIME, Integer.valueOf(tPDownloadParamData.getStarTimeMS()));
        }
        if (tPDownloadParamData.getEndTimeMS() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Integer.valueOf(tPDownloadParamData.getEndTimeMS()));
        }
        if (tPDownloadParamData.getClipCount() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_COUNT, Integer.valueOf(tPDownloadParamData.getClipCount()));
        }
        if (tPDownloadParamData.getClipNo() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_NO, Integer.valueOf(tPDownloadParamData.getClipNo()));
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getBase())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_BASE, tPDownloadParamData.getBase());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getLinkVid())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_LINK_VID, tPDownloadParamData.getLinkVid());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getFileMD5())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_FILE_MD5, tPDownloadParamData.getFileMD5());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getM3u8())) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_M3U8, tPDownloadParamData.getM3u8());
        }
        if (tPDownloadParamData.getTm() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_TM, Long.valueOf(tPDownloadParamData.getTm()));
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getNonce())) {
            TPLogUtil.i("TPProxyUtils", "nonce:" + tPDownloadParamData.getNonce());
            hashMap.put(TPDownloadProxyEnum.DLPARAM_NONCE, tPDownloadParamData.getNonce());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getDecKey())) {
            TPLogUtil.i("TPProxyUtils", "encrypt stream key:" + tPDownloadParamData.getDecKey());
            hashMap.put(TPDownloadProxyEnum.DLPARAM_ENCRYPT_STREAM_KEY, tPDownloadParamData.getDecKey());
        }
        if (!TextUtils.isEmpty(tPDownloadParamData.getRandoms())) {
            TPLogUtil.i("TPProxyUtils", "encrypt randoms:" + tPDownloadParamData.getRandoms());
            hashMap.put(TPDownloadProxyEnum.DLPARAM_ENCRYPT_STREAM_RANDOMS, tPDownloadParamData.getRandoms());
        }
        hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_FP2P, Integer.valueOf(tPDownloadParamData.getFp2p()));
        if (tPDownloadParamData.getTestid() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_TESTID, Integer.valueOf(tPDownloadParamData.getTestid()));
        }
        if (tPDownloadParamData.getExceptDelay() > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_EXPECT_DELAY_TIME, Integer.valueOf(tPDownloadParamData.getExceptDelay()));
        }
        if (tPDownloadParamData.getSecondaryM3u8List() != null) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_SECONDARY_M3U8_LIST, tPDownloadParamData.getSecondaryM3u8List());
        }
        if (!com.tencent.thumbplayer.utils.b.a(tPDownloadParamData.getExtInfoMap())) {
            hashMap.putAll(tPDownloadParamData.getExtInfoMap());
        }
        hashMap.put(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE, tPDownloadParamData.getSelfAdaption() ? 3 : 0);
        hashMap.put(TPDownloadProxyEnum.DLPARAM_FORMAT_NODES, tPDownloadParamData.getDefInfoList());
        if (tPDownloadParamData.getPcdnUrlList() != null && !tPDownloadParamData.getPcdnUrlList().isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            Iterator<String> it = tPDownloadParamData.getPcdnUrlList().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(t.aE);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TPLogUtil.i("TPProxyUtils", "pcdn url list: " + sb.toString());
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PCDN_URLS, sb.toString());
        }
        if (tPDownloadParamData.getPcdnVtList() != null && !tPDownloadParamData.getPcdnVtList().isEmpty()) {
            StringBuilder sb2 = new StringBuilder("");
            Iterator<Integer> it2 = tPDownloadParamData.getPcdnVtList().iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next().intValue());
                sb2.append(t.aE);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            hashMap.put(TPDownloadProxyEnum.DLPARAM_PCDN_VTS, sb2.toString());
        }
        return new TPDownloadParam(arrayList2, h.a(tPDownloadParamData.getDlType()), hashMap);
    }
}
