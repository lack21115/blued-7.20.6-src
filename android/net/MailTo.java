package android.net;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/MailTo.class */
public class MailTo {
    private static final String BODY = "body";
    private static final String CC = "cc";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders = new HashMap<>();

    private MailTo() {
    }

    public static boolean isMailTo(String str) {
        return str != null && str.startsWith("mailto:");
    }

    public static MailTo parse(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException();
        }
        if (isMailTo(str)) {
            Uri parse = Uri.parse(str.substring("mailto:".length()));
            MailTo mailTo = new MailTo();
            String query = parse.getQuery();
            if (query != null) {
                String[] split = query.split(ContainerUtils.FIELD_DELIMITER);
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String[] split2 = split[i2].split("=");
                    if (split2.length != 0) {
                        mailTo.mHeaders.put(Uri.decode(split2[0]).toLowerCase(Locale.ROOT), split2.length > 1 ? Uri.decode(split2[1]) : null);
                    }
                    i = i2 + 1;
                }
            }
            String path = parse.getPath();
            if (path != null) {
                String to = mailTo.getTo();
                String str2 = path;
                if (to != null) {
                    str2 = path + ", " + to;
                }
                mailTo.mHeaders.put("to", str2);
            }
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    public String getBody() {
        return this.mHeaders.get("body");
    }

    public String getCc() {
        return this.mHeaders.get("cc");
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    public String getTo() {
        return this.mHeaders.get("to");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append('?');
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append('&');
        }
        return sb.toString();
    }
}
