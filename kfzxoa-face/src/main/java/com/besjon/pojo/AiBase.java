/**
 * Copyright 2019 bejson.com
 */
package com.besjon.pojo;

/**
 * Auto-generated: 2019-06-02 15:20:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AiBase {

    private int error_code;
    private String error_msg;
    private long log_id;
    private long timestamp;
    private int cached;
    private AiResult aiResult;

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public int getCached() {
        return cached;
    }

    public void setAiResult(AiResult aiResult) {
        this.aiResult = aiResult;
    }

    public AiResult getAiResult() {
        return aiResult;
    }

    @Override
    public String toString() {
        return "AiBase [error_code=" + error_code + ", error_msg=" + error_msg + ", log_id=" + log_id
                + ", timestamp=" + timestamp + ", cached=" + cached + ", aiResult=" + aiResult + "]";
    }

}