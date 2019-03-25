package cn.lijiahao.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lijiahao.demo.utils.ImageUploadUtil;


/**
*
*@Description 处理图片上传的controller层
*@author 李佳浩
*@Date 2018年11月9日 上午11:56:15
*/
@Controller
public class UploadImg {
	String dirPath = "uploadImages";//图片服务器名称
	/**
	 * 上传图片
	 * */
	@RequestMapping("/uploadImg.action")
	public void updateImage(HttpServletRequest request, HttpServletResponse response){
		try {
            ImageUploadUtil.ckeditor(request, response, dirPath);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}
