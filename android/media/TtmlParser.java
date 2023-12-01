package android.media;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-9557208-dex2jar.jar:android/media/TtmlParser.class */
class TtmlParser {
    private static final int DEFAULT_FRAMERATE = 30;
    private static final int DEFAULT_SUBFRAMERATE = 1;
    private static final int DEFAULT_TICKRATE = 1;
    static final String TAG = "TtmlParser";
    private long mCurrentRunId;
    private final TtmlNodeListener mListener;
    private XmlPullParser mParser;

    public TtmlParser(TtmlNodeListener ttmlNodeListener) {
        this.mListener = ttmlNodeListener;
    }

    private void extractAttribute(XmlPullParser xmlPullParser, int i, StringBuilder sb) {
        sb.append(" ");
        sb.append(xmlPullParser.getAttributeName(i));
        sb.append("=\"");
        sb.append(xmlPullParser.getAttributeValue(i));
        sb.append("\"");
    }

    private boolean isEndOfDoc() throws XmlPullParserException {
        return this.mParser.getEventType() == 1;
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals(TtmlUtils.TAG_BODY) || str.equals(TtmlUtils.TAG_DIV) || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals(TtmlUtils.TAG_STYLING) || str.equals("layout") || str.equals(TtmlUtils.TAG_REGION) || str.equals(TtmlUtils.TAG_METADATA) || str.equals(TtmlUtils.TAG_SMPTE_IMAGE) || str.equals(TtmlUtils.TAG_SMPTE_DATA) || str.equals(TtmlUtils.TAG_SMPTE_INFORMATION);
    }

    private void loadParser(String str) throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(false);
        this.mParser = newInstance.newPullParser();
        this.mParser.setInput(new StringReader(str));
    }

    private TtmlNode parseNode(TtmlNode ttmlNode) throws XmlPullParserException, IOException {
        if (this.mParser.getEventType() != 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        long j = 0;
        long j2 = Long.MAX_VALUE;
        long j3 = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mParser.getAttributeCount()) {
                break;
            }
            String attributeName = this.mParser.getAttributeName(i2);
            String attributeValue = this.mParser.getAttributeValue(i2);
            String replaceFirst = attributeName.replaceFirst("^.*:", "");
            if (replaceFirst.equals("begin")) {
                j = TtmlUtils.parseTimeExpression(attributeValue, 30, 1, 1);
            } else if (replaceFirst.equals("end")) {
                j2 = TtmlUtils.parseTimeExpression(attributeValue, 30, 1, 1);
            } else if (replaceFirst.equals(TtmlUtils.ATTR_DURATION)) {
                j3 = TtmlUtils.parseTimeExpression(attributeValue, 30, 1, 1);
            } else {
                extractAttribute(this.mParser, i2, sb);
            }
            i = i2 + 1;
        }
        long j4 = j;
        long j5 = j2;
        if (ttmlNode != null) {
            long j6 = j + ttmlNode.mStartTimeMs;
            j4 = j6;
            j5 = j2;
            if (j2 != Long.MAX_VALUE) {
                j5 = j2 + ttmlNode.mStartTimeMs;
                j4 = j6;
            }
        }
        long j7 = j5;
        if (j3 > 0) {
            if (j5 != Long.MAX_VALUE) {
                Log.e(TAG, "'dur' and 'end' attributes are defined at the same time.'end' value is ignored.");
            }
            j7 = j4 + j3;
        }
        long j8 = j7;
        if (ttmlNode != null) {
            j8 = j7;
            if (j7 == Long.MAX_VALUE) {
                j8 = j7;
                if (ttmlNode.mEndTimeMs != Long.MAX_VALUE) {
                    j8 = j7;
                    if (j7 > ttmlNode.mEndTimeMs) {
                        j8 = ttmlNode.mEndTimeMs;
                    }
                }
            }
        }
        return new TtmlNode(this.mParser.getName(), sb.toString(), null, j4, j8, ttmlNode, this.mCurrentRunId);
    }

    private void parseTtml() throws XmlPullParserException, IOException {
        boolean z;
        int i;
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        boolean z2 = true;
        while (!isEndOfDoc()) {
            int eventType = this.mParser.getEventType();
            TtmlNode ttmlNode = (TtmlNode) linkedList.peekLast();
            if (z2) {
                if (eventType == 2) {
                    if (isSupportedTag(this.mParser.getName())) {
                        TtmlNode parseNode = parseNode(ttmlNode);
                        linkedList.addLast(parseNode);
                        z = z2;
                        i = i2;
                        if (ttmlNode != null) {
                            ttmlNode.mChildren.add(parseNode);
                            z = z2;
                            i = i2;
                        }
                    } else {
                        Log.w(TAG, "Unsupported tag " + this.mParser.getName() + " is ignored.");
                        i = i2 + 1;
                        z = false;
                    }
                } else if (eventType == 4) {
                    String applyDefaultSpacePolicy = TtmlUtils.applyDefaultSpacePolicy(this.mParser.getText());
                    z = z2;
                    i = i2;
                    if (!TextUtils.isEmpty(applyDefaultSpacePolicy)) {
                        ttmlNode.mChildren.add(new TtmlNode(TtmlUtils.PCDATA, "", applyDefaultSpacePolicy, 0L, Long.MAX_VALUE, ttmlNode, this.mCurrentRunId));
                        z = z2;
                        i = i2;
                    }
                } else {
                    z = z2;
                    i = i2;
                    if (eventType == 3) {
                        if (this.mParser.getName().equals("p")) {
                            this.mListener.onTtmlNodeParsed((TtmlNode) linkedList.getLast());
                        } else if (this.mParser.getName().equals("tt")) {
                            this.mListener.onRootNodeParsed((TtmlNode) linkedList.getLast());
                        }
                        linkedList.removeLast();
                        z = z2;
                        i = i2;
                    }
                }
            } else if (eventType == 2) {
                i = i2 + 1;
                z = z2;
            } else {
                z = z2;
                i = i2;
                if (eventType == 3) {
                    int i3 = i2 - 1;
                    z = z2;
                    i = i3;
                    if (i3 == 0) {
                        z = true;
                        i = i3;
                    }
                }
            }
            this.mParser.next();
            z2 = z;
            i2 = i;
        }
    }

    public void parse(String str, long j) throws XmlPullParserException, IOException {
        this.mParser = null;
        this.mCurrentRunId = j;
        loadParser(str);
        parseTtml();
    }
}
