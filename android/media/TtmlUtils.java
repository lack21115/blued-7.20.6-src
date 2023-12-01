package android.media;

import android.app.backup.FullBackup;
import com.anythink.expressad.d.a.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/media/TtmlUtils.class */
final class TtmlUtils {
    public static final String ATTR_BEGIN = "begin";
    public static final String ATTR_DURATION = "dur";
    public static final String ATTR_END = "end";
    public static final long INVALID_TIMESTAMP = Long.MAX_VALUE;
    public static final String PCDATA = "#pcdata";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SMPTE_DATA = "smpte:data";
    public static final String TAG_SMPTE_IMAGE = "smpte:image";
    public static final String TAG_SMPTE_INFORMATION = "smpte:information";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    private TtmlUtils() {
    }

    public static String applyDefaultSpacePolicy(String str) {
        return applySpacePolicy(str, true);
    }

    public static String applySpacePolicy(String str, boolean z) {
        String replaceAll = str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "\n").replaceAll(" *\n *", "\n");
        if (z) {
            replaceAll = replaceAll.replaceAll("\n", " ");
        }
        return replaceAll.replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static String extractText(TtmlNode ttmlNode, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        extractText(ttmlNode, j, j2, sb, false);
        return sb.toString().replaceAll("\n$", "");
    }

    private static void extractText(TtmlNode ttmlNode, long j, long j2, StringBuilder sb, boolean z) {
        if (ttmlNode.mName.equals(PCDATA) && z) {
            sb.append(ttmlNode.mText);
        } else if (ttmlNode.mName.equals("br") && z) {
            sb.append("\n");
        } else if (ttmlNode.mName.equals(TAG_METADATA) || !ttmlNode.isActive(j, j2)) {
        } else {
            boolean equals = ttmlNode.mName.equals("p");
            int length = sb.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ttmlNode.mChildren.size()) {
                    break;
                }
                extractText(ttmlNode.mChildren.get(i2), j, j2, sb, equals || z);
                i = i2 + 1;
            }
            if (!equals || length == sb.length()) {
                return;
            }
            sb.append("\n");
        }
    }

    public static String extractTtmlFragment(TtmlNode ttmlNode, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        extractTtmlFragment(ttmlNode, j, j2, sb);
        return sb.toString();
    }

    private static void extractTtmlFragment(TtmlNode ttmlNode, long j, long j2, StringBuilder sb) {
        if (ttmlNode.mName.equals(PCDATA)) {
            sb.append(ttmlNode.mText);
        } else if (ttmlNode.mName.equals("br")) {
            sb.append("<br/>");
        } else if (!ttmlNode.isActive(j, j2)) {
        } else {
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(ttmlNode.mName);
            sb.append(ttmlNode.mAttributes);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ttmlNode.mChildren.size()) {
                    sb.append("</");
                    sb.append(ttmlNode.mName);
                    sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                    return;
                }
                extractTtmlFragment(ttmlNode.mChildren.get(i2), j, j2, sb);
                i = i2 + 1;
            }
        }
    }

    public static long parseTimeExpression(String str, int i, int i2, int i3) throws NumberFormatException {
        double d;
        String group;
        String group2;
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            double parseLong = Long.parseLong(matcher.group(1)) * b.P;
            double parseLong2 = Long.parseLong(matcher.group(2)) * 60;
            double parseLong3 = Long.parseLong(matcher.group(3));
            String group3 = matcher.group(4);
            double parseDouble = group3 != null ? Double.parseDouble(group3) : 0.0d;
            return (long) (1000.0d * (parseLong + parseLong2 + parseLong3 + parseDouble + (matcher.group(5) != null ? Long.parseLong(group) / i : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(group2) / i2) / i : 0.0d)));
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble2 = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            if (group4.equals("h")) {
                d = parseDouble2 * 3.6E9d;
            } else if (group4.equals("m")) {
                d = parseDouble2 * 6.0E7d;
            } else if (group4.equals("s")) {
                d = parseDouble2 * 1000000.0d;
            } else if (group4.equals("ms")) {
                d = parseDouble2 * 1000.0d;
            } else if (group4.equals(FullBackup.DATA_TREE_TOKEN)) {
                d = (parseDouble2 / i) * 1000000.0d;
            } else {
                d = parseDouble2;
                if (group4.equals("t")) {
                    d = (parseDouble2 / i3) * 1000000.0d;
                }
            }
            return (long) d;
        }
        throw new NumberFormatException("Malformed time expression : " + str);
    }
}
