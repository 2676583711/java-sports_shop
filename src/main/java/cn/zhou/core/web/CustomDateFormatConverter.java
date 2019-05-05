package cn.zhou.core.web;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 时间格式转换器
 */


public class CustomDateFormatConverter //extends RequestMappingHandlerAdapter
        implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    // 178 7620 0329
//
//    @Override
//    public Date convert(Object source) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        try {
//            return dateFormat.parse((String) source);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//}
}
