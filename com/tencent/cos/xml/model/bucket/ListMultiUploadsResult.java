package com.tencent.cos.xml.model.bucket;

import android.util.Xml;
import com.opos.acs.st.STManager;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListMultipartUploads;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/ListMultiUploadsResult.class */
public final class ListMultiUploadsResult extends CosXmlResult {
    public ListMultipartUploads listMultipartUploads;

    public static void parseListMultipartUploadsResult(InputStream inputStream, ListMultipartUploads listMultipartUploads) throws XmlPullParserException, IOException {
        ListMultipartUploads.Upload upload;
        ListMultipartUploads.CommonPrefixes commonPrefixes;
        ListMultipartUploads.Owner owner;
        ListMultipartUploads.Initiator initiator;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        listMultipartUploads.uploads = new ArrayList();
        listMultipartUploads.commonPrefixes = new ArrayList();
        ListMultipartUploads.Upload upload2 = null;
        ListMultipartUploads.Initiator initiator2 = null;
        ListMultipartUploads.Owner owner2 = null;
        ListMultipartUploads.CommonPrefixes commonPrefixes2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    listMultipartUploads.bucket = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("Encoding-Type")) {
                    newPullParser.next();
                    listMultipartUploads.encodingType = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("KeyMarker")) {
                    newPullParser.next();
                    listMultipartUploads.keyMarker = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("UploadIdMarker")) {
                    newPullParser.next();
                    listMultipartUploads.uploadIdMarker = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("NextKeyMarker")) {
                    newPullParser.next();
                    listMultipartUploads.nextKeyMarker = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("NextUploadIdMarker")) {
                    newPullParser.next();
                    listMultipartUploads.nextUploadIdMarker = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("MaxUploads")) {
                    newPullParser.next();
                    listMultipartUploads.maxUploads = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listMultipartUploads.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    if (commonPrefixes2 == null) {
                        listMultipartUploads.prefix = newPullParser.getText();
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                    } else {
                        commonPrefixes2.prefix = newPullParser.getText();
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                    }
                } else if (name.equalsIgnoreCase("Delimiter")) {
                    newPullParser.next();
                    listMultipartUploads.delimiter = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("Upload")) {
                    upload = new ListMultipartUploads.Upload();
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    upload2.key = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("UploadId")) {
                    newPullParser.next();
                    upload2.uploadID = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    upload2.storageClass = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("Initiator")) {
                    initiator = new ListMultipartUploads.Initiator();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                } else if (name.equalsIgnoreCase("UIN")) {
                    newPullParser.next();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                    if (initiator2 != null) {
                        initiator2.uin = newPullParser.getText();
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                    }
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListMultipartUploads.Owner();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    initiator = initiator2;
                } else if (name.equalsIgnoreCase("UID")) {
                    newPullParser.next();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                    if (owner2 != null) {
                        owner2.uid = newPullParser.getText();
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                    }
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    if (owner2 != null) {
                        owner2.id = newPullParser.getText();
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                    } else {
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                        if (initiator2 != null) {
                            initiator2.id = newPullParser.getText();
                            upload = upload2;
                            commonPrefixes = commonPrefixes2;
                            owner = owner2;
                            initiator = initiator2;
                        }
                    }
                } else if (name.equalsIgnoreCase("DisplayName")) {
                    newPullParser.next();
                    if (owner2 != null) {
                        owner2.displayName = newPullParser.getText();
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                    } else {
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                        initiator = initiator2;
                        if (initiator2 != null) {
                            initiator2.displayName = newPullParser.getText();
                            upload = upload2;
                            commonPrefixes = commonPrefixes2;
                            owner = owner2;
                            initiator = initiator2;
                        }
                    }
                } else if (name.equalsIgnoreCase("Initiated")) {
                    newPullParser.next();
                    upload2.initiated = newPullParser.getText();
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else {
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                    if (name.equalsIgnoreCase("CommonPrefixs")) {
                        commonPrefixes = new ListMultipartUploads.CommonPrefixes();
                        initiator = initiator2;
                        owner = owner2;
                        upload = upload2;
                    }
                }
            } else if (eventType != 3) {
                upload = upload2;
                commonPrefixes = commonPrefixes2;
                owner = owner2;
                initiator = initiator2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Upload")) {
                    listMultipartUploads.uploads.add(upload2);
                    upload = null;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name2.equalsIgnoreCase("CommonPrefixs")) {
                    listMultipartUploads.commonPrefixes.add(commonPrefixes2);
                    commonPrefixes = null;
                    upload = upload2;
                    owner = owner2;
                    initiator = initiator2;
                } else if (name2.equalsIgnoreCase("Owner")) {
                    upload2.owner = owner2;
                    owner = null;
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    initiator = initiator2;
                } else {
                    upload = upload2;
                    commonPrefixes = commonPrefixes2;
                    owner = owner2;
                    initiator = initiator2;
                    if (name2.equalsIgnoreCase("Initiator")) {
                        upload2.initiator = initiator2;
                        initiator = null;
                        upload = upload2;
                        commonPrefixes = commonPrefixes2;
                        owner = owner2;
                    }
                }
            }
            eventType = newPullParser.next();
            upload2 = upload;
            commonPrefixes2 = commonPrefixes;
            owner2 = owner;
            initiator2 = initiator;
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.listMultipartUploads = new ListMultipartUploads();
        try {
            parseListMultipartUploadsResult(httpResponse.byteStream(), this.listMultipartUploads);
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.POOR_NETWORK.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.SERVERERROR.getCode(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        ListMultipartUploads listMultipartUploads = this.listMultipartUploads;
        return listMultipartUploads != null ? listMultipartUploads.toString() : super.printResult();
    }
}
