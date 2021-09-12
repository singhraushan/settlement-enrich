package com.jpmc.enrich.util;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EnrichUtility {

    public static BiFunction<String,String,String> BANK_PARTY = (acc,code)->{
                                                                        return "{" +
                                                                                " \"accountNumber\": "+acc+" ," +
                                                                                "\"bankCode\": "+code+" " +
                                                                                "}";
                                                                    };
    public static Function<String,String> SUPP_INFO = (s)->{
        if(Objects.nonNull(s) && !s.trim().isEmpty()){
            return "/"+s.replaceAll(":","/").replaceAll("-","/");
        }
        return "";
    };
}
