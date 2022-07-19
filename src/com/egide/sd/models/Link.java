package com.egide.sd.models;

public class Link {
	private Long id;
    private String link_name;
    private String url;
    private long total_elapsed_time;
    private long total_downloaded_kilobytes;
    private Website website;

   public Link(){}

    public Link(Long id, String link_name, String url, long total_elapsed_time, long total_downloaded_kilobytes, Website website) {
        this.id = id;
        this.link_name = link_name;
        this.url = url;
        this.total_elapsed_time = total_elapsed_time;
        this.total_downloaded_kilobytes = total_downloaded_kilobytes;
        this.website = website;
    }

    public Link(String link_name, String url, long total_elapsed_time, long total_downloaded_kilobytes, Website website) {
        this.link_name = link_name;
        this.url = url;
        this.total_elapsed_time = total_elapsed_time;
        this.total_downloaded_kilobytes = total_downloaded_kilobytes;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink_name() {
        return link_name;
    }

    public void setLink_name(String link_name) {
        this.link_name = link_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTotal_elapsed_time() {
        return total_elapsed_time;
    }

    public void setTotal_elapsed_time(long total_elapsed_time) {
        this.total_elapsed_time = total_elapsed_time;
    }

    public long getTotal_downloaded_kilobytes() {
        return total_downloaded_kilobytes;
    }

    public void setTotal_downloaded_kilobytes(long total_downloaded_kilobytes) {
        this.total_downloaded_kilobytes = total_downloaded_kilobytes;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", link_name='" + link_name + '\'' +
                ", url='" + url + '\'' +
                ", total_elapsed_time=" + total_elapsed_time +
                ", total_downloaded_kilobytes=" + total_downloaded_kilobytes +
                ", website=" + website.toString() +
                '}';
    }
}
