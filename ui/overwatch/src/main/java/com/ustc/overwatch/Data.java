package com.ustc.overwatch;

import com.alibaba.fastjson.JSON;

public class Data {
    @Override
    public String toString() {
        return JSON.toJSONString(this) + "\n";
    }
}