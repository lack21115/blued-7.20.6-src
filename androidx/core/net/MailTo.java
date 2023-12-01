package androidx.core.net;

import android.media.TtmlUtils;
import android.net.Uri;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/net/MailTo.class */
public final class MailTo {
    public static final String MAILTO_SCHEME = "mailto:";

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f2504a = new HashMap<>();

    private MailTo() {
    }

    public static boolean isMailTo(Uri uri) {
        return uri != null && "mailto".equals(uri.getScheme());
    }

    public static boolean isMailTo(String str) {
        return str != null && str.startsWith("mailto:");
    }

    public static MailTo parse(Uri uri) throws ParseException {
        return parse(uri.toString());
    }

    public static MailTo parse(String str) throws ParseException {
        String decode;
        String substring;
        Preconditions.checkNotNull(str);
        if (isMailTo(str)) {
            int indexOf = str.indexOf(35);
            String str2 = str;
            if (indexOf != -1) {
                str2 = str.substring(0, indexOf);
            }
            int indexOf2 = str2.indexOf(63);
            if (indexOf2 == -1) {
                decode = Uri.decode(str2.substring(7));
                substring = null;
            } else {
                decode = Uri.decode(str2.substring(7, indexOf2));
                substring = str2.substring(indexOf2 + 1);
            }
            MailTo mailTo = new MailTo();
            if (substring != null) {
                String[] split = substring.split("&");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String[] split2 = split[i2].split("=", 2);
                    if (split2.length != 0) {
                        mailTo.f2504a.put(Uri.decode(split2[0]).toLowerCase(Locale.ROOT), split2.length > 1 ? Uri.decode(split2[1]) : null);
                    }
                    i = i2 + 1;
                }
            }
            String to = mailTo.getTo();
            String str3 = decode;
            if (to != null) {
                str3 = decode + ", " + to;
            }
            mailTo.f2504a.put("to", str3);
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    public String getBcc() {
        return this.f2504a.get("bcc");
    }

    public String getBody() {
        return this.f2504a.get(TtmlUtils.TAG_BODY);
    }

    public String getCc() {
        return this.f2504a.get("cc");
    }

    public Map<String, String> getHeaders() {
        return this.f2504a;
    }

    public String getSubject() {
        return this.f2504a.get("subject");
    }

    public String getTo() {
        return this.f2504a.get("to");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append('?');
        for (Map.Entry<String, String> entry : this.f2504a.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append('&');
        }
        return sb.toString();
    }
}
