package com.duoyu.rpc;

import java.io.Serializable;

/**
 * @Description
 * @Author wangxc
 * @Date 2021/8/19
 */
public class RpcRequest implements Serializable {
    private String className;
    private String methodName;
    private Object[] params;
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
