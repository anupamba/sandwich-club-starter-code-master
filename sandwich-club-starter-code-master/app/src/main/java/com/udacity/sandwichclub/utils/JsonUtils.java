package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import java.util.ArrayList;
import java.util.Arrays;

public class JsonUtils {


    /** Sample JSON to Parse ************************************************
     *          {
     mainName:Ham and cheese sandwich,
     alsoKnownAs:[]},
     placeOfOrigin:,
     description:A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham
     between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables
     like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.,
     image:https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG,
     ingredients:[Sliced bread,Cheese,Ham]}
     *
     *
     * **********************************************************************/
    public static Sandwich parseSandwichJson(String json) {
        Sandwich objSandwich =  new Sandwich();
       /* objSandwich.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG");
        objSandwich.setMainName("Ham and cheese sandwich");
        objSandwich.setAlsoKnownAs(Arrays.asList("vad,abc,pqr".split(",")));
        objSandwich.setDescription("A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham\n" +
                "         between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables\n" +
                "         like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.");
        objSandwich.setPlaceOfOrigin("India");*/



        /*String json = "{\\\"name\\\":{\\\"mainName\\\":\\\"Roujiamo\\\","
                + "\\\"alsoKnownAs\\\":[\\\"Rougamo\\\",\\\"Rou jiacmo\\\"]"
                + "},"
                + "\\\"placeOfOrigin\\\":\\\"China\\\","
                + "\\\"description\\\":\\\"Roujiamo, meaning \\\\\\\"meat\r\n" +
                "burger\\\\\\\" or \\\\\\\"meat sandwich\\\\\\\", is a street food originating from the cuisine of\r\n" +
                "Shaanxi Province and now widely consumed all over China. The meat is most commonly pork,\r\n" +
                "stewed for hours in a soup containing over 20 spices and seasonings. Although it is\r\n" +
                "possible to use only a few spices (which many vendors do), the resulting meat is less\r\n" +
                "flavourful.\\\","
                + "\\\"image\\\":\\\"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Roujiamo.jpg/800px-Roujiamo.jpg\\\","
                + "\\\"ingredients\\\":[\\\"Pork\\\",\\\"bread\\\"]"
                + "}";*/




        String[] strArr = json.split(":");

        objSandwich.setDescription(strArr[5].replaceAll("\"",""));

        objSandwich.setPlaceOfOrigin(strArr[4].replaceAll("\"","").replaceAll("\"",""));
        objSandwich.setMainName(strArr[2].replaceAll("\"","").split(",")[0]);

        objSandwich.setPlaceOfOrigin(strArr[4].replaceAll("\"","").split(",")[0]);

        objSandwich.setImage((strArr[6]+strArr[7]).replaceAll("\"","").split(",")[0]);

        String str1 = strArr[3].replaceAll("\"","");
        String str2 = str1.replaceAll("\\[","");
        String strAlso = str2.replaceAll("]","");

        objSandwich.setAlsoKnownAs(Arrays.asList(strAlso.split(",")));

        String str3 = strArr[8].replaceAll("\"","");
        String str4 = str3.replaceAll("\\[","");
        String strIngr = str4.replaceAll("]","");

        objSandwich.setIngredients(Arrays.asList(strIngr.replaceAll("\\{","").replaceAll("\\}","").split(",")));




        /*Pattern mainName = Pattern.compile("mainName");
        Pattern alsoKnownAs = Pattern.compile("\"alsoKnownAs\":\"([^,]*)\",");
        Pattern placeOfOrigin = Pattern.compile("\"placeOfOrigin\":\"([^,]*)\",");
        Pattern description = Pattern.compile("\"description\":\"([^,]*)\",");
        Pattern image = Pattern.compile("\"image\":\"([^,]*)\",");
        Pattern ingredients = Pattern.compile("\"ingredients\":\"([^,]*)\",");

        Matcher mainName_matcher = mainName.matcher(json);
        Matcher alsoKnownAs_matcher = alsoKnownAs.matcher(json);
        Matcher placeOfOrigin_matcher = placeOfOrigin.matcher(json);
        Matcher description_matcher = description.matcher(json);
        Matcher image_matcher = image.matcher(json);
        Matcher ingredients_matcher = ingredients.matcher(json);

        if( mainName_matcher.find()
                || alsoKnownAs_matcher.find()
                || placeOfOrigin_matcher.find()
                || description_matcher.find()
                || image_matcher.find()
                || ingredients_matcher.find()) {
            if(mainName_matcher.find()  && null != mainName_matcher.group(0))
                System.out.println(mainName_matcher.group(0));

            if(alsoKnownAs_matcher.find()  && null != alsoKnownAs_matcher.group(0))
                System.out.println(alsoKnownAs_matcher.group(0));

            if(placeOfOrigin_matcher.find()  && null != placeOfOrigin_matcher.group(0))
                System.out.println(placeOfOrigin_matcher.group(0));

            if(description_matcher.find()  && null != description_matcher.group(0))
                System.out.println(description_matcher.group(0));

            if(image_matcher.find()  && null != image_matcher.group(0))
                System.out.println(image_matcher.group(0));

            if(ingredients_matcher.find()  && null != ingredients_matcher.group(0))
                System.out.println(ingredients_matcher.group(0));
        }
        ****/

        return objSandwich;
    }
}
