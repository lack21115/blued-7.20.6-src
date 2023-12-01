package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.e.j;
import com.google.common.net.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/d/b.class */
public final class b extends f {
    private static final String b = b.class.getSimpleName();

    public b(Context context) {
        super(context);
    }

    @Override // cn.com.chinatelecom.account.api.d.e
    public h a(String str, String str2, int i, g gVar) {
        return a(str) ? b(str, str2, i, gVar) : c(str, str2, i, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0547 A[Catch: IOException -> 0x0871, TRY_ENTER, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0551 A[Catch: IOException -> 0x0871, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x06ba A[Catch: IOException -> 0x0871, TRY_ENTER, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x06c4 A[Catch: IOException -> 0x0871, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x082e A[Catch: IOException -> 0x0871, TRY_ENTER, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0838 A[Catch: IOException -> 0x0871, TRY_ENTER, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x085f A[Catch: IOException -> 0x0875, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0875, blocks: (B:269:0x0853, B:272:0x085f), top: B:284:0x0853 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0853 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03d3 A[Catch: IOException -> 0x0871, TRY_ENTER, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03db A[Catch: IOException -> 0x0871, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x0871, blocks: (B:70:0x02b3, B:73:0x02be, B:95:0x03d3, B:98:0x03db, B:151:0x0547, B:154:0x0551, B:205:0x06ba, B:208:0x06c4, B:259:0x082e, B:262:0x0838), top: B:286:0x0018 }] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.com.chinatelecom.account.api.d.h b(java.lang.String r7, java.lang.String r8, int r9, cn.com.chinatelecom.account.api.d.g r10) {
        /*
            Method dump skipped, instructions count: 2169
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.chinatelecom.account.api.d.b.b(java.lang.String, java.lang.String, int, cn.com.chinatelecom.account.api.d.g):cn.com.chinatelecom.account.api.d.h");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v75 */
    /* JADX WARN: Type inference failed for: r7v76 */
    public h c(String str, String str2, int i, g gVar) {
        Throwable th;
        BufferedReader bufferedReader;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2;
        InputStream inputStream3;
        BufferedReader bufferedReader3;
        InputStream inputStream4;
        BufferedReader bufferedReader4;
        BufferedReader bufferedReader5;
        InputStream inputStream5;
        BufferedReader bufferedReader6;
        BufferedReader bufferedReader7;
        h hVar = new h();
        String str3 = null;
        try {
            try {
                try {
                    HttpURLConnection d = d(str, str2, i, gVar);
                    int responseCode = d.getResponseCode();
                    if (responseCode == 200) {
                        inputStream5 = d.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            bufferedReader6 = new BufferedReader(new InputStreamReader(inputStream5));
                            while (true) {
                                try {
                                    String readLine = bufferedReader6.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                    sb.append("\n");
                                } catch (SocketTimeoutException e) {
                                    e = e;
                                    bufferedReader4 = bufferedReader6;
                                    inputStream4 = inputStream5;
                                    StringBuilder sb2 = new StringBuilder();
                                    String str4 = bufferedReader4;
                                    sb2.append(cn.com.chinatelecom.account.api.a.d.a(j.f));
                                    String str5 = bufferedReader4;
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str6 = bufferedReader4;
                                    sb2.append(gVar.f4083c);
                                    String str7 = bufferedReader4;
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str8 = bufferedReader4;
                                    sb2.append(e.getMessage());
                                    String str9 = bufferedReader4;
                                    hVar.b = j.a(80005, sb2.toString());
                                    String str10 = bufferedReader4;
                                    String str11 = b;
                                    String str12 = bufferedReader4;
                                    StringBuilder sb3 = new StringBuilder();
                                    String str13 = bufferedReader4;
                                    sb3.append("SocketTimeoutException-");
                                    String str14 = bufferedReader4;
                                    sb3.append(gVar.f4083c);
                                    String str15 = bufferedReader4;
                                    sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str16 = bufferedReader4;
                                    sb3.append(e.getMessage());
                                    String str17 = bufferedReader4;
                                    CtAuth.warn(str11, sb3.toString(), e);
                                    String str18 = bufferedReader4;
                                    StringBuilder sb4 = new StringBuilder();
                                    String str19 = bufferedReader4;
                                    sb4.append("SocketTimeoutException ：");
                                    String str20 = bufferedReader4;
                                    sb4.append(e.getMessage());
                                    String str21 = bufferedReader4;
                                    BufferedReader bufferedReader8 = bufferedReader4;
                                    InputStream inputStream6 = inputStream4;
                                    cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, sb4.toString());
                                    if (bufferedReader4 != null) {
                                        bufferedReader4.close();
                                    }
                                    str = inputStream6;
                                    str2 = bufferedReader8;
                                    if (inputStream4 != null) {
                                        inputStream4.close();
                                        str = inputStream6;
                                        str2 = bufferedReader8;
                                    }
                                    return hVar;
                                } catch (UnknownHostException e2) {
                                    e = e2;
                                    bufferedReader3 = bufferedReader6;
                                    inputStream3 = inputStream5;
                                    StringBuilder sb5 = new StringBuilder();
                                    String str22 = bufferedReader3;
                                    sb5.append(cn.com.chinatelecom.account.api.a.d.a(j.g));
                                    String str23 = bufferedReader3;
                                    sb5.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str24 = bufferedReader3;
                                    sb5.append(gVar.f4083c);
                                    String str25 = bufferedReader3;
                                    sb5.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str26 = bufferedReader3;
                                    sb5.append(e.getMessage());
                                    String str27 = bufferedReader3;
                                    hVar.b = j.a(80006, sb5.toString());
                                    String str28 = bufferedReader3;
                                    String str29 = b;
                                    String str30 = bufferedReader3;
                                    StringBuilder sb6 = new StringBuilder();
                                    String str31 = bufferedReader3;
                                    sb6.append("UnknownHostException-");
                                    String str32 = bufferedReader3;
                                    sb6.append(gVar.f4083c);
                                    String str33 = bufferedReader3;
                                    sb6.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str34 = bufferedReader3;
                                    sb6.append(e.getMessage());
                                    String str35 = bufferedReader3;
                                    CtAuth.warn(str29, sb6.toString(), e);
                                    String str36 = bufferedReader3;
                                    StringBuilder sb7 = new StringBuilder();
                                    String str37 = bufferedReader3;
                                    sb7.append("UnknownHostException ：");
                                    String str38 = bufferedReader3;
                                    sb7.append(e.getMessage());
                                    String str39 = bufferedReader3;
                                    str2 = bufferedReader3;
                                    str = inputStream3;
                                    cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, sb7.toString());
                                    if (bufferedReader3 != null) {
                                        bufferedReader3.close();
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                        return hVar;
                                    }
                                    return hVar;
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedReader5 = bufferedReader6;
                                    inputStream2 = inputStream5;
                                    StringBuilder sb8 = new StringBuilder();
                                    String str40 = bufferedReader5;
                                    sb8.append(cn.com.chinatelecom.account.api.a.d.a(j.h));
                                    String str41 = bufferedReader5;
                                    sb8.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str42 = bufferedReader5;
                                    sb8.append(gVar.f4083c);
                                    String str43 = bufferedReader5;
                                    sb8.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str44 = bufferedReader5;
                                    sb8.append(e.getMessage());
                                    String str45 = bufferedReader5;
                                    hVar.b = j.a(80007, sb8.toString());
                                    String str46 = bufferedReader5;
                                    String str47 = b;
                                    String str48 = bufferedReader5;
                                    StringBuilder sb9 = new StringBuilder();
                                    String str49 = bufferedReader5;
                                    sb9.append("IOException-");
                                    String str50 = bufferedReader5;
                                    sb9.append(gVar.f4083c);
                                    String str51 = bufferedReader5;
                                    sb9.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    String str52 = bufferedReader5;
                                    sb9.append(e.getMessage());
                                    String str53 = bufferedReader5;
                                    CtAuth.warn(str47, sb9.toString(), e);
                                    String str54 = bufferedReader5;
                                    StringBuilder sb10 = new StringBuilder();
                                    String str55 = bufferedReader5;
                                    sb10.append("IOException ：");
                                    String str56 = bufferedReader5;
                                    sb10.append(e.getMessage());
                                    String str57 = bufferedReader5;
                                    str2 = bufferedReader5;
                                    str = inputStream2;
                                    cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, sb10.toString());
                                    if (bufferedReader5 != null) {
                                        bufferedReader5.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                        return hVar;
                                    }
                                    return hVar;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader7 = bufferedReader6;
                                    inputStream = inputStream5;
                                    bufferedReader2 = bufferedReader7;
                                    try {
                                        hVar.b = j.a(80001, cn.com.chinatelecom.account.api.a.d.a(j.b) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + gVar.f4083c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                                        CtAuth.warn(b, "Throwable-" + gVar.f4083c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage(), th);
                                        StringBuilder sb11 = new StringBuilder();
                                        sb11.append("Throwable ：");
                                        sb11.append(th.getMessage());
                                        cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, sb11.toString());
                                        if (bufferedReader2 != null) {
                                            bufferedReader2.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                            return hVar;
                                        }
                                        return hVar;
                                    } catch (Throwable th3) {
                                        bufferedReader = bufferedReader2;
                                        th = th3;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            hVar.f4086a = 0;
                            String sb12 = sb.toString();
                            if (!TextUtils.isEmpty(sb12)) {
                                hVar.b = new JSONObject(sb12);
                                cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, null);
                            }
                            cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, null);
                            d a2 = cn.com.chinatelecom.account.api.e.a.a(this.f4081a, d, true);
                            if (a2 != null) {
                                hVar.f4087c = a2.f4079a;
                                cn.com.chinatelecom.account.api.e.f.a(gVar.d).f(a2.f4080c);
                            }
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            bufferedReader4 = null;
                            inputStream4 = inputStream5;
                        } catch (UnknownHostException e6) {
                            e = e6;
                            bufferedReader3 = null;
                            inputStream3 = inputStream5;
                        } catch (IOException e7) {
                            e = e7;
                            inputStream2 = inputStream5;
                            bufferedReader5 = str3;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader7 = null;
                        }
                    } else {
                        if (responseCode != 302) {
                            hVar.b = j.a(80002, cn.com.chinatelecom.account.api.a.d.a(j.f4101c) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + gVar.f4083c + "-code : " + responseCode);
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append(" Http response code :");
                            sb13.append(responseCode);
                            String sb14 = sb13.toString();
                            cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, sb14);
                            CtAuth.info(b, sb14);
                        } else if (gVar.b < 10) {
                            gVar.b++;
                            gVar.f = false;
                            String headerField = d.getHeaderField(HttpHeaders.LOCATION);
                            d a3 = cn.com.chinatelecom.account.api.e.a.a(d);
                            cn.com.chinatelecom.account.api.e.f.a(gVar.d).f(a3.f4080c);
                            int i2 = 0;
                            if (!TextUtils.isEmpty(a3.d)) {
                                i2 = a3.d.equals("0") ? 0 : 1;
                            }
                            CtAuth.info(b, " method : " + i2);
                            return a(headerField, null, i2, gVar);
                        } else {
                            hVar.b = j.a(80001, cn.com.chinatelecom.account.api.a.d.a(j.b) + "-Redirect more than 10 times");
                            cn.com.chinatelecom.account.api.e.f.a(gVar.d, hVar.b, "Redirect more than 10 times");
                        }
                        inputStream5 = null;
                        bufferedReader6 = null;
                    }
                    if (bufferedReader6 != null) {
                        bufferedReader6.close();
                    }
                    if (inputStream5 != null) {
                        inputStream5.close();
                        return hVar;
                    }
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    inputStream4 = null;
                    bufferedReader4 = null;
                } catch (UnknownHostException e9) {
                    e = e9;
                    inputStream3 = null;
                    bufferedReader3 = null;
                } catch (IOException e10) {
                    e = e10;
                    inputStream2 = null;
                    bufferedReader5 = str3;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = null;
                    inputStream = null;
                }
                return hVar;
            } catch (IOException e11) {
                e11.printStackTrace();
                return hVar;
            }
        } catch (Throwable th6) {
            InputStream inputStream7 = str;
            th = th6;
            bufferedReader = str2;
            inputStream = inputStream7;
        }
    }
}
