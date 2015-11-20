package my.example;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
public class SlangsDaoGenerator {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.dolphinapps.greendao.model");

        Entity favorite = schema.addEntity("Favorite");
        favorite.addIdProperty().autoincrement().primaryKey();
        favorite.addStringProperty("slang");
        favorite.addStringProperty("meaning");
        new DaoGenerator().generateAll(schema, "../app/src/main/java");


    }
}
