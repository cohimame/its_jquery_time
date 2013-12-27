// @SOURCE:E:/workspace/play_ws/jobs/conf/routes
// @HASH:c5f4fd12b79e6565326531b69a23e846f5761f00
// @DATE:Thu Aug 29 18:14:13 GMT+04:00 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._


import Router.queryString


// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers {

// @LINE:3
// @LINE:2
// @LINE:1
class ReversePickLists {
    

// @LINE:2
def preview(warehouse:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "preview" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("warehouse", warehouse)))))
}
                                                

// @LINE:1
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:3
def sendAsync(warehouse:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "sendasync" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("warehouse", warehouse)))))
}
                                                
    
}
                          

// @LINE:5
class ReverseAssets {
    

// @LINE:5
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:4
class ReverseDashboard {
    

// @LINE:4
def backlog(warehouse:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "backlog/" + implicitly[PathBindable[String]].unbind("warehouse", URLEncoder.encode(warehouse, "utf-8")))
}
                                                
    
}
                          
}
                  


// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.javascript {

// @LINE:3
// @LINE:2
// @LINE:1
class ReversePickLists {
    

// @LINE:2
def preview : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PickLists.preview",
   """
      function(warehouse) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "preview" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("warehouse", warehouse)])})
      }
   """
)
                        

// @LINE:1
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PickLists.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:3
def sendAsync : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PickLists.sendAsync",
   """
      function(warehouse) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendasync" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("warehouse", warehouse)])})
      }
   """
)
                        
    
}
              

// @LINE:5
class ReverseAssets {
    

// @LINE:5
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:4
class ReverseDashboard {
    

// @LINE:4
def backlog : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Dashboard.backlog",
   """
      function(warehouse) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "backlog/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("warehouse", encodeURIComponent(warehouse))})
      }
   """
)
                        
    
}
              
}
        


// @LINE:5
// @LINE:4
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.ref {

// @LINE:3
// @LINE:2
// @LINE:1
class ReversePickLists {
    

// @LINE:2
def preview(warehouse:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PickLists.preview(warehouse), HandlerDef(this, "controllers.PickLists", "preview", Seq(classOf[String]), "GET", """""", _prefix + """preview""")
)
                      

// @LINE:1
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PickLists.index(), HandlerDef(this, "controllers.PickLists", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

// @LINE:3
def sendAsync(warehouse:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PickLists.sendAsync(warehouse), HandlerDef(this, "controllers.PickLists", "sendAsync", Seq(classOf[String]), "POST", """""", _prefix + """sendasync""")
)
                      
    
}
                          

// @LINE:5
class ReverseAssets {
    

// @LINE:5
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:4
class ReverseDashboard {
    

// @LINE:4
def backlog(warehouse:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Dashboard.backlog(warehouse), HandlerDef(this, "controllers.Dashboard", "backlog", Seq(classOf[String]), "GET", """""", _prefix + """backlog/$warehouse<[^/]+>""")
)
                      
    
}
                          
}
                  
      