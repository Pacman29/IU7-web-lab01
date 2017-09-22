package ru.web;

import static j2html.TagCreator.*;
import j2html.tags.ContainerTag;

import java.util.ArrayList;

import static j2html.TagCreator.div;
import static j2html.TagCreator.each;

public class SectionCreator {
    ArrayList<Request> requests;

    public SectionCreator() {
        this.requests = new ArrayList<>();
    }

    public ContainerTag getHtml(String title, String text){
        return div(
                a()
                        .attr("data-toggle","collapse")
                        .withHref("#section-"+title)
                        .withClass("btn btn-info my_btn")
                        .withText(title),
                div(
                        hr(),
                        p(text),
                        hr(),
                        each(this.requests, (request) -> div(
                                p("URL: " + request.getUrl()),
                                p("State: "+ Integer.toString(request.getState())),
                                p("Head: "),
                                code(request.getHead()),
                                p("Body: "),
                                code(request.getBody()),
                                hr()
                                )
                        )
                ).withClass("collapse").withId("section-"+title)
        );
    }
    
    public void add(Request request){
        this.requests.add(request);
    }
}
