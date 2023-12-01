package com.tencent.cos.xml.transfer;

import android.text.TextUtils;
import com.opos.acs.st.STManager;
import com.tencent.cos.xml.model.bucket.PutBucketIntelligentTieringRequest;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.model.tag.BucketLoggingStatus;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.model.tag.CreateBucketConfiguration;
import com.tencent.cos.xml.model.tag.Delete;
import com.tencent.cos.xml.model.tag.DomainConfiguration;
import com.tencent.cos.xml.model.tag.InventoryConfiguration;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.model.tag.RestoreConfigure;
import com.tencent.cos.xml.model.tag.Tagging;
import com.tencent.cos.xml.model.tag.VersioningConfiguration;
import com.tencent.cos.xml.model.tag.WebsiteConfiguration;
import com.tencent.cos.xml.model.tag.eventstreaming.CSVInput;
import com.tencent.cos.xml.model.tag.eventstreaming.CSVOutput;
import com.tencent.cos.xml.model.tag.eventstreaming.JSONInput;
import com.tencent.cos.xml.model.tag.eventstreaming.JSONOutput;
import com.tencent.cos.xml.model.tag.eventstreaming.SelectRequest;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.XMLConstants;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/XmlBuilder.class */
public class XmlBuilder extends XmlSlimBuilder {
    private static void addElement(XmlSerializer xmlSerializer, String str, String str2) throws IOException {
        if (str2 != null) {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        }
    }

