package com.tencent.cos.xml.transfer;

import android.util.Xml;
import com.alipay.sdk.packet.e;
import com.opos.acs.st.STManager;
import com.tencent.cos.xml.model.tag.AccelerateConfiguration;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.model.tag.BucketLoggingStatus;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.model.tag.DeleteResult;
import com.tencent.cos.xml.model.tag.DomainConfiguration;
import com.tencent.cos.xml.model.tag.InventoryConfiguration;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.model.tag.ListBucket;
import com.tencent.cos.xml.model.tag.ListBucketVersions;
import com.tencent.cos.xml.model.tag.ListInventoryConfiguration;
import com.tencent.cos.xml.model.tag.ListVersionResult;
import com.tencent.cos.xml.model.tag.LocationConstraint;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.model.tag.Tagging;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.cos.xml.model.tag.WebsiteConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/XmlParser.class */
public class XmlParser extends XmlSlimParser {
    public static void parseAccelerateConfiguration(InputStream inputStream, AccelerateConfiguration accelerateConfiguration) throws XmlPullParserException, IOException {
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
                if ("Status".equalsIgnoreCase(name)) {
                    newPullParser.next();
                    accelerateConfiguration.status = newPullParser.getText();
                } else if ("Type".equalsIgnoreCase(name)) {
                    newPullParser.next();
                    accelerateConfiguration.type = newPullParser.getText();
                }
            }
            eventType = newPullParser.next();
        }
    }

    public static void parseAccessControlPolicy(InputStream inputStream, AccessControlPolicy accessControlPolicy) throws XmlPullParserException, IOException {
        AccessControlPolicy.Owner owner;
        AccessControlPolicy.Grant grant;
        AccessControlPolicy.Grantee grantee;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        accessControlPolicy.accessControlList = new AccessControlPolicy.AccessControlList();
        accessControlPolicy.accessControlList.grants = new ArrayList();
        AccessControlPolicy.Owner owner2 = null;
        AccessControlPolicy.Grantee grantee2 = null;
        AccessControlPolicy.Grant grant2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Owner")) {
                    owner = new AccessControlPolicy.Owner();
                    grant = grant2;
                    grantee = grantee2;
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    if (owner2 != null) {
                        owner2.id = newPullParser.getText();
                        owner = owner2;
                        grant = grant2;
                        grantee = grantee2;
                    } else {
                        owner = owner2;
                        grant = grant2;
                        grantee = grantee2;
                        if (grantee2 != null) {
                            grantee2.id = newPullParser.getText();
                            owner = owner2;
                            grant = grant2;
                            grantee = grantee2;
                        }
                    }
                } else if (name.equalsIgnoreCase("DisplayName")) {
                    newPullParser.next();
                    if (owner2 != null) {
                        owner2.displayName = newPullParser.getText();
                        owner = owner2;
                        grant = grant2;
                        grantee = grantee2;
                    } else {
                        owner = owner2;
                        grant = grant2;
                        grantee = grantee2;
                        if (grantee2 != null) {
                            grantee2.displayName = newPullParser.getText();
                            owner = owner2;
                            grant = grant2;
                            grantee = grantee2;
                        }
                    }
                } else if (name.equalsIgnoreCase("Grant")) {
                    grant = new AccessControlPolicy.Grant();
                    owner = owner2;
                    grantee = grantee2;
                } else if (name.equalsIgnoreCase("Grantee")) {
                    grantee = new AccessControlPolicy.Grantee();
                    owner = owner2;
                    grant = grant2;
                } else if (name.equalsIgnoreCase("URI")) {
                    newPullParser.next();
                    grantee2.uri = newPullParser.getText();
                    owner = owner2;
                    grant = grant2;
                    grantee = grantee2;
                } else {
                    owner = owner2;
                    grant = grant2;
                    grantee = grantee2;
                    if (name.equalsIgnoreCase("Permission")) {
                        newPullParser.next();
                        grant2.permission = newPullParser.getText();
                        grantee = grantee2;
                        grant = grant2;
                        owner = owner2;
                    }
                }
            } else if (eventType != 3) {
                owner = owner2;
                grant = grant2;
                grantee = grantee2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Owner")) {
                    accessControlPolicy.owner = owner2;
                    owner = null;
                    grant = grant2;
                    grantee = grantee2;
                } else if (name2.equalsIgnoreCase("Grant")) {
                    accessControlPolicy.accessControlList.grants.add(grant2);
                    grant = null;
                    owner = owner2;
                    grantee = grantee2;
                } else {
                    owner = owner2;
                    grant = grant2;
                    grantee = grantee2;
                    if (name2.equalsIgnoreCase("Grantee")) {
                        grant2.grantee = grantee2;
                        grantee = null;
                        owner = owner2;
                        grant = grant2;
                    }
                }
            }
            eventType = newPullParser.next();
            owner2 = owner;
            grant2 = grant;
            grantee2 = grantee;
        }
    }

    public static void parseBucketLoggingStatus(InputStream inputStream, BucketLoggingStatus bucketLoggingStatus) throws XmlPullParserException, IOException {
        BucketLoggingStatus.LoggingEnabled loggingEnabled;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        BucketLoggingStatus.LoggingEnabled loggingEnabled2 = null;
        while (true) {
            BucketLoggingStatus.LoggingEnabled loggingEnabled3 = loggingEnabled2;
            if (eventType == 1) {
                return;
            }
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("LoggingEnabled")) {
                    loggingEnabled = new BucketLoggingStatus.LoggingEnabled();
                } else if (name.equalsIgnoreCase("TargetBucket")) {
                    newPullParser.next();
                    loggingEnabled3.targetBucket = newPullParser.getText();
                    loggingEnabled = loggingEnabled3;
                } else {
                    loggingEnabled = loggingEnabled3;
                    if (name.equalsIgnoreCase("TargetPrefix")) {
                        newPullParser.next();
                        loggingEnabled3.targetPrefix = newPullParser.getText();
                        loggingEnabled = loggingEnabled3;
                    }
                }
            } else if (eventType != 3) {
                loggingEnabled = loggingEnabled3;
            } else {
                loggingEnabled = loggingEnabled3;
                if (newPullParser.getName().equalsIgnoreCase("LoggingEnabled")) {
                    bucketLoggingStatus.loggingEnabled = loggingEnabled3;
                    loggingEnabled = null;
                }
            }
            eventType = newPullParser.next();
            loggingEnabled2 = loggingEnabled;
        }
    }

    public static void parseCORSConfiguration(InputStream inputStream, CORSConfiguration cORSConfiguration) throws XmlPullParserException, IOException {
        CORSConfiguration.CORSRule cORSRule;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        cORSConfiguration.corsRules = new ArrayList();
        CORSConfiguration.CORSRule cORSRule2 = null;
        while (true) {
            CORSConfiguration.CORSRule cORSRule3 = cORSRule2;
            if (eventType == 1) {
                return;
            }
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("CORSRule")) {
                    cORSRule = new CORSConfiguration.CORSRule();
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    cORSRule3.id = newPullParser.getText();
                    cORSRule = cORSRule3;
                } else if (name.equalsIgnoreCase("AllowedOrigin")) {
                    newPullParser.next();
                    cORSRule3.allowedOrigin = newPullParser.getText();
                    cORSRule = cORSRule3;
                } else if (name.equalsIgnoreCase("AllowedMethod")) {
                    newPullParser.next();
                    if (cORSRule3.allowedMethod == null) {
                        cORSRule3.allowedMethod = new ArrayList();
                    }
                    cORSRule3.allowedMethod.add(newPullParser.getText());
                    cORSRule = cORSRule3;
                } else if (name.equalsIgnoreCase("AllowedHeader")) {
                    newPullParser.next();
                    if (cORSRule3.allowedHeader == null) {
                        cORSRule3.allowedHeader = new ArrayList();
                    }
                    cORSRule3.allowedHeader.add(newPullParser.getText());
                    cORSRule = cORSRule3;
                } else if (name.equalsIgnoreCase("ExposeHeader")) {
                    newPullParser.next();
                    if (cORSRule3.exposeHeader == null) {
                        cORSRule3.exposeHeader = new ArrayList();
                    }
                    cORSRule3.exposeHeader.add(newPullParser.getText());
                    cORSRule = cORSRule3;
                } else {
                    cORSRule = cORSRule3;
                    if (name.equalsIgnoreCase("MaxAgeSeconds")) {
                        newPullParser.next();
                        cORSRule3.maxAgeSeconds = Integer.parseInt(newPullParser.getText());
                        cORSRule = cORSRule3;
                    }
                }
            } else if (eventType != 3) {
                cORSRule = cORSRule3;
            } else {
                cORSRule = cORSRule3;
                if (newPullParser.getName().equalsIgnoreCase("CORSRule")) {
                    cORSConfiguration.corsRules.add(cORSRule3);
                    cORSRule = null;
                }
            }
            eventType = newPullParser.next();
            cORSRule2 = cORSRule;
        }
    }

    public static void parseDeleteResult(InputStream inputStream, DeleteResult deleteResult) throws XmlPullParserException, IOException {
        DeleteResult.Deleted deleted;
        DeleteResult.Error error;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        deleteResult.errorList = new ArrayList();
        deleteResult.deletedList = new ArrayList();
        DeleteResult.Deleted deleted2 = null;
        DeleteResult.Error error2 = null;
        while (true) {
            DeleteResult.Error error3 = error2;
            if (eventType == 1) {
                return;
            }
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Deleted")) {
                    deleted = new DeleteResult.Deleted();
                    error = error3;
                } else if (name.equalsIgnoreCase("Error")) {
                    error = new DeleteResult.Error();
                    deleted = deleted2;
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    if (deleted2 != null) {
                        deleted2.key = newPullParser.getText();
                        deleted = deleted2;
                        error = error3;
                    } else {
                        deleted = deleted2;
                        error = error3;
                        if (error3 != null) {
                            error3.key = newPullParser.getText();
                            deleted = deleted2;
                            error = error3;
                        }
                    }
                } else if (name.equalsIgnoreCase("VersionId")) {
                    newPullParser.next();
                    if (deleted2 != null) {
                        deleted2.versionId = newPullParser.getText();
                        deleted = deleted2;
                        error = error3;
                    } else {
                        deleted = deleted2;
                        error = error3;
                        if (error3 != null) {
                            error3.versionId = newPullParser.getText();
                            deleted = deleted2;
                            error = error3;
                        }
                    }
                } else if (name.equalsIgnoreCase("DeleteMarker")) {
                    newPullParser.next();
                    deleted2.deleteMarker = Boolean.parseBoolean(newPullParser.getText());
                    deleted = deleted2;
                    error = error3;
                } else if (name.equalsIgnoreCase("DeleteMarkerVersionId")) {
                    newPullParser.next();
                    deleted2.deleteMarkerVersionId = newPullParser.getText();
                    deleted = deleted2;
                    error = error3;
                } else {
                    deleted = deleted2;
                    error = error3;
                    if (name.equalsIgnoreCase("Message")) {
                        newPullParser.next();
                        error3.message = newPullParser.getText();
                        error = error3;
                        deleted = deleted2;
                    }
                }
            } else if (eventType != 3) {
                deleted = deleted2;
                error = error3;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Deleted")) {
                    deleteResult.deletedList.add(deleted2);
                    deleted = null;
                    error = error3;
                } else {
                    deleted = deleted2;
                    error = error3;
                    if (name2.equalsIgnoreCase("Error")) {
                        deleteResult.errorList.add(error3);
                        error = null;
                        deleted = deleted2;
                    }
                }
            }
            eventType = newPullParser.next();
            deleted2 = deleted;
            error2 = error;
        }
    }

    public static void parseDomainConfiguration(InputStream inputStream, DomainConfiguration domainConfiguration) throws XmlPullParserException, IOException {
        DomainConfiguration.DomainRule domainRule;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        domainConfiguration.domainRules = new ArrayList();
        DomainConfiguration.DomainRule domainRule2 = null;
        while (true) {
            DomainConfiguration.DomainRule domainRule3 = domainRule2;
            if (eventType == 1) {
                return;
            }
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("DomainRule")) {
                    domainRule = new DomainConfiguration.DomainRule();
                } else if (name.equalsIgnoreCase("Status")) {
                    newPullParser.next();
                    domainRule3.status = newPullParser.getText();
                    domainRule = domainRule3;
                } else if (name.equalsIgnoreCase("Name")) {
                    newPullParser.next();
                    domainRule3.name = newPullParser.getText();
                    domainRule = domainRule3;
                } else {
                    domainRule = domainRule3;
                    if (name.equalsIgnoreCase("Type")) {
                        newPullParser.next();
                        domainRule3.type = newPullParser.getText();
                        domainRule = domainRule3;
                    }
                }
            } else if (eventType != 3) {
                domainRule = domainRule3;
            } else {
                domainRule = domainRule3;
                if (newPullParser.getName().equalsIgnoreCase("DomainRule")) {
                    domainConfiguration.domainRules.add(domainRule3);
                    domainRule = null;
                }
            }
            eventType = newPullParser.next();
            domainRule2 = domainRule;
        }
    }

    public static void parseGetBucketObjectVersionsResult(InputStream inputStream, ListVersionResult listVersionResult) throws XmlPullParserException, IOException {
        ListVersionResult.Owner owner;
        ListVersionResult.DeleteMarker deleteMarker;
        ListVersionResult.Version version;
        ListVersionResult.CommonPrefixes commonPrefixes;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        listVersionResult.commonPrefixes = linkedList;
        listVersionResult.deleteMarkers = linkedList3;
        listVersionResult.versions = linkedList2;
        ListVersionResult.Owner owner2 = null;
        ListVersionResult.CommonPrefixes commonPrefixes2 = null;
        ListVersionResult.Version version2 = null;
        ListVersionResult.DeleteMarker deleteMarker2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Name")) {
                    newPullParser.next();
                    listVersionResult.name = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Encoding-Type")) {
                    newPullParser.next();
                    listVersionResult.encodingType = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("KeyMarker")) {
                    newPullParser.next();
                    listVersionResult.keyMarker = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("VersionIdMarker")) {
                    newPullParser.next();
                    listVersionResult.versionIdMarker = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("MaxKeys")) {
                    newPullParser.next();
                    listVersionResult.maxKeys = Integer.parseInt(newPullParser.getText());
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Delimiter")) {
                    newPullParser.next();
                    listVersionResult.delimiter = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("NextKeyMarker")) {
                    newPullParser.next();
                    listVersionResult.nextKeyMarker = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listVersionResult.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("NextVersionIdMarker")) {
                    newPullParser.next();
                    listVersionResult.nextVersionIdMarker = newPullParser.getText();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    if (commonPrefixes2 == null) {
                        listVersionResult.prefix = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    } else {
                        commonPrefixes2.prefix = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    if (version2 != null) {
                        version2.key = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    } else {
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                        if (deleteMarker2 != null) {
                            deleteMarker2.key = newPullParser.getText();
                            owner = owner2;
                            deleteMarker = deleteMarker2;
                            version = version2;
                            commonPrefixes = commonPrefixes2;
                        }
                    }
                } else if (name.equalsIgnoreCase("VersionId")) {
                    newPullParser.next();
                    if (version2 != null) {
                        version2.versionID = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    } else {
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                        if (deleteMarker2 != null) {
                            deleteMarker2.versionId = newPullParser.getText();
                            owner = owner2;
                            deleteMarker = deleteMarker2;
                            version = version2;
                            commonPrefixes = commonPrefixes2;
                        }
                    }
                } else if (name.equalsIgnoreCase("IsLatest")) {
                    newPullParser.next();
                    if (version2 != null) {
                        version2.isLatest = Boolean.valueOf(newPullParser.getText()).booleanValue();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    } else {
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                        if (deleteMarker2 != null) {
                            deleteMarker2.isLatest = Boolean.valueOf(newPullParser.getText()).booleanValue();
                            owner = owner2;
                            deleteMarker = deleteMarker2;
                            version = version2;
                            commonPrefixes = commonPrefixes2;
                        }
                    }
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    if (version2 != null) {
                        version2.lastModified = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    } else {
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                        if (deleteMarker2 != null) {
                            deleteMarker2.lastModified = newPullParser.getText();
                            owner = owner2;
                            deleteMarker = deleteMarker2;
                            version = version2;
                            commonPrefixes = commonPrefixes2;
                        }
                    }
                } else if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (version2 != null) {
                        version2.etag = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("Size")) {
                    newPullParser.next();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (version2 != null) {
                        version2.size = Long.valueOf(newPullParser.getText()).longValue();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (version2 != null) {
                        version2.storageClass = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListVersionResult.Owner();
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (owner2 != null) {
                        owner2.id = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("DisplayName")) {
                    newPullParser.next();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (owner2 != null) {
                        owner2.displayName = newPullParser.getText();
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("DeleteMarker")) {
                    deleteMarker = new ListVersionResult.DeleteMarker();
                    owner = owner2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase(e.e)) {
                    version = new ListVersionResult.Version();
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    commonPrefixes = commonPrefixes2;
                } else {
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (name.equalsIgnoreCase("CommonPrefixes")) {
                        commonPrefixes = new ListVersionResult.CommonPrefixes();
                        version = version2;
                        deleteMarker = deleteMarker2;
                        owner = owner2;
                    }
                }
            } else if (eventType != 3) {
                owner = owner2;
                deleteMarker = deleteMarker2;
                version = version2;
                commonPrefixes = commonPrefixes2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Owner")) {
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (owner2 != null) {
                        if (deleteMarker2 != null) {
                            deleteMarker2.owner = owner2;
                        } else if (version2 != null) {
                            version2.owner = owner2;
                        }
                        owner = null;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name2.equalsIgnoreCase("DeleteMarker")) {
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (deleteMarker2 != null) {
                        linkedList3.add(deleteMarker2);
                        deleteMarker = null;
                        owner = owner2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name2.equalsIgnoreCase(e.e)) {
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (version2 != null) {
                        linkedList2.add(version2);
                        version = null;
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else {
                    owner = owner2;
                    deleteMarker = deleteMarker2;
                    version = version2;
                    commonPrefixes = commonPrefixes2;
                    if (name2.equalsIgnoreCase("CommonPrefixes")) {
                        owner = owner2;
                        deleteMarker = deleteMarker2;
                        version = version2;
                        commonPrefixes = commonPrefixes2;
                        if (commonPrefixes2 != null) {
                            linkedList.add(commonPrefixes2);
                            commonPrefixes = null;
                            owner = owner2;
                            deleteMarker = deleteMarker2;
                            version = version2;
                        }
                    }
                }
            }
            eventType = newPullParser.next();
            owner2 = owner;
            deleteMarker2 = deleteMarker;
            version2 = version;
            commonPrefixes2 = commonPrefixes;
        }
    }

    public static void parseInventoryConfiguration(InputStream inputStream, InventoryConfiguration inventoryConfiguration) throws XmlPullParserException, IOException {
        InventoryConfiguration.COSBucketDestination cOSBucketDestination;
        InventoryConfiguration.OptionalFields optionalFields;
        InventoryConfiguration.Filter filter;
        InventoryConfiguration.Schedule schedule;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        InventoryConfiguration.COSBucketDestination cOSBucketDestination2 = null;
        InventoryConfiguration.Schedule schedule2 = null;
        InventoryConfiguration.Filter filter2 = null;
        InventoryConfiguration.OptionalFields optionalFields2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Id")) {
                    newPullParser.next();
                    inventoryConfiguration.id = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("IsEnabled")) {
                    newPullParser.next();
                    inventoryConfiguration.isEnabled = Boolean.valueOf(newPullParser.getText()).booleanValue();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("COSBucketDestination")) {
                    cOSBucketDestination = new InventoryConfiguration.COSBucketDestination();
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Format")) {
                    newPullParser.next();
                    cOSBucketDestination2.format = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("AccountId")) {
                    newPullParser.next();
                    cOSBucketDestination2.accountId = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    cOSBucketDestination2.bucket = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    if (cOSBucketDestination2 != null) {
                        cOSBucketDestination2.prefix = newPullParser.getText();
                        cOSBucketDestination = cOSBucketDestination2;
                        optionalFields = optionalFields2;
                        filter = filter2;
                        schedule = schedule2;
                    } else {
                        cOSBucketDestination = cOSBucketDestination2;
                        optionalFields = optionalFields2;
                        filter = filter2;
                        schedule = schedule2;
                        if (filter2 != null) {
                            filter2.prefix = newPullParser.getText();
                            cOSBucketDestination = cOSBucketDestination2;
                            optionalFields = optionalFields2;
                            filter = filter2;
                            schedule = schedule2;
                        }
                    }
                } else if (name.equalsIgnoreCase("Encryption")) {
                    cOSBucketDestination2.encryption = new InventoryConfiguration.Encryption();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("SSE-COS")) {
                    newPullParser.next();
                    cOSBucketDestination2.encryption.sSECOS = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Schedule")) {
                    schedule = new InventoryConfiguration.Schedule();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                } else if (name.equalsIgnoreCase("Frequency")) {
                    newPullParser.next();
                    schedule2.frequency = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Filter")) {
                    filter = new InventoryConfiguration.Filter();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("IncludedObjectVersions")) {
                    newPullParser.next();
                    inventoryConfiguration.includedObjectVersions = newPullParser.getText();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("OptionalFields")) {
                    optionalFields = new InventoryConfiguration.OptionalFields();
                    optionalFields.fields = new HashSet(6);
                    cOSBucketDestination = cOSBucketDestination2;
                    filter = filter2;
                    schedule = schedule2;
                } else {
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                    if (name.equalsIgnoreCase("Field")) {
                        newPullParser.next();
                        optionalFields2.fields.add(newPullParser.getText());
                        schedule = schedule2;
                        filter = filter2;
                        optionalFields = optionalFields2;
                        cOSBucketDestination = cOSBucketDestination2;
                    }
                }
            } else if (eventType != 3) {
                cOSBucketDestination = cOSBucketDestination2;
                optionalFields = optionalFields2;
                filter = filter2;
                schedule = schedule2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("COSBucketDestination")) {
                    inventoryConfiguration.destination = new InventoryConfiguration.Destination();
                    inventoryConfiguration.destination.cosBucketDestination = cOSBucketDestination2;
                    cOSBucketDestination = null;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name2.equalsIgnoreCase("OptionalFields")) {
                    inventoryConfiguration.optionalFields = optionalFields2;
                    optionalFields = null;
                    cOSBucketDestination = cOSBucketDestination2;
                    filter = filter2;
                    schedule = schedule2;
                } else if (name2.equalsIgnoreCase("Filter")) {
                    inventoryConfiguration.filter = filter2;
                    filter = null;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else {
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    filter = filter2;
                    schedule = schedule2;
                    if (name2.equalsIgnoreCase("Schedule")) {
                        inventoryConfiguration.schedule = schedule2;
                        schedule = null;
                        cOSBucketDestination = cOSBucketDestination2;
                        optionalFields = optionalFields2;
                        filter = filter2;
                    }
                }
            }
            eventType = newPullParser.next();
            cOSBucketDestination2 = cOSBucketDestination;
            optionalFields2 = optionalFields;
            filter2 = filter;
            schedule2 = schedule;
        }
    }

    public static void parseLifecycleConfiguration(InputStream inputStream, LifecycleConfiguration lifecycleConfiguration) throws XmlPullParserException, IOException {
        LifecycleConfiguration.Rule rule;
        LifecycleConfiguration.Filter filter;
        LifecycleConfiguration.Transition transition;
        LifecycleConfiguration.NoncurrentVersionExpiration noncurrentVersionExpiration;
        LifecycleConfiguration.NoncurrentVersionTransition noncurrentVersionTransition;
        LifecycleConfiguration.Expiration expiration;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        lifecycleConfiguration.rules = new ArrayList();
        LifecycleConfiguration.Rule rule2 = null;
        LifecycleConfiguration.Filter filter2 = null;
        LifecycleConfiguration.Transition transition2 = null;
        LifecycleConfiguration.NoncurrentVersionExpiration noncurrentVersionExpiration2 = null;
        LifecycleConfiguration.NoncurrentVersionTransition noncurrentVersionTransition2 = null;
        LifecycleConfiguration.Expiration expiration2 = null;
        LifecycleConfiguration.AbortIncompleteMultiUpload abortIncompleteMultiUpload = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            if (eventType != 2) {
                if (eventType == 3) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("Rule")) {
                        lifecycleConfiguration.rules.add(rule2);
                        rule2 = null;
                    } else if (name.equalsIgnoreCase("Filter")) {
                        rule2.filter = filter2;
                        filter2 = null;
                    } else if (name.equalsIgnoreCase("Transition")) {
                        rule2.transition = transition2;
                        transition2 = null;
                    } else if (name.equalsIgnoreCase("NoncurrentVersionExpiration")) {
                        rule2.noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionExpiration2 = null;
                    } else if (name.equalsIgnoreCase("NoncurrentVersionTransition")) {
                        rule2.noncurrentVersionTransition = noncurrentVersionTransition2;
                        noncurrentVersionTransition2 = null;
                    } else if (name.equalsIgnoreCase("Expiration")) {
                        rule2.expiration = expiration2;
                        expiration2 = null;
                    } else if (name.equalsIgnoreCase("AbortIncompleteMultipartUpload")) {
                        rule2.abortIncompleteMultiUpload = abortIncompleteMultiUpload;
                        abortIncompleteMultiUpload = null;
                    }
                }
                rule = rule2;
                filter = filter2;
                transition = transition2;
                noncurrentVersionExpiration = noncurrentVersionExpiration2;
                noncurrentVersionTransition = noncurrentVersionTransition2;
                expiration = expiration2;
                expiration2 = expiration;
                noncurrentVersionTransition2 = noncurrentVersionTransition;
                noncurrentVersionExpiration2 = noncurrentVersionExpiration;
                transition2 = transition;
                filter2 = filter;
                rule2 = rule;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Rule")) {
                    rule = new LifecycleConfiguration.Rule();
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    rule2.id = newPullParser.getText();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("Filter")) {
                    filter = new LifecycleConfiguration.Filter();
                    rule = rule2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    filter2.prefix = newPullParser.getText();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("Status")) {
                    newPullParser.next();
                    rule2.status = newPullParser.getText();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("Transition")) {
                    transition = new LifecycleConfiguration.Transition();
                    rule = rule2;
                    filter = filter2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("Expiration")) {
                    expiration = new LifecycleConfiguration.Expiration();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                } else if (name2.equalsIgnoreCase("Days")) {
                    newPullParser.next();
                    if (transition2 != null) {
                        transition2.days = Integer.parseInt(newPullParser.getText());
                        rule = rule2;
                        filter = filter2;
                        transition = transition2;
                        noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionTransition = noncurrentVersionTransition2;
                        expiration = expiration2;
                    } else {
                        rule = rule2;
                        filter = filter2;
                        transition = transition2;
                        noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionTransition = noncurrentVersionTransition2;
                        expiration = expiration2;
                        if (rule2.expiration != null) {
                            expiration2.days = Integer.parseInt(newPullParser.getText());
                            rule = rule2;
                            filter = filter2;
                            transition = transition2;
                            noncurrentVersionExpiration = noncurrentVersionExpiration2;
                            noncurrentVersionTransition = noncurrentVersionTransition2;
                            expiration = expiration2;
                        }
                    }
                } else if (name2.equalsIgnoreCase("Date")) {
                    newPullParser.next();
                    if (transition2 != null) {
                        transition2.date = newPullParser.getText();
                        rule = rule2;
                        filter = filter2;
                        transition = transition2;
                        noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionTransition = noncurrentVersionTransition2;
                        expiration = expiration2;
                    } else {
                        rule = rule2;
                        filter = filter2;
                        transition = transition2;
                        noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionTransition = noncurrentVersionTransition2;
                        expiration = expiration2;
                        if (expiration2 != null) {
                            expiration2.date = newPullParser.getText();
                            rule = rule2;
                            filter = filter2;
                            transition = transition2;
                            noncurrentVersionExpiration = noncurrentVersionExpiration2;
                            noncurrentVersionTransition = noncurrentVersionTransition2;
                            expiration = expiration2;
                        }
                    }
                } else if (name2.equalsIgnoreCase("ExpiredObjectDeleteMarker")) {
                    newPullParser.next();
                    expiration2.expiredObjectDeleteMarker = newPullParser.getText();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("AbortIncompleteMultipartUpload")) {
                    abortIncompleteMultiUpload = new LifecycleConfiguration.AbortIncompleteMultiUpload();
                } else if (name2.equalsIgnoreCase("DaysAfterInitiation")) {
                    newPullParser.next();
                    abortIncompleteMultiUpload.daysAfterInitiation = Integer.parseInt(newPullParser.getText());
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("NoncurrentVersionExpiration")) {
                    noncurrentVersionExpiration = new LifecycleConfiguration.NoncurrentVersionExpiration();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("NoncurrentVersionTransition")) {
                    noncurrentVersionTransition = new LifecycleConfiguration.NoncurrentVersionTransition();
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    expiration = expiration2;
                } else if (name2.equalsIgnoreCase("NoncurrentDays")) {
                    newPullParser.next();
                    if (noncurrentVersionExpiration2 != null) {
                        noncurrentVersionExpiration2.noncurrentDays = Integer.parseInt(newPullParser.getText());
                        rule = rule2;
                        filter = filter2;
                        transition = transition2;
                        noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionTransition = noncurrentVersionTransition2;
                        expiration = expiration2;
                    } else {
                        rule = rule2;
                        filter = filter2;
                        transition = transition2;
                        noncurrentVersionExpiration = noncurrentVersionExpiration2;
                        noncurrentVersionTransition = noncurrentVersionTransition2;
                        expiration = expiration2;
                        if (noncurrentVersionTransition2 != null) {
                            noncurrentVersionTransition2.noncurrentDays = Integer.parseInt(newPullParser.getText());
                            rule = rule2;
                            filter = filter2;
                            transition = transition2;
                            noncurrentVersionExpiration = noncurrentVersionExpiration2;
                            noncurrentVersionTransition = noncurrentVersionTransition2;
                            expiration = expiration2;
                        }
                    }
                } else {
                    rule = rule2;
                    filter = filter2;
                    transition = transition2;
                    noncurrentVersionExpiration = noncurrentVersionExpiration2;
                    noncurrentVersionTransition = noncurrentVersionTransition2;
                    expiration = expiration2;
                    if (name2.equalsIgnoreCase("StorageClass")) {
                        newPullParser.next();
                        if (transition2 != null) {
                            transition2.storageClass = newPullParser.getText();
                            rule = rule2;
                            filter = filter2;
                            transition = transition2;
                            noncurrentVersionExpiration = noncurrentVersionExpiration2;
                            noncurrentVersionTransition = noncurrentVersionTransition2;
                            expiration = expiration2;
                        } else {
                            rule = rule2;
                            filter = filter2;
                            transition = transition2;
                            noncurrentVersionExpiration = noncurrentVersionExpiration2;
                            noncurrentVersionTransition = noncurrentVersionTransition2;
                            expiration = expiration2;
                            if (noncurrentVersionTransition2 != null) {
                                noncurrentVersionTransition2.storageClass = newPullParser.getText();
                                expiration = expiration2;
                                noncurrentVersionTransition = noncurrentVersionTransition2;
                                noncurrentVersionExpiration = noncurrentVersionExpiration2;
                                transition = transition2;
                                filter = filter2;
                                rule = rule2;
                            }
                        }
                    }
                }
                expiration2 = expiration;
                noncurrentVersionTransition2 = noncurrentVersionTransition;
                noncurrentVersionExpiration2 = noncurrentVersionExpiration;
                transition2 = transition;
                filter2 = filter;
                rule2 = rule;
            }
        }
    }

    public static void parseListBucketResult(InputStream inputStream, ListBucket listBucket) throws XmlPullParserException, IOException {
        ListBucket.Contents contents;
        ListBucket.Owner owner;
        ListBucket.CommonPrefixes commonPrefixes;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        listBucket.contentsList = new ArrayList();
        listBucket.commonPrefixesList = new ArrayList();
        ListBucket.Contents contents2 = null;
        ListBucket.CommonPrefixes commonPrefixes2 = null;
        ListBucket.Owner owner2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Name")) {
                    newPullParser.next();
                    listBucket.name = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Encoding-Type")) {
                    newPullParser.next();
                    listBucket.encodingType = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Marker")) {
                    newPullParser.next();
                    listBucket.marker = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("MaxKeys")) {
                    newPullParser.next();
                    listBucket.maxKeys = Integer.parseInt(newPullParser.getText());
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Delimiter")) {
                    newPullParser.next();
                    listBucket.delimiter = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("NextMarker")) {
                    newPullParser.next();
                    listBucket.nextMarker = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listBucket.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    if (commonPrefixes2 == null) {
                        listBucket.prefix = newPullParser.getText();
                        contents = contents2;
                        owner = owner2;
                        commonPrefixes = commonPrefixes2;
                    } else {
                        commonPrefixes2.prefix = newPullParser.getText();
                        contents = contents2;
                        owner = owner2;
                        commonPrefixes = commonPrefixes2;
                    }
                } else if (name.equalsIgnoreCase("Contents")) {
                    contents = new ListBucket.Contents();
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    contents2.key = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    contents2.lastModified = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    contents2.eTag = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Size")) {
                    newPullParser.next();
                    contents2.size = Long.parseLong(newPullParser.getText());
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("StorageClass")) {
                    newPullParser.next();
                    contents2.storageClass = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListBucket.Owner();
                    contents = contents2;
                    commonPrefixes = commonPrefixes2;
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    owner2.id = newPullParser.getText();
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else {
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                    if (name.equalsIgnoreCase("CommonPrefixes")) {
                        commonPrefixes = new ListBucket.CommonPrefixes();
                        owner = owner2;
                        contents = contents2;
                    }
                }
            } else if (eventType != 3) {
                contents = contents2;
                owner = owner2;
                commonPrefixes = commonPrefixes2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Contents")) {
                    listBucket.contentsList.add(contents2);
                    contents = null;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                } else if (name2.equalsIgnoreCase("Owner")) {
                    contents2.owner = owner2;
                    owner = null;
                    contents = contents2;
                    commonPrefixes = commonPrefixes2;
                } else {
                    contents = contents2;
                    owner = owner2;
                    commonPrefixes = commonPrefixes2;
                    if (name2.equalsIgnoreCase("CommonPrefixes")) {
                        listBucket.commonPrefixesList.add(commonPrefixes2);
                        commonPrefixes = null;
                        contents = contents2;
                        owner = owner2;
                    }
                }
            }
            eventType = newPullParser.next();
            contents2 = contents;
            owner2 = owner;
            commonPrefixes2 = commonPrefixes;
        }
    }

    public static void parseListBucketVersions(InputStream inputStream, ListBucketVersions listBucketVersions) throws XmlPullParserException, IOException {
        ListBucketVersions.ObjectVersion objectVersion;
        ListBucketVersions.Owner owner;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        listBucketVersions.objectVersionList = new ArrayList();
        ListBucketVersions.ObjectVersion objectVersion2 = null;
        ListBucketVersions.Owner owner2 = null;
        while (true) {
            ListBucketVersions.Owner owner3 = owner2;
            if (eventType == 1) {
                return;
            }
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Name")) {
                    newPullParser.next();
                    listBucketVersions.name = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    listBucketVersions.prefix = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("KeyMarker")) {
                    newPullParser.next();
                    listBucketVersions.keyMarker = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("VersionIdMarker")) {
                    newPullParser.next();
                    listBucketVersions.versionIdMarker = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("MaxKeys")) {
                    newPullParser.next();
                    listBucketVersions.maxKeys = Long.parseLong(newPullParser.getText());
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listBucketVersions.isTruncated = Boolean.parseBoolean(newPullParser.getText());
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("NextKeyMarker")) {
                    newPullParser.next();
                    listBucketVersions.nextKeyMarker = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("NextVersionIdMarker")) {
                    newPullParser.next();
                    listBucketVersions.nextVersionIdMarker = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("DeleteMarker")) {
                    objectVersion = new ListBucketVersions.DeleteMarker();
                    owner = owner3;
                } else if (name.equalsIgnoreCase(e.e)) {
                    objectVersion = new ListBucketVersions.Version();
                    owner = owner3;
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    objectVersion2.key = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("VersionId")) {
                    newPullParser.next();
                    objectVersion2.versionId = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("IsLatest")) {
                    newPullParser.next();
                    objectVersion2.isLatest = Boolean.parseBoolean(newPullParser.getText());
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("LastModified")) {
                    newPullParser.next();
                    objectVersion2.lastModified = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("Owner")) {
                    owner = new ListBucketVersions.Owner();
                    objectVersion = objectVersion2;
                } else if (name.equalsIgnoreCase("UID")) {
                    newPullParser.next();
                    owner3.uid = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("ETag")) {
                    newPullParser.next();
                    ((ListBucketVersions.Version) objectVersion2).eTag = newPullParser.getText();
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else if (name.equalsIgnoreCase("Size")) {
                    newPullParser.next();
                    ((ListBucketVersions.Version) objectVersion2).size = Long.parseLong(newPullParser.getText());
                    objectVersion = objectVersion2;
                    owner = owner3;
                } else {
                    objectVersion = objectVersion2;
                    owner = owner3;
                    if (name.equalsIgnoreCase("StorageClass")) {
                        newPullParser.next();
                        ((ListBucketVersions.Version) objectVersion2).storageClass = newPullParser.getText();
                        owner = owner3;
                        objectVersion = objectVersion2;
                    }
                }
            } else if (eventType != 3) {
                objectVersion = objectVersion2;
                owner = owner3;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Owner")) {
                    objectVersion2.owner = owner3;
                    owner = null;
                    objectVersion = objectVersion2;
                } else {
                    if (name2.equalsIgnoreCase("DeleteMarker")) {
                        listBucketVersions.objectVersionList.add(objectVersion2);
                    } else {
                        objectVersion = objectVersion2;
                        owner = owner3;
                        if (name2.equalsIgnoreCase(e.e)) {
                            listBucketVersions.objectVersionList.add(objectVersion2);
                        }
                    }
                    objectVersion = null;
                    owner = owner3;
                }
            }
            eventType = newPullParser.next();
            objectVersion2 = objectVersion;
            owner2 = owner;
        }
    }

    public static void parseListInventoryConfiguration(InputStream inputStream, ListInventoryConfiguration listInventoryConfiguration) throws IOException, XmlPullParserException {
        InventoryConfiguration inventoryConfiguration;
        InventoryConfiguration.COSBucketDestination cOSBucketDestination;
        InventoryConfiguration.OptionalFields optionalFields;
        InventoryConfiguration.Schedule schedule;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        listInventoryConfiguration.inventoryConfigurations = new HashSet(20);
        InventoryConfiguration inventoryConfiguration2 = null;
        InventoryConfiguration.Schedule schedule2 = null;
        InventoryConfiguration.OptionalFields optionalFields2 = null;
        InventoryConfiguration.COSBucketDestination cOSBucketDestination2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("IsTruncated")) {
                    newPullParser.next();
                    listInventoryConfiguration.isTruncated = Boolean.valueOf(newPullParser.getText()).booleanValue();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("ContinuationToken")) {
                    newPullParser.next();
                    listInventoryConfiguration.continuationToken = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("NextContinuationToken")) {
                    newPullParser.next();
                    listInventoryConfiguration.nextContinuationToken = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("InventoryConfiguration")) {
                    inventoryConfiguration = new InventoryConfiguration();
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Id")) {
                    newPullParser.next();
                    inventoryConfiguration2.id = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("IsEnabled")) {
                    newPullParser.next();
                    inventoryConfiguration2.isEnabled = Boolean.valueOf(newPullParser.getText()).booleanValue();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("COSBucketDestination")) {
                    cOSBucketDestination = new InventoryConfiguration.COSBucketDestination();
                    inventoryConfiguration = inventoryConfiguration2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Format")) {
                    newPullParser.next();
                    cOSBucketDestination2.format = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("AccountId")) {
                    newPullParser.next();
                    cOSBucketDestination2.accountId = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    cOSBucketDestination2.bucket = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                    if (cOSBucketDestination2 != null) {
                        cOSBucketDestination2.prefix = newPullParser.getText();
                        inventoryConfiguration = inventoryConfiguration2;
                        cOSBucketDestination = cOSBucketDestination2;
                        optionalFields = optionalFields2;
                        schedule = schedule2;
                    }
                } else if (name.equalsIgnoreCase("Encryption")) {
                    newPullParser.next();
                    cOSBucketDestination2.encryption = new InventoryConfiguration.Encryption();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("SSE-COS")) {
                    newPullParser.next();
                    cOSBucketDestination2.encryption.sSECOS = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Schedule")) {
                    schedule = new InventoryConfiguration.Schedule();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                } else if (name.equalsIgnoreCase("Frequency")) {
                    newPullParser.next();
                    schedule2.frequency = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("Filter")) {
                    inventoryConfiguration2.filter = new InventoryConfiguration.Filter();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("IncludedObjectVersions")) {
                    newPullParser.next();
                    inventoryConfiguration2.includedObjectVersions = newPullParser.getText();
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name.equalsIgnoreCase("OptionalFields")) {
                    optionalFields = new InventoryConfiguration.OptionalFields();
                    optionalFields.fields = new HashSet(6);
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    schedule = schedule2;
                } else {
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                    if (name.equalsIgnoreCase("Field")) {
                        newPullParser.next();
                        optionalFields2.fields.add(newPullParser.getText());
                        schedule = schedule2;
                        optionalFields = optionalFields2;
                        cOSBucketDestination = cOSBucketDestination2;
                        inventoryConfiguration = inventoryConfiguration2;
                    }
                }
            } else if (eventType != 3) {
                inventoryConfiguration = inventoryConfiguration2;
                cOSBucketDestination = cOSBucketDestination2;
                optionalFields = optionalFields2;
                schedule = schedule2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("COSBucketDestination")) {
                    inventoryConfiguration2.destination = new InventoryConfiguration.Destination();
                    inventoryConfiguration2.destination.cosBucketDestination = cOSBucketDestination2;
                    cOSBucketDestination = null;
                    inventoryConfiguration = inventoryConfiguration2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name2.equalsIgnoreCase("OptionalFields")) {
                    inventoryConfiguration2.optionalFields = optionalFields2;
                    optionalFields = null;
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    schedule = schedule2;
                } else if (name2.equalsIgnoreCase("Filter")) {
                    inventoryConfiguration2.filter = null;
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                } else if (name2.equalsIgnoreCase("Schedule")) {
                    inventoryConfiguration2.schedule = schedule2;
                    schedule = null;
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                } else {
                    inventoryConfiguration = inventoryConfiguration2;
                    cOSBucketDestination = cOSBucketDestination2;
                    optionalFields = optionalFields2;
                    schedule = schedule2;
                    if (name2.equalsIgnoreCase("InventoryConfiguration")) {
                        listInventoryConfiguration.inventoryConfigurations.add(inventoryConfiguration2);
                        inventoryConfiguration = null;
                        cOSBucketDestination = cOSBucketDestination2;
                        optionalFields = optionalFields2;
                        schedule = schedule2;
                    }
                }
            }
            eventType = newPullParser.next();
            inventoryConfiguration2 = inventoryConfiguration;
            cOSBucketDestination2 = cOSBucketDestination;
            optionalFields2 = optionalFields;
            schedule2 = schedule;
        }
    }

    public static void parseLocationConstraint(InputStream inputStream, LocationConstraint locationConstraint) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return;
            }
            if (i == 2 && newPullParser.getName().equalsIgnoreCase("LocationConstraint")) {
                newPullParser.next();
                locationConstraint.location = newPullParser.getText();
            }
            eventType = newPullParser.next();
        }
    }

    public static void parseReplicationConfiguration(InputStream inputStream, ReplicationConfiguration replicationConfiguration) throws XmlPullParserException, IOException {
        ReplicationConfiguration.Rule rule;
        ReplicationConfiguration.Destination destination;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        replicationConfiguration.rules = new ArrayList();
        ReplicationConfiguration.Rule rule2 = null;
        ReplicationConfiguration.Destination destination2 = null;
        while (true) {
            ReplicationConfiguration.Destination destination3 = destination2;
            if (eventType == 1) {
                return;
            }
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("Role")) {
                    newPullParser.next();
                    replicationConfiguration.role = newPullParser.getText();
                    rule = rule2;
                    destination = destination3;
                } else if (name.equalsIgnoreCase("Rule")) {
                    rule = new ReplicationConfiguration.Rule();
                    destination = destination3;
                } else if (name.equalsIgnoreCase("Status")) {
                    newPullParser.next();
                    rule2.status = newPullParser.getText();
                    rule = rule2;
                    destination = destination3;
                } else if (name.equalsIgnoreCase(STManager.REGION_OF_ID)) {
                    newPullParser.next();
                    rule2.id = newPullParser.getText();
                    rule = rule2;
                    destination = destination3;
                } else if (name.equalsIgnoreCase("Prefix")) {
                    newPullParser.next();
                    rule2.prefix = newPullParser.getText();
                    rule = rule2;
                    destination = destination3;
                } else if (name.equalsIgnoreCase("Destination")) {
                    destination = new ReplicationConfiguration.Destination();
                    rule = rule2;
                } else if (name.equalsIgnoreCase("Bucket")) {
                    newPullParser.next();
                    destination3.bucket = newPullParser.getText();
                    rule = rule2;
                    destination = destination3;
                } else {
                    rule = rule2;
                    destination = destination3;
                    if (name.equalsIgnoreCase("StorageClass")) {
                        newPullParser.next();
                        destination3.storageClass = newPullParser.getText();
                        destination = destination3;
                        rule = rule2;
                    }
                }
            } else if (eventType != 3) {
                rule = rule2;
                destination = destination3;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("Rule")) {
                    replicationConfiguration.rules.add(rule2);
                    rule = null;
                    destination = destination3;
                } else {
                    rule = rule2;
                    destination = destination3;
                    if (name2.equalsIgnoreCase("Destination")) {
                        rule2.destination = destination3;
                        destination = null;
                        rule = rule2;
                    }
                }
            }
            eventType = newPullParser.next();
            rule2 = rule;
            destination2 = destination;
        }
    }

    public static void parseTagging(InputStream inputStream, Tagging tagging) throws XmlPullParserException, IOException {
        Tagging.TagSet tagSet;
        Tagging.Tag tag;
        String str;
        String str2;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        Tagging.TagSet tagSet2 = null;
        String str3 = null;
        String str4 = null;
        Tagging.Tag tag2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("TagSet".equalsIgnoreCase(name)) {
                    tagSet = new Tagging.TagSet();
                    tag = tag2;
                    str = str3;
                    str2 = str4;
                } else if ("Tag".equalsIgnoreCase(name)) {
                    tag = new Tagging.Tag();
                    tagSet = tagSet2;
                    str = str3;
                    str2 = str4;
                } else if ("Key".equalsIgnoreCase(name)) {
                    newPullParser.next();
                    str = newPullParser.getText();
                    tagSet = tagSet2;
                    tag = tag2;
                    str2 = str4;
                } else {
                    tagSet = tagSet2;
                    tag = tag2;
                    str = str3;
                    str2 = str4;
                    if ("Value".equalsIgnoreCase(name)) {
                        newPullParser.next();
                        str2 = newPullParser.getText();
                        str = str3;
                        tag = tag2;
                        tagSet = tagSet2;
                    }
                }
            } else if (eventType != 3) {
                tagSet = tagSet2;
                tag = tag2;
                str = str3;
                str2 = str4;
            } else {
                String name2 = newPullParser.getName();
                if ("TagSet".equalsIgnoreCase(name2)) {
                    tagging.tagSet = tagSet2;
                    tagSet = null;
                    tag = tag2;
                    str = str3;
                    str2 = str4;
                } else if ("Tag".equalsIgnoreCase(name2)) {
                    tagSet = tagSet2;
                    tag = tag2;
                    str = str3;
                    str2 = str4;
                    if (tagSet2 != null) {
                        tagSet2.addTag(tag2);
                        tagSet = tagSet2;
                        tag = tag2;
                        str = str3;
                        str2 = str4;
                    }
                } else if ("Key".equalsIgnoreCase(name2)) {
                    tagSet = tagSet2;
                    tag = tag2;
                    str = str3;
                    str2 = str4;
                    if (tag2 != null) {
                        tag2.key = str3;
                        tagSet = tagSet2;
                        tag = tag2;
                        str = str3;
                        str2 = str4;
                    }
                } else {
                    tagSet = tagSet2;
                    tag = tag2;
                    str = str3;
                    str2 = str4;
                    if ("Value".equalsIgnoreCase(name2)) {
                        tagSet = tagSet2;
                        tag = tag2;
                        str = str3;
                        str2 = str4;
                        if (tag2 != null) {
                            tag2.value = str4;
                            tagSet = tagSet2;
                            tag = tag2;
                            str = str3;
                            str2 = str4;
                        }
                    }
                }
            }
            eventType = newPullParser.next();
            tagSet2 = tagSet;
            tag2 = tag;
            str3 = str;
            str4 = str2;
        }
    }

    public static void parseVersioningConfiguration(InputStream inputStream, VersioningConfiguration versioningConfiguration) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return;
            }
            if (i == 2 && newPullParser.getName().equalsIgnoreCase("Status")) {
                newPullParser.next();
                versioningConfiguration.status = newPullParser.getText();
            }
            eventType = newPullParser.next();
        }
    }

    public static void parseWebsiteConfig(InputStream inputStream, WebsiteConfiguration websiteConfiguration) throws XmlPullParserException, IOException {
        WebsiteConfiguration.IndexDocument indexDocument;
        WebsiteConfiguration.ErrorDocument errorDocument;
        WebsiteConfiguration.RedirectAllRequestTo redirectAllRequestTo;
        WebsiteConfiguration.RoutingRule routingRule;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        int eventType = newPullParser.getEventType();
        websiteConfiguration.routingRules = new ArrayList();
        WebsiteConfiguration.IndexDocument indexDocument2 = null;
        WebsiteConfiguration.RoutingRule routingRule2 = null;
        WebsiteConfiguration.RedirectAllRequestTo redirectAllRequestTo2 = null;
        WebsiteConfiguration.ErrorDocument errorDocument2 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("IndexDocument")) {
                    indexDocument = new WebsiteConfiguration.IndexDocument();
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("Suffix")) {
                    newPullParser.next();
                    indexDocument2.suffix = newPullParser.getText();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("ErrorDocument")) {
                    errorDocument = new WebsiteConfiguration.ErrorDocument();
                    indexDocument = indexDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("Key")) {
                    newPullParser.next();
                    errorDocument2.key = newPullParser.getText();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("RedirectAllRequestsTo")) {
                    redirectAllRequestTo = new WebsiteConfiguration.RedirectAllRequestTo();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("Protocol")) {
                    newPullParser.next();
                    if (redirectAllRequestTo2 != null) {
                        redirectAllRequestTo2.protocol = newPullParser.getText();
                        indexDocument = indexDocument2;
                        errorDocument = errorDocument2;
                        redirectAllRequestTo = redirectAllRequestTo2;
                        routingRule = routingRule2;
                    } else {
                        routingRule2.redirect.protocol = newPullParser.getText();
                        indexDocument = indexDocument2;
                        errorDocument = errorDocument2;
                        redirectAllRequestTo = redirectAllRequestTo2;
                        routingRule = routingRule2;
                    }
                } else if (name.equalsIgnoreCase("RoutingRule")) {
                    routingRule = new WebsiteConfiguration.RoutingRule();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                } else if (name.equalsIgnoreCase("Condition")) {
                    routingRule2.contidion = new WebsiteConfiguration.Contidion();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("HttpErrorCodeReturnedEquals")) {
                    newPullParser.next();
                    routingRule2.contidion.httpErrorCodeReturnedEquals = Integer.parseInt(newPullParser.getText());
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("KeyPrefixEquals")) {
                    newPullParser.next();
                    routingRule2.contidion.keyPrefixEquals = newPullParser.getText();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("Redirect")) {
                    routingRule2.redirect = new WebsiteConfiguration.Redirect();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name.equalsIgnoreCase("ReplaceKeyPrefixWith")) {
                    newPullParser.next();
                    routingRule2.redirect.replaceKeyPrefixWith = newPullParser.getText();
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else {
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                    if (name.equalsIgnoreCase("ReplaceKeyWith")) {
                        newPullParser.next();
                        routingRule2.redirect.replaceKeyWith = newPullParser.getText();
                        routingRule = routingRule2;
                        redirectAllRequestTo = redirectAllRequestTo2;
                        errorDocument = errorDocument2;
                        indexDocument = indexDocument2;
                    }
                }
            } else if (eventType != 3) {
                indexDocument = indexDocument2;
                errorDocument = errorDocument2;
                redirectAllRequestTo = redirectAllRequestTo2;
                routingRule = routingRule2;
            } else {
                String name2 = newPullParser.getName();
                if (name2.equalsIgnoreCase("IndexDocument")) {
                    websiteConfiguration.indexDocument = indexDocument2;
                    indexDocument = null;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name2.equalsIgnoreCase("ErrorDocument")) {
                    websiteConfiguration.errorDocument = errorDocument2;
                    errorDocument = null;
                    indexDocument = indexDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                } else if (name2.equalsIgnoreCase("RedirectAllRequestsTo")) {
                    websiteConfiguration.redirectAllRequestTo = redirectAllRequestTo2;
                    redirectAllRequestTo = null;
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    routingRule = routingRule2;
                } else {
                    indexDocument = indexDocument2;
                    errorDocument = errorDocument2;
                    redirectAllRequestTo = redirectAllRequestTo2;
                    routingRule = routingRule2;
                    if (name2.equalsIgnoreCase("RoutingRule")) {
                        websiteConfiguration.routingRules.add(routingRule2);
                        routingRule = null;
                        indexDocument = indexDocument2;
                        errorDocument = errorDocument2;
                        redirectAllRequestTo = redirectAllRequestTo2;
                    }
                }
            }
            eventType = newPullParser.next();
            indexDocument2 = indexDocument;
            errorDocument2 = errorDocument;
            redirectAllRequestTo2 = redirectAllRequestTo;
            routingRule2 = routingRule;
        }
    }
}
