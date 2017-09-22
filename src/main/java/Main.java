import task_options.UrlChecker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

import static j2html.TagCreator.*;

public class Main {
    public static void main(String[] args){
        try {
//            String method = "OPTIONS";
//            UrlChecker.sendRequest("http://mail.ru",method).print();
//            UrlChecker.sendRequest("http://ya.ru/",method).print();
//            UrlChecker.sendRequest("http://www.rambler.ru/",method).print();
//            UrlChecker.sendRequest("https://www.google.ru/",method).print();
//            UrlChecker.sendRequest("https://github.com/",method).print();
//            UrlChecker.sendRequest("https://ru.linkedin.com/",method).print();
//            UrlChecker.sendRequest("http://apple.com/",method).print();
//
//            method = "HEAD";
//            UrlChecker.sendRequest("http://vk.com",method).print();
//            UrlChecker.sendRequest("http://apple.com/",method).print();
//            UrlChecker.sendRequest("http://www.msn.com/",method).print();
//
//            method = "GET";
//            UrlChecker.sendRequest("http://yandex.ru",method).print();
//            UrlChecker.sendRequest("http://google.com",method).print();
//
//            method = "POST";
//            UrlChecker.sendRequest("http://yandex.ru",method).print();
//            UrlChecker.sendRequest("http://google.com",method).print();
//
//            System.out.println("\n\n\nVK API\n\n\n");
//
//            UrlChecker.sendRequest("https://api.vk.com/method/users.get?user_ids=1&fields=sex,photo_max,bdate,education",
//                    "GET").print();
//            UrlChecker.sendRequest("https://api.vk.com/method/wall.get?owner_id=1&count=10&access_token=31cb22ce31cb22ce31cb22ce1631955db6331cb31cb22ce680f6d0a6958c1ef6300606b",
//                    "GET").print();
//            UrlChecker.sendRequest("https://api.vk.com/method/database.getCities?country_id=1",
//                    "GET").print();
//            UrlChecker.sendRequest("https://api.vk.com/method/database.getFaculties?university_id=250",
//                    "GET").print();
//            UrlChecker.sendRequest("https://api.vk.com/method/wall.post?owner_id=95549092&message=\"кек\"&access_token=8a3e3a050e1721d4de980657a9a4bd4441451ece425faac634a01b20fbec1c8afe035380f1cd08bbc03eb",
//                    "GET").print();
//
//            System.out.println("\n\n\nPUT DELETE\n\n\n");
//
//            UrlChecker.sendRequest("https://jsonplaceholder.typicode.com/posts/2",
//                    "PUT").print();
//            UrlChecker.sendRequest("https://jsonplaceholder.typicode.com/posts/2",
//                    "DELETE").print();


            String htmlpage = html(
                    head(
                            title("Title"),
                            link().withRel("stylesheet").withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),
                            script().withSrc("https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"),
                            script().withSrc("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js")
                    ),
                    body(
                            h1("WEB Лабораторная №1"),
                            div(
                                    a()
                                            .attr("data-toggle","collapse")
                                            .withHref("#demo")
                                            .withClass("btn btn-info")
                                            .withText("CLICK!!!"),
                                    div()
                                            .withText("bla-bla")
                                            .withId("demo")
                                            .withClass("collapse in")
                            ).withClass("container")
                    )
            ).render();

            File html = new File(".","index.html");
            Files.deleteIfExists(html.toPath());

            html.createNewFile();
            FileWriter fileWriter = new FileWriter(html);
            fileWriter.write(htmlpage);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
