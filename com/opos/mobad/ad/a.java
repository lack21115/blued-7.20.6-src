package com.opos.mobad.ad;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/a.class */
public class a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final String a(int i) {
        String str;
        if (i == 10003) {
            str = "now time over ad expire time.";
        } else if (i == 10006) {
            return "interstitial ad data is null.";
        } else {
            if (i == 10010) {
                return "ad has loaded,but not ready to show";
            }
            if (i == 10208) {
                return "splash ad render failed.";
            }
            str = "unknown creative.";
            if (i != 10600) {
                if (i != 11001) {
                    switch (i) {
                        case 10400:
                            return "no stream video to play.";
                        case 10401:
                            return "no local cached video to play.";
                        case 10402:
                            return "no video to play.";
                        case 10403:
                            return "no net,can't play video.";
                        case 10404:
                            return "video has expired.";
                        default:
                            str = "unknown creative.";
                            switch (i) {
                                case 10407:
                                    return "unsupported play mode.";
                                case 10408:
                                    return "video not cached.";
                                case 10409:
                                    break;
                                default:
                                    str = "unknown creative.";
                                    switch (i) {
                                        case 10500:
                                            return "get adView is null.";
                                        case 10501:
                                            break;
                                        case 10502:
                                            return "The bottomArea view already has a parent..please not attachToRoot";
                                        default:
                                            switch (i) {
                                                case 11003:
                                                    return "you request ad too often.";
                                                case 11004:
                                                    return "you should't play ad on the top in the shaped screen mobile";
                                                case 11005:
                                                    return "ads must display on android version after19";
                                                default:
                                                    return "unknown error.";
                                            }
                                    }
                            }
                    }
                } else {
                    return "ad has destroyed.";
                }
            }
        }
        return str;
    }
}
