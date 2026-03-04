package com.practice.demo1.dto;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse <T> {

    private boolean success;
    private String message ;
    private String error;
    @Timestamp
    private Long timestamp;
    private T data;

    public ApiResponse(boolean success, String message, T data){
          this.success=success;
          this.message=message;
          this.data=data;
          this.timestamp=System.currentTimeMillis();
    }

    public static <T> ApiResponse<T> ok(T data){return new ApiResponse<>(true, "success",data);}
    public static <T> ApiResponse<T> ok(String message, T data){return new ApiResponse<>(true,message,data);}

    public static <T> ApiResponse<T> error(String error){
        return ApiResponse.<T>builder()
                .success(false)
                .error(error)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
