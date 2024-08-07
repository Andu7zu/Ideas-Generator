package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class IdeasGenerator {
    private static final int NO_OF_PICKS = 5;
    private static final int NO_OF_APIS = 1433;
    private String[] apisList = new String[NO_OF_APIS];

    public IdeasGenerator() {

    }

    protected void readAndStoreFile(){

        int index = 0;

        try {
            File apiFile = new File("apis.txt");
            Scanner reader = new Scanner(apiFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                apisList[index++] = data;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected ArrayList<ApiData> pickRandomApis(){
        Random rand = new Random();
        ArrayList<ApiData> apis = new ArrayList<>();
        ArrayList<Integer> chosenIndexes = new ArrayList<>();


        for(int i = 0; i < NO_OF_PICKS; i++){
            int tempVal = rand.nextInt(apisList.length);
            if(chosenIndexes.contains(tempVal)){
                i--;
            }
            else{
                String[] temp = apisList[tempVal].split("__");
                apis.add(new ApiData(temp[0], temp[1], temp[2]));
                chosenIndexes.add(tempVal);
            }
        }

        return apis;
    }

}




