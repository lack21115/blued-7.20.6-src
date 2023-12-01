package android.provider;

import android.R;
import android.accounts.Account;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.CursorEntityIterator;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.Contacts;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract.class */
public final class ContactsContract {
    public static final String AUTHORITY = "com.android.contacts";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.android.contacts");
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final String DEFERRED_SNIPPETING = "deferred_snippeting";
    public static final String DEFERRED_SNIPPETING_QUERY = "deferred_snippeting_query";
    public static final String DIRECTORY_PARAM_KEY = "directory";
    public static final String LIMIT_PARAM_KEY = "limit";
    public static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
    public static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
    public static final String REMOVE_DUPLICATE_ENTRIES = "remove_duplicate_entries";
    public static final String STREQUENT_PHONE_ONLY = "strequent_phone_only";

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$AggregationExceptions.class */
    public static final class AggregationExceptions implements BaseColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/aggregation_exception";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "aggregation_exceptions");
        public static final String RAW_CONTACT_ID1 = "raw_contact_id1";
        public static final String RAW_CONTACT_ID2 = "raw_contact_id2";
        public static final String TYPE = "type";
        public static final int TYPE_AUTOMATIC = 0;
        public static final int TYPE_KEEP_SEPARATE = 2;
        public static final int TYPE_KEEP_TOGETHER = 1;

        private AggregationExceptions() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Authorization.class */
    public static final class Authorization {
        public static final String AUTHORIZATION_METHOD = "authorize";
        public static final String KEY_AUTHORIZED_URI = "authorized_uri";
        public static final String KEY_URI_TO_AUTHORIZE = "uri_to_authorize";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$BaseSyncColumns.class */
    protected interface BaseSyncColumns {
        public static final String SYNC1 = "sync1";
        public static final String SYNC2 = "sync2";
        public static final String SYNC3 = "sync3";
        public static final String SYNC4 = "sync4";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds.class */
    public static final class CommonDataKinds {
        public static final String PACKAGE_COMMON = "common";

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$BaseTypes.class */
        public interface BaseTypes {
            public static final int TYPE_CUSTOM = 0;
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Callable.class */
        public static final class Callable implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "callables");
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$CommonColumns.class */
        protected interface CommonColumns extends BaseTypes {
            public static final String DATA = "data1";
            public static final String LABEL = "data3";
            public static final String TYPE = "data2";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Contactables.class */
        public static final class Contactables implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String VISIBLE_CONTACTS_ONLY = "visible_contacts_only";
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "contactables");
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Email.class */
        public static final class Email implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String ADDRESS = "data1";
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";
            public static final String DISPLAY_NAME = "data4";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_MOBILE = 4;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "emails");
            public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI, ContactsColumns.LOOKUP_KEY);
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");

            private Email() {
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeLabelResource(i)) : charSequence;
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040418;
                    case 2:
                        return 17040419;
                    case 3:
                        return 17040420;
                    case 4:
                        return 17040421;
                    default:
                        return 17040417;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Event.class */
        public static final class Event implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
            public static final String START_DATE = "data1";
            public static final int TYPE_ANNIVERSARY = 1;
            public static final int TYPE_BIRTHDAY = 3;
            public static final int TYPE_OTHER = 2;

            private Event() {
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeResource(Integer.valueOf(i))) : charSequence;
            }

            public static int getTypeResource(Integer num) {
                if (num == null) {
                    return 17040416;
                }
                switch (num.intValue()) {
                    case 1:
                        return 17040415;
                    case 2:
                        return 17040416;
                    case 3:
                        return 17040414;
                    default:
                        return 17040413;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$GroupMembership.class */
        public static final class GroupMembership implements DataColumnsWithJoins, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group_membership";
            public static final String GROUP_ROW_ID = "data1";
            public static final String GROUP_SOURCE_ID = "group_sourceid";

            private GroupMembership() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Identity.class */
        public static final class Identity implements DataColumnsWithJoins, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
            public static final String IDENTITY = "data1";
            public static final String NAMESPACE = "data2";

            private Identity() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Im.class */
        public static final class Im implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";
            public static final String CUSTOM_PROTOCOL = "data6";
            public static final String PROTOCOL = "data5";
            public static final int PROTOCOL_AIM = 0;
            public static final int PROTOCOL_CUSTOM = -1;
            public static final int PROTOCOL_GOOGLE_TALK = 5;
            public static final int PROTOCOL_ICQ = 6;
            public static final int PROTOCOL_JABBER = 7;
            public static final int PROTOCOL_MSN = 1;
            public static final int PROTOCOL_NETMEETING = 8;
            public static final int PROTOCOL_QQ = 4;
            public static final int PROTOCOL_SKYPE = 3;
            public static final int PROTOCOL_YAHOO = 2;
            public static final int TYPE_HOME = 1;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            private Im() {
            }

            public static final CharSequence getProtocolLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != -1 || TextUtils.isEmpty(charSequence)) ? resources.getText(getProtocolLabelResource(i)) : charSequence;
            }

