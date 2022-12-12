package com.meowu.plugins.language.utils;

import com.google.common.base.CaseFormat;
import com.meowu.commons.utils.AssertUtils;
import com.meowu.plugins.language.constants.StringConstants;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SpellingUtils{

    public static String toString(byte[] bytes){
        return toString(bytes, StandardCharsets.UTF_8);
    }

    public static String toString(byte[] bytes, Charset charset){
        AssertUtils.notNull(bytes, "array must not be null");
        AssertUtils.notNull(charset, "charset must not be null");

        if(ArrayUtils.isEmpty(bytes)){
            return StringConstants.EMPTY_STRING;
        }

        return new String(bytes, charset);
    }

    public static String upper(String str){
        AssertUtils.notNull(str, "string content must not be null");

        return str.toUpperCase();
    }

    public static String lower(String str){
        AssertUtils.notNull(str, "string content must not be null");

        return str.toLowerCase();
    }

    public static String capitalize(String str){
        AssertUtils.notNull(str, "string content must not be null");

        return StringUtils.capitalize(str);
    }

    public static String decapitalize(String str){
        AssertUtils.notNull(str, "string content must not be null");

        return StringUtils.uncapitalize(str);
    }

    public static String camel(String str){
        AssertUtils.notNull(str, "string content must not be null");

        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }

    public static String underline(String str){
        AssertUtils.notNull(str, "string content must not be null");

        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static boolean safeEqual(String compare, String compareTo){
        if(compare == compareTo){
            return true;
        }

        if(compare == null || compareTo == null){
            return false;
        }

        if(compare.length() != compareTo.length()){
            return false;
        }

        int result = 0;

        // time-constant comparison
        for(int i = 0; i < compare.length(); i++){
            result |= compare.charAt(i) ^ compareTo.charAt(i);
        }

        return (result == 0);
    }
}
