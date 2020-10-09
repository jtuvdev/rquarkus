package org.reactiveroute;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.quarkus.vertx.web.RouteFilter;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.Router;

@ApplicationScoped
@RouteBase(path="/reactiveRoute",produces = "text/html")
public class ReactiveRoute {
    
    
    //@Route(methods = HttpMethod.GET)
    @Route(path="/greeting", methods = HttpMethod.GET)
    public void helloRoutingContext(RoutingContext rc){
        rc.response().end("Hello reactive");
    }

    
    //@Route(methods = HttpMethod.GET)
    @Route(path="/hello", methods = HttpMethod.GET)
    public void helloRoutingExchange(RoutingExchange re){
        re.ok("Hello");
    }

    
    public void init (@Observes Router router){
        router.get("/bookreactive").handler(rc ->{
            rc.response().end("Book1");
        });
    }

    @RouteFilter
    public void myFilter(RoutingContext rc){
        rc.response().putHeader("test", "test");
        rc.next();
    }
}