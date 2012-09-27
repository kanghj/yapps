package com.vouov.yapps.json.bean;

/**
 * User: yuml
 * Date: 12-9-28
 * Time: 上午1:35
 */
public class JsonResult {
    private boolean success = true;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
