package controllers

import play.api._
import play.api.mvc._
import models.PickList
import templates.Html
import java.util.Date
import scala.concurrent.{ExecutionContext, future}

object PickLists extends Controller {

  def preview(warehouse: String) = Action {
    val pickList = PickList.find(warehouse)
    val timestamp = new java.util.Date
    Ok(views.html.pickList(warehouse, pickList, timestamp))
  }

  def sendAsync(warehouse: String) = Action {
    import ExecutionContext.Implicits.global
    future {
      val pickList = PickList.find(warehouse)
      send(views.html.pickList(warehouse, pickList, new Date))
    }
    Redirect(routes.PickLists.index())
  }

  def index = Action {
    Ok(views.html.index())
  }

  private def send(html: Html) {
    Logger.info(html.body)
  }

}