package com.google.android.util;

import com.amap.api.col.p0003sl.iu;
import com.baidu.mobads.sdk.internal.a;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser.class */
public abstract class AbstractMessageParser {
    public static final String musicNote = "♫ ";
    private HashMap<Character, Format> formatStart;
    private int nextChar;
    private int nextClass;
    private boolean parseAcronyms;
    private boolean parseFormatting;
    private boolean parseMeText;
    private boolean parseMusic;
    private boolean parseSmilies;
    private boolean parseUrls;
    private ArrayList<Part> parts;
    private String text;
    private ArrayList<Token> tokens;

    /* renamed from: com.google.android.util.AbstractMessageParser$1  reason: invalid class name */
    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type = new int[Token.Type.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:43:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:45:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006f -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0077 -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007b -> B:47:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x007f -> B:41:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.SMILEY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.ACRONYM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.MUSIC.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.GOOGLE_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.YOUTUBE_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.PHOTO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[Token.Type.FLICKR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Acronym.class */
    public static class Acronym extends Token {
        private String value;

        public Acronym(String str, String str2) {
            super(Token.Type.ACRONYM, str);
            this.value = str2;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getRawText());
            info.add(getValue());
            return info;
        }

        public String getValue() {
            return this.value;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$FlickrPhoto.class */
    public static class FlickrPhoto extends Token {
        private static final String SETS = "sets";
        private static final String TAGS = "tags";
        private String grouping;
        private String groupingId;
        private String photo;
        private String user;
        private static final Pattern URL_PATTERN = Pattern.compile("http://(?:www.)?flickr.com/photos/([^/?#&]+)/?([^/?#&]+)?/?.*");
        private static final Pattern GROUPING_PATTERN = Pattern.compile("http://(?:www.)?flickr.com/photos/([^/?#&]+)/(tags|sets)/([^/?#&]+)/?");

        public FlickrPhoto(String str, String str2, String str3, String str4, String str5) {
            super(Token.Type.FLICKR, str5);
            if ("tags".equals(str)) {
                this.user = null;
                this.photo = null;
                this.grouping = "tags";
                this.groupingId = str2;
                return;
            }
            this.user = str;
            this.photo = "show".equals(str2) ? null : str2;
            this.grouping = str3;
            this.groupingId = str4;
        }

        public static String getPhotoURL(String str, String str2) {
            return "http://flickr.com/photos/" + str + BridgeUtil.SPLIT_MARK + str2;
        }

        public static String getRssUrl(String str) {
            return null;
        }

        public static String getTagsURL(String str) {
            return "http://flickr.com/photos/tags/" + str;
        }

        public static String getUserSetsURL(String str, String str2) {
            return "http://flickr.com/photos/" + str + "/sets/" + str2;
        }

        public static String getUserTagsURL(String str, String str2) {
            return "http://flickr.com/photos/" + str + "/tags/" + str2;
        }

        public static String getUserURL(String str) {
            return "http://flickr.com/photos/" + str;
        }

        public static FlickrPhoto matchURL(String str, String str2) {
            Matcher matcher = GROUPING_PATTERN.matcher(str);
            if (matcher.matches()) {
                return new FlickrPhoto(matcher.group(1), null, matcher.group(2), matcher.group(3), str2);
            }
            Matcher matcher2 = URL_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return new FlickrPhoto(matcher2.group(1), matcher2.group(2), null, null, str2);
            }
            return null;
        }

        public String getGrouping() {
            return this.grouping;
        }

        public String getGroupingId() {
            return this.groupingId;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getUrl());
            info.add(getUser() != null ? getUser() : "");
            info.add(getPhoto() != null ? getPhoto() : "");
            info.add(getGrouping() != null ? getGrouping() : "");
            info.add(getGroupingId() != null ? getGroupingId() : "");
            return info;
        }

        public String getPhoto() {
            return this.photo;
        }

        public String getUrl() {
            return SETS.equals(this.grouping) ? getUserSetsURL(this.user, this.groupingId) : "tags".equals(this.grouping) ? this.user != null ? getUserTagsURL(this.user, this.groupingId) : getTagsURL(this.groupingId) : this.photo != null ? getPhotoURL(this.user, this.photo) : getUserURL(this.user);
        }

        public String getUser() {
            return this.user;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isMedia() {
            return true;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Format.class */
    public static class Format extends Token {
        private char ch;
        private boolean matched;
        private boolean start;

        public Format(char c2, boolean z) {
            super(Token.Type.FORMAT, String.valueOf(c2));
            this.ch = c2;
            this.start = z;
        }

        private String getFormatEnd(char c2) {
            switch (c2) {
                case '\"':
                    return "”</font>";
                case '*':
                    return "</b>";
                case '^':
                    return "</font></b>";
                case '_':
                    return "</i>";
                default:
                    throw new AssertionError("unknown format '" + c2 + "'");
            }
        }

        private String getFormatStart(char c2) {
            switch (c2) {
                case '\"':
                    return "<font color=\"#999999\">“";
                case '*':
                    return "<b>";
                case '^':
                    return "<b><font color=\"#005FFF\">";
                case '_':
                    return "<i>";
                default:
                    throw new AssertionError("unknown format '" + c2 + "'");
            }
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean controlCaps() {
            return this.ch == '^';
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return true;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean setCaps() {
            return this.start;
        }

        public void setMatched(boolean z) {
            this.matched = z;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public String toHtml(boolean z) {
            return this.matched ? this.start ? getFormatStart(this.ch) : getFormatEnd(this.ch) : this.ch == '\"' ? "&quot;" : String.valueOf(this.ch);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Html.class */
    public static class Html extends Token {
        private String html;

        public Html(String str, String str2) {
            super(Token.Type.HTML, str);
            this.html = str2;
        }

        private static String trimLeadingWhitespace(String str) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= str.length() || !Character.isWhitespace(str.charAt(i))) {
                    break;
                }
                i2 = i + 1;
            }
            return str.substring(i);
        }

        public static String trimTrailingWhitespace(String str) {
            int i;
            int length = str.length();
            while (true) {
                i = length;
                if (i <= 0 || !Character.isWhitespace(str.charAt(i - 1))) {
                    break;
                }
                length = i - 1;
            }
            return str.substring(0, i);
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return true;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public String toHtml(boolean z) {
            return z ? this.html.toUpperCase() : this.html;
        }

        public void trimLeadingWhitespace() {
            this.text = trimLeadingWhitespace(this.text);
            this.html = trimLeadingWhitespace(this.html);
        }

        public void trimTrailingWhitespace() {
            this.text = trimTrailingWhitespace(this.text);
            this.html = trimTrailingWhitespace(this.html);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Link.class */
    public static class Link extends Token {
        private String url;

        public Link(String str, String str2) {
            super(Token.Type.LINK, str2);
            this.url = str;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getURL());
            info.add(getRawText());
            return info;
        }

        public String getURL() {
            return this.url;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$MusicTrack.class */
    public static class MusicTrack extends Token {
        private String track;

        public MusicTrack(String str) {
            super(Token.Type.MUSIC, str);
            this.track = str;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getTrack());
            return info;
        }

        public String getTrack() {
            return this.track;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Part.class */
    public static class Part {
        private String meText;
        private ArrayList<Token> tokens = new ArrayList<>();

        private String getPartType() {
            return isMedia() ? "d" : this.meText != null ? "m" : "";
        }

        public void add(Token token) {
            if (isMedia()) {
                throw new AssertionError("media ");
            }
            this.tokens.add(token);
        }

        public Token getMediaToken() {
            if (isMedia()) {
                return this.tokens.get(0);
            }
            return null;
        }

        public String getRawText() {
            StringBuilder sb = new StringBuilder();
            if (this.meText != null) {
                sb.append(this.meText);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.tokens.size()) {
                    return sb.toString();
                }
                sb.append(this.tokens.get(i2).getRawText());
                i = i2 + 1;
            }
        }

        public ArrayList<Token> getTokens() {
            return this.tokens;
        }

        public String getType(boolean z) {
            return (z ? "s" : "r") + getPartType();
        }

        public boolean isMedia() {
            return this.tokens.size() == 1 && this.tokens.get(0).isMedia();
        }

        public void setMeText(String str) {
            this.meText = str;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Photo.class */
    public static class Photo extends Token {
        private static final Pattern URL_PATTERN = Pattern.compile("http://picasaweb.google.com/([^/?#&]+)/+((?!searchbrowse)[^/?#&]+)(?:/|/photo)?(?:\\?[^#]*)?(?:#(.*))?");
        private String album;
        private String photo;
        private String user;

        public Photo(String str, String str2, String str3, String str4) {
            super(Token.Type.PHOTO, str4);
            this.user = str;
            this.album = str2;
            this.photo = str3;
        }

        public static String getAlbumURL(String str, String str2) {
            return "http://picasaweb.google.com/" + str + BridgeUtil.SPLIT_MARK + str2;
        }

        public static String getPhotoURL(String str, String str2, String str3) {
            return "http://picasaweb.google.com/" + str + BridgeUtil.SPLIT_MARK + str2 + "/photo#" + str3;
        }

        public static String getRssUrl(String str) {
            return "http://picasaweb.google.com/data/feed/api/user/" + str + "?category=album&alt=rss";
        }

        public static Photo matchURL(String str, String str2) {
            Matcher matcher = URL_PATTERN.matcher(str);
            if (matcher.matches()) {
                return new Photo(matcher.group(1), matcher.group(2), matcher.group(3), str2);
            }
            return null;
        }

        public String getAlbum() {
            return this.album;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getRssUrl(getUser()));
            info.add(getAlbumURL(getUser(), getAlbum()));
            if (getPhoto() != null) {
                info.add(getPhotoURL(getUser(), getAlbum(), getPhoto()));
                return info;
            }
            info.add(null);
            return info;
        }

        public String getPhoto() {
            return this.photo;
        }

        public String getUser() {
            return this.user;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isMedia() {
            return true;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Resources.class */
    public interface Resources {
        TrieNode getAcronyms();

        TrieNode getDomainSuffixes();

        Set<String> getSchemes();

        TrieNode getSmileys();
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Smiley.class */
    public static class Smiley extends Token {
        public Smiley(String str) {
            super(Token.Type.SMILEY, str);
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getRawText());
            return info;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Token.class */
    public static abstract class Token {
        protected String text;
        protected Type type;

        /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Token$Type.class */
        public enum Type {
            HTML(a.f),
            FORMAT("format"),
            LINK("l"),
            SMILEY(iu.h),
            ACRONYM("a"),
            MUSIC("m"),
            GOOGLE_VIDEO("v"),
            YOUTUBE_VIDEO("yt"),
            PHOTO("p"),
            FLICKR("f");
            
            private String stringRep;

            Type(String str) {
                this.stringRep = str;
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.stringRep;
            }
        }

        protected Token(Type type, String str) {
            this.type = type;
            this.text = str;
        }

        public boolean controlCaps() {
            return false;
        }

        public List<String> getInfo() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getType().toString());
            return arrayList;
        }

        public String getRawText() {
            return this.text;
        }

        public Type getType() {
            return this.type;
        }

        public boolean isArray() {
            return !isHtml();
        }

        public abstract boolean isHtml();

        public boolean isMedia() {
            return false;
        }

        public boolean setCaps() {
            return false;
        }

        public String toHtml(boolean z) {
            throw new AssertionError("not html");
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$TrieNode.class */
    public static class TrieNode {
        private final HashMap<Character, TrieNode> children;
        private String text;
        private String value;

        public TrieNode() {
            this("");
        }

        public TrieNode(String str) {
            this.children = new HashMap<>();
            this.text = str;
        }

        public static void addToTrie(TrieNode trieNode, String str, String str2) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    trieNode.setValue(str2);
                    return;
                } else {
                    trieNode = trieNode.getOrCreateChild(str.charAt(i2));
                    i = i2 + 1;
                }
            }
        }

        public final boolean exists() {
            return this.value != null;
        }

        public TrieNode getChild(char c2) {
            return this.children.get(Character.valueOf(c2));
        }

        public TrieNode getOrCreateChild(char c2) {
            Character valueOf = Character.valueOf(c2);
            TrieNode trieNode = this.children.get(valueOf);
            TrieNode trieNode2 = trieNode;
            if (trieNode == null) {
                trieNode2 = new TrieNode(this.text + String.valueOf(c2));
                this.children.put(valueOf, trieNode2);
            }
            return trieNode2;
        }

        public final String getText() {
            return this.text;
        }

        public final String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$Video.class */
    public static class Video extends Token {
        private static final Pattern URL_PATTERN = Pattern.compile("(?i)http://video\\.google\\.[a-z0-9]+(?:\\.[a-z0-9]+)?/videoplay\\?.*?\\bdocid=(-?\\d+).*");
        private String docid;

        public Video(String str, String str2) {
            super(Token.Type.GOOGLE_VIDEO, str2);
            this.docid = str;
        }

        public static String getRssUrl(String str) {
            return "http://video.google.com/videofeed?type=docid&output=rss&sourceid=gtalk&docid=" + str;
        }

        public static String getURL(String str) {
            return getURL(str, null);
        }

        public static String getURL(String str, String str2) {
            String str3;
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
                if (str2.length() > 0) {
                    str3 = str2 + "&";
                }
            }
            return "http://video.google.com/videoplay?" + str3 + "docid=" + str;
        }

        public static Video matchURL(String str, String str2) {
            Matcher matcher = URL_PATTERN.matcher(str);
            if (matcher.matches()) {
                return new Video(matcher.group(1), str2);
            }
            return null;
        }

        public String getDocID() {
            return this.docid;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getRssUrl(this.docid));
            info.add(getURL(this.docid));
            return info;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isMedia() {
            return true;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/google/android/util/AbstractMessageParser$YouTubeVideo.class */
    public static class YouTubeVideo extends Token {
        private static final Pattern URL_PATTERN = Pattern.compile("(?i)http://(?:[a-z0-9]+\\.)?youtube\\.[a-z0-9]+(?:\\.[a-z0-9]+)?/watch\\?.*\\bv=([-_a-zA-Z0-9=]+).*");
        private String docid;

        public YouTubeVideo(String str, String str2) {
            super(Token.Type.YOUTUBE_VIDEO, str2);
            this.docid = str;
        }

        public static String getPrefixedURL(boolean z, String str, String str2, String str3) {
            String str4;
            String str5 = z ? "http://" : "";
            String str6 = str;
            if (str == null) {
                str6 = "";
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
                if (str3.length() > 0) {
                    str4 = str3 + "&";
                }
            }
            return str5 + str6 + "youtube.com/watch?" + str4 + "v=" + str2;
        }

        public static String getRssUrl(String str) {
            return "http://youtube.com/watch?v=" + str;
        }

        public static String getURL(String str) {
            return getURL(str, null);
        }

        public static String getURL(String str, String str2) {
            String str3;
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
                if (str2.length() > 0) {
                    str3 = str2 + "&";
                }
            }
            return "http://youtube.com/watch?" + str3 + "v=" + str;
        }

        public static YouTubeVideo matchURL(String str, String str2) {
            Matcher matcher = URL_PATTERN.matcher(str);
            if (matcher.matches()) {
                return new YouTubeVideo(matcher.group(1), str2);
            }
            return null;
        }

        public String getDocID() {
            return this.docid;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public List<String> getInfo() {
            List<String> info = super.getInfo();
            info.add(getRssUrl(this.docid));
            info.add(getURL(this.docid));
            return info;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isHtml() {
            return false;
        }

        @Override // com.google.android.util.AbstractMessageParser.Token
        public boolean isMedia() {
            return true;
        }
    }

    public AbstractMessageParser(String str) {
        this(str, true, true, true, true, true, true);
    }

    public AbstractMessageParser(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.text = str;
        this.nextChar = 0;
        this.nextClass = 10;
        this.parts = new ArrayList<>();
        this.tokens = new ArrayList<>();
        this.formatStart = new HashMap<>();
        this.parseSmilies = z;
        this.parseAcronyms = z2;
        this.parseFormatting = z3;
        this.parseUrls = z4;
        this.parseMusic = z5;
        this.parseMeText = z6;
    }

    private void addToken(Token token) {
        this.tokens.add(token);
    }

    private void addURLToken(String str, String str2) {
        addToken(tokenForUrl(str, str2));
    }

    private void buildParts(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tokens.size()) {
                break;
            }
            Token token = this.tokens.get(i2);
            if (token.isMedia() || this.parts.size() == 0 || lastPart().isMedia()) {
                this.parts.add(new Part());
            }
            lastPart().add(token);
            i = i2 + 1;
        }
        if (this.parts.size() > 0) {
            this.parts.get(0).setMeText(str);
        }
    }

    private int getCharClass(int i) {
        if (i < 0 || this.text.length() <= i) {
            return 0;
        }
        char charAt = this.text.charAt(i);
        if (Character.isWhitespace(charAt)) {
            return 1;
        }
        if (Character.isLetter(charAt)) {
            return 2;
        }
        if (Character.isDigit(charAt)) {
            return 3;
        }
        if (isPunctuation(charAt)) {
            int i2 = this.nextClass + 1;
            this.nextClass = i2;
            return i2;
        }
        return 4;
    }

    private boolean isDomainChar(char c2) {
        return c2 == '-' || Character.isLetter(c2) || Character.isDigit(c2);
    }

    private static boolean isFormatChar(char c2) {
        switch (c2) {
            case '*':
            case '^':
            case '_':
                return true;
            default:
                return false;
        }
    }

    private static boolean isPunctuation(char c2) {
        switch (c2) {
            case '!':
            case '\"':
            case '(':
            case ')':
            case ',':
            case '.':
            case ':':
            case ';':
            case '?':
                return true;
            default:
                return false;
        }
    }

    private static boolean isSmileyBreak(char c2, char c3) {
        switch (c2) {
            case '$':
            case '&':
            case '*':
            case '+':
            case '-':
            case '/':
            case '<':
            case '=':
            case '>':
            case '@':
            case '[':
            case '\\':
            case ']':
            case '^':
            case '|':
            case '}':
            case '~':
                switch (c3) {
                    case '#':
                    case '$':
                    case '%':
                    case '*':
                    case '/':
                    case '<':
                    case '=':
                    case '>':
                    case '@':
                    case '[':
                    case '\\':
                    case '^':
                    case '~':
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private boolean isSmileyBreak(int i) {
        return i > 0 && i < this.text.length() && isSmileyBreak(this.text.charAt(i - 1), this.text.charAt(i));
    }

    private boolean isURLBreak(int i) {
        switch (getCharClass(i - 1)) {
            case 2:
            case 3:
            case 4:
                return false;
            default:
                return true;
        }
    }

    private boolean isValidDomain(String str) {
        return matches(getResources().getDomainSuffixes(), reverse(str));
    }

    private boolean isWordBreak(int i) {
        return getCharClass(i - 1) != getCharClass(i);
    }

    private Part lastPart() {
        return this.parts.get(this.parts.size() - 1);
    }

    private static TrieNode longestMatch(TrieNode trieNode, AbstractMessageParser abstractMessageParser, int i) {
        return longestMatch(trieNode, abstractMessageParser, i, false);
    }

    private static TrieNode longestMatch(TrieNode trieNode, AbstractMessageParser abstractMessageParser, int i, boolean z) {
        TrieNode trieNode2 = trieNode;
        TrieNode trieNode3 = null;
        while (i < abstractMessageParser.getRawText().length()) {
            int i2 = i + 1;
            trieNode2 = trieNode2.getChild(abstractMessageParser.getRawText().charAt(i));
            if (trieNode2 == null) {
                break;
            }
            if (trieNode2.exists()) {
                if (abstractMessageParser.isWordBreak(i2)) {
                    trieNode3 = trieNode2;
                    i = i2;
                } else if (z && abstractMessageParser.isSmileyBreak(i2)) {
                    trieNode3 = trieNode2;
                    i = i2;
                }
            }
            i = i2;
        }
        return trieNode3;
    }

    private static boolean matches(TrieNode trieNode, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return false;
            }
            trieNode = trieNode.getChild(str.charAt(i2));
            if (trieNode == null) {
                return false;
            }
            if (trieNode.exists()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private boolean parseAcronym() {
        TrieNode longestMatch;
        if (this.parseAcronyms && (longestMatch = longestMatch(getResources().getAcronyms(), this, this.nextChar)) != null) {
            addToken(new Acronym(longestMatch.getText(), longestMatch.getValue()));
            this.nextChar += longestMatch.getText().length();
            return true;
        }
        return false;
    }

    private boolean parseFormatting() {
        int i;
        if (this.parseFormatting) {
            int i2 = this.nextChar;
            while (true) {
                i = i2;
                if (i >= this.text.length() || !isFormatChar(this.text.charAt(i))) {
                    break;
                }
                i2 = i + 1;
            }
            if (i == this.nextChar || !isWordBreak(i)) {
                return false;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i3 = this.nextChar;
            while (true) {
                int i4 = i3;
                if (i4 >= i) {
                    break;
                }
                char charAt = this.text.charAt(i4);
                Character valueOf = Character.valueOf(charAt);
                if (linkedHashMap.containsKey(valueOf)) {
                    addToken(new Format(charAt, false));
                } else {
                    Format format = this.formatStart.get(valueOf);
                    if (format != null) {
                        format.setMatched(true);
                        this.formatStart.remove(valueOf);
                        linkedHashMap.put(valueOf, Boolean.TRUE);
                    } else {
                        Format format2 = new Format(charAt, true);
                        this.formatStart.put(valueOf, format2);
                        addToken(format2);
                        linkedHashMap.put(valueOf, Boolean.FALSE);
                    }
                }
                i3 = i4 + 1;
            }
            for (Character ch : linkedHashMap.keySet()) {
                if (linkedHashMap.get(ch) == Boolean.TRUE) {
                    Format format3 = new Format(ch.charValue(), false);
                    format3.setMatched(true);
                    addToken(format3);
                }
            }
            this.nextChar = i;
            return true;
        }
        return false;
    }

    private boolean parseMusicTrack() {
        if (this.parseMusic && this.text.startsWith(musicNote)) {
            addToken(new MusicTrack(this.text.substring(musicNote.length())));
            this.nextChar = this.text.length();
            return true;
        }
        return false;
    }

    private boolean parseSmiley() {
        TrieNode longestMatch;
        if (this.parseSmilies && (longestMatch = longestMatch(getResources().getSmileys(), this, this.nextChar, true)) != null) {
            int charClass = getCharClass(this.nextChar - 1);
            int charClass2 = getCharClass(this.nextChar + longestMatch.getText().length());
            if ((charClass == 2 || charClass == 3) && (charClass2 == 2 || charClass2 == 3)) {
                return false;
            }
            addToken(new Smiley(longestMatch.getText()));
            this.nextChar += longestMatch.getText().length();
            return true;
        }
        return false;
    }

    private void parseText() {
        StringBuilder sb = new StringBuilder();
        int i = this.nextChar;
        do {
            String str = this.text;
            int i2 = this.nextChar;
            this.nextChar = i2 + 1;
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\n':
                    sb.append("<br>");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
        } while (!isWordBreak(this.nextChar));
        addToken(new Html(this.text.substring(i, this.nextChar), sb.toString()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a4, code lost:
        if (isPunctuation(r0) != false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseURL() {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.util.AbstractMessageParser.parseURL():boolean");
    }

    protected static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return sb.toString();
            }
            sb.append(str.charAt(i));
            length = i;
        }
    }

    public static Token tokenForUrl(String str, String str2) {
        Video video;
        if (str == null) {
            video = null;
        } else {
            Video matchURL = Video.matchURL(str, str2);
            video = matchURL;
            if (matchURL == null) {
                YouTubeVideo matchURL2 = YouTubeVideo.matchURL(str, str2);
                if (matchURL2 != null) {
                    return matchURL2;
                }
                Photo matchURL3 = Photo.matchURL(str, str2);
                if (matchURL3 != null) {
                    return matchURL3;
                }
                FlickrPhoto matchURL4 = FlickrPhoto.matchURL(str, str2);
                return matchURL4 != null ? matchURL4 : new Link(str, str2);
            }
        }
        return video;
    }

    public final Part getPart(int i) {
        return this.parts.get(i);
    }

    public final int getPartCount() {
        return this.parts.size();
    }

    public final List<Part> getParts() {
        return this.parts;
    }

    public final String getRawText() {
        return this.text;
    }

    protected abstract Resources getResources();

    public void parse() {
        if (parseMusicTrack()) {
            buildParts(null);
            return;
        }
        String str = null;
        if (this.parseMeText) {
            str = null;
            if (this.text.startsWith("/me")) {
                str = null;
                if (this.text.length() > 3) {
                    str = null;
                    if (Character.isWhitespace(this.text.charAt(3))) {
                        str = this.text.substring(0, 4);
                        this.text = this.text.substring(4);
                    }
                }
            }
        }
        boolean z = false;
        while (this.nextChar < this.text.length()) {
            if (!isWordBreak(this.nextChar) && (!z || !isSmileyBreak(this.nextChar))) {
                throw new AssertionError("last chunk did not end at word break");
            }
            if (parseSmiley()) {
                z = true;
            } else {
                z = false;
                if (!parseAcronym()) {
                    z = false;
                    if (!parseURL()) {
                        z = false;
                        if (!parseFormatting()) {
                            parseText();
                            z = false;
                        }
                    }
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tokens.size()) {
                break;
            }
            if (this.tokens.get(i2).isMedia()) {
                if (i2 > 0 && (this.tokens.get(i2 - 1) instanceof Html)) {
                    ((Html) this.tokens.get(i2 - 1)).trimLeadingWhitespace();
                }
                if (i2 + 1 < this.tokens.size() && (this.tokens.get(i2 + 1) instanceof Html)) {
                    ((Html) this.tokens.get(i2 + 1)).trimTrailingWhitespace();
                }
            }
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.tokens.size()) {
                buildParts(str);
                return;
            }
            int i5 = i4;
            if (this.tokens.get(i4).isHtml()) {
                i5 = i4;
                if (this.tokens.get(i4).toHtml(true).length() == 0) {
                    this.tokens.remove(i4);
                    i5 = i4 - 1;
                }
            }
            i3 = i5 + 1;
        }
    }

    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        Iterator<Part> it = this.parts.iterator();
        while (it.hasNext()) {
            boolean z = false;
            sb.append("<p>");
            Iterator<Token> it2 = it.next().getTokens().iterator();
            while (it2.hasNext()) {
                Token next = it2.next();
                if (next.isHtml()) {
                    sb.append(next.toHtml(z));
                } else {
                    switch (AnonymousClass1.$SwitchMap$com$google$android$util$AbstractMessageParser$Token$Type[next.getType().ordinal()]) {
                        case 1:
                            sb.append("<a href=\"");
                            sb.append(((Link) next).getURL());
                            sb.append("\">");
                            sb.append(next.getRawText());
                            sb.append("</a>");
                            break;
                        case 2:
                            sb.append(next.getRawText());
                            break;
                        case 3:
                            sb.append(next.getRawText());
                            break;
                        case 4:
                            sb.append(((MusicTrack) next).getTrack());
                            break;
                        case 5:
                            sb.append("<a href=\"");
                            Video video = (Video) next;
                            sb.append(Video.getURL(((Video) next).getDocID()));
                            sb.append("\">");
                            sb.append(next.getRawText());
                            sb.append("</a>");
                            break;
                        case 6:
                            sb.append("<a href=\"");
                            YouTubeVideo youTubeVideo = (YouTubeVideo) next;
                            sb.append(YouTubeVideo.getURL(((YouTubeVideo) next).getDocID()));
                            sb.append("\">");
                            sb.append(next.getRawText());
                            sb.append("</a>");
                            break;
                        case 7:
                            sb.append("<a href=\"");
                            sb.append(Photo.getAlbumURL(((Photo) next).getUser(), ((Photo) next).getAlbum()));
                            sb.append("\">");
                            sb.append(next.getRawText());
                            sb.append("</a>");
                            break;
                        case 8:
                            Photo photo = (Photo) next;
                            sb.append("<a href=\"");
                            sb.append(((FlickrPhoto) next).getUrl());
                            sb.append("\">");
                            sb.append(next.getRawText());
                            sb.append("</a>");
                            break;
                        default:
                            throw new AssertionError("unknown token type: " + next.getType());
                    }
                }
                if (next.controlCaps()) {
                    z = next.setCaps();
                }
            }
            sb.append("</p>\n");
        }
        return sb.toString();
    }
}
