package com.example.live.util;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * RestTemplate 把数据从 HttpResponse 转换成 Object 的时候，找不到合适的 HttpMessageConverter 来转换。
 * 在报错信息中知道，不支持[text/plain;charset=UTF-8]类型，需要继承 MappingJackson2HttpMessageConverter 并在构造过程中设置其支持的 MediaType 类型：
 *
 */
public class JacksonConverter extends MappingJackson2HttpMessageConverter {

    public JacksonConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);
        setSupportedMediaTypes(mediaTypes);
    }
}
