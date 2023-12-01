package android.graphics;

import android.content.ContentResolver;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/LegacyFontListParser.class */
public class LegacyFontListParser {

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/LegacyFontListParser$Family.class */
    public static class Family {
        public List<String> nameset = new ArrayList();
        public List<String> fileset = new ArrayList();

        public String getName() {
            if (this.nameset == null || this.nameset.isEmpty()) {
                return null;
            }
            return this.nameset.get(0);
        }
    }

    public static List<Family> parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            return readFamilySet(newPullParser);
        } finally {
            inputStream.close();
        }
    }

    private static Family readFamily(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Family family = new Family();
        xmlPullParser.require(2, null, "family");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("nameset")) {
                    family.nameset = readNameset(xmlPullParser);
                } else if (name.equals("fileset")) {
                    family.fileset = readFileset(xmlPullParser);
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        return family;
    }

    private static List<Family> readFamilySet(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("family")) {
                arrayList.add(readFamily(xmlPullParser));
            }
        }
        return arrayList;
    }

    private static List<String> readFileset(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "fileset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(ContentResolver.SCHEME_FILE)) {
                    arrayList.add(readText(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private static List<String> readNameset(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, null, "nameset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("name")) {
                    arrayList.add(readText(xmlPullParser));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        return arrayList;
    }

    private static String readText(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = "";
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            xmlPullParser.nextTag();
        }
        return str;
    }

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
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
