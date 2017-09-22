import task_options.UrlChecker;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            String method = "OPTIONS";
            UrlChecker.sendRequest("http://mail.ru",method).print();
            UrlChecker.sendRequest("http://ya.ru/",method).print();
            UrlChecker.sendRequest("http://www.rambler.ru/",method).print();
            UrlChecker.sendRequest("https://www.google.ru/",method).print();
            UrlChecker.sendRequest("https://github.com/",method).print();
            //UrlChecker.sendRequest("http://linkedin.com/",method).print();
            UrlChecker.sendRequest("http://apple.com/",method).print();

            method = "HEAD";
            UrlChecker.sendRequest("http://vk.com",method).print();
            UrlChecker.sendRequest("http://apple.com/",method).print();
            UrlChecker.sendRequest("http://www.msn.com/",method).print();

            method = "GET";
            UrlChecker.sendRequest("http://yandex.ru",method).print();
            UrlChecker.sendRequest("http://google.com",method).print();

            method = "POST";
            UrlChecker.sendRequest("http://yandex.ru",method).print();
            UrlChecker.sendRequest("http://google.com",method).print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
