// @SOURCE:E:/workspace/play_ws/jobs/conf/routes
// @HASH:c5f4fd12b79e6565326531b69a23e846f5761f00
// @DATE:Thu Aug 29 18:14:13 GMT+04:00 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:1
private[this] lazy val controllers_PickLists_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:2
private[this] lazy val controllers_PickLists_preview1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("preview"))))
        

// @LINE:3
private[this] lazy val controllers_PickLists_sendAsync2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sendasync"))))
        

// @LINE:4
private[this] lazy val controllers_Dashboard_backlog3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("backlog/"),DynamicPart("warehouse", """[^/]+""",true))))
        

// @LINE:5
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.PickLists.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """preview""","""controllers.PickLists.preview(warehouse:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sendasync""","""controllers.PickLists.sendAsync(warehouse:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """backlog/$warehouse<[^/]+>""","""controllers.Dashboard.backlog(warehouse:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:1
case controllers_PickLists_index0(params) => {
   call { 
        invokeHandler(controllers.PickLists.index, HandlerDef(this, "controllers.PickLists", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:2
case controllers_PickLists_preview1(params) => {
   call(params.fromQuery[String]("warehouse", None)) { (warehouse) =>
        invokeHandler(controllers.PickLists.preview(warehouse), HandlerDef(this, "controllers.PickLists", "preview", Seq(classOf[String]),"GET", """""", Routes.prefix + """preview"""))
   }
}
        

// @LINE:3
case controllers_PickLists_sendAsync2(params) => {
   call(params.fromQuery[String]("warehouse", None)) { (warehouse) =>
        invokeHandler(controllers.PickLists.sendAsync(warehouse), HandlerDef(this, "controllers.PickLists", "sendAsync", Seq(classOf[String]),"POST", """""", Routes.prefix + """sendasync"""))
   }
}
        

// @LINE:4
case controllers_Dashboard_backlog3(params) => {
   call(params.fromPath[String]("warehouse", None)) { (warehouse) =>
        invokeHandler(controllers.Dashboard.backlog(warehouse), HandlerDef(this, "controllers.Dashboard", "backlog", Seq(classOf[String]),"GET", """""", Routes.prefix + """backlog/$warehouse<[^/]+>"""))
   }
}
        

// @LINE:5
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        