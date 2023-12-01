package com.android.org.conscrypt;

import com.youzan.androidsdk.tool.AppSigning;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.net.ssl.SSLException;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/NativeCrypto.class */
public final class NativeCrypto {
    public static final String[] DEFAULT_PROTOCOLS = null;
    static final String[] DEFAULT_PSK_CIPHER_SUITES = null;
    static final String[] DEFAULT_X509_CIPHER_SUITES = null;
    public static final int EC_CURVE_GF2M = 2;
    public static final int EC_CURVE_GFP = 1;
    public static final int EVP_PKEY_CMAC = 894;
    public static final int EVP_PKEY_DH = 28;
    public static final int EVP_PKEY_DSA = 116;
    public static final int EVP_PKEY_EC = 408;
    public static final int EVP_PKEY_HMAC = 855;
    public static final int EVP_PKEY_RSA = 6;
    public static final int EXFLAG_CA = 16;
    public static final int EXFLAG_CRITICAL = 512;
    public static final int EXTENSION_TYPE_CRITICAL = 1;
    public static final int EXTENSION_TYPE_NON_CRITICAL = 0;
    public static final int GN_STACK_ISSUER_ALT_NAME = 2;
    public static final int GN_STACK_SUBJECT_ALT_NAME = 1;
    public static final int OPENSSL_EC_NAMED_CURVE = 1;
    public static final Map<String, String> OPENSSL_TO_STANDARD_CIPHER_SUITES = null;
    public static final int PKCS7_CERTS = 1;
    public static final int PKCS7_CRLS = 2;
    public static final int POINT_CONVERSION_COMPRESSED = 2;
    public static final int POINT_CONVERSION_HYBRID = 4;
    public static final int POINT_CONVERSION_UNCOMPRESSED = 4;
    public static final int RAND_SEED_LENGTH_IN_BYTES = 1024;
    public static final int RSA_NO_PADDING = 3;
    public static final int RSA_PKCS1_PADDING = 1;
    public static final int SSL3_RT_HEADER_LENGTH = 5;
    public static final int SSL3_RT_MAX_COMPRESSED_LENGTH = 16384;
    public static final int SSL3_RT_MAX_ENCRYPTED_LENGTH = 16704;
    public static final int SSL3_RT_MAX_ENCRYPTED_OVERHEAD = 320;
    public static final int SSL3_RT_MAX_MD_SIZE = 64;
    public static final int SSL3_RT_MAX_PACKET_SIZE = 16709;
    public static final int SSL3_RT_MAX_PLAIN_LENGTH = 16384;
    public static final int SSL3_RT_SEND_MAX_ENCRYPTED_OVERHEAD = 80;
    public static final int SSL_CB_ACCEPT_EXIT = 8194;
    public static final int SSL_CB_ACCEPT_LOOP = 8193;
    public static final int SSL_CB_ALERT = 16384;
    public static final int SSL_CB_CONNECT_EXIT = 4098;
    public static final int SSL_CB_CONNECT_LOOP = 4097;
    public static final int SSL_CB_EXIT = 2;
    public static final int SSL_CB_HANDSHAKE_DONE = 32;
    public static final int SSL_CB_HANDSHAKE_START = 16;
    public static final int SSL_CB_LOOP = 1;
    public static final int SSL_CB_READ = 4;
    public static final int SSL_CB_READ_ALERT = 16388;
    public static final int SSL_CB_WRITE = 8;
    public static final int SSL_CB_WRITE_ALERT = 16392;
    public static final long SSL_MODE_CBC_RECORD_SPLITTING = 256;
    public static final long SSL_MODE_HANDSHAKE_CUTTHROUGH = 512;
    public static final long SSL_MODE_SEND_FALLBACK_SCSV = 128;
    public static final long SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION = 65536;
    public static final long SSL_OP_NO_SSLv3 = 33554432;
    public static final long SSL_OP_NO_TICKET = 16384;
    public static final long SSL_OP_NO_TLSv1 = 67108864;
    public static final long SSL_OP_NO_TLSv1_1 = 268435456;
    public static final long SSL_OP_NO_TLSv1_2 = 134217728;
    public static final long SSL_OP_TLSEXT_PADDING = 16;
    public static final int SSL_RECEIVED_SHUTDOWN = 2;
    public static final int SSL_RT_MAX_CIPHER_BLOCK_SIZE = 16;
    public static final int SSL_SENT_SHUTDOWN = 1;
    public static final int SSL_ST_ACCEPT = 8192;
    public static final int SSL_ST_BEFORE = 16384;
    public static final int SSL_ST_CONNECT = 4096;
    public static final int SSL_ST_INIT = 12288;
    public static final int SSL_ST_MASK = 4095;
    public static final int SSL_ST_OK = 3;
    public static final int SSL_ST_RENEGOTIATE = 12292;
    public static final int SSL_VERIFY_FAIL_IF_NO_PEER_CERT = 2;
    public static final int SSL_VERIFY_NONE = 0;
    public static final int SSL_VERIFY_PEER = 1;
    public static final int SSL_aDH = 8;
    public static final int SSL_aDSS = 2;
    public static final int SSL_aECDH = 16;
    public static final int SSL_aECDSA = 64;
    public static final int SSL_aGOST01 = 512;
    public static final int SSL_aGOST94 = 256;
    public static final int SSL_aKRB5 = 32;
    public static final int SSL_aNULL = 4;
    public static final int SSL_aPSK = 128;
    public static final int SSL_aRSA = 1;
    public static final int SSL_kDHd = 4;
    public static final int SSL_kDHr = 2;
    public static final int SSL_kECDHe = 64;
    public static final int SSL_kECDHr = 32;
    public static final int SSL_kEDH = 8;
    public static final int SSL_kEECDH = 128;
    public static final int SSL_kGOST = 512;
    public static final int SSL_kKRB5 = 16;
    public static final int SSL_kPSK = 256;
    public static final int SSL_kRSA = 1;
    public static final int SSL_kSRP = 1024;
    public static final Map<String, String> STANDARD_TO_OPENSSL_CIPHER_SUITES = null;
    private static final String[] SUPPORTED_CIPHER_SUITES = null;
    private static final String SUPPORTED_PROTOCOL_SSLV3 = "SSLv3";
    private static final String SUPPORTED_PROTOCOL_TLSV1 = "TLSv1";
    private static final String SUPPORTED_PROTOCOL_TLSV1_1 = "TLSv1.1";
    private static final String SUPPORTED_PROTOCOL_TLSV1_2 = "TLSv1.2";
    public static final byte TLS_CT_DSS_FIXED_DH = 4;
    public static final byte TLS_CT_DSS_SIGN = 2;
    public static final byte TLS_CT_ECDSA_FIXED_ECDH = 66;
    public static final byte TLS_CT_ECDSA_SIGN = 64;
    public static final byte TLS_CT_RSA_FIXED_DH = 3;
    public static final byte TLS_CT_RSA_FIXED_ECDH = 65;
    public static final byte TLS_CT_RSA_SIGN = 1;
    public static final String TLS_EMPTY_RENEGOTIATION_INFO_SCSV = "TLS_EMPTY_RENEGOTIATION_INFO_SCSV";
    public static final String TLS_FALLBACK_SCSV = "TLS_FALLBACK_SCSV";

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/NativeCrypto$SSLHandshakeCallbacks.class */
    public interface SSLHandshakeCallbacks {
        void clientCertificateRequested(byte[] bArr, byte[][] bArr2) throws CertificateEncodingException, SSLException;

