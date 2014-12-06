package me.aerovulpe.watportal.resources.food.products;

import org.json.JSONException;
import org.json.JSONObject;

import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.resources.Resource;

import static me.aerovulpe.watportal.constants.Constants.CALCIUM_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.CALORIES_KEY;
import static me.aerovulpe.watportal.constants.Constants.CARBO_FIBRE_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.CARBO_FIBRE_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.CARBO_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.CARBO_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.CARBO_SUGARS_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.CHOLESTEROL_MG_KEY;
import static me.aerovulpe.watportal.constants.Constants.DIET_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.DIET_TYPE_KEY;
import static me.aerovulpe.watportal.constants.Constants.FAT_SATURATED_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.FAT_SATURATED_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.FAT_TRANS_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.FAT_TRANS_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.INGREDIENTS_KEY;
import static me.aerovulpe.watportal.constants.Constants.IRON_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.MICRO_NUTRIENTS_KEY;
import static me.aerovulpe.watportal.constants.Constants.PRODUCT_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.PRODUCT_NAME_KEY;
import static me.aerovulpe.watportal.constants.Constants.PROTEIN_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.SERVING_SIZE_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.SERVING_SIZE_KEY;
import static me.aerovulpe.watportal.constants.Constants.SERVING_SIZE_ML_KEY;
import static me.aerovulpe.watportal.constants.Constants.SODIUM_MG_KEY;
import static me.aerovulpe.watportal.constants.Constants.SODIUM_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.TIPS_KEY;
import static me.aerovulpe.watportal.constants.Constants.TOTAL_FAT_G_KEY;
import static me.aerovulpe.watportal.constants.Constants.TOTAL_FAT_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.VITAMIN_A_PERCENT_KEY;
import static me.aerovulpe.watportal.constants.Constants.VITAMIN_C_PERCENT_KEY;

public class WatProduct implements WatObject {
    private Data data;
    private Meta meta;

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public Resource getResourceType() {
        return Resource.FOOD_PRODUCTS;
    }

    public static class Data {
        private int calcium_percent;
        private int calories;
        private int carbo_fibre_g;
        private int carbo_fibre_percent;
        private int carbo_g;
        private int carbo_percent;
        private int carbo_sugars_g;
        private int cholesterol_mg;
        private int diet_id;
        private String diet_type;
        private int fat_saturated_g;
        private int fat_saturated_percent;
        private int fat_trans_g;
        private int fat_trans_percent;
        private String ingredients;
        private int iron_percent;
        private String micro_nutrients;
        private int product_id;
        private String product_name;
        private int protein_g;
        private String serving_size;
        private int serving_size_g;
        private int serving_size_ml;
        private int sodium_mg;
        private int sodium_percent;
        private String tips;
        private int total_fat_g;
        private int total_fat_percent;
        private int vitamin_a_percent;
        private int vitamin_c_percent;

        public int getCalcium_percent() {
            return this.calcium_percent;
        }

        public void setCalcium_percent(int calcium_percent) {
            this.calcium_percent = calcium_percent;
        }

