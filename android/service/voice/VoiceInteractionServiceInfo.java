package android.service.voice;

import android.Manifest;
import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionServiceInfo.class */
public class VoiceInteractionServiceInfo {
    static final String TAG = "VoiceInteractionServiceInfo";
    private String mParseError;
    private String mRecognitionService;
    private ServiceInfo mServiceInfo;
    private String mSessionService;
    private String mSettingsActivity;

    public VoiceInteractionServiceInfo(PackageManager packageManager, ComponentName componentName) throws PackageManager.NameNotFoundException {
        this(packageManager, packageManager.getServiceInfo(componentName, 128));
    }

    public VoiceInteractionServiceInfo(PackageManager packageManager, ComponentName componentName, int i) throws PackageManager.NameNotFoundException, RemoteException {
        this(packageManager, AppGlobals.getPackageManager().getServiceInfo(componentName, 128, i));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01ec -> B:88:0x0016). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0222 -> B:88:0x0016). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0258 -> B:88:0x0016). Please submit an issue!!! */
    public VoiceInteractionServiceInfo(PackageManager packageManager, ServiceInfo serviceInfo) {
        int next;
        if (!Manifest.permission.BIND_VOICE_INTERACTION.equals(serviceInfo.permission)) {
            this.mParseError = "Service does not require permission android.permission.BIND_VOICE_INTERACTION";
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        XmlResourceParser xmlResourceParser4 = null;
        try {
            try {
                try {
                    XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, VoiceInteractionService.SERVICE_META_DATA);
                    if (loadXmlMetaData == null) {
                        xmlResourceParser4 = loadXmlMetaData;
                        xmlResourceParser = loadXmlMetaData;
                        xmlResourceParser2 = loadXmlMetaData;
                        xmlResourceParser3 = loadXmlMetaData;
                        this.mParseError = "No android.voice_interaction meta-data for " + serviceInfo.packageName;
                        if (loadXmlMetaData != null) {
                            loadXmlMetaData.close();
                        }
                    } else {
                        Resources resourcesForApplication = packageManager.getResourcesForApplication(serviceInfo.applicationInfo);
                        AttributeSet asAttributeSet = Xml.asAttributeSet(loadXmlMetaData);
                        do {
                            next = loadXmlMetaData.next();
                            if (next == 1) {
                                break;
                            }
                        } while (next != 2);
                        if ("voice-interaction-service".equals(loadXmlMetaData.getName())) {
                            TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.VoiceInteractionService);
                            this.mSessionService = obtainAttributes.getString(1);
                            this.mRecognitionService = obtainAttributes.getString(2);
                            this.mSettingsActivity = obtainAttributes.getString(0);
                            obtainAttributes.recycle();
                            if (this.mSessionService != null) {
                                if (loadXmlMetaData != null) {
                                    loadXmlMetaData.close();
                                }
                                this.mServiceInfo = serviceInfo;
                                return;
                            }
                            xmlResourceParser4 = loadXmlMetaData;
                            xmlResourceParser = loadXmlMetaData;
                            xmlResourceParser2 = loadXmlMetaData;
                            xmlResourceParser3 = loadXmlMetaData;
                            this.mParseError = "No sessionService specified";
                            if (loadXmlMetaData != null) {
                                loadXmlMetaData.close();
                            }
                        } else {
                            xmlResourceParser4 = loadXmlMetaData;
                            xmlResourceParser = loadXmlMetaData;
                            xmlResourceParser2 = loadXmlMetaData;
                            xmlResourceParser3 = loadXmlMetaData;
                            this.mParseError = "Meta-data does not start with voice-interaction-service tag";
                            if (loadXmlMetaData != null) {
                                loadXmlMetaData.close();
                            }
                        }
                    }
                } catch (IOException e) {
                    this.mParseError = "Error parsing voice interation service meta-data: " + e;
                    xmlResourceParser3 = xmlResourceParser;
                    Log.w(TAG, "error parsing voice interaction service meta-data", e);
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                } catch (XmlPullParserException e2) {
                    this.mParseError = "Error parsing voice interation service meta-data: " + e2;
                    xmlResourceParser3 = xmlResourceParser4;
                    Log.w(TAG, "error parsing voice interaction service meta-data", e2);
                    if (xmlResourceParser4 != null) {
                        xmlResourceParser4.close();
                    }
                }
            } catch (PackageManager.NameNotFoundException e3) {
                this.mParseError = "Error parsing voice interation service meta-data: " + e3;
                xmlResourceParser3 = xmlResourceParser2;
                Log.w(TAG, "error parsing voice interaction service meta-data", e3);
                if (xmlResourceParser2 != null) {
                    xmlResourceParser2.close();
                }
            }
        } catch (Throwable th) {
            if (xmlResourceParser3 != null) {
                xmlResourceParser3.close();
            }
            throw th;
        }
    }

    public String getParseError() {
        return this.mParseError;
    }

    public String getRecognitionService() {
        return this.mRecognitionService;
    }

    public ServiceInfo getServiceInfo() {
        return this.mServiceInfo;
    }

    public String getSessionService() {
        return this.mSessionService;
    }

    public String getSettingsActivity() {
        return this.mSettingsActivity;
    }
}
