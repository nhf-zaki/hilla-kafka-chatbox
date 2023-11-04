package demo.zk.application.model;

import org.apache.kafka.common.serialization.Serializer;
import org.jsoup.SerializationException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class MessageSerializer implements Serializer<Message> {

    public static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Override
    public byte[] serialize(String topic, Message message) {
        try {
            return mapper.writeValueAsBytes(message);
        } catch (JsonProcessingException jpe) {
            throw new SerializationException(jpe);
        }
    }

}
