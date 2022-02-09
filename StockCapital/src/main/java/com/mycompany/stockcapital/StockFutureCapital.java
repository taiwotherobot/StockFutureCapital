/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stockcapital;

import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author password
 */
public class StockFutureCapital {

    public static void main(String args[]) {
        System.out.println("Here are the stocks in your portfolio and how much they closed at?: ");
        Scanner sc = new Scanner(System.in);

        try {
            JsonReader reader = new JsonReader(new FileReader("C:\\Users\\password\\Documents\\NetBeansProjects\\StockCapital\\src\\main\\resource\\sample.json"));

            reader.beginArray();
            while (reader.hasNext()) {

                reader.beginObject();
                while (reader.hasNext()) {

                    String key = reader.nextName();
                    String checkName = sc.nextLine();

                    if (key.equals("ticker")) {

                        System.out.println(reader.nextString());

                    } else if (key.equals("name")) {

                        System.out.println(reader.nextString());

                    } else if (key.equals("close")) {

                        System.out.println(reader.nextDouble());

                    } else {
                        reader.skipValue();
                    }
                }
                reader.endObject();
            }
            reader.endArray();

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }


    
}
