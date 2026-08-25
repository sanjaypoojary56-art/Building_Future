package com.example.demo.controllers;

import com.example.demo.ChatRequests.AIChatRequest;
import com.example.demo.services.AIChatService;
import com.example.demo.Responses.AIResponse;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Responses.ResponseToReactFromAi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
@RestController
public class AIChatController {
    BeanOutputConverter<AIResponse> converter=new BeanOutputConverter<>(AIResponse.class);
    @Autowired
    private AIChatService aw;
    @Autowired
    private Repo1 repo;
    private  ChatClient chatClient;
    public AIChatController(ChatClient.Builder builder)
    {
        this.chatClient=builder.build();
    }
    @PostMapping("/ai/chat")
    public ResponseToReactFromAi generateResponse(@RequestBody AIChatRequest request) {
        String format = converter.getFormat();
        String message = request.getMessage();
        System.out.println("this prints fgirst");
        try {
            String response = chatClient.prompt().system("""
                    You are hired as a ai assistant for my job portal,intents are SEARCH_JOBS,APPLY_JOB,MY_APPLICATIONS,CHECK_APPLICATION_STATUS(For only this even  if param,ters not specified dont ask for parameters just
                    
                    set the message property to SEARCH_WITHOUT_PARAMETERS )
                    ,SKILL_RECOMENDATIONS,SKILL_GAP,SEARCH_JOB_MYSKILLS
                     if general set it to TEXT ,AND FOR THE INTENTS LIKE CHECK_APPLICATONS WE NEED SOME PARAMETERS LIKE APPLICATION ID ,
                      AS AI YOU KNOW ABOUT IT SO IF 
                     IT IS NOT PRESENT IN MESSAGE ASK USER TO SPECIFY REQUIRED PARAMETERS ACCORDING TO YOU
                     parameters from user message and fill it according to my fields.message is you message to user as a response addition to data
                    """ + format).user(message).call().content();
            System.out.println("this prints next" + response);
            return aw.senddata(converter.convert(response));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  aw.senddata(converter.convert("sfdsd"));

        }

    }



}
