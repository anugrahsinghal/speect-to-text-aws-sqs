package com.cogito.hackerearth.service;

import com.cogito.hackerearth.service.internal.AudioEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageReceiver {

    private final SpeechToText speechToText;

    @Slf4j
    @Service
    public class MessageReceiver {

        @SqsListener(value = "testObjectQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
        public void receiveMessage(final AudioEvent message,
                                   @Header("SenderId") String senderId) {
            log.info("message received {} {}", senderId, message);

            speechToText.convert(message.getInput());


        }
    }
}