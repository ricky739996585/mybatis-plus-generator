package com.movie.demo.comm.po;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruin
 */
@Component
@Slf4j
public class ResultVM implements Serializable {
    @Value("${spring.application.name}")
    private String serverName;
    private static ResultVM resultVM;

    @PostConstruct
    public void init() {
        resultVM = this;
        resultVM.serverName = "服务-" + this.serverName + ":";
    }


    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS = 200;

    public static final Integer FAIL = 500;

    public Integer code = null;

    private String msg = "";

    private Object result;

    private Boolean encryption;

    //AES 秘钥
    public static final String AES_KEY = "1234567890123456";

    public ResultVM() {

    }

    public ResultVM(Integer code) {
        this.code = code;
    }

    public ResultVM(Integer code, String msg) {
        this.code = code;
        log.warn(resultVM.serverName + msg);
        this.msg = msg;
    }

    public ResultVM(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public ResultVM(Integer code, String msg, Object result) {
        this.code = code;
        log.warn(resultVM.serverName + msg);
        this.msg = msg;
        this.result = result;
    }

    public ResultVM(Integer code, String msg, Object result, Boolean encryption) {
        this.code = code;
        log.warn(resultVM.serverName + msg);
        this.msg = msg;
        this.result = result;
        this.encryption = encryption;
    }

    public ResultVM(String msg, Object result) {
        log.warn(resultVM.serverName + msg);
        this.msg = msg;
        this.result = result;
    }

    public ResultVM(Object result) {
        this.result = result;
    }

    public static ResultVM error() {
        return error(FAIL, "未知异常，请联系管理员");
    }

    public static ResultVM error(String msg) {
        log.error(msg);
        return error(FAIL, msg);
    }

    public static ResultVM error(Integer code, String msg) {
        log.error(msg);
        return new ResultVM(FAIL, msg);
    }

    public static ResultVM ok(String msg) {
        return ok(SUCCESS, msg);
    }

    public static ResultVM ok(Integer code, String msg) {
        return new ResultVM(SUCCESS, msg);
    }

    public static ResultVM ok(Object result) {
        return new ResultVM(SUCCESS, result);
    }

    public static ResultVM ok(String msg, Object result) {
        return new ResultVM(SUCCESS, msg, result);
    }

    public static ResultVM ok() {
        return new ResultVM(SUCCESS);
    }

    public static ResultVM info(Boolean ret) {
        if (ret) {
            return ResultVM.ok();
        } else {
            return ResultVM.error();
        }
    }


    public Integer getCode() {
        return code;
    }

    public ResultVM setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultVM setMsg(String msg) {
        this.msg = resultVM.serverName + msg;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public ResultVM setResult(Object result) {
        this.result = result;
        return this;
    }


    /**
     * 获取对应的数据
     *
     * @return
     */
    public <T extends Object> T getData(Class<T> entiytClass) {
        if (this.result == null) {
            return null;
        }
        T entity = JSON.parseObject(JSON.toJSONString(this.result, SerializerFeature.IgnoreErrorGetter), entiytClass);
        return entity;
    }

    /**
     * 获取对应的数据
     *
     * @return
     */
    public <T extends Object> List<T> getData(List<T> list, Class<T> entiytClass) {
        if (this.result == null) {
            return null;
        }
        List<JSONObject> jsonObjects = this.getData(List.class);
        for (JSONObject jsonObject : jsonObjects) {
            T entity = JSON.parseObject(jsonObject.toJSONString(), entiytClass);
            list.add(entity);
        }
        return list;
    }


    /**
     * 获取对应的数据
     *
     * @return
     */
    public <T extends Object> List<T> getData(Map map, String key, Class<T> entiytClass) {
        if (this.result == null) {
            return null;
        }
        List<T> list = new ArrayList<>();
        map = (Map) this.result;
        List<Map> jsonObjects = (List<Map>) map.get(key);
        for (Map object : jsonObjects) {
            JSONObject jsonObject = new JSONObject(object);
            T entity = JSON.parseObject(jsonObject.toJSONString(), entiytClass);
            list.add(entity);
        }
        return list;
    }
}
