//package com.santu.dto.response;
//
//public class TestimonialResponse {
//
//    private Long id;
//    private String name;
//    private String role;
//    private int rating;
//    private String feedback;
//    private String imagePath; // Path to the image
//
//    public TestimonialResponse(Long id, String name, String role, int rating, String feedback, String imagePath) {
//        this.id = id;
//        this.name = name;
//        this.role = role;
//        this.rating = rating;
//        this.feedback = feedback;
//        this.imagePath = imagePath;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public String getFeedback() {
//        return feedback;
//    }
//
//    public void setFeedback(String feedback) {
//        this.feedback = feedback;
//    }
//
//    public String getImagePath() {
//        return imagePath;
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
//}


package com.santu.dto.response;

public record TestimonialResponse(Long id, String name, String role, int rating, String feedback, String imagePath) {
}
