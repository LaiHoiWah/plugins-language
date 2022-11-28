package com.meowu.plugins.language.utils;

import com.google.common.base.CaseFormat;
import com.meowu.commons.utils.AssertUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

public class SpellingUtils {

    private final static String  EMPTY   = "";
    private final static Charset CHARSET = Charset.forName("utf-8");

    public static String toString(byte[] bytes){
        return toString(bytes, CHARSET);
    }

    public static String toString(byte[] bytes, Charset charset){
        AssertUtils.notNull(bytes, "array must not be null");
        AssertUtils.notNull(charset, "charset must not be null");

        if(ArrayUtils.isEmpty(bytes)){
            return EMPTY;
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
}
