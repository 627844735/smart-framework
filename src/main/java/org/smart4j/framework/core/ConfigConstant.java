package org.smart4j.framework.core;

/**
 * 配置项
 * //TODO 资源文件路径和资源项写在一块了,后面要分开
 */
public enum ConfigConstant {

    PLUGIN_PATH("F://2020708/workspace/smart-framework/src/main/resources/"),
    CONFIG_FILE("smart.properties"),
    JDBC_DRIVER("smart.framework.jdbc.driver"),
    JDBC_URL("smart.framework.jdbc.url"),
    JDBC_USERNAME("smart.framework.jdbc.username"),
    JDBC_PASSWORD("smart.framework.jdbc.password"),
    APP_BASE_PACKAGE("smart.framework.app.base_package"),
    APP_JSP_PATH("smart.framework.app.jsp_path"),
    APP_ASSET_PATH("smart.framework.app.asset_path");

    private String tyeName;

     ConfigConstant(String tyeName) {
        this.tyeName = tyeName;
    }

    /**
     * 获取枚举中的值
     * @return
     */
    public String getTyeName(){
         return tyeName;
    }
}