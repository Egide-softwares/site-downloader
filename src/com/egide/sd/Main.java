package com.egide.sd;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.egide.sd.utils.ConsoleColors;

public class Main {
	private static long filesCount = 1;
	private static String validAuthority;
	private static Set<String> downloadedURLS = new HashSet<String>();
	private static String downloadsBasePath = System.getProperty("user.home")+"/downloaded_sites/";
	
	public static boolean isExtLinkValid (String url){
        if(url.startsWith("//") || url.startsWith("#") || url.trim().contains("javascript:void(0)")) return false;
        return true;
    }

    public static void downloadLink(String url) throws Exception {
        System.out.println(ConsoleColors.GREEN_BOLD+"\nDownloading File: "+ filesCount + ConsoleColors.RESET);
        try{
            URL extURL = new URL(url);
            if(!extURL.getAuthority().equals(validAuthority)) return;
            String fileToDownload;
            String[] items = extURL.getFile().split("/");
            if(items.length > 0 && items[items.length-1].contains(".")){
            	fileToDownload = downloadsBasePath+extURL.getAuthority()+extURL.getPath();
            }else{
            	fileToDownload = downloadsBasePath+extURL.getAuthority()+extURL.getPath()+"/index.html";
            }
            ReadableByteChannel rbc = Channels.newChannel(extURL.openStream());
            File downloadedFile = new File(fileToDownload);
            if(!downloadedFile.exists()){
            	downloadedFile.getParentFile().mkdirs(); 
            	downloadedFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileToDownload);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
        	System.out.println("File size: "+ConsoleColors.YELLOW+(downloadedFile.length()/1024)+"Kb"+ConsoleColors.RESET);
        	System.out.println("Authority: "+extURL.getAuthority());
        	System.out.println(ConsoleColors.GREEN+"URL: "+url+ConsoleColors.RESET+"\n");
        	filesCount++;
        	downloadAllExtURLS(url);
        }catch (Exception e){
            System.out.println(ConsoleColors.RED+"🛑 Download failed.\n"+ConsoleColors.RESET);
        }
    }
    
    public static void downloadAllExtURLS(String mainURL) {
    	try {
    		System.gc();
            Document doc = Jsoup.connect(mainURL).get();
            Elements linksElements = doc.getElementsByAttribute("href");
            
            //deallocate memory of doc
            doc = null;
            
            for(Element link: linksElements){
                if(!isExtLinkValid(link.attr("href"))) continue;
                String url = link.absUrl("href").trim();
                URL parsedUrl = new URL(url);
                if(downloadedURLS.contains(url)) continue;
                downloadedURLS.add(url);
                if(!parsedUrl.getAuthority().equalsIgnoreCase(validAuthority)) {
                	continue;
                }
                downloadLink(url);
            }
		} catch (Exception e) {
			System.out.println("MESSAGE: "+e.getMessage()+"\n");
		}
    }

	public static void main(String[] args) {
		try {
			System.gc();
			System.out.println("\n======= SITE DOWNLOADER =========================");
			System.out.println("BY: "+ConsoleColors.GREEN_BOLD_BRIGHT+"Harerimana Egide <egideharerimana085@gmail.com>\n"+ConsoleColors.RESET);
			
			String mainURL;
			Scanner scanner = new Scanner(System.in);
			System.out.println(ConsoleColors.BLUE_BOLD+"Enter site URL (http/https): "+ConsoleColors.RESET);
			mainURL = scanner.next();
			scanner.close();
			
			System.out.println(ConsoleColors.BLUE_BOLD+"\nSTARTING DOWNLOAD..."+ConsoleColors.RESET);
			
			URL website = new URL(mainURL);
	        String fileToDownload;
	        if(!website.getFile().contains(".")){
	        	fileToDownload = downloadsBasePath+website.getAuthority()+website.getPath()+"/index.html";
	        }else{
	        	fileToDownload = downloadsBasePath+website.getAuthority()+website.getPath();
	        }
	        File downloadedFile = new File(fileToDownload);
	        if(!downloadedFile.exists()){
	        	downloadedFile.getParentFile().mkdirs(); 
	        	downloadedFile.createNewFile();
	        }
	        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
	        FileOutputStream fos = new FileOutputStream(fileToDownload);
	        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
			
			validAuthority = website.getAuthority();
			downloadedURLS.add(mainURL);
			
			System.out.println("\nURL: "+mainURL);
			System.out.println("Authority: "+website.getAuthority());
	        System.out.println("File size: "+ConsoleColors.YELLOW+downloadedFile.length()/1024 +"Kb"+ConsoleColors.RESET);
	        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"\nDownloading external links..."+ConsoleColors.RESET);
	        
	        downloadAllExtURLS(mainURL);
	        
		} catch (Exception e) {
			System.out.println("EXCEPTION: "+e.getMessage());
		}
	}

}
