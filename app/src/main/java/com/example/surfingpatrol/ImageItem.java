package com.example.surfingpatrol;

public class ImageItem {
    String publisher;
    String beach_name;
    String image_url;
    String description;

    public ImageItem(String publisher,String beach_name, String image_url, String description)
    {
        this.publisher = publisher;
        this.beach_name = beach_name;
        this.image_url = image_url;
        this.description = description;
    }
    public ImageItem(){};

    public String getPublisher()
    {
        return publisher;
    }
    public String getBeach_name()
    {
        return beach_name;
    }
    public String getImage_url()
    {
        return image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setBeach_name(String beach_name) {
        this.beach_name = beach_name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
