package com.pemudaprogrammer.cores.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseEntity<T> {
    private T data;
    private Map<String, Object> headers = new HashMap();
    private String message;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonSerialize(
            using = LocalDateTimeSerializer.class
    )
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    private LocalDateTime time;

    public ApiResponseEntity() {
        this.time = LocalDateTime.now();
    }

    public ApiResponseEntity(T _data) {
        this.data = _data;
//        this.headers.put("status", HttpStatus.OK);
        this.time = LocalDateTime.now();
    }


    public ResponseEntity<ApiResponseEntity<T>> toResponse(HttpStatus status) {
        return new ResponseEntity(this, status);
    }

    public ResponseEntity<ApiResponseEntity<T>> toResponse(HttpStatus status, String _message) {
        this.message = _message;
        return new ResponseEntity(this, status);
    }

    public ResponseEntity<ApiResponseEntity<T>> toResponse(String _message) {
        this.message = _message;
        return new ResponseEntity(this, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseEntity<T>> toResponseOk() {
        return new ResponseEntity(this, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseEntity<T>> toResponseCreated() {
        return new ResponseEntity(this, HttpStatus.CREATED);
    }

    public ApiResponseEntity<T> setResponseHeaders(String key, Object value) {
        this.headers.put(key, value);
        return this;
    }

    @Generated
    public T getData() {
        return this.data;
    }

    @Generated
    public Map<String, Object> getHeaders() {
        return this.headers;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public LocalDateTime getTime() {
        return this.time;
    }

    @Generated
    public void setData(final T data) {
        this.data = data;
    }

    @Generated
    public void setHeaders(final Map<String, Object> headers) {
        this.headers = headers;
    }

    @Generated
    public void setMessage(final String message) {
        this.message = message;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    @Generated
    public void setTime(final LocalDateTime time) {
        this.time = time;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResponseEntity)) {
            return false;
        } else {
            ApiResponseEntity<?> other = (ApiResponseEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$headers = this.getHeaders();
                Object other$headers = other.getHeaders();
                if (this$headers == null) {
                    if (other$headers != null) {
                        return false;
                    }
                } else if (!this$headers.equals(other$headers)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$time = this.getTime();
                Object other$time = other.getTime();
                if (this$time == null) {
                    if (other$time != null) {
                        return false;
                    }
                } else if (!this$time.equals(other$time)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ApiResponseEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $headers = this.getHeaders();
        result = result * 59 + ($headers == null ? 43 : $headers.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $time = this.getTime();
        result = result * 59 + ($time == null ? 43 : $time.hashCode());
        return result;
    }
}