        public int getCalories() {
            return this.calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public int getCarbo_fibre_g() {
            return this.carbo_fibre_g;
        }

        public void setCarbo_fibre_g(int carbo_fibre_g) {
            this.carbo_fibre_g = carbo_fibre_g;
        }

        public int getCarbo_fibre_percent() {
            return this.carbo_fibre_percent;
        }

        public void setCarbo_fibre_percent(int carbo_fibre_percent) {
            this.carbo_fibre_percent = carbo_fibre_percent;
        }

        public int getCarbo_g() {
            return this.carbo_g;
        }

        public void setCarbo_g(int carbo_g) {
            this.carbo_g = carbo_g;
        }

        public int getCarbo_percent() {
            return this.carbo_percent;
        }

        public void setCarbo_percent(int carbo_percent) {
            this.carbo_percent = carbo_percent;
        }

        public int getCarbo_sugars_g() {
            return this.carbo_sugars_g;
        }

        public void setCarbo_sugars_g(int carbo_sugars_g) {
            this.carbo_sugars_g = carbo_sugars_g;
        }

        public int getCholesterol_mg() {
            return this.cholesterol_mg;
        }

        public void setCholesterol_mg(int cholesterol_mg) {
            this.cholesterol_mg = cholesterol_mg;
        }

        public int getDiet_id() {
            return this.diet_id;
        }

        public void setDiet_id(int diet_id) {
            this.diet_id = diet_id;
        }

        public String getDiet_type() {
            return this.diet_type;
        }

        public void setDiet_type(String diet_type) {
            this.diet_type = diet_type;
        }

        public int getFat_saturated_g() {
            return this.fat_saturated_g;
        }

        public void setFat_saturated_g(int fat_saturated_g) {
            this.fat_saturated_g = fat_saturated_g;
        }

        public int getFat_saturated_percent() {
            return this.fat_saturated_percent;
        }

        public void setFat_saturated_percent(int fat_saturated_percent) {
            this.fat_saturated_percent = fat_saturated_percent;
        }

        public int getFat_trans_g() {
            return this.fat_trans_g;
        }

        public void setFat_trans_g(int fat_trans_g) {
            this.fat_trans_g = fat_trans_g;
        }

        public int getFat_trans_percent() {
            return this.fat_trans_percent;
        }

        public void setFat_trans_percent(int fat_trans_percent) {
            this.fat_trans_percent = fat_trans_percent;
        }

        public String getIngredients() {
            return this.ingredients;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }

        public int getIron_percent() {
            return this.iron_percent;
        }

        public void setIron_percent(int iron_percent) {
            this.iron_percent = iron_percent;
        }

        public String getMicro_nutrients() {
            return this.micro_nutrients;
        }

        public void setMicro_nutrients(String micro_nutrients) {
            this.micro_nutrients = micro_nutrients;
        }

        public int getProduct_id() {
            return this.product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getProduct_name() {
            return this.product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public int getProtein_g() {
            return this.protein_g;
        }

        public void setProtein_g(int protein_g) {
            this.protein_g = protein_g;
        }

        public String getServing_size() {
            return this.serving_size;
        }

        public void setServing_size(String serving_size) {
            this.serving_size = serving_size;
        }

        public int getServing_size_g() {
            return this.serving_size_g;
        }

        public void setServing_size_g(int serving_size_g) {
            this.serving_size_g = serving_size_g;
        }

        public int getServing_size_ml() {
            return this.serving_size_ml;
        }

        public void setServing_size_ml(int serving_size_ml) {
            this.serving_size_ml = serving_size_ml;
        }

        public int getSodium_mg() {
            return this.sodium_mg;
        }

        public void setSodium_mg(int sodium_mg) {
            this.sodium_mg = sodium_mg;
        }

        public int getSodium_percent() {
            return this.sodium_percent;
        }

        public void setSodium_percent(int sodium_percent) {
            this.sodium_percent = sodium_percent;
        }

        public String getTips() {
            return this.tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public int getTotal_fat_g() {
            return this.total_fat_g;
        }

        public void setTotal_fat_g(int total_fat_g) {
            this.total_fat_g = total_fat_g;
        }

        public int getTotal_fat_percent() {
            return this.total_fat_percent;
        }

        public void setTotal_fat_percent(int total_fat_percent) {
            this.total_fat_percent = total_fat_percent;
        }

        public int getVitamin_a_percent() {
            return this.vitamin_a_percent;
        }

        public void setVitamin_a_percent(int vitamin_a_percent) {
            this.vitamin_a_percent = vitamin_a_percent;
        }

        public int getVitamin_c_percent() {
            return this.vitamin_c_percent;
        }

        public void setVitamin_c_percent(int vitamin_c_percent) {
            this.vitamin_c_percent = vitamin_c_percent;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "calcium_percent=" + calcium_percent +
                    ", calories=" + calories +
                    ", carbo_fibre_g='" + carbo_fibre_g + '\'' +
                    ", carbo_fibre_percent='" + carbo_fibre_percent + '\'' +
                    ", carbo_g=" + carbo_g +
                    ", carbo_percent=" + carbo_percent +
                    ", carbo_sugars_g=" + carbo_sugars_g +
                    ", cholesterol_mg=" + cholesterol_mg +
                    ", diet_id=" + diet_id +
                    ", diet_type='" + diet_type + '\'' +
                    ", fat_saturated_g=" + fat_saturated_g +
                    ", fat_saturated_percent=" + fat_saturated_percent +
                    ", fat_trans_g='" + fat_trans_g + '\'' +
                    ", fat_trans_percent='" + fat_trans_percent + '\'' +
                    ", ingredients='" + ingredients + '\'' +
                    ", iron_percent=" + iron_percent +
                    ", micro_nutrients='" + micro_nutrients + '\'' +
                    ", product_id=" + product_id +
                    ", product_name='" + product_name + '\'' +
                    ", protein_g=" + protein_g +
                    ", serving_size='" + serving_size + '\'' +
                    ", serving_size_g='" + serving_size_g + '\'' +
                    ", serving_size_ml='" + serving_size_ml + '\'' +
                    ", sodium_mg=" + sodium_mg +
                    ", sodium_percent=" + sodium_percent +
                    ", tips='" + tips + '\'' +
                    ", total_fat_g=" + total_fat_g +
                    ", total_fat_percent=" + total_fat_percent +
                    ", vitamin_a_percent=" + vitamin_a_percent +
                    ", vitamin_c_percent=" + vitamin_c_percent +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatProduct{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatProduct parse(Meta meta, JSONObject dataObject) throws JSONException {
        WatProduct watProduct = new WatProduct();

        Data data = new Data();

        data.setProduct_id(dataObject.getInt(PRODUCT_ID_KEY));
        data.setProduct_name(dataObject.getString(PRODUCT_NAME_KEY));
        data.setIngredients(dataObject.getString(INGREDIENTS_KEY));
        data.setServing_size(dataObject.getString(SERVING_SIZE_KEY));
        data.setMicro_nutrients(dataObject.getString(MICRO_NUTRIENTS_KEY));
        data.setTips(dataObject.getString(TIPS_KEY));
        data.setDiet_type(dataObject.getString(DIET_TYPE_KEY));
        data.setDiet_id(dataObject.getInt(DIET_ID_KEY));

        data.setServing_size_ml(dataObject.optInt(SERVING_SIZE_ML_KEY));
        data.setServing_size_g(dataObject.optInt(SERVING_SIZE_G_KEY));
        data.setCalories(dataObject.optInt(CALORIES_KEY));
        data.setTotal_fat_g(dataObject.optInt(TOTAL_FAT_G_KEY));
        data.setTotal_fat_percent(dataObject.optInt(TOTAL_FAT_PERCENT_KEY));
        data.setFat_saturated_g(dataObject.optInt(FAT_SATURATED_G_KEY));
        data.setFat_saturated_percent(dataObject.optInt(FAT_SATURATED_PERCENT_KEY));
        data.setFat_trans_g(dataObject.optInt(FAT_TRANS_G_KEY));
        data.setFat_trans_percent(dataObject.optInt(FAT_TRANS_PERCENT_KEY));
        data.setCholesterol_mg(dataObject.optInt(CHOLESTEROL_MG_KEY));
        data.setSodium_mg(dataObject.optInt(SODIUM_MG_KEY));
        data.setSodium_percent(dataObject.optInt(SODIUM_PERCENT_KEY));
        data.setCarbo_g(dataObject.optInt(CARBO_G_KEY));
        data.setCarbo_percent(dataObject.optInt(CARBO_PERCENT_KEY));
        data.setCarbo_fibre_g(dataObject.optInt(CARBO_FIBRE_G_KEY));
        data.setCarbo_fibre_percent(dataObject.optInt(CARBO_FIBRE_PERCENT_KEY));
        data.setCarbo_sugars_g(dataObject.optInt(CARBO_SUGARS_G_KEY));
        data.setProtein_g(dataObject.optInt(PROTEIN_G_KEY));
        data.setVitamin_a_percent(dataObject.optInt(VITAMIN_A_PERCENT_KEY));
        data.setVitamin_c_percent(dataObject.optInt(VITAMIN_C_PERCENT_KEY));
        data.setCalcium_percent(dataObject.optInt(CALCIUM_PERCENT_KEY));
        data.setIron_percent(dataObject.optInt(IRON_PERCENT_KEY));


        watProduct.setMeta(meta);
        watProduct.setData(data);

        return watProduct;
    }
}
