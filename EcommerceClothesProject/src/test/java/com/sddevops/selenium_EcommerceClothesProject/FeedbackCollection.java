package com.sddevops.selenium_EcommerceClothesProject;

import java.util.*;

public class FeedbackCollection {

    private ArrayList<Feedback> feedbacks = new ArrayList<>();
    private int capacity;

    public FeedbackCollection() {
    	/*songs.add(new Song("0001","good 4 u","Olivia Rodrigo",3.59));
    	songs.add(new Song("0002","Peaches","Justin Bieber",3.18));
    	songs.add(new Song("0003","MONTERO","Lil Nas X",2.3));
    	songs.add(new Song("0004","bad guy","Billie Eilish",3.14));*/

        this.capacity = 20;
    }

    public FeedbackCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void addFeedback(Feedback feedback) {
    	if(feedbacks.size() != capacity) {
    		feedbacks.add(feedback);
    	}
    }
    
    
    public Feedback findFeedbacksById(int id) {
    	for (Feedback s : feedbacks) { 		      
            if(s.getFeedback().equals(id)) return s;
       }
    	return null;
    }

 
}
