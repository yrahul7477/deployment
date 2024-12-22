//package com.santu.dto.response;
//
//public class FAQResponse {
//    private Long id;
//    private String question;
//    private String answer;
//
//    // Constructor
//    public FAQResponse(Long id, String question, String answer) {
//        this.id = id;
//        this.question = question;
//        this.answer = answer;
//    }
//
//    // Getters
//    public Long getId() {
//        return id;
//    }
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//}


package com.santu.dto.response;

public record FAQResponse(Long id, String question, String answer) {
}
