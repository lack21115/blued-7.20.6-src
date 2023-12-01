package com.tencent.thumbplayer.tplayer.plugins.report;

import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.speech.tts.TextToSpeech;
import com.cdo.oaps.ad.OapsKey;
import com.soft.blued.ui.find.model.UserFindResult;
import com.tencent.tendinsv.a.b;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams.class */
public class TPReportParams {
    public static final int BUFFERING_REASON_BITRATE_JITTER = 1400109;
    public static final int BUFFERING_REASON_CDN_TIMEOUT = 1400103;
    public static final int BUFFERING_REASON_CDN_TIMEOUT_BUT_CONNECTED = 1400104;
    public static final int BUFFERING_REASON_DOWNLOAD_SHORT_TIME = 1400111;
    public static final int BUFFERING_REASON_DOWNLOAD_TASK = 1400101;
    public static final int BUFFERING_REASON_NETWORK_DEVICE_EXCEPTION = 1400102;
    public static final int BUFFERING_REASON_NETWORK_UNSTABLE = 1400100;
    public static final int BUFFERING_REASON_P2P_FASTER_THAN_HTTP = 1400110;
    public static final int BUFFERING_REASON_P2P_UPLOAD = 1400112;
    public static final int BUFFERING_REASON_RECEIVE_TIMEOUT = 1400105;
    public static final int BUFFERING_REASON_RECEIVE_TIMEOUT_BUT_CONNECTED = 1400106;
    public static final int BUFFERING_REASON_SLOWLY_SPEED = 1400107;
    public static final int BUFFERING_REASON_SLOWLY_SPEED_BUT_CONNECTED = 1400108;
    public static final String ERROR_CODE_NO_ERROR = "0";
    public static final String JSON_KEY_VAL = "val";
    public static final int LIVE_STEP_FAILED = 150;
    public static final int LIVE_STEP_LOADING_SUCC = 205;
    public static final int LIVE_STEP_PLAY = 263;
    public static final int NETWORK_TYPE_2G = 2;
    public static final int NETWORK_TYPE_3G = 3;
    public static final int NETWORK_TYPE_4G = 4;
    public static final int NETWORK_TYPE_5G = 5;
    public static final int NETWORK_TYPE_ETHERNET = 10;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int PLAYER_STEP_BUFFERING = 35;
    public static final int PLAYER_STEP_FIRST_LOAD = 30;
    public static final int PLAYER_STEP_FIRST_RENDERING = 32;
    public static final int PLAYER_STEP_GET_CDN_URL = 15;
    public static final int PLAYER_STEP_INIT_PLAYER = 5;
    public static final int PLAYER_STEP_LOAD_SUBTITLE = 33;
    public static final int PLAYER_STEP_PLAY_DONE = 50;
    public static final int PLAYER_STEP_REDIRECT = 34;
    public static final int PLAYER_STEP_USER_SEEK = 40;
    public static final int PLAYER_TYPE_SYSTEM_PLAYER = 0;
    public static final int PLAYER_TYPE_THUMB_PLAYER = 1;
    public static final int PLAY_END_REASON_APP_EXIT = 2;
    public static final int PLAY_END_REASON_EOS = 0;
    public static final int PLAY_END_REASON_PLAYER_ERROR = 3;
    public static final int PLAY_END_REASON_USER_STOP = 1;
    public static final int PLAY_EVENT_NONE = 0;
    public static final int PLAY_EVENT_PAUSE_BY_DEVICE = 2;
    public static final int PLAY_EVENT_SCREEN_SHOT = 3;
    public static final int PLAY_EVENT_SEEK = 1;
    public static final int PLAY_SCENE_NORMAL_PLAY = 1;
    public static final int PLAY_SCENE_TRICK_PLAY = 2;
    public static final int PLAY_TYPE_LIVE = 1;
    public static final int PLAY_TYPE_UNKNOWN = -1;
    public static final int PLAY_TYPE_VOD = 0;
    public static final String PROP_KEY_DATA = "data";
    private static final String TAG = "TPReportParams";
    public static final int VIDEO_DL_TYPE_HLS = 3;
    public static final int VIDEO_DL_TYPE_MP4 = 1;
    private CommonParams commonParams = new CommonParams();
    private PlayerInitParams initParams = new PlayerInitParams();
    private GetCdnUrlParams getCdnParams = new GetCdnUrlParams();
    private FirstLoadParams firstLoadParams = new FirstLoadParams();
    private FirstRenderParams firstRenderParams = new FirstRenderParams();
    private LoadSubtitleParams loadSubtitleParams = new LoadSubtitleParams();
    private RedirectParams redirectParams = new RedirectParams();
    private BufferingTotalParams bufferingTotalParams = new BufferingTotalParams();
    private UserSeekTotalParams userSeekTotalParams = new UserSeekTotalParams();
    private PlayDoneParams playDoneParams = new PlayDoneParams();
    private LiveExParam liveExParam = new LiveExParam();
    private VodExParam vodExParam = new VodExParam();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$BufferingOnceParams.class */
    public class BufferingOnceParams {
        public long bufferingPresentTimeLong;
        public long endTimeUnix;
        public String errCodeString;
        public int formatInt;
        public int lastEventInt;
        public int reasonInt;
        public int sceneInt;
        public long starTimeUnix;
        public String urlString;

