package com.tuv01.newssearch;

/**
 * Created by Tuv01 on 30.03.2018.
 */

/**
 * An {News} object contains information related to a single news.
 */
public class News {

    /** Title of the News */
    private String webTitle;
    /** Section of the News */
    private String sectionName;
    /** Author of the News */
    private String author;
    /** Publication Date of the News */
    private String webPublicationDate;
    /** Website URL of the News */
    private String webUrl;

    /**
     * Constructs a new {News} object.
     *
     * @param webTitle is the magnitude (size) of the news
     * @param sectionName is the location where the news happened
     * @param author is the author of the news
     * @param webPublicationDate is the publication date of the news
     * @param webUrl is the website URL to find more details about the news
     */
    public News(String webTitle, String sectionName, String author, String webPublicationDate, String webUrl) {
        this.webTitle = webTitle;
        this.sectionName = sectionName;
        this.author = author;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
    }
    //Getter
    /**
     * Returns the title of the news.
     */
    public String getWebTitle() {
        return webTitle;
    }
    /**
     * Returns the section name of the news.
     */
    public String getSectionName() {
        return sectionName;
    }
    /**
     * Returns the author of the news.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Returns the publication date of the news.
     */
    public String getWebPublicationDate() {
        return webPublicationDate;
    }
    /**
     * Returns the website URL to find more information about the news.
     */
    public String getWebUrl() {
        return webUrl;
    }
}