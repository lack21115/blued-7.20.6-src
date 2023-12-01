package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bo.class */
public abstract class bo {
    public static int Code(int i) {
        int i2;
        if (i == -1) {
            i2 = 1006;
        } else if (i == 200) {
            return 1000;
        } else {
            if (i == 204) {
                return 1005;
            }
            if (i == 496) {
                return 1007;
            }
            i2 = 1001;
            if (i != 498) {
                i2 = 1001;
                if (i != 804) {
                    if (i != 1001) {
                        if (i != 1100) {
                            if (i != 704) {
                                if (i != 705) {
                                    if (i != 801) {
                                        if (i != 802) {
                                            switch (i) {
                                                case 700:
                                                    return 1005;
                                                case 701:
                                                    return 1004;
                                                case 702:
                                                    return 1003;
                                                default:
                                                    switch (i) {
                                                        case 900:
                                                            return 1005;
                                                        case 901:
                                                            return 1004;
                                                        case 902:
                                                            return 1003;
                                                        default:
                                                            return 1010;
                                                    }
                                            }
                                        }
                                        return 1003;
                                    }
                                    return 1004;
                                }
                                return 1009;
                            }
                            return 1008;
                        }
                        return 1005;
                    }
                    return 1002;
                }
            }
        }
        return i2;
    }
}
