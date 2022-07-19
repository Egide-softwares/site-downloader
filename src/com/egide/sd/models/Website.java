package com.egide.sd.models;

import java.time.LocalDateTime;
import java.util.Set;

public class Website {
    private Long id;
    private String website_name;
    private LocalDateTime download_start_date_time;
    private LocalDateTime download_end_date_time;
    private long total_elapsed_time;
    private long total_downloaded_kilobytes;
    private Set<Link> links;

    public Website() {}

    public Website(Long id, String website_name, LocalDateTime download_start_date_time, LocalDateTime download_end_date_time, long total_elapsed_time, long total_downloaded_kilobytes) {
        this.id = id;
        this.website_name = website_name;
        this.download_start_date_time = download_start_date_time;
        this.download_end_date_time = download_end_date_time;
        this.total_elapsed_time = total_elapsed_time;
        this.total_downloaded_kilobytes = total_downloaded_kilobytes;
    }

    public Website(String website_name, LocalDateTime download_start_date_time, LocalDateTime download_end_date_time, long total_elapsed_time, long total_downloaded_kilobytes) {
        this.website_name = website_name;
        this.download_start_date_time = download_start_date_time;
        this.download_end_date_time = download_end_date_time;
        this.total_elapsed_time = total_elapsed_time;
        this.total_downloaded_kilobytes = total_downloaded_kilobytes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite_name() {
        return website_name;
    }

    public void setWebsite_name(String website_name) {
        this.website_name = website_name;
    }

    public LocalDateTime getDownload_start_date_time() {
        return download_start_date_time;
    }

    public void setDownload_start_date_time(LocalDateTime download_start_date_time) {
        this.download_start_date_time = download_start_date_time;
    }

    public LocalDateTime getDownload_end_date_time() {
        return download_end_date_time;
    }

    public void setDownload_end_date_time(LocalDateTime download_end_date_time) {
        this.download_end_date_time = download_end_date_time;
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

    public Set<Link> getLinks() {
		return links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	@Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", website_name='" + website_name + '\'' +
                ", download_start_date_time=" + download_start_date_time +
                ", download_end_date_time=" + download_end_date_time +
                ", total_elapsed_time=" + total_elapsed_time +
                ", total_downloaded_kilobytes=" + total_downloaded_kilobytes +
                '}';
    }
}
