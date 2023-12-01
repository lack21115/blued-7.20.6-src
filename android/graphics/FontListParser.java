package android.graphics;

import android.speech.tts.TextToSpeech;
import android.util.Xml;
import com.sobot.chat.widget.html.SobotCustomTagHandler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/FontListParser.class */
public class FontListParser {

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/FontListParser$Alias.class */
    public static class Alias {
        public String name;
        public String toName;
        public int weight;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/FontListParser$Config.class */
    public static class Config {
        public List<Family> families = new ArrayList();
        public List<Alias> aliases = new ArrayList();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/FontListParser$Family.class */
    public static class Family {
        public List<Font> fonts;
        public String lang;
        public String name;
        public String variant;

        public Family(String str, List<Font> list, String str2, String str3) {
            this.name = str;
            this.fonts = list;
            this.lang = str2;
            this.variant = str3;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/FontListParser$Font.class */
    public static class Font {
        public String fontName;
        public boolean isItalic;
        public int weight;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Font(String str, int i, boolean z) {
            this.fontName = str;
            this.weight = i;
            this.isItalic = z;
        }
    }

    public static boolean isLegacyFormat(InputStream inputStream) throws XmlPullParserException, IOException {
        if (inputStream.markSupported()) {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            newPullParser.require(2, null, "familyset");
            boolean z = newPullParser.getAttributeValue(null, "version") == null;
            inputStream.reset();
            return z;
        }
        throw new IllegalArgumentException("InputStream does not support mark");
    }

    public static Config parse(File file, String str) throws XmlPullParserException, IOException {
        return parse(new FileInputStream(file), str);
    }

    public static Config parse(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        Config config;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = !(inputStream instanceof BufferedInputStream) ? new BufferedInputStream(inputStream) : (BufferedInputStream) inputStream;
            BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
            bufferedInputStream2.mark(inputStream.available());
            BufferedInputStream bufferedInputStream4 = bufferedInputStream2;
            if (isLegacyFormat(bufferedInputStream2)) {
                BufferedInputStream bufferedInputStream5 = bufferedInputStream2;
                Config parseLegacyFormat = parseLegacyFormat(bufferedInputStream2, str);
                config = parseLegacyFormat;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                    config = parseLegacyFormat;
                }
            } else {
                Config parseNormalFormat = parseNormalFormat(bufferedInputStream2, str);
                config = parseNormalFormat;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                    return parseNormalFormat;
                }
            }
            return config;
        } catch (Throwable th) {
            if (0 != 0) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public static Config parseLegacyFormat(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        try {
            return new FontListConverter(LegacyFontListParser.parse(inputStream), str).convert();
        } finally {
            inputStream.close();
        }
    }

    public static Config parseNormalFormat(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        newPullParser.nextTag();
        return readFamilies(newPullParser, str);
    }

    private static Alias readAlias(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Alias alias = new Alias();
        alias.name = xmlPullParser.getAttributeValue(null, "name");
        alias.toName = xmlPullParser.getAttributeValue(null, "to");
        String attributeValue = xmlPullParser.getAttributeValue(null, "weight");
        if (attributeValue == null) {
            alias.weight = 400;
        } else {
            alias.weight = Integer.parseInt(attributeValue);
        }
        skip(xmlPullParser);
        return alias;
    }

    private static Config readFamilies(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        Config config = new Config();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    config.families.add(readFamily(xmlPullParser, str));
                } else if (xmlPullParser.getName().equals("alias")) {
                    config.aliases.add(readAlias(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        return config;
    }

    private static Family readFamily(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "lang");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, TextToSpeech.Engine.KEY_PARAM_VARIANT);
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(SobotCustomTagHandler.HTML_FONT)) {
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, "weight");
                    arrayList.add(new Font(str + File.separatorChar + xmlPullParser.nextText(), attributeValue4 == null ? 400 : Integer.parseInt(attributeValue4), "italic".equals(xmlPullParser.getAttributeValue(null, "style"))));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        return new Family(attributeValue, arrayList, attributeValue2, attributeValue3);
    }

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
