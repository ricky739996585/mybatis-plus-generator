package com.mybatisplus.base.config;


import com.baomidou.mybatisplus.generator.config.rules.DbType;
import org.springframework.beans.factory.annotation.Value;

public class ConnectionConfig {
    @Value("mybatisplus.url")
    private String url;
    @Value("mybatisplus.username")
    private String username;
    @Value("mybatisplus.password")
    private String password;
    @Value("mybatisplus.driverName")
    private String driverName;
    @Value("mybatisplus.packageName")
    private String packageName;
    private DbType dbType;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
