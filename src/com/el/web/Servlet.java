package com.el.web;

import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "ELServlet",urlPatterns = "/EL")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Successfully! By post");

        System.out.println(request.getContentType());//得到客户端发送过来内容的类型，application/json;charset=UTF-8
        System.out.println(request.getRemoteAddr());//得到客户端的ip地址

        request.setCharacterEncoding("UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(//使用字符流读取客户端发过来的数据
                request.getInputStream()));
        String line = null;
        StringBuffer s = new StringBuffer();
        while ((line = br.readLine()) != null) {
            s.append(line);
        }
        br.close();

        System.out.println(s.toString());//{"password":"123456","name":"admin"}
        response.getOutputStream().write("60".getBytes("UTF-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("Successfully! By get");
        response.getOutputStream().write("Successfully! By get".getBytes("utf-8"));

        System.out.println(request.getContentType());//得到客户端发送过来内容的类型，application/json;charset=UTF-8
        System.out.println(request.getRemoteAddr());//得到客户端的ip地址

        BufferedReader br = new BufferedReader(new InputStreamReader(//使用字符流读取客户端发过来的数据
                request.getInputStream()));
        String line = null;
        StringBuffer s = new StringBuffer();
        while ((line = br.readLine()) != null) {
            s.append(line);
        }
        br.close();

        System.out.println(s.toString());//{"password":"123456","name":"admin"}

        try {
            JSONObject json = new JSONObject(s.toString());//转化为jSONObject对象
            String name = json.getString("name");//从json对象中得到相应key的值
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");

            JSONObject rjson = new JSONObject();
            rjson.put("result", 10);//返回值

            System.out.println("rjson=" + rjson);
            // response.getWriter().write(rjson.toString());//向客户端发送一个带有json对象内容的响应
            response.getOutputStream().write(rjson.toString().getBytes("UTF-8"));//向客户端发送一个带有json对象内容的响应


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
