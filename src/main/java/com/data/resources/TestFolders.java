package com.data.resources;

import com.utils.ResourceUtils;
import com.dto.Folder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestFolders {

    private final String prefix = "TestFolder_";

    @Bean(name="randomFolder")
    public Folder randomFolder()
    {
        Folder folder = new Folder();
        String suffix5 = ResourceUtils.generateRandomSuffix(5);
        String suffix20 = ResourceUtils.generateRandomSuffix(20);
//        String suffix5 = "blabla";
//        String suffix20 = "blablablabla";
        folder.setName(prefix+suffix5);
        folder.setDescription(prefix+suffix20);
        return folder;
    }

    @Bean(name="parentFolder")
    public Folder parent()
    {
        Folder folder = new Folder();
        folder.setName("Reports");
        folder.setDescription("Reports");
        return folder;
    }



}
