package com.stark.homework.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@Slf4j
public class Response {

    private final String event;

    public Response(String event) {
        this.event = Objects.requireNonNullElse(event, "");
    }

    /**
     * event正常运行
     *
     * @param body 事件
     * @param msg 事件运行状态“成功”
     * @return 事件正常运行ResponseEntity实体
     */
    public ResponseEntity<Object> ok(Object body, String msg) {
        log.info("[Info]  " + this.event + ": " + msg);
        return ResponseEntity.ok(body);
    }

    public ResponseEntity<Object> ok(String msg) {
        log.info("[Info]  " + this.event + ": " + msg);
        return ResponseEntity.ok(msg);
    }

    /**
     * event运行报错
     *
     * @param msg  事件运行失败信息
     * @param code 失败状态码
     * @return  ResponseEntity实体类
     */
    public ResponseEntity<Object> error(String msg, HttpStatus code) {
        log.info("[Error] " + this.event + ": " + msg);
        return ResponseEntity.status(code).body(msg);
    }

    public ResponseEntity<Object> error(String msg) {
        log.info("[Error] " + this.event + ": " + msg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

}