        public BufferingOnceParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("scene", this.sceneInt);
                jSONObject.put("levent", this.lastEventInt);
                jSONObject.put("reason", this.reasonInt);
                jSONObject.put("format", this.formatInt);
                jSONObject.put("ptime", this.bufferingPresentTimeLong);
                jSONObject.put("stime", this.starTimeUnix);
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put("url", this.urlString);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("scene", this.sceneInt);
            aVar.a("levent", this.lastEventInt);
            aVar.a("reason", this.reasonInt);
            aVar.a("format", this.formatInt);
            aVar.a("ptime", this.bufferingPresentTimeLong);
            aVar.a("stime", this.starTimeUnix);
            aVar.a("etime", this.endTimeUnix);
            aVar.a("url", this.urlString);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.sceneInt = 1;
            this.lastEventInt = 0;
            this.reasonInt = TPReportParams.BUFFERING_REASON_NETWORK_UNSTABLE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$BufferingTotalParams.class */
    public class BufferingTotalParams {
        public int bufferingCountInt;
        public int bufferingDurationInt;
        public List<BufferingOnceParams> bufferingOnceParamsList = new LinkedList();

        public BufferingTotalParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("bcount", this.bufferingCountInt);
                jSONObject.put("tduration", this.bufferingDurationInt);
                JSONArray jSONArray = new JSONArray();
                for (BufferingOnceParams bufferingOnceParams : this.bufferingOnceParamsList) {
                    JSONObject jSONObject2 = new JSONObject();
                    bufferingOnceParams.paramsToJson(jSONObject2);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(TPReportParams.JSON_KEY_VAL, jSONArray);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("bcount", this.bufferingCountInt);
            aVar.a("tduration", this.bufferingDurationInt);
        }

