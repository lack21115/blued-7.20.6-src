package com.qiniu.android.collect;

import android.media.MediaFormat;
import com.igexin.push.core.b;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoElement.class */
public class UploadInfoElement {
    public static String x_log_client_id = "";

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoElement$BlockInfo.class */
    public static class BlockInfo {
        private long bytes_sent;
        private String current_region_id;
        private long file_size;
        private String log_type = "block";
        private long pid;
        private long recovered_from;
        private String target_region_id;
        private long tid;
        private long total_elapsed_time;
        private int up_api_version;
        private long up_time;

        public long getBytes_sent() {
            return this.bytes_sent;
        }

        public String getCurrent_region_id() {
            return this.current_region_id;
        }

        public long getFile_size() {
            return this.file_size;
        }

        public String getLog_type() {
            return this.log_type;
        }

        public long getPid() {
            return this.pid;
        }

        public long getRecovered_from() {
            return this.recovered_from;
        }

        public String getTarget_region_id() {
            return this.target_region_id;
        }

        public long getTid() {
            return this.tid;
        }

        public long getTotal_elapsed_time() {
            return this.total_elapsed_time;
        }

        public int getUp_api_version() {
            return this.up_api_version;
        }

        public long getUp_time() {
            return this.up_time;
        }

        public void setBytes_sent(long j) {
            this.bytes_sent = j;
        }

        public void setCurrent_region_id(String str) {
            this.current_region_id = str;
        }

        public void setFile_size(long j) {
            this.file_size = j;
        }

        public void setLog_type(String str) {
            this.log_type = str;
        }

        public void setPid(long j) {
            this.pid = j;
        }

        public void setRecovered_from(long j) {
            this.recovered_from = j;
        }

        public void setTarget_region_id(String str) {
            this.target_region_id = str;
        }

        public void setTid(long j) {
            this.tid = j;
        }

        public void setTotal_elapsed_time(long j) {
            this.total_elapsed_time = j;
        }

        public void setUp_api_version(int i) {
            this.up_api_version = i;
        }

