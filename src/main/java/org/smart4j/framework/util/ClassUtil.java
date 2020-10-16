package org.smart4j.framework.util;/**
 * Created by Enzo Cotter on 2020/10/15.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.core.ConfigConstant;

import java.net.URL;
import java.util.Objects;

/**
 * @author:zqy
 * @date:2020/10/15 16:51
 * @desc:
 */
//TODO 未设计好,此处的功能应该设计一个接口.
public class ClassUtil {
    private static final Logger log = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     * @return
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取类的路径
     * @return
     */
    public static String getClassPath(){
        String classpath = "";

        //TODO 这里需要传入类名,如果传入空字符串,返回也为空，看后续！
        URL resource = getClassLoader().getResource("");
        if(!Objects.isNull(resource))
            classpath = resource.getPath();
        return classpath;
    }

    /**
     * 加载类
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className){
        return loadClass(className,true);
    }

    private static Class<?> loadClass(String className, boolean isInitialized){
        Class<?> cls;
        try {
            cls = Class.forName(className,isInitialized,getClassLoader());
        }catch (ClassNotFoundException cnfe){
            log.error("类加载出错\n"+cnfe);
            throw new RuntimeException(cnfe);
        }

        return cls;
    }
}
