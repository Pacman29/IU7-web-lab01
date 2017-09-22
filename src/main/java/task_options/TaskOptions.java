package task_options;

import j2html.TagCreator;
import j2html.tags.ContainerTag;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

import static j2html.TagCreator.div;

public class TaskOptions {
    ArrayList<Request> requests;
    
    
    public ContainerTag getHtml(){
        return div(
                each(this.requests, request ->
                        p(request.getUrl())
                    )
        );
    }
    
    public void add(Request request){
        this.requests.add(request);
    }
}
