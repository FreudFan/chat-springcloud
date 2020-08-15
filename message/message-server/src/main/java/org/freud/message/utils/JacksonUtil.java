package org.freud.message.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Slf4j
public class JacksonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private final static String LocalDatePattern = "yyyy-MM-dd";
    private final static String LocalDateTimePattern = "yyyy-MM-dd HH:mm:ss";

    static {
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(timeModule);
        //为空字段不显示
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }

    /***
     * 对象序列化为json字符串
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJSON(T obj) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("Jackson序列化失败");
            throw new RuntimeException(e);
        }
        return jsonStr;
    }

    /***
     * 将json字符串序列化为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJSON(String json, Class<T> clazz) {
        T obj;
        try {
            if (clazz.isAssignableFrom(String.class)) {
                return (T) json;
            }
            obj = objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("Jackson反序列化失败");
            throw new RuntimeException(e);
        }
        return obj;
    }

    /***
     * 反序列化集合
     * @param string
     * @param typeReference
     * @return
     */
    public static Object fromJSON(String string, TypeReference typeReference) {
        try {
            return objectMapper.readValue(string, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 将 object 转成 map
     * @param obj
     * @return
     */
    public static Map<String, String> toMap(Object obj) {
        return (Map<String, String>) fromJSON(toJSON(obj), new TypeReference<Map<String, String>>(){});
    }

    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern(LocalDatePattern)));
        }
    }

    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext deserializationContext)
                throws IOException {
            return LocalDate.parse(p.getValueAsString(), DateTimeFormatter.ofPattern(LocalDatePattern));
        }
    }

    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern(LocalDateTimePattern)));
        }
    }

    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext)
                throws IOException {
            return LocalDateTime.parse(p.getValueAsString(), DateTimeFormatter.ofPattern(LocalDateTimePattern));
        }
    }

}
