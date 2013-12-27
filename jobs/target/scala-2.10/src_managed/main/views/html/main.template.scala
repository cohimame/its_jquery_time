
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""
<!DOCTYPE html>
<html>

  <head>
    <title>Pick list</title>
    <link rel="stylesheet" type="text/css" media="screen" href='"""),_display_(Seq[Any](/*7.66*/routes/*7.72*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*7.111*/("""'>
    <link rel="stylesheet" type="text/css" media="screen" href='"""),_display_(Seq[Any](/*8.66*/routes/*8.72*/.Assets.at("stylesheets/main.css"))),format.raw/*8.106*/("""'>
  </head>

  <body>

    <div class="screenshot">
      <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
          <div class="container">
            <a class="brand" href="#">"""),_display_(Seq[Any](/*17.40*/title)),format.raw/*17.45*/("""</a>
          </div>
        </div>
      </div>

      <div class="container">
        """),_display_(Seq[Any](/*23.10*/content)),format.raw/*23.17*/("""
      </div>
    </div>

  </body>

</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Aug 29 18:29:29 GMT+04:00 2013
                    SOURCE: E:/workspace/play_ws/jobs/app/views/main.scala.html
                    HASH: 107509cb201971de7e4b204f1ceedccfc3f81953
                    MATRIX: 509->1|616->31|785->165|799->171|860->210|964->279|978->285|1034->319|1284->533|1311->538|1443->634|1472->641
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|38->17|38->17|44->23|44->23
                    -- GENERATED --
                */
            