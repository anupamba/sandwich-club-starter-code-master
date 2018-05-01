package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        //finish();
        //Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {

        TextView origin = findViewById(R.id.origin_tv);
        TextView desc = findViewById(R.id.description_tv);

        origin.setText(sandwich.getPlaceOfOrigin() != null ? sandwich.getPlaceOfOrigin() : "Not Available");
        desc.setText(sandwich.getDescription() != null ? sandwich.getDescription() :"Not Available");

        // Ingredients
        if(null != sandwich.getIngredients()
                && sandwich.getIngredients().size() > 0 ) {
            TextView ingredientTV = findViewById(R.id.ingredients_tv);
            StringBuilder strBulIngredient = new StringBuilder();
            for(int i = 0; i < sandwich.getIngredients().size(); i++) {
                ingredientTV.setText(strBulIngredient.append(sandwich.getIngredients().toArray()[i].toString()+"\n"));
            }
        }

        // Also know as
        if(null != sandwich.getAlsoKnownAs()
                && sandwich.getAlsoKnownAs().size() > 0 ) {
            TextView alsoKnowTV = findViewById(R.id.also_known_tv);
            StringBuilder strBulAlsoKnow = new StringBuilder();
            for(int i = 0; i < sandwich.getAlsoKnownAs().size(); i++) {
                alsoKnowTV.setText(strBulAlsoKnow.append(sandwich.getAlsoKnownAs().toArray()[i].toString()+"\n"));
            }
        }
    }
}
