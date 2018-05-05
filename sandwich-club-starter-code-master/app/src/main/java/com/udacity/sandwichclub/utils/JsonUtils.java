package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        // Convert JSON string to JSONObject
        JSONObject jsonObject;
        Sandwich objSandwich =  new Sandwich();
        String NAME = "name";
        String PLACE_OF_ORIGIN = "placeOfOrigin";
        String DESC = "description";
        String IMAGE = "image";
        String INGREDIENTS = "ingredients";
        String ALL_SO_KNOWN_AS = "alsoKnownAs";

        try {
            jsonObject = new JSONObject(json);
            if( jsonObject != null && jsonObject.length() > 0) {

                if (jsonObject.has(INGREDIENTS)) {
                    List<String> list = new ArrayList<>();
                    JSONArray jsonArray = (JSONArray) jsonObject.get(INGREDIENTS);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        list.add(jsonArray.getString(i));
                        objSandwich.setIngredients(list);
                    }
                }

                if (jsonObject.has(NAME)) {
                    List<String> list = new ArrayList<>();
                    JSONObject  msg = (JSONObject)jsonObject.get(NAME);

                    objSandwich.setMainName(msg.get("mainName").toString());

                    JSONArray jsonArray = ((JSONArray)msg.get(ALL_SO_KNOWN_AS));
                        for (int j = 0; j < jsonArray.length(); j++) {
                            list.add(jsonArray.getString(j));
                            objSandwich.setAlsoKnownAs(list);
                        }
                }


                if (jsonObject.has(IMAGE)) {
                    objSandwich.setImage(jsonObject.getString(IMAGE));
                }

                if (jsonObject.has(DESC)) {
                    objSandwich.setDescription(jsonObject.getString(DESC));
                }

                if (jsonObject.has(PLACE_OF_ORIGIN)) {
                    objSandwich.setPlaceOfOrigin(jsonObject.getString(PLACE_OF_ORIGIN));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return objSandwich;
    }
}