        public void setUp_time(long j) {
            this.up_time = j;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoElement$ReqInfo.class */
    public static class ReqInfo {
        private long bytes_sent;
        private long bytes_total;
        private long connect_elapsed_time;
        private String current_region_id;
        private long dns_elapsed_time;
        private String error_description;
        private String error_type;
        private long file_offset;
        private String host;
        private String network_type;
        private String os_version;
        private long pid;
        private int port;
        private long prefetched_ip_count;
        private String remote_ip;
        private String req_id;
        private long request_elapsed_time;
        private long response_elapsed_time;
        private String sdk_name;
        private String sdk_version;
        private long signal_strength;
        private int status_code;
        private String target_bucket;
        private String target_key;
        private String target_region_id;
        private long tid;
        private long tls_connect_elapsed_time;
        private long total_elapsed_time;
        private long up_time;
        private String up_type;
        private long wait_elapsed_time;
        public String log_type = "request";
        private String os_name = "android";

        public long getBytes_sent() {
            return this.bytes_sent;
        }

        public long getBytes_total() {
            return this.bytes_total;
        }

        public long getConnect_elapsed_time() {
            return this.connect_elapsed_time;
        }

        public String getCurrent_region_id() {
            return this.current_region_id;
        }

        public long getDns_elapsed_time() {
            return this.dns_elapsed_time;
        }

        public String getError_description() {
            return this.error_description;
        }

        public String getError_type() {
            return this.error_type;
        }

        public long getFile_offset() {
            return this.file_offset;
        }

        public String getHost() {
            return this.host;
        }

        public String getLog_type() {
            return this.log_type;
        }

        public String getNetwork_type() {
            return this.network_type;
        }

        public String getOs_name() {
            return this.os_name;
        }

        public String getOs_version() {
            return this.os_version;
        }

        public long getPid() {
            return this.pid;
        }

        public int getPort() {
            return this.port;
        }

        public long getPrefetched_ip_count() {
            return this.prefetched_ip_count;
        }

        public String getRemote_ip() {
            return this.remote_ip;
        }

        public String getReq_id() {
            return this.req_id;
        }

        public long getRequest_elapsed_time() {
            return this.request_elapsed_time;
        }

        public long getResponse_elapsed_time() {
            return this.response_elapsed_time;
        }

        public String getSdk_name() {
            return this.sdk_name;
        }

        public String getSdk_version() {
            return this.sdk_version;
        }

        public long getSignal_strength() {
            return this.signal_strength;
        }

        public int getStatus_code() {
            return this.status_code;
        }

        public String getTarget_bucket() {
            return this.target_bucket;
        }

        public String getTarget_key() {
            return this.target_key;
        }

        public String getTarget_region_id() {
            return this.target_region_id;
        }

        public long getTid() {
            return this.tid;
        }

        public long getTls_connect_elapsed_time() {
            return this.tls_connect_elapsed_time;
        }

        public long getTotal_elapsed_time() {
            return this.total_elapsed_time;
        }

        public long getUp_time() {
            return this.up_time;
        }

        public String getUp_type() {
            return this.up_type;
        }

        public long getWait_elapsed_time() {
            return this.wait_elapsed_time;
        }

        public void setBytes_sent(long j) {
            this.bytes_sent = j;
        }

        public void setBytes_total(long j) {
            this.bytes_total = j;
        }

        public void setConnect_elapsed_time(long j) {
            this.connect_elapsed_time = j;
        }

        public void setCurrent_region_id(String str) {
            this.current_region_id = str;
        }

        public void setDns_elapsed_time(long j) {
            this.dns_elapsed_time = j;
        }

        public void setError_description(String str) {
            this.error_description = str;
        }

        public void setError_type(String str) {
            this.error_type = str;
        }

        public void setFile_offset(long j) {
            this.file_offset = j;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setLog_type(String str) {
            this.log_type = str;
        }

        public void setNetwork_type(String str) {
            this.network_type = str;
        }

        public void setOs_name(String str) {
            this.os_name = str;
        }

        public void setOs_version(String str) {
            this.os_version = str;
        }

        public void setPid(long j) {
            this.pid = j;
        }

        public void setPort(int i) {
            this.port = i;
        }

        public void setPrefetched_ip_count(long j) {
            this.prefetched_ip_count = j;
        }

        public void setRemote_ip(String str) {
            this.remote_ip = str;
        }

        public void setReq_id(String str) {
            this.req_id = str;
        }

        public void setRequest_elapsed_time(long j) {
            this.request_elapsed_time = j;
        }

        public void setResponse_elapsed_time(long j) {
            this.response_elapsed_time = j;
        }

        public void setSdk_name(String str) {
            this.sdk_name = str;
        }

        public void setSdk_version(String str) {
            this.sdk_version = str;
        }

        public void setSignal_strength(long j) {
            this.signal_strength = j;
        }

        public void setStatus_code(int i) {
            this.status_code = i;
        }

        public void setTarget_bucket(String str) {
            this.target_bucket = str;
        }

        public void setTarget_key(String str) {
            this.target_key = str;
        }

        public void setTarget_region_id(String str) {
            this.target_region_id = str;
        }

        public void setTid(long j) {
            this.tid = j;
        }

        public void setTls_connect_elapsed_time(long j) {
            this.tls_connect_elapsed_time = j;
        }

        public void setTotal_elapsed_time(long j) {
            this.total_elapsed_time = j;
        }

        public void setUp_time(long j) {
            this.up_time = j;
        }

        public void setUp_type(String str) {
            this.up_type = str;
        }

        public void setWait_elapsed_time(long j) {
            this.wait_elapsed_time = j;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoElement$UploadQuality.class */
    public static class UploadQuality {
        private long bytes_sent;
        private String cloud_type;
        private String log_type = MediaFormat.KEY_QUALITY;
        private long regions_counts = 1;
        private long requests_counts;
        private String result;
        private long total_elapsed_time;
        private long up_time;

        public long getBytes_sent() {
            return this.bytes_sent;
        }

        public String getCloud_type() {
            return this.cloud_type;
        }

        public String getLog_type() {
            return this.log_type;
        }

        public long getRegions_counts() {
            return this.regions_counts;
        }

        public long getRequests_counts() {
            return this.requests_counts;
        }

        public String getResult() {
            return this.result;
        }

        public long getTotal_elapsed_time() {
            return this.total_elapsed_time;
        }

        public long getUp_time() {
            return this.up_time;
        }

        public void setBytes_sent(long j) {
            this.bytes_sent = j;
        }

        public void setCloud_type(String str) {
            this.cloud_type = str;
        }

        public void setLog_type(String str) {
            this.log_type = str;
        }

        public void setRegions_counts(long j) {
            this.regions_counts = j;
        }

        public void setRequests_counts(long j) {
            this.requests_counts = j;
        }

        public void setResult(String str) {
            this.result = str;
        }

        public void setTotal_elapsed_time(long j) {
            this.total_elapsed_time = j;
        }

        public void setUp_time(long j) {
            this.up_time = j;
        }
    }

    public static String errorType(int i, String str) {
        return i == 406 ? "checksum_error" : (200 >= i || i >= 1000) ? i != -1004 ? i != -1003 ? i != -1001 ? i != -2 ? i != -1 ? "unknown_error" : (str == null || str.indexOf("but received") == -1) ? "network_error" : "file_changed" : "user_canceled" : "timeout" : "unknown_host" : "cannot_connect_to_host" : "response_error";
    }

    public static String resultCode(int i, String str) {
        if (i == 406) {
            return "checksum_error";
        }
        if (200 >= i || i >= 1000) {
            String str2 = "zero_size_file";
            if (i == -1001) {
                str2 = "timeout";
            } else if (i != -406) {
                if (i != 200) {
                    switch (i) {
                        case -1005:
                            return "network_slow";
                        case -1004:
                            return "cannot_connect_to_host";
                        case -1003:
                            return "unknown_host";
                        default:
                            switch (i) {
                                case -6:
                                case -4:
                                    break;
                                case -5:
                                    return "invalid_args";
                                case -3:
                                    return "invalid_file";
                                case -2:
                                    return "user_canceled";
                                case -1:
                                    return (str == null || str.indexOf("but received") == -1) ? "network_error" : "file_changed";
                                default:
                                    return "unknown_error";
                            }
                    }
                } else {
                    return b.x;
                }
            } else {
                return "crc32_nomatch";
            }
            return str2;
        }
        return "response_error";
    }
}