        int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2);

        void onSSLStateChange(long j, int i, int i2);

        int serverPSKKeyRequested(String str, String str2, byte[] bArr);

        void verifyCertificateChain(long j, long[] jArr, String str) throws CertificateException;
    }

    static {
        throw new VerifyError("bad dex opcode");
    }

    public static native void ASN1_TIME_to_Calendar(long j, Calendar calendar);

    public static native byte[] ASN1_seq_pack_X509(long[] jArr);

    public static native long[] ASN1_seq_unpack_X509_bio(long j);

    public static native void BIO_free_all(long j);

    public static native int BIO_read(long j, byte[] bArr);

    public static native void BIO_write(long j, byte[] bArr, int i, int i2) throws IOException;

    public static native void DH_generate_key(long j);

    public static native long DH_generate_parameters_ex(int i, long j);

    public static native long DSA_generate_key(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static native int ECDH_compute_key(byte[] bArr, int i, long j, long j2);

    public static native void EC_GROUP_clear_free(long j);

    public static native boolean EC_GROUP_cmp(long j, long j2);

    public static native long EC_GROUP_dup(long j);

    public static native byte[] EC_GROUP_get_cofactor(long j);

    public static native byte[][] EC_GROUP_get_curve(long j);

    public static native String EC_GROUP_get_curve_name(long j);

    public static native int EC_GROUP_get_degree(long j);

    public static native long EC_GROUP_get_generator(long j);

    public static native byte[] EC_GROUP_get_order(long j);

    public static native long EC_GROUP_new_by_curve_name(String str);

    public static native long EC_GROUP_new_curve(int i, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native void EC_GROUP_set_asn1_flag(long j, int i);

    public static native void EC_GROUP_set_generator(long j, long j2, byte[] bArr, byte[] bArr2);

    public static native void EC_GROUP_set_point_conversion_form(long j, int i);

    public static native long EC_KEY_generate_key(long j);

    public static native long EC_KEY_get0_group(long j);

    public static native byte[] EC_KEY_get_private_key(long j);

    public static native long EC_KEY_get_public_key(long j);

    public static native void EC_KEY_set_nonce_from_hash(long j, boolean z);

    public static native void EC_POINT_clear_free(long j);

    public static native boolean EC_POINT_cmp(long j, long j2, long j3);

    public static native byte[][] EC_POINT_get_affine_coordinates(long j, long j2);

    public static native long EC_POINT_new(long j);

    public static native void EC_POINT_set_affine_coordinates(long j, long j2, byte[] bArr, byte[] bArr2);

    public static native int ENGINE_add(long j);

    public static native long ENGINE_by_id(String str);

    public static native int ENGINE_ctrl_cmd_string(long j, String str, String str2, int i);

    public static native int ENGINE_finish(long j);

    public static native int ENGINE_free(long j);

    public static native String ENGINE_get_id(long j);

    public static native int ENGINE_init(long j);

    public static native void ENGINE_load_dynamic();

    public static native long ENGINE_load_private_key(long j, String str);

    public static native long ERR_peek_last_error();

    public static native int EVP_CIPHER_CTX_block_size(long j);

    public static native void EVP_CIPHER_CTX_free(long j);

    public static native long EVP_CIPHER_CTX_new();

    public static native void EVP_CIPHER_CTX_set_key_length(long j, int i);

    public static native void EVP_CIPHER_CTX_set_padding(long j, boolean z);

    public static native int EVP_CIPHER_iv_length(long j);

    public static native int EVP_CipherFinal_ex(long j, byte[] bArr, int i) throws BadPaddingException, IllegalBlockSizeException;

    public static native void EVP_CipherInit_ex(long j, long j2, byte[] bArr, byte[] bArr2, boolean z);

    public static native int EVP_CipherUpdate(long j, byte[] bArr, int i, byte[] bArr2, int i2, int i3);

    public static native int EVP_DigestFinal(OpenSSLDigestContext openSSLDigestContext, byte[] bArr, int i);

    public static native int EVP_DigestInit(OpenSSLDigestContext openSSLDigestContext, long j);

    public static native byte[] EVP_DigestSignFinal(OpenSSLDigestContext openSSLDigestContext);

    public static native void EVP_DigestSignInit(OpenSSLDigestContext openSSLDigestContext, long j, long j2);

    public static native void EVP_DigestSignUpdate(OpenSSLDigestContext openSSLDigestContext, byte[] bArr);

    public static native void EVP_DigestUpdate(OpenSSLDigestContext openSSLDigestContext, byte[] bArr, int i, int i2);

    public static native int EVP_MD_CTX_copy(OpenSSLDigestContext openSSLDigestContext, OpenSSLDigestContext openSSLDigestContext2);

    public static native long EVP_MD_CTX_create();

    public static native void EVP_MD_CTX_destroy(long j);

    public static native void EVP_MD_CTX_init(OpenSSLDigestContext openSSLDigestContext);

    public static native int EVP_MD_block_size(long j);

    public static native int EVP_MD_size(long j);

    public static native int EVP_PKEY_cmp(long j, long j2);

    public static native void EVP_PKEY_free(long j);

    public static native long EVP_PKEY_new_DH(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static native long EVP_PKEY_new_DSA(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static native long EVP_PKEY_new_EC_KEY(long j, long j2, byte[] bArr);

    public static native long EVP_PKEY_new_RSA(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8);

    public static native long EVP_PKEY_new_mac_key(int i, byte[] bArr);

    public static native String EVP_PKEY_print_private(long j);

    public static native String EVP_PKEY_print_public(long j);

    public static native int EVP_PKEY_size(long j);

    public static native int EVP_PKEY_type(long j);

    public static native int EVP_SignFinal(OpenSSLDigestContext openSSLDigestContext, byte[] bArr, int i, long j);

    public static native int EVP_SignInit(OpenSSLDigestContext openSSLDigestContext, long j);

    public static native void EVP_SignUpdate(OpenSSLDigestContext openSSLDigestContext, byte[] bArr, int i, int i2);

    public static native int EVP_VerifyFinal(OpenSSLDigestContext openSSLDigestContext, byte[] bArr, int i, int i2, long j);

    public static native int EVP_VerifyInit(OpenSSLDigestContext openSSLDigestContext, long j);

    public static native void EVP_VerifyUpdate(OpenSSLDigestContext openSSLDigestContext, byte[] bArr, int i, int i2);

    public static native long EVP_get_cipherbyname(String str);

    public static native long EVP_get_digestbyname(String str);

    public static native int OBJ_txt2nid(String str);

    public static native String OBJ_txt2nid_longName(String str);

    public static native String OBJ_txt2nid_oid(String str);

    public static native long[] PEM_read_bio_PKCS7(long j, int i);

    public static native long PEM_read_bio_X509(long j);

    public static native long PEM_read_bio_X509_CRL(long j);

    public static native void RAND_bytes(byte[] bArr);

    public static native int RAND_load_file(String str, long j);

    public static native void RAND_seed(byte[] bArr);

    public static native long RSA_generate_key_ex(int i, byte[] bArr);

    public static native int RSA_private_decrypt(int i, byte[] bArr, byte[] bArr2, long j, int i2) throws BadPaddingException, SignatureException;

    public static native int RSA_private_encrypt(int i, byte[] bArr, byte[] bArr2, long j, int i2);

    public static native int RSA_public_decrypt(int i, byte[] bArr, byte[] bArr2, long j, int i2) throws BadPaddingException, SignatureException;

    public static native int RSA_public_encrypt(int i, byte[] bArr, byte[] bArr2, long j, int i2);

    public static native int RSA_size(long j);

    public static native void SSL_CTX_disable_npn(long j);

    public static native void SSL_CTX_enable_npn(long j);

    public static native void SSL_CTX_free(long j);

    public static native long SSL_CTX_new();

    public static native void SSL_CTX_set_session_id_context(long j, byte[] bArr);

    public static native String SSL_SESSION_cipher(long j);

    public static native void SSL_SESSION_free(long j);

    public static native long SSL_SESSION_get_time(long j);

    public static native String SSL_SESSION_get_version(long j);

    public static native byte[] SSL_SESSION_session_id(long j);

    public static native void SSL_check_private_key(long j) throws SSLException;

    public static native long SSL_clear_mode(long j, long j2);

    public static native long SSL_clear_options(long j, long j2);

    public static native long SSL_do_handshake(long j, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks, int i, boolean z, byte[] bArr, byte[] bArr2) throws SSLException, SocketTimeoutException, CertificateException;

    public static native long SSL_do_handshake_bio(long j, long j2, long j3, SSLHandshakeCallbacks sSLHandshakeCallbacks, boolean z, byte[] bArr, byte[] bArr2) throws SSLException, SocketTimeoutException, CertificateException;

    public static native void SSL_enable_tls_channel_id(long j) throws SSLException;

    public static native void SSL_free(long j);

    public static native byte[] SSL_get0_alpn_selected(long j);

    public static native long[] SSL_get_certificate(long j);

    public static native long[] SSL_get_ciphers(long j);

    public static native long SSL_get_mode(long j);

    public static native byte[] SSL_get_npn_negotiated_protocol(long j);

    public static native long SSL_get_options(long j);

    public static native long[] SSL_get_peer_cert_chain(long j);

    public static native String SSL_get_servername(long j);

    public static native int SSL_get_shutdown(long j);

    public static native byte[] SSL_get_tls_channel_id(long j) throws SSLException;

    public static native void SSL_interrupt(long j);

    public static native long SSL_new(long j) throws SSLException;

    public static native int SSL_read(long j, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks, byte[] bArr, int i, int i2, int i3) throws IOException;

    public static native int SSL_read_BIO(long j, byte[] bArr, int i, int i2, long j2, long j3, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native void SSL_renegotiate(long j) throws SSLException;

    public static native void SSL_set1_tls_channel_id(long j, long j2);

    public static native void SSL_set_accept_state(long j);

    public static native int SSL_set_alpn_protos(long j, byte[] bArr);

    public static native void SSL_set_cipher_lists(long j, String[] strArr);

    public static native void SSL_set_client_CA_list(long j, byte[][] bArr);

    public static native void SSL_set_connect_state(long j);

    public static native long SSL_set_mode(long j, long j2);

    public static native long SSL_set_options(long j, long j2);

    public static native void SSL_set_session(long j, long j2) throws SSLException;

    public static native void SSL_set_session_creation_enabled(long j, boolean z) throws SSLException;

    public static native void SSL_set_tlsext_host_name(long j, String str) throws SSLException;

    public static native void SSL_set_verify(long j, int i);

    public static native void SSL_shutdown(long j, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native void SSL_shutdown_BIO(long j, long j2, long j3, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native void SSL_use_PrivateKey(long j, long j2);

    public static native void SSL_use_certificate(long j, long[] jArr);

    public static native void SSL_use_psk_identity_hint(long j, String str) throws SSLException;

    public static native void SSL_write(long j, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks, byte[] bArr, int i, int i2, int i3) throws IOException;

    public static native int SSL_write_BIO(long j, byte[] bArr, int i, long j2, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native void X509_CRL_free(long j);

    public static native long X509_CRL_get0_by_cert(long j, long j2);

    public static native long X509_CRL_get0_by_serial(long j, byte[] bArr);

    public static native long[] X509_CRL_get_REVOKED(long j);

    public static native long X509_CRL_get_ext(long j, String str);

    public static native byte[] X509_CRL_get_ext_oid(long j, String str);

    public static native byte[] X509_CRL_get_issuer_name(long j);

    public static native long X509_CRL_get_lastUpdate(long j);

    public static native long X509_CRL_get_nextUpdate(long j);

    public static native long X509_CRL_get_version(long j);

    public static native void X509_CRL_print(long j, long j2);

    public static native void X509_CRL_verify(long j, long j2);

    public static int X509_NAME_hash(X500Principal x500Principal) {
        return X509_NAME_hash(x500Principal, AppSigning.SHA1);
    }

    private static int X509_NAME_hash(X500Principal x500Principal, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(x500Principal.getEncoded());
            int i = 0 + 1;
            byte b = digest[0];
            int i2 = i + 1;
            return ((b & 255) << 0) | ((digest[i] & 255) << 8) | ((digest[i2] & 255) << 16) | ((digest[i2 + 1] & 255) << 24);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static int X509_NAME_hash_old(X500Principal x500Principal) {
        return X509_NAME_hash(x500Principal, "MD5");
    }

    public static native String X509_NAME_print_ex(long j, long j2);

    public static native long X509_REVOKED_dup(long j);

    public static native long X509_REVOKED_get_ext(long j, String str);

    public static native byte[] X509_REVOKED_get_ext_oid(long j, String str);

    public static native byte[] X509_REVOKED_get_serialNumber(long j);

    public static native void X509_REVOKED_print(long j, long j2);

    public static native int X509_check_issued(long j, long j2);

    public static native int X509_cmp(long j, long j2);

    public static native void X509_free(long j);

    public static native byte[] X509_get_ext_oid(long j, String str);

    public static native byte[] X509_get_issuer_name(long j);

    public static native long X509_get_notAfter(long j);

    public static native long X509_get_notBefore(long j);

    public static native long X509_get_pubkey(long j) throws NoSuchAlgorithmException;

    public static native byte[] X509_get_serialNumber(long j);

    public static native byte[] X509_get_subject_name(long j);

    public static native long X509_get_version(long j);

    public static native void X509_print_ex(long j, long j2, long j3, long j4);

    public static native int X509_supported_extension(long j);

    public static native void X509_verify(long j, long j2) throws BadPaddingException;

    private static void add(String str, String str2) {
        OPENSSL_TO_STANDARD_CIPHER_SUITES.put(str2, str);
        STANDARD_TO_OPENSSL_CIPHER_SUITES.put(str, str2);
    }

    public static String[] checkEnabledCipherSuites(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("cipherSuites == null");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return strArr;
            }
            String str = strArr[i2];
            if (str == null) {
                throw new IllegalArgumentException("cipherSuites[" + i2 + "] == null");
            }
            if (!str.equals(TLS_EMPTY_RENEGOTIATION_INFO_SCSV) && !str.equals(TLS_FALLBACK_SCSV) && !STANDARD_TO_OPENSSL_CIPHER_SUITES.containsKey(str) && !OPENSSL_TO_STANDARD_CIPHER_SUITES.containsKey(str)) {
                throw new IllegalArgumentException("cipherSuite " + str + " is not supported.");
            }
            i = i2 + 1;
        }
    }

    public static String[] checkEnabledProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return strArr;
            }
            String str = strArr[i2];
            if (str == null) {
                throw new IllegalArgumentException("protocols[" + i2 + "] == null");
            }
            if (!str.equals(SUPPORTED_PROTOCOL_SSLV3) && !str.equals(SUPPORTED_PROTOCOL_TLSV1) && !str.equals(SUPPORTED_PROTOCOL_TLSV1_1) && !str.equals(SUPPORTED_PROTOCOL_TLSV1_2)) {
                throw new IllegalArgumentException("protocol " + str + " is not supported");
            }
            i = i2 + 1;
        }
    }

    private static native void clinit();

    public static native long create_BIO_InputStream(OpenSSLBIOInputStream openSSLBIOInputStream);

    public static native long create_BIO_OutputStream(OutputStream outputStream);

    public static native long[] d2i_PKCS7_bio(long j, int i);

    public static native long d2i_PKCS8_PRIV_KEY_INFO(byte[] bArr);

    public static native long d2i_PUBKEY(byte[] bArr);

    public static native long d2i_SSL_SESSION(byte[] bArr);

    public static native long d2i_X509(byte[] bArr);

    public static native long d2i_X509_CRL_bio(long j);

    public static native long d2i_X509_bio(long j);

    public static native long getDSAPrivateKeyWrapper(DSAPrivateKey dSAPrivateKey);

    public static native long getECPrivateKeyWrapper(ECPrivateKey eCPrivateKey, long j);

    public static native long getRSAPrivateKeyWrapper(RSAPrivateKey rSAPrivateKey, byte[] bArr);

    public static String[] getSupportedCipherSuites() {
        return (String[]) SUPPORTED_CIPHER_SUITES.clone();
    }

    public static String[] getSupportedProtocols() {
        return new String[]{SUPPORTED_PROTOCOL_SSLV3, SUPPORTED_PROTOCOL_TLSV1, SUPPORTED_PROTOCOL_TLSV1_1, SUPPORTED_PROTOCOL_TLSV1_2};
    }

    public static native byte[][] get_DH_params(long j);

    public static native byte[][] get_DSA_params(long j);

    public static native int get_EC_GROUP_type(long j);

    public static native int get_EVP_CIPHER_CTX_buf_len(long j);

    public static native byte[][] get_RSA_private_params(long j);

    public static native byte[][] get_RSA_public_params(long j);

    public static native int get_SSL_CIPHER_algorithm_auth(long j);

    public static native int get_SSL_CIPHER_algorithm_mkey(long j);

    public static native byte[] get_X509_CRL_crl_enc(long j);

    public static native String[] get_X509_CRL_ext_oids(long j, int i);

    public static native String get_X509_CRL_sig_alg_oid(long j);

    public static native byte[] get_X509_CRL_sig_alg_parameter(long j);

    public static native byte[] get_X509_CRL_signature(long j);

    public static native Object[][] get_X509_GENERAL_NAME_stack(long j, int i) throws CertificateParsingException;

    public static native String[] get_X509_REVOKED_ext_oids(long j, int i);

    public static native long get_X509_REVOKED_revocationDate(long j);

    public static native byte[] get_X509_cert_info_enc(long j);

    public static native int get_X509_ex_flags(long j);

    public static native boolean[] get_X509_ex_kusage(long j);

    public static native int get_X509_ex_pathlen(long j);

    public static native String[] get_X509_ex_xkusage(long j);

    public static native String[] get_X509_ext_oids(long j, int i);

    public static native int get_X509_hashCode(long j);

    public static native boolean[] get_X509_issuerUID(long j);

    public static native String get_X509_pubkey_oid(long j);

    public static native String get_X509_sig_alg_oid(long j);

    public static native byte[] get_X509_sig_alg_parameter(long j);

    public static native byte[] get_X509_signature(long j);

    public static native boolean[] get_X509_subjectUID(long j);

    public static native byte[] i2d_DSAPrivateKey(long j);

    public static native byte[] i2d_DSAPublicKey(long j);

    public static native byte[] i2d_PKCS7(long[] jArr);

    public static native byte[] i2d_PKCS8_PRIV_KEY_INFO(long j);

    public static native byte[] i2d_PUBKEY(long j);

    public static native byte[] i2d_RSAPrivateKey(long j);

    public static native byte[] i2d_RSAPublicKey(long j);

    public static native byte[] i2d_SSL_SESSION(long j);

    public static native byte[] i2d_X509(long j);

    public static native byte[] i2d_X509_CRL(long j);

    public static native byte[] i2d_X509_PUBKEY(long j);

    public static native byte[] i2d_X509_REVOKED(long j);

    public static void setEnabledCipherSuites(long j, String[] strArr) {
        checkEnabledCipherSuites(strArr);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                SSL_set_cipher_lists(j, (String[]) arrayList.toArray(new String[arrayList.size()]));
                return;
            }
            String str = strArr[i2];
            if (!str.equals(TLS_EMPTY_RENEGOTIATION_INFO_SCSV)) {
                if (str.equals(TLS_FALLBACK_SCSV)) {
                    SSL_set_mode(j, 128L);
                } else {
                    String str2 = STANDARD_TO_OPENSSL_CIPHER_SUITES.get(str);
                    if (str2 != null) {
                        str = str2;
                    }
                    arrayList.add(str);
                }
            }
            i = i2 + 1;
        }
    }

    public static void setEnabledProtocols(long j, String[] strArr) {
        long j2;
        long j3;
        checkEnabledProtocols(strArr);
        long j4 = 503316480;
        long j5 = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                SSL_set_options(j, j4);
                SSL_clear_options(j, j5);
                return;
            }
            String str = strArr[i2];
            if (str.equals(SUPPORTED_PROTOCOL_SSLV3)) {
                j4 &= -33554433;
                j2 = j5;
                j3 = 33554432;
            } else if (str.equals(SUPPORTED_PROTOCOL_TLSV1)) {
                j4 &= -67108865;
                j2 = j5;
                j3 = 67108864;
            } else if (str.equals(SUPPORTED_PROTOCOL_TLSV1_1)) {
                j4 &= -268435457;
                j2 = j5;
                j3 = 268435456;
            } else if (!str.equals(SUPPORTED_PROTOCOL_TLSV1_2)) {
                throw new IllegalStateException();
            } else {
                j4 &= -134217729;
                j2 = j5;
                j3 = 134217728;
            }
            j5 = j2 | j3;
            i = i2 + 1;
        }
    }

    public static native void set_DSA_flag_nonce_from_hash(long j);

    public static native void set_SSL_psk_client_callback_enabled(long j, boolean z);

    public static native void set_SSL_psk_server_callback_enabled(long j, boolean z);
}
