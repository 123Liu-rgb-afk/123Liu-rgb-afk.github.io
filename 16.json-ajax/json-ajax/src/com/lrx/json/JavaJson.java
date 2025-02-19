package com.lrx.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class JavaJson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Book book = new Book(1, "西游记");
        //把java对象转为json
        String strBook = gson.toJson(book);
        System.out.println(strBook);

        //把json字符串转为java对象
        Book objBook = gson.fromJson(strBook, Book.class);
        System.out.println(objBook);



        //创建List对象
        List<Book> listBooks = new ArrayList<>();
        listBooks.add(new Book(2,"水浒传"));
        listBooks.add(new Book(3,"三国演义"));

        //把List对象转为json 字符串
        String strList = gson.toJson(listBooks);
        System.out.println(strList);


        //把json 字符串转为list对象
        //匿名内部类访问protected，隐式构造器，super()
        Class<? super List<Book>> rawType = new TypeToken<List<Book>>() {
        }.getRawType();

        Object object = gson.fromJson(strList, rawType);
        System.out.println(object);


    }
}
