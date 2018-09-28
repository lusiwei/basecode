package json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.User;

public class JsonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        User user=new User();
        user.setUsername("jack");
        user.setAge(12);
        user.setSex("man");
        ObjectMapper objectMapper=new ObjectMapper();
        String s=objectMapper.writeValueAsString(user);
        System.out.println(s);
        String string = JSON.toJSONString(user);
        System.out.println(string);
    }
}