    public static String buildAccessControlPolicyXML(AccessControlPolicy accessControlPolicy) throws XmlPullParserException, IOException {
        if (accessControlPolicy == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "AccessControlPolicy");
        newSerializer.startTag("", "Owner");
        addElement(newSerializer, STManager.REGION_OF_ID, accessControlPolicy.owner.id);
        newSerializer.endTag("", "Owner");
        newSerializer.startTag("", "AccessControlList");
        for (AccessControlPolicy.Grant grant : accessControlPolicy.accessControlList.grants) {
            newSerializer.startTag("", "Grant");
            if (!TextUtils.isEmpty(grant.grantee.uri)) {
                newSerializer.setPrefix("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
                newSerializer.startTag("", "Grantee");
                newSerializer.attribute("", "xsi:type", "CanonicalUser");
                addElement(newSerializer, "URI", grant.grantee.uri);
                newSerializer.endTag("", "Grantee");
            } else if (!TextUtils.isEmpty(grant.grantee.id)) {
                newSerializer.setPrefix("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
                newSerializer.startTag("", "Grantee");
                newSerializer.attribute("", "xsi:type", "Group");
                addElement(newSerializer, STManager.REGION_OF_ID, grant.grantee.id);
                newSerializer.endTag("", "Grantee");
            }
            addElement(newSerializer, "Permission", grant.permission);
            newSerializer.endTag("", "Grant");
        }
        newSerializer.endTag("", "AccessControlList");
        newSerializer.endTag("", "AccessControlPolicy");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildBucketLogging(BucketLoggingStatus bucketLoggingStatus) throws XmlPullParserException, IOException {
        if (bucketLoggingStatus == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "BucketLoggingStatus");
        if (bucketLoggingStatus.loggingEnabled != null) {
            newSerializer.startTag("", "LoggingEnabled");
            addElement(newSerializer, "TargetBucket", bucketLoggingStatus.loggingEnabled.targetBucket);
            addElement(newSerializer, "TargetPrefix", bucketLoggingStatus.loggingEnabled.targetPrefix);
            newSerializer.endTag("", "LoggingEnabled");
        }
        newSerializer.endTag("", "BucketLoggingStatus");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildCORSConfigurationXML(CORSConfiguration cORSConfiguration) throws XmlPullParserException, IOException {
        if (cORSConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "CORSConfiguration");
        if (cORSConfiguration.corsRules != null) {
            for (CORSConfiguration.CORSRule cORSRule : cORSConfiguration.corsRules) {
                if (cORSRule != null) {
                    newSerializer.startTag("", "CORSRule");
                    addElement(newSerializer, STManager.REGION_OF_ID, cORSRule.id);
                    addElement(newSerializer, "AllowedOrigin", cORSRule.allowedOrigin);
                    if (cORSRule.allowedMethod != null) {
                        for (String str : cORSRule.allowedMethod) {
                            addElement(newSerializer, "AllowedMethod", str);
                        }
                    }
                    if (cORSRule.allowedHeader != null) {
                        for (String str2 : cORSRule.allowedHeader) {
                            addElement(newSerializer, "AllowedHeader", str2);
                        }
                    }
                    if (cORSRule.exposeHeader != null) {
                        for (String str3 : cORSRule.exposeHeader) {
                            addElement(newSerializer, "ExposeHeader", str3);
                        }
                    }
                    addElement(newSerializer, "MaxAgeSeconds", String.valueOf(cORSRule.maxAgeSeconds));
                    newSerializer.endTag("", "CORSRule");
                }
            }
        }
        newSerializer.endTag("", "CORSConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildCreateBucketConfiguration(CreateBucketConfiguration createBucketConfiguration) throws XmlPullParserException, IOException {
        if (createBucketConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "CreateBucketConfiguration");
        addElement(newSerializer, "BucketAZConfig", createBucketConfiguration.bucketAzConfig);
        newSerializer.endTag("", "CreateBucketConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildDelete(Delete delete) throws XmlPullParserException, IOException {
        if (delete == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "Delete");
        addElement(newSerializer, "Quiet", String.valueOf(delete.quiet));
        if (delete.deleteObjects != null) {
            for (Delete.DeleteObject deleteObject : delete.deleteObjects) {
                if (deleteObject != null) {
                    newSerializer.startTag("", "Object");
                    addElement(newSerializer, "Key", deleteObject.key);
                    addElement(newSerializer, "VersionId", deleteObject.versionId);
                    newSerializer.endTag("", "Object");
                }
            }
        }
        newSerializer.endTag("", "Delete");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildDomainConfiguration(DomainConfiguration domainConfiguration) throws IOException, XmlPullParserException {
        if (domainConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "DomainConfiguration");
        if (domainConfiguration.domainRules != null && domainConfiguration.domainRules.size() > 0) {
            for (DomainConfiguration.DomainRule domainRule : domainConfiguration.domainRules) {
                newSerializer.startTag("", "DomainRule");
                addElement(newSerializer, "Status", domainRule.status);
                addElement(newSerializer, "Name", domainRule.name);
                addElement(newSerializer, "Type", domainRule.type);
                addElement(newSerializer, "ForcedReplacement", domainRule.forcedReplacement);
                newSerializer.endTag("", "DomainRule");
            }
        }
        newSerializer.endTag("", "DomainConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildInventoryConfiguration(InventoryConfiguration inventoryConfiguration) throws IOException, XmlPullParserException {
        if (inventoryConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "InventoryConfiguration");
        if (inventoryConfiguration.id != null) {
            addElement(newSerializer, "Id", inventoryConfiguration.id);
        }
        addElement(newSerializer, "IsEnabled", inventoryConfiguration.isEnabled ? "true" : "false");
        if (inventoryConfiguration.destination != null) {
            newSerializer.startTag("", "Destination");
            if (inventoryConfiguration.destination.cosBucketDestination != null) {
                newSerializer.startTag("", "COSBucketDestination");
                if (inventoryConfiguration.destination.cosBucketDestination.format != null) {
                    addElement(newSerializer, "Format", inventoryConfiguration.destination.cosBucketDestination.format);
                }
                if (inventoryConfiguration.destination.cosBucketDestination.accountId != null) {
                    addElement(newSerializer, "AccountId", inventoryConfiguration.destination.cosBucketDestination.accountId);
                }
                if (inventoryConfiguration.destination.cosBucketDestination.bucket != null) {
                    addElement(newSerializer, "Bucket", inventoryConfiguration.destination.cosBucketDestination.bucket);
                }
                if (inventoryConfiguration.destination.cosBucketDestination.prefix != null) {
                    addElement(newSerializer, "Prefix", inventoryConfiguration.destination.cosBucketDestination.prefix);
                }
                if (inventoryConfiguration.destination.cosBucketDestination.encryption != null) {
                    newSerializer.startTag("", "Encryption");
                    addElement(newSerializer, "SSE-COS", inventoryConfiguration.destination.cosBucketDestination.encryption.sSECOS);
                    newSerializer.endTag("", "Encryption");
                }
                newSerializer.endTag("", "COSBucketDestination");
            }
            newSerializer.endTag("", "Destination");
        }
        if (inventoryConfiguration.schedule != null && inventoryConfiguration.schedule.frequency != null) {
            newSerializer.startTag("", "Schedule");
            addElement(newSerializer, "Frequency", inventoryConfiguration.schedule.frequency);
            newSerializer.endTag("", "Schedule");
        }
        if (inventoryConfiguration.filter != null && inventoryConfiguration.filter.prefix != null) {
            newSerializer.startTag("", "Filter");
            addElement(newSerializer, "Prefix", inventoryConfiguration.filter.prefix);
            newSerializer.endTag("", "Filter");
        }
        if (inventoryConfiguration.includedObjectVersions != null) {
            addElement(newSerializer, "IncludedObjectVersions", inventoryConfiguration.includedObjectVersions);
        }
        if (inventoryConfiguration.optionalFields != null && inventoryConfiguration.optionalFields.fields != null) {
            newSerializer.startTag("", "OptionalFields");
            for (String str : inventoryConfiguration.optionalFields.fields) {
                addElement(newSerializer, "Field", str);
            }
            newSerializer.endTag("", "OptionalFields");
        }
        newSerializer.endTag("", "InventoryConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildLifecycleConfigurationXML(LifecycleConfiguration lifecycleConfiguration) throws XmlPullParserException, IOException {
        if (lifecycleConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "LifecycleConfiguration");
        if (lifecycleConfiguration.rules != null) {
            for (LifecycleConfiguration.Rule rule : lifecycleConfiguration.rules) {
                if (rule != null) {
                    newSerializer.startTag("", "Rule");
                    addElement(newSerializer, STManager.REGION_OF_ID, rule.id);
                    if (rule.filter != null) {
                        newSerializer.startTag("", "Filter");
                        addElement(newSerializer, "Prefix", rule.filter.prefix);
                        newSerializer.endTag("", "Filter");
                    }
                    addElement(newSerializer, "Status", rule.status);
                    if (rule.transition != null) {
                        newSerializer.startTag("", "Transition");
                        addElement(newSerializer, "Days", String.valueOf(rule.transition.days));
                        addElement(newSerializer, "StorageClass", rule.transition.storageClass);
                        addElement(newSerializer, "Date", rule.transition.date);
                        newSerializer.endTag("", "Transition");
                    }
                    if (rule.expiration != null) {
                        newSerializer.startTag("", "Expiration");
                        addElement(newSerializer, "Days", String.valueOf(rule.expiration.days));
                        addElement(newSerializer, "ExpiredObjectDeleteMarker", rule.expiration.expiredObjectDeleteMarker);
                        addElement(newSerializer, "Date", rule.expiration.date);
                        newSerializer.endTag("", "Expiration");
                    }
                    if (rule.noncurrentVersionTransition != null) {
                        newSerializer.startTag("", "NoncurrentVersionTransition");
                        addElement(newSerializer, "NoncurrentDays", String.valueOf(rule.noncurrentVersionTransition.noncurrentDays));
                        addElement(newSerializer, "StorageClass", rule.noncurrentVersionTransition.storageClass);
                        newSerializer.endTag("", "NoncurrentVersionTransition");
                    }
                    if (rule.noncurrentVersionExpiration != null) {
                        newSerializer.startTag("", "NoncurrentVersionExpiration");
                        addElement(newSerializer, "NoncurrentDays", String.valueOf(rule.noncurrentVersionExpiration.noncurrentDays));
                        newSerializer.endTag("", "NoncurrentVersionExpiration");
                    }
                    if (rule.abortIncompleteMultiUpload != null) {
                        newSerializer.startTag("", "AbortIncompleteMultipartUpload");
                        addElement(newSerializer, "DaysAfterInitiation", String.valueOf(rule.abortIncompleteMultiUpload.daysAfterInitiation));
                        newSerializer.endTag("", "AbortIncompleteMultipartUpload");
                    }
                    newSerializer.endTag("", "Rule");
                }
            }
        }
        newSerializer.endTag("", "LifecycleConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildPutBucketAccelerateXML(boolean z) throws XmlPullParserException, IOException {
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "AccelerateConfiguration");
        addElement(newSerializer, "Status", z ? PutBucketIntelligentTieringRequest.STATUS_ENABLED : PutBucketIntelligentTieringRequest.STATUS_SUSPEND);
        newSerializer.endTag("", "AccelerateConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildReplicationConfiguration(ReplicationConfiguration replicationConfiguration) throws XmlPullParserException, IOException {
        if (replicationConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "ReplicationConfiguration");
        addElement(newSerializer, "Role", replicationConfiguration.role);
        if (replicationConfiguration.rules != null) {
            for (ReplicationConfiguration.Rule rule : replicationConfiguration.rules) {
                if (rule != null) {
                    newSerializer.startTag("", "Rule");
                    addElement(newSerializer, "Status", rule.status);
                    addElement(newSerializer, STManager.REGION_OF_ID, rule.id);
                    addElement(newSerializer, "Prefix", rule.prefix);
                    if (rule.destination != null) {
                        newSerializer.startTag("", "Destination");
                        addElement(newSerializer, "Bucket", rule.destination.bucket);
                        addElement(newSerializer, "StorageClass", rule.destination.storageClass);
                        newSerializer.endTag("", "Destination");
                    }
                    newSerializer.endTag("", "Rule");
                }
            }
        }
        newSerializer.endTag("", "ReplicationConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildRestore(RestoreConfigure restoreConfigure) throws XmlPullParserException, IOException {
        if (restoreConfigure == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "RestoreRequest");
        addElement(newSerializer, "Days", String.valueOf(restoreConfigure.days));
        if (restoreConfigure.casJobParameters != null) {
            newSerializer.startTag("", "CASJobParameters");
            addElement(newSerializer, "Tier", restoreConfigure.casJobParameters.tier);
            newSerializer.endTag("", "CASJobParameters");
        }
        newSerializer.endTag("", "RestoreRequest");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildSelectRequest(SelectRequest selectRequest) throws IOException, XmlPullParserException {
        if (selectRequest == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "SelectRequest");
        addElement(newSerializer, "Expression", selectRequest.getExpression());
        addElement(newSerializer, "ExpressionType", selectRequest.getExpressionType());
        newSerializer.startTag("", "InputSerialization");
        addElement(newSerializer, "CompressionType", selectRequest.getInputSerialization().getCompressionType());
        if (selectRequest.getInputSerialization().getCsv() != null) {
            CSVInput csv = selectRequest.getInputSerialization().getCsv();
            newSerializer.startTag("", "CSV");
            addElement(newSerializer, "FileHeaderInfo", csv.getFileHeaderInfo());
            addElement(newSerializer, "RecordDelimiter", csv.getRecordDelimiterAsString());
            addElement(newSerializer, "FieldDelimiter", csv.getFieldDelimiterAsString());
            addElement(newSerializer, "QuoteCharacter", csv.getQuoteCharacterAsString());
            addElement(newSerializer, "QuoteEscapeCharacter", csv.getQuoteEscapeCharacterAsString());
            addElement(newSerializer, "Comments", csv.getCommentsAsString());
            addElement(newSerializer, "AllowQuotedRecordDelimiter", csv.getAllowQuotedRecordDelimiter().booleanValue() ? "TRUE" : "FALSE");
            newSerializer.endTag("", "CSV");
        } else if (selectRequest.getInputSerialization().getJson() != null) {
            JSONInput json = selectRequest.getInputSerialization().getJson();
            newSerializer.startTag("", "JSON");
            addElement(newSerializer, "Type", json.getType());
            newSerializer.endTag("", "JSON");
        }
        newSerializer.endTag("", "InputSerialization");
        newSerializer.startTag("", "OutputSerialization");
        if (selectRequest.getOutputSerialization().getCsv() != null) {
            CSVOutput csv2 = selectRequest.getOutputSerialization().getCsv();
            newSerializer.startTag("", "CSV");
            addElement(newSerializer, "QuoteFields", csv2.getQuoteFields());
            addElement(newSerializer, "RecordDelimiter", csv2.getRecordDelimiterAsString());
            addElement(newSerializer, "FieldDelimiter", csv2.getFieldDelimiterAsString());
            addElement(newSerializer, "QuoteCharacter", csv2.getQuoteCharacterAsString());
            addElement(newSerializer, "QuoteEscapeCharacter", csv2.getQuoteEscapeCharacterAsString());
            newSerializer.endTag("", "CSV");
        } else if (selectRequest.getOutputSerialization().getJson() != null) {
            JSONOutput json2 = selectRequest.getOutputSerialization().getJson();
            newSerializer.startTag("", "JSON");
            addElement(newSerializer, "RecordDelimiter", json2.getRecordDelimiterAsString());
            newSerializer.endTag("", "JSON");
        }
        newSerializer.endTag("", "OutputSerialization");
        newSerializer.startTag("", "RequestProgress");
        addElement(newSerializer, PutBucketIntelligentTieringRequest.STATUS_ENABLED, String.valueOf(selectRequest.getRequestProgress().getEnabled()));
        newSerializer.endTag("", "RequestProgress");
        newSerializer.endTag("", "SelectRequest");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildTagging(Tagging tagging) throws XmlPullParserException, IOException {
        if (tagging == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "Tagging");
        newSerializer.startTag("", "TagSet");
        if (!tagging.tagSet.tags.isEmpty()) {
            for (Tagging.Tag tag : tagging.tagSet.tags) {
                newSerializer.startTag("", "Tag");
                addElement(newSerializer, "Key", tag.key);
                addElement(newSerializer, "Value", tag.value);
                newSerializer.endTag("", "Tag");
            }
        }
        newSerializer.endTag("", "TagSet");
        newSerializer.endTag("", "Tagging");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildVersioningConfiguration(VersioningConfiguration versioningConfiguration) throws XmlPullParserException, IOException {
        if (versioningConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "VersioningConfiguration");
        addElement(newSerializer, "Status", versioningConfiguration.status);
        newSerializer.endTag("", "VersioningConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    public static String buildWebsiteConfiguration(WebsiteConfiguration websiteConfiguration) throws XmlPullParserException, IOException {
        if (websiteConfiguration == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", null);
        newSerializer.startTag("", "WebsiteConfiguration");
        if (websiteConfiguration.indexDocument != null) {
            newSerializer.startTag("", "IndexDocument");
            if (websiteConfiguration.indexDocument.suffix != null) {
                addElement(newSerializer, "Suffix", websiteConfiguration.indexDocument.suffix);
            }
            newSerializer.endTag("", "IndexDocument");
        }
        if (websiteConfiguration.errorDocument != null) {
            newSerializer.startTag("", "ErrorDocument");
            if (websiteConfiguration.errorDocument.key != null) {
                addElement(newSerializer, "Key", websiteConfiguration.errorDocument.key);
            }
            newSerializer.endTag("", "ErrorDocument");
        }
        if (websiteConfiguration.redirectAllRequestTo != null) {
            newSerializer.startTag("", "RedirectAllRequestTo");
            if (websiteConfiguration.redirectAllRequestTo.protocol != null) {
                addElement(newSerializer, "Protocol", websiteConfiguration.redirectAllRequestTo.protocol);
            }
            newSerializer.endTag("", "RedirectAllRequestTo");
        }
        if (websiteConfiguration.routingRules != null && websiteConfiguration.routingRules.size() > 0) {
            newSerializer.startTag("", "RoutingRules");
            for (WebsiteConfiguration.RoutingRule routingRule : websiteConfiguration.routingRules) {
                newSerializer.startTag("", "RoutingRule");
                if (routingRule.contidion != null) {
                    newSerializer.startTag("", "Condition");
                    if (routingRule.contidion.httpErrorCodeReturnedEquals != -1) {
                        addElement(newSerializer, "HttpErrorCodeReturnedEquals", String.valueOf(routingRule.contidion.httpErrorCodeReturnedEquals));
                    }
                    if (routingRule.contidion.keyPrefixEquals != null) {
                        addElement(newSerializer, "KeyPrefixEquals", routingRule.contidion.keyPrefixEquals);
                    }
                    newSerializer.endTag("", "Condition");
                }
                if (routingRule.redirect != null) {
                    newSerializer.startTag("", "Redirect");
                    if (routingRule.redirect.protocol != null) {
                        addElement(newSerializer, "Protocol", routingRule.redirect.protocol);
                    }
                    if (routingRule.redirect.replaceKeyPrefixWith != null) {
                        addElement(newSerializer, "ReplaceKeyPrefixWith", routingRule.redirect.replaceKeyPrefixWith);
                    }
                    if (routingRule.redirect.replaceKeyWith != null) {
                        addElement(newSerializer, "ReplaceKeyWith", routingRule.redirect.replaceKeyWith);
                    }
                    newSerializer.endTag("", "Redirect");
                }
                newSerializer.endTag("", "RoutingRule");
            }
            newSerializer.endTag("", "RoutingRules");
        }
        newSerializer.endTag("", "WebsiteConfiguration");
        newSerializer.endDocument();
        return removeXMLHeader(stringWriter.toString());
    }

    private static String removeXMLHeader(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.startsWith("<?xml")) {
                str2 = str.substring(str.indexOf("?>") + 2);
            }
        }
        return str2;
    }
}
