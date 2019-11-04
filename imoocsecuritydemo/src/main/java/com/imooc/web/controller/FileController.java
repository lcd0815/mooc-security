package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @Author: 李存东
 * @Date: 2019/10/29
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileController {
    String folder = "C:\\javaCode\\mooc-security\\imoocsecuritydemo\\src\\main\\java\\com\\imooc\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File dest = new File(folder, new Date().getTime() + ".txt");
        //这里的做法:传来的文件写到本地的文件
        //实际开发一般把这个file转成流,写到阿里云oss或者fastDFS
//        file.getInputStream()
        file.transferTo(dest);
        return new FileInfo(dest.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream()

        ) {
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=text.txt");

            IOUtils.copy(inputStream, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
