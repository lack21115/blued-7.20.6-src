package com.ishumei.smantifraud;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l1111l111111Il.l11l1111I1l;
import com.ishumei.l1111l111111Il.l11l1111lIIl;
import com.ishumei.l111l1111llIl.l111l11111lIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/smantifraud/SmAntiFraud.class */
public class SmAntiFraud {
    public static final String AREA_BJ = "bj";
    public static final String AREA_FJNY = "fjny";
    public static final String AREA_XJP = "xjp";
    public static final String BUILD = "b8";
    public static final int SM_AF_ASYN_MODE = 1;
    public static final int SM_AF_SYN_MODE = 0;
    private static final String l1111l111111Il = "sm";
    private static IServerSmidCallback l111l11111lIl;
    public static SmOption option;

    /* renamed from: com.ishumei.smantifraud.SmAntiFraud$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/smantifraud/SmAntiFraud$1.class */
    static final class AnonymousClass1 implements Runnable {
        private /* synthetic */ String l1111l111111Il;

        AnonymousClass1(String str) {
            this.l1111l111111Il = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IServerSmidCallback iServerSmidCallback = SmAntiFraud.l111l11111lIl;
            iServerSmidCallback.onSuccess("B" + this.l1111l111111Il);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/smantifraud/SmAntiFraud$IDeviceIdCallback.class */
    public interface IDeviceIdCallback {
        void onResult(String str);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/smantifraud/SmAntiFraud$IServerSmidCallback.class */
    public interface IServerSmidCallback {
        void onError(int i);

        void onSuccess(String str);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/smantifraud/SmAntiFraud$SmOption.class */
    public static class SmOption {
        private static final int l1111l111111Il = 1024;
        private String l111l1111lI1l;
        private String l111l1111lIl;
        private String l111l11IlIlIl;
        private Set<String> l11l1111I1ll;
        private boolean l11l1111Il;
        private byte[] l11l11IlIIll;
        private boolean l111l11111lIl = false;
        private String l111l11111I1l = "";
        private String l111l11111Il = "";
        private boolean l111l1111l1Il = true;
        private boolean l111l1111llIl = true;
        private boolean l11l1111lIIl = false;
        private boolean l11l1111I11l = false;
        private IServerSmidCallback l11l1111I1l = null;
        private String l11l1111Il1l = "default";
        private String l11l1111Ill = null;
        private boolean l11l111l11Il = false;
        private String l11l111l1lll = SmAntiFraud.AREA_BJ;

        public SmOption() {
            this.l111l1111lI1l = null;
            this.l111l1111lIl = null;
            this.l111l1111lI1l = "/deviceprofile/v4";
            this.l111l1111lIl = "/v3/cloudconf";
        }

        private boolean l111l11IlIlIl() {
            return this.l11l1111Il;
        }

        private boolean l11l111l1lll() {
            return this.l111l11111lIl;
        }

        public final String l1111l111111Il() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.l111l1111l1Il ? "1" : "0");
            sb.append(this.l111l1111llIl ? "1" : "0");
            sb.append(this.l11l1111lIIl ? "1" : "0");
            sb.append(this.l11l1111I11l ? "1" : "0");
            sb.append(SmAntiFraud.l111l11111lIl != null ? "1" : "0");
            Set<String> set = this.l11l1111I1ll;
            sb.append((set == null || set.size() <= 0) ? "0" : "1");
            sb.append(this.l11l111l11Il ? "1" : "0");
            return sb.toString();
        }

        public final boolean l111l11111I1l() {
            return this.l11l1111I11l;
        }

        public final boolean l111l11111Il() {
            return this.l11l111l11Il;
        }

        public final String l111l11111lIl() {
            return this.l11l111l1lll;
        }

        public final byte[] l111l1111l1Il() {
            return this.l11l11IlIIll;
        }

        public final IServerSmidCallback l111l1111lI1l() {
            return this.l11l1111I1l;
        }

        public final String l111l1111lIl() {
            return this.l111l1111lIl;
        }

        public final String l111l1111llIl() {
            return this.l11l1111Ill;
        }

        public final boolean l11l1111I11l() {
            return this.l111l1111llIl;
        }

        public final boolean l11l1111I1l() {
            return this.l111l1111l1Il;
        }

        public final String l11l1111I1ll() {
            return this.l111l11111I1l;
        }

        public final String l11l1111Il() {
            return this.l111l11111Il;
        }

        public final String l11l1111Il1l() {
            return this.l111l1111lI1l;
        }

        public final Set<String> l11l1111Ill() {
            return this.l11l1111I1ll;
        }

        public final boolean l11l1111lIIl() {
            return this.l11l1111lIIl;
        }

        public final String l11l111l11Il() {
            return this.l111l11IlIlIl;
        }

        public final String l11l11IlIIll() {
            return this.l11l1111Il1l;
        }

        public void setAppId(String str) {
            this.l11l1111Il1l = str;
        }

        public void setArea(String str) {
            this.l11l111l1lll = str;
        }

        public void setChannel(String str) {
            this.l111l11111Il = str;
        }

        public void setCheckCrt(boolean z) {
            this.l11l111l11Il = z;
        }

        public void setCloudConf(boolean z) {
            this.l111l1111llIl = z;
        }

        public void setConfUrl(String str) {
            this.l111l1111lIl = str;
        }

        public void setExtraInfo(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                this.l111l11IlIlIl = str.substring(0, 1024);
            } else {
                this.l111l11IlIlIl = str;
            }
        }

        public void setFirst(boolean z) {
            this.l11l1111Il = z;
        }

        public void setHttpsCrt(byte[] bArr) {
            this.l11l11IlIIll = bArr;
        }

        public void setNotCollect(Set<String> set) {
            this.l11l1111I1ll = set;
        }

        public void setOrganization(String str) {
            this.l111l11111I1l = str;
        }

        public void setPublicKey(String str) {
            this.l11l1111Ill = str;
        }

        public void setServerIdCallback(IServerSmidCallback iServerSmidCallback) {
            this.l11l1111I1l = iServerSmidCallback;
        }

        public void setSynMode(boolean z) {
            this.l111l11111lIl = z;
        }

        public void setTransport(boolean z) {
            this.l111l1111l1Il = z;
        }

        public void setUrl(String str) {
            this.l111l1111lI1l = str;
        }

        public void setUsingHttps(boolean z) {
            this.l11l1111I11l = z;
        }

        public void setUsingMD5(boolean z) {
            this.l11l1111lIIl = z;
        }
    }

