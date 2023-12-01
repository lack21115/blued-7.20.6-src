package com.sobot.chat.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.widget.LinkMovementClickMethod;
import com.sobot.chat.widget.emoji.InputHelper;
import com.sobot.chat.widget.html.SobotCustomTagHandler;
import com.sobot.chat.widget.rich.EmailSpan;
import com.sobot.chat.widget.rich.MyURLSpan;
import com.sobot.chat.widget.rich.PhoneSpan;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/HtmlTools.class */
public class HtmlTools {
    public static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef";
    public static final String TOP_LEVEL_DOMAIN_STR_FOR_WEB_URL = "(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))";
    private static HtmlTools instance;
    private Context context;
    private String textImagePath;
    public static Pattern WEB_URL3 = Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
    public static final Pattern WEB_URL2 = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    public static final Pattern WEB_URL = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
    public static final Pattern EMAIL_ADDRESS = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    public static Pattern PHONE_NUMBER = Pattern.compile("\\d{3}-\\d{8}|\\d{3}-\\d{7}|\\d{4}-\\d{8}|\\d{4}-\\d{7}|1+[34578]+\\d{9}|\\+\\d{2}1+[34578]+\\d{9}|400\\d{7}|400-\\d{3}-\\d{4}|\\d{12}|\\d{11}|\\d{10}|\\d{8}|\\d{7}");
    public static final Pattern EMOJI = Pattern.compile("\\[(([一-龥]+)|([a-zA-z]+))\\]");
    public static final Pattern EMOJI_NUMBERS = Pattern.compile("\\[[(0-9)]+\\]");

    private HtmlTools(Context context) {
        this.context = context.getApplicationContext();
    }

    public static HtmlTools getInstance(Context context) {
        if (instance == null) {
            instance = new HtmlTools(context.getApplicationContext());
        }
        return instance;
    }

    public static Pattern getPhoneNumberPattern() {
        return PHONE_NUMBER;
    }

    public static Pattern getWebUrl() {
        return WEB_URL3;
    }

    public static boolean isHasPatterns(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (getWebUrl().matcher(str.toString()).matches()) {
            return true;
        }
        LogUtils.i("URL 非法，请输入有效的URL链接:" + str);
        return false;
    }

