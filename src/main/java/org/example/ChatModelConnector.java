package org.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class ChatModelConnector {
    private String model;
    private static final String LOCALHOST = "http://localhost:11434";

    public ChatLanguageModel connectModel(String modelName){
        return OllamaChatModel.builder()
                .baseUrl(LOCALHOST)
                .modelName(modelName)
                .build();
    }

}
