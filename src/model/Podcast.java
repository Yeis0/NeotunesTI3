package model;

/**
 * <b>Podcast</b> is a class that represents a podcast of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Podcast extends Audio  {

    private String description;
    private Category category;

    /**
     * <b>Constructor</b> allows to create a Podcast's object.
     * 
     * @param name        is the podcast's name.
     * @param duration    is the podcast's duration.
     * @param url         is the podcast's url.
     * @param autor       is the podcast's autor.
     * @param description is the podcast's description.
     * @param category    is the podcast's category.
     */
    public Podcast(String name, int duration, String url, User autor, String description, int category) {
        super(name, duration, url, autor);
        this.description = description;

        switch (category) {
            case 1:
                this.category = Category.POLICY;
                break;
            case 2:
                this.category = Category.ENTERTAINMENT;
                break;
            case 3:
                this.category = Category.VIDEOGAMES;
                break;
            case 4:
                this.category = Category.FASHION;
                break;
        }
    }

    /**
     * <b>getDescription</b> allows to get the podcast's description.
     * 
     * @return String the podcast's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * <b>setDescription</b> allows to set the podcast's description.
     * 
     * @param description is the podcast's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <b>getCategory</b> allows to get the podcast's category.
     * 
     * @return Category the podcast's category.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * <b>setCategory</b> allows to set the podcast's category.
     * 
     * @param category is the podcast's category.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
