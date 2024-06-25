package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class DataReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static JsonNode getJsonNode(String path) {
        try (InputStream input = DataReader.class.getClassLoader().getResourceAsStream(path)) {
            return objectMapper.readTree(input);
        } catch (IOException ex) {
            LogUtils.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static String readConfig(String value) {
        return getJsonNode("configuration/config.json").get(value).asText();
    }


    public static String readCapabilities(String value) {
        return getJsonNode("configuration/capabilities.json").get(value).asText();
    }

    public static String readCredentials(String value) {
        return getJsonNode("configuration/credentials.json").get(value).asText();
    }
}

