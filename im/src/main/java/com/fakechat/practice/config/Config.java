package com.fakechat.practice.config;


import com.fakechat.practice.protocol.Serializer;

import java.util.Properties;

public abstract class Config {


    public static Serializer.Algorithm getSerializerAlgorithm() {

        return Serializer.Algorithm.Json;

    }
}