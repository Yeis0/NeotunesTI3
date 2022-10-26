package model;

public class Podcast extends Audio implements Playable {

    private String description;
    private Category category;

    public Podcast(String name, double duration, String url, String description, int category){
        super(name, duration, url);
        this.description = description;

        switch(category){
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

    public String playsStandar(){
        return "The podcast " + getName() + " is playing";
    }

    public String playsPremium(){
        return "The podcast " + getName() + " is playing";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    
}
