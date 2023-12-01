package com.blued.android.framework.web;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.fragment.app.Fragment;
import com.alipay.sdk.util.i;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.utils.UriUtils;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/WebUploadFile.class */
public class WebUploadFile {
    public static int a = 1;
    private Fragment b;
    private ValueCallback<Uri> c;
    private String d = "";
    private ValueCallback<Uri[]> e;

    public WebUploadFile(Fragment fragment) {
        this.b = fragment;
    }

    private Intent a() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent a2 = a(b(), c(), d());
        a2.putExtra("android.intent.extra.INTENT", intent);
        return a2;
    }

    private Intent a(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        return intent;
    }

    private Intent a(Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", ProviderHolder.a().c().a());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebChromeClient.FileChooserParams fileChooserParams) {
        this.b.startActivityForResult(fileChooserParams.createIntent(), a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent b() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File file = new File(externalStoragePublicDirectory.getAbsolutePath() + File.separator + "Camera");
        file.mkdirs();
        long currentTimeMillis = System.currentTimeMillis();
        String charSequence = currentTimeMillis != 0 ? DateFormat.format("yyyyMMdd_kkmmss", currentTimeMillis).toString() : "";
        this.d = file.getAbsolutePath() + File.separator + "IMG_" + charSequence + ".jpg";
        intent.addFlags(1);
        intent.addFlags(2);
        intent.putExtra("output", UriUtils.a(this.d));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent c() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    private Intent d() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public void a(int i, int i2, Intent intent) {
        if (i == a && i2 == -1) {
            if (this.c != null) {
                if (intent != null) {
                    String[] strArr = {"_data"};
                    Cursor query = this.b.getActivity().getContentResolver().query(intent.getData(), strArr, null, null, null);
                    if (query != null) {
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex(strArr[0]));
                        query.close();
                        if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                            this.c.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                        } else {
                            this.c.onReceiveValue(Uri.fromFile(new File(string)));
                        }
                        this.c = null;
                    }
                } else {
                    String str = this.d;
                    if (str != null && !str.isEmpty()) {
                        this.c.onReceiveValue(Uri.fromFile(new File(this.d)));
                        this.d = "";
                        this.c = null;
                    }
                }
            } else if (this.e != null && AppMethods.c(21)) {
                b(i, i2, intent);
            }
        }
        ValueCallback<Uri> valueCallback = this.c;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.c = null;
            this.d = "";
            return;
        }
        ValueCallback<Uri[]> valueCallback2 = this.e;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.e = null;
        }
    }

    public void a(ValueCallback<Uri> valueCallback, String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        if (this.c != null) {
            return;
        }
        this.c = valueCallback;
        String[] split = str3.split(i.b);
        String str5 = split[0];
        String str6 = str4.length() > 0 ? str4 : "filesystem";
        String str7 = str6;
        if (str4.equals("filesystem")) {
            int length = split.length;
            int i = 0;
            while (true) {
                str7 = str6;
                if (i >= length) {
                    break;
                }
                String[] split2 = split[i].split("=");
                String str8 = str6;
                if (split2.length == 2) {
                    str8 = str6;
                    if ("capture".equals(split2[0])) {
                        str8 = split2[1];
                    }
                }
                i++;
                str6 = str8;
            }
        }
        this.d = null;
        if (str5.equals("image/*")) {
            if (str7.equals("camera")) {
                this.b.startActivityForResult(b(), a);
                return;
            }
            Intent a2 = a(b());
            a2.putExtra("android.intent.extra.INTENT", a("image/*"));
            this.b.startActivityForResult(a2, a);
        } else if (str5.equals("video/*")) {
            if (str7.equals("camcorder")) {
                this.b.startActivityForResult(c(), a);
                return;
            }
            Intent a3 = a(c());
            a3.putExtra("android.intent.extra.INTENT", a("video/*"));
            this.b.startActivityForResult(a3, a);
        } else if (!str5.equals("audio/*")) {
            this.b.startActivityForResult(a(), a);
        } else if (str7.equals("microphone")) {
            this.b.startActivityForResult(d(), a);
        } else {
            Intent a4 = a(d());
            a4.putExtra("android.intent.extra.INTENT", a("audio/*"));
            this.b.startActivityForResult(a4, a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
        if (r6.equals("image/*") == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.webkit.WebView r6, android.webkit.ValueCallback<android.net.Uri[]> r7, final android.webkit.WebChromeClient.FileChooserParams r8) {
        /*
            r5 = this;
            r0 = 21
            boolean r0 = com.blued.android.core.AppMethods.c(r0)
            if (r0 == 0) goto Lca
            r0 = r8
            java.lang.String[] r0 = r0.getAcceptTypes()
            r6 = r0
            r0 = r8
            boolean r0 = r0.isCaptureEnabled()
            r11 = r0
            r0 = r6
            int r0 = r0.length
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r10
            if (r0 <= 0) goto L26
            r0 = r6
            r1 = 0
            r0 = r0[r1]
            r6 = r0
            goto L2a
        L26:
            java.lang.String r0 = "image/*"
            r6 = r0
        L2a:
            r0 = r5
            r1 = r7
            r0.e = r1
            r0 = r11
            if (r0 != 0) goto L3a
            r0 = r5
            r1 = r8
            r0.a(r1)
            return
        L3a:
            r0 = r6
            int r0 = r0.hashCode()
            r10 = r0
            r0 = r10
            r1 = -661257167(0xffffffffd8960431, float:-1.31955797E15)
            if (r0 == r1) goto L78
            r0 = r10
            r1 = 452781974(0x1afce796, float:1.04598904E-22)
            if (r0 == r1) goto L68
            r0 = r10
            r1 = 1911932022(0x71f5c476, float:2.4339627E30)
            if (r0 == r1) goto L5b
            goto L88
        L5b:
            r0 = r6
            java.lang.String r1 = "image/*"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L88
            goto L8b
        L68:
            r0 = r6
            java.lang.String r1 = "video/*"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L88
            r0 = 1
            r9 = r0
            goto L8b
        L78:
            r0 = r6
            java.lang.String r1 = "audio/*"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L88
            r0 = 2
            r9 = r0
            goto L8b
        L88:
            r0 = -1
            r9 = r0
        L8b:
            r0 = r9
            if (r0 == 0) goto Lbe
            r0 = r9
            r1 = 1
            if (r0 == r1) goto Lb1
            r0 = r9
            r1 = 2
            if (r0 == r1) goto La2
            r0 = r5
            r1 = r8
            r0.a(r1)
            return
        La2:
            r0 = r5
            androidx.fragment.app.Fragment r0 = r0.b
            r1 = r5
            android.content.Intent r1 = r1.d()
            int r2 = com.blued.android.framework.web.WebUploadFile.a
            r0.startActivityForResult(r1, r2)
            return
        Lb1:
            com.blued.android.framework.web.WebUploadFile$2 r0 = new com.blued.android.framework.web.WebUploadFile$2
            r1 = r0
            r2 = r5
            r3 = r8
            r1.<init>()
            com.blued.android.framework.web.permission.PermissionHelper.a(r0)
            return
        Lbe:
            com.blued.android.framework.web.WebUploadFile$1 r0 = new com.blued.android.framework.web.WebUploadFile$1
            r1 = r0
            r2 = r5
            r3 = r8
            r1.<init>()
            com.blued.android.framework.web.permission.PermissionHelper.a(r0)
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.web.WebUploadFile.a(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):void");
    }

    public void b(int i, int i2, Intent intent) {
        ValueCallback<Uri[]> valueCallback = this.e;
        if (valueCallback == null) {
            return;
        }
        if (i2 != -1 || valueCallback == null) {
            this.e.onReceiveValue(null);
        } else {
            Uri[] parseResult = WebChromeClient.FileChooserParams.parseResult(i2, intent);
            Uri[] uriArr = parseResult;
            if (parseResult == null) {
                uriArr = parseResult;
                if (!this.d.isEmpty()) {
                    uriArr = new Uri[]{Uri.fromFile(new File(this.d))};
                }
            }
            this.e.onReceiveValue(uriArr);
        }
        this.e = null;
    }
}
