
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Pick lists")/*1.20*/ {_display_(Seq[Any](format.raw/*1.22*/("""

  <form method="post" action=""""),_display_(Seq[Any](/*3.32*/routes/*3.38*/.PickLists.sendAsync("W123"))),format.raw/*3.66*/("""">
    <p>
      <button type="submit" class="btn btn-large btn-success">
        Generate &amp; Send Pick List
      </button>
    </p>
  </form>

  <form method="get" action=""""),_display_(Seq[Any](/*11.31*/routes/*11.37*/.PickLists.preview(""))),format.raw/*11.59*/("""">
    <p>
      <input type="hidden" name="warehouse" value="W123">
      <button type="submit" class="btn btn-large">Preview</button>
    </p>
  </form>
""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Aug 29 18:29:29 GMT+04:00 2013
                    SOURCE: E:/workspace/play_ws/jobs/app/views/index.scala.html
                    HASH: 265f7cd9c95db264b1b0f08c355c8188d077eed2
                    MATRIX: 578->1|604->19|643->21|713->56|727->62|776->90|998->276|1013->282|1057->304
                    LINES: 22->1|22->1|22->1|24->3|24->3|24->3|32->11|32->11|32->11
                    -- GENERATED --
                */
            