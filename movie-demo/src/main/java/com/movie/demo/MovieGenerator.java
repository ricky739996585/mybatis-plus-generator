package com.movie.demo;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.mybatisplus.base.config.ConnectionConfig;
import com.mybatisplus.base.GeneratorCode;
import org.junit.Test;

public class MovieGenerator extends GeneratorCode {


    @Test
    public void movieGenerator(){
        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.setUrl("jdbc:mysql://localhost:3306/test");
        connectionConfig.setDbType(DbType.MYSQL);
        connectionConfig.setDriverName("com.mysql.jdbc.Driver");
        connectionConfig.setUsername("root");
        connectionConfig.setPassword("123456");
        connectionConfig.setPackageName("com.movie.demo");
        this.generateByTables(connectionConfig,"tb_movie");
    }
}
