package com.dql.learn.guava;

import com.google.common.base.Preconditions;

/**
 * @author dengquanliang
 * Created on 2020/12/11
 */
public class ParamPreconditions {
    public ParamPreconditions check(boolean expression, String errorMsg) throws IllegalArgumentException{
        Preconditions.checkArgument(expression, errorMsg);
        return this;
    }
    public ParamPreconditions check(boolean expression) throws IllegalArgumentException{
        Preconditions.checkArgument(expression);
        return this;
    }
}
