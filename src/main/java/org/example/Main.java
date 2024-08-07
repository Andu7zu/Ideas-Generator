package org.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        IdeasGenerator ideasGenerator = new IdeasGenerator();
        ideasGenerator.readAndStoreFile();

        ArrayList<ApiData> apiData = ideasGenerator.pickRandomApis();

          var model = new ChatModelConnector().connectModel("llama3");
            String userPrompt = """
                    Generate 5 fun project ideas, combining 2-5 APIs from the list below. The ideas must be
                    suitable for a junior programmer and they should be formatted like this.

                    Mark each idea like : Idea 1, Idea 2, Idea 3 etc.

                    Each unique idea must have the following:

                    #Title

                    #Short description

                    # The APIs used and their URLs

                    Grade their difficulty (On a scale from 1-5)

                    Grade the Bussiness possible success (On a scale from 1-5)

                    -------------------------------------------------------------

                    Here's the list:
                    """;
            for(ApiData data : apiData){
                userPrompt += "\n" + data.toString();
            }

            String response = model.generate(userPrompt);
            System.out.printf("Response: %s%n", response);

    }

}