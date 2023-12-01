package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/BaseWrapper.class */
public class BaseWrapper extends OapsWrapper {
    public static final String BASE_PKG_MEDIA = "com.android.providers.media";
    public static final String BASE_PKG_SYSTEM = "android";
    public static final String ENTER_ID_17 = "17";
    public static final String ENTER_ID_18 = "18";
    public static final String ENTER_ID_19 = "19";
    public static final String ENTER_ID_AD_SDK = "14";
    public static final String ENTER_ID_APP = "4";
    public static final String ENTER_ID_BROWSER = "6";
    public static final String ENTER_ID_COST = "8";
    public static final String ENTER_ID_DESKTOP = "7";
    public static final String ENTER_ID_DESKTOP_LAUNCHER = "10";
    public static final String ENTER_ID_GAME_CENTER = "13";
    public static final String ENTER_ID_GAME_SDK = "11";
    public static final String ENTER_ID_MARKET = "12";
    public static final String ENTER_ID_MESSAGE = "9";
    public static final String ENTER_ID_OAPS_ASSISTANT_SCREEN = "34";
    public static final String ENTER_ID_OAPS_CLOUD = "43";
    public static final String ENTER_ID_OAPS_DEMO = "31";
    public static final String ENTER_ID_OAPS_FLOWMARKET = "36";
    public static final String ENTER_ID_OAPS_GAMESPACE = "37";
    public static final String ENTER_ID_OAPS_HEYTAPMULTIAPP = "46";
    public static final String ENTER_ID_OAPS_INSTANT = "41";
    public static final String ENTER_ID_OAPS_OPEN_GUIDE = "42";
    public static final String ENTER_ID_OAPS_PHONEMANAGER = "40";
    public static final String ENTER_ID_OAPS_RECENTS = "45";
    public static final String ENTER_ID_OAPS_ROAMING = "33";
    public static final String ENTER_ID_OAPS_SCANNER = "39";
    public static final String ENTER_ID_OAPS_SECUREPAY = "44";
    public static final String ENTER_ID_OAPS_SPEECH_ASSIST = "35";
    public static final String ENTER_ID_OAPS_SYS_CRASH = "38";
    public static final String ENTER_ID_OAPS_WEATHER = "32";
    public static final String ENTER_ID_SECURITY_CENTER = "5";
    public static final String ENTER_ID_SHORTCUT = "23";
    public static final String ENTER_ID_SYSTEM_DIRECT_SERVICE = "21";
    public static final String ENTER_ID_SYSTEM_HELPER = "20";
    public static final String ENTER_ID_SYSTEM_SIM_SETTING = "22";
    public static final String ENTER_ID_TOOLKIT = "30";
    public static final String ENTER_ID_WAP_GAME_SDK = "16";
    public static final String ENTER_ID_WAP_MARKET_SDK = "15";
    public static final String GO_BACK_NO = "0";
    public static final String GO_BACK_YES = "1";
    public static final String GO_BACK_YES_NOT_INTERCEPT = "2";
    @Deprecated
    public static final String SIGN_TYPE_SYSTEM = "1";

    public BaseWrapper(Map<String, Object> map) {
        super(map);
    }

    public static BaseWrapper wrapper(Map<String, Object> map) {
        return new BaseWrapper(map);
    }

    protected BaseWrapper a(byte[] bArr) {
        return (BaseWrapper) set("content", bArr);
    }

    protected byte[] a() {
        try {
            return (byte[]) get("content");
        } catch (ag e) {
            return null;
        }
    }

    public String getBasePkg() {
        try {
            return (String) get(OapsKey.KEY_BASE_PKG);
        } catch (ag e) {
            return "";
        }
    }

    public String getCallbackKey() {
        try {
            return (String) get(OapsKey.KEY_CALLBACK_KEY);
        } catch (ag e) {
            return "";
        }
    }

    public String getCallingPkg() {
        try {
            return (String) get(OapsKey.KEY_CALLING_PKG);
        } catch (ag e) {
            return "";
        }
    }

    public String getEnterId() {
        try {
            return (String) get("enterId");
        } catch (ag e) {
            return "";
        }
    }

    public String getEnterModule() {
        try {
            return (String) get(OapsKey.KEY_ENTER_MODULE);
        } catch (ag e) {
            return "";
        }
    }

    public String getEnterModule2() {
        try {
            return (String) get(OapsKey.KEY_ENTER_MODULE2);
        } catch (ag e) {
            return "";
        }
    }

    public String getExtModule() {
        try {
            return (String) get(OapsKey.KEY_EXT_MODULE);
        } catch (ag e) {
            return "";
        }
    }

    public String getGoBack() {
        try {
            return (String) get(OapsKey.KEY_GOBACK);
        } catch (ag e) {
            return "";
        }
    }

    public String getSecret() {
        try {
            return (String) get("secret");
        } catch (ag e) {
            return "";
        }
    }

    @Deprecated
    public String getSignType() {
        try {
            return (String) get(OapsKey.KEY_SIGN_TYPE);
        } catch (ag e) {
            return "";
        }
    }

    public BaseWrapper setBasePkg(String str) {
        return (BaseWrapper) set(OapsKey.KEY_BASE_PKG, str);
    }

    public BaseWrapper setCallbackKey(String str) {
        return (BaseWrapper) set(OapsKey.KEY_CALLBACK_KEY, str);
    }

    public BaseWrapper setCallingPkg(String str) {
        return (BaseWrapper) set(OapsKey.KEY_CALLING_PKG, str);
    }

    public BaseWrapper setEnterId(String str) {
        return (BaseWrapper) set("enterId", str);
    }

    public BaseWrapper setEnterModule(String str) {
        return (BaseWrapper) set(OapsKey.KEY_ENTER_MODULE, str);
    }

    public BaseWrapper setEnterModule2(String str) {
        return (BaseWrapper) set(OapsKey.KEY_ENTER_MODULE2, str);
    }

    public BaseWrapper setExtModule(String str) {
        return (BaseWrapper) set(OapsKey.KEY_EXT_MODULE, str);
    }

    public BaseWrapper setGoBack(String str) {
        return (BaseWrapper) set(OapsKey.KEY_GOBACK, str);
    }

    public BaseWrapper setSecret(String str) {
        return (BaseWrapper) set("secret", str);
    }

    @Deprecated
    public BaseWrapper setSignType(String str) {
        return (BaseWrapper) set(OapsKey.KEY_SIGN_TYPE, str);
    }
}
