package org.lesson.java.thymeleaf.best_of_the_year.Classes;

public class Song {
    
    private int id;
    private String title;
    
    public Song(int id, String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    };

    public String getTitle() {
        return title;
    };

    @Override
    public String toString() {
        return this.title;
    }

}
