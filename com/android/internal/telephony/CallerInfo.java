package com.android.internal.telephony;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Country;
import android.location.CountryDetector;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import com.android.internal.R;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/telephony/CallerInfo.class */
public class CallerInfo {
    private static final String TAG = "CallerInfo";
    private static final boolean VDBG = Rlog.isLoggable(TAG, 2);
    public Drawable cachedPhoto;
    public Bitmap cachedPhotoIcon;
    public String cnapName;
    public Uri contactDisplayPhotoUri;
    public boolean contactExists;
    public long contactIdOrZero;
    public Uri contactRefUri;
    public Uri contactRingtoneUri;
    public String geoDescription;
    public boolean isCachedPhotoCurrent;
    public String lookupKey;
    private boolean mIsEmergency = false;
    private boolean mIsVoiceMail = false;
    public String name;
    public int namePresentation;
    public boolean needUpdate;
    public String normalizedNumber;
    public String numberLabel;
    public int numberPresentation;
    public int numberType;
    public String phoneLabel;
    public String phoneNumber;
    public int photoResource;
    public boolean shouldSendToVoicemail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CallerInfo doSecondaryLookupIfNecessary(Context context, String str, CallerInfo callerInfo) {
        CallerInfo callerInfo2 = callerInfo;
        if (!callerInfo.contactExists) {
            callerInfo2 = callerInfo;
            if (PhoneNumberUtils.isUriNumber(str)) {
                String usernameFromUriNumber = PhoneNumberUtils.getUsernameFromUriNumber(str);
                callerInfo2 = callerInfo;
                if (PhoneNumberUtils.isGlobalPhoneNumber(usernameFromUriNumber)) {
                    callerInfo2 = getCallerInfo(context, Uri.withAppendedPath(ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI, Uri.encode(usernameFromUriNumber)));
                }
            }
        }
        return callerInfo2;
    }

    public static CallerInfo getCallerInfo(Context context, Uri uri) {
        return getCallerInfo(context, uri, CallerInfoAsyncQuery.getCurrentProfileContentResolver(context).query(uri, null, null, null, null));
    }

