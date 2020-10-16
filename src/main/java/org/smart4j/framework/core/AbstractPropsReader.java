package org.smart4j.framework.core;/**
 * Created by Enzo Cotter on 2020/10/16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Props文件读取
 * @author:zqy
 * @date:2020/10/16 10:15
 * @desc:
 */
public abstract class AbstractPropsReader {
    private static final Logger log = LoggerFactory.getLogger(SimplePropsReader.class);

    /*props文件路径*/
    private String propsFilePath;

    /*存储从props中读取出来的键值,可能为null.*/
    private Map<String,Object> propsHashMap = new LinkedHashMap<>();

    private AbstractPropsReader(){}

    public AbstractPropsReader(String filePath){
        this.propsFilePath = filePath;
    }

    /**
     * 加载props属性文件.
     * @param
     * @return
     */
    public Properties loadProps(){
        Properties props = new Properties();
        if(Objects.isNull(propsFilePath))
            throw new IllegalArgumentException();


        String suffix = ".properties";
        if(propsFilePath.lastIndexOf(suffix) == -1)
            propsFilePath += suffix;
        //TD 原著这里使用getClassLoad().getResourcesAsStream();加载文件会出错.
        try(InputStream is = new FileInputStream(propsFilePath)){

            if(!Objects.isNull(is))
                props.load(is);
            loadPropsHashMap(props);
        }catch (IOException e){
            log.error("读取文件出错\n"+e);
            throw new RuntimeException();
        }
        return props;
    }

    /**
     * 将props中的key和value存入HashMap中.
     * @param props
     */
    protected void loadPropsHashMap(Properties props){
        if(Objects.isNull(props))
            throw new RuntimeException("文件加载异常或者文件为空");

        Enumeration<?> keys = props.propertyNames();
        while(keys.hasMoreElements()){
            String key = (String)keys.nextElement();
            propsHashMap.put(key,props.getProperty(key));
        }
    }

    public Map<String,Object> getpropsMap(){
        return this.propsHashMap;
    }
//  ========================================================
//          abstract method
//  ========================================================

    /**
     * 获取某个Key的value
     * @param key
     * @return
     */
    public abstract Object getTypeValue(String key);

    /**
     * 获取包含相同前缀的属性
     * @param prefix
     * @return
     */
    public abstract Map<String,Object> getContainsAttrPrefix(String prefix);
}
