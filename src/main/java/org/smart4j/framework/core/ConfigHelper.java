package org.smart4j.framework.core;/**
 * Created by Enzo Cotter on 2020/10/16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

/**
 * 加载属性文件
 * @author:zqy
 * @date:2020/10/16 11:33
 * @desc:
 */
public class ConfigHelper {

    private static final Logger log = LoggerFactory.getLogger(ConfigHelper.class);

    /**
     * 获取props文件中的配置项.
     * @return
     */
    public static Map<String,Object> getPropsValues(){
        AbstractPropsReader simplePropsReader = new SimplePropsReader(ConfigConstant.PLUGIN_PATH.getTyeName()+ConfigConstant.CONFIG_FILE.getTyeName());
        simplePropsReader.loadProps();
        Map<String, Object> propsMap = simplePropsReader.getpropsMap();
        if(propsMap.size() <= 0){
            log.error("文件加载异常");
            throw new RuntimeException("文件加载异常");
        }
        return propsMap;
    }
}
