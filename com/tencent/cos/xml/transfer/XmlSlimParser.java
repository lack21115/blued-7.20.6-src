package com.tencent.cos.xml.transfer;

import android.util.Xml;
import com.google.common.net.HttpHeaders;
import com.opos.acs.st.STManager;
import com.tencent.cos.xml.model.tag.CopyObject;
import com.tencent.cos.xml.model.tag.InitiateMultipartUpload;
import com.tencent.cos.xml.model.tag.ListParts;
import com.tencent.cos.xml.model.tag.PostResponse;
import com.tencent.cos.xml.utils.BaseXmlSlimParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/XmlSlimParser.class */
public class XmlSlimParser extends BaseXmlSlimParser {
    public static void parseCopyObjectResult(InputStream inputStream, CopyObject copyObject) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return;
            }
            if (i == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    copyObject.eTag = newPullParser.getText();
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    copyObject.lastModified = newPullParser.getText();
                }
            }
            eventType = newPullParser.next();
        }
    }

    public static void parseInitiateMultipartUploadResult(InputStream inputStream, InitiateMultipartUpload initiateMultipartUpload) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return;
            }
            if (i == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    initiateMultipartUpload.bucket = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    initiateMultipartUpload.key = newPullParser.getText();
                } else if (name.equalsIgnoreCase("UploadId")) {
                    newPullParser.next();
                    initiateMultipartUpload.uploadId = newPullParser.getText();
                }
            }
            eventType = newPullParser.next();
        }
    }

    public static void parseListPartsResult(InputStream inputStream, ListParts listParts) throws XmlPullParserException, IOException {
        ListParts.Owner owner;
        ListParts.Initiator initiator;
        ListParts.Part part;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        listParts.parts = new ArrayList();
        ListParts.Owner owner2 = null;
        ListParts.Part part2 = null;
        ListParts.Initiator initiator2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    listParts.bucket = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("Encoding-type")) {
                    newPullParser.next();
                    listParts.encodingType = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    listParts.key = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("UploadId")) {
                    newPullParser.next();
                    listParts.uploadId = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListParts.Owner();
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("Initiator")) {
                    initiator = new ListParts.Initiator();
                    owner = owner2;
                    part = part2;
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    if (owner2 != null) {
                        owner2.id = newPullParser.getText();
                        owner = owner2;
                        initiator = initiator2;
                        part = part2;
                    } else {
                        owner = owner2;
                        initiator = initiator2;
                        part = part2;
                        if (initiator2 != null) {
                            initiator2.id = newPullParser.getText();
                            owner = owner2;
                            initiator = initiator2;
                            part = part2;
                        }
                    }
                } else if (name.equalsIgnoreCase("DisplayName")) {
                    newPullParser.next();
                    if (owner2 != null) {
                        owner2.disPlayName = newPullParser.getText();
                        owner = owner2;
                        initiator = initiator2;
                        part = part2;
                    } else {
                        owner = owner2;
                        initiator = initiator2;
                        part = part2;
                        if (initiator2 != null) {
                            initiator2.disPlayName = newPullParser.getText();
                            owner = owner2;
                            initiator = initiator2;
                            part = part2;
                        }
                    }
                } else if (name.equalsIgnoreCase("PartNumberMarker")) {
                    newPullParser.next();
                    listParts.partNumberMarker = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    listParts.storageClass = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("NextPartNumberMarker")) {
                    newPullParser.next();
                    listParts.nextPartNumberMarker = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("MaxParts")) {
                    newPullParser.next();
                    listParts.maxParts = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listParts.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("Part")) {
                    part = new ListParts.Part();
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("PartNumber")) {
                    newPullParser.next();
                    part2.partNumber = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    part2.lastModified = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    part2.eTag = newPullParser.getText();
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                } else {
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                    if (name.equalsIgnoreCase("Size")) {
                        newPullParser.next();
                        part2.size = newPullParser.getText();
                        part = part2;
                        initiator = initiator2;
                        owner = owner2;
                    }
                }
            } else if (eventType != 3) {
                owner = owner2;
                initiator = initiator2;
                part = part2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Owner")) {
                    listParts.owner = owner2;
                    owner = null;
                    initiator = initiator2;
                    part = part2;
                } else if (name2.equalsIgnoreCase("Initiator")) {
                    listParts.initiator = initiator2;
                    initiator = null;
                    owner = owner2;
                    part = part2;
                } else {
                    owner = owner2;
                    initiator = initiator2;
                    part = part2;
                    if (name2.equalsIgnoreCase("Part")) {
                        listParts.parts.add(part2);
                        part = null;
                        owner = owner2;
                        initiator = initiator2;
                    }
                }
            }
            eventType = newPullParser.next();
            owner2 = owner;
            initiator2 = initiator;
            part2 = part;
        }
    }

    public static void parsePostResponseResult(InputStream inputStream, PostResponse postResponse) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return;
            }
            if (i == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase(HttpHeaders.LOCATION)) {
                    newPullParser.next();
                    postResponse.location = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    postResponse.bucket = newPullParser.getText();
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    postResponse.key = newPullParser.getText();
                } else if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    postResponse.eTag = newPullParser.getText();
                }
            }
            eventType = newPullParser.next();
        }
    }
}