    public static CallerInfo getCallerInfo(Context context, Uri uri, Cursor cursor) {
        int columnIndex;
        CallerInfo callerInfo = new CallerInfo();
        callerInfo.photoResource = 0;
        callerInfo.phoneLabel = null;
        callerInfo.numberType = 0;
        callerInfo.numberLabel = null;
        callerInfo.cachedPhoto = null;
        callerInfo.isCachedPhotoCurrent = false;
        callerInfo.contactExists = false;
        if (VDBG) {
            Rlog.v(TAG, "getCallerInfo() based on cursor...");
        }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnIndex2 = cursor.getColumnIndex("display_name");
                if (columnIndex2 != -1) {
                    callerInfo.name = cursor.getString(columnIndex2);
                }
                int columnIndex3 = cursor.getColumnIndex("number");
                if (columnIndex3 != -1) {
                    callerInfo.phoneNumber = cursor.getString(columnIndex3);
                }
                int columnIndex4 = cursor.getColumnIndex("normalized_number");
                if (columnIndex4 != -1) {
                    callerInfo.normalizedNumber = cursor.getString(columnIndex4);
                }
                int columnIndex5 = cursor.getColumnIndex("label");
                if (columnIndex5 != -1 && (columnIndex = cursor.getColumnIndex("type")) != -1) {
                    callerInfo.numberType = cursor.getInt(columnIndex);
                    callerInfo.numberLabel = cursor.getString(columnIndex5);
                    callerInfo.phoneLabel = ContactsContract.CommonDataKinds.Phone.getDisplayLabel(context, callerInfo.numberType, callerInfo.numberLabel).toString();
                }
                int columnIndexForPersonId = getColumnIndexForPersonId(uri, cursor);
                if (columnIndexForPersonId != -1) {
                    long j = cursor.getLong(columnIndexForPersonId);
                    if (j != 0 && !ContactsContract.Contacts.isEnterpriseContactId(j)) {
                        callerInfo.contactIdOrZero = j;
                        if (VDBG) {
                            Rlog.v(TAG, "==> got info.contactIdOrZero: " + callerInfo.contactIdOrZero);
                        }
                    }
                } else {
                    Rlog.w(TAG, "Couldn't find contact_id column for " + uri);
                }
                int columnIndex6 = cursor.getColumnIndex("lookup");
                if (columnIndex6 != -1) {
                    callerInfo.lookupKey = cursor.getString(columnIndex6);
                }
                int columnIndex7 = cursor.getColumnIndex("photo_uri");
                if (columnIndex7 == -1 || cursor.getString(columnIndex7) == null) {
                    callerInfo.contactDisplayPhotoUri = null;
                } else {
                    callerInfo.contactDisplayPhotoUri = Uri.parse(cursor.getString(columnIndex7));
                }
                int columnIndex8 = cursor.getColumnIndex("custom_ringtone");
                if (columnIndex8 == -1 || cursor.getString(columnIndex8) == null) {
                    callerInfo.contactRingtoneUri = null;
                } else {
                    callerInfo.contactRingtoneUri = Uri.parse(cursor.getString(columnIndex8));
                }
                int columnIndex9 = cursor.getColumnIndex("send_to_voicemail");
                callerInfo.shouldSendToVoicemail = columnIndex9 != -1 && cursor.getInt(columnIndex9) == 1;
                callerInfo.contactExists = true;
            }
            cursor.close();
        }
        callerInfo.needUpdate = false;
        callerInfo.name = normalize(callerInfo.name);
        callerInfo.contactRefUri = uri;
        return callerInfo;
    }

    public static CallerInfo getCallerInfo(Context context, String str) {
        if (VDBG) {
            Rlog.v(TAG, "getCallerInfo() based on number...");
        }
        return getCallerInfo(context, str, SubscriptionManager.getDefaultSubId());
    }

    public static CallerInfo getCallerInfo(Context context, String str, int i) {
        CallerInfo callerInfo;
        if (TextUtils.isEmpty(str)) {
            callerInfo = null;
        } else if (PhoneNumberUtils.isLocalEmergencyNumber(context, str)) {
            return new CallerInfo().markAsEmergency(context);
        } else {
            if (PhoneNumberUtils.isVoiceMailNumber(i, str)) {
                return new CallerInfo().markAsVoiceMail();
            }
            CallerInfo doSecondaryLookupIfNecessary = doSecondaryLookupIfNecessary(context, str, getCallerInfo(context, Uri.withAppendedPath(ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI, Uri.encode(str))));
            callerInfo = doSecondaryLookupIfNecessary;
            if (TextUtils.isEmpty(doSecondaryLookupIfNecessary.phoneNumber)) {
                doSecondaryLookupIfNecessary.phoneNumber = str;
                return doSecondaryLookupIfNecessary;
            }
        }
        return callerInfo;
    }

    private static int getColumnIndexForPersonId(Uri uri, Cursor cursor) {
        if (VDBG) {
            Rlog.v(TAG, "- getColumnIndexForPersonId: contactRef URI = '" + uri + "'...");
        }
        String uri2 = uri.toString();
        String str = null;
        if (uri2.startsWith("content://com.android.contacts/data/phones")) {
            if (VDBG) {
                Rlog.v(TAG, "'data/phones' URI; using RawContacts.CONTACT_ID");
            }
            str = "contact_id";
        } else if (uri2.startsWith("content://com.android.contacts/data")) {
            if (VDBG) {
                Rlog.v(TAG, "'data' URI; using Data.CONTACT_ID");
            }
            str = "contact_id";
        } else if (uri2.startsWith("content://com.android.contacts/phone_lookup")) {
            if (VDBG) {
                Rlog.v(TAG, "'phone_lookup' URI; using PhoneLookup._ID");
            }
            str = "_id";
        } else {
            Rlog.w(TAG, "Unexpected prefix for contactRef '" + uri2 + "'");
        }
        int columnIndex = str != null ? cursor.getColumnIndex(str) : -1;
        if (VDBG) {
            Rlog.v(TAG, "==> Using column '" + str + "' (columnIndex = " + columnIndex + ") for person_id lookup...");
        }
        return columnIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getCurrentCountryIso(Context context) {
        return getCurrentCountryIso(context, Locale.getDefault());
    }

    private static String getCurrentCountryIso(Context context, Locale locale) {
        CountryDetector countryDetector = (CountryDetector) context.getSystemService("country_detector");
        String str = null;
        if (countryDetector != null) {
            Country detectCountry = countryDetector.detectCountry();
            if (detectCountry != null) {
                str = detectCountry.getCountryIso();
            } else {
                Rlog.e(TAG, "CountryDetector.detectCountry() returned null.");
                str = null;
            }
        }
        String str2 = str;
        if (str == null) {
            str2 = locale.getCountry();
            Rlog.w(TAG, "No CountryDetector; falling back to countryIso based on locale: " + str2);
        }
        return str2;
    }

    private static String getGeoDescription(Context context, String str) {
        Phonenumber.PhoneNumber phoneNumber;
        String str2;
        if (VDBG) {
            Rlog.v(TAG, "getGeoDescription('" + str + "')...");
        }
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder = PhoneNumberOfflineGeocoder.getInstance();
            Locale locale = context.getResources().getConfiguration().locale;
            String currentCountryIso = getCurrentCountryIso(context, locale);
            Phonenumber.PhoneNumber phoneNumber2 = null;
            try {
                if (VDBG) {
                    Rlog.v(TAG, "parsing '" + str + "' for countryIso '" + currentCountryIso + "'...");
                }
                Phonenumber.PhoneNumber parse = phoneNumberUtil.parse(str, currentCountryIso);
                phoneNumber = parse;
                if (VDBG) {
                    phoneNumber2 = parse;
                    Rlog.v(TAG, "- parsed number: " + parse);
                    phoneNumber = parse;
                }
            } catch (NumberParseException e) {
                Rlog.w(TAG, "getGeoDescription: NumberParseException for incoming number '" + str + "'");
                phoneNumber = phoneNumber2;
            }
            str2 = null;
            if (phoneNumber != null) {
                String descriptionForNumber = phoneNumberOfflineGeocoder.getDescriptionForNumber(phoneNumber, locale);
                str2 = descriptionForNumber;
                if (VDBG) {
                    Rlog.v(TAG, "- got description: '" + descriptionForNumber + "'");
                    return descriptionForNumber;
                }
            }
        }
        return str2;
    }

    private static String normalize(String str) {
        if (str == null || str.length() > 0) {
            return str;
        }
        return null;
    }

    public boolean isEmergencyNumber() {
        return this.mIsEmergency;
    }

    public boolean isVoiceMailNumber() {
        return this.mIsVoiceMail;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallerInfo markAsEmergency(Context context) {
        this.phoneNumber = context.getString(R.string.emergency_call_dialog_number_for_display);
        this.photoResource = R.drawable.picture_emergency;
        this.mIsEmergency = true;
        return this;
    }

    CallerInfo markAsVoiceMail() {
        return markAsVoiceMail(SubscriptionManager.getDefaultSubId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallerInfo markAsVoiceMail(int i) {
        this.mIsVoiceMail = true;
        try {
            this.phoneNumber = TelephonyManager.getDefault().getVoiceMailAlphaTag(i);
            return this;
        } catch (SecurityException e) {
            Rlog.e(TAG, "Cannot access VoiceMail.", e);
            return this;
        }
    }

    public String toString() {
        return new StringBuilder(128).append(super.toString() + " { ").append("name " + (this.name == null ? "null" : "non-null")).append(", phoneNumber " + (this.phoneNumber == null ? "null" : "non-null")).append(" }").toString();
    }

    public void updateGeoDescription(Context context, String str) {
        if (!TextUtils.isEmpty(this.phoneNumber)) {
            str = this.phoneNumber;
        }
        this.geoDescription = getGeoDescription(context, str);
    }
}
