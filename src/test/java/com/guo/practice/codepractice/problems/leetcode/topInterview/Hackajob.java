package com.guo.practice.codepractice.problems.leetcode.topInterview;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Hackajob {


    /**
     * @return
     */
    @Test
    public void starWar() {
        try {

            String character = "Luke Skywalker";
            String encodecharacter = URLEncoder.encode(character, StandardCharsets.UTF_8.toString());

            StringBuilder result = new StringBuilder();
            URL url = new URL("https://challenges.hackajob.co/swapi/api/people/?search=" + encodecharacter + "&format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            JsonObject jsonObject = new JsonParser().parse(result.toString()).getAsJsonObject();

            JsonArray jsonArray = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonArray("films");

            log.debug("******** film count: " + jsonArray.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void starWar2() {
        String film = "The Force Awakens";
        String character = "Obi-Wan Kenobi";
        ///////////////////////////////////////

        StringBuilder sb = new StringBuilder();
        sb.append(film);
        sb.append(": ");

        List<String> characterList = new ArrayList<>();
        List<String> filmList = new ArrayList<>();

        JsonObject filmsObject = getResult("films", film);
        JsonArray peopleUrls = filmsObject.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonArray("characters");
        for (int i = 0; i < peopleUrls.size(); i++) {
            JsonObject people = getResult(peopleUrls.get(i).getAsString() + "?format=json");
            String peopleName = people.get("name").getAsString();
            characterList.add(peopleName);
        }

        /////////////////////////////
        // append sorted list
        characterList = characterList.stream().sorted().collect(Collectors.toList());
        for (int n = 0; n < characterList.size(); n++) {
            sb.append(characterList.get(n));
            if (n < characterList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("; ");

        sb.append(character);
        sb.append(": ");
        JsonObject peopleObject = getResult("people", character);
        if (peopleObject.getAsJsonArray("results").size() == 0) {
            sb.append("none");
        } else {
            JsonArray filmObj = peopleObject.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonArray("films");
            for (int j = 0; j < filmObj.size(); j++) {
                JsonObject movie = getResult(filmObj.get(j).getAsString() + "?format=json");
                String title = movie.get("title").getAsString();
                filmList.add(title);
            }

            /////////////////////////////
            // append sorted list
            filmList = filmList.stream().sorted().collect(Collectors.toList());
            for (int m = 0; m < filmList.size(); m++) {
                sb.append(filmList.get(m));
                if (m < filmList.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        log.debug("******** film cha: " + sb.toString());

    }


    public JsonObject getResult(String type, String name) {
        String encodedName = "";
        String urlString = "";
        try {
            encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
            urlString = "https://challenges.hackajob.co/swapi/api/" + type + "/?search=" + encodedName + "&format=json";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return getResult(urlString);
    }

    public JsonObject getResult(String urlString) {
        JsonObject resultObject = null;
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            resultObject = new JsonParser().parse(result.toString()).getAsJsonObject();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultObject;
    }

    /**
     * We want you to write a program that converts Morse code to English text and English text to Morse code
     */
    @Test
    public void morseCode() {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */

        boolean morseToEnglish = true;
        String textToTranslate = "..- .... ..-. .-.. --- .-    ...-";
//        textToTranslate = "The wizard quickly jinxed the gnomes before they vaporized.";
        if (textToTranslate.length() > 1000000 || textToTranslate.length() == 0) {
//            return "";
        }

        char[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                ',', '.', '?'};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};

        Map<Character, String> englishMorseMap = new HashMap<>();
        Map<String, Character> morseEnglishMap = new HashMap<>();

        for (int i = 0; i < 39; i++) {
            englishMorseMap.put(english[i], morse[i]);
            morseEnglishMap.put(morse[i], english[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (morseToEnglish) {
            String[] lettes = textToTranslate.split(" ");
            for (int k = 0; k < lettes.length; k++) {
                String inputStr = lettes[k];
                Character cha = morseEnglishMap.get(inputStr);
                if (inputStr.length() == 0) {
                    if(lettes[k-1].length() != 0) {
                        stringBuilder.append(" ");
                    }
                } else {
                    stringBuilder.append(cha.toString());
                }
            }

        } else {
            char[] letters = textToTranslate.toLowerCase().toCharArray();
            for (int j = 0; j < letters.length; j++) {
                Character let = letters[j];
                String code = englishMorseMap.get(let);
                if (let.toString().equals(" ")) {
                    stringBuilder.append("  ");

                } else {
                    stringBuilder.append(code).append(" ");
                }
            }
        }

        String translatedText = stringBuilder.toString();

        System.out.println(translatedText);

//        return translatedText;
    }


}
