package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/b.class */
public final class b extends d {
    /* JADX WARN: Removed duplicated region for block: B:58:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r7, java.io.File r8) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.b.a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }

    private String dQ(String str) {
        File file = new File(str + ".anr");
        String str2 = "";
        String str3 = str2;
        if (file.exists()) {
            try {
                str2 = q.Q(file);
            } catch (IOException e) {
                this.mErrorMessage += e + "\n";
            }
            q.N(file);
            str3 = str2;
        }
        return str3;
    }

    private static boolean dR(String str) {
        String[] zz = com.kwad.sdk.crash.e.zy().zz();
        int length = zz.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String str2 = zz[i2];
            if (str.contains(str2)) {
                com.kwad.sdk.core.d.b.d("AnrReporter", " tag=" + str2);
                return true;
            }
            i = i2 + 1;
        }
    }

    private AnrExceptionMessage w(File file) {
        String str;
        try {
            str = q.Q(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        q.N(file);
        return anrExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(File file, File file2, File file3, String str) {
        com.kwad.sdk.core.d.b.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage w = w(file2);
        try {
            w.mReason = dQ(str);
            a(w, file);
            b(file3, w);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) w.toString(), true);
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ ANR Report Begin ------\n").append(w);
            w.mDumpsys = q.Q(new File(str + ".minfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            w.mErrorMessage += this.mErrorMessage;
        }
        return w;
    }
}
