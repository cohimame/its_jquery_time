import akka.actor.{Actor, Props}
import models.Warehouse
import play.api.libs.concurrent.Akka
import play.api.GlobalSettings
import play.api.templates.Html
import play.api.libs.concurrent.Execution.Implicits.defaultContext

object Global extends GlobalSettings {

  override def onStart(application: play.api.Application) {

    play.api.Logger.info("Scheduling job...")
    import scala.concurrent.duration._
    import play.api.Play.current

    for (warehouse <- Warehouse.find()) {
      val actor = Akka.system.actorOf(
        Props(new PickListActor(warehouse))
      )

      Akka.system.scheduler.schedule(
        0.seconds, 25.seconds, actor, "send"
      )
    }
  }

}


import java.util.Date
import models.PickList

class PickListActor(warehouse: String) extends Actor {

  def receive = {

    case "send" => 
      val pickList = PickList.find(warehouse)
      val html = views.html.pickList(warehouse, pickList, new Date )
      send(html)
    
    case _ => play.api.Logger.warn("unsupported message type")

  }

  def send(html: Html) {
    play.api.Logger.info("PickListActor.send for " + warehouse)
    // ...

  }
}
