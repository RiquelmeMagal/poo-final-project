package product;
import utils.RandomID;

public class Category {
    private String code;
    private String prefix;
    private String title;
    private String description;

    public Category(String title, String prefix, String description) {
        this.code = prefix + RandomID.randomWithoutLetters(4);
        this.title = title;
        this.prefix = prefix;
        this.description = description;
    
    }


    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDescription() {
        return description;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description.length() > 0 ? String.format("[%s]%s:%s", this.code, this.title, this.description) : String.format("[%s]%s",this.code, this.title);
    }
}
