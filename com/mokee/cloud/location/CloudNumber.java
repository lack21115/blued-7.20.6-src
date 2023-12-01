package com.mokee.cloud.location;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mokee.cloud.misc.CloudUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.Callable;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/CloudNumber.class */
public class CloudNumber {
    private static final String[] a = null;
    public static boolean b;
    private static boolean c;
    private static String d;
    private static String e;
    private static int f;
    private static int g;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/CloudNumber$Callback.class */
    public interface Callback {
        void onResult(String str, String str2, PhoneType phoneType, EngineType engineType);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/CloudNumber$EngineType.class */
    public static final class EngineType {
        public static final EngineType OFFLINE = null;
        public static final EngineType ONLINE = null;
        private static final /* synthetic */ EngineType[] a = null;
        private static final String[] b = null;

        static {
            String[] strArr = new String[2];
            throw new VerifyError("bad dex opcode");
        }

        private EngineType(String str, int i) {
        }

        public static EngineType valueOf(String str) {
            return (EngineType) Enum.valueOf(EngineType.class, str);
        }

        public static EngineType[] values() {
            EngineType[] engineTypeArr = a;
            int length = engineTypeArr.length;
            EngineType[] engineTypeArr2 = new EngineType[length];
            System.arraycopy(engineTypeArr, 0, engineTypeArr2, 0, length);
            return engineTypeArr2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/CloudNumber$PhoneType.class */
    public static final class PhoneType {
        public static final PhoneType ADVERTISEMENT = null;
        public static final PhoneType FRAUD = null;
        public static final PhoneType HARASS = null;
        public static final PhoneType NORMAL = null;
        private static final /* synthetic */ PhoneType[] a = null;
        private static final String[] b = null;

        static {
            String[] strArr = new String[4];
            throw new VerifyError("bad dex opcode");
        }

        private PhoneType(String str, int i) {
        }

        public static PhoneType valueOf(String str) {
            return (PhoneType) Enum.valueOf(PhoneType.class, str);
        }

        public static PhoneType[] values() {
            PhoneType[] phoneTypeArr = a;
            int length = phoneTypeArr.length;
            PhoneType[] phoneTypeArr2 = new PhoneType[length];
            System.arraycopy(phoneTypeArr, 0, phoneTypeArr2, 0, length);
            return phoneTypeArr2;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/location/CloudNumber$a.class */
    class a implements Callable<Object> {
        private static final String[] a = null;
        private final /* synthetic */ String val$formatNumber;
        private final /* synthetic */ boolean val$longRequest;

        static {
            String[] strArr = new String[8];
            throw new VerifyError("bad dex opcode");
        }

        a(String str, boolean z) {
            this.val$formatNumber = str;
            this.val$longRequest = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format(Locale.getDefault(), CloudNumber.e, this.val$formatNumber)).openConnection();
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    httpURLConnection.setRequestProperty(a[2], a[5]);
                    httpURLConnection.setRequestProperty(a[0], a[6]);
                    try {
                        httpURLConnection.setConnectTimeout(this.val$longRequest ? CloudNumber.g : CloudNumber.f);
                        httpURLConnection.setReadTimeout(this.val$longRequest ? CloudNumber.g : CloudNumber.f);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            try {
                                if (readLine == null) {
                                    try {
                                        break;
                                    } catch (Exception e) {
                                        throw e;
                                    }
                                }
                                sb.append(readLine);
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        inputStream.close();
                        CloudNumber.d = CloudUtils.getInfoFromResult(sb.toString());
                        CloudNumber.c = (TextUtils.isEmpty(CloudNumber.d) || CloudNumber.d.contains(a[3])) ? false : true;
                    } catch (Exception e3) {
                        throw e3;
                    }
                } catch (Exception e4) {
                    throw e4;
                }
            } catch (Exception e5) {
                Log.e(a[1], a[7], e5);
            }
            return a[4];
        }
    }

    static {
        String[] strArr = new String[7];
        throw new VerifyError("bad dex opcode");
    }

    private static void a(Context context, Callback callback, ContentResolver contentResolver, LocationInfo locationInfo, String str, String str2, String str3) {
        String rewritePhoneLocation = LocationUtils.rewritePhoneLocation(str3);
        PhoneType phoneType = LocationUtils.getPhoneType(rewritePhoneLocation);
        if (!CloudUtils.inContactList(contentResolver, str) || phoneType == PhoneType.NORMAL) {
            str2 = rewritePhoneLocation;
        } else {
            phoneType = PhoneType.NORMAL;
        }
        LocationUtils.insertOrUpdateLocationInfo(contentResolver, locationInfo, str, str2, LocationUtils.getPhoneTypeID(phoneType), LocationUtils.getEngineTypeID(EngineType.ONLINE));
        callback.onResult(str, str2, phoneType, EngineType.ONLINE);
    }

    private static void a(Callback callback, ContentResolver contentResolver, LocationInfo locationInfo, String str, String str2) {
        LocationUtils.insertOrUpdateLocationInfo(contentResolver, locationInfo, str, str2, LocationUtils.getPhoneTypeID(PhoneType.NORMAL), LocationUtils.getEngineTypeID(EngineType.OFFLINE));
        callback.onResult(str, str2, PhoneType.NORMAL, EngineType.OFFLINE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x024d, code lost:
        if (r0 != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (android.text.TextUtils.isEmpty(r0.getUserMark()) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b1, code lost:
        if (r0 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cb, code lost:
        if (r0 > java.lang.System.currentTimeMillis()) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d5, code lost:
        if (r0 != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e9, code lost:
        if (r0 != false) goto L133;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void detect(java.lang.String r8, com.mokee.cloud.location.CloudNumber.Callback r9, android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 697
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.location.CloudNumber.detect(java.lang.String, com.mokee.cloud.location.CloudNumber$Callback, android.content.Context, boolean):void");
    }
}