        public void reset() {
            this.bufferingCountInt = 0;
            this.bufferingDurationInt = 0;
            this.bufferingOnceParamsList.clear();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$CommonParams.class */
    public class CommonParams {
        public String appVersionString;
        public int cdnIdInt;
        public String cdnIpString;
        public String cdnUipString;
        public String deviceNameString;
        public String deviceResolutionString;
        public int downloadTypeInt;
        public String flowIdString;
        public String guidString;
        public int loginTypeInt;
        public float mediaDurationFloat;
        public int mediaFormatInt;
        public int mediaRateInt;
        public String mediaResolutionString;
        public int networkSpeedInt;
        public int networkTypeInt;
        public int onlineInt;
        public String osVersionString;
        public int p2pInt;
        public String p2pVersionString;
        public long platformLong;
        public String playNoString;
        public int playTypeInt;
        public int playerTypeInt;
        public String playerVersionString;
        public String proto;
        public String protover;
        public String qqOpenIdString;
        public int scenesId;
        public int seqInt = 0;
        public int signalStrengthInt;
        public int stepInt;
        public int testIdInt;
        public String uinString;
        public String uipString;
        public String vidString;
        public String wxOpenIdString;

        public CommonParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("step", this.stepInt);
            aVar.a("seq", this.seqInt);
            aVar.a("platform", this.platformLong);
            aVar.a("flowid", this.flowIdString);
            aVar.a("playno", this.playNoString);
            aVar.a("uin", this.uinString);
            aVar.a("QQopenid", this.qqOpenIdString);
            aVar.a("WXopenid", this.wxOpenIdString);
            aVar.a("logintype", this.loginTypeInt);
            aVar.a(TPDownloadProxyEnum.USER_GUID, this.guidString);
            aVar.a("uip", this.uipString);
            aVar.a("cdnuip", this.cdnUipString);
            aVar.a("cdnip", this.cdnIpString);
            aVar.a(UserFindResult.USER_SORT_BY.ONLINE, this.onlineInt);
            aVar.a("p2p", this.p2pInt);
            aVar.a("sstrength", this.signalStrengthInt);
            aVar.a("network", this.networkTypeInt);
            aVar.a("speed", this.networkSpeedInt);
            aVar.a("device", this.deviceNameString);
            aVar.a("resolution", this.deviceResolutionString);
            aVar.a("testid", this.testIdInt);
            aVar.a("osver", this.osVersionString);
            aVar.a("p2pver", this.p2pVersionString);
            aVar.a("appver", this.appVersionString);
            aVar.a("playerver", this.playerVersionString);
            aVar.a("playertype", this.playerTypeInt);
            aVar.a("cdnid", this.cdnIdInt);
            aVar.a("scenesid", this.scenesId);
            aVar.a("playtype", this.playTypeInt);
            aVar.a("dltype", this.downloadTypeInt);
            aVar.a(OapsKey.KEY_VERID, this.vidString);
            aVar.a("definition", this.mediaResolutionString);
            aVar.a("fmt", this.mediaFormatInt);
            aVar.a(TextToSpeech.Engine.KEY_PARAM_RATE, this.mediaRateInt);
            aVar.a("duration", this.mediaDurationFloat);
            aVar.a(WifiConfiguration.Protocol.varName, this.proto);
            aVar.a("protover", this.protover);
        }

        public void reset() {
            this.stepInt = 0;
            this.seqInt = 0;
            this.platformLong = 0L;
            this.flowIdString = "";
            this.playNoString = "";
            this.uinString = "";
            this.qqOpenIdString = "";
            this.wxOpenIdString = "";
            this.loginTypeInt = 0;
            this.guidString = "";
            this.uipString = "";
            this.cdnUipString = "";
            this.cdnIpString = "";
            this.onlineInt = 0;
            this.p2pInt = 0;
            this.signalStrengthInt = 0;
            this.networkTypeInt = 0;
            this.networkSpeedInt = 0;
            this.deviceNameString = "";
            this.deviceResolutionString = "";
            this.testIdInt = 0;
            this.osVersionString = "";
            this.p2pVersionString = "";
            this.appVersionString = "";
            this.playerVersionString = "";
            this.playerTypeInt = 0;
            this.cdnIdInt = 0;
            this.scenesId = 0;
            this.downloadTypeInt = 0;
            this.vidString = "";
            this.mediaResolutionString = "";
            this.mediaFormatInt = 0;
            this.mediaRateInt = 0;
            this.mediaDurationFloat = 0.0f;
            this.proto = "";
            this.protover = "";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$FirstLoadParams.class */
    public class FirstLoadParams {
        public String cdnUrlString;
        public int cgiUrlIndex;
        public long endTimeUnix;
        public String errCodeString;
        public long firstOpenTimeUnix;
        public long firstPacketReadTimeUnix;
        public long starTimeUnix;

        public FirstLoadParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("stime", this.starTimeUnix);
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put("fileopenedtime", this.firstOpenTimeUnix);
                jSONObject.put("firstpacketreadtime", this.firstPacketReadTimeUnix);
                jSONObject.put("url", this.cdnUrlString);
                jSONObject.put("urlindex", this.cgiUrlIndex);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("stime", this.starTimeUnix);
            aVar.a("etime", this.endTimeUnix);
            aVar.a("fileopenedtime", this.firstOpenTimeUnix);
            aVar.a("firstpacketreadtime", this.firstPacketReadTimeUnix);
            aVar.a("url", this.cdnUrlString);
            aVar.a("urlindex", this.cgiUrlIndex);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.starTimeUnix = 0L;
            this.firstOpenTimeUnix = 0L;
            this.firstPacketReadTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.cdnUrlString = "";
            this.cgiUrlIndex = 0;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$FirstRenderParams.class */
    public class FirstRenderParams {
        public long endTimeUnix;
        public String errCodeString;
        public long starTimeUnix;

        public FirstRenderParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("stime", this.starTimeUnix);
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("stime", this.starTimeUnix);
            aVar.a("etime", this.endTimeUnix);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$GetCdnUrlParams.class */
    public class GetCdnUrlParams {
        public long endTimeUnix;
        public String errCodeString;
        public String proxyIpString;
        public long starTimeUnix;

        public GetCdnUrlParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("stime", this.starTimeUnix);
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put(b.a.q, this.proxyIpString);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("stime", this.starTimeUnix);
            aVar.a("etime", this.endTimeUnix);
            aVar.a(b.a.q, this.proxyIpString);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.proxyIpString = "";
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$LiveExParam.class */
    public class LiveExParam {
        int adPlayLengthInt;
        int blockCountInt;
        int blockTimeInt;
        String cdnServerString;
        int connectTimeInt;
        int contentIdInt;
        String defSwitchString;
        int deviceTypeInt;
        int downSpeedInt;
        String downloadServerIpString;
        String downloadUrl;
        int errCodeInt;
        String extraInfoString;
        int freeTypeInt;
        String fullErrCodeString;
        int getStreamDurationInt;
        int getSyncFrameDurationInt;
        int getUrlTimeInt;
        int isLookBackInt;
        int isStreamP2PInt;
        int isUseP2PInt;
        int isUserPayInt;
        int liveDelayInt;
        int liveProgramIdInt;
        int liveTagInt;
        int liveTypeInt;
        long loadingTimeLong;
        int maxSpeedInt;
        int networkTypeInt;
        int playTimeInt;
        String playerVersionString;
        int prePlayLengthInt;
        int reconnectCntInt;
        long reportTimeLong;
        String spanId;
        int streamIdInt;
        int testSpeedInt;
        String tuid;
        String userIpString;
        String userQQString;

        public LiveExParam() {
        }

        public void paramsToJson(JSONObject jSONObject) {
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("ftime", this.reportTimeLong);
            aVar.a("sip", this.userIpString);
            aVar.a("iqq", this.userQQString);
            aVar.a("prdlength", this.prePlayLengthInt);
            aVar.a("playad", this.adPlayLengthInt);
            aVar.a("fplayerver", this.playerVersionString);
            aVar.a("dsip", this.downloadServerIpString);
            aVar.a("devtype", this.deviceTypeInt);
            aVar.a("nettype", this.networkTypeInt);
            aVar.a("freetype", this.freeTypeInt);
            aVar.a("use_p2p", this.isUseP2PInt);
            aVar.a("p2p_play", this.isStreamP2PInt);
            aVar.a("livepid", this.liveProgramIdInt);
            aVar.a("sid", this.streamIdInt);
            aVar.a("contentid", this.contentIdInt);
            aVar.a("playtime", this.playTimeInt);
            aVar.a("isuserpay", this.isUserPayInt);
            aVar.a("switch", this.defSwitchString);
            aVar.a("live_type", this.liveTypeInt);
            aVar.a("xserverip", this.cdnServerString);
            aVar.a("durl", this.downloadUrl);
            aVar.a("lookback", this.isLookBackInt);
            aVar.a("live_delay", this.liveDelayInt);
            aVar.a("live_tag", this.liveTagInt);
            aVar.a(ConnectivityManager.EXTRA_EXTRA_INFO, this.extraInfoString);
            aVar.a("cnntime", this.connectTimeInt);
            aVar.a("maxspeed", this.maxSpeedInt);
            aVar.a("testspeed", this.testSpeedInt);
            aVar.a("downspeed", this.downSpeedInt);
            aVar.a("recnncount", this.reconnectCntInt);
            aVar.a("loadingtime", this.loadingTimeLong);
            aVar.a("blocktime", this.blockTimeInt);
            aVar.a("blockcount", this.blockCountInt);
            aVar.a("errorcode", this.errCodeInt);
            aVar.a("geturltime", this.getUrlTimeInt);
            aVar.a("fullecode", this.fullErrCodeString);
            aVar.a("get_stream_data_duration", this.getStreamDurationInt);
            aVar.a("get_sync_frame_duration", this.getSyncFrameDurationInt);
            aVar.a("spanId", this.spanId);
            aVar.a("tuid", this.tuid);
        }

        public void reset() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$LoadSubtitleParams.class */
    public class LoadSubtitleParams {
        public int bufferingDurationInt;
        public int cdnTypeInt;
        public int cgiUrlIndex;
        public long endTimeUnix;
        public String errCodeString;
        public long starTimeUnix;
        public String subtitleUrlString;

        public LoadSubtitleParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("stime", this.starTimeUnix);
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put("bufferduration", this.bufferingDurationInt);
                jSONObject.put("url", this.subtitleUrlString);
                jSONObject.put("vt", this.cdnTypeInt);
                jSONObject.put("urlindex", this.cgiUrlIndex);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("stime", this.starTimeUnix);
            aVar.a("etime", this.endTimeUnix);
            aVar.a("bufferduration", this.bufferingDurationInt);
            aVar.a("url", this.subtitleUrlString);
            aVar.a("vt", this.cdnTypeInt);
            aVar.a("urlindex", this.cgiUrlIndex);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.bufferingDurationInt = 0;
            this.subtitleUrlString = "";
            this.cdnTypeInt = 0;
            this.cgiUrlIndex = 0;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$PlayDoneParams.class */
    public class PlayDoneParams {
        public long endTimeUnix;
        public String errCodeString;
        public float playDurationFloat;
        public int reasonInt;

        public PlayDoneParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("reason", this.reasonInt);
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put("playduration", this.playDurationFloat);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("reason", this.reasonInt);
            aVar.a("etime", this.endTimeUnix);
            aVar.a("playduration", this.playDurationFloat);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.reasonInt = 0;
            this.endTimeUnix = 0L;
            this.playDurationFloat = 0.0f;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$PlayerInitParams.class */
    public class PlayerInitParams {
        public String errCodeString;
        public long playEndTimeUnix;
        public long playStarTimeUnix;

        public PlayerInitParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("stime", this.playStarTimeUnix);
                jSONObject.put("etime", this.playEndTimeUnix);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("stime", this.playStarTimeUnix);
            aVar.a("etime", this.playEndTimeUnix);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.playStarTimeUnix = 0L;
            this.playEndTimeUnix = 0L;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$RedirectParams.class */
    public class RedirectParams {
        public int cdnTypeInt;
        public long endTimeUnix;
        public String errCodeString;
        public int redirectCountInt;
        public String redirectedUrlString;
        public long starTimeUnix;

        public RedirectParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("etime", this.endTimeUnix);
                jSONObject.put("url", this.redirectedUrlString);
                jSONObject.put("vt", this.cdnTypeInt);
                jSONObject.put("t302", this.redirectCountInt);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("etime", this.endTimeUnix);
            aVar.a("url", this.redirectedUrlString);
            aVar.a("vt", this.cdnTypeInt);
            aVar.a("t302", this.redirectCountInt);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.redirectedUrlString = "";
            this.cdnTypeInt = 0;
            this.redirectCountInt = 0;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$UserSeekOnceParams.class */
    public class UserSeekOnceParams {
        public long endPresentTimeLong;
        public String errCodeString;
        public int formatInt;
        public long seekEndTimeUnix;
        public long seekStartTimeUnix;
        public long startPresentTimeLong;

        public UserSeekOnceParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("format", this.formatInt);
                jSONObject.put("pstime", this.startPresentTimeLong);
                jSONObject.put("petime", this.endPresentTimeLong);
                jSONObject.put("lstime", this.seekStartTimeUnix);
                jSONObject.put("letime", this.seekEndTimeUnix);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("format", this.formatInt);
            aVar.a("pstime", this.startPresentTimeLong);
            aVar.a("petime", this.endPresentTimeLong);
            aVar.a("lstime", this.seekStartTimeUnix);
            aVar.a("letime", this.seekEndTimeUnix);
            aVar.a("code", this.errCodeString);
        }

        public void reset() {
            this.startPresentTimeLong = 0L;
            this.endPresentTimeLong = 0L;
            this.seekStartTimeUnix = 0L;
            this.seekEndTimeUnix = 0L;
            this.errCodeString = "0";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$UserSeekTotalParams.class */
    public class UserSeekTotalParams {
        public int seekBufferingCountInt;
        public int seekBufferingDurationInt;
        public List<UserSeekOnceParams> seekOnceParamsList = new LinkedList();
        public int seekTotalCountInt;

        public UserSeekTotalParams() {
        }

        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("scount", this.seekTotalCountInt);
                jSONObject.put("tbcount", this.seekBufferingCountInt);
                jSONObject.put("tbduration", this.seekBufferingDurationInt);
                JSONArray jSONArray = new JSONArray();
                for (UserSeekOnceParams userSeekOnceParams : this.seekOnceParamsList) {
                    JSONObject jSONObject2 = new JSONObject();
                    userSeekOnceParams.paramsToJson(jSONObject2);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(TPReportParams.JSON_KEY_VAL, jSONArray);
            } catch (JSONException e) {
                TPLogUtil.e(TPReportParams.TAG, e);
            }
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("scount", this.seekTotalCountInt);
            aVar.a("tbcount", this.seekBufferingCountInt);
            aVar.a("tbduration", this.seekBufferingDurationInt);
        }

        public void reset() {
            this.seekTotalCountInt = 0;
            this.seekBufferingCountInt = 0;
            this.seekBufferingDurationInt = 0;
            this.seekOnceParamsList.clear();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/report/TPReportParams$VodExParam.class */
    public class VodExParam {
        int bizIdInt;
        int clipInt;
        int currentPlayInt;
        int freeTypeInt;
        int hasSubtitleInt;
        int hevcLcInt;
        int hitDownloaded;
        int isSelectedSubtitleInt;
        int multiTrackInt;
        int optimizedPlayInt;
        int statusInt;

        public VodExParam() {
        }

        public void paramsToJson(JSONObject jSONObject) {
        }

        public void paramsToProperties(com.tencent.thumbplayer.common.a.a aVar) {
            aVar.a("freetype", this.freeTypeInt);
            aVar.a("currentplay", this.currentPlayInt);
            aVar.a("optimizedplay", this.optimizedPlayInt);
            aVar.a("subtitles", this.hasSubtitleInt);
            aVar.a("selsubtitles", this.isSelectedSubtitleInt);
            aVar.a("multitrack", this.multiTrackInt);
            aVar.a("bizid", this.bizIdInt);
            aVar.a("hevclv", this.hevcLcInt);
            aVar.a("clip", this.clipInt);
            aVar.a("status", this.statusInt);
            aVar.a("hitdownloaded", this.hitDownloaded);
        }

        public void reset() {
        }
    }

    public TPReportParams() {
        this.commonParams.reset();
        this.initParams.reset();
        this.getCdnParams.reset();
        this.firstLoadParams.reset();
        this.firstRenderParams.reset();
        this.loadSubtitleParams.reset();
        this.redirectParams.reset();
        this.bufferingTotalParams.reset();
        this.userSeekTotalParams.reset();
        this.playDoneParams.reset();
    }

    public BufferingOnceParams createBufferingOnceParams() {
        return new BufferingOnceParams();
    }

    public UserSeekOnceParams createUserSeekOnceParams() {
        return new UserSeekOnceParams();
    }

    public BufferingTotalParams getBufferingTotalParams() {
        return this.bufferingTotalParams;
    }

    public CommonParams getCommonParams() {
        return this.commonParams;
    }

    public FirstLoadParams getFirstLoadParams() {
        return this.firstLoadParams;
    }

    public FirstRenderParams getFirstRenderParams() {
        return this.firstRenderParams;
    }

    public GetCdnUrlParams getGetCdnParams() {
        return this.getCdnParams;
    }

    public PlayerInitParams getInitParams() {
        return this.initParams;
    }

    public LiveExParam getLiveExParam() {
        return this.liveExParam;
    }

    public LoadSubtitleParams getLoadSubtitleParams() {
        return this.loadSubtitleParams;
    }

    public PlayDoneParams getPlayDoneParams() {
        return this.playDoneParams;
    }

    public RedirectParams getRedirectParams() {
        return this.redirectParams;
    }

    public UserSeekTotalParams getUserSeekTotalParams() {
        return this.userSeekTotalParams;
    }

    public VodExParam getVodExParam() {
        return this.vodExParam;
    }

    public void resetAllParam() {
        this.commonParams.reset();
        this.firstLoadParams.reset();
        this.firstRenderParams.reset();
        this.loadSubtitleParams.reset();
        this.getCdnParams.reset();
        this.redirectParams.reset();
        this.bufferingTotalParams.reset();
        this.userSeekTotalParams.reset();
        this.playDoneParams.reset();
        this.liveExParam.reset();
        this.vodExParam.reset();
    }
}
