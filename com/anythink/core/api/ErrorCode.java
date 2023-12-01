package com.anythink.core.api;

import com.android.internal.telephony.SmsConstants;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ErrorCode.class */
public class ErrorCode {
    public static final String adShowError = "4006";
    public static final String adSourceBidError = "4007";
    public static final String adSourceNotFilledError = "4008";
    public static final String adapterInnerError = "2006";
    public static final String adapterNotExistError = "2002";
    public static final String appIdError = "10003";
    public static final String appIdOrPlaceIdEmpty = "3002";
    public static final String appKeyError = "10001";
    public static final String c2sBiddingCacheError = "2012";
    public static final String contextDestoryError = "4002";
    public static final String dataLevelLowError = "9992";
    public static final String exception = "9999";
    public static final String filterSourceError = "2010";
    public static final String formatError = "3003";
    public static final String httpStatuException = "9990";
    public static final String inNetworkErrorCodeRequestFailPacing = "2014";
    public static final String inPacingError = "2004";
    public static final String inRequestFailPacing = "2007";
    public static final String loadCappingError = "2009";
    public static final String loadFailInPacingError = "2008";
    public static final String loadInShowingFilter = "2011";
    public static final String loadingError = "2005";
    public static final String networkError = "1001";
    public static final String networkFirmIdfilterSourceError = "2013";
    public static final String noADError = "4001";
    public static final String noAdsourceConfig = "4004";
    public static final String noAdsourceConfigInDebugerMode = "4009";
    public static final String noAvailableAdsource = "4005";
    public static final String outOfCapError = "2003";
    public static final String placeStrategyError = "3001";
    public static final String placementAdClose = "4003";
    public static final String placementIdError = "10004";
    public static final String serverError = "1002";
    public static final String statuError = "9991";
    public static final String timeOutError = "2001";
    public static final String unknown = "-9999";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static AdError getErrorCode(String str, String str2, String str3) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == 1754688) {
            if (str.equals(exception)) {
                z = false;
            }
            z = true;
        } else if (hashCode != 46730162) {
            switch (hashCode) {
                case 1507424:
                    if (str.equals(networkError)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1507425:
                    if (str.equals(serverError)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    switch (hashCode) {
                        case 1537215:
                            if (str.equals(timeOutError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537216:
                            if (str.equals("2002")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537217:
                            if (str.equals(outOfCapError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537218:
                            if (str.equals(inPacingError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537219:
                            if (str.equals(loadingError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537220:
                            if (str.equals(adapterInnerError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537221:
                            if (str.equals(inRequestFailPacing)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537222:
                            if (str.equals(loadFailInPacingError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1537223:
                            if (str.equals(loadCappingError)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            switch (hashCode) {
                                case 1537246:
                                    if (str.equals(loadInShowingFilter)) {
                                        z = true;
                                        break;
                                    }
                                    z = true;
                                    break;
                                case 1537247:
                                    if (str.equals(c2sBiddingCacheError)) {
                                        z = true;
                                        break;
                                    }
                                    z = true;
                                    break;
                                case 1537248:
                                    if (str.equals(networkFirmIdfilterSourceError)) {
                                        z = true;
                                        break;
                                    }
                                    z = true;
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 1567006:
                                            if (str.equals(placeStrategyError)) {
                                                z = true;
                                                break;
                                            }
                                            z = true;
                                            break;
                                        case 1567007:
                                            if (str.equals(appIdOrPlaceIdEmpty)) {
                                                z = true;
                                                break;
                                            }
                                            z = true;
                                            break;
                                        case 1567008:
                                            if (str.equals(formatError)) {
                                                z = true;
                                                break;
                                            }
                                            z = true;
                                            break;
                                        default:
                                            switch (hashCode) {
                                                case 1596797:
                                                    if (str.equals(noADError)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596798:
                                                    if (str.equals(contextDestoryError)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596799:
                                                    if (str.equals(placementAdClose)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596800:
                                                    if (str.equals(noAdsourceConfig)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596801:
                                                    if (str.equals(noAvailableAdsource)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596802:
                                                    if (str.equals(adShowError)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596803:
                                                    if (str.equals(adSourceBidError)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596804:
                                                    if (str.equals(adSourceNotFilledError)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                case 1596805:
                                                    if (str.equals(noAdsourceConfigInDebugerMode)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    z = true;
                                                    break;
                                                default:
                                                    switch (hashCode) {
                                                        case 1754679:
                                                            if (str.equals(httpStatuException)) {
                                                                z = true;
                                                                break;
                                                            }
                                                            z = true;
                                                            break;
                                                        case 1754680:
                                                            if (str.equals(statuError)) {
                                                                z = true;
                                                                break;
                                                            }
                                                            z = true;
                                                            break;
                                                        case 1754681:
                                                            if (str.equals(dataLevelLowError)) {
                                                                z = true;
                                                                break;
                                                            }
                                                            z = true;
                                                            break;
                                                        default:
                                                            switch (hashCode) {
                                                                case 46730164:
                                                                    if (str.equals(appIdError)) {
                                                                        z = true;
                                                                        break;
                                                                    }
                                                                    z = true;
                                                                    break;
                                                                case 46730165:
                                                                    if (str.equals(placementIdError)) {
                                                                        z = true;
                                                                        break;
                                                                    }
                                                                    z = true;
                                                                    break;
                                                                default:
                                                                    z = true;
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            if (str.equals("10001")) {
                z = true;
            }
            z = true;
        }
        switch (z) {
            case false:
                return new AdError(exception, "Exception in sdk.", str2, str3);
            case true:
                return new AdError(httpStatuException, "Https status exception.", str2, str3);
            case true:
                return new AdError(statuError, "Service status error.", str2, str3);
            case true:
                return new AdError(dataLevelLowError, "Upload data level is FORBIDDEN, must called 'ATSDK.setGDPRUploadDataLevel' to set the level.", str2, str3);
            case true:
                return new AdError(networkError, "Network is unavailable.", str2, str3);
            case true:
                return new AdError(serverError, "Server is unavailable.", str2, str3);
            case true:
                return new AdError(timeOutError, "Ad load time out.", str2, str3);
            case true:
                return new AdError("2002", "Adapter does not exist.", str2, str3);
            case true:
                return new AdError(outOfCapError, "Not satisfy the Placement's Cap configuration.", str2, str3);
            case true:
                return new AdError(noADError, "Return Ad is empty.", str2, str3);
            case true:
                return new AdError(placeStrategyError, "Get placement strategy error, please check your network or your appid、appkey and placementid is availiable.", str2, str3);
            case true:
                return new AdError(loadingError, "Placement's Ad is loading.", str2, str3);
            case true:
                return new AdError(inPacingError, "Not satisfy the Placement's Placing configuration.", str2, str3);
            case true:
                return new AdError(contextDestoryError, "Context or activity has been destory.", str2, str3);
            case true:
                return new AdError(appIdOrPlaceIdEmpty, "AppId or PlacementId is empty.", str2, str3);
            case true:
                return new AdError(formatError, "Mismatched ad placement and ad format", str2, str3);
            case true:
                return new AdError(placementAdClose, "Placement Ads switch is close.", str2, str3);
            case true:
                return new AdError(noAdsourceConfig, "The placement strategy does not contain any ad sources, please check the mediation configuration in TopOn", str2, str3);
            case true:
                return new AdError(adapterInnerError, "Please check if your network sdk version is correct and all the network plugin has been put in your package.", str2, str3);
            case true:
                return new AdError("10001", "Please check your appkey.", str2, str3);
            case true:
                return new AdError(appIdError, "Please check your appid.", str2, str3);
            case true:
                return new AdError(placementIdError, "Please check your placementid.", str2, str3);
            case true:
                return new AdError(noAvailableAdsource, "Ad sources are filtered, no ad source is currently available", str2, str3);
            case true:
                return new AdError(adShowError, "Ad show failed", str2, str3);
            case true:
                return new AdError(inRequestFailPacing, "Not satisfy the Fail-request's Placing configuration.", str2, str3);
            case true:
                return new AdError(loadFailInPacingError, "The placement load too frequent within the specified time period after the previous load failure.", str2, str3);
            case true:
                return new AdError(loadCappingError, "The placement load too many times within the specified time period.", str2, str3);
            case true:
                return new AdError(loadInShowingFilter, "This unitgroup can't load on showing.", str2, str3);
            case true:
                return new AdError(adSourceBidError, "Bid error", str2, str3);
            case true:
                return new AdError(adSourceNotFilledError, "Ad source not filled, cause by customize fillter.", str2, str3);
            case true:
                return new AdError(c2sBiddingCacheError, "C2S Bidding Cache error.", str2, str3);
            case true:
                return new AdError(noAdsourceConfigInDebugerMode, "The placement strategy does not contain any ad sources, please check the debugger configuration in ATSDK.setDebuggerConfig", str2, str3);
            case true:
                return new AdError(noAdsourceConfigInDebugerMode, "AdSource filter by network firm id.", str2, str3);
            default:
                return new AdError("-9999", SmsConstants.FORMAT_UNKNOWN, str2, str3);
        }
    }
}