    public static void parseLinkText(Context context, TextView textView, Spanned spanned, int i, boolean z) {
        if (spanned instanceof Spannable) {
            Spannable spannable = (Spannable) spanned;
            Matcher matcher = EMAIL_ADDRESS.matcher(spannable);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (((URLSpan[]) spannable.getSpans(start, end, URLSpan.class)).length == 0) {
                    spannable.setSpan(new EmailSpan(context.getApplicationContext(), matcher.group(), i), start, end, 33);
                }
            }
            Matcher matcher2 = getWebUrl().matcher(spannable);
            while (matcher2.find()) {
                int start2 = matcher2.start();
                int end2 = matcher2.end();
                if (((URLSpan[]) spannable.getSpans(start2, end2, URLSpan.class)).length == 0) {
                    spannable.setSpan(new MyURLSpan(context.getApplicationContext(), matcher2.group(), i, true), start2, end2, 33);
                }
            }
            Matcher matcher3 = getPhoneNumberPattern().matcher(spannable);
            while (matcher3.find()) {
                int start3 = matcher3.start();
                int end3 = matcher3.end();
                if (((URLSpan[]) spannable.getSpans(start3, end3, URLSpan.class)).length == 0) {
                    spannable.setSpan(new PhoneSpan(context.getApplicationContext(), matcher3.group(), i), start3, end3, 33);
                }
            }
            int length = spanned.length();
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
            URLSpan[] uRLSpanArr2 = spanned != null ? (URLSpan[]) spanned.getSpans(0, length, URLSpan.class) : new URLSpan[0];
            if (uRLSpanArr.length == 0 && uRLSpanArr2.length == 0) {
                textView.setText(spannable);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
            for (URLSpan uRLSpan : uRLSpanArr2) {
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new MyURLSpan(context.getApplicationContext(), uRLSpan.getURL(), i, z), spanned.getSpanStart(uRLSpan), spanned.getSpanEnd(uRLSpan), 33);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public static void setPhoneNumberPattern(Pattern pattern) {
        PHONE_NUMBER = pattern;
    }

    public static void setWebUrl(Pattern pattern) {
        WEB_URL3 = pattern;
    }

    public Spanned formatRichTextWithPic(final TextView textView, final String str, final int i) {
        return Html.fromHtml(str.replace("span", SobotCustomTagHandler.NEW_SPAN), new Html.ImageGetter() { // from class: com.sobot.chat.utils.HtmlTools.2
            @Override // android.text.Html.ImageGetter
            public Drawable getDrawable(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                HtmlTools htmlTools = HtmlTools.this;
                htmlTools.textImagePath = CommonUtils.getSDCardRootPath(htmlTools.context);
                String str3 = HtmlTools.this.textImagePath + String.valueOf(str2.hashCode());
                if (!new File(str3).exists()) {
                    LogUtils.i(str3 + " Do not eixts");
                    if (str2.startsWith("https://") || str2.startsWith("http://")) {
                        HtmlTools.this.loadPic(textView, str2, str, str3, i);
                        return null;
                    }
                    return null;
                }
                LogUtils.i(" 网络下载 文本中的图片信息  " + str3 + "  eixts");
                Drawable createFromPath = Drawable.createFromPath(str3);
                if (createFromPath != null) {
                    LogUtils.i(" 图文并茂中 图片的 大小 width： " + createFromPath.getIntrinsicWidth() + "--height:" + createFromPath.getIntrinsicWidth());
                    createFromPath.setBounds(0, 0, createFromPath.getIntrinsicWidth() * 4, createFromPath.getIntrinsicHeight() * 4);
                }
                return createFromPath;
            }
        }, new SobotCustomTagHandler(this.context, textView.getTextColors()));
    }

    public String getHTMLStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Pattern.compile("<[^>]+>", 2).matcher(Pattern.compile("<br/>", 2).matcher(str).replaceAll("\n")).replaceAll("");
    }

    public void loadPic(final TextView textView, String str, final String str2, String str3, final int i) {
        HttpUtils.getInstance().download(str, new File(str3), null, new HttpUtils.FileCallBack() { // from class: com.sobot.chat.utils.HtmlTools.1
            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void inProgress(int i2) {
                LogUtils.i(" 文本图片的下载进度" + i2);
            }

            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void onError(Exception exc, String str4, int i2) {
                LogUtils.i(" 文本图片的下载失败", exc);
            }

            @Override // com.sobot.chat.core.HttpUtils.FileCallBack
            public void onResponse(File file) {
                HtmlTools.this.setRichText(textView, str2, i);
            }
        });
    }

    public void setRichText(TextView textView, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = str;
        if (str.contains("<p>")) {
            str2 = str.replaceAll("<p>", "").replaceAll("</p>", "<br/>").replaceAll("\n", "<br/>");
        }
        while (str2.length() > 5 && "<br/>".equals(str2.substring(str2.length() - 5, str2.length()))) {
            str2 = str2.substring(0, str2.length() - 5);
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
            if (str2.length() > 0) {
                str3 = str2;
                if ("\n".equals(str2.substring(str2.length() - 1, str2.length()))) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        str3 = str2;
                        if (i3 >= str2.length()) {
                            break;
                        }
                        str3 = str2;
                        if (str2.lastIndexOf("\n") != str2.length() - 1) {
                            break;
                        }
                        str2 = str2.substring(0, str2.length() - 1);
                        i2 = i3 + 1;
                    }
                }
            }
        }
        textView.setMovementMethod(LinkMovementClickMethod.getInstance());
        parseLinkText(this.context, textView, InputHelper.displayEmoji(this.context.getApplicationContext(), formatRichTextWithPic(textView, str3.replace("\n", "<br/>"), i)), i, false);
    }

    public void setRichText(TextView textView, String str, int i, boolean z) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        while (!TextUtils.isEmpty(str2) && str2.length() > 5 && "<br/>".equals(str2.substring(0, 5))) {
            str2 = str2.substring(5, str2.length());
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
            if (str2.length() > 5) {
                str3 = str2;
                if ("<br/>".equals(str2.substring(str2.length() - 5, str2.length()))) {
                    str3 = str2.substring(0, str2.length() - 5);
                }
            }
        }
        textView.setMovementMethod(LinkMovementClickMethod.getInstance());
        textView.setFocusable(false);
        parseLinkText(this.context, textView, InputHelper.displayEmoji(this.context.getApplicationContext(), formatRichTextWithPic(textView, str3.replace("\n", "<br />"), i)), i, z);
    }

    public void setRichTextViewText(TextView textView, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = str;
        if (str.contains("\n")) {
            str2 = str.replaceAll("\n", "<br/>");
        }
        textView.setMovementMethod(LinkMovementClickMethod.getInstance());
        parseLinkText(this.context, textView, InputHelper.displayEmoji(this.context.getApplicationContext(), formatRichTextWithPic(textView, str2.replace("\n", "<br/>"), i)), i, false);
    }
}