    private SmAntiFraud() {
    }

    public static void create(Context context, SmOption smOption) {
        synchronized (SmAntiFraud.class) {
            if (smOption != null) {
                try {
                    if (!TextUtils.isEmpty(smOption.l11l1111I1ll())) {
                        if (TextUtils.isEmpty(smOption.l111l1111llIl())) {
                            Log.e(l1111l111111Il, l111l1111lI1l.l111l11111Il("8f8a9d93969cb49a86df979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1"));
                            return;
                        }
                        if (TextUtils.isEmpty(smOption.l11l11IlIIll())) {
                            Log.e(l1111l111111Il, l111l1111lI1l.l111l11111Il("9e8f8fb69bdf979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1"));
                        }
                        try {
                            l111l11111lIl.l1111l111111Il().l111l11111lIl();
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext == null) {
                                l111l11111lIl.l1111l111111Il().l111l11111I1l();
                                return;
                            }
                            l111l1111llIl.l1111l111111Il.l111l11111Il = applicationContext;
                            if (l111l1111llIl.l1111l111111Il.l111l1111l1Il == null) {
                                l111l1111llIl.l1111l111111Il.l111l1111l1Il = String.format(Locale.CHINA, "%d-%05d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100000)));
                            }
                            option = smOption;
                            String l111l11111lIl2 = smOption.l111l11111lIl();
                            boolean z = true;
                            int hashCode = l111l11111lIl2.hashCode();
                            if (hashCode != 3144) {
                                if (hashCode != 118718) {
                                    if (hashCode == 3144079 && l111l11111lIl2.equals(AREA_FJNY)) {
                                        z = true;
                                    }
                                } else if (l111l11111lIl2.equals(AREA_XJP)) {
                                    z = true;
                                }
                            } else if (l111l11111lIl2.equals(AREA_BJ)) {
                                z = false;
                            }
                            String[] strArr = z ? !z ? !z ? new String[]{option.l11l1111Il1l(), option.l111l11111lIl()} : com.ishumei.l111l11111lIl.l111l1111llIl.l111l11111I1l : com.ishumei.l111l11111lIl.l111l1111llIl.l111l11111lIl : com.ishumei.l111l11111lIl.l111l1111llIl.l1111l111111Il;
                            SmOption smOption2 = option;
                            l111l1111llIl.l1111l111111Il();
                            smOption2.setUrl(l111l1111llIl.l1111l111111Il(strArr[0], option.l11l1111Il1l(), option.l111l11111I1l()));
                            SmOption smOption3 = option;
                            l111l1111llIl.l1111l111111Il();
                            smOption3.setConfUrl(l111l1111llIl.l1111l111111Il(strArr[0], option.l111l1111lIl(), option.l111l11111I1l()));
                            l11l1111I1l.l1111l111111Il().l1111l111111Il(strArr[1], option.l11l1111I1ll());
                            com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(smOption);
                            com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l1111l111111Il(smOption);
                            if (option.l111l1111lI1l() != null) {
                                l111l11111lIl = option.l111l1111lI1l();
                            }
                            String l111l11111lIl3 = l11l1111I1l.l1111l111111Il().l111l11111lIl();
                            if (!TextUtils.isEmpty(l111l11111lIl3) && l111l11111lIl != null) {
                                synchronized (SmAntiFraud.class) {
                                    try {
                                        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new AnonymousClass1(l111l11111lIl3), 2);
                                    } finally {
                                    }
                                }
                            }
                            if (com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl()) {
                                l111l1111llIl.l1111l111111Il().l111l11111lIl();
                            }
                            l111l11111lIl.l1111l111111Il().l111l11111I1l();
                            return;
                        } catch (Exception e) {
                            l111l11111lIl.l1111l111111Il().l111l11111I1l();
                            return;
                        } catch (Throwable th) {
                            l111l11111lIl.l1111l111111Il().l111l11111I1l();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            Log.e(l1111l111111Il, l111l1111lI1l.l111l11111Il("ac92b08f8b969091df9e919bdf908d989e9196859e8b969091df9c908a939bdf91908bdf9d9adf918a9393d1"));
        }
    }

    public static String getDeviceId() {
        String str;
        SmOption smOption = option;
        if (smOption == null) {
            str = "ac92be918b96b98d9e8a9bd19c8d9a9e8b9adf979e8cdf91908bdf9d9a9a91df9c9e93939a9bdf869a8bd1";
        } else if (TextUtils.isEmpty(smOption.l11l1111I1ll())) {
            str = "908d989e9196859e8b969091df979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1";
        } else if (!TextUtils.isEmpty(option.l111l1111llIl())) {
            if (TextUtils.isEmpty(option.l11l11IlIIll())) {
                str = "9e8f8fb69bdf979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1";
            }
            return l111l1111llIl.l1111l111111Il().l111l11111I1l();
        } else {
            str = "8f8a9d93969cb49a86df979e8cdf91908bdf9d9a9a91df8c9a8bdf869a8bd1";
        }
        Log.e(l1111l111111Il, l111l1111lI1l.l111l11111Il(str));
        return l111l1111llIl.l1111l111111Il().l111l11111I1l();
    }

    public static void getDeviceId(IDeviceIdCallback iDeviceIdCallback) {
        if (iDeviceIdCallback == null) {
            throw new IllegalArgumentException("callback cannot be null.");
        }
        l111l1111llIl.l1111l111111Il().l1111l111111Il(iDeviceIdCallback, Thread.currentThread() == Looper.getMainLooper().getThread());
    }

    public static String getSDKVersion() {
        return "3.0.6";
    }

    public static IServerSmidCallback getServerIdCallback() {
        return l111l11111lIl;
    }

    private static void l1111l111111Il(SmOption smOption) {
        l111l11111lIl(smOption);
        String l111l11111lIl2 = l11l1111I1l.l1111l111111Il().l111l11111lIl();
        if (!TextUtils.isEmpty(l111l11111lIl2) && l111l11111lIl != null) {
            synchronized (SmAntiFraud.class) {
                try {
                    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new AnonymousClass1(l111l11111lIl2), 2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl()) {
            l111l1111llIl.l1111l111111Il().l111l11111lIl();
        }
    }

    private static void l111l11111lIl(SmOption smOption) {
        boolean z;
        option = smOption;
        String l111l11111lIl2 = smOption.l111l11111lIl();
        int hashCode = l111l11111lIl2.hashCode();
        if (hashCode == 3144) {
            if (l111l11111lIl2.equals(AREA_BJ)) {
                z = false;
            }
            z = true;
        } else if (hashCode != 118718) {
            if (hashCode == 3144079 && l111l11111lIl2.equals(AREA_FJNY)) {
                z = true;
            }
            z = true;
        } else {
            if (l111l11111lIl2.equals(AREA_XJP)) {
                z = true;
            }
            z = true;
        }
        String[] strArr = z ? !z ? !z ? new String[]{option.l11l1111Il1l(), option.l111l11111lIl()} : com.ishumei.l111l11111lIl.l111l1111llIl.l111l11111I1l : com.ishumei.l111l11111lIl.l111l1111llIl.l111l11111lIl : com.ishumei.l111l11111lIl.l111l1111llIl.l1111l111111Il;
        SmOption smOption2 = option;
        l111l1111llIl.l1111l111111Il();
        smOption2.setUrl(l111l1111llIl.l1111l111111Il(strArr[0], option.l11l1111Il1l(), option.l111l11111I1l()));
        SmOption smOption3 = option;
        l111l1111llIl.l1111l111111Il();
        smOption3.setConfUrl(l111l1111llIl.l1111l111111Il(strArr[0], option.l111l1111lIl(), option.l111l11111I1l()));
        l11l1111I1l.l1111l111111Il().l1111l111111Il(strArr[1], option.l11l1111I1ll());
        com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(smOption);
        com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l1111l111111Il(smOption);
        if (option.l111l1111lI1l() != null) {
            l111l11111lIl = option.l111l1111lI1l();
        }
    }

    public static void registerServerIdCallback(IServerSmidCallback iServerSmidCallback) {
        synchronized (SmAntiFraud.class) {
            try {
                l111l11111lIl = iServerSmidCallback;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void track(String str, String str2, MotionEvent motionEvent) {
        l11l1111lIIl.l1111l111111Il().l1111l111111Il(str, str2, motionEvent);
    }
}
