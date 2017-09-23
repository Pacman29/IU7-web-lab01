package ru.web;

import java.io.IOException;

import static j2html.TagCreator.*;

public class Task {
    public static String go(){
        try {

            String method = "OPTIONS";
            SectionCreator sectionOptions = new SectionCreator();
            sectionOptions.add(UrlChecker.sendRequest("http://mail.ru",method));
            sectionOptions.add(UrlChecker.sendRequest("http://ya.ru/",method));
            sectionOptions.add(UrlChecker.sendRequest("http://www.rambler.ru/",method));
            sectionOptions.add(UrlChecker.sendRequest("https://www.google.ru/",method));
            sectionOptions.add(UrlChecker.sendRequest("https://github.com/",method));
            sectionOptions.add(UrlChecker.sendRequest("https://ru.linkedin.com/",method));
            sectionOptions.add(UrlChecker.sendRequest("http://apple.com/",method));


            method = "HEAD";
            SectionCreator sectionHead = new SectionCreator();
            sectionHead.add(UrlChecker.sendRequest("http://vk.com",method));
            sectionHead.add(UrlChecker.sendRequest("http://apple.com/",method));
            sectionHead.add(UrlChecker.sendRequest("http://www.msn.com/",method));

            method = "GET";
            SectionCreator sectionGet = new SectionCreator();
            sectionGet.add(UrlChecker.sendRequest("http://yandex.ru",method));
            sectionGet.add(UrlChecker.sendRequest("http://google.com",method));

            method = "POST";
            SectionCreator sectionPost = new SectionCreator();
            sectionPost.add(UrlChecker.sendRequest("http://yandex.ru",method));
            sectionPost.add(UrlChecker.sendRequest("http://google.com",method));

            SectionCreator sectionVKapi = new SectionCreator();
            sectionVKapi.add(UrlChecker.sendRequest("https://api.vk.com/method/users.get?user_ids=1&fields=sex,photo_max,bdate,education",
                    "GET"));
            sectionVKapi.add(UrlChecker.sendRequest("https://api.vk.com/method/wall.get?owner_id=1&count=10&access_token=31cb22ce31cb22ce31cb22ce1631955db6331cb31cb22ce680f6d0a6958c1ef6300606b",
                    "GET"));
            sectionVKapi.add(UrlChecker.sendRequest("https://api.vk.com/method/database.getCities?country_id=1",
                    "GET"));
            sectionVKapi.add(UrlChecker.sendRequest("https://api.vk.com/method/database.getFaculties?university_id=250",
                    "GET"));
            sectionVKapi.add(UrlChecker.sendRequest("https://api.vk.com/method/wall.post?owner_id=95549092&message=\"кек\"&access_token=8a3e3a050e1721d4de980657a9a4bd4441451ece425faac634a01b20fbec1c8afe035380f1cd08bbc03eb",
                    "GET"));

            SectionCreator sectionRESTserver = new SectionCreator();
            sectionRESTserver.add(UrlChecker.sendRequest("https://jsonplaceholder.typicode.com/posts/2",
                    "PUT"));
            sectionRESTserver.add(UrlChecker.sendRequest("https://jsonplaceholder.typicode.com/posts/2",
                    "DELETE"));


            String htmlpage = html(
                    head(
                            title("WEB"),
                            link().withRel("stylesheet").withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),
                            script().withSrc("https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"),
                            script().withSrc("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"),
                            style(".my_btn {" +
                                    "width: -webkit-fill-available" +
                                    "}" +
                                    ".my_title {" +
                                    "text-align: -webkit-center" +
                                    "}")
                    ),
                    body(
                            h1("WEB. Лабораторная №1").withClass("my_title"),
                            div(
                                sectionOptions.getHtml("OPTIONS","Используется для определения возможностей веб-сервера или параметров\n" +
                                        "соединения для конкретного ресурса. В ответ серверу следует включить\n" +
                                        "заголовок Allow со списком поддерживаемых методов."),
                                sectionHead.getHtml("HEAD","Запрос HEAD обычно применяется для\n" +
                                        "извлечения метаданных, проверки наличия ресурса."),
                                sectionGet.getHtml("GET","Используется для запроса содержимого указанного ресурса. С помощью\n" +
                                        "метода GET можно также начать какой-либо процесс."),
                                sectionPost.getHtml("POST","Применяется для передачи пользовательских данных заданному ресурсу."),
                                sectionVKapi.getHtml("VK_API","Использование методов VK api"),
                                sectionRESTserver.getHtml("RESTserver","REST сервер, поддерживающий PUT и DELETE.")
                            ).withClass("row")
                    ).withClass("container")
            ).render();
            return htmlpage;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
