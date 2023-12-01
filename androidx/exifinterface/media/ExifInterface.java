package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.mtp.MtpConstants;
import android.opengl.GLES30;
import android.opengl.GLES31Ext;
import android.text.format.Time;
import android.util.Log;
import android.util.Pair;
import com.anythink.expressad.exoplayer.b;
import com.blued.das.live.LiveProtos;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface.class */
public class ExifInterface {
    private static final HashMap<String, ExifTag>[] A;
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    private static final HashSet<String> B;
    private static final HashMap<Integer, Integer> C;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    private static final Pattern U;
    private static final Pattern V;
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    static final ExifTag[][] e;
    static final Charset f;
    static final byte[] g;
    private static SimpleDateFormat l;
    private static final ExifTag[] v;
    private static final ExifTag[] w;
    private static final ExifTag x;
    private static final ExifTag y;
    private static final HashMap<Integer, ExifTag>[] z;
    private final String D;
    private final AssetManager.AssetInputStream E;
    private int F;
    private final HashMap<String, ExifAttribute>[] G;
    private Set<Integer> H;
    private ByteOrder I;
    private boolean J;
    private int K;
    private int L;
    private byte[] M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private static final List<Integer> h = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> i = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f2847a = {-1, -40, -1};
    private static final byte[] j = {79, 76, 89, 77, 80, 0};
    private static final byte[] k = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    static final String[] b = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f2848c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] d = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    private static final ExifTag[] m = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, LiveProtos.Event.LIVE_PK_START_BTN_CLICK_VALUE, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, LiveProtos.Event.LIVE_PK_EXIT_BTN_SHOW_VALUE, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, LiveProtos.Event.LIVE_PK_EXIT_BTN_CLICK_VALUE, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", GLES30.GL_DRAW_BUFFER0, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7)};
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    private static final ExifTag[] n = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, GLES30.GL_MAX_DRAW_BUFFERS, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, GLES30.GL_DRAW_BUFFER2, 3), new ExifTag(TAG_OECF, GLES30.GL_DRAW_BUFFER3, 7), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, GLES31Ext.GL_TEXTURE_2D_MULTISAMPLE_ARRAY_OES, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    private static final ExifTag[] o = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    private static final ExifTag[] p = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    private static final ExifTag[] q = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, LiveProtos.Event.LIVE_PK_START_BTN_CLICK_VALUE, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, LiveProtos.Event.LIVE_PK_EXIT_BTN_SHOW_VALUE, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, LiveProtos.Event.LIVE_PK_EXIT_BTN_CLICK_VALUE, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", GLES30.GL_DRAW_BUFFER0, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    private static final ExifTag r = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    private static final ExifTag[] s = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag("CameraSettingsIFDPointer", MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    private static final ExifTag[] t = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final ExifTag[] u = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream.class */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {

        /* renamed from: c  reason: collision with root package name */
        private static final ByteOrder f2849c = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder d = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        final int f2850a;
        int b;
        private DataInputStream e;
        private ByteOrder f;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.f = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.e = dataInputStream;
            int available = dataInputStream.available();
            this.f2850a = available;
            this.b = 0;
            this.e.mark(available);
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.e.available();
        }

        public int peek() {
            return this.b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.b++;
            return this.e.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.e.read(bArr, i, i2);
            this.b += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.b++;
            return this.e.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.b + 1;
            this.b = i;
            if (i <= this.f2850a) {
                int read = this.e.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.b += 2;
            return this.e.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.b + bArr.length;
            this.b = length;
            if (length > this.f2850a) {
                throw new EOFException();
            }
            if (this.e.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.b + i2;
            this.b = i3;
            if (i3 > this.f2850a) {
                throw new EOFException();
            }
            if (this.e.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.b + 4;
            this.b = i;
            if (i <= this.f2850a) {
                int read = this.e.read();
                int read2 = this.e.read();
                int read3 = this.e.read();
                int read4 = this.e.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f;
                    if (byteOrder == f2849c) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == d) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.b + 8;
            this.b = i;
            if (i <= this.f2850a) {
                int read = this.e.read();
                int read2 = this.e.read();
                int read3 = this.e.read();
                int read4 = this.e.read();
                int read5 = this.e.read();
                int read6 = this.e.read();
                int read7 = this.e.read();
                int read8 = this.e.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f;
                    if (byteOrder == f2849c) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == d) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    throw new IOException("Invalid byte order: " + this.f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.b + 2;
            this.b = i;
            if (i <= this.f2850a) {
                int read = this.e.read();
                int read2 = this.e.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f;
                    if (byteOrder == f2849c) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == d) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.b += 2;
            return this.e.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.b++;
            return this.e.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.b + 2;
            this.b = i;
            if (i <= this.f2850a) {
                int read = this.e.read();
                int read2 = this.e.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f;
                    if (byteOrder == f2849c) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == d) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j) throws IOException {
            int i = this.b;
            if (i > j) {
                this.b = 0;
                this.e.reset();
                this.e.mark(this.f2850a);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.f = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.f2850a - this.b);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= min) {
                    this.b += i3;
                    return i3;
                }
                i2 = i3 + this.e.skipBytes(min - i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream.class */
    public static class ByteOrderedDataOutputStream extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final OutputStream f2851a;
        private ByteOrder b;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f2851a = outputStream;
            this.b = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f2851a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f2851a.write(bArr, i, i2);
        }

        public void writeByte(int i) throws IOException {
            this.f2851a.write(i);
        }

        public void writeInt(int i) throws IOException {
            if (this.b == ByteOrder.LITTLE_ENDIAN) {
                this.f2851a.write((i >>> 0) & 255);
                this.f2851a.write((i >>> 8) & 255);
                this.f2851a.write((i >>> 16) & 255);
                this.f2851a.write((i >>> 24) & 255);
            } else if (this.b == ByteOrder.BIG_ENDIAN) {
                this.f2851a.write((i >>> 24) & 255);
                this.f2851a.write((i >>> 16) & 255);
                this.f2851a.write((i >>> 8) & 255);
                this.f2851a.write((i >>> 0) & 255);
            }
        }

        public void writeShort(short s) throws IOException {
            if (this.b == ByteOrder.LITTLE_ENDIAN) {
                this.f2851a.write((s >>> 0) & 255);
                this.f2851a.write((s >>> 8) & 255);
            } else if (this.b == ByteOrder.BIG_ENDIAN) {
                this.f2851a.write((s >>> 8) & 255);
                this.f2851a.write((s >>> 0) & 255);
            }
        }

        public void writeUnsignedInt(long j) throws IOException {
            writeInt((int) j);
        }

        public void writeUnsignedShort(int i) throws IOException {
            writeShort((short) i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface$ExifAttribute.class */
    public static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(ExifInterface.f);
                return new ExifAttribute(1, bytes.length, bytes);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f2848c[12] * dArr.length]);
            wrap.order(byteOrder);
            int length = dArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new ExifAttribute(12, dArr.length, wrap.array());
                }
                wrap.putDouble(dArr[i2]);
                i = i2 + 1;
            }
        }

        public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f2848c[9] * iArr.length]);
            wrap.order(byteOrder);
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new ExifAttribute(9, iArr.length, wrap.array());
                }
                wrap.putInt(iArr[i2]);
                i = i2 + 1;
            }
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f2848c[10] * rationalArr.length]);
            wrap.order(byteOrder);
            int length = rationalArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new ExifAttribute(10, rationalArr.length, wrap.array());
                }
                Rational rational = rationalArr[i2];
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
                i = i2 + 1;
            }
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.f);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f2848c[4] * jArr.length]);
            wrap.order(byteOrder);
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new ExifAttribute(4, jArr.length, wrap.array());
                }
                wrap.putInt((int) jArr[i2]);
                i = i2 + 1;
            }
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f2848c[5] * rationalArr.length]);
            wrap.order(byteOrder);
            int length = rationalArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new ExifAttribute(5, rationalArr.length, wrap.array());
                }
                Rational rational = rationalArr[i2];
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
                i = i2 + 1;
            }
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.f2848c[3] * iArr.length]);
            wrap.order(byteOrder);
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new ExifAttribute(3, iArr.length, wrap.array());
                }
                wrap.putShort((short) iArr[i2]);
                i = i2 + 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:237:0x042e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object a(java.nio.ByteOrder r10) {
            /*
                Method dump skipped, instructions count: 1109
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.a(java.nio.ByteOrder):java.lang.Object");
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 != null) {
                if (a2 instanceof String) {
                    return Double.parseDouble((String) a2);
                }
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof double[]) {
                    double[] dArr = (double[]) a2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) a2;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 != null) {
                if (a2 instanceof String) {
                    return Integer.parseInt((String) a2);
                }
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof String) {
                return (String) a2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    int i2 = i + 1;
                    i = i2;
                    if (i2 != jArr.length) {
                        sb.append(",");
                        i = i2;
                    }
                }
                return sb.toString();
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                int i3 = 0;
                while (i3 < iArr.length) {
                    sb.append(iArr[i3]);
                    int i4 = i3 + 1;
                    i3 = i4;
                    if (i4 != iArr.length) {
                        sb.append(",");
                        i3 = i4;
                    }
                }
                return sb.toString();
            } else if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                int i5 = 0;
                while (i5 < dArr.length) {
                    sb.append(dArr[i5]);
                    int i6 = i5 + 1;
                    i5 = i6;
                    if (i6 != dArr.length) {
                        sb.append(",");
                        i5 = i6;
                    }
                }
                return sb.toString();
            } else if (a2 instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) a2;
                int i7 = 0;
                while (i7 < rationalArr.length) {
                    sb.append(rationalArr[i7].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i7].denominator);
                    int i8 = i7 + 1;
                    i7 = i8;
                    if (i8 != rationalArr.length) {
                        sb.append(",");
                        i7 = i8;
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        public int size() {
            return ExifInterface.f2848c[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.b[this.format] + ", data length:" + this.bytes.length + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface$ExifTag.class */
    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        ExifTag(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }

        boolean a(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && i == 8) {
                return true;
            }
            return (this.primaryFormat == 12 || this.secondaryFormat == 12) && i == 11;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface$IfdType.class */
    public @interface IfdType {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/exifinterface/media/ExifInterface$Rational.class */
    public static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d) {
            this((long) (d * 10000.0d), 10000L);
        }

        Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    /* JADX WARN: Type inference failed for: r0v59, types: [androidx.exifinterface.media.ExifInterface$ExifTag[], androidx.exifinterface.media.ExifInterface$ExifTag[][]] */
    static {
        ExifTag[] exifTagArr = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        v = exifTagArr;
        ExifTag[] exifTagArr2 = m;
        e = new ExifTag[]{exifTagArr2, n, o, p, q, exifTagArr2, s, t, u, exifTagArr};
        w = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", GLES30.GL_DRAW_BUFFER0, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        x = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        y = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        ExifTag[][] exifTagArr3 = e;
        z = new HashMap[exifTagArr3.length];
        A = new HashMap[exifTagArr3.length];
        B = new HashSet<>(Arrays.asList("FNumber", TAG_DIGITAL_ZOOM_RATIO, "ExposureTime", TAG_SUBJECT_DISTANCE, "GPSTimeStamp"));
        C = new HashMap<>();
        Charset forName = Charset.forName(b.i);
        f = forName;
        g = "Exif����".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        l = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= e.length) {
                C.put(Integer.valueOf(w[0].number), 5);
                C.put(Integer.valueOf(w[1].number), 1);
                C.put(Integer.valueOf(w[2].number), 2);
                C.put(Integer.valueOf(w[3].number), 3);
                C.put(Integer.valueOf(w[4].number), 7);
                C.put(Integer.valueOf(w[5].number), 8);
                U = Pattern.compile(".*[1-9].*");
                V = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            z[i3] = new HashMap<>();
            A[i3] = new HashMap<>();
            ExifTag[] exifTagArr4 = e[i3];
            int length = exifTagArr4.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length) {
                    ExifTag exifTag = exifTagArr4[i5];
                    z[i3].put(Integer.valueOf(exifTag.number), exifTag);
                    A[i3].put(exifTag.name, exifTag);
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        this.G = new HashMap[e.length];
        this.H = new HashSet(e.length);
        this.I = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.D = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.E = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.E = null;
        }
        a(inputStream);
    }

    public ExifInterface(String str) throws IOException {
        FileInputStream fileInputStream;
        this.G = new HashMap[e.length];
        this.H = new HashSet(e.length);
        this.I = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.E = null;
        this.D = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            a((InputStream) fileInputStream);
            a((Closeable) fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) fileInputStream);
            throw th;
        }
    }

    private static double a(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split("/", -1);
            double parseDouble3 = parseDouble + (parseDouble2 / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                    throw new IllegalArgumentException();
                }
                return parseDouble3;
            }
            return -parseDouble3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e2) {
            throw new IllegalArgumentException();
        }
    }

    private int a(ByteOrderedDataOutputStream byteOrderedDataOutputStream, int i2) throws IOException {
        int i3;
        ExifTag[][] exifTagArr = e;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        ExifTag[] exifTagArr2 = w;
        int length = exifTagArr2.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                break;
            }
            b(exifTagArr2[i5].name);
            i4 = i5 + 1;
        }
        b(x.name);
        b(y.name);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= e.length) {
                break;
            }
            Object[] array = this.G[i7].entrySet().toArray();
            int length2 = array.length;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < length2) {
                    Map.Entry entry = (Map.Entry) array[i9];
                    if (entry.getValue() == null) {
                        this.G[i7].remove(entry.getKey());
                    }
                    i8 = i9 + 1;
                }
            }
            i6 = i7 + 1;
        }
        if (!this.G[1].isEmpty()) {
            this.G[0].put(w[1].name, ExifAttribute.createULong(0L, this.I));
        }
        if (!this.G[2].isEmpty()) {
            this.G[0].put(w[2].name, ExifAttribute.createULong(0L, this.I));
        }
        if (!this.G[3].isEmpty()) {
            this.G[1].put(w[3].name, ExifAttribute.createULong(0L, this.I));
        }
        if (this.J) {
            this.G[4].put(x.name, ExifAttribute.createULong(0L, this.I));
            this.G[4].put(y.name, ExifAttribute.createULong(this.L, this.I));
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= e.length) {
                break;
            }
            int i12 = 0;
            for (Map.Entry<String, ExifAttribute> entry2 : this.G[i11].entrySet()) {
                int size = entry2.getValue().size();
                if (size > 4) {
                    i12 += size;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
            i10 = i11 + 1;
        }
        int i13 = 0;
        int i14 = 8;
        while (true) {
            i3 = i14;
            if (i13 >= e.length) {
                break;
            }
            int i15 = i3;
            if (!this.G[i13].isEmpty()) {
                iArr[i13] = i3;
                i15 = i3 + (this.G[i13].size() * 12) + 2 + 4 + iArr2[i13];
            }
            i13++;
            i14 = i15;
        }
        int i16 = i3;
        if (this.J) {
            this.G[4].put(x.name, ExifAttribute.createULong(i3, this.I));
            this.K = i2 + i3;
            i16 = i3 + this.L;
        }
        int i17 = i16 + 8;
        if (!this.G[1].isEmpty()) {
            this.G[0].put(w[1].name, ExifAttribute.createULong(iArr[1], this.I));
        }
        if (!this.G[2].isEmpty()) {
            this.G[0].put(w[2].name, ExifAttribute.createULong(iArr[2], this.I));
        }
        if (!this.G[3].isEmpty()) {
            this.G[1].put(w[3].name, ExifAttribute.createULong(iArr[3], this.I));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(i17);
        byteOrderedDataOutputStream.write(g);
        byteOrderedDataOutputStream.writeShort(this.I == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        byteOrderedDataOutputStream.setByteOrder(this.I);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        int i18 = 0;
        while (true) {
            int i19 = i18;
            if (i19 >= e.length) {
                break;
            }
            if (!this.G[i19].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.G[i19].size());
                int size2 = iArr[i19] + 2 + (this.G[i19].size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry3 : this.G[i19].entrySet()) {
                    int i20 = A[i19].get(entry3.getKey()).number;
                    ExifAttribute value = entry3.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i20);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i19 != 0 || this.G[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> entry4 : this.G[i19].entrySet()) {
                    ExifAttribute value2 = entry4.getValue();
                    if (value2.bytes.length > 4) {
                        byteOrderedDataOutputStream.write(value2.bytes, 0, value2.bytes.length);
                    }
                }
            }
            i18 = i19 + 1;
        }
        if (this.J) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i17;
    }

    private int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (b(bArr)) {
            return 9;
        }
        if (c(bArr)) {
            return 7;
        }
        return d(bArr) ? 10 : 0;
    }

    private ExifAttribute a(String str) {
        String str2 = str;
        if ("ISOSpeedRatings".equals(str)) {
            str2 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= e.length) {
                return null;
            }
            ExifAttribute exifAttribute = this.G[i3].get(str2);
            if (exifAttribute != null) {
                return exifAttribute;
            }
            i2 = i3 + 1;
        }
    }

    private String a(double d2) {
        long j2 = (long) d2;
        double d3 = d2 - j2;
        long j3 = (long) (d3 * 60.0d);
        long round = Math.round((d3 - (j3 / 60.0d)) * 3600.0d * 1.0E7d);
        return j2 + "/1," + j3 + "/1," + round + "/10000000";
    }

    private void a() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute("DateTime") == null) {
            this.G[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.G[0].put("ImageWidth", ExifAttribute.createULong(0L, this.I));
        }
        if (getAttribute("ImageLength") == null) {
            this.G[0].put("ImageLength", ExifAttribute.createULong(0L, this.I));
        }
        if (getAttribute("Orientation") == null) {
            this.G[0].put("Orientation", ExifAttribute.createULong(0L, this.I));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.G[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0L, this.I));
        }
    }

    private void a(int i2, int i3) throws IOException {
        if (this.G[i2].isEmpty() || this.G[i3].isEmpty()) {
            return;
        }
        ExifAttribute exifAttribute = this.G[i2].get("ImageLength");
        ExifAttribute exifAttribute2 = this.G[i2].get("ImageWidth");
        ExifAttribute exifAttribute3 = this.G[i3].get("ImageLength");
        ExifAttribute exifAttribute4 = this.G[i3].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.I);
        int intValue2 = exifAttribute2.getIntValue(this.I);
        int intValue3 = exifAttribute3.getIntValue(this.I);
        int intValue4 = exifAttribute4.getIntValue(this.I);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap<String, ExifAttribute>[] hashMapArr = this.G;
        HashMap<String, ExifAttribute> hashMap = hashMapArr[i2];
        hashMapArr[i2] = hashMapArr[i3];
        hashMapArr[i3] = hashMap;
    }

    private void a(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        a(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        b(byteOrderedDataInputStream, 0);
        d(byteOrderedDataInputStream, 0);
        d(byteOrderedDataInputStream, 5);
        d(byteOrderedDataInputStream, 4);
        b((InputStream) byteOrderedDataInputStream);
        if (this.F != 8 || (exifAttribute = this.G[1].get(TAG_MAKER_NOTE)) == null) {
            return;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
        byteOrderedDataInputStream2.setByteOrder(this.I);
        byteOrderedDataInputStream2.seek(6L);
        b(byteOrderedDataInputStream2, 9);
        ExifAttribute exifAttribute2 = this.G[9].get(TAG_COLOR_SPACE);
        if (exifAttribute2 != null) {
            this.G[1].put(TAG_COLOR_SPACE, exifAttribute2);
        }
    }

    private void a(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ByteOrder e2 = e(byteOrderedDataInputStream);
        this.I = e2;
        byteOrderedDataInputStream.setByteOrder(e2);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i3 = this.F;
        if (i3 != 7 && i3 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt < 8 || readInt >= i2) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i4 = readInt - 8;
        if (i4 <= 0 || byteOrderedDataInputStream.skipBytes(i4) == i4) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.a(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private void a(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        int i2;
        int i3;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.I);
        int min = Math.min(exifAttribute2.getIntValue(this.I), byteOrderedDataInputStream.available() - intValue);
        int i4 = this.F;
        if (i4 != 4 && i4 != 9 && i4 != 10) {
            i3 = intValue;
            if (i4 == 7) {
                i2 = this.P;
            }
            if (i3 > 0 || min <= 0) {
            }
            this.J = true;
            this.K = i3;
            this.L = min;
            if (this.D == null && this.E == null) {
                byte[] bArr = new byte[min];
                byteOrderedDataInputStream.seek(i3);
                byteOrderedDataInputStream.readFully(bArr);
                this.M = bArr;
                return;
            }
            return;
        }
        i2 = this.O;
        i3 = intValue + i2;
        if (i3 > 0) {
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    private void a(InputStream inputStream) throws IOException {
        int i2 = 0;
        while (true) {
            try {
                try {
                    int i3 = i2;
                    if (i3 >= e.length) {
                        break;
                    }
                    this.G[i3] = new HashMap<>();
                    i2 = i3 + 1;
                } catch (IOException e2) {
                    this.T = false;
                }
            } finally {
                a();
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.F = a(bufferedInputStream);
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        switch (this.F) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                a(byteOrderedDataInputStream);
                break;
            case 4:
                a(byteOrderedDataInputStream, 0, 0);
                break;
            case 7:
                c(byteOrderedDataInputStream);
                break;
            case 9:
                b(byteOrderedDataInputStream);
                break;
            case 10:
                d(byteOrderedDataInputStream);
                break;
        }
        f(byteOrderedDataInputStream);
        this.T = true;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        int read;
        int read2;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-1);
        if (dataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-40);
        byteOrderedDataOutputStream.writeByte(-1);
        byteOrderedDataOutputStream.writeByte(-31);
        a(byteOrderedDataOutputStream, 6);
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte readByte = dataInputStream.readByte();
            if (readByte == -39 || readByte == -38) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                b(dataInputStream, byteOrderedDataOutputStream);
                return;
            } else if (readByte != -31) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                int i2 = readUnsignedShort - 2;
                if (i2 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i2 > 0 && (read = dataInputStream.read(bArr, 0, Math.min(i2, 4096))) >= 0) {
                    byteOrderedDataOutputStream.write(bArr, 0, read);
                    i2 -= read;
                }
            } else {
                int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                if (readUnsignedShort2 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (readUnsignedShort2 >= 6) {
                    if (dataInputStream.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, g)) {
                        int i3 = readUnsignedShort2 - 6;
                        if (dataInputStream.skipBytes(i3) != i3) {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                int i4 = readUnsignedShort2;
                if (readUnsignedShort2 >= 6) {
                    i4 = readUnsignedShort2 - 6;
                    byteOrderedDataOutputStream.write(bArr2);
                }
                while (i4 > 0 && (read2 = dataInputStream.read(bArr, 0, Math.min(i4, 4096))) >= 0) {
                    byteOrderedDataOutputStream.write(bArr, 0, read2);
                    i4 -= read2;
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    private void a(byte[] bArr, int i2) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        a(byteOrderedDataInputStream, bArr.length);
        b(byteOrderedDataInputStream, i2);
    }

    private boolean a(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.a(this.I);
            if (Arrays.equals(BITS_PER_SAMPLE_RGB, iArr)) {
                return true;
            }
            if (this.F != 3 || (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
                return false;
            }
            int intValue = exifAttribute.getIntValue(this.I);
            if (intValue == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) {
                return true;
            }
            return intValue == 6 && Arrays.equals(iArr, BITS_PER_SAMPLE_RGB);
        }
        return false;
    }

    private static boolean a(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            byte[] bArr2 = f2847a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    private static long[] a(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return jArr;
            }
            jArr[i3] = iArr[i3];
            i2 = i3 + 1;
        }
    }

    private static int b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private void b(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(byteOrderedDataInputStream, i2, 5);
        byteOrderedDataInputStream.seek(i3);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= readInt) {
                return;
            }
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == r.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.I);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.I);
                this.G[0].put("ImageLength", createUShort);
                this.G[0].put("ImageWidth", createUShort2);
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
            i4 = i5 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r7, int r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.b(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int):void");
    }

    private void b(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] a2 = a(exifAttribute.a(this.I));
        long[] a3 = a(exifAttribute2.a(this.I));
        if (a2 == null) {
            Log.w("ExifInterface", "stripOffsets should not be null.");
        } else if (a3 == null) {
            Log.w("ExifInterface", "stripByteCounts should not be null.");
        } else {
            long j2 = 0;
            int length = a3.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                j2 += a3[i3];
                i2 = i3 + 1;
            }
            int i4 = (int) j2;
            byte[] bArr = new byte[i4];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < a2.length; i7++) {
                int i8 = (int) a2[i7];
                int i9 = (int) a3[i7];
                int i10 = i8 - i5;
                if (i10 < 0) {
                    Log.d("ExifInterface", "Invalid strip offset value");
                }
                byteOrderedDataInputStream.seek(i10);
                byte[] bArr2 = new byte[i9];
                byteOrderedDataInputStream.read(bArr2);
                i5 = i5 + i10 + i9;
                System.arraycopy(bArr2, 0, bArr, i6, i9);
                i6 += i9;
            }
            this.J = true;
            this.M = bArr;
            this.L = i4;
        }
    }

    private void b(InputStream inputStream) throws IOException {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        ExifAttribute exifAttribute = this.G[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.G[1].get(TAG_PIXEL_Y_DIMENSION);
        if (exifAttribute != null && exifAttribute2 != null) {
            this.G[0].put("ImageWidth", exifAttribute);
            this.G[0].put("ImageLength", exifAttribute2);
        }
        if (this.G[4].isEmpty() && b(this.G[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.G;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (b(this.G[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void b(String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= e.length) {
                return;
            }
            this.G[i3].remove(str);
            i2 = i3 + 1;
        }
    }

    private boolean b(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.I) <= 512 && exifAttribute2.getIntValue(this.I) <= 512;
    }

    private boolean b(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bytes.length) {
                return true;
            }
            if (bArr[i3] != bytes[i3]) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    private static Pair<Integer, Integer> c(String str) {
        if (!str.contains(",")) {
            if (!str.contains("/")) {
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(str));
                    return (valueOf.longValue() < 0 || valueOf.longValue() > 65535) ? valueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                } catch (NumberFormatException e2) {
                    try {
                        Double.parseDouble(str);
                        return new Pair<>(12, -1);
                    } catch (NumberFormatException e3) {
                        return new Pair<>(2, -1);
                    }
                }
            }
            String[] split = str.split("/", -1);
            if (split.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split[0]);
                    long parseDouble2 = (long) Double.parseDouble(split[1]);
                    return (parseDouble < 0 || parseDouble2 < 0) ? new Pair<>(10, -1) : (parseDouble > 2147483647L || parseDouble2 > 2147483647L) ? new Pair<>(5, -1) : new Pair<>(10, 5);
                } catch (NumberFormatException e4) {
                }
            }
            return new Pair<>(2, -1);
        }
        String[] split2 = str.split(",", -1);
        Pair<Integer, Integer> c2 = c(split2[0]);
        Pair<Integer, Integer> pair = c2;
        if (c2.first.intValue() == 2) {
            return c2;
        }
        for (int i2 = 1; i2 < split2.length; i2++) {
            Pair<Integer, Integer> c3 = c(split2[i2]);
            int intValue = (c3.first.equals(pair.first) || c3.second.equals(pair.first)) ? pair.first.intValue() : -1;
            int intValue2 = (pair.second.intValue() == -1 || !(c3.first.equals(pair.second) || c3.second.equals(pair.second))) ? -1 : pair.second.intValue();
            if (intValue == -1 && intValue2 == -1) {
                return new Pair<>(2, -1);
            }
            if (intValue == -1) {
                pair = new Pair<>(Integer.valueOf(intValue2), -1);
            } else if (intValue2 == -1) {
                pair = new Pair<>(Integer.valueOf(intValue), -1);
            }
        }
        return pair;
    }

    private void c(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        a(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.G[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.I);
            byte[] bArr = new byte[j.length];
            byteOrderedDataInputStream2.readFully(bArr);
            byteOrderedDataInputStream2.seek(0L);
            byte[] bArr2 = new byte[k.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            if (Arrays.equals(bArr, j)) {
                byteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr2, k)) {
                byteOrderedDataInputStream2.seek(12L);
            }
            b(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.G[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.G[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.G[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.G[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.G[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.a(this.I);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                } else {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    int i4 = i2;
                    int i5 = i3;
                    if (i2 < i3) {
                        int i6 = i2 + i3;
                        i5 = i6 - i3;
                        i4 = i6 - i5;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i4, this.I);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i5, this.I);
                    this.G[0].put("ImageWidth", createUShort);
                    this.G[0].put("ImageLength", createUShort2);
                }
            }
        }
    }

    private void c(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = this.G[i2].get("ImageLength");
        ExifAttribute exifAttribute3 = this.G[i2].get("ImageWidth");
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.G[i2].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            a(byteOrderedDataInputStream, exifAttribute.getIntValue(this.I), i2);
        }
    }

    private boolean c(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder e2 = e(byteOrderedDataInputStream);
        this.I = e2;
        byteOrderedDataInputStream.setByteOrder(e2);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 20306 || readShort == 21330;
    }

    private void d(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        a(byteOrderedDataInputStream);
        if (this.G[0].get(TAG_RW2_JPG_FROM_RAW) != null) {
            a(byteOrderedDataInputStream, this.S, 5);
        }
        ExifAttribute exifAttribute = this.G[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute2 = this.G[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute == null || exifAttribute2 != null) {
            return;
        }
        this.G[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
    }

    private void d(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute createUShort;
        ExifAttribute createUShort2;
        ExifAttribute exifAttribute = this.G[i2].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute2 = this.G[i2].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute3 = this.G[i2].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute4 = this.G[i2].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute5 = this.G[i2].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute == null) {
            if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
                c(byteOrderedDataInputStream, i2);
                return;
            }
            int intValue = exifAttribute2.getIntValue(this.I);
            int intValue2 = exifAttribute4.getIntValue(this.I);
            int intValue3 = exifAttribute5.getIntValue(this.I);
            int intValue4 = exifAttribute3.getIntValue(this.I);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifAttribute createUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.I);
            ExifAttribute createUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.I);
            this.G[i2].put("ImageLength", createUShort3);
            this.G[i2].put("ImageWidth", createUShort4);
            return;
        }
        if (exifAttribute.format == 5) {
            Rational[] rationalArr = (Rational[]) exifAttribute.a(this.I);
            if (rationalArr == null || rationalArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                return;
            }
            createUShort = ExifAttribute.createURational(rationalArr[0], this.I);
            createUShort2 = ExifAttribute.createURational(rationalArr[1], this.I);
        } else {
            int[] iArr = (int[]) exifAttribute.a(this.I);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            createUShort = ExifAttribute.createUShort(iArr[0], this.I);
            createUShort2 = ExifAttribute.createUShort(iArr[1], this.I);
        }
        this.G[i2].put("ImageWidth", createUShort);
        this.G[i2].put("ImageLength", createUShort2);
    }

    private boolean d(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder e2 = e(byteOrderedDataInputStream);
        this.I = e2;
        byteOrderedDataInputStream.setByteOrder(e2);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 85;
    }

    private ByteOrder e(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void f(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.G[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute == null) {
            this.N = 6;
            a(byteOrderedDataInputStream, hashMap);
            return;
        }
        int intValue = exifAttribute.getIntValue(this.I);
        this.N = intValue;
        if (intValue != 1) {
            if (intValue == 6) {
                a(byteOrderedDataInputStream, hashMap);
                return;
            } else if (intValue != 7) {
                return;
            }
        }
        if (a((HashMap) hashMap)) {
            b(byteOrderedDataInputStream, hashMap);
        }
    }

    public void flipHorizontally() {
        int i2 = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i2 = 2;
                break;
            case 2:
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 8;
                break;
            case 8:
                i2 = 7;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute("Orientation", Integer.toString(i2));
    }

    public void flipVertically() {
        int i2 = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 7;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute("Orientation", Integer.toString(i2));
    }

    public double getAltitude(double d2) {
        double attributeDouble = getAttributeDouble("GPSAltitude", -1.0d);
        int i2 = -1;
        int attributeInt = getAttributeInt("GPSAltitudeRef", -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d2;
        }
        if (attributeInt != 1) {
            i2 = 1;
        }
        return attributeDouble * i2;
    }

    public String getAttribute(String str) {
        ExifAttribute a2 = a(str);
        if (a2 != null) {
            if (B.contains(str)) {
                if (!str.equals("GPSTimeStamp")) {
                    try {
                        return Double.toString(a2.getDoubleValue(this.I));
                    } catch (NumberFormatException e2) {
                        return null;
                    }
                } else if (a2.format != 5 && a2.format != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + a2.format);
                    return null;
                } else {
                    Rational[] rationalArr = (Rational[]) a2.a(this.I);
                    if (rationalArr == null || rationalArr.length != 3) {
                        Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                        return null;
                    }
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator))));
                }
            }
            return a2.getStringValue(this.I);
        }
        return null;
    }

    public double getAttributeDouble(String str, double d2) {
        ExifAttribute a2 = a(str);
        if (a2 == null) {
            return d2;
        }
        try {
            return a2.getDoubleValue(this.I);
        } catch (NumberFormatException e2) {
            return d2;
        }
    }

    public int getAttributeInt(String str, int i2) {
        ExifAttribute a2 = a(str);
        if (a2 == null) {
            return i2;
        }
        try {
            return a2.getIntValue(this.I);
        } catch (NumberFormatException e2) {
            return i2;
        }
    }

    public long getDateTime() {
        String attribute = getAttribute("DateTime");
        if (attribute == null || !U.matcher(attribute).matches()) {
            return -1L;
        }
        try {
            Date parse = l.parse(attribute, new ParsePosition(0));
            if (parse == null) {
                return -1L;
            }
            long time = parse.getTime();
            String attribute2 = getAttribute(TAG_SUBSEC_TIME);
            long j2 = time;
            if (attribute2 != null) {
                try {
                    long parseLong = Long.parseLong(attribute2);
                    while (parseLong > 1000) {
                        parseLong /= 10;
                    }
                    j2 = time + parseLong;
                } catch (NumberFormatException e2) {
                    return time;
                }
            }
            return j2;
        } catch (IllegalArgumentException e3) {
            return -1L;
        }
    }

    public long getGpsDateTime() {
        String attribute = getAttribute("GPSDateStamp");
        String attribute2 = getAttribute("GPSTimeStamp");
        if (attribute == null || attribute2 == null) {
            return -1L;
        }
        if (U.matcher(attribute).matches() || U.matcher(attribute2).matches()) {
            try {
                Date parse = l.parse(attribute + ' ' + attribute2, new ParsePosition(0));
                if (parse == null) {
                    return -1L;
                }
                return parse.getTime();
            } catch (IllegalArgumentException e2) {
                return -1L;
            }
        }
        return -1L;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public double[] getLatLong() {
        String attribute = getAttribute("GPSLatitude");
        String attribute2 = getAttribute("GPSLatitudeRef");
        String attribute3 = getAttribute("GPSLongitude");
        String attribute4 = getAttribute("GPSLongitudeRef");
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{a(attribute, attribute2), a(attribute3, attribute4)};
        } catch (IllegalArgumentException e2) {
            Log.w("ExifInterface", "Latitude/longitude values are not parseable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            return null;
        }
    }

    public int getRotationDegrees() {
        switch (getAttributeInt("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public byte[] getThumbnail() {
        int i2 = this.N;
        if (i2 == 6 || i2 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    public Bitmap getThumbnailBitmap() {
        if (this.J) {
            if (this.M == null) {
                this.M = getThumbnailBytes();
            }
            int i2 = this.N;
            if (i2 == 6 || i2 == 7) {
                return BitmapFactory.decodeByteArray(this.M, 0, this.L);
            }
            if (i2 == 1) {
                int length = this.M.length / 3;
                int[] iArr = new int[length];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        break;
                    }
                    byte[] bArr = this.M;
                    int i5 = i4 * 3;
                    iArr[i4] = (bArr[i5] << 16) + 0 + (bArr[i5 + 1] << 8) + bArr[i5 + 2];
                    i3 = i4 + 1;
                }
                ExifAttribute exifAttribute = this.G[4].get("ImageLength");
                ExifAttribute exifAttribute2 = this.G[4].get("ImageWidth");
                if (exifAttribute == null || exifAttribute2 == null) {
                    return null;
                }
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.I), exifAttribute.getIntValue(this.I), Bitmap.Config.ARGB_8888);
            }
            return null;
        }
        return null;
    }

    public byte[] getThumbnailBytes() {
        InputStream inputStream;
        AssetManager.AssetInputStream fileInputStream;
        if (!this.J) {
            return null;
        }
        byte[] bArr = this.M;
        try {
            if (bArr != null) {
                return bArr;
            }
            try {
                if (this.E != null) {
                    fileInputStream = this.E;
                    inputStream = fileInputStream;
                    try {
                        if (!fileInputStream.markSupported()) {
                            Log.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");
                            a((Closeable) fileInputStream);
                            return null;
                        }
                        fileInputStream.reset();
                    } catch (IOException e2) {
                        e = e2;
                        Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
                        a((Closeable) inputStream);
                        return null;
                    }
                } else {
                    fileInputStream = this.D != null ? new FileInputStream(this.D) : null;
                }
                if (fileInputStream == null) {
                    FileInputStream fileInputStream2 = fileInputStream;
                    throw new FileNotFoundException();
                }
                FileInputStream fileInputStream3 = fileInputStream;
                if (fileInputStream.skip(this.K) != this.K) {
                    FileInputStream fileInputStream4 = fileInputStream;
                    throw new IOException("Corrupted image");
                }
                byte[] bArr2 = new byte[this.L];
                FileInputStream fileInputStream5 = fileInputStream;
                if (fileInputStream.read(bArr2) == this.L) {
                    FileInputStream fileInputStream6 = fileInputStream;
                    this.M = bArr2;
                    a((Closeable) fileInputStream);
                    return bArr2;
                }
                throw new IOException("Corrupted image");
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                a((Closeable) null);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public long[] getThumbnailRange() {
        if (this.J) {
            return new long[]{this.K, this.L};
        }
        return null;
    }

    public boolean hasThumbnail() {
        return this.J;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt("Orientation", 1);
        boolean z2 = true;
        if (attributeInt != 2) {
            z2 = true;
            if (attributeInt != 7) {
                z2 = true;
                if (attributeInt != 4) {
                    z2 = true;
                    if (attributeInt != 5) {
                        z2 = false;
                    }
                }
            }
        }
        return z2;
    }

    public boolean isThumbnailCompressed() {
        int i2 = this.N;
        return i2 == 6 || i2 == 7;
    }

    public void resetOrientation() {
        setAttribute("Orientation", Integer.toString(1));
    }

    public void rotate(int i2) {
        int i3;
        if (i2 % 90 != 0) {
            throw new IllegalArgumentException("degree should be a multiple of 90");
        }
        int attributeInt = getAttributeInt("Orientation", 1);
        if (h.contains(Integer.valueOf(attributeInt))) {
            int indexOf = (h.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
            int i4 = 0;
            if (indexOf < 0) {
                i4 = 4;
            }
            i3 = h.get(indexOf + i4).intValue();
        } else {
            i3 = 0;
            if (i.contains(Integer.valueOf(attributeInt))) {
                int indexOf2 = (i.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
                int i5 = 0;
                if (indexOf2 < 0) {
                    i5 = 4;
                }
                i3 = i.get(indexOf2 + i5).intValue();
            }
        }
        setAttribute("Orientation", Integer.toString(i3));
    }

    public void saveAttributes() throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (!this.T || this.F != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        }
        if (this.D == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        this.M = getThumbnail();
        File file = new File(this.D + ".tmp");
        if (!new File(this.D).renameTo(file)) {
            throw new IOException("Could not rename to " + file.getAbsolutePath());
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(this.D);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                a(fileInputStream, fileOutputStream);
                a((Closeable) fileInputStream);
                a((Closeable) fileOutputStream);
                file.delete();
                this.M = null;
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) fileInputStream);
                a((Closeable) fileOutputStream);
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public void setAltitude(double d2) {
        String str = d2 >= 0.0d ? "0" : "1";
        setAttribute("GPSAltitude", new Rational(Math.abs(d2)).toString());
        setAttribute("GPSAltitudeRef", str);
    }

    public void setAttribute(String str, String str2) {
        String str3;
        int i2;
        String str4;
        String str5;
        Matcher matcher;
        String str6 = "ISOSpeedRatings".equals(str) ? TAG_PHOTOGRAPHIC_SENSITIVITY : str;
        String str7 = "ExifInterface";
        String str8 = str2;
        if (str2 != null) {
            str8 = str2;
            if (B.contains(str6)) {
                if (str6.equals("GPSTimeStamp")) {
                    if (!V.matcher(str2).find()) {
                        Log.w("ExifInterface", "Invalid value for " + str6 + " : " + str2);
                        return;
                    }
                    str8 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str8 = new Rational(Double.parseDouble(str2)).toString();
                    } catch (NumberFormatException e2) {
                        Log.w("ExifInterface", "Invalid value for " + str6 + " : " + str2);
                        return;
                    }
                }
            }
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= e.length) {
                return;
            }
            if (i4 != 4 || this.J) {
                ExifTag exifTag = A[i4].get(str6);
                str3 = str7;
                if (exifTag != null) {
                    if (str8 != null) {
                        Pair<Integer, Integer> c2 = c(str8);
                        if (exifTag.primaryFormat == c2.first.intValue() || exifTag.primaryFormat == c2.second.intValue()) {
                            i2 = exifTag.primaryFormat;
                        } else if (exifTag.secondaryFormat != -1 && (exifTag.secondaryFormat == c2.first.intValue() || exifTag.secondaryFormat == c2.second.intValue())) {
                            i2 = exifTag.secondaryFormat;
                        } else if (exifTag.primaryFormat == 1 || exifTag.primaryFormat == 7 || exifTag.primaryFormat == 2) {
                            i2 = exifTag.primaryFormat;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Given tag (");
                            sb.append(str6);
                            sb.append(") value didn't match with one of expected ");
                            sb.append("formats: ");
                            sb.append(b[exifTag.primaryFormat]);
                            if (exifTag.secondaryFormat == -1) {
                                str4 = "";
                            } else {
                                str4 = ", " + b[exifTag.secondaryFormat];
                            }
                            sb.append(str4);
                            sb.append(" (guess: ");
                            sb.append(b[c2.first.intValue()]);
                            if (c2.second.intValue() == -1) {
                                str5 = "";
                            } else {
                                str5 = ", " + b[c2.second.intValue()];
                            }
                            sb.append(str5);
                            sb.append(")");
                            Log.w(str7, sb.toString());
                            str3 = str7;
                        }
                        switch (i2) {
                            case 1:
                                this.G[i4].put(str6, ExifAttribute.createByte(str8));
                                continue;
                                i3 = i4 + 1;
                            case 2:
                            case 7:
                                this.G[i4].put(str6, ExifAttribute.createString(str8));
                                continue;
                                i3 = i4 + 1;
                            case 3:
                                String[] split = str8.split(",", -1);
                                int[] iArr = new int[split.length];
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 < split.length) {
                                        iArr[i6] = Integer.parseInt(split[i6]);
                                        i5 = i6 + 1;
                                    } else {
                                        this.G[i4].put(str6, ExifAttribute.createUShort(iArr, this.I));
                                        continue;
                                        i3 = i4 + 1;
                                    }
                                }
                            case 4:
                                String[] split2 = str8.split(",", -1);
                                long[] jArr = new long[split2.length];
                                int i7 = 0;
                                while (true) {
                                    int i8 = i7;
                                    if (i8 < split2.length) {
                                        jArr[i8] = Long.parseLong(split2[i8]);
                                        i7 = i8 + 1;
                                    } else {
                                        this.G[i4].put(str6, ExifAttribute.createULong(jArr, this.I));
                                        continue;
                                        i3 = i4 + 1;
                                    }
                                }
                            case 5:
                                String[] split3 = str8.split(",", -1);
                                Rational[] rationalArr = new Rational[split3.length];
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9;
                                    if (i10 < split3.length) {
                                        String[] split4 = split3[i10].split("/", -1);
                                        rationalArr[i10] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                        i9 = i10 + 1;
                                    } else {
                                        this.G[i4].put(str6, ExifAttribute.createURational(rationalArr, this.I));
                                        continue;
                                        i3 = i4 + 1;
                                    }
                                }
                            case 6:
                            case 8:
                            case 11:
                            default:
                                Log.w(str7, "Data format isn't one of expected formats: " + i2);
                                continue;
                                i3 = i4 + 1;
                            case 9:
                                String[] split5 = str8.split(",", -1);
                                int[] iArr2 = new int[split5.length];
                                int i11 = 0;
                                while (true) {
                                    int i12 = i11;
                                    if (i12 >= split5.length) {
                                        this.G[i4].put(str6, ExifAttribute.createSLong(iArr2, this.I));
                                        str3 = str7;
                                        break;
                                    } else {
                                        iArr2[i12] = Integer.parseInt(split5[i12]);
                                        i11 = i12 + 1;
                                    }
                                }
                            case 10:
                                String[] split6 = str8.split(",", -1);
                                Rational[] rationalArr2 = new Rational[split6.length];
                                int i13 = 0;
                                while (true) {
                                    int i14 = i13;
                                    if (i14 >= split6.length) {
                                        this.G[i4].put(str6, ExifAttribute.createSRational(rationalArr2, this.I));
                                        str3 = str7;
                                        break;
                                    } else {
                                        String[] split7 = split6[i14].split("/", -1);
                                        rationalArr2[i14] = new Rational((long) Double.parseDouble(split7[0]), (long) Double.parseDouble(split7[1]));
                                        i13 = i14 + 1;
                                    }
                                }
                            case 12:
                                String[] split8 = str8.split(",", -1);
                                double[] dArr = new double[split8.length];
                                int i15 = 0;
                                while (true) {
                                    int i16 = i15;
                                    if (i16 >= split8.length) {
                                        this.G[i4].put(str6, ExifAttribute.createDouble(dArr, this.I));
                                        str3 = str7;
                                        break;
                                    } else {
                                        dArr[i16] = Double.parseDouble(split8[i16]);
                                        i15 = i16 + 1;
                                    }
                                }
                        }
                    } else {
                        this.G[i4].remove(str6);
                        str3 = str7;
                    }
                }
            } else {
                str3 = str7;
            }
            str7 = str3;
            i3 = i4 + 1;
        }
    }

    public void setDateTime(long j2) {
        setAttribute("DateTime", l.format(new Date(j2)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(j2 % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location == null) {
            return;
        }
        setAttribute("GPSProcessingMethod", location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1L))) / 1000.0f).toString());
        String[] split = l.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute("GPSDateStamp", split[0]);
        setAttribute("GPSTimeStamp", split[1]);
    }

    public void setLatLong(double d2, double d3) {
        if (d2 < -90.0d || d2 > 90.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Latitude value " + d2 + " is not valid.");
        } else if (d3 < -180.0d || d3 > 180.0d || Double.isNaN(d3)) {
            throw new IllegalArgumentException("Longitude value " + d3 + " is not valid.");
        } else {
            setAttribute("GPSLatitudeRef", d2 >= 0.0d ? "N" : LATITUDE_SOUTH);
            setAttribute("GPSLatitude", a(Math.abs(d2)));
            setAttribute("GPSLongitudeRef", d3 >= 0.0d ? LONGITUDE_EAST : "W");
            setAttribute("GPSLongitude", a(Math.abs(d3)));
        }
    }
}
