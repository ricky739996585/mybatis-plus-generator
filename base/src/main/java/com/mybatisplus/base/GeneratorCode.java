package com.mybatisplus.base;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mybatisplus.base.config.ConnectionConfig;

public abstract class GeneratorCode {


    public void generateByTables(boolean serviceNameWithI, ConnectionConfig connectionConfig, String ... tableNames){

        String dbUrl = connectionConfig.getUrl();
        String username = connectionConfig.getUsername();
        String password = connectionConfig.getPassword();
        String driverName = connectionConfig.getDriverName();
        DbType dbType = connectionConfig.getDbType();
        String packeageName = connectionConfig.getPackageName();
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(dbType)
                .setUrl(dbUrl)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driverName);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)   //  命名驼峰设置
                .setTablePrefix("tb_")     //表明前缀清除
                .setInclude(tableNames);

        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setOutputDir(System.getProperty("user.dir")+"/src/main/java")
                .setFileOverride(true)
                .setMapperName("%sDao");    // DAO名称设置

        if (!serviceNameWithI){
            config.setServiceName("%sService"); // Service名称设置
        }



        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packeageName) //例如：com.mybatis-plus.demo
                .setEntity("entity")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("dao.mapper")
                .setMapper("dao");



        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();

    }

    public void generateByTables(ConnectionConfig connectionConfig,String... tableNames){
        generateByTables(true,connectionConfig, tableNames);
    }

}
