package com.cjs.boot.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final String ASYNC_SUFFIX = ".json";

    public static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(header) && XML_HTTP_REQUEST.equals(header) && header.endsWith(ASYNC_SUFFIX)) {
            return true;
        }
        return false;
    }

}
