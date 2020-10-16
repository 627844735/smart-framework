package org.smart4j.framework.core;/**
 * Created by Enzo Cotter on 2020/10/16.
 */

import java.util.Map;

/**
 * @author:zqy
 * @date:2020/10/16 10:51
 * @desc:
 */
public class SimplePropsReader extends AbstractPropsReader {

    public SimplePropsReader(String filePath) {
        super(filePath);
    }

// ======================================
//      abstractPropsReader methods
//          TODO 未实现
// ======================================

    @Override
    public Object getTypeValue(String key) {
        return null;
    }

    @Override
    public Map<String, Object> getContainsAttrPrefix(String prefix) {
        return null;
    }
}
