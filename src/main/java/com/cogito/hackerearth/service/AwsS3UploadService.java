package com.cogito.hackerearth.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.cogito.hackerearth.config.AwsConfig;
import com.cogito.hackerearth.service.internal.HashGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
@Slf4j
@RequiredArgsConstructor
public class AwsS3UploadService implements UploadService {

    private final AmazonS3 amazonS3;
    private final AwsConfig awsConfig;
    private final HashGenerator hashGenerator;


    @Override
    public void uploadSpeech(Object input) {

        amazonS3.putObject(awsConfig.getBucketName(),
                hashGenerator.getNonRepeatableHash().toString(),
                // todo
                (InputStream) input,
                // todo
                objectMetadata((MultipartFile) input)
        );

    }


    private ObjectMetadata objectMetadata(MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();

        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        objectMetadata.getUserMetadata().put("extension", "mp4");

        return objectMetadata;
    }
}