            public static final int getProtocolLabelResource(int i) {
                switch (i) {
                    case 0:
                        return 17040431;
                    case 1:
                        return 17040432;
                    case 2:
                        return 17040433;
                    case 3:
                        return 17040434;
                    case 4:
                        return 17040435;
                    case 5:
                        return 17040436;
                    case 6:
                        return 17040437;
                    case 7:
                        return 17040438;
                    case 8:
                        return 17040439;
                    default:
                        return 17040430;
                }
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeLabelResource(i)) : charSequence;
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040427;
                    case 2:
                        return 17040428;
                    case 3:
                        return 17040429;
                    default:
                        return 17040426;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$LocalGroup.class */
        public static final class LocalGroup implements DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/local-groups";
            public static final String GROUP = "data1";
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "local-groups");
            public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI, ContactsColumns.LOOKUP_KEY);
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");

            private LocalGroup() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Nickname.class */
        public static final class Nickname implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
            public static final String NAME = "data1";
            public static final int TYPE_DEFAULT = 1;
            public static final int TYPE_INITIALS = 5;
            public static final int TYPE_MAIDEN_NAME = 3;
            @Deprecated
            public static final int TYPE_MAINDEN_NAME = 3;
            public static final int TYPE_OTHER_NAME = 2;
            public static final int TYPE_SHORT_NAME = 4;

            private Nickname() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Note.class */
        public static final class Note implements DataColumnsWithJoins, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
            public static final String NOTE = "data1";

            private Note() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Organization.class */
        public static final class Organization implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String COMPANY = "data1";
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";
            public static final String DEPARTMENT = "data5";
            public static final String JOB_DESCRIPTION = "data6";
            public static final String OFFICE_LOCATION = "data9";
            public static final String PHONETIC_NAME = "data8";
            public static final String PHONETIC_NAME_STYLE = "data10";
            public static final String SYMBOL = "data7";
            public static final String TITLE = "data4";
            public static final int TYPE_OTHER = 2;
            public static final int TYPE_WORK = 1;

            private Organization() {
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeLabelResource(i)) : charSequence;
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040440;
                    case 2:
                        return 17040441;
                    default:
                        return 17040442;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Phone.class */
        public static final class Phone implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";
            public static final String NORMALIZED_NUMBER = "data4";
            public static final String NUMBER = "data1";
            public static final String SEARCH_DISPLAY_NAME_KEY = "search_display_name";
            public static final String SEARCH_PHONE_NUMBER_KEY = "search_phone_number";
            public static final int TYPE_ASSISTANT = 19;
            public static final int TYPE_CALLBACK = 8;
            public static final int TYPE_CAR = 9;
            public static final int TYPE_COMPANY_MAIN = 10;
            public static final int TYPE_FAX_HOME = 5;
            public static final int TYPE_FAX_WORK = 4;
            public static final int TYPE_HOME = 1;
            public static final int TYPE_ISDN = 11;
            public static final int TYPE_MAIN = 12;
            public static final int TYPE_MMS = 20;
            public static final int TYPE_MOBILE = 2;
            public static final int TYPE_OTHER = 7;
            public static final int TYPE_OTHER_FAX = 13;
            public static final int TYPE_PAGER = 6;
            public static final int TYPE_RADIO = 14;
            public static final int TYPE_TELEX = 15;
            public static final int TYPE_TTY_TDD = 16;
            public static final int TYPE_WORK = 3;
            public static final int TYPE_WORK_MOBILE = 17;
            public static final int TYPE_WORK_PAGER = 18;
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, Contacts.People.Phones.CONTENT_DIRECTORY);
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");

            private Phone() {
            }

            @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charSequence) {
                return getTypeLabel(context.getResources(), i, charSequence);
            }

            @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charSequence, CharSequence[] charSequenceArr) {
                return getTypeLabel(context.getResources(), i, charSequence);
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return ((i == 0 || i == 19) && !TextUtils.isEmpty(charSequence)) ? charSequence : resources.getText(getTypeLabelResource(i));
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040393;
                    case 2:
                        return 17040394;
                    case 3:
                        return 17040395;
                    case 4:
                        return 17040396;
                    case 5:
                        return 17040397;
                    case 6:
                        return 17040398;
                    case 7:
                        return 17040399;
                    case 8:
                        return 17040400;
                    case 9:
                        return 17040401;
                    case 10:
                        return 17040402;
                    case 11:
                        return 17040403;
                    case 12:
                        return 17040404;
                    case 13:
                        return 17040405;
                    case 14:
                        return 17040406;
                    case 15:
                        return 17040407;
                    case 16:
                        return 17040408;
                    case 17:
                        return 17040409;
                    case 18:
                        return 17040410;
                    case 19:
                        return 17040411;
                    case 20:
                        return 17040412;
                    default:
                        return 17040392;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Photo.class */
        public static final class Photo implements DataColumnsWithJoins, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            public static final String PHOTO = "data15";
            public static final String PHOTO_FILE_ID = "data14";

            private Photo() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Relation.class */
        public static final class Relation implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";
            public static final String NAME = "data1";
            public static final int TYPE_ASSISTANT = 1;
            public static final int TYPE_BROTHER = 2;
            public static final int TYPE_CHILD = 3;
            public static final int TYPE_DOMESTIC_PARTNER = 4;
            public static final int TYPE_FATHER = 5;
            public static final int TYPE_FRIEND = 6;
            public static final int TYPE_MANAGER = 7;
            public static final int TYPE_MOTHER = 8;
            public static final int TYPE_PARENT = 9;
            public static final int TYPE_PARTNER = 10;
            public static final int TYPE_REFERRED_BY = 11;
            public static final int TYPE_RELATIVE = 12;
            public static final int TYPE_SISTER = 13;
            public static final int TYPE_SPOUSE = 14;

            private Relation() {
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeLabelResource(i)) : charSequence;
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040444;
                    case 2:
                        return 17040445;
                    case 3:
                        return 17040446;
                    case 4:
                        return 17040447;
                    case 5:
                        return 17040448;
                    case 6:
                        return 17040449;
                    case 7:
                        return 17040450;
                    case 8:
                        return 17040451;
                    case 9:
                        return 17040452;
                    case 10:
                        return 17040453;
                    case 11:
                        return 17040454;
                    case 12:
                        return 17040455;
                    case 13:
                        return 17040456;
                    case 14:
                        return 17040457;
                    default:
                        return 17040442;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$SipAddress.class */
        public static final class SipAddress implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
            public static final String SIP_ADDRESS = "data1";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            private SipAddress() {
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeLabelResource(i)) : charSequence;
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040459;
                    case 2:
                        return 17040460;
                    case 3:
                        return 17040461;
                    default:
                        return 17040458;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$StructuredName.class */
        public static final class StructuredName implements DataColumnsWithJoins, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
            public static final String DISPLAY_NAME = "data1";
            public static final String FAMILY_NAME = "data3";
            public static final String FULL_NAME_STYLE = "data10";
            public static final String GIVEN_NAME = "data2";
            public static final String MIDDLE_NAME = "data5";
            public static final String PHONETIC_FAMILY_NAME = "data9";
            public static final String PHONETIC_GIVEN_NAME = "data7";
            public static final String PHONETIC_MIDDLE_NAME = "data8";
            public static final String PHONETIC_NAME_STYLE = "data11";
            public static final String PREFIX = "data4";
            public static final String SUFFIX = "data6";

            private StructuredName() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$StructuredPostal.class */
        public static final class StructuredPostal implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CITY = "data7";
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/postal-address_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "postals");
            public static final String COUNTRY = "data10";
            public static final String FORMATTED_ADDRESS = "data1";
            public static final String NEIGHBORHOOD = "data6";
            public static final String POBOX = "data5";
            public static final String POSTCODE = "data9";
            public static final String REGION = "data8";
            public static final String STREET = "data4";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            private StructuredPostal() {
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charSequence) {
                return (i != 0 || TextUtils.isEmpty(charSequence)) ? resources.getText(getTypeLabelResource(i)) : charSequence;
            }

            public static final int getTypeLabelResource(int i) {
                switch (i) {
                    case 1:
                        return 17040423;
                    case 2:
                        return 17040424;
                    case 3:
                        return 17040425;
                    default:
                        return 17040422;
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$CommonDataKinds$Website.class */
        public static final class Website implements DataColumnsWithJoins, CommonColumns, ContactCounts {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
            public static final int TYPE_BLOG = 2;
            public static final int TYPE_FTP = 6;
            public static final int TYPE_HOME = 4;
            public static final int TYPE_HOMEPAGE = 1;
            public static final int TYPE_OTHER = 7;
            public static final int TYPE_PROFILE = 3;
            public static final int TYPE_WORK = 5;
            public static final String URL = "data1";

            private Website() {
            }
        }

        private CommonDataKinds() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ContactCounts.class */
    public interface ContactCounts {
        public static final String EXTRA_ADDRESS_BOOK_INDEX = "android.provider.extra.ADDRESS_BOOK_INDEX";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "android.provider.extra.ADDRESS_BOOK_INDEX_TITLES";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ContactNameColumns.class */
    protected interface ContactNameColumns {
        public static final String DISPLAY_NAME_ALTERNATIVE = "display_name_alt";
        public static final String DISPLAY_NAME_PRIMARY = "display_name";
        public static final String DISPLAY_NAME_SOURCE = "display_name_source";
        public static final String PHONETIC_NAME = "phonetic_name";
        public static final String PHONETIC_NAME_STYLE = "phonetic_name_style";
        public static final String SORT_KEY_ALTERNATIVE = "sort_key_alt";
        public static final String SORT_KEY_PRIMARY = "sort_key";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ContactOptionsColumns.class */
    protected interface ContactOptionsColumns {
        public static final String CUSTOM_RINGTONE = "custom_ringtone";
        public static final String LAST_TIME_CONTACTED = "last_time_contacted";
        public static final String PINNED = "pinned";
        public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";
        public static final String STARRED = "starred";
        public static final String TIMES_CONTACTED = "times_contacted";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ContactStatusColumns.class */
    protected interface ContactStatusColumns {
        public static final String CONTACT_CHAT_CAPABILITY = "contact_chat_capability";
        public static final String CONTACT_PRESENCE = "contact_presence";
        public static final String CONTACT_STATUS = "contact_status";
        public static final String CONTACT_STATUS_ICON = "contact_status_icon";
        public static final String CONTACT_STATUS_LABEL = "contact_status_label";
        public static final String CONTACT_STATUS_RES_PACKAGE = "contact_status_res_package";
        public static final String CONTACT_STATUS_TIMESTAMP = "contact_status_ts";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts.class */
    public static class Contacts implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns, ContactCounts {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        public static final String CONTENT_VCARD_TYPE = "text/x-vcard";
        public static final String QUERY_PARAMETER_VCARD_NO_PHOTO = "nophoto";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, android.provider.Contacts.AUTHORITY);
        public static final Uri CORP_CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "contacts_corp");
        public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI, ContactsColumns.LOOKUP_KEY);
        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI, "as_vcard");
        public static final Uri CONTENT_MULTI_VCARD_URI = Uri.withAppendedPath(CONTENT_URI, "as_multi_vcard");
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
        public static final Uri CONTENT_STREQUENT_URI = Uri.withAppendedPath(CONTENT_URI, "strequent");
        public static final Uri CONTENT_FREQUENT_URI = Uri.withAppendedPath(CONTENT_URI, "frequent");
        public static final Uri CONTENT_STREQUENT_FILTER_URI = Uri.withAppendedPath(CONTENT_STREQUENT_URI, "filter");
        public static final Uri CONTENT_GROUP_URI = Uri.withAppendedPath(CONTENT_URI, "group");
        public static long ENTERPRISE_CONTACT_ID_BASE = 1000000000;

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts$AggregationSuggestions.class */
        public static final class AggregationSuggestions implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactStatusColumns {
            public static final String CONTENT_DIRECTORY = "suggestions";
            public static final String PARAMETER_MATCH_EMAIL = "email";
            public static final String PARAMETER_MATCH_NAME = "name";
            public static final String PARAMETER_MATCH_NICKNAME = "nickname";
            public static final String PARAMETER_MATCH_PHONE = "phone";

            /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts$AggregationSuggestions$Builder.class */
            public static final class Builder {
                private long mContactId;
                private int mLimit;
                private ArrayList<String> mKinds = new ArrayList<>();
                private ArrayList<String> mValues = new ArrayList<>();

                public Builder addParameter(String str, String str2) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.mKinds.add(str);
                        this.mValues.add(str2);
                    }
                    return this;
                }

                public Uri build() {
                    Uri.Builder buildUpon = Contacts.CONTENT_URI.buildUpon();
                    buildUpon.appendEncodedPath(String.valueOf(this.mContactId));
                    buildUpon.appendPath(AggregationSuggestions.CONTENT_DIRECTORY);
                    if (this.mLimit != 0) {
                        buildUpon.appendQueryParameter("limit", String.valueOf(this.mLimit));
                    }
                    int size = this.mKinds.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            return buildUpon.build();
                        }
                        buildUpon.appendQueryParameter("query", this.mKinds.get(i2) + ":" + this.mValues.get(i2));
                        i = i2 + 1;
                    }
                }

                public Builder setContactId(long j) {
                    this.mContactId = j;
                    return this;
                }

                public Builder setLimit(int i) {
                    this.mLimit = i;
                    return this;
                }
            }

            private AggregationSuggestions() {
            }

            public static final Builder builder() {
                return new Builder();
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts$Data.class */
        public static final class Data implements BaseColumns, DataColumns {
            public static final String CONTENT_DIRECTORY = "data";

            private Data() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts$Entity.class */
        public static final class Entity implements BaseColumns, ContactsColumns, ContactNameColumns, RawContactsColumns, BaseSyncColumns, SyncColumns, DataColumns, StatusColumns, ContactOptionsColumns, ContactStatusColumns, DataUsageStatColumns {
            public static final String CONTENT_DIRECTORY = "entities";
            public static final String DATA_ID = "data_id";
            public static final String RAW_CONTACT_ID = "raw_contact_id";

            private Entity() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts$Photo.class */
        public static final class Photo implements BaseColumns, DataColumnsWithJoins {
            public static final String CONTENT_DIRECTORY = "photo";
            public static final String DISPLAY_PHOTO = "display_photo";
            public static final String PHOTO = "data15";
            public static final String PHOTO_FILE_ID = "data14";

            private Photo() {
            }
        }

        @Deprecated
        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Contacts$StreamItems.class */
        public static final class StreamItems implements StreamItemsColumns {
            @Deprecated
            public static final String CONTENT_DIRECTORY = "stream_items";

            @Deprecated
            private StreamItems() {
            }
        }

        private Contacts() {
        }

        public static Uri getLookupUri(long j, String str) {
            return ContentUris.withAppendedId(Uri.withAppendedPath(CONTENT_LOOKUP_URI, str), j);
        }

        public static Uri getLookupUri(ContentResolver contentResolver, Uri uri) {
            Cursor query = contentResolver.query(uri, new String[]{ContactsColumns.LOOKUP_KEY, "_id"}, null, null, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    return getLookupUri(query.getLong(1), query.getString(0));
                }
                query.close();
                return null;
            } finally {
                query.close();
            }
        }

        public static boolean isEnterpriseContactId(long j) {
            return j >= ENTERPRISE_CONTACT_ID_BASE && j < Profile.MIN_ID;
        }

        public static Uri lookupContact(ContentResolver contentResolver, Uri uri) {
            Cursor query;
            if (uri == null || (query = contentResolver.query(uri, new String[]{"_id"}, null, null, null)) == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    return ContentUris.withAppendedId(CONTENT_URI, query.getLong(0));
                }
                query.close();
                return null;
            } finally {
                query.close();
            }
        }

        @Deprecated
        public static void markAsContacted(ContentResolver contentResolver, long j) {
            Uri withAppendedId = ContentUris.withAppendedId(CONTENT_URI, j);
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_time_contacted", Long.valueOf(System.currentTimeMillis()));
            contentResolver.update(withAppendedId, contentValues, null, null);
        }

        public static InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri) {
            return openContactPhotoInputStream(contentResolver, uri, false);
        }

        public static InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri, boolean z) {
            InputStream inputStream;
            if (z) {
                try {
                    inputStream = contentResolver.openAssetFileDescriptor(Uri.withAppendedPath(uri, "display_photo"), "r").createInputStream();
                } catch (IOException e) {
                }
                return inputStream;
            }
            Uri withAppendedPath = Uri.withAppendedPath(uri, "photo");
            inputStream = null;
            if (withAppendedPath != null) {
                Cursor query = contentResolver.query(withAppendedPath, new String[]{"data15"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            byte[] blob = query.getBlob(0);
                            if (blob == null) {
                                inputStream = null;
                                if (query != null) {
                                    query.close();
                                    return null;
                                }
                            } else {
                                InputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                inputStream = byteArrayInputStream;
                                if (query != null) {
                                    query.close();
                                    return byteArrayInputStream;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                inputStream = null;
                if (query != null) {
                    query.close();
                    return null;
                }
            }
            return inputStream;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ContactsColumns.class */
    protected interface ContactsColumns {
        public static final String CONTACT_LAST_UPDATED_TIMESTAMP = "contact_last_updated_timestamp";
        public static final String DISPLAY_NAME = "display_name";
        public static final String HAS_PHONE_NUMBER = "has_phone_number";
        public static final String IN_DEFAULT_DIRECTORY = "in_default_directory";
        public static final String IN_VISIBLE_GROUP = "in_visible_group";
        public static final String IS_USER_PROFILE = "is_user_profile";
        public static final String LOOKUP_KEY = "lookup";
        public static final String NAME_RAW_CONTACT_ID = "name_raw_contact_id";
        public static final String PHOTO_FILE_ID = "photo_file_id";
        public static final String PHOTO_ID = "photo_id";
        public static final String PHOTO_THUMBNAIL_URI = "photo_thumb_uri";
        public static final String PHOTO_URI = "photo_uri";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Data.class */
    public static final class Data implements DataColumnsWithJoins, ContactCounts {
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "data");
        public static final String VISIBLE_CONTACTS_ONLY = "visible_contacts_only";

        private Data() {
        }

        /* JADX WARN: Finally extract failed */
        public static Uri getContactLookupUri(ContentResolver contentResolver, Uri uri) {
            Cursor query = contentResolver.query(uri, new String[]{"contact_id", ContactsColumns.LOOKUP_KEY}, null, null, null);
            Uri uri2 = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        Uri lookupUri = Contacts.getLookupUri(query.getLong(0), query.getString(1));
                        uri2 = lookupUri;
                        if (query != null) {
                            query.close();
                            uri2 = lookupUri;
                        }
                        return uri2;
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
                return null;
            }
            return uri2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DataColumns.class */
    protected interface DataColumns {
        public static final String DATA1 = "data1";
        public static final String DATA10 = "data10";
        public static final String DATA11 = "data11";
        public static final String DATA12 = "data12";
        public static final String DATA13 = "data13";
        public static final String DATA14 = "data14";
        public static final String DATA15 = "data15";
        public static final String DATA2 = "data2";
        public static final String DATA3 = "data3";
        public static final String DATA4 = "data4";
        public static final String DATA5 = "data5";
        public static final String DATA6 = "data6";
        public static final String DATA7 = "data7";
        public static final String DATA8 = "data8";
        public static final String DATA9 = "data9";
        public static final String DATA_VERSION = "data_version";
        public static final String IS_PRIMARY = "is_primary";
        public static final String IS_READ_ONLY = "is_read_only";
        public static final String IS_SUPER_PRIMARY = "is_super_primary";
        public static final String MIMETYPE = "mimetype";
        public static final String RAW_CONTACT_ID = "raw_contact_id";
        public static final String RES_PACKAGE = "res_package";
        public static final String SYNC1 = "data_sync1";
        public static final String SYNC2 = "data_sync2";
        public static final String SYNC3 = "data_sync3";
        public static final String SYNC4 = "data_sync4";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DataColumnsWithJoins.class */
    protected interface DataColumnsWithJoins extends BaseColumns, DataColumns, StatusColumns, RawContactsColumns, ContactsColumns, ContactNameColumns, ContactOptionsColumns, ContactStatusColumns, DataUsageStatColumns {
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DataUsageFeedback.class */
    public static final class DataUsageFeedback {
        public static final String USAGE_TYPE = "type";
        public static final String USAGE_TYPE_CALL = "call";
        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
        public static final Uri FEEDBACK_URI = Uri.withAppendedPath(Data.CONTENT_URI, "usagefeedback");
        public static final Uri DELETE_USAGE_URI = Uri.withAppendedPath(Contacts.CONTENT_URI, "delete_usage");
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DataUsageStatColumns.class */
    protected interface DataUsageStatColumns {
        public static final String LAST_TIME_USED = "last_time_used";
        public static final String TIMES_USED = "times_used";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DeletedContacts.class */
    public static final class DeletedContacts implements DeletedContactsColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "deleted_contacts");
        private static final int DAYS_KEPT = 30;
        public static final long DAYS_KEPT_MILLISECONDS = 2592000000L;

        private DeletedContacts() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DeletedContactsColumns.class */
    protected interface DeletedContactsColumns {
        public static final String CONTACT_DELETED_TIMESTAMP = "contact_deleted_timestamp";
        public static final String CONTACT_ID = "contact_id";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Directory.class */
    public static final class Directory implements BaseColumns {
        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_directory";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_directories";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
        public static final long DEFAULT = 0;
        public static final String DIRECTORY_AUTHORITY = "authority";
        public static final String DISPLAY_NAME = "displayName";
        public static final String EXPORT_SUPPORT = "exportSupport";
        public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2;
        public static final int EXPORT_SUPPORT_NONE = 0;
        public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1;
        public static final long LOCAL_INVISIBLE = 1;
        public static final String PACKAGE_NAME = "packageName";
        public static final String PHOTO_SUPPORT = "photoSupport";
        public static final int PHOTO_SUPPORT_FULL = 3;
        public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2;
        public static final int PHOTO_SUPPORT_NONE = 0;
        public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1;
        public static final String SHORTCUT_SUPPORT = "shortcutSupport";
        public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1;
        public static final int SHORTCUT_SUPPORT_FULL = 2;
        public static final int SHORTCUT_SUPPORT_NONE = 0;
        public static final String TYPE_RESOURCE_ID = "typeResourceId";

        private Directory() {
        }

        public static void notifyDirectoryChange(ContentResolver contentResolver) {
            contentResolver.update(CONTENT_URI, new ContentValues(), null, null);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DisplayNameSources.class */
    public interface DisplayNameSources {
        public static final int EMAIL = 10;
        public static final int NICKNAME = 35;
        public static final int ORGANIZATION = 30;
        public static final int PHONE = 20;
        public static final int STRUCTURED_NAME = 40;
        public static final int UNDEFINED = 0;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$DisplayPhoto.class */
    public static final class DisplayPhoto {
        public static final String DISPLAY_MAX_DIM = "display_max_dim";
        public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
        public static final Uri CONTENT_MAX_DIMENSIONS_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "photo_dimensions");

        private DisplayPhoto() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$FullNameStyle.class */
    public interface FullNameStyle {
        public static final int CHINESE = 3;
        public static final int CJK = 2;
        public static final int JAPANESE = 4;
        public static final int KOREAN = 5;
        public static final int UNDEFINED = 0;
        public static final int WESTERN = 1;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Groups.class */
    public static final class Groups implements BaseColumns, GroupsColumns, SyncColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "groups");
        public static final Uri CONTENT_SUMMARY_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "groups_summary");

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Groups$EntityIteratorImpl.class */
        private static class EntityIteratorImpl extends CursorEntityIterator {
            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }

            @Override // android.content.CursorEntityIterator
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "_id");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "account_name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "account_type");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "dirty");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "version");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sourceid");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "res_package");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "title");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, GroupsColumns.TITLE_RES);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, GroupsColumns.GROUP_VISIBLE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync4");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "system_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "deleted");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "notes");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "should_sync");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, GroupsColumns.FAVORITES);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, GroupsColumns.AUTO_ADD);
                cursor.moveToNext();
                return new Entity(contentValues);
            }
        }

        private Groups() {
        }

        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$GroupsColumns.class */
    protected interface GroupsColumns {
        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";
        public static final String AUTO_ADD = "auto_add";
        public static final String DATA_SET = "data_set";
        public static final String DELETED = "deleted";
        public static final String FAVORITES = "favorites";
        public static final String GROUP_IS_READ_ONLY = "group_is_read_only";
        public static final String GROUP_VISIBLE = "group_visible";
        public static final String NOTES = "notes";
        public static final String PARAM_RETURN_GROUP_COUNT_PER_ACCOUNT = "return_group_count_per_account";
        public static final String RES_PACKAGE = "res_package";
        public static final String SHOULD_SYNC = "should_sync";
        public static final String SUMMARY_COUNT = "summ_count";
        public static final String SUMMARY_GROUP_COUNT_PER_ACCOUNT = "group_count_per_account";
        public static final String SUMMARY_WITH_PHONES = "summ_phones";
        public static final String SYSTEM_ID = "system_id";
        public static final String TITLE = "title";
        public static final String TITLE_RES = "title_res";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Intents.class */
    public static final class Intents {
        public static final String ACTION_GET_MULTIPLE_PHONES = "com.android.contacts.action.GET_MULTIPLE_PHONES";
        public static final String ACTION_PROFILE_CHANGED = "android.provider.Contacts.PROFILE_CHANGED";
        public static final String ATTACH_IMAGE = "com.android.contacts.action.ATTACH_IMAGE";
        public static final String CONTACTS_DATABASE_CREATED = "android.provider.Contacts.DATABASE_CREATED";
        public static final String EXTRA_CREATE_DESCRIPTION = "com.android.contacts.action.CREATE_DESCRIPTION";
        @Deprecated
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        public static final String EXTRA_FORCE_CREATE = "com.android.contacts.action.FORCE_CREATE";
        @Deprecated
        public static final String EXTRA_MODE = "mode";
        public static final String EXTRA_PHONE_URIS = "com.android.contacts.extra.PHONE_URIS";
        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
        public static final String INVITE_CONTACT = "com.android.contacts.action.INVITE_CONTACT";
        @Deprecated
        public static final int MODE_LARGE = 3;
        @Deprecated
        public static final int MODE_MEDIUM = 2;
        @Deprecated
        public static final int MODE_SMALL = 1;
        public static final String SEARCH_SUGGESTION_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
        public static final String SHOW_OR_CREATE_CONTACT = "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Intents$Insert.class */
        public static final class Insert {
            public static final String ACCOUNT = "com.android.contacts.extra.ACCOUNT";
            public static final String ACTION = "android.intent.action.INSERT";
            public static final String COMPANY = "company";
            public static final String DATA = "data";
            public static final String DATA_SET = "com.android.contacts.extra.DATA_SET";
            public static final String EMAIL = "email";
            public static final String EMAIL_ISPRIMARY = "email_isprimary";
            public static final String EMAIL_TYPE = "email_type";
            public static final String FULL_MODE = "full_mode";
            public static final String IM_HANDLE = "im_handle";
            public static final String IM_ISPRIMARY = "im_isprimary";
            public static final String IM_PROTOCOL = "im_protocol";
            public static final String JOB_TITLE = "job_title";
            public static final String NAME = "name";
            public static final String NOTES = "notes";
            public static final String PHONE = "phone";
            public static final String PHONETIC_NAME = "phonetic_name";
            public static final String PHONE_ISPRIMARY = "phone_isprimary";
            public static final String PHONE_TYPE = "phone_type";
            public static final String POSTAL = "postal";
            public static final String POSTAL_ISPRIMARY = "postal_isprimary";
            public static final String POSTAL_TYPE = "postal_type";
            public static final String SECONDARY_EMAIL = "secondary_email";
            public static final String SECONDARY_EMAIL_TYPE = "secondary_email_type";
            public static final String SECONDARY_PHONE = "secondary_phone";
            public static final String SECONDARY_PHONE_TYPE = "secondary_phone_type";
            public static final String TERTIARY_EMAIL = "tertiary_email";
            public static final String TERTIARY_EMAIL_TYPE = "tertiary_email_type";
            public static final String TERTIARY_PHONE = "tertiary_phone";
            public static final String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Intents$UI.class */
        public static final class UI {
            public static final String FILTER_CONTACTS_ACTION = "com.android.contacts.action.FILTER_CONTACTS";
            public static final String FILTER_TEXT_EXTRA_KEY = "com.android.contacts.extra.FILTER_TEXT";
            public static final String GROUP_NAME_EXTRA_KEY = "com.android.contacts.extra.GROUP";
            public static final String LIST_ALL_CONTACTS_ACTION = "com.android.contacts.action.LIST_ALL_CONTACTS";
            public static final String LIST_CONTACTS_WITH_PHONES_ACTION = "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";
            public static final String LIST_DEFAULT = "com.android.contacts.action.LIST_DEFAULT";
            public static final String LIST_FREQUENT_ACTION = "com.android.contacts.action.LIST_FREQUENT";
            public static final String LIST_GROUP_ACTION = "com.android.contacts.action.LIST_GROUP";
            public static final String LIST_STARRED_ACTION = "com.android.contacts.action.LIST_STARRED";
            public static final String LIST_STREQUENT_ACTION = "com.android.contacts.action.LIST_STREQUENT";
            public static final String PICK_JOIN_CONTACT_ACTION = "com.android.contacts.action.JOIN_CONTACT";
            public static final String TARGET_CONTACT_ID_EXTRA_KEY = "com.android.contacts.action.CONTACT_ID";
            public static final String TITLE_EXTRA_KEY = "com.android.contacts.extra.TITLE_EXTRA";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PhoneLookup.class */
    public static final class PhoneLookup implements BaseColumns, PhoneLookupColumns, ContactsColumns, ContactOptionsColumns {
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_lookup";
        public static final String QUERY_PARAMETER_SIP_ADDRESS = "sip";
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "phone_lookup");
        public static final Uri ENTERPRISE_CONTENT_FILTER_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "phone_lookup_enterprise");

        private PhoneLookup() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PhoneLookupColumns.class */
    protected interface PhoneLookupColumns {
        public static final String LABEL = "label";
        public static final String NORMALIZED_NUMBER = "normalized_number";
        public static final String NUMBER = "number";
        public static final String TYPE = "type";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PhoneticNameStyle.class */
    public interface PhoneticNameStyle {
        public static final int JAPANESE = 4;
        public static final int KOREAN = 5;
        public static final int PINYIN = 3;
        public static final int UNDEFINED = 0;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PhotoFiles.class */
    public static final class PhotoFiles implements BaseColumns, PhotoFilesColumns {
        private PhotoFiles() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PhotoFilesColumns.class */
    protected interface PhotoFilesColumns {
        public static final String FILESIZE = "filesize";
        public static final String HEIGHT = "height";
        public static final String WIDTH = "width";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PinnedPositions.class */
    public static final class PinnedPositions {
        public static final int DEMOTED = -1;
        public static final String UNDEMOTE_METHOD = "undemote";
        public static final int UNPINNED = 0;

        public static void pin(ContentResolver contentResolver, long j, int i) {
            Uri withAppendedPath = Uri.withAppendedPath(Contacts.CONTENT_URI, String.valueOf(j));
            ContentValues contentValues = new ContentValues();
            contentValues.put(ContactOptionsColumns.PINNED, Integer.valueOf(i));
            contentResolver.update(withAppendedPath, contentValues, null, null);
        }

        public static void undemote(ContentResolver contentResolver, long j) {
            contentResolver.call(ContactsContract.AUTHORITY_URI, UNDEMOTE_METHOD, String.valueOf(j), null);
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Presence.class */
    public static final class Presence extends StatusUpdates {
        public Presence() {
            super();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$PresenceColumns.class */
    protected interface PresenceColumns {
        public static final String CUSTOM_PROTOCOL = "custom_protocol";
        public static final String DATA_ID = "presence_data_id";
        public static final String IM_ACCOUNT = "im_account";
        public static final String IM_HANDLE = "im_handle";
        public static final String PROTOCOL = "protocol";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Profile.class */
    public static final class Profile implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        public static final long MIN_ID = 9223372034707292160L;
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, MediaFormat.KEY_PROFILE);
        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI, "as_vcard");
        public static final Uri CONTENT_RAW_CONTACTS_URI = Uri.withAppendedPath(CONTENT_URI, "raw_contacts");

        private Profile() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ProfileSyncState.class */
    public static final class ProfileSyncState implements SyncStateContract.Columns {
        public static final String CONTENT_DIRECTORY = "syncstate";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(Profile.CONTENT_URI, "syncstate");

        private ProfileSyncState() {
        }

        public static byte[] get(ContentProviderClient contentProviderClient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(contentProviderClient, CONTENT_URI, account);
        }

        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient contentProviderClient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(contentProviderClient, CONTENT_URI, account);
        }

        public static ContentProviderOperation newSetOperation(Account account, byte[] bArr) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, bArr);
        }

        public static void set(ContentProviderClient contentProviderClient, Account account, byte[] bArr) throws RemoteException {
            SyncStateContract.Helpers.set(contentProviderClient, CONTENT_URI, account, bArr);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$ProviderStatus.class */
    public static final class ProviderStatus {
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/provider_status";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "provider_status");
        public static final String DATA1 = "data1";
        public static final String STATUS = "status";
        public static final int STATUS_CHANGING_LOCALE = 3;
        public static final int STATUS_NORMAL = 0;
        public static final int STATUS_NO_ACCOUNTS_NO_CONTACTS = 4;
        public static final int STATUS_UPGRADE_OUT_OF_MEMORY = 2;
        public static final int STATUS_UPGRADING = 1;

        private ProviderStatus() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$QuickContact.class */
    public static final class QuickContact {
        public static final String ACTION_QUICK_CONTACT = "android.provider.action.QUICK_CONTACT";
        public static final String EXTRA_EXCLUDE_MIMES = "android.provider.extra.EXCLUDE_MIMES";
        public static final String EXTRA_MODE = "android.provider.extra.MODE";
        @Deprecated
        public static final String EXTRA_TARGET_RECT = "android.provider.extra.TARGET_RECT";
        public static final int MODE_LARGE = 3;
        public static final int MODE_MEDIUM = 2;
        public static final int MODE_SMALL = 1;

        public static Intent composeQuickContactsIntent(Context context, Rect rect, Uri uri, int i, String[] strArr) {
            while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            Intent addFlags = new Intent(ACTION_QUICK_CONTACT).addFlags((context instanceof Activity ? 0 : 268468224) | 536870912);
            addFlags.setData(uri);
            addFlags.setSourceBounds(rect);
            addFlags.putExtra(EXTRA_MODE, i);
            addFlags.putExtra(EXTRA_EXCLUDE_MIMES, strArr);
            return addFlags;
        }

        public static Intent composeQuickContactsIntent(Context context, View view, Uri uri, int i, String[] strArr) {
            float f = context.getResources().getCompatibilityInfo().applicationScale;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = (int) ((iArr[0] * f) + 0.5f);
            rect.top = (int) ((iArr[1] * f) + 0.5f);
            rect.right = (int) (((iArr[0] + view.getWidth()) * f) + 0.5f);
            rect.bottom = (int) (((iArr[1] + view.getHeight()) * f) + 0.5f);
            return composeQuickContactsIntent(context, rect, uri, i, strArr);
        }

        public static void showQuickContact(Context context, Rect rect, Uri uri, int i, String[] strArr) {
            startActivityWithErrorToast(context, composeQuickContactsIntent(context, rect, uri, i, strArr));
        }

        public static void showQuickContact(Context context, View view, Uri uri, int i, String[] strArr) {
            startActivityWithErrorToast(context, composeQuickContactsIntent(context, view, uri, i, strArr));
        }

        private static void startActivityWithErrorToast(Context context, Intent intent) {
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(context, 17040462, 0).show();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContacts.class */
    public static final class RawContacts implements BaseColumns, RawContactsColumns, ContactOptionsColumns, ContactNameColumns, SyncColumns {
        public static final int AGGREGATION_MODE_DEFAULT = 0;
        public static final int AGGREGATION_MODE_DISABLED = 3;
        @Deprecated
        public static final int AGGREGATION_MODE_IMMEDIATE = 1;
        public static final int AGGREGATION_MODE_SUSPENDED = 2;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "raw_contacts");

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContacts$Data.class */
        public static final class Data implements BaseColumns, DataColumns {
            public static final String CONTENT_DIRECTORY = "data";

            private Data() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContacts$DisplayPhoto.class */
        public static final class DisplayPhoto {
            public static final String CONTENT_DIRECTORY = "display_photo";

            private DisplayPhoto() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContacts$Entity.class */
        public static final class Entity implements BaseColumns, DataColumns {
            public static final String CONTENT_DIRECTORY = "entity";
            public static final String DATA_ID = "data_id";

            private Entity() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContacts$EntityIteratorImpl.class */
        private static class EntityIteratorImpl extends CursorEntityIterator {
            private static final String[] DATA_KEYS = {"data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", DataColumns.DATA12, DataColumns.DATA13, "data14", "data15", DataColumns.SYNC1, DataColumns.SYNC2, DataColumns.SYNC3, DataColumns.SYNC4};

            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }

            @Override // android.content.CursorEntityIterator
            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                long j = cursor.getLong(columnIndexOrThrow);
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "account_name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "account_type");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "data_set");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "dirty");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "version");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sourceid");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues, "sync4");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "deleted");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "contact_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues, "starred");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentValues, RawContactsColumns.NAME_VERIFIED);
                android.content.Entity entity = new android.content.Entity(contentValues);
                while (j == cursor.getLong(columnIndexOrThrow)) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("_id", Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("data_id"))));
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues2, "res_package");
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues2, "mimetype");
                    DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues2, DataColumns.IS_PRIMARY);
                    DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues2, DataColumns.IS_SUPER_PRIMARY);
                    DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentValues2, DataColumns.DATA_VERSION);
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues2, CommonDataKinds.GroupMembership.GROUP_SOURCE_ID);
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentValues2, DataColumns.DATA_VERSION);
                    String[] strArr = DATA_KEYS;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < length) {
                            String str = strArr[i2];
                            int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(str);
                            switch (cursor.getType(columnIndexOrThrow2)) {
                                case 0:
                                    break;
                                case 1:
                                case 2:
                                case 3:
                                    contentValues2.put(str, cursor.getString(columnIndexOrThrow2));
                                    break;
                                case 4:
                                    contentValues2.put(str, cursor.getBlob(columnIndexOrThrow2));
                                    break;
                                default:
                                    throw new IllegalStateException("Invalid or unhandled data type");
                            }
                            i = i2 + 1;
                        } else {
                            entity.addSubValue(Data.CONTENT_URI, contentValues2);
                            if (!cursor.moveToNext()) {
                                return entity;
                            }
                        }
                    }
                }
                return entity;
            }
        }

        @Deprecated
        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContacts$StreamItems.class */
        public static final class StreamItems implements BaseColumns, StreamItemsColumns {
            @Deprecated
            public static final String CONTENT_DIRECTORY = "stream_items";

            @Deprecated
            private StreamItems() {
            }
        }

        private RawContacts() {
        }

        /* JADX WARN: Finally extract failed */
        public static Uri getContactLookupUri(ContentResolver contentResolver, Uri uri) {
            Cursor query = contentResolver.query(Uri.withAppendedPath(uri, "data"), new String[]{"contact_id", ContactsColumns.LOOKUP_KEY}, null, null, null);
            Uri uri2 = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        Uri lookupUri = Contacts.getLookupUri(query.getLong(0), query.getString(1));
                        uri2 = lookupUri;
                        if (query != null) {
                            query.close();
                            uri2 = lookupUri;
                        }
                        return uri2;
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
                return null;
            }
            return uri2;
        }

        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContactsColumns.class */
    protected interface RawContactsColumns {
        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";
        public static final String AGGREGATION_MODE = "aggregation_mode";
        public static final String CONTACT_ID = "contact_id";
        public static final String DATA_SET = "data_set";
        public static final String DELETED = "deleted";
        public static final String NAME_VERIFIED = "name_verified";
        public static final String RAW_CONTACT_IS_READ_ONLY = "raw_contact_is_read_only";
        public static final String RAW_CONTACT_IS_USER_PROFILE = "raw_contact_is_user_profile";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$RawContactsEntity.class */
    public static final class RawContactsEntity implements BaseColumns, DataColumns, RawContactsColumns {
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";
        public static final String DATA_ID = "data_id";
        public static final String FOR_EXPORT_ONLY = "for_export_only";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "raw_contact_entities");
        public static final Uri PROFILE_CONTENT_URI = Uri.withAppendedPath(Profile.CONTENT_URI, "raw_contact_entities");

        private RawContactsEntity() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$SearchSnippets.class */
    public static class SearchSnippets {
        public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
        public static final String SNIPPET = "snippet";
        public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$Settings.class */
    public static final class Settings implements SettingsColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "settings");

        private Settings() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$SettingsColumns.class */
    protected interface SettingsColumns {
        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String ANY_UNSYNCED = "any_unsynced";
        public static final String DATA_SET = "data_set";
        public static final String SHOULD_SYNC = "should_sync";
        public static final String UNGROUPED_COUNT = "summ_count";
        public static final String UNGROUPED_VISIBLE = "ungrouped_visible";
        public static final String UNGROUPED_WITH_PHONES = "summ_phones";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StatusColumns.class */
    protected interface StatusColumns {
        public static final int AVAILABLE = 5;
        public static final int AWAY = 2;
        public static final int CAPABILITY_HAS_CAMERA = 4;
        public static final int CAPABILITY_HAS_VIDEO = 2;
        public static final int CAPABILITY_HAS_VOICE = 1;
        public static final String CHAT_CAPABILITY = "chat_capability";
        public static final int DO_NOT_DISTURB = 4;
        public static final int IDLE = 3;
        public static final int INVISIBLE = 1;
        public static final int OFFLINE = 0;
        public static final String PRESENCE = "mode";
        @Deprecated
        public static final String PRESENCE_CUSTOM_STATUS = "status";
        @Deprecated
        public static final String PRESENCE_STATUS = "mode";
        public static final String STATUS = "status";
        public static final String STATUS_ICON = "status_icon";
        public static final String STATUS_LABEL = "status_label";
        public static final String STATUS_RES_PACKAGE = "status_res_package";
        public static final String STATUS_TIMESTAMP = "status_ts";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StatusUpdates.class */
    public static class StatusUpdates implements StatusColumns, PresenceColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "status_updates");
        public static final Uri PROFILE_CONTENT_URI = Uri.withAppendedPath(Profile.CONTENT_URI, "status_updates");

        private StatusUpdates() {
        }

        public static final int getPresenceIconResourceId(int i) {
            switch (i) {
                case 1:
                    return R.drawable.presence_invisible;
                case 2:
                case 3:
                    return R.drawable.presence_away;
                case 4:
                    return R.drawable.presence_busy;
                case 5:
                    return R.drawable.presence_online;
                default:
                    return R.drawable.presence_offline;
            }
        }

        public static final int getPresencePrecedence(int i) {
            return i;
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StreamItemPhotos.class */
    public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
        @Deprecated
        public static final String PHOTO = "photo";

        @Deprecated
        private StreamItemPhotos() {
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StreamItemPhotosColumns.class */
    protected interface StreamItemPhotosColumns {
        @Deprecated
        public static final String PHOTO_FILE_ID = "photo_file_id";
        @Deprecated
        public static final String PHOTO_URI = "photo_uri";
        @Deprecated
        public static final String SORT_INDEX = "sort_index";
        @Deprecated
        public static final String STREAM_ITEM_ID = "stream_item_id";
        @Deprecated
        public static final String SYNC1 = "stream_item_photo_sync1";
        @Deprecated
        public static final String SYNC2 = "stream_item_photo_sync2";
        @Deprecated
        public static final String SYNC3 = "stream_item_photo_sync3";
        @Deprecated
        public static final String SYNC4 = "stream_item_photo_sync4";
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StreamItems.class */
    public static final class StreamItems implements BaseColumns, StreamItemsColumns {
        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";
        @Deprecated
        public static final String MAX_ITEMS = "max_items";
        @Deprecated
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "stream_items");
        @Deprecated
        public static final Uri CONTENT_PHOTO_URI = Uri.withAppendedPath(CONTENT_URI, "photo");
        @Deprecated
        public static final Uri CONTENT_LIMIT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "stream_items_limit");

        @Deprecated
        /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StreamItems$StreamItemPhotos.class */
        public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
            @Deprecated
            public static final String CONTENT_DIRECTORY = "photo";
            @Deprecated
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item_photo";
            @Deprecated
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";

            @Deprecated
            private StreamItemPhotos() {
            }
        }

        @Deprecated
        private StreamItems() {
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$StreamItemsColumns.class */
    protected interface StreamItemsColumns {
        @Deprecated
        public static final String ACCOUNT_NAME = "account_name";
        @Deprecated
        public static final String ACCOUNT_TYPE = "account_type";
        @Deprecated
        public static final String COMMENTS = "comments";
        @Deprecated
        public static final String CONTACT_ID = "contact_id";
        @Deprecated
        public static final String CONTACT_LOOKUP_KEY = "contact_lookup";
        @Deprecated
        public static final String DATA_SET = "data_set";
        @Deprecated
        public static final String RAW_CONTACT_ID = "raw_contact_id";
        @Deprecated
        public static final String RAW_CONTACT_SOURCE_ID = "raw_contact_source_id";
        @Deprecated
        public static final String RES_ICON = "icon";
        @Deprecated
        public static final String RES_LABEL = "label";
        @Deprecated
        public static final String RES_PACKAGE = "res_package";
        @Deprecated
        public static final String SYNC1 = "stream_item_sync1";
        @Deprecated
        public static final String SYNC2 = "stream_item_sync2";
        @Deprecated
        public static final String SYNC3 = "stream_item_sync3";
        @Deprecated
        public static final String SYNC4 = "stream_item_sync4";
        @Deprecated
        public static final String TEXT = "text";
        @Deprecated
        public static final String TIMESTAMP = "timestamp";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$SyncColumns.class */
    protected interface SyncColumns extends BaseSyncColumns {
        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String DIRTY = "dirty";
        public static final String SOURCE_ID = "sourceid";
        public static final String VERSION = "version";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$SyncState.class */
    public static final class SyncState implements SyncStateContract.Columns {
        public static final String CONTENT_DIRECTORY = "syncstate";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "syncstate");

        private SyncState() {
        }

        public static byte[] get(ContentProviderClient contentProviderClient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(contentProviderClient, CONTENT_URI, account);
        }

        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient contentProviderClient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(contentProviderClient, CONTENT_URI, account);
        }

        public static ContentProviderOperation newSetOperation(Account account, byte[] bArr) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, bArr);
        }

        public static void set(ContentProviderClient contentProviderClient, Account account, byte[] bArr) throws RemoteException {
            SyncStateContract.Helpers.set(contentProviderClient, CONTENT_URI, account, bArr);
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/provider/ContactsContract$SyncStateColumns.class */
    public interface SyncStateColumns extends SyncStateContract.Columns {
    }

    public static boolean isProfileId(long j) {
        return j >= Profile.MIN_ID;
    }
}
