
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
object pickList extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,List[models.Preparation],java.util.Date,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(warehouse: String, list: List[models.Preparation],
  time: java.util.Date):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.24*/("""

"""),_display_(Seq[Any](/*4.2*/main("Warehouse " + warehouse + " pick list for " + time)/*4.59*/ {_display_(Seq[Any](format.raw/*4.61*/("""

  <table>
    <tr>
      <th>Order #</th>
      <th>Product EAN</th>
      <th>Product description</th>
      <th>Quantity</th>
      <th>Location</th>
    </tr>
  """),_display_(Seq[Any](/*14.4*/for((preparation, index) <- list.zipWithIndex) yield /*14.50*/ {_display_(Seq[Any](format.raw/*14.52*/("""
    <tr"""),_display_(Seq[Any](/*15.9*/(if (index % 2 == 0) " class='odd'"))),format.raw/*15.45*/(""">
      <td>"""),_display_(Seq[Any](/*16.12*/preparation/*16.23*/.orderNumber)),format.raw/*16.35*/("""</td>
      <td>"""),_display_(Seq[Any](/*17.12*/preparation/*17.23*/.product.ean)),format.raw/*17.35*/("""</td>
      <td>"""),_display_(Seq[Any](/*18.12*/preparation/*18.23*/.product.description)),format.raw/*18.43*/("""</td>
      <td>"""),_display_(Seq[Any](/*19.12*/preparation/*19.23*/.quantity)),format.raw/*19.32*/("""</td>
      <td>"""),_display_(Seq[Any](/*20.12*/preparation/*20.23*/.location)),format.raw/*20.32*/("""</td>
    </tr> """)))})),format.raw/*21.12*/("""
  </table>
""")))})))}
    }
    
    def render(warehouse:String,list:List[models.Preparation],time:java.util.Date): play.api.templates.Html = apply(warehouse,list,time)
    
    def f:((String,List[models.Preparation],java.util.Date) => play.api.templates.Html) = (warehouse,list,time) => apply(warehouse,list,time)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Aug 29 18:10:25 GMT+04:00 2013
                    SOURCE: E:/workspace/play_ws/jobs/app/views/pickList.scala.html
                    HASH: 07313d778f4869bcb89f68185b665fa0c2a7ac09
                    MATRIX: 548->1|701->77|740->82|805->139|844->141|1056->318|1118->364|1158->366|1203->376|1261->412|1311->426|1331->437|1365->449|1419->467|1439->478|1473->490|1527->508|1547->519|1589->539|1643->557|1663->568|1694->577|1748->595|1768->606|1799->615|1849->633
                    LINES: 19->1|23->2|25->4|25->4|25->4|35->14|35->14|35->14|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|41->20|41->20|41->20|42->21
                    -- GENERATED --
                */
            