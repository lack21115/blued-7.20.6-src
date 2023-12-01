package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/text/util/LinkifyCompat.class */
public final class LinkifyCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2536a = new String[0];
    private static final Comparator<LinkSpec> b = new Comparator<LinkSpec>() { // from class: androidx.core.text.util.LinkifyCompat.1
        @Override // java.util.Comparator
        public int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            if (linkSpec.f2538c < linkSpec2.f2538c) {
                return -1;
            }
            if (linkSpec.f2538c <= linkSpec2.f2538c && linkSpec.d >= linkSpec2.d) {
                return linkSpec.d > linkSpec2.d ? -1 : 0;
            }
            return 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/util/LinkifyCompat$LinkSpec.class */
    public static class LinkSpec {

        /* renamed from: a  reason: collision with root package name */
        URLSpan f2537a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        int f2538c;
        int d;

        LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/text/util/LinkifyCompat$LinkifyMask.class */
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static String a(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : FindAddress.a(str);
    }

    private static String a(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z;
        String str2;
        String str3 = str;
        if (transformFilter != null) {
            str3 = transformFilter.transformUrl(matcher, str);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                z = false;
                str2 = str3;
                break;
            } else if (str3.regionMatches(true, 0, strArr[i2], 0, strArr[i2].length())) {
                z = true;
                str2 = str3;
                if (!str3.regionMatches(false, 0, strArr[i2], 0, strArr[i2].length())) {
                    str2 = strArr[i2] + str3.substring(strArr[i2].length());
                    z = true;
                }
            } else {
                i = i2 + 1;
            }
        }
        String str4 = str2;
        if (!z) {
            str4 = str2;
            if (strArr.length > 0) {
                str4 = strArr[0] + str2;
            }
        }
        return str4;
    }

    private static void a(TextView textView) {
        if ((textView.getMovementMethod() instanceof LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private static void a(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static void a(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int indexOf;
        String obj = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String a2 = a(obj);
                if (a2 == null || (indexOf = obj.indexOf(a2)) < 0) {
                    return;
                }
                LinkSpec linkSpec = new LinkSpec();
                int length = a2.length() + indexOf;
                linkSpec.f2538c = indexOf + i;
                i += length;
                linkSpec.d = i;
                obj = obj.substring(length);
                try {
                    linkSpec.b = com.tencent.smtt.sdk.WebView.SCHEME_GEO + URLEncoder.encode(a2, "UTF-8");
                    arrayList.add(linkSpec);
                } catch (UnsupportedEncodingException e) {
                }
            } catch (UnsupportedOperationException e2) {
                return;
            }
        }
    }

    private static void a(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.b = a(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.f2538c = start;
                linkSpec.d = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static void addLinks(TextView textView, Pattern pattern, String str) {
        if (a()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (a()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (a()) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            a(textView);
        }
    }

    public static boolean addLinks(Spannable spannable, int i) {
        if (a()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        int length = uRLSpanArr.length;
        while (true) {
            int i2 = length - 1;
            if (i2 < 0) {
                break;
            }
            spannable.removeSpan(uRLSpanArr[i2]);
            length = i2;
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            a(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            a(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i & 8) != 0) {
            a(arrayList, spannable);
        }
        b(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.f2537a == null) {
                a(linkSpec.b, linkSpec.f2538c, linkSpec.d, spannable);
            }
        }
        return true;
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str) {
        return a() ? Linkify.addLinks(spannable, pattern, str) : addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        return a() ? Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r10.length < 1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean addLinks(android.text.Spannable r7, java.util.regex.Pattern r8, java.lang.String r9, java.lang.String[] r10, android.text.util.Linkify.MatchFilter r11, android.text.util.Linkify.TransformFilter r12) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LinkifyCompat.addLinks(android.text.Spannable, java.util.regex.Pattern, java.lang.String, java.lang.String[], android.text.util.Linkify$MatchFilter, android.text.util.Linkify$TransformFilter):boolean");
    }

    public static boolean addLinks(TextView textView, int i) {
        if (a()) {
            return Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (addLinks((Spannable) text, i)) {
                a(textView);
                return true;
            }
            return false;
        }
        SpannableString valueOf = SpannableString.valueOf(text);
        if (addLinks(valueOf, i)) {
            a(textView);
            textView.setText(valueOf);
            return true;
        }
        return false;
    }

    private static void b(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        Object[] objArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                break;
            }
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.f2537a = objArr[i2];
            linkSpec.f2538c = spannable.getSpanStart(objArr[i2]);
            linkSpec.d = spannable.getSpanEnd(objArr[i2]);
            arrayList.add(linkSpec);
            i = i2 + 1;
        }
        Collections.sort(arrayList, b);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i3);
            int i4 = i3 + 1;
            LinkSpec linkSpec3 = arrayList.get(i4);
            if (linkSpec2.f2538c <= linkSpec3.f2538c && linkSpec2.d > linkSpec3.f2538c) {
                int i5 = (linkSpec3.d > linkSpec2.d && linkSpec2.d - linkSpec2.f2538c <= linkSpec3.d - linkSpec3.f2538c) ? linkSpec2.d - linkSpec2.f2538c < linkSpec3.d - linkSpec3.f2538c ? i3 : -1 : i4;
                if (i5 != -1) {
                    Object obj = arrayList.get(i5).f2537a;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i5);
                    size--;
                }
            }
            i3 = i4;
        }
    }
}
